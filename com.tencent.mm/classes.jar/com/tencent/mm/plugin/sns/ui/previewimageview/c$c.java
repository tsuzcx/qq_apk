package com.tencent.mm.plugin.sns.ui.previewimageview;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.model.ag;
import com.tencent.mm.plugin.sns.model.h;
import com.tencent.mm.sdk.g.b.a;

final class c$c
  extends h<String, Integer, Boolean>
{
  private ImageView cxy;
  private Bitmap frG;
  private String path;
  
  public c$c(c paramc, ImageView paramImageView, String paramString)
  {
    this.cxy = paramImageView;
    this.path = paramString;
  }
  
  public final a cjN()
  {
    AppMethodBeat.i(40302);
    a locala = ag.coP();
    AppMethodBeat.o(40302);
    return locala;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.previewimageview.c.c
 * JD-Core Version:    0.7.0.1
 */