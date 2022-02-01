package com.tencent.mm.storagebase.a;

import android.database.Cursor;
import android.util.SparseArray;
import java.util.HashMap;

public abstract interface d<T>
  extends Cursor
{
  public abstract boolean YZ(int paramInt);
  
  public abstract a Za(int paramInt);
  
  public abstract void Zb(int paramInt);
  
  public abstract void a(f.a parama);
  
  public abstract boolean a(Object paramObject, a parama);
  
  public abstract boolean dU(Object paramObject);
  
  public abstract a dV(Object paramObject);
  
  public abstract HashMap<Object, T> fdA();
  
  public abstract boolean fdB();
  
  public abstract SparseArray<T>[] fdz();
  
  public abstract void wg(boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.storagebase.a.d
 * JD-Core Version:    0.7.0.1
 */