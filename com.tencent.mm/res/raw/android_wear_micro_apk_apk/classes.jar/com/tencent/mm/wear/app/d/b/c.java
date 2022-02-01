package com.tencent.mm.wear.app.d.b;

import com.tencent.mm.wear.a.c.d;
import com.tencent.mm.wear.app.b.h;
import java.util.ArrayList;
import java.util.List;

public final class c
  extends a
{
  public final void a(int paramInt, byte[] paramArrayOfByte)
  {
    if (paramInt == 20001)
    {
      d.c("MicroMsg.PhoneStartHandler", "handle phone start", new Object[0]);
      h.E(true);
      h.nd();
    }
  }
  
  public final List<Integer> nE()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Integer.valueOf(20001));
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.mm.wear.app.d.b.c
 * JD-Core Version:    0.7.0.1
 */