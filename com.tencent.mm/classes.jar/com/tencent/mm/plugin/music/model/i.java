package com.tencent.mm.plugin.music.model;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelimage.j;
import com.tencent.mm.modelimage.loader.a.c.a;
import com.tencent.mm.modelimage.loader.b.h;
import com.tencent.mm.modelimage.r;
import com.tencent.mm.plugin.music.a.d;
import com.tencent.mm.plugin.sns.c.q;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.protocal.protobuf.dmz;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.br;
import com.tencent.mm.ui.aw;

public final class i
{
  public a LMu;
  public b LMv;
  private h LMw;
  public MMHandler LMx;
  public com.tencent.mm.b.f<String, Bitmap> ltC;
  
  public i()
  {
    AppMethodBeat.i(63011);
    this.LMw = new h()
    {
      public final Bitmap a(String paramAnonymousString, View paramAnonymousView, com.tencent.mm.modelimage.loader.c.b paramAnonymousb)
      {
        return null;
      }
      
      public final void b(final String paramAnonymousString, final View paramAnonymousView, com.tencent.mm.modelimage.loader.c.b paramAnonymousb)
      {
        AppMethodBeat.i(63009);
        if (paramAnonymousb.bitmap != null) {}
        for (boolean bool = true;; bool = false)
        {
          Log.i("MicroMsg.Music.MusicImageLoader", "onImageLoadFinish %s %b", new Object[] { paramAnonymousString, Boolean.valueOf(bool) });
          if (paramAnonymousView != null) {
            break;
          }
          AppMethodBeat.o(63009);
          return;
        }
        paramAnonymousString = (com.tencent.mm.plugin.music.model.e.a)paramAnonymousView.getTag();
        if ((paramAnonymousb.bitmap != null) && (paramAnonymousString != null))
        {
          i.this.a(paramAnonymousString, paramAnonymousb.bitmap);
          if (i.this.LMv != null) {
            i.this.LMv.at(paramAnonymousb.bitmap);
          }
          paramAnonymousView = aw.bc(paramAnonymousb.bitmap);
          if (!paramAnonymousString.J(paramAnonymousView)) {
            o.god().aG(paramAnonymousString.field_musicId, paramAnonymousView[0], paramAnonymousView[1]);
          }
          if (i.this.LMu != null) {
            MMHandlerThread.postToMainThread(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(63008);
                i.this.LMu.a(paramAnonymousString, paramAnonymousView);
                AppMethodBeat.o(63008);
              }
            });
          }
        }
        AppMethodBeat.o(63009);
      }
      
