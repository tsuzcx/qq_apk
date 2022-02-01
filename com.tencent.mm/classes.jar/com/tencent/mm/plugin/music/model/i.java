package com.tencent.mm.plugin.music.model;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ay.a.a.c.a;
import com.tencent.mm.ay.q;
import com.tencent.mm.b.f;
import com.tencent.mm.plugin.music.a.d;
import com.tencent.mm.plugin.sns.b.p;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.protocal.protobuf.cvt;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.storage.bp;
import com.tencent.mm.ui.ar;

public final class i
{
  public a FRA;
  private com.tencent.mm.ay.a.c.h FRB;
  public MMHandler FRC;
  public f<String, Bitmap> iRF;
  
  public i()
  {
    AppMethodBeat.i(63011);
    this.FRB = new com.tencent.mm.ay.a.c.h()
    {
      public final Bitmap a(String paramAnonymousString, View paramAnonymousView, com.tencent.mm.ay.a.d.b paramAnonymousb)
      {
        return null;
      }
      
      public final void b(String paramAnonymousString, View paramAnonymousView) {}
      
      public final void b(final String paramAnonymousString, final View paramAnonymousView, com.tencent.mm.ay.a.d.b paramAnonymousb)
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
            paramAnonymousView = ar.aJ(paramAnonymousb.bitmap);
            if (!paramAnonymousString.F(paramAnonymousView)) {
              o.feW().az(paramAnonymousString.field_musicId, paramAnonymousView[0], paramAnonymousView[1]);
            }
            if (i.this.FRA != null) {
              MMHandlerThread.postToMainThread(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(63008);
                  i.this.FRA.a(paramAnonymousString, paramAnonymousView);
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
    this.FRC = new MMHandler(Looper.getMainLooper());
    this.iRF = new com.tencent.mm.memory.a.b(5, getClass());
    AppMethodBeat.o(63011);
  }
  
  final void a(com.tencent.mm.plugin.music.model.e.a parama, Bitmap paramBitmap)
  {
    AppMethodBeat.i(63013);
    Log.i("MicroMsg.Music.MusicImageLoader", "putBitmapToCache %s", new Object[] { parama.field_musicId });
    this.iRF.put(parama.field_musicId, paramBitmap);
    AppMethodBeat.o(63013);
  }
  
  public final void a(com.tencent.mm.plugin.music.model.e.a parama, CdnImageView paramCdnImageView, Context paramContext, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(63012);
    if (paramBoolean1) {
      this.iRF.remove(parama.field_musicId);
    }
    Object localObject1 = (Bitmap)this.iRF.get(parama.field_musicId);
    if ((localObject1 != null) && (!((Bitmap)localObject1).isRecycled()))
    {
      Log.i("MicroMsg.Music.MusicImageLoader", "hit cache %s", new Object[] { parama.field_musicId });
      paramCdnImageView.setImageBitmap((Bitmap)localObject1);
      if (parama.fff())
      {
        paramCdnImageView = new int[2];
        paramCdnImageView[0] = parama.field_songBgColor;
        paramCdnImageView[1] = parama.field_songLyricColor;
      }
      for (;;)
      {
        if (this.FRA != null) {
          this.FRA.a(parama, paramCdnImageView);
        }
        AppMethodBeat.o(63012);
        return;
        paramCdnImageView = ar.aJ((Bitmap)localObject1);
      }
    }
    localObject1 = null;
    Object localObject2 = null;
    Log.i("MicroMsg.Music.MusicImageLoader", "no hit cache %s %s %s %s", new Object[] { parama.field_musicId, parama.field_songHAlbumUrl, parama.field_songAlbumUrl, parama.field_songAlbumLocalPath });
    paramCdnImageView.setTag(parama);
    if (parama.ffg())
    {
      paramContext = new c.a();
      paramContext.fullPath = com.tencent.mm.plugin.music.h.b.ce(parama.field_musicId, true);
      paramContext.lRD = true;
      paramContext.lRB = true;
      paramContext.lRP = a.d.default_icon_music;
      if (paramBoolean2)
      {
        paramContext.lRK = true;
        paramContext.lRL = 10;
      }
      q.bml().a(parama.field_songHAlbumUrl, paramCdnImageView, paramContext.bmL(), this.FRB);
      localObject1 = localObject2;
    }
    for (;;)
    {
      if ((localObject1 != null) && (!((Bitmap)localObject1).isRecycled()))
      {
        a(parama, (Bitmap)localObject1);
        paramCdnImageView.setImageBitmap((Bitmap)localObject1);
        paramContext = ar.aJ((Bitmap)localObject1);
        paramCdnImageView = parama;
        if (!parama.F(paramContext)) {
          paramCdnImageView = o.feW().az(parama.field_musicId, paramContext[0], paramContext[1]);
        }
        if ((this.FRA != null) && (paramCdnImageView != null)) {
          this.FRA.a(paramCdnImageView, paramContext);
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
            localObject2 = q.bmh().a(parama.field_songAlbumLocalPath, com.tencent.mm.ci.a.getDensity(paramContext), false);
          }
          if (localObject2 == null) {
            break label566;
          }
          localObject1 = BitmapUtil.fastblur((Bitmap)localObject2, 10);
          break;
          paramContext = new c.a();
          paramContext.fullPath = com.tencent.mm.plugin.music.h.b.ce(parama.field_musicId, false);
          paramContext.lRD = true;
          paramContext.lRB = true;
          if (paramBoolean2)
          {
            paramContext.lRK = true;
            paramContext.lRL = 10;
          }
          q.bml().a(parama.field_songAlbumUrl, paramCdnImageView, paramContext.bmL(), this.FRB);
          localObject1 = localObject2;
          break;
          localObject1 = q.bmh().b(parama.field_songAlbumLocalPath, com.tencent.mm.ci.a.getDensity(paramContext), false);
        }
        paramCdnImageView.setImageResource(a.d.default_icon_music);
        if ((!parama.fff()) && (this.FRA != null)) {
          this.FRA.a(parama, new int[] { -16777216, -1 });
        }
        Log.i("MicroMsg.Music.MusicImageLoader", "field_songAlbumUrl:%s", new Object[] { parama.field_songAlbumUrl });
        localObject1 = localObject2;
        if (!TextUtils.isEmpty(parama.field_songAlbumUrl))
        {
          paramContext = new c.a();
          paramContext.fullPath = com.tencent.mm.plugin.music.h.b.ce(parama.field_musicId, true);
          paramContext.lRD = true;
          paramContext.lRB = true;
          if (paramBoolean2)
          {
            paramContext.lRK = true;
            paramContext.lRL = 10;
          }
          q.bml().a(parama.field_songAlbumUrl, paramCdnImageView, paramContext.bmL(), this.FRB);
          localObject1 = localObject2;
        }
        break;
      case 1: 
      case 8: 
      case 9: 
        label566:
        cvt localcvt = new cvt();
        localcvt.Id = parama.field_songMediaId;
        localcvt.TDF = parama.field_songAlbumUrl;
        localcvt.TDG = parama.field_songAlbumType;
        localcvt.Url = localcvt.TDF;
        localObject1 = localObject2;
        if (p.JPc != null)
        {
          localObject1 = p.JPc.a(localcvt);
          if (localObject1 != null)
          {
            localObject1 = BitmapUtil.fastblur((Bitmap)localObject1, 10);
          }
          else
          {
            paramCdnImageView.setImageResource(a.d.default_icon_music);
            if ((!parama.fff()) && (this.FRA != null)) {
              this.FRA.a(parama, new int[] { -16777216, -1 });
            }
            p.JPc.gm(paramCdnImageView);
            p.JPc.a(localcvt, paramCdnImageView, paramContext.hashCode(), bp.VGp);
            this.FRC.removeCallbacksAndMessages(null);
            this.FRC.postDelayed(new b(parama), 1000L);
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
    com.tencent.mm.plugin.music.model.e.a FRG;
    
    b(com.tencent.mm.plugin.music.model.e.a parama)
    {
      this.FRG = parama;
    }
    
    public final void run()
    {
      AppMethodBeat.i(63010);
      Object localObject = new cvt();
      ((cvt)localObject).Id = this.FRG.field_songMediaId;
      ((cvt)localObject).TDF = this.FRG.field_songAlbumUrl;
      ((cvt)localObject).TDG = this.FRG.field_songAlbumType;
      ((cvt)localObject).Url = ((cvt)localObject).TDF;
      localObject = p.JPc.a((cvt)localObject);
      if (localObject != null)
      {
        localObject = BitmapUtil.fastblur((Bitmap)localObject, 10);
        i.this.a(this.FRG, (Bitmap)localObject);
        localObject = ar.aJ((Bitmap)localObject);
        if (!this.FRG.F((int[])localObject)) {
          this.FRG = o.feW().az(this.FRG.field_musicId, localObject[0], localObject[1]);
        }
        if ((i.this.FRA != null) && (this.FRG != null)) {
          i.this.FRA.a(this.FRG, (int[])localObject);
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