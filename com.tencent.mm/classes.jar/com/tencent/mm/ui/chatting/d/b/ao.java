package com.tencent.mm.ui.chatting.d.b;

import android.content.Intent;
import android.view.ContextMenu;
import android.view.MenuItem;
import com.tencent.mm.plugin.mmsight.SightCaptureResult;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.chatting.d.ag;

public abstract interface ao
  extends ag
{
  public abstract void R(int paramInt1, int paramInt2, String paramString);
  
  public abstract void V(String paramString1, int paramInt, String paramString2);
  
  public abstract void a(ContextMenu paramContextMenu, int paramInt, ca paramca);
  
  public abstract void a(SightCaptureResult paramSightCaptureResult);
  
  public abstract boolean a(MenuItem paramMenuItem, ca paramca);
  
  public abstract boolean co(ca paramca);
  
  public abstract boolean i(int paramInt1, int paramInt2, Intent paramIntent);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.d.b.ao
 * JD-Core Version:    0.7.0.1
 */