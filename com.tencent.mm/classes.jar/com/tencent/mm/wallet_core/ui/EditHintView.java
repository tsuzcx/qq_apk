package com.tencent.mm.wallet_core.ui;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.text.Editable;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.text.TextUtils.TruncateAt;
import android.text.method.KeyListener;
import android.text.method.PasswordTransformationMethod;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.e;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.h;
import com.tencent.mm.plugin.wxpay.a.k;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.ui.widget.a.c;
import com.tencent.mm.wallet_core.a.a;
import com.tencent.mm.wallet_core.b;
import com.tenpay.android.wechat.TenpaySecureEditText;

@Deprecated
public class EditHintView
  extends RelativeLayout
  implements View.OnFocusChangeListener
{
  private int background = -1;
  private View.OnFocusChangeListener fuf;
  private TextView fug;
  private ImageView fui;
  private String fuj = "";
  private String fuk = "";
  private int ful = -1;
  private int fum = -1;
  public boolean fun = true;
  private boolean fup = false;
  private int fuq = 1;
  private int fur = -1;
  private View.OnClickListener fut = new EditHintView.8(this);
  private int gravity = 19;
  private boolean gun = true;
  private int imeOptions;
  private int inputType = 1;
  private int mode = 0;
  public boolean vcS = true;
  private EditHintView.b wBL;
  private TextView wBM;
  TenpaySecureEditText wBN;
  private int wBO = -1;
  private int wBP = 1;
  private int wBQ = -1;
  private boolean wBR = true;
  private String wBS = null;
  private DatePickerDialog wBT = null;
  private int wBU = 0;
  private int wBV = 0;
  private c wBW = null;
  private EditHintView.a wBX;
  
  public EditHintView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public EditHintView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet);
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, a.k.EditHintView, paramInt, 0);
    paramInt = paramAttributeSet.getResourceId(a.k.EditHintView_hint, 0);
    if (paramInt != 0) {
      this.fuj = paramContext.getString(paramInt);
    }
    paramInt = paramAttributeSet.getResourceId(a.k.EditHintView_tipmsg, 0);
    if (paramInt != 0) {
      this.fuk = paramContext.getString(paramInt);
    }
    this.inputType = paramAttributeSet.getInteger(a.k.EditHintView_android_inputType, 1);
    this.fun = paramAttributeSet.getBoolean(a.k.EditHintView_editable, true);
    this.gravity = paramAttributeSet.getInt(a.k.EditHintView_android_gravity, 19);
    this.gun = paramAttributeSet.getBoolean(a.k.EditHintView_android_clickable, true);
    this.fur = paramAttributeSet.getInteger(a.k.EditHintView_maxLength, -1);
    this.ful = paramAttributeSet.getInteger(a.k.EditHintView_editType, 0);
    this.imeOptions = paramAttributeSet.getInteger(a.k.EditHintView_android_imeOptions, 5);
    this.wBQ = paramAttributeSet.getColor(a.k.EditHintView_hintTextColor, a.c.black);
    this.background = paramAttributeSet.getResourceId(a.k.EditHintView_android_background, -1);
    this.fum = paramAttributeSet.getResourceId(a.k.EditHintView_hintTextBg, a.e.edittext_bg_selector);
    this.fuq = paramAttributeSet.getInteger(a.k.EditHintView_minLength, 1);
    this.vcS = paramAttributeSet.getBoolean(a.k.EditHintView_android_singleLine, true);
    paramAttributeSet.recycle();
    paramContext = com.tencent.mm.ui.y.gt(paramContext).inflate(a.g.edit_hint_view, this, true);
    this.wBN = ((TenpaySecureEditText)paramContext.findViewById(a.f.hint_et));
    this.fug = ((TextView)paramContext.findViewById(a.f.tip_tv));
    this.wBM = ((TextView)paramContext.findViewById(a.f.pre_filled_tv));
    this.fui = ((ImageView)paramContext.findViewById(a.f.info_iv));
    this.wBN.setImeOptions(this.imeOptions);
    switch (this.ful)
    {
    case 11: 
    default: 
      this.inputType = 1;
    case 0: 
      cNc();
      this.wBN.setSingleLine(this.vcS);
      if (!this.vcS) {
        this.wBN.setMaxLines(1073741823);
      }
      this.fui.setOnClickListener(this.fut);
      this.wBN.addTextChangedListener(new EditHintView.1(this));
      this.wBN.setOnFocusChangeListener(this);
      if (!bk.bl(this.fuj)) {
        this.wBN.setHint(this.fuj);
      }
      if (!bk.bl(this.fuk)) {
        this.fug.setText(this.fuk);
      }
      this.wBN.setGravity(this.gravity);
      if (this.inputType == 2)
      {
        this.wBN.setKeyListener(new EditHintView.2(this));
        label663:
        if (this.fur != -1) {
          this.wBN.setFilters(new InputFilter[] { new InputFilter.LengthFilter(this.fur) });
        }
        super.setEnabled(true);
        super.setClickable(true);
        if (!this.gun)
        {
          this.wBN.setEnabled(false);
          this.wBN.setTextColor(getResources().getColor(this.wBQ));
          this.wBN.setFocusable(false);
          this.wBN.setClickable(false);
          this.wBN.setBackgroundResource(a.e.transparent_background);
          setBackgroundResource(a.e.list_item_normal);
        }
        if (this.fun) {
          break label1326;
        }
        this.fup = true;
        this.wBN.setEnabled(false);
        this.wBN.setTextColor(getResources().getColor(a.c.link_color_pressed));
        this.wBN.setFocusable(false);
        this.wBN.setClickable(false);
        this.wBN.setBackgroundResource(a.e.transparent_background);
        setBackgroundResource(a.e.comm_list_item_selector);
      }
      break;
    }
    for (;;)
    {
      if (this.background > 0) {
        setBackgroundResource(this.background);
      }
      if ((this.fug != null) && (this.wBO != -1))
      {
        paramContext = this.fug.getLayoutParams();
        paramContext.width = this.wBO;
        this.fug.setLayoutParams(paramContext);
      }
      if (q.Gw()) {
        this.wBN.setSecureEncrypt(new a(getEncryptType()));
      }
      return;
      this.fur = 25;
      this.wBN.setIsBankcardFormat(true);
      this.inputType = 2;
      break;
      this.fur = 6;
      this.fug.setVisibility(8);
      this.wBN.setIsPasswordFormat(true);
      this.wBN.setImeOptions(6);
      this.inputType = 128;
      break;
      this.fur = 3;
      this.fug.setVisibility(8);
      this.wBN.setIsCvvPaymentFormat(true);
      this.wBN.setImeOptions(6);
      this.inputType = 128;
      break;
      this.fur = 4;
      this.fug.setVisibility(8);
      this.wBN.setIsCvv4PaymentFormat(true);
      this.wBN.setImeOptions(6);
      this.inputType = 128;
      break;
      this.fur = 30;
      this.inputType = 3;
      break;
      this.fur = 18;
      this.inputType = 4;
      break;
      this.fur = 4;
      this.inputType = 2;
      break;
      this.fun = false;
      this.wBN.setIsValidThru(true);
      setOnClickListener(new EditHintView.7(this));
      break;
      this.fur = 6;
      this.fug.setVisibility(8);
      this.inputType = 2;
      break;
      this.inputType = 32;
      break;
      if ((this.fun) || (!this.gun)) {
        break;
      }
      break;
      this.fur = 12;
      this.wBN.setIsMoneyAmountFormat(true);
      break;
      this.wBN.setIsSecurityAnswerFormat(true);
      break;
      if (this.inputType == 4)
      {
        this.wBN.setKeyListener(new EditHintView.3(this));
        break label663;
      }
      if (this.inputType == 128)
      {
        this.wBN.setTransformationMethod(PasswordTransformationMethod.getInstance());
        this.wBN.setKeyListener(new EditHintView.4(this));
        this.wBN.setRawInputType(18);
        break label663;
      }
      if (this.inputType == 3)
      {
        this.wBN.setKeyListener(new EditHintView.5(this));
        break label663;
      }
      this.wBN.setInputType(this.inputType);
      break label663;
      label1326:
      this.fup = false;
      this.wBN.setBackgroundResource(this.fum);
      setBackgroundResource(a.e.transparent_background);
    }
  }
  
  private void cNc()
  {
    if ((this.ful == 7) || (this.ful == 14) || (this.ful == 15)) {
      return;
    }
    if ((this.fun) && (!bk.bl(getText())))
    {
      this.fui.setVisibility(0);
      this.fui.setImageResource(a.e.list_clear);
      return;
    }
    switch (this.ful)
    {
    case 2: 
    case 5: 
    case 6: 
    case 7: 
    case 8: 
    default: 
      this.fui.setVisibility(8);
      return;
    case 3: 
    case 4: 
    case 9: 
    case 10: 
      this.fui.setVisibility(0);
      this.fui.setImageResource(a.e.payinfoicon);
      return;
    }
    if (this.wBR)
    {
      this.fui.setVisibility(0);
      this.fui.setImageResource(a.h.wallet_scan_camera);
      return;
    }
    this.fui.setVisibility(8);
  }
  
  private int getEncryptType()
  {
    switch (this.ful)
    {
    case 2: 
    case 3: 
    case 5: 
    case 8: 
    case 9: 
    case 10: 
    case 11: 
    case 12: 
    default: 
      return 0;
    case 17: 
      return -10;
    case 7: 
      return 20;
    case 6: 
      return 60;
    case 13: 
      return 40;
    case 16: 
      return -20;
    case 4: 
    case 14: 
    case 15: 
      return 30;
    }
    return 50;
  }
  
  private Rect getValidRectOfInfoIv()
  {
    Rect localRect = new Rect();
    this.fui.getHitRect(localRect);
    localRect.left -= 50;
    localRect.right += 50;
    localRect.top -= 25;
    localRect.bottom += 25;
    return localRect;
  }
  
  private void setValStrForce(String paramString)
  {
    KeyListener localKeyListener = this.wBN.getKeyListener();
    this.wBN.setKeyListener(null);
    setEnabled(false);
    setClickable(false);
    setValStr(paramString);
    this.wBN.setKeyListener(localKeyListener);
  }
  
  public final boolean YL()
  {
    if ((!this.fun) && (!this.gun)) {}
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              return true;
              switch (this.ful)
              {
              }
            } while (this.wBN.getInputLength() >= this.fuq);
            return false;
            return this.wBN.isBankcardNum();
            return this.wBN.isPhoneNum();
          } while (this.wBN.getInputLength() > 0);
          return false;
          return this.wBN.isAreaIDCardNum(this.wBP);
        } while (this.wBN.getInputLength() == 6);
        return false;
      } while (this.wBN.getInputLength() == 3);
      return false;
    } while (this.wBN.getInputLength() == 4);
    return false;
    return bk.ZC(this.wBN.getText().toString());
    return this.wBN.isMoneyAmount();
  }
  
  public String get3DesEncrptData()
  {
    return this.wBN.get3DesEncrptData();
  }
  
  public String getMD5Value()
  {
    if (this.ful == 3) {}
    for (String str = bk.aM(this.wBS, "").replace("/", "");; str = this.wBN.getText().toString()) {
      return ad.bB(str);
    }
  }
  
  public String getText()
  {
    switch (this.ful)
    {
    case 11: 
    case 12: 
    default: 
      return bk.aM(this.wBN.getText().toString(), "");
    case 1: 
    case 13: 
    case 16: 
      localTenpaySecureEditText = this.wBN;
      b.cMj();
      return localTenpaySecureEditText.getEncryptDataWithHash(false, b.cMk());
    case 4: 
    case 14: 
    case 15: 
      return this.wBN.get3DesEncrptData();
    case 5: 
      return this.wBN.get3DesEncrptData();
    case 3: 
      return bk.aM(this.wBS, "").replace("/", "");
    case 2: 
    case 9: 
      return bk.aM(this.wBN.getText().toString(), "");
    case 0: 
    case 8: 
    case 10: 
      return bk.aM(this.wBN.getText().toString(), "");
    case 6: 
      return this.wBN.get3DesVerifyCode();
    }
    TenpaySecureEditText localTenpaySecureEditText = this.wBN;
    b.cMj();
    return localTenpaySecureEditText.getEncryptDataWithHash(true, b.cMk());
  }
  
  public void onFocusChange(View paramView, boolean paramBoolean)
  {
    if (this.fuf != null) {
      this.fuf.onFocusChange(this, paramBoolean);
    }
    com.tencent.mm.sdk.platformtools.y.d("MicroMsg.EditHintView", "View:" + this.fuk + ", editType:" + this.ful + " onFocusChange to " + paramBoolean);
    if (!this.fup)
    {
      this.fug.setEnabled(false);
      return;
    }
    this.fug.setEnabled(true);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = true;
    int i;
    if (!this.fun)
    {
      if (this.fui.getVisibility() != 0) {
        break label55;
      }
      i = 1;
      if (i == 0) {
        break label65;
      }
      if (!getValidRectOfInfoIv().contains((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY())) {
        break label60;
      }
      i = 1;
    }
    for (;;)
    {
      if (i != 0) {
        bool = false;
      }
      return bool;
      label55:
      i = 0;
      break;
      label60:
      i = 0;
      continue;
      label65:
      i = 0;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int j;
    int i;
    if ((this.ful != 7) && (this.ful != 17) && (this.ful != 14))
    {
      j = paramInt1;
      i = paramInt2;
      if (this.ful != 15) {}
    }
    else
    {
      setMeasuredDimension(getDefaultSize(BackwardSupportUtil.b.b(getContext(), 960.0F), paramInt1), getDefaultSize(BackwardSupportUtil.b.b(getContext(), 720.0F), paramInt2));
      paramInt2 = getMeasuredWidth();
      if ((this.ful != 7) && (this.ful != 17)) {
        break label141;
      }
      paramInt1 = paramInt2 / 6;
    }
    for (;;)
    {
      j = View.MeasureSpec.makeMeasureSpec(paramInt2, 1073741824);
      i = View.MeasureSpec.makeMeasureSpec(paramInt1, 1073741824);
      setMeasuredDimension(getDefaultSize(paramInt2, j), getDefaultSize(paramInt1, i));
      super.onMeasure(j, i);
      return;
      label141:
      if (this.ful == 14) {
        paramInt1 = paramInt2 / 3;
      } else {
        paramInt1 = paramInt2 / 4;
      }
    }
  }
  
  public void set3DesValStr(String paramString)
  {
    switch (this.ful)
    {
    default: 
      this.wBN.setText(paramString);
      this.wBN.setSelection(this.wBN.getText().length());
      return;
    }
    if ((!bk.bl(paramString)) && (paramString.length() <= 5))
    {
      this.wBN.setSelection(0);
      this.wBN.set3DesEncrptData(paramString);
      this.fur = (24 - paramString.length());
      this.wBN.setFilters(new InputFilter[] { new InputFilter.LengthFilter(this.fur) });
      return;
    }
    this.wBN.set3DesEncrptData(paramString);
    this.wBN.setSelection(this.wBN.getText().length());
  }
  
  public void setClickable(boolean paramBoolean)
  {
    super.setClickable(paramBoolean);
    this.gun = paramBoolean;
    if (!paramBoolean)
    {
      this.wBN.setEnabled(false);
      if (!this.fun) {
        this.wBN.setTextColor(getResources().getColor(a.c.lightgrey));
      }
      for (;;)
      {
        this.wBN.setFocusable(false);
        this.wBN.setClickable(false);
        return;
        this.wBN.setTextColor(getResources().getColor(this.wBQ));
      }
    }
    this.wBN.setEnabled(true);
    if (!this.fun) {
      this.wBN.setTextColor(getResources().getColor(a.c.link_color_pressed));
    }
    for (;;)
    {
      this.wBN.setFocusable(true);
      this.wBN.setClickable(true);
      return;
      this.wBN.setTextColor(getResources().getColor(this.wBQ));
    }
  }
  
  public void setEditBG(int paramInt)
  {
    if (this.wBN != null) {
      this.wBN.setBackgroundResource(paramInt);
    }
  }
  
  public void setEllipsize(TextUtils.TruncateAt paramTruncateAt)
  {
    this.wBN.setEllipsize(paramTruncateAt);
  }
  
  public void setEnabled(boolean paramBoolean)
  {
    super.setEnabled(paramBoolean);
    this.fun = paramBoolean;
    this.fui.setEnabled(true);
  }
  
  public void setEncryptType(int paramInt)
  {
    if (q.Gw()) {
      this.wBN.setSecureEncrypt(new a(paramInt));
    }
  }
  
  public void setHintStr(String paramString)
  {
    this.wBN.setHint(paramString);
  }
  
  public void setIdentifyCardType(int paramInt)
  {
    this.wBP = paramInt;
    if (paramInt == 1)
    {
      this.wBN.setKeyListener(new EditHintView.6(this));
      return;
    }
    this.wBN.setInputType(1);
  }
  
  public void setImeOptions(int paramInt)
  {
    this.wBN.setImeOptions(paramInt);
  }
  
  public void setInfoIvVisible(int paramInt)
  {
    this.fui.setVisibility(paramInt);
  }
  
  public void setMaxLen(int paramInt)
  {
    if (paramInt != -1)
    {
      this.fur = paramInt;
      this.wBN.setFilters(new InputFilter[] { new InputFilter.LengthFilter(paramInt) });
    }
  }
  
  public void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    super.setOnClickListener(paramOnClickListener);
  }
  
  public void setOnEditorActionListener(TextView.OnEditorActionListener paramOnEditorActionListener)
  {
    this.wBN.setOnEditorActionListener(paramOnEditorActionListener);
  }
  
  public void setOnFocusChangeListener(View.OnFocusChangeListener paramOnFocusChangeListener)
  {
    super.setOnFocusChangeListener(paramOnFocusChangeListener);
    this.fuf = paramOnFocusChangeListener;
  }
  
  public void setOnInfoListener(EditHintView.a parama)
  {
    this.wBX = parama;
  }
  
  public void setOnInputValidChangeListener(EditHintView.b paramb)
  {
    this.wBL = paramb;
  }
  
  public void setPreFilledStr(String paramString)
  {
    if (!bk.bl(paramString))
    {
      this.wBM.setText(paramString);
      this.wBM.setVisibility(0);
      return;
    }
    this.wBM.setText("");
    this.wBM.setVisibility(8);
  }
  
  public void setPreText(String paramString)
  {
    KeyListener localKeyListener = this.wBN.getKeyListener();
    this.wBN.setInputType(1);
    this.wBN.setKeyListener(null);
    setValStr(paramString);
    this.wBN.setKeyListener(localKeyListener);
    this.mode = 4;
  }
  
  public void setShowScanCamera(boolean paramBoolean)
  {
    this.wBR = paramBoolean;
    cNc();
  }
  
  public void setTipStr(String paramString)
  {
    this.fug.setText(paramString);
  }
  
  public void setTipTextColor(int paramInt)
  {
    if (this.fug != null) {
      this.fug.setTextColor(paramInt);
    }
  }
  
  public void setTipWidth(int paramInt)
  {
    this.wBO = BackwardSupportUtil.b.b(getContext(), paramInt * 1.0F);
    if (this.fug != null)
    {
      ViewGroup.LayoutParams localLayoutParams = this.fug.getLayoutParams();
      localLayoutParams.width = this.wBO;
      this.fug.setLayoutParams(localLayoutParams);
    }
  }
  
  public void setValStr(String paramString)
  {
    switch (this.ful)
    {
    default: 
      this.wBN.setText(paramString);
      this.wBN.setSelection(this.wBN.getText().length());
      return;
    }
    if ((!bk.bl(paramString)) && (paramString.length() <= 5))
    {
      this.wBN.setSelection(0);
      this.wBN.setBankcardTailNum(paramString);
      this.fur = (24 - paramString.length());
      this.wBN.setFilters(new InputFilter[] { new InputFilter.LengthFilter(this.fur) });
      return;
    }
    this.wBN.setText(paramString);
    this.wBN.setSelection(this.wBN.getText().length());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.wallet_core.ui.EditHintView
 * JD-Core Version:    0.7.0.1
 */