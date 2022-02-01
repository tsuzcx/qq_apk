package com.tencent.mm.plugin.recharge.ui.form;

import android.content.Context;
import android.content.res.Resources;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AutoCompleteTextView;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filter.FilterResults;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class d
  extends BaseAdapter
  implements Filterable
{
  private static String TAG = "MicroMsg.MobileHistoryAdapter";
  private MallFormView HBt;
  private b HCg;
  public d HCh;
  public a HCi;
  private AutoCompleteTextView HzH;
  List<String[]> HzK;
  public List<com.tencent.mm.plugin.recharge.model.a> HzQ;
  public boolean HzR;
  private List<com.tencent.mm.plugin.recharge.model.a> HzS;
  private String HzU;
  private Context mContext;
  
  public d(MallFormView paramMallFormView, List<String[]> paramList)
  {
    AppMethodBeat.i(67321);
    this.HzQ = new ArrayList();
    this.HzR = false;
    this.HCh = null;
    this.HCi = null;
    this.mContext = paramMallFormView.getContext();
    this.HBt = paramMallFormView;
    this.HzH = ((AutoCompleteTextView)paramMallFormView.getContentEditText());
    this.HzK = paramList;
    AppMethodBeat.o(67321);
  }
  
  public final com.tencent.mm.plugin.recharge.model.a abX(int paramInt)
  {
    com.tencent.mm.plugin.recharge.model.a locala1 = null;
    for (;;)
    {
      try
      {
        AppMethodBeat.i(67325);
        if (!this.HzR) {
          break label79;
        }
        if (paramInt == 0)
        {
          AppMethodBeat.o(67325);
          return locala1;
        }
        if (paramInt <= this.HzQ.size())
        {
          locala1 = (com.tencent.mm.plugin.recharge.model.a)this.HzQ.get(paramInt - 1);
          AppMethodBeat.o(67325);
          continue;
        }
        AppMethodBeat.o(67325);
      }
      finally {}
      continue;
      label79:
      if (paramInt < this.HzQ.size())
      {
        com.tencent.mm.plugin.recharge.model.a locala2 = (com.tencent.mm.plugin.recharge.model.a)this.HzQ.get(paramInt);
        AppMethodBeat.o(67325);
      }
      else
      {
        AppMethodBeat.o(67325);
      }
    }
  }
  
  public final void gE(List<com.tencent.mm.plugin.recharge.model.a> paramList)
  {
    try
    {
      AppMethodBeat.i(67322);
      this.HzS = paramList;
      notifyDataSetChanged();
      AppMethodBeat.o(67322);
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
    AppMethodBeat.i(67324);
    int i;
    if (this.HzR)
    {
      i = this.HzQ.size();
      AppMethodBeat.o(67324);
      return i + 2;
    }
    if (this.HzQ.size() > 0)
    {
      i = this.HzQ.size();
      AppMethodBeat.o(67324);
      return i + 1;
    }
    AppMethodBeat.o(67324);
    return 0;
  }
  
  public final Filter getFilter()
  {
    AppMethodBeat.i(67323);
    Log.d(TAG, "getFilter");
    if (this.HCg == null) {
      this.HCg = new b((byte)0);
    }
    b localb = this.HCg;
    AppMethodBeat.o(67323);
    return localb;
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final int getItemViewType(int paramInt)
  {
    AppMethodBeat.i(67327);
    if (this.HzR)
    {
      if (paramInt == 0)
      {
        AppMethodBeat.o(67327);
        return 2;
      }
      if (paramInt <= this.HzQ.size())
      {
        AppMethodBeat.o(67327);
        return 0;
      }
      AppMethodBeat.o(67327);
      return 3;
    }
    if (paramInt < this.HzQ.size())
    {
      AppMethodBeat.o(67327);
      return 0;
    }
    AppMethodBeat.o(67327);
    return 1;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(67326);
    switch (getItemViewType(paramInt))
    {
    }
    label151:
    label287:
    label675:
    for (;;)
    {
      AppMethodBeat.o(67326);
      return paramView;
      c localc;
      com.tencent.mm.plugin.recharge.model.a locala;
      int i;
      int j;
      if (paramView == null)
      {
        paramViewGroup = View.inflate(this.mContext, a.g.recharge_input_history_item, null);
        localc = new c((byte)0);
        localc.HzY = ((TextView)paramViewGroup.findViewById(a.f.mall_input_record));
        localc.jbF = ((TextView)paramViewGroup.findViewById(a.f.mall_input_name));
        localc.HCl = ((ImageView)paramViewGroup.findViewById(a.f.top_divider));
        paramViewGroup.setTag(localc);
        if ((localc != null) && (localc.HCl != null))
        {
          if (paramInt != 0) {
            break label371;
          }
          localc.HCl.setVisibility(0);
        }
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
        Log.d(TAG, "record.record " + paramView + ", record.name " + locala.name + "，record.location " + locala.oex);
        if (com.tencent.mm.plugin.recharge.model.a.HyZ.equals(locala.Hzc)) {
          break label594;
        }
        paramView = new SpannableStringBuilder(paramView);
        int[] arrayOfInt = locala.Hzc;
        int k = arrayOfInt.length;
        i = 0;
        if (i >= k) {
          break label401;
        }
        j = arrayOfInt[i];
        if (j >= 0)
        {
          if (j < 7) {
            break label384;
          }
          paramInt = j + 2;
        }
      }
      for (;;)
      {
        paramView.setSpan(new ForegroundColorSpan(this.mContext.getResources().getColor(a.c.recharge_wrong_number_span_color)), paramInt, paramInt + 1, 34);
        i += 1;
        break label287;
        localc = (c)paramView.getTag();
        paramViewGroup = paramView;
        break;
        label371:
        localc.HCl.setVisibility(8);
        break label151;
        paramInt = j;
        if (j >= 3) {
          paramInt = j + 1;
        }
      }
      localc.HzY.setTextSize(24.0F);
      localc.HzY.setTextColor(this.mContext.getResources().getColor(a.c.normal_text_color));
      localc.jbF.setTextColor(this.mContext.getResources().getColor(a.c.normal_text_color));
      localc.HzY.setText(paramView);
      label463:
      if ((locala.name != null) && (!Util.isNullOrNil(locala.name.trim())))
      {
        if (!Util.isNullOrNil(locala.oex)) {
          localc.jbF.setText(locala.name + this.mContext.getString(a.i.wallet_recharge_dest_wrapper, new Object[] { locala.oex }));
        }
        for (;;)
        {
          if (!locala.name.equals(this.mContext.getString(a.i.wallet_recharge_me))) {
            break label675;
          }
          localc.jbF.setTextColor(this.mContext.getResources().getColor(a.c.recharge_product_item_bg_clicked));
          paramView = paramViewGroup;
          break;
          label594:
          localc.HzY.setTextSize(16.0F);
          localc.HzY.setTextColor(this.mContext.getResources().getColor(a.c.hint_text_color));
          localc.jbF.setTextColor(this.mContext.getResources().getColor(a.c.hint_text_color));
          localc.HzY.setText(paramView);
          break label463;
          localc.jbF.setText(locala.name);
        }
        localc.jbF.setTextColor(this.mContext.getResources().getColor(a.c.normal_color));
        paramView = paramViewGroup;
      }
      else if (!Util.isNullOrNil(locala.oex))
      {
        localc.jbF.setText(this.mContext.getString(a.i.wallet_recharge_not_in_contact) + this.mContext.getString(a.i.wallet_recharge_dest_wrapper, new Object[] { locala.oex }));
        paramView = paramViewGroup;
      }
      else
      {
        localc.jbF.setText(this.mContext.getString(a.i.wallet_recharge_not_in_contact));
        paramView = paramViewGroup;
        continue;
        paramView = View.inflate(this.mContext, a.g.recharge_input_history_first_item, null);
        paramView.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(67314);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bn(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/recharge/ui/form/MobileHistoryAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
            d.a(d.this).dismissDropDown();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/recharge/ui/form/MobileHistoryAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(67314);
          }
        });
        continue;
        paramView = View.inflate(this.mContext, a.g.recharge_input_history_last_item, null);
        paramView.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(67315);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bn(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/recharge/ui/form/MobileHistoryAdapter$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
            com.tencent.mm.plugin.recharge.a.a.ftQ().gE(null);
            d.b(d.this).fuo();
            d.this.gE(new LinkedList());
            if (d.c(d.this) != null) {
              d.c(d.this).fud();
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/recharge/ui/form/MobileHistoryAdapter$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(67315);
          }
        });
        continue;
        paramView = View.inflate(this.mContext, a.g.recharge_input_history_last_item, null);
        ((TextView)paramView.findViewById(a.f.recharge_id_last_item_content)).setText(a.i.mall_recharge_close);
        paramView.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(67316);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bn(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/recharge/ui/form/MobileHistoryAdapter$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
            d.a(d.this).dismissDropDown();
            d.b(d.this).fun();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/recharge/ui/form/MobileHistoryAdapter$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(67316);
          }
        });
      }
    }
  }
  
  public final int getViewTypeCount()
  {
    return 4;
  }
  
  public static abstract interface a
  {
    public abstract void fud();
  }
  
  final class b
    extends Filter
  {
    private b() {}
    
    private static int[] jJ(String paramString1, String paramString2)
    {
      AppMethodBeat.i(67320);
      if (paramString1.equals(paramString2))
      {
        paramString1 = com.tencent.mm.plugin.recharge.model.a.HyZ;
        AppMethodBeat.o(67320);
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
          AppMethodBeat.o(67320);
          return arrayOfInt;
        }
      }
      paramString1 = com.tencent.mm.plugin.recharge.model.a.Hza;
      AppMethodBeat.o(67320);
      return paramString1;
    }
    
    protected final Filter.FilterResults performFiltering(CharSequence paramCharSequence)
    {
      Filter.FilterResults localFilterResults;
      ArrayList localArrayList;
      Object localObject1;
      Object localObject2;
      try
      {
        AppMethodBeat.i(67318);
        localFilterResults = new Filter.FilterResults();
        localArrayList = new ArrayList();
        if (paramCharSequence != null) {}
        for (localObject1 = com.tencent.mm.plugin.recharge.model.b.aaY(paramCharSequence.toString()); (((String)localObject1).equals(d.d(d.this))) && (!((String)localObject1).equals("")); localObject1 = "")
        {
          d.a(d.this).post(new d.b.1(this));
          localFilterResults.count = d.this.HzQ.size();
          localFilterResults.values = d.this.HzQ;
          AppMethodBeat.o(67318);
          return localFilterResults;
        }
        d.a(d.this, (String)localObject1);
        if ((d.e(d.this) != null) && (!d.e(d.this).isEmpty()))
        {
          localObject2 = d.e(d.this).iterator();
          while (((Iterator)localObject2).hasNext()) {
            ((com.tencent.mm.plugin.recharge.model.a)((Iterator)localObject2).next()).Hzc = com.tencent.mm.plugin.recharge.model.a.HyZ;
          }
        }
        if (d.b(d.this).bAz()) {
          break label373;
        }
      }
      finally {}
      if (!Util.isNullOrNil(d.d(d.this)))
      {
        Log.i(d.TAG, "performFiltering1 ".concat(String.valueOf(paramCharSequence)));
        paramCharSequence = d.e(d.this).iterator();
        while (paramCharSequence.hasNext())
        {
          localObject1 = (com.tencent.mm.plugin.recharge.model.a)paramCharSequence.next();
          if (((com.tencent.mm.plugin.recharge.model.a)localObject1).Hzb.startsWith(d.d(d.this))) {
            localArrayList.add(localObject1);
          }
        }
      }
      for (;;)
      {
        localFilterResults.count = localArrayList.size();
        localFilterResults.values = localArrayList;
        d.this.HzR = bool;
        AppMethodBeat.o(67318);
        break;
        localArrayList.addAll(d.e(d.this));
        boolean bool = false;
        continue;
        label373:
        long l = System.currentTimeMillis();
        Log.i(d.TAG, "performFiltering2 ".concat(String.valueOf(paramCharSequence)));
        paramCharSequence = com.tencent.mm.plugin.recharge.a.a.ftS();
        if ((paramCharSequence != null) && (((String)localObject1).equals(paramCharSequence.Hzb)))
        {
          AppMethodBeat.o(67318);
          break;
        }
        if ((d.f(d.this) == null) || (d.f(d.this).isEmpty())) {
          d.a(d.this, com.tencent.mm.pluginsdk.b.dN(d.g(d.this)));
        }
        if (d.f(d.this) != null)
        {
          paramCharSequence = d.f(d.this).iterator();
          for (;;)
          {
            if (!paramCharSequence.hasNext()) {
              break label606;
            }
            localObject2 = (String[])paramCharSequence.next();
            String str = com.tencent.mm.plugin.recharge.model.b.aaY(localObject2[2]);
            localObject1 = jJ(d.d(d.this), str);
            if (com.tencent.mm.plugin.recharge.model.a.HyZ.equals(localObject1))
            {
              AppMethodBeat.o(67318);
              break;
            }
            if ((!com.tencent.mm.plugin.recharge.model.a.Hza.equals(localObject1)) && (localArrayList.size() < 4))
            {
              localObject2 = new com.tencent.mm.plugin.recharge.model.a(str, localObject2[1], 1);
              ((com.tencent.mm.plugin.recharge.model.a)localObject2).Hzc = ((int[])localObject1);
              localArrayList.add(localObject2);
            }
          }
        }
        label606:
        paramCharSequence = com.tencent.mm.plugin.recharge.a.a.ftQ().ftR().iterator();
        for (;;)
        {
          if (!paramCharSequence.hasNext()) {
            break label723;
          }
          localObject1 = (com.tencent.mm.plugin.recharge.model.a)paramCharSequence.next();
          localObject2 = com.tencent.mm.plugin.recharge.model.b.aaY(((com.tencent.mm.plugin.recharge.model.a)localObject1).Hzb);
          localObject2 = jJ(d.d(d.this), (String)localObject2);
          if (com.tencent.mm.plugin.recharge.model.a.HyZ.equals(localObject2))
          {
            AppMethodBeat.o(67318);
            break;
          }
          if ((!com.tencent.mm.plugin.recharge.model.a.Hza.equals(localObject2)) && (localArrayList.size() < 4))
          {
            ((com.tencent.mm.plugin.recharge.model.a)localObject1).Hzc = ((int[])localObject2);
            localArrayList.add(localObject1);
          }
        }
        label723:
        Log.d(d.TAG, " search phone number cost " + (System.currentTimeMillis() - l) + " ms ");
        bool = true;
        continue;
        bool = false;
      }
    }
    
    protected final void publishResults(CharSequence paramCharSequence, Filter.FilterResults paramFilterResults)
    {
      AppMethodBeat.i(67319);
      if (paramFilterResults.values == null)
      {
        d.this.HzQ = new ArrayList();
        if (paramFilterResults.count != 0) {
          break label109;
        }
      }
      label109:
      for (d.b(d.this).HCd = true;; d.b(d.this).HCd = false)
      {
        Log.i(d.TAG, "results.count " + paramFilterResults.count);
        if (paramFilterResults.count > 0) {
          d.this.notifyDataSetChanged();
        }
        AppMethodBeat.o(67319);
        return;
        d.this.HzQ = ((List)paramFilterResults.values);
        break;
      }
    }
  }
  
  final class c
  {
    ImageView HCl;
    TextView HzY;
    TextView jbF;
    
    private c() {}
  }
  
  public static abstract interface d {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.recharge.ui.form.d
 * JD-Core Version:    0.7.0.1
 */