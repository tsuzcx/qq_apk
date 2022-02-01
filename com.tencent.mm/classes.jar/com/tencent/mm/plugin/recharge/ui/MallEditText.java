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
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wxpay.a.a;
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
  private b BDC;
  AutoCompleteTextView BDD;
  boolean BDE;
  private a BDF;
  private List<String[]> BDG;
  private com.tencent.mm.plugin.recharge.model.a BDH;
  private Runnable BDI;
  private boolean BDJ;
  private int BDK;
  private int gravity;
  private TextView hXv;
  private int imeOptions;
  private int inputType;
  private View.OnFocusChangeListener ktK;
  private ImageView ktM;
  private String ktN;
  private String ktO;
  private int ktP;
  public boolean ktR;
  private boolean ktT;
  private int ktU;
  private int ktV;
  private boolean maw;
  
  public MallEditText(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public MallEditText(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(67135);
    this.BDF = null;
    this.ktN = "";
    this.ktO = "";
    this.inputType = 1;
    this.maw = true;
    this.ktV = -1;
    this.ktU = 1;
    this.gravity = 19;
    this.ktP = -1;
    this.ktT = false;
    this.BDH = null;
    this.ktR = true;
    this.BDI = null;
    this.BDJ = false;
    this.BDK = 0;
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, a.a.MallEditText, paramInt, 0);
    paramInt = paramAttributeSet.getResourceId(7, 0);
    if (paramInt != 0) {
      this.ktN = paramContext.getString(paramInt);
    }
    paramInt = paramAttributeSet.getResourceId(8, 0);
    if (paramInt != 0) {
      this.ktO = paramContext.getString(paramInt);
    }
    this.inputType = paramAttributeSet.getInteger(4, 1);
    this.ktR = paramAttributeSet.getBoolean(3, true);
    this.gravity = paramAttributeSet.getInt(0, 19);
    this.maw = paramAttributeSet.getBoolean(1, true);
    this.ktV = paramAttributeSet.getInteger(2, -1);
    this.ktP = paramAttributeSet.getInteger(6, 0);
    this.imeOptions = paramAttributeSet.getInteger(5, 5);
    paramAttributeSet.recycle();
    paramAttributeSet = LayoutInflater.from(paramContext).inflate(2131496045, this, true);
    this.hXv = ((TextView)paramAttributeSet.findViewById(2131309652));
    this.BDD = ((AutoCompleteTextView)paramAttributeSet.findViewById(2131302331));
    if (com.tencent.mm.cb.a.jk(paramContext))
    {
      this.BDD.setTextSize(0, paramContext.getResources().getDimensionPixelSize(2131165535) * com.tencent.mm.cb.a.iZ(getContext()));
      label289:
      this.ktM = ((ImageView)paramAttributeSet.findViewById(2131302653));
      Log.d("MicroMsg.MallEditText", "setFormat editType:" + this.ktP);
      this.BDD.setImeOptions(this.imeOptions);
      switch (this.ktP)
      {
      default: 
        label364:
        this.inputType = 1;
        label369:
        this.BDD.addTextChangedListener(new TextWatcher()
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
        this.BDD.setOnFocusChangeListener(this);
        if (!Util.isNullOrNil(this.ktN)) {
          this.BDD.setHint(this.ktN);
        }
        if (this.inputType == 2)
        {
          this.BDD.setKeyListener(new NumberKeyListener()
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
          label436:
          this.BDD.setGravity(this.gravity);
          if (!this.maw)
          {
            this.BDD.setEnabled(false);
            this.BDD.setTextColor(getResources().getColor(2131100904));
            this.BDD.setFocusable(false);
            this.BDD.setClickable(false);
          }
          if (this.ktR) {
            break label724;
          }
          this.ktT = true;
          this.BDD.setEnabled(false);
          this.BDD.setFocusable(false);
          this.BDD.setClickable(false);
        }
        break;
      }
    }
    for (;;)
    {
      if (this.ktV != -1) {
        this.BDD.setFilters(new InputFilter[] { new InputFilter.LengthFilter(this.ktV) });
      }
      Log.d("MicroMsg.MallEditText", "initData editType:" + this.ktP);
      switch (this.ktP)
      {
      default: 
        AppMethodBeat.o(67135);
        return;
        this.BDD.setTextSize(0, com.tencent.mm.cb.a.aG(paramContext, 2131165535));
        break label289;
        this.ktU = 13;
        this.ktV = 13;
        this.inputType = 2;
        setInfoTvImageResource(2131234625);
        this.ktM.setVisibility(0);
        break label369;
        if (this.ktR) {
          break label364;
        }
        this.ktM.setImageResource(2131233959);
        this.ktM.setVisibility(0);
        break label364;
        this.BDD.setInputType(this.inputType);
        this.BDD.setRawInputType(this.inputType);
        break label436;
        label724:
        this.ktT = false;
      }
    }
    Log.d("MicroMsg.MallEditText", "setMobileEditTv");
    paramContext = com.tencent.mm.plugin.recharge.a.a.eHL().eHM();
    this.BDF = new a((byte)0);
    this.BDF.ga(paramContext);
    if ((paramContext != null) && (paramContext.size() > 0))
    {
      this.BDH = ((com.tencent.mm.plugin.recharge.model.a)paramContext.get(0));
      setInput(this.BDH);
    }
    for (;;)
    {
      if ((paramContext == null) || (paramContext.size() == 0))
      {
        g.aAi();
        paramContext = (String)g.aAh().azQ().get(6, null);
        this.BDD.setText(paramContext);
        this.BDD.setSelection(this.BDD.getText().length());
        eHP();
      }
      this.BDD.setAdapter(this.BDF);
      this.BDD.setOnItemClickListener(new AdapterView.OnItemClickListener()
      {
        public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          AppMethodBeat.i(67118);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousAdapterView);
          localb.bm(paramAnonymousView);
          localb.pH(paramAnonymousInt);
          localb.zo(paramAnonymousLong);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/recharge/ui/MallEditText$4", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.axR());
          MallEditText.a(MallEditText.this, MallEditText.d(MallEditText.this).Vp(paramAnonymousInt));
          if (MallEditText.e(MallEditText.this) != null)
          {
            Log.d("MicroMsg.MallEditText", "onItemClick record.record " + MallEditText.e(MallEditText.this).BCX + ", record.name " + MallEditText.e(MallEditText.this).name);
            MallEditText.this.setInput(MallEditText.e(MallEditText.this));
          }
          MallEditText.a(MallEditText.this).dismissDropDown();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/recharge/ui/MallEditText$4", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(67118);
        }
      });
      break;
      if (this.BDG == null) {
        new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(67117);
            try
            {
              MallEditText.a(MallEditText.this, com.tencent.mm.pluginsdk.b.dO(MallEditText.this.getContext()));
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
  
  private void eHP()
  {
    AppMethodBeat.i(67141);
    boolean bool = bql();
    if (bool != this.ktT)
    {
      Log.d("MicroMsg.MallEditText", "View:" + this.ktO + ", editType:" + this.ktP + " inputValid change to " + bool);
      this.ktT = bool;
      if (this.BDC != null) {
        this.BDC.onInputValidChange(this.ktT);
      }
      if (!bool)
      {
        if (this.hXv.getVisibility() == 0)
        {
          this.hXv.setText("");
          this.hXv.setVisibility(8);
        }
        this.BDH = null;
      }
    }
    if (this.BDC != null) {
      this.BDC.eHR();
    }
    AppMethodBeat.o(67141);
  }
  
  private void setInputForce(com.tencent.mm.plugin.recharge.model.a parama)
  {
    AppMethodBeat.i(67140);
    this.BDH = parama;
    if (parama != null)
    {
      KeyListener localKeyListener = this.BDD.getKeyListener();
      this.BDD.setKeyListener(null);
      this.BDD.setText(parama.BCX);
      this.BDD.setSelection(this.BDD.getText().length());
      this.BDD.setKeyListener(localKeyListener);
      eHP();
      Log.d("MicroMsg.MallEditText", "editTv.setText " + parama.BCX + ", name " + parama.name + ", isInputValid " + this.ktT);
      if ((!Util.isNullOrNil(parama.name)) && (this.ktT))
      {
        this.hXv.setText(parama.name);
        this.hXv.setVisibility(0);
        AppMethodBeat.o(67140);
        return;
      }
      this.hXv.setText("");
      this.hXv.setVisibility(8);
      AppMethodBeat.o(67140);
      return;
    }
    this.BDD.setText("");
    eHP();
    Log.d("MicroMsg.MallEditText", "editTv.setText null");
    this.hXv.setText("");
    this.hXv.setVisibility(8);
    AppMethodBeat.o(67140);
  }
  
  public final boolean bql()
  {
    AppMethodBeat.i(67143);
    switch (this.ktP)
    {
    default: 
      if (this.BDD.getText().length() >= this.ktU)
      {
        AppMethodBeat.o(67143);
        return true;
      }
      break;
    case 1: 
      String str = this.BDD.getText().toString();
      if ((str.length() >= this.ktU) && (str.length() <= this.ktV) && (PhoneNumberUtils.isGlobalPhoneNumber(com.tencent.mm.plugin.recharge.model.b.Ts(str))))
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
  
  public final boolean eHQ()
  {
    AppMethodBeat.i(67145);
    if (getVisibility() == 0)
    {
      if (Util.isNullOrNil(getText()))
      {
        Log.d("MicroMsg.MallEditText", "View:" + this.ktO + ", editType:" + this.ktP + " checkInputValid : empty ");
        AppMethodBeat.o(67145);
        return false;
      }
      if (this.ktT)
      {
        AppMethodBeat.o(67145);
        return true;
      }
      Log.d("MicroMsg.MallEditText", "View:" + this.ktO + ", editType:" + this.ktP + " checkInputValid : illegal ");
      AppMethodBeat.o(67145);
      return false;
    }
    AppMethodBeat.o(67145);
    return true;
  }
  
  public void getFocus()
  {
    AppMethodBeat.i(67152);
    this.BDD.findFocus();
    AppMethodBeat.o(67152);
  }
  
  public com.tencent.mm.plugin.recharge.model.a getInputRecord()
  {
    AppMethodBeat.i(67151);
    if (this.BDH != null)
    {
      locala = this.BDH;
      AppMethodBeat.o(67151);
      return locala;
    }
    this.BDH = new com.tencent.mm.plugin.recharge.model.a(getText(), this.hXv.getText().toString(), 0);
    com.tencent.mm.plugin.recharge.model.a locala = this.BDH;
    AppMethodBeat.o(67151);
    return locala;
  }
  
  public String getText()
  {
    AppMethodBeat.i(67142);
    switch (this.ktP)
    {
    default: 
      str = Util.nullAs(this.BDD.getText().toString(), "");
      AppMethodBeat.o(67142);
      return str;
    }
    String str = Util.nullAs(this.BDD.getText().toString(), "");
    AppMethodBeat.o(67142);
    return str;
  }
  
  public void onFocusChange(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(67148);
    if (this.ktK != null) {
      this.ktK.onFocusChange(this, paramBoolean);
    }
    if (!this.BDJ) {}
    for (boolean bool = true;; bool = false)
    {
      if ((bool == paramBoolean) && (!paramBoolean) && (this.BDI != null)) {
        this.BDI.run();
      }
      this.BDJ = paramBoolean;
      Log.d("MicroMsg.MallEditText", "View:" + this.ktO + ", editType:" + this.ktP + " onFocusChange to " + paramBoolean);
      if (this.BDC != null) {
        this.BDC.onInputValidChange(this.ktT);
      }
      AppMethodBeat.o(67148);
      return;
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    return !this.ktR;
  }
  
  public void setEllipsize(TextUtils.TruncateAt paramTruncateAt)
  {
    AppMethodBeat.i(67144);
    this.BDD.setEllipsize(paramTruncateAt);
    AppMethodBeat.o(67144);
  }
  
  public void setHintStr(String paramString)
  {
    AppMethodBeat.i(67136);
    this.BDD.setHint(paramString);
    AppMethodBeat.o(67136);
  }
  
  public void setImeOptions(int paramInt)
  {
    AppMethodBeat.i(67149);
    this.BDD.setImeOptions(paramInt);
    AppMethodBeat.o(67149);
  }
  
  public void setInfoTvImageResource(int paramInt)
  {
    AppMethodBeat.i(67138);
    if (paramInt == 2131233321) {}
    for (boolean bool = true;; bool = false)
    {
      this.BDE = bool;
      this.ktM.setImageResource(paramInt);
      AppMethodBeat.o(67138);
      return;
    }
  }
  
  public void setInfoTvOnClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(67137);
    this.ktM.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(67137);
  }
  
  public void setInput(com.tencent.mm.plugin.recharge.model.a parama)
  {
    AppMethodBeat.i(67139);
    this.BDH = parama;
    if (parama != null)
    {
      this.BDD.setText(parama.BCX);
      this.BDD.setSelection(this.BDD.getText().length());
      eHP();
      Log.d("MicroMsg.MallEditText", "editTv.setText " + parama.BCX + ", name " + parama.name + ", isInputValid " + this.ktT);
      if ((!Util.isNullOrNil(parama.name)) && (this.ktT))
      {
        this.hXv.setText(parama.name);
        this.hXv.setVisibility(0);
        AppMethodBeat.o(67139);
        return;
      }
      this.hXv.setText("");
      this.hXv.setVisibility(8);
      AppMethodBeat.o(67139);
      return;
    }
    this.BDD.setText("");
    eHP();
    Log.d("MicroMsg.MallEditText", "editTv.setText null");
    this.hXv.setText("");
    this.hXv.setVisibility(8);
    AppMethodBeat.o(67139);
  }
  
  public void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(67146);
    super.setOnClickListener(paramOnClickListener);
    this.BDD.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(67146);
  }
  
  public void setOnEditorActionListener(TextView.OnEditorActionListener paramOnEditorActionListener)
  {
    AppMethodBeat.i(67150);
    this.BDD.setOnEditorActionListener(paramOnEditorActionListener);
    AppMethodBeat.o(67150);
  }
  
  public void setOnFocusChangeListener(View.OnFocusChangeListener paramOnFocusChangeListener)
  {
    AppMethodBeat.i(67147);
    super.setOnFocusChangeListener(paramOnFocusChangeListener);
    this.ktK = paramOnFocusChangeListener;
    AppMethodBeat.o(67147);
  }
  
  public void setOnInputValidChangeListener(b paramb)
  {
    this.BDC = paramb;
  }
  
  final class a
    extends BaseAdapter
    implements Filterable
  {
    public List<com.tencent.mm.plugin.recharge.model.a> BDM;
    public boolean BDN;
    private List<com.tencent.mm.plugin.recharge.model.a> BDO;
    private a BDP;
    private String BDQ;
    
    private a()
    {
      AppMethodBeat.i(67127);
      this.BDM = new ArrayList();
      this.BDN = false;
      AppMethodBeat.o(67127);
    }
    
    public final com.tencent.mm.plugin.recharge.model.a Vp(int paramInt)
    {
      com.tencent.mm.plugin.recharge.model.a locala1 = null;
      for (;;)
      {
        try
        {
          AppMethodBeat.i(67131);
          if (!this.BDN) {
            break label79;
          }
          if (paramInt == 0)
          {
            AppMethodBeat.o(67131);
            return locala1;
          }
          if (paramInt <= this.BDM.size())
          {
            locala1 = (com.tencent.mm.plugin.recharge.model.a)this.BDM.get(paramInt - 1);
            AppMethodBeat.o(67131);
            continue;
          }
          AppMethodBeat.o(67131);
        }
        finally {}
        continue;
        label79:
        if (paramInt < this.BDM.size())
        {
          com.tencent.mm.plugin.recharge.model.a locala2 = (com.tencent.mm.plugin.recharge.model.a)this.BDM.get(paramInt);
          AppMethodBeat.o(67131);
        }
        else
        {
          AppMethodBeat.o(67131);
        }
      }
    }
    
    public final void ga(List<com.tencent.mm.plugin.recharge.model.a> paramList)
    {
      AppMethodBeat.i(67128);
      this.BDO = paramList;
      this.BDM.clear();
      this.BDN = false;
      AppMethodBeat.o(67128);
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(67130);
      int i;
      if (this.BDN)
      {
        i = this.BDM.size();
        AppMethodBeat.o(67130);
        return i + 2;
      }
      if (this.BDM.size() > 0)
      {
        i = this.BDM.size();
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
      if (this.BDP == null) {
        this.BDP = new a((byte)0);
      }
      a locala = this.BDP;
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
      if (this.BDN)
      {
        if (paramInt == 0)
        {
          AppMethodBeat.o(67133);
          return 2;
        }
        if (paramInt <= this.BDM.size())
        {
          AppMethodBeat.o(67133);
          return 0;
        }
        AppMethodBeat.o(67133);
        return 3;
      }
      if (paramInt < this.BDM.size())
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
        label235:
        int j;
        if (paramView == null)
        {
          paramViewGroup = View.inflate(MallEditText.this.getContext(), 2131496048, null);
          localc = new MallEditText.c(MallEditText.this, (byte)0);
          localc.BDU = ((TextView)paramViewGroup.findViewById(2131304362));
          localc.gxs = ((TextView)paramViewGroup.findViewById(2131304361));
          paramViewGroup.setTag(localc);
          locala = Vp(paramInt);
          paramView = paramViewGroup;
          if (locala == null) {
            continue;
          }
          paramView = paramViewGroup;
          if (localc == null) {
            continue;
          }
          paramView = paramViewGroup;
          if (localc.BDU == null) {
            continue;
          }
          paramView = paramViewGroup;
          if (localc.gxs == null) {
            continue;
          }
          paramView = com.tencent.mm.plugin.recharge.model.b.aKR(locala.BCX);
          Log.d("MicroMsg.MallEditText", "record.record " + paramView + ", record.name " + locala.name);
          if (com.tencent.mm.plugin.recharge.model.a.BCV.equals(locala.BCY)) {
            break label399;
          }
          paramView = new SpannableStringBuilder(paramView);
          int[] arrayOfInt = locala.BCY;
          int k = arrayOfInt.length;
          i = 0;
          if (i >= k) {
            break label325;
          }
          j = arrayOfInt[i];
          if (j >= 0)
          {
            if (j < 7) {
              break label308;
            }
            paramInt = j + 2;
          }
        }
        for (;;)
        {
          paramView.setSpan(new ForegroundColorSpan(-65536), paramInt, paramInt + 1, 34);
          i += 1;
          break label235;
          localc = (MallEditText.c)paramView.getTag();
          paramViewGroup = paramView;
          break;
          label308:
          paramInt = j;
          if (j >= 3) {
            paramInt = j + 1;
          }
        }
        label325:
        localc.BDU.setText(paramView);
        label334:
        if ((locala.name != null) && (!Util.isNullOrNil(locala.name.trim()))) {
          localc.gxs.setText(MallEditText.this.getResources().getString(2131762952, new Object[] { locala.name }));
        }
        for (;;)
        {
          paramViewGroup.setBackgroundResource(2131231898);
          paramView = paramViewGroup;
          break;
          label399:
          localc.BDU.setText(paramView);
          break label334;
          localc.gxs.setText("");
        }
        paramView = View.inflate(MallEditText.this.getContext(), 2131496047, null);
        paramView.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(67119);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bm(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/recharge/ui/MallEditText$MobileHistoryAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
            MallEditText.a(MallEditText.this).dismissDropDown();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/recharge/ui/MallEditText$MobileHistoryAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(67119);
          }
        });
        continue;
        paramView = View.inflate(MallEditText.this.getContext(), 2131496049, null);
        paramView.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(67120);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bm(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/recharge/ui/MallEditText$MobileHistoryAdapter$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
            com.tencent.mm.plugin.recharge.a.a.eHL().ga(null);
            MallEditText.this.setInput(null);
            MallEditText.d(MallEditText.this).ga(new LinkedList());
            MallEditText.d(MallEditText.this).notifyDataSetChanged();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/recharge/ui/MallEditText$MobileHistoryAdapter$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(67120);
          }
        });
        continue;
        paramView = View.inflate(MallEditText.this.getContext(), 2131496049, null);
        ((TextView)paramView).setText(2131762941);
        paramView.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(67121);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bm(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/recharge/ui/MallEditText$MobileHistoryAdapter$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
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
      
      private static int[] jy(String paramString1, String paramString2)
      {
        AppMethodBeat.i(67126);
        if (paramString1.equals(paramString2))
        {
          paramString1 = com.tencent.mm.plugin.recharge.model.a.BCV;
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
        paramString1 = com.tencent.mm.plugin.recharge.model.a.BCW;
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
          for (localObject1 = com.tencent.mm.plugin.recharge.model.b.Ts(paramCharSequence.toString()); ((String)localObject1).equals(MallEditText.a.a(MallEditText.a.this)); localObject1 = "")
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
          if (MallEditText.this.bql()) {
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
            if (((com.tencent.mm.plugin.recharge.model.a)localObject1).BCX.startsWith(MallEditText.a.a(MallEditText.a.this))) {
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
            paramCharSequence = MallEditText.a.this.BDM;
            MallEditText.a.this.BDM = localArrayList;
            MallEditText.a.this.BDN = bool;
            localFilterResults.count = MallEditText.a.this.BDM.size();
            localFilterResults.values = MallEditText.a.this.BDM;
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
              if (((com.tencent.mm.plugin.recharge.model.a)localObject1).BCX.equals(MallEditText.a.a(MallEditText.a.this)))
              {
                ((com.tencent.mm.plugin.recharge.model.a)localObject1).BCY = com.tencent.mm.plugin.recharge.model.a.BCV;
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
              MallEditText.a(MallEditText.this, com.tencent.mm.pluginsdk.b.dO(MallEditText.this.getContext()));
              if (MallEditText.f(MallEditText.this) != null)
              {
                paramCharSequence = MallEditText.f(MallEditText.this).iterator();
                if (paramCharSequence.hasNext())
                {
                  localObject2 = (String[])paramCharSequence.next();
                  str = com.tencent.mm.plugin.recharge.model.b.Ts(localObject2[2]);
                  localObject1 = jy(MallEditText.a.a(MallEditText.a.this), str);
                  if (!com.tencent.mm.plugin.recharge.model.a.BCV.equals(localObject1)) {
                    break label680;
                  }
                  paramCharSequence = new com.tencent.mm.plugin.recharge.model.a(str, localObject2[1], 1);
                  paramCharSequence.BCY = com.tencent.mm.plugin.recharge.model.a.BCV;
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
                if ((!com.tencent.mm.plugin.recharge.model.a.BCW.equals(localObject1)) && (localArrayList.size() < 5))
                {
                  localObject2 = new com.tencent.mm.plugin.recharge.model.a(str, localObject2[1], 1);
                  ((com.tencent.mm.plugin.recharge.model.a)localObject2).BCY = ((int[])localObject1);
                  localArrayList.add(localObject2);
                }
              }
            }
          }
          if ((localArrayList.size() == 1) && (MallEditText.this.bql()))
          {
            paramCharSequence = (com.tencent.mm.plugin.recharge.model.a)localArrayList.get(0);
            if (com.tencent.mm.plugin.recharge.model.a.BCV.equals(paramCharSequence.BCY))
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
    public abstract void eHR();
    
    public abstract void onInputValidChange(boolean paramBoolean);
  }
  
  final class c
  {
    TextView BDU;
    TextView gxs;
    
    private c() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.recharge.ui.MallEditText
 * JD-Core Version:    0.7.0.1
 */