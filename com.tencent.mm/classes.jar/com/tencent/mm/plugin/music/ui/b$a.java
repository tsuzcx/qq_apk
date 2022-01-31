package com.tencent.mm.plugin.music.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.Transformation;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.as.g;
import com.tencent.mm.as.o;
import com.tencent.mm.plugin.music.a.c;
import com.tencent.mm.plugin.music.model.c.b;
import com.tencent.mm.plugin.sns.b.n;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.protocal.c.awd;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.az;
import com.tencent.mm.ui.ak;

public final class b$a
{
  MusicItemLayout mBA;
  View mBB;
  View mBC;
  View mBD;
  CdnImageView mBE;
  TextView mBF;
  TextView mBG;
  LyricView mBH;
  boolean mBI;
  private Animation.AnimationListener mBJ = new b.a.3(this);
  private int mode = 1;
  com.tencent.mm.plugin.music.model.e.a mzx;
  
  public b$a(b paramb) {}
  
  public final boolean bnR()
  {
    return this.mode == 2;
  }
  
  public final void bnS()
  {
    if ((this.mBI) || (this.mode == 1)) {
      return;
    }
    com.tencent.mm.plugin.music.model.d.d.ds(3, this.mBz.scene);
    if (this.mBz.mBx == 0)
    {
      this.mBz.mBx = this.mBB.getMeasuredHeight();
      localObject = new LinearLayout.LayoutParams(-1, this.mBz.mBx);
      ((LinearLayout.LayoutParams)localObject).weight = 0.0F;
      this.mBB.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    com.tencent.mm.plugin.music.model.d.d.mAk = true;
    com.tencent.mm.plugin.music.model.d.d.bny();
    this.mode = 1;
    this.mBI = true;
    Object localObject = new a(this.mBH, this.mBz.mBt);
    ((a)localObject).setDuration(500L);
    ((a)localObject).setAnimationListener(this.mBJ);
    this.mBH.startAnimation((Animation)localObject);
  }
  
  public final void bnT()
  {
    if ((this.mBI) || (this.mode == 2)) {
      return;
    }
    com.tencent.mm.plugin.music.model.d.d.ds(2, this.mBz.scene);
    if (this.mBz.mBx == 0)
    {
      this.mBz.mBx = this.mBB.getMeasuredHeight();
      localObject = new LinearLayout.LayoutParams(-1, this.mBz.mBx);
      ((LinearLayout.LayoutParams)localObject).weight = 0.0F;
      this.mBB.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    com.tencent.mm.plugin.music.model.d.d.mAk = true;
    com.tencent.mm.plugin.music.model.d.d.bny();
    this.mode = 2;
    this.mBI = true;
    Object localObject = new a(this.mBH, this.mBz.mBu);
    ((a)localObject).setDuration(500L);
    ((a)localObject).setAnimationListener(this.mBJ);
    this.mBH.startAnimation((Animation)localObject);
  }
  
  public final void bnU()
  {
    com.tencent.mm.plugin.music.model.d.d.mAk = true;
    com.tencent.mm.plugin.music.model.d.d.bny();
    if (this.mode == 1)
    {
      bnT();
      return;
    }
    bnS();
  }
  
  public final void c(com.tencent.mm.plugin.music.model.e.a parama, boolean paramBoolean)
  {
    Object localObject2;
    Object localObject1;
    boolean bool;
    label186:
    com.tencent.mm.plugin.music.model.c localc;
    CdnImageView localCdnImageView;
    Context localContext;
    if (parama != null)
    {
      y.i("MicroMsg.Music.MusicMainAdapter", "updateView %s", new Object[] { parama.field_songName });
      this.mzx = parama;
      if (bk.bl(parama.field_songHAlbumUrl)) {
        ((com.tencent.mm.plugin.music.e.e)com.tencent.mm.plugin.music.f.c.b.Q(com.tencent.mm.plugin.music.e.e.class)).a(parama, this.mBz.mzI);
      }
      this.mBA.setTag(this);
      if (((com.tencent.mm.plugin.music.model.d.a(parama)) && (this.mBz.scene != 3)) || (bk.bl(parama.field_songSinger))) {
        break label377;
      }
      this.mBG.setText(parama.field_songSinger);
      this.mBG.setVisibility(0);
      this.mBF.setText(parama.field_songName);
      this.mBF.setTag(parama.field_songName);
      localObject2 = this.mBH;
      localObject1 = com.tencent.mm.plugin.music.model.e.bnq();
      bool = this.mBz.mzI;
      if (((com.tencent.mm.plugin.music.model.e.b)localObject1).mAs.get(parama.field_musicId) == null) {
        break label389;
      }
      localObject1 = (com.tencent.mm.plugin.music.model.a)((com.tencent.mm.plugin.music.model.e.b)localObject1).mAs.get(parama.field_musicId);
      ((LyricView)localObject2).setLyricObj((com.tencent.mm.plugin.music.model.a)localObject1);
      if ((!com.tencent.mm.plugin.music.model.d.a(parama)) || (this.mBz.mzI)) {
        this.mBH.setCurrentTime(1L);
      }
      bnS();
      localc = this.mBz.mBw;
      localCdnImageView = this.mBE;
      localContext = this.mBz.context;
      bool = this.mBz.mzI;
      if (paramBoolean) {
        localc.diW.remove(parama.field_musicId);
      }
      localObject1 = (Bitmap)localc.diW.get(parama.field_musicId);
      if ((localObject1 == null) || (((Bitmap)localObject1).isRecycled())) {
        break label411;
      }
      y.i("MicroMsg.Music.MusicImageLoader", "hit cache %s", new Object[] { parama.field_musicId });
      localCdnImageView.setImageBitmap((Bitmap)localObject1);
      if (!parama.bnz()) {
        break label401;
      }
      localObject1 = new int[2];
      localObject1[0] = parama.field_songBgColor;
      localObject1[1] = parama.field_songLyricColor;
      label355:
      if (localc.mzr != null) {
        localc.mzr.a(parama, (int[])localObject1);
      }
    }
    label389:
    label401:
    label411:
    label1222:
    for (;;)
    {
      return;
      label377:
      this.mBG.setVisibility(8);
      break;
      localObject1 = ((com.tencent.mm.plugin.music.model.e.b)localObject1).b(parama, bool);
      break label186;
      localObject1 = ak.Y((Bitmap)localObject1);
      break label355;
      localObject1 = null;
      localObject2 = null;
      y.i("MicroMsg.Music.MusicImageLoader", "no hit cache %s %s %s %s", new Object[] { parama.field_musicId, parama.field_songHAlbumUrl, parama.field_songAlbumUrl, parama.field_songAlbumLocalPath });
      localCdnImageView.setTag(parama);
      if (parama.bnA())
      {
        localObject1 = new com.tencent.mm.as.a.a.c.a();
        ((com.tencent.mm.as.a.a.c.a)localObject1).erh = com.tencent.mm.plugin.music.h.b.aO(parama.field_musicId, true);
        ((com.tencent.mm.as.a.a.c.a)localObject1).erf = true;
        ((com.tencent.mm.as.a.a.c.a)localObject1).erd = true;
        ((com.tencent.mm.as.a.a.c.a)localObject1).eru = a.c.default_icon_music;
        if (bool)
        {
          ((com.tencent.mm.as.a.a.c.a)localObject1).erp = true;
          ((com.tencent.mm.as.a.a.c.a)localObject1).erq = 10;
        }
        o.ON().a(parama.field_songHAlbumUrl, localCdnImageView, ((com.tencent.mm.as.a.a.c.a)localObject1).OV(), localc.mzs);
        localObject1 = localObject2;
      }
      for (;;)
      {
        if ((localObject1 == null) || (((Bitmap)localObject1).isRecycled())) {
          break label1222;
        }
        localc.a(parama, (Bitmap)localObject1);
        localCdnImageView.setImageBitmap((Bitmap)localObject1);
        localObject2 = ak.Y((Bitmap)localObject1);
        localObject1 = parama;
        if (!parama.o((int[])localObject2)) {
          localObject1 = com.tencent.mm.plugin.music.model.e.bnq().Y(parama.field_musicId, localObject2[0], localObject2[1]);
        }
        if ((localc.mzr == null) || (localObject1 == null)) {
          break;
        }
        localc.mzr.a((com.tencent.mm.plugin.music.model.e.a)localObject1, (int[])localObject2);
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
              localObject2 = o.OJ().a(parama.field_songAlbumLocalPath, com.tencent.mm.cb.a.getDensity(localContext), false);
            }
            if (localObject2 == null) {
              break label868;
            }
            localObject1 = com.tencent.mm.sdk.platformtools.c.f((Bitmap)localObject2, 10);
            break;
            localObject1 = new com.tencent.mm.as.a.a.c.a();
            ((com.tencent.mm.as.a.a.c.a)localObject1).erh = com.tencent.mm.plugin.music.h.b.aO(parama.field_musicId, false);
            ((com.tencent.mm.as.a.a.c.a)localObject1).erf = true;
            ((com.tencent.mm.as.a.a.c.a)localObject1).erd = true;
            if (bool)
            {
              ((com.tencent.mm.as.a.a.c.a)localObject1).erp = true;
              ((com.tencent.mm.as.a.a.c.a)localObject1).erq = 10;
            }
            o.ON().a(parama.field_songAlbumUrl, localCdnImageView, ((com.tencent.mm.as.a.a.c.a)localObject1).OV(), localc.mzs);
            localObject1 = localObject2;
            break;
            localObject1 = o.OJ().b(parama.field_songAlbumLocalPath, com.tencent.mm.cb.a.getDensity(localContext), false);
          }
          localCdnImageView.setImageResource(a.c.default_icon_music);
          if ((!parama.bnz()) && (localc.mzr != null)) {
            localc.mzr.a(parama, new int[] { -16777216, -1 });
          }
          y.i("MicroMsg.Music.MusicImageLoader", "field_songAlbumUrl:%s", new Object[] { parama.field_songAlbumUrl });
          localObject1 = localObject2;
          if (!TextUtils.isEmpty(parama.field_songAlbumUrl))
          {
            localObject1 = new com.tencent.mm.as.a.a.c.a();
            ((com.tencent.mm.as.a.a.c.a)localObject1).erh = com.tencent.mm.plugin.music.h.b.aO(parama.field_musicId, true);
            ((com.tencent.mm.as.a.a.c.a)localObject1).erf = true;
            ((com.tencent.mm.as.a.a.c.a)localObject1).erd = true;
            if (bool)
            {
              ((com.tencent.mm.as.a.a.c.a)localObject1).erp = true;
              ((com.tencent.mm.as.a.a.c.a)localObject1).erq = 10;
            }
            o.ON().a(parama.field_songAlbumUrl, localCdnImageView, ((com.tencent.mm.as.a.a.c.a)localObject1).OV(), localc.mzs);
            localObject1 = localObject2;
          }
          break;
        case 1: 
        case 8: 
        case 9: 
          label868:
          awd localawd = new awd();
          localawd.lsK = parama.field_songMediaId;
          localawd.trP = parama.field_songAlbumUrl;
          localawd.trQ = parama.field_songAlbumType;
          localawd.kSC = localawd.trP;
          localObject1 = localObject2;
          if (n.omC != null)
          {
            localObject1 = n.omC.b(localawd);
            if (localObject1 != null)
            {
              localObject1 = com.tencent.mm.sdk.platformtools.c.f((Bitmap)localObject1, 10);
            }
            else
            {
              localCdnImageView.setImageResource(a.c.default_icon_music);
              if ((!parama.bnz()) && (localc.mzr != null)) {
                localc.mzr.a(parama, new int[] { -16777216, -1 });
              }
              n.omC.cM(localCdnImageView);
              n.omC.a(localawd, localCdnImageView, localContext.hashCode(), az.uBK);
              localc.mzt.removeCallbacksAndMessages(null);
              localc.mzt.postDelayed(new c.b(localc, parama), 1000L);
            }
          }
          break;
        }
      }
    }
  }
  
  public final class a
    extends Animation
  {
    final int eIC;
    final int mBN;
    View view;
    
    public a(View paramView, int paramInt)
    {
      this.view = paramView;
      this.eIC = paramInt;
      this.mBN = paramView.getHeight();
    }
    
    protected final void applyTransformation(float paramFloat, Transformation paramTransformation)
    {
      int i = (int)(this.mBN + (this.eIC - this.mBN) * paramFloat);
      this.view.getLayoutParams().height = i;
      this.view.requestLayout();
    }
    
    public final void initialize(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      super.initialize(paramInt1, paramInt2, paramInt3, paramInt4);
    }
    
    public final boolean willChangeBounds()
    {
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.music.ui.b.a
 * JD-Core Version:    0.7.0.1
 */