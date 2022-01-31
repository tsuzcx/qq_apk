package com.tencent.mm.plugin.webview.fts.ui;

import android.annotation.SuppressLint;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.AbsoluteLayout;
import com.tencent.mm.plugin.webview.fts.c.a;
import com.tencent.mm.plugin.webview.fts.c.b.b;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.ui.widget.MMWebView;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class b
{
  private MMWebView dYF;
  List<b.a> gVk;
  public int gVl = -1;
  public float[] gVm;
  View gVn;
  public int gVp = -1;
  public ah mHandler;
  public a rbf;
  b.b rbg;
  
  @SuppressLint({"ClickableViewAccessibility"})
  public b(MMWebView paramMMWebView, b.b paramb)
  {
    this.dYF = paramMMWebView;
    this.mHandler = new ah(Looper.getMainLooper());
    this.gVk = new LinkedList();
    this.gVn = new View(paramMMWebView.getContext());
    this.rbg = paramb;
  }
  
  private List<b.a> b(b.a parama)
  {
    LinkedList localLinkedList = new LinkedList();
    Iterator localIterator = this.gVk.iterator();
    while (localIterator.hasNext())
    {
      b.a locala = (b.a)localIterator.next();
      if (locala.gVA == parama.id) {
        localLinkedList.addAll(b(locala));
      }
    }
    localLinkedList.add(parama);
    return localLinkedList;
  }
  
  private void c(View paramView, int paramInt1, int paramInt2, int paramInt3)
  {
    paramView = new b.a(paramView, paramInt1, paramInt2, paramInt3);
    this.gVk.add(paramView);
  }
  
  private int cd(int paramInt1, int paramInt2)
  {
    Iterator localIterator = this.gVk.iterator();
    int i = 0;
    if (localIterator.hasNext())
    {
      b.a locala = (b.a)localIterator.next();
      if ((paramInt1 != locala.gVA) || (paramInt2 < locala.z)) {
        break label62;
      }
      i += 1;
    }
    label62:
    for (;;)
    {
      break;
      return i;
    }
  }
  
  public final b.a BT(int paramInt)
  {
    Iterator localIterator = this.gVk.iterator();
    while (localIterator.hasNext())
    {
      b.a locala = (b.a)localIterator.next();
      if (locala.id == paramInt) {
        return locala;
      }
    }
    return null;
  }
  
  final void a(b.a parama)
  {
    this.gVk.removeAll(b(parama));
  }
  
  public final boolean a(int paramInt1, float[] paramArrayOfFloat, int paramInt2)
  {
    if (mi(paramInt1)) {
      return true;
    }
    b.a locala = BT(paramInt1);
    if (locala == null) {
      return false;
    }
    View localView = (View)locala.gVz.get();
    ViewGroup localViewGroup = mb(locala.gVA);
    if (localViewGroup == null) {
      return false;
    }
    if ((paramInt2 >= 0) && (paramInt2 != 2147483647)) {
      if (paramInt2 != 0) {
        break label91;
      }
    }
    label91:
    for (int i = 0;; i = 8)
    {
      localView.setVisibility(i);
      if ((paramArrayOfFloat != null) && (paramArrayOfFloat.length >= 5)) {
        break;
      }
      return true;
    }
    float f1 = paramArrayOfFloat[0];
    float f2 = paramArrayOfFloat[1];
    float f3 = paramArrayOfFloat[2];
    float f4 = paramArrayOfFloat[3];
    i = (int)paramArrayOfFloat[4];
    this.gVk.remove(locala);
    if (locala.z != i)
    {
      localViewGroup.removeView(localView);
      if (a(localView, paramInt1, locala.gVA, paramArrayOfFloat, paramInt2)) {
        return true;
      }
      a(locala);
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
    c(localView, paramInt1, locala.gVA, i);
    paramInt1 = localViewGroup.indexOfChild(this.gVn);
    if ((localViewGroup.indexOfChild(localView) == -1) && (paramInt1 != -1))
    {
      localViewGroup.addView(localView, paramInt1);
      localViewGroup.removeView(this.gVn);
    }
    return true;
  }
  
  final boolean a(View paramView, int paramInt1, int paramInt2, float[] paramArrayOfFloat, int paramInt3)
  {
    int k = 0;
    if ((paramView == null) || (paramArrayOfFloat == null) || (paramArrayOfFloat.length < 5)) {}
    ViewGroup localViewGroup;
    do
    {
      return false;
      localViewGroup = mb(paramInt2);
    } while ((localViewGroup == null) || (mg(paramInt1) != null));
    float f1 = paramArrayOfFloat[0];
    float f2 = paramArrayOfFloat[1];
    float f3 = paramArrayOfFloat[2];
    float f4 = paramArrayOfFloat[3];
    int m = (int)paramArrayOfFloat[4];
    paramArrayOfFloat = new ViewGroup.LayoutParams((int)f3, (int)f4);
    int j = cd(paramInt2, m);
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
        break label189;
      }
    }
    label189:
    for (paramInt3 = k;; paramInt3 = 8)
    {
      paramView.setVisibility(paramInt3);
      localViewGroup.addView(paramView, j, paramArrayOfFloat);
      paramView.setX(f1);
      paramView.setY(f2);
      c(paramView, paramInt1, paramInt2, m);
      return true;
    }
  }
  
  final ViewGroup mb(int paramInt)
  {
    if (paramInt == 0)
    {
      localObject = this.dYF.getTopView();
      if ((localObject instanceof AbsoluteLayout)) {
        return localObject;
      }
      return null;
    }
    Object localObject = BT(paramInt);
    if (localObject == null) {
      return null;
    }
    localObject = (View)((b.a)localObject).gVz.get();
    if ((localObject instanceof ViewGroup)) {
      return (ViewGroup)localObject;
    }
    return null;
  }
  
  public final View mg(int paramInt)
  {
    b.a locala = BT(paramInt);
    if (locala == null) {
      return null;
    }
    return (View)locala.gVz.get();
  }
  
  public final boolean mi(int paramInt)
  {
    return (this.gVp == paramInt) || (this.gVl == paramInt);
  }
  
  final boolean mk(int paramInt)
  {
    if (paramInt != this.gVl) {}
    while (BT(paramInt) == null) {
      return false;
    }
    this.rbg.caO();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.fts.ui.b
 * JD-Core Version:    0.7.0.1
 */