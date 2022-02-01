package com.tencent.mm.plugin.recharge.ui;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.telephony.PhoneNumberUtils;
import android.text.Editable;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.text.SpannableStringBuilder;
import android.text.TextUtils.TruncateAt;
import android.text.TextWatcher;
import android.text.method.KeyListener;
import android.text.method.NumberKeyListener;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AutoCompleteTextView;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filter.FilterResults;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.d;
import com.tencent.mm.plugin.wxpay.a.e;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.plugin.wxpay.a.k;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class MallEditText
  extends LinearLayout
  implements View.OnFocusChangeListener
{
  private b HzG;
  AutoCompleteTextView HzH;
  boolean HzI;
  private a HzJ;
  private List<String[]> HzK;
  private com.tencent.mm.plugin.recharge.model.a HzL;
  private Runnable HzM;
  private boolean HzN;
  private int HzO;
  private int editType;
  private int ek;
  private int inputType;
  private TextView kMa;
  private ImageView nlA;
  private String nlB;
  private String nlC;
  private int nlD;
  public boolean nlF;
  private boolean nlH;
  private int nlI;
  private int nlJ;
  private View.OnFocusChangeListener nly;
  private boolean oYn;
  
  public MallEditText(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public MallEditText(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(67135);
    this.HzJ = null;
    this.nlB = "";
    this.nlC = "";
    this.inputType = 1;
    this.oYn = true;
    this.nlJ = -1;
    this.nlI = 1;
    this.ek = 19;
    this.editType = -1;
    this.nlH = false;
    this.HzL = null;
    this.nlF = true;
    this.HzM = null;
    this.HzN = false;
    this.HzO = 0;
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, a.k.MallEditText, paramInt, 0);
    paramInt = paramAttributeSet.getResourceId(a.k.MallEditText_mallHint, 0);
    if (paramInt != 0) {
      this.nlB = paramContext.getString(paramInt);
    }
    paramInt = paramAttributeSet.getResourceId(a.k.MallEditText_mallTipmsg, 0);
    if (paramInt != 0) {
      this.nlC = paramContext.getString(paramInt);
    }
    this.inputType = paramAttributeSet.getInteger(a.k.MallEditText_android_inputType, 1);
    this.nlF = paramAttributeSet.getBoolean(a.k.MallEditText_android_editable, true);
    this.ek = paramAttributeSet.getInt(a.k.MallEditText_android_gravity, 19);
    this.oYn = paramAttributeSet.getBoolean(a.k.MallEditText_android_clickable, true);
    this.nlJ = paramAttributeSet.getInteger(a.k.MallEditText_android_maxLength, -1);
    this.editType = paramAttributeSet.getInteger(a.k.MallEditText_mallEditType, 0);
    this.nlD = paramAttributeSet.getInteger(a.k.MallEditText_android_imeOptions, 5);
    paramAttributeSet.recycle();
    paramAttributeSet = LayoutInflater.from(paramContext).inflate(a.g.recharge_edit_text, this, true);
    this.kMa = ((TextView)paramAttributeSet.findViewById(a.f.username_tv));
    this.HzH = ((AutoCompleteTextView)paramAttributeSet.findViewById(a.f.hint_et));
    if (com.tencent.mm.ci.a.ko(paramContext))
    {
      this.HzH.setTextSize(0, paramContext.getResources().getDimensionPixelSize(a.d.NormalTextSize) * com.tencent.mm.ci.a.kd(getContext()));
      label308:
      this.nlA = ((ImageView)paramAttributeSet.findViewById(a.f.info_iv));
      Log.d("MicroMsg.MallEditText", "setFormat editType:" + this.editType);
      this.HzH.setImeOptions(this.nlD);
      switch (this.editType)
      {
      default: 
        label384:
        this.inputType = 1;
        label389:
        this.HzH.addTextChangedListener(new TextWatcher()
        {
          public final void afterTextChanged(Editable paramAnonymousEditable) {}
          
          public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
          
          public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
          {
            AppMethodBeat.i(67116);
            String str = paramAnonymousCharSequence.toString();
            paramAnonymousInt2 = MallEditText.a(MallEditText.this).getSelectionStart();
            paramAnonymousCharSequence = "";
            paramAnonymousInt1 = paramAnonymousInt2;
            int i;
            if (str != null)
            {
              paramAnonymousCharSequence = new StringBuilder(str.replaceAll(" ", ""));
              paramAnonymousInt1 = paramAnonymousCharSequence.length();
              if (paramAnonymousInt1 >= 4) {
                paramAnonymousCharSequence.insert(3, ' ');
              }
              if (paramAnonymousInt1 >= 8) {
                paramAnonymousCharSequence.insert(8, ' ');
              }
              paramAnonymousCharSequence = paramAnonymousCharSequence.toString();
              i = paramAnonymousCharSequence.length();
              if (i <= MallEditText.b(MallEditText.this)) {
                break label215;
              }
              if (((paramAnonymousInt2 != 4) && (paramAnonymousInt2 != 9)) || (paramAnonymousInt3 != 1)) {
                break label186;
              }
              paramAnonymousInt1 = paramAnonymousInt2 + 1;
            }
            for (;;)
            {
              MallEditText.a(MallEditText.this, i);
              if (str.equals(paramAnonymousCharSequence)) {
                break label272;
              }
              MallEditText.a(MallEditText.this).setText(paramAnonymousCharSequence);
              if (paramAnonymousInt1 >= MallEditText.b(MallEditText.this)) {
                break;
              }
              MallEditText.a(MallEditText.this).setSelection(paramAnonymousInt1);
              AppMethodBeat.o(67116);
              return;
              label186:
              if (paramAnonymousInt2 != 4)
              {
                paramAnonymousInt1 = paramAnonymousInt2;
                if (paramAnonymousInt2 != 9) {}
              }
              else
              {
                paramAnonymousInt1 = paramAnonymousInt2;
                if (paramAnonymousInt3 > 1)
                {
                  paramAnonymousInt1 = paramAnonymousInt2 + paramAnonymousInt3;
                  continue;
                  label215:
                  paramAnonymousInt1 = paramAnonymousInt2;
                  if (i < MallEditText.b(MallEditText.this)) {
                    if (paramAnonymousInt2 != 4)
                    {
                      paramAnonymousInt1 = paramAnonymousInt2;
                      if (paramAnonymousInt2 != 9) {}
                    }
                    else
                    {
                      paramAnonymousInt1 = paramAnonymousInt2 - 1;
                    }
                  }
                }
              }
            }
            MallEditText.a(MallEditText.this).setSelection(MallEditText.b(MallEditText.this));
            AppMethodBeat.o(67116);
            return;
            label272:
            MallEditText.c(MallEditText.this);
            AppMethodBeat.o(67116);
          }
        });
        this.HzH.setOnFocusChangeListener(this);
        if (!Util.isNullOrNil(this.nlB)) {
          this.HzH.setHint(this.nlB);
        }
        if (this.inputType == 2)
        {
          this.HzH.setKeyListener(new NumberKeyListener()
          {
            protected final char[] getAcceptedChars()
            {
              return new char[] { 49, 50, 51, 52, 53, 54, 55, 56, 57, 48, 32 };
            }
            
            public final int getInputType()
            {
              return 3;
            }
          });
          label456:
          this.HzH.setGravity(this.ek);
          if (!this.oYn)
          {
            this.HzH.setEnabled(false);
            this.HzH.setTextColor(getResources().getColor(a.c.normal_text_color));
            this.HzH.setFocusable(false);
            this.HzH.setClickable(false);
          }
          if (this.nlF) {
            break label745;
          }
          this.nlH = true;
          this.HzH.setEnabled(false);
          this.HzH.setFocusable(false);
          this.HzH.setClickable(false);
        }
        break;
      }
    }
    for (;;)
    {
      if (this.nlJ != -1) {
        this.HzH.setFilters(new InputFilter[] { new InputFilter.LengthFilter(this.nlJ) });
      }
      Log.d("MicroMsg.MallEditText", "initData editType:" + this.editType);
      switch (this.editType)
      {
      default: 
        AppMethodBeat.o(67135);
        return;
        this.HzH.setTextSize(0, com.tencent.mm.ci.a.aY(paramContext, a.d.NormalTextSize));
        break label308;
        this.nlI = 13;
        this.nlJ = 13;
        this.inputType = 2;
        setInfoTvImageResource(a.e.recharge_phone_contact);
        this.nlA.setVisibility(0);
        break label389;
        if (this.nlF) {
          break label384;
        }
        this.nlA.setImageResource(a.e.mm_submenu);
        this.nlA.setVisibility(0);
        break label384;
        this.HzH.setInputType(this.inputType);
        this.HzH.setRawInputType(this.inputType);
        break label456;
        label745:
        this.nlH = false;
      }
    }
    Log.d("MicroMsg.MallEditText", "setMobileEditTv");
    paramContext = com.tencent.mm.plugin.recharge.a.a.ftQ().ftR();
    this.HzJ = new a((byte)0);
    this.HzJ.gE(paramContext);
    if ((paramContext != null) && (paramContext.size() > 0))
    {
      this.HzL = ((com.tencent.mm.plugin.recharge.model.a)paramContext.get(0));
      setInput(this.HzL);
    }
    for (;;)
    {
      if ((paramContext == null) || (paramContext.size() == 0))
      {
        h.aHH();
        paramContext = (String)h.aHG().aHp().b(6, null);
        this.HzH.setText(paramContext);
        this.HzH.setSelection(this.HzH.getText().length());
        ftU();
      }
      this.HzH.setAdapter(this.HzJ);
      this.HzH.setOnItemClickListener(new AdapterView.OnItemClickListener()
      {
        public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          AppMethodBeat.i(67118);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousAdapterView);
          localb.bn(paramAnonymousView);
          localb.sg(paramAnonymousInt);
          localb.Fs(paramAnonymousLong);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/recharge/ui/MallEditText$4", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.aFi());
          MallEditText.a(MallEditText.this, MallEditText.d(MallEditText.this).abX(paramAnonymousInt));
          if (MallEditText.e(MallEditText.this) != null)
          {
            Log.d("MicroMsg.MallEditText", "onItemClick record.record " + MallEditText.e(MallEditText.this).Hzb + ", record.name " + MallEditText.e(MallEditText.this).name);
            MallEditText.this.setInput(MallEditText.e(MallEditText.this));
          }
          MallEditText.a(MallEditText.this).dismissDropDown();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/recharge/ui/MallEditText$4", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(67118);
        }
      });
      break;
      if (this.HzK == null) {
        new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(67117);
            try
            {
              MallEditText.a(MallEditText.this, com.tencent.mm.pluginsdk.b.dN(MallEditText.this.getContext()));
              AppMethodBeat.o(67117);
              return;
            }
            catch (Exception localException)
            {
              Log.printErrStackTrace("MicroMsg.MallEditText", localException, "", new Object[0]);
              AppMethodBeat.o(67117);
            }
          }
        }.run();
      }
    }
  }
  
  private void ftU()
  {
    AppMethodBeat.i(67141);
    boolean bool = bAz();
    if (bool != this.nlH)
    {
      Log.d("MicroMsg.MallEditText", "View:" + this.nlC + ", editType:" + this.editType + " inputValid change to " + bool);
      this.nlH = bool;
      if (this.HzG != null) {
        this.HzG.onInputValidChange(this.nlH);
      }
      if (!bool)
      {
        if (this.kMa.getVisibility() == 0)
        {
          this.kMa.setText("");
          this.kMa.setVisibility(8);
        }
        this.HzL = null;
      }
    }
    if (this.HzG != null) {
      this.HzG.ftW();
    }
    AppMethodBeat.o(67141);
  }
  
  private void setInputForce(com.tencent.mm.plugin.recharge.model.a parama)
  {
    AppMethodBeat.i(67140);
    this.HzL = parama;
    if (parama != null)
    {
      KeyListener localKeyListener = this.HzH.getKeyListener();
      this.HzH.setKeyListener(null);
      this.HzH.setText(parama.Hzb);
      this.HzH.setSelection(this.HzH.getText().length());
      this.HzH.setKeyListener(localKeyListener);
      ftU();
      Log.d("MicroMsg.MallEditText", "editTv.setText " + parama.Hzb + ", name " + parama.name + ", isInputValid " + this.nlH);
      if ((!Util.isNullOrNil(parama.name)) && (this.nlH))
      {
        this.kMa.setText(parama.name);
        this.kMa.setVisibility(0);
        AppMethodBeat.o(67140);
        return;
      }
      this.kMa.setText("");
      this.kMa.setVisibility(8);
      AppMethodBeat.o(67140);
      return;
    }
    this.HzH.setText("");
    ftU();
    Log.d("MicroMsg.MallEditText", "editTv.setText null");
    this.kMa.setText("");
    this.kMa.setVisibility(8);
    AppMethodBeat.o(67140);
  }
  
  public final boolean bAz()
  {
    AppMethodBeat.i(67143);
    switch (this.editType)
    {
    default: 
      if (this.HzH.getText().length() >= this.nlI)
      {
        AppMethodBeat.o(67143);
        return true;
      }
      break;
    case 1: 
      String str = this.HzH.getText().toString();
      if ((str.length() >= this.nlI) && (str.length() <= this.nlJ) && (PhoneNumberUtils.isGlobalPhoneNumber(com.tencent.mm.plugin.recharge.model.b.aaY(str))))
      {
        AppMethodBeat.o(67143);
        return true;
      }
      AppMethodBeat.o(67143);
      return false;
    }
    AppMethodBeat.o(67143);
    return false;
  }
  
  public final boolean ftV()
  {
    AppMethodBeat.i(67145);
    if (getVisibility() == 0)
    {
      if (Util.isNullOrNil(getText()))
      {
        Log.d("MicroMsg.MallEditText", "View:" + this.nlC + ", editType:" + this.editType + " checkInputValid : empty ");
        AppMethodBeat.o(67145);
        return false;
      }
      if (this.nlH)
      {
        AppMethodBeat.o(67145);
        return true;
      }
      Log.d("MicroMsg.MallEditText", "View:" + this.nlC + ", editType:" + this.editType + " checkInputValid : illegal ");
      AppMethodBeat.o(67145);
      return false;
    }
    AppMethodBeat.o(67145);
    return true;
  }
  
  public void getFocus()
  {
    AppMethodBeat.i(67152);
    this.HzH.findFocus();
    AppMethodBeat.o(67152);
  }
  
  public com.tencent.mm.plugin.recharge.model.a getInputRecord()
  {
    AppMethodBeat.i(67151);
    if (this.HzL != null)
    {
      locala = this.HzL;
      AppMethodBeat.o(67151);
      return locala;
    }
    this.HzL = new com.tencent.mm.plugin.recharge.model.a(getText(), this.kMa.getText().toString(), 0);
    com.tencent.mm.plugin.recharge.model.a locala = this.HzL;
    AppMethodBeat.o(67151);
    return locala;
  }
  
  public String getText()
  {
    AppMethodBeat.i(67142);
    switch (this.editType)
    {
    default: 
      str = Util.nullAs(this.HzH.getText().toString(), "");
      AppMethodBeat.o(67142);
      return str;
    }
    String str = Util.nullAs(this.HzH.getText().toString(), "");
    AppMethodBeat.o(67142);
    return str;
  }
  
  public void onFocusChange(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(67148);
    if (this.nly != null) {
      this.nly.onFocusChange(this, paramBoolean);
    }
    if (!this.HzN) {}
    for (boolean bool = true;; bool = false)
    {
      if ((bool == paramBoolean) && (!paramBoolean) && (this.HzM != null)) {
        this.HzM.run();
      }
      this.HzN = paramBoolean;
      Log.d("MicroMsg.MallEditText", "View:" + this.nlC + ", editType:" + this.editType + " onFocusChange to " + paramBoolean);
      if (this.HzG != null) {
        this.HzG.onInputValidChange(this.nlH);
      }
      AppMethodBeat.o(67148);
      return;
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    return !this.nlF;
  }
  
  public void setEllipsize(TextUtils.TruncateAt paramTruncateAt)
  {
    AppMethodBeat.i(67144);
    this.HzH.setEllipsize(paramTruncateAt);
    AppMethodBeat.o(67144);
  }
  
  public void setHintStr(String paramString)
  {
    AppMethodBeat.i(67136);
    this.HzH.setHint(paramString);
    AppMethodBeat.o(67136);
  }
  
  public void setImeOptions(int paramInt)
  {
    AppMethodBeat.i(67149);
    this.HzH.setImeOptions(paramInt);
    AppMethodBeat.o(67149);
  }
  
  public void setInfoTvImageResource(int paramInt)
  {
    AppMethodBeat.i(67138);
    if (paramInt == a.e.list_clear) {}
    for (boolean bool = true;; bool = false)
    {
      this.HzI = bool;
      this.nlA.setImageResource(paramInt);
      AppMethodBeat.o(67138);
      return;
    }
  }
  
  public void setInfoTvOnClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(67137);
    this.nlA.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(67137);
  }
  
  public void setInput(com.tencent.mm.plugin.recharge.model.a parama)
  {
    AppMethodBeat.i(67139);
    this.HzL = parama;
    if (parama != null)
    {
      this.HzH.setText(parama.Hzb);
      this.HzH.setSelection(this.HzH.getText().length());
      ftU();
      Log.d("MicroMsg.MallEditText", "editTv.setText " + parama.Hzb + ", name " + parama.name + ", isInputValid " + this.nlH);
      if ((!Util.isNullOrNil(parama.name)) && (this.nlH))
      {
        this.kMa.setText(parama.name);
        this.kMa.setVisibility(0);
        AppMethodBeat.o(67139);
        return;
      }
      this.kMa.setText("");
      this.kMa.setVisibility(8);
      AppMethodBeat.o(67139);
      return;
    }
    this.HzH.setText("");
    ftU();
    Log.d("MicroMsg.MallEditText", "editTv.setText null");
    this.kMa.setText("");
    this.kMa.setVisibility(8);
    AppMethodBeat.o(67139);
  }
  
  public void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(67146);
    super.setOnClickListener(paramOnClickListener);
    this.HzH.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(67146);
  }
  
  public void setOnEditorActionListener(TextView.OnEditorActionListener paramOnEditorActionListener)
  {
    AppMethodBeat.i(67150);
    this.HzH.setOnEditorActionListener(paramOnEditorActionListener);
    AppMethodBeat.o(67150);
  }
  
  public void setOnFocusChangeListener(View.OnFocusChangeListener paramOnFocusChangeListener)
  {
    AppMethodBeat.i(67147);
    super.setOnFocusChangeListener(paramOnFocusChangeListener);
    this.nly = paramOnFocusChangeListener;
    AppMethodBeat.o(67147);
  }
  
  public void setOnInputValidChangeListener(b paramb)
  {
    this.HzG = paramb;
  }
  
  final class a
    extends BaseAdapter
    implements Filterable
  {
    public List<com.tencent.mm.plugin.recharge.model.a> HzQ;
    public boolean HzR;
    private List<com.tencent.mm.plugin.recharge.model.a> HzS;
    private a HzT;
    private String HzU;
    
    private a()
    {
      AppMethodBeat.i(67127);
      this.HzQ = new ArrayList();
      this.HzR = false;
      AppMethodBeat.o(67127);
    }
    
    public final com.tencent.mm.plugin.recharge.model.a abX(int paramInt)
    {
      com.tencent.mm.plugin.recharge.model.a locala1 = null;
      for (;;)
      {
        try
        {
          AppMethodBeat.i(67131);
          if (!this.HzR) {
            break label79;
          }
          if (paramInt == 0)
          {
            AppMethodBeat.o(67131);
            return locala1;
          }
          if (paramInt <= this.HzQ.size())
          {
            locala1 = (com.tencent.mm.plugin.recharge.model.a)this.HzQ.get(paramInt - 1);
            AppMethodBeat.o(67131);
            continue;
          }
          AppMethodBeat.o(67131);
        }
        finally {}
        continue;
        label79:
        if (paramInt < this.HzQ.size())
        {
          com.tencent.mm.plugin.recharge.model.a locala2 = (com.tencent.mm.plugin.recharge.model.a)this.HzQ.get(paramInt);
          AppMethodBeat.o(67131);
        }
        else
        {
          AppMethodBeat.o(67131);
        }
      }
    }
    
    public final void gE(List<com.tencent.mm.plugin.recharge.model.a> paramList)
    {
      AppMethodBeat.i(67128);
      this.HzS = paramList;
      this.HzQ.clear();
      this.HzR = false;
      AppMethodBeat.o(67128);
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(67130);
      int i;
      if (this.HzR)
      {
        i = this.HzQ.size();
        AppMethodBeat.o(67130);
        return i + 2;
      }
      if (this.HzQ.size() > 0)
      {
        i = this.HzQ.size();
        AppMethodBeat.o(67130);
        return i + 1;
      }
      AppMethodBeat.o(67130);
      return 0;
    }
    
    public final Filter getFilter()
    {
      AppMethodBeat.i(67129);
      Log.d("MicroMsg.MallEditText", "getFilter");
      if (this.HzT == null) {
        this.HzT = new a((byte)0);
      }
      a locala = this.HzT;
      AppMethodBeat.o(67129);
      return locala;
    }
    
    public final long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public final int getItemViewType(int paramInt)
    {
      AppMethodBeat.i(67133);
      if (this.HzR)
      {
        if (paramInt == 0)
        {
          AppMethodBeat.o(67133);
          return 2;
        }
        if (paramInt <= this.HzQ.size())
        {
          AppMethodBeat.o(67133);
          return 0;
        }
        AppMethodBeat.o(67133);
        return 3;
      }
      if (paramInt < this.HzQ.size())
      {
        AppMethodBeat.o(67133);
        return 0;
      }
      AppMethodBeat.o(67133);
      return 1;
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(67132);
      switch (getItemViewType(paramInt))
      {
      }
      for (;;)
      {
        AppMethodBeat.o(67132);
        return paramView;
        MallEditText.c localc;
        com.tencent.mm.plugin.recharge.model.a locala;
        int i;
        label238:
        int j;
        if (paramView == null)
        {
          paramViewGroup = View.inflate(MallEditText.this.getContext(), a.g.recharge_input_history_item, null);
          localc = new MallEditText.c(MallEditText.this, (byte)0);
          localc.HzY = ((TextView)paramViewGroup.findViewById(a.f.mall_input_record));
          localc.jbF = ((TextView)paramViewGroup.findViewById(a.f.mall_input_name));
          paramViewGroup.setTag(localc);
          locala = abX(paramInt);
          paramView = paramViewGroup;
          if (locala == null) {
            continue;
          }
          paramView = paramViewGroup;
          if (localc == null) {
            continue;
          }
          paramView = paramViewGroup;
          if (localc.HzY == null) {
            continue;
          }
          paramView = paramViewGroup;
          if (localc.jbF == null) {
            continue;
          }
          paramView = com.tencent.mm.plugin.recharge.model.b.aVs(locala.Hzb);
          Log.d("MicroMsg.MallEditText", "record.record " + paramView + ", record.name " + locala.name);
          if (com.tencent.mm.plugin.recharge.model.a.HyZ.equals(locala.Hzc)) {
            break label404;
          }
          paramView = new SpannableStringBuilder(paramView);
          int[] arrayOfInt = locala.Hzc;
          int k = arrayOfInt.length;
          i = 0;
          if (i >= k) {
            break label328;
          }
          j = arrayOfInt[i];
          if (j >= 0)
          {
            if (j < 7) {
              break label311;
            }
            paramInt = j + 2;
          }
        }
        for (;;)
        {
          paramView.setSpan(new ForegroundColorSpan(-65536), paramInt, paramInt + 1, 34);
          i += 1;
          break label238;
          localc = (MallEditText.c)paramView.getTag();
          paramViewGroup = paramView;
          break;
          label311:
          paramInt = j;
          if (j >= 3) {
            paramInt = j + 1;
          }
        }
        label328:
        localc.HzY.setText(paramView);
        label337:
        if ((locala.name != null) && (!Util.isNullOrNil(locala.name.trim()))) {
          localc.jbF.setText(MallEditText.this.getResources().getString(a.i.mall_recharge_username, new Object[] { locala.name }));
        }
        for (;;)
        {
          paramViewGroup.setBackgroundResource(a.e.comm_list_item_selector);
          paramView = paramViewGroup;
          break;
          label404:
          localc.HzY.setText(paramView);
          break label337;
          localc.jbF.setText("");
        }
        paramView = View.inflate(MallEditText.this.getContext(), a.g.recharge_input_history_first_item, null);
        paramView.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(67119);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bn(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/recharge/ui/MallEditText$MobileHistoryAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
            MallEditText.a(MallEditText.this).dismissDropDown();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/recharge/ui/MallEditText$MobileHistoryAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(67119);
          }
        });
        continue;
        paramView = View.inflate(MallEditText.this.getContext(), a.g.recharge_input_history_last_item, null);
        paramView.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(67120);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bn(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/recharge/ui/MallEditText$MobileHistoryAdapter$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
            com.tencent.mm.plugin.recharge.a.a.ftQ().gE(null);
            MallEditText.this.setInput(null);
            MallEditText.d(MallEditText.this).gE(new LinkedList());
            MallEditText.d(MallEditText.this).notifyDataSetChanged();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/recharge/ui/MallEditText$MobileHistoryAdapter$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(67120);
          }
        });
        continue;
        paramView = View.inflate(MallEditText.this.getContext(), a.g.recharge_input_history_last_item, null);
        ((TextView)paramView).setText(a.i.mall_recharge_close);
        paramView.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(67121);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bn(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/recharge/ui/MallEditText$MobileHistoryAdapter$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
            MallEditText.a(MallEditText.this).dismissDropDown();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/recharge/ui/MallEditText$MobileHistoryAdapter$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(67121);
          }
        });
      }
    }
    
    public final int getViewTypeCount()
    {
      return 4;
    }
    
    final class a
      extends Filter
    {
      private a() {}
      
      private static int[] jJ(String paramString1, String paramString2)
      {
        AppMethodBeat.i(67126);
        if (paramString1.equals(paramString2))
        {
          paramString1 = com.tencent.mm.plugin.recharge.model.a.HyZ;
          AppMethodBeat.o(67126);
          return paramString1;
        }
        if ((paramString2 != null) && (paramString1.length() == paramString2.length()))
        {
          int i = 0;
          int[] arrayOfInt = new int[2];
          int[] tmp48_46 = arrayOfInt;
          tmp48_46[0] = -1;
          int[] tmp52_48 = tmp48_46;
          tmp52_48[1] = -1;
          tmp52_48;
          int j = paramString1.length() - 1;
          int k;
          for (;;)
          {
            k = i;
            if (j <= 0) {
              break;
            }
            k = i;
            if (paramString2.charAt(j) != paramString1.charAt(j))
            {
              i += 1;
              k = i;
              if (i > 2) {
                break;
              }
              arrayOfInt[(i - 1)] = j;
              k = i;
            }
            j -= 1;
            i = k;
          }
          if (k <= 2)
          {
            AppMethodBeat.o(67126);
            return arrayOfInt;
          }
        }
        paramString1 = com.tencent.mm.plugin.recharge.model.a.Hza;
        AppMethodBeat.o(67126);
        return paramString1;
      }
      
      protected final Filter.FilterResults performFiltering(final CharSequence paramCharSequence)
      {
        Filter.FilterResults localFilterResults;
        ArrayList localArrayList;
        Object localObject1;
        try
        {
          AppMethodBeat.i(67125);
          localFilterResults = new Filter.FilterResults();
          localArrayList = new ArrayList();
          if (paramCharSequence != null) {}
          for (localObject1 = com.tencent.mm.plugin.recharge.model.b.aaY(paramCharSequence.toString()); ((String)localObject1).equals(MallEditText.a.a(MallEditText.a.this)); localObject1 = "")
          {
            MallEditText.a(MallEditText.this).post(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(67122);
                MallEditText.a(MallEditText.this).dismissDropDown();
                AppMethodBeat.o(67122);
              }
            });
            AppMethodBeat.o(67125);
            return localFilterResults;
          }
          MallEditText.a.a(MallEditText.a.this, (String)localObject1);
          if (MallEditText.this.bAz()) {
            break label362;
          }
          if (Util.isNullOrNil(MallEditText.a.a(MallEditText.a.this))) {
            break label342;
          }
          Log.d("MicroMsg.MallEditText", "performFiltering ".concat(String.valueOf(paramCharSequence)));
          paramCharSequence = MallEditText.a.b(MallEditText.a.this).iterator();
          while (paramCharSequence.hasNext())
          {
            localObject1 = (com.tencent.mm.plugin.recharge.model.a)paramCharSequence.next();
            if (((com.tencent.mm.plugin.recharge.model.a)localObject1).Hzb.startsWith(MallEditText.a.a(MallEditText.a.this))) {
              localArrayList.add(localObject1);
            }
          }
          bool = false;
        }
        finally {}
        boolean bool;
        label215:
        if (localArrayList.size() == 0)
        {
          MallEditText.a(MallEditText.this).post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(67123);
              MallEditText.a(MallEditText.this).dismissDropDown();
              AppMethodBeat.o(67123);
            }
          });
          bool = false;
        }
        for (;;)
        {
          for (;;)
          {
            paramCharSequence = MallEditText.a.this.HzQ;
            MallEditText.a.this.HzQ = localArrayList;
            MallEditText.a.this.HzR = bool;
            localFilterResults.count = MallEditText.a.this.HzQ.size();
            localFilterResults.values = MallEditText.a.this.HzQ;
            Log.d("MicroMsg.MallEditText", "results.count " + localFilterResults.count);
            paramCharSequence.clear();
            AppMethodBeat.o(67125);
            break;
            label342:
            localArrayList.addAll(MallEditText.a.b(MallEditText.a.this));
            bool = false;
            break label215;
            label362:
            long l = System.currentTimeMillis();
            Log.d("MicroMsg.MallEditText", "performFiltering ".concat(String.valueOf(paramCharSequence)));
            paramCharSequence = MallEditText.a.b(MallEditText.a.this).iterator();
            while (paramCharSequence.hasNext())
            {
              localObject1 = (com.tencent.mm.plugin.recharge.model.a)paramCharSequence.next();
              if (((com.tencent.mm.plugin.recharge.model.a)localObject1).Hzb.equals(MallEditText.a.a(MallEditText.a.this)))
              {
                ((com.tencent.mm.plugin.recharge.model.a)localObject1).Hzc = com.tencent.mm.plugin.recharge.model.a.HyZ;
                localArrayList.clear();
                localArrayList.add(localObject1);
              }
            }
            if (localArrayList.size() <= 0)
            {
              paramCharSequence = MallEditText.f(MallEditText.this);
              if (paramCharSequence != null) {}
            }
            try
            {
              MallEditText.a(MallEditText.this, com.tencent.mm.pluginsdk.b.dN(MallEditText.this.getContext()));
              if (MallEditText.f(MallEditText.this) != null)
              {
                paramCharSequence = MallEditText.f(MallEditText.this).iterator();
                if (paramCharSequence.hasNext())
                {
                  localObject2 = (String[])paramCharSequence.next();
                  str = com.tencent.mm.plugin.recharge.model.b.aaY(localObject2[2]);
                  localObject1 = jJ(MallEditText.a.a(MallEditText.a.this), str);
                  if (!com.tencent.mm.plugin.recharge.model.a.HyZ.equals(localObject1)) {
                    break label680;
                  }
                  paramCharSequence = new com.tencent.mm.plugin.recharge.model.a(str, localObject2[1], 1);
                  paramCharSequence.Hzc = com.tencent.mm.plugin.recharge.model.a.HyZ;
                  localArrayList.clear();
                  localArrayList.add(paramCharSequence);
                }
              }
              Log.d("MicroMsg.MallEditText", " search phone number cost " + (System.currentTimeMillis() - l) + " ms ");
              bool = true;
            }
            catch (Exception paramCharSequence)
            {
              for (;;)
              {
                Object localObject2;
                String str;
                Log.printErrStackTrace("MicroMsg.MallEditText", paramCharSequence, "", new Object[0]);
                continue;
                label680:
                if ((!com.tencent.mm.plugin.recharge.model.a.Hza.equals(localObject1)) && (localArrayList.size() < 5))
                {
                  localObject2 = new com.tencent.mm.plugin.recharge.model.a(str, localObject2[1], 1);
                  ((com.tencent.mm.plugin.recharge.model.a)localObject2).Hzc = ((int[])localObject1);
                  localArrayList.add(localObject2);
                }
              }
            }
          }
          if ((localArrayList.size() == 1) && (MallEditText.this.bAz()))
          {
            paramCharSequence = (com.tencent.mm.plugin.recharge.model.a)localArrayList.get(0);
            if (com.tencent.mm.plugin.recharge.model.a.HyZ.equals(paramCharSequence.Hzc))
            {
              MallEditText.a(MallEditText.this).post(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(67124);
                  MallEditText.a(MallEditText.this, paramCharSequence);
                  if (!Util.isNullOrNil(MallEditText.e(MallEditText.this).name))
                  {
                    MallEditText.g(MallEditText.this).setText(MallEditText.e(MallEditText.this).name);
                    MallEditText.g(MallEditText.this).setVisibility(0);
                  }
                  for (;;)
                  {
                    MallEditText.a(MallEditText.this).dismissDropDown();
                    AppMethodBeat.o(67124);
                    return;
                    MallEditText.g(MallEditText.this).setText("");
                    MallEditText.g(MallEditText.this).setVisibility(8);
                  }
                }
              });
              bool = false;
            }
          }
        }
      }
      
      protected final void publishResults(CharSequence paramCharSequence, Filter.FilterResults paramFilterResults) {}
    }
  }
  
  public static abstract interface b
  {
    public abstract void ftW();
    
    public abstract void onInputValidChange(boolean paramBoolean);
  }
  
  final class c
  {
    TextView HzY;
    TextView jbF;
    
    private c() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.recharge.ui.MallEditText
 * JD-Core Version:    0.7.0.1
 */