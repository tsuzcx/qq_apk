package com.tencent.mm.ui.chatting.d;

import android.content.Intent;
import android.content.res.Configuration;
import android.view.KeyEvent;
import android.widget.AbsListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.chatting.d.b.n;
import com.tencent.mm.ui.l;
import java.util.HashSet;
import java.util.Iterator;

public final class p
  extends l
  implements n
{
  private HashSet<l> kYC;
  
  public p()
  {
    AppMethodBeat.i(35256);
    this.kYC = new HashSet();
    AppMethodBeat.o(35256);
  }
  
  public final void a(l paraml)
  {
    AppMethodBeat.i(35257);
    if (!this.kYC.contains(paraml)) {
      this.kYC.add(paraml);
    }
    AppMethodBeat.o(35257);
  }
  
  public final void b(l paraml)
  {
    AppMethodBeat.i(35258);
    this.kYC.remove(paraml);
    AppMethodBeat.o(35258);
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(35259);
    Iterator localIterator = this.kYC.iterator();
    while (localIterator.hasNext()) {
      ((l)localIterator.next()).onActivityResult(paramInt1, paramInt2, paramIntent);
    }
    AppMethodBeat.o(35259);
  }
  
  public final void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(35262);
    super.onConfigurationChanged(paramConfiguration);
    Iterator localIterator = this.kYC.iterator();
    while (localIterator.hasNext()) {
      ((l)localIterator.next()).onConfigurationChanged(paramConfiguration);
    }
    AppMethodBeat.o(35262);
  }
  
  public final void onFinish()
  {
    AppMethodBeat.i(233088);
    super.onFinish();
    Iterator localIterator = this.kYC.iterator();
    while (localIterator.hasNext()) {
      ((l)localIterator.next()).onFinish();
    }
    AppMethodBeat.o(233088);
  }
  
  public final boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(35260);
    Iterator localIterator = this.kYC.iterator();
    while (localIterator.hasNext()) {
      if (((l)localIterator.next()).onKeyDown(paramInt, paramKeyEvent))
      {
        AppMethodBeat.o(35260);
        return true;
      }
    }
    AppMethodBeat.o(35260);
    return false;
  }
  
  public final void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(35261);
    super.onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
    Iterator localIterator = this.kYC.iterator();
    while (localIterator.hasNext()) {
      ((l)localIterator.next()).onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
    }
    AppMethodBeat.o(35261);
  }
  
  public final void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(35263);
    super.onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
    Iterator localIterator = this.kYC.iterator();
    while (localIterator.hasNext()) {
      ((l)localIterator.next()).onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
    }
    AppMethodBeat.o(35263);
  }
  
  public final void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    AppMethodBeat.i(35264);
    super.onScrollStateChanged(paramAbsListView, paramInt);
    Iterator localIterator = this.kYC.iterator();
    while (localIterator.hasNext()) {
      ((l)localIterator.next()).onScrollStateChanged(paramAbsListView, paramInt);
    }
    AppMethodBeat.o(35264);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.d.p
 * JD-Core Version:    0.7.0.1
 */