package com.tencent.mm.ui.conversation.a;

import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mm.R.f;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.as.g;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.sdk.platformtools.y;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

final class l$c
  implements Runnable
{
  WeakReference<l> vUS;
  List<s> vVb;
  List<s> vVc;
  
  private static int a(String paramString, l paraml, List<s> paramList, int paramInt1, int paramInt2, int paramInt3)
  {
    Iterator localIterator = paramList.iterator();
    s locals;
    label187:
    l.b localb;
    for (;;)
    {
      if (localIterator.hasNext())
      {
        locals = (s)localIterator.next();
        paraml.vUQ.put(locals.getFileName(), Long.valueOf(locals.eFV));
        if (paraml.vUR.containsKey(Long.valueOf(locals.eFV)))
        {
          y.d("MicroMsg.MassSightBanner", "%s: has contains massSendId %d, file %s", new Object[] { paramString, Long.valueOf(locals.eFV), locals.getFileName() });
        }
        else if (paramInt1 < paramInt2)
        {
          paramList = paraml.mContainer;
          int i = paramInt1 + 1;
          paramList = paramList.getChildAt(paramInt1);
          y.d("MicroMsg.MassSightBanner", "%s: refresh view(%d/%d, hashCode %d) with massSendId %d", new Object[] { paramString, Integer.valueOf(i), Integer.valueOf(paramInt2), Integer.valueOf(paramList.hashCode()), Long.valueOf(locals.eFV) });
          paramInt1 = i;
          localb = (l.b)paramList.getTag();
          if (localb != null) {
            break label698;
          }
          localb = new l.b((byte)0);
        }
      }
    }
    label437:
    label698:
    for (;;)
    {
      String str1;
      if (localb.vUT != locals.eFV)
      {
        y.d("MicroMsg.MassSightBanner", "ashutest::mass send id not match! %d -> %d, totalCount %d", new Object[] { Long.valueOf(localb.vUT), Long.valueOf(locals.eFV), Integer.valueOf(paramInt3) });
        localb.vUT = locals.eFV;
        localb.vUV = paramList;
        localb.vUW = ((com.tencent.mm.plugin.sight.decode.a.a)paramList.findViewById(R.h.image_view));
        localb.vUX = ((ImageView)paramList.findViewById(R.h.status_iv));
        localb.fsc = ((ProgressBar)paramList.findViewById(R.h.progress));
        localb.vUZ = ((ImageButton)paramList.findViewById(R.h.cancel_btn));
        localb.vUY = ((TextView)paramList.findViewById(R.h.info_tv));
        localb.vUW.setDrawableWidth(paramList.getResources().getDimensionPixelSize(R.f.NormalAvatarSize));
        localb.vUV.setTag(localb);
        localb.vUZ.setTag(Long.valueOf(localb.vUT));
        localb.vUV.setOnClickListener(new l.b.1(localb));
        localb.vUZ.setOnClickListener(new l.b.2(localb));
        com.tencent.mm.modelvideo.o.Sr();
        str1 = t.nS(locals.getFileName());
        com.tencent.mm.modelvideo.o.Sr();
        String str2 = t.nT(locals.getFileName());
        paramList = com.tencent.mm.as.o.OJ().a(str2, com.tencent.mm.cb.a.getDensity(paramList.getContext()), paramList.getContext());
        localb.vUW.setThumbBmp(paramList);
        if (paramInt3 <= 3) {
          break label670;
        }
        localb.vUW.clear();
        localb.vUX.setVisibility(0);
      }
      for (;;)
      {
        a(localb, locals);
        paraml.vUR.put(Long.valueOf(locals.eFV), localb);
        break;
        paramList = LayoutInflater.from(paraml.mContainer.getContext()).inflate(R.i.mass_send_sight_banner_view, paraml.mContainer, false);
        paraml.mContainer.addView(paramList);
        y.d("MicroMsg.MassSightBanner", "%s: new view(%d/%d, hashCode %d) with massSendId %d", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramList.hashCode()), Long.valueOf(locals.eFV) });
        break label187;
        y.d("MicroMsg.MassSightBanner", "ashutest::mass send id match! %d, totalCount %d", new Object[] { Long.valueOf(localb.vUT), Integer.valueOf(paramInt3) });
        break label437;
        localb.vUW.aW(str1, false);
        localb.vUX.setVisibility(8);
      }
      return paramInt1;
    }
  }
  
  public static void a(l.b paramb, s params)
  {
    boolean bool = true;
    y.v("MicroMsg.MassSightBanner", "info status %d", new Object[] { Integer.valueOf(params.status) });
    if ((params.status == 198) || (params.status == 197) || (params.status == 196))
    {
      paramb.fsc.setVisibility(4);
      paramb.vUY.setVisibility(0);
      paramb.vUZ.setEnabled(true);
      paramb.vUU = true;
      return;
    }
    float f = params.eGk / params.ebK;
    paramb.fsc.setVisibility(0);
    paramb.vUY.setVisibility(4);
    paramb.fsc.setProgress((int)(paramb.fsc.getMax() * f));
    params = paramb.vUZ;
    if (Float.compare(0.99F, f) > 0) {}
    for (;;)
    {
      params.setEnabled(bool);
      paramb.vUU = false;
      return;
      bool = false;
    }
  }
  
  public final void run()
  {
    l locall = (l)this.vUS.get();
    if (locall == null) {
      y.w("MicroMsg.MassSightBanner", "try to refresh, but banner ref is null");
    }
    for (;;)
    {
      return;
      int k = locall.mContainer.getChildCount();
      locall.vUR.clear();
      HashSet localHashSet = new HashSet();
      Iterator localIterator = this.vVb.iterator();
      while (localIterator.hasNext()) {
        localHashSet.add(Long.valueOf(((s)localIterator.next()).eFV));
      }
      localIterator = this.vVc.iterator();
      while (localIterator.hasNext()) {
        localHashSet.add(Long.valueOf(((s)localIterator.next()).eFV));
      }
      int i = localHashSet.size();
      int j = a("update unfinish", locall, this.vVb, 0, k, i);
      j = a("update fail", locall, this.vVc, j, k, i);
      i = j;
      while (i < k)
      {
        locall.mContainer.removeViewAt(j);
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.a.l.c
 * JD-Core Version:    0.7.0.1
 */