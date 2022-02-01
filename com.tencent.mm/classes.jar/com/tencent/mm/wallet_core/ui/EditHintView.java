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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.a.d;
import com.tencent.mm.ui.widget.e;
import com.tencent.mm.ui.y;
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
  public boolean Gfe;
  private b IeR;
  private TextView IeS;
  TenpaySecureEditText IeT;
  private int IeU;
  private int IeV;
  private int IeW;
  private boolean IeX;
  private String IeY;
  private DatePickerDialog IeZ;
  private int Ifa;
  private int Ifb;
  private d Ifc;
  private a Ifd;
  private int background;
  private int gravity;
  private TextView hJf;
  private int imeOptions;
  private int inputType;
  private boolean izA;
  private int izB;
  private int izC;
  private View.OnClickListener izD;
  private View.OnFocusChangeListener izr;
  private ImageView izt;
  private String izu;
  private String izv;
  private int izw;
  private int izx;
  public boolean izy;
  private boolean jUS;
  private int mode;
  
  public EditHintView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public EditHintView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(72906);
    this.izu = "";
    this.izv = "";
    this.inputType = 1;
    this.jUS = true;
    this.izC = -1;
    this.izB = 1;
    this.gravity = 19;
    this.IeU = -1;
    this.izw = -1;
    this.izA = false;
    this.IeV = 1;
    this.IeW = -1;
    this.background = -1;
    this.izx = -1;
    this.izy = true;
    this.Gfe = true;
    this.IeX = true;
    this.IeY = null;
    this.mode = 0;
    this.IeZ = null;
    this.Ifa = 0;
    this.Ifb = 0;
    this.izD = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(72904);
        if (EditHintView.l(EditHintView.this).getVisibility() == 0)
        {
          if ((EditHintView.this.izy) && (!bt.isNullOrNil(EditHintView.this.getText())))
          {
            EditHintView.this.IeT.ClearInput();
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
    this.Ifc = null;
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, a.a.EditHintView, paramInt, 0);
    paramInt = paramAttributeSet.getResourceId(8, 0);
    if (paramInt != 0) {
      this.izu = paramContext.getString(paramInt);
    }
    paramInt = paramAttributeSet.getResourceId(13, 0);
    if (paramInt != 0) {
      this.izv = paramContext.getString(paramInt);
    }
    this.inputType = paramAttributeSet.getInteger(4, 1);
    this.izy = paramAttributeSet.getBoolean(7, true);
    this.gravity = paramAttributeSet.getInt(0, 19);
    this.jUS = paramAttributeSet.getBoolean(2, true);
    this.izC = paramAttributeSet.getInteger(11, -1);
    this.izw = paramAttributeSet.getInteger(6, 0);
    this.imeOptions = paramAttributeSet.getInteger(5, 5);
    this.IeW = paramAttributeSet.getColor(10, 2131100711);
    this.background = paramAttributeSet.getResourceId(1, -1);
    this.izx = paramAttributeSet.getResourceId(9, 2131231995);
    this.izB = paramAttributeSet.getInteger(12, 1);
    this.Gfe = paramAttributeSet.getBoolean(3, true);
    paramAttributeSet.recycle();
    paramContext = y.js(paramContext).inflate(2131493737, this, true);
    this.IeT = ((TenpaySecureEditText)paramContext.findViewById(2131300744));
    this.hJf = ((TextView)paramContext.findViewById(2131305880));
    this.IeS = ((TextView)paramContext.findViewById(2131303372));
    this.izt = ((ImageView)paramContext.findViewById(2131301009));
    this.IeT.setImeOptions(this.imeOptions);
    switch (this.izw)
    {
    case 11: 
    default: 
      this.inputType = 1;
    case 0: 
      fku();
      this.IeT.setSingleLine(this.Gfe);
      if (!this.Gfe) {
        this.IeT.setMaxLines(1073741823);
      }
      this.izt.setOnClickListener(this.izD);
      this.IeT.addTextChangedListener(new TextWatcher()
      {
        public final void afterTextChanged(Editable paramAnonymousEditable)
        {
          AppMethodBeat.i(72901);
          boolean bool = EditHintView.this.aKX();
          if ((bool != EditHintView.c(EditHintView.this)) && (EditHintView.d(EditHintView.this) != null))
          {
            ad.d("MicroMsg.EditHintView", "View:" + EditHintView.e(EditHintView.this) + ", editType:" + EditHintView.f(EditHintView.this) + " inputValid change to " + bool);
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
          if ((EditHintView.a(EditHintView.this) == 4) && (EditHintView.this.aKX()))
          {
            EditHintView.b(EditHintView.this);
            EditHintView.this.IeT.ClearInput();
          }
          AppMethodBeat.o(72900);
        }
        
        public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      });
      this.IeT.setOnFocusChangeListener(this);
      if (!bt.isNullOrNil(this.izu)) {
        this.IeT.setHint(this.izu);
      }
      if (!bt.isNullOrNil(this.izv)) {
        this.hJf.setText(this.izv);
      }
      this.IeT.setGravity(this.gravity);
      if (this.inputType == 2)
      {
        this.IeT.setKeyListener(new NumberKeyListener()
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
        if (this.izC != -1) {
          this.IeT.setFilters(new InputFilter[] { new InputFilter.LengthFilter(this.izC) });
        }
        super.setEnabled(true);
        super.setClickable(true);
        if (!this.jUS)
        {
          this.IeT.setEnabled(false);
          this.IeT.setTextColor(getResources().getColor(this.IeW));
          this.IeT.setFocusable(false);
          this.IeT.setClickable(false);
          this.IeT.setBackgroundResource(2131234429);
          setBackgroundResource(2131232867);
        }
        if (this.izy) {
          break label1307;
        }
        this.izA = true;
        this.IeT.setEnabled(false);
        this.IeT.setTextColor(getResources().getColor(2131100548));
        this.IeT.setFocusable(false);
        this.IeT.setClickable(false);
        this.IeT.setBackgroundResource(2131234429);
        setBackgroundResource(2131231818);
      }
      break;
    }
    for (;;)
    {
      if (this.background > 0) {
        setBackgroundResource(this.background);
      }
      if ((this.hJf != null) && (this.IeU != -1))
      {
        paramContext = this.hJf.getLayoutParams();
        paramContext.width = this.IeU;
        this.hJf.setLayoutParams(paramContext);
      }
      if (u.aqV()) {
        this.IeT.setSecureEncrypt(new a(getEncryptType()));
      }
      AppMethodBeat.o(72906);
      return;
      this.izC = 25;
      this.IeT.setIsBankcardFormat(true);
      this.inputType = 2;
      break;
      this.izC = 6;
      this.hJf.setVisibility(8);
      this.IeT.setIsPasswordFormat(true, true);
      this.IeT.setImeOptions(6);
      this.inputType = 128;
      break;
      this.izC = 3;
      this.hJf.setVisibility(8);
      this.IeT.setIsCvvPaymentFormat(true);
      this.IeT.setImeOptions(6);
      this.inputType = 128;
      break;
      this.izC = 4;
      this.hJf.setVisibility(8);
      this.IeT.setIsCvv4PaymentFormat(true);
      this.IeT.setImeOptions(6);
      this.inputType = 128;
      break;
      this.izC = 30;
      this.inputType = 3;
      break;
      this.izC = 18;
      this.inputType = 4;
      break;
      this.izC = 4;
      this.inputType = 2;
      break;
      this.izy = false;
      this.IeT.setIsValidThru(true);
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
                  EditHintView.a(EditHintView.this, EditHintView.this.aKX());
                  if (EditHintView.d(EditHintView.this) != null)
                  {
                    ad.d("MicroMsg.EditHintView", "View:" + EditHintView.e(EditHintView.this) + ", editType:" + EditHintView.f(EditHintView.this) + " inputValid change to " + EditHintView.c(EditHintView.this));
                    EditHintView.d(EditHintView.this);
                    EditHintView.c(EditHintView.this);
                  }
                  AppMethodBeat.o(72902);
                  return;
                }
                paramAnonymous2DatePicker = new DecimalFormat("00");
                if (u.aqV()) {
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
      this.izC = 6;
      this.hJf.setVisibility(8);
      this.inputType = 2;
      break;
      this.inputType = 32;
      break;
      if ((this.izy) || (!this.jUS)) {
        break;
      }
      break;
      this.izC = 12;
      this.IeT.setIsMoneyAmountFormat(true);
      break;
      this.IeT.setIsSecurityAnswerFormat(true);
      break;
      if (this.inputType == 4)
      {
        this.IeT.setKeyListener(new NumberKeyListener()
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
        this.IeT.setTransformationMethod(PasswordTransformationMethod.getInstance());
        this.IeT.setKeyListener(new NumberKeyListener()
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
        this.IeT.setRawInputType(18);
        break label638;
      }
      if (this.inputType == 3)
      {
        this.IeT.setKeyListener(new NumberKeyListener()
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
      this.IeT.setInputType(this.inputType);
      break label638;
      label1307:
      this.izA = false;
      this.IeT.setBackgroundResource(this.izx);
      setBackgroundResource(2131234429);
    }
  }
  
  private void fku()
  {
    AppMethodBeat.i(72931);
    if ((this.izw == 7) || (this.izw == 14) || (this.izw == 15))
    {
      AppMethodBeat.o(72931);
      return;
    }
    if ((this.izy) && (!bt.isNullOrNil(getText())))
    {
      this.izt.setVisibility(0);
      this.izt.setImageResource(2131232862);
      AppMethodBeat.o(72931);
      return;
    }
    switch (this.izw)
    {
    case 2: 
    case 5: 
    case 6: 
    case 7: 
    case 8: 
    default: 
      this.izt.setVisibility(8);
      AppMethodBeat.o(72931);
      return;
    case 3: 
    case 4: 
    case 9: 
    case 10: 
      this.izt.setVisibility(0);
      this.izt.setImageResource(2131233568);
      AppMethodBeat.o(72931);
      return;
    }
    if (this.IeX)
    {
      this.izt.setVisibility(0);
      this.izt.setImageResource(2131691405);
      AppMethodBeat.o(72931);
      return;
    }
    this.izt.setVisibility(8);
    AppMethodBeat.o(72931);
  }
  
  private int getEncryptType()
  {
    switch (this.izw)
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
    this.izt.getHitRect(localRect);
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
    KeyListener localKeyListener = this.IeT.getKeyListener();
    this.IeT.setKeyListener(null);
    setEnabled(false);
    setClickable(false);
    setValStr(paramString);
    this.IeT.setKeyListener(localKeyListener);
    AppMethodBeat.o(72914);
  }
  
  public final boolean aKX()
  {
    AppMethodBeat.i(72923);
    if ((!this.izy) && (!this.jUS))
    {
      AppMethodBeat.o(72923);
      return true;
    }
    boolean bool;
    switch (this.izw)
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
      if (this.IeT.getInputLength() >= this.izB)
      {
        AppMethodBeat.o(72923);
        return true;
      }
      break;
    case 1: 
      bool = this.IeT.isBankcardNum();
      AppMethodBeat.o(72923);
      return bool;
    case 9: 
      bool = this.IeT.isPhoneNum();
      AppMethodBeat.o(72923);
      return bool;
    case 4: 
      if (this.IeT.getInputLength() > 0)
      {
        AppMethodBeat.o(72923);
        return true;
      }
      AppMethodBeat.o(72923);
      return false;
    case 5: 
      bool = this.IeT.isAreaIDCardNum(this.IeV);
      AppMethodBeat.o(72923);
      return bool;
    case 7: 
    case 17: 
      if (this.IeT.getInputLength() == 6)
      {
        AppMethodBeat.o(72923);
        return true;
      }
      AppMethodBeat.o(72923);
      return false;
    case 14: 
      if (this.IeT.getInputLength() == 3)
      {
        AppMethodBeat.o(72923);
        return true;
      }
      AppMethodBeat.o(72923);
      return false;
    case 15: 
      if (this.IeT.getInputLength() == 4)
      {
        AppMethodBeat.o(72923);
        return true;
      }
      AppMethodBeat.o(72923);
      return false;
    case 8: 
      bool = bt.aFV(this.IeT.getText().toString());
      AppMethodBeat.o(72923);
      return bool;
    case 12: 
      bool = this.IeT.isMoneyAmount();
      AppMethodBeat.o(72923);
      return bool;
    }
    AppMethodBeat.o(72923);
    return false;
  }
  
  public String get3DesEncrptData()
  {
    AppMethodBeat.i(72924);
    String str = this.IeT.get3DesEncrptData();
    AppMethodBeat.o(72924);
    return str;
  }
  
  public String getMD5Value()
  {
    AppMethodBeat.i(72922);
    if (this.izw == 3) {}
    for (String str = bt.by(this.IeY, "").replace("/", "");; str = this.IeT.getText().toString())
    {
      str = ai.du(str);
      AppMethodBeat.o(72922);
      return str;
    }
  }
  
  public String getText()
  {
    AppMethodBeat.i(72921);
    switch (this.izw)
    {
    case 11: 
    case 12: 
    default: 
      localObject = bt.by(this.IeT.getText().toString(), "");
      AppMethodBeat.o(72921);
      return localObject;
    case 1: 
    case 13: 
    case 16: 
      localObject = this.IeT;
      b.fjk();
      localObject = ((TenpaySecureEditText)localObject).getEncryptDataWithHash(false, b.fjl());
      AppMethodBeat.o(72921);
      return localObject;
    case 4: 
    case 14: 
    case 15: 
      localObject = this.IeT.get3DesEncrptData();
      AppMethodBeat.o(72921);
      return localObject;
    case 5: 
      localObject = this.IeT.get3DesEncrptData();
      AppMethodBeat.o(72921);
      return localObject;
    case 3: 
      localObject = bt.by(this.IeY, "").replace("/", "");
      AppMethodBeat.o(72921);
      return localObject;
    case 2: 
    case 9: 
      localObject = bt.by(this.IeT.getText().toString(), "");
      AppMethodBeat.o(72921);
      return localObject;
    case 0: 
    case 8: 
    case 10: 
      localObject = bt.by(this.IeT.getText().toString(), "");
      AppMethodBeat.o(72921);
      return localObject;
    case 6: 
      localObject = this.IeT.get3DesVerifyCode();
      AppMethodBeat.o(72921);
      return localObject;
    }
    Object localObject = this.IeT;
    b.fjk();
    localObject = ((TenpaySecureEditText)localObject).getEncryptDataWithHash(true, b.fjl());
    AppMethodBeat.o(72921);
    return localObject;
  }
  
  public void onFocusChange(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(72932);
    if (this.izr != null) {
      this.izr.onFocusChange(this, paramBoolean);
    }
    ad.d("MicroMsg.EditHintView", "View:" + this.izv + ", editType:" + this.izw + " onFocusChange to " + paramBoolean);
    if (!this.izA)
    {
      this.hJf.setEnabled(false);
      AppMethodBeat.o(72932);
      return;
    }
    this.hJf.setEnabled(true);
    AppMethodBeat.o(72932);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(72928);
    int i;
    if (!this.izy)
    {
      if (this.izt.getVisibility() != 0) {
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
    if ((this.izw != 7) && (this.izw != 17) && (this.izw != 14))
    {
      j = paramInt1;
      i = paramInt2;
      if (this.izw != 15) {}
    }
    else
    {
      setMeasuredDimension(getDefaultSize(BackwardSupportUtil.b.g(getContext(), 960.0F), paramInt1), getDefaultSize(BackwardSupportUtil.b.g(getContext(), 720.0F), paramInt2));
      paramInt2 = getMeasuredWidth();
      if ((this.izw != 7) && (this.izw != 17)) {
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
      if (this.izw == 14) {
        paramInt1 = paramInt2 / 3;
      } else {
        paramInt1 = paramInt2 / 4;
      }
    }
  }
  
  public void set3DesValStr(String paramString)
  {
    AppMethodBeat.i(72913);
    switch (this.izw)
    {
    default: 
      this.IeT.setText(paramString);
      this.IeT.setSelection(this.IeT.getText().length());
      AppMethodBeat.o(72913);
      return;
    }
    if ((!bt.isNullOrNil(paramString)) && (paramString.length() <= 5))
    {
      this.IeT.setSelection(0);
      this.IeT.set3DesEncrptData(paramString);
      this.izC = (24 - paramString.length());
      this.IeT.setFilters(new InputFilter[] { new InputFilter.LengthFilter(this.izC) });
      AppMethodBeat.o(72913);
      return;
    }
    this.IeT.set3DesEncrptData(paramString);
    this.IeT.setSelection(this.IeT.getText().length());
    AppMethodBeat.o(72913);
  }
  
  public void setClickable(boolean paramBoolean)
  {
    AppMethodBeat.i(72927);
    super.setClickable(paramBoolean);
    this.jUS = paramBoolean;
    if (!paramBoolean)
    {
      this.IeT.setEnabled(false);
      if (!this.izy) {
        this.IeT.setTextColor(getResources().getColor(2131100544));
      }
      for (;;)
      {
        this.IeT.setFocusable(false);
        this.IeT.setClickable(false);
        AppMethodBeat.o(72927);
        return;
        this.IeT.setTextColor(getResources().getColor(this.IeW));
      }
    }
    this.IeT.setEnabled(true);
    if (!this.izy) {
      this.IeT.setTextColor(getResources().getColor(2131100548));
    }
    for (;;)
    {
      this.IeT.setFocusable(true);
      this.IeT.setClickable(true);
      AppMethodBeat.o(72927);
      return;
      this.IeT.setTextColor(getResources().getColor(this.IeW));
    }
  }
  
  public void setEditBG(int paramInt)
  {
    AppMethodBeat.i(72916);
    if (this.IeT != null) {
      this.IeT.setBackgroundResource(paramInt);
    }
    AppMethodBeat.o(72916);
  }
  
  public void setEllipsize(TextUtils.TruncateAt paramTruncateAt)
  {
    AppMethodBeat.i(72925);
    this.IeT.setEllipsize(paramTruncateAt);
    AppMethodBeat.o(72925);
  }
  
  public void setEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(72926);
    super.setEnabled(paramBoolean);
    this.izy = paramBoolean;
    this.izt.setEnabled(true);
    AppMethodBeat.o(72926);
  }
  
  public void setEncryptType(int paramInt)
  {
    AppMethodBeat.i(72917);
    if (u.aqV()) {
      this.IeT.setSecureEncrypt(new a(paramInt));
    }
    AppMethodBeat.o(72917);
  }
  
  public void setHintStr(String paramString)
  {
    AppMethodBeat.i(72909);
    this.IeT.setHint(paramString);
    AppMethodBeat.o(72909);
  }
  
  public void setIdentifyCardType(int paramInt)
  {
    AppMethodBeat.i(72920);
    this.IeV = paramInt;
    if (paramInt == 1)
    {
      this.IeT.setKeyListener(new NumberKeyListener()
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
    this.IeT.setInputType(1);
    AppMethodBeat.o(72920);
  }
  
  public void setImeOptions(int paramInt)
  {
    AppMethodBeat.i(72933);
    this.IeT.setImeOptions(paramInt);
    AppMethodBeat.o(72933);
  }
  
  public void setInfoIvVisible(int paramInt)
  {
    AppMethodBeat.i(72935);
    this.izt.setVisibility(paramInt);
    AppMethodBeat.o(72935);
  }
  
  public void setMaxLen(int paramInt)
  {
    AppMethodBeat.i(72919);
    if (paramInt != -1)
    {
      this.izC = paramInt;
      this.IeT.setFilters(new InputFilter[] { new InputFilter.LengthFilter(paramInt) });
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
    this.IeT.setOnEditorActionListener(paramOnEditorActionListener);
    AppMethodBeat.o(72934);
  }
  
  public void setOnFocusChangeListener(View.OnFocusChangeListener paramOnFocusChangeListener)
  {
    AppMethodBeat.i(72930);
    super.setOnFocusChangeListener(paramOnFocusChangeListener);
    this.izr = paramOnFocusChangeListener;
    AppMethodBeat.o(72930);
  }
  
  public void setOnInfoListener(a parama)
  {
    this.Ifd = parama;
  }
  
  public void setOnInputValidChangeListener(b paramb)
  {
    this.IeR = paramb;
  }
  
  public void setPreFilledStr(String paramString)
  {
    AppMethodBeat.i(72911);
    if (!bt.isNullOrNil(paramString))
    {
      this.IeS.setText(paramString);
      this.IeS.setVisibility(0);
      AppMethodBeat.o(72911);
      return;
    }
    this.IeS.setText("");
    this.IeS.setVisibility(8);
    AppMethodBeat.o(72911);
  }
  
  public void setPreText(String paramString)
  {
    AppMethodBeat.i(72915);
    KeyListener localKeyListener = this.IeT.getKeyListener();
    this.IeT.setInputType(1);
    this.IeT.setKeyListener(null);
    setValStr(paramString);
    this.IeT.setKeyListener(localKeyListener);
    this.mode = 4;
    AppMethodBeat.o(72915);
  }
  
  public void setShowScanCamera(boolean paramBoolean)
  {
    AppMethodBeat.i(72937);
    this.IeX = paramBoolean;
    fku();
    AppMethodBeat.o(72937);
  }
  
  public void setTipStr(String paramString)
  {
    AppMethodBeat.i(72910);
    this.hJf.setText(paramString);
    AppMethodBeat.o(72910);
  }
  
  public void setTipTextColor(int paramInt)
  {
    AppMethodBeat.i(72918);
    if (this.hJf != null) {
      this.hJf.setTextColor(paramInt);
    }
    AppMethodBeat.o(72918);
  }
  
  public void setTipWidth(int paramInt)
  {
    AppMethodBeat.i(72907);
    this.IeU = BackwardSupportUtil.b.g(getContext(), paramInt * 1.0F);
    if (this.hJf != null)
    {
      ViewGroup.LayoutParams localLayoutParams = this.hJf.getLayoutParams();
      localLayoutParams.width = this.IeU;
      this.hJf.setLayoutParams(localLayoutParams);
    }
    AppMethodBeat.o(72907);
  }
  
  public void setValStr(String paramString)
  {
    AppMethodBeat.i(72912);
    switch (this.izw)
    {
    default: 
      this.IeT.setText(paramString);
      this.IeT.setSelection(this.IeT.getText().length());
      AppMethodBeat.o(72912);
      return;
    }
    if ((!bt.isNullOrNil(paramString)) && (paramString.length() <= 5))
    {
      this.IeT.setSelection(0);
      this.IeT.setBankcardTailNum(paramString);
      this.izC = (24 - paramString.length());
      this.IeT.setFilters(new InputFilter[] { new InputFilter.LengthFilter(this.izC) });
      AppMethodBeat.o(72912);
      return;
    }
    this.IeT.setText(paramString);
    this.IeT.setSelection(this.IeT.getText().length());
    AppMethodBeat.o(72912);
  }
  
  public static abstract interface a {}
  
  public static abstract interface b {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.wallet_core.ui.EditHintView
 * JD-Core Version:    0.7.0.1
 */