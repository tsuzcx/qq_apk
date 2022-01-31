package com.tencent.mm.plugin.sns.ui;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.h;
import com.tencent.mm.sdk.platformtools.ah;

final class PreviewImageView$a
  extends h<String, Integer, Boolean>
{
  private ImageView bQf;
  private Bitmap ebo;
  private String path;
  
  public PreviewImageView$a(PreviewImageView paramPreviewImageView, ImageView paramImageView, String paramString)
  {
    this.bQf = paramImageView;
    this.path = paramString;
  }
  
  public final ah byB()
  {
    return af.bDq();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.PreviewImageView.a
 * JD-Core Version:    0.7.0.1
 */