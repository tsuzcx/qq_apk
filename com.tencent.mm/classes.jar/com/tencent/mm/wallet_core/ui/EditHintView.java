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
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.wxpay.a.a;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.BitmapFactory;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.aa;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.a.d;
import com.tencent.mm.ui.widget.e;
import com.tenpay.android.wechat.TenpaySecureEditText;
import java.text.DecimalFormat;
import java.util.Calendar;

@Deprecated
public class EditHintView
  extends RelativeLayout
  implements View.OnFocusChangeListener
{
  public boolean OYB;
  private b Rvc;
  private TextView Rvd;
  TenpaySecureEditText Rve;
  private int Rvf;
  private int Rvg;
  private int Rvh;
  private boolean Rvi;
  private String Rvj;
  private DatePickerDialog Rvk;
  private int Rvl;
  private int Rvm;
  private d Rvn;
  private a Rvo;
  private int background;
  private int gravity;
  private int imeOptions;
  private int inputType;
  private TextView jBS;
  private View.OnFocusChangeListener ktK;
  private ImageView ktM;
  private String ktN;
  private String ktO;
  private int ktP;
  private int ktQ;
  public boolean ktR;
  private boolean ktT;
  private int ktU;
  private int ktV;
  private View.OnClickListener ktW;
  private boolean maw;
  private int mode;
  
  public EditHintView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public EditHintView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(72906);
    this.ktN = "";
    this.ktO = "";
    this.inputType = 1;
    this.maw = true;
    this.ktV = -1;
    this.ktU = 1;
    this.gravity = 19;
    this.Rvf = -1;
    this.ktP = -1;
    this.ktT = false;
    this.Rvg = 1;
    this.Rvh = -1;
    this.background = -1;
    this.ktQ = -1;
    this.ktR = true;
    this.OYB = true;
    this.Rvi = true;
    this.Rvj = null;
    this.mode = 0;
    this.Rvk = null;
    this.Rvl = 0;
    this.Rvm = 0;
    this.ktW = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(72904);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/wallet_core/ui/EditHintView$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        if (EditHintView.l(EditHintView.this).getVisibility() == 0)
        {
          if ((!EditHintView.this.ktR) || (Util.isNullOrNil(EditHintView.this.getText()))) {
            break label98;
          }
          EditHintView.this.Rve.ClearInput();
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
    this.Rvn = null;
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, a.a.EditHintView, paramInt, 0);
    paramInt = paramAttributeSet.getResourceId(8, 0);
    if (paramInt != 0) {
      this.ktN = paramContext.getString(paramInt);
    }
    paramInt = paramAttributeSet.getResourceId(13, 0);
    if (paramInt != 0) {
      this.ktO = paramContext.getString(paramInt);
    }
    this.inputType = paramAttributeSet.getInteger(4, 1);
    this.ktR = paramAttributeSet.getBoolean(7, true);
    this.gravity = paramAttributeSet.getInt(0, 19);
    this.maw = paramAttributeSet.getBoolean(2, true);
    this.ktV = paramAttributeSet.getInteger(11, -1);
    this.ktP = paramAttributeSet.getInteger(6, 0);
    this.imeOptions = paramAttributeSet.getInteger(5, 5);
    this.Rvh = paramAttributeSet.getColor(10, 2131100904);
    this.background = paramAttributeSet.getResourceId(1, -1);
    this.ktQ = paramAttributeSet.getResourceId(9, 2131232086);
    this.ktU = paramAttributeSet.getInteger(12, 1);
    this.OYB = paramAttributeSet.getBoolean(3, true);
    paramAttributeSet.recycle();
    paramContext = aa.jQ(paramContext).inflate(2131493872, this, true);
    this.Rve = ((TenpaySecureEditText)paramContext.findViewById(2131302331));
    this.jBS = ((TextView)paramContext.findViewById(2131309163));
    this.Rvd = ((TextView)paramContext.findViewById(2131306085));
    this.ktM = ((ImageView)paramContext.findViewById(2131302653));
    this.Rve.setImeOptions(this.imeOptions);
    switch (this.ktP)
    {
    case 11: 
    default: 
      this.inputType = 1;
    case 0: 
      hhO();
      this.Rve.setSingleLine(this.OYB);
      if (!this.OYB) {
        this.Rve.setMaxLines(1073741823);
      }
      this.ktM.setOnClickListener(this.ktW);
      this.Rve.addTextChangedListener(new TextWatcher()
      {
        public final void afterTextChanged(Editable paramAnonymousEditable)
        {
          AppMethodBeat.i(72901);
          boolean bool = EditHintView.this.bql();
          if ((bool != EditHintView.c(EditHintView.this)) && (EditHintView.d(EditHintView.this) != null))
          {
            Log.d("MicroMsg.EditHintView", "View:" + EditHintView.e(EditHintView.this) + ", editType:" + EditHintView.f(EditHintView.this) + " inputValid change to " + bool);
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
          if ((EditHintView.a(EditHintView.this) == 4) && (EditHintView.this.bql()))
          {
            EditHintView.b(EditHintView.this);
            EditHintView.this.Rve.ClearInput();
          }
          AppMethodBeat.o(72900);
        }
        
        public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      });
      this.Rve.setOnFocusChangeListener(this);
      if (!Util.isNullOrNil(this.ktN)) {
        this.Rve.setHint(this.ktN);
      }
      if (!Util.isNullOrNil(this.ktO)) {
        this.jBS.setText(this.ktO);
      }
      this.Rve.setGravity(this.gravity);
      if (this.inputType == 2)
      {
        this.Rve.setKeyListener(new NumberKeyListener()
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
        if (this.ktV != -1) {
          this.Rve.setFilters(new InputFilter[] { new InputFilter.LengthFilter(this.ktV) });
        }
        super.setEnabled(true);
        super.setClickable(true);
        if (!this.maw)
        {
          this.Rve.setEnabled(false);
          this.Rve.setTextColor(getResources().getColor(this.Rvh));
          this.Rve.setFocusable(false);
          this.Rve.setClickable(false);
          this.Rve.setBackgroundResource(2131235359);
          setBackgroundResource(2131233327);
        }
        if (this.ktR) {
          break label1307;
        }
        this.ktT = true;
        this.Rve.setEnabled(false);
        this.Rve.setTextColor(getResources().getColor(2131100687));
        this.Rve.setFocusable(false);
        this.Rve.setClickable(false);
        this.Rve.setBackgroundResource(2131235359);
        setBackgroundResource(2131231898);
      }
      break;
    }
    for (;;)
    {
      if (this.background > 0) {
        setBackgroundResource(this.background);
      }
      if ((this.jBS != null) && (this.Rvf != -1))
      {
        paramContext = this.jBS.getLayoutParams();
        paramContext.width = this.Rvf;
        this.jBS.setLayoutParams(paramContext);
      }
      if (z.aUo()) {
        this.Rve.setSecureEncrypt(new com.tencent.mm.wallet_core.a.a(getEncryptType()));
      }
      AppMethodBeat.o(72906);
      return;
      this.ktV = 25;
      this.Rve.setIsBankcardFormat(true);
      this.inputType = 2;
      break;
      this.ktV = 6;
      this.jBS.setVisibility(8);
      this.Rve.setIsPasswordFormat(true, true);
      this.Rve.setImeOptions(6);
      this.inputType = 128;
      break;
      this.ktV = 3;
      this.jBS.setVisibility(8);
      this.Rve.setIsCvvPaymentFormat(true);
      this.Rve.setImeOptions(6);
      this.inputType = 128;
      break;
      this.ktV = 4;
      this.jBS.setVisibility(8);
      this.Rve.setIsCvv4PaymentFormat(true);
      this.Rve.setImeOptions(6);
      this.inputType = 128;
      break;
      this.ktV = 30;
      this.inputType = 3;
      break;
      this.ktV = 18;
      this.inputType = 4;
      break;
      this.ktV = 4;
      this.inputType = 2;
      break;
      this.ktR = false;
      this.Rve.setIsValidThru(true);
      setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(72903);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/wallet_core/ui/EditHintView$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
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
                  h.c(EditHintView.this.getContext(), EditHintView.this.getContext().getString(2131767693), null, true);
                  EditHintView.a(EditHintView.this, EditHintView.this.bql());
                  if (EditHintView.d(EditHintView.this) != null)
                  {
                    Log.d("MicroMsg.EditHintView", "View:" + EditHintView.e(EditHintView.this) + ", editType:" + EditHintView.f(EditHintView.this) + " inputValid change to " + EditHintView.c(EditHintView.this));
                    EditHintView.d(EditHintView.this);
                    EditHintView.c(EditHintView.this);
                  }
                  AppMethodBeat.o(72902);
                  return;
                }
                paramAnonymous2DatePicker = new DecimalFormat("00");
                if (z.aUo()) {
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
      this.ktV = 6;
      this.jBS.setVisibility(8);
      this.inputType = 2;
      break;
      this.inputType = 32;
      break;
      if ((this.ktR) || (!this.maw)) {
        break;
      }
      break;
      this.ktV = 12;
      this.Rve.setIsMoneyAmountFormat(true);
      break;
      this.Rve.setIsSecurityAnswerFormat(true);
      break;
      if (this.inputType == 4)
      {
        this.Rve.setKeyListener(new NumberKeyListener()
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
        this.Rve.setTransformationMethod(PasswordTransformationMethod.getInstance());
        this.Rve.setKeyListener(new NumberKeyListener()
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
        this.Rve.setRawInputType(18);
        break label638;
      }
      if (this.inputType == 3)
      {
        this.Rve.setKeyListener(new NumberKeyListener()
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
      this.Rve.setInputType(this.inputType);
      break label638;
      label1307:
      this.ktT = false;
      this.Rve.setBackgroundResource(this.ktQ);
      setBackgroundResource(2131235359);
    }
  }
  
  private int getEncryptType()
  {
    switch (this.ktP)
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
    this.ktM.getHitRect(localRect);
    localRect.left -= 50;
    localRect.right += 50;
    localRect.top -= 25;
    localRect.bottom += 25;
    AppMethodBeat.o(72936);
    return localRect;
  }
  
  private void hhO()
  {
    AppMethodBeat.i(72931);
    if ((this.ktP == 7) || (this.ktP == 14) || (this.ktP == 15))
    {
      AppMethodBeat.o(72931);
      return;
    }
    if ((this.ktR) && (!Util.isNullOrNil(getText())))
    {
      this.ktM.setVisibility(0);
      this.ktM.setImageResource(2131233321);
      AppMethodBeat.o(72931);
      return;
    }
    switch (this.ktP)
    {
    case 2: 
    case 5: 
    case 6: 
    case 7: 
    case 8: 
    default: 
      this.ktM.setVisibility(8);
      AppMethodBeat.o(72931);
      return;
    case 3: 
    case 4: 
    case 9: 
    case 10: 
      this.ktM.setVisibility(0);
      this.ktM.setImageResource(2131234375);
      AppMethodBeat.o(72931);
      return;
    }
    if (this.Rvi)
    {
      this.ktM.setVisibility(0);
      this.ktM.setImageResource(2131691739);
      AppMethodBeat.o(72931);
      return;
    }
    this.ktM.setVisibility(8);
    AppMethodBeat.o(72931);
  }
  
  private void setValStrForce(String paramString)
  {
    AppMethodBeat.i(72914);
    KeyListener localKeyListener = this.Rve.getKeyListener();
    this.Rve.setKeyListener(null);
    setEnabled(false);
    setClickable(false);
    setValStr(paramString);
    this.Rve.setKeyListener(localKeyListener);
    AppMethodBeat.o(72914);
  }
  
  public final boolean bql()
  {
    AppMethodBeat.i(72923);
    if ((!this.ktR) && (!this.maw))
    {
      AppMethodBeat.o(72923);
      return true;
    }
    boolean bool;
    switch (this.ktP)
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
      if (this.Rve.getInputLength() >= this.ktU)
      {
        AppMethodBeat.o(72923);
        return true;
      }
      break;
    case 1: 
      bool = this.Rve.isBankcardNum();
      AppMethodBeat.o(72923);
      return bool;
    case 9: 
      bool = this.Rve.isPhoneNum();
      AppMethodBeat.o(72923);
      return bool;
    case 4: 
      if (this.Rve.getInputLength() > 0)
      {
        AppMethodBeat.o(72923);
        return true;
      }
      AppMethodBeat.o(72923);
      return false;
    case 5: 
      bool = this.Rve.isAreaIDCardNum(this.Rvg);
      AppMethodBeat.o(72923);
      return bool;
    case 7: 
    case 17: 
      if (this.Rve.getInputLength() == 6)
      {
        AppMethodBeat.o(72923);
        return true;
      }
      AppMethodBeat.o(72923);
      return false;
    case 14: 
      if (this.Rve.getInputLength() == 3)
      {
        AppMethodBeat.o(72923);
        return true;
      }
      AppMethodBeat.o(72923);
      return false;
    case 15: 
      if (this.Rve.getInputLength() == 4)
      {
        AppMethodBeat.o(72923);
        return true;
      }
      AppMethodBeat.o(72923);
      return false;
    case 8: 
      bool = Util.isValidEmail(this.Rve.getText().toString());
      AppMethodBeat.o(72923);
      return bool;
    case 12: 
      bool = this.Rve.isMoneyAmount();
      AppMethodBeat.o(72923);
      return bool;
    }
    AppMethodBeat.o(72923);
    return false;
  }
  
  public String get3DesEncrptData()
  {
    AppMethodBeat.i(72924);
    String str = this.Rve.get3DesEncrptData();
    AppMethodBeat.o(72924);
    return str;
  }
  
  public String getMD5Value()
  {
    AppMethodBeat.i(72922);
    if (this.ktP == 3) {}
    for (String str = Util.nullAs(this.Rvj, "").replace("/", "");; str = this.Rve.getText().toString())
    {
      str = MD5Util.getMD5String(str);
      AppMethodBeat.o(72922);
      return str;
    }
  }
  
  public String getText()
  {
    AppMethodBeat.i(72921);
    switch (this.ktP)
    {
    case 11: 
    case 12: 
    default: 
      localObject = Util.nullAs(this.Rve.getText().toString(), "");
      AppMethodBeat.o(72921);
      return localObject;
    case 1: 
    case 13: 
    case 16: 
      localObject = this.Rve;
      com.tencent.mm.wallet_core.b.hgC();
      localObject = ((TenpaySecureEditText)localObject).getEncryptDataWithHash(false, com.tencent.mm.wallet_core.b.hgD());
      AppMethodBeat.o(72921);
      return localObject;
    case 4: 
    case 14: 
    case 15: 
      localObject = this.Rve.get3DesEncrptData();
      AppMethodBeat.o(72921);
      return localObject;
    case 5: 
      localObject = this.Rve.get3DesEncrptData();
      AppMethodBeat.o(72921);
      return localObject;
    case 3: 
      localObject = Util.nullAs(this.Rvj, "").replace("/", "");
      AppMethodBeat.o(72921);
      return localObject;
    case 2: 
    case 9: 
      localObject = Util.nullAs(this.Rve.getText().toString(), "");
      AppMethodBeat.o(72921);
      return localObject;
    case 0: 
    case 8: 
    case 10: 
      localObject = Util.nullAs(this.Rve.getText().toString(), "");
      AppMethodBeat.o(72921);
      return localObject;
    case 6: 
      localObject = this.Rve.get3DesVerifyCode();
      AppMethodBeat.o(72921);
      return localObject;
    }
    Object localObject = this.Rve;
    com.tencent.mm.wallet_core.b.hgC();
    localObject = ((TenpaySecureEditText)localObject).getEncryptDataWithHash(true, com.tencent.mm.wallet_core.b.hgD());
    AppMethodBeat.o(72921);
    return localObject;
  }
  
  public void onFocusChange(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(72932);
    if (this.ktK != null) {
      this.ktK.onFocusChange(this, paramBoolean);
    }
    Log.d("MicroMsg.EditHintView", "View:" + this.ktO + ", editType:" + this.ktP + " onFocusChange to " + paramBoolean);
    if (!this.ktT)
    {
      this.jBS.setEnabled(false);
      AppMethodBeat.o(72932);
      return;
    }
    this.jBS.setEnabled(true);
    AppMethodBeat.o(72932);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(72928);
    int i;
    if (!this.ktR)
    {
      if (this.ktM.getVisibility() != 0) {
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
    if ((this.ktP != 7) && (this.ktP != 17) && (this.ktP != 14))
    {
      j = paramInt1;
      i = paramInt2;
      if (this.ktP != 15) {}
    }
    else
    {
      setMeasuredDimension(getDefaultSize(BackwardSupportUtil.BitmapFactory.fromDPToPix(getContext(), 960.0F), paramInt1), getDefaultSize(BackwardSupportUtil.BitmapFactory.fromDPToPix(getContext(), 720.0F), paramInt2));
      paramInt2 = getMeasuredWidth();
      if ((this.ktP != 7) && (this.ktP != 17)) {
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
      if (this.ktP == 14) {
        paramInt1 = paramInt2 / 3;
      } else {
        paramInt1 = paramInt2 / 4;
      }
    }
  }
  
  public void set3DesValStr(String paramString)
  {
    AppMethodBeat.i(72913);
    switch (this.ktP)
    {
    default: 
      this.Rve.setText(paramString);
      this.Rve.setSelection(this.Rve.getText().length());
      AppMethodBeat.o(72913);
      return;
    }
    if ((!Util.isNullOrNil(paramString)) && (paramString.length() <= 5))
    {
      this.Rve.setSelection(0);
      this.Rve.set3DesEncrptData(paramString);
      this.ktV = (24 - paramString.length());
      this.Rve.setFilters(new InputFilter[] { new InputFilter.LengthFilter(this.ktV) });
      AppMethodBeat.o(72913);
      return;
    }
    this.Rve.set3DesEncrptData(paramString);
    this.Rve.setSelection(this.Rve.getText().length());
    AppMethodBeat.o(72913);
  }
  
  public void setClickable(boolean paramBoolean)
  {
    AppMethodBeat.i(72927);
    super.setClickable(paramBoolean);
    this.maw = paramBoolean;
    if (!paramBoolean)
    {
      this.Rve.setEnabled(false);
      if (!this.ktR) {
        this.Rve.setTextColor(getResources().getColor(2131100682));
      }
      for (;;)
      {
        this.Rve.setFocusable(false);
        this.Rve.setClickable(false);
        AppMethodBeat.o(72927);
        return;
        this.Rve.setTextColor(getResources().getColor(this.Rvh));
      }
    }
    this.Rve.setEnabled(true);
    if (!this.ktR) {
      this.Rve.setTextColor(getResources().getColor(2131100687));
    }
    for (;;)
    {
      this.Rve.setFocusable(true);
      this.Rve.setClickable(true);
      AppMethodBeat.o(72927);
      return;
      this.Rve.setTextColor(getResources().getColor(this.Rvh));
    }
  }
  
  public void setEditBG(int paramInt)
  {
    AppMethodBeat.i(72916);
    if (this.Rve != null) {
      this.Rve.setBackgroundResource(paramInt);
    }
    AppMethodBeat.o(72916);
  }
  
  public void setEllipsize(TextUtils.TruncateAt paramTruncateAt)
  {
    AppMethodBeat.i(72925);
    this.Rve.setEllipsize(paramTruncateAt);
    AppMethodBeat.o(72925);
  }
  
  public void setEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(72926);
    super.setEnabled(paramBoolean);
    this.ktR = paramBoolean;
    this.ktM.setEnabled(true);
    AppMethodBeat.o(72926);
  }
  
  public void setEncryptType(int paramInt)
  {
    AppMethodBeat.i(72917);
    if (z.aUo()) {
      this.Rve.setSecureEncrypt(new com.tencent.mm.wallet_core.a.a(paramInt));
    }
    AppMethodBeat.o(72917);
  }
  
  public void setHintStr(String paramString)
  {
    AppMethodBeat.i(72909);
    this.Rve.setHint(paramString);
    AppMethodBeat.o(72909);
  }
  
  public void setIdentifyCardType(int paramInt)
  {
    AppMethodBeat.i(72920);
    this.Rvg = paramInt;
    if (paramInt == 1)
    {
      this.Rve.setKeyListener(new NumberKeyListener()
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
    this.Rve.setInputType(1);
    AppMethodBeat.o(72920);
  }
  
  public void setImeOptions(int paramInt)
  {
    AppMethodBeat.i(72933);
    this.Rve.setImeOptions(paramInt);
    AppMethodBeat.o(72933);
  }
  
  public void setInfoIvVisible(int paramInt)
  {
    AppMethodBeat.i(72935);
    this.ktM.setVisibility(paramInt);
    AppMethodBeat.o(72935);
  }
  
  public void setMaxLen(int paramInt)
  {
    AppMethodBeat.i(72919);
    if (paramInt != -1)
    {
      this.ktV = paramInt;
      this.Rve.setFilters(new InputFilter[] { new InputFilter.LengthFilter(paramInt) });
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
    this.Rve.setOnEditorActionListener(paramOnEditorActionListener);
    AppMethodBeat.o(72934);
  }
  
  public void setOnFocusChangeListener(View.OnFocusChangeListener paramOnFocusChangeListener)
  {
    AppMethodBeat.i(72930);
    super.setOnFocusChangeListener(paramOnFocusChangeListener);
    this.ktK = paramOnFocusChangeListener;
    AppMethodBeat.o(72930);
  }
  
  public void setOnInfoListener(a parama)
  {
    this.Rvo = parama;
  }
  
  public void setOnInputValidChangeListener(b paramb)
  {
    this.Rvc = paramb;
  }
  
  public void setPreFilledStr(String paramString)
  {
    AppMethodBeat.i(72911);
    if (!Util.isNullOrNil(paramString))
    {
      this.Rvd.setText(paramString);
      this.Rvd.setVisibility(0);
      AppMethodBeat.o(72911);
      return;
    }
    this.Rvd.setText("");
    this.Rvd.setVisibility(8);
    AppMethodBeat.o(72911);
  }
  
  public void setPreText(String paramString)
  {
    AppMethodBeat.i(72915);
    KeyListener localKeyListener = this.Rve.getKeyListener();
    this.Rve.setInputType(1);
    this.Rve.setKeyListener(null);
    setValStr(paramString);
    this.Rve.setKeyListener(localKeyListener);
    this.mode = 4;
    AppMethodBeat.o(72915);
  }
  
  public void setShowScanCamera(boolean paramBoolean)
  {
    AppMethodBeat.i(72937);
    this.Rvi = paramBoolean;
    hhO();
    AppMethodBeat.o(72937);
  }
  
  public void setTipStr(String paramString)
  {
    AppMethodBeat.i(72910);
    this.jBS.setText(paramString);
    AppMethodBeat.o(72910);
  }
  
  public void setTipTextColor(int paramInt)
  {
    AppMethodBeat.i(72918);
    if (this.jBS != null) {
      this.jBS.setTextColor(paramInt);
    }
    AppMethodBeat.o(72918);
  }
  
  public void setTipWidth(int paramInt)
  {
    AppMethodBeat.i(72907);
    this.Rvf = BackwardSupportUtil.BitmapFactory.fromDPToPix(getContext(), paramInt * 1.0F);
    if (this.jBS != null)
    {
      ViewGroup.LayoutParams localLayoutParams = this.jBS.getLayoutParams();
      localLayoutParams.width = this.Rvf;
      this.jBS.setLayoutParams(localLayoutParams);
    }
    AppMethodBeat.o(72907);
  }
  
  public void setValStr(String paramString)
  {
    AppMethodBeat.i(72912);
    switch (this.ktP)
    {
    default: 
      this.Rve.setText(paramString);
      this.Rve.setSelection(this.Rve.getText().length());
      AppMethodBeat.o(72912);
      return;
    }
    if ((!Util.isNullOrNil(paramString)) && (paramString.length() <= 5))
    {
      this.Rve.setSelection(0);
      this.Rve.setBankcardTailNum(paramString);
      this.ktV = (24 - paramString.length());
      this.Rve.setFilters(new InputFilter[] { new InputFilter.LengthFilter(this.ktV) });
      AppMethodBeat.o(72912);
      return;
    }
    this.Rve.setText(paramString);
    this.Rve.setSelection(this.Rve.getText().length());
    AppMethodBeat.o(72912);
  }
  
  public static abstract interface a {}
  
  public static abstract interface b {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.wallet_core.ui.EditHintView
 * JD-Core Version:    0.7.0.1
 */