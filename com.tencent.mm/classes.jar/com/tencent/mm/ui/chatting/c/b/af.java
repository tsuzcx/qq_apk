package com.tencent.mm.ui.chatting.c.b;

import android.content.Intent;
import android.view.ContextMenu;
import android.view.MenuItem;
import com.tencent.mm.plugin.mmsight.SightCaptureResult;
import com.tencent.mm.storage.bl;
import com.tencent.mm.ui.chatting.c.ab;

public abstract interface af
  extends ab
{
  public abstract void F(String paramString1, int paramInt, String paramString2);
  
  public abstract void Q(int paramInt1, int paramInt2, String paramString);
  
  public abstract void a(ContextMenu paramContextMenu, int paramInt, bl parambl);
  
  public abstract void a(SightCaptureResult paramSightCaptureResult);
  
  public abstract boolean a(MenuItem paramMenuItem, bl parambl);
  
  public abstract boolean bx(bl parambl);
  
  public abstract boolean h(int paramInt1, int paramInt2, Intent paramIntent);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.c.b.af
 * JD-Core Version:    0.7.0.1
 */