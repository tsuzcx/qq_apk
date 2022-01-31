package com.tencent.mm.protocal.c;

import com.tencent.mm.bv.b;
import java.util.LinkedList;

public final class art
  extends blm
{
  public String euK;
  public b hPF;
  public int tmY;
  public int tmZ;
  public cms tna;
  public String tnh;
  
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
      if (this.hPF != null) {
        paramVarArgs.b(3, this.hPF);
      }
      if (this.tnh != null) {
        paramVarArgs.d(4, this.tnh);
      }
      paramVarArgs.gB(5, this.tmY);
      paramVarArgs.gB(6, this.tmZ);
      if (this.tna != null)
      {
        paramVarArgs.gD(7, this.tna.btq());
        this.tna.a(paramVarArgs);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.tEX == null) {
        break label662;
      }
    }
    label662:
    for (int i = d.a.a.a.gA(1, this.tEX.btq()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.euK != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.euK);
      }
      i = paramInt;
      if (this.hPF != null) {
        i = paramInt + d.a.a.a.a(3, this.hPF);
      }
      paramInt = i;
      if (this.tnh != null) {
        paramInt = i + d.a.a.b.b.a.e(4, this.tnh);
      }
      i = paramInt + d.a.a.a.gy(5, this.tmY) + d.a.a.a.gy(6, this.tmZ);
      paramInt = i;
      if (this.tna != null) {
        paramInt = i + d.a.a.a.gA(7, this.tna.btq());
      }
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new d.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
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
        art localart = (art)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
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
            localart.tEX = ((gc)localObject1);
            paramInt += 1;
          }
        case 2: 
          localart.euK = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 3: 
          localart.hPF = ((d.a.a.a.a)localObject1).cUs();
          return 0;
        case 4: 
          localart.tnh = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 5: 
          localart.tmY = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 6: 
          localart.tmZ = ((d.a.a.a.a)localObject1).xpH.oD();
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
          localart.tna = ((cms)localObject1);
          paramInt += 1;
        }
        break;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.c.art
 * JD-Core Version:    0.7.0.1
 */