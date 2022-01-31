package com.tencent.mm.ui.conversation.a;

import android.content.Context;
import android.os.Looper;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.tencent.mm.R.i;
import com.tencent.mm.model.au;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.modelvideo.t.a;
import com.tencent.mm.modelvideo.t.a.a;
import com.tencent.mm.modelvideo.u;
import com.tencent.mm.pluginsdk.ui.b.b;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

public final class l
  extends b
  implements t.a
{
  ViewGroup mContainer;
  Map<String, Long> vUQ = new HashMap();
  Map<Long, l.b> vUR = new HashMap();
  
  public l(Context paramContext)
  {
    super(paramContext);
    o.Sr().a(this, Looper.getMainLooper());
    this.mContainer = ((ViewGroup)this.view);
  }
  
  private void apa()
  {
    y.i("MicroMsg.MassSightBanner", "call update status");
    l.a locala = new l.a((byte)0);
    locala.vUS = new WeakReference(this);
    au.DS().O(locala);
  }
  
  public final void a(t.a.a parama)
  {
    parama = parama.fileName;
    Long localLong = (Long)this.vUQ.get(parama);
    if (localLong == null)
    {
      y.d("MicroMsg.MassSightBanner", "massSendId is null, fileName %s", new Object[] { parama });
      if (bk.aM(parama, "").startsWith("DELETE_")) {
        apa();
      }
      return;
    }
    l.b localb = (l.b)this.vUR.get(localLong);
    if (localb == null)
    {
      y.d("MicroMsg.MassSightBanner", "find massSendId %d, but holder is null", new Object[] { localLong });
      return;
    }
    s locals = u.oe(parama);
    if (locals == null)
    {
      y.w("MicroMsg.MassSightBanner", "on nofify changed, filename %s, massSendId %d, but videoinfo is null", new Object[] { parama, localLong });
      return;
    }
    if (locals.status == 199)
    {
      y.i("MicroMsg.MassSightBanner", "fileName %s, massSendId %d, done", new Object[] { parama, localLong });
      apa();
      return;
    }
    l.c.a(localb, locals);
  }
  
  public final void destroy()
  {
    o.Sr().a(this);
  }
  
  public final int getLayoutId()
  {
    return R.i.mass_send_sight_banner;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.a.l
 * JD-Core Version:    0.7.0.1
 */