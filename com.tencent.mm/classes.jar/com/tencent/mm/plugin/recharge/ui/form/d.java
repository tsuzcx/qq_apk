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
  private AutoCompleteTextView Nxk;
  List<String[]> Nxn;
  public List<com.tencent.mm.plugin.recharge.model.a> Nxt;
  public boolean Nxu;
  private List<com.tencent.mm.plugin.recharge.model.a> Nxv;
  private String Nxx;
  private MallFormView NyW;
  private b NzJ;
  public d NzK;
  public a NzL;
  private Context mContext;
  
  public d(MallFormView paramMallFormView, List<String[]> paramList)
  {
    AppMethodBeat.i(67321);
    this.Nxt = new ArrayList();
    this.Nxu = false;
    this.NzK = null;
    this.NzL = null;
    this.mContext = paramMallFormView.getContext();
    this.NyW = paramMallFormView;
    this.Nxk = ((AutoCompleteTextView)paramMallFormView.getContentEditText());
    this.Nxn = paramList;
    AppMethodBeat.o(67321);
  }
  
  public final com.tencent.mm.plugin.recharge.model.a agl(int paramInt)
  {
    com.tencent.mm.plugin.recharge.model.a locala1 = null;
    for (;;)
    {
      try
      {
        AppMethodBeat.i(67325);
        if (!this.Nxu) {
          break label79;
        }
        if (paramInt == 0)
        {
          AppMethodBeat.o(67325);
          return locala1;
        }
        if (paramInt <= this.Nxt.size())
        {
          locala1 = (com.tencent.mm.plugin.recharge.model.a)this.Nxt.get(paramInt - 1);
          AppMethodBeat.o(67325);
          continue;
        }
        AppMethodBeat.o(67325);
      }
      finally {}
      continue;
      label79:
      if (paramInt < this.Nxt.size())
      {
        com.tencent.mm.plugin.recharge.model.a locala2 = (com.tencent.mm.plugin.recharge.model.a)this.Nxt.get(paramInt);
        AppMethodBeat.o(67325);
      }
      else
      {
        AppMethodBeat.o(67325);
      }
    }
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(67324);
    int i;
    if (this.Nxu)
    {
      i = this.Nxt.size();
      AppMethodBeat.o(67324);
      return i + 2;
    }
    if (this.Nxt.size() > 0)
    {
      i = this.Nxt.size();
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
    if (this.NzJ == null) {
      this.NzJ = new b((byte)0);
    }
    b localb = this.NzJ;
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
    if (this.Nxu)
    {
      if (paramInt == 0)
      {
        AppMethodBeat.o(67327);
        return 2;
      }
      if (paramInt <= this.Nxt.size())
      {
        AppMethodBeat.o(67327);
        return 0;
      }
      AppMethodBeat.o(67327);
      return 3;
    }
    if (paramInt < this.Nxt.size())
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
        localc.NxB = ((TextView)paramViewGroup.findViewById(a.f.mall_input_record));
        localc.lDF = ((TextView)paramViewGroup.findViewById(a.f.mall_input_name));
        localc.NzO = ((ImageView)paramViewGroup.findViewById(a.f.top_divider));
        paramViewGroup.setTag(localc);
        if ((localc != null) && (localc.NzO != null))
        {
          if (paramInt != 0) {
            break label371;
          }
          localc.NzO.setVisibility(0);
        }
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
        Log.d(TAG, "record.record " + paramView + ", record.name " + locala.name + "，record.location " + locala.mse);
        if (com.tencent.mm.plugin.recharge.model.a.NwE.equals(locala.NwH)) {
          break label594;
        }
        paramView = new SpannableStringBuilder(paramView);
        int[] arrayOfInt = locala.NwH;
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
        localc.NzO.setVisibility(8);
        break label151;
        paramInt = j;
        if (j >= 3) {
          paramInt = j + 1;
        }
      }
      localc.NxB.setTextSize(24.0F);
      localc.NxB.setTextColor(this.mContext.getResources().getColor(a.c.normal_text_color));
      localc.lDF.setTextColor(this.mContext.getResources().getColor(a.c.normal_text_color));
      localc.NxB.setText(paramView);
      label463:
      if ((locala.name != null) && (!Util.isNullOrNil(locala.name.trim())))
      {
        if (!Util.isNullOrNil(locala.mse)) {
          localc.lDF.setText(locala.name + this.mContext.getString(a.i.wallet_recharge_dest_wrapper, new Object[] { locala.mse }));
        }
        for (;;)
        {
          if (!locala.name.equals(this.mContext.getString(a.i.wallet_recharge_me))) {
            break label675;
          }
          localc.lDF.setTextColor(this.mContext.getResources().getColor(a.c.recharge_product_item_bg_clicked));
          paramView = paramViewGroup;
          break;
          label594:
          localc.NxB.setTextSize(16.0F);
          localc.NxB.setTextColor(this.mContext.getResources().getColor(a.c.hint_text_color));
          localc.lDF.setTextColor(this.mContext.getResources().getColor(a.c.hint_text_color));
          localc.NxB.setText(paramView);
          break label463;
          localc.lDF.setText(locala.name);
        }
        localc.lDF.setTextColor(this.mContext.getResources().getColor(a.c.normal_color));
        paramView = paramViewGroup;
      }
      else if (!Util.isNullOrNil(locala.mse))
      {
        localc.lDF.setText(this.mContext.getString(a.i.wallet_recharge_not_in_contact) + this.mContext.getString(a.i.wallet_recharge_dest_wrapper, new Object[] { locala.mse }));
        paramView = paramViewGroup;
      }
      else
      {
        localc.lDF.setText(this.mContext.getString(a.i.wallet_recharge_not_in_contact));
        paramView = paramViewGroup;
        continue;
        paramView = View.inflate(this.mContext, a.g.recharge_input_history_first_item, null);
        paramView.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(67314);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.cH(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/recharge/ui/form/MobileHistoryAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
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
            localb.cH(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/recharge/ui/form/MobileHistoryAdapter$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
            com.tencent.mm.plugin.recharge.a.a.gFE().jE(null);
            d.b(d.this).gGd();
            d.this.jE(new LinkedList());
            if (d.c(d.this) != null) {
              d.c(d.this).gFR();
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
            localb.cH(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/recharge/ui/form/MobileHistoryAdapter$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
            d.a(d.this).dismissDropDown();
            d.b(d.this).gGc();
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
  
  public final void jE(List<com.tencent.mm.plugin.recharge.model.a> paramList)
  {
    try
    {
      AppMethodBeat.i(67322);
      this.Nxv = paramList;
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
  
  public static abstract interface a
  {
    public abstract void gFR();
  }
  
  final class b
    extends Filter
  {
    private b() {}
    
    private static int[] le(String paramString1, String paramString2)
    {
      AppMethodBeat.i(67320);
      if (paramString1.equals(paramString2))
      {
        paramString1 = com.tencent.mm.plugin.recharge.model.a.NwE;
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
      paramString1 = com.tencent.mm.plugin.recharge.model.a.NwF;
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
        for (localObject1 = com.tencent.mm.plugin.recharge.model.b.Tu(paramCharSequence.toString()); (((String)localObject1).equals(d.d(d.this))) && (!((String)localObject1).equals("")); localObject1 = "")
        {
          d.a(d.this).post(new d.b.1(this));
          localFilterResults.count = d.this.Nxt.size();
          localFilterResults.values = d.this.Nxt;
          AppMethodBeat.o(67318);
          return localFilterResults;
        }
        d.a(d.this, (String)localObject1);
        if ((d.e(d.this) != null) && (!d.e(d.this).isEmpty()))
        {
          localObject2 = d.e(d.this).iterator();
          while (((Iterator)localObject2).hasNext()) {
            ((com.tencent.mm.plugin.recharge.model.a)((Iterator)localObject2).next()).NwH = com.tencent.mm.plugin.recharge.model.a.NwE;
          }
        }
        if (d.b(d.this).bZp()) {
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
          if (((com.tencent.mm.plugin.recharge.model.a)localObject1).NwG.startsWith(d.d(d.this))) {
            localArrayList.add(localObject1);
          }
        }
      }
      for (;;)
      {
        localFilterResults.count = localArrayList.size();
        localFilterResults.values = localArrayList;
        d.this.Nxu = bool;
        AppMethodBeat.o(67318);
        break;
        localArrayList.addAll(d.e(d.this));
        boolean bool = false;
        continue;
        label373:
        long l = System.currentTimeMillis();
        Log.i(d.TAG, "performFiltering2 ".concat(String.valueOf(paramCharSequence)));
        paramCharSequence = com.tencent.mm.plugin.recharge.a.a.gFG();
        if ((paramCharSequence != null) && (((String)localObject1).equals(paramCharSequence.NwG)))
        {
          AppMethodBeat.o(67318);
          break;
        }
        if ((d.f(d.this) == null) || (d.f(d.this).isEmpty())) {
          d.a(d.this, com.tencent.mm.pluginsdk.b.eI(d.g(d.this)));
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
            String str = com.tencent.mm.plugin.recharge.model.b.Tu(localObject2[2]);
            localObject1 = le(d.d(d.this), str);
            if (com.tencent.mm.plugin.recharge.model.a.NwE.equals(localObject1))
            {
              AppMethodBeat.o(67318);
              break;
            }
            if ((!com.tencent.mm.plugin.recharge.model.a.NwF.equals(localObject1)) && (localArrayList.size() < 4))
            {
              localObject2 = new com.tencent.mm.plugin.recharge.model.a(str, localObject2[1], 1);
              ((com.tencent.mm.plugin.recharge.model.a)localObject2).NwH = ((int[])localObject1);
              localArrayList.add(localObject2);
            }
          }
        }
        label606:
        paramCharSequence = com.tencent.mm.plugin.recharge.a.a.gFE().gFF().iterator();
        for (;;)
        {
          if (!paramCharSequence.hasNext()) {
            break label723;
          }
          localObject1 = (com.tencent.mm.plugin.recharge.model.a)paramCharSequence.next();
          localObject2 = com.tencent.mm.plugin.recharge.model.b.Tu(((com.tencent.mm.plugin.recharge.model.a)localObject1).NwG);
          localObject2 = le(d.d(d.this), (String)localObject2);
          if (com.tencent.mm.plugin.recharge.model.a.NwE.equals(localObject2))
          {
            AppMethodBeat.o(67318);
            break;
          }
          if ((!com.tencent.mm.plugin.recharge.model.a.NwF.equals(localObject2)) && (localArrayList.size() < 4))
          {
            ((com.tencent.mm.plugin.recharge.model.a)localObject1).NwH = ((int[])localObject2);
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
        d.this.Nxt = new ArrayList();
        if (paramFilterResults.count != 0) {
          break label109;
        }
      }
      label109:
      for (d.b(d.this).NzG = true;; d.b(d.this).NzG = false)
      {
        Log.i(d.TAG, "results.count " + paramFilterResults.count);
        if (paramFilterResults.count > 0) {
          d.this.notifyDataSetChanged();
        }
        AppMethodBeat.o(67319);
        return;
        d.this.Nxt = ((List)paramFilterResults.values);
        break;
      }
    }
  }
  
  final class c
  {
    TextView NxB;
    ImageView NzO;
    TextView lDF;
    
    private c() {}
  }
  
  public static abstract interface d {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.recharge.ui.form.d
 * JD-Core Version:    0.7.0.1
 */