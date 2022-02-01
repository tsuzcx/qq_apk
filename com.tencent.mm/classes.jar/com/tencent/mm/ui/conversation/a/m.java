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
import com.tencent.mm.model.bg;
import com.tencent.mm.modelvideo.m.5;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.modelvideo.t.a;
import com.tencent.mm.modelvideo.t.a.a;
import com.tencent.mm.modelvideo.u;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
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
  Map<String, Long> Qio;
  Map<Long, b> Qip;
  ViewGroup mContainer;
  
  public m(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(38821);
    this.Qio = new HashMap();
    this.Qip = new HashMap();
    o.bhj().a(this, Looper.getMainLooper());
    this.mContainer = ((ViewGroup)this.view);
    AppMethodBeat.o(38821);
  }
  
  private void updateStatus()
  {
    AppMethodBeat.i(38823);
    Log.i("MicroMsg.MassSightBanner", "call update status");
    a locala = new a((byte)0);
    locala.Qiq = new WeakReference(this);
    bg.aAk().postToWorker(locala);
    AppMethodBeat.o(38823);
  }
  
  public final void a(t.a.a parama)
  {
    AppMethodBeat.i(38824);
    parama = parama.fileName;
    Long localLong = (Long)this.Qio.get(parama);
    if (localLong == null)
    {
      Log.d("MicroMsg.MassSightBanner", "massSendId is null, fileName %s", new Object[] { parama });
      if (Util.nullAs(parama, "").startsWith("DELETE_")) {
        updateStatus();
      }
      AppMethodBeat.o(38824);
      return;
    }
    b localb = (b)this.Qip.get(localLong);
    if (localb == null)
    {
      Log.d("MicroMsg.MassSightBanner", "find massSendId %d, but holder is null", new Object[] { localLong });
      AppMethodBeat.o(38824);
      return;
    }
    s locals = u.QN(parama);
    if (locals == null)
    {
      Log.w("MicroMsg.MassSightBanner", "on nofify changed, filename %s, massSendId %d, but videoinfo is null", new Object[] { parama, localLong });
      AppMethodBeat.o(38824);
      return;
    }
    if (locals.status == 199)
    {
      Log.i("MicroMsg.MassSightBanner", "fileName %s, massSendId %d, done", new Object[] { parama, localLong });
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
    o.bhj().a(this);
    AppMethodBeat.o(38822);
  }
  
  public final int getLayoutId()
  {
    return 2131495471;
  }
  
  static final class a
    implements Runnable
  {
    WeakReference<m> Qiq;
    
    public final void run()
    {
      AppMethodBeat.i(38815);
      List localList1 = o.bhj().bhA();
      List localList2 = o.bhj().bhB();
      Object localObject = (m)this.Qiq.get();
      if (localObject == null)
      {
        Log.w("MicroMsg.MassSightBanner", "try to load date, but banner ref is null");
        AppMethodBeat.o(38815);
        return;
      }
      Log.i("MicroMsg.MassSightBanner", "ViewCount %d, unfinish size %d, fail size %d", new Object[] { Integer.valueOf(((m)localObject).mContainer.getChildCount()), Integer.valueOf(localList1.size()), Integer.valueOf(localList2.size()) });
      if ((((m)localObject).mContainer.getChildCount() == 0) && (localList1.isEmpty()) && (localList2.isEmpty()))
      {
        AppMethodBeat.o(38815);
        return;
      }
      localObject = new m.c((byte)0);
      ((m.c)localObject).Qiq = new WeakReference(this.Qiq.get());
      ((m.c)localObject).Qiz = localList1;
      ((m.c)localObject).QiA = localList2;
      MMHandlerThread.postToMainThread((Runnable)localObject);
      AppMethodBeat.o(38815);
    }
  }
  
  static final class b
  {
    long Qir = 0L;
    boolean Qis = false;
    View Qit = null;
    com.tencent.mm.plugin.sight.decode.a.a Qiu = null;
    ImageView Qiv = null;
    TextView Qiw = null;
    ImageButton Qix = null;
    ProgressBar krF = null;
  }
  
  static final class c
    implements Runnable
  {
    List<s> QiA;
    WeakReference<m> Qiq;
    List<s> Qiz;
    
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
          paramm.Qio.put(locals.getFileName(), Long.valueOf(locals.jqz));
          if (paramm.Qip.containsKey(Long.valueOf(locals.jqz)))
          {
            Log.d("MicroMsg.MassSightBanner", "%s: has contains massSendId %d, file %s", new Object[] { paramString, Long.valueOf(locals.jqz), locals.getFileName() });
          }
          else if (paramInt1 < paramInt2)
          {
            paramList = paramm.mContainer;
            int i = paramInt1 + 1;
            paramList = paramList.getChildAt(paramInt1);
            Log.d("MicroMsg.MassSightBanner", "%s: refresh view(%d/%d, hashCode %d) with massSendId %d", new Object[] { paramString, Integer.valueOf(i), Integer.valueOf(paramInt2), Integer.valueOf(paramList.hashCode()), Long.valueOf(locals.jqz) });
            paramInt1 = i;
            localb = (m.b)paramList.getTag();
            if (localb != null) {
              break label713;
            }
            localb = new m.b((byte)0);
          }
        }
      }
      label436:
      label713:
      for (;;)
      {
        String str1;
        if (localb.Qir != locals.jqz)
        {
          Log.d("MicroMsg.MassSightBanner", "ashutest::mass send id not match! %d -> %d, totalCount %d", new Object[] { Long.valueOf(localb.Qir), Long.valueOf(locals.jqz), Integer.valueOf(paramInt3) });
          localb.Qir = locals.jqz;
          localb.Qit = paramList;
          localb.Qiu = ((com.tencent.mm.plugin.sight.decode.a.a)paramList.findViewById(2131302602));
          localb.Qiv = ((ImageView)paramList.findViewById(2131308400));
          localb.krF = ((ProgressBar)paramList.findViewById(2131306281));
          localb.Qix = ((ImageButton)paramList.findViewById(2131297963));
          localb.Qiw = ((TextView)paramList.findViewById(2131302657));
          localb.Qiu.setDrawableWidth(paramList.getResources().getDimensionPixelSize(2131165526));
          localb.Qit.setTag(localb);
          localb.Qix.setTag(Long.valueOf(localb.Qir));
          localb.Qit.setOnClickListener(new m.b.1(localb));
          localb.Qix.setOnClickListener(new m.b.2(localb));
          o.bhj();
          str1 = t.Qw(locals.getFileName());
          o.bhj();
          String str2 = t.Qx(locals.getFileName());
          i locali = q.bcR();
          float f = com.tencent.mm.cb.a.getDensity(paramList.getContext());
          paramList.getContext();
          paramList = locali.a(str2, f, -1);
          localb.Qiu.setThumbBmp(paramList);
          if (paramInt3 <= 3) {
            break label679;
          }
          localb.Qiu.clear();
          localb.Qiv.setVisibility(0);
        }
        for (;;)
        {
          a(localb, locals);
          paramm.Qip.put(Long.valueOf(locals.jqz), localb);
          break;
          paramList = LayoutInflater.from(paramm.mContainer.getContext()).inflate(2131495472, paramm.mContainer, false);
          paramm.mContainer.addView(paramList);
          Log.d("MicroMsg.MassSightBanner", "%s: new view(%d/%d, hashCode %d) with massSendId %d", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramList.hashCode()), Long.valueOf(locals.jqz) });
          break label192;
          Log.d("MicroMsg.MassSightBanner", "ashutest::mass send id match! %d, totalCount %d", new Object[] { Long.valueOf(localb.Qir), Integer.valueOf(paramInt3) });
          break label436;
          localb.Qiu.e(str1, false, 0);
          localb.Qiv.setVisibility(8);
        }
        AppMethodBeat.o(38818);
        return paramInt1;
      }
    }
    
    public static void a(m.b paramb, s params)
    {
      boolean bool = true;
      AppMethodBeat.i(38819);
      Log.v("MicroMsg.MassSightBanner", "info status %d", new Object[] { Integer.valueOf(params.status) });
      if ((params.status == 198) || (params.status == 197) || (params.status == 196))
      {
        paramb.krF.setVisibility(4);
        paramb.Qiw.setVisibility(0);
        paramb.Qix.setEnabled(true);
        paramb.Qis = true;
        AppMethodBeat.o(38819);
        return;
      }
      float f = params.jqP / params.iKP;
      paramb.krF.setVisibility(0);
      paramb.Qiw.setVisibility(4);
      paramb.krF.setProgress((int)(paramb.krF.getMax() * f));
      params = paramb.Qix;
      if (Float.compare(0.99F, f) > 0) {}
      for (;;)
      {
        params.setEnabled(bool);
        paramb.Qis = false;
        AppMethodBeat.o(38819);
        return;
        bool = false;
      }
    }
    
    public final void run()
    {
      AppMethodBeat.i(38820);
      m localm = (m)this.Qiq.get();
      if (localm == null)
      {
        Log.w("MicroMsg.MassSightBanner", "try to refresh, but banner ref is null");
        AppMethodBeat.o(38820);
        return;
      }
      int k = localm.mContainer.getChildCount();
      localm.Qip.clear();
      HashSet localHashSet = new HashSet();
      Iterator localIterator = this.Qiz.iterator();
      while (localIterator.hasNext()) {
        localHashSet.add(Long.valueOf(((s)localIterator.next()).jqz));
      }
      localIterator = this.QiA.iterator();
      while (localIterator.hasNext()) {
        localHashSet.add(Long.valueOf(((s)localIterator.next()).jqz));
      }
      int i = localHashSet.size();
      int j = a("update unfinish", localm, this.Qiz, 0, k, i);
      j = a("update fail", localm, this.QiA, j, k, i);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.a.m
 * JD-Core Version:    0.7.0.1
 */