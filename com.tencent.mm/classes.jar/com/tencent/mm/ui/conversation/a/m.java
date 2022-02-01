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
import com.tencent.mm.av.i;
import com.tencent.mm.av.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bc;
import com.tencent.mm.modelvideo.m.5;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.modelvideo.t.a;
import com.tencent.mm.modelvideo.t.a.a;
import com.tencent.mm.modelvideo.u;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
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
  Map<String, Long> KUY;
  Map<Long, b> KUZ;
  ViewGroup mContainer;
  
  public m(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(38821);
    this.KUY = new HashMap();
    this.KUZ = new HashMap();
    o.aNh().a(this, Looper.getMainLooper());
    this.mContainer = ((ViewGroup)this.view);
    AppMethodBeat.o(38821);
  }
  
  private void updateStatus()
  {
    AppMethodBeat.i(38823);
    ae.i("MicroMsg.MassSightBanner", "call update status");
    a locala = new a((byte)0);
    locala.KVa = new WeakReference(this);
    bc.ajU().aw(locala);
    AppMethodBeat.o(38823);
  }
  
  public final void a(t.a.a parama)
  {
    AppMethodBeat.i(38824);
    parama = parama.fileName;
    Long localLong = (Long)this.KUY.get(parama);
    if (localLong == null)
    {
      ae.d("MicroMsg.MassSightBanner", "massSendId is null, fileName %s", new Object[] { parama });
      if (bu.bI(parama, "").startsWith("DELETE_")) {
        updateStatus();
      }
      AppMethodBeat.o(38824);
      return;
    }
    b localb = (b)this.KUZ.get(localLong);
    if (localb == null)
    {
      ae.d("MicroMsg.MassSightBanner", "find massSendId %d, but holder is null", new Object[] { localLong });
      AppMethodBeat.o(38824);
      return;
    }
    s locals = u.Ia(parama);
    if (locals == null)
    {
      ae.w("MicroMsg.MassSightBanner", "on nofify changed, filename %s, massSendId %d, but videoinfo is null", new Object[] { parama, localLong });
      AppMethodBeat.o(38824);
      return;
    }
    if (locals.status == 199)
    {
      ae.i("MicroMsg.MassSightBanner", "fileName %s, massSendId %d, done", new Object[] { parama, localLong });
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
    o.aNh().a(this);
    AppMethodBeat.o(38822);
  }
  
  public final int getLayoutId()
  {
    return 2131494742;
  }
  
  static final class a
    implements Runnable
  {
    WeakReference<m> KVa;
    
    public final void run()
    {
      AppMethodBeat.i(38815);
      List localList1 = o.aNh().aNy();
      List localList2 = o.aNh().aNz();
      Object localObject = (m)this.KVa.get();
      if (localObject == null)
      {
        ae.w("MicroMsg.MassSightBanner", "try to load date, but banner ref is null");
        AppMethodBeat.o(38815);
        return;
      }
      ae.i("MicroMsg.MassSightBanner", "ViewCount %d, unfinish size %d, fail size %d", new Object[] { Integer.valueOf(((m)localObject).mContainer.getChildCount()), Integer.valueOf(localList1.size()), Integer.valueOf(localList2.size()) });
      if ((((m)localObject).mContainer.getChildCount() == 0) && (localList1.isEmpty()) && (localList2.isEmpty()))
      {
        AppMethodBeat.o(38815);
        return;
      }
      localObject = new m.c((byte)0);
      ((m.c)localObject).KVa = new WeakReference(this.KVa.get());
      ((m.c)localObject).KVj = localList1;
      ((m.c)localObject).KVk = localList2;
      ar.f((Runnable)localObject);
      AppMethodBeat.o(38815);
    }
  }
  
  static final class b
  {
    long KVb = 0L;
    boolean KVc = false;
    View KVd = null;
    com.tencent.mm.plugin.sight.decode.a.a KVe = null;
    ImageView KVf = null;
    TextView KVg = null;
    ImageButton KVh = null;
    ProgressBar jtq = null;
  }
  
  static final class c
    implements Runnable
  {
    WeakReference<m> KVa;
    List<s> KVj;
    List<s> KVk;
    
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
          paramm.KUY.put(locals.getFileName(), Long.valueOf(locals.ivn));
          if (paramm.KUZ.containsKey(Long.valueOf(locals.ivn)))
          {
            ae.d("MicroMsg.MassSightBanner", "%s: has contains massSendId %d, file %s", new Object[] { paramString, Long.valueOf(locals.ivn), locals.getFileName() });
          }
          else if (paramInt1 < paramInt2)
          {
            paramList = paramm.mContainer;
            int i = paramInt1 + 1;
            paramList = paramList.getChildAt(paramInt1);
            ae.d("MicroMsg.MassSightBanner", "%s: refresh view(%d/%d, hashCode %d) with massSendId %d", new Object[] { paramString, Integer.valueOf(i), Integer.valueOf(paramInt2), Integer.valueOf(paramList.hashCode()), Long.valueOf(locals.ivn) });
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
        if (localb.KVb != locals.ivn)
        {
          ae.d("MicroMsg.MassSightBanner", "ashutest::mass send id not match! %d -> %d, totalCount %d", new Object[] { Long.valueOf(localb.KVb), Long.valueOf(locals.ivn), Integer.valueOf(paramInt3) });
          localb.KVb = locals.ivn;
          localb.KVd = paramList;
          localb.KVe = ((com.tencent.mm.plugin.sight.decode.a.a)paramList.findViewById(2131300966));
          localb.KVf = ((ImageView)paramList.findViewById(2131305203));
          localb.jtq = ((ProgressBar)paramList.findViewById(2131303515));
          localb.KVh = ((ImageButton)paramList.findViewById(2131297690));
          localb.KVg = ((TextView)paramList.findViewById(2131301013));
          localb.KVe.setDrawableWidth(paramList.getResources().getDimensionPixelSize(2131165508));
          localb.KVd.setTag(localb);
          localb.KVh.setTag(Long.valueOf(localb.KVb));
          localb.KVd.setOnClickListener(new m.b.1(localb));
          localb.KVh.setOnClickListener(new m.b.2(localb));
          o.aNh();
          str1 = t.HJ(locals.getFileName());
          o.aNh();
          String str2 = t.HK(locals.getFileName());
          paramList = q.aIX().a(str2, com.tencent.mm.cb.a.getDensity(paramList.getContext()), paramList.getContext());
          localb.KVe.setThumbBmp(paramList);
          if (paramInt3 <= 3) {
            break label669;
          }
          localb.KVe.clear();
          localb.KVf.setVisibility(0);
        }
        for (;;)
        {
          a(localb, locals);
          paramm.KUZ.put(Long.valueOf(locals.ivn), localb);
          break;
          paramList = LayoutInflater.from(paramm.mContainer.getContext()).inflate(2131494743, paramm.mContainer, false);
          paramm.mContainer.addView(paramList);
          ae.d("MicroMsg.MassSightBanner", "%s: new view(%d/%d, hashCode %d) with massSendId %d", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramList.hashCode()), Long.valueOf(locals.ivn) });
          break label192;
          ae.d("MicroMsg.MassSightBanner", "ashutest::mass send id match! %d, totalCount %d", new Object[] { Long.valueOf(localb.KVb), Integer.valueOf(paramInt3) });
          break label436;
          localb.KVe.e(str1, false, 0);
          localb.KVf.setVisibility(8);
        }
        AppMethodBeat.o(38818);
        return paramInt1;
      }
    }
    
    public static void a(m.b paramb, s params)
    {
      boolean bool = true;
      AppMethodBeat.i(38819);
      ae.v("MicroMsg.MassSightBanner", "info status %d", new Object[] { Integer.valueOf(params.status) });
      if ((params.status == 198) || (params.status == 197) || (params.status == 196))
      {
        paramb.jtq.setVisibility(4);
        paramb.KVg.setVisibility(0);
        paramb.KVh.setEnabled(true);
        paramb.KVc = true;
        AppMethodBeat.o(38819);
        return;
      }
      float f = params.ivD / params.hPI;
      paramb.jtq.setVisibility(0);
      paramb.KVg.setVisibility(4);
      paramb.jtq.setProgress((int)(paramb.jtq.getMax() * f));
      params = paramb.KVh;
      if (Float.compare(0.99F, f) > 0) {}
      for (;;)
      {
        params.setEnabled(bool);
        paramb.KVc = false;
        AppMethodBeat.o(38819);
        return;
        bool = false;
      }
    }
    
    public final void run()
    {
      AppMethodBeat.i(38820);
      m localm = (m)this.KVa.get();
      if (localm == null)
      {
        ae.w("MicroMsg.MassSightBanner", "try to refresh, but banner ref is null");
        AppMethodBeat.o(38820);
        return;
      }
      int k = localm.mContainer.getChildCount();
      localm.KUZ.clear();
      HashSet localHashSet = new HashSet();
      Iterator localIterator = this.KVj.iterator();
      while (localIterator.hasNext()) {
        localHashSet.add(Long.valueOf(((s)localIterator.next()).ivn));
      }
      localIterator = this.KVk.iterator();
      while (localIterator.hasNext()) {
        localHashSet.add(Long.valueOf(((s)localIterator.next()).ivn));
      }
      int i = localHashSet.size();
      int j = a("update unfinish", localm, this.KVj, 0, k, i);
      j = a("update fail", localm, this.KVk, j, k, i);
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