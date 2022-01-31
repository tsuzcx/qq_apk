package com.tencent.mm.plugin.music.ui;

import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.Transformation;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.music.model.c;
import com.tencent.mm.plugin.music.model.e.a;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public final class b$a
{
  private int mode;
  a oZD;
  MusicItemLayout pbF;
  View pbG;
  View pbH;
  View pbI;
  CdnImageView pbJ;
  TextView pbK;
  TextView pbL;
  LyricView pbM;
  boolean pbN;
  private Animation.AnimationListener pbO;
  
  public b$a(b paramb)
  {
    AppMethodBeat.i(105078);
    this.mode = 1;
    this.pbO = new b.a.3(this);
    AppMethodBeat.o(105078);
  }
  
  public final boolean bWo()
  {
    return this.mode == 2;
  }
  
  public final void bWp()
  {
    AppMethodBeat.i(105080);
    if ((this.pbN) || (this.mode == 1))
    {
      AppMethodBeat.o(105080);
      return;
    }
    com.tencent.mm.plugin.music.model.d.e.eS(3, this.pbE.scene);
    if (this.pbE.pbC == 0)
    {
      this.pbE.pbC = this.pbG.getMeasuredHeight();
      localObject = new LinearLayout.LayoutParams(-1, this.pbE.pbC);
      ((LinearLayout.LayoutParams)localObject).weight = 0.0F;
      this.pbG.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    com.tencent.mm.plugin.music.model.d.e.paq = true;
    com.tencent.mm.plugin.music.model.d.e.bVV();
    this.mode = 1;
    this.pbN = true;
    Object localObject = new a(this.pbM, this.pbE.pby);
    ((a)localObject).setDuration(500L);
    ((a)localObject).setAnimationListener(this.pbO);
    this.pbM.startAnimation((Animation)localObject);
    AppMethodBeat.o(105080);
  }
  
  public final void bWq()
  {
    AppMethodBeat.i(105081);
    if ((this.pbN) || (this.mode == 2))
    {
      AppMethodBeat.o(105081);
      return;
    }
    com.tencent.mm.plugin.music.model.d.e.eS(2, this.pbE.scene);
    if (this.pbE.pbC == 0)
    {
      this.pbE.pbC = this.pbG.getMeasuredHeight();
      localObject = new LinearLayout.LayoutParams(-1, this.pbE.pbC);
      ((LinearLayout.LayoutParams)localObject).weight = 0.0F;
      this.pbG.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    com.tencent.mm.plugin.music.model.d.e.paq = true;
    com.tencent.mm.plugin.music.model.d.e.bVV();
    this.mode = 2;
    this.pbN = true;
    Object localObject = new a(this.pbM, this.pbE.pbz);
    ((a)localObject).setDuration(500L);
    ((a)localObject).setAnimationListener(this.pbO);
    this.pbM.startAnimation((Animation)localObject);
    AppMethodBeat.o(105081);
  }
  
  public final void bWr()
  {
    AppMethodBeat.i(105082);
    com.tencent.mm.plugin.music.model.d.e.paq = true;
    com.tencent.mm.plugin.music.model.d.e.bVV();
    if (this.mode == 1)
    {
      bWq();
      AppMethodBeat.o(105082);
      return;
    }
    bWp();
    AppMethodBeat.o(105082);
  }
  
  public final void d(a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(105079);
    if (parama != null)
    {
      ab.i("MicroMsg.Music.MusicMainAdapter", "updateView %s", new Object[] { parama.field_songName });
      this.oZD = parama;
      if (bo.isNullOrNil(parama.field_songHAlbumUrl)) {
        ((com.tencent.mm.plugin.music.e.e)com.tencent.mm.plugin.music.f.c.b.am(com.tencent.mm.plugin.music.e.e.class)).a(parama, this.pbE.oZO);
      }
      this.pbF.setTag(this);
      if (((com.tencent.mm.plugin.music.model.d.a(parama)) && (this.pbE.scene != 3)) || (bo.isNullOrNil(parama.field_songSinger))) {
        break label226;
      }
      this.pbL.setText(parama.field_songSinger);
      this.pbL.setVisibility(0);
    }
    for (;;)
    {
      this.pbK.setText(parama.field_songName);
      this.pbK.setTag(parama.field_songName);
      this.pbM.setLyricObj(com.tencent.mm.plugin.music.model.e.bVM().b(parama, this.pbE.oZO));
      if ((!com.tencent.mm.plugin.music.model.d.a(parama)) || (this.pbE.oZO)) {
        this.pbM.setCurrentTime(1L);
      }
      bWp();
      this.pbE.pbB.a(parama, this.pbJ, this.pbE.context, paramBoolean, this.pbE.oZO);
      AppMethodBeat.o(105079);
      return;
      label226:
      this.pbL.setVisibility(8);
    }
  }
  
  public final class a
    extends Animation
  {
    final int eRv;
    final int pbR;
    View view;
    
    public a(View paramView, int paramInt)
    {
      AppMethodBeat.i(105075);
      this.view = paramView;
      this.eRv = paramInt;
      this.pbR = paramView.getHeight();
      AppMethodBeat.o(105075);
    }
    
    protected final void applyTransformation(float paramFloat, Transformation paramTransformation)
    {
      AppMethodBeat.i(105076);
      int i = (int)(this.pbR + (this.eRv - this.pbR) * paramFloat);
      this.view.getLayoutParams().height = i;
      this.view.requestLayout();
      AppMethodBeat.o(105076);
    }
    
    public final void initialize(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      AppMethodBeat.i(105077);
      super.initialize(paramInt1, paramInt2, paramInt3, paramInt4);
      AppMethodBeat.o(105077);
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