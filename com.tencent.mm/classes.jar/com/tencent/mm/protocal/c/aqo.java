package com.tencent.mm.protocal.c;

import d.a.a.b;
import java.util.LinkedList;

public final class aqo
  extends com.tencent.mm.bv.a
{
  public String hPY;
  public int jwX;
  public String sAY;
  public String sPt;
  public bml tmw;
  public int tmx;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.tmw == null) {
        throw new b("Not all required fields were included: NickName");
      }
      paramVarArgs.gB(1, this.jwX);
      if (this.tmw != null)
      {
        paramVarArgs.gD(2, this.tmw.btq());
        this.tmw.a(paramVarArgs);
      }
      if (this.sAY != null) {
        paramVarArgs.d(3, this.sAY);
      }
      if (this.sPt != null) {
        paramVarArgs.d(4, this.sPt);
      }
      if (this.hPY != null) {
        paramVarArgs.d(5, this.hPY);
      }
      paramVarArgs.gB(6, this.tmx);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = d.a.a.a.gy(1, this.jwX) + 0;
      paramInt = i;
      if (this.tmw != null) {
        paramInt = i + d.a.a.a.gA(2, this.tmw.btq());
      }
      i = paramInt;
      if (this.sAY != null) {
        i = paramInt + d.a.a.b.b.a.e(3, this.sAY);
      }
      paramInt = i;
      if (this.sPt != null) {
        paramInt = i + d.a.a.b.b.a.e(4, this.sPt);
      }
      i = paramInt;
      if (this.hPY != null) {
        i = paramInt + d.a.a.b.b.a.e(5, this.hPY);
      }
      return i + d.a.a.a.gy(6, this.tmx);
    }
    if (paramInt == 2)
    {
      paramVarArgs = new d.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.a(paramVarArgs)) {
        if (!super.a(paramVarArgs, this, paramInt)) {
          paramVarArgs.cUt();
        }
      }
      if (this.tmw == null) {
        throw new b("Not all required fields were included: NickName");
      }
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (d.a.a.a.a)paramVarArgs[0];
      aqo localaqo = (aqo)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        return -1;
      case 1: 
        localaqo.jwX = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      case 2: 
        paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bml();
          localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((bml)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
          localaqo.tmw = ((bml)localObject1);
          paramInt += 1;
        }
        return 0;
      case 3: 
        localaqo.sAY = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      case 4: 
        localaqo.sPt = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      case 5: 
        localaqo.hPY = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      }
      localaqo.tmx = ((d.a.a.a.a)localObject1).xpH.oD();
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.c.aqo
 * JD-Core Version:    0.7.0.1
 */