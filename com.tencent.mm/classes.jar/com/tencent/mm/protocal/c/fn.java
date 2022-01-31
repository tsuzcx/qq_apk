package com.tencent.mm.protocal.c;

import d.a.a.b;
import java.util.LinkedList;

public final class fn
  extends com.tencent.mm.bv.a
  implements bsi
{
  public String ID;
  public bmk syK;
  public String szd;
  public int sze;
  public bmk szf;
  public String szg;
  public int szh;
  public String szi;
  public String szj;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    int i;
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.szf == null) {
        throw new b("Not all required fields were included: QRCodeBuffer");
      }
      if (this.syK == null) {
        throw new b("Not all required fields were included: Key");
      }
      paramVarArgs.gB(1, this.sze);
      if (this.szf != null)
      {
        paramVarArgs.gD(2, this.szf.btq());
        this.szf.a(paramVarArgs);
      }
      if (this.szg != null) {
        paramVarArgs.d(3, this.szg);
      }
      if (this.syK != null)
      {
        paramVarArgs.gD(4, this.syK.btq());
        this.syK.a(paramVarArgs);
      }
      if (this.szi != null) {
        paramVarArgs.d(5, this.szi);
      }
      if (this.szj != null) {
        paramVarArgs.d(6, this.szj);
      }
      paramVarArgs.gB(7, this.szh);
      if (this.ID != null) {
        paramVarArgs.d(8, this.ID);
      }
      if (this.szd != null) {
        paramVarArgs.d(9, this.szd);
      }
      i = 0;
    }
    do
    {
      return i;
      if (paramInt != 1) {
        break;
      }
      i = d.a.a.a.gy(1, this.sze) + 0;
      paramInt = i;
      if (this.szf != null) {
        paramInt = i + d.a.a.a.gA(2, this.szf.btq());
      }
      i = paramInt;
      if (this.szg != null) {
        i = paramInt + d.a.a.b.b.a.e(3, this.szg);
      }
      paramInt = i;
      if (this.syK != null) {
        paramInt = i + d.a.a.a.gA(4, this.syK.btq());
      }
      i = paramInt;
      if (this.szi != null) {
        i = paramInt + d.a.a.b.b.a.e(5, this.szi);
      }
      paramInt = i;
      if (this.szj != null) {
        paramInt = i + d.a.a.b.b.a.e(6, this.szj);
      }
      i = paramInt + d.a.a.a.gy(7, this.szh);
      paramInt = i;
      if (this.ID != null) {
        paramInt = i + d.a.a.b.b.a.e(8, this.ID);
      }
      i = paramInt;
    } while (this.szd == null);
    return paramInt + d.a.a.b.b.a.e(9, this.szd);
    if (paramInt == 2)
    {
      paramVarArgs = new d.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.a(paramVarArgs)) {
        if (!super.a(paramVarArgs, this, paramInt)) {
          paramVarArgs.cUt();
        }
      }
      if (this.szf == null) {
        throw new b("Not all required fields were included: QRCodeBuffer");
      }
      if (this.syK == null) {
        throw new b("Not all required fields were included: Key");
      }
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (d.a.a.a.a)paramVarArgs[0];
      fn localfn = (fn)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        return -1;
      case 1: 
        localfn.sze = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      case 2: 
        paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bmk();
          localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bmk)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
          localfn.szf = ((bmk)localObject1);
          paramInt += 1;
        }
        return 0;
      case 3: 
        localfn.szg = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      case 4: 
        paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bmk();
          localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bmk)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
          localfn.syK = ((bmk)localObject1);
          paramInt += 1;
        }
        return 0;
      case 5: 
        localfn.szi = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      case 6: 
        localfn.szj = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      case 7: 
        localfn.szh = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      case 8: 
        localfn.ID = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      }
      localfn.szd = ((d.a.a.a.a)localObject1).xpH.readString();
      return 0;
    }
    return -1;
  }
  
  public final int getRet()
  {
    return this.sze;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.c.fn
 * JD-Core Version:    0.7.0.1
 */