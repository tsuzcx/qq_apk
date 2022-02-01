package com.tencent.mm.wallet_core.ui;

import android.app.DatePickerDialog;
import android.app.DatePickerDialog.OnDateSetListener;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.text.Editable;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.text.TextUtils.TruncateAt;
import android.text.TextWatcher;
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
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.wxpay.a.a;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.a.d;
import com.tencent.mm.ui.widget.e;
import com.tencent.mm.ui.z;
import com.tencent.mm.wallet_core.a.a;
import com.tencent.mm.wallet_core.b;
import com.tenpay.android.wechat.TenpaySecureEditText;
import java.text.DecimalFormat;
import java.util.Calendar;

@Deprecated
public class EditHintView
  extends RelativeLayout
  implements View.OnFocusChangeListener
{
  public boolean HET;
  private String JGA;
  private DatePickerDialog JGB;
  private int JGC;
  private int JGD;
  private d JGE;
  private a JGF;
  private b JGt;
  private TextView JGu;
  TenpaySecureEditText JGv;
  private int JGw;
  private int JGx;
  private int JGy;
  private boolean JGz;
  private int background;
  private int gravity;
  private int iZA;
  public boolean iZB;
  private boolean iZD;
  private int iZE;
  private int iZF;
  private View.OnClickListener iZG;
  private View.OnFocusChangeListener iZu;
  private ImageView iZw;
  private String iZx;
  private String iZy;
  private int iZz;
  private TextView ijF;
  private int imeOptions;
  private int inputType;
  private boolean kvD;
  private int mode;
  
  public EditHintView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public EditHintView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(72906);
    this.iZx = "";
    this.iZy = "";
    this.inputType = 1;
    this.kvD = true;
    this.iZF = -1;
    this.iZE = 1;
    this.gravity = 19;
    this.JGw = -1;
    this.iZz = -1;
    this.iZD = false;
    this.JGx = 1;
    this.JGy = -1;
    this.background = -1;
    this.iZA = -1;
    this.iZB = true;
    this.HET = true;
    this.JGz = true;
    this.JGA = null;
    this.mode = 0;
    this.JGB = null;
    this.JGC = 0;
    this.JGD = 0;
    this.iZG = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(72904);
        if (EditHintView.l(EditHintView.this).getVisibility() == 0)
        {
          if ((EditHintView.this.iZB) && (!bs.isNullOrNil(EditHintView.this.getText())))
          {
            EditHintView.this.JGv.ClearInput();
            AppMethodBeat.o(72904);
            return;
          }
          if (EditHintView.f(EditHintView.this) == 1)
          {
            if ((EditHintView.m(EditHintView.this) != null) && (EditHintView.n(EditHintView.this)))
            {
              EditHintView.m(EditHintView.this);
              AppMethodBeat.o(72904);
            }
          }
          else {
            EditHintView.o(EditHintView.this);
          }
        }
        AppMethodBeat.o(72904);
      }
    };
    this.JGE = null;
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, a.a.EditHintView, paramInt, 0);
    paramInt = paramAttributeSet.getResourceId(8, 0);
    if (paramInt != 0) {
      this.iZx = paramContext.getString(paramInt);
    }
    paramInt = paramAttributeSet.getResourceId(13, 0);
    if (paramInt != 0) {
      this.iZy = paramContext.getString(paramInt);
    }
    this.inputType = paramAttributeSet.getInteger(4, 1);
    this.iZB = paramAttributeSet.getBoolean(7, true);
    this.gravity = paramAttributeSet.getInt(0, 19);
    this.kvD = paramAttributeSet.getBoolean(2, true);
    this.iZF = paramAttributeSet.getInteger(11, -1);
    this.iZz = paramAttributeSet.getInteger(6, 0);
    this.imeOptions = paramAttributeSet.getInteger(5, 5);
    this.JGy = paramAttributeSet.getColor(10, 2131100711);
    this.background = paramAttributeSet.getResourceId(1, -1);
    this.iZA = paramAttributeSet.getResourceId(9, 2131231995);
    this.iZE = paramAttributeSet.getInteger(12, 1);
    this.HET = paramAttributeSet.getBoolean(3, true);
    paramAttributeSet.recycle();
    paramContext = z.jD(paramContext).inflate(2131493737, this, true);
    this.JGv = ((TenpaySecureEditText)paramContext.findViewById(2131300744));
    this.ijF = ((TextView)paramContext.findViewById(2131305880));
    this.JGu = ((TextView)paramContext.findViewById(2131303372));
    this.iZw = ((ImageView)paramContext.findViewById(2131301009));
    this.JGv.setImeOptions(this.imeOptions);
    switch (this.iZz)
    {
    case 11: 
    default: 
      this.inputType = 1;
    case 0: 
      fAK();
      this.JGv.setSingleLine(this.HET);
      if (!this.HET) {
        this.JGv.setMaxLines(1073741823);
      }
      this.iZw.setOnClickListener(this.iZG);
      this.JGv.addTextChangedListener(new TextWatcher()
      {
        public final void afterTextChanged(Editable paramAnonymousEditable)
        {
          AppMethodBeat.i(72901);
          boolean bool = EditHintView.this.aRO();
          if ((bool != EditHintView.c(EditHintView.this)) && (EditHintView.d(EditHintView.this) != null))
          {
            ac.d("MicroMsg.EditHintView", "View:" + EditHintView.e(EditHintView.this) + ", editType:" + EditHintView.f(EditHintView.this) + " inputValid change to " + bool);
            EditHintView.a(EditHintView.this, bool);
            EditHintView.d(EditHintView.this);
            EditHintView.c(EditHintView.this);
          }
          EditHintView.g(EditHintView.this);
          AppMethodBeat.o(72901);
        }
        
        public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
        {
          AppMethodBeat.i(72900);
          if ((EditHintView.a(EditHintView.this) == 4) && (EditHintView.this.aRO()))
          {
            EditHintView.b(EditHintView.this);
            EditHintView.this.JGv.ClearInput();
          }
          AppMethodBeat.o(72900);
        }
        
        public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      });
      this.JGv.setOnFocusChangeListener(this);
      if (!bs.isNullOrNil(this.iZx)) {
        this.JGv.setHint(this.iZx);
      }
      if (!bs.isNullOrNil(this.iZy)) {
        this.ijF.setText(this.iZy);
      }
      this.JGv.setGravity(this.gravity);
      if (this.inputType == 2)
      {
        this.JGv.setKeyListener(new NumberKeyListener()
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
        if (this.iZF != -1) {
          this.JGv.setFilters(new InputFilter[] { new InputFilter.LengthFilter(this.iZF) });
        }
        super.setEnabled(true);
        super.setClickable(true);
        if (!this.kvD)
        {
          this.JGv.setEnabled(false);
          this.JGv.setTextColor(getResources().getColor(this.JGy));
          this.JGv.setFocusable(false);
          this.JGv.setClickable(false);
          this.JGv.setBackgroundResource(2131234429);
          setBackgroundResource(2131232867);
        }
        if (this.iZB) {
          break label1307;
        }
        this.iZD = true;
        this.JGv.setEnabled(false);
        this.JGv.setTextColor(getResources().getColor(2131100548));
        this.JGv.setFocusable(false);
        this.JGv.setClickable(false);
        this.JGv.setBackgroundResource(2131234429);
        setBackgroundResource(2131231818);
      }
      break;
    }
    for (;;)
    {
      if (this.background > 0) {
        setBackgroundResource(this.background);
      }
      if ((this.ijF != null) && (this.JGw != -1))
      {
        paramContext = this.ijF.getLayoutParams();
        paramContext.width = this.JGw;
        this.ijF.setLayoutParams(paramContext);
      }
      if (u.axL()) {
        this.JGv.setSecureEncrypt(new a(getEncryptType()));
      }
      AppMethodBeat.o(72906);
      return;
      this.iZF = 25;
      this.JGv.setIsBankcardFormat(true);
      this.inputType = 2;
      break;
      this.iZF = 6;
      this.ijF.setVisibility(8);
      this.JGv.setIsPasswordFormat(true, true);
      this.JGv.setImeOptions(6);
      this.inputType = 128;
      break;
      this.iZF = 3;
      this.ijF.setVisibility(8);
      this.JGv.setIsCvvPaymentFormat(true);
      this.JGv.setImeOptions(6);
      this.inputType = 128;
      break;
      this.iZF = 4;
      this.ijF.setVisibility(8);
      this.JGv.setIsCvv4PaymentFormat(true);
      this.JGv.setImeOptions(6);
      this.inputType = 128;
      break;
      this.iZF = 30;
      this.inputType = 3;
      break;
      this.iZF = 18;
      this.inputType = 4;
      break;
      this.iZF = 4;
      this.inputType = 2;
      break;
      this.iZB = false;
      this.JGv.setIsValidThru(true);
      setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(72903);
          if (EditHintView.h(EditHintView.this) == null)
          {
            paramAnonymousView = Calendar.getInstance();
            paramAnonymousView.setTimeInMillis(System.currentTimeMillis());
            paramAnonymousView.add(2, 1);
            EditHintView.a(EditHintView.this, paramAnonymousView.get(1));
            EditHintView.b(EditHintView.this, paramAnonymousView.get(2));
            EditHintView.a(EditHintView.this, new e(EditHintView.this.getContext(), new DatePickerDialog.OnDateSetListener()
            {
              public final void onDateSet(DatePicker paramAnonymous2DatePicker, int paramAnonymous2Int1, int paramAnonymous2Int2, int paramAnonymous2Int3)
              {
                AppMethodBeat.i(72902);
                if ((paramAnonymous2Int1 < EditHintView.i(EditHintView.this)) && (paramAnonymous2Int2 < EditHintView.j(EditHintView.this)))
                {
                  h.c(EditHintView.this.getContext(), EditHintView.this.getContext().getString(2131765250), null, true);
                  EditHintView.a(EditHintView.this, EditHintView.this.aRO());
                  if (EditHintView.d(EditHintView.this) != null)
                  {
                    ac.d("MicroMsg.EditHintView", "View:" + EditHintView.e(EditHintView.this) + ", editType:" + EditHintView.f(EditHintView.this) + " inputValid change to " + EditHintView.c(EditHintView.this));
                    EditHintView.d(EditHintView.this);
                    EditHintView.c(EditHintView.this);
                  }
                  AppMethodBeat.o(72902);
                  return;
                }
                paramAnonymous2DatePicker = new DecimalFormat("00");
                if (u.axL()) {
                  EditHintView.a(EditHintView.this, paramAnonymous2DatePicker.format(paramAnonymous2Int2 + 1) + paramAnonymous2Int1);
                }
                for (;;)
                {
                  EditHintView.k(EditHintView.this).setText(paramAnonymous2DatePicker.format(paramAnonymous2Int2 + 1) + paramAnonymous2DatePicker.format(paramAnonymous2Int1).substring(2));
                  break;
                  EditHintView.a(EditHintView.this, paramAnonymous2DatePicker.format(paramAnonymous2Int1).substring(2) + paramAnonymous2DatePicker.format(paramAnonymous2Int2 + 1));
                }
              }
            }, EditHintView.i(EditHintView.this), EditHintView.j(EditHintView.this), paramAnonymousView.get(5), paramAnonymousView.getTimeInMillis()));
          }
          EditHintView.h(EditHintView.this).show();
          AppMethodBeat.o(72903);
        }
      });
      break;
      this.iZF = 6;
      this.ijF.setVisibility(8);
      this.inputType = 2;
      break;
      this.inputType = 32;
      break;
      if ((this.iZB) || (!this.kvD)) {
        break;
      }
      break;
      this.iZF = 12;
      this.JGv.setIsMoneyAmountFormat(true);
      break;
      this.JGv.setIsSecurityAnswerFormat(true);
      break;
      if (this.inputType == 4)
      {
        this.JGv.setKeyListener(new NumberKeyListener()
        {
          protected final char[] getAcceptedChars()
          {
            return new char[] { 49, 50, 51, 52, 53, 54, 55, 56, 57, 48, 120, 88 };
          }
          
          public final int getInputType()
          {
            return 1;
          }
        });
        break label638;
      }
      if (this.inputType == 128)
      {
        this.JGv.setTransformationMethod(PasswordTransformationMethod.getInstance());
        this.JGv.setKeyListener(new NumberKeyListener()
        {
          protected final char[] getAcceptedChars()
          {
            return new char[] { 49, 50, 51, 52, 53, 54, 55, 56, 57, 48 };
          }
          
          public final int getInputType()
          {
            return 18;
          }
        });
        this.JGv.setRawInputType(18);
        break label638;
      }
      if (this.inputType == 3)
      {
        this.JGv.setKeyListener(new NumberKeyListener()
        {
          protected final char[] getAcceptedChars()
          {
            return new char[] { 49, 50, 51, 52, 53, 54, 55, 56, 57, 48, 45 };
          }
          
          public final int getInputType()
          {
            return 3;
          }
        });
        break label638;
      }
      this.JGv.setInputType(this.inputType);
      break label638;
      label1307:
      this.iZD = false;
      this.JGv.setBackgroundResource(this.iZA);
      setBackgroundResource(2131234429);
    }
  }
  
  private void fAK()
  {
    AppMethodBeat.i(72931);
    if ((this.iZz == 7) || (this.iZz == 14) || (this.iZz == 15))
    {
      AppMethodBeat.o(72931);
      return;
    }
    if ((this.iZB) && (!bs.isNullOrNil(getText())))
    {
      this.iZw.setVisibility(0);
      this.iZw.setImageResource(2131232862);
      AppMethodBeat.o(72931);
      return;
    }
    switch (this.iZz)
    {
    case 2: 
    case 5: 
    case 6: 
    case 7: 
    case 8: 
    default: 
      this.iZw.setVisibility(8);
      AppMethodBeat.o(72931);
      return;
    case 3: 
    case 4: 
    case 9: 
    case 10: 
      this.iZw.setVisibility(0);
      this.iZw.setImageResource(2131233568);
      AppMethodBeat.o(72931);
      return;
    }
    if (this.JGz)
    {
      this.iZw.setVisibility(0);
      this.iZw.setImageResource(2131691405);
      AppMethodBeat.o(72931);
      return;
    }
    this.iZw.setVisibility(8);
    AppMethodBeat.o(72931);
  }
  
  private int getEncryptType()
  {
    switch (this.iZz)
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
    AppMethodBeat.i(72936);
    Rect localRect = new Rect();
    this.iZw.getHitRect(localRect);
    localRect.left -= 50;
    localRect.right += 50;
    localRect.top -= 25;
    localRect.bottom += 25;
    AppMethodBeat.o(72936);
    return localRect;
  }
  
  private void setValStrForce(String paramString)
  {
    AppMethodBeat.i(72914);
    KeyListener localKeyListener = this.JGv.getKeyListener();
    this.JGv.setKeyListener(null);
    setEnabled(false);
    setClickable(false);
    setValStr(paramString);
    this.JGv.setKeyListener(localKeyListener);
    AppMethodBeat.o(72914);
  }
  
  public final boolean aRO()
  {
    AppMethodBeat.i(72923);
    if ((!this.iZB) && (!this.kvD))
    {
      AppMethodBeat.o(72923);
      return true;
    }
    boolean bool;
    switch (this.iZz)
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
      if (this.JGv.getInputLength() >= this.iZE)
      {
        AppMethodBeat.o(72923);
        return true;
      }
      break;
    case 1: 
      bool = this.JGv.isBankcardNum();
      AppMethodBeat.o(72923);
      return bool;
    case 9: 
      bool = this.JGv.isPhoneNum();
      AppMethodBeat.o(72923);
      return bool;
    case 4: 
      if (this.JGv.getInputLength() > 0)
      {
        AppMethodBeat.o(72923);
        return true;
      }
      AppMethodBeat.o(72923);
      return false;
    case 5: 
      bool = this.JGv.isAreaIDCardNum(this.JGx);
      AppMethodBeat.o(72923);
      return bool;
    case 7: 
    case 17: 
      if (this.JGv.getInputLength() == 6)
      {
        AppMethodBeat.o(72923);
        return true;
      }
      AppMethodBeat.o(72923);
      return false;
    case 14: 
      if (this.JGv.getInputLength() == 3)
      {
        AppMethodBeat.o(72923);
        return true;
      }
      AppMethodBeat.o(72923);
      return false;
    case 15: 
      if (this.JGv.getInputLength() == 4)
      {
        AppMethodBeat.o(72923);
        return true;
      }
      AppMethodBeat.o(72923);
      return false;
    case 8: 
      bool = bs.aLm(this.JGv.getText().toString());
      AppMethodBeat.o(72923);
      return bool;
    case 12: 
      bool = this.JGv.isMoneyAmount();
      AppMethodBeat.o(72923);
      return bool;
    }
    AppMethodBeat.o(72923);
    return false;
  }
  
  public String get3DesEncrptData()
  {
    AppMethodBeat.i(72924);
    String str = this.JGv.get3DesEncrptData();
    AppMethodBeat.o(72924);
    return str;
  }
  
  public String getMD5Value()
  {
    AppMethodBeat.i(72922);
    if (this.iZz == 3) {}
    for (String str = bs.bG(this.JGA, "").replace("/", "");; str = this.JGv.getText().toString())
    {
      str = ah.dg(str);
      AppMethodBeat.o(72922);
      return str;
    }
  }
  
  public String getText()
  {
    AppMethodBeat.i(72921);
    switch (this.iZz)
    {
    case 11: 
    case 12: 
    default: 
      localObject = bs.bG(this.JGv.getText().toString(), "");
      AppMethodBeat.o(72921);
      return localObject;
    case 1: 
    case 13: 
    case 16: 
      localObject = this.JGv;
      b.fzz();
      localObject = ((TenpaySecureEditText)localObject).getEncryptDataWithHash(false, b.fzA());
      AppMethodBeat.o(72921);
      return localObject;
    case 4: 
    case 14: 
    case 15: 
      localObject = this.JGv.get3DesEncrptData();
      AppMethodBeat.o(72921);
      return localObject;
    case 5: 
      localObject = this.JGv.get3DesEncrptData();
      AppMethodBeat.o(72921);
      return localObject;
    case 3: 
      localObject = bs.bG(this.JGA, "").replace("/", "");
      AppMethodBeat.o(72921);
      return localObject;
    case 2: 
    case 9: 
      localObject = bs.bG(this.JGv.getText().toString(), "");
      AppMethodBeat.o(72921);
      return localObject;
    case 0: 
    case 8: 
    case 10: 
      localObject = bs.bG(this.JGv.getText().toString(), "");
      AppMethodBeat.o(72921);
      return localObject;
    case 6: 
      localObject = this.JGv.get3DesVerifyCode();
      AppMethodBeat.o(72921);
      return localObject;
    }
    Object localObject = this.JGv;
    b.fzz();
    localObject = ((TenpaySecureEditText)localObject).getEncryptDataWithHash(true, b.fzA());
    AppMethodBeat.o(72921);
    return localObject;
  }
  
  public void onFocusChange(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(72932);
    if (this.iZu != null) {
      this.iZu.onFocusChange(this, paramBoolean);
    }
    ac.d("MicroMsg.EditHintView", "View:" + this.iZy + ", editType:" + this.iZz + " onFocusChange to " + paramBoolean);
    if (!this.iZD)
    {
      this.ijF.setEnabled(false);
      AppMethodBeat.o(72932);
      return;
    }
    this.ijF.setEnabled(true);
    AppMethodBeat.o(72932);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(72928);
    int i;
    if (!this.iZB)
    {
      if (this.iZw.getVisibility() != 0) {
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
      AppMethodBeat.o(72928);
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
    AppMethodBeat.o(72928);
    return true;
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(72908);
    int j;
    int i;
    if ((this.iZz != 7) && (this.iZz != 17) && (this.iZz != 14))
    {
      j = paramInt1;
      i = paramInt2;
      if (this.iZz != 15) {}
    }
    else
    {
      setMeasuredDimension(getDefaultSize(BackwardSupportUtil.b.g(getContext(), 960.0F), paramInt1), getDefaultSize(BackwardSupportUtil.b.g(getContext(), 720.0F), paramInt2));
      paramInt2 = getMeasuredWidth();
      if ((this.iZz != 7) && (this.iZz != 17)) {
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
      AppMethodBeat.o(72908);
      return;
      label153:
      if (this.iZz == 14) {
        paramInt1 = paramInt2 / 3;
      } else {
        paramInt1 = paramInt2 / 4;
      }
    }
  }
  
  public void set3DesValStr(String paramString)
  {
    AppMethodBeat.i(72913);
    switch (this.iZz)
    {
    default: 
      this.JGv.setText(paramString);
      this.JGv.setSelection(this.JGv.getText().length());
      AppMethodBeat.o(72913);
      return;
    }
    if ((!bs.isNullOrNil(paramString)) && (paramString.length() <= 5))
    {
      this.JGv.setSelection(0);
      this.JGv.set3DesEncrptData(paramString);
      this.iZF = (24 - paramString.length());
      this.JGv.setFilters(new InputFilter[] { new InputFilter.LengthFilter(this.iZF) });
      AppMethodBeat.o(72913);
      return;
    }
    this.JGv.set3DesEncrptData(paramString);
    this.JGv.setSelection(this.JGv.getText().length());
    AppMethodBeat.o(72913);
  }
  
  public void setClickable(boolean paramBoolean)
  {
    AppMethodBeat.i(72927);
    super.setClickable(paramBoolean);
    this.kvD = paramBoolean;
    if (!paramBoolean)
    {
      this.JGv.setEnabled(false);
      if (!this.iZB) {
        this.JGv.setTextColor(getResources().getColor(2131100544));
      }
      for (;;)
      {
        this.JGv.setFocusable(false);
        this.JGv.setClickable(false);
        AppMethodBeat.o(72927);
        return;
        this.JGv.setTextColor(getResources().getColor(this.JGy));
      }
    }
    this.JGv.setEnabled(true);
    if (!this.iZB) {
      this.JGv.setTextColor(getResources().getColor(2131100548));
    }
    for (;;)
    {
      this.JGv.setFocusable(true);
      this.JGv.setClickable(true);
      AppMethodBeat.o(72927);
      return;
      this.JGv.setTextColor(getResources().getColor(this.JGy));
    }
  }
  
  public void setEditBG(int paramInt)
  {
    AppMethodBeat.i(72916);
    if (this.JGv != null) {
      this.JGv.setBackgroundResource(paramInt);
    }
    AppMethodBeat.o(72916);
  }
  
  public void setEllipsize(TextUtils.TruncateAt paramTruncateAt)
  {
    AppMethodBeat.i(72925);
    this.JGv.setEllipsize(paramTruncateAt);
    AppMethodBeat.o(72925);
  }
  
  public void setEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(72926);
    super.setEnabled(paramBoolean);
    this.iZB = paramBoolean;
    this.iZw.setEnabled(true);
    AppMethodBeat.o(72926);
  }
  
  public void setEncryptType(int paramInt)
  {
    AppMethodBeat.i(72917);
    if (u.axL()) {
      this.JGv.setSecureEncrypt(new a(paramInt));
    }
    AppMethodBeat.o(72917);
  }
  
  public void setHintStr(String paramString)
  {
    AppMethodBeat.i(72909);
    this.JGv.setHint(paramString);
    AppMethodBeat.o(72909);
  }
  
  public void setIdentifyCardType(int paramInt)
  {
    AppMethodBeat.i(72920);
    this.JGx = paramInt;
    if (paramInt == 1)
    {
      this.JGv.setKeyListener(new NumberKeyListener()
      {
        protected final char[] getAcceptedChars()
        {
          return new char[] { 49, 50, 51, 52, 53, 54, 55, 56, 57, 48, 120, 88 };
        }
        
        public final int getInputType()
        {
          return 1;
        }
      });
      AppMethodBeat.o(72920);
      return;
    }
    this.JGv.setInputType(1);
    AppMethodBeat.o(72920);
  }
  
  public void setImeOptions(int paramInt)
  {
    AppMethodBeat.i(72933);
    this.JGv.setImeOptions(paramInt);
    AppMethodBeat.o(72933);
  }
  
  public void setInfoIvVisible(int paramInt)
  {
    AppMethodBeat.i(72935);
    this.iZw.setVisibility(paramInt);
    AppMethodBeat.o(72935);
  }
  
  public void setMaxLen(int paramInt)
  {
    AppMethodBeat.i(72919);
    if (paramInt != -1)
    {
      this.iZF = paramInt;
      this.JGv.setFilters(new InputFilter[] { new InputFilter.LengthFilter(paramInt) });
    }
    AppMethodBeat.o(72919);
  }
  
  public void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(72929);
    super.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(72929);
  }
  
  public void setOnEditorActionListener(TextView.OnEditorActionListener paramOnEditorActionListener)
  {
    AppMethodBeat.i(72934);
    this.JGv.setOnEditorActionListener(paramOnEditorActionListener);
    AppMethodBeat.o(72934);
  }
  
  public void setOnFocusChangeListener(View.OnFocusChangeListener paramOnFocusChangeListener)
  {
    AppMethodBeat.i(72930);
    super.setOnFocusChangeListener(paramOnFocusChangeListener);
    this.iZu = paramOnFocusChangeListener;
    AppMethodBeat.o(72930);
  }
  
  public void setOnInfoListener(a parama)
  {
    this.JGF = parama;
  }
  
  public void setOnInputValidChangeListener(b paramb)
  {
    this.JGt = paramb;
  }
  
  public void setPreFilledStr(String paramString)
  {
    AppMethodBeat.i(72911);
    if (!bs.isNullOrNil(paramString))
    {
      this.JGu.setText(paramString);
      this.JGu.setVisibility(0);
      AppMethodBeat.o(72911);
      return;
    }
    this.JGu.setText("");
    this.JGu.setVisibility(8);
    AppMethodBeat.o(72911);
  }
  
  public void setPreText(String paramString)
  {
    AppMethodBeat.i(72915);
    KeyListener localKeyListener = this.JGv.getKeyListener();
    this.JGv.setInputType(1);
    this.JGv.setKeyListener(null);
    setValStr(paramString);
    this.JGv.setKeyListener(localKeyListener);
    this.mode = 4;
    AppMethodBeat.o(72915);
  }
  
  public void setShowScanCamera(boolean paramBoolean)
  {
    AppMethodBeat.i(72937);
    this.JGz = paramBoolean;
    fAK();
    AppMethodBeat.o(72937);
  }
  
  public void setTipStr(String paramString)
  {
    AppMethodBeat.i(72910);
    this.ijF.setText(paramString);
    AppMethodBeat.o(72910);
  }
  
  public void setTipTextColor(int paramInt)
  {
    AppMethodBeat.i(72918);
    if (this.ijF != null) {
      this.ijF.setTextColor(paramInt);
    }
    AppMethodBeat.o(72918);
  }
  
  public void setTipWidth(int paramInt)
  {
    AppMethodBeat.i(72907);
    this.JGw = BackwardSupportUtil.b.g(getContext(), paramInt * 1.0F);
    if (this.ijF != null)
    {
      ViewGroup.LayoutParams localLayoutParams = this.ijF.getLayoutParams();
      localLayoutParams.width = this.JGw;
      this.ijF.setLayoutParams(localLayoutParams);
    }
    AppMethodBeat.o(72907);
  }
  
  public void setValStr(String paramString)
  {
    AppMethodBeat.i(72912);
    switch (this.iZz)
    {
    default: 
      this.JGv.setText(paramString);
      this.JGv.setSelection(this.JGv.getText().length());
      AppMethodBeat.o(72912);
      return;
    }
    if ((!bs.isNullOrNil(paramString)) && (paramString.length() <= 5))
    {
      this.JGv.setSelection(0);
      this.JGv.setBankcardTailNum(paramString);
      this.iZF = (24 - paramString.length());
      this.JGv.setFilters(new InputFilter[] { new InputFilter.LengthFilter(this.iZF) });
      AppMethodBeat.o(72912);
      return;
    }
    this.JGv.setText(paramString);
    this.JGv.setSelection(this.JGv.getText().length());
    AppMethodBeat.o(72912);
  }
  
  public static abstract interface a {}
  
  public static abstract interface b {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.wallet_core.ui.EditHintView
 * JD-Core Version:    0.7.0.1
 */