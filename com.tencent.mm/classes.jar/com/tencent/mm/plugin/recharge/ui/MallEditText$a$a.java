package com.tencent.mm.plugin.recharge.ui;

import android.widget.AutoCompleteTextView;
import android.widget.Filter;
import android.widget.Filter.FilterResults;
import com.tencent.mm.plugin.recharge.model.b;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

final class MallEditText$a$a
  extends Filter
{
  private MallEditText$a$a(MallEditText.a parama) {}
  
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
    Filter.FilterResults localFilterResults;
    ArrayList localArrayList;
    Object localObject1;
    try
    {
      localFilterResults = new Filter.FilterResults();
      localArrayList = new ArrayList();
      if (paramCharSequence != null) {}
      for (localObject1 = b.qa(paramCharSequence.toString()); ((String)localObject1).equals(MallEditText.a.a(this.nqq)); localObject1 = "")
      {
        MallEditText.a(this.nqq.nqk).post(new MallEditText.a.a.1(this));
        return localFilterResults;
      }
      MallEditText.a.a(this.nqq, (String)localObject1);
      if (this.nqq.nqk.YL()) {
        break label354;
      }
      if (bk.bl(MallEditText.a.a(this.nqq))) {
        break label334;
      }
      y.d("MicroMsg.MallEditText", "performFiltering " + paramCharSequence);
      paramCharSequence = MallEditText.a.b(this.nqq).iterator();
      while (paramCharSequence.hasNext())
      {
        localObject1 = (com.tencent.mm.plugin.recharge.model.a)paramCharSequence.next();
        if (((com.tencent.mm.plugin.recharge.model.a)localObject1).npv.startsWith(MallEditText.a.a(this.nqq))) {
          localArrayList.add(localObject1);
        }
      }
      bool = false;
    }
    finally {}
    boolean bool;
    label212:
    if (localArrayList.size() == 0)
    {
      MallEditText.a(this.nqq.nqk).post(new MallEditText.a.a.2(this));
      bool = false;
    }
    for (;;)
    {
      for (;;)
      {
        paramCharSequence = this.nqq.nql;
        this.nqq.nql = localArrayList;
        this.nqq.nqm = bool;
        localFilterResults.count = this.nqq.nql.size();
        localFilterResults.values = this.nqq.nql;
        y.d("MicroMsg.MallEditText", "results.count " + localFilterResults.count);
        paramCharSequence.clear();
        break;
        label334:
        localArrayList.addAll(MallEditText.a.b(this.nqq));
        bool = false;
        break label212;
        label354:
        long l = System.currentTimeMillis();
        y.d("MicroMsg.MallEditText", "performFiltering " + paramCharSequence);
        paramCharSequence = MallEditText.a.b(this.nqq).iterator();
        while (paramCharSequence.hasNext())
        {
          localObject1 = (com.tencent.mm.plugin.recharge.model.a)paramCharSequence.next();
          if (((com.tencent.mm.plugin.recharge.model.a)localObject1).npv.equals(MallEditText.a.a(this.nqq)))
          {
            ((com.tencent.mm.plugin.recharge.model.a)localObject1).npx = com.tencent.mm.plugin.recharge.model.a.npt;
            localArrayList.clear();
            localArrayList.add(localObject1);
          }
        }
        if (localArrayList.size() <= 0)
        {
          paramCharSequence = MallEditText.f(this.nqq.nqk);
          if (paramCharSequence != null) {}
        }
        try
        {
          MallEditText.a(this.nqq.nqk, com.tencent.mm.pluginsdk.a.ck(this.nqq.nqk.getContext()));
          if (MallEditText.f(this.nqq.nqk) != null)
          {
            paramCharSequence = MallEditText.f(this.nqq.nqk).iterator();
            if (paramCharSequence.hasNext())
            {
              localObject2 = (String[])paramCharSequence.next();
              str = b.qa(localObject2[2]);
              localObject1 = et(MallEditText.a.a(this.nqq), str);
              if (!com.tencent.mm.plugin.recharge.model.a.npt.equals(localObject1)) {
                break label679;
              }
              paramCharSequence = new com.tencent.mm.plugin.recharge.model.a(str, localObject2[1], 1);
              paramCharSequence.npx = com.tencent.mm.plugin.recharge.model.a.npt;
              localArrayList.clear();
              localArrayList.add(paramCharSequence);
            }
          }
          y.d("MicroMsg.MallEditText", " search phone number cost " + (System.currentTimeMillis() - l) + " ms ");
          bool = true;
        }
        catch (Exception paramCharSequence)
        {
          for (;;)
          {
            Object localObject2;
            String str;
            y.printErrStackTrace("MicroMsg.MallEditText", paramCharSequence, "", new Object[0]);
            continue;
            label679:
            if ((!com.tencent.mm.plugin.recharge.model.a.npu.equals(localObject1)) && (localArrayList.size() < 5))
            {
              localObject2 = new com.tencent.mm.plugin.recharge.model.a(str, localObject2[1], 1);
              ((com.tencent.mm.plugin.recharge.model.a)localObject2).npx = ((int[])localObject1);
              localArrayList.add(localObject2);
            }
          }
        }
      }
      if ((localArrayList.size() == 1) && (this.nqq.nqk.YL()))
      {
        paramCharSequence = (com.tencent.mm.plugin.recharge.model.a)localArrayList.get(0);
        if (com.tencent.mm.plugin.recharge.model.a.npt.equals(paramCharSequence.npx))
        {
          MallEditText.a(this.nqq.nqk).post(new MallEditText.a.a.3(this, paramCharSequence));
          bool = false;
        }
      }
    }
  }
  
  protected final void publishResults(CharSequence paramCharSequence, Filter.FilterResults paramFilterResults) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.recharge.ui.MallEditText.a.a
 * JD-Core Version:    0.7.0.1
 */