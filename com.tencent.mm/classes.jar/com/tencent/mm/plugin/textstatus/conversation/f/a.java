package com.tencent.mm.plugin.textstatus.conversation.f;

import android.graphics.Bitmap;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.d;
import com.tencent.mm.modelavatar.AvatarStorage.a;
import com.tencent.mm.plugin.finder.loader.p;
import com.tencent.mm.plugin.finder.loader.p.a;
import com.tencent.mm.plugin.finder.loader.r;
import com.tencent.mm.plugin.finder.storage.v;
import com.tencent.mm.plugin.textstatus.h.f.h;
import com.tencent.mm.pluginsdk.ui.j;
import com.tencent.mm.pluginsdk.ui.j.a;
import com.tencent.mm.pluginsdk.ui.j.b;
import com.tencent.mm.pluginsdk.ui.j.c;
import com.tencent.mm.storage.au;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public final class a
  implements j.a, j.b
{
  final List<WeakReference<AvatarStorage.a>> Exg;
  private final j.a Exh;
  
  public a(j.a parama)
  {
    AppMethodBeat.i(291025);
    this.Exg = new ArrayList();
    this.Exh = parama;
    AppMethodBeat.o(291025);
  }
  
  private static Pair<String, Boolean> bdI(String paramString)
  {
    AppMethodBeat.i(291029);
    if (au.bwY(paramString))
    {
      paramString = new Pair(paramString, Boolean.TRUE);
      AppMethodBeat.o(291029);
      return paramString;
    }
    paramString = new Pair(paramString, Boolean.FALSE);
    AppMethodBeat.o(291029);
    return paramString;
  }
  
  public final void a(final j paramj)
  {
    AppMethodBeat.i(291054);
    if ((paramj instanceof AvatarStorage.a))
    {
      Object localObject = bdI(paramj.getTag());
      boolean bool = ((Boolean)((Pair)localObject).second).booleanValue();
      localObject = (String)((Pair)localObject).first;
      if (bool)
      {
        paramj = (AvatarStorage.a)paramj;
        this.Exg.add(new WeakReference(paramj));
        AppMethodBeat.o(291054);
        return;
      }
      paramj.XYW = new j.c()
      {
        public final boolean ayJ(String paramAnonymousString)
        {
          AppMethodBeat.i(291009);
          if (this.mae.equals(paramAnonymousString))
          {
            paramj.iKl();
            paramj.XYW = null;
          }
          AppMethodBeat.o(291009);
          return true;
        }
      };
      this.Exh.a(paramj);
    }
    AppMethodBeat.o(291054);
  }
  
  public final Bitmap aCj()
  {
    AppMethodBeat.i(291048);
    Bitmap localBitmap = this.Exh.aCj();
    AppMethodBeat.o(291048);
    return localBitmap;
  }
  
  public final boolean ayI(String paramString)
  {
    AppMethodBeat.i(291062);
    if (!au.bwY(paramString))
    {
      AppMethodBeat.o(291062);
      return true;
    }
    AppMethodBeat.o(291062);
    return false;
  }
  
  public final Bitmap b(final String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(291035);
    Object localObject1 = bdI(paramString);
    Object localObject2 = (String)((Pair)localObject1).first;
    if (((Boolean)((Pair)localObject1).second).booleanValue())
    {
      localObject1 = com.tencent.mm.plugin.textstatus.conversation.g.a.Tjq;
      localObject1 = com.tencent.mm.plugin.textstatus.conversation.g.a.bdK(paramString);
      if (localObject1 != null)
      {
        localObject1 = ((h)localObject1).field_smallHeadImgUrl;
        localObject2 = p.ExI;
        localObject2 = p.a(p.a.ExO);
        p localp = p.ExI;
        localObject1 = p.eCq().dk(new com.tencent.mm.plugin.finder.loader.b((String)localObject1, v.FLF));
        ((com.tencent.mm.loader.a.b)localObject1).a((com.tencent.mm.loader.b.e)localObject2);
        localObject2 = (Bitmap)((com.tencent.mm.loader.a.b)localObject1).bll();
        if ((localObject2 != null) && (!((Bitmap)localObject2).isRecycled()))
        {
          AppMethodBeat.o(291035);
          return localObject2;
        }
        ((com.tencent.mm.loader.a.b)localObject1).a(new com.tencent.mm.loader.e.e() {});
        ((com.tencent.mm.loader.a.b)localObject1).blg();
      }
      AppMethodBeat.o(291035);
      return null;
    }
    paramString = this.Exh.b((String)localObject2, paramInt1, paramInt2, paramInt3);
    AppMethodBeat.o(291035);
    return paramString;
  }
  
  public final Bitmap ik(String paramString)
  {
    AppMethodBeat.i(291043);
    Pair localPair = bdI(paramString);
    if (((Boolean)localPair.second).booleanValue())
    {
      paramString = b(paramString, 0, 0, 0);
      AppMethodBeat.o(291043);
      return paramString;
    }
    paramString = this.Exh.ik((String)localPair.first);
    AppMethodBeat.o(291043);
    return paramString;
  }
  
  public final Bitmap loadBitmap(String paramString)
  {
    AppMethodBeat.i(291037);
    Pair localPair = bdI(paramString);
    if (((Boolean)localPair.second).booleanValue())
    {
      paramString = b(paramString, 0, 0, 0);
      AppMethodBeat.o(291037);
      return paramString;
    }
    paramString = this.Exh.loadBitmap((String)localPair.first);
    AppMethodBeat.o(291037);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.conversation.f.a
 * JD-Core Version:    0.7.0.1
 */