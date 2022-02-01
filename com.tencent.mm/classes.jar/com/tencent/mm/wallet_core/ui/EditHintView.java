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
import com.tencent.mm.ui.af;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.mm.ui.widget.g;
import com.tenpay.android.wechat.TenpaySecureEditText;
import java.text.DecimalFormat;
import java.util.Calendar;

@Deprecated
public class EditHintView
  extends RelativeLayout
  implements View.OnFocusChangeListener
{
  public boolean adZa;
  private boolean agUA;
  private String agUB;
  private DatePickerDialog agUC;
  private int agUD;
  private int agUE;
  private e agUF;
  private a agUG;
  private b agUu;
  private TextView agUv;
  TenpaySecureEditText agUw;
  private int agUx;
  private int agUy;
  private int agUz;
  private int background;
  private int editType;
  private int fl;
  private int inputType;
  private int mode;
  private TextView pls;
  private View.OnFocusChangeListener qiH;
  private ImageView qiJ;
  private String qiK;
  private String qiL;
  private int qiM;
  private int qiN;
  public boolean qiO;
  private boolean qiQ;
  private int qiR;
  private int qiS;
  private View.OnClickListener qiT;
  private boolean sdN;
  
  public EditHintView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public EditHintView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(72906);
    this.qiK = "";
    this.qiL = "";
    this.inputType = 1;
    this.sdN = true;
    this.qiS = -1;
    this.qiR = 1;
    this.fl = 19;
    this.agUx = -1;
    this.editType = -1;
    this.qiQ = false;
    this.agUy = 1;
    this.agUz = -1;
    this.background = -1;
    this.qiN = -1;
    this.qiO = true;
    this.adZa = true;
    this.agUA = true;
    this.agUB = null;
    this.mode = 0;
    this.agUC = null;
    this.agUD = 0;
    this.agUE = 0;
    this.qiT = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(72904);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/wallet_core/ui/EditHintView$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        if (EditHintView.l(EditHintView.this).getVisibility() == 0)
        {
          if ((!EditHintView.this.qiO) || (Util.isNullOrNil(EditHintView.this.getText()))) {
            break label98;
          }
          EditHintView.this.agUw.ClearInput();
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
    this.agUF = null;
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, a.k.EditHintView, paramInt, 0);
    paramInt = paramAttributeSet.getResourceId(a.k.EditHintView_hint, 0);
    if (paramInt != 0) {
      this.qiK = paramContext.getString(paramInt);
    }
    paramInt = paramAttributeSet.getResourceId(a.k.EditHintView_tipmsg, 0);
    if (paramInt != 0) {
      this.qiL = paramContext.getString(paramInt);
    }
    this.inputType = paramAttributeSet.getInteger(a.k.EditHintView_android_inputType, 1);
    this.qiO = paramAttributeSet.getBoolean(a.k.EditHintView_editable, true);
    this.fl = paramAttributeSet.getInt(a.k.EditHintView_android_gravity, 19);
    this.sdN = paramAttributeSet.getBoolean(a.k.EditHintView_android_clickable, true);
    this.qiS = paramAttributeSet.getInteger(a.k.EditHintView_maxLength, -1);
    this.editType = paramAttributeSet.getInteger(a.k.EditHintView_editType, 0);
    this.qiM = paramAttributeSet.getInteger(a.k.EditHintView_android_imeOptions, 5);
    this.agUz = paramAttributeSet.getColor(a.k.EditHintView_hintTextColor, a.c.normal_text_color);
    this.background = paramAttributeSet.getResourceId(a.k.EditHintView_android_background, -1);
    this.qiN = paramAttributeSet.getResourceId(a.k.EditHintView_hintTextBg, a.e.edittext_bg_selector);
    this.qiR = paramAttributeSet.getInteger(a.k.EditHintView_minLength, 1);
    this.adZa = paramAttributeSet.getBoolean(a.k.EditHintView_android_singleLine, true);
    paramAttributeSet.recycle();
    paramContext = af.mU(paramContext).inflate(a.g.edit_hint_view, this, true);
    this.agUw = ((TenpaySecureEditText)paramContext.findViewById(a.f.hint_et));
    this.pls = ((TextView)paramContext.findViewById(a.f.tip_tv));
    this.agUv = ((TextView)paramContext.findViewById(a.f.pre_filled_tv));
    this.qiJ = ((ImageView)paramContext.findViewById(a.f.info_iv));
    this.agUw.setImeOptions(this.qiM);
    switch (this.editType)
    {
    case 11: 
    default: 
      this.inputType = 1;
    case 0: 
      jPk();
      this.agUw.setSingleLine(this.adZa);
      if (!this.adZa) {
        this.agUw.setMaxLines(1073741823);
      }
      this.qiJ.setOnClickListener(this.qiT);
      this.agUw.addTextChangedListener(new TextWatcher()
      {
        public final void afterTextChanged(Editable paramAnonymousEditable)
        {
          AppMethodBeat.i(72901);
          boolean bool = EditHintView.this.bZp();
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
          if ((EditHintView.a(EditHintView.this) == 4) && (EditHintView.this.bZp()))
          {
            EditHintView.b(EditHintView.this);
            EditHintView.this.agUw.ClearInput();
          }
          AppMethodBeat.o(72900);
        }
        
        public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      });
      this.agUw.setOnFocusChangeListener(this);
      if (!Util.isNullOrNil(this.qiK)) {
        this.agUw.setHint(this.qiK);
      }
      if (!Util.isNullOrNil(this.qiL)) {
        this.pls.setText(this.qiL);
      }
      this.agUw.setGravity(this.fl);
      if (this.inputType == 2)
      {
        this.agUw.setKeyListener(new NumberKeyListener()
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
        if (this.qiS != -1) {
          this.agUw.setFilters(new InputFilter[] { new InputFilter.LengthFilter(this.qiS) });
        }
        super.setEnabled(true);
        super.setClickable(true);
        if (!this.sdN)
        {
          this.agUw.setEnabled(false);
          this.agUw.setTextColor(getResources().getColor(this.agUz));
          this.agUw.setFocusable(false);
          this.agUw.setClickable(false);
          this.agUw.setBackgroundResource(a.e.transparent_background);
          setBackgroundResource(a.e.list_item_normal);
        }
        if (this.qiO) {
          break label1336;
        }
        this.qiQ = true;
        this.agUw.setEnabled(false);
        this.agUw.setTextColor(getResources().getColor(a.c.link_color_pressed));
        this.agUw.setFocusable(false);
        this.agUw.setClickable(false);
        this.agUw.setBackgroundResource(a.e.transparent_background);
        setBackgroundResource(a.e.comm_list_item_selector);
      }
      break;
    }
    for (;;)
    {
      if (this.background > 0) {
        setBackgroundResource(this.background);
      }
      if ((this.pls != null) && (this.agUx != -1))
      {
        paramContext = this.pls.getLayoutParams();
        paramContext.width = this.agUx;
        this.pls.setLayoutParams(paramContext);
      }
      if (z.bBi()) {
        this.agUw.setSecureEncrypt(new com.tencent.mm.wallet_core.a.a(getEncryptType()));
      }
      AppMethodBeat.o(72906);
      return;
      this.qiS = 25;
      this.agUw.setIsBankcardFormat(true);
      this.inputType = 2;
      break;
      this.qiS = 6;
      this.pls.setVisibility(8);
      this.agUw.setIsPasswordFormat(true, true);
      this.agUw.setImeOptions(6);
      this.inputType = 128;
      break;
      this.qiS = 3;
      this.pls.setVisibility(8);
      this.agUw.setIsCvvPaymentFormat(true);
      this.agUw.setImeOptions(6);
      this.inputType = 128;
      break;
      this.qiS = 4;
      this.pls.setVisibility(8);
      this.agUw.setIsCvv4PaymentFormat(true);
      this.agUw.setImeOptions(6);
      this.inputType = 128;
      break;
      this.qiS = 30;
      this.inputType = 3;
      break;
      this.qiS = 18;
      this.inputType = 4;
      break;
      this.qiS = 4;
      this.inputType = 2;
      break;
      this.qiO = false;
      this.agUw.setIsValidThru(true);
      setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(72903);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/wallet_core/ui/EditHintView$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
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
                  k.c(EditHintView.this.getContext(), EditHintView.this.getContext().getString(a.i.wallet_err_expired_date), null, true);
                  EditHintView.a(EditHintView.this, EditHintView.this.bZp());
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
                if (z.bBi()) {
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
      this.qiS = 6;
      this.pls.setVisibility(8);
      this.inputType = 2;
      break;
      this.inputType = 32;
      break;
      if ((this.qiO) || (!this.sdN)) {
        break;
      }
      break;
      this.qiS = 12;
      this.agUw.setIsMoneyAmountFormat(true);
      break;
      this.agUw.setIsSecurityAnswerFormat(true);
      break;
      if (this.inputType == 4)
      {
        this.agUw.setKeyListener(new NumberKeyListener()
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
        this.agUw.setTransformationMethod(PasswordTransformationMethod.getInstance());
        this.agUw.setKeyListener(new NumberKeyListener()
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
        this.agUw.setRawInputType(18);
        break label667;
      }
      if (this.inputType == 3)
      {
        this.agUw.setKeyListener(new NumberKeyListener()
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
      this.agUw.setInputType(this.inputType);
      break label667;
      label1336:
      this.qiQ = false;
      this.agUw.setBackgroundResource(this.qiN);
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
    this.qiJ.getHitRect(localRect);
    localRect.left -= 50;
    localRect.right += 50;
    localRect.top -= 25;
    localRect.bottom += 25;
    AppMethodBeat.o(72936);
    return localRect;
  }
  
  private void jPk()
  {
    AppMethodBeat.i(72931);
    if ((this.editType == 7) || (this.editType == 14) || (this.editType == 15))
    {
      AppMethodBeat.o(72931);
      return;
    }
    if ((this.qiO) && (!Util.isNullOrNil(getText())))
    {
      this.qiJ.setVisibility(0);
      this.qiJ.setImageResource(a.e.list_clear);
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
      this.qiJ.setVisibility(8);
      AppMethodBeat.o(72931);
      return;
    case 3: 
    case 4: 
    case 9: 
    case 10: 
      this.qiJ.setVisibility(0);
      this.qiJ.setImageResource(a.e.payinfoicon);
      AppMethodBeat.o(72931);
      return;
    }
    if (this.agUA)
    {
      this.qiJ.setVisibility(0);
      this.qiJ.setImageResource(a.h.wallet_scan_camera);
      AppMethodBeat.o(72931);
      return;
    }
    this.qiJ.setVisibility(8);
    AppMethodBeat.o(72931);
  }
  
  private void setValStrForce(String paramString)
  {
    AppMethodBeat.i(72914);
    KeyListener localKeyListener = this.agUw.getKeyListener();
    this.agUw.setKeyListener(null);
    setEnabled(false);
    setClickable(false);
    setValStr(paramString);
    this.agUw.setKeyListener(localKeyListener);
    AppMethodBeat.o(72914);
  }
  
  public final boolean bZp()
  {
    AppMethodBeat.i(72923);
    if ((!this.qiO) && (!this.sdN))
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
      if (this.agUw.getInputLength() >= this.qiR)
      {
        AppMethodBeat.o(72923);
        return true;
      }
      break;
    case 1: 
      bool = this.agUw.isBankcardNum();
      AppMethodBeat.o(72923);
      return bool;
    case 9: 
      bool = this.agUw.isPhoneNum();
      AppMethodBeat.o(72923);
      return bool;
    case 4: 
      if (this.agUw.getInputLength() > 0)
      {
        AppMethodBeat.o(72923);
        return true;
      }
      AppMethodBeat.o(72923);
      return false;
    case 5: 
      bool = this.agUw.isAreaIDCardNum(this.agUy);
      AppMethodBeat.o(72923);
      return bool;
    case 7: 
    case 17: 
      if (this.agUw.getInputLength() == 6)
      {
        AppMethodBeat.o(72923);
        return true;
      }
      AppMethodBeat.o(72923);
      return false;
    case 14: 
      if (this.agUw.getInputLength() == 3)
      {
        AppMethodBeat.o(72923);
        return true;
      }
      AppMethodBeat.o(72923);
      return false;
    case 15: 
      if (this.agUw.getInputLength() == 4)
      {
        AppMethodBeat.o(72923);
        return true;
      }
      AppMethodBeat.o(72923);
      return false;
    case 8: 
      bool = Util.isValidEmail(this.agUw.getText().toString());
      AppMethodBeat.o(72923);
      return bool;
    case 12: 
      bool = this.agUw.isMoneyAmount();
      AppMethodBeat.o(72923);
      return bool;
    }
    AppMethodBeat.o(72923);
    return false;
  }
  
  public String get3DesEncrptData()
  {
    AppMethodBeat.i(72924);
    String str = this.agUw.get3DesEncrptData();
    AppMethodBeat.o(72924);
    return str;
  }
  
  public String getMD5Value()
  {
    AppMethodBeat.i(72922);
    if (this.editType == 3) {}
    for (String str = Util.nullAs(this.agUB, "").replace("/", "");; str = this.agUw.getText().toString())
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
      localObject = Util.nullAs(this.agUw.getText().toString(), "");
      AppMethodBeat.o(72921);
      return localObject;
    case 1: 
    case 13: 
    case 16: 
      localObject = this.agUw;
      com.tencent.mm.wallet_core.b.jNX();
      localObject = ((TenpaySecureEditText)localObject).getEncryptDataWithHash(false, com.tencent.mm.wallet_core.b.jNY());
      AppMethodBeat.o(72921);
      return localObject;
    case 4: 
    case 14: 
    case 15: 
      localObject = this.agUw.get3DesEncrptData();
      AppMethodBeat.o(72921);
      return localObject;
    case 5: 
      localObject = this.agUw.get3DesEncrptData();
      AppMethodBeat.o(72921);
      return localObject;
    case 3: 
      localObject = Util.nullAs(this.agUB, "").replace("/", "");
      AppMethodBeat.o(72921);
      return localObject;
    case 2: 
    case 9: 
      localObject = Util.nullAs(this.agUw.getText().toString(), "");
      AppMethodBeat.o(72921);
      return localObject;
    case 0: 
    case 8: 
    case 10: 
      localObject = Util.nullAs(this.agUw.getText().toString(), "");
      AppMethodBeat.o(72921);
      return localObject;
    case 6: 
      localObject = this.agUw.get3DesVerifyCode();
      AppMethodBeat.o(72921);
      return localObject;
    }
    Object localObject = this.agUw;
    com.tencent.mm.wallet_core.b.jNX();
    localObject = ((TenpaySecureEditText)localObject).getEncryptDataWithHash(true, com.tencent.mm.wallet_core.b.jNY());
    AppMethodBeat.o(72921);
    return localObject;
  }
  
  public void onFocusChange(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(72932);
    if (this.qiH != null) {
      this.qiH.onFocusChange(this, paramBoolean);
    }
    Log.d("MicroMsg.EditHintView", "View:" + this.qiL + ", editType:" + this.editType + " onFocusChange to " + paramBoolean);
    if (!this.qiQ)
    {
      this.pls.setEnabled(false);
      AppMethodBeat.o(72932);
      return;
    }
    this.pls.setEnabled(true);
    AppMethodBeat.o(72932);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(72928);
    int i;
    if (!this.qiO)
    {
      if (this.qiJ.getVisibility() != 0) {
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
      this.agUw.setText(paramString);
      this.agUw.setSelection(this.agUw.getText().length());
      AppMethodBeat.o(72913);
      return;
    }
    if ((!Util.isNullOrNil(paramString)) && (paramString.length() <= 5))
    {
      this.agUw.setSelection(0);
      this.agUw.set3DesEncrptData(paramString);
      this.qiS = (24 - paramString.length());
      this.agUw.setFilters(new InputFilter[] { new InputFilter.LengthFilter(this.qiS) });
      AppMethodBeat.o(72913);
      return;
    }
    this.agUw.set3DesEncrptData(paramString);
    this.agUw.setSelection(this.agUw.getText().length());
    AppMethodBeat.o(72913);
  }
  
  public void setClickable(boolean paramBoolean)
  {
    AppMethodBeat.i(72927);
    super.setClickable(paramBoolean);
    this.sdN = paramBoolean;
    if (!paramBoolean)
    {
      this.agUw.setEnabled(false);
      if (!this.qiO) {
        this.agUw.setTextColor(getResources().getColor(a.c.lightgrey));
      }
      for (;;)
      {
        this.agUw.setFocusable(false);
        this.agUw.setClickable(false);
        AppMethodBeat.o(72927);
        return;
        this.agUw.setTextColor(getResources().getColor(this.agUz));
      }
    }
    this.agUw.setEnabled(true);
    if (!this.qiO) {
      this.agUw.setTextColor(getResources().getColor(a.c.link_color_pressed));
    }
    for (;;)
    {
      this.agUw.setFocusable(true);
      this.agUw.setClickable(true);
      AppMethodBeat.o(72927);
      return;
      this.agUw.setTextColor(getResources().getColor(this.agUz));
    }
  }
  
  public void setEditBG(int paramInt)
  {
    AppMethodBeat.i(72916);
    if (this.agUw != null) {
      this.agUw.setBackgroundResource(paramInt);
    }
    AppMethodBeat.o(72916);
  }
  
  public void setEllipsize(TextUtils.TruncateAt paramTruncateAt)
  {
    AppMethodBeat.i(72925);
    this.agUw.setEllipsize(paramTruncateAt);
    AppMethodBeat.o(72925);
  }
  
  public void setEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(72926);
    super.setEnabled(paramBoolean);
    this.qiO = paramBoolean;
    this.qiJ.setEnabled(true);
    AppMethodBeat.o(72926);
  }
  
  public void setEncryptType(int paramInt)
  {
    AppMethodBeat.i(72917);
    if (z.bBi()) {
      this.agUw.setSecureEncrypt(new com.tencent.mm.wallet_core.a.a(paramInt));
    }
    AppMethodBeat.o(72917);
  }
  
  public void setHintStr(String paramString)
  {
    AppMethodBeat.i(72909);
    this.agUw.setHint(paramString);
    AppMethodBeat.o(72909);
  }
  
  public void setIdentifyCardType(int paramInt)
  {
    AppMethodBeat.i(72920);
    this.agUy = paramInt;
    if (paramInt == 1)
    {
      this.agUw.setKeyListener(new NumberKeyListener()
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
    this.agUw.setInputType(1);
    AppMethodBeat.o(72920);
  }
  
  public void setImeOptions(int paramInt)
  {
    AppMethodBeat.i(72933);
    this.agUw.setImeOptions(paramInt);
    AppMethodBeat.o(72933);
  }
  
  public void setInfoIvVisible(int paramInt)
  {
    AppMethodBeat.i(72935);
    this.qiJ.setVisibility(paramInt);
    AppMethodBeat.o(72935);
  }
  
  public void setMaxLen(int paramInt)
  {
    AppMethodBeat.i(72919);
    if (paramInt != -1)
    {
      this.qiS = paramInt;
      this.agUw.setFilters(new InputFilter[] { new InputFilter.LengthFilter(paramInt) });
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
    this.agUw.setOnEditorActionListener(paramOnEditorActionListener);
    AppMethodBeat.o(72934);
  }
  
  public void setOnFocusChangeListener(View.OnFocusChangeListener paramOnFocusChangeListener)
  {
    AppMethodBeat.i(72930);
    super.setOnFocusChangeListener(paramOnFocusChangeListener);
    this.qiH = paramOnFocusChangeListener;
    AppMethodBeat.o(72930);
  }
  
  public void setOnInfoListener(a parama)
  {
    this.agUG = parama;
  }
  
  public void setOnInputValidChangeListener(b paramb)
  {
    this.agUu = paramb;
  }
  
  public void setPreFilledStr(String paramString)
  {
    AppMethodBeat.i(72911);
    if (!Util.isNullOrNil(paramString))
    {
      this.agUv.setText(paramString);
      this.agUv.setVisibility(0);
      AppMethodBeat.o(72911);
      return;
    }
    this.agUv.setText("");
    this.agUv.setVisibility(8);
    AppMethodBeat.o(72911);
  }
  
  public void setPreText(String paramString)
  {
    AppMethodBeat.i(72915);
    KeyListener localKeyListener = this.agUw.getKeyListener();
    this.agUw.setInputType(1);
    this.agUw.setKeyListener(null);
    setValStr(paramString);
    this.agUw.setKeyListener(localKeyListener);
    this.mode = 4;
    AppMethodBeat.o(72915);
  }
  
  public void setShowScanCamera(boolean paramBoolean)
  {
    AppMethodBeat.i(72937);
    this.agUA = paramBoolean;
    jPk();
    AppMethodBeat.o(72937);
  }
  
  public void setTipStr(String paramString)
  {
    AppMethodBeat.i(72910);
    this.pls.setText(paramString);
    AppMethodBeat.o(72910);
  }
  
  public void setTipTextColor(int paramInt)
  {
    AppMethodBeat.i(72918);
    if (this.pls != null) {
      this.pls.setTextColor(paramInt);
    }
    AppMethodBeat.o(72918);
  }
  
  public void setTipWidth(int paramInt)
  {
    AppMethodBeat.i(72907);
    this.agUx = BackwardSupportUtil.BitmapFactory.fromDPToPix(getContext(), paramInt * 1.0F);
    if (this.pls != null)
    {
      ViewGroup.LayoutParams localLayoutParams = this.pls.getLayoutParams();
      localLayoutParams.width = this.agUx;
      this.pls.setLayoutParams(localLayoutParams);
    }
    AppMethodBeat.o(72907);
  }
  
  public void setValStr(String paramString)
  {
    AppMethodBeat.i(72912);
    switch (this.editType)
    {
    default: 
      this.agUw.setText(paramString);
      this.agUw.setSelection(this.agUw.getText().length());
      AppMethodBeat.o(72912);
      return;
    }
    if ((!Util.isNullOrNil(paramString)) && (paramString.length() <= 5))
    {
      this.agUw.setSelection(0);
      this.agUw.setBankcardTailNum(paramString);
      this.qiS = (24 - paramString.length());
      this.agUw.setFilters(new InputFilter[] { new InputFilter.LengthFilter(this.qiS) });
      AppMethodBeat.o(72912);
      return;
    }
    this.agUw.setText(paramString);
    this.agUw.setSelection(this.agUw.getText().length());
    AppMethodBeat.o(72912);
  }
  
  public static abstract interface a {}
  
  public static abstract interface b {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.wallet_core.ui.EditHintView
 * JD-Core Version:    0.7.0.1
 */