package com.tencent.mm.plugin.sns.ui.previewimageview;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.model.ah;
import com.tencent.mm.plugin.sns.model.h;
import java.util.concurrent.ExecutorService;

final class c$c
  extends h<String, Integer, Boolean>
{
  private ImageView dxD;
  private Bitmap hPl;
  private String path;
  
  public c$c(c paramc, ImageView paramImageView, String paramString)
  {
    this.dxD = paramImageView;
    this.path = paramString;
  }
  
  public final ExecutorService dFv()
  {
    AppMethodBeat.i(179372);
    ExecutorService localExecutorService = ah.dXo();
    AppMethodBeat.o(179372);
    return localExecutorService;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.previewimageview.c.c
 * JD-Core Version:    0.7.0.1
 */