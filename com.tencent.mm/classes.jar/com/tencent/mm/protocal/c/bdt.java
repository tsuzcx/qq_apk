package com.tencent.mm.protocal.c;

import java.util.LinkedList;

public final class bdt
  extends com.tencent.mm.bv.a
{
  public String desc;
  public String ilp;
  public String name;
  public int qho;
  public String qhp;
  public String qhq;
  public String qhr;
  public String title;
  public bju tzc;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.name != null) {
        paramVarArgs.d(1, this.name);
      }
      if (this.title != null) {
        paramVarArgs.d(2, this.title);
      }
      if (this.desc != null) {
        paramVarArgs.d(3, this.desc);
      }
      if (this.ilp != null) {
        paramVarArgs.d(4, this.ilp);
      }
      paramVarArgs.gB(5, this.qho);
      if (this.qhp != null) {
        paramVarArgs.d(6, this.qhp);
      }
      if (this.qhq != null) {
        paramVarArgs.d(7, this.qhq);
      }
      if (this.qhr != null) {
        paramVarArgs.d(8, this.qhr);
      }
      if (this.tzc != null)
      {
        paramVarArgs.gD(9, this.tzc.btq());
        this.tzc.a(paramVarArgs);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.name == null) {
        break label705;
      }
    }
    label705:
    for (int i = d.a.a.b.b.a.e(1, this.name) + 0;; i = 0)
    {
      paramInt = i;
      if (this.title != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.title);
      }
      i = paramInt;
      if (this.desc != null) {
        i = paramInt + d.a.a.b.b.a.e(3, this.desc);
      }
      paramInt = i;
      if (this.ilp != null) {
        paramInt = i + d.a.a.b.b.a.e(4, this.ilp);
      }
      i = paramInt + d.a.a.a.gy(5, this.qho);
      paramInt = i;
      if (this.qhp != null) {
        paramInt = i + d.a.a.b.b.a.e(6, this.qhp);
      }
      i = paramInt;
      if (this.qhq != null) {
        i = paramInt + d.a.a.b.b.a.e(7, this.qhq);
      }
      paramInt = i;
      if (this.qhr != null) {
        paramInt = i + d.a.a.b.b.a.e(8, this.qhr);
      }
      i = paramInt;
      if (this.tzc != null) {
        i = paramInt + d.a.a.a.gA(9, this.tzc.btq());
      }
      return i;
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
        bdt localbdt = (bdt)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          return -1;
        case 1: 
          localbdt.name = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 2: 
          localbdt.title = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 3: 
          localbdt.desc = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 4: 
          localbdt.ilp = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 5: 
          localbdt.qho = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 6: 
          localbdt.qhp = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 7: 
          localbdt.qhq = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 8: 
          localbdt.qhr = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        }
        paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bju();
          localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((bju)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
          localbdt.tzc = ((bju)localObject1);
          paramInt += 1;
        }
        break;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.c.bdt
 * JD-Core Version:    0.7.0.1
 */