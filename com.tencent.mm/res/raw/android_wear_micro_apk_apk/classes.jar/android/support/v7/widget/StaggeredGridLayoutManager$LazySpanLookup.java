package android.support.v7.widget;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

final class StaggeredGridLayoutManager$LazySpanLookup
{
  int[] mData;
  List<StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem> xE;
  
  private int aX(int paramInt)
  {
    int i = this.mData.length;
    while (i <= paramInt) {
      i *= 2;
    }
    return i;
  }
  
  private void aY(int paramInt)
  {
    if (this.mData == null)
    {
      this.mData = new int[Math.max(paramInt, 10) + 1];
      Arrays.fill(this.mData, -1);
    }
    while (paramInt < this.mData.length) {
      return;
    }
    int[] arrayOfInt = this.mData;
    this.mData = new int[aX(paramInt)];
    System.arraycopy(arrayOfInt, 0, this.mData, 0, arrayOfInt.length);
    Arrays.fill(this.mData, arrayOfInt.length, this.mData.length, -1);
  }
  
  private int aZ(int paramInt)
  {
    if (this.xE == null) {
      return -1;
    }
    StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem localFullSpanItem = ba(paramInt);
    if (localFullSpanItem != null) {
      this.xE.remove(localFullSpanItem);
    }
    int j = this.xE.size();
    int i = 0;
    if (i < j) {
      if (((StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem)this.xE.get(i)).un < paramInt) {}
    }
    for (;;)
    {
      if (i != -1)
      {
        localFullSpanItem = (StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem)this.xE.get(i);
        this.xE.remove(i);
        return localFullSpanItem.un;
        i += 1;
        break;
      }
      return -1;
      i = -1;
    }
  }
  
  final void K(int paramInt1, int paramInt2)
  {
    if ((this.mData == null) || (paramInt1 >= this.mData.length)) {}
    Object localObject;
    do
    {
      return;
      aY(paramInt1 + paramInt2);
      localObject = this.mData;
      int[] arrayOfInt = this.mData;
      System.arraycopy(localObject, paramInt1 + paramInt2, arrayOfInt, paramInt1, arrayOfInt.length - paramInt1 - paramInt2);
      Arrays.fill(this.mData, this.mData.length - paramInt2, this.mData.length, -1);
    } while (this.xE == null);
    int i = this.xE.size() - 1;
    label93:
    if (i >= 0)
    {
      localObject = (StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem)this.xE.get(i);
      if (((StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem)localObject).un >= paramInt1)
      {
        if (((StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem)localObject).un >= paramInt1 + paramInt2) {
          break label150;
        }
        this.xE.remove(i);
      }
    }
    for (;;)
    {
      i -= 1;
      break label93;
      break;
      label150:
      ((StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem)localObject).un -= paramInt2;
    }
  }
  
  final void L(int paramInt1, int paramInt2)
  {
    if ((this.mData == null) || (paramInt1 >= this.mData.length)) {}
    for (;;)
    {
      return;
      aY(paramInt1 + paramInt2);
      Object localObject = this.mData;
      System.arraycopy(localObject, paramInt1, localObject, paramInt1 + paramInt2, this.mData.length - paramInt1 - paramInt2);
      Arrays.fill(this.mData, paramInt1, paramInt1 + paramInt2, -1);
      if (this.xE != null)
      {
        int i = this.xE.size() - 1;
        while (i >= 0)
        {
          localObject = (StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem)this.xE.get(i);
          if (((StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem)localObject).un >= paramInt1) {
            ((StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem)localObject).un += paramInt2;
          }
          i -= 1;
        }
      }
    }
  }
  
  final void a(int paramInt, ar paramar)
  {
    aY(paramInt);
    this.mData[paramInt] = paramar.bL;
  }
  
  public final void a(StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem paramFullSpanItem)
  {
    if (this.xE == null) {
      this.xE = new ArrayList();
    }
    int j = this.xE.size();
    int i = 0;
    while (i < j)
    {
      StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem localFullSpanItem = (StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem)this.xE.get(i);
      if (localFullSpanItem.un == paramFullSpanItem.un) {
        this.xE.remove(i);
      }
      if (localFullSpanItem.un >= paramFullSpanItem.un)
      {
        this.xE.add(i, paramFullSpanItem);
        return;
      }
      i += 1;
    }
    this.xE.add(paramFullSpanItem);
  }
  
  final int aU(int paramInt)
  {
    if (this.xE != null)
    {
      int i = this.xE.size() - 1;
      while (i >= 0)
      {
        if (((StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem)this.xE.get(i)).un >= paramInt) {
          this.xE.remove(i);
        }
        i -= 1;
      }
    }
    return aV(paramInt);
  }
  
  final int aV(int paramInt)
  {
    if (this.mData == null) {}
    while (paramInt >= this.mData.length) {
      return -1;
    }
    int i = aZ(paramInt);
    if (i == -1)
    {
      int[] arrayOfInt = this.mData;
      Arrays.fill(arrayOfInt, paramInt, arrayOfInt.length, -1);
      return this.mData.length;
    }
    Arrays.fill(this.mData, paramInt, i + 1, -1);
    return i + 1;
  }
  
  final int aW(int paramInt)
  {
    if ((this.mData == null) || (paramInt >= this.mData.length)) {
      return -1;
    }
    return this.mData[paramInt];
  }
  
  public final StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem ba(int paramInt)
  {
    Object localObject;
    if (this.xE == null)
    {
      localObject = null;
      return localObject;
    }
    int i = this.xE.size() - 1;
    for (;;)
    {
      if (i < 0) {
        break label61;
      }
      StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem localFullSpanItem = (StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem)this.xE.get(i);
      localObject = localFullSpanItem;
      if (localFullSpanItem.un == paramInt) {
        break;
      }
      i -= 1;
    }
    label61:
    return null;
  }
  
  final void clear()
  {
    if (this.mData != null) {
      Arrays.fill(this.mData, -1);
    }
    this.xE = null;
  }
  
  public final StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem i(int paramInt1, int paramInt2, int paramInt3)
  {
    Object localObject;
    if (this.xE == null)
    {
      localObject = null;
      return localObject;
    }
    int j = this.xE.size();
    int i = 0;
    for (;;)
    {
      if (i >= j) {
        break label112;
      }
      StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem localFullSpanItem = (StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem)this.xE.get(i);
      if (localFullSpanItem.un >= paramInt2) {
        return null;
      }
      if (localFullSpanItem.un >= paramInt1)
      {
        localObject = localFullSpanItem;
        if (paramInt3 == 0) {
          break;
        }
        localObject = localFullSpanItem;
        if (localFullSpanItem.xF == paramInt3) {
          break;
        }
        localObject = localFullSpanItem;
        if (localFullSpanItem.xH) {
          break;
        }
      }
      i += 1;
    }
    label112:
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.v7.widget.StaggeredGridLayoutManager.LazySpanLookup
 * JD-Core Version:    0.7.0.1
 */