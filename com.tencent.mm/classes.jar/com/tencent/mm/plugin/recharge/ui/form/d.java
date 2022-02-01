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
  private AutoCompleteTextView BDD;
  List<String[]> BDG;
  public List<com.tencent.mm.plugin.recharge.model.a> BDM;
  public boolean BDN;
  private List<com.tencent.mm.plugin.recharge.model.a> BDO;
  private String BDQ;
  private MallFormView BFp;
  private b BGc;
  public d BGd;
  public a BGe;
  private Context mContext;
  
  public d(MallFormView paramMallFormView, List<String[]> paramList)
  {
    AppMethodBeat.i(67321);
    this.BDM = new ArrayList();
    this.BDN = false;
    this.BGd = null;
    this.BGe = null;
    this.mContext = paramMallFormView.getContext();
    this.BFp = paramMallFormView;
    this.BDD = ((AutoCompleteTextView)paramMallFormView.getContentEditText());
    this.BDG = paramList;
    AppMethodBeat.o(67321);
  }
  
  public final com.tencent.mm.plugin.recharge.model.a Vp(int paramInt)
  {
    com.tencent.mm.plugin.recharge.model.a locala1 = null;
    for (;;)
    {
      try
      {
        AppMethodBeat.i(67325);
        if (!this.BDN) {
          break label79;
        }
        if (paramInt == 0)
        {
          AppMethodBeat.o(67325);
          return locala1;
        }
        if (paramInt <= this.BDM.size())
        {
          locala1 = (com.tencent.mm.plugin.recharge.model.a)this.BDM.get(paramInt - 1);
          AppMethodBeat.o(67325);
          continue;
        }
        AppMethodBeat.o(67325);
      }
      finally {}
      continue;
      label79:
      if (paramInt < this.BDM.size())
      {
        com.tencent.mm.plugin.recharge.model.a locala2 = (com.tencent.mm.plugin.recharge.model.a)this.BDM.get(paramInt);
        AppMethodBeat.o(67325);
      }
      else
      {
        AppMethodBeat.o(67325);
      }
    }
  }
  
  public final void ga(List<com.tencent.mm.plugin.recharge.model.a> paramList)
  {
    try
    {
      AppMethodBeat.i(67322);
      this.BDO = paramList;
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
    if (this.BDN)
    {
      i = this.BDM.size();
      AppMethodBeat.o(67324);
      return i + 2;
    }
    if (this.BDM.size() > 0)
    {
      i = this.BDM.size();
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
    if (this.BGc == null) {
      this.BGc = new b((byte)0);
    }
    b localb = this.BGc;
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
    if (this.BDN)
    {
      if (paramInt == 0)
      {
        AppMethodBeat.o(67327);
        return 2;
      }
      if (paramInt <= this.BDM.size())
      {
        AppMethodBeat.o(67327);
        return 0;
      }
      AppMethodBeat.o(67327);
      return 3;
    }
    if (paramInt < this.BDM.size())
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
        paramViewGroup = View.inflate(this.mContext, 2131496048, null);
        localc = new c((byte)0);
        localc.BDU = ((TextView)paramViewGroup.findViewById(2131304362));
        localc.gxs = ((TextView)paramViewGroup.findViewById(2131304361));
        localc.BGh = ((ImageView)paramViewGroup.findViewById(2131309313));
        paramViewGroup.setTag(localc);
        if ((localc != null) && (localc.BGh != null))
        {
          if (paramInt != 0) {
            break label367;
          }
          localc.BGh.setVisibility(0);
        }
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
        Log.d(TAG, "record.record " + paramView + ", record.name " + locala.name + "，record.location " + locala.ljO);
        if (com.tencent.mm.plugin.recharge.model.a.BCV.equals(locala.BCY)) {
          break label590;
        }
        paramView = new SpannableStringBuilder(paramView);
        int[] arrayOfInt = locala.BCY;
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
        paramView.setSpan(new ForegroundColorSpan(this.mContext.getResources().getColor(2131100988)), paramInt, paramInt + 1, 34);
        i += 1;
        break label283;
        localc = (c)paramView.getTag();
        paramViewGroup = paramView;
        break;
        label367:
        localc.BGh.setVisibility(8);
        break label147;
        label380:
        paramInt = j;
        if (j >= 3) {
          paramInt = j + 1;
        }
      }
      localc.BDU.setTextSize(24.0F);
      localc.BDU.setTextColor(this.mContext.getResources().getColor(2131100904));
      localc.gxs.setTextColor(this.mContext.getResources().getColor(2131100904));
      localc.BDU.setText(paramView);
      label459:
      if ((locala.name != null) && (!Util.isNullOrNil(locala.name.trim())))
      {
        if (!Util.isNullOrNil(locala.ljO)) {
          localc.gxs.setText(locala.name + this.mContext.getString(2131768232, new Object[] { locala.ljO }));
        }
        for (;;)
        {
          if (!locala.name.equals(this.mContext.getString(2131768240))) {
            break label671;
          }
          localc.gxs.setTextColor(this.mContext.getResources().getColor(2131100985));
          paramView = paramViewGroup;
          break;
          label590:
          localc.BDU.setTextSize(16.0F);
          localc.BDU.setTextColor(this.mContext.getResources().getColor(2131100594));
          localc.gxs.setTextColor(this.mContext.getResources().getColor(2131100594));
          localc.BDU.setText(paramView);
          break label459;
          localc.gxs.setText(locala.name);
        }
        localc.gxs.setTextColor(this.mContext.getResources().getColor(2131100900));
        paramView = paramViewGroup;
      }
      else if (!Util.isNullOrNil(locala.ljO))
      {
        localc.gxs.setText(this.mContext.getString(2131768242) + this.mContext.getString(2131768232, new Object[] { locala.ljO }));
        paramView = paramViewGroup;
      }
      else
      {
        localc.gxs.setText(this.mContext.getString(2131768242));
        paramView = paramViewGroup;
        continue;
        paramView = View.inflate(this.mContext, 2131496047, null);
        paramView.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(67314);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bm(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/recharge/ui/form/MobileHistoryAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
            d.a(d.this).dismissDropDown();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/recharge/ui/form/MobileHistoryAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(67314);
          }
        });
        continue;
        paramView = View.inflate(this.mContext, 2131496049, null);
        paramView.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(67315);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bm(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/recharge/ui/form/MobileHistoryAdapter$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
            com.tencent.mm.plugin.recharge.a.a.eHL().ga(null);
            d.b(d.this).eIj();
            d.this.ga(new LinkedList());
            if (d.c(d.this) != null) {
              d.c(d.this).eHY();
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/recharge/ui/form/MobileHistoryAdapter$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(67315);
          }
        });
        continue;
        paramView = View.inflate(this.mContext, 2131496049, null);
        ((TextView)paramView.findViewById(2131306642)).setText(2131762941);
        paramView.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(67316);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bm(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/recharge/ui/form/MobileHistoryAdapter$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
            d.a(d.this).dismissDropDown();
            d.b(d.this).eIi();
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
    public abstract void eHY();
  }
  
  final class b
    extends Filter
  {
    private b() {}
    
    private static int[] jy(String paramString1, String paramString2)
    {
      AppMethodBeat.i(67320);
      if (paramString1.equals(paramString2))
      {
        paramString1 = com.tencent.mm.plugin.recharge.model.a.BCV;
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
      paramString1 = com.tencent.mm.plugin.recharge.model.a.BCW;
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
        for (localObject1 = com.tencent.mm.plugin.recharge.model.b.Ts(paramCharSequence.toString()); (((String)localObject1).equals(d.d(d.this))) && (!((String)localObject1).equals("")); localObject1 = "")
        {
          d.a(d.this).post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(67317);
              AppMethodBeat.o(67317);
            }
          });
          localFilterResults.count = d.this.BDM.size();
          localFilterResults.values = d.this.BDM;
          AppMethodBeat.o(67318);
          return localFilterResults;
        }
        d.a(d.this, (String)localObject1);
        if ((d.e(d.this) != null) && (!d.e(d.this).isEmpty()))
        {
          localObject2 = d.e(d.this).iterator();
          while (((Iterator)localObject2).hasNext()) {
            ((com.tencent.mm.plugin.recharge.model.a)((Iterator)localObject2).next()).BCY = com.tencent.mm.plugin.recharge.model.a.BCV;
          }
        }
        if (d.b(d.this).bql()) {
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
          if (((com.tencent.mm.plugin.recharge.model.a)localObject1).BCX.startsWith(d.d(d.this))) {
            localArrayList.add(localObject1);
          }
        }
      }
      for (;;)
      {
        localFilterResults.count = localArrayList.size();
        localFilterResults.values = localArrayList;
        d.this.BDN = bool;
        AppMethodBeat.o(67318);
        break;
        localArrayList.addAll(d.e(d.this));
        boolean bool = false;
        continue;
        label373:
        long l = System.currentTimeMillis();
        Log.i(d.TAG, "performFiltering2 ".concat(String.valueOf(paramCharSequence)));
        paramCharSequence = com.tencent.mm.plugin.recharge.a.a.eHN();
        if ((paramCharSequence != null) && (((String)localObject1).equals(paramCharSequence.BCX)))
        {
          AppMethodBeat.o(67318);
          break;
        }
        if ((d.f(d.this) == null) || (d.f(d.this).isEmpty())) {
          d.a(d.this, com.tencent.mm.pluginsdk.b.dO(d.g(d.this)));
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
            String str = com.tencent.mm.plugin.recharge.model.b.Ts(localObject2[2]);
            localObject1 = jy(d.d(d.this), str);
            if (com.tencent.mm.plugin.recharge.model.a.BCV.equals(localObject1))
            {
              AppMethodBeat.o(67318);
              break;
            }
            if ((!com.tencent.mm.plugin.recharge.model.a.BCW.equals(localObject1)) && (localArrayList.size() < 4))
            {
              localObject2 = new com.tencent.mm.plugin.recharge.model.a(str, localObject2[1], 1);
              ((com.tencent.mm.plugin.recharge.model.a)localObject2).BCY = ((int[])localObject1);
              localArrayList.add(localObject2);
            }
          }
        }
        label606:
        paramCharSequence = com.tencent.mm.plugin.recharge.a.a.eHL().eHM().iterator();
        for (;;)
        {
          if (!paramCharSequence.hasNext()) {
            break label723;
          }
          localObject1 = (com.tencent.mm.plugin.recharge.model.a)paramCharSequence.next();
          localObject2 = com.tencent.mm.plugin.recharge.model.b.Ts(((com.tencent.mm.plugin.recharge.model.a)localObject1).BCX);
          localObject2 = jy(d.d(d.this), (String)localObject2);
          if (com.tencent.mm.plugin.recharge.model.a.BCV.equals(localObject2))
          {
            AppMethodBeat.o(67318);
            break;
          }
          if ((!com.tencent.mm.plugin.recharge.model.a.BCW.equals(localObject2)) && (localArrayList.size() < 4))
          {
            ((com.tencent.mm.plugin.recharge.model.a)localObject1).BCY = ((int[])localObject2);
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
        d.this.BDM = new ArrayList();
        if (paramFilterResults.count != 0) {
          break label109;
        }
      }
      label109:
      for (d.b(d.this).BFZ = true;; d.b(d.this).BFZ = false)
      {
        Log.i(d.TAG, "results.count " + paramFilterResults.count);
        if (paramFilterResults.count > 0) {
          d.this.notifyDataSetChanged();
        }
        AppMethodBeat.o(67319);
        return;
        d.this.BDM = ((List)paramFilterResults.values);
        break;
      }
    }
  }
  
  final class c
  {
    TextView BDU;
    ImageView BGh;
    TextView gxs;
    
    private c() {}
  }
  
  public static abstract interface d {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.recharge.ui.form.d
 * JD-Core Version:    0.7.0.1
 */