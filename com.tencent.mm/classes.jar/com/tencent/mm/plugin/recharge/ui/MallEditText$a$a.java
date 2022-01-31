package com.tencent.mm.plugin.recharge.ui;

import android.widget.AutoCompleteTextView;
import android.widget.Filter;
import android.widget.Filter.FilterResults;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.recharge.model.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

final class MallEditText$a$a
  extends Filter
{
  private MallEditText$a$a(MallEditText.a parama) {}
  
  private static int[] fR(String paramString1, String paramString2)
  {
    AppMethodBeat.i(44218);
    if (paramString1.equals(paramString2))
    {
      paramString1 = com.tencent.mm.plugin.recharge.model.a.pUH;
      AppMethodBeat.o(44218);
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
        AppMethodBeat.o(44218);
        return arrayOfInt;
      }
    }
    paramString1 = com.tencent.mm.plugin.recharge.model.a.pUI;
    AppMethodBeat.o(44218);
    return paramString1;
  }
  
  protected final Filter.FilterResults performFiltering(CharSequence paramCharSequence)
  {
    Filter.FilterResults localFilterResults;
    ArrayList localArrayList;
    Object localObject1;
    try
    {
      AppMethodBeat.i(44217);
      localFilterResults = new Filter.FilterResults();
      localArrayList = new ArrayList();
      if (paramCharSequence != null) {}
      for (localObject1 = b.xw(paramCharSequence.toString()); ((String)localObject1).equals(MallEditText.a.a(this.pVE)); localObject1 = "")
      {
        MallEditText.a(this.pVE.pVy).post(new MallEditText.a.a.1(this));
        AppMethodBeat.o(44217);
        return localFilterResults;
      }
      MallEditText.a.a(this.pVE, (String)localObject1);
      if (this.pVE.pVy.asv()) {
        break label362;
      }
      if (bo.isNullOrNil(MallEditText.a.a(this.pVE))) {
        break label342;
      }
      ab.d("MicroMsg.MallEditText", "performFiltering ".concat(String.valueOf(paramCharSequence)));
      paramCharSequence = MallEditText.a.b(this.pVE).iterator();
      while (paramCharSequence.hasNext())
      {
        localObject1 = (com.tencent.mm.plugin.recharge.model.a)paramCharSequence.next();
        if (((com.tencent.mm.plugin.recharge.model.a)localObject1).pUJ.startsWith(MallEditText.a.a(this.pVE))) {
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
      MallEditText.a(this.pVE.pVy).post(new MallEditText.a.a.2(this));
      bool = false;
    }
    for (;;)
    {
      for (;;)
      {
        paramCharSequence = this.pVE.pVz;
        this.pVE.pVz = localArrayList;
        this.pVE.pVA = bool;
        localFilterResults.count = this.pVE.pVz.size();
        localFilterResults.values = this.pVE.pVz;
        ab.d("MicroMsg.MallEditText", "results.count " + localFilterResults.count);
        paramCharSequence.clear();
        AppMethodBeat.o(44217);
        break;
        label342:
        localArrayList.addAll(MallEditText.a.b(this.pVE));
        bool = false;
        break label215;
        label362:
        long l = System.currentTimeMillis();
        ab.d("MicroMsg.MallEditText", "performFiltering ".concat(String.valueOf(paramCharSequence)));
        paramCharSequence = MallEditText.a.b(this.pVE).iterator();
        while (paramCharSequence.hasNext())
        {
          localObject1 = (com.tencent.mm.plugin.recharge.model.a)paramCharSequence.next();
          if (((com.tencent.mm.plugin.recharge.model.a)localObject1).pUJ.equals(MallEditText.a.a(this.pVE)))
          {
            ((com.tencent.mm.plugin.recharge.model.a)localObject1).pUL = com.tencent.mm.plugin.recharge.model.a.pUH;
            localArrayList.clear();
            localArrayList.add(localObject1);
          }
        }
        if (localArrayList.size() <= 0)
        {
          paramCharSequence = MallEditText.f(this.pVE.pVy);
          if (paramCharSequence != null) {}
        }
        try
        {
          MallEditText.a(this.pVE.pVy, com.tencent.mm.pluginsdk.a.cL(this.pVE.pVy.getContext()));
          if (MallEditText.f(this.pVE.pVy) != null)
          {
            paramCharSequence = MallEditText.f(this.pVE.pVy).iterator();
            if (paramCharSequence.hasNext())
            {
              localObject2 = (String[])paramCharSequence.next();
              str = b.xw(localObject2[2]);
              localObject1 = fR(MallEditText.a.a(this.pVE), str);
              if (!com.tencent.mm.plugin.recharge.model.a.pUH.equals(localObject1)) {
                break label680;
              }
              paramCharSequence = new com.tencent.mm.plugin.recharge.model.a(str, localObject2[1], 1);
              paramCharSequence.pUL = com.tencent.mm.plugin.recharge.model.a.pUH;
              localArrayList.clear();
              localArrayList.add(paramCharSequence);
            }
          }
          ab.d("MicroMsg.MallEditText", " search phone number cost " + (System.currentTimeMillis() - l) + " ms ");
          bool = true;
        }
        catch (Exception paramCharSequence)
        {
          for (;;)
          {
            Object localObject2;
            String str;
            ab.printErrStackTrace("MicroMsg.MallEditText", paramCharSequence, "", new Object[0]);
            continue;
            label680:
            if ((!com.tencent.mm.plugin.recharge.model.a.pUI.equals(localObject1)) && (localArrayList.size() < 5))
            {
              localObject2 = new com.tencent.mm.plugin.recharge.model.a(str, localObject2[1], 1);
              ((com.tencent.mm.plugin.recharge.model.a)localObject2).pUL = ((int[])localObject1);
              localArrayList.add(localObject2);
            }
          }
        }
      }
      if ((localArrayList.size() == 1) && (this.pVE.pVy.asv()))
      {
        paramCharSequence = (com.tencent.mm.plugin.recharge.model.a)localArrayList.get(0);
        if (com.tencent.mm.plugin.recharge.model.a.pUH.equals(paramCharSequence.pUL))
        {
          MallEditText.a(this.pVE.pVy).post(new MallEditText.a.a.3(this, paramCharSequence));
          bool = false;
        }
      }
    }
  }
  
  protected final void publishResults(CharSequence paramCharSequence, Filter.FilterResults paramFilterResults) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.recharge.ui.MallEditText.a.a
 * JD-Core Version:    0.7.0.1
 */