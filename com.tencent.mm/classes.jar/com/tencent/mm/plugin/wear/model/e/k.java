package com.tencent.mm.plugin.wear.model.e;

import com.tencent.mm.chatroom.e.b;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.model.s;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.plugin.wear.model.g;
import com.tencent.mm.protocal.c.cjx;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

public final class k
  extends a
{
  public final List<Integer> bYY()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Integer.valueOf(11011));
    localArrayList.add(Integer.valueOf(11010));
    return localArrayList;
  }
  
  protected final byte[] p(int paramInt, byte[] paramArrayOfByte)
  {
    Object localObject;
    switch (paramInt)
    {
    default: 
      return null;
    case 11010: 
      localObject = new cjx();
    }
    try
    {
      ((cjx)localObject).aH(paramArrayOfByte);
      label40:
      com.tencent.mm.plugin.wear.model.a.bYL().qRw.cI(((cjx)localObject).tXp, ((cjx)localObject).tXB);
      return null;
      try
      {
        paramArrayOfByte = new String(paramArrayOfByte, "utf8");
        au.Hx();
        localObject = c.Fw().abl(paramArrayOfByte);
        if (s.fn(paramArrayOfByte))
        {
          au.Hx();
          localObject = c.Fw().abl(paramArrayOfByte);
          ((ad)localObject).fq(0);
          au.Hx();
          c.Fw().a(paramArrayOfByte, (ad)localObject);
          au.Hx();
          c.Fv().b(new b(paramArrayOfByte, 0));
          com.tencent.mm.plugin.wear.model.c.a.ez(4, 0);
          return null;
        }
      }
      catch (UnsupportedEncodingException paramArrayOfByte)
      {
        for (;;)
        {
          paramArrayOfByte = "";
          continue;
          s.o((ad)localObject);
        }
      }
    }
    catch (IOException paramArrayOfByte)
    {
      break label40;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wear.model.e.k
 * JD-Core Version:    0.7.0.1
 */