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
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.e;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.h;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.plugin.wxpay.a.k;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.BitmapFactory;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.ad;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.a.d;
import com.tencent.mm.ui.widget.g;
import com.tenpay.android.wechat.TenpaySecureEditText;
import java.text.DecimalFormat;
import java.util.Calendar;

@Deprecated
public class EditHintView
  extends RelativeLayout
  implements View.OnFocusChangeListener
{
  public boolean WrK;
  private b YWA;
  private TextView YWB;
  TenpaySecureEditText YWC;
  private int YWD;
  private int YWE;
  private int YWF;
  private boolean YWG;
  private String YWH;
  private DatePickerDialog YWI;
  private int YWJ;
  private int YWK;
  private d YWL;
  private a YWM;
  private int background;
  private int editType;
  private int ek;
  private int inputType;
  private int mode;
  private TextView mrN;
  private ImageView nlA;
  private String nlB;
  private String nlC;
  private int nlD;
  private int nlE;
  public boolean nlF;
  private boolean nlH;
  private int nlI;
  private int nlJ;
  private View.OnClickListener nlK;
  private View.OnFocusChangeListener nly;
  private boolean oYn;
  
  public EditHintView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public EditHintView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(72906);
    this.nlB = "";
    this.nlC = "";
    this.inputType = 1;
    this.oYn = true;
    this.nlJ = -1;
    this.nlI = 1;
    this.ek = 19;
    this.YWD = -1;
    this.editType = -1;
    this.nlH = false;
    this.YWE = 1;
    this.YWF = -1;
    this.background = -1;
    this.nlE = -1;
    this.nlF = true;
    this.WrK = true;
    this.YWG = true;
    this.YWH = null;
    this.mode = 0;
    this.YWI = null;
    this.YWJ = 0;
    this.YWK = 0;
    this.nlK = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(72904);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/wallet_core/ui/EditHintView$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        if (EditHintView.l(EditHintView.this).getVisibility() == 0)
        {
          if ((!EditHintView.this.nlF) || (Util.isNullOrNil(EditHintView.this.getText()))) {
            break label98;
          }
          EditHintView.this.YWC.ClearInput();
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
    this.YWL = null;
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, a.k.EditHintView, paramInt, 0);
    paramInt = paramAttributeSet.getResourceId(a.k.EditHintView_hint, 0);
    if (paramInt != 0) {
      this.nlB = paramContext.getString(paramInt);
    }
    paramInt = paramAttributeSet.getResourceId(a.k.EditHintView_tipmsg, 0);
    if (paramInt != 0) {
      this.nlC = paramContext.getString(paramInt);
    }
    this.inputType = paramAttributeSet.getInteger(a.k.EditHintView_android_inputType, 1);
    this.nlF = paramAttributeSet.getBoolean(a.k.EditHintView_editable, true);
    this.ek = paramAttributeSet.getInt(a.k.EditHintView_android_gravity, 19);
    this.oYn = paramAttributeSet.getBoolean(a.k.EditHintView_android_clickable, true);
    this.nlJ = paramAttributeSet.getInteger(a.k.EditHintView_maxLength, -1);
    this.editType = paramAttributeSet.getInteger(a.k.EditHintView_editType, 0);
    this.nlD = paramAttributeSet.getInteger(a.k.EditHintView_android_imeOptions, 5);
    this.YWF = paramAttributeSet.getColor(a.k.EditHintView_hintTextColor, a.c.normal_text_color);
    this.background = paramAttributeSet.getResourceId(a.k.EditHintView_android_background, -1);
    this.nlE = paramAttributeSet.getResourceId(a.k.EditHintView_hintTextBg, a.e.edittext_bg_selector);
    this.nlI = paramAttributeSet.getInteger(a.k.EditHintView_minLength, 1);
    this.WrK = paramAttributeSet.getBoolean(a.k.EditHintView_android_singleLine, true);
    paramAttributeSet.recycle();
    paramContext = ad.kS(paramContext).inflate(a.g.edit_hint_view, this, true);
    this.YWC = ((TenpaySecureEditText)paramContext.findViewById(a.f.hint_et));
    this.mrN = ((TextView)paramContext.findViewById(a.f.tip_tv));
    this.YWB = ((TextView)paramContext.findViewById(a.f.pre_filled_tv));
    this.nlA = ((ImageView)paramContext.findViewById(a.f.info_iv));
    this.YWC.setImeOptions(this.nlD);
    switch (this.editType)
    {
    case 11: 
    default: 
      this.inputType = 1;
    case 0: 
      ijp();
      this.YWC.setSingleLine(this.WrK);
      if (!this.WrK) {
        this.YWC.setMaxLines(1073741823);
      }
      this.nlA.setOnClickListener(this.nlK);
      this.YWC.addTextChangedListener(new TextWatcher()
      {
        public final void afterTextChanged(Editable paramAnonymousEditable)
        {
          AppMethodBeat.i(72901);
          boolean bool = EditHintView.this.bAz();
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
          if ((EditHintView.a(EditHintView.this) == 4) && (EditHintView.this.bAz()))
          {
            EditHintView.b(EditHintView.this);
            EditHintView.this.YWC.ClearInput();
          }
          AppMethodBeat.o(72900);
        }
        
        public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      });
      this.YWC.setOnFocusChangeListener(this);
      if (!Util.isNullOrNil(this.nlB)) {
        this.YWC.setHint(this.nlB);
      }
      if (!Util.isNullOrNil(this.nlC)) {
        this.mrN.setText(this.nlC);
      }
      this.YWC.setGravity(this.ek);
      if (this.inputType == 2)
      {
        this.YWC.setKeyListener(new NumberKeyListener()
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
        label667:
        if (this.nlJ != -1) {
          this.YWC.setFilters(new InputFilter[] { new InputFilter.LengthFilter(this.nlJ) });
        }
        super.setEnabled(true);
        super.setClickable(true);
        if (!this.oYn)
        {
          this.YWC.setEnabled(false);
          this.YWC.setTextColor(getResources().getColor(this.YWF));
          this.YWC.setFocusable(false);
          this.YWC.setClickable(false);
          this.YWC.setBackgroundResource(a.e.transparent_background);
          setBackgroundResource(a.e.list_item_normal);
        }
        if (this.nlF) {
          break label1336;
        }
        this.nlH = true;
        this.YWC.setEnabled(false);
        this.YWC.setTextColor(getResources().getColor(a.c.link_color_pressed));
        this.YWC.setFocusable(false);
        this.YWC.setClickable(false);
        this.YWC.setBackgroundResource(a.e.transparent_background);
        setBackgroundResource(a.e.comm_list_item_selector);
      }
      break;
    }
    for (;;)
    {
      if (this.background > 0) {
        setBackgroundResource(this.background);
      }
      if ((this.mrN != null) && (this.YWD != -1))
      {
        paramContext = this.mrN.getLayoutParams();
        paramContext.width = this.YWD;
        this.mrN.setLayoutParams(paramContext);
      }
      if (z.bdq()) {
        this.YWC.setSecureEncrypt(new com.tencent.mm.wallet_core.a.a(getEncryptType()));
      }
      AppMethodBeat.o(72906);
      return;
      this.nlJ = 25;
      this.YWC.setIsBankcardFormat(true);
      this.inputType = 2;
      break;
      this.nlJ = 6;
      this.mrN.setVisibility(8);
      this.YWC.setIsPasswordFormat(true, true);
      this.YWC.setImeOptions(6);
      this.inputType = 128;
      break;
      this.nlJ = 3;
      this.mrN.setVisibility(8);
      this.YWC.setIsCvvPaymentFormat(true);
      this.YWC.setImeOptions(6);
      this.inputType = 128;
      break;
      this.nlJ = 4;
      this.mrN.setVisibility(8);
      this.YWC.setIsCvv4PaymentFormat(true);
      this.YWC.setImeOptions(6);
      this.inputType = 128;
      break;
      this.nlJ = 30;
      this.inputType = 3;
      break;
      this.nlJ = 18;
      this.inputType = 4;
      break;
      this.nlJ = 4;
      this.inputType = 2;
      break;
      this.nlF = false;
      this.YWC.setIsValidThru(true);
      setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(72903);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/wallet_core/ui/EditHintView$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          if (EditHintView.h(EditHintView.this) == null)
          {
            paramAnonymousView = Calendar.getInstance();
            paramAnonymousView.setTimeInMillis(System.currentTimeMillis());
            paramAnonymousView.add(2, 1);
            EditHintView.a(EditHintView.this, paramAnonymousView.get(1));
            EditHintView.b(EditHintView.this, paramAnonymousView.get(2));
            EditHintView.a(EditHintView.this, new g(EditHintView.this.getContext(), new DatePickerDialog.OnDateSetListener()
            {
              public final void onDateSet(DatePicker paramAnonymous2DatePicker, int paramAnonymous2Int1, int paramAnonymous2Int2, int paramAnonymous2Int3)
              {
                AppMethodBeat.i(72902);
                if ((paramAnonymous2Int1 < EditHintView.i(EditHintView.this)) && (paramAnonymous2Int2 < EditHintView.j(EditHintView.this)))
                {
                  h.c(EditHintView.this.getContext(), EditHintView.this.getContext().getString(a.i.wallet_err_expired_date), null, true);
                  EditHintView.a(EditHintView.this, EditHintView.this.bAz());
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
                if (z.bdq()) {
                  EditHintView.a(EditHintView.this, paramAnonymous2DatePicker.format(paramAnonymous2Int2 + 1) + paramAnonymous2Int1);
                }
                for (;;)
                {
                  EditHintView.k(EditHintView.this).setText(paramAnonymous2DatePicker.format(paramAnonymous2Int2 + 1) + paramAnonymous2DatePicker.format(paramAnonymous2Int1).substring(2));
                  break;
                  EditHintView.a(EditHintView.this, paramAnonymous2DatePicker.format(paramAnonymous2Int1).substring(2) + paramAnonymous2DatePicker.format(paramAnonymous2Int2 + 1));
                }
              }
            }, EditHintView.i(EditHintView.this), EditHintView.j(EditHintView.this), paramAnonymousView.get(5), paramAnonymousView.getTimeInMillis(), (byte)0));
          }
          EditHintView.h(EditHintView.this).show();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/wallet_core/ui/EditHintView$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(72903);
        }
      });
      break;
      this.nlJ = 6;
      this.mrN.setVisibility(8);
      this.inputType = 2;
      break;
      this.inputType = 32;
      break;
      if ((this.nlF) || (!this.oYn)) {
        break;
      }
      break;
      this.nlJ = 12;
      this.YWC.setIsMoneyAmountFormat(true);
      break;
      this.YWC.setIsSecurityAnswerFormat(true);
      break;
      if (this.inputType == 4)
      {
        this.YWC.setKeyListener(new NumberKeyListener()
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
        break label667;
      }
      if (this.inputType == 128)
      {
        this.YWC.setTransformationMethod(PasswordTransformationMethod.getInstance());
        this.YWC.setKeyListener(new NumberKeyListener()
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
        this.YWC.setRawInputType(18);
        break label667;
      }
      if (this.inputType == 3)
      {
        this.YWC.setKeyListener(new NumberKeyListener()
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
        break label667;
      }
      this.YWC.setInputType(this.inputType);
      break label667;
      label1336:
      this.nlH = false;
      this.YWC.setBackgroundResource(this.nlE);
      setBackgroundResource(a.e.transparent_background);
    }
  }
  
  private int getEncryptType()
  {
    switch (this.editType)
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
    this.nlA.getHitRect(localRect);
    localRect.left -= 50;
    localRect.right += 50;
    localRect.top -= 25;
    localRect.bottom += 25;
    AppMethodBeat.o(72936);
    return localRect;
  }
  
  private void ijp()
  {
    AppMethodBeat.i(72931);
    if ((this.editType == 7) || (this.editType == 14) || (this.editType == 15))
    {
      AppMethodBeat.o(72931);
      return;
    }
    if ((this.nlF) && (!Util.isNullOrNil(getText())))
    {
      this.nlA.setVisibility(0);
      this.nlA.setImageResource(a.e.list_clear);
      AppMethodBeat.o(72931);
      return;
    }
    switch (this.editType)
    {
    case 2: 
    case 5: 
    case 6: 
    case 7: 
    case 8: 
    default: 
      this.nlA.setVisibility(8);
      AppMethodBeat.o(72931);
      return;
    case 3: 
    case 4: 
    case 9: 
    case 10: 
      this.nlA.setVisibility(0);
      this.nlA.setImageResource(a.e.payinfoicon);
      AppMethodBeat.o(72931);
      return;
    }
    if (this.YWG)
    {
      this.nlA.setVisibility(0);
      this.nlA.setImageResource(a.h.wallet_scan_camera);
      AppMethodBeat.o(72931);
      return;
    }
    this.nlA.setVisibility(8);
    AppMethodBeat.o(72931);
  }
  
  private void setValStrForce(String paramString)
  {
    AppMethodBeat.i(72914);
    KeyListener localKeyListener = this.YWC.getKeyListener();
    this.YWC.setKeyListener(null);
    setEnabled(false);
    setClickable(false);
    setValStr(paramString);
    this.YWC.setKeyListener(localKeyListener);
    AppMethodBeat.o(72914);
  }
  
  public final boolean bAz()
  {
    AppMethodBeat.i(72923);
    if ((!this.nlF) && (!this.oYn))
    {
      AppMethodBeat.o(72923);
      return true;
    }
    boolean bool;
    switch (this.editType)
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
      if (this.YWC.getInputLength() >= this.nlI)
      {
        AppMethodBeat.o(72923);
        return true;
      }
      break;
    case 1: 
      bool = this.YWC.isBankcardNum();
      AppMethodBeat.o(72923);
      return bool;
    case 9: 
      bool = this.YWC.isPhoneNum();
      AppMethodBeat.o(72923);
      return bool;
    case 4: 
      if (this.YWC.getInputLength() > 0)
      {
        AppMethodBeat.o(72923);
        return true;
      }
      AppMethodBeat.o(72923);
      return false;
    case 5: 
      bool = this.YWC.isAreaIDCardNum(this.YWE);
      AppMethodBeat.o(72923);
      return bool;
    case 7: 
    case 17: 
      if (this.YWC.getInputLength() == 6)
      {
        AppMethodBeat.o(72923);
        return true;
      }
      AppMethodBeat.o(72923);
      return false;
    case 14: 
      if (this.YWC.getInputLength() == 3)
      {
        AppMethodBeat.o(72923);
        return true;
      }
      AppMethodBeat.o(72923);
      return false;
    case 15: 
      if (this.YWC.getInputLength() == 4)
      {
        AppMethodBeat.o(72923);
        return true;
      }
      AppMethodBeat.o(72923);
      return false;
    case 8: 
      bool = Util.isValidEmail(this.YWC.getText().toString());
      AppMethodBeat.o(72923);
      return bool;
    case 12: 
      bool = this.YWC.isMoneyAmount();
      AppMethodBeat.o(72923);
      return bool;
    }
    AppMethodBeat.o(72923);
    return false;
  }
  
  public String get3DesEncrptData()
  {
    AppMethodBeat.i(72924);
    String str = this.YWC.get3DesEncrptData();
    AppMethodBeat.o(72924);
    return str;
  }
  
  public String getMD5Value()
  {
    AppMethodBeat.i(72922);
    if (this.editType == 3) {}
    for (String str = Util.nullAs(this.YWH, "").replace("/", "");; str = this.YWC.getText().toString())
    {
      str = MD5Util.getMD5String(str);
      AppMethodBeat.o(72922);
      return str;
    }
  }
  
  public String getText()
  {
    AppMethodBeat.i(72921);
    switch (this.editType)
    {
    case 11: 
    case 12: 
    default: 
      localObject = Util.nullAs(this.YWC.getText().toString(), "");
      AppMethodBeat.o(72921);
      return localObject;
    case 1: 
    case 13: 
    case 16: 
      localObject = this.YWC;
      com.tencent.mm.wallet_core.b.iie();
      localObject = ((TenpaySecureEditText)localObject).getEncryptDataWithHash(false, com.tencent.mm.wallet_core.b.iif());
      AppMethodBeat.o(72921);
      return localObject;
    case 4: 
    case 14: 
    case 15: 
      localObject = this.YWC.get3DesEncrptData();
      AppMethodBeat.o(72921);
      return localObject;
    case 5: 
      localObject = this.YWC.get3DesEncrptData();
      AppMethodBeat.o(72921);
      return localObject;
    case 3: 
      localObject = Util.nullAs(this.YWH, "").replace("/", "");
      AppMethodBeat.o(72921);
      return localObject;
    case 2: 
    case 9: 
      localObject = Util.nullAs(this.YWC.getText().toString(), "");
      AppMethodBeat.o(72921);
      return localObject;
    case 0: 
    case 8: 
    case 10: 
      localObject = Util.nullAs(this.YWC.getText().toString(), "");
      AppMethodBeat.o(72921);
      return localObject;
    case 6: 
      localObject = this.YWC.get3DesVerifyCode();
      AppMethodBeat.o(72921);
      return localObject;
    }
    Object localObject = this.YWC;
    com.tencent.mm.wallet_core.b.iie();
    localObject = ((TenpaySecureEditText)localObject).getEncryptDataWithHash(true, com.tencent.mm.wallet_core.b.iif());
    AppMethodBeat.o(72921);
    return localObject;
  }
  
  public void onFocusChange(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(72932);
    if (this.nly != null) {
      this.nly.onFocusChange(this, paramBoolean);
    }
    Log.d("MicroMsg.EditHintView", "View:" + this.nlC + ", editType:" + this.editType + " onFocusChange to " + paramBoolean);
    if (!this.nlH)
    {
      this.mrN.setEnabled(false);
      AppMethodBeat.o(72932);
      return;
    }
    this.mrN.setEnabled(true);
    AppMethodBeat.o(72932);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(72928);
    int i;
    if (!this.nlF)
    {
      if (this.nlA.getVisibility() != 0) {
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
    if ((this.editType != 7) && (this.editType != 17) && (this.editType != 14))
    {
      j = paramInt1;
      i = paramInt2;
      if (this.editType != 15) {}
    }
    else
    {
      setMeasuredDimension(getDefaultSize(BackwardSupportUtil.BitmapFactory.fromDPToPix(getContext(), 960.0F), paramInt1), getDefaultSize(BackwardSupportUtil.BitmapFactory.fromDPToPix(getContext(), 720.0F), paramInt2));
      paramInt2 = getMeasuredWidth();
      if ((this.editType != 7) && (this.editType != 17)) {
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
      if (this.editType == 14) {
        paramInt1 = paramInt2 / 3;
      } else {
        paramInt1 = paramInt2 / 4;
      }
    }
  }
  
  public void set3DesValStr(String paramString)
  {
    AppMethodBeat.i(72913);
    switch (this.editType)
    {
    default: 
      this.YWC.setText(paramString);
      this.YWC.setSelection(this.YWC.getText().length());
      AppMethodBeat.o(72913);
      return;
    }
    if ((!Util.isNullOrNil(paramString)) && (paramString.length() <= 5))
    {
      this.YWC.setSelection(0);
      this.YWC.set3DesEncrptData(paramString);
      this.nlJ = (24 - paramString.length());
      this.YWC.setFilters(new InputFilter[] { new InputFilter.LengthFilter(this.nlJ) });
      AppMethodBeat.o(72913);
      return;
    }
    this.YWC.set3DesEncrptData(paramString);
    this.YWC.setSelection(this.YWC.getText().length());
    AppMethodBeat.o(72913);
  }
  
  public void setClickable(boolean paramBoolean)
  {
    AppMethodBeat.i(72927);
    super.setClickable(paramBoolean);
    this.oYn = paramBoolean;
    if (!paramBoolean)
    {
      this.YWC.setEnabled(false);
      if (!this.nlF) {
        this.YWC.setTextColor(getResources().getColor(a.c.lightgrey));
      }
      for (;;)
      {
        this.YWC.setFocusable(false);
        this.YWC.setClickable(false);
        AppMethodBeat.o(72927);
        return;
        this.YWC.setTextColor(getResources().getColor(this.YWF));
      }
    }
    this.YWC.setEnabled(true);
    if (!this.nlF) {
      this.YWC.setTextColor(getResources().getColor(a.c.link_color_pressed));
    }
    for (;;)
    {
      this.YWC.setFocusable(true);
      this.YWC.setClickable(true);
      AppMethodBeat.o(72927);
      return;
      this.YWC.setTextColor(getResources().getColor(this.YWF));
    }
  }
  
  public void setEditBG(int paramInt)
  {
    AppMethodBeat.i(72916);
    if (this.YWC != null) {
      this.YWC.setBackgroundResource(paramInt);
    }
    AppMethodBeat.o(72916);
  }
  
  public void setEllipsize(TextUtils.TruncateAt paramTruncateAt)
  {
    AppMethodBeat.i(72925);
    this.YWC.setEllipsize(paramTruncateAt);
    AppMethodBeat.o(72925);
  }
  
  public void setEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(72926);
    super.setEnabled(paramBoolean);
    this.nlF = paramBoolean;
    this.nlA.setEnabled(true);
    AppMethodBeat.o(72926);
  }
  
  public void setEncryptType(int paramInt)
  {
    AppMethodBeat.i(72917);
    if (z.bdq()) {
      this.YWC.setSecureEncrypt(new com.tencent.mm.wallet_core.a.a(paramInt));
    }
    AppMethodBeat.o(72917);
  }
  
  public void setHintStr(String paramString)
  {
    AppMethodBeat.i(72909);
    this.YWC.setHint(paramString);
    AppMethodBeat.o(72909);
  }
  
  public void setIdentifyCardType(int paramInt)
  {
    AppMethodBeat.i(72920);
    this.YWE = paramInt;
    if (paramInt == 1)
    {
      this.YWC.setKeyListener(new NumberKeyListener()
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
    this.YWC.setInputType(1);
    AppMethodBeat.o(72920);
  }
  
  public void setImeOptions(int paramInt)
  {
    AppMethodBeat.i(72933);
    this.YWC.setImeOptions(paramInt);
    AppMethodBeat.o(72933);
  }
  
  public void setInfoIvVisible(int paramInt)
  {
    AppMethodBeat.i(72935);
    this.nlA.setVisibility(paramInt);
    AppMethodBeat.o(72935);
  }
  
  public void setMaxLen(int paramInt)
  {
    AppMethodBeat.i(72919);
    if (paramInt != -1)
    {
      this.nlJ = paramInt;
      this.YWC.setFilters(new InputFilter[] { new InputFilter.LengthFilter(paramInt) });
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
    this.YWC.setOnEditorActionListener(paramOnEditorActionListener);
    AppMethodBeat.o(72934);
  }
  
  public void setOnFocusChangeListener(View.OnFocusChangeListener paramOnFocusChangeListener)
  {
    AppMethodBeat.i(72930);
    super.setOnFocusChangeListener(paramOnFocusChangeListener);
    this.nly = paramOnFocusChangeListener;
    AppMethodBeat.o(72930);
  }
  
  public void setOnInfoListener(a parama)
  {
    this.YWM = parama;
  }
  
  public void setOnInputValidChangeListener(b paramb)
  {
    this.YWA = paramb;
  }
  
  public void setPreFilledStr(String paramString)
  {
    AppMethodBeat.i(72911);
    if (!Util.isNullOrNil(paramString))
    {
      this.YWB.setText(paramString);
      this.YWB.setVisibility(0);
      AppMethodBeat.o(72911);
      return;
    }
    this.YWB.setText("");
    this.YWB.setVisibility(8);
    AppMethodBeat.o(72911);
  }
  
  public void setPreText(String paramString)
  {
    AppMethodBeat.i(72915);
    KeyListener localKeyListener = this.YWC.getKeyListener();
    this.YWC.setInputType(1);
    this.YWC.setKeyListener(null);
    setValStr(paramString);
    this.YWC.setKeyListener(localKeyListener);
    this.mode = 4;
    AppMethodBeat.o(72915);
  }
  
  public void setShowScanCamera(boolean paramBoolean)
  {
    AppMethodBeat.i(72937);
    this.YWG = paramBoolean;
    ijp();
    AppMethodBeat.o(72937);
  }
  
  public void setTipStr(String paramString)
  {
    AppMethodBeat.i(72910);
    this.mrN.setText(paramString);
    AppMethodBeat.o(72910);
  }
  
  public void setTipTextColor(int paramInt)
  {
    AppMethodBeat.i(72918);
    if (this.mrN != null) {
      this.mrN.setTextColor(paramInt);
    }
    AppMethodBeat.o(72918);
  }
  
  public void setTipWidth(int paramInt)
  {
    AppMethodBeat.i(72907);
    this.YWD = BackwardSupportUtil.BitmapFactory.fromDPToPix(getContext(), paramInt * 1.0F);
    if (this.mrN != null)
    {
      ViewGroup.LayoutParams localLayoutParams = this.mrN.getLayoutParams();
      localLayoutParams.width = this.YWD;
      this.mrN.setLayoutParams(localLayoutParams);
    }
    AppMethodBeat.o(72907);
  }
  
  public void setValStr(String paramString)
  {
    AppMethodBeat.i(72912);
    switch (this.editType)
    {
    default: 
      this.YWC.setText(paramString);
      this.YWC.setSelection(this.YWC.getText().length());
      AppMethodBeat.o(72912);
      return;
    }
    if ((!Util.isNullOrNil(paramString)) && (paramString.length() <= 5))
    {
      this.YWC.setSelection(0);
      this.YWC.setBankcardTailNum(paramString);
      this.nlJ = (24 - paramString.length());
      this.YWC.setFilters(new InputFilter[] { new InputFilter.LengthFilter(this.nlJ) });
      AppMethodBeat.o(72912);
      return;
    }
    this.YWC.setText(paramString);
    this.YWC.setSelection(this.YWC.getText().length());
    AppMethodBeat.o(72912);
  }
  
  public static abstract interface a {}
  
  public static abstract interface b {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.wallet_core.ui.EditHintView
 * JD-Core Version:    0.7.0.1
 */