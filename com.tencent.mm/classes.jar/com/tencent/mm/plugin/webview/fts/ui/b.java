package com.tencent.mm.plugin.webview.fts.ui;

import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.AbsoluteLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.fts.b.a;
import com.tencent.mm.plugin.webview.fts.b.b.b;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.SyncTask;
import com.tencent.mm.ui.widget.MMWebView;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class b
{
  List<a> WCX;
  public a WCY;
  b.b WCZ;
  public MMHandler mHandler;
  private MMWebView ooz;
  public int tzg;
  public float[] tzh;
  View tzi;
  public int tzk;
  
  public b(MMWebView paramMMWebView, b.b paramb)
  {
    AppMethodBeat.i(78132);
    this.tzg = -1;
    this.tzk = -1;
    this.ooz = paramMMWebView;
    this.mHandler = new MMHandler(Looper.getMainLooper());
    this.WCX = new LinkedList();
    this.tzi = new View(paramMMWebView.getContext());
    this.WCZ = paramb;
    AppMethodBeat.o(78132);
  }
  
  private List<a> b(a parama)
  {
    AppMethodBeat.i(78137);
    LinkedList localLinkedList = new LinkedList();
    Iterator localIterator = this.WCX.iterator();
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
  
  private void d(View paramView, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(78141);
    paramView = new a(paramView, paramInt1, paramInt2, paramInt3);
    this.WCX.add(paramView);
    AppMethodBeat.o(78141);
  }
  
  private int fL(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(78138);
    Iterator localIterator = this.WCX.iterator();
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
  
  public final boolean Ao(int paramInt)
  {
    return (this.tzk == paramInt) || (this.tzg == paramInt);
  }
  
  final boolean CK(int paramInt)
  {
    AppMethodBeat.i(78142);
    if (paramInt != this.tzg)
    {
      AppMethodBeat.o(78142);
      return false;
    }
    if (atz(paramInt) == null)
    {
      AppMethodBeat.o(78142);
      return false;
    }
    this.WCZ.ito();
    AppMethodBeat.o(78142);
    return true;
  }
  
  final void a(a parama)
  {
    AppMethodBeat.i(78136);
    this.WCX.removeAll(b(parama));
    AppMethodBeat.o(78136);
  }
  
  public final boolean a(int paramInt1, float[] paramArrayOfFloat, int paramInt2)
  {
    AppMethodBeat.i(78135);
    if (Ao(paramInt1))
    {
      AppMethodBeat.o(78135);
      return true;
    }
    a locala = atz(paramInt1);
    if (locala == null)
    {
      AppMethodBeat.o(78135);
      return false;
    }
    View localView = (View)locala.tzB.get();
    ViewGroup localViewGroup = aty(locala.parent);
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
    this.WCX.remove(locala);
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
    d(localView, paramInt1, locala.parent, i);
    paramInt1 = localViewGroup.indexOfChild(this.tzi);
    if ((localViewGroup.indexOfChild(localView) == -1) && (paramInt1 != -1))
    {
      localViewGroup.addView(localView, paramInt1);
      localViewGroup.removeView(this.tzi);
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
    ViewGroup localViewGroup = aty(paramInt2);
    if (localViewGroup == null)
    {
      AppMethodBeat.o(78133);
      return false;
    }
    if (dU(paramInt1) != null)
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
    int j = fL(paramInt2, m);
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
      d(paramView, paramInt1, paramInt2, m);
      AppMethodBeat.o(78133);
      return true;
    }
  }
  
  final ViewGroup aty(int paramInt)
  {
    AppMethodBeat.i(78134);
    if (paramInt == 0)
    {
      localObject = this.ooz.getTopView();
      if ((localObject instanceof AbsoluteLayout))
      {
        AppMethodBeat.o(78134);
        return localObject;
      }
      AppMethodBeat.o(78134);
      return null;
    }
    Object localObject = atz(paramInt);
    if (localObject == null)
    {
      AppMethodBeat.o(78134);
      return null;
    }
    localObject = (View)((a)localObject).tzB.get();
    if ((localObject instanceof ViewGroup))
    {
      localObject = (ViewGroup)localObject;
      AppMethodBeat.o(78134);
      return localObject;
    }
    AppMethodBeat.o(78134);
    return null;
  }
  
  public final a atz(int paramInt)
  {
    AppMethodBeat.i(78139);
    Iterator localIterator = this.WCX.iterator();
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
  
  public final View dU(int paramInt)
  {
    AppMethodBeat.i(78140);
    Object localObject = atz(paramInt);
    if (localObject == null)
    {
      AppMethodBeat.o(78140);
      return null;
    }
    localObject = (View)((a)localObject).tzB.get();
    AppMethodBeat.o(78140);
    return localObject;
  }
  
  public static final class a
  {
    int id;
    int parent;
    public WeakReference<View> tzB;
    int z;
    
    public a(View paramView, int paramInt1, int paramInt2, int paramInt3)
    {
      AppMethodBeat.i(78131);
      this.tzB = new WeakReference(paramView);
      this.id = paramInt1;
      this.parent = paramInt2;
      this.z = paramInt3;
      AppMethodBeat.o(78131);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.fts.ui.b
 * JD-Core Version:    0.7.0.1
 */