package com.tencent.mm.protocal.c;

import java.util.LinkedList;

public final class bgq
  extends blm
{
  public long appid;
  public int bHz;
  public int platform;
  public long sDc;
  public int scene;
  public int tBn;
  public long tBo;
  public int tBp;
  public long tBq;
  public long tBr;
  public String tyF;
  
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
      paramVarArgs.gB(2, this.tBn);
      paramVarArgs.Y(3, this.tBo);
      paramVarArgs.Y(4, this.appid);
      paramVarArgs.Y(5, this.sDc);
      paramVarArgs.gB(6, this.tBp);
      paramVarArgs.gB(7, this.scene);
      paramVarArgs.gB(8, this.bHz);
      paramVarArgs.Y(9, this.tBq);
      paramVarArgs.Y(10, this.tBr);
      paramVarArgs.gB(11, this.platform);
      if (this.tyF != null) {
        paramVarArgs.d(12, this.tyF);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.tEX == null) {
        break label714;
      }
    }
    label714:
    for (paramInt = d.a.a.a.gA(1, this.tEX.btq()) + 0;; paramInt = 0)
    {
      int i = paramInt + d.a.a.a.gy(2, this.tBn) + d.a.a.a.X(3, this.tBo) + d.a.a.a.X(4, this.appid) + d.a.a.a.X(5, this.sDc) + d.a.a.a.gy(6, this.tBp) + d.a.a.a.gy(7, this.scene) + d.a.a.a.gy(8, this.bHz) + d.a.a.a.X(9, this.tBq) + d.a.a.a.X(10, this.tBr) + d.a.a.a.gy(11, this.platform);
      paramInt = i;
      if (this.tyF != null) {
        paramInt = i + d.a.a.b.b.a.e(12, this.tyF);
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
        bgq localbgq = (bgq)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
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
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new gc();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((gc)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, blm.a((d.a.a.a.a)localObject2))) {}
            localbgq.tEX = ((gc)localObject1);
            paramInt += 1;
          }
        case 2: 
          localbgq.tBn = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 3: 
          localbgq.tBo = ((d.a.a.a.a)localObject1).xpH.oE();
          return 0;
        case 4: 
          localbgq.appid = ((d.a.a.a.a)localObject1).xpH.oE();
          return 0;
        case 5: 
          localbgq.sDc = ((d.a.a.a.a)localObject1).xpH.oE();
          return 0;
        case 6: 
          localbgq.tBp = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 7: 
          localbgq.scene = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 8: 
          localbgq.bHz = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 9: 
          localbgq.tBq = ((d.a.a.a.a)localObject1).xpH.oE();
          return 0;
        case 10: 
          localbgq.tBr = ((d.a.a.a.a)localObject1).xpH.oE();
          return 0;
        case 11: 
          localbgq.platform = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        }
        localbgq.tyF = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.c.bgq
 * JD-Core Version:    0.7.0.1
 */