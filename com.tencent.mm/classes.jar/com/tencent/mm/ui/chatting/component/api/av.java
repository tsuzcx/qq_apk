package com.tencent.mm.ui.chatting.component.api;

import android.content.Intent;
import android.view.ContextMenu;
import android.view.MenuItem;
import com.tencent.mm.plugin.mmsight.SightCaptureResult;
import com.tencent.mm.storage.cc;
import com.tencent.mm.ui.chatting.component.aj;

public abstract interface av
  extends aj
{
  public abstract void X(String paramString1, int paramInt, String paramString2);
  
  public abstract void a(ContextMenu paramContextMenu, int paramInt, cc paramcc);
  
  public abstract boolean a(MenuItem paramMenuItem, cc paramcc);
  
  public abstract void ab(int paramInt1, int paramInt2, String paramString);
  
  public abstract void c(SightCaptureResult paramSightCaptureResult);
  
  public abstract boolean cK(cc paramcc);
  
  public abstract boolean l(int paramInt1, int paramInt2, Intent paramIntent);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.component.api.av
 * JD-Core Version:    0.7.0.1
 */