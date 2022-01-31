package android.support.v7.widget;

import android.support.v4.view.r;
import android.util.Log;
import android.view.View;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class an
{
  private static final List<Object> vl = Collections.EMPTY_LIST;
  private int df;
  int sx = -1;
  public final View ve;
  int vf = -1;
  long vg = -1L;
  int vh = -1;
  int vi = -1;
  an vj = null;
  an vk = null;
  List<Object> vm = null;
  List<Object> vn = null;
  private int vo = 0;
  private af vp = null;
  private int vq = 0;
  RecyclerView vr;
  
  public an(View paramView)
  {
    if (paramView == null) {
      throw new IllegalArgumentException("itemView may not be null");
    }
    this.ve = paramView;
  }
  
  final void addFlags(int paramInt)
  {
    this.df |= paramInt;
  }
  
  final boolean ay(int paramInt)
  {
    return (this.df & paramInt) != 0;
  }
  
  final void d(int paramInt, boolean paramBoolean)
  {
    if (this.vf == -1) {
      this.vf = this.sx;
    }
    if (this.vi == -1) {
      this.vi = this.sx;
    }
    if (paramBoolean) {
      this.vi += paramInt;
    }
    this.sx += paramInt;
    if (this.ve.getLayoutParams() != null) {
      ((RecyclerView.LayoutParams)this.ve.getLayoutParams()).up = true;
    }
  }
  
  final void ee()
  {
    this.vf = -1;
    this.vi = -1;
  }
  
  final boolean ef()
  {
    return (this.df & 0x80) != 0;
  }
  
  public final int eg()
  {
    if (this.vi == -1) {
      return this.sx;
    }
    return this.vi;
  }
  
  final boolean eh()
  {
    return this.vp != null;
  }
  
  final void ei()
  {
    this.vp.r(this);
  }
  
  final boolean ej()
  {
    return (this.df & 0x20) != 0;
  }
  
  final void ek()
  {
    this.df &= 0xFFFFFFDF;
  }
  
  final void el()
  {
    this.df &= 0xFFFFFEFF;
  }
  
  final boolean em()
  {
    return (this.df & 0x4) != 0;
  }
  
  final boolean en()
  {
    return (this.df & 0x2) != 0;
  }
  
  final boolean eo()
  {
    return (this.df & 0x40) != 0;
  }
  
  final boolean ep()
  {
    return (this.df & 0x100) != 0;
  }
  
  final void eq()
  {
    if (this.vm != null) {
      this.vm.clear();
    }
    this.df &= 0xFFFFFBFF;
  }
  
  final List<Object> er()
  {
    if ((this.df & 0x400) == 0)
    {
      if ((this.vm == null) || (this.vm.size() == 0)) {
        return vl;
      }
      return this.vn;
    }
    return vl;
  }
  
  final void es()
  {
    this.df = 0;
    this.sx = -1;
    this.vf = -1;
    this.vg = -1L;
    this.vi = -1;
    this.vo = 0;
    this.vj = null;
    this.vk = null;
    eq();
    this.vq = 0;
  }
  
  public final boolean et()
  {
    return ((this.df & 0x10) == 0) && (!r.e(this.ve));
  }
  
  final void f(af paramaf)
  {
    this.vp = paramaf;
  }
  
  @Deprecated
  public final int getPosition()
  {
    if (this.vi == -1) {
      return this.sx;
    }
    return this.vi;
  }
  
  final boolean isBound()
  {
    return (this.df & 0x1) != 0;
  }
  
  final boolean isRemoved()
  {
    return (this.df & 0x8) != 0;
  }
  
  public final void p(boolean paramBoolean)
  {
    int i;
    if (paramBoolean)
    {
      i = this.vo - 1;
      this.vo = i;
      if (this.vo >= 0) {
        break label61;
      }
      this.vo = 0;
      Log.e("View", "isRecyclable decremented below 0: unmatched pair of setIsRecyable() calls for " + this);
    }
    label61:
    do
    {
      return;
      i = this.vo + 1;
      break;
      if ((!paramBoolean) && (this.vo == 1))
      {
        this.df |= 0x10;
        return;
      }
    } while ((!paramBoolean) || (this.vo != 0));
    this.df &= 0xFFFFFFEF;
  }
  
  final void q(Object paramObject)
  {
    if (paramObject == null) {
      addFlags(1024);
    }
    while ((this.df & 0x400) != 0) {
      return;
    }
    if (this.vm == null)
    {
      this.vm = new ArrayList();
      this.vn = Collections.unmodifiableList(this.vm);
    }
    this.vm.add(paramObject);
  }
  
  final void setFlags(int paramInt1, int paramInt2)
  {
    this.df = (this.df & (paramInt2 ^ 0xFFFFFFFF) | paramInt1 & paramInt2);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("ViewHolder{" + Integer.toHexString(hashCode()) + " position=" + this.sx + " id=" + this.vg + ", oldPos=" + this.vf + ", pLpos:" + this.vi);
    if (eh()) {
      localStringBuilder.append(" scrap");
    }
    if (em()) {
      localStringBuilder.append(" invalid");
    }
    if (!isBound()) {
      localStringBuilder.append(" unbound");
    }
    if (en()) {
      localStringBuilder.append(" update");
    }
    if (isRemoved()) {
      localStringBuilder.append(" removed");
    }
    if (ef()) {
      localStringBuilder.append(" ignored");
    }
    if (eo()) {
      localStringBuilder.append(" changed");
    }
    if (ep()) {
      localStringBuilder.append(" tmpDetached");
    }
    if (!et()) {
      localStringBuilder.append(" not recyclable(" + this.vo + ")");
    }
    if (((this.df & 0x200) != 0) || (em())) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        localStringBuilder.append("undefined adapter position");
      }
      if (this.ve.getParent() == null) {
        localStringBuilder.append(" no parent");
      }
      localStringBuilder.append("}");
      return localStringBuilder.toString();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.v7.widget.an
 * JD-Core Version:    0.7.0.1
 */