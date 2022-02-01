package com.tencent.mm.plugin.sns.ad.widget.a.a;

import android.content.Context;
import android.graphics.Rect;
import com.tencent.mm.plugin.sns.ad.widget.gllib.GLViewContainer;

public abstract class a
  extends com.tencent.mm.plugin.sns.ad.widget.a.b
{
  protected GLViewContainer Qho;
  
  public a(Context paramContext, GLViewContainer paramGLViewContainer, com.tencent.mm.plugin.sns.ad.widget.a.b.a parama)
  {
    super(paramContext, parama);
    this.Qho = paramGLViewContainer;
    hdg();
  }
  
  public final void B(Rect paramRect)
  {
    com.tencent.mm.plugin.sns.ad.widget.gllib.b localb = new com.tencent.mm.plugin.sns.ad.widget.gllib.b(this.mContext);
    int j = Math.abs(paramRect.right - paramRect.left);
    int i = Math.abs(paramRect.top - paramRect.bottom);
    com.tencent.mm.plugin.sns.ad.widget.gllib.b.a locala = new com.tencent.mm.plugin.sns.ad.widget.gllib.b.a(j, i);
    locala.leftMargin = paramRect.left;
    locala.topMargin = paramRect.top;
    localb.a(locala);
    localb.setImageBitmap(this.Qhg.Qhk);
    localb.setAlpha(0.0F);
    this.Qho.a(localb);
    j = paramRect.left;
    a(localb, paramRect.top + i / 2, i);
  }
  
  protected abstract void a(com.tencent.mm.plugin.sns.ad.widget.gllib.b paramb, int paramInt1, int paramInt2);
  
  public final void clear()
  {
    super.clear();
    this.Qho.removeAllViews();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.widget.a.a.a
 * JD-Core Version:    0.7.0.1
 */