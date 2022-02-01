package com.tencent.mm.plugin.music.model;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aw.a.a.c.a;
import com.tencent.mm.aw.a.c.h;
import com.tencent.mm.aw.i;
import com.tencent.mm.aw.q;
import com.tencent.mm.plugin.sns.b.o;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.protocal.protobuf.byn;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.storage.bj;
import com.tencent.mm.ui.al;

public final class d
{
  public com.tencent.mm.b.f<String, Bitmap> fGf;
  public a wkO;
  private h wkP;
  public ap wkQ;
  
  public d()
  {
    AppMethodBeat.i(63011);
    this.wkP = new h()
    {
      public final Bitmap a(String paramAnonymousString, View paramAnonymousView, com.tencent.mm.aw.a.d.b paramAnonymousb)
      {
        return null;
      }
      
      public final void b(String paramAnonymousString, View paramAnonymousView) {}
      
      public final void b(final String paramAnonymousString, final View paramAnonymousView, com.tencent.mm.aw.a.d.b paramAnonymousb)
      {
        AppMethodBeat.i(63009);
        if (paramAnonymousb.bitmap != null) {}
        for (boolean bool = true;; bool = false)
        {
          ad.i("MicroMsg.Music.MusicImageLoader", "onImageLoadFinish %s %b", new Object[] { paramAnonymousString, Boolean.valueOf(bool) });
          paramAnonymousString = (com.tencent.mm.plugin.music.model.e.a)paramAnonymousView.getTag();
          if ((paramAnonymousb.bitmap != null) && (paramAnonymousString != null))
          {
            d.this.a(paramAnonymousString, paramAnonymousb.bitmap);
            paramAnonymousView = al.aG(paramAnonymousb.bitmap);
            if (!paramAnonymousString.B(paramAnonymousView)) {
              f.dtf().as(paramAnonymousString.field_musicId, paramAnonymousView[0], paramAnonymousView[1]);
            }
            if (d.this.wkO != null) {
              aq.f(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(63008);
                  d.this.wkO.a(paramAnonymousString, paramAnonymousView);
                  AppMethodBeat.o(63008);
                }
              });
            }
          }
          AppMethodBeat.o(63009);
          return;
        }
      }
    };
    this.wkQ = new ap(Looper.getMainLooper());
    this.fGf = new com.tencent.mm.memory.a.b(5, getClass());
    AppMethodBeat.o(63011);
  }
  
  final void a(com.tencent.mm.plugin.music.model.e.a parama, Bitmap paramBitmap)
  {
    AppMethodBeat.i(63013);
    ad.i("MicroMsg.Music.MusicImageLoader", "putBitmapToCache %s", new Object[] { parama.field_musicId });
    this.fGf.put(parama.field_musicId, paramBitmap);
    AppMethodBeat.o(63013);
  }
  
  public final void a(com.tencent.mm.plugin.music.model.e.a parama, CdnImageView paramCdnImageView, Context paramContext, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(63012);
    if (paramBoolean1) {
      this.fGf.remove(parama.field_musicId);
    }
    Object localObject1 = (Bitmap)this.fGf.get(parama.field_musicId);
    if ((localObject1 != null) && (!((Bitmap)localObject1).isRecycled()))
    {
      ad.i("MicroMsg.Music.MusicImageLoader", "hit cache %s", new Object[] { parama.field_musicId });
      paramCdnImageView.setImageBitmap((Bitmap)localObject1);
      if (parama.dtp())
      {
        paramCdnImageView = new int[2];
        paramCdnImageView[0] = parama.field_songBgColor;
        paramCdnImageView[1] = parama.field_songLyricColor;
      }
      for (;;)
      {
        if (this.wkO != null) {
          this.wkO.a(parama, paramCdnImageView);
        }
        AppMethodBeat.o(63012);
        return;
        paramCdnImageView = al.aG((Bitmap)localObject1);
      }
    }
    localObject1 = null;
    Object localObject2 = null;
    ad.i("MicroMsg.Music.MusicImageLoader", "no hit cache %s %s %s %s", new Object[] { parama.field_musicId, parama.field_songHAlbumUrl, parama.field_songAlbumUrl, parama.field_songAlbumLocalPath });
    paramCdnImageView.setTag(parama);
    if (parama.dtq())
    {
      paramContext = new c.a();
      paramContext.hdP = com.tencent.mm.plugin.music.h.b.bB(parama.field_musicId, true);
      paramContext.idr = true;
      paramContext.idp = true;
      paramContext.idD = 2131231880;
      if (paramBoolean2)
      {
        paramContext.idy = true;
        paramContext.idz = 10;
      }
      q.aIJ().a(parama.field_songHAlbumUrl, paramCdnImageView, paramContext.aJc(), this.wkP);
      localObject1 = localObject2;
    }
    for (;;)
    {
      if ((localObject1 != null) && (!((Bitmap)localObject1).isRecycled()))
      {
        a(parama, (Bitmap)localObject1);
        paramCdnImageView.setImageBitmap((Bitmap)localObject1);
        paramContext = al.aG((Bitmap)localObject1);
        paramCdnImageView = parama;
        if (!parama.B(paramContext)) {
          paramCdnImageView = f.dtf().as(parama.field_musicId, paramContext[0], paramContext[1]);
        }
        if ((this.wkO != null) && (paramCdnImageView != null)) {
          this.wkO.a(paramCdnImageView, paramContext);
        }
      }
      AppMethodBeat.o(63012);
      return;
      switch (parama.field_musicType)
      {
      case 2: 
      case 3: 
      default: 
        localObject1 = localObject2;
        break;
      case 0: 
      case 5: 
      case 7: 
      case 10: 
      case 11: 
      case 4: 
      case 6: 
        for (;;)
        {
          localObject2 = localObject1;
          if (localObject1 == null) {
            localObject2 = q.aIF().a(parama.field_songAlbumLocalPath, com.tencent.mm.cc.a.getDensity(paramContext), false);
          }
          if (localObject2 == null) {
            break label566;
          }
          localObject1 = com.tencent.mm.sdk.platformtools.g.l((Bitmap)localObject2, 10);
          break;
          paramContext = new c.a();
          paramContext.hdP = com.tencent.mm.plugin.music.h.b.bB(parama.field_musicId, false);
          paramContext.idr = true;
          paramContext.idp = true;
          if (paramBoolean2)
          {
            paramContext.idy = true;
            paramContext.idz = 10;
          }
          q.aIJ().a(parama.field_songAlbumUrl, paramCdnImageView, paramContext.aJc(), this.wkP);
          localObject1 = localObject2;
          break;
          localObject1 = q.aIF().b(parama.field_songAlbumLocalPath, com.tencent.mm.cc.a.getDensity(paramContext), false);
        }
        paramCdnImageView.setImageResource(2131231880);
        if ((!parama.dtp()) && (this.wkO != null)) {
          this.wkO.a(parama, new int[] { -16777216, -1 });
        }
        ad.i("MicroMsg.Music.MusicImageLoader", "field_songAlbumUrl:%s", new Object[] { parama.field_songAlbumUrl });
        localObject1 = localObject2;
        if (!TextUtils.isEmpty(parama.field_songAlbumUrl))
        {
          paramContext = new c.a();
          paramContext.hdP = com.tencent.mm.plugin.music.h.b.bB(parama.field_musicId, true);
          paramContext.idr = true;
          paramContext.idp = true;
          if (paramBoolean2)
          {
            paramContext.idy = true;
            paramContext.idz = 10;
          }
          q.aIJ().a(parama.field_songAlbumUrl, paramCdnImageView, paramContext.aJc(), this.wkP);
          localObject1 = localObject2;
        }
        break;
      case 1: 
      case 8: 
      case 9: 
        label566:
        byn localbyn = new byn();
        localbyn.Id = parama.field_songMediaId;
        localbyn.GSI = parama.field_songAlbumUrl;
        localbyn.GSJ = parama.field_songAlbumType;
        localbyn.Url = localbyn.GSI;
        localObject1 = localObject2;
        if (o.zbS != null)
        {
          localObject1 = o.zbS.a(localbyn);
          if (localObject1 != null)
          {
            localObject1 = com.tencent.mm.sdk.platformtools.g.l((Bitmap)localObject1, 10);
          }
          else
          {
            paramCdnImageView.setImageResource(2131231880);
            if ((!parama.dtp()) && (this.wkO != null)) {
              this.wkO.a(parama, new int[] { -16777216, -1 });
            }
            o.zbS.eR(paramCdnImageView);
            o.zbS.a(localbyn, paramCdnImageView, paramContext.hashCode(), bj.ILV);
            this.wkQ.removeCallbacksAndMessages(null);
            this.wkQ.postDelayed(new b(parama), 1000L);
          }
        }
        break;
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract void a(com.tencent.mm.plugin.music.model.e.a parama, int[] paramArrayOfInt);
  }
  
  final class b
    implements Runnable
  {
    com.tencent.mm.plugin.music.model.e.a wkU;
    
    b(com.tencent.mm.plugin.music.model.e.a parama)
    {
      this.wkU = parama;
    }
    
    public final void run()
    {
      AppMethodBeat.i(63010);
      Object localObject = new byn();
      ((byn)localObject).Id = this.wkU.field_songMediaId;
      ((byn)localObject).GSI = this.wkU.field_songAlbumUrl;
      ((byn)localObject).GSJ = this.wkU.field_songAlbumType;
      ((byn)localObject).Url = ((byn)localObject).GSI;
      localObject = o.zbS.a((byn)localObject);
      if (localObject != null)
      {
        localObject = com.tencent.mm.sdk.platformtools.g.l((Bitmap)localObject, 10);
        d.this.a(this.wkU, (Bitmap)localObject);
        localObject = al.aG((Bitmap)localObject);
        if (!this.wkU.B((int[])localObject)) {
          this.wkU = f.dtf().as(this.wkU.field_musicId, localObject[0], localObject[1]);
        }
        if ((d.this.wkO != null) && (this.wkU != null)) {
          d.this.wkO.a(this.wkU, (int[])localObject);
        }
      }
      AppMethodBeat.o(63010);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.music.model.d
 * JD-Core Version:    0.7.0.1
 */