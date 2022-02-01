package com.tencent.mm.storagebase.a;

import android.database.Cursor;
import android.util.SparseArray;
import java.util.HashMap;

public abstract interface d<T>
  extends Cursor
{
  public abstract void a(f.a parama);
  
  public abstract boolean a(Object paramObject, a parama);
  
  public abstract boolean abi(int paramInt);
  
  public abstract a abj(int paramInt);
  
  public abstract void abk(int paramInt);
  
  public abstract boolean dX(Object paramObject);
  
  public abstract a dY(Object paramObject);
  
  public abstract SparseArray<T>[] ftH();
  
  public abstract HashMap<Object, T> ftI();
  
  public abstract boolean ftJ();
  
  public abstract void wS(boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.storagebase.a.d
 * JD-Core Version:    0.7.0.1
 */