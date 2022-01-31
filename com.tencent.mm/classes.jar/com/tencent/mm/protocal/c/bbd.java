package com.tencent.mm.protocal.c;

import java.util.LinkedList;

public final class bbd
  extends com.tencent.mm.bv.a
{
  public String app_id;
  public String ePQ;
  public String fGK;
  public String nickname;
  public int sex;
  public int source;
  public String svT;
  public String twW;
  public String twX;
  public String txg;
  public String txi;
  public String txj;
  public String txk;
  public String txl;
  public bbe txm;
  public int type;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.ePQ != null) {
        paramVarArgs.d(1, this.ePQ);
      }
      if (this.nickname != null) {
        paramVarArgs.d(2, this.nickname);
      }
      paramVarArgs.gB(3, this.type);
      if (this.fGK != null) {
        paramVarArgs.d(4, this.fGK);
      }
      if (this.twW != null) {
        paramVarArgs.d(5, this.twW);
      }
      if (this.twX != null) {
        paramVarArgs.d(6, this.twX);
      }
      paramVarArgs.gB(7, this.source);
      if (this.txi != null) {
        paramVarArgs.d(8, this.txi);
      }
      if (this.txj != null) {
        paramVarArgs.d(9, this.txj);
      }
      if (this.txk != null) {
        paramVarArgs.d(10, this.txk);
      }
      if (this.txl != null) {
        paramVarArgs.d(11, this.txl);
      }
      if (this.txm != null)
      {
        paramVarArgs.gD(12, this.txm.btq());
        this.txm.a(paramVarArgs);
      }
      if (this.svT != null) {
        paramVarArgs.d(13, this.svT);
      }
      if (this.app_id != null) {
        paramVarArgs.d(14, this.app_id);
      }
      paramVarArgs.gB(15, this.sex);
      if (this.txg != null) {
        paramVarArgs.d(16, this.txg);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.ePQ == null) {
        break label1070;
      }
    }
    label1070:
    for (paramInt = d.a.a.b.b.a.e(1, this.ePQ) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.nickname != null) {
        i = paramInt + d.a.a.b.b.a.e(2, this.nickname);
      }
      i += d.a.a.a.gy(3, this.type);
      paramInt = i;
      if (this.fGK != null) {
        paramInt = i + d.a.a.b.b.a.e(4, this.fGK);
      }
      i = paramInt;
      if (this.twW != null) {
        i = paramInt + d.a.a.b.b.a.e(5, this.twW);
      }
      paramInt = i;
      if (this.twX != null) {
        paramInt = i + d.a.a.b.b.a.e(6, this.twX);
      }
      i = paramInt + d.a.a.a.gy(7, this.source);
      paramInt = i;
      if (this.txi != null) {
        paramInt = i + d.a.a.b.b.a.e(8, this.txi);
      }
      i = paramInt;
      if (this.txj != null) {
        i = paramInt + d.a.a.b.b.a.e(9, this.txj);
      }
      paramInt = i;
      if (this.txk != null) {
        paramInt = i + d.a.a.b.b.a.e(10, this.txk);
      }
      i = paramInt;
      if (this.txl != null) {
        i = paramInt + d.a.a.b.b.a.e(11, this.txl);
      }
      paramInt = i;
      if (this.txm != null) {
        paramInt = i + d.a.a.a.gA(12, this.txm.btq());
      }
      i = paramInt;
      if (this.svT != null) {
        i = paramInt + d.a.a.b.b.a.e(13, this.svT);
      }
      paramInt = i;
      if (this.app_id != null) {
        paramInt = i + d.a.a.b.b.a.e(14, this.app_id);
      }
      i = paramInt + d.a.a.a.gy(15, this.sex);
      paramInt = i;
      if (this.txg != null) {
        paramInt = i + d.a.a.b.b.a.e(16, this.txg);
      }
      return paramInt;
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
        bbd localbbd = (bbd)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          return -1;
        case 1: 
          localbbd.ePQ = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 2: 
          localbbd.nickname = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 3: 
          localbbd.type = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 4: 
          localbbd.fGK = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 5: 
          localbbd.twW = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 6: 
          localbbd.twX = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 7: 
          localbbd.source = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 8: 
          localbbd.txi = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 9: 
          localbbd.txj = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 10: 
          localbbd.txk = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 11: 
          localbbd.txl = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 12: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bbe();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((bbe)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
            localbbd.txm = ((bbe)localObject1);
            paramInt += 1;
          }
        case 13: 
          localbbd.svT = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 14: 
          localbbd.app_id = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 15: 
          localbbd.sex = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        }
        localbbd.txg = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.c.bbd
 * JD-Core Version:    0.7.0.1
 */