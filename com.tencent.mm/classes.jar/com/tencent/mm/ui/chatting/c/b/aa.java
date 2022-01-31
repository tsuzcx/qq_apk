package com.tencent.mm.ui.chatting.c.b;

import android.content.Intent;
import android.view.ContextMenu;
import android.view.MenuItem;
import com.tencent.mm.plugin.mmsight.SightCaptureResult;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.chatting.c.v;

public abstract interface aa
  extends v
{
  public abstract void E(int paramInt1, int paramInt2, String paramString);
  
  public abstract void a(ContextMenu paramContextMenu, int paramInt, bi parambi);
  
  public abstract void a(SightCaptureResult paramSightCaptureResult);
  
  public abstract boolean a(MenuItem paramMenuItem, bi parambi);
  
  public abstract boolean bc(bi parambi);
  
  public abstract boolean g(int paramInt1, int paramInt2, Intent paramIntent);
  
  public abstract void z(String paramString1, int paramInt, String paramString2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.c.b.aa
 * JD-Core Version:    0.7.0.1
 */