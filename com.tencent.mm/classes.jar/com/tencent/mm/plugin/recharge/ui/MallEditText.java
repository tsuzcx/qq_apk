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
import android.widget.AutoCompleteTextView;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.recharge.model.b;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.d;
import com.tencent.mm.plugin.wxpay.a.e;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.plugin.wxpay.a.k;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.z;
import java.util.ArrayList;
import java.util.List;

public class MallEditText
  extends LinearLayout
  implements View.OnFocusChangeListener
{
  private TextView eYn;
  private View.OnFocusChangeListener fuf;
  private ImageView fui;
  private String fuj = "";
  String fuk = "";
  int ful = -1;
  public boolean fun = true;
  boolean fup = false;
  private int fuq = 1;
  private int fur = -1;
  private int gravity = 19;
  private boolean gun = true;
  private int imeOptions;
  private int inputType = 1;
  private MallEditText.b nqb;
  AutoCompleteTextView nqc;
  boolean nqd;
  private a nqe = null;
  private List<String[]> nqf;
  private com.tencent.mm.plugin.recharge.model.a nqg = null;
  private Runnable nqh = null;
  private boolean nqi = false;
  private int nqj = 0;
  
  public MallEditText(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public MallEditText(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet);
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, a.k.MallEditText, paramInt, 0);
    paramInt = paramAttributeSet.getResourceId(a.k.MallEditText_mallHint, 0);
    if (paramInt != 0) {
      this.fuj = paramContext.getString(paramInt);
    }
    paramInt = paramAttributeSet.getResourceId(a.k.MallEditText_mallTipmsg, 0);
    if (paramInt != 0) {
      this.fuk = paramContext.getString(paramInt);
    }
    this.inputType = paramAttributeSet.getInteger(a.k.MallEditText_android_inputType, 1);
    this.fun = paramAttributeSet.getBoolean(a.k.MallEditText_android_editable, true);
    this.gravity = paramAttributeSet.getInt(a.k.MallEditText_android_gravity, 19);
    this.gun = paramAttributeSet.getBoolean(a.k.MallEditText_android_clickable, true);
    this.fur = paramAttributeSet.getInteger(a.k.MallEditText_android_maxLength, -1);
    this.ful = paramAttributeSet.getInteger(a.k.MallEditText_mallEditType, 0);
    this.imeOptions = paramAttributeSet.getInteger(a.k.MallEditText_android_imeOptions, 5);
    paramAttributeSet.recycle();
    paramAttributeSet = LayoutInflater.from(paramContext).inflate(a.g.recharge_edit_text, this, true);
    this.eYn = ((TextView)paramAttributeSet.findViewById(a.f.username_tv));
    this.nqc = ((AutoCompleteTextView)paramAttributeSet.findViewById(a.f.hint_et));
    if (com.tencent.mm.cb.a.fh(paramContext))
    {
      this.nqc.setTextSize(0, paramContext.getResources().getDimensionPixelSize(a.d.NormalTextSize) * 1.25F);
      label298:
      this.fui = ((ImageView)paramAttributeSet.findViewById(a.f.info_iv));
      y.d("MicroMsg.MallEditText", "setFormat editType:" + this.ful);
      this.nqc.setImeOptions(this.imeOptions);
      switch (this.ful)
      {
      default: 
        label372:
        this.inputType = 1;
        label377:
        this.nqc.addTextChangedListener(new MallEditText.1(this));
        this.nqc.setOnFocusChangeListener(this);
        if (!bk.bl(this.fuj)) {
          this.nqc.setHint(this.fuj);
        }
        if (this.inputType == 2)
        {
          this.nqc.setKeyListener(new MallEditText.2(this));
          label444:
          this.nqc.setGravity(this.gravity);
          if (!this.gun)
          {
            this.nqc.setEnabled(false);
            this.nqc.setTextColor(getResources().getColor(a.c.black));
            this.nqc.setFocusable(false);
            this.nqc.setClickable(false);
          }
          if (this.fun) {
            break label728;
          }
          this.fup = true;
          this.nqc.setEnabled(false);
          this.nqc.setFocusable(false);
          this.nqc.setClickable(false);
        }
        break;
      }
    }
    for (;;)
    {
      if (this.fur != -1) {
        this.nqc.setFilters(new InputFilter[] { new InputFilter.LengthFilter(this.fur) });
      }
      y.d("MicroMsg.MallEditText", "initData editType:" + this.ful);
      switch (this.ful)
      {
      default: 
        return;
        this.nqc.setTextSize(0, com.tencent.mm.cb.a.aa(paramContext, a.d.NormalTextSize));
        break label298;
        this.fuq = 13;
        this.fur = 13;
        this.inputType = 2;
        setInfoTvImageResource(a.e.recharge_phone_contact);
        this.fui.setVisibility(0);
        break label377;
        if (this.fun) {
          break label372;
        }
        this.fui.setImageResource(a.e.mm_submenu);
        this.fui.setVisibility(0);
        break label372;
        this.nqc.setInputType(this.inputType);
        this.nqc.setRawInputType(this.inputType);
        break label444;
        label728:
        this.fup = false;
      }
    }
    y.d("MicroMsg.MallEditText", "setMobileEditTv");
    paramContext = com.tencent.mm.plugin.recharge.a.a.bva().bvb();
    this.nqe = new a((byte)0);
    this.nqe.ce(paramContext);
    if ((paramContext != null) && (paramContext.size() > 0))
    {
      this.nqg = ((com.tencent.mm.plugin.recharge.model.a)paramContext.get(0));
      setInput(this.nqg);
    }
    for (;;)
    {
      if ((paramContext == null) || (paramContext.size() == 0))
      {
        g.DQ();
        paramContext = (String)g.DP().Dz().get(6, null);
        this.nqc.setText(paramContext);
        this.nqc.setSelection(this.nqc.getText().length());
        bvd();
      }
      this.nqc.setAdapter(this.nqe);
      this.nqc.setOnItemClickListener(new MallEditText.4(this));
      return;
      if (this.nqf == null) {
        new Runnable()
        {
          public final void run()
          {
            try
            {
              MallEditText.a(MallEditText.this, com.tencent.mm.pluginsdk.a.ck(MallEditText.this.getContext()));
              return;
            }
            catch (Exception localException)
            {
              y.printErrStackTrace("MicroMsg.MallEditText", localException, "", new Object[0]);
            }
          }
        }.run();
      }
    }
  }
  
  private void bvd()
  {
    boolean bool = YL();
    if (bool != this.fup)
    {
      y.d("MicroMsg.MallEditText", "View:" + this.fuk + ", editType:" + this.ful + " inputValid change to " + bool);
      this.fup = bool;
      if (this.nqb != null) {
        this.nqb.gG(this.fup);
      }
      if (!bool)
      {
        if (this.eYn.getVisibility() == 0)
        {
          this.eYn.setText("");
          this.eYn.setVisibility(8);
        }
        this.nqg = null;
      }
    }
    if (this.nqb != null) {
      this.nqb.bve();
    }
  }
  
  private void setInputForce(com.tencent.mm.plugin.recharge.model.a parama)
  {
    this.nqg = parama;
    if (parama != null)
    {
      KeyListener localKeyListener = this.nqc.getKeyListener();
      this.nqc.setKeyListener(null);
      this.nqc.setText(parama.npv);
      this.nqc.setSelection(this.nqc.getText().length());
      this.nqc.setKeyListener(localKeyListener);
      bvd();
      y.d("MicroMsg.MallEditText", "editTv.setText " + parama.npv + ", name " + parama.name + ", isInputValid " + this.fup);
      if ((!bk.bl(parama.name)) && (this.fup))
      {
        this.eYn.setText(parama.name);
        this.eYn.setVisibility(0);
        return;
      }
      this.eYn.setText("");
      this.eYn.setVisibility(8);
      return;
    }
    this.nqc.setText("");
    bvd();
    y.d("MicroMsg.MallEditText", "editTv.setText null");
    this.eYn.setText("");
    this.eYn.setVisibility(8);
  }
  
  public final boolean YL()
  {
    switch (this.ful)
    {
    default: 
      if (this.nqc.getText().length() < this.fuq) {
        break;
      }
    case 1: 
      String str;
      do
      {
        return true;
        str = this.nqc.getText().toString();
      } while ((str.length() >= this.fuq) && (str.length() <= this.fur) && (PhoneNumberUtils.isGlobalPhoneNumber(b.qa(str))));
      return false;
    }
    return false;
  }
  
  public void getFocus()
  {
    this.nqc.findFocus();
  }
  
  public com.tencent.mm.plugin.recharge.model.a getInputRecord()
  {
    if (this.nqg != null) {
      return this.nqg;
    }
    this.nqg = new com.tencent.mm.plugin.recharge.model.a(getText(), this.eYn.getText().toString(), 0);
    return this.nqg;
  }
  
  public String getText()
  {
    switch (this.ful)
    {
    default: 
      return bk.aM(this.nqc.getText().toString(), "");
    }
    return bk.aM(this.nqc.getText().toString(), "");
  }
  
  public void onFocusChange(View paramView, boolean paramBoolean)
  {
    if (this.fuf != null) {
      this.fuf.onFocusChange(this, paramBoolean);
    }
    if (!this.nqi) {}
    for (boolean bool = true;; bool = false)
    {
      if ((bool == paramBoolean) && (!paramBoolean) && (this.nqh != null)) {
        this.nqh.run();
      }
      this.nqi = paramBoolean;
      y.d("MicroMsg.MallEditText", "View:" + this.fuk + ", editType:" + this.ful + " onFocusChange to " + paramBoolean);
      if (this.nqb != null) {
        this.nqb.gG(this.fup);
      }
      return;
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    return !this.fun;
  }
  
  public void setEllipsize(TextUtils.TruncateAt paramTruncateAt)
  {
    this.nqc.setEllipsize(paramTruncateAt);
  }
  
  public void setHintStr(String paramString)
  {
    this.nqc.setHint(paramString);
  }
  
  public void setImeOptions(int paramInt)
  {
    this.nqc.setImeOptions(paramInt);
  }
  
  public void setInfoTvImageResource(int paramInt)
  {
    if (paramInt == a.e.list_clear) {}
    for (boolean bool = true;; bool = false)
    {
      this.nqd = bool;
      this.fui.setImageResource(paramInt);
      return;
    }
  }
  
  public void setInfoTvOnClickListener(View.OnClickListener paramOnClickListener)
  {
    this.fui.setOnClickListener(paramOnClickListener);
  }
  
  public void setInput(com.tencent.mm.plugin.recharge.model.a parama)
  {
    this.nqg = parama;
    if (parama != null)
    {
      this.nqc.setText(parama.npv);
      this.nqc.setSelection(this.nqc.getText().length());
      bvd();
      y.d("MicroMsg.MallEditText", "editTv.setText " + parama.npv + ", name " + parama.name + ", isInputValid " + this.fup);
      if ((!bk.bl(parama.name)) && (this.fup))
      {
        this.eYn.setText(parama.name);
        this.eYn.setVisibility(0);
        return;
      }
      this.eYn.setText("");
      this.eYn.setVisibility(8);
      return;
    }
    this.nqc.setText("");
    bvd();
    y.d("MicroMsg.MallEditText", "editTv.setText null");
    this.eYn.setText("");
    this.eYn.setVisibility(8);
  }
  
  public void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    super.setOnClickListener(paramOnClickListener);
    this.nqc.setOnClickListener(paramOnClickListener);
  }
  
  public void setOnEditorActionListener(TextView.OnEditorActionListener paramOnEditorActionListener)
  {
    this.nqc.setOnEditorActionListener(paramOnEditorActionListener);
  }
  
  public void setOnFocusChangeListener(View.OnFocusChangeListener paramOnFocusChangeListener)
  {
    super.setOnFocusChangeListener(paramOnFocusChangeListener);
    this.fuf = paramOnFocusChangeListener;
  }
  
  public void setOnInputValidChangeListener(MallEditText.b paramb)
  {
    this.nqb = paramb;
  }
  
  private final class a
    extends BaseAdapter
    implements Filterable
  {
    public List<com.tencent.mm.plugin.recharge.model.a> nql = new ArrayList();
    public boolean nqm = false;
    private List<com.tencent.mm.plugin.recharge.model.a> nqn;
    private MallEditText.a.a nqo;
    private String nqp;
    
    private a() {}
    
    public final void ce(List<com.tencent.mm.plugin.recharge.model.a> paramList)
    {
      this.nqn = paramList;
      this.nql.clear();
      this.nqm = false;
    }
    
    public final int getCount()
    {
      if (this.nqm) {
        return this.nql.size() + 2;
      }
      if (this.nql.size() > 0) {
        return this.nql.size() + 1;
      }
      return 0;
    }
    
    public final Filter getFilter()
    {
      y.d("MicroMsg.MallEditText", "getFilter");
      if (this.nqo == null) {
        this.nqo = new MallEditText.a.a(this, (byte)0);
      }
      return this.nqo;
    }
    
    public final long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public final int getItemViewType(int paramInt)
    {
      int i = 0;
      if (this.nqm) {
        if (paramInt == 0) {
          i = 2;
        }
      }
      while (paramInt < this.nql.size())
      {
        do
        {
          return i;
        } while (paramInt <= this.nql.size());
        return 3;
      }
      return 1;
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      Object localObject;
      switch (getItemViewType(paramInt))
      {
      default: 
        localObject = paramView;
      case 0: 
        com.tencent.mm.plugin.recharge.model.a locala;
        do
        {
          do
          {
            do
            {
              do
              {
                return localObject;
                if (paramView != null) {
                  break;
                }
                paramView = View.inflate(MallEditText.this.getContext(), a.g.recharge_input_history_item, null);
                paramViewGroup = new MallEditText.c(MallEditText.this, (byte)0);
                paramViewGroup.nqt = ((TextView)paramView.findViewById(a.f.mall_input_record));
                paramViewGroup.fdt = ((TextView)paramView.findViewById(a.f.mall_input_name));
                paramView.setTag(paramViewGroup);
                locala = wu(paramInt);
                localObject = paramView;
              } while (locala == null);
              localObject = paramView;
            } while (paramViewGroup == null);
            localObject = paramView;
          } while (paramViewGroup.nqt == null);
          localObject = paramView;
        } while (paramViewGroup.fdt == null);
        localObject = b.LB(locala.npv);
        y.d("MicroMsg.MallEditText", "record.record " + (String)localObject + ", record.name " + locala.name);
        if (!com.tencent.mm.plugin.recharge.model.a.npt.equals(locala.npx))
        {
          localObject = new SpannableStringBuilder((CharSequence)localObject);
          int[] arrayOfInt = locala.npx;
          int k = arrayOfInt.length;
          int i = 0;
          if (i < k)
          {
            int j = arrayOfInt[i];
            if (j >= 0)
            {
              if (j < 7) {
                break label305;
              }
              paramInt = j + 2;
            }
            for (;;)
            {
              ((SpannableStringBuilder)localObject).setSpan(new ForegroundColorSpan(-65536), paramInt, paramInt + 1, 34);
              i += 1;
              break label234;
              paramViewGroup = (MallEditText.c)paramView.getTag();
              break;
              paramInt = j;
              if (j >= 3) {
                paramInt = j + 1;
              }
            }
          }
          paramViewGroup.nqt.setText((CharSequence)localObject);
          if ((locala.name == null) || (bk.bl(locala.name.trim()))) {
            break label406;
          }
          paramViewGroup.fdt.setText(MallEditText.this.getResources().getString(a.i.mall_recharge_username, new Object[] { locala.name }));
        }
        for (;;)
        {
          paramView.setBackgroundResource(a.e.comm_list_item_selector);
          return paramView;
          paramViewGroup.nqt.setText((CharSequence)localObject);
          break;
          paramViewGroup.fdt.setText("");
        }
      case 2: 
        paramView = View.inflate(MallEditText.this.getContext(), a.g.recharge_input_history_first_item, null);
        paramView.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            MallEditText.a(MallEditText.this).dismissDropDown();
          }
        });
        return paramView;
      case 1: 
        label234:
        paramView = View.inflate(MallEditText.this.getContext(), a.g.recharge_input_history_last_item, null);
        label305:
        paramView.setOnClickListener(new MallEditText.a.2(this));
        label406:
        return paramView;
      }
      paramView = View.inflate(MallEditText.this.getContext(), a.g.recharge_input_history_last_item, null);
      ((TextView)paramView).setText(a.i.mall_recharge_close);
      paramView.setOnClickListener(new MallEditText.a.3(this));
      return paramView;
    }
    
    public final int getViewTypeCount()
    {
      return 4;
    }
    
    /* Error */
    public final com.tencent.mm.plugin.recharge.model.a wu(int paramInt)
    {
      // Byte code:
      //   0: aconst_null
      //   1: astore_3
      //   2: aload_0
      //   3: monitorenter
      //   4: aload_0
      //   5: getfield 39	com/tencent/mm/plugin/recharge/ui/MallEditText$a:nqm	Z
      //   8: istore_2
      //   9: iload_2
      //   10: ifeq +43 -> 53
      //   13: iload_1
      //   14: ifne +7 -> 21
      //   17: aload_0
      //   18: monitorexit
      //   19: aload_3
      //   20: areturn
      //   21: iload_1
      //   22: aload_0
      //   23: getfield 37	com/tencent/mm/plugin/recharge/ui/MallEditText$a:nql	Ljava/util/List;
      //   26: invokeinterface 65 1 0
      //   31: if_icmpgt -14 -> 17
      //   34: aload_0
      //   35: getfield 37	com/tencent/mm/plugin/recharge/ui/MallEditText$a:nql	Ljava/util/List;
      //   38: iload_1
      //   39: iconst_1
      //   40: isub
      //   41: invokeinterface 270 2 0
      //   46: checkcast 142	com/tencent/mm/plugin/recharge/model/a
      //   49: astore_3
      //   50: goto -33 -> 17
      //   53: iload_1
      //   54: aload_0
      //   55: getfield 37	com/tencent/mm/plugin/recharge/ui/MallEditText$a:nql	Ljava/util/List;
      //   58: invokeinterface 65 1 0
      //   63: if_icmpge -46 -> 17
      //   66: aload_0
      //   67: getfield 37	com/tencent/mm/plugin/recharge/ui/MallEditText$a:nql	Ljava/util/List;
      //   70: iload_1
      //   71: invokeinterface 270 2 0
      //   76: checkcast 142	com/tencent/mm/plugin/recharge/model/a
      //   79: astore_3
      //   80: goto -63 -> 17
      //   83: astore_3
      //   84: aload_0
      //   85: monitorexit
      //   86: aload_3
      //   87: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	88	0	this	a
      //   0	88	1	paramInt	int
      //   8	2	2	bool	boolean
      //   1	79	3	locala	com.tencent.mm.plugin.recharge.model.a
      //   83	4	3	localObject	Object
      // Exception table:
      //   from	to	target	type
      //   4	9	83	finally
      //   21	50	83	finally
      //   53	80	83	finally
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.recharge.ui.MallEditText
 * JD-Core Version:    0.7.0.1
 */