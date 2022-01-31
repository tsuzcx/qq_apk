package com.tencent.mm.protocal.c;

import java.util.LinkedList;

public final class h
  extends blm
{
  public int scene;
  public String srr;
  public LinkedList<j> srv = new LinkedList();
  public aw srw;
  public long srx;
  public long srz;
  public String title;
  
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
      if (this.title != null) {
        paramVarArgs.d(2, this.title);
      }
      paramVarArgs.Y(3, this.srz);
      paramVarArgs.d(5, 8, this.srv);
      paramVarArgs.gB(7, this.scene);
      if (this.srr != null) {
        paramVarArgs.d(8, this.srr);
      }
      if (this.srw != null)
      {
        paramVarArgs.gD(9, this.srw.btq());
        this.srw.a(paramVarArgs);
      }
      paramVarArgs.Y(10, this.srx);
      return 0;
    }
    if (paramInt == 1) {
      if (this.tEX == null) {
        break label790;
      }
    }
    label790:
    for (paramInt = d.a.a.a.gA(1, this.tEX.btq()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.title != null) {
        i = paramInt + d.a.a.b.b.a.e(2, this.title);
      }
      i = i + d.a.a.a.X(3, this.srz) + d.a.a.a.c(5, 8, this.srv) + d.a.a.a.gy(7, this.scene);
      paramInt = i;
      if (this.srr != null) {
        paramInt = i + d.a.a.b.b.a.e(8, this.srr);
      }
      i = paramInt;
      if (this.srw != null) {
        i = paramInt + d.a.a.a.gA(9, this.srw.btq());
      }
      return i + d.a.a.a.X(10, this.srx);
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.srv.clear();
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
        h localh = (h)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        case 4: 
        case 6: 
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
            localh.tEX = ((gc)localObject1);
            paramInt += 1;
          }
        case 2: 
          localh.title = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 3: 
          localh.srz = ((d.a.a.a.a)localObject1).xpH.oE();
          return 0;
        case 5: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new j();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((j)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, blm.a((d.a.a.a.a)localObject2))) {}
            localh.srv.add(localObject1);
            paramInt += 1;
          }
        case 7: 
          localh.scene = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 8: 
          localh.srr = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 9: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new aw();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((aw)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, blm.a((d.a.a.a.a)localObject2))) {}
            localh.srw = ((aw)localObject1);
            paramInt += 1;
          }
        }
        localh.srx = ((d.a.a.a.a)localObject1).xpH.oE();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.c.h
 * JD-Core Version:    0.7.0.1
 */