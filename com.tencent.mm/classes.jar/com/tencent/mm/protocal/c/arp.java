package com.tencent.mm.protocal.c;

import java.util.LinkedList;

public final class arp
  extends blm
{
  public String euK;
  public LinkedList<String> tmX = new LinkedList();
  public int tmY;
  public int tmZ;
  public cms tna;
  public int tnc;
  public String tnd;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.tEX != null)
      {
        paramVarArgs.gD(1, this.tEX.btq());
        this.tEX.a(paramVarArgs);
      }
      if (this.euK != null) {
        paramVarArgs.d(2, this.euK);
      }
      paramVarArgs.d(3, 1, this.tmX);
      paramVarArgs.gB(4, this.tnc);
      if (this.tnd != null) {
        paramVarArgs.d(6, this.tnd);
      }
      paramVarArgs.gB(7, this.tmY);
      paramVarArgs.gB(8, this.tmZ);
      if (this.tna != null)
      {
        paramVarArgs.gD(9, this.tna.btq());
        this.tna.a(paramVarArgs);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.tEX == null) {
        break label708;
      }
    }
    label708:
    for (paramInt = d.a.a.a.gA(1, this.tEX.btq()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.euK != null) {
        i = paramInt + d.a.a.b.b.a.e(2, this.euK);
      }
      i = i + d.a.a.a.c(3, 1, this.tmX) + d.a.a.a.gy(4, this.tnc);
      paramInt = i;
      if (this.tnd != null) {
        paramInt = i + d.a.a.b.b.a.e(6, this.tnd);
      }
      i = paramInt + d.a.a.a.gy(7, this.tmY) + d.a.a.a.gy(8, this.tmZ);
      paramInt = i;
      if (this.tna != null) {
        paramInt = i + d.a.a.a.gA(9, this.tna.btq());
      }
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.tmX.clear();
        paramVarArgs = new d.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = blm.a(paramVarArgs); paramInt > 0; paramInt = blm.a(paramVarArgs)) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.cUt();
          }
        }
        break;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (d.a.a.a.a)paramVarArgs[0];
        arp localarp = (arp)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        case 5: 
        default: 
          return -1;
        case 1: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new gc();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((gc)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, blm.a((d.a.a.a.a)localObject2))) {}
            localarp.tEX = ((gc)localObject1);
            paramInt += 1;
          }
        case 2: 
          localarp.euK = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 3: 
          localarp.tmX.add(((d.a.a.a.a)localObject1).xpH.readString());
          return 0;
        case 4: 
          localarp.tnc = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 6: 
          localarp.tnd = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 7: 
          localarp.tmY = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 8: 
          localarp.tmZ = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        }
        paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cms();
          localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cms)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, blm.a((d.a.a.a.a)localObject2))) {}
          localarp.tna = ((cms)localObject1);
          paramInt += 1;
        }
        break;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.c.arp
 * JD-Core Version:    0.7.0.1
 */