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
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.widget.MMWebView;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class b
{
  List<a> AQJ;
  public a AQK;
  b.b AQL;
  private MMWebView gQk;
  public int leo;
  public float[] lep;
  View leq;
  public int les;
  public ap mHandler;
  
  @SuppressLint({"ClickableViewAccessibility"})
  public b(MMWebView paramMMWebView, b.b paramb)
  {
    AppMethodBeat.i(78132);
    this.leo = -1;
    this.les = -1;
    this.gQk = paramMMWebView;
    this.mHandler = new ap(Looper.getMainLooper());
    this.AQJ = new LinkedList();
    this.leq = new View(paramMMWebView.getContext());
    this.AQL = paramb;
    AppMethodBeat.o(78132);
  }
  
  private List<a> b(a parama)
  {
    AppMethodBeat.i(78137);
    LinkedList localLinkedList = new LinkedList();
    Iterator localIterator = this.AQJ.iterator();
    while (localIterator.hasNext())
    {
      a locala = (a)localIterator.next();
      if (locala.parent == parama.id) {
        localLinkedList.addAll(b(locala));
      }
    }
    localLinkedList.add(parama);
    AppMethodBeat.o(78137);
    return localLinkedList;
  }
  
  private void e(View paramView, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(78141);
    paramView = new a(paramView, paramInt1, paramInt2, paramInt3);
    this.AQJ.add(paramView);
    AppMethodBeat.o(78141);
  }
  
  private int ec(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(78138);
    Iterator localIterator = this.AQJ.iterator();
    int i = 0;
    if (localIterator.hasNext())
    {
      a locala = (a)localIterator.next();
      if ((paramInt1 != locala.parent) || (paramInt2 < locala.z)) {
        break label72;
      }
      i += 1;
    }
    label72:
    for (;;)
    {
      break;
      AppMethodBeat.o(78138);
      return i;
    }
  }
  
  final ViewGroup SB(int paramInt)
  {
    AppMethodBeat.i(78134);
    if (paramInt == 0)
    {
      localObject = this.gQk.getTopView();
      if ((localObject instanceof AbsoluteLayout))
      {
        AppMethodBeat.o(78134);
        return localObject;
      }
      AppMethodBeat.o(78134);
      return null;
    }
    Object localObject = SC(paramInt);
    if (localObject == null)
    {
      AppMethodBeat.o(78134);
      return null;
    }
    localObject = (View)((a)localObject).leJ.get();
    if ((localObject instanceof ViewGroup))
    {
      localObject = (ViewGroup)localObject;
      AppMethodBeat.o(78134);
      return localObject;
    }
    AppMethodBeat.o(78134);
    return null;
  }
  
  public final a SC(int paramInt)
  {
    AppMethodBeat.i(78139);
    Iterator localIterator = this.AQJ.iterator();
    while (localIterator.hasNext())
    {
      a locala = (a)localIterator.next();
      if (locala.id == paramInt)
      {
        AppMethodBeat.o(78139);
        return locala;
      }
    }
    AppMethodBeat.o(78139);
    return null;
  }
  
  final void a(a parama)
  {
    AppMethodBeat.i(78136);
    this.AQJ.removeAll(b(parama));
    AppMethodBeat.o(78136);
  }
  
  public final boolean a(int paramInt1, float[] paramArrayOfFloat, int paramInt2)
  {
    AppMethodBeat.i(78135);
    if (rt(paramInt1))
    {
      AppMethodBeat.o(78135);
      return true;
    }
    a locala = SC(paramInt1);
    if (locala == null)
    {
      AppMethodBeat.o(78135);
      return false;
    }
    View localView = (View)locala.leJ.get();
    ViewGroup localViewGroup = SB(locala.parent);
    if (localViewGroup == null)
    {
      AppMethodBeat.o(78135);
      return false;
    }
    if ((paramInt2 >= 0) && (paramInt2 != 2147483647)) {
      if (paramInt2 != 0) {
        break label116;
      }
    }
    label116:
    for (int i = 0;; i = 8)
    {
      localView.setVisibility(i);
      if ((paramArrayOfFloat != null) && (paramArrayOfFloat.length >= 5)) {
        break;
      }
      AppMethodBeat.o(78135);
      return true;
    }
    float f1 = paramArrayOfFloat[0];
    float f2 = paramArrayOfFloat[1];
    float f3 = paramArrayOfFloat[2];
    float f4 = paramArrayOfFloat[3];
    i = (int)paramArrayOfFloat[4];
    this.AQJ.remove(locala);
    if (locala.z != i)
    {
      localViewGroup.removeView(localView);
      if (a(localView, paramInt1, locala.parent, paramArrayOfFloat, paramInt2))
      {
        AppMethodBeat.o(78135);
        return true;
      }
      a(locala);
      AppMethodBeat.o(78135);
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
    e(localView, paramInt1, locala.parent, i);
    paramInt1 = localViewGroup.indexOfChild(this.leq);
    if ((localViewGroup.indexOfChild(localView) == -1) && (paramInt1 != -1))
    {
      localViewGroup.addView(localView, paramInt1);
      localViewGroup.removeView(this.leq);
    }
    AppMethodBeat.o(78135);
    return true;
  }
  
  final boolean a(View paramView, int paramInt1, int paramInt2, float[] paramArrayOfFloat, int paramInt3)
  {
    int k = 0;
    AppMethodBeat.i(78133);
    if ((paramView == null) || (paramArrayOfFloat == null) || (paramArrayOfFloat.length < 5))
    {
      AppMethodBeat.o(78133);
      return false;
    }
    ViewGroup localViewGroup = SB(paramInt2);
    if (localViewGroup == null)
    {
      AppMethodBeat.o(78133);
      return false;
    }
    if (getViewById(paramInt1) != null)
    {
      AppMethodBeat.o(78133);
      return false;
    }
    float f1 = paramArrayOfFloat[0];
    float f2 = paramArrayOfFloat[1];
    float f3 = paramArrayOfFloat[2];
    float f4 = paramArrayOfFloat[3];
    int m = (int)paramArrayOfFloat[4];
    paramArrayOfFloat = new ViewGroup.LayoutParams((int)f3, (int)f4);
    int j = ec(paramInt2, m);
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
        break label218;
      }
    }
    label218:
    for (paramInt3 = k;; paramInt3 = 8)
    {
      paramView.setVisibility(paramInt3);
      localViewGroup.addView(paramView, j, paramArrayOfFloat);
      paramView.setX(f1);
      paramView.setY(f2);
      e(paramView, paramInt1, paramInt2, m);
      AppMethodBeat.o(78133);
      return true;
    }
  }
  
  public final View getViewById(int paramInt)
  {
    AppMethodBeat.i(78140);
    Object localObject = SC(paramInt);
    if (localObject == null)
    {
      AppMethodBeat.o(78140);
      return null;
    }
    localObject = (View)((a)localObject).leJ.get();
    AppMethodBeat.o(78140);
    return localObject;
  }
  
  public final boolean rt(int paramInt)
  {
    return (this.les == paramInt) || (this.leo == paramInt);
  }
  
  final boolean tA(int paramInt)
  {
    AppMethodBeat.i(78142);
    if (paramInt != this.leo)
    {
      AppMethodBeat.o(78142);
      return false;
    }
    if (SC(paramInt) == null)
    {
      AppMethodBeat.o(78142);
      return false;
    }
    this.AQL.ekh();
    AppMethodBeat.o(78142);
    return true;
  }
  
  public static final class a
  {
    int id;
    public WeakReference<View> leJ;
    int parent;
    int z;
    
    public a(View paramView, int paramInt1, int paramInt2, int paramInt3)
    {
      AppMethodBeat.i(78131);
      this.leJ = new WeakReference(paramView);
      this.id = paramInt1;
      this.parent = paramInt2;
      this.z = paramInt3;
      AppMethodBeat.o(78131);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.fts.ui.b
 * JD-Core Version:    0.7.0.1
 */