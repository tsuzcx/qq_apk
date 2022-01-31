package com.tencent.mm.protocal.c;

import java.util.LinkedList;

public final class qk
  extends blm
{
  public String sCE;
  public int sOl;
  public String sOm;
  public LinkedList<qj> sOn = new LinkedList();
  public int sOo;
  public int scene;
  public String svK;
  
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
      paramVarArgs.gB(2, this.sOl);
      if (this.sOm != null) {
        paramVarArgs.d(3, this.sOm);
      }
      if (this.sCE != null) {
        paramVarArgs.d(4, this.sCE);
      }
      if (this.svK != null) {
        paramVarArgs.d(5, this.svK);
      }
      paramVarArgs.d(6, 8, this.sOn);
      paramVarArgs.gB(7, this.scene);
      paramVarArgs.gB(8, this.sOo);
      return 0;
    }
    if (paramInt == 1) {
      if (this.tEX == null) {
        break label688;
      }
    }
    label688:
    for (paramInt = d.a.a.a.gA(1, this.tEX.btq()) + 0;; paramInt = 0)
    {
      int i = paramInt + d.a.a.a.gy(2, this.sOl);
      paramInt = i;
      if (this.sOm != null) {
        paramInt = i + d.a.a.b.b.a.e(3, this.sOm);
      }
      i = paramInt;
      if (this.sCE != null) {
        i = paramInt + d.a.a.b.b.a.e(4, this.sCE);
      }
      paramInt = i;
      if (this.svK != null) {
        paramInt = i + d.a.a.b.b.a.e(5, this.svK);
      }
      return paramInt + d.a.a.a.c(6, 8, this.sOn) + d.a.a.a.gy(7, this.scene) + d.a.a.a.gy(8, this.sOo);
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.sOn.clear();
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
        qk localqk = (qk)paramVarArgs[1];
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
            localqk.tEX = ((gc)localObject1);
            paramInt += 1;
          }
        case 2: 
          localqk.sOl = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 3: 
          localqk.sOm = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 4: 
          localqk.sCE = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 5: 
          localqk.svK = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 6: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new qj();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((qj)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, blm.a((d.a.a.a.a)localObject2))) {}
            localqk.sOn.add(localObject1);
            paramInt += 1;
          }
        case 7: 
          localqk.scene = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        }
        localqk.sOo = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.c.qk
 * JD-Core Version:    0.7.0.1
 */