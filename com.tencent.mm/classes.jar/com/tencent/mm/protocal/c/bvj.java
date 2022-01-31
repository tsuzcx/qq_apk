package com.tencent.mm.protocal.c;

import java.util.LinkedList;

public final class bvj
  extends com.tencent.mm.bv.a
{
  public int scene;
  public bvi tMc;
  public bvi tMd;
  public bvi tMe;
  public int tMf;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.tMc != null)
      {
        paramVarArgs.gD(1, this.tMc.btq());
        this.tMc.a(paramVarArgs);
      }
      if (this.tMd != null)
      {
        paramVarArgs.gD(2, this.tMd.btq());
        this.tMd.a(paramVarArgs);
      }
      if (this.tMe != null)
      {
        paramVarArgs.gD(3, this.tMe.btq());
        this.tMe.a(paramVarArgs);
      }
      paramVarArgs.gB(4, this.scene);
      paramVarArgs.gB(5, this.tMf);
      return 0;
    }
    if (paramInt == 1) {
      if (this.tMc == null) {
        break label641;
      }
    }
    label641:
    for (int i = d.a.a.a.gA(1, this.tMc.btq()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.tMd != null) {
        paramInt = i + d.a.a.a.gA(2, this.tMd.btq());
      }
      i = paramInt;
      if (this.tMe != null) {
        i = paramInt + d.a.a.a.gA(3, this.tMe.btq());
      }
      return i + d.a.a.a.gy(4, this.scene) + d.a.a.a.gy(5, this.tMf);
      if (paramInt == 2)
      {
        paramVarArgs = new d.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.a(paramVarArgs)) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.cUt();
          }
        }
        break;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (d.a.a.a.a)paramVarArgs[0];
        bvj localbvj = (bvj)paramVarArgs[1];
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
            localObject1 = new bvi();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bvi)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
            localbvj.tMc = ((bvi)localObject1);
            paramInt += 1;
          }
        case 2: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bvi();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bvi)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
            localbvj.tMd = ((bvi)localObject1);
            paramInt += 1;
          }
        case 3: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bvi();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bvi)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
            localbvj.tMe = ((bvi)localObject1);
            paramInt += 1;
          }
        case 4: 
          localbvj.scene = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        }
        localbvj.tMf = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.protocal.c.bvj
 * JD-Core Version:    0.7.0.1
 */