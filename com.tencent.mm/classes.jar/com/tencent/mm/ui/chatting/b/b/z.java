package com.tencent.mm.ui.chatting.b.b;

import android.content.Intent;
import android.view.ContextMenu;
import android.view.MenuItem;
import com.tencent.mm.plugin.mmsight.SightCaptureResult;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.chatting.b.v;

public abstract interface z
  extends v
{
  public abstract void B(String paramString1, int paramInt, String paramString2);
  
  public abstract void a(ContextMenu paramContextMenu, int paramInt, bi parambi);
  
  public abstract void a(SightCaptureResult paramSightCaptureResult);
  
  public abstract boolean a(MenuItem paramMenuItem, bi parambi);
  
  public abstract boolean aR(bi parambi);
  
  public abstract boolean g(int paramInt1, int paramInt2, Intent paramIntent);
  
  public abstract void x(int paramInt1, int paramInt2, String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.b.b.z
 * JD-Core Version:    0.7.0.1
 */