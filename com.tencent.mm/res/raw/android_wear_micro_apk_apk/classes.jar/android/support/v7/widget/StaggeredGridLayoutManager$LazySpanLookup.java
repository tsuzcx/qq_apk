package android.support.v7.widget;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

final class StaggeredGridLayoutManager$LazySpanLookup
{
  int[] mData;
  List<StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem> vP;
  
  final void I(int paramInt1, int paramInt2)
  {
    if ((this.mData == null) || (paramInt1 >= this.mData.length)) {}
    do
    {
      return;
      aF(paramInt1 + paramInt2);
      System.arraycopy(this.mData, paramInt1 + paramInt2, this.mData, paramInt1, this.mData.length - paramInt1 - paramInt2);
      Arrays.fill(this.mData, this.mData.length - paramInt2, this.mData.length, -1);
    } while (this.vP == null);
    int i = this.vP.size() - 1;
    label87:
    StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem localFullSpanItem;
    if (i >= 0)
    {
      localFullSpanItem = (StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem)this.vP.get(i);
      if (localFullSpanItem.sx >= paramInt1)
      {
        if (localFullSpanItem.sx >= paramInt1 + paramInt2) {
          break label144;
        }
        this.vP.remove(i);
      }
    }
    for (;;)
    {
      i -= 1;
      break label87;
      break;
      label144:
      localFullSpanItem.sx -= paramInt2;
    }
  }
  
  final void J(int paramInt1, int paramInt2)
  {
    if ((this.mData == null) || (paramInt1 >= this.mData.length)) {}
    for (;;)
    {
      return;
      aF(paramInt1 + paramInt2);
      System.arraycopy(this.mData, paramInt1, this.mData, paramInt1 + paramInt2, this.mData.length - paramInt1 - paramInt2);
      Arrays.fill(this.mData, paramInt1, paramInt1 + paramInt2, -1);
      if (this.vP != null)
      {
        int i = this.vP.size() - 1;
        while (i >= 0)
        {
          StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem localFullSpanItem = (StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem)this.vP.get(i);
          if (localFullSpanItem.sx >= paramInt1) {
            localFullSpanItem.sx += paramInt2;
          }
          i -= 1;
        }
      }
    }
  }
  
  public final void a(StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem paramFullSpanItem)
  {
    if (this.vP == null) {
      this.vP = new ArrayList();
    }
    int j = this.vP.size();
    int i = 0;
    while (i < j)
    {
      StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem localFullSpanItem = (StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem)this.vP.get(i);
      if (localFullSpanItem.sx == paramFullSpanItem.sx) {
        this.vP.remove(i);
      }
      if (localFullSpanItem.sx >= paramFullSpanItem.sx)
      {
        this.vP.add(i, paramFullSpanItem);
        return;
      }
      i += 1;
    }
    this.vP.add(paramFullSpanItem);
  }
  
  final int aD(int paramInt)
  {
    if (this.vP != null)
    {
      int i = this.vP.size() - 1;
      while (i >= 0)
      {
        if (((StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem)this.vP.get(i)).sx >= paramInt) {
          this.vP.remove(i);
        }
        i -= 1;
      }
    }
    return aE(paramInt);
  }
  
  final int aE(int paramInt)
  {
    if (this.mData == null) {
      return -1;
    }
    if (paramInt >= this.mData.length) {
      return -1;
    }
    StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem localFullSpanItem;
    int i;
    if (this.vP != null)
    {
      localFullSpanItem = aG(paramInt);
      if (localFullSpanItem != null) {
        this.vP.remove(localFullSpanItem);
      }
      int j = this.vP.size();
      i = 0;
      if (i >= j) {
        break label178;
      }
      if (((StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem)this.vP.get(i)).sx < paramInt) {}
    }
    for (;;)
    {
      if (i != -1)
      {
        localFullSpanItem = (StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem)this.vP.get(i);
        this.vP.remove(i);
      }
      for (i = localFullSpanItem.sx;; i = -1)
      {
        if (i != -1) {
          break label162;
        }
        Arrays.fill(this.mData, paramInt, this.mData.length, -1);
        return this.mData.length;
        i += 1;
        break;
      }
      label162:
      Arrays.fill(this.mData, paramInt, i + 1, -1);
      return i + 1;
      label178:
      i = -1;
    }
  }
  
  final void aF(int paramInt)
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
    int i = this.mData.length;
    while (i <= paramInt) {
      i *= 2;
    }
    this.mData = new int[i];
    System.arraycopy(arrayOfInt, 0, this.mData, 0, arrayOfInt.length);
    Arrays.fill(this.mData, arrayOfInt.length, this.mData.length, -1);
  }
  
  public final StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem aG(int paramInt)
  {
    Object localObject;
    if (this.vP == null)
    {
      localObject = null;
      return localObject;
    }
    int i = this.vP.size() - 1;
    for (;;)
    {
      if (i < 0) {
        break label61;
      }
      StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem localFullSpanItem = (StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem)this.vP.get(i);
      localObject = localFullSpanItem;
      if (localFullSpanItem.sx == paramInt) {
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
    this.vP = null;
  }
  
  public final StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem i(int paramInt1, int paramInt2, int paramInt3)
  {
    Object localObject;
    if (this.vP == null)
    {
      localObject = null;
      return localObject;
    }
    int j = this.vP.size();
    int i = 0;
    for (;;)
    {
      if (i >= j) {
        break label112;
      }
      StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem localFullSpanItem = (StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem)this.vP.get(i);
      if (localFullSpanItem.sx >= paramInt2) {
        return null;
      }
      if (localFullSpanItem.sx >= paramInt1)
      {
        localObject = localFullSpanItem;
        if (paramInt3 == 0) {
          break;
        }
        localObject = localFullSpanItem;
        if (localFullSpanItem.vQ == paramInt3) {
          break;
        }
        localObject = localFullSpanItem;
        if (localFullSpanItem.vS) {
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