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
import com.tencent.mm.plugin.recharge.model.b;
import com.tencent.mm.plugin.wxpay.a.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class MallEditText
  extends LinearLayout
  implements View.OnFocusChangeListener
{
  private int gravity;
  private TextView icz;
  private int imeOptions;
  private int inputType;
  private boolean izA;
  private int izB;
  private int izC;
  private View.OnFocusChangeListener izr;
  private ImageView izt;
  private String izu;
  private String izv;
  private int izw;
  public boolean izy;
  private boolean jUS;
  private b uXj;
  AutoCompleteTextView uXk;
  boolean uXl;
  private a uXm;
  private List<String[]> uXn;
  private com.tencent.mm.plugin.recharge.model.a uXo;
  private Runnable uXp;
  private boolean uXq;
  private int uXr;
  
  public MallEditText(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public MallEditText(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(67135);
    this.uXm = null;
    this.izu = "";
    this.izv = "";
    this.inputType = 1;
    this.jUS = true;
    this.izC = -1;
    this.izB = 1;
    this.gravity = 19;
    this.izw = -1;
    this.izA = false;
    this.uXo = null;
    this.izy = true;
    this.uXp = null;
    this.uXq = false;
    this.uXr = 0;
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, a.a.MallEditText, paramInt, 0);
    paramInt = paramAttributeSet.getResourceId(7, 0);
    if (paramInt != 0) {
      this.izu = paramContext.getString(paramInt);
    }
    paramInt = paramAttributeSet.getResourceId(8, 0);
    if (paramInt != 0) {
      this.izv = paramContext.getString(paramInt);
    }
    this.inputType = paramAttributeSet.getInteger(4, 1);
    this.izy = paramAttributeSet.getBoolean(3, true);
    this.gravity = paramAttributeSet.getInt(0, 19);
    this.jUS = paramAttributeSet.getBoolean(1, true);
    this.izC = paramAttributeSet.getInteger(2, -1);
    this.izw = paramAttributeSet.getInteger(6, 0);
    this.imeOptions = paramAttributeSet.getInteger(5, 5);
    paramAttributeSet.recycle();
    paramAttributeSet = LayoutInflater.from(paramContext).inflate(2131495202, this, true);
    this.icz = ((TextView)paramAttributeSet.findViewById(2131306253));
    this.uXk = ((AutoCompleteTextView)paramAttributeSet.findViewById(2131300744));
    if (com.tencent.mm.cd.a.hS(paramContext))
    {
      this.uXk.setTextSize(0, paramContext.getResources().getDimensionPixelSize(2131165517) * com.tencent.mm.cd.a.hH(getContext()));
      label289:
      this.izt = ((ImageView)paramAttributeSet.findViewById(2131301009));
      ad.d("MicroMsg.MallEditText", "setFormat editType:" + this.izw);
      this.uXk.setImeOptions(this.imeOptions);
      switch (this.izw)
      {
      default: 
        label364:
        this.inputType = 1;
        label369:
        this.uXk.addTextChangedListener(new TextWatcher()
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
        this.uXk.setOnFocusChangeListener(this);
        if (!bt.isNullOrNil(this.izu)) {
          this.uXk.setHint(this.izu);
        }
        if (this.inputType == 2)
        {
          this.uXk.setKeyListener(new NumberKeyListener()
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
          this.uXk.setGravity(this.gravity);
          if (!this.jUS)
          {
            this.uXk.setEnabled(false);
            this.uXk.setTextColor(getResources().getColor(2131100711));
            this.uXk.setFocusable(false);
            this.uXk.setClickable(false);
          }
          if (this.izy) {
            break label724;
          }
          this.izA = true;
          this.uXk.setEnabled(false);
          this.uXk.setFocusable(false);
          this.uXk.setClickable(false);
        }
        break;
      }
    }
    for (;;)
    {
      if (this.izC != -1) {
        this.uXk.setFilters(new InputFilter[] { new InputFilter.LengthFilter(this.izC) });
      }
      ad.d("MicroMsg.MallEditText", "initData editType:" + this.izw);
      switch (this.izw)
      {
      default: 
        AppMethodBeat.o(67135);
        return;
        this.uXk.setTextSize(0, com.tencent.mm.cd.a.ao(paramContext, 2131165517));
        break label289;
        this.izB = 13;
        this.izC = 13;
        this.inputType = 2;
        setInfoTvImageResource(2131233803);
        this.izt.setVisibility(0);
        break label369;
        if (this.izy) {
          break label364;
        }
        this.izt.setImageResource(2131233284);
        this.izt.setVisibility(0);
        break label364;
        this.uXk.setInputType(this.inputType);
        this.uXk.setRawInputType(this.inputType);
        break label436;
        label724:
        this.izA = false;
      }
    }
    ad.d("MicroMsg.MallEditText", "setMobileEditTv");
    paramContext = com.tencent.mm.plugin.recharge.a.a.dfC().dfD();
    this.uXm = new a((byte)0);
    this.uXm.eD(paramContext);
    if ((paramContext != null) && (paramContext.size() > 0))
    {
      this.uXo = ((com.tencent.mm.plugin.recharge.model.a)paramContext.get(0));
      setInput(this.uXo);
    }
    for (;;)
    {
      if ((paramContext == null) || (paramContext.size() == 0))
      {
        g.afC();
        paramContext = (String)g.afB().afk().get(6, null);
        this.uXk.setText(paramContext);
        this.uXk.setSelection(this.uXk.getText().length());
        dfG();
      }
      this.uXk.setAdapter(this.uXm);
      this.uXk.setOnItemClickListener(new AdapterView.OnItemClickListener()
      {
        public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          AppMethodBeat.i(67118);
          MallEditText.a(MallEditText.this, MallEditText.d(MallEditText.this).JW(paramAnonymousInt));
          if (MallEditText.e(MallEditText.this) != null)
          {
            ad.d("MicroMsg.MallEditText", "onItemClick record.record " + MallEditText.e(MallEditText.this).uWD + ", record.name " + MallEditText.e(MallEditText.this).name);
            MallEditText.this.setInput(MallEditText.e(MallEditText.this));
          }
          MallEditText.a(MallEditText.this).dismissDropDown();
          AppMethodBeat.o(67118);
        }
      });
      break;
      if (this.uXn == null) {
        new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(67117);
            try
            {
              MallEditText.a(MallEditText.this, com.tencent.mm.pluginsdk.a.dk(MallEditText.this.getContext()));
              AppMethodBeat.o(67117);
              return;
            }
            catch (Exception localException)
            {
              ad.printErrStackTrace("MicroMsg.MallEditText", localException, "", new Object[0]);
              AppMethodBeat.o(67117);
            }
          }
        }.run();
      }
    }
  }
  
  private void dfG()
  {
    AppMethodBeat.i(67141);
    boolean bool = aKX();
    if (bool != this.izA)
    {
      ad.d("MicroMsg.MallEditText", "View:" + this.izv + ", editType:" + this.izw + " inputValid change to " + bool);
      this.izA = bool;
      if (this.uXj != null) {
        this.uXj.onInputValidChange(this.izA);
      }
      if (!bool)
      {
        if (this.icz.getVisibility() == 0)
        {
          this.icz.setText("");
          this.icz.setVisibility(8);
        }
        this.uXo = null;
      }
    }
    if (this.uXj != null) {
      this.uXj.dfI();
    }
    AppMethodBeat.o(67141);
  }
  
  private void setInputForce(com.tencent.mm.plugin.recharge.model.a parama)
  {
    AppMethodBeat.i(67140);
    this.uXo = parama;
    if (parama != null)
    {
      KeyListener localKeyListener = this.uXk.getKeyListener();
      this.uXk.setKeyListener(null);
      this.uXk.setText(parama.uWD);
      this.uXk.setSelection(this.uXk.getText().length());
      this.uXk.setKeyListener(localKeyListener);
      dfG();
      ad.d("MicroMsg.MallEditText", "editTv.setText " + parama.uWD + ", name " + parama.name + ", isInputValid " + this.izA);
      if ((!bt.isNullOrNil(parama.name)) && (this.izA))
      {
        this.icz.setText(parama.name);
        this.icz.setVisibility(0);
        AppMethodBeat.o(67140);
        return;
      }
      this.icz.setText("");
      this.icz.setVisibility(8);
      AppMethodBeat.o(67140);
      return;
    }
    this.uXk.setText("");
    dfG();
    ad.d("MicroMsg.MallEditText", "editTv.setText null");
    this.icz.setText("");
    this.icz.setVisibility(8);
    AppMethodBeat.o(67140);
  }
  
  public final boolean aKX()
  {
    AppMethodBeat.i(67143);
    switch (this.izw)
    {
    default: 
      if (this.uXk.getText().length() >= this.izB)
      {
        AppMethodBeat.o(67143);
        return true;
      }
      break;
    case 1: 
      String str = this.uXk.getText().toString();
      if ((str.length() >= this.izB) && (str.length() <= this.izC) && (PhoneNumberUtils.isGlobalPhoneNumber(b.CD(str))))
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
  
  public final boolean dfH()
  {
    AppMethodBeat.i(67145);
    if (getVisibility() == 0)
    {
      if (bt.isNullOrNil(getText()))
      {
        ad.d("MicroMsg.MallEditText", "View:" + this.izv + ", editType:" + this.izw + " checkInputValid : empty ");
        AppMethodBeat.o(67145);
        return false;
      }
      if (this.izA)
      {
        AppMethodBeat.o(67145);
        return true;
      }
      ad.d("MicroMsg.MallEditText", "View:" + this.izv + ", editType:" + this.izw + " checkInputValid : illegal ");
      AppMethodBeat.o(67145);
      return false;
    }
    AppMethodBeat.o(67145);
    return true;
  }
  
  public void getFocus()
  {
    AppMethodBeat.i(67152);
    this.uXk.findFocus();
    AppMethodBeat.o(67152);
  }
  
  public com.tencent.mm.plugin.recharge.model.a getInputRecord()
  {
    AppMethodBeat.i(67151);
    if (this.uXo != null)
    {
      locala = this.uXo;
      AppMethodBeat.o(67151);
      return locala;
    }
    this.uXo = new com.tencent.mm.plugin.recharge.model.a(getText(), this.icz.getText().toString(), 0);
    com.tencent.mm.plugin.recharge.model.a locala = this.uXo;
    AppMethodBeat.o(67151);
    return locala;
  }
  
  public String getText()
  {
    AppMethodBeat.i(67142);
    switch (this.izw)
    {
    default: 
      str = bt.by(this.uXk.getText().toString(), "");
      AppMethodBeat.o(67142);
      return str;
    }
    String str = bt.by(this.uXk.getText().toString(), "");
    AppMethodBeat.o(67142);
    return str;
  }
  
  public void onFocusChange(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(67148);
    if (this.izr != null) {
      this.izr.onFocusChange(this, paramBoolean);
    }
    if (!this.uXq) {}
    for (boolean bool = true;; bool = false)
    {
      if ((bool == paramBoolean) && (!paramBoolean) && (this.uXp != null)) {
        this.uXp.run();
      }
      this.uXq = paramBoolean;
      ad.d("MicroMsg.MallEditText", "View:" + this.izv + ", editType:" + this.izw + " onFocusChange to " + paramBoolean);
      if (this.uXj != null) {
        this.uXj.onInputValidChange(this.izA);
      }
      AppMethodBeat.o(67148);
      return;
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    return !this.izy;
  }
  
  public void setEllipsize(TextUtils.TruncateAt paramTruncateAt)
  {
    AppMethodBeat.i(67144);
    this.uXk.setEllipsize(paramTruncateAt);
    AppMethodBeat.o(67144);
  }
  
  public void setHintStr(String paramString)
  {
    AppMethodBeat.i(67136);
    this.uXk.setHint(paramString);
    AppMethodBeat.o(67136);
  }
  
  public void setImeOptions(int paramInt)
  {
    AppMethodBeat.i(67149);
    this.uXk.setImeOptions(paramInt);
    AppMethodBeat.o(67149);
  }
  
  public void setInfoTvImageResource(int paramInt)
  {
    AppMethodBeat.i(67138);
    if (paramInt == 2131232862) {}
    for (boolean bool = true;; bool = false)
    {
      this.uXl = bool;
      this.izt.setImageResource(paramInt);
      AppMethodBeat.o(67138);
      return;
    }
  }
  
  public void setInfoTvOnClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(67137);
    this.izt.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(67137);
  }
  
  public void setInput(com.tencent.mm.plugin.recharge.model.a parama)
  {
    AppMethodBeat.i(67139);
    this.uXo = parama;
    if (parama != null)
    {
      this.uXk.setText(parama.uWD);
      this.uXk.setSelection(this.uXk.getText().length());
      dfG();
      ad.d("MicroMsg.MallEditText", "editTv.setText " + parama.uWD + ", name " + parama.name + ", isInputValid " + this.izA);
      if ((!bt.isNullOrNil(parama.name)) && (this.izA))
      {
        this.icz.setText(parama.name);
        this.icz.setVisibility(0);
        AppMethodBeat.o(67139);
        return;
      }
      this.icz.setText("");
      this.icz.setVisibility(8);
      AppMethodBeat.o(67139);
      return;
    }
    this.uXk.setText("");
    dfG();
    ad.d("MicroMsg.MallEditText", "editTv.setText null");
    this.icz.setText("");
    this.icz.setVisibility(8);
    AppMethodBeat.o(67139);
  }
  
  public void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(67146);
    super.setOnClickListener(paramOnClickListener);
    this.uXk.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(67146);
  }
  
  public void setOnEditorActionListener(TextView.OnEditorActionListener paramOnEditorActionListener)
  {
    AppMethodBeat.i(67150);
    this.uXk.setOnEditorActionListener(paramOnEditorActionListener);
    AppMethodBeat.o(67150);
  }
  
  public void setOnFocusChangeListener(View.OnFocusChangeListener paramOnFocusChangeListener)
  {
    AppMethodBeat.i(67147);
    super.setOnFocusChangeListener(paramOnFocusChangeListener);
    this.izr = paramOnFocusChangeListener;
    AppMethodBeat.o(67147);
  }
  
  public void setOnInputValidChangeListener(b paramb)
  {
    this.uXj = paramb;
  }
  
  final class a
    extends BaseAdapter
    implements Filterable
  {
    public List<com.tencent.mm.plugin.recharge.model.a> uXt;
    public boolean uXu;
    private List<com.tencent.mm.plugin.recharge.model.a> uXv;
    private a uXw;
    private String uXx;
    
    private a()
    {
      AppMethodBeat.i(67127);
      this.uXt = new ArrayList();
      this.uXu = false;
      AppMethodBeat.o(67127);
    }
    
    public final com.tencent.mm.plugin.recharge.model.a JW(int paramInt)
    {
      com.tencent.mm.plugin.recharge.model.a locala1 = null;
      for (;;)
      {
        try
        {
          AppMethodBeat.i(67131);
          if (!this.uXu) {
            break label79;
          }
          if (paramInt == 0)
          {
            AppMethodBeat.o(67131);
            return locala1;
          }
          if (paramInt <= this.uXt.size())
          {
            locala1 = (com.tencent.mm.plugin.recharge.model.a)this.uXt.get(paramInt - 1);
            AppMethodBeat.o(67131);
            continue;
          }
          AppMethodBeat.o(67131);
        }
        finally {}
        continue;
        label79:
        if (paramInt < this.uXt.size())
        {
          com.tencent.mm.plugin.recharge.model.a locala2 = (com.tencent.mm.plugin.recharge.model.a)this.uXt.get(paramInt);
          AppMethodBeat.o(67131);
        }
        else
        {
          AppMethodBeat.o(67131);
        }
      }
    }
    
    public final void eD(List<com.tencent.mm.plugin.recharge.model.a> paramList)
    {
      AppMethodBeat.i(67128);
      this.uXv = paramList;
      this.uXt.clear();
      this.uXu = false;
      AppMethodBeat.o(67128);
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(67130);
      int i;
      if (this.uXu)
      {
        i = this.uXt.size();
        AppMethodBeat.o(67130);
        return i + 2;
      }
      if (this.uXt.size() > 0)
      {
        i = this.uXt.size();
        AppMethodBeat.o(67130);
        return i + 1;
      }
      AppMethodBeat.o(67130);
      return 0;
    }
    
    public final Filter getFilter()
    {
      AppMethodBeat.i(67129);
      ad.d("MicroMsg.MallEditText", "getFilter");
      if (this.uXw == null) {
        this.uXw = new a((byte)0);
      }
      a locala = this.uXw;
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
      if (this.uXu)
      {
        if (paramInt == 0)
        {
          AppMethodBeat.o(67133);
          return 2;
        }
        if (paramInt <= this.uXt.size())
        {
          AppMethodBeat.o(67133);
          return 0;
        }
        AppMethodBeat.o(67133);
        return 3;
      }
      if (paramInt < this.uXt.size())
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
          localc.uXB = ((TextView)paramViewGroup.findViewById(2131302023));
          localc.ftj = ((TextView)paramViewGroup.findViewById(2131302022));
          paramViewGroup.setTag(localc);
          locala = JW(paramInt);
          paramView = paramViewGroup;
          if (locala == null) {
            continue;
          }
          paramView = paramViewGroup;
          if (localc == null) {
            continue;
          }
          paramView = paramViewGroup;
          if (localc.uXB == null) {
            continue;
          }
          paramView = paramViewGroup;
          if (localc.ftj == null) {
            continue;
          }
          paramView = b.alm(locala.uWD);
          ad.d("MicroMsg.MallEditText", "record.record " + paramView + ", record.name " + locala.name);
          if (com.tencent.mm.plugin.recharge.model.a.uWB.equals(locala.uWE)) {
            break label399;
          }
          paramView = new SpannableStringBuilder(paramView);
          int[] arrayOfInt = locala.uWE;
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
        localc.uXB.setText(paramView);
        label334:
        if ((locala.name != null) && (!bt.isNullOrNil(locala.name.trim()))) {
          localc.ftj.setText(MallEditText.this.getResources().getString(2131761165, new Object[] { locala.name }));
        }
        for (;;)
        {
          paramViewGroup.setBackgroundResource(2131231818);
          paramView = paramViewGroup;
          break;
          label399:
          localc.uXB.setText(paramView);
          break label334;
          localc.ftj.setText("");
        }
        paramView = View.inflate(MallEditText.this.getContext(), 2131495204, null);
        paramView.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(67119);
            MallEditText.a(MallEditText.this).dismissDropDown();
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
            com.tencent.mm.plugin.recharge.a.a.dfC().eD(null);
            MallEditText.this.setInput(null);
            MallEditText.d(MallEditText.this).eD(new LinkedList());
            MallEditText.d(MallEditText.this).notifyDataSetChanged();
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
            MallEditText.a(MallEditText.this).dismissDropDown();
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
      
      private static int[] ib(String paramString1, String paramString2)
      {
        AppMethodBeat.i(67126);
        if (paramString1.equals(paramString2))
        {
          paramString1 = com.tencent.mm.plugin.recharge.model.a.uWB;
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
        paramString1 = com.tencent.mm.plugin.recharge.model.a.uWC;
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
          for (localObject1 = b.CD(paramCharSequence.toString()); ((String)localObject1).equals(MallEditText.a.a(MallEditText.a.this)); localObject1 = "")
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
          if (MallEditText.this.aKX()) {
            break label362;
          }
          if (bt.isNullOrNil(MallEditText.a.a(MallEditText.a.this))) {
            break label342;
          }
          ad.d("MicroMsg.MallEditText", "performFiltering ".concat(String.valueOf(paramCharSequence)));
          paramCharSequence = MallEditText.a.b(MallEditText.a.this).iterator();
          while (paramCharSequence.hasNext())
          {
            localObject1 = (com.tencent.mm.plugin.recharge.model.a)paramCharSequence.next();
            if (((com.tencent.mm.plugin.recharge.model.a)localObject1).uWD.startsWith(MallEditText.a.a(MallEditText.a.this))) {
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
            paramCharSequence = MallEditText.a.this.uXt;
            MallEditText.a.this.uXt = localArrayList;
            MallEditText.a.this.uXu = bool;
            localFilterResults.count = MallEditText.a.this.uXt.size();
            localFilterResults.values = MallEditText.a.this.uXt;
            ad.d("MicroMsg.MallEditText", "results.count " + localFilterResults.count);
            paramCharSequence.clear();
            AppMethodBeat.o(67125);
            break;
            label342:
            localArrayList.addAll(MallEditText.a.b(MallEditText.a.this));
            bool = false;
            break label215;
            label362:
            long l = System.currentTimeMillis();
            ad.d("MicroMsg.MallEditText", "performFiltering ".concat(String.valueOf(paramCharSequence)));
            paramCharSequence = MallEditText.a.b(MallEditText.a.this).iterator();
            while (paramCharSequence.hasNext())
            {
              localObject1 = (com.tencent.mm.plugin.recharge.model.a)paramCharSequence.next();
              if (((com.tencent.mm.plugin.recharge.model.a)localObject1).uWD.equals(MallEditText.a.a(MallEditText.a.this)))
              {
                ((com.tencent.mm.plugin.recharge.model.a)localObject1).uWE = com.tencent.mm.plugin.recharge.model.a.uWB;
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
              MallEditText.a(MallEditText.this, com.tencent.mm.pluginsdk.a.dk(MallEditText.this.getContext()));
              if (MallEditText.f(MallEditText.this) != null)
              {
                paramCharSequence = MallEditText.f(MallEditText.this).iterator();
                if (paramCharSequence.hasNext())
                {
                  localObject2 = (String[])paramCharSequence.next();
                  str = b.CD(localObject2[2]);
                  localObject1 = ib(MallEditText.a.a(MallEditText.a.this), str);
                  if (!com.tencent.mm.plugin.recharge.model.a.uWB.equals(localObject1)) {
                    break label680;
                  }
                  paramCharSequence = new com.tencent.mm.plugin.recharge.model.a(str, localObject2[1], 1);
                  paramCharSequence.uWE = com.tencent.mm.plugin.recharge.model.a.uWB;
                  localArrayList.clear();
                  localArrayList.add(paramCharSequence);
                }
              }
              ad.d("MicroMsg.MallEditText", " search phone number cost " + (System.currentTimeMillis() - l) + " ms ");
              bool = true;
            }
            catch (Exception paramCharSequence)
            {
              for (;;)
              {
                Object localObject2;
                String str;
                ad.printErrStackTrace("MicroMsg.MallEditText", paramCharSequence, "", new Object[0]);
                continue;
                label680:
                if ((!com.tencent.mm.plugin.recharge.model.a.uWC.equals(localObject1)) && (localArrayList.size() < 5))
                {
                  localObject2 = new com.tencent.mm.plugin.recharge.model.a(str, localObject2[1], 1);
                  ((com.tencent.mm.plugin.recharge.model.a)localObject2).uWE = ((int[])localObject1);
                  localArrayList.add(localObject2);
                }
              }
            }
          }
          if ((localArrayList.size() == 1) && (MallEditText.this.aKX()))
          {
            paramCharSequence = (com.tencent.mm.plugin.recharge.model.a)localArrayList.get(0);
            if (com.tencent.mm.plugin.recharge.model.a.uWB.equals(paramCharSequence.uWE))
            {
              MallEditText.a(MallEditText.this).post(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(67124);
                  MallEditText.a(MallEditText.this, paramCharSequence);
                  if (!bt.isNullOrNil(MallEditText.e(MallEditText.this).name))
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
    public abstract void dfI();
    
    public abstract void onInputValidChange(boolean paramBoolean);
  }
  
  final class c
  {
    TextView ftj;
    TextView uXB;
    
    private c() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.recharge.ui.MallEditText
 * JD-Core Version:    0.7.0.1
 */