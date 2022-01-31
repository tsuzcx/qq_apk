package com.tencent.mm.ui.conversation.a;

import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.at.g;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.sdk.platformtools.ab;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

final class m$c
  implements Runnable
{
  WeakReference<m> AmU;
  List<s> And;
  List<s> Ane;
  
  private static int a(String paramString, m paramm, List<s> paramList, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(34692);
    Iterator localIterator = paramList.iterator();
    s locals;
    label192:
    m.b localb;
    for (;;)
    {
      if (localIterator.hasNext())
      {
        locals = (s)localIterator.next();
        paramm.AmS.put(locals.getFileName(), Long.valueOf(locals.fVM));
        if (paramm.AmT.containsKey(Long.valueOf(locals.fVM)))
        {
          ab.d("MicroMsg.MassSightBanner", "%s: has contains massSendId %d, file %s", new Object[] { paramString, Long.valueOf(locals.fVM), locals.getFileName() });
        }
        else if (paramInt1 < paramInt2)
        {
          paramList = paramm.mContainer;
          int i = paramInt1 + 1;
          paramList = paramList.getChildAt(paramInt1);
          ab.d("MicroMsg.MassSightBanner", "%s: refresh view(%d/%d, hashCode %d) with massSendId %d", new Object[] { paramString, Integer.valueOf(i), Integer.valueOf(paramInt2), Integer.valueOf(paramList.hashCode()), Long.valueOf(locals.fVM) });
          paramInt1 = i;
          localb = (m.b)paramList.getTag();
          if (localb != null) {
            break label702;
          }
          localb = new m.b((byte)0);
        }
      }
    }
    label436:
    label702:
    for (;;)
    {
      String str1;
      if (localb.AmV != locals.fVM)
      {
        ab.d("MicroMsg.MassSightBanner", "ashutest::mass send id not match! %d -> %d, totalCount %d", new Object[] { Long.valueOf(localb.AmV), Long.valueOf(locals.fVM), Integer.valueOf(paramInt3) });
        localb.AmV = locals.fVM;
        localb.AmX = paramList;
        localb.AmY = ((com.tencent.mm.plugin.sight.decode.a.a)paramList.findViewById(2131826112));
        localb.AmZ = ((ImageView)paramList.findViewById(2131826113));
        localb.gJE = ((ProgressBar)paramList.findViewById(2131821404));
        localb.Anb = ((ImageButton)paramList.findViewById(2131822887));
        localb.Ana = ((TextView)paramList.findViewById(2131824340));
        localb.AmY.setDrawableWidth(paramList.getResources().getDimensionPixelSize(2131427800));
        localb.AmX.setTag(localb);
        localb.Anb.setTag(Long.valueOf(localb.AmV));
        localb.AmX.setOnClickListener(new m.b.1(localb));
        localb.Anb.setOnClickListener(new m.b.2(localb));
        com.tencent.mm.modelvideo.o.alE();
        str1 = t.vf(locals.getFileName());
        com.tencent.mm.modelvideo.o.alE();
        String str2 = t.vg(locals.getFileName());
        paramList = com.tencent.mm.at.o.ahC().a(str2, com.tencent.mm.cb.a.getDensity(paramList.getContext()), paramList.getContext());
        localb.AmY.setThumbBmp(paramList);
        if (paramInt3 <= 3) {
          break label669;
        }
        localb.AmY.clear();
        localb.AmZ.setVisibility(0);
      }
      for (;;)
      {
        a(localb, locals);
        paramm.AmT.put(Long.valueOf(locals.fVM), localb);
        break;
        paramList = LayoutInflater.from(paramm.mContainer.getContext()).inflate(2130970128, paramm.mContainer, false);
        paramm.mContainer.addView(paramList);
        ab.d("MicroMsg.MassSightBanner", "%s: new view(%d/%d, hashCode %d) with massSendId %d", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramList.hashCode()), Long.valueOf(locals.fVM) });
        break label192;
        ab.d("MicroMsg.MassSightBanner", "ashutest::mass send id match! %d, totalCount %d", new Object[] { Long.valueOf(localb.AmV), Integer.valueOf(paramInt3) });
        break label436;
        localb.AmY.bl(str1, false);
        localb.AmZ.setVisibility(8);
      }
      AppMethodBeat.o(34692);
      return paramInt1;
    }
  }
  
  public static void a(m.b paramb, s params)
  {
    boolean bool = true;
    AppMethodBeat.i(34693);
    ab.v("MicroMsg.MassSightBanner", "info status %d", new Object[] { Integer.valueOf(params.status) });
    if ((params.status == 198) || (params.status == 197) || (params.status == 196))
    {
      paramb.gJE.setVisibility(4);
      paramb.Ana.setVisibility(0);
      paramb.Anb.setEnabled(true);
      paramb.AmW = true;
      AppMethodBeat.o(34693);
      return;
    }
    float f = params.fWa / params.fsd;
    paramb.gJE.setVisibility(0);
    paramb.Ana.setVisibility(4);
    paramb.gJE.setProgress((int)(paramb.gJE.getMax() * f));
    params = paramb.Anb;
    if (Float.compare(0.99F, f) > 0) {}
    for (;;)
    {
      params.setEnabled(bool);
      paramb.AmW = false;
      AppMethodBeat.o(34693);
      return;
      bool = false;
    }
  }
  
  public final void run()
  {
    AppMethodBeat.i(34694);
    m localm = (m)this.AmU.get();
    if (localm == null)
    {
      ab.w("MicroMsg.MassSightBanner", "try to refresh, but banner ref is null");
      AppMethodBeat.o(34694);
      return;
    }
    int k = localm.mContainer.getChildCount();
    localm.AmT.clear();
    HashSet localHashSet = new HashSet();
    Iterator localIterator = this.And.iterator();
    while (localIterator.hasNext()) {
      localHashSet.add(Long.valueOf(((s)localIterator.next()).fVM));
    }
    localIterator = this.Ane.iterator();
    while (localIterator.hasNext()) {
      localHashSet.add(Long.valueOf(((s)localIterator.next()).fVM));
    }
    int i = localHashSet.size();
    int j = a("update unfinish", localm, this.And, 0, k, i);
    j = a("update fail", localm, this.Ane, j, k, i);
    i = j;
    while (i < k)
    {
      localm.mContainer.removeViewAt(j);
      i += 1;
    }
    AppMethodBeat.o(34694);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.a.m.c
 * JD-Core Version:    0.7.0.1
 */