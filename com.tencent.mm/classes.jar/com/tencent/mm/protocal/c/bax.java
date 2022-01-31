package com.tencent.mm.protocal.c;

import java.util.LinkedList;

public final class bax
  extends com.tencent.mm.bv.a
{
  public String app_id;
  public String ePR;
  public int mdq;
  public int tfo;
  public baz tfp;
  public int twQ;
  public bay twR;
  public int twS;
  public int twT;
  public int twU;
  public int twV;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.ePR != null) {
        paramVarArgs.d(1, this.ePR);
      }
      paramVarArgs.gB(2, this.twQ);
      if (this.twR != null)
      {
        paramVarArgs.gD(3, this.twR.btq());
        this.twR.a(paramVarArgs);
      }
      paramVarArgs.gB(4, this.tfo);
      if (this.tfp != null)
      {
        paramVarArgs.gD(5, this.tfp.btq());
        this.tfp.a(paramVarArgs);
      }
      paramVarArgs.gB(6, this.twS);
      paramVarArgs.gB(7, this.twT);
      paramVarArgs.gB(8, this.mdq);
      paramVarArgs.gB(9, this.twU);
      if (this.app_id != null) {
        paramVarArgs.d(10, this.app_id);
      }
      paramVarArgs.gB(11, this.twV);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ePR == null) {
        break label805;
      }
    }
    label805:
    for (paramInt = d.a.a.b.b.a.e(1, this.ePR) + 0;; paramInt = 0)
    {
      int i = paramInt + d.a.a.a.gy(2, this.twQ);
      paramInt = i;
      if (this.twR != null) {
        paramInt = i + d.a.a.a.gA(3, this.twR.btq());
      }
      i = paramInt + d.a.a.a.gy(4, this.tfo);
      paramInt = i;
      if (this.tfp != null) {
        paramInt = i + d.a.a.a.gA(5, this.tfp.btq());
      }
      i = paramInt + d.a.a.a.gy(6, this.twS) + d.a.a.a.gy(7, this.twT) + d.a.a.a.gy(8, this.mdq) + d.a.a.a.gy(9, this.twU);
      paramInt = i;
      if (this.app_id != null) {
        paramInt = i + d.a.a.b.b.a.e(10, this.app_id);
      }
      return paramInt + d.a.a.a.gy(11, this.twV);
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
        bax localbax = (bax)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          return -1;
        case 1: 
          localbax.ePR = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 2: 
          localbax.twQ = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 3: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bay();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bay)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
            localbax.twR = ((bay)localObject1);
            paramInt += 1;
          }
        case 4: 
          localbax.tfo = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 5: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new baz();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((baz)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
            localbax.tfp = ((baz)localObject1);
            paramInt += 1;
          }
        case 6: 
          localbax.twS = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 7: 
          localbax.twT = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 8: 
          localbax.mdq = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 9: 
          localbax.twU = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 10: 
          localbax.app_id = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        }
        localbax.twV = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.c.bax
 * JD-Core Version:    0.7.0.1
 */