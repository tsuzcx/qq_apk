package com.tencent.mm.ui.chatting.c;

import android.content.Intent;
import android.content.res.Configuration;
import android.view.KeyEvent;
import android.widget.AbsListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashSet;
import java.util.Iterator;

public final class l
  extends com.tencent.mm.ui.k
  implements com.tencent.mm.ui.chatting.c.b.k
{
  private HashSet<com.tencent.mm.ui.k> ywo;
  
  public l()
  {
    AppMethodBeat.i(31366);
    this.ywo = new HashSet();
    AppMethodBeat.o(31366);
  }
  
  public final void a(com.tencent.mm.ui.k paramk)
  {
    AppMethodBeat.i(31367);
    if (!this.ywo.contains(paramk)) {
      this.ywo.add(paramk);
    }
    AppMethodBeat.o(31367);
  }
  
  public final void b(com.tencent.mm.ui.k paramk)
  {
    AppMethodBeat.i(31368);
    this.ywo.remove(paramk);
    AppMethodBeat.o(31368);
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(31369);
    Iterator localIterator = this.ywo.iterator();
    while (localIterator.hasNext()) {
      ((com.tencent.mm.ui.k)localIterator.next()).onActivityResult(paramInt1, paramInt2, paramIntent);
    }
    AppMethodBeat.o(31369);
  }
  
  public final void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(31372);
    super.onConfigurationChanged(paramConfiguration);
    Iterator localIterator = this.ywo.iterator();
    while (localIterator.hasNext()) {
      ((com.tencent.mm.ui.k)localIterator.next()).onConfigurationChanged(paramConfiguration);
    }
    AppMethodBeat.o(31372);
  }
  
  public final boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(31370);
    Iterator localIterator = this.ywo.iterator();
    while (localIterator.hasNext()) {
      if (((com.tencent.mm.ui.k)localIterator.next()).onKeyDown(paramInt, paramKeyEvent))
      {
        AppMethodBeat.o(31370);
        return true;
      }
    }
    AppMethodBeat.o(31370);
    return false;
  }
  
  public final void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(31371);
    super.onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
    Iterator localIterator = this.ywo.iterator();
    while (localIterator.hasNext()) {
      ((com.tencent.mm.ui.k)localIterator.next()).onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
    }
    AppMethodBeat.o(31371);
  }
  
  public final void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(31373);
    super.onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
    Iterator localIterator = this.ywo.iterator();
    while (localIterator.hasNext()) {
      ((com.tencent.mm.ui.k)localIterator.next()).onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
    }
    AppMethodBeat.o(31373);
  }
  
  public final void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    AppMethodBeat.i(31374);
    super.onScrollStateChanged(paramAbsListView, paramInt);
    Iterator localIterator = this.ywo.iterator();
    while (localIterator.hasNext()) {
      ((com.tencent.mm.ui.k)localIterator.next()).onScrollStateChanged(paramAbsListView, paramInt);
    }
    AppMethodBeat.o(31374);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.c.l
 * JD-Core Version:    0.7.0.1
 */