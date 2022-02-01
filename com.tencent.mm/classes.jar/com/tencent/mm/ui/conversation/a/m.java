package com.tencent.mm.ui.conversation.a;

import android.content.Context;
import android.content.res.Resources;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.az;
import com.tencent.mm.modelvideo.m.5;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.modelvideo.t.a;
import com.tencent.mm.modelvideo.t.a.a;
import com.tencent.mm.modelvideo.u;
import com.tencent.mm.pluginsdk.ui.b.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class m
  extends b
  implements t.a
{
  Map<String, Long> IHw;
  Map<Long, b> IHx;
  ViewGroup mContainer;
  
  public m(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(38821);
    this.IHw = new HashMap();
    this.IHx = new HashMap();
    com.tencent.mm.modelvideo.o.aJy().a(this, Looper.getMainLooper());
    this.mContainer = ((ViewGroup)this.view);
    AppMethodBeat.o(38821);
  }
  
  private void updateStatus()
  {
    AppMethodBeat.i(38823);
    ac.i("MicroMsg.MassSightBanner", "call update status");
    a locala = new a((byte)0);
    locala.IHy = new WeakReference(this);
    az.agU().az(locala);
    AppMethodBeat.o(38823);
  }
  
  public final void a(t.a.a parama)
  {
    AppMethodBeat.i(38824);
    parama = parama.fileName;
    Long localLong = (Long)this.IHw.get(parama);
    if (localLong == null)
    {
      ac.d("MicroMsg.MassSightBanner", "massSendId is null, fileName %s", new Object[] { parama });
      if (bs.bG(parama, "").startsWith("DELETE_")) {
        updateStatus();
      }
      AppMethodBeat.o(38824);
      return;
    }
    b localb = (b)this.IHx.get(localLong);
    if (localb == null)
    {
      ac.d("MicroMsg.MassSightBanner", "find massSendId %d, but holder is null", new Object[] { localLong });
      AppMethodBeat.o(38824);
      return;
    }
    s locals = u.Ej(parama);
    if (locals == null)
    {
      ac.w("MicroMsg.MassSightBanner", "on nofify changed, filename %s, massSendId %d, but videoinfo is null", new Object[] { parama, localLong });
      AppMethodBeat.o(38824);
      return;
    }
    if (locals.status == 199)
    {
      ac.i("MicroMsg.MassSightBanner", "fileName %s, massSendId %d, done", new Object[] { parama, localLong });
      updateStatus();
      AppMethodBeat.o(38824);
      return;
    }
    c.a(localb, locals);
    AppMethodBeat.o(38824);
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(38822);
    com.tencent.mm.modelvideo.o.aJy().a(this);
    AppMethodBeat.o(38822);
  }
  
  public final int getLayoutId()
  {
    return 2131494742;
  }
  
  static final class a
    implements Runnable
  {
    WeakReference<m> IHy;
    
    public final void run()
    {
      AppMethodBeat.i(38815);
      List localList1 = com.tencent.mm.modelvideo.o.aJy().aJP();
      List localList2 = com.tencent.mm.modelvideo.o.aJy().aJQ();
      Object localObject = (m)this.IHy.get();
      if (localObject == null)
      {
        ac.w("MicroMsg.MassSightBanner", "try to load date, but banner ref is null");
        AppMethodBeat.o(38815);
        return;
      }
      ac.i("MicroMsg.MassSightBanner", "ViewCount %d, unfinish size %d, fail size %d", new Object[] { Integer.valueOf(((m)localObject).mContainer.getChildCount()), Integer.valueOf(localList1.size()), Integer.valueOf(localList2.size()) });
      if ((((m)localObject).mContainer.getChildCount() == 0) && (localList1.isEmpty()) && (localList2.isEmpty()))
      {
        AppMethodBeat.o(38815);
        return;
      }
      localObject = new m.c((byte)0);
      ((m.c)localObject).IHy = new WeakReference(this.IHy.get());
      ((m.c)localObject).IHH = localList1;
      ((m.c)localObject).IHI = localList2;
      ap.f((Runnable)localObject);
      AppMethodBeat.o(38815);
    }
  }
  
  static final class b
  {
    boolean IHA = false;
    View IHB = null;
    com.tencent.mm.plugin.sight.decode.a.a IHC = null;
    ImageView IHD = null;
    TextView IHE = null;
    ImageButton IHF = null;
    long IHz = 0L;
    ProgressBar iXo = null;
  }
  
  static final class c
    implements Runnable
  {
    List<s> IHH;
    List<s> IHI;
    WeakReference<m> IHy;
    
    private static int a(String paramString, m paramm, List<s> paramList, int paramInt1, int paramInt2, int paramInt3)
    {
      AppMethodBeat.i(38818);
      Iterator localIterator = paramList.iterator();
      s locals;
      label192:
      m.b localb;
      for (;;)
      {
        if (localIterator.hasNext())
        {
          locals = (s)localIterator.next();
          paramm.IHw.put(locals.getFileName(), Long.valueOf(locals.hYX));
          if (paramm.IHx.containsKey(Long.valueOf(locals.hYX)))
          {
            ac.d("MicroMsg.MassSightBanner", "%s: has contains massSendId %d, file %s", new Object[] { paramString, Long.valueOf(locals.hYX), locals.getFileName() });
          }
          else if (paramInt1 < paramInt2)
          {
            paramList = paramm.mContainer;
            int i = paramInt1 + 1;
            paramList = paramList.getChildAt(paramInt1);
            ac.d("MicroMsg.MassSightBanner", "%s: refresh view(%d/%d, hashCode %d) with massSendId %d", new Object[] { paramString, Integer.valueOf(i), Integer.valueOf(paramInt2), Integer.valueOf(paramList.hashCode()), Long.valueOf(locals.hYX) });
            paramInt1 = i;
            localb = (m.b)paramList.getTag();
            if (localb != null) {
              break label703;
            }
            localb = new m.b((byte)0);
          }
        }
      }
      label436:
      label703:
      for (;;)
      {
        String str1;
        if (localb.IHz != locals.hYX)
        {
          ac.d("MicroMsg.MassSightBanner", "ashutest::mass send id not match! %d -> %d, totalCount %d", new Object[] { Long.valueOf(localb.IHz), Long.valueOf(locals.hYX), Integer.valueOf(paramInt3) });
          localb.IHz = locals.hYX;
          localb.IHB = paramList;
          localb.IHC = ((com.tencent.mm.plugin.sight.decode.a.a)paramList.findViewById(2131300966));
          localb.IHD = ((ImageView)paramList.findViewById(2131305203));
          localb.iXo = ((ProgressBar)paramList.findViewById(2131303515));
          localb.IHF = ((ImageButton)paramList.findViewById(2131297690));
          localb.IHE = ((TextView)paramList.findViewById(2131301013));
          localb.IHC.setDrawableWidth(paramList.getResources().getDimensionPixelSize(2131165508));
          localb.IHB.setTag(localb);
          localb.IHF.setTag(Long.valueOf(localb.IHz));
          localb.IHB.setOnClickListener(new m.b.1(localb));
          localb.IHF.setOnClickListener(new m.b.2(localb));
          com.tencent.mm.modelvideo.o.aJy();
          str1 = t.DV(locals.getFileName());
          com.tencent.mm.modelvideo.o.aJy();
          String str2 = t.DW(locals.getFileName());
          paramList = com.tencent.mm.av.o.aFx().a(str2, com.tencent.mm.cc.a.getDensity(paramList.getContext()), paramList.getContext());
          localb.IHC.setThumbBmp(paramList);
          if (paramInt3 <= 3) {
            break label669;
          }
          localb.IHC.clear();
          localb.IHD.setVisibility(0);
        }
        for (;;)
        {
          a(localb, locals);
          paramm.IHx.put(Long.valueOf(locals.hYX), localb);
          break;
          paramList = LayoutInflater.from(paramm.mContainer.getContext()).inflate(2131494743, paramm.mContainer, false);
          paramm.mContainer.addView(paramList);
          ac.d("MicroMsg.MassSightBanner", "%s: new view(%d/%d, hashCode %d) with massSendId %d", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramList.hashCode()), Long.valueOf(locals.hYX) });
          break label192;
          ac.d("MicroMsg.MassSightBanner", "ashutest::mass send id match! %d, totalCount %d", new Object[] { Long.valueOf(localb.IHz), Integer.valueOf(paramInt3) });
          break label436;
          localb.IHC.e(str1, false, 0);
          localb.IHD.setVisibility(8);
        }
        AppMethodBeat.o(38818);
        return paramInt1;
      }
    }
    
    public static void a(m.b paramb, s params)
    {
      boolean bool = true;
      AppMethodBeat.i(38819);
      ac.v("MicroMsg.MassSightBanner", "info status %d", new Object[] { Integer.valueOf(params.status) });
      if ((params.status == 198) || (params.status == 197) || (params.status == 196))
      {
        paramb.iXo.setVisibility(4);
        paramb.IHE.setVisibility(0);
        paramb.IHF.setEnabled(true);
        paramb.IHA = true;
        AppMethodBeat.o(38819);
        return;
      }
      float f = params.hZn / params.hux;
      paramb.iXo.setVisibility(0);
      paramb.IHE.setVisibility(4);
      paramb.iXo.setProgress((int)(paramb.iXo.getMax() * f));
      params = paramb.IHF;
      if (Float.compare(0.99F, f) > 0) {}
      for (;;)
      {
        params.setEnabled(bool);
        paramb.IHA = false;
        AppMethodBeat.o(38819);
        return;
        bool = false;
      }
    }
    
    public final void run()
    {
      AppMethodBeat.i(38820);
      m localm = (m)this.IHy.get();
      if (localm == null)
      {
        ac.w("MicroMsg.MassSightBanner", "try to refresh, but banner ref is null");
        AppMethodBeat.o(38820);
        return;
      }
      int k = localm.mContainer.getChildCount();
      localm.IHx.clear();
      HashSet localHashSet = new HashSet();
      Iterator localIterator = this.IHH.iterator();
      while (localIterator.hasNext()) {
        localHashSet.add(Long.valueOf(((s)localIterator.next()).hYX));
      }
      localIterator = this.IHI.iterator();
      while (localIterator.hasNext()) {
        localHashSet.add(Long.valueOf(((s)localIterator.next()).hYX));
      }
      int i = localHashSet.size();
      int j = a("update unfinish", localm, this.IHH, 0, k, i);
      j = a("update fail", localm, this.IHI, j, k, i);
      i = j;
      while (i < k)
      {
        localm.mContainer.removeViewAt(j);
        i += 1;
      }
      AppMethodBeat.o(38820);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.a.m
 * JD-Core Version:    0.7.0.1
 */