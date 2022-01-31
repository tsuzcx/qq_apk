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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.recharge.model.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class d
  extends BaseAdapter
  implements Filterable
{
  private static String TAG = "MicroMsg.MobileHistoryAdapter";
  private Context mContext;
  public boolean pVA;
  private List<com.tencent.mm.plugin.recharge.model.a> pVB;
  private String pVD;
  private AutoCompleteTextView pVq;
  private List<String[]> pVt;
  public List<com.tencent.mm.plugin.recharge.model.a> pVz;
  private b pXQ;
  public d pXR;
  public d.a pXS;
  private MallFormView pXd;
  
  public d(MallFormView paramMallFormView, List<String[]> paramList)
  {
    AppMethodBeat.i(44410);
    this.pVz = new ArrayList();
    this.pVA = false;
    this.pXR = null;
    this.pXS = null;
    this.mContext = paramMallFormView.getContext();
    this.pXd = paramMallFormView;
    this.pVq = ((AutoCompleteTextView)paramMallFormView.getContentEditText());
    this.pVt = paramList;
    AppMethodBeat.o(44410);
  }
  
  public final com.tencent.mm.plugin.recharge.model.a Cg(int paramInt)
  {
    com.tencent.mm.plugin.recharge.model.a locala1 = null;
    for (;;)
    {
      try
      {
        AppMethodBeat.i(44414);
        if (!this.pVA) {
          break label79;
        }
        if (paramInt == 0)
        {
          AppMethodBeat.o(44414);
          return locala1;
        }
        if (paramInt <= this.pVz.size())
        {
          locala1 = (com.tencent.mm.plugin.recharge.model.a)this.pVz.get(paramInt - 1);
          AppMethodBeat.o(44414);
          continue;
        }
        AppMethodBeat.o(44414);
      }
      finally {}
      continue;
      label79:
      if (paramInt < this.pVz.size())
      {
        com.tencent.mm.plugin.recharge.model.a locala2 = (com.tencent.mm.plugin.recharge.model.a)this.pVz.get(paramInt);
        AppMethodBeat.o(44414);
      }
      else
      {
        AppMethodBeat.o(44414);
      }
    }
  }
  
  public final void cH(List<com.tencent.mm.plugin.recharge.model.a> paramList)
  {
    try
    {
      AppMethodBeat.i(44411);
      this.pVB = paramList;
      this.pVz.clear();
      this.pVA = false;
      notifyDataSetChanged();
      AppMethodBeat.o(44411);
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
    AppMethodBeat.i(44413);
    int i;
    if (this.pVA)
    {
      i = this.pVz.size();
      AppMethodBeat.o(44413);
      return i + 2;
    }
    if (this.pVz.size() > 0)
    {
      i = this.pVz.size();
      AppMethodBeat.o(44413);
      return i + 1;
    }
    AppMethodBeat.o(44413);
    return 0;
  }
  
  public final Filter getFilter()
  {
    AppMethodBeat.i(44412);
    ab.d(TAG, "getFilter");
    if (this.pXQ == null) {
      this.pXQ = new b((byte)0);
    }
    b localb = this.pXQ;
    AppMethodBeat.o(44412);
    return localb;
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final int getItemViewType(int paramInt)
  {
    AppMethodBeat.i(44416);
    if (this.pVA)
    {
      if (paramInt == 0)
      {
        AppMethodBeat.o(44416);
        return 2;
      }
      if (paramInt <= this.pVz.size())
      {
        AppMethodBeat.o(44416);
        return 0;
      }
      AppMethodBeat.o(44416);
      return 3;
    }
    if (paramInt < this.pVz.size())
    {
      AppMethodBeat.o(44416);
      return 0;
    }
    AppMethodBeat.o(44416);
    return 1;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(44415);
    switch (getItemViewType(paramInt))
    {
    }
    label147:
    label283:
    label671:
    for (;;)
    {
      AppMethodBeat.o(44415);
      return paramView;
      c localc;
      com.tencent.mm.plugin.recharge.model.a locala;
      int i;
      int j;
      if (paramView == null)
      {
        paramViewGroup = View.inflate(this.mContext, 2130970530, null);
        localc = new c((byte)0);
        localc.pVH = ((TextView)paramViewGroup.findViewById(2131827079));
        localc.gve = ((TextView)paramViewGroup.findViewById(2131827080));
        localc.pXV = ((ImageView)paramViewGroup.findViewById(2131827078));
        paramViewGroup.setTag(localc);
        if ((localc != null) && (localc.pXV != null))
        {
          if (paramInt != 0) {
            break label367;
          }
          localc.pXV.setVisibility(0);
        }
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
        ab.d(TAG, "record.record " + paramView + ", record.name " + locala.name + "，record.location " + locala.pUK);
        if (com.tencent.mm.plugin.recharge.model.a.pUH.equals(locala.pUL)) {
          break label590;
        }
        paramView = new SpannableStringBuilder(paramView);
        int[] arrayOfInt = locala.pUL;
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
        paramView.setSpan(new ForegroundColorSpan(this.mContext.getResources().getColor(2131690385)), paramInt, paramInt + 1, 34);
        i += 1;
        break label283;
        localc = (c)paramView.getTag();
        paramViewGroup = paramView;
        break;
        label367:
        localc.pXV.setVisibility(8);
        break label147;
        label380:
        paramInt = j;
        if (j >= 3) {
          paramInt = j + 1;
        }
      }
      localc.pVH.setTextSize(24.0F);
      localc.pVH.setTextColor(this.mContext.getResources().getColor(2131690322));
      localc.gve.setTextColor(this.mContext.getResources().getColor(2131690322));
      localc.pVH.setText(paramView);
      label459:
      if ((locala.name != null) && (!bo.isNullOrNil(locala.name.trim())))
      {
        if (!bo.isNullOrNil(locala.pUK)) {
          localc.gve.setText(locala.name + this.mContext.getString(2131305563, new Object[] { locala.pUK }));
        }
        for (;;)
        {
          if (!locala.name.equals(this.mContext.getString(2131305571))) {
            break label671;
          }
          localc.gve.setTextColor(this.mContext.getResources().getColor(2131690382));
          paramView = paramViewGroup;
          break;
          label590:
          localc.pVH.setTextSize(16.0F);
          localc.pVH.setTextColor(this.mContext.getResources().getColor(2131690168));
          localc.gve.setTextColor(this.mContext.getResources().getColor(2131690168));
          localc.pVH.setText(paramView);
          break label459;
          localc.gve.setText(locala.name);
        }
        localc.gve.setTextColor(this.mContext.getResources().getColor(2131690318));
        paramView = paramViewGroup;
      }
      else if (!bo.isNullOrNil(locala.pUK))
      {
        localc.gve.setText(this.mContext.getString(2131305573) + this.mContext.getString(2131305563, new Object[] { locala.pUK }));
        paramView = paramViewGroup;
      }
      else
      {
        localc.gve.setText(this.mContext.getString(2131305573));
        paramView = paramViewGroup;
        continue;
        paramView = View.inflate(this.mContext, 2130970529, null);
        paramView.setOnClickListener(new d.1(this));
        continue;
        paramView = View.inflate(this.mContext, 2130970531, null);
        paramView.setOnClickListener(new d.2(this));
        continue;
        paramView = View.inflate(this.mContext, 2130970531, null);
        ((TextView)paramView.findViewById(2131827082)).setText(2131301507);
        paramView.setOnClickListener(new d.3(this));
      }
    }
  }
  
  public final int getViewTypeCount()
  {
    return 4;
  }
  
  final class b
    extends Filter
  {
    private b() {}
    
    private static int[] fR(String paramString1, String paramString2)
    {
      AppMethodBeat.i(44409);
      if (paramString1.equals(paramString2))
      {
        paramString1 = com.tencent.mm.plugin.recharge.model.a.pUH;
        AppMethodBeat.o(44409);
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
          AppMethodBeat.o(44409);
          return arrayOfInt;
        }
      }
      paramString1 = com.tencent.mm.plugin.recharge.model.a.pUI;
      AppMethodBeat.o(44409);
      return paramString1;
    }
    
    protected final Filter.FilterResults performFiltering(CharSequence paramCharSequence)
    {
      Filter.FilterResults localFilterResults;
      ArrayList localArrayList;
      Object localObject1;
      try
      {
        AppMethodBeat.i(44407);
        localFilterResults = new Filter.FilterResults();
        localArrayList = new ArrayList();
        if (paramCharSequence != null) {}
        for (localObject1 = b.xw(paramCharSequence.toString()); (((String)localObject1).equals(d.d(d.this))) && (!((String)localObject1).equals("")); localObject1 = "")
        {
          d.a(d.this).post(new d.b.1(this));
          AppMethodBeat.o(44407);
          return localFilterResults;
        }
        d.a(d.this, (String)localObject1);
        if (d.b(d.this).asv()) {
          break label299;
        }
        if (bo.isNullOrNil(d.d(d.this))) {
          break label279;
        }
        ab.i(d.TAG, "performFiltering1 ".concat(String.valueOf(paramCharSequence)));
        paramCharSequence = d.e(d.this).iterator();
        while (paramCharSequence.hasNext())
        {
          localObject1 = (com.tencent.mm.plugin.recharge.model.a)paramCharSequence.next();
          if (((com.tencent.mm.plugin.recharge.model.a)localObject1).pUJ.startsWith(d.d(d.this))) {
            localArrayList.add(localObject1);
          }
        }
        bool = false;
      }
      finally {}
      boolean bool;
      label223:
      localFilterResults.count = localArrayList.size();
      localFilterResults.values = localArrayList;
      d.this.pVA = bool;
      if (localArrayList.size() == 0) {}
      for (d.b(d.this).pXN = true;; d.b(d.this).pXN = false)
      {
        AppMethodBeat.o(44407);
        break;
        label279:
        localArrayList.addAll(d.e(d.this));
        bool = false;
        break label223;
        label299:
        long l = System.currentTimeMillis();
        ab.i(d.TAG, "performFiltering2 ".concat(String.valueOf(paramCharSequence)));
        paramCharSequence = com.tencent.mm.plugin.recharge.a.a.cfo();
        if ((paramCharSequence != null) && (((String)localObject1).equals(paramCharSequence.pUJ)))
        {
          AppMethodBeat.o(44407);
          break;
        }
        if ((d.f(d.this) == null) || (d.f(d.this).isEmpty())) {
          d.a(d.this, com.tencent.mm.pluginsdk.a.cL(d.g(d.this)));
        }
        Object localObject2;
        if (d.f(d.this) != null)
        {
          paramCharSequence = d.f(d.this).iterator();
          for (;;)
          {
            if (!paramCharSequence.hasNext()) {
              break label532;
            }
            localObject2 = (String[])paramCharSequence.next();
            String str = b.xw(localObject2[2]);
            localObject1 = fR(d.d(d.this), str);
            if (com.tencent.mm.plugin.recharge.model.a.pUH.equals(localObject1))
            {
              AppMethodBeat.o(44407);
              break;
            }
            if ((!com.tencent.mm.plugin.recharge.model.a.pUI.equals(localObject1)) && (localArrayList.size() < 4))
            {
              localObject2 = new com.tencent.mm.plugin.recharge.model.a(str, localObject2[1], 1);
              ((com.tencent.mm.plugin.recharge.model.a)localObject2).pUL = ((int[])localObject1);
              localArrayList.add(localObject2);
            }
          }
        }
        label532:
        paramCharSequence = com.tencent.mm.plugin.recharge.a.a.cfm().cfn().iterator();
        for (;;)
        {
          if (!paramCharSequence.hasNext()) {
            break label649;
          }
          localObject1 = (com.tencent.mm.plugin.recharge.model.a)paramCharSequence.next();
          localObject2 = b.xw(((com.tencent.mm.plugin.recharge.model.a)localObject1).pUJ);
          localObject2 = fR(d.d(d.this), (String)localObject2);
          if (com.tencent.mm.plugin.recharge.model.a.pUH.equals(localObject2))
          {
            AppMethodBeat.o(44407);
            break;
          }
          if ((!com.tencent.mm.plugin.recharge.model.a.pUI.equals(localObject2)) && (localArrayList.size() < 4))
          {
            ((com.tencent.mm.plugin.recharge.model.a)localObject1).pUL = ((int[])localObject2);
            localArrayList.add(localObject1);
          }
        }
        label649:
        ab.d(d.TAG, " search phone number cost " + (System.currentTimeMillis() - l) + " ms ");
        bool = true;
        break label223;
      }
    }
    
    protected final void publishResults(CharSequence paramCharSequence, Filter.FilterResults paramFilterResults)
    {
      AppMethodBeat.i(44408);
      if (paramFilterResults.values == null)
      {
        d.this.pVz = new ArrayList();
        if (paramFilterResults.count != 0) {
          break label109;
        }
      }
      label109:
      for (d.b(d.this).pXN = true;; d.b(d.this).pXN = false)
      {
        ab.i(d.TAG, "results.count " + paramFilterResults.count);
        if (paramFilterResults.count > 0) {
          d.this.notifyDataSetChanged();
        }
        AppMethodBeat.o(44408);
        return;
        d.this.pVz = ((List)paramFilterResults.values);
        break;
      }
    }
  }
  
  final class c
  {
    TextView gve;
    TextView pVH;
    ImageView pXV;
    
    private c() {}
  }
  
  public static abstract interface d {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.recharge.ui.form.d
 * JD-Core Version:    0.7.0.1
 */