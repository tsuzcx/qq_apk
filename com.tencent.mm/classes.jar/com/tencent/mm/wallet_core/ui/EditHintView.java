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
import android.text.method.NumberKeyListener;
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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.wxpay.a.a;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.w;
import com.tencent.mm.ui.widget.b.c;
import com.tencent.mm.wallet_core.a.a;
import com.tencent.mm.wallet_core.b;
import com.tenpay.android.wechat.TenpaySecureEditText;

@Deprecated
public class EditHintView
  extends RelativeLayout
  implements View.OnFocusChangeListener
{
  private EditHintView.b AYe;
  private TextView AYf;
  TenpaySecureEditText AYg;
  private int AYh;
  private int AYi;
  private int AYj;
  private boolean AYk;
  private String AYl;
  private DatePickerDialog AYm;
  private int AYn;
  private int AYo;
  private c AYp;
  private EditHintView.a AYq;
  private int background;
  private View.OnFocusChangeListener gLH;
  private TextView gLI;
  private ImageView gLK;
  private String gLL;
  private String gLM;
  private int gLN;
  private int gLO;
  public boolean gLP;
  private boolean gLR;
  private int gLS;
  private int gLT;
  private View.OnClickListener gLV;
  private int gravity;
  private boolean hPf;
  private int imeOptions;
  private int inputType;
  private int mode;
  public boolean zrr;
  
  public EditHintView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public EditHintView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(49187);
    this.gLL = "";
    this.gLM = "";
    this.inputType = 1;
    this.hPf = true;
    this.gLT = -1;
    this.gLS = 1;
    this.gravity = 19;
    this.AYh = -1;
    this.gLN = -1;
    this.gLR = false;
    this.AYi = 1;
    this.AYj = -1;
    this.background = -1;
    this.gLO = -1;
    this.gLP = true;
    this.zrr = true;
    this.AYk = true;
    this.AYl = null;
    this.mode = 0;
    this.AYm = null;
    this.AYn = 0;
    this.AYo = 0;
    this.gLV = new EditHintView.8(this);
    this.AYp = null;
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, a.a.EditHintView, paramInt, 0);
    paramInt = paramAttributeSet.getResourceId(6, 0);
    if (paramInt != 0) {
      this.gLL = paramContext.getString(paramInt);
    }
    paramInt = paramAttributeSet.getResourceId(7, 0);
    if (paramInt != 0) {
      this.gLM = paramContext.getString(paramInt);
    }
    this.inputType = paramAttributeSet.getInteger(4, 1);
    this.gLP = paramAttributeSet.getBoolean(11, true);
    this.gravity = paramAttributeSet.getInt(0, 19);
    this.hPf = paramAttributeSet.getBoolean(2, true);
    this.gLT = paramAttributeSet.getInteger(12, -1);
    this.gLN = paramAttributeSet.getInteger(8, 0);
    this.imeOptions = paramAttributeSet.getInteger(5, 5);
    this.AYj = paramAttributeSet.getColor(9, 2131689763);
    this.background = paramAttributeSet.getResourceId(1, -1);
    this.gLO = paramAttributeSet.getResourceId(10, 2130838586);
    this.gLS = paramAttributeSet.getInteger(13, 1);
    this.zrr = paramAttributeSet.getBoolean(3, true);
    paramAttributeSet.recycle();
    paramContext = w.hM(paramContext).inflate(2130969348, this, true);
    this.AYg = ((TenpaySecureEditText)paramContext.findViewById(2131821072));
    this.gLI = ((TextView)paramContext.findViewById(2131821071));
    this.AYf = ((TextView)paramContext.findViewById(2131823494));
    this.gLK = ((ImageView)paramContext.findViewById(2131821073));
    this.AYg.setImeOptions(this.imeOptions);
    switch (this.gLN)
    {
    case 11: 
    default: 
      this.inputType = 1;
    case 0: 
      dSN();
      this.AYg.setSingleLine(this.zrr);
      if (!this.zrr) {
        this.AYg.setMaxLines(1073741823);
      }
      this.gLK.setOnClickListener(this.gLV);
      this.AYg.addTextChangedListener(new EditHintView.1(this));
      this.AYg.setOnFocusChangeListener(this);
      if (!bo.isNullOrNil(this.gLL)) {
        this.AYg.setHint(this.gLL);
      }
      if (!bo.isNullOrNil(this.gLM)) {
        this.gLI.setText(this.gLM);
      }
      this.AYg.setGravity(this.gravity);
      if (this.inputType == 2)
      {
        this.AYg.setKeyListener(new NumberKeyListener()
        {
          protected final char[] getAcceptedChars()
          {
            return new char[] { 49, 50, 51, 52, 53, 54, 55, 56, 57, 48 };
          }
          
          public final int getInputType()
          {
            return 3;
          }
        });
        label638:
        if (this.gLT != -1) {
          this.AYg.setFilters(new InputFilter[] { new InputFilter.LengthFilter(this.gLT) });
        }
        super.setEnabled(true);
        super.setClickable(true);
        if (!this.hPf)
        {
          this.AYg.setEnabled(false);
          this.AYg.setTextColor(getResources().getColor(this.AYj));
          this.AYg.setFocusable(false);
          this.AYg.setClickable(false);
          this.AYg.setBackgroundResource(2130840999);
          setBackgroundResource(2130839276);
        }
        if (this.gLP) {
          break label1306;
        }
        this.gLR = true;
        this.AYg.setEnabled(false);
        this.AYg.setTextColor(getResources().getColor(2131690215));
        this.AYg.setFocusable(false);
        this.AYg.setClickable(false);
        this.AYg.setBackgroundResource(2130840999);
        setBackgroundResource(2130838445);
      }
      break;
    }
    for (;;)
    {
      if (this.background > 0) {
        setBackgroundResource(this.background);
      }
      if ((this.gLI != null) && (this.AYh != -1))
      {
        paramContext = this.gLI.getLayoutParams();
        paramContext.width = this.AYh;
        this.gLI.setLayoutParams(paramContext);
      }
      if (r.ZB()) {
        this.AYg.setSecureEncrypt(new a(getEncryptType()));
      }
      AppMethodBeat.o(49187);
      return;
      this.gLT = 25;
      this.AYg.setIsBankcardFormat(true);
      this.inputType = 2;
      break;
      this.gLT = 6;
      this.gLI.setVisibility(8);
      this.AYg.setIsPasswordFormat(true);
      this.AYg.setImeOptions(6);
      this.inputType = 128;
      break;
      this.gLT = 3;
      this.gLI.setVisibility(8);
      this.AYg.setIsCvvPaymentFormat(true);
      this.AYg.setImeOptions(6);
      this.inputType = 128;
      break;
      this.gLT = 4;
      this.gLI.setVisibility(8);
      this.AYg.setIsCvv4PaymentFormat(true);
      this.AYg.setImeOptions(6);
      this.inputType = 128;
      break;
      this.gLT = 30;
      this.inputType = 3;
      break;
      this.gLT = 18;
      this.inputType = 4;
      break;
      this.gLT = 4;
      this.inputType = 2;
      break;
      this.gLP = false;
      this.AYg.setIsValidThru(true);
      setOnClickListener(new EditHintView.7(this));
      break;
      this.gLT = 6;
      this.gLI.setVisibility(8);
      this.inputType = 2;
      break;
      this.inputType = 32;
      break;
      if ((this.gLP) || (!this.hPf)) {
        break;
      }
      break;
      this.gLT = 12;
      this.AYg.setIsMoneyAmountFormat(true);
      break;
      this.AYg.setIsSecurityAnswerFormat(true);
      break;
      if (this.inputType == 4)
      {
        this.AYg.setKeyListener(new EditHintView.3(this));
        break label638;
      }
      if (this.inputType == 128)
      {
        this.AYg.setTransformationMethod(PasswordTransformationMethod.getInstance());
        this.AYg.setKeyListener(new EditHintView.4(this));
        this.AYg.setRawInputType(18);
        break label638;
      }
      if (this.inputType == 3)
      {
        this.AYg.setKeyListener(new EditHintView.5(this));
        break label638;
      }
      this.AYg.setInputType(this.inputType);
      break label638;
      label1306:
      this.gLR = false;
      this.AYg.setBackgroundResource(this.gLO);
      setBackgroundResource(2130840999);
    }
  }
  
  private void dSN()
  {
    AppMethodBeat.i(49212);
    if ((this.gLN == 7) || (this.gLN == 14) || (this.gLN == 15))
    {
      AppMethodBeat.o(49212);
      return;
    }
    if ((this.gLP) && (!bo.isNullOrNil(getText())))
    {
      this.gLK.setVisibility(0);
      this.gLK.setImageResource(2130839272);
      AppMethodBeat.o(49212);
      return;
    }
    switch (this.gLN)
    {
    case 2: 
    case 5: 
    case 6: 
    case 7: 
    case 8: 
    default: 
      this.gLK.setVisibility(8);
      AppMethodBeat.o(49212);
      return;
    case 3: 
    case 4: 
    case 9: 
    case 10: 
      this.gLK.setVisibility(0);
      this.gLK.setImageResource(2130839903);
      AppMethodBeat.o(49212);
      return;
    }
    if (this.AYk)
    {
      this.gLK.setVisibility(0);
      this.gLK.setImageResource(2131232197);
      AppMethodBeat.o(49212);
      return;
    }
    this.gLK.setVisibility(8);
    AppMethodBeat.o(49212);
  }
  
  private int getEncryptType()
  {
    switch (this.gLN)
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
    AppMethodBeat.i(49217);
    Rect localRect = new Rect();
    this.gLK.getHitRect(localRect);
    localRect.left -= 50;
    localRect.right += 50;
    localRect.top -= 25;
    localRect.bottom += 25;
    AppMethodBeat.o(49217);
    return localRect;
  }
  
  private void setValStrForce(String paramString)
  {
    AppMethodBeat.i(49195);
    KeyListener localKeyListener = this.AYg.getKeyListener();
    this.AYg.setKeyListener(null);
    setEnabled(false);
    setClickable(false);
    setValStr(paramString);
    this.AYg.setKeyListener(localKeyListener);
    AppMethodBeat.o(49195);
  }
  
  public final boolean asv()
  {
    AppMethodBeat.i(49204);
    if ((!this.gLP) && (!this.hPf))
    {
      AppMethodBeat.o(49204);
      return true;
    }
    boolean bool;
    switch (this.gLN)
    {
    case 0: 
    case 2: 
    case 3: 
    case 6: 
    case 10: 
    case 11: 
    case 13: 
    case 16: 
    default: 
      if (this.AYg.getInputLength() >= this.gLS)
      {
        AppMethodBeat.o(49204);
        return true;
      }
      break;
    case 1: 
      bool = this.AYg.isBankcardNum();
      AppMethodBeat.o(49204);
      return bool;
    case 9: 
      bool = this.AYg.isPhoneNum();
      AppMethodBeat.o(49204);
      return bool;
    case 4: 
      if (this.AYg.getInputLength() > 0)
      {
        AppMethodBeat.o(49204);
        return true;
      }
      AppMethodBeat.o(49204);
      return false;
    case 5: 
      bool = this.AYg.isAreaIDCardNum(this.AYi);
      AppMethodBeat.o(49204);
      return bool;
    case 7: 
    case 17: 
      if (this.AYg.getInputLength() == 6)
      {
        AppMethodBeat.o(49204);
        return true;
      }
      AppMethodBeat.o(49204);
      return false;
    case 14: 
      if (this.AYg.getInputLength() == 3)
      {
        AppMethodBeat.o(49204);
        return true;
      }
      AppMethodBeat.o(49204);
      return false;
    case 15: 
      if (this.AYg.getInputLength() == 4)
      {
        AppMethodBeat.o(49204);
        return true;
      }
      AppMethodBeat.o(49204);
      return false;
    case 8: 
      bool = bo.apH(this.AYg.getText().toString());
      AppMethodBeat.o(49204);
      return bool;
    case 12: 
      bool = this.AYg.isMoneyAmount();
      AppMethodBeat.o(49204);
      return bool;
    }
    AppMethodBeat.o(49204);
    return false;
  }
  
  public String get3DesEncrptData()
  {
    AppMethodBeat.i(49205);
    String str = this.AYg.get3DesEncrptData();
    AppMethodBeat.o(49205);
    return str;
  }
  
  public String getMD5Value()
  {
    AppMethodBeat.i(49203);
    if (this.gLN == 3) {}
    for (String str = bo.bf(this.AYl, "").replace("/", "");; str = this.AYg.getText().toString())
    {
      str = ag.cE(str);
      AppMethodBeat.o(49203);
      return str;
    }
  }
  
  public String getText()
  {
    AppMethodBeat.i(49202);
    switch (this.gLN)
    {
    case 11: 
    case 12: 
    default: 
      localObject = bo.bf(this.AYg.getText().toString(), "");
      AppMethodBeat.o(49202);
      return localObject;
    case 1: 
    case 13: 
    case 16: 
      localObject = this.AYg;
      b.dRI();
      localObject = ((TenpaySecureEditText)localObject).getEncryptDataWithHash(false, b.dRJ());
      AppMethodBeat.o(49202);
      return localObject;
    case 4: 
    case 14: 
    case 15: 
      localObject = this.AYg.get3DesEncrptData();
      AppMethodBeat.o(49202);
      return localObject;
    case 5: 
      localObject = this.AYg.get3DesEncrptData();
      AppMethodBeat.o(49202);
      return localObject;
    case 3: 
      localObject = bo.bf(this.AYl, "").replace("/", "");
      AppMethodBeat.o(49202);
      return localObject;
    case 2: 
    case 9: 
      localObject = bo.bf(this.AYg.getText().toString(), "");
      AppMethodBeat.o(49202);
      return localObject;
    case 0: 
    case 8: 
    case 10: 
      localObject = bo.bf(this.AYg.getText().toString(), "");
      AppMethodBeat.o(49202);
      return localObject;
    case 6: 
      localObject = this.AYg.get3DesVerifyCode();
      AppMethodBeat.o(49202);
      return localObject;
    }
    Object localObject = this.AYg;
    b.dRI();
    localObject = ((TenpaySecureEditText)localObject).getEncryptDataWithHash(true, b.dRJ());
    AppMethodBeat.o(49202);
    return localObject;
  }
  
  public void onFocusChange(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(49213);
    if (this.gLH != null) {
      this.gLH.onFocusChange(this, paramBoolean);
    }
    ab.d("MicroMsg.EditHintView", "View:" + this.gLM + ", editType:" + this.gLN + " onFocusChange to " + paramBoolean);
    if (!this.gLR)
    {
      this.gLI.setEnabled(false);
      AppMethodBeat.o(49213);
      return;
    }
    this.gLI.setEnabled(true);
    AppMethodBeat.o(49213);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(49209);
    int i;
    if (!this.gLP)
    {
      if (this.gLK.getVisibility() != 0) {
        break label63;
      }
      i = 1;
      if (i == 0) {
        break label73;
      }
      if (!getValidRectOfInfoIv().contains((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY())) {
        break label68;
      }
      i = 1;
    }
    for (;;)
    {
      if (i == 0) {
        break label78;
      }
      AppMethodBeat.o(49209);
      return false;
      label63:
      i = 0;
      break;
      label68:
      i = 0;
      continue;
      label73:
      i = 0;
    }
    label78:
    AppMethodBeat.o(49209);
    return true;
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(49189);
    int j;
    int i;
    if ((this.gLN != 7) && (this.gLN != 17) && (this.gLN != 14))
    {
      j = paramInt1;
      i = paramInt2;
      if (this.gLN != 15) {}
    }
    else
    {
      setMeasuredDimension(getDefaultSize(BackwardSupportUtil.b.b(getContext(), 960.0F), paramInt1), getDefaultSize(BackwardSupportUtil.b.b(getContext(), 720.0F), paramInt2));
      paramInt2 = getMeasuredWidth();
      if ((this.gLN != 7) && (this.gLN != 17)) {
        break label153;
      }
      paramInt1 = paramInt2 / 6;
    }
    for (;;)
    {
      j = View.MeasureSpec.makeMeasureSpec(paramInt2, 1073741824);
      i = View.MeasureSpec.makeMeasureSpec(paramInt1, 1073741824);
      setMeasuredDimension(getDefaultSize(paramInt2, j), getDefaultSize(paramInt1, i));
      super.onMeasure(j, i);
      AppMethodBeat.o(49189);
      return;
      label153:
      if (this.gLN == 14) {
        paramInt1 = paramInt2 / 3;
      } else {
        paramInt1 = paramInt2 / 4;
      }
    }
  }
  
  public void set3DesValStr(String paramString)
  {
    AppMethodBeat.i(49194);
    switch (this.gLN)
    {
    default: 
      this.AYg.setText(paramString);
      this.AYg.setSelection(this.AYg.getText().length());
      AppMethodBeat.o(49194);
      return;
    }
    if ((!bo.isNullOrNil(paramString)) && (paramString.length() <= 5))
    {
      this.AYg.setSelection(0);
      this.AYg.set3DesEncrptData(paramString);
      this.gLT = (24 - paramString.length());
      this.AYg.setFilters(new InputFilter[] { new InputFilter.LengthFilter(this.gLT) });
      AppMethodBeat.o(49194);
      return;
    }
    this.AYg.set3DesEncrptData(paramString);
    this.AYg.setSelection(this.AYg.getText().length());
    AppMethodBeat.o(49194);
  }
  
  public void setClickable(boolean paramBoolean)
  {
    AppMethodBeat.i(49208);
    super.setClickable(paramBoolean);
    this.hPf = paramBoolean;
    if (!paramBoolean)
    {
      this.AYg.setEnabled(false);
      if (!this.gLP) {
        this.AYg.setTextColor(getResources().getColor(2131690211));
      }
      for (;;)
      {
        this.AYg.setFocusable(false);
        this.AYg.setClickable(false);
        AppMethodBeat.o(49208);
        return;
        this.AYg.setTextColor(getResources().getColor(this.AYj));
      }
    }
    this.AYg.setEnabled(true);
    if (!this.gLP) {
      this.AYg.setTextColor(getResources().getColor(2131690215));
    }
    for (;;)
    {
      this.AYg.setFocusable(true);
      this.AYg.setClickable(true);
      AppMethodBeat.o(49208);
      return;
      this.AYg.setTextColor(getResources().getColor(this.AYj));
    }
  }
  
  public void setEditBG(int paramInt)
  {
    AppMethodBeat.i(49197);
    if (this.AYg != null) {
      this.AYg.setBackgroundResource(paramInt);
    }
    AppMethodBeat.o(49197);
  }
  
  public void setEllipsize(TextUtils.TruncateAt paramTruncateAt)
  {
    AppMethodBeat.i(49206);
    this.AYg.setEllipsize(paramTruncateAt);
    AppMethodBeat.o(49206);
  }
  
  public void setEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(49207);
    super.setEnabled(paramBoolean);
    this.gLP = paramBoolean;
    this.gLK.setEnabled(true);
    AppMethodBeat.o(49207);
  }
  
  public void setEncryptType(int paramInt)
  {
    AppMethodBeat.i(49198);
    if (r.ZB()) {
      this.AYg.setSecureEncrypt(new a(paramInt));
    }
    AppMethodBeat.o(49198);
  }
  
  public void setHintStr(String paramString)
  {
    AppMethodBeat.i(49190);
    this.AYg.setHint(paramString);
    AppMethodBeat.o(49190);
  }
  
  public void setIdentifyCardType(int paramInt)
  {
    AppMethodBeat.i(49201);
    this.AYi = paramInt;
    if (paramInt == 1)
    {
      this.AYg.setKeyListener(new EditHintView.6(this));
      AppMethodBeat.o(49201);
      return;
    }
    this.AYg.setInputType(1);
    AppMethodBeat.o(49201);
  }
  
  public void setImeOptions(int paramInt)
  {
    AppMethodBeat.i(49214);
    this.AYg.setImeOptions(paramInt);
    AppMethodBeat.o(49214);
  }
  
  public void setInfoIvVisible(int paramInt)
  {
    AppMethodBeat.i(49216);
    this.gLK.setVisibility(paramInt);
    AppMethodBeat.o(49216);
  }
  
  public void setMaxLen(int paramInt)
  {
    AppMethodBeat.i(49200);
    if (paramInt != -1)
    {
      this.gLT = paramInt;
      this.AYg.setFilters(new InputFilter[] { new InputFilter.LengthFilter(paramInt) });
    }
    AppMethodBeat.o(49200);
  }
  
  public void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(49210);
    super.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(49210);
  }
  
  public void setOnEditorActionListener(TextView.OnEditorActionListener paramOnEditorActionListener)
  {
    AppMethodBeat.i(49215);
    this.AYg.setOnEditorActionListener(paramOnEditorActionListener);
    AppMethodBeat.o(49215);
  }
  
  public void setOnFocusChangeListener(View.OnFocusChangeListener paramOnFocusChangeListener)
  {
    AppMethodBeat.i(49211);
    super.setOnFocusChangeListener(paramOnFocusChangeListener);
    this.gLH = paramOnFocusChangeListener;
    AppMethodBeat.o(49211);
  }
  
  public void setOnInfoListener(EditHintView.a parama)
  {
    this.AYq = parama;
  }
  
  public void setOnInputValidChangeListener(EditHintView.b paramb)
  {
    this.AYe = paramb;
  }
  
  public void setPreFilledStr(String paramString)
  {
    AppMethodBeat.i(49192);
    if (!bo.isNullOrNil(paramString))
    {
      this.AYf.setText(paramString);
      this.AYf.setVisibility(0);
      AppMethodBeat.o(49192);
      return;
    }
    this.AYf.setText("");
    this.AYf.setVisibility(8);
    AppMethodBeat.o(49192);
  }
  
  public void setPreText(String paramString)
  {
    AppMethodBeat.i(49196);
    KeyListener localKeyListener = this.AYg.getKeyListener();
    this.AYg.setInputType(1);
    this.AYg.setKeyListener(null);
    setValStr(paramString);
    this.AYg.setKeyListener(localKeyListener);
    this.mode = 4;
    AppMethodBeat.o(49196);
  }
  
  public void setShowScanCamera(boolean paramBoolean)
  {
    AppMethodBeat.i(49218);
    this.AYk = paramBoolean;
    dSN();
    AppMethodBeat.o(49218);
  }
  
  public void setTipStr(String paramString)
  {
    AppMethodBeat.i(49191);
    this.gLI.setText(paramString);
    AppMethodBeat.o(49191);
  }
  
  public void setTipTextColor(int paramInt)
  {
    AppMethodBeat.i(49199);
    if (this.gLI != null) {
      this.gLI.setTextColor(paramInt);
    }
    AppMethodBeat.o(49199);
  }
  
  public void setTipWidth(int paramInt)
  {
    AppMethodBeat.i(49188);
    this.AYh = BackwardSupportUtil.b.b(getContext(), paramInt * 1.0F);
    if (this.gLI != null)
    {
      ViewGroup.LayoutParams localLayoutParams = this.gLI.getLayoutParams();
      localLayoutParams.width = this.AYh;
      this.gLI.setLayoutParams(localLayoutParams);
    }
    AppMethodBeat.o(49188);
  }
  
  public void setValStr(String paramString)
  {
    AppMethodBeat.i(49193);
    switch (this.gLN)
    {
    default: 
      this.AYg.setText(paramString);
      this.AYg.setSelection(this.AYg.getText().length());
      AppMethodBeat.o(49193);
      return;
    }
    if ((!bo.isNullOrNil(paramString)) && (paramString.length() <= 5))
    {
      this.AYg.setSelection(0);
      this.AYg.setBankcardTailNum(paramString);
      this.gLT = (24 - paramString.length());
      this.AYg.setFilters(new InputFilter[] { new InputFilter.LengthFilter(this.gLT) });
      AppMethodBeat.o(49193);
      return;
    }
    this.AYg.setText(paramString);
    this.AYg.setSelection(this.AYg.getText().length());
    AppMethodBeat.o(49193);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.wallet_core.ui.EditHintView
 * JD-Core Version:    0.7.0.1
 */