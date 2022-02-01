package com.tencent.mm.plugin.music.model;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aw.a.a.c.a;
import com.tencent.mm.aw.a.c.h;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.protocal.protobuf.bpi;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.storage.bc;
import com.tencent.mm.ui.ai;

public final class d
{
  public com.tencent.mm.b.f<String, Bitmap> fkD;
  public a tWI;
  private h tWJ;
  public ap tWK;
  
  public d()
  {
    AppMethodBeat.i(63011);
    this.tWJ = new h()
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
            paramAnonymousView = ai.aC(paramAnonymousb.bitmap);
            if (!paramAnonymousString.B(paramAnonymousView)) {
              f.cVn().ap(paramAnonymousString.field_musicId, paramAnonymousView[0], paramAnonymousView[1]);
            }
            if (d.this.tWI != null) {
              aq.f(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(63008);
                  d.this.tWI.a(paramAnonymousString, paramAnonymousView);
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
    this.tWK = new ap(Looper.getMainLooper());
    this.fkD = new com.tencent.mm.memory.a.b(5, getClass());
    AppMethodBeat.o(63011);
  }
  
  final void a(com.tencent.mm.plugin.music.model.e.a parama, Bitmap paramBitmap)
  {
    AppMethodBeat.i(63013);
    ad.i("MicroMsg.Music.MusicImageLoader", "putBitmapToCache %s", new Object[] { parama.field_musicId });
    this.fkD.put(parama.field_musicId, paramBitmap);
    AppMethodBeat.o(63013);
  }
  
  public final void a(com.tencent.mm.plugin.music.model.e.a parama, CdnImageView paramCdnImageView, Context paramContext, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(63012);
    if (paramBoolean1) {
      this.fkD.remove(parama.field_musicId);
    }
    Object localObject1 = (Bitmap)this.fkD.get(parama.field_musicId);
    if ((localObject1 != null) && (!((Bitmap)localObject1).isRecycled()))
    {
      ad.i("MicroMsg.Music.MusicImageLoader", "hit cache %s", new Object[] { parama.field_musicId });
      paramCdnImageView.setImageBitmap((Bitmap)localObject1);
      if (parama.cVx())
      {
        paramCdnImageView = new int[2];
        paramCdnImageView[0] = parama.field_songBgColor;
        paramCdnImageView[1] = parama.field_songLyricColor;
      }
      for (;;)
      {
        if (this.tWI != null) {
          this.tWI.a(parama, paramCdnImageView);
        }
        AppMethodBeat.o(63012);
        return;
        paramCdnImageView = ai.aC((Bitmap)localObject1);
      }
    }
    localObject1 = null;
    Object localObject2 = null;
    ad.i("MicroMsg.Music.MusicImageLoader", "no hit cache %s %s %s %s", new Object[] { parama.field_musicId, parama.field_songHAlbumUrl, parama.field_songAlbumUrl, parama.field_songAlbumLocalPath });
    paramCdnImageView.setTag(parama);
    if (parama.cVy())
    {
      paramContext = new c.a();
      paramContext.gjt = com.tencent.mm.plugin.music.h.b.bn(parama.field_musicId, true);
      paramContext.hjU = true;
      paramContext.hjS = true;
      paramContext.hkf = 2131231880;
      if (paramBoolean2)
      {
        paramContext.hka = true;
        paramContext.hkb = 10;
      }
      com.tencent.mm.aw.o.ayJ().a(parama.field_songHAlbumUrl, paramCdnImageView, paramContext.azc(), this.tWJ);
      localObject1 = localObject2;
    }
    for (;;)
    {
      if ((localObject1 != null) && (!((Bitmap)localObject1).isRecycled()))
      {
        a(parama, (Bitmap)localObject1);
        paramCdnImageView.setImageBitmap((Bitmap)localObject1);
        paramContext = ai.aC((Bitmap)localObject1);
        paramCdnImageView = parama;
        if (!parama.B(paramContext)) {
          paramCdnImageView = f.cVn().ap(parama.field_musicId, paramContext[0], paramContext[1]);
        }
        if ((this.tWI != null) && (paramCdnImageView != null)) {
          this.tWI.a(paramCdnImageView, paramContext);
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
            localObject2 = com.tencent.mm.aw.o.ayF().a(parama.field_songAlbumLocalPath, com.tencent.mm.cd.a.getDensity(paramContext), false);
          }
          if (localObject2 == null) {
            break label566;
          }
          localObject1 = com.tencent.mm.sdk.platformtools.f.l((Bitmap)localObject2, 10);
          break;
          paramContext = new c.a();
          paramContext.gjt = com.tencent.mm.plugin.music.h.b.bn(parama.field_musicId, false);
          paramContext.hjU = true;
          paramContext.hjS = true;
          if (paramBoolean2)
          {
            paramContext.hka = true;
            paramContext.hkb = 10;
          }
          com.tencent.mm.aw.o.ayJ().a(parama.field_songAlbumUrl, paramCdnImageView, paramContext.azc(), this.tWJ);
          localObject1 = localObject2;
          break;
          localObject1 = com.tencent.mm.aw.o.ayF().b(parama.field_songAlbumLocalPath, com.tencent.mm.cd.a.getDensity(paramContext), false);
        }
        paramCdnImageView.setImageResource(2131231880);
        if ((!parama.cVx()) && (this.tWI != null)) {
          this.tWI.a(parama, new int[] { -16777216, -1 });
        }
        ad.i("MicroMsg.Music.MusicImageLoader", "field_songAlbumUrl:%s", new Object[] { parama.field_songAlbumUrl });
        localObject1 = localObject2;
        if (!TextUtils.isEmpty(parama.field_songAlbumUrl))
        {
          paramContext = new c.a();
          paramContext.gjt = com.tencent.mm.plugin.music.h.b.bn(parama.field_musicId, true);
          paramContext.hjU = true;
          paramContext.hjS = true;
          if (paramBoolean2)
          {
            paramContext.hka = true;
            paramContext.hkb = 10;
          }
          com.tencent.mm.aw.o.ayJ().a(parama.field_songAlbumUrl, paramCdnImageView, paramContext.azc(), this.tWJ);
          localObject1 = localObject2;
        }
        break;
      case 1: 
      case 8: 
      case 9: 
        label566:
        bpi localbpi = new bpi();
        localbpi.Id = parama.field_songMediaId;
        localbpi.DMQ = parama.field_songAlbumUrl;
        localbpi.DMR = parama.field_songAlbumType;
        localbpi.Url = localbpi.DMQ;
        localObject1 = localObject2;
        if (com.tencent.mm.plugin.sns.c.o.wzG != null)
        {
          localObject1 = com.tencent.mm.plugin.sns.c.o.wzG.a(localbpi);
          if (localObject1 != null)
          {
            localObject1 = com.tencent.mm.sdk.platformtools.f.l((Bitmap)localObject1, 10);
          }
          else
          {
            paramCdnImageView.setImageResource(2131231880);
            if ((!parama.cVx()) && (this.tWI != null)) {
              this.tWI.a(parama, new int[] { -16777216, -1 });
            }
            com.tencent.mm.plugin.sns.c.o.wzG.eo(paramCdnImageView);
            com.tencent.mm.plugin.sns.c.o.wzG.a(localbpi, paramCdnImageView, paramContext.hashCode(), bc.FzF);
            this.tWK.removeCallbacksAndMessages(null);
            this.tWK.postDelayed(new b(parama), 1000L);
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
    com.tencent.mm.plugin.music.model.e.a tWO;
    
    b(com.tencent.mm.plugin.music.model.e.a parama)
    {
      this.tWO = parama;
    }
    
    public final void run()
    {
      AppMethodBeat.i(63010);
      Object localObject = new bpi();
      ((bpi)localObject).Id = this.tWO.field_songMediaId;
      ((bpi)localObject).DMQ = this.tWO.field_songAlbumUrl;
      ((bpi)localObject).DMR = this.tWO.field_songAlbumType;
      ((bpi)localObject).Url = ((bpi)localObject).DMQ;
      localObject = com.tencent.mm.plugin.sns.c.o.wzG.a((bpi)localObject);
      if (localObject != null)
      {
        localObject = com.tencent.mm.sdk.platformtools.f.l((Bitmap)localObject, 10);
        d.this.a(this.tWO, (Bitmap)localObject);
        localObject = ai.aC((Bitmap)localObject);
        if (!this.tWO.B((int[])localObject)) {
          this.tWO = f.cVn().ap(this.tWO.field_musicId, localObject[0], localObject[1]);
        }
        if ((d.this.tWI != null) && (this.tWO != null)) {
          d.this.tWI.a(this.tWO, (int[])localObject);
        }
      }
      AppMethodBeat.o(63010);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.music.model.d
 * JD-Core Version:    0.7.0.1
 */