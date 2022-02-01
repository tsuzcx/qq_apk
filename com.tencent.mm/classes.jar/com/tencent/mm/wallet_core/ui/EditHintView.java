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
import com.tencent.mm.ui.z;
import com.tenpay.android.wechat.TenpaySecureEditText;
import java.text.DecimalFormat;
import java.util.Calendar;

@Deprecated
public class EditHintView
  extends RelativeLayout
  implements View.OnFocusChangeListener
{
  public boolean JsK;
  private int LzA;
  private int LzB;
  private int LzC;
  private boolean LzD;
  private String LzE;
  private DatePickerDialog LzF;
  private int LzG;
  private int LzH;
  private d LzI;
  private a LzJ;
  private b Lzx;
  private TextView Lzy;
  TenpaySecureEditText Lzz;
  private int background;
  private int gravity;
  private TextView iCW;
  private int imeOptions;
  private int inputType;
  private View.OnFocusChangeListener jsD;
  private ImageView jsF;
  private String jsG;
  private String jsH;
  private int jsI;
  private int jsJ;
  public boolean jsK;
  private boolean jsM;
  private int jsN;
  private int jsO;
  private View.OnClickListener jsP;
  private boolean kRF;
  private int mode;
  
  public EditHintView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public EditHintView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(72906);
    this.jsG = "";
    this.jsH = "";
    this.inputType = 1;
    this.kRF = true;
    this.jsO = -1;
    this.jsN = 1;
    this.gravity = 19;
    this.LzA = -1;
    this.jsI = -1;
    this.jsM = false;
    this.LzB = 1;
    this.LzC = -1;
    this.background = -1;
    this.jsJ = -1;
    this.jsK = true;
    this.JsK = true;
    this.LzD = true;
    this.LzE = null;
    this.mode = 0;
    this.LzF = null;
    this.LzG = 0;
    this.LzH = 0;
    this.jsP = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(72904);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/wallet_core/ui/EditHintView$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        if (EditHintView.l(EditHintView.this).getVisibility() == 0)
        {
          if ((!EditHintView.this.jsK) || (bt.isNullOrNil(EditHintView.this.getText()))) {
            break label98;
          }
          EditHintView.this.Lzz.ClearInput();
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/wallet_core/ui/EditHintView$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(72904);
          return;
          label98:
          if (EditHintView.f(EditHintView.this) == 1)
          {
            if ((EditHintView.m(EditHintView.this) != null) && (EditHintView.n(EditHintView.this))) {
              EditHintView.m(EditHintView.this);
            }
          }
          else {
            EditHintView.o(EditHintView.this);
          }
        }
      }
    };
    this.LzI = null;
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, a.a.EditHintView, paramInt, 0);
    paramInt = paramAttributeSet.getResourceId(8, 0);
    if (paramInt != 0) {
      this.jsG = paramContext.getString(paramInt);
    }
    paramInt = paramAttributeSet.getResourceId(13, 0);
    if (paramInt != 0) {
      this.jsH = paramContext.getString(paramInt);
    }
    this.inputType = paramAttributeSet.getInteger(4, 1);
    this.jsK = paramAttributeSet.getBoolean(7, true);
    this.gravity = paramAttributeSet.getInt(0, 19);
    this.kRF = paramAttributeSet.getBoolean(2, true);
    this.jsO = paramAttributeSet.getInteger(11, -1);
    this.jsI = paramAttributeSet.getInteger(6, 0);
    this.imeOptions = paramAttributeSet.getInteger(5, 5);
    this.LzC = paramAttributeSet.getColor(10, 2131100711);
    this.background = paramAttributeSet.getResourceId(1, -1);
    this.jsJ = paramAttributeSet.getResourceId(9, 2131231995);
    this.jsN = paramAttributeSet.getInteger(12, 1);
    this.JsK = paramAttributeSet.getBoolean(3, true);
    paramAttributeSet.recycle();
    paramContext = z.jO(paramContext).inflate(2131493737, this, true);
    this.Lzz = ((TenpaySecureEditText)paramContext.findViewById(2131300744));
    this.iCW = ((TextView)paramContext.findViewById(2131305880));
    this.Lzy = ((TextView)paramContext.findViewById(2131303372));
    this.jsF = ((ImageView)paramContext.findViewById(2131301009));
    this.Lzz.setImeOptions(this.imeOptions);
    switch (this.jsI)
    {
    case 11: 
    default: 
      this.inputType = 1;
    case 0: 
      fRU();
      this.Lzz.setSingleLine(this.JsK);
      if (!this.JsK) {
        this.Lzz.setMaxLines(1073741823);
      }
      this.jsF.setOnClickListener(this.jsP);
      this.Lzz.addTextChangedListener(new TextWatcher()
      {
        public final void afterTextChanged(Editable paramAnonymousEditable)
        {
          AppMethodBeat.i(72901);
          boolean bool = EditHintView.this.aVa();
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
          if ((EditHintView.a(EditHintView.this) == 4) && (EditHintView.this.aVa()))
          {
            EditHintView.b(EditHintView.this);
            EditHintView.this.Lzz.ClearInput();
          }
          AppMethodBeat.o(72900);
        }
        
        public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      });
      this.Lzz.setOnFocusChangeListener(this);
      if (!bt.isNullOrNil(this.jsG)) {
        this.Lzz.setHint(this.jsG);
      }
      if (!bt.isNullOrNil(this.jsH)) {
        this.iCW.setText(this.jsH);
      }
      this.Lzz.setGravity(this.gravity);
      if (this.inputType == 2)
      {
        this.Lzz.setKeyListener(new NumberKeyListener()
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
        if (this.jsO != -1) {
          this.Lzz.setFilters(new InputFilter[] { new InputFilter.LengthFilter(this.jsO) });
        }
        super.setEnabled(true);
        super.setClickable(true);
        if (!this.kRF)
        {
          this.Lzz.setEnabled(false);
          this.Lzz.setTextColor(getResources().getColor(this.LzC));
          this.Lzz.setFocusable(false);
          this.Lzz.setClickable(false);
          this.Lzz.setBackgroundResource(2131234429);
          setBackgroundResource(2131232867);
        }
        if (this.jsK) {
          break label1307;
        }
        this.jsM = true;
        this.Lzz.setEnabled(false);
        this.Lzz.setTextColor(getResources().getColor(2131100548));
        this.Lzz.setFocusable(false);
        this.Lzz.setClickable(false);
        this.Lzz.setBackgroundResource(2131234429);
        setBackgroundResource(2131231818);
      }
      break;
    }
    for (;;)
    {
      if (this.background > 0) {
        setBackgroundResource(this.background);
      }
      if ((this.iCW != null) && (this.LzA != -1))
      {
        paramContext = this.iCW.getLayoutParams();
        paramContext.width = this.LzA;
        this.iCW.setLayoutParams(paramContext);
      }
      if (u.aAB()) {
        this.Lzz.setSecureEncrypt(new com.tencent.mm.wallet_core.a.a(getEncryptType()));
      }
      AppMethodBeat.o(72906);
      return;
      this.jsO = 25;
      this.Lzz.setIsBankcardFormat(true);
      this.inputType = 2;
      break;
      this.jsO = 6;
      this.iCW.setVisibility(8);
      this.Lzz.setIsPasswordFormat(true, true);
      this.Lzz.setImeOptions(6);
      this.inputType = 128;
      break;
      this.jsO = 3;
      this.iCW.setVisibility(8);
      this.Lzz.setIsCvvPaymentFormat(true);
      this.Lzz.setImeOptions(6);
      this.inputType = 128;
      break;
      this.jsO = 4;
      this.iCW.setVisibility(8);
      this.Lzz.setIsCvv4PaymentFormat(true);
      this.Lzz.setImeOptions(6);
      this.inputType = 128;
      break;
      this.jsO = 30;
      this.inputType = 3;
      break;
      this.jsO = 18;
      this.inputType = 4;
      break;
      this.jsO = 4;
      this.inputType = 2;
      break;
      this.jsK = false;
      this.Lzz.setIsValidThru(true);
      setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(72903);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/wallet_core/ui/EditHintView$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
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
                  EditHintView.a(EditHintView.this, EditHintView.this.aVa());
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
                if (u.aAB()) {
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
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/wallet_core/ui/EditHintView$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(72903);
        }
      });
      break;
      this.jsO = 6;
      this.iCW.setVisibility(8);
      this.inputType = 2;
      break;
      this.inputType = 32;
      break;
      if ((this.jsK) || (!this.kRF)) {
        break;
      }
      break;
      this.jsO = 12;
      this.Lzz.setIsMoneyAmountFormat(true);
      break;
      this.Lzz.setIsSecurityAnswerFormat(true);
      break;
      if (this.inputType == 4)
      {
        this.Lzz.setKeyListener(new NumberKeyListener()
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
        this.Lzz.setTransformationMethod(PasswordTransformationMethod.getInstance());
        this.Lzz.setKeyListener(new NumberKeyListener()
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
        this.Lzz.setRawInputType(18);
        break label638;
      }
      if (this.inputType == 3)
      {
        this.Lzz.setKeyListener(new NumberKeyListener()
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
      this.Lzz.setInputType(this.inputType);
      break label638;
      label1307:
      this.jsM = false;
      this.Lzz.setBackgroundResource(this.jsJ);
      setBackgroundResource(2131234429);
    }
  }
  
  private void fRU()
  {
    AppMethodBeat.i(72931);
    if ((this.jsI == 7) || (this.jsI == 14) || (this.jsI == 15))
    {
      AppMethodBeat.o(72931);
      return;
    }
    if ((this.jsK) && (!bt.isNullOrNil(getText())))
    {
      this.jsF.setVisibility(0);
      this.jsF.setImageResource(2131232862);
      AppMethodBeat.o(72931);
      return;
    }
    switch (this.jsI)
    {
    case 2: 
    case 5: 
    case 6: 
    case 7: 
    case 8: 
    default: 
      this.jsF.setVisibility(8);
      AppMethodBeat.o(72931);
      return;
    case 3: 
    case 4: 
    case 9: 
    case 10: 
      this.jsF.setVisibility(0);
      this.jsF.setImageResource(2131233568);
      AppMethodBeat.o(72931);
      return;
    }
    if (this.LzD)
    {
      this.jsF.setVisibility(0);
      this.jsF.setImageResource(2131691405);
      AppMethodBeat.o(72931);
      return;
    }
    this.jsF.setVisibility(8);
    AppMethodBeat.o(72931);
  }
  
  private int getEncryptType()
  {
    switch (this.jsI)
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
    this.jsF.getHitRect(localRect);
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
    KeyListener localKeyListener = this.Lzz.getKeyListener();
    this.Lzz.setKeyListener(null);
    setEnabled(false);
    setClickable(false);
    setValStr(paramString);
    this.Lzz.setKeyListener(localKeyListener);
    AppMethodBeat.o(72914);
  }
  
  public final boolean aVa()
  {
    AppMethodBeat.i(72923);
    if ((!this.jsK) && (!this.kRF))
    {
      AppMethodBeat.o(72923);
      return true;
    }
    boolean bool;
    switch (this.jsI)
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
      if (this.Lzz.getInputLength() >= this.jsN)
      {
        AppMethodBeat.o(72923);
        return true;
      }
      break;
    case 1: 
      bool = this.Lzz.isBankcardNum();
      AppMethodBeat.o(72923);
      return bool;
    case 9: 
      bool = this.Lzz.isPhoneNum();
      AppMethodBeat.o(72923);
      return bool;
    case 4: 
      if (this.Lzz.getInputLength() > 0)
      {
        AppMethodBeat.o(72923);
        return true;
      }
      AppMethodBeat.o(72923);
      return false;
    case 5: 
      bool = this.Lzz.isAreaIDCardNum(this.LzB);
      AppMethodBeat.o(72923);
      return bool;
    case 7: 
    case 17: 
      if (this.Lzz.getInputLength() == 6)
      {
        AppMethodBeat.o(72923);
        return true;
      }
      AppMethodBeat.o(72923);
      return false;
    case 14: 
      if (this.Lzz.getInputLength() == 3)
      {
        AppMethodBeat.o(72923);
        return true;
      }
      AppMethodBeat.o(72923);
      return false;
    case 15: 
      if (this.Lzz.getInputLength() == 4)
      {
        AppMethodBeat.o(72923);
        return true;
      }
      AppMethodBeat.o(72923);
      return false;
    case 8: 
      bool = bt.aQS(this.Lzz.getText().toString());
      AppMethodBeat.o(72923);
      return bool;
    case 12: 
      bool = this.Lzz.isMoneyAmount();
      AppMethodBeat.o(72923);
      return bool;
    }
    AppMethodBeat.o(72923);
    return false;
  }
  
  public String get3DesEncrptData()
  {
    AppMethodBeat.i(72924);
    String str = this.Lzz.get3DesEncrptData();
    AppMethodBeat.o(72924);
    return str;
  }
  
  public String getMD5Value()
  {
    AppMethodBeat.i(72922);
    if (this.jsI == 3) {}
    for (String str = bt.bI(this.LzE, "").replace("/", "");; str = this.Lzz.getText().toString())
    {
      str = ai.ee(str);
      AppMethodBeat.o(72922);
      return str;
    }
  }
  
  public String getText()
  {
    AppMethodBeat.i(72921);
    switch (this.jsI)
    {
    case 11: 
    case 12: 
    default: 
      localObject = bt.bI(this.Lzz.getText().toString(), "");
      AppMethodBeat.o(72921);
      return localObject;
    case 1: 
    case 13: 
    case 16: 
      localObject = this.Lzz;
      com.tencent.mm.wallet_core.b.fQJ();
      localObject = ((TenpaySecureEditText)localObject).getEncryptDataWithHash(false, com.tencent.mm.wallet_core.b.fQK());
      AppMethodBeat.o(72921);
      return localObject;
    case 4: 
    case 14: 
    case 15: 
      localObject = this.Lzz.get3DesEncrptData();
      AppMethodBeat.o(72921);
      return localObject;
    case 5: 
      localObject = this.Lzz.get3DesEncrptData();
      AppMethodBeat.o(72921);
      return localObject;
    case 3: 
      localObject = bt.bI(this.LzE, "").replace("/", "");
      AppMethodBeat.o(72921);
      return localObject;
    case 2: 
    case 9: 
      localObject = bt.bI(this.Lzz.getText().toString(), "");
      AppMethodBeat.o(72921);
      return localObject;
    case 0: 
    case 8: 
    case 10: 
      localObject = bt.bI(this.Lzz.getText().toString(), "");
      AppMethodBeat.o(72921);
      return localObject;
    case 6: 
      localObject = this.Lzz.get3DesVerifyCode();
      AppMethodBeat.o(72921);
      return localObject;
    }
    Object localObject = this.Lzz;
    com.tencent.mm.wallet_core.b.fQJ();
    localObject = ((TenpaySecureEditText)localObject).getEncryptDataWithHash(true, com.tencent.mm.wallet_core.b.fQK());
    AppMethodBeat.o(72921);
    return localObject;
  }
  
  public void onFocusChange(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(72932);
    if (this.jsD != null) {
      this.jsD.onFocusChange(this, paramBoolean);
    }
    ad.d("MicroMsg.EditHintView", "View:" + this.jsH + ", editType:" + this.jsI + " onFocusChange to " + paramBoolean);
    if (!this.jsM)
    {
      this.iCW.setEnabled(false);
      AppMethodBeat.o(72932);
      return;
    }
    this.iCW.setEnabled(true);
    AppMethodBeat.o(72932);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(72928);
    int i;
    if (!this.jsK)
    {
      if (this.jsF.getVisibility() != 0) {
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
    if ((this.jsI != 7) && (this.jsI != 17) && (this.jsI != 14))
    {
      j = paramInt1;
      i = paramInt2;
      if (this.jsI != 15) {}
    }
    else
    {
      setMeasuredDimension(getDefaultSize(BackwardSupportUtil.b.g(getContext(), 960.0F), paramInt1), getDefaultSize(BackwardSupportUtil.b.g(getContext(), 720.0F), paramInt2));
      paramInt2 = getMeasuredWidth();
      if ((this.jsI != 7) && (this.jsI != 17)) {
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
      if (this.jsI == 14) {
        paramInt1 = paramInt2 / 3;
      } else {
        paramInt1 = paramInt2 / 4;
      }
    }
  }
  
  public void set3DesValStr(String paramString)
  {
    AppMethodBeat.i(72913);
    switch (this.jsI)
    {
    default: 
      this.Lzz.setText(paramString);
      this.Lzz.setSelection(this.Lzz.getText().length());
      AppMethodBeat.o(72913);
      return;
    }
    if ((!bt.isNullOrNil(paramString)) && (paramString.length() <= 5))
    {
      this.Lzz.setSelection(0);
      this.Lzz.set3DesEncrptData(paramString);
      this.jsO = (24 - paramString.length());
      this.Lzz.setFilters(new InputFilter[] { new InputFilter.LengthFilter(this.jsO) });
      AppMethodBeat.o(72913);
      return;
    }
    this.Lzz.set3DesEncrptData(paramString);
    this.Lzz.setSelection(this.Lzz.getText().length());
    AppMethodBeat.o(72913);
  }
  
  public void setClickable(boolean paramBoolean)
  {
    AppMethodBeat.i(72927);
    super.setClickable(paramBoolean);
    this.kRF = paramBoolean;
    if (!paramBoolean)
    {
      this.Lzz.setEnabled(false);
      if (!this.jsK) {
        this.Lzz.setTextColor(getResources().getColor(2131100544));
      }
      for (;;)
      {
        this.Lzz.setFocusable(false);
        this.Lzz.setClickable(false);
        AppMethodBeat.o(72927);
        return;
        this.Lzz.setTextColor(getResources().getColor(this.LzC));
      }
    }
    this.Lzz.setEnabled(true);
    if (!this.jsK) {
      this.Lzz.setTextColor(getResources().getColor(2131100548));
    }
    for (;;)
    {
      this.Lzz.setFocusable(true);
      this.Lzz.setClickable(true);
      AppMethodBeat.o(72927);
      return;
      this.Lzz.setTextColor(getResources().getColor(this.LzC));
    }
  }
  
  public void setEditBG(int paramInt)
  {
    AppMethodBeat.i(72916);
    if (this.Lzz != null) {
      this.Lzz.setBackgroundResource(paramInt);
    }
    AppMethodBeat.o(72916);
  }
  
  public void setEllipsize(TextUtils.TruncateAt paramTruncateAt)
  {
    AppMethodBeat.i(72925);
    this.Lzz.setEllipsize(paramTruncateAt);
    AppMethodBeat.o(72925);
  }
  
  public void setEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(72926);
    super.setEnabled(paramBoolean);
    this.jsK = paramBoolean;
    this.jsF.setEnabled(true);
    AppMethodBeat.o(72926);
  }
  
  public void setEncryptType(int paramInt)
  {
    AppMethodBeat.i(72917);
    if (u.aAB()) {
      this.Lzz.setSecureEncrypt(new com.tencent.mm.wallet_core.a.a(paramInt));
    }
    AppMethodBeat.o(72917);
  }
  
  public void setHintStr(String paramString)
  {
    AppMethodBeat.i(72909);
    this.Lzz.setHint(paramString);
    AppMethodBeat.o(72909);
  }
  
  public void setIdentifyCardType(int paramInt)
  {
    AppMethodBeat.i(72920);
    this.LzB = paramInt;
    if (paramInt == 1)
    {
      this.Lzz.setKeyListener(new NumberKeyListener()
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
    this.Lzz.setInputType(1);
    AppMethodBeat.o(72920);
  }
  
  public void setImeOptions(int paramInt)
  {
    AppMethodBeat.i(72933);
    this.Lzz.setImeOptions(paramInt);
    AppMethodBeat.o(72933);
  }
  
  public void setInfoIvVisible(int paramInt)
  {
    AppMethodBeat.i(72935);
    this.jsF.setVisibility(paramInt);
    AppMethodBeat.o(72935);
  }
  
  public void setMaxLen(int paramInt)
  {
    AppMethodBeat.i(72919);
    if (paramInt != -1)
    {
      this.jsO = paramInt;
      this.Lzz.setFilters(new InputFilter[] { new InputFilter.LengthFilter(paramInt) });
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
    this.Lzz.setOnEditorActionListener(paramOnEditorActionListener);
    AppMethodBeat.o(72934);
  }
  
  public void setOnFocusChangeListener(View.OnFocusChangeListener paramOnFocusChangeListener)
  {
    AppMethodBeat.i(72930);
    super.setOnFocusChangeListener(paramOnFocusChangeListener);
    this.jsD = paramOnFocusChangeListener;
    AppMethodBeat.o(72930);
  }
  
  public void setOnInfoListener(a parama)
  {
    this.LzJ = parama;
  }
  
  public void setOnInputValidChangeListener(b paramb)
  {
    this.Lzx = paramb;
  }
  
  public void setPreFilledStr(String paramString)
  {
    AppMethodBeat.i(72911);
    if (!bt.isNullOrNil(paramString))
    {
      this.Lzy.setText(paramString);
      this.Lzy.setVisibility(0);
      AppMethodBeat.o(72911);
      return;
    }
    this.Lzy.setText("");
    this.Lzy.setVisibility(8);
    AppMethodBeat.o(72911);
  }
  
  public void setPreText(String paramString)
  {
    AppMethodBeat.i(72915);
    KeyListener localKeyListener = this.Lzz.getKeyListener();
    this.Lzz.setInputType(1);
    this.Lzz.setKeyListener(null);
    setValStr(paramString);
    this.Lzz.setKeyListener(localKeyListener);
    this.mode = 4;
    AppMethodBeat.o(72915);
  }
  
  public void setShowScanCamera(boolean paramBoolean)
  {
    AppMethodBeat.i(72937);
    this.LzD = paramBoolean;
    fRU();
    AppMethodBeat.o(72937);
  }
  
  public void setTipStr(String paramString)
  {
    AppMethodBeat.i(72910);
    this.iCW.setText(paramString);
    AppMethodBeat.o(72910);
  }
  
  public void setTipTextColor(int paramInt)
  {
    AppMethodBeat.i(72918);
    if (this.iCW != null) {
      this.iCW.setTextColor(paramInt);
    }
    AppMethodBeat.o(72918);
  }
  
  public void setTipWidth(int paramInt)
  {
    AppMethodBeat.i(72907);
    this.LzA = BackwardSupportUtil.b.g(getContext(), paramInt * 1.0F);
    if (this.iCW != null)
    {
      ViewGroup.LayoutParams localLayoutParams = this.iCW.getLayoutParams();
      localLayoutParams.width = this.LzA;
      this.iCW.setLayoutParams(localLayoutParams);
    }
    AppMethodBeat.o(72907);
  }
  
  public void setValStr(String paramString)
  {
    AppMethodBeat.i(72912);
    switch (this.jsI)
    {
    default: 
      this.Lzz.setText(paramString);
      this.Lzz.setSelection(this.Lzz.getText().length());
      AppMethodBeat.o(72912);
      return;
    }
    if ((!bt.isNullOrNil(paramString)) && (paramString.length() <= 5))
    {
      this.Lzz.setSelection(0);
      this.Lzz.setBankcardTailNum(paramString);
      this.jsO = (24 - paramString.length());
      this.Lzz.setFilters(new InputFilter[] { new InputFilter.LengthFilter(this.jsO) });
      AppMethodBeat.o(72912);
      return;
    }
    this.Lzz.setText(paramString);
    this.Lzz.setSelection(this.Lzz.getText().length());
    AppMethodBeat.o(72912);
  }
  
  public static abstract interface a {}
  
  public static abstract interface b {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.wallet_core.ui.EditHintView
 * JD-Core Version:    0.7.0.1
 */