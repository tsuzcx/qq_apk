package android.support.v7.widget;

import android.support.v4.view.r;
import android.util.Log;
import android.view.View;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class an
{
  private static final List<Object> xa = Collections.EMPTY_LIST;
  private int eT;
  int un = -1;
  public final View wT;
  int wU = -1;
  long wV = -1L;
  int wW = -1;
  int wX = -1;
  an wY = null;
  an wZ = null;
  List<Object> xb = null;
  List<Object> xc = null;
  private int xd = 0;
  private af xe = null;
  private int xf = 0;
  RecyclerView xg;
  
  public an(View paramView)
  {
    if (paramView == null) {
      throw new IllegalArgumentException("itemView may not be null");
    }
    this.wT = paramView;
  }
  
  final boolean aK(int paramInt)
  {
    return (this.eT & paramInt) != 0;
  }
  
  final void addFlags(int paramInt)
  {
    this.eT |= paramInt;
  }
  
  final void df()
  {
    this.eT = 0;
    this.un = -1;
    this.wU = -1;
    this.wV = -1L;
    this.wX = -1;
    this.xd = 0;
    this.wY = null;
    this.wZ = null;
    eF();
    this.xf = 0;
  }
  
  final void e(int paramInt, boolean paramBoolean)
  {
    if (this.wU == -1) {
      this.wU = this.un;
    }
    if (this.wX == -1) {
      this.wX = this.un;
    }
    if (paramBoolean) {
      this.wX += paramInt;
    }
    this.un += paramInt;
    if (this.wT.getLayoutParams() != null) {
      ((RecyclerView.LayoutParams)this.wT.getLayoutParams()).we = true;
    }
  }
  
  final void eA()
  {
    this.eT &= 0xFFFFFEFF;
  }
  
  final boolean eB()
  {
    return (this.eT & 0x4) != 0;
  }
  
  final boolean eC()
  {
    return (this.eT & 0x2) != 0;
  }
  
  final boolean eD()
  {
    return (this.eT & 0x40) != 0;
  }
  
  final boolean eE()
  {
    return (this.eT & 0x100) != 0;
  }
  
  final void eF()
  {
    if (this.xb != null) {
      this.xb.clear();
    }
    this.eT &= 0xFFFFFBFF;
  }
  
  final List<Object> eG()
  {
    if ((this.eT & 0x400) == 0)
    {
      if ((this.xb == null) || (this.xb.size() == 0)) {
        return xa;
      }
      return this.xc;
    }
    return xa;
  }
  
  public final boolean eH()
  {
    return ((this.eT & 0x10) == 0) && (!r.f(this.wT));
  }
  
  final void es()
  {
    this.wU = -1;
    this.wX = -1;
  }
  
  final void et()
  {
    if (this.wU == -1) {
      this.wU = this.un;
    }
  }
  
  final boolean eu()
  {
    return (this.eT & 0x80) != 0;
  }
  
  public final int ev()
  {
    if (this.wX == -1) {
      return this.un;
    }
    return this.wX;
  }
  
  final boolean ew()
  {
    return this.xe != null;
  }
  
  final void ex()
  {
    this.xe.r(this);
  }
  
  final boolean ey()
  {
    return (this.eT & 0x20) != 0;
  }
  
  final void ez()
  {
    this.eT &= 0xFFFFFFDF;
  }
  
  final void f(af paramaf)
  {
    this.xe = paramaf;
  }
  
  @Deprecated
  public final int getPosition()
  {
    if (this.wX == -1) {
      return this.un;
    }
    return this.wX;
  }
  
  final boolean isBound()
  {
    return (this.eT & 0x1) != 0;
  }
  
  final boolean isRemoved()
  {
    return (this.eT & 0x8) != 0;
  }
  
  public final void s(boolean paramBoolean)
  {
    int i;
    if (paramBoolean)
    {
      i = this.xd - 1;
      this.xd = i;
      if (this.xd >= 0) {
        break label54;
      }
      this.xd = 0;
      Log.e("View", "isRecyclable decremented below 0: unmatched pair of setIsRecyable() calls for ".concat(String.valueOf(this)));
    }
    label54:
    do
    {
      return;
      i = this.xd + 1;
      break;
      if ((!paramBoolean) && (this.xd == 1))
      {
        this.eT |= 0x10;
        return;
      }
    } while ((!paramBoolean) || (this.xd != 0));
    this.eT &= 0xFFFFFFEF;
  }
  
  final void setFlags(int paramInt1, int paramInt2)
  {
    this.eT = (this.eT & (paramInt2 ^ 0xFFFFFFFF) | paramInt1 & paramInt2);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("ViewHolder{" + Integer.toHexString(hashCode()) + " position=" + this.un + " id=" + this.wV + ", oldPos=" + this.wU + ", pLpos:" + this.wX);
    if (ew()) {
      localStringBuilder.append(" scrap");
    }
    if (eB()) {
      localStringBuilder.append(" invalid");
    }
    if (!isBound()) {
      localStringBuilder.append(" unbound");
    }
    if (eC()) {
      localStringBuilder.append(" update");
    }
    if (isRemoved()) {
      localStringBuilder.append(" removed");
    }
    if (eu()) {
      localStringBuilder.append(" ignored");
    }
    if (eD()) {
      localStringBuilder.append(" changed");
    }
    if (eE()) {
      localStringBuilder.append(" tmpDetached");
    }
    if (!eH()) {
      localStringBuilder.append(" not recyclable(" + this.xd + ")");
    }
    if (((this.eT & 0x200) != 0) || (eB())) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        localStringBuilder.append("undefined adapter position");
      }
      if (this.wT.getParent() == null) {
        localStringBuilder.append(" no parent");
      }
      localStringBuilder.append("}");
      return localStringBuilder.toString();
    }
  }
  
  final void z(Object paramObject)
  {
    if (paramObject == null) {
      addFlags(1024);
    }
    while ((this.eT & 0x400) != 0) {
      return;
    }
    if (this.xb == null)
    {
      this.xb = new ArrayList();
      this.xc = Collections.unmodifiableList(this.xb);
    }
    this.xb.add(paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.v7.widget.an
 * JD-Core Version:    0.7.0.1
 */