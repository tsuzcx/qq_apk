package com.tencent.mm.ui.chatting.d.b;

import android.content.Intent;
import android.view.ContextMenu;
import android.view.MenuItem;
import com.tencent.mm.plugin.mmsight.SightCaptureResult;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.chatting.d.af;

public abstract interface an
  extends af
{
  public abstract void Q(String paramString1, int paramInt, String paramString2);
  
  public abstract void T(int paramInt1, int paramInt2, String paramString);
  
  public abstract void a(ContextMenu paramContextMenu, int paramInt, ca paramca);
  
  public abstract void a(SightCaptureResult paramSightCaptureResult);
  
  public abstract boolean a(MenuItem paramMenuItem, ca paramca);
  
  public abstract boolean bU(ca paramca);
  
  public abstract boolean i(int paramInt1, int paramInt2, Intent paramIntent);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.d.b.an
 * JD-Core Version:    0.7.0.1
 */