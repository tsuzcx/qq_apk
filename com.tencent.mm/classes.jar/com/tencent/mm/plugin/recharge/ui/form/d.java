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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class d
  extends BaseAdapter
  implements Filterable
{
  private static String TAG = "MicroMsg.MobileHistoryAdapter";
  private Context mContext;
  private AutoCompleteTextView xnH;
  List<String[]> xnK;
  public List<com.tencent.mm.plugin.recharge.model.a> xnQ;
  public boolean xnR;
  private List<com.tencent.mm.plugin.recharge.model.a> xnS;
  private String xnU;
  private MallFormView xpu;
  private b xqg;
  public d xqh;
  public a xqi;
  
  public d(MallFormView paramMallFormView, List<String[]> paramList)
  {
    AppMethodBeat.i(67321);
    this.xnQ = new ArrayList();
    this.xnR = false;
    this.xqh = null;
    this.xqi = null;
    this.mContext = paramMallFormView.getContext();
    this.xpu = paramMallFormView;
    this.xnH = ((AutoCompleteTextView)paramMallFormView.getContentEditText());
    this.xnK = paramList;
    AppMethodBeat.o(67321);
  }
  
  public final com.tencent.mm.plugin.recharge.model.a Nu(int paramInt)
  {
    com.tencent.mm.plugin.recharge.model.a locala1 = null;
    for (;;)
    {
      try
      {
        AppMethodBeat.i(67325);
        if (!this.xnR) {
          break label79;
        }
        if (paramInt == 0)
        {
          AppMethodBeat.o(67325);
          return locala1;
        }
        if (paramInt <= this.xnQ.size())
        {
          locala1 = (com.tencent.mm.plugin.recharge.model.a)this.xnQ.get(paramInt - 1);
          AppMethodBeat.o(67325);
          continue;
        }
        AppMethodBeat.o(67325);
      }
      finally {}
      continue;
      label79:
      if (paramInt < this.xnQ.size())
      {
        com.tencent.mm.plugin.recharge.model.a locala2 = (com.tencent.mm.plugin.recharge.model.a)this.xnQ.get(paramInt);
        AppMethodBeat.o(67325);
      }
      else
      {
        AppMethodBeat.o(67325);
      }
    }
  }
  
  public final void eW(List<com.tencent.mm.plugin.recharge.model.a> paramList)
  {
    try
    {
      AppMethodBeat.i(67322);
      this.xnS = paramList;
      this.xnQ.clear();
      this.xnR = false;
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
    if (this.xnR)
    {
      i = this.xnQ.size();
      AppMethodBeat.o(67324);
      return i + 2;
    }
    if (this.xnQ.size() > 0)
    {
      i = this.xnQ.size();
      AppMethodBeat.o(67324);
      return i + 1;
    }
    AppMethodBeat.o(67324);
    return 0;
  }
  
  public final Filter getFilter()
  {
    AppMethodBeat.i(67323);
    ad.d(TAG, "getFilter");
    if (this.xqg == null) {
      this.xqg = new b((byte)0);
    }
    b localb = this.xqg;
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
    if (this.xnR)
    {
      if (paramInt == 0)
      {
        AppMethodBeat.o(67327);
        return 2;
      }
      if (paramInt <= this.xnQ.size())
      {
        AppMethodBeat.o(67327);
        return 0;
      }
      AppMethodBeat.o(67327);
      return 3;
    }
    if (paramInt < this.xnQ.size())
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
    label147:
    label283:
    label671:
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
        paramViewGroup = View.inflate(this.mContext, 2131495205, null);
        localc = new c((byte)0);
        localc.xnY = ((TextView)paramViewGroup.findViewById(2131302023));
        localc.fQd = ((TextView)paramViewGroup.findViewById(2131302022));
        localc.xql = ((ImageView)paramViewGroup.findViewById(2131306004));
        paramViewGroup.setTag(localc);
        if ((localc != null) && (localc.xql != null))
        {
          if (paramInt != 0) {
            break label367;
          }
          localc.xql.setVisibility(0);
        }
        locala = Nu(paramInt);
        paramView = paramViewGroup;
        if (locala == null) {
          continue;
        }
        paramView = paramViewGroup;
        if (localc == null) {
          continue;
        }
        paramView = paramViewGroup;
        if (localc.xnY == null) {
          continue;
        }
        paramView = paramViewGroup;
        if (localc.fQd == null) {
          continue;
        }
        paramView = com.tencent.mm.plugin.recharge.model.b.avk(locala.xnb);
        ad.d(TAG, "record.record " + paramView + ", record.name " + locala.name + "，record.location " + locala.kcO);
        if (com.tencent.mm.plugin.recharge.model.a.xmZ.equals(locala.xnc)) {
          break label590;
        }
        paramView = new SpannableStringBuilder(paramView);
        int[] arrayOfInt = locala.xnc;
        int k = arrayOfInt.length;
        i = 0;
        if (i >= k) {
          break label397;
        }
        j = arrayOfInt[i];
        if (j >= 0)
        {
          if (j < 7) {
            break label380;
          }
          paramInt = j + 2;
        }
      }
      for (;;)
      {
        paramView.setSpan(new ForegroundColorSpan(this.mContext.getResources().getColor(2131100792)), paramInt, paramInt + 1, 34);
        i += 1;
        break label283;
        localc = (c)paramView.getTag();
        paramViewGroup = paramView;
        break;
        label367:
        localc.xql.setVisibility(8);
        break label147;
        label380:
        paramInt = j;
        if (j >= 3) {
          paramInt = j + 1;
        }
      }
      localc.xnY.setTextSize(24.0F);
      localc.xnY.setTextColor(this.mContext.getResources().getColor(2131100711));
      localc.fQd.setTextColor(this.mContext.getResources().getColor(2131100711));
      localc.xnY.setText(paramView);
      label459:
      if ((locala.name != null) && (!bt.isNullOrNil(locala.name.trim())))
      {
        if (!bt.isNullOrNil(locala.kcO)) {
          localc.fQd.setText(locala.name + this.mContext.getString(2131765779, new Object[] { locala.kcO }));
        }
        for (;;)
        {
          if (!locala.name.equals(this.mContext.getString(2131765787))) {
            break label671;
          }
          localc.fQd.setTextColor(this.mContext.getResources().getColor(2131100789));
          paramView = paramViewGroup;
          break;
          label590:
          localc.xnY.setTextSize(16.0F);
          localc.xnY.setTextColor(this.mContext.getResources().getColor(2131100490));
          localc.fQd.setTextColor(this.mContext.getResources().getColor(2131100490));
          localc.xnY.setText(paramView);
          break label459;
          localc.fQd.setText(locala.name);
        }
        localc.fQd.setTextColor(this.mContext.getResources().getColor(2131100707));
        paramView = paramViewGroup;
      }
      else if (!bt.isNullOrNil(locala.kcO))
      {
        localc.fQd.setText(this.mContext.getString(2131765789) + this.mContext.getString(2131765779, new Object[] { locala.kcO }));
        paramView = paramViewGroup;
      }
      else
      {
        localc.fQd.setText(this.mContext.getString(2131765789));
        paramView = paramViewGroup;
        continue;
        paramView = View.inflate(this.mContext, 2131495204, null);
        paramView.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(67314);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/recharge/ui/form/MobileHistoryAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
            d.a(d.this).dismissDropDown();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/recharge/ui/form/MobileHistoryAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(67314);
          }
        });
        continue;
        paramView = View.inflate(this.mContext, 2131495206, null);
        paramView.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(67315);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/recharge/ui/form/MobileHistoryAdapter$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
            com.tencent.mm.plugin.recharge.a.a.dDG().eW(null);
            d.b(d.this).dEe();
            d.this.eW(new LinkedList());
            if (d.c(d.this) != null) {
              d.c(d.this).dDT();
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/recharge/ui/form/MobileHistoryAdapter$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(67315);
          }
        });
        continue;
        paramView = View.inflate(this.mContext, 2131495206, null);
        ((TextView)paramView.findViewById(2131303835)).setText(2131761154);
        paramView.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(67316);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/recharge/ui/form/MobileHistoryAdapter$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
            d.a(d.this).dismissDropDown();
            d.b(d.this).dEd();
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
    public abstract void dDT();
  }
  
  final class b
    extends Filter
  {
    private b() {}
    
    private static int[] iF(String paramString1, String paramString2)
    {
      AppMethodBeat.i(67320);
      if (paramString1.equals(paramString2))
      {
        paramString1 = com.tencent.mm.plugin.recharge.model.a.xmZ;
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
      paramString1 = com.tencent.mm.plugin.recharge.model.a.xna;
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
        for (localObject1 = com.tencent.mm.plugin.recharge.model.b.JV(paramCharSequence.toString()); (((String)localObject1).equals(d.d(d.this))) && (!((String)localObject1).equals("")); localObject1 = "")
        {
          d.a(d.this).post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(67317);
              AppMethodBeat.o(67317);
            }
          });
          localFilterResults.count = d.this.xnQ.size();
          localFilterResults.values = d.this.xnQ;
          AppMethodBeat.o(67318);
          return localFilterResults;
        }
        d.a(d.this, (String)localObject1);
        if ((d.e(d.this) != null) && (!d.e(d.this).isEmpty()))
        {
          localObject2 = d.e(d.this).iterator();
          while (((Iterator)localObject2).hasNext()) {
            ((com.tencent.mm.plugin.recharge.model.a)((Iterator)localObject2).next()).xnc = com.tencent.mm.plugin.recharge.model.a.xmZ;
          }
        }
        if (d.b(d.this).aVa()) {
          break label394;
        }
      }
      finally {}
      if (!bt.isNullOrNil(d.d(d.this)))
      {
        ad.i(d.TAG, "performFiltering1 ".concat(String.valueOf(paramCharSequence)));
        paramCharSequence = d.e(d.this).iterator();
        while (paramCharSequence.hasNext())
        {
          localObject1 = (com.tencent.mm.plugin.recharge.model.a)paramCharSequence.next();
          if (((com.tencent.mm.plugin.recharge.model.a)localObject1).xnb.startsWith(d.d(d.this))) {
            localArrayList.add(localObject1);
          }
        }
      }
      for (;;)
      {
        label318:
        localFilterResults.count = localArrayList.size();
        localFilterResults.values = localArrayList;
        d.this.xnR = bool;
        if (localArrayList.size() == 0) {}
        for (d.b(d.this).xqd = true;; d.b(d.this).xqd = false)
        {
          AppMethodBeat.o(67318);
          break;
          localArrayList.addAll(d.e(d.this));
          bool = false;
          break label318;
          label394:
          long l = System.currentTimeMillis();
          ad.i(d.TAG, "performFiltering2 ".concat(String.valueOf(paramCharSequence)));
          paramCharSequence = com.tencent.mm.plugin.recharge.a.a.dDI();
          if ((paramCharSequence != null) && (((String)localObject1).equals(paramCharSequence.xnb)))
          {
            AppMethodBeat.o(67318);
            break;
          }
          if ((d.f(d.this) == null) || (d.f(d.this).isEmpty())) {
            d.a(d.this, com.tencent.mm.pluginsdk.b.dr(d.g(d.this)));
          }
          if (d.f(d.this) != null)
          {
            paramCharSequence = d.f(d.this).iterator();
            for (;;)
            {
              if (!paramCharSequence.hasNext()) {
                break label627;
              }
              localObject2 = (String[])paramCharSequence.next();
              String str = com.tencent.mm.plugin.recharge.model.b.JV(localObject2[2]);
              localObject1 = iF(d.d(d.this), str);
              if (com.tencent.mm.plugin.recharge.model.a.xmZ.equals(localObject1))
              {
                AppMethodBeat.o(67318);
                break;
              }
              if ((!com.tencent.mm.plugin.recharge.model.a.xna.equals(localObject1)) && (localArrayList.size() < 4))
              {
                localObject2 = new com.tencent.mm.plugin.recharge.model.a(str, localObject2[1], 1);
                ((com.tencent.mm.plugin.recharge.model.a)localObject2).xnc = ((int[])localObject1);
                localArrayList.add(localObject2);
              }
            }
          }
          label627:
          paramCharSequence = com.tencent.mm.plugin.recharge.a.a.dDG().dDH().iterator();
          for (;;)
          {
            if (!paramCharSequence.hasNext()) {
              break label744;
            }
            localObject1 = (com.tencent.mm.plugin.recharge.model.a)paramCharSequence.next();
            localObject2 = com.tencent.mm.plugin.recharge.model.b.JV(((com.tencent.mm.plugin.recharge.model.a)localObject1).xnb);
            localObject2 = iF(d.d(d.this), (String)localObject2);
            if (com.tencent.mm.plugin.recharge.model.a.xmZ.equals(localObject2))
            {
              AppMethodBeat.o(67318);
              break;
            }
            if ((!com.tencent.mm.plugin.recharge.model.a.xna.equals(localObject2)) && (localArrayList.size() < 4))
            {
              ((com.tencent.mm.plugin.recharge.model.a)localObject1).xnc = ((int[])localObject2);
              localArrayList.add(localObject1);
            }
          }
          label744:
          ad.d(d.TAG, " search phone number cost " + (System.currentTimeMillis() - l) + " ms ");
          bool = true;
          break label318;
        }
        boolean bool = false;
      }
    }
    
    protected final void publishResults(CharSequence paramCharSequence, Filter.FilterResults paramFilterResults)
    {
      AppMethodBeat.i(67319);
      if (paramFilterResults.values == null)
      {
        d.this.xnQ = new ArrayList();
        if (paramFilterResults.count != 0) {
          break label109;
        }
      }
      label109:
      for (d.b(d.this).xqd = true;; d.b(d.this).xqd = false)
      {
        ad.i(d.TAG, "results.count " + paramFilterResults.count);
        if (paramFilterResults.count > 0) {
          d.this.notifyDataSetChanged();
        }
        AppMethodBeat.o(67319);
        return;
        d.this.xnQ = ((List)paramFilterResults.values);
        break;
      }
    }
  }
  
  final class c
  {
    TextView fQd;
    TextView xnY;
    ImageView xql;
    
    private c() {}
  }
  
  public static abstract interface d {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.recharge.ui.form.d
 * JD-Core Version:    0.7.0.1
 */