package com.tencent.mm.ui.chatting.b;

import android.content.Intent;
import android.content.res.Configuration;
import android.view.KeyEvent;
import android.widget.AbsListView;
import com.tencent.mm.ui.chatting.b.b.j;
import java.util.HashSet;
import java.util.Iterator;

public final class l
  extends com.tencent.mm.ui.l
  implements j
{
  private HashSet<com.tencent.mm.ui.l> umI = new HashSet();
  
  public final void a(com.tencent.mm.ui.l paraml)
  {
    if (!this.umI.contains(paraml)) {
      this.umI.add(paraml);
    }
  }
  
  public final void b(com.tencent.mm.ui.l paraml)
  {
    this.umI.remove(paraml);
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    Iterator localIterator = this.umI.iterator();
    while (localIterator.hasNext()) {
      ((com.tencent.mm.ui.l)localIterator.next()).onActivityResult(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public final void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    Iterator localIterator = this.umI.iterator();
    while (localIterator.hasNext()) {
      ((com.tencent.mm.ui.l)localIterator.next()).onConfigurationChanged(paramConfiguration);
    }
  }
  
  public final boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    Iterator localIterator = this.umI.iterator();
    while (localIterator.hasNext()) {
      if (((com.tencent.mm.ui.l)localIterator.next()).onKeyDown(paramInt, paramKeyEvent)) {
        return true;
      }
    }
    return false;
  }
  
  public final void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    super.onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
    Iterator localIterator = this.umI.iterator();
    while (localIterator.hasNext()) {
      ((com.tencent.mm.ui.l)localIterator.next()).onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
    }
  }
  
  public final void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    super.onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
    Iterator localIterator = this.umI.iterator();
    while (localIterator.hasNext()) {
      ((com.tencent.mm.ui.l)localIterator.next()).onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
    }
  }
  
  public final void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    super.onScrollStateChanged(paramAbsListView, paramInt);
    Iterator localIterator = this.umI.iterator();
    while (localIterator.hasNext()) {
      ((com.tencent.mm.ui.l)localIterator.next()).onScrollStateChanged(paramAbsListView, paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.b.l
 * JD-Core Version:    0.7.0.1
 */