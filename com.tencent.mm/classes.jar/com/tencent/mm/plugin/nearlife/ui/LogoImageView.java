package com.tencent.mm.plugin.nearlife.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ak;

public class LogoImageView
  extends ImageView
{
  int eRu;
  int eRv;
  ak handler;
  String imagePath;
  String url;
  
  public LogoImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(22970);
    this.url = null;
    this.handler = new LogoImageView.1(this);
    AppMethodBeat.o(22970);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.nearlife.ui.LogoImageView
 * JD-Core Version:    0.7.0.1
 */