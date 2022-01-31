package com.tencent.mm.protocal.c;

import java.util.LinkedList;

public final class ara
  extends blm
{
  public String bOL;
  public int iHt;
  public int scene;
  public String tmJ;
  public String tmK;
  public int tmL;
  public int tmM;
  public String url;
  
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
      if (this.bOL != null) {
        paramVarArgs.d(2, this.bOL);
      }
      if (this.tmJ != null) {
        paramVarArgs.d(3, this.tmJ);
      }
      paramVarArgs.gB(4, this.scene);
      if (this.url != null) {
        paramVarArgs.d(5, this.url);
      }
      if (this.tmK != null) {
        paramVarArgs.d(6, this.tmK);
      }
      paramVarArgs.gB(7, this.iHt);
      paramVarArgs.gB(8, this.tmL);
      paramVarArgs.gB(9, this.tmM);
      return 0;
    }
    if (paramInt == 1) {
      if (this.tEX == null) {
        break label649;
      }
    }
    label649:
    for (int i = d.a.a.a.gA(1, this.tEX.btq()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.bOL != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.bOL);
      }
      i = paramInt;
      if (this.tmJ != null) {
        i = paramInt + d.a.a.b.b.a.e(3, this.tmJ);
      }
      i += d.a.a.a.gy(4, this.scene);
      paramInt = i;
      if (this.url != null) {
        paramInt = i + d.a.a.b.b.a.e(5, this.url);
      }
      i = paramInt;
      if (this.tmK != null) {
        i = paramInt + d.a.a.b.b.a.e(6, this.tmK);
      }
      return i + d.a.a.a.gy(7, this.iHt) + d.a.a.a.gy(8, this.tmL) + d.a.a.a.gy(9, this.tmM);
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
        ara localara = (ara)paramVarArgs[1];
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
            localara.tEX = ((gc)localObject1);
            paramInt += 1;
          }
        case 2: 
          localara.bOL = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 3: 
          localara.tmJ = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 4: 
          localara.scene = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 5: 
          localara.url = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 6: 
          localara.tmK = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 7: 
          localara.iHt = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 8: 
          localara.tmL = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        }
        localara.tmM = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.c.ara
 * JD-Core Version:    0.7.0.1
 */