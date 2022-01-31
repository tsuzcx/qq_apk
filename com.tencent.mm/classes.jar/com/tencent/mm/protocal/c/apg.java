package com.tencent.mm.protocal.c;

import java.util.LinkedList;

public final class apg
  extends com.tencent.mm.bv.a
{
  public int create_time;
  public int ild;
  public String imz;
  public int qlX;
  public String sMy;
  public long sQd;
  public int state;
  public String tef;
  public String tlk;
  public bek tll;
  public int tlm;
  public int tln;
  public String tlo;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.tef != null) {
        paramVarArgs.d(1, this.tef);
      }
      if (this.sMy != null) {
        paramVarArgs.d(2, this.sMy);
      }
      paramVarArgs.Y(3, this.sQd);
      paramVarArgs.gB(4, this.state);
      if (this.tlk != null) {
        paramVarArgs.d(5, this.tlk);
      }
      paramVarArgs.gB(6, this.qlX);
      if (this.tll != null)
      {
        paramVarArgs.gD(7, this.tll.btq());
        this.tll.a(paramVarArgs);
      }
      paramVarArgs.gB(8, this.create_time);
      paramVarArgs.gB(9, this.ild);
      paramVarArgs.gB(10, this.tlm);
      paramVarArgs.gB(11, this.tln);
      if (this.tlo != null) {
        paramVarArgs.d(12, this.tlo);
      }
      if (this.imz != null) {
        paramVarArgs.d(13, this.imz);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.tef == null) {
        break label829;
      }
    }
    label829:
    for (paramInt = d.a.a.b.b.a.e(1, this.tef) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.sMy != null) {
        i = paramInt + d.a.a.b.b.a.e(2, this.sMy);
      }
      i = i + d.a.a.a.X(3, this.sQd) + d.a.a.a.gy(4, this.state);
      paramInt = i;
      if (this.tlk != null) {
        paramInt = i + d.a.a.b.b.a.e(5, this.tlk);
      }
      i = paramInt + d.a.a.a.gy(6, this.qlX);
      paramInt = i;
      if (this.tll != null) {
        paramInt = i + d.a.a.a.gA(7, this.tll.btq());
      }
      i = paramInt + d.a.a.a.gy(8, this.create_time) + d.a.a.a.gy(9, this.ild) + d.a.a.a.gy(10, this.tlm) + d.a.a.a.gy(11, this.tln);
      paramInt = i;
      if (this.tlo != null) {
        paramInt = i + d.a.a.b.b.a.e(12, this.tlo);
      }
      i = paramInt;
      if (this.imz != null) {
        i = paramInt + d.a.a.b.b.a.e(13, this.imz);
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
        apg localapg = (apg)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          return -1;
        case 1: 
          localapg.tef = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 2: 
          localapg.sMy = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 3: 
          localapg.sQd = ((d.a.a.a.a)localObject1).xpH.oE();
          return 0;
        case 4: 
          localapg.state = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 5: 
          localapg.tlk = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 6: 
          localapg.qlX = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 7: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bek();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((bek)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
            localapg.tll = ((bek)localObject1);
            paramInt += 1;
          }
        case 8: 
          localapg.create_time = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 9: 
          localapg.ild = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 10: 
          localapg.tlm = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 11: 
          localapg.tln = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 12: 
          localapg.tlo = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        }
        localapg.imz = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.c.apg
 * JD-Core Version:    0.7.0.1
 */