package com.tencent.mm.plugin.recharge.ui.form;

import android.content.Context;
import android.content.res.Resources;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AutoCompleteTextView;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filter.FilterResults;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.plugin.recharge.model.b;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class d
  extends BaseAdapter
  implements Filterable
{
  private static String TAG = "MicroMsg.MobileHistoryAdapter";
  private Context mContext;
  private AutoCompleteTextView nqc;
  private List<String[]> nqf;
  public List<com.tencent.mm.plugin.recharge.model.a> nql = new ArrayList();
  public boolean nqm = false;
  private List<com.tencent.mm.plugin.recharge.model.a> nqn;
  private String nqp;
  private MallFormView nrP;
  private b nsC;
  public d nsD = null;
  public a nsE = null;
  
  public d(MallFormView paramMallFormView, List<String[]> paramList)
  {
    this.mContext = paramMallFormView.getContext();
    this.nrP = paramMallFormView;
    this.nqc = ((AutoCompleteTextView)paramMallFormView.getContentEditText());
    this.nqf = paramList;
  }
  
  public final void ce(List<com.tencent.mm.plugin.recharge.model.a> paramList)
  {
    try
    {
      this.nqn = paramList;
      this.nql.clear();
      this.nqm = false;
      notifyDataSetChanged();
      return;
    }
    finally
    {
      paramList = finally;
      throw paramList;
    }
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
    y.d(TAG, "getFilter");
    if (this.nsC == null) {
      this.nsC = new b((byte)0);
    }
    return this.nsC;
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
              paramView = View.inflate(this.mContext, a.g.recharge_input_history_item, null);
              paramViewGroup = new c((byte)0);
              paramViewGroup.nqt = ((TextView)paramView.findViewById(a.f.mall_input_record));
              paramViewGroup.fdt = ((TextView)paramView.findViewById(a.f.mall_input_name));
              paramViewGroup.nsH = ((ImageView)paramView.findViewById(a.f.top_divider));
              paramView.setTag(paramViewGroup);
              if ((paramViewGroup != null) && (paramViewGroup.nsH != null))
              {
                if (paramInt != 0) {
                  break label361;
                }
                paramViewGroup.nsH.setVisibility(0);
              }
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
      y.d(TAG, "record.record " + (String)localObject + ", record.name " + locala.name + "，record.location " + locala.npw);
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
              break label373;
            }
            paramInt = j + 2;
          }
          for (;;)
          {
            ((SpannableStringBuilder)localObject).setSpan(new ForegroundColorSpan(this.mContext.getResources().getColor(a.c.recharge_wrong_number_span_color)), paramInt, paramInt + 1, 34);
            i += 1;
            break label279;
            paramViewGroup = (c)paramView.getTag();
            break;
            paramViewGroup.nsH.setVisibility(8);
            break label138;
            paramInt = j;
            if (j >= 3) {
              paramInt = j + 1;
            }
          }
        }
        paramViewGroup.nqt.setTextSize(24.0F);
        paramViewGroup.nqt.setTextColor(this.mContext.getResources().getColor(a.c.normal_text_color));
        paramViewGroup.fdt.setTextColor(this.mContext.getResources().getColor(a.c.normal_text_color));
        paramViewGroup.nqt.setText((CharSequence)localObject);
        if ((locala.name == null) || (bk.bl(locala.name.trim()))) {
          break label674;
        }
        if (bk.bl(locala.npw)) {
          break label637;
        }
        paramViewGroup.fdt.setText(locala.name + this.mContext.getString(a.i.wallet_recharge_dest_wrapper, new Object[] { locala.npw }));
      }
      for (;;)
      {
        if (!locala.name.equals(this.mContext.getString(a.i.wallet_recharge_me))) {
          break label652;
        }
        paramViewGroup.fdt.setTextColor(this.mContext.getResources().getColor(a.c.recharge_product_item_bg_clicked));
        return paramView;
        paramViewGroup.nqt.setTextSize(16.0F);
        paramViewGroup.nqt.setTextColor(this.mContext.getResources().getColor(a.c.hint_text_color));
        paramViewGroup.fdt.setTextColor(this.mContext.getResources().getColor(a.c.hint_text_color));
        paramViewGroup.nqt.setText((CharSequence)localObject);
        break;
        paramViewGroup.fdt.setText(locala.name);
      }
      paramViewGroup.fdt.setTextColor(this.mContext.getResources().getColor(a.c.normal_color));
      return paramView;
      if (!bk.bl(locala.npw))
      {
        paramViewGroup.fdt.setText(this.mContext.getString(a.i.wallet_recharge_not_in_contact) + this.mContext.getString(a.i.wallet_recharge_dest_wrapper, new Object[] { locala.npw }));
        return paramView;
      }
      paramViewGroup.fdt.setText(this.mContext.getString(a.i.wallet_recharge_not_in_contact));
      return paramView;
    case 2: 
      paramView = View.inflate(this.mContext, a.g.recharge_input_history_first_item, null);
      paramView.setOnClickListener(new d.1(this));
      return paramView;
    case 1: 
      label138:
      label279:
      label361:
      label373:
      label637:
      paramView = View.inflate(this.mContext, a.g.recharge_input_history_last_item, null);
      label652:
      label674:
      paramView.setOnClickListener(new d.2(this));
      return paramView;
    }
    paramView = View.inflate(this.mContext, a.g.recharge_input_history_last_item, null);
    ((TextView)paramView.findViewById(a.f.recharge_id_last_item_content)).setText(a.i.mall_recharge_close);
    paramView.setOnClickListener(new d.3(this));
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
    //   5: getfield 59	com/tencent/mm/plugin/recharge/ui/form/d:nqm	Z
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
    //   23: getfield 57	com/tencent/mm/plugin/recharge/ui/form/d:nql	Ljava/util/List;
    //   26: invokeinterface 118 1 0
    //   31: if_icmpgt -14 -> 17
    //   34: aload_0
    //   35: getfield 57	com/tencent/mm/plugin/recharge/ui/form/d:nql	Ljava/util/List;
    //   38: iload_1
    //   39: iconst_1
    //   40: isub
    //   41: invokeinterface 365 2 0
    //   46: checkcast 198	com/tencent/mm/plugin/recharge/model/a
    //   49: astore_3
    //   50: goto -33 -> 17
    //   53: iload_1
    //   54: aload_0
    //   55: getfield 57	com/tencent/mm/plugin/recharge/ui/form/d:nql	Ljava/util/List;
    //   58: invokeinterface 118 1 0
    //   63: if_icmpge -46 -> 17
    //   66: aload_0
    //   67: getfield 57	com/tencent/mm/plugin/recharge/ui/form/d:nql	Ljava/util/List;
    //   70: iload_1
    //   71: invokeinterface 365 2 0
    //   76: checkcast 198	com/tencent/mm/plugin/recharge/model/a
    //   79: astore_3
    //   80: goto -63 -> 17
    //   83: astore_3
    //   84: aload_0
    //   85: monitorexit
    //   86: aload_3
    //   87: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	88	0	this	d
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
  
  public static abstract interface a
  {
    public abstract void bvi();
  }
  
  private final class b
    extends Filter
  {
    private b() {}
    
    private static int[] et(String paramString1, String paramString2)
    {
      if (paramString1.equals(paramString2)) {
        return com.tencent.mm.plugin.recharge.model.a.npt;
      }
      if ((paramString2 != null) && (paramString1.length() == paramString2.length()))
      {
        int i = 0;
        int[] arrayOfInt = new int[2];
        int[] tmp36_34 = arrayOfInt;
        tmp36_34[0] = -1;
        int[] tmp40_36 = tmp36_34;
        tmp40_36[1] = -1;
        tmp40_36;
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
        if (k <= 2) {
          return arrayOfInt;
        }
      }
      return com.tencent.mm.plugin.recharge.model.a.npu;
    }
    
    protected final Filter.FilterResults performFiltering(CharSequence paramCharSequence)
    {
      label521:
      label669:
      label680:
      for (;;)
      {
        Filter.FilterResults localFilterResults;
        ArrayList localArrayList;
        Object localObject1;
        try
        {
          localFilterResults = new Filter.FilterResults();
          localArrayList = new ArrayList();
          if (paramCharSequence != null)
          {
            localObject1 = b.qa(paramCharSequence.toString());
            if ((((String)localObject1).equals(d.d(d.this))) && (!((String)localObject1).equals("")))
            {
              d.a(d.this).post(new d.b.1(this));
              return localFilterResults;
            }
          }
          else
          {
            localObject1 = "";
            continue;
          }
          d.a(d.this, (String)localObject1);
          if (!d.b(d.this).YL()) {
            if (!bk.bl(d.d(d.this)))
            {
              y.i(d.TAG, "performFiltering1 " + paramCharSequence);
              paramCharSequence = d.e(d.this).iterator();
              if (paramCharSequence.hasNext())
              {
                localObject1 = (com.tencent.mm.plugin.recharge.model.a)paramCharSequence.next();
                if (!((com.tencent.mm.plugin.recharge.model.a)localObject1).npv.startsWith(d.d(d.this))) {
                  continue;
                }
                localArrayList.add(localObject1);
                continue;
              }
              bool = false;
            }
          }
        }
        finally {}
        for (;;)
        {
          localFilterResults.count = localArrayList.size();
          localFilterResults.values = localArrayList;
          d.this.nqm = bool;
          if (localArrayList.size() != 0) {
            break label669;
          }
          d.b(d.this).nsz = true;
          break label680;
          localArrayList.addAll(d.e(d.this));
          boolean bool = false;
          continue;
          long l = System.currentTimeMillis();
          y.i(d.TAG, "performFiltering2 " + paramCharSequence);
          paramCharSequence = com.tencent.mm.plugin.recharge.a.a.bvc();
          if ((paramCharSequence != null) && (((String)localObject1).equals(paramCharSequence.npv))) {
            break;
          }
          if ((d.f(d.this) == null) || (d.f(d.this).isEmpty())) {
            d.a(d.this, com.tencent.mm.pluginsdk.a.ck(d.g(d.this)));
          }
          Object localObject2;
          if (d.f(d.this) != null)
          {
            paramCharSequence = d.f(d.this).iterator();
            for (;;)
            {
              if (!paramCharSequence.hasNext()) {
                break label521;
              }
              localObject2 = (String[])paramCharSequence.next();
              String str = b.qa(localObject2[2]);
              localObject1 = et(d.d(d.this), str);
              if (com.tencent.mm.plugin.recharge.model.a.npt.equals(localObject1)) {
                break;
              }
              if ((!com.tencent.mm.plugin.recharge.model.a.npu.equals(localObject1)) && (localArrayList.size() < 4))
              {
                localObject2 = new com.tencent.mm.plugin.recharge.model.a(str, localObject2[1], 1);
                ((com.tencent.mm.plugin.recharge.model.a)localObject2).npx = ((int[])localObject1);
                localArrayList.add(localObject2);
              }
            }
          }
          paramCharSequence = com.tencent.mm.plugin.recharge.a.a.bva().bvb().iterator();
          for (;;)
          {
            if (!paramCharSequence.hasNext()) {
              break label633;
            }
            localObject1 = (com.tencent.mm.plugin.recharge.model.a)paramCharSequence.next();
            localObject2 = b.qa(((com.tencent.mm.plugin.recharge.model.a)localObject1).npv);
            localObject2 = et(d.d(d.this), (String)localObject2);
            if (com.tencent.mm.plugin.recharge.model.a.npt.equals(localObject2)) {
              break;
            }
            if ((!com.tencent.mm.plugin.recharge.model.a.npu.equals(localObject2)) && (localArrayList.size() < 4))
            {
              ((com.tencent.mm.plugin.recharge.model.a)localObject1).npx = ((int[])localObject2);
              localArrayList.add(localObject1);
            }
          }
          label633:
          y.d(d.TAG, " search phone number cost " + (System.currentTimeMillis() - l) + " ms ");
          bool = true;
        }
        d.b(d.this).nsz = false;
      }
    }
    
    protected final void publishResults(CharSequence paramCharSequence, Filter.FilterResults paramFilterResults)
    {
      if (paramFilterResults.values == null)
      {
        d.this.nql = new ArrayList();
        if (paramFilterResults.count != 0) {
          break label96;
        }
      }
      label96:
      for (d.b(d.this).nsz = true;; d.b(d.this).nsz = false)
      {
        y.i(d.TAG, "results.count " + paramFilterResults.count);
        if (paramFilterResults.count > 0) {
          d.this.notifyDataSetChanged();
        }
        return;
        d.this.nql = ((List)paramFilterResults.values);
        break;
      }
    }
  }
  
  private final class c
  {
    TextView fdt;
    TextView nqt;
    ImageView nsH;
    
    private c() {}
  }
  
  public static abstract interface d {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.recharge.ui.form.d
 * JD-Core Version:    0.7.0.1
 */