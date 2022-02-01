package com.tencent.mm.plugin.music.model;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.av.a.a.c.a;
import com.tencent.mm.av.a.c.h;
import com.tencent.mm.av.q;
import com.tencent.mm.b.f;
import com.tencent.mm.plugin.sns.b.g;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.protocal.protobuf.cnb;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.storage.bp;
import com.tencent.mm.ui.ao;

public final class i
{
  public a Akw;
  private h Akx;
  public MMHandler Aky;
  public f<String, Bitmap> gnw;
  
  public i()
  {
    AppMethodBeat.i(63011);
    this.Akx = new h()
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
          Log.i("MicroMsg.Music.MusicImageLoader", "onImageLoadFinish %s %b", new Object[] { paramAnonymousString, Boolean.valueOf(bool) });
          paramAnonymousString = (com.tencent.mm.plugin.music.model.e.a)paramAnonymousView.getTag();
          if ((paramAnonymousb.bitmap != null) && (paramAnonymousString != null))
          {
            i.this.a(paramAnonymousString, paramAnonymousb.bitmap);
            paramAnonymousView = ao.aK(paramAnonymousb.bitmap);
            if (!paramAnonymousString.G(paramAnonymousView)) {
              o.euD().aw(paramAnonymousString.field_musicId, paramAnonymousView[0], paramAnonymousView[1]);
            }
            if (i.this.Akw != null) {
              MMHandlerThread.postToMainThread(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(63008);
                  i.this.Akw.a(paramAnonymousString, paramAnonymousView);
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
    this.Aky = new MMHandler(Looper.getMainLooper());
    this.gnw = new com.tencent.mm.memory.a.b(5, getClass());
    AppMethodBeat.o(63011);
  }
  
  final void a(com.tencent.mm.plugin.music.model.e.a parama, Bitmap paramBitmap)
  {
    AppMethodBeat.i(63013);
    Log.i("MicroMsg.Music.MusicImageLoader", "putBitmapToCache %s", new Object[] { parama.field_musicId });
    this.gnw.put(parama.field_musicId, paramBitmap);
    AppMethodBeat.o(63013);
  }
  
  public final void a(com.tencent.mm.plugin.music.model.e.a parama, CdnImageView paramCdnImageView, Context paramContext, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(63012);
    if (paramBoolean1) {
      this.gnw.remove(parama.field_musicId);
    }
    Object localObject1 = (Bitmap)this.gnw.get(parama.field_musicId);
    if ((localObject1 != null) && (!((Bitmap)localObject1).isRecycled()))
    {
      Log.i("MicroMsg.Music.MusicImageLoader", "hit cache %s", new Object[] { parama.field_musicId });
      paramCdnImageView.setImageBitmap((Bitmap)localObject1);
      if (parama.euM())
      {
        paramCdnImageView = new int[2];
        paramCdnImageView[0] = parama.field_songBgColor;
        paramCdnImageView[1] = parama.field_songLyricColor;
      }
      for (;;)
      {
        if (this.Akw != null) {
          this.Akw.a(parama, paramCdnImageView);
        }
        AppMethodBeat.o(63012);
        return;
        paramCdnImageView = ao.aK((Bitmap)localObject1);
      }
    }
    localObject1 = null;
    Object localObject2 = null;
    Log.i("MicroMsg.Music.MusicImageLoader", "no hit cache %s %s %s %s", new Object[] { parama.field_musicId, parama.field_songHAlbumUrl, parama.field_songAlbumUrl, parama.field_songAlbumLocalPath });
    paramCdnImageView.setTag(parama);
    if (parama.euN())
    {
      paramContext = new c.a();
      paramContext.fullPath = com.tencent.mm.plugin.music.h.b.bV(parama.field_musicId, true);
      paramContext.jbf = true;
      paramContext.jbd = true;
      paramContext.jbq = 2131231962;
      if (paramBoolean2)
      {
        paramContext.jbl = true;
        paramContext.jbm = 10;
      }
      q.bcV().a(parama.field_songHAlbumUrl, paramCdnImageView, paramContext.bdv(), this.Akx);
      localObject1 = localObject2;
    }
    for (;;)
    {
      if ((localObject1 != null) && (!((Bitmap)localObject1).isRecycled()))
      {
        a(parama, (Bitmap)localObject1);
        paramCdnImageView.setImageBitmap((Bitmap)localObject1);
        paramContext = ao.aK((Bitmap)localObject1);
        paramCdnImageView = parama;
        if (!parama.G(paramContext)) {
          paramCdnImageView = o.euD().aw(parama.field_musicId, paramContext[0], paramContext[1]);
        }
        if ((this.Akw != null) && (paramCdnImageView != null)) {
          this.Akw.a(paramCdnImageView, paramContext);
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
            localObject2 = q.bcR().a(parama.field_songAlbumLocalPath, com.tencent.mm.cb.a.getDensity(paramContext), false);
          }
          if (localObject2 == null) {
            break label566;
          }
          localObject1 = BitmapUtil.fastblur((Bitmap)localObject2, 10);
          break;
          paramContext = new c.a();
          paramContext.fullPath = com.tencent.mm.plugin.music.h.b.bV(parama.field_musicId, false);
          paramContext.jbf = true;
          paramContext.jbd = true;
          if (paramBoolean2)
          {
            paramContext.jbl = true;
            paramContext.jbm = 10;
          }
          q.bcV().a(parama.field_songAlbumUrl, paramCdnImageView, paramContext.bdv(), this.Akx);
          localObject1 = localObject2;
          break;
          localObject1 = q.bcR().b(parama.field_songAlbumLocalPath, com.tencent.mm.cb.a.getDensity(paramContext), false);
        }
        paramCdnImageView.setImageResource(2131231962);
        if ((!parama.euM()) && (this.Akw != null)) {
          this.Akw.a(parama, new int[] { -16777216, -1 });
        }
        Log.i("MicroMsg.Music.MusicImageLoader", "field_songAlbumUrl:%s", new Object[] { parama.field_songAlbumUrl });
        localObject1 = localObject2;
        if (!TextUtils.isEmpty(parama.field_songAlbumUrl))
        {
          paramContext = new c.a();
          paramContext.fullPath = com.tencent.mm.plugin.music.h.b.bV(parama.field_musicId, true);
          paramContext.jbf = true;
          paramContext.jbd = true;
          if (paramBoolean2)
          {
            paramContext.jbl = true;
            paramContext.jbm = 10;
          }
          q.bcV().a(parama.field_songAlbumUrl, paramCdnImageView, paramContext.bdv(), this.Akx);
          localObject1 = localObject2;
        }
        break;
      case 1: 
      case 8: 
      case 9: 
        label566:
        cnb localcnb = new cnb();
        localcnb.Id = parama.field_songMediaId;
        localcnb.Msz = parama.field_songAlbumUrl;
        localcnb.MsA = parama.field_songAlbumType;
        localcnb.Url = localcnb.Msz;
        localObject1 = localObject2;
        if (com.tencent.mm.plugin.sns.b.o.DCM != null)
        {
          localObject1 = com.tencent.mm.plugin.sns.b.o.DCM.b(localcnb);
          if (localObject1 != null)
          {
            localObject1 = BitmapUtil.fastblur((Bitmap)localObject1, 10);
          }
          else
          {
            paramCdnImageView.setImageResource(2131231962);
            if ((!parama.euM()) && (this.Akw != null)) {
              this.Akw.a(parama, new int[] { -16777216, -1 });
            }
            com.tencent.mm.plugin.sns.b.o.DCM.ff(paramCdnImageView);
            com.tencent.mm.plugin.sns.b.o.DCM.a(localcnb, paramCdnImageView, paramContext.hashCode(), bp.Oqt);
            this.Aky.removeCallbacksAndMessages(null);
            this.Aky.postDelayed(new b(parama), 1000L);
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
    com.tencent.mm.plugin.music.model.e.a AkC;
    
    b(com.tencent.mm.plugin.music.model.e.a parama)
    {
      this.AkC = parama;
    }
    
    public final void run()
    {
      AppMethodBeat.i(63010);
      Object localObject = new cnb();
      ((cnb)localObject).Id = this.AkC.field_songMediaId;
      ((cnb)localObject).Msz = this.AkC.field_songAlbumUrl;
      ((cnb)localObject).MsA = this.AkC.field_songAlbumType;
      ((cnb)localObject).Url = ((cnb)localObject).Msz;
      localObject = com.tencent.mm.plugin.sns.b.o.DCM.b((cnb)localObject);
      if (localObject != null)
      {
        localObject = BitmapUtil.fastblur((Bitmap)localObject, 10);
        i.this.a(this.AkC, (Bitmap)localObject);
        localObject = ao.aK((Bitmap)localObject);
        if (!this.AkC.G((int[])localObject)) {
          this.AkC = o.euD().aw(this.AkC.field_musicId, localObject[0], localObject[1]);
        }
        if ((i.this.Akw != null) && (this.AkC != null)) {
          i.this.Akw.a(this.AkC, (int[])localObject);
        }
      }
      AppMethodBeat.o(63010);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.music.model.i
 * JD-Core Version:    0.7.0.1
 */