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
import com.tencent.mm.model.v;
import com.tencent.mm.plugin.wxpay.a.a;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bu;
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
  public boolean JNz;
  private b LWm;
  private TextView LWn;
  TenpaySecureEditText LWo;
  private int LWp;
  private int LWq;
  private int LWr;
  private boolean LWs;
  private String LWt;
  private DatePickerDialog LWu;
  private int LWv;
  private int LWw;
  private d LWx;
  private a LWy;
  private int background;
  private int gravity;
  private TextView iFP;
  private int imeOptions;
  private int inputType;
  private String jvA;
  private int jvB;
  private int jvC;
  public boolean jvD;
  private boolean jvF;
  private int jvG;
  private int jvH;
  private View.OnClickListener jvI;
  private View.OnFocusChangeListener jvw;
  private ImageView jvy;
  private String jvz;
  private boolean kVo;
  private int mode;
  
  public EditHintView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public EditHintView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(72906);
    this.jvz = "";
    this.jvA = "";
    this.inputType = 1;
    this.kVo = true;
    this.jvH = -1;
    this.jvG = 1;
    this.gravity = 19;
    this.LWp = -1;
    this.jvB = -1;
    this.jvF = false;
    this.LWq = 1;
    this.LWr = -1;
    this.background = -1;
    this.jvC = -1;
    this.jvD = true;
    this.JNz = true;
    this.LWs = true;
    this.LWt = null;
    this.mode = 0;
    this.LWu = null;
    this.LWv = 0;
    this.LWw = 0;
    this.jvI = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(72904);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/wallet_core/ui/EditHintView$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        if (EditHintView.l(EditHintView.this).getVisibility() == 0)
        {
          if ((!EditHintView.this.jvD) || (bu.isNullOrNil(EditHintView.this.getText()))) {
            break label98;
          }
          EditHintView.this.LWo.ClearInput();
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
    this.LWx = null;
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, a.a.EditHintView, paramInt, 0);
    paramInt = paramAttributeSet.getResourceId(8, 0);
    if (paramInt != 0) {
      this.jvz = paramContext.getString(paramInt);
    }
    paramInt = paramAttributeSet.getResourceId(13, 0);
    if (paramInt != 0) {
      this.jvA = paramContext.getString(paramInt);
    }
    this.inputType = paramAttributeSet.getInteger(4, 1);
    this.jvD = paramAttributeSet.getBoolean(7, true);
    this.gravity = paramAttributeSet.getInt(0, 19);
    this.kVo = paramAttributeSet.getBoolean(2, true);
    this.jvH = paramAttributeSet.getInteger(11, -1);
    this.jvB = paramAttributeSet.getInteger(6, 0);
    this.imeOptions = paramAttributeSet.getInteger(5, 5);
    this.LWr = paramAttributeSet.getColor(10, 2131100711);
    this.background = paramAttributeSet.getResourceId(1, -1);
    this.jvC = paramAttributeSet.getResourceId(9, 2131231995);
    this.jvG = paramAttributeSet.getInteger(12, 1);
    this.JNz = paramAttributeSet.getBoolean(3, true);
    paramAttributeSet.recycle();
    paramContext = z.jV(paramContext).inflate(2131493737, this, true);
    this.LWo = ((TenpaySecureEditText)paramContext.findViewById(2131300744));
    this.iFP = ((TextView)paramContext.findViewById(2131305880));
    this.LWn = ((TextView)paramContext.findViewById(2131303372));
    this.jvy = ((ImageView)paramContext.findViewById(2131301009));
    this.LWo.setImeOptions(this.imeOptions);
    switch (this.jvB)
    {
    case 11: 
    default: 
      this.inputType = 1;
    case 0: 
      fWq();
      this.LWo.setSingleLine(this.JNz);
      if (!this.JNz) {
        this.LWo.setMaxLines(1073741823);
      }
      this.jvy.setOnClickListener(this.jvI);
      this.LWo.addTextChangedListener(new TextWatcher()
      {
        public final void afterTextChanged(Editable paramAnonymousEditable)
        {
          AppMethodBeat.i(72901);
          boolean bool = EditHintView.this.aVz();
          if ((bool != EditHintView.c(EditHintView.this)) && (EditHintView.d(EditHintView.this) != null))
          {
            ae.d("MicroMsg.EditHintView", "View:" + EditHintView.e(EditHintView.this) + ", editType:" + EditHintView.f(EditHintView.this) + " inputValid change to " + bool);
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
          if ((EditHintView.a(EditHintView.this) == 4) && (EditHintView.this.aVz()))
          {
            EditHintView.b(EditHintView.this);
            EditHintView.this.LWo.ClearInput();
          }
          AppMethodBeat.o(72900);
        }
        
        public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      });
      this.LWo.setOnFocusChangeListener(this);
      if (!bu.isNullOrNil(this.jvz)) {
        this.LWo.setHint(this.jvz);
      }
      if (!bu.isNullOrNil(this.jvA)) {
        this.iFP.setText(this.jvA);
      }
      this.LWo.setGravity(this.gravity);
      if (this.inputType == 2)
      {
        this.LWo.setKeyListener(new NumberKeyListener()
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
        if (this.jvH != -1) {
          this.LWo.setFilters(new InputFilter[] { new InputFilter.LengthFilter(this.jvH) });
        }
        super.setEnabled(true);
        super.setClickable(true);
        if (!this.kVo)
        {
          this.LWo.setEnabled(false);
          this.LWo.setTextColor(getResources().getColor(this.LWr));
          this.LWo.setFocusable(false);
          this.LWo.setClickable(false);
          this.LWo.setBackgroundResource(2131234429);
          setBackgroundResource(2131232867);
        }
        if (this.jvD) {
          break label1307;
        }
        this.jvF = true;
        this.LWo.setEnabled(false);
        this.LWo.setTextColor(getResources().getColor(2131100548));
        this.LWo.setFocusable(false);
        this.LWo.setClickable(false);
        this.LWo.setBackgroundResource(2131234429);
        setBackgroundResource(2131231818);
      }
      break;
    }
    for (;;)
    {
      if (this.background > 0) {
        setBackgroundResource(this.background);
      }
      if ((this.iFP != null) && (this.LWp != -1))
      {
        paramContext = this.iFP.getLayoutParams();
        paramContext.width = this.LWp;
        this.iFP.setLayoutParams(paramContext);
      }
      if (v.aAR()) {
        this.LWo.setSecureEncrypt(new com.tencent.mm.wallet_core.a.a(getEncryptType()));
      }
      AppMethodBeat.o(72906);
      return;
      this.jvH = 25;
      this.LWo.setIsBankcardFormat(true);
      this.inputType = 2;
      break;
      this.jvH = 6;
      this.iFP.setVisibility(8);
      this.LWo.setIsPasswordFormat(true, true);
      this.LWo.setImeOptions(6);
      this.inputType = 128;
      break;
      this.jvH = 3;
      this.iFP.setVisibility(8);
      this.LWo.setIsCvvPaymentFormat(true);
      this.LWo.setImeOptions(6);
      this.inputType = 128;
      break;
      this.jvH = 4;
      this.iFP.setVisibility(8);
      this.LWo.setIsCvv4PaymentFormat(true);
      this.LWo.setImeOptions(6);
      this.inputType = 128;
      break;
      this.jvH = 30;
      this.inputType = 3;
      break;
      this.jvH = 18;
      this.inputType = 4;
      break;
      this.jvH = 4;
      this.inputType = 2;
      break;
      this.jvD = false;
      this.LWo.setIsValidThru(true);
      setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(72903);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/wallet_core/ui/EditHintView$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
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
                  EditHintView.a(EditHintView.this, EditHintView.this.aVz());
                  if (EditHintView.d(EditHintView.this) != null)
                  {
                    ae.d("MicroMsg.EditHintView", "View:" + EditHintView.e(EditHintView.this) + ", editType:" + EditHintView.f(EditHintView.this) + " inputValid change to " + EditHintView.c(EditHintView.this));
                    EditHintView.d(EditHintView.this);
                    EditHintView.c(EditHintView.this);
                  }
                  AppMethodBeat.o(72902);
                  return;
                }
                paramAnonymous2DatePicker = new DecimalFormat("00");
                if (v.aAR()) {
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
      this.jvH = 6;
      this.iFP.setVisibility(8);
      this.inputType = 2;
      break;
      this.inputType = 32;
      break;
      if ((this.jvD) || (!this.kVo)) {
        break;
      }
      break;
      this.jvH = 12;
      this.LWo.setIsMoneyAmountFormat(true);
      break;
      this.LWo.setIsSecurityAnswerFormat(true);
      break;
      if (this.inputType == 4)
      {
        this.LWo.setKeyListener(new NumberKeyListener()
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
        this.LWo.setTransformationMethod(PasswordTransformationMethod.getInstance());
        this.LWo.setKeyListener(new NumberKeyListener()
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
        this.LWo.setRawInputType(18);
        break label638;
      }
      if (this.inputType == 3)
      {
        this.LWo.setKeyListener(new NumberKeyListener()
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
      this.LWo.setInputType(this.inputType);
      break label638;
      label1307:
      this.jvF = false;
      this.LWo.setBackgroundResource(this.jvC);
      setBackgroundResource(2131234429);
    }
  }
  
  private void fWq()
  {
    AppMethodBeat.i(72931);
    if ((this.jvB == 7) || (this.jvB == 14) || (this.jvB == 15))
    {
      AppMethodBeat.o(72931);
      return;
    }
    if ((this.jvD) && (!bu.isNullOrNil(getText())))
    {
      this.jvy.setVisibility(0);
      this.jvy.setImageResource(2131232862);
      AppMethodBeat.o(72931);
      return;
    }
    switch (this.jvB)
    {
    case 2: 
    case 5: 
    case 6: 
    case 7: 
    case 8: 
    default: 
      this.jvy.setVisibility(8);
      AppMethodBeat.o(72931);
      return;
    case 3: 
    case 4: 
    case 9: 
    case 10: 
      this.jvy.setVisibility(0);
      this.jvy.setImageResource(2131233568);
      AppMethodBeat.o(72931);
      return;
    }
    if (this.LWs)
    {
      this.jvy.setVisibility(0);
      this.jvy.setImageResource(2131691405);
      AppMethodBeat.o(72931);
      return;
    }
    this.jvy.setVisibility(8);
    AppMethodBeat.o(72931);
  }
  
  private int getEncryptType()
  {
    switch (this.jvB)
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
    this.jvy.getHitRect(localRect);
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
    KeyListener localKeyListener = this.LWo.getKeyListener();
    this.LWo.setKeyListener(null);
    setEnabled(false);
    setClickable(false);
    setValStr(paramString);
    this.LWo.setKeyListener(localKeyListener);
    AppMethodBeat.o(72914);
  }
  
  public final boolean aVz()
  {
    AppMethodBeat.i(72923);
    if ((!this.jvD) && (!this.kVo))
    {
      AppMethodBeat.o(72923);
      return true;
    }
    boolean bool;
    switch (this.jvB)
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
      if (this.LWo.getInputLength() >= this.jvG)
      {
        AppMethodBeat.o(72923);
        return true;
      }
      break;
    case 1: 
      bool = this.LWo.isBankcardNum();
      AppMethodBeat.o(72923);
      return bool;
    case 9: 
      bool = this.LWo.isPhoneNum();
      AppMethodBeat.o(72923);
      return bool;
    case 4: 
      if (this.LWo.getInputLength() > 0)
      {
        AppMethodBeat.o(72923);
        return true;
      }
      AppMethodBeat.o(72923);
      return false;
    case 5: 
      bool = this.LWo.isAreaIDCardNum(this.LWq);
      AppMethodBeat.o(72923);
      return bool;
    case 7: 
    case 17: 
      if (this.LWo.getInputLength() == 6)
      {
        AppMethodBeat.o(72923);
        return true;
      }
      AppMethodBeat.o(72923);
      return false;
    case 14: 
      if (this.LWo.getInputLength() == 3)
      {
        AppMethodBeat.o(72923);
        return true;
      }
      AppMethodBeat.o(72923);
      return false;
    case 15: 
      if (this.LWo.getInputLength() == 4)
      {
        AppMethodBeat.o(72923);
        return true;
      }
      AppMethodBeat.o(72923);
      return false;
    case 8: 
      bool = bu.aSp(this.LWo.getText().toString());
      AppMethodBeat.o(72923);
      return bool;
    case 12: 
      bool = this.LWo.isMoneyAmount();
      AppMethodBeat.o(72923);
      return bool;
    }
    AppMethodBeat.o(72923);
    return false;
  }
  
  public String get3DesEncrptData()
  {
    AppMethodBeat.i(72924);
    String str = this.LWo.get3DesEncrptData();
    AppMethodBeat.o(72924);
    return str;
  }
  
  public String getMD5Value()
  {
    AppMethodBeat.i(72922);
    if (this.jvB == 3) {}
    for (String str = bu.bI(this.LWt, "").replace("/", "");; str = this.LWo.getText().toString())
    {
      str = aj.ej(str);
      AppMethodBeat.o(72922);
      return str;
    }
  }
  
  public String getText()
  {
    AppMethodBeat.i(72921);
    switch (this.jvB)
    {
    case 11: 
    case 12: 
    default: 
      localObject = bu.bI(this.LWo.getText().toString(), "");
      AppMethodBeat.o(72921);
      return localObject;
    case 1: 
    case 13: 
    case 16: 
      localObject = this.LWo;
      com.tencent.mm.wallet_core.b.fVf();
      localObject = ((TenpaySecureEditText)localObject).getEncryptDataWithHash(false, com.tencent.mm.wallet_core.b.fVg());
      AppMethodBeat.o(72921);
      return localObject;
    case 4: 
    case 14: 
    case 15: 
      localObject = this.LWo.get3DesEncrptData();
      AppMethodBeat.o(72921);
      return localObject;
    case 5: 
      localObject = this.LWo.get3DesEncrptData();
      AppMethodBeat.o(72921);
      return localObject;
    case 3: 
      localObject = bu.bI(this.LWt, "").replace("/", "");
      AppMethodBeat.o(72921);
      return localObject;
    case 2: 
    case 9: 
      localObject = bu.bI(this.LWo.getText().toString(), "");
      AppMethodBeat.o(72921);
      return localObject;
    case 0: 
    case 8: 
    case 10: 
      localObject = bu.bI(this.LWo.getText().toString(), "");
      AppMethodBeat.o(72921);
      return localObject;
    case 6: 
      localObject = this.LWo.get3DesVerifyCode();
      AppMethodBeat.o(72921);
      return localObject;
    }
    Object localObject = this.LWo;
    com.tencent.mm.wallet_core.b.fVf();
    localObject = ((TenpaySecureEditText)localObject).getEncryptDataWithHash(true, com.tencent.mm.wallet_core.b.fVg());
    AppMethodBeat.o(72921);
    return localObject;
  }
  
  public void onFocusChange(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(72932);
    if (this.jvw != null) {
      this.jvw.onFocusChange(this, paramBoolean);
    }
    ae.d("MicroMsg.EditHintView", "View:" + this.jvA + ", editType:" + this.jvB + " onFocusChange to " + paramBoolean);
    if (!this.jvF)
    {
      this.iFP.setEnabled(false);
      AppMethodBeat.o(72932);
      return;
    }
    this.iFP.setEnabled(true);
    AppMethodBeat.o(72932);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(72928);
    int i;
    if (!this.jvD)
    {
      if (this.jvy.getVisibility() != 0) {
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
    if ((this.jvB != 7) && (this.jvB != 17) && (this.jvB != 14))
    {
      j = paramInt1;
      i = paramInt2;
      if (this.jvB != 15) {}
    }
    else
    {
      setMeasuredDimension(getDefaultSize(BackwardSupportUtil.b.h(getContext(), 960.0F), paramInt1), getDefaultSize(BackwardSupportUtil.b.h(getContext(), 720.0F), paramInt2));
      paramInt2 = getMeasuredWidth();
      if ((this.jvB != 7) && (this.jvB != 17)) {
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
      if (this.jvB == 14) {
        paramInt1 = paramInt2 / 3;
      } else {
        paramInt1 = paramInt2 / 4;
      }
    }
  }
  
  public void set3DesValStr(String paramString)
  {
    AppMethodBeat.i(72913);
    switch (this.jvB)
    {
    default: 
      this.LWo.setText(paramString);
      this.LWo.setSelection(this.LWo.getText().length());
      AppMethodBeat.o(72913);
      return;
    }
    if ((!bu.isNullOrNil(paramString)) && (paramString.length() <= 5))
    {
      this.LWo.setSelection(0);
      this.LWo.set3DesEncrptData(paramString);
      this.jvH = (24 - paramString.length());
      this.LWo.setFilters(new InputFilter[] { new InputFilter.LengthFilter(this.jvH) });
      AppMethodBeat.o(72913);
      return;
    }
    this.LWo.set3DesEncrptData(paramString);
    this.LWo.setSelection(this.LWo.getText().length());
    AppMethodBeat.o(72913);
  }
  
  public void setClickable(boolean paramBoolean)
  {
    AppMethodBeat.i(72927);
    super.setClickable(paramBoolean);
    this.kVo = paramBoolean;
    if (!paramBoolean)
    {
      this.LWo.setEnabled(false);
      if (!this.jvD) {
        this.LWo.setTextColor(getResources().getColor(2131100544));
      }
      for (;;)
      {
        this.LWo.setFocusable(false);
        this.LWo.setClickable(false);
        AppMethodBeat.o(72927);
        return;
        this.LWo.setTextColor(getResources().getColor(this.LWr));
      }
    }
    this.LWo.setEnabled(true);
    if (!this.jvD) {
      this.LWo.setTextColor(getResources().getColor(2131100548));
    }
    for (;;)
    {
      this.LWo.setFocusable(true);
      this.LWo.setClickable(true);
      AppMethodBeat.o(72927);
      return;
      this.LWo.setTextColor(getResources().getColor(this.LWr));
    }
  }
  
  public void setEditBG(int paramInt)
  {
    AppMethodBeat.i(72916);
    if (this.LWo != null) {
      this.LWo.setBackgroundResource(paramInt);
    }
    AppMethodBeat.o(72916);
  }
  
  public void setEllipsize(TextUtils.TruncateAt paramTruncateAt)
  {
    AppMethodBeat.i(72925);
    this.LWo.setEllipsize(paramTruncateAt);
    AppMethodBeat.o(72925);
  }
  
  public void setEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(72926);
    super.setEnabled(paramBoolean);
    this.jvD = paramBoolean;
    this.jvy.setEnabled(true);
    AppMethodBeat.o(72926);
  }
  
  public void setEncryptType(int paramInt)
  {
    AppMethodBeat.i(72917);
    if (v.aAR()) {
      this.LWo.setSecureEncrypt(new com.tencent.mm.wallet_core.a.a(paramInt));
    }
    AppMethodBeat.o(72917);
  }
  
  public void setHintStr(String paramString)
  {
    AppMethodBeat.i(72909);
    this.LWo.setHint(paramString);
    AppMethodBeat.o(72909);
  }
  
  public void setIdentifyCardType(int paramInt)
  {
    AppMethodBeat.i(72920);
    this.LWq = paramInt;
    if (paramInt == 1)
    {
      this.LWo.setKeyListener(new NumberKeyListener()
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
    this.LWo.setInputType(1);
    AppMethodBeat.o(72920);
  }
  
  public void setImeOptions(int paramInt)
  {
    AppMethodBeat.i(72933);
    this.LWo.setImeOptions(paramInt);
    AppMethodBeat.o(72933);
  }
  
  public void setInfoIvVisible(int paramInt)
  {
    AppMethodBeat.i(72935);
    this.jvy.setVisibility(paramInt);
    AppMethodBeat.o(72935);
  }
  
  public void setMaxLen(int paramInt)
  {
    AppMethodBeat.i(72919);
    if (paramInt != -1)
    {
      this.jvH = paramInt;
      this.LWo.setFilters(new InputFilter[] { new InputFilter.LengthFilter(paramInt) });
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
    this.LWo.setOnEditorActionListener(paramOnEditorActionListener);
    AppMethodBeat.o(72934);
  }
  
  public void setOnFocusChangeListener(View.OnFocusChangeListener paramOnFocusChangeListener)
  {
    AppMethodBeat.i(72930);
    super.setOnFocusChangeListener(paramOnFocusChangeListener);
    this.jvw = paramOnFocusChangeListener;
    AppMethodBeat.o(72930);
  }
  
  public void setOnInfoListener(a parama)
  {
    this.LWy = parama;
  }
  
  public void setOnInputValidChangeListener(b paramb)
  {
    this.LWm = paramb;
  }
  
  public void setPreFilledStr(String paramString)
  {
    AppMethodBeat.i(72911);
    if (!bu.isNullOrNil(paramString))
    {
      this.LWn.setText(paramString);
      this.LWn.setVisibility(0);
      AppMethodBeat.o(72911);
      return;
    }
    this.LWn.setText("");
    this.LWn.setVisibility(8);
    AppMethodBeat.o(72911);
  }
  
  public void setPreText(String paramString)
  {
    AppMethodBeat.i(72915);
    KeyListener localKeyListener = this.LWo.getKeyListener();
    this.LWo.setInputType(1);
    this.LWo.setKeyListener(null);
    setValStr(paramString);
    this.LWo.setKeyListener(localKeyListener);
    this.mode = 4;
    AppMethodBeat.o(72915);
  }
  
  public void setShowScanCamera(boolean paramBoolean)
  {
    AppMethodBeat.i(72937);
    this.LWs = paramBoolean;
    fWq();
    AppMethodBeat.o(72937);
  }
  
  public void setTipStr(String paramString)
  {
    AppMethodBeat.i(72910);
    this.iFP.setText(paramString);
    AppMethodBeat.o(72910);
  }
  
  public void setTipTextColor(int paramInt)
  {
    AppMethodBeat.i(72918);
    if (this.iFP != null) {
      this.iFP.setTextColor(paramInt);
    }
    AppMethodBeat.o(72918);
  }
  
  public void setTipWidth(int paramInt)
  {
    AppMethodBeat.i(72907);
    this.LWp = BackwardSupportUtil.b.h(getContext(), paramInt * 1.0F);
    if (this.iFP != null)
    {
      ViewGroup.LayoutParams localLayoutParams = this.iFP.getLayoutParams();
      localLayoutParams.width = this.LWp;
      this.iFP.setLayoutParams(localLayoutParams);
    }
    AppMethodBeat.o(72907);
  }
  
  public void setValStr(String paramString)
  {
    AppMethodBeat.i(72912);
    switch (this.jvB)
    {
    default: 
      this.LWo.setText(paramString);
      this.LWo.setSelection(this.LWo.getText().length());
      AppMethodBeat.o(72912);
      return;
    }
    if ((!bu.isNullOrNil(paramString)) && (paramString.length() <= 5))
    {
      this.LWo.setSelection(0);
      this.LWo.setBankcardTailNum(paramString);
      this.jvH = (24 - paramString.length());
      this.LWo.setFilters(new InputFilter[] { new InputFilter.LengthFilter(this.jvH) });
      AppMethodBeat.o(72912);
      return;
    }
    this.LWo.setText(paramString);
    this.LWo.setSelection(this.LWo.getText().length());
    AppMethodBeat.o(72912);
  }
  
  public static abstract interface a {}
  
  public static abstract interface b {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.wallet_core.ui.EditHintView
 * JD-Core Version:    0.7.0.1
 */