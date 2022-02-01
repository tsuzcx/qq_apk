package com.tencent.mm.plugin.music.model;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.av.a.a.c.a;
import com.tencent.mm.av.i;
import com.tencent.mm.av.q;
import com.tencent.mm.plugin.sns.b.g;
import com.tencent.mm.plugin.sns.b.o;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.protocal.protobuf.bzh;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.storage.bk;
import com.tencent.mm.ui.al;

public final class d
{
  public com.tencent.mm.b.f<String, Bitmap> fIj;
  public a wAx;
  private com.tencent.mm.av.a.c.h wAy;
  public aq wAz;
  
  public d()
  {
    AppMethodBeat.i(63011);
    this.wAy = new com.tencent.mm.av.a.c.h()
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
          ae.i("MicroMsg.Music.MusicImageLoader", "onImageLoadFinish %s %b", new Object[] { paramAnonymousString, Boolean.valueOf(bool) });
          paramAnonymousString = (com.tencent.mm.plugin.music.model.e.a)paramAnonymousView.getTag();
          if ((paramAnonymousb.bitmap != null) && (paramAnonymousString != null))
          {
            d.this.a(paramAnonymousString, paramAnonymousb.bitmap);
            paramAnonymousView = al.aH(paramAnonymousb.bitmap);
            if (!paramAnonymousString.C(paramAnonymousView)) {
              f.dwu().at(paramAnonymousString.field_musicId, paramAnonymousView[0], paramAnonymousView[1]);
            }
            if (d.this.wAx != null) {
              ar.f(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(63008);
                  d.this.wAx.a(paramAnonymousString, paramAnonymousView);
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
    this.wAz = new aq(Looper.getMainLooper());
    this.fIj = new com.tencent.mm.memory.a.b(5, getClass());
    AppMethodBeat.o(63011);
  }
  
  final void a(com.tencent.mm.plugin.music.model.e.a parama, Bitmap paramBitmap)
  {
    AppMethodBeat.i(63013);
    ae.i("MicroMsg.Music.MusicImageLoader", "putBitmapToCache %s", new Object[] { parama.field_musicId });
    this.fIj.put(parama.field_musicId, paramBitmap);
    AppMethodBeat.o(63013);
  }
  
  public final void a(com.tencent.mm.plugin.music.model.e.a parama, CdnImageView paramCdnImageView, Context paramContext, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(63012);
    if (paramBoolean1) {
      this.fIj.remove(parama.field_musicId);
    }
    Object localObject1 = (Bitmap)this.fIj.get(parama.field_musicId);
    if ((localObject1 != null) && (!((Bitmap)localObject1).isRecycled()))
    {
      ae.i("MicroMsg.Music.MusicImageLoader", "hit cache %s", new Object[] { parama.field_musicId });
      paramCdnImageView.setImageBitmap((Bitmap)localObject1);
      if (parama.dwE())
      {
        paramCdnImageView = new int[2];
        paramCdnImageView[0] = parama.field_songBgColor;
        paramCdnImageView[1] = parama.field_songLyricColor;
      }
      for (;;)
      {
        if (this.wAx != null) {
          this.wAx.a(parama, paramCdnImageView);
        }
        AppMethodBeat.o(63012);
        return;
        paramCdnImageView = al.aH((Bitmap)localObject1);
      }
    }
    localObject1 = null;
    Object localObject2 = null;
    ae.i("MicroMsg.Music.MusicImageLoader", "no hit cache %s %s %s %s", new Object[] { parama.field_musicId, parama.field_songHAlbumUrl, parama.field_songAlbumUrl, parama.field_songAlbumLocalPath });
    paramCdnImageView.setTag(parama);
    if (parama.dwF())
    {
      paramContext = new c.a();
      paramContext.hgD = com.tencent.mm.plugin.music.h.b.bF(parama.field_musicId, true);
      paramContext.igk = true;
      paramContext.igi = true;
      paramContext.igv = 2131231880;
      if (paramBoolean2)
      {
        paramContext.igq = true;
        paramContext.igr = 10;
      }
      q.aJb().a(parama.field_songHAlbumUrl, paramCdnImageView, paramContext.aJu(), this.wAy);
      localObject1 = localObject2;
    }
    for (;;)
    {
      if ((localObject1 != null) && (!((Bitmap)localObject1).isRecycled()))
      {
        a(parama, (Bitmap)localObject1);
        paramCdnImageView.setImageBitmap((Bitmap)localObject1);
        paramContext = al.aH((Bitmap)localObject1);
        paramCdnImageView = parama;
        if (!parama.C(paramContext)) {
          paramCdnImageView = f.dwu().at(parama.field_musicId, paramContext[0], paramContext[1]);
        }
        if ((this.wAx != null) && (paramCdnImageView != null)) {
          this.wAx.a(paramCdnImageView, paramContext);
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
            localObject2 = q.aIX().a(parama.field_songAlbumLocalPath, com.tencent.mm.cb.a.getDensity(paramContext), false);
          }
          if (localObject2 == null) {
            break label566;
          }
          localObject1 = com.tencent.mm.sdk.platformtools.h.l((Bitmap)localObject2, 10);
          break;
          paramContext = new c.a();
          paramContext.hgD = com.tencent.mm.plugin.music.h.b.bF(parama.field_musicId, false);
          paramContext.igk = true;
          paramContext.igi = true;
          if (paramBoolean2)
          {
            paramContext.igq = true;
            paramContext.igr = 10;
          }
          q.aJb().a(parama.field_songAlbumUrl, paramCdnImageView, paramContext.aJu(), this.wAy);
          localObject1 = localObject2;
          break;
          localObject1 = q.aIX().b(parama.field_songAlbumLocalPath, com.tencent.mm.cb.a.getDensity(paramContext), false);
        }
        paramCdnImageView.setImageResource(2131231880);
        if ((!parama.dwE()) && (this.wAx != null)) {
          this.wAx.a(parama, new int[] { -16777216, -1 });
        }
        ae.i("MicroMsg.Music.MusicImageLoader", "field_songAlbumUrl:%s", new Object[] { parama.field_songAlbumUrl });
        localObject1 = localObject2;
        if (!TextUtils.isEmpty(parama.field_songAlbumUrl))
        {
          paramContext = new c.a();
          paramContext.hgD = com.tencent.mm.plugin.music.h.b.bF(parama.field_musicId, true);
          paramContext.igk = true;
          paramContext.igi = true;
          if (paramBoolean2)
          {
            paramContext.igq = true;
            paramContext.igr = 10;
          }
          q.aJb().a(parama.field_songAlbumUrl, paramCdnImageView, paramContext.aJu(), this.wAy);
          localObject1 = localObject2;
        }
        break;
      case 1: 
      case 8: 
      case 9: 
        label566:
        bzh localbzh = new bzh();
        localbzh.Id = parama.field_songMediaId;
        localbzh.Hmj = parama.field_songAlbumUrl;
        localbzh.Hmk = parama.field_songAlbumType;
        localbzh.Url = localbzh.Hmj;
        localObject1 = localObject2;
        if (o.zsv != null)
        {
          localObject1 = o.zsv.a(localbzh);
          if (localObject1 != null)
          {
            localObject1 = com.tencent.mm.sdk.platformtools.h.l((Bitmap)localObject1, 10);
          }
          else
          {
            paramCdnImageView.setImageResource(2131231880);
            if ((!parama.dwE()) && (this.wAx != null)) {
              this.wAx.a(parama, new int[] { -16777216, -1 });
            }
            o.zsv.eQ(paramCdnImageView);
            o.zsv.a(localbzh, paramCdnImageView, paramContext.hashCode(), bk.JgC);
            this.wAz.removeCallbacksAndMessages(null);
            this.wAz.postDelayed(new b(parama), 1000L);
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
    com.tencent.mm.plugin.music.model.e.a wAD;
    
    b(com.tencent.mm.plugin.music.model.e.a parama)
    {
      this.wAD = parama;
    }
    
    public final void run()
    {
      AppMethodBeat.i(63010);
      Object localObject = new bzh();
      ((bzh)localObject).Id = this.wAD.field_songMediaId;
      ((bzh)localObject).Hmj = this.wAD.field_songAlbumUrl;
      ((bzh)localObject).Hmk = this.wAD.field_songAlbumType;
      ((bzh)localObject).Url = ((bzh)localObject).Hmj;
      localObject = o.zsv.a((bzh)localObject);
      if (localObject != null)
      {
        localObject = com.tencent.mm.sdk.platformtools.h.l((Bitmap)localObject, 10);
        d.this.a(this.wAD, (Bitmap)localObject);
        localObject = al.aH((Bitmap)localObject);
        if (!this.wAD.C((int[])localObject)) {
          this.wAD = f.dwu().at(this.wAD.field_musicId, localObject[0], localObject[1]);
        }
        if ((d.this.wAx != null) && (this.wAD != null)) {
          d.this.wAx.a(this.wAD, (int[])localObject);
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