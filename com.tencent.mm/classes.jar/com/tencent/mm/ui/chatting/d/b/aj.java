package com.tencent.mm.ui.chatting.d.b;

import android.content.Intent;
import android.view.ContextMenu;
import android.view.MenuItem;
import com.tencent.mm.plugin.mmsight.SightCaptureResult;
import com.tencent.mm.storage.bu;
import com.tencent.mm.ui.chatting.d.ad;

public abstract interface aj
  extends ad
{
  public abstract void F(String paramString1, int paramInt, String paramString2);
  
  public abstract void R(int paramInt1, int paramInt2, String paramString);
  
  public abstract void a(ContextMenu paramContextMenu, int paramInt, bu parambu);
  
  public abstract void a(SightCaptureResult paramSightCaptureResult);
  
  public abstract boolean a(MenuItem paramMenuItem, bu parambu);
  
  public abstract boolean bF(bu parambu);
  
  public abstract boolean h(int paramInt1, int paramInt2, Intent paramIntent);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.d.b.aj
 * JD-Core Version:    0.7.0.1
 */