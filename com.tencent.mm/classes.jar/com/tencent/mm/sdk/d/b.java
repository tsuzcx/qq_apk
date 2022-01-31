package com.tencent.mm.sdk.d;

import com.tencent.mm.sdk.platformtools.y;
import java.io.Serializable;

public class b
  extends c
  implements Serializable
{
  public final String name = getClass().getSimpleName();
  
  public void enter()
  {
    super.enter();
    y.i("LogStateTransitionState", "entering " + this.name);
  }
  
  public void exit()
  {
    super.exit();
    y.i("LogStateTransitionState", "exiting " + this.name);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.sdk.d.b
 * JD-Core Version:    0.7.0.1
 */