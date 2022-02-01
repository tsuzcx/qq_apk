package com.tencent.mm.plugin.mv.ui.uic;

import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.data.e;
import com.tencent.mm.plugin.finder.storage.data.e.a;
import com.tencent.mm.plugin.finder.upload.r;
import com.tencent.mm.plugin.mv.model.f;
import com.tencent.mm.plugin.mv.ui.a.b;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.a;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"com/tencent/mm/plugin/mv/ui/uic/MusicMvMainUIC$finderPostListener$1", "Lcom/tencent/mm/plugin/finder/upload/IFinderPostListener;", "onPostEnd", "", "localId", "", "isOk", "", "onPostNotify", "onPostOk", "svrID", "onPostStart", "plugin-mv_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class i$d
  implements r
{
  i$d(i parami, AppCompatActivity paramAppCompatActivity) {}
  
  public final void onPostEnd(long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(287610);
    Log.i(this.Mfb.TAG, "onPostEnd " + paramLong + ' ' + paramBoolean);
    Object localObject = this.Mfb.pUj;
    int i;
    if (((ArrayList)localObject).size() > 0)
    {
      i = 1;
      if (i == 0) {
        break label128;
      }
    }
    for (;;)
    {
      if (localObject != null)
      {
        localObject = (b)((ArrayList)localObject).get(0);
        if (localObject != null)
        {
          localObject = ((b)localObject).MaX;
          if (localObject != null)
          {
            i locali = this.Mfb;
            Long localLong = ((f)localObject).LXg;
            if (localLong == null)
            {
              AppMethodBeat.o(287610);
              return;
              i = 0;
              break;
              label128:
              localObject = null;
              continue;
            }
            if ((localLong.longValue() == paramLong) && (!paramBoolean))
            {
              ((f)localObject).LXs = 3;
              d.uiThread((a)new a(locali));
            }
          }
        }
      }
    }
    AppMethodBeat.o(287610);
  }
  
  public final void onPostNotify(long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(287628);
    Log.i(this.Mfb.TAG, "onPostNotify " + paramLong + ' ' + paramBoolean);
    AppMethodBeat.o(287628);
  }
  
  public final void onPostOk(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(287622);
    Object localObject1 = this.Mfb.pUj;
    int i;
    if (((ArrayList)localObject1).size() > 0)
    {
      i = 1;
      if (i == 0) {
        break label90;
      }
      label30:
      if (localObject1 != null) {
        break label96;
      }
      localObject1 = null;
    }
    for (;;)
    {
      if (localObject1 == null) {
        Log.i(this.Mfb.TAG, "onPostOk not found mv " + paramLong1 + ' ' + paramLong2);
      }
      AppMethodBeat.o(287622);
      return;
      i = 0;
      break;
      label90:
      localObject1 = null;
      break label30;
      label96:
      localObject1 = (b)((ArrayList)localObject1).get(0);
      if (localObject1 == null)
      {
        localObject1 = null;
      }
      else
      {
        localObject1 = ((b)localObject1).MaX;
        if (localObject1 != null) {
          break label136;
        }
        localObject1 = null;
      }
    }
    label136:
    i locali = this.Mfb;
    final AppCompatActivity localAppCompatActivity = this.Awh;
    Log.i(locali.TAG, "onPostOk " + paramLong1 + ' ' + paramLong2);
    Object localObject2 = ((f)localObject1).LXg;
    if (localObject2 == null) {
      label193:
      Log.i(locali.TAG, "first item difference local id " + ((f)localObject1).LXg + ' ' + paramLong1);
    }
    for (;;)
    {
      localObject1 = ah.aiuX;
      break;
      if (((Long)localObject2).longValue() != paramLong1) {
        break label193;
      }
      ((f)localObject1).LXs = 4;
      localObject2 = e.FMN;
      localObject2 = e.a.jn(paramLong2);
      if (localObject2 != null)
      {
        ((f)localObject1).LXv = ((FinderItem)localObject2).getFeedObject();
        locali.a(((FinderItem)localObject2).getId(), ((FinderItem)localObject2).getObjectNonceId(), (f)localObject1);
      }
      d.uiThread((a)new b(locali, localAppCompatActivity));
    }
  }
  
  public final void onPostStart(long paramLong)
  {
    AppMethodBeat.i(287605);
    Log.i(this.Mfb.TAG, s.X("onPostStart ", Long.valueOf(paramLong)));
    Object localObject = this.Mfb.pUj;
    int i;
    if (((ArrayList)localObject).size() > 0)
    {
      i = 1;
      if (i == 0) {
        break label109;
      }
    }
    for (;;)
    {
      if (localObject != null)
      {
        localObject = (b)((ArrayList)localObject).get(0);
        if (localObject != null)
        {
          localObject = ((b)localObject).MaX;
          if (localObject != null)
          {
            i locali = this.Mfb;
            Long localLong = ((f)localObject).LXg;
            if (localLong == null)
            {
              AppMethodBeat.o(287605);
              return;
              i = 0;
              break;
              label109:
              localObject = null;
              continue;
            }
            if (localLong.longValue() == paramLong)
            {
              ((f)localObject).LXs = 2;
              d.uiThread((a)new c(locali));
            }
          }
        }
      }
    }
    AppMethodBeat.o(287605);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements a<ah>
  {
    a(i parami)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements a<ah>
  {
    b(i parami, AppCompatActivity paramAppCompatActivity)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements a<ah>
  {
    c(i parami)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.ui.uic.i.d
 * JD-Core Version:    0.7.0.1
 */