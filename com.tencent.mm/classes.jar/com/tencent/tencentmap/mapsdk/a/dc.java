package com.tencent.tencentmap.mapsdk.a;

import java.io.Serializable;

public abstract class dc
  implements Serializable
{
  public abstract void a(da paramda);
  
  public abstract void a(db paramdb);
  
  public final byte[] a()
  {
    db localdb = new db();
    a(localdb);
    return localdb.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.dc
 * JD-Core Version:    0.7.0.1
 */