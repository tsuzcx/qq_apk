package com.tencent.mm.plugin.webview.fts.ui;

import android.annotation.SuppressLint;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.AbsoluteLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.fts.c.a;
import com.tencent.mm.plugin.webview.fts.c.b.b;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.ui.widget.MMWebView;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class b
{
  private MMWebView foJ;
  View iyA;
  public int iyC;
  List<b.a> iyx;
  public int iyy;
  public float[] iyz;
  public ak mHandler;
  public a uQN;
  b.b uQO;
  
  @SuppressLint({"ClickableViewAccessibility"})
  public b(MMWebView paramMMWebView, b.b paramb)
  {
    AppMethodBeat.i(5918);
    this.iyy = -1;
    this.iyC = -1;
    this.foJ = paramMMWebView;
    this.mHandler = new ak(Looper.getMainLooper());
    this.iyx = new LinkedList();
    this.iyA = new View(paramMMWebView.getContext());
    this.uQO = paramb;
    AppMethodBeat.o(5918);
  }
  
  private List<b.a> b(b.a parama)
  {
    AppMethodBeat.i(5923);
    LinkedList localLinkedList = new LinkedList();
    Iterator localIterator = this.iyx.iterator();
    while (localIterator.hasNext())
    {
      b.a locala = (b.a)localIterator.next();
      if (locala.parent == parama.id) {
        localLinkedList.addAll(b(locala));
      }
    }
    localLinkedList.add(parama);
    AppMethodBeat.o(5923);
    return localLinkedList;
  }
  
  private void c(View paramView, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(5927);
    paramView = new b.a(paramView, paramInt1, paramInt2, paramInt3);
    this.iyx.add(paramView);
    AppMethodBeat.o(5927);
  }
  
  private int dm(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(5924);
    Iterator localIterator = this.iyx.iterator();
    int i = 0;
    if (localIterator.hasNext())
    {
      b.a locala = (b.a)localIterator.next();
      if ((paramInt1 != locala.parent) || (paramInt2 < locala.z)) {
        break label74;
      }
      i += 1;
    }
    label74:
    for (;;)
    {
      break;
      AppMethodBeat.o(5924);
      return i;
    }
  }
  
  final ViewGroup JM(int paramInt)
  {
    AppMethodBeat.i(5920);
    if (paramInt == 0)
    {
      localObject = this.foJ.getTopView();
      if ((localObject instanceof AbsoluteLayout))
      {
        AppMethodBeat.o(5920);
        return localObject;
      }
      AppMethodBeat.o(5920);
      return null;
    }
    Object localObject = JN(paramInt);
    if (localObject == null)
    {
      AppMethodBeat.o(5920);
      return null;
    }
    localObject = (View)((b.a)localObject).iyQ.get();
    if ((localObject instanceof ViewGroup))
    {
      localObject = (ViewGroup)localObject;
      AppMethodBeat.o(5920);
      return localObject;
    }
    AppMethodBeat.o(5920);
    return null;
  }
  
  public final b.a JN(int paramInt)
  {
    AppMethodBeat.i(5925);
    Iterator localIterator = this.iyx.iterator();
    while (localIterator.hasNext())
    {
      b.a locala = (b.a)localIterator.next();
      if (locala.id == paramInt)
      {
        AppMethodBeat.o(5925);
        return locala;
      }
    }
    AppMethodBeat.o(5925);
    return null;
  }
  
  final void a(b.a parama)
  {
    AppMethodBeat.i(5922);
    this.iyx.removeAll(b(parama));
    AppMethodBeat.o(5922);
  }
  
  public final boolean a(int paramInt1, float[] paramArrayOfFloat, int paramInt2)
  {
    AppMethodBeat.i(5921);
    if (pk(paramInt1))
    {
      AppMethodBeat.o(5921);
      return true;
    }
    b.a locala = JN(paramInt1);
    if (locala == null)
    {
      AppMethodBeat.o(5921);
      return false;
    }
    View localView = (View)locala.iyQ.get();
    ViewGroup localViewGroup = JM(locala.parent);
    if (localViewGroup == null)
    {
      AppMethodBeat.o(5921);
      return false;
    }
    if ((paramInt2 >= 0) && (paramInt2 != 2147483647)) {
      if (paramInt2 != 0) {
        break label121;
      }
    }
    label121:
    for (int i = 0;; i = 8)
    {
      localView.setVisibility(i);
      if ((paramArrayOfFloat != null) && (paramArrayOfFloat.length >= 5)) {
        break;
      }
      AppMethodBeat.o(5921);
      return true;
    }
    float f1 = paramArrayOfFloat[0];
    float f2 = paramArrayOfFloat[1];
    float f3 = paramArrayOfFloat[2];
    float f4 = paramArrayOfFloat[3];
    i = (int)paramArrayOfFloat[4];
    this.iyx.remove(locala);
    if (locala.z != i)
    {
      localViewGroup.removeView(localView);
      if (a(localView, paramInt1, locala.parent, paramArrayOfFloat, paramInt2))
      {
        AppMethodBeat.o(5921);
        return true;
      }
      a(locala);
      AppMethodBeat.o(5921);
      return false;
    }
    paramArrayOfFloat = localView.getLayoutParams();
    if (f3 != 3.4028235E+38F) {
      paramArrayOfFloat.width = ((int)f3);
    }
    if (f4 != 3.4028235E+38F) {
      paramArrayOfFloat.height = ((int)f4);
    }
    if (f1 != 3.4028235E+38F) {
      localView.setX(f1);
    }
    if (f2 != 3.4028235E+38F) {
      localView.setY(f2);
    }
    localView.requestLayout();
    c(localView, paramInt1, locala.parent, i);
    paramInt1 = localViewGroup.indexOfChild(this.iyA);
    if ((localViewGroup.indexOfChild(localView) == -1) && (paramInt1 != -1))
    {
      localViewGroup.addView(localView, paramInt1);
      localViewGroup.removeView(this.iyA);
    }
    AppMethodBeat.o(5921);
    return true;
  }
  
  final boolean a(View paramView, int paramInt1, int paramInt2, float[] paramArrayOfFloat, int paramInt3)
  {
    int k = 0;
    AppMethodBeat.i(5919);
    if ((paramView == null) || (paramArrayOfFloat == null) || (paramArrayOfFloat.length < 5))
    {
      AppMethodBeat.o(5919);
      return false;
    }
    ViewGroup localViewGroup = JM(paramInt2);
    if (localViewGroup == null)
    {
      AppMethodBeat.o(5919);
      return false;
    }
    if (getViewById(paramInt1) != null)
    {
      AppMethodBeat.o(5919);
      return false;
    }
    float f1 = paramArrayOfFloat[0];
    float f2 = paramArrayOfFloat[1];
    float f3 = paramArrayOfFloat[2];
    float f4 = paramArrayOfFloat[3];
    int m = (int)paramArrayOfFloat[4];
    paramArrayOfFloat = new ViewGroup.LayoutParams((int)f3, (int)f4);
    int j = dm(paramInt2, m);
    int i = j;
    if (j < 0) {
      i = 0;
    }
    j = i;
    if (i > localViewGroup.getChildCount()) {
      j = localViewGroup.getChildCount();
    }
    if ((paramInt3 != 2147483647) && (paramInt3 >= 0)) {
      if (paramInt3 != 0) {
        break label223;
      }
    }
    label223:
    for (paramInt3 = k;; paramInt3 = 8)
    {
      paramView.setVisibility(paramInt3);
      localViewGroup.addView(paramView, j, paramArrayOfFloat);
      paramView.setX(f1);
      paramView.setY(f2);
      c(paramView, paramInt1, paramInt2, m);
      AppMethodBeat.o(5919);
      return true;
    }
  }
  
  public final View getViewById(int paramInt)
  {
    AppMethodBeat.i(5926);
    Object localObject = JN(paramInt);
    if (localObject == null)
    {
      AppMethodBeat.o(5926);
      return null;
    }
    localObject = (View)((b.a)localObject).iyQ.get();
    AppMethodBeat.o(5926);
    return localObject;
  }
  
  public final boolean pk(int paramInt)
  {
    return (this.iyC == paramInt) || (this.iyy == paramInt);
  }
  
  final boolean pm(int paramInt)
  {
    AppMethodBeat.i(5928);
    if (paramInt != this.iyy)
    {
      AppMethodBeat.o(5928);
      return false;
    }
    if (JN(paramInt) == null)
    {
      AppMethodBeat.o(5928);
      return false;
    }
    this.uQO.daO();
    AppMethodBeat.o(5928);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.fts.ui.b
 * JD-Core Version:    0.7.0.1
 */