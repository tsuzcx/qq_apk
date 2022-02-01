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
import com.tencent.mm.storage.aq;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class MallEditText
  extends LinearLayout
  implements View.OnFocusChangeListener
{
  private b Nxj;
  AutoCompleteTextView Nxk;
  boolean Nxl;
  private a Nxm;
  private List<String[]> Nxn;
  private com.tencent.mm.plugin.recharge.model.a Nxo;
  private Runnable Nxp;
  private boolean Nxq;
  private int Nxr;
  private int editType;
  private int fl;
  private int inputType;
  private TextView nnW;
  private View.OnFocusChangeListener qiH;
  private ImageView qiJ;
  private String qiK;
  private String qiL;
  private int qiM;
  public boolean qiO;
  private boolean qiQ;
  private int qiR;
  private int qiS;
  private boolean sdN;
  
  public MallEditText(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public MallEditText(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(67135);
    this.Nxm = null;
    this.qiK = "";
    this.qiL = "";
    this.inputType = 1;
    this.sdN = true;
    this.qiS = -1;
    this.qiR = 1;
    this.fl = 19;
    this.editType = -1;
    this.qiQ = false;
    this.Nxo = null;
    this.qiO = true;
    this.Nxp = null;
    this.Nxq = false;
    this.Nxr = 0;
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, a.k.MallEditText, paramInt, 0);
    paramInt = paramAttributeSet.getResourceId(a.k.MallEditText_mallHint, 0);
    if (paramInt != 0) {
      this.qiK = paramContext.getString(paramInt);
    }
    paramInt = paramAttributeSet.getResourceId(a.k.MallEditText_mallTipmsg, 0);
    if (paramInt != 0) {
      this.qiL = paramContext.getString(paramInt);
    }
    this.inputType = paramAttributeSet.getInteger(a.k.MallEditText_android_inputType, 1);
    this.qiO = paramAttributeSet.getBoolean(a.k.MallEditText_android_editable, true);
    this.fl = paramAttributeSet.getInt(a.k.MallEditText_android_gravity, 19);
    this.sdN = paramAttributeSet.getBoolean(a.k.MallEditText_android_clickable, true);
    this.qiS = paramAttributeSet.getInteger(a.k.MallEditText_android_maxLength, -1);
    this.editType = paramAttributeSet.getInteger(a.k.MallEditText_mallEditType, 0);
    this.qiM = paramAttributeSet.getInteger(a.k.MallEditText_android_imeOptions, 5);
    paramAttributeSet.recycle();
    paramAttributeSet = LayoutInflater.from(paramContext).inflate(a.g.recharge_edit_text, this, true);
    this.nnW = ((TextView)paramAttributeSet.findViewById(a.f.username_tv));
    this.Nxk = ((AutoCompleteTextView)paramAttributeSet.findViewById(a.f.hint_et));
    if (com.tencent.mm.cd.a.mp(paramContext))
    {
      this.Nxk.setTextSize(0, paramContext.getResources().getDimensionPixelSize(a.d.NormalTextSize) * com.tencent.mm.cd.a.mf(getContext()));
      label308:
      this.qiJ = ((ImageView)paramAttributeSet.findViewById(a.f.info_iv));
      Log.d("MicroMsg.MallEditText", "setFormat editType:" + this.editType);
      this.Nxk.setImeOptions(this.qiM);
      switch (this.editType)
      {
      default: 
        label384:
        this.inputType = 1;
        label389:
        this.Nxk.addTextChangedListener(new TextWatcher()
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
        this.Nxk.setOnFocusChangeListener(this);
        if (!Util.isNullOrNil(this.qiK)) {
          this.Nxk.setHint(this.qiK);
        }
        if (this.inputType == 2)
        {
          this.Nxk.setKeyListener(new NumberKeyListener()
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
          this.Nxk.setGravity(this.fl);
          if (!this.sdN)
          {
            this.Nxk.setEnabled(false);
            this.Nxk.setTextColor(getResources().getColor(a.c.normal_text_color));
            this.Nxk.setFocusable(false);
            this.Nxk.setClickable(false);
          }
          if (this.qiO) {
            break label745;
          }
          this.qiQ = true;
          this.Nxk.setEnabled(false);
          this.Nxk.setFocusable(false);
          this.Nxk.setClickable(false);
        }
        break;
      }
    }
    for (;;)
    {
      if (this.qiS != -1) {
        this.Nxk.setFilters(new InputFilter[] { new InputFilter.LengthFilter(this.qiS) });
      }
      Log.d("MicroMsg.MallEditText", "initData editType:" + this.editType);
      switch (this.editType)
      {
      default: 
        AppMethodBeat.o(67135);
        return;
        this.Nxk.setTextSize(0, com.tencent.mm.cd.a.br(paramContext, a.d.NormalTextSize));
        break label308;
        this.qiR = 13;
        this.qiS = 13;
        this.inputType = 2;
        setInfoTvImageResource(a.e.recharge_phone_contact);
        this.qiJ.setVisibility(0);
        break label389;
        if (this.qiO) {
          break label384;
        }
        this.qiJ.setImageResource(a.e.mm_submenu);
        this.qiJ.setVisibility(0);
        break label384;
        this.Nxk.setInputType(this.inputType);
        this.Nxk.setRawInputType(this.inputType);
        break label456;
        label745:
        this.qiQ = false;
      }
    }
    Log.d("MicroMsg.MallEditText", "setMobileEditTv");
    paramContext = com.tencent.mm.plugin.recharge.a.a.gFE().gFF();
    this.Nxm = new a((byte)0);
    this.Nxm.jE(paramContext);
    if ((paramContext != null) && (paramContext.size() > 0))
    {
      this.Nxo = ((com.tencent.mm.plugin.recharge.model.a)paramContext.get(0));
      setInput(this.Nxo);
    }
    for (;;)
    {
      if ((paramContext == null) || (paramContext.size() == 0))
      {
        h.baF();
        paramContext = (String)h.baE().ban().d(6, null);
        this.Nxk.setText(paramContext);
        this.Nxk.setSelection(this.Nxk.getText().length());
        gFI();
      }
      this.Nxk.setAdapter(this.Nxm);
      this.Nxk.setOnItemClickListener(new AdapterView.OnItemClickListener()
      {
        public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          AppMethodBeat.i(67118);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.cH(paramAnonymousAdapterView);
          localb.cH(paramAnonymousView);
          localb.sc(paramAnonymousInt);
          localb.hB(paramAnonymousLong);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/recharge/ui/MallEditText$4", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.aYj());
          MallEditText.a(MallEditText.this, MallEditText.d(MallEditText.this).agl(paramAnonymousInt));
          if (MallEditText.e(MallEditText.this) != null)
          {
            Log.d("MicroMsg.MallEditText", "onItemClick record.record " + MallEditText.e(MallEditText.this).NwG + ", record.name " + MallEditText.e(MallEditText.this).name);
            MallEditText.this.setInput(MallEditText.e(MallEditText.this));
          }
          MallEditText.a(MallEditText.this).dismissDropDown();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/recharge/ui/MallEditText$4", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(67118);
        }
      });
      break;
      if (this.Nxn == null) {
        new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(67117);
            try
            {
              MallEditText.a(MallEditText.this, com.tencent.mm.pluginsdk.b.eI(MallEditText.this.getContext()));
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
  
  private void gFI()
  {
    AppMethodBeat.i(67141);
    boolean bool = bZp();
    if (bool != this.qiQ)
    {
      Log.d("MicroMsg.MallEditText", "View:" + this.qiL + ", editType:" + this.editType + " inputValid change to " + bool);
      this.qiQ = bool;
      if (this.Nxj != null) {
        this.Nxj.onInputValidChange(this.qiQ);
      }
      if (!bool)
      {
        if (this.nnW.getVisibility() == 0)
        {
          this.nnW.setText("");
          this.nnW.setVisibility(8);
        }
        this.Nxo = null;
      }
    }
    if (this.Nxj != null) {
      this.Nxj.gFK();
    }
    AppMethodBeat.o(67141);
  }
  
  private void setInputForce(com.tencent.mm.plugin.recharge.model.a parama)
  {
    AppMethodBeat.i(67140);
    this.Nxo = parama;
    if (parama != null)
    {
      KeyListener localKeyListener = this.Nxk.getKeyListener();
      this.Nxk.setKeyListener(null);
      this.Nxk.setText(parama.NwG);
      this.Nxk.setSelection(this.Nxk.getText().length());
      this.Nxk.setKeyListener(localKeyListener);
      gFI();
      Log.d("MicroMsg.MallEditText", "editTv.setText " + parama.NwG + ", name " + parama.name + ", isInputValid " + this.qiQ);
      if ((!Util.isNullOrNil(parama.name)) && (this.qiQ))
      {
        this.nnW.setText(parama.name);
        this.nnW.setVisibility(0);
        AppMethodBeat.o(67140);
        return;
      }
      this.nnW.setText("");
      this.nnW.setVisibility(8);
      AppMethodBeat.o(67140);
      return;
    }
    this.Nxk.setText("");
    gFI();
    Log.d("MicroMsg.MallEditText", "editTv.setText null");
    this.nnW.setText("");
    this.nnW.setVisibility(8);
    AppMethodBeat.o(67140);
  }
  
  public final boolean bZp()
  {
    AppMethodBeat.i(67143);
    switch (this.editType)
    {
    default: 
      if (this.Nxk.getText().length() >= this.qiR)
      {
        AppMethodBeat.o(67143);
        return true;
      }
      break;
    case 1: 
      String str = this.Nxk.getText().toString();
      if ((str.length() >= this.qiR) && (str.length() <= this.qiS) && (PhoneNumberUtils.isGlobalPhoneNumber(com.tencent.mm.plugin.recharge.model.b.Tu(str))))
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
  
  public final boolean gFJ()
  {
    AppMethodBeat.i(67145);
    if (getVisibility() == 0)
    {
      if (Util.isNullOrNil(getText()))
      {
        Log.d("MicroMsg.MallEditText", "View:" + this.qiL + ", editType:" + this.editType + " checkInputValid : empty ");
        AppMethodBeat.o(67145);
        return false;
      }
      if (this.qiQ)
      {
        AppMethodBeat.o(67145);
        return true;
      }
      Log.d("MicroMsg.MallEditText", "View:" + this.qiL + ", editType:" + this.editType + " checkInputValid : illegal ");
      AppMethodBeat.o(67145);
      return false;
    }
    AppMethodBeat.o(67145);
    return true;
  }
  
  public void getFocus()
  {
    AppMethodBeat.i(67152);
    this.Nxk.findFocus();
    AppMethodBeat.o(67152);
  }
  
  public com.tencent.mm.plugin.recharge.model.a getInputRecord()
  {
    AppMethodBeat.i(67151);
    if (this.Nxo != null)
    {
      locala = this.Nxo;
      AppMethodBeat.o(67151);
      return locala;
    }
    this.Nxo = new com.tencent.mm.plugin.recharge.model.a(getText(), this.nnW.getText().toString(), 0);
    com.tencent.mm.plugin.recharge.model.a locala = this.Nxo;
    AppMethodBeat.o(67151);
    return locala;
  }
  
  public String getText()
  {
    AppMethodBeat.i(67142);
    switch (this.editType)
    {
    default: 
      str = Util.nullAs(this.Nxk.getText().toString(), "");
      AppMethodBeat.o(67142);
      return str;
    }
    String str = Util.nullAs(this.Nxk.getText().toString(), "");
    AppMethodBeat.o(67142);
    return str;
  }
  
  public void onFocusChange(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(67148);
    if (this.qiH != null) {
      this.qiH.onFocusChange(this, paramBoolean);
    }
    if (!this.Nxq) {}
    for (boolean bool = true;; bool = false)
    {
      if ((bool == paramBoolean) && (!paramBoolean) && (this.Nxp != null)) {
        this.Nxp.run();
      }
      this.Nxq = paramBoolean;
      Log.d("MicroMsg.MallEditText", "View:" + this.qiL + ", editType:" + this.editType + " onFocusChange to " + paramBoolean);
      if (this.Nxj != null) {
        this.Nxj.onInputValidChange(this.qiQ);
      }
      AppMethodBeat.o(67148);
      return;
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    return !this.qiO;
  }
  
  public void setEllipsize(TextUtils.TruncateAt paramTruncateAt)
  {
    AppMethodBeat.i(67144);
    this.Nxk.setEllipsize(paramTruncateAt);
    AppMethodBeat.o(67144);
  }
  
  public void setHintStr(String paramString)
  {
    AppMethodBeat.i(67136);
    this.Nxk.setHint(paramString);
    AppMethodBeat.o(67136);
  }
  
  public void setImeOptions(int paramInt)
  {
    AppMethodBeat.i(67149);
    this.Nxk.setImeOptions(paramInt);
    AppMethodBeat.o(67149);
  }
  
  public void setInfoTvImageResource(int paramInt)
  {
    AppMethodBeat.i(67138);
    if (paramInt == a.e.list_clear) {}
    for (boolean bool = true;; bool = false)
    {
      this.Nxl = bool;
      this.qiJ.setImageResource(paramInt);
      AppMethodBeat.o(67138);
      return;
    }
  }
  
  public void setInfoTvOnClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(67137);
    this.qiJ.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(67137);
  }
  
  public void setInput(com.tencent.mm.plugin.recharge.model.a parama)
  {
    AppMethodBeat.i(67139);
    this.Nxo = parama;
    if (parama != null)
    {
      this.Nxk.setText(parama.NwG);
      this.Nxk.setSelection(this.Nxk.getText().length());
      gFI();
      Log.d("MicroMsg.MallEditText", "editTv.setText " + parama.NwG + ", name " + parama.name + ", isInputValid " + this.qiQ);
      if ((!Util.isNullOrNil(parama.name)) && (this.qiQ))
      {
        this.nnW.setText(parama.name);
        this.nnW.setVisibility(0);
        AppMethodBeat.o(67139);
        return;
      }
      this.nnW.setText("");
      this.nnW.setVisibility(8);
      AppMethodBeat.o(67139);
      return;
    }
    this.Nxk.setText("");
    gFI();
    Log.d("MicroMsg.MallEditText", "editTv.setText null");
    this.nnW.setText("");
    this.nnW.setVisibility(8);
    AppMethodBeat.o(67139);
  }
  
  public void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(67146);
    super.setOnClickListener(paramOnClickListener);
    this.Nxk.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(67146);
  }
  
  public void setOnEditorActionListener(TextView.OnEditorActionListener paramOnEditorActionListener)
  {
    AppMethodBeat.i(67150);
    this.Nxk.setOnEditorActionListener(paramOnEditorActionListener);
    AppMethodBeat.o(67150);
  }
  
  public void setOnFocusChangeListener(View.OnFocusChangeListener paramOnFocusChangeListener)
  {
    AppMethodBeat.i(67147);
    super.setOnFocusChangeListener(paramOnFocusChangeListener);
    this.qiH = paramOnFocusChangeListener;
    AppMethodBeat.o(67147);
  }
  
  public void setOnInputValidChangeListener(b paramb)
  {
    this.Nxj = paramb;
  }
  
  final class a
    extends BaseAdapter
    implements Filterable
  {
    public List<com.tencent.mm.plugin.recharge.model.a> Nxt;
    public boolean Nxu;
    private List<com.tencent.mm.plugin.recharge.model.a> Nxv;
    private a Nxw;
    private String Nxx;
    
    private a()
    {
      AppMethodBeat.i(67127);
      this.Nxt = new ArrayList();
      this.Nxu = false;
      AppMethodBeat.o(67127);
    }
    
    public final com.tencent.mm.plugin.recharge.model.a agl(int paramInt)
    {
      com.tencent.mm.plugin.recharge.model.a locala1 = null;
      for (;;)
      {
        try
        {
          AppMethodBeat.i(67131);
          if (!this.Nxu) {
            break label79;
          }
          if (paramInt == 0)
          {
            AppMethodBeat.o(67131);
            return locala1;
          }
          if (paramInt <= this.Nxt.size())
          {
            locala1 = (com.tencent.mm.plugin.recharge.model.a)this.Nxt.get(paramInt - 1);
            AppMethodBeat.o(67131);
            continue;
          }
          AppMethodBeat.o(67131);
        }
        finally {}
        continue;
        label79:
        if (paramInt < this.Nxt.size())
        {
          com.tencent.mm.plugin.recharge.model.a locala2 = (com.tencent.mm.plugin.recharge.model.a)this.Nxt.get(paramInt);
          AppMethodBeat.o(67131);
        }
        else
        {
          AppMethodBeat.o(67131);
        }
      }
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(67130);
      int i;
      if (this.Nxu)
      {
        i = this.Nxt.size();
        AppMethodBeat.o(67130);
        return i + 2;
      }
      if (this.Nxt.size() > 0)
      {
        i = this.Nxt.size();
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
      if (this.Nxw == null) {
        this.Nxw = new a((byte)0);
      }
      a locala = this.Nxw;
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
      if (this.Nxu)
      {
        if (paramInt == 0)
        {
          AppMethodBeat.o(67133);
          return 2;
        }
        if (paramInt <= this.Nxt.size())
        {
          AppMethodBeat.o(67133);
          return 0;
        }
        AppMethodBeat.o(67133);
        return 3;
      }
      if (paramInt < this.Nxt.size())
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
          localc.NxB = ((TextView)paramViewGroup.findViewById(a.f.mall_input_record));
          localc.lDF = ((TextView)paramViewGroup.findViewById(a.f.mall_input_name));
          paramViewGroup.setTag(localc);
          locala = agl(paramInt);
          paramView = paramViewGroup;
          if (locala == null) {
            continue;
          }
          paramView = paramViewGroup;
          if (localc == null) {
            continue;
          }
          paramView = paramViewGroup;
          if (localc.NxB == null) {
            continue;
          }
          paramView = paramViewGroup;
          if (localc.lDF == null) {
            continue;
          }
          paramView = com.tencent.mm.plugin.recharge.model.b.aSA(locala.NwG);
          Log.d("MicroMsg.MallEditText", "record.record " + paramView + ", record.name " + locala.name);
          if (com.tencent.mm.plugin.recharge.model.a.NwE.equals(locala.NwH)) {
            break label404;
          }
          paramView = new SpannableStringBuilder(paramView);
          int[] arrayOfInt = locala.NwH;
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
        localc.NxB.setText(paramView);
        label337:
        if ((locala.name != null) && (!Util.isNullOrNil(locala.name.trim()))) {
          localc.lDF.setText(MallEditText.this.getResources().getString(a.i.mall_recharge_username, new Object[] { locala.name }));
        }
        for (;;)
        {
          paramViewGroup.setBackgroundResource(a.e.comm_list_item_selector);
          paramView = paramViewGroup;
          break;
          label404:
          localc.NxB.setText(paramView);
          break label337;
          localc.lDF.setText("");
        }
        paramView = View.inflate(MallEditText.this.getContext(), a.g.recharge_input_history_first_item, null);
        paramView.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(67119);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.cH(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/recharge/ui/MallEditText$MobileHistoryAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
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
            localb.cH(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/recharge/ui/MallEditText$MobileHistoryAdapter$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
            com.tencent.mm.plugin.recharge.a.a.gFE().jE(null);
            MallEditText.this.setInput(null);
            MallEditText.d(MallEditText.this).jE(new LinkedList());
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
            localb.cH(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/recharge/ui/MallEditText$MobileHistoryAdapter$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
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
    
    public final void jE(List<com.tencent.mm.plugin.recharge.model.a> paramList)
    {
      AppMethodBeat.i(67128);
      this.Nxv = paramList;
      this.Nxt.clear();
      this.Nxu = false;
      AppMethodBeat.o(67128);
    }
    
    final class a
      extends Filter
    {
      private a() {}
      
      private static int[] le(String paramString1, String paramString2)
      {
        AppMethodBeat.i(67126);
        if (paramString1.equals(paramString2))
        {
          paramString1 = com.tencent.mm.plugin.recharge.model.a.NwE;
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
        paramString1 = com.tencent.mm.plugin.recharge.model.a.NwF;
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
          for (localObject1 = com.tencent.mm.plugin.recharge.model.b.Tu(paramCharSequence.toString()); ((String)localObject1).equals(MallEditText.a.a(MallEditText.a.this)); localObject1 = "")
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
          if (MallEditText.this.bZp()) {
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
            if (((com.tencent.mm.plugin.recharge.model.a)localObject1).NwG.startsWith(MallEditText.a.a(MallEditText.a.this))) {
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
            paramCharSequence = MallEditText.a.this.Nxt;
            MallEditText.a.this.Nxt = localArrayList;
            MallEditText.a.this.Nxu = bool;
            localFilterResults.count = MallEditText.a.this.Nxt.size();
            localFilterResults.values = MallEditText.a.this.Nxt;
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
              if (((com.tencent.mm.plugin.recharge.model.a)localObject1).NwG.equals(MallEditText.a.a(MallEditText.a.this)))
              {
                ((com.tencent.mm.plugin.recharge.model.a)localObject1).NwH = com.tencent.mm.plugin.recharge.model.a.NwE;
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
              MallEditText.a(MallEditText.this, com.tencent.mm.pluginsdk.b.eI(MallEditText.this.getContext()));
              if (MallEditText.f(MallEditText.this) != null)
              {
                paramCharSequence = MallEditText.f(MallEditText.this).iterator();
                if (paramCharSequence.hasNext())
                {
                  localObject2 = (String[])paramCharSequence.next();
                  str = com.tencent.mm.plugin.recharge.model.b.Tu(localObject2[2]);
                  localObject1 = le(MallEditText.a.a(MallEditText.a.this), str);
                  if (!com.tencent.mm.plugin.recharge.model.a.NwE.equals(localObject1)) {
                    break label680;
                  }
                  paramCharSequence = new com.tencent.mm.plugin.recharge.model.a(str, localObject2[1], 1);
                  paramCharSequence.NwH = com.tencent.mm.plugin.recharge.model.a.NwE;
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
                if ((!com.tencent.mm.plugin.recharge.model.a.NwF.equals(localObject1)) && (localArrayList.size() < 5))
                {
                  localObject2 = new com.tencent.mm.plugin.recharge.model.a(str, localObject2[1], 1);
                  ((com.tencent.mm.plugin.recharge.model.a)localObject2).NwH = ((int[])localObject1);
                  localArrayList.add(localObject2);
                }
              }
            }
          }
          if ((localArrayList.size() == 1) && (MallEditText.this.bZp()))
          {
            paramCharSequence = (com.tencent.mm.plugin.recharge.model.a)localArrayList.get(0);
            if (com.tencent.mm.plugin.recharge.model.a.NwE.equals(paramCharSequence.NwH))
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
    public abstract void gFK();
    
    public abstract void onInputValidChange(boolean paramBoolean);
  }
  
  final class c
  {
    TextView NxB;
    TextView lDF;
    
    private c() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.recharge.ui.MallEditText
 * JD-Core Version:    0.7.0.1
 */