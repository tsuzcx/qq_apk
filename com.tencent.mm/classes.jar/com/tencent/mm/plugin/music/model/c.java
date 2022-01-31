package com.tencent.mm.plugin.music.model;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.at.o;
import com.tencent.mm.plugin.sns.b.n;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.protocal.protobuf.bcs;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.storage.az;
import com.tencent.mm.ui.af;

public final class c
{
  public com.tencent.mm.a.f<String, Bitmap> eap;
  public c.a oZx;
  private com.tencent.mm.at.a.c.g oZy;
  public ak oZz;
  
  public c()
  {
    AppMethodBeat.i(104879);
    this.oZy = new c.1(this);
    this.oZz = new ak(Looper.getMainLooper());
    this.eap = new com.tencent.mm.memory.a.b(5, getClass());
    AppMethodBeat.o(104879);
  }
  
  final void a(com.tencent.mm.plugin.music.model.e.a parama, Bitmap paramBitmap)
  {
    AppMethodBeat.i(104881);
    ab.i("MicroMsg.Music.MusicImageLoader", "putBitmapToCache %s", new Object[] { parama.field_musicId });
    this.eap.put(parama.field_musicId, paramBitmap);
    AppMethodBeat.o(104881);
  }
  
  public final void a(com.tencent.mm.plugin.music.model.e.a parama, CdnImageView paramCdnImageView, Context paramContext, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(104880);
    if (paramBoolean1) {
      this.eap.remove(parama.field_musicId);
    }
    Object localObject1 = (Bitmap)this.eap.get(parama.field_musicId);
    if ((localObject1 != null) && (!((Bitmap)localObject1).isRecycled()))
    {
      ab.i("MicroMsg.Music.MusicImageLoader", "hit cache %s", new Object[] { parama.field_musicId });
      paramCdnImageView.setImageBitmap((Bitmap)localObject1);
      if (parama.bVW())
      {
        paramCdnImageView = new int[2];
        paramCdnImageView[0] = parama.field_songBgColor;
        paramCdnImageView[1] = parama.field_songLyricColor;
      }
      for (;;)
      {
        if (this.oZx != null) {
          this.oZx.a(parama, paramCdnImageView);
        }
        AppMethodBeat.o(104880);
        return;
        paramCdnImageView = af.ao((Bitmap)localObject1);
      }
    }
    localObject1 = null;
    Object localObject2 = null;
    ab.i("MicroMsg.Music.MusicImageLoader", "no hit cache %s %s %s %s", new Object[] { parama.field_musicId, parama.field_songHAlbumUrl, parama.field_songAlbumUrl, parama.field_songAlbumLocalPath });
    paramCdnImageView.setTag(parama);
    if (parama.bVX())
    {
      paramContext = new com.tencent.mm.at.a.a.c.a();
      paramContext.eNO = com.tencent.mm.plugin.music.h.b.be(parama.field_musicId, true);
      paramContext.eNM = true;
      paramContext.eNK = true;
      paramContext.eNY = 2130838497;
      if (paramBoolean2)
      {
        paramContext.fHu = true;
        paramContext.fHv = 10;
      }
      o.ahG().a(parama.field_songHAlbumUrl, paramCdnImageView, paramContext.ahY(), this.oZy);
      localObject1 = localObject2;
    }
    for (;;)
    {
      if ((localObject1 != null) && (!((Bitmap)localObject1).isRecycled()))
      {
        a(parama, (Bitmap)localObject1);
        paramCdnImageView.setImageBitmap((Bitmap)localObject1);
        paramContext = af.ao((Bitmap)localObject1);
        paramCdnImageView = parama;
        if (!parama.y(paramContext)) {
          paramCdnImageView = e.bVM().ap(parama.field_musicId, paramContext[0], paramContext[1]);
        }
        if ((this.oZx != null) && (paramCdnImageView != null)) {
          this.oZx.a(paramCdnImageView, paramContext);
        }
      }
      AppMethodBeat.o(104880);
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
            localObject2 = o.ahC().a(parama.field_songAlbumLocalPath, com.tencent.mm.cb.a.getDensity(paramContext), false);
          }
          if (localObject2 == null) {
            break label566;
          }
          localObject1 = d.g((Bitmap)localObject2, 10);
          break;
          paramContext = new com.tencent.mm.at.a.a.c.a();
          paramContext.eNO = com.tencent.mm.plugin.music.h.b.be(parama.field_musicId, false);
          paramContext.eNM = true;
          paramContext.eNK = true;
          if (paramBoolean2)
          {
            paramContext.fHu = true;
            paramContext.fHv = 10;
          }
          o.ahG().a(parama.field_songAlbumUrl, paramCdnImageView, paramContext.ahY(), this.oZy);
          localObject1 = localObject2;
          break;
          localObject1 = o.ahC().b(parama.field_songAlbumLocalPath, com.tencent.mm.cb.a.getDensity(paramContext), false);
        }
        paramCdnImageView.setImageResource(2130838497);
        if ((!parama.bVW()) && (this.oZx != null)) {
          this.oZx.a(parama, new int[] { -16777216, -1 });
        }
        ab.i("MicroMsg.Music.MusicImageLoader", "field_songAlbumUrl:%s", new Object[] { parama.field_songAlbumUrl });
        localObject1 = localObject2;
        if (!TextUtils.isEmpty(parama.field_songAlbumUrl))
        {
          paramContext = new com.tencent.mm.at.a.a.c.a();
          paramContext.eNO = com.tencent.mm.plugin.music.h.b.be(parama.field_musicId, true);
          paramContext.eNM = true;
          paramContext.eNK = true;
          if (paramBoolean2)
          {
            paramContext.fHu = true;
            paramContext.fHv = 10;
          }
          o.ahG().a(parama.field_songAlbumUrl, paramCdnImageView, paramContext.ahY(), this.oZy);
          localObject1 = localObject2;
        }
        break;
      case 1: 
      case 8: 
      case 9: 
        label566:
        bcs localbcs = new bcs();
        localbcs.Id = parama.field_songMediaId;
        localbcs.xrS = parama.field_songAlbumUrl;
        localbcs.xrT = parama.field_songAlbumType;
        localbcs.Url = localbcs.xrS;
        localObject1 = localObject2;
        if (n.raQ != null)
        {
          localObject1 = n.raQ.b(localbcs);
          if (localObject1 != null)
          {
            localObject1 = d.g((Bitmap)localObject1, 10);
          }
          else
          {
            paramCdnImageView.setImageResource(2130838497);
            if ((!parama.bVW()) && (this.oZx != null)) {
              this.oZx.a(parama, new int[] { -16777216, -1 });
            }
            n.raQ.dC(paramCdnImageView);
            n.raQ.a(localbcs, paramCdnImageView, paramContext.hashCode(), az.yNU);
            this.oZz.removeCallbacksAndMessages(null);
            this.oZz.postDelayed(new c.b(this, parama), 1000L);
          }
        }
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.music.model.c
 * JD-Core Version:    0.7.0.1
 */