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
import com.tencent.mm.aw.i;
import com.tencent.mm.aw.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ba;
import com.tencent.mm.modelvideo.m.5;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.modelvideo.t.a;
import com.tencent.mm.modelvideo.t.a.a;
import com.tencent.mm.modelvideo.u;
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
  extends com.tencent.mm.pluginsdk.ui.b.b
  implements t.a
{
  Map<String, Long> KyE;
  Map<Long, b> KyF;
  ViewGroup mContainer;
  
  public m(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(38821);
    this.KyE = new HashMap();
    this.KyF = new HashMap();
    o.aMJ().a(this, Looper.getMainLooper());
    this.mContainer = ((ViewGroup)this.view);
    AppMethodBeat.o(38821);
  }
  
  private void updateStatus()
  {
    AppMethodBeat.i(38823);
    ad.i("MicroMsg.MassSightBanner", "call update status");
    a locala = new a((byte)0);
    locala.KyG = new WeakReference(this);
    ba.ajF().ay(locala);
    AppMethodBeat.o(38823);
  }
  
  public final void a(t.a.a parama)
  {
    AppMethodBeat.i(38824);
    parama = parama.fileName;
    Long localLong = (Long)this.KyE.get(parama);
    if (localLong == null)
    {
      ad.d("MicroMsg.MassSightBanner", "massSendId is null, fileName %s", new Object[] { parama });
      if (bt.bI(parama, "").startsWith("DELETE_")) {
        updateStatus();
      }
      AppMethodBeat.o(38824);
      return;
    }
    b localb = (b)this.KyF.get(localLong);
    if (localb == null)
    {
      ad.d("MicroMsg.MassSightBanner", "find massSendId %d, but holder is null", new Object[] { localLong });
      AppMethodBeat.o(38824);
      return;
    }
    s locals = u.Hy(parama);
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
    o.aMJ().a(this);
    AppMethodBeat.o(38822);
  }
  
  public final int getLayoutId()
  {
    return 2131494742;
  }
  
  static final class a
    implements Runnable
  {
    WeakReference<m> KyG;
    
    public final void run()
    {
      AppMethodBeat.i(38815);
      List localList1 = o.aMJ().aNa();
      List localList2 = o.aMJ().aNb();
      Object localObject = (m)this.KyG.get();
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
      ((m.c)localObject).KyG = new WeakReference(this.KyG.get());
      ((m.c)localObject).KyP = localList1;
      ((m.c)localObject).KyQ = localList2;
      aq.f((Runnable)localObject);
      AppMethodBeat.o(38815);
    }
  }
  
  static final class b
  {
    long KyH = 0L;
    boolean KyI = false;
    View KyJ = null;
    com.tencent.mm.plugin.sight.decode.a.a KyK = null;
    ImageView KyL = null;
    TextView KyM = null;
    ImageButton KyN = null;
    ProgressBar jqx = null;
  }
  
  static final class c
    implements Runnable
  {
    WeakReference<m> KyG;
    List<s> KyP;
    List<s> KyQ;
    
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
          paramm.KyE.put(locals.getFileName(), Long.valueOf(locals.ist));
          if (paramm.KyF.containsKey(Long.valueOf(locals.ist)))
          {
            ad.d("MicroMsg.MassSightBanner", "%s: has contains massSendId %d, file %s", new Object[] { paramString, Long.valueOf(locals.ist), locals.getFileName() });
          }
          else if (paramInt1 < paramInt2)
          {
            paramList = paramm.mContainer;
            int i = paramInt1 + 1;
            paramList = paramList.getChildAt(paramInt1);
            ad.d("MicroMsg.MassSightBanner", "%s: refresh view(%d/%d, hashCode %d) with massSendId %d", new Object[] { paramString, Integer.valueOf(i), Integer.valueOf(paramInt2), Integer.valueOf(paramList.hashCode()), Long.valueOf(locals.ist) });
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
        if (localb.KyH != locals.ist)
        {
          ad.d("MicroMsg.MassSightBanner", "ashutest::mass send id not match! %d -> %d, totalCount %d", new Object[] { Long.valueOf(localb.KyH), Long.valueOf(locals.ist), Integer.valueOf(paramInt3) });
          localb.KyH = locals.ist;
          localb.KyJ = paramList;
          localb.KyK = ((com.tencent.mm.plugin.sight.decode.a.a)paramList.findViewById(2131300966));
          localb.KyL = ((ImageView)paramList.findViewById(2131305203));
          localb.jqx = ((ProgressBar)paramList.findViewById(2131303515));
          localb.KyN = ((ImageButton)paramList.findViewById(2131297690));
          localb.KyM = ((TextView)paramList.findViewById(2131301013));
          localb.KyK.setDrawableWidth(paramList.getResources().getDimensionPixelSize(2131165508));
          localb.KyJ.setTag(localb);
          localb.KyN.setTag(Long.valueOf(localb.KyH));
          localb.KyJ.setOnClickListener(new m.b.1(localb));
          localb.KyN.setOnClickListener(new m.b.2(localb));
          o.aMJ();
          str1 = t.Hh(locals.getFileName());
          o.aMJ();
          String str2 = t.Hi(locals.getFileName());
          paramList = q.aIF().a(str2, com.tencent.mm.cc.a.getDensity(paramList.getContext()), paramList.getContext());
          localb.KyK.setThumbBmp(paramList);
          if (paramInt3 <= 3) {
            break label669;
          }
          localb.KyK.clear();
          localb.KyL.setVisibility(0);
        }
        for (;;)
        {
          a(localb, locals);
          paramm.KyF.put(Long.valueOf(locals.ist), localb);
          break;
          paramList = LayoutInflater.from(paramm.mContainer.getContext()).inflate(2131494743, paramm.mContainer, false);
          paramm.mContainer.addView(paramList);
          ad.d("MicroMsg.MassSightBanner", "%s: new view(%d/%d, hashCode %d) with massSendId %d", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramList.hashCode()), Long.valueOf(locals.ist) });
          break label192;
          ad.d("MicroMsg.MassSightBanner", "ashutest::mass send id match! %d, totalCount %d", new Object[] { Long.valueOf(localb.KyH), Integer.valueOf(paramInt3) });
          break label436;
          localb.KyK.e(str1, false, 0);
          localb.KyL.setVisibility(8);
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
        paramb.jqx.setVisibility(4);
        paramb.KyM.setVisibility(0);
        paramb.KyN.setEnabled(true);
        paramb.KyI = true;
        AppMethodBeat.o(38819);
        return;
      }
      float f = params.isJ / params.hMP;
      paramb.jqx.setVisibility(0);
      paramb.KyM.setVisibility(4);
      paramb.jqx.setProgress((int)(paramb.jqx.getMax() * f));
      params = paramb.KyN;
      if (Float.compare(0.99F, f) > 0) {}
      for (;;)
      {
        params.setEnabled(bool);
        paramb.KyI = false;
        AppMethodBeat.o(38819);
        return;
        bool = false;
      }
    }
    
    public final void run()
    {
      AppMethodBeat.i(38820);
      m localm = (m)this.KyG.get();
      if (localm == null)
      {
        ad.w("MicroMsg.MassSightBanner", "try to refresh, but banner ref is null");
        AppMethodBeat.o(38820);
        return;
      }
      int k = localm.mContainer.getChildCount();
      localm.KyF.clear();
      HashSet localHashSet = new HashSet();
      Iterator localIterator = this.KyP.iterator();
      while (localIterator.hasNext()) {
        localHashSet.add(Long.valueOf(((s)localIterator.next()).ist));
      }
      localIterator = this.KyQ.iterator();
      while (localIterator.hasNext()) {
        localHashSet.add(Long.valueOf(((s)localIterator.next()).ist));
      }
      int i = localHashSet.size();
      int j = a("update unfinish", localm, this.KyP, 0, k, i);
      j = a("update fail", localm, this.KyQ, j, k, i);
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