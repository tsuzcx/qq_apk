package com.tencent.mm.storagebase.a;

import android.database.Cursor;
import android.util.SparseArray;
import java.util.HashMap;

public abstract interface d<T>
  extends Cursor
{
  public abstract boolean WP(int paramInt);
  
  public abstract a WQ(int paramInt);
  
  public abstract void WR(int paramInt);
  
  public abstract void a(f.a parama);
  
  public abstract boolean a(Object paramObject, a parama);
  
  public abstract boolean dT(Object paramObject);
  
  public abstract a dU(Object paramObject);
  
  public abstract SparseArray<T>[] eNV();
  
  public abstract HashMap<Object, T> eNW();
  
  public abstract boolean eNX();
  
  public abstract void ve(boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.storagebase.a.d
 * JD-Core Version:    0.7.0.1
 */