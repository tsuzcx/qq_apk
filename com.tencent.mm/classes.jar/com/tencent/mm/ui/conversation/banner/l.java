package com.tencent.mm.ui.conversation.banner;

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
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.bh;
import com.tencent.mm.modelimage.j;
import com.tencent.mm.modelimage.r;
import com.tencent.mm.modelvideo.aa;
import com.tencent.mm.modelvideo.aa.a;
import com.tencent.mm.modelvideo.aa.a.a;
import com.tencent.mm.modelvideo.ab;
import com.tencent.mm.modelvideo.t.5;
import com.tencent.mm.modelvideo.v;
import com.tencent.mm.modelvideo.z;
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
  extends com.tencent.mm.pluginsdk.ui.a.b
  implements aa.a
{
  Map<String, Long> afts;
  Map<Long, b> aftt;
  ViewGroup mContainer;
  
  public l(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(38821);
    this.afts = new HashMap();
    this.aftt = new HashMap();
    v.bOh().a(this, Looper.getMainLooper());
    this.mContainer = ((ViewGroup)this.view);
    AppMethodBeat.o(38821);
  }
  
  private void updateStatus()
  {
    AppMethodBeat.i(38823);
    Log.i("MicroMsg.MassSightBanner", "call update status");
    a locala = new a((byte)0);
    locala.aftu = new WeakReference(this);
    bh.baH().postToWorker(locala);
    AppMethodBeat.o(38823);
  }
  
  public final void a(aa.a.a parama)
  {
    AppMethodBeat.i(38824);
    parama = parama.fileName;
    Long localLong = (Long)this.afts.get(parama);
    if (localLong == null)
    {
      Log.d("MicroMsg.MassSightBanner", "massSendId is null, fileName %s", new Object[] { parama });
      if (Util.nullAs(parama, "").startsWith("DELETE_")) {
        updateStatus();
      }
      AppMethodBeat.o(38824);
      return;
    }
    b localb = (b)this.aftt.get(localLong);
    if (localb == null)
    {
      Log.d("MicroMsg.MassSightBanner", "find massSendId %d, but holder is null", new Object[] { localLong });
      AppMethodBeat.o(38824);
      return;
    }
    z localz = ab.Qo(parama);
    if (localz == null)
    {
      Log.w("MicroMsg.MassSightBanner", "on nofify changed, filename %s, massSendId %d, but videoinfo is null", new Object[] { parama, localLong });
      AppMethodBeat.o(38824);
      return;
    }
    if (localz.status == 199)
    {
      Log.i("MicroMsg.MassSightBanner", "fileName %s, massSendId %d, done", new Object[] { parama, localLong });
      updateStatus();
      AppMethodBeat.o(38824);
      return;
    }
    c.a(localb, localz);
    AppMethodBeat.o(38824);
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(38822);
    v.bOh().a(this);
    AppMethodBeat.o(38822);
  }
  
  public final int getLayoutId()
  {
    return R.i.glB;
  }
  
  static final class a
    implements Runnable
  {
    WeakReference<l> aftu;
    
    public final void run()
    {
      AppMethodBeat.i(38815);
      List localList1 = v.bOh().bOB();
      List localList2 = v.bOh().bOC();
      Object localObject = (l)this.aftu.get();
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
      ((l.c)localObject).aftu = new WeakReference((l)this.aftu.get());
      ((l.c)localObject).aftD = localList1;
      ((l.c)localObject).aftE = localList2;
      MMHandlerThread.postToMainThread((Runnable)localObject);
      AppMethodBeat.o(38815);
    }
  }
  
  static final class b
  {
    TextView aftA = null;
    ImageButton aftB = null;
    long aftv = 0L;
    boolean aftw = false;
    View aftx = null;
    com.tencent.mm.plugin.sight.decode.model.a afty = null;
    ImageView aftz = null;
    ProgressBar qgC = null;
  }
  
  static final class c
    implements Runnable
  {
    List<z> aftD;
    List<z> aftE;
    WeakReference<l> aftu;
    
    private static int a(String paramString, l paraml, List<z> paramList, int paramInt1, int paramInt2, int paramInt3)
    {
      AppMethodBeat.i(38818);
      Iterator localIterator = paramList.iterator();
      z localz;
      label192:
      l.b localb;
      for (;;)
      {
        if (localIterator.hasNext())
        {
          localz = (z)localIterator.next();
          paraml.afts.put(localz.getFileName(), Long.valueOf(localz.oYW));
          if (paraml.aftt.containsKey(Long.valueOf(localz.oYW)))
          {
            Log.d("MicroMsg.MassSightBanner", "%s: has contains massSendId %d, file %s", new Object[] { paramString, Long.valueOf(localz.oYW), localz.getFileName() });
          }
          else if (paramInt1 < paramInt2)
          {
            paramList = paraml.mContainer;
            int i = paramInt1 + 1;
            paramList = paramList.getChildAt(paramInt1);
            Log.d("MicroMsg.MassSightBanner", "%s: refresh view(%d/%d, hashCode %d) with massSendId %d", new Object[] { paramString, Integer.valueOf(i), Integer.valueOf(paramInt2), Integer.valueOf(paramList.hashCode()), Long.valueOf(localz.oYW) });
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
        if (localb.aftv != localz.oYW)
        {
          Log.d("MicroMsg.MassSightBanner", "ashutest::mass send id not match! %d -> %d, totalCount %d", new Object[] { Long.valueOf(localb.aftv), Long.valueOf(localz.oYW), Integer.valueOf(paramInt3) });
          localb.aftv = localz.oYW;
          localb.aftx = paramList;
          localb.afty = ((com.tencent.mm.plugin.sight.decode.model.a)paramList.findViewById(R.h.image_view));
          localb.aftz = ((ImageView)paramList.findViewById(R.h.fYe));
          localb.qgC = ((ProgressBar)paramList.findViewById(R.h.progress));
          localb.aftB = ((ImageButton)paramList.findViewById(R.h.cancel_btn));
          localb.aftA = ((TextView)paramList.findViewById(R.h.info_tv));
          localb.afty.setDrawableWidth(paramList.getResources().getDimensionPixelSize(R.f.NormalAvatarSize));
          localb.aftx.setTag(localb);
          localb.aftB.setTag(Long.valueOf(localb.aftv));
          localb.aftx.setOnClickListener(new l.b.1(localb));
          localb.aftB.setOnClickListener(new l.b.2(localb));
          v.bOh();
          str1 = aa.PX(localz.getFileName());
          v.bOh();
          String str2 = aa.PY(localz.getFileName());
          j localj = r.bKa();
          float f = com.tencent.mm.cd.a.getDensity(paramList.getContext());
          paramList.getContext();
          paramList = localj.a(str2, f, -1);
          localb.afty.setThumbBmp(paramList);
          if (paramInt3 <= 3) {
            break label685;
          }
          localb.afty.clear();
          localb.aftz.setVisibility(0);
        }
        for (;;)
        {
          a(localb, localz);
          paraml.aftt.put(Long.valueOf(localz.oYW), localb);
          break;
          paramList = LayoutInflater.from(paraml.mContainer.getContext()).inflate(R.i.glC, paraml.mContainer, false);
          paraml.mContainer.addView(paramList);
          Log.d("MicroMsg.MassSightBanner", "%s: new view(%d/%d, hashCode %d) with massSendId %d", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramList.hashCode()), Long.valueOf(localz.oYW) });
          break label192;
          Log.d("MicroMsg.MassSightBanner", "ashutest::mass send id match! %d, totalCount %d", new Object[] { Long.valueOf(localb.aftv), Integer.valueOf(paramInt3) });
          break label442;
          localb.afty.e(str1, false, 0);
          localb.aftz.setVisibility(8);
        }
        AppMethodBeat.o(38818);
        return paramInt1;
      }
    }
    
    public static void a(l.b paramb, z paramz)
    {
      boolean bool = true;
      AppMethodBeat.i(38819);
      Log.v("MicroMsg.MassSightBanner", "info status %d", new Object[] { Integer.valueOf(paramz.status) });
      if ((paramz.status == 198) || (paramz.status == 197) || (paramz.status == 196))
      {
        paramb.qgC.setVisibility(4);
        paramb.aftA.setVisibility(0);
        paramb.aftB.setEnabled(true);
        paramb.aftw = true;
        AppMethodBeat.o(38819);
        return;
      }
      float f = paramz.oZm / paramz.osy;
      paramb.qgC.setVisibility(0);
      paramb.aftA.setVisibility(4);
      paramb.qgC.setProgress((int)(paramb.qgC.getMax() * f));
      paramz = paramb.aftB;
      if (Float.compare(0.99F, f) > 0) {}
      for (;;)
      {
        paramz.setEnabled(bool);
        paramb.aftw = false;
        AppMethodBeat.o(38819);
        return;
        bool = false;
      }
    }
    
    public final void run()
    {
      AppMethodBeat.i(38820);
      l locall = (l)this.aftu.get();
      if (locall == null)
      {
        Log.w("MicroMsg.MassSightBanner", "try to refresh, but banner ref is null");
        AppMethodBeat.o(38820);
        return;
      }
      int k = locall.mContainer.getChildCount();
      locall.aftt.clear();
      HashSet localHashSet = new HashSet();
      Iterator localIterator = this.aftD.iterator();
      while (localIterator.hasNext()) {
        localHashSet.add(Long.valueOf(((z)localIterator.next()).oYW));
      }
      localIterator = this.aftE.iterator();
      while (localIterator.hasNext()) {
        localHashSet.add(Long.valueOf(((z)localIterator.next()).oYW));
      }
      int i = localHashSet.size();
      int j = a("update unfinish", locall, this.aftD, 0, k, i);
      j = a("update fail", locall, this.aftE, j, k, i);
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
 * Qualified Name:     com.tencent.mm.ui.conversation.banner.l
 * JD-Core Version:    0.7.0.1
 */