package com.tencent.mm.plugin.sns.ui;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.model.ag;
import com.tencent.mm.plugin.sns.model.h;
import com.tencent.mm.sdk.g.b.a;

final class PreviewImageView$a
  extends h<String, Integer, Boolean>
{
  private ImageView cxy;
  private Bitmap frG;
  private String path;
  
  public PreviewImageView$a(PreviewImageView paramPreviewImageView, ImageView paramImageView, String paramString)
  {
    this.cxy = paramImageView;
    this.path = paramString;
  }
  
  public final a cjN()
  {
    AppMethodBeat.i(38512);
    a locala = ag.coP();
    AppMethodBeat.o(38512);
    return locala;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.PreviewImageView.a
 * JD-Core Version:    0.7.0.1
 */