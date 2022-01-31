package com.tencent.mm.pluginsdk.ui.tools;

import android.content.pm.ResolveInfo;
import android.graphics.drawable.Drawable;

final class AppChooserUI$c
{
  boolean lnq;
  boolean pKW;
  ResolveInfo sln;
  CharSequence slo;
  Drawable slp;
  boolean slq;
  boolean slr;
  
  public AppChooserUI$c(AppChooserUI paramAppChooserUI) {}
  
  public AppChooserUI$c(AppChooserUI paramAppChooserUI, ResolveInfo paramResolveInfo, CharSequence paramCharSequence)
  {
    this.sln = paramResolveInfo;
    this.slo = paramCharSequence;
    this.slq = false;
    this.pKW = true;
    this.slr = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.AppChooserUI.c
 * JD-Core Version:    0.7.0.1
 */