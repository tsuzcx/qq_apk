package com.tencent.mm.plugin.webview.fts.ui;

import android.content.Context;
import android.view.GestureDetector;
import android.view.View;
import com.tencent.mm.plugin.webview.fts.c.c;

public final class a
{
  int Cv = 0;
  float gCn = 0.0F;
  View gES;
  GestureDetector gEU;
  float gEW = 0.0F;
  int gEX = -1;
  int gEY = 0;
  Runnable gEZ = new a.1(this);
  Context mContext;
  a.a ras = a.a.rav;
  a.b rat;
  
  public a(Context paramContext, View paramView, a.b paramb)
  {
    this.mContext = paramContext;
    this.rat = paramb;
    this.gES = paramView;
    this.gEU = new GestureDetector(this.mContext, new a.2(this));
    this.gCn = c.cn(paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.fts.ui.a
 * JD-Core Version:    0.7.0.1
 */