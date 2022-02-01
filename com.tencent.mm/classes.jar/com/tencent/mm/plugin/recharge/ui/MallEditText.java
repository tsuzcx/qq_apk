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
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class MallEditText
  extends LinearLayout
  implements View.OnFocusChangeListener
{
  private int gravity;
  private TextView heI;
  private int imeOptions;
  private int inputType;
  private String jvA;
  private int jvB;
  public boolean jvD;
  private boolean jvF;
  private int jvG;
  private int jvH;
  private View.OnFocusChangeListener jvw;
  private ImageView jvy;
  private String jvz;
  private boolean kVo;
  private b xDD;
  AutoCompleteTextView xDE;
  boolean xDF;
  private a xDG;
  private List<String[]> xDH;
  private com.tencent.mm.plugin.recharge.model.a xDI;
  private Runnable xDJ;
  private boolean xDK;
  private int xDL;
  
  public MallEditText(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public MallEditText(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(67135);
    this.xDG = null;
    this.jvz = "";
    this.jvA = "";
    this.inputType = 1;
    this.kVo = true;
    this.jvH = -1;
    this.jvG = 1;
    this.gravity = 19;
    this.jvB = -1;
    this.jvF = false;
    this.xDI = null;
    this.jvD = true;
    this.xDJ = null;
    this.xDK = false;
    this.xDL = 0;
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, a.a.MallEditText, paramInt, 0);
    paramInt = paramAttributeSet.getResourceId(7, 0);
    if (paramInt != 0) {
      this.jvz = paramContext.getString(paramInt);
    }
    paramInt = paramAttributeSet.getResourceId(8, 0);
    if (paramInt != 0) {
      this.jvA = paramContext.getString(paramInt);
    }
    this.inputType = paramAttributeSet.getInteger(4, 1);
    this.jvD = paramAttributeSet.getBoolean(3, true);
    this.gravity = paramAttributeSet.getInt(0, 19);
    this.kVo = paramAttributeSet.getBoolean(1, true);
    this.jvH = paramAttributeSet.getInteger(2, -1);
    this.jvB = paramAttributeSet.getInteger(6, 0);
    this.imeOptions = paramAttributeSet.getInteger(5, 5);
    paramAttributeSet.recycle();
    paramAttributeSet = LayoutInflater.from(paramContext).inflate(2131495202, this, true);
    this.heI = ((TextView)paramAttributeSet.findViewById(2131306253));
    this.xDE = ((AutoCompleteTextView)paramAttributeSet.findViewById(2131300744));
    if (com.tencent.mm.cb.a.ir(paramContext))
    {
      this.xDE.setTextSize(0, paramContext.getResources().getDimensionPixelSize(2131165517) * com.tencent.mm.cb.a.ig(getContext()));
      label289:
      this.jvy = ((ImageView)paramAttributeSet.findViewById(2131301009));
      ae.d("MicroMsg.MallEditText", "setFormat editType:" + this.jvB);
      this.xDE.setImeOptions(this.imeOptions);
      switch (this.jvB)
      {
      default: 
        label364:
        this.inputType = 1;
        label369:
        this.xDE.addTextChangedListener(new TextWatcher()
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
        this.xDE.setOnFocusChangeListener(this);
        if (!bu.isNullOrNil(this.jvz)) {
          this.xDE.setHint(this.jvz);
        }
        if (this.inputType == 2)
        {
          this.xDE.setKeyListener(new NumberKeyListener()
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
          this.xDE.setGravity(this.gravity);
          if (!this.kVo)
          {
            this.xDE.setEnabled(false);
            this.xDE.setTextColor(getResources().getColor(2131100711));
            this.xDE.setFocusable(false);
            this.xDE.setClickable(false);
          }
          if (this.jvD) {
            break label724;
          }
          this.jvF = true;
          this.xDE.setEnabled(false);
          this.xDE.setFocusable(false);
          this.xDE.setClickable(false);
        }
        break;
      }
    }
    for (;;)
    {
      if (this.jvH != -1) {
        this.xDE.setFilters(new InputFilter[] { new InputFilter.LengthFilter(this.jvH) });
      }
      ae.d("MicroMsg.MallEditText", "initData editType:" + this.jvB);
      switch (this.jvB)
      {
      default: 
        AppMethodBeat.o(67135);
        return;
        this.xDE.setTextSize(0, com.tencent.mm.cb.a.ax(paramContext, 2131165517));
        break label289;
        this.jvG = 13;
        this.jvH = 13;
        this.inputType = 2;
        setInfoTvImageResource(2131233803);
        this.jvy.setVisibility(0);
        break label369;
        if (this.jvD) {
          break label364;
        }
        this.jvy.setImageResource(2131233284);
        this.jvy.setVisibility(0);
        break label364;
        this.xDE.setInputType(this.inputType);
        this.xDE.setRawInputType(this.inputType);
        break label436;
        label724:
        this.jvF = false;
      }
    }
    ae.d("MicroMsg.MallEditText", "setMobileEditTv");
    paramContext = com.tencent.mm.plugin.recharge.a.a.dGX().dGY();
    this.xDG = new a((byte)0);
    this.xDG.fe(paramContext);
    if ((paramContext != null) && (paramContext.size() > 0))
    {
      this.xDI = ((com.tencent.mm.plugin.recharge.model.a)paramContext.get(0));
      setInput(this.xDI);
    }
    for (;;)
    {
      if ((paramContext == null) || (paramContext.size() == 0))
      {
        g.ajS();
        paramContext = (String)g.ajR().ajA().get(6, null);
        this.xDE.setText(paramContext);
        this.xDE.setSelection(this.xDE.getText().length());
        dHb();
      }
      this.xDE.setAdapter(this.xDG);
      this.xDE.setOnItemClickListener(new AdapterView.OnItemClickListener()
      {
        public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          AppMethodBeat.i(67118);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousAdapterView);
          localb.bd(paramAnonymousView);
          localb.mu(paramAnonymousInt);
          localb.rl(paramAnonymousLong);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/recharge/ui/MallEditText$4", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.ahF());
          MallEditText.a(MallEditText.this, MallEditText.d(MallEditText.this).Oa(paramAnonymousInt));
          if (MallEditText.e(MallEditText.this) != null)
          {
            ae.d("MicroMsg.MallEditText", "onItemClick record.record " + MallEditText.e(MallEditText.this).xCY + ", record.name " + MallEditText.e(MallEditText.this).name);
            MallEditText.this.setInput(MallEditText.e(MallEditText.this));
          }
          MallEditText.a(MallEditText.this).dismissDropDown();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/recharge/ui/MallEditText$4", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(67118);
        }
      });
      break;
      if (this.xDH == null) {
        new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(67117);
            try
            {
              MallEditText.a(MallEditText.this, com.tencent.mm.pluginsdk.b.dt(MallEditText.this.getContext()));
              AppMethodBeat.o(67117);
              return;
            }
            catch (Exception localException)
            {
              ae.printErrStackTrace("MicroMsg.MallEditText", localException, "", new Object[0]);
              AppMethodBeat.o(67117);
            }
          }
        }.run();
      }
    }
  }
  
  private void dHb()
  {
    AppMethodBeat.i(67141);
    boolean bool = aVz();
    if (bool != this.jvF)
    {
      ae.d("MicroMsg.MallEditText", "View:" + this.jvA + ", editType:" + this.jvB + " inputValid change to " + bool);
      this.jvF = bool;
      if (this.xDD != null) {
        this.xDD.onInputValidChange(this.jvF);
      }
      if (!bool)
      {
        if (this.heI.getVisibility() == 0)
        {
          this.heI.setText("");
          this.heI.setVisibility(8);
        }
        this.xDI = null;
      }
    }
    if (this.xDD != null) {
      this.xDD.dHd();
    }
    AppMethodBeat.o(67141);
  }
  
  private void setInputForce(com.tencent.mm.plugin.recharge.model.a parama)
  {
    AppMethodBeat.i(67140);
    this.xDI = parama;
    if (parama != null)
    {
      KeyListener localKeyListener = this.xDE.getKeyListener();
      this.xDE.setKeyListener(null);
      this.xDE.setText(parama.xCY);
      this.xDE.setSelection(this.xDE.getText().length());
      this.xDE.setKeyListener(localKeyListener);
      dHb();
      ae.d("MicroMsg.MallEditText", "editTv.setText " + parama.xCY + ", name " + parama.name + ", isInputValid " + this.jvF);
      if ((!bu.isNullOrNil(parama.name)) && (this.jvF))
      {
        this.heI.setText(parama.name);
        this.heI.setVisibility(0);
        AppMethodBeat.o(67140);
        return;
      }
      this.heI.setText("");
      this.heI.setVisibility(8);
      AppMethodBeat.o(67140);
      return;
    }
    this.xDE.setText("");
    dHb();
    ae.d("MicroMsg.MallEditText", "editTv.setText null");
    this.heI.setText("");
    this.heI.setVisibility(8);
    AppMethodBeat.o(67140);
  }
  
  public final boolean aVz()
  {
    AppMethodBeat.i(67143);
    switch (this.jvB)
    {
    default: 
      if (this.xDE.getText().length() >= this.jvG)
      {
        AppMethodBeat.o(67143);
        return true;
      }
      break;
    case 1: 
      String str = this.xDE.getText().toString();
      if ((str.length() >= this.jvG) && (str.length() <= this.jvH) && (PhoneNumberUtils.isGlobalPhoneNumber(com.tencent.mm.plugin.recharge.model.b.Ku(str))))
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
  
  public final boolean dHc()
  {
    AppMethodBeat.i(67145);
    if (getVisibility() == 0)
    {
      if (bu.isNullOrNil(getText()))
      {
        ae.d("MicroMsg.MallEditText", "View:" + this.jvA + ", editType:" + this.jvB + " checkInputValid : empty ");
        AppMethodBeat.o(67145);
        return false;
      }
      if (this.jvF)
      {
        AppMethodBeat.o(67145);
        return true;
      }
      ae.d("MicroMsg.MallEditText", "View:" + this.jvA + ", editType:" + this.jvB + " checkInputValid : illegal ");
      AppMethodBeat.o(67145);
      return false;
    }
    AppMethodBeat.o(67145);
    return true;
  }
  
  public void getFocus()
  {
    AppMethodBeat.i(67152);
    this.xDE.findFocus();
    AppMethodBeat.o(67152);
  }
  
  public com.tencent.mm.plugin.recharge.model.a getInputRecord()
  {
    AppMethodBeat.i(67151);
    if (this.xDI != null)
    {
      locala = this.xDI;
      AppMethodBeat.o(67151);
      return locala;
    }
    this.xDI = new com.tencent.mm.plugin.recharge.model.a(getText(), this.heI.getText().toString(), 0);
    com.tencent.mm.plugin.recharge.model.a locala = this.xDI;
    AppMethodBeat.o(67151);
    return locala;
  }
  
  public String getText()
  {
    AppMethodBeat.i(67142);
    switch (this.jvB)
    {
    default: 
      str = bu.bI(this.xDE.getText().toString(), "");
      AppMethodBeat.o(67142);
      return str;
    }
    String str = bu.bI(this.xDE.getText().toString(), "");
    AppMethodBeat.o(67142);
    return str;
  }
  
  public void onFocusChange(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(67148);
    if (this.jvw != null) {
      this.jvw.onFocusChange(this, paramBoolean);
    }
    if (!this.xDK) {}
    for (boolean bool = true;; bool = false)
    {
      if ((bool == paramBoolean) && (!paramBoolean) && (this.xDJ != null)) {
        this.xDJ.run();
      }
      this.xDK = paramBoolean;
      ae.d("MicroMsg.MallEditText", "View:" + this.jvA + ", editType:" + this.jvB + " onFocusChange to " + paramBoolean);
      if (this.xDD != null) {
        this.xDD.onInputValidChange(this.jvF);
      }
      AppMethodBeat.o(67148);
      return;
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    return !this.jvD;
  }
  
  public void setEllipsize(TextUtils.TruncateAt paramTruncateAt)
  {
    AppMethodBeat.i(67144);
    this.xDE.setEllipsize(paramTruncateAt);
    AppMethodBeat.o(67144);
  }
  
  public void setHintStr(String paramString)
  {
    AppMethodBeat.i(67136);
    this.xDE.setHint(paramString);
    AppMethodBeat.o(67136);
  }
  
  public void setImeOptions(int paramInt)
  {
    AppMethodBeat.i(67149);
    this.xDE.setImeOptions(paramInt);
    AppMethodBeat.o(67149);
  }
  
  public void setInfoTvImageResource(int paramInt)
  {
    AppMethodBeat.i(67138);
    if (paramInt == 2131232862) {}
    for (boolean bool = true;; bool = false)
    {
      this.xDF = bool;
      this.jvy.setImageResource(paramInt);
      AppMethodBeat.o(67138);
      return;
    }
  }
  
  public void setInfoTvOnClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(67137);
    this.jvy.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(67137);
  }
  
  public void setInput(com.tencent.mm.plugin.recharge.model.a parama)
  {
    AppMethodBeat.i(67139);
    this.xDI = parama;
    if (parama != null)
    {
      this.xDE.setText(parama.xCY);
      this.xDE.setSelection(this.xDE.getText().length());
      dHb();
      ae.d("MicroMsg.MallEditText", "editTv.setText " + parama.xCY + ", name " + parama.name + ", isInputValid " + this.jvF);
      if ((!bu.isNullOrNil(parama.name)) && (this.jvF))
      {
        this.heI.setText(parama.name);
        this.heI.setVisibility(0);
        AppMethodBeat.o(67139);
        return;
      }
      this.heI.setText("");
      this.heI.setVisibility(8);
      AppMethodBeat.o(67139);
      return;
    }
    this.xDE.setText("");
    dHb();
    ae.d("MicroMsg.MallEditText", "editTv.setText null");
    this.heI.setText("");
    this.heI.setVisibility(8);
    AppMethodBeat.o(67139);
  }
  
  public void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(67146);
    super.setOnClickListener(paramOnClickListener);
    this.xDE.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(67146);
  }
  
  public void setOnEditorActionListener(TextView.OnEditorActionListener paramOnEditorActionListener)
  {
    AppMethodBeat.i(67150);
    this.xDE.setOnEditorActionListener(paramOnEditorActionListener);
    AppMethodBeat.o(67150);
  }
  
  public void setOnFocusChangeListener(View.OnFocusChangeListener paramOnFocusChangeListener)
  {
    AppMethodBeat.i(67147);
    super.setOnFocusChangeListener(paramOnFocusChangeListener);
    this.jvw = paramOnFocusChangeListener;
    AppMethodBeat.o(67147);
  }
  
  public void setOnInputValidChangeListener(b paramb)
  {
    this.xDD = paramb;
  }
  
  final class a
    extends BaseAdapter
    implements Filterable
  {
    public List<com.tencent.mm.plugin.recharge.model.a> xDN;
    public boolean xDO;
    private List<com.tencent.mm.plugin.recharge.model.a> xDP;
    private a xDQ;
    private String xDR;
    
    private a()
    {
      AppMethodBeat.i(67127);
      this.xDN = new ArrayList();
      this.xDO = false;
      AppMethodBeat.o(67127);
    }
    
    public final com.tencent.mm.plugin.recharge.model.a Oa(int paramInt)
    {
      com.tencent.mm.plugin.recharge.model.a locala1 = null;
      for (;;)
      {
        try
        {
          AppMethodBeat.i(67131);
          if (!this.xDO) {
            break label79;
          }
          if (paramInt == 0)
          {
            AppMethodBeat.o(67131);
            return locala1;
          }
          if (paramInt <= this.xDN.size())
          {
            locala1 = (com.tencent.mm.plugin.recharge.model.a)this.xDN.get(paramInt - 1);
            AppMethodBeat.o(67131);
            continue;
          }
          AppMethodBeat.o(67131);
        }
        finally {}
        continue;
        label79:
        if (paramInt < this.xDN.size())
        {
          com.tencent.mm.plugin.recharge.model.a locala2 = (com.tencent.mm.plugin.recharge.model.a)this.xDN.get(paramInt);
          AppMethodBeat.o(67131);
        }
        else
        {
          AppMethodBeat.o(67131);
        }
      }
    }
    
    public final void fe(List<com.tencent.mm.plugin.recharge.model.a> paramList)
    {
      AppMethodBeat.i(67128);
      this.xDP = paramList;
      this.xDN.clear();
      this.xDO = false;
      AppMethodBeat.o(67128);
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(67130);
      int i;
      if (this.xDO)
      {
        i = this.xDN.size();
        AppMethodBeat.o(67130);
        return i + 2;
      }
      if (this.xDN.size() > 0)
      {
        i = this.xDN.size();
        AppMethodBeat.o(67130);
        return i + 1;
      }
      AppMethodBeat.o(67130);
      return 0;
    }
    
    public final Filter getFilter()
    {
      AppMethodBeat.i(67129);
      ae.d("MicroMsg.MallEditText", "getFilter");
      if (this.xDQ == null) {
        this.xDQ = new a((byte)0);
      }
      a locala = this.xDQ;
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
      if (this.xDO)
      {
        if (paramInt == 0)
        {
          AppMethodBeat.o(67133);
          return 2;
        }
        if (paramInt <= this.xDN.size())
        {
          AppMethodBeat.o(67133);
          return 0;
        }
        AppMethodBeat.o(67133);
        return 3;
      }
      if (paramInt < this.xDN.size())
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
          paramViewGroup = View.inflate(MallEditText.this.getContext(), 2131495205, null);
          localc = new MallEditText.c(MallEditText.this, (byte)0);
          localc.xDV = ((TextView)paramViewGroup.findViewById(2131302023));
          localc.fSj = ((TextView)paramViewGroup.findViewById(2131302022));
          paramViewGroup.setTag(localc);
          locala = Oa(paramInt);
          paramView = paramViewGroup;
          if (locala == null) {
            continue;
          }
          paramView = paramViewGroup;
          if (localc == null) {
            continue;
          }
          paramView = paramViewGroup;
          if (localc.xDV == null) {
            continue;
          }
          paramView = paramViewGroup;
          if (localc.fSj == null) {
            continue;
          }
          paramView = com.tencent.mm.plugin.recharge.model.b.awz(locala.xCY);
          ae.d("MicroMsg.MallEditText", "record.record " + paramView + ", record.name " + locala.name);
          if (com.tencent.mm.plugin.recharge.model.a.xCW.equals(locala.xCZ)) {
            break label399;
          }
          paramView = new SpannableStringBuilder(paramView);
          int[] arrayOfInt = locala.xCZ;
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
        localc.xDV.setText(paramView);
        label334:
        if ((locala.name != null) && (!bu.isNullOrNil(locala.name.trim()))) {
          localc.fSj.setText(MallEditText.this.getResources().getString(2131761165, new Object[] { locala.name }));
        }
        for (;;)
        {
          paramViewGroup.setBackgroundResource(2131231818);
          paramView = paramViewGroup;
          break;
          label399:
          localc.xDV.setText(paramView);
          break label334;
          localc.fSj.setText("");
        }
        paramView = View.inflate(MallEditText.this.getContext(), 2131495204, null);
        paramView.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(67119);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/recharge/ui/MallEditText$MobileHistoryAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
            MallEditText.a(MallEditText.this).dismissDropDown();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/recharge/ui/MallEditText$MobileHistoryAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(67119);
          }
        });
        continue;
        paramView = View.inflate(MallEditText.this.getContext(), 2131495206, null);
        paramView.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(67120);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/recharge/ui/MallEditText$MobileHistoryAdapter$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
            com.tencent.mm.plugin.recharge.a.a.dGX().fe(null);
            MallEditText.this.setInput(null);
            MallEditText.d(MallEditText.this).fe(new LinkedList());
            MallEditText.d(MallEditText.this).notifyDataSetChanged();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/recharge/ui/MallEditText$MobileHistoryAdapter$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(67120);
          }
        });
        continue;
        paramView = View.inflate(MallEditText.this.getContext(), 2131495206, null);
        ((TextView)paramView).setText(2131761154);
        paramView.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(67121);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/recharge/ui/MallEditText$MobileHistoryAdapter$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
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
      
      private static int[] iL(String paramString1, String paramString2)
      {
        AppMethodBeat.i(67126);
        if (paramString1.equals(paramString2))
        {
          paramString1 = com.tencent.mm.plugin.recharge.model.a.xCW;
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
        paramString1 = com.tencent.mm.plugin.recharge.model.a.xCX;
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
          for (localObject1 = com.tencent.mm.plugin.recharge.model.b.Ku(paramCharSequence.toString()); ((String)localObject1).equals(MallEditText.a.a(MallEditText.a.this)); localObject1 = "")
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
          if (MallEditText.this.aVz()) {
            break label362;
          }
          if (bu.isNullOrNil(MallEditText.a.a(MallEditText.a.this))) {
            break label342;
          }
          ae.d("MicroMsg.MallEditText", "performFiltering ".concat(String.valueOf(paramCharSequence)));
          paramCharSequence = MallEditText.a.b(MallEditText.a.this).iterator();
          while (paramCharSequence.hasNext())
          {
            localObject1 = (com.tencent.mm.plugin.recharge.model.a)paramCharSequence.next();
            if (((com.tencent.mm.plugin.recharge.model.a)localObject1).xCY.startsWith(MallEditText.a.a(MallEditText.a.this))) {
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
            paramCharSequence = MallEditText.a.this.xDN;
            MallEditText.a.this.xDN = localArrayList;
            MallEditText.a.this.xDO = bool;
            localFilterResults.count = MallEditText.a.this.xDN.size();
            localFilterResults.values = MallEditText.a.this.xDN;
            ae.d("MicroMsg.MallEditText", "results.count " + localFilterResults.count);
            paramCharSequence.clear();
            AppMethodBeat.o(67125);
            break;
            label342:
            localArrayList.addAll(MallEditText.a.b(MallEditText.a.this));
            bool = false;
            break label215;
            label362:
            long l = System.currentTimeMillis();
            ae.d("MicroMsg.MallEditText", "performFiltering ".concat(String.valueOf(paramCharSequence)));
            paramCharSequence = MallEditText.a.b(MallEditText.a.this).iterator();
            while (paramCharSequence.hasNext())
            {
              localObject1 = (com.tencent.mm.plugin.recharge.model.a)paramCharSequence.next();
              if (((com.tencent.mm.plugin.recharge.model.a)localObject1).xCY.equals(MallEditText.a.a(MallEditText.a.this)))
              {
                ((com.tencent.mm.plugin.recharge.model.a)localObject1).xCZ = com.tencent.mm.plugin.recharge.model.a.xCW;
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
              MallEditText.a(MallEditText.this, com.tencent.mm.pluginsdk.b.dt(MallEditText.this.getContext()));
              if (MallEditText.f(MallEditText.this) != null)
              {
                paramCharSequence = MallEditText.f(MallEditText.this).iterator();
                if (paramCharSequence.hasNext())
                {
                  localObject2 = (String[])paramCharSequence.next();
                  str = com.tencent.mm.plugin.recharge.model.b.Ku(localObject2[2]);
                  localObject1 = iL(MallEditText.a.a(MallEditText.a.this), str);
                  if (!com.tencent.mm.plugin.recharge.model.a.xCW.equals(localObject1)) {
                    break label680;
                  }
                  paramCharSequence = new com.tencent.mm.plugin.recharge.model.a(str, localObject2[1], 1);
                  paramCharSequence.xCZ = com.tencent.mm.plugin.recharge.model.a.xCW;
                  localArrayList.clear();
                  localArrayList.add(paramCharSequence);
                }
              }
              ae.d("MicroMsg.MallEditText", " search phone number cost " + (System.currentTimeMillis() - l) + " ms ");
              bool = true;
            }
            catch (Exception paramCharSequence)
            {
              for (;;)
              {
                Object localObject2;
                String str;
                ae.printErrStackTrace("MicroMsg.MallEditText", paramCharSequence, "", new Object[0]);
                continue;
                label680:
                if ((!com.tencent.mm.plugin.recharge.model.a.xCX.equals(localObject1)) && (localArrayList.size() < 5))
                {
                  localObject2 = new com.tencent.mm.plugin.recharge.model.a(str, localObject2[1], 1);
                  ((com.tencent.mm.plugin.recharge.model.a)localObject2).xCZ = ((int[])localObject1);
                  localArrayList.add(localObject2);
                }
              }
            }
          }
          if ((localArrayList.size() == 1) && (MallEditText.this.aVz()))
          {
            paramCharSequence = (com.tencent.mm.plugin.recharge.model.a)localArrayList.get(0);
            if (com.tencent.mm.plugin.recharge.model.a.xCW.equals(paramCharSequence.xCZ))
            {
              MallEditText.a(MallEditText.this).post(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(67124);
                  MallEditText.a(MallEditText.this, paramCharSequence);
                  if (!bu.isNullOrNil(MallEditText.e(MallEditText.this).name))
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
    public abstract void dHd();
    
    public abstract void onInputValidChange(boolean paramBoolean);
  }
  
  final class c
  {
    TextView fSj;
    TextView xDV;
    
    private c() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.recharge.ui.MallEditText
 * JD-Core Version:    0.7.0.1
 */