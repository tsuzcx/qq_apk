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
import android.text.method.KeyListener;
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
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.z;
import java.util.ArrayList;
import java.util.List;

public class MallEditText
  extends LinearLayout
  implements View.OnFocusChangeListener
{
  private View.OnFocusChangeListener gLH;
  private ImageView gLK;
  private String gLL;
  private String gLM;
  private int gLN;
  public boolean gLP;
  private boolean gLR;
  private int gLS;
  private int gLT;
  private TextView gqe;
  private int gravity;
  private boolean hPf;
  private int imeOptions;
  private int inputType;
  private MallEditText.b pVp;
  AutoCompleteTextView pVq;
  boolean pVr;
  private a pVs;
  private List<String[]> pVt;
  private com.tencent.mm.plugin.recharge.model.a pVu;
  private Runnable pVv;
  private boolean pVw;
  private int pVx;
  
  public MallEditText(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public MallEditText(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(44227);
    this.pVs = null;
    this.gLL = "";
    this.gLM = "";
    this.inputType = 1;
    this.hPf = true;
    this.gLT = -1;
    this.gLS = 1;
    this.gravity = 19;
    this.gLN = -1;
    this.gLR = false;
    this.pVu = null;
    this.gLP = true;
    this.pVv = null;
    this.pVw = false;
    this.pVx = 0;
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, a.a.MallEditText, paramInt, 0);
    paramInt = paramAttributeSet.getResourceId(6, 0);
    if (paramInt != 0) {
      this.gLL = paramContext.getString(paramInt);
    }
    paramInt = paramAttributeSet.getResourceId(7, 0);
    if (paramInt != 0) {
      this.gLM = paramContext.getString(paramInt);
    }
    this.inputType = paramAttributeSet.getInteger(4, 1);
    this.gLP = paramAttributeSet.getBoolean(3, true);
    this.gravity = paramAttributeSet.getInt(0, 19);
    this.hPf = paramAttributeSet.getBoolean(1, true);
    this.gLT = paramAttributeSet.getInteger(2, -1);
    this.gLN = paramAttributeSet.getInteger(8, 0);
    this.imeOptions = paramAttributeSet.getInteger(5, 5);
    paramAttributeSet.recycle();
    paramAttributeSet = LayoutInflater.from(paramContext).inflate(2130970527, this, true);
    this.gqe = ((TextView)paramAttributeSet.findViewById(2131827077));
    this.pVq = ((AutoCompleteTextView)paramAttributeSet.findViewById(2131821072));
    if (com.tencent.mm.cb.a.gt(paramContext))
    {
      this.pVq.setTextSize(0, paramContext.getResources().getDimensionPixelSize(2131427809) * com.tencent.mm.cb.a.gi(getContext()));
      label289:
      this.gLK = ((ImageView)paramAttributeSet.findViewById(2131821073));
      ab.d("MicroMsg.MallEditText", "setFormat editType:" + this.gLN);
      this.pVq.setImeOptions(this.imeOptions);
      switch (this.gLN)
      {
      default: 
        label364:
        this.inputType = 1;
        label369:
        this.pVq.addTextChangedListener(new MallEditText.1(this));
        this.pVq.setOnFocusChangeListener(this);
        if (!bo.isNullOrNil(this.gLL)) {
          this.pVq.setHint(this.gLL);
        }
        if (this.inputType == 2)
        {
          this.pVq.setKeyListener(new MallEditText.2(this));
          label436:
          this.pVq.setGravity(this.gravity);
          if (!this.hPf)
          {
            this.pVq.setEnabled(false);
            this.pVq.setTextColor(getResources().getColor(2131689763));
            this.pVq.setFocusable(false);
            this.pVq.setClickable(false);
          }
          if (this.gLP) {
            break label724;
          }
          this.gLR = true;
          this.pVq.setEnabled(false);
          this.pVq.setFocusable(false);
          this.pVq.setClickable(false);
        }
        break;
      }
    }
    for (;;)
    {
      if (this.gLT != -1) {
        this.pVq.setFilters(new InputFilter[] { new InputFilter.LengthFilter(this.gLT) });
      }
      ab.d("MicroMsg.MallEditText", "initData editType:" + this.gLN);
      switch (this.gLN)
      {
      default: 
        AppMethodBeat.o(44227);
        return;
        this.pVq.setTextSize(0, com.tencent.mm.cb.a.ao(paramContext, 2131427809));
        break label289;
        this.gLS = 13;
        this.gLT = 13;
        this.inputType = 2;
        setInfoTvImageResource(2130840122);
        this.gLK.setVisibility(0);
        break label369;
        if (this.gLP) {
          break label364;
        }
        this.gLK.setImageResource(2130839661);
        this.gLK.setVisibility(0);
        break label364;
        this.pVq.setInputType(this.inputType);
        this.pVq.setRawInputType(this.inputType);
        break label436;
        label724:
        this.gLR = false;
      }
    }
    ab.d("MicroMsg.MallEditText", "setMobileEditTv");
    paramContext = com.tencent.mm.plugin.recharge.a.a.cfm().cfn();
    this.pVs = new a((byte)0);
    this.pVs.cH(paramContext);
    if ((paramContext != null) && (paramContext.size() > 0))
    {
      this.pVu = ((com.tencent.mm.plugin.recharge.model.a)paramContext.get(0));
      setInput(this.pVu);
    }
    for (;;)
    {
      if ((paramContext == null) || (paramContext.size() == 0))
      {
        g.RM();
        paramContext = (String)g.RL().Ru().get(6, null);
        this.pVq.setText(paramContext);
        this.pVq.setSelection(this.pVq.getText().length());
        cfq();
      }
      this.pVq.setAdapter(this.pVs);
      this.pVq.setOnItemClickListener(new AdapterView.OnItemClickListener()
      {
        public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          AppMethodBeat.i(44210);
          MallEditText.a(MallEditText.this, MallEditText.d(MallEditText.this).Cg(paramAnonymousInt));
          if (MallEditText.e(MallEditText.this) != null)
          {
            ab.d("MicroMsg.MallEditText", "onItemClick record.record " + MallEditText.e(MallEditText.this).pUJ + ", record.name " + MallEditText.e(MallEditText.this).name);
            MallEditText.this.setInput(MallEditText.e(MallEditText.this));
          }
          MallEditText.a(MallEditText.this).dismissDropDown();
          AppMethodBeat.o(44210);
        }
      });
      break;
      if (this.pVt == null) {
        new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(44209);
            try
            {
              MallEditText.a(MallEditText.this, com.tencent.mm.pluginsdk.a.cL(MallEditText.this.getContext()));
              AppMethodBeat.o(44209);
              return;
            }
            catch (Exception localException)
            {
              ab.printErrStackTrace("MicroMsg.MallEditText", localException, "", new Object[0]);
              AppMethodBeat.o(44209);
            }
          }
        }.run();
      }
    }
  }
  
  private void cfq()
  {
    AppMethodBeat.i(44233);
    boolean bool = asv();
    if (bool != this.gLR)
    {
      ab.d("MicroMsg.MallEditText", "View:" + this.gLM + ", editType:" + this.gLN + " inputValid change to " + bool);
      this.gLR = bool;
      if (this.pVp != null) {
        this.pVp.onInputValidChange(this.gLR);
      }
      if (!bool)
      {
        if (this.gqe.getVisibility() == 0)
        {
          this.gqe.setText("");
          this.gqe.setVisibility(8);
        }
        this.pVu = null;
      }
    }
    if (this.pVp != null) {
      this.pVp.cfs();
    }
    AppMethodBeat.o(44233);
  }
  
  private void setInputForce(com.tencent.mm.plugin.recharge.model.a parama)
  {
    AppMethodBeat.i(44232);
    this.pVu = parama;
    if (parama != null)
    {
      KeyListener localKeyListener = this.pVq.getKeyListener();
      this.pVq.setKeyListener(null);
      this.pVq.setText(parama.pUJ);
      this.pVq.setSelection(this.pVq.getText().length());
      this.pVq.setKeyListener(localKeyListener);
      cfq();
      ab.d("MicroMsg.MallEditText", "editTv.setText " + parama.pUJ + ", name " + parama.name + ", isInputValid " + this.gLR);
      if ((!bo.isNullOrNil(parama.name)) && (this.gLR))
      {
        this.gqe.setText(parama.name);
        this.gqe.setVisibility(0);
        AppMethodBeat.o(44232);
        return;
      }
      this.gqe.setText("");
      this.gqe.setVisibility(8);
      AppMethodBeat.o(44232);
      return;
    }
    this.pVq.setText("");
    cfq();
    ab.d("MicroMsg.MallEditText", "editTv.setText null");
    this.gqe.setText("");
    this.gqe.setVisibility(8);
    AppMethodBeat.o(44232);
  }
  
  public final boolean asv()
  {
    AppMethodBeat.i(44235);
    switch (this.gLN)
    {
    default: 
      if (this.pVq.getText().length() >= this.gLS)
      {
        AppMethodBeat.o(44235);
        return true;
      }
      break;
    case 1: 
      String str = this.pVq.getText().toString();
      if ((str.length() >= this.gLS) && (str.length() <= this.gLT) && (PhoneNumberUtils.isGlobalPhoneNumber(b.xw(str))))
      {
        AppMethodBeat.o(44235);
        return true;
      }
      AppMethodBeat.o(44235);
      return false;
    }
    AppMethodBeat.o(44235);
    return false;
  }
  
  public final boolean cfr()
  {
    AppMethodBeat.i(44237);
    if (getVisibility() == 0)
    {
      if (bo.isNullOrNil(getText()))
      {
        ab.d("MicroMsg.MallEditText", "View:" + this.gLM + ", editType:" + this.gLN + " checkInputValid : empty ");
        AppMethodBeat.o(44237);
        return false;
      }
      if (this.gLR)
      {
        AppMethodBeat.o(44237);
        return true;
      }
      ab.d("MicroMsg.MallEditText", "View:" + this.gLM + ", editType:" + this.gLN + " checkInputValid : illegal ");
      AppMethodBeat.o(44237);
      return false;
    }
    AppMethodBeat.o(44237);
    return true;
  }
  
  public void getFocus()
  {
    AppMethodBeat.i(44244);
    this.pVq.findFocus();
    AppMethodBeat.o(44244);
  }
  
  public com.tencent.mm.plugin.recharge.model.a getInputRecord()
  {
    AppMethodBeat.i(44243);
    if (this.pVu != null)
    {
      locala = this.pVu;
      AppMethodBeat.o(44243);
      return locala;
    }
    this.pVu = new com.tencent.mm.plugin.recharge.model.a(getText(), this.gqe.getText().toString(), 0);
    com.tencent.mm.plugin.recharge.model.a locala = this.pVu;
    AppMethodBeat.o(44243);
    return locala;
  }
  
  public String getText()
  {
    AppMethodBeat.i(44234);
    switch (this.gLN)
    {
    default: 
      str = bo.bf(this.pVq.getText().toString(), "");
      AppMethodBeat.o(44234);
      return str;
    }
    String str = bo.bf(this.pVq.getText().toString(), "");
    AppMethodBeat.o(44234);
    return str;
  }
  
  public void onFocusChange(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(44240);
    if (this.gLH != null) {
      this.gLH.onFocusChange(this, paramBoolean);
    }
    if (!this.pVw) {}
    for (boolean bool = true;; bool = false)
    {
      if ((bool == paramBoolean) && (!paramBoolean) && (this.pVv != null)) {
        this.pVv.run();
      }
      this.pVw = paramBoolean;
      ab.d("MicroMsg.MallEditText", "View:" + this.gLM + ", editType:" + this.gLN + " onFocusChange to " + paramBoolean);
      if (this.pVp != null) {
        this.pVp.onInputValidChange(this.gLR);
      }
      AppMethodBeat.o(44240);
      return;
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    return !this.gLP;
  }
  
  public void setEllipsize(TextUtils.TruncateAt paramTruncateAt)
  {
    AppMethodBeat.i(44236);
    this.pVq.setEllipsize(paramTruncateAt);
    AppMethodBeat.o(44236);
  }
  
  public void setHintStr(String paramString)
  {
    AppMethodBeat.i(44228);
    this.pVq.setHint(paramString);
    AppMethodBeat.o(44228);
  }
  
  public void setImeOptions(int paramInt)
  {
    AppMethodBeat.i(44241);
    this.pVq.setImeOptions(paramInt);
    AppMethodBeat.o(44241);
  }
  
  public void setInfoTvImageResource(int paramInt)
  {
    AppMethodBeat.i(44230);
    if (paramInt == 2130839272) {}
    for (boolean bool = true;; bool = false)
    {
      this.pVr = bool;
      this.gLK.setImageResource(paramInt);
      AppMethodBeat.o(44230);
      return;
    }
  }
  
  public void setInfoTvOnClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(44229);
    this.gLK.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(44229);
  }
  
  public void setInput(com.tencent.mm.plugin.recharge.model.a parama)
  {
    AppMethodBeat.i(44231);
    this.pVu = parama;
    if (parama != null)
    {
      this.pVq.setText(parama.pUJ);
      this.pVq.setSelection(this.pVq.getText().length());
      cfq();
      ab.d("MicroMsg.MallEditText", "editTv.setText " + parama.pUJ + ", name " + parama.name + ", isInputValid " + this.gLR);
      if ((!bo.isNullOrNil(parama.name)) && (this.gLR))
      {
        this.gqe.setText(parama.name);
        this.gqe.setVisibility(0);
        AppMethodBeat.o(44231);
        return;
      }
      this.gqe.setText("");
      this.gqe.setVisibility(8);
      AppMethodBeat.o(44231);
      return;
    }
    this.pVq.setText("");
    cfq();
    ab.d("MicroMsg.MallEditText", "editTv.setText null");
    this.gqe.setText("");
    this.gqe.setVisibility(8);
    AppMethodBeat.o(44231);
  }
  
  public void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(44238);
    super.setOnClickListener(paramOnClickListener);
    this.pVq.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(44238);
  }
  
  public void setOnEditorActionListener(TextView.OnEditorActionListener paramOnEditorActionListener)
  {
    AppMethodBeat.i(44242);
    this.pVq.setOnEditorActionListener(paramOnEditorActionListener);
    AppMethodBeat.o(44242);
  }
  
  public void setOnFocusChangeListener(View.OnFocusChangeListener paramOnFocusChangeListener)
  {
    AppMethodBeat.i(44239);
    super.setOnFocusChangeListener(paramOnFocusChangeListener);
    this.gLH = paramOnFocusChangeListener;
    AppMethodBeat.o(44239);
  }
  
  public void setOnInputValidChangeListener(MallEditText.b paramb)
  {
    this.pVp = paramb;
  }
  
  final class a
    extends BaseAdapter
    implements Filterable
  {
    public boolean pVA;
    private List<com.tencent.mm.plugin.recharge.model.a> pVB;
    private MallEditText.a.a pVC;
    private String pVD;
    public List<com.tencent.mm.plugin.recharge.model.a> pVz;
    
    private a()
    {
      AppMethodBeat.i(44219);
      this.pVz = new ArrayList();
      this.pVA = false;
      AppMethodBeat.o(44219);
    }
    
    public final com.tencent.mm.plugin.recharge.model.a Cg(int paramInt)
    {
      com.tencent.mm.plugin.recharge.model.a locala1 = null;
      for (;;)
      {
        try
        {
          AppMethodBeat.i(44223);
          if (!this.pVA) {
            break label79;
          }
          if (paramInt == 0)
          {
            AppMethodBeat.o(44223);
            return locala1;
          }
          if (paramInt <= this.pVz.size())
          {
            locala1 = (com.tencent.mm.plugin.recharge.model.a)this.pVz.get(paramInt - 1);
            AppMethodBeat.o(44223);
            continue;
          }
          AppMethodBeat.o(44223);
        }
        finally {}
        continue;
        label79:
        if (paramInt < this.pVz.size())
        {
          com.tencent.mm.plugin.recharge.model.a locala2 = (com.tencent.mm.plugin.recharge.model.a)this.pVz.get(paramInt);
          AppMethodBeat.o(44223);
        }
        else
        {
          AppMethodBeat.o(44223);
        }
      }
    }
    
    public final void cH(List<com.tencent.mm.plugin.recharge.model.a> paramList)
    {
      AppMethodBeat.i(44220);
      this.pVB = paramList;
      this.pVz.clear();
      this.pVA = false;
      AppMethodBeat.o(44220);
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(44222);
      int i;
      if (this.pVA)
      {
        i = this.pVz.size();
        AppMethodBeat.o(44222);
        return i + 2;
      }
      if (this.pVz.size() > 0)
      {
        i = this.pVz.size();
        AppMethodBeat.o(44222);
        return i + 1;
      }
      AppMethodBeat.o(44222);
      return 0;
    }
    
    public final Filter getFilter()
    {
      AppMethodBeat.i(44221);
      ab.d("MicroMsg.MallEditText", "getFilter");
      if (this.pVC == null) {
        this.pVC = new MallEditText.a.a(this, (byte)0);
      }
      MallEditText.a.a locala = this.pVC;
      AppMethodBeat.o(44221);
      return locala;
    }
    
    public final long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public final int getItemViewType(int paramInt)
    {
      AppMethodBeat.i(44225);
      if (this.pVA)
      {
        if (paramInt == 0)
        {
          AppMethodBeat.o(44225);
          return 2;
        }
        if (paramInt <= this.pVz.size())
        {
          AppMethodBeat.o(44225);
          return 0;
        }
        AppMethodBeat.o(44225);
        return 3;
      }
      if (paramInt < this.pVz.size())
      {
        AppMethodBeat.o(44225);
        return 0;
      }
      AppMethodBeat.o(44225);
      return 1;
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(44224);
      switch (getItemViewType(paramInt))
      {
      }
      for (;;)
      {
        AppMethodBeat.o(44224);
        return paramView;
        MallEditText.c localc;
        com.tencent.mm.plugin.recharge.model.a locala;
        int i;
        label235:
        int j;
        if (paramView == null)
        {
          paramViewGroup = View.inflate(MallEditText.this.getContext(), 2130970530, null);
          localc = new MallEditText.c(MallEditText.this, (byte)0);
          localc.pVH = ((TextView)paramViewGroup.findViewById(2131827079));
          localc.gve = ((TextView)paramViewGroup.findViewById(2131827080));
          paramViewGroup.setTag(localc);
          locala = Cg(paramInt);
          paramView = paramViewGroup;
          if (locala == null) {
            continue;
          }
          paramView = paramViewGroup;
          if (localc == null) {
            continue;
          }
          paramView = paramViewGroup;
          if (localc.pVH == null) {
            continue;
          }
          paramView = paramViewGroup;
          if (localc.gve == null) {
            continue;
          }
          paramView = b.XL(locala.pUJ);
          ab.d("MicroMsg.MallEditText", "record.record " + paramView + ", record.name " + locala.name);
          if (com.tencent.mm.plugin.recharge.model.a.pUH.equals(locala.pUL)) {
            break label399;
          }
          paramView = new SpannableStringBuilder(paramView);
          int[] arrayOfInt = locala.pUL;
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
        localc.pVH.setText(paramView);
        label334:
        if ((locala.name != null) && (!bo.isNullOrNil(locala.name.trim()))) {
          localc.gve.setText(MallEditText.this.getResources().getString(2131301518, new Object[] { locala.name }));
        }
        for (;;)
        {
          paramViewGroup.setBackgroundResource(2130838445);
          paramView = paramViewGroup;
          break;
          label399:
          localc.pVH.setText(paramView);
          break label334;
          localc.gve.setText("");
        }
        paramView = View.inflate(MallEditText.this.getContext(), 2130970529, null);
        paramView.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(44211);
            MallEditText.a(MallEditText.this).dismissDropDown();
            AppMethodBeat.o(44211);
          }
        });
        continue;
        paramView = View.inflate(MallEditText.this.getContext(), 2130970531, null);
        paramView.setOnClickListener(new MallEditText.a.2(this));
        continue;
        paramView = View.inflate(MallEditText.this.getContext(), 2130970531, null);
        ((TextView)paramView).setText(2131301507);
        paramView.setOnClickListener(new MallEditText.a.3(this));
      }
    }
    
    public final int getViewTypeCount()
    {
      return 4;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.recharge.ui.MallEditText
 * JD-Core Version:    0.7.0.1
 */