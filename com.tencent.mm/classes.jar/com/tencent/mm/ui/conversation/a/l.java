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
import com.tencent.mm.R.f;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.ay.i;
import com.tencent.mm.ay.q;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.bh;
import com.tencent.mm.modelvideo.q.5;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.w;
import com.tencent.mm.modelvideo.x;
import com.tencent.mm.modelvideo.x.a;
import com.tencent.mm.modelvideo.x.a.a;
import com.tencent.mm.modelvideo.y;
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

public final class l
  extends com.tencent.mm.pluginsdk.ui.b.b
  implements x.a
{
  Map<String, Long> XFu;
  Map<Long, b> XFv;
  ViewGroup mContainer;
  
  public l(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(38821);
    this.XFu = new HashMap();
    this.XFv = new HashMap();
    s.bqB().a(this, Looper.getMainLooper());
    this.mContainer = ((ViewGroup)this.view);
    AppMethodBeat.o(38821);
  }
  
  private void updateStatus()
  {
    AppMethodBeat.i(38823);
    Log.i("MicroMsg.MassSightBanner", "call update status");
    a locala = new a((byte)0);
    locala.XFw = new WeakReference(this);
    bh.aHJ().postToWorker(locala);
    AppMethodBeat.o(38823);
  }
  
  public final void a(x.a.a parama)
  {
    AppMethodBeat.i(38824);
    parama = parama.fileName;
    Long localLong = (Long)this.XFu.get(parama);
    if (localLong == null)
    {
      Log.d("MicroMsg.MassSightBanner", "massSendId is null, fileName %s", new Object[] { parama });
      if (Util.nullAs(parama, "").startsWith("DELETE_")) {
        updateStatus();
      }
      AppMethodBeat.o(38824);
      return;
    }
    b localb = (b)this.XFv.get(localLong);
    if (localb == null)
    {
      Log.d("MicroMsg.MassSightBanner", "find massSendId %d, but holder is null", new Object[] { localLong });
      AppMethodBeat.o(38824);
      return;
    }
    w localw = y.Yk(parama);
    if (localw == null)
    {
      Log.w("MicroMsg.MassSightBanner", "on nofify changed, filename %s, massSendId %d, but videoinfo is null", new Object[] { parama, localLong });
      AppMethodBeat.o(38824);
      return;
    }
    if (localw.status == 199)
    {
      Log.i("MicroMsg.MassSightBanner", "fileName %s, massSendId %d, done", new Object[] { parama, localLong });
      updateStatus();
      AppMethodBeat.o(38824);
      return;
    }
    c.a(localb, localw);
    AppMethodBeat.o(38824);
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(38822);
    s.bqB().a(this);
    AppMethodBeat.o(38822);
  }
  
  public final int getLayoutId()
  {
    return R.i.eiC;
  }
  
  static final class a
    implements Runnable
  {
    WeakReference<l> XFw;
    
    public final void run()
    {
      AppMethodBeat.i(38815);
      List localList1 = s.bqB().bqW();
      List localList2 = s.bqB().bqX();
      Object localObject = (l)this.XFw.get();
      if (localObject == null)
      {
        Log.w("MicroMsg.MassSightBanner", "try to load date, but banner ref is null");
        AppMethodBeat.o(38815);
        return;
      }
      Log.i("MicroMsg.MassSightBanner", "ViewCount %d, unfinish size %d, fail size %d", new Object[] { Integer.valueOf(((l)localObject).mContainer.getChildCount()), Integer.valueOf(localList1.size()), Integer.valueOf(localList2.size()) });
      if ((((l)localObject).mContainer.getChildCount() == 0) && (localList1.isEmpty()) && (localList2.isEmpty()))
      {
        AppMethodBeat.o(38815);
        return;
      }
      localObject = new l.c((byte)0);
      ((l.c)localObject).XFw = new WeakReference(this.XFw.get());
      ((l.c)localObject).XFF = localList1;
      ((l.c)localObject).XFG = localList2;
      MMHandlerThread.postToMainThread((Runnable)localObject);
      AppMethodBeat.o(38815);
    }
  }
  
  static final class b
  {
    com.tencent.mm.plugin.sight.decode.a.a XFA = null;
    ImageView XFB = null;
    TextView XFC = null;
    ImageButton XFD = null;
    long XFx = 0L;
    boolean XFy = false;
    View XFz = null;
    ProgressBar njo = null;
  }
  
  static final class c
    implements Runnable
  {
    List<w> XFF;
    List<w> XFG;
    WeakReference<l> XFw;
    
    private static int a(String paramString, l paraml, List<w> paramList, int paramInt1, int paramInt2, int paramInt3)
    {
      AppMethodBeat.i(38818);
      Iterator localIterator = paramList.iterator();
      w localw;
      label192:
      l.b localb;
      for (;;)
      {
        if (localIterator.hasNext())
        {
          localw = (w)localIterator.next();
          paraml.XFu.put(localw.getFileName(), Long.valueOf(localw.mga));
          if (paraml.XFv.containsKey(Long.valueOf(localw.mga)))
          {
            Log.d("MicroMsg.MassSightBanner", "%s: has contains massSendId %d, file %s", new Object[] { paramString, Long.valueOf(localw.mga), localw.getFileName() });
          }
          else if (paramInt1 < paramInt2)
          {
            paramList = paraml.mContainer;
            int i = paramInt1 + 1;
            paramList = paramList.getChildAt(paramInt1);
            Log.d("MicroMsg.MassSightBanner", "%s: refresh view(%d/%d, hashCode %d) with massSendId %d", new Object[] { paramString, Integer.valueOf(i), Integer.valueOf(paramInt2), Integer.valueOf(paramList.hashCode()), Long.valueOf(localw.mga) });
            paramInt1 = i;
            localb = (l.b)paramList.getTag();
            if (localb != null) {
              break label719;
            }
            localb = new l.b((byte)0);
          }
        }
      }
      label442:
      label719:
      for (;;)
      {
        String str1;
        if (localb.XFx != localw.mga)
        {
          Log.d("MicroMsg.MassSightBanner", "ashutest::mass send id not match! %d -> %d, totalCount %d", new Object[] { Long.valueOf(localb.XFx), Long.valueOf(localw.mga), Integer.valueOf(paramInt3) });
          localb.XFx = localw.mga;
          localb.XFz = paramList;
          localb.XFA = ((com.tencent.mm.plugin.sight.decode.a.a)paramList.findViewById(R.h.image_view));
          localb.XFB = ((ImageView)paramList.findViewById(R.h.dVH));
          localb.njo = ((ProgressBar)paramList.findViewById(R.h.progress));
          localb.XFD = ((ImageButton)paramList.findViewById(R.h.cancel_btn));
          localb.XFC = ((TextView)paramList.findViewById(R.h.info_tv));
          localb.XFA.setDrawableWidth(paramList.getResources().getDimensionPixelSize(R.f.NormalAvatarSize));
          localb.XFz.setTag(localb);
          localb.XFD.setTag(Long.valueOf(localb.XFx));
          localb.XFz.setOnClickListener(new l.b.1(localb));
          localb.XFD.setOnClickListener(new l.b.2(localb));
          s.bqB();
          str1 = x.XT(localw.getFileName());
          s.bqB();
          String str2 = x.XU(localw.getFileName());
          i locali = q.bmh();
          float f = com.tencent.mm.ci.a.getDensity(paramList.getContext());
          paramList.getContext();
          paramList = locali.a(str2, f, -1);
          localb.XFA.setThumbBmp(paramList);
          if (paramInt3 <= 3) {
            break label685;
          }
          localb.XFA.clear();
          localb.XFB.setVisibility(0);
        }
        for (;;)
        {
          a(localb, localw);
          paraml.XFv.put(Long.valueOf(localw.mga), localb);
          break;
          paramList = LayoutInflater.from(paraml.mContainer.getContext()).inflate(R.i.eiD, paraml.mContainer, false);
          paraml.mContainer.addView(paramList);
          Log.d("MicroMsg.MassSightBanner", "%s: new view(%d/%d, hashCode %d) with massSendId %d", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramList.hashCode()), Long.valueOf(localw.mga) });
          break label192;
          Log.d("MicroMsg.MassSightBanner", "ashutest::mass send id match! %d, totalCount %d", new Object[] { Long.valueOf(localb.XFx), Integer.valueOf(paramInt3) });
          break label442;
          localb.XFA.f(str1, false, 0);
          localb.XFB.setVisibility(8);
        }
        AppMethodBeat.o(38818);
        return paramInt1;
      }
    }
    
    public static void a(l.b paramb, w paramw)
    {
      boolean bool = true;
      AppMethodBeat.i(38819);
      Log.v("MicroMsg.MassSightBanner", "info status %d", new Object[] { Integer.valueOf(paramw.status) });
      if ((paramw.status == 198) || (paramw.status == 197) || (paramw.status == 196))
      {
        paramb.njo.setVisibility(4);
        paramb.XFC.setVisibility(0);
        paramb.XFD.setEnabled(true);
        paramb.XFy = true;
        AppMethodBeat.o(38819);
        return;
      }
      float f = paramw.mgq / paramw.lAW;
      paramb.njo.setVisibility(0);
      paramb.XFC.setVisibility(4);
      paramb.njo.setProgress((int)(paramb.njo.getMax() * f));
      paramw = paramb.XFD;
      if (Float.compare(0.99F, f) > 0) {}
      for (;;)
      {
        paramw.setEnabled(bool);
        paramb.XFy = false;
        AppMethodBeat.o(38819);
        return;
        bool = false;
      }
    }
    
    public final void run()
    {
      AppMethodBeat.i(38820);
      l locall = (l)this.XFw.get();
      if (locall == null)
      {
        Log.w("MicroMsg.MassSightBanner", "try to refresh, but banner ref is null");
        AppMethodBeat.o(38820);
        return;
      }
      int k = locall.mContainer.getChildCount();
      locall.XFv.clear();
      HashSet localHashSet = new HashSet();
      Iterator localIterator = this.XFF.iterator();
      while (localIterator.hasNext()) {
        localHashSet.add(Long.valueOf(((w)localIterator.next()).mga));
      }
      localIterator = this.XFG.iterator();
      while (localIterator.hasNext()) {
        localHashSet.add(Long.valueOf(((w)localIterator.next()).mga));
      }
      int i = localHashSet.size();
      int j = a("update unfinish", locall, this.XFF, 0, k, i);
      j = a("update fail", locall, this.XFG, j, k, i);
      i = j;
      while (i < k)
      {
        locall.mContainer.removeViewAt(j);
        i += 1;
      }
      AppMethodBeat.o(38820);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.a.l
 * JD-Core Version:    0.7.0.1
 */