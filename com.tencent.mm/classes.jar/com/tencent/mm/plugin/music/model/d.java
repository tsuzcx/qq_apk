package com.tencent.mm.plugin.music.model;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.av.a.a.c.a;
import com.tencent.mm.av.a.c.h;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.protocal.protobuf.btz;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.storage.bf;
import com.tencent.mm.ui.aj;

public final class d
{
  public com.tencent.mm.b.f<String, Bitmap> fnX;
  public a vft;
  private h vfu;
  public ao vfv;
  
  public d()
  {
    AppMethodBeat.i(63011);
    this.vfu = new h()
    {
      public final Bitmap a(String paramAnonymousString, View paramAnonymousView, com.tencent.mm.av.a.d.b paramAnonymousb)
      {
        return null;
      }
      
      public final void b(String paramAnonymousString, View paramAnonymousView) {}
      
      public final void b(final String paramAnonymousString, final View paramAnonymousView, com.tencent.mm.av.a.d.b paramAnonymousb)
      {
        AppMethodBeat.i(63009);
        if (paramAnonymousb.bitmap != null) {}
        for (boolean bool = true;; bool = false)
        {
          ac.i("MicroMsg.Music.MusicImageLoader", "onImageLoadFinish %s %b", new Object[] { paramAnonymousString, Boolean.valueOf(bool) });
          paramAnonymousString = (com.tencent.mm.plugin.music.model.e.a)paramAnonymousView.getTag();
          if ((paramAnonymousb.bitmap != null) && (paramAnonymousString != null))
          {
            d.this.a(paramAnonymousString, paramAnonymousb.bitmap);
            paramAnonymousView = aj.aE(paramAnonymousb.bitmap);
            if (!paramAnonymousString.B(paramAnonymousView)) {
              f.diT().ao(paramAnonymousString.field_musicId, paramAnonymousView[0], paramAnonymousView[1]);
            }
            if (d.this.vft != null) {
              ap.f(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(63008);
                  d.this.vft.a(paramAnonymousString, paramAnonymousView);
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
    this.vfv = new ao(Looper.getMainLooper());
    this.fnX = new com.tencent.mm.memory.a.b(5, getClass());
    AppMethodBeat.o(63011);
  }
  
  final void a(com.tencent.mm.plugin.music.model.e.a parama, Bitmap paramBitmap)
  {
    AppMethodBeat.i(63013);
    ac.i("MicroMsg.Music.MusicImageLoader", "putBitmapToCache %s", new Object[] { parama.field_musicId });
    this.fnX.put(parama.field_musicId, paramBitmap);
    AppMethodBeat.o(63013);
  }
  
  public final void a(com.tencent.mm.plugin.music.model.e.a parama, CdnImageView paramCdnImageView, Context paramContext, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(63012);
    if (paramBoolean1) {
      this.fnX.remove(parama.field_musicId);
    }
    Object localObject1 = (Bitmap)this.fnX.get(parama.field_musicId);
    if ((localObject1 != null) && (!((Bitmap)localObject1).isRecycled()))
    {
      ac.i("MicroMsg.Music.MusicImageLoader", "hit cache %s", new Object[] { parama.field_musicId });
      paramCdnImageView.setImageBitmap((Bitmap)localObject1);
      if (parama.djd())
      {
        paramCdnImageView = new int[2];
        paramCdnImageView[0] = parama.field_songBgColor;
        paramCdnImageView[1] = parama.field_songLyricColor;
      }
      for (;;)
      {
        if (this.vft != null) {
          this.vft.a(parama, paramCdnImageView);
        }
        AppMethodBeat.o(63012);
        return;
        paramCdnImageView = aj.aE((Bitmap)localObject1);
      }
    }
    localObject1 = null;
    Object localObject2 = null;
    ac.i("MicroMsg.Music.MusicImageLoader", "no hit cache %s %s %s %s", new Object[] { parama.field_musicId, parama.field_songHAlbumUrl, parama.field_songAlbumUrl, parama.field_songAlbumLocalPath });
    paramCdnImageView.setTag(parama);
    if (parama.dje())
    {
      paramContext = new c.a();
      paramContext.gKe = com.tencent.mm.plugin.music.h.b.bu(parama.field_musicId, true);
      paramContext.hKx = true;
      paramContext.hKv = true;
      paramContext.hKI = 2131231880;
      if (paramBoolean2)
      {
        paramContext.hKD = true;
        paramContext.hKE = 10;
      }
      com.tencent.mm.av.o.aFB().a(parama.field_songHAlbumUrl, paramCdnImageView, paramContext.aFT(), this.vfu);
      localObject1 = localObject2;
    }
    for (;;)
    {
      if ((localObject1 != null) && (!((Bitmap)localObject1).isRecycled()))
      {
        a(parama, (Bitmap)localObject1);
        paramCdnImageView.setImageBitmap((Bitmap)localObject1);
        paramContext = aj.aE((Bitmap)localObject1);
        paramCdnImageView = parama;
        if (!parama.B(paramContext)) {
          paramCdnImageView = f.diT().ao(parama.field_musicId, paramContext[0], paramContext[1]);
        }
        if ((this.vft != null) && (paramCdnImageView != null)) {
          this.vft.a(paramCdnImageView, paramContext);
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
            localObject2 = com.tencent.mm.av.o.aFx().a(parama.field_songAlbumLocalPath, com.tencent.mm.cc.a.getDensity(paramContext), false);
          }
          if (localObject2 == null) {
            break label566;
          }
          localObject1 = com.tencent.mm.sdk.platformtools.f.l((Bitmap)localObject2, 10);
          break;
          paramContext = new c.a();
          paramContext.gKe = com.tencent.mm.plugin.music.h.b.bu(parama.field_musicId, false);
          paramContext.hKx = true;
          paramContext.hKv = true;
          if (paramBoolean2)
          {
            paramContext.hKD = true;
            paramContext.hKE = 10;
          }
          com.tencent.mm.av.o.aFB().a(parama.field_songAlbumUrl, paramCdnImageView, paramContext.aFT(), this.vfu);
          localObject1 = localObject2;
          break;
          localObject1 = com.tencent.mm.av.o.aFx().b(parama.field_songAlbumLocalPath, com.tencent.mm.cc.a.getDensity(paramContext), false);
        }
        paramCdnImageView.setImageResource(2131231880);
        if ((!parama.djd()) && (this.vft != null)) {
          this.vft.a(parama, new int[] { -16777216, -1 });
        }
        ac.i("MicroMsg.Music.MusicImageLoader", "field_songAlbumUrl:%s", new Object[] { parama.field_songAlbumUrl });
        localObject1 = localObject2;
        if (!TextUtils.isEmpty(parama.field_songAlbumUrl))
        {
          paramContext = new c.a();
          paramContext.gKe = com.tencent.mm.plugin.music.h.b.bu(parama.field_musicId, true);
          paramContext.hKx = true;
          paramContext.hKv = true;
          if (paramBoolean2)
          {
            paramContext.hKD = true;
            paramContext.hKE = 10;
          }
          com.tencent.mm.av.o.aFB().a(parama.field_songAlbumUrl, paramCdnImageView, paramContext.aFT(), this.vfu);
          localObject1 = localObject2;
        }
        break;
      case 1: 
      case 8: 
      case 9: 
        label566:
        btz localbtz = new btz();
        localbtz.Id = parama.field_songMediaId;
        localbtz.Fjh = parama.field_songAlbumUrl;
        localbtz.Fji = parama.field_songAlbumType;
        localbtz.Url = localbtz.Fjh;
        localObject1 = localObject2;
        if (com.tencent.mm.plugin.sns.b.o.xMa != null)
        {
          localObject1 = com.tencent.mm.plugin.sns.b.o.xMa.a(localbtz);
          if (localObject1 != null)
          {
            localObject1 = com.tencent.mm.sdk.platformtools.f.l((Bitmap)localObject1, 10);
          }
          else
          {
            paramCdnImageView.setImageResource(2131231880);
            if ((!parama.djd()) && (this.vft != null)) {
              this.vft.a(parama, new int[] { -16777216, -1 });
            }
            com.tencent.mm.plugin.sns.b.o.xMa.eB(paramCdnImageView);
            com.tencent.mm.plugin.sns.b.o.xMa.a(localbtz, paramCdnImageView, paramContext.hashCode(), bf.GYH);
            this.vfv.removeCallbacksAndMessages(null);
            this.vfv.postDelayed(new b(parama), 1000L);
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
    com.tencent.mm.plugin.music.model.e.a vfz;
    
    b(com.tencent.mm.plugin.music.model.e.a parama)
    {
      this.vfz = parama;
    }
    
    public final void run()
    {
      AppMethodBeat.i(63010);
      Object localObject = new btz();
      ((btz)localObject).Id = this.vfz.field_songMediaId;
      ((btz)localObject).Fjh = this.vfz.field_songAlbumUrl;
      ((btz)localObject).Fji = this.vfz.field_songAlbumType;
      ((btz)localObject).Url = ((btz)localObject).Fjh;
      localObject = com.tencent.mm.plugin.sns.b.o.xMa.a((btz)localObject);
      if (localObject != null)
      {
        localObject = com.tencent.mm.sdk.platformtools.f.l((Bitmap)localObject, 10);
        d.this.a(this.vfz, (Bitmap)localObject);
        localObject = aj.aE((Bitmap)localObject);
        if (!this.vfz.B((int[])localObject)) {
          this.vfz = f.diT().ao(this.vfz.field_musicId, localObject[0], localObject[1]);
        }
        if ((d.this.vft != null) && (this.vfz != null)) {
          d.this.vft.a(this.vfz, (int[])localObject);
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