      public final void c(String paramAnonymousString, View paramAnonymousView) {}
    };
    this.LMx = new MMHandler(Looper.getMainLooper());
    this.ltC = new com.tencent.mm.memory.a.b(5, getClass());
    AppMethodBeat.o(63011);
  }
  
  public final void a(com.tencent.mm.aw.f paramf, CdnImageView paramCdnImageView, Context paramContext, boolean paramBoolean)
  {
    AppMethodBeat.i(271158);
    if ((paramf == null) || (paramCdnImageView == null))
    {
      AppMethodBeat.o(271158);
      return;
    }
    com.tencent.mm.plugin.music.model.e.a locala = new com.tencent.mm.plugin.music.model.e.a();
    locala.field_musicId = paramf.oOv;
    locala.field_originMusicId = paramf.oOv;
    locala.field_musicType = paramf.oOt;
    locala.field_songAlbum = paramf.oOz;
    locala.field_songAlbumType = paramf.oOJ;
    locala.field_songAlbumLocalPath = paramf.oOF;
    locala.field_songAlbumUrl = paramf.oOA;
    if ((TextUtils.isEmpty(locala.field_songLyric)) && (!TextUtils.isEmpty(paramf.oOE))) {
      locala.field_songLyric = paramf.oOE;
    }
    locala.field_songSnsShareUser = paramf.oOP;
    if ((TextUtils.isEmpty(locala.field_songHAlbumUrl)) && (!Util.isNullOrNil(paramf.oOM))) {
      locala.field_songHAlbumUrl = paramf.oOM;
    }
    a(locala, paramCdnImageView, paramContext, true, paramBoolean);
    AppMethodBeat.o(271158);
  }
  
  final void a(com.tencent.mm.plugin.music.model.e.a parama, Bitmap paramBitmap)
  {
    AppMethodBeat.i(63013);
    Log.i("MicroMsg.Music.MusicImageLoader", "putBitmapToCache %s", new Object[] { parama.field_musicId });
    this.ltC.put(parama.field_musicId, paramBitmap);
    AppMethodBeat.o(63013);
  }
  
  public final void a(com.tencent.mm.plugin.music.model.e.a parama, CdnImageView paramCdnImageView, Context paramContext, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(63012);
    if (paramBoolean1) {
      this.ltC.remove(parama.field_musicId);
    }
    Object localObject1 = (Bitmap)this.ltC.get(parama.field_musicId);
    if ((localObject1 != null) && (!((Bitmap)localObject1).isRecycled()))
    {
      Log.i("MicroMsg.Music.MusicImageLoader", "hit cache %s", new Object[] { parama.field_musicId });
      paramCdnImageView.setImageBitmap((Bitmap)localObject1);
      if (parama.goo())
      {
        paramCdnImageView = new int[2];
        paramCdnImageView[0] = parama.field_songBgColor;
        paramCdnImageView[1] = parama.field_songLyricColor;
      }
      for (;;)
      {
        if (this.LMu != null) {
          this.LMu.a(parama, paramCdnImageView);
        }
        AppMethodBeat.o(63012);
        return;
        paramCdnImageView = aw.bc((Bitmap)localObject1);
      }
    }
    localObject1 = null;
    Object localObject2 = null;
    Log.i("MicroMsg.Music.MusicImageLoader", "no hit cache %s %s %s %s", new Object[] { parama.field_musicId, parama.field_songHAlbumUrl, parama.field_songAlbumUrl, parama.field_songAlbumLocalPath });
    paramCdnImageView.setTag(parama);
    if (parama.gop())
    {
      paramContext = new c.a();
      paramContext.fullPath = com.tencent.mm.plugin.music.h.b.cA(parama.field_musicId, true);
      paramContext.oKp = true;
      paramContext.oKn = true;
      paramContext.oKB = a.d.default_icon_music;
      if (paramBoolean2)
      {
        paramContext.oKw = true;
        paramContext.oKx = 40;
      }
      r.bKe().a(parama.field_songHAlbumUrl, paramCdnImageView, paramContext.bKx(), this.LMw);
      localObject1 = localObject2;
    }
    for (;;)
    {
      if ((localObject1 != null) && (!((Bitmap)localObject1).isRecycled()))
      {
        a(parama, (Bitmap)localObject1);
        paramCdnImageView.setImageBitmap((Bitmap)localObject1);
        paramContext = aw.bc((Bitmap)localObject1);
        paramCdnImageView = parama;
        if (!parama.J(paramContext)) {
          paramCdnImageView = o.god().aG(parama.field_musicId, paramContext[0], paramContext[1]);
        }
        if ((this.LMu != null) && (paramCdnImageView != null)) {
          this.LMu.a(paramCdnImageView, paramContext);
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
            localObject2 = r.bKa().a(parama.field_songAlbumLocalPath, com.tencent.mm.cd.a.getDensity(paramContext), false);
          }
          if (localObject2 == null) {
            break label566;
          }
          localObject1 = BitmapUtil.fastblur((Bitmap)localObject2, 10);
          break;
          paramContext = new c.a();
          paramContext.fullPath = com.tencent.mm.plugin.music.h.b.cA(parama.field_musicId, false);
          paramContext.oKp = true;
          paramContext.oKn = true;
          if (paramBoolean2)
          {
            paramContext.oKw = true;
            paramContext.oKx = 10;
          }
          r.bKe().a(parama.field_songAlbumUrl, paramCdnImageView, paramContext.bKx(), this.LMw);
          localObject1 = localObject2;
          break;
          localObject1 = r.bKa().b(parama.field_songAlbumLocalPath, com.tencent.mm.cd.a.getDensity(paramContext), false);
        }
        paramCdnImageView.setImageResource(a.d.default_icon_music);
        if ((!parama.goo()) && (this.LMu != null)) {
          this.LMu.a(parama, new int[] { -16777216, -1 });
        }
        Log.i("MicroMsg.Music.MusicImageLoader", "field_songAlbumUrl:%s", new Object[] { parama.field_songAlbumUrl });
        localObject1 = localObject2;
        if (!TextUtils.isEmpty(parama.field_songAlbumUrl))
        {
          paramContext = new c.a();
          paramContext.fullPath = com.tencent.mm.plugin.music.h.b.cA(parama.field_musicId, true);
          paramContext.oKp = true;
          paramContext.oKn = true;
          if (paramBoolean2)
          {
            paramContext.oKw = true;
            paramContext.oKx = 10;
          }
          r.bKe().a(parama.field_songAlbumUrl, paramCdnImageView, paramContext.bKx(), this.LMw);
          localObject1 = localObject2;
        }
        break;
      case 1: 
      case 8: 
      case 9: 
        label566:
        dmz localdmz = new dmz();
        localdmz.Id = parama.field_songMediaId;
        localdmz.aaTl = parama.field_songAlbumUrl;
        localdmz.aaTm = parama.field_songAlbumType;
        localdmz.Url = localdmz.aaTl;
        localObject1 = localObject2;
        if (q.Qkh != null)
        {
          localObject1 = q.Qkh.a(localdmz);
          if (localObject1 != null)
          {
            localObject1 = BitmapUtil.fastblur((Bitmap)localObject1, 10);
          }
          else
          {
            paramCdnImageView.setImageResource(a.d.default_icon_music);
            if ((!parama.goo()) && (this.LMu != null)) {
              this.LMu.a(parama, new int[] { -16777216, -1 });
            }
            q.Qkh.jq(paramCdnImageView);
            q.Qkh.a(localdmz, paramCdnImageView, paramContext.hashCode(), br.adkd);
            this.LMx.removeCallbacksAndMessages(null);
            this.LMx.postDelayed(new c(parama), 1000L);
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
  
  public static abstract interface b
  {
    public abstract void at(Bitmap paramBitmap);
  }
  
  final class c
    implements Runnable
  {
    com.tencent.mm.plugin.music.model.e.a LMB;
    
    c(com.tencent.mm.plugin.music.model.e.a parama)
    {
      this.LMB = parama;
    }
    
    public final void run()
    {
      AppMethodBeat.i(63010);
      Object localObject = new dmz();
      ((dmz)localObject).Id = this.LMB.field_songMediaId;
      ((dmz)localObject).aaTl = this.LMB.field_songAlbumUrl;
      ((dmz)localObject).aaTm = this.LMB.field_songAlbumType;
      ((dmz)localObject).Url = ((dmz)localObject).aaTl;
      localObject = q.Qkh.a((dmz)localObject);
      if (localObject != null)
      {
        localObject = BitmapUtil.fastblur((Bitmap)localObject, 10);
        i.this.a(this.LMB, (Bitmap)localObject);
        localObject = aw.bc((Bitmap)localObject);
        if (!this.LMB.J((int[])localObject)) {
          this.LMB = o.god().aG(this.LMB.field_musicId, localObject[0], localObject[1]);
        }
        if ((i.this.LMu != null) && (this.LMB != null)) {
          i.this.LMu.a(this.LMB, (int[])localObject);
        }
      }
      AppMethodBeat.o(63010);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.music.model.i
 * JD-Core Version:    0.7.0.1
 */