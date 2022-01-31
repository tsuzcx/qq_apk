package com.tencent.mm.plugin.wear.model.e;

import com.tencent.mm.plugin.wear.model.h;
import java.util.ArrayList;
import java.util.List;

public final class n
  extends a
{
  public final List<Integer> bYY()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Integer.valueOf(11033));
    localArrayList.add(Integer.valueOf(11030));
    return localArrayList;
  }
  
  protected final byte[] p(int paramInt, byte[] paramArrayOfByte)
  {
    switch (paramInt)
    {
    case 11031: 
    case 11032: 
    default: 
      return null;
    case 11030: 
      if (new String(paramArrayOfByte).equals("arm_v7")) {
        return h.Rk("wechatvoicesilk_v7a");
      }
      return h.Rk("wechatvoicesilk");
    }
    return h.Rk("stlport_shared");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wear.model.e.n
 * JD-Core Version:    0.7.0.1
 */