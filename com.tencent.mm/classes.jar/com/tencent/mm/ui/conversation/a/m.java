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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
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
  Map<String, Long> Hhd;
  Map<Long, b> Hhe;
  ViewGroup mContainer;
  
  public m(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(38821);
    this.Hhd = new HashMap();
    this.Hhe = new HashMap();
    com.tencent.mm.modelvideo.o.aCI().a(this, Looper.getMainLooper());
    this.mContainer = ((ViewGroup)this.view);
    AppMethodBeat.o(38821);
  }
  
  private void updateStatus()
  {
    AppMethodBeat.i(38823);
    ad.i("MicroMsg.MassSightBanner", "call update status");
    a locala = new a((byte)0);
    locala.Hhf = new WeakReference(this);
    az.afE().ax(locala);
    AppMethodBeat.o(38823);
  }
  
  public final void a(t.a.a parama)
  {
    AppMethodBeat.i(38824);
    parama = parama.fileName;
    Long localLong = (Long)this.Hhd.get(parama);
    if (localLong == null)
    {
      ad.d("MicroMsg.MassSightBanner", "massSendId is null, fileName %s", new Object[] { parama });
      if (bt.by(parama, "").startsWith("DELETE_")) {
        updateStatus();
      }
      AppMethodBeat.o(38824);
      return;
    }
    b localb = (b)this.Hhe.get(localLong);
    if (localb == null)
    {
      ad.d("MicroMsg.MassSightBanner", "find massSendId %d, but holder is null", new Object[] { localLong });
      AppMethodBeat.o(38824);
      return;
    }
    s locals = u.Ae(parama);
    if (locals == null)
    {
      ad.w("MicroMsg.MassSightBanner", "on nofify changed, filename %s, massSendId %d, but videoinfo is null", new Object[] { parama, localLong });
      AppMethodBeat.o(38824);
      return;
    }
    if (locals.status == 199)
    {
      ad.i("MicroMsg.MassSightBanner", "fileName %s, massSendId %d, done", new Object[] { parama, localLong });
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
    com.tencent.mm.modelvideo.o.aCI().a(this);
    AppMethodBeat.o(38822);
  }
  
  public final int getLayoutId()
  {
    return 2131494742;
  }
  
  static final class a
    implements Runnable
  {
    WeakReference<m> Hhf;
    
    public final void run()
    {
      AppMethodBeat.i(38815);
      List localList1 = com.tencent.mm.modelvideo.o.aCI().aCY();
      List localList2 = com.tencent.mm.modelvideo.o.aCI().aCZ();
      Object localObject = (m)this.Hhf.get();
      if (localObject == null)
      {
        ad.w("MicroMsg.MassSightBanner", "try to load date, but banner ref is null");
        AppMethodBeat.o(38815);
        return;
      }
      ad.i("MicroMsg.MassSightBanner", "ViewCount %d, unfinish size %d, fail size %d", new Object[] { Integer.valueOf(((m)localObject).mContainer.getChildCount()), Integer.valueOf(localList1.size()), Integer.valueOf(localList2.size()) });
      if ((((m)localObject).mContainer.getChildCount() == 0) && (localList1.isEmpty()) && (localList2.isEmpty()))
      {
        AppMethodBeat.o(38815);
        return;
      }
      localObject = new m.c((byte)0);
      ((m.c)localObject).Hhf = new WeakReference(this.Hhf.get());
      ((m.c)localObject).Hho = localList1;
      ((m.c)localObject).Hhp = localList2;
      aq.f((Runnable)localObject);
      AppMethodBeat.o(38815);
    }
  }
  
  static final class b
  {
    long Hhg = 0L;
    boolean Hhh = false;
    View Hhi = null;
    com.tencent.mm.plugin.sight.decode.a.a Hhj = null;
    ImageView Hhk = null;
    TextView Hhl = null;
    ImageButton Hhm = null;
    ProgressBar ixl = null;
  }
  
  static final class c
    implements Runnable
  {
    WeakReference<m> Hhf;
    List<s> Hho;
    List<s> Hhp;
    
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
          paramm.Hhd.put(locals.getFileName(), Long.valueOf(locals.hyw));
          if (paramm.Hhe.containsKey(Long.valueOf(locals.hyw)))
          {
            ad.d("MicroMsg.MassSightBanner", "%s: has contains massSendId %d, file %s", new Object[] { paramString, Long.valueOf(locals.hyw), locals.getFileName() });
          }
          else if (paramInt1 < paramInt2)
          {
            paramList = paramm.mContainer;
            int i = paramInt1 + 1;
            paramList = paramList.getChildAt(paramInt1);
            ad.d("MicroMsg.MassSightBanner", "%s: refresh view(%d/%d, hashCode %d) with massSendId %d", new Object[] { paramString, Integer.valueOf(i), Integer.valueOf(paramInt2), Integer.valueOf(paramList.hashCode()), Long.valueOf(locals.hyw) });
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
        if (localb.Hhg != locals.hyw)
        {
          ad.d("MicroMsg.MassSightBanner", "ashutest::mass send id not match! %d -> %d, totalCount %d", new Object[] { Long.valueOf(localb.Hhg), Long.valueOf(locals.hyw), Integer.valueOf(paramInt3) });
          localb.Hhg = locals.hyw;
          localb.Hhi = paramList;
          localb.Hhj = ((com.tencent.mm.plugin.sight.decode.a.a)paramList.findViewById(2131300966));
          localb.Hhk = ((ImageView)paramList.findViewById(2131305203));
          localb.ixl = ((ProgressBar)paramList.findViewById(2131303515));
          localb.Hhm = ((ImageButton)paramList.findViewById(2131297690));
          localb.Hhl = ((TextView)paramList.findViewById(2131301013));
          localb.Hhj.setDrawableWidth(paramList.getResources().getDimensionPixelSize(2131165508));
          localb.Hhi.setTag(localb);
          localb.Hhm.setTag(Long.valueOf(localb.Hhg));
          localb.Hhi.setOnClickListener(new m.b.1(localb));
          localb.Hhm.setOnClickListener(new m.b.2(localb));
          com.tencent.mm.modelvideo.o.aCI();
          str1 = t.zQ(locals.getFileName());
          com.tencent.mm.modelvideo.o.aCI();
          String str2 = t.zR(locals.getFileName());
          paramList = com.tencent.mm.aw.o.ayF().a(str2, com.tencent.mm.cd.a.getDensity(paramList.getContext()), paramList.getContext());
          localb.Hhj.setThumbBmp(paramList);
          if (paramInt3 <= 3) {
            break label669;
          }
          localb.Hhj.clear();
          localb.Hhk.setVisibility(0);
        }
        for (;;)
        {
          a(localb, locals);
          paramm.Hhe.put(Long.valueOf(locals.hyw), localb);
          break;
          paramList = LayoutInflater.from(paramm.mContainer.getContext()).inflate(2131494743, paramm.mContainer, false);
          paramm.mContainer.addView(paramList);
          ad.d("MicroMsg.MassSightBanner", "%s: new view(%d/%d, hashCode %d) with massSendId %d", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramList.hashCode()), Long.valueOf(locals.hyw) });
          break label192;
          ad.d("MicroMsg.MassSightBanner", "ashutest::mass send id match! %d, totalCount %d", new Object[] { Long.valueOf(localb.Hhg), Integer.valueOf(paramInt3) });
          break label436;
          localb.Hhj.e(str1, false, 0);
          localb.Hhk.setVisibility(8);
        }
        AppMethodBeat.o(38818);
        return paramInt1;
      }
    }
    
    public static void a(m.b paramb, s params)
    {
      boolean bool = true;
      AppMethodBeat.i(38819);
      ad.v("MicroMsg.MassSightBanner", "info status %d", new Object[] { Integer.valueOf(params.status) });
      if ((params.status == 198) || (params.status == 197) || (params.status == 196))
      {
        paramb.ixl.setVisibility(4);
        paramb.Hhl.setVisibility(0);
        paramb.Hhm.setEnabled(true);
        paramb.Hhh = true;
        AppMethodBeat.o(38819);
        return;
      }
      float f = params.hyM / params.gTY;
      paramb.ixl.setVisibility(0);
      paramb.Hhl.setVisibility(4);
      paramb.ixl.setProgress((int)(paramb.ixl.getMax() * f));
      params = paramb.Hhm;
      if (Float.compare(0.99F, f) > 0) {}
      for (;;)
      {
        params.setEnabled(bool);
        paramb.Hhh = false;
        AppMethodBeat.o(38819);
        return;
        bool = false;
      }
    }
    
    public final void run()
    {
      AppMethodBeat.i(38820);
      m localm = (m)this.Hhf.get();
      if (localm == null)
      {
        ad.w("MicroMsg.MassSightBanner", "try to refresh, but banner ref is null");
        AppMethodBeat.o(38820);
        return;
      }
      int k = localm.mContainer.getChildCount();
      localm.Hhe.clear();
      HashSet localHashSet = new HashSet();
      Iterator localIterator = this.Hho.iterator();
      while (localIterator.hasNext()) {
        localHashSet.add(Long.valueOf(((s)localIterator.next()).hyw));
      }
      localIterator = this.Hhp.iterator();
      while (localIterator.hasNext()) {
        localHashSet.add(Long.valueOf(((s)localIterator.next()).hyw));
      }
      int i = localHashSet.size();
      int j = a("update unfinish", localm, this.Hho, 0, k, i);
      j = a("update fail", localm, this.Hhp, j, k, i);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.a.m
 * JD-Core Version:    0.7.0.1
 */