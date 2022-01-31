package com.tencent.mm.pluginsdk.ui.tools;

import android.content.pm.ResolveInfo;
import android.graphics.drawable.Drawable;

final class AppChooserUI$c
{
  boolean nKJ;
  boolean tqS;
  ResolveInfo wdP;
  CharSequence wdQ;
  Drawable wdR;
  boolean wdS;
  boolean wdT;
  
  public AppChooserUI$c(AppChooserUI paramAppChooserUI) {}
  
  public AppChooserUI$c(AppChooserUI paramAppChooserUI, ResolveInfo paramResolveInfo, CharSequence paramCharSequence)
  {
    this.wdP = paramResolveInfo;
    this.wdQ = paramCharSequence;
    this.wdS = false;
    this.tqS = true;
    this.wdT = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.AppChooserUI.c
 * JD-Core Version:    0.7.0.1
 */