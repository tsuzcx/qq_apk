package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dfu
  extends com.tencent.mm.bx.a
{
  public int Aob;
  public int Hug;
  public LinkedList<akx> Huh;
  public long Hui;
  public double Huj;
  public double Huk;
  public String bVF;
  public boolean cMS;
  public int commentCount;
  public long endTime;
  public String feedId;
  public int height;
  public boolean isAd;
  public int likeCount;
  public int ltB;
  public int sFm;
  public long startTime;
  public String userName;
  public int vi;
  public int y;
  public int yYM;
  
  public dfu()
  {
    AppMethodBeat.i(122546);
    this.y = -1;
    this.height = -1;
    this.ltB = -1;
    this.Hug = 0;
    this.yYM = -1;
    this.sFm = -1;
    this.vi = 0;
    this.Aob = 0;
    this.cMS = false;
    this.startTime = -1L;
    this.endTime = -1L;
    this.Huh = new LinkedList();
    this.Hui = 0L;
    this.Huj = 0.0D;
    this.Huk = 0.0D;
    this.isAd = false;
    AppMethodBeat.o(122546);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(122547);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.feedId != null) {
        paramVarArgs.d(1, this.feedId);
      }
      paramVarArgs.aS(2, this.y);
      paramVarArgs.aS(3, this.height);
      paramVarArgs.aS(4, this.ltB);
      paramVarArgs.aS(5, this.Hug);
      paramVarArgs.aS(6, this.yYM);
      paramVarArgs.aS(7, this.sFm);
      paramVarArgs.aS(8, this.vi);
      paramVarArgs.aS(9, this.Aob);
      paramVarArgs.bt(10, this.cMS);
      paramVarArgs.aY(11, this.startTime);
      paramVarArgs.aY(12, this.endTime);
      paramVarArgs.e(13, 8, this.Huh);
      paramVarArgs.aY(14, this.Hui);
      paramVarArgs.e(15, this.Huj);
      paramVarArgs.e(16, this.Huk);
      paramVarArgs.aS(17, this.commentCount);
      paramVarArgs.aS(18, this.likeCount);
      if (this.userName != null) {
        paramVarArgs.d(19, this.userName);
      }
      paramVarArgs.bt(20, this.isAd);
      if (this.bVF != null) {
        paramVarArgs.d(21, this.bVF);
      }
      AppMethodBeat.o(122547);
      return 0;
    }
    if (paramInt == 1) {
      if (this.feedId == null) {
        break label1216;
      }
    }
    label1216:
    for (paramInt = f.a.a.b.b.a.e(1, this.feedId) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.y) + f.a.a.b.b.a.bz(3, this.height) + f.a.a.b.b.a.bz(4, this.ltB) + f.a.a.b.b.a.bz(5, this.Hug) + f.a.a.b.b.a.bz(6, this.yYM) + f.a.a.b.b.a.bz(7, this.sFm) + f.a.a.b.b.a.bz(8, this.vi) + f.a.a.b.b.a.bz(9, this.Aob) + f.a.a.b.b.a.alV(10) + f.a.a.b.b.a.p(11, this.startTime) + f.a.a.b.b.a.p(12, this.endTime) + f.a.a.a.c(13, 8, this.Huh) + f.a.a.b.b.a.p(14, this.Hui) + f.a.a.b.b.a.alT(15) + f.a.a.b.b.a.alT(16) + f.a.a.b.b.a.bz(17, this.commentCount) + f.a.a.b.b.a.bz(18, this.likeCount);
      paramInt = i;
      if (this.userName != null) {
        paramInt = i + f.a.a.b.b.a.e(19, this.userName);
      }
      i = paramInt + f.a.a.b.b.a.alV(20);
      paramInt = i;
      if (this.bVF != null) {
        paramInt = i + f.a.a.b.b.a.e(21, this.bVF);
      }
      AppMethodBeat.o(122547);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Huh.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(122547);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dfu localdfu = (dfu)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(122547);
          return -1;
        case 1: 
          localdfu.feedId = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(122547);
          return 0;
        case 2: 
          localdfu.y = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(122547);
          return 0;
        case 3: 
          localdfu.height = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(122547);
          return 0;
        case 4: 
          localdfu.ltB = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(122547);
          return 0;
        case 5: 
          localdfu.Hug = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(122547);
          return 0;
        case 6: 
          localdfu.yYM = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(122547);
          return 0;
        case 7: 
          localdfu.sFm = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(122547);
          return 0;
        case 8: 
          localdfu.vi = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(122547);
          return 0;
        case 9: 
          localdfu.Aob = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(122547);
          return 0;
        case 10: 
          localdfu.cMS = ((f.a.a.a.a)localObject1).NPN.grw();
          AppMethodBeat.o(122547);
          return 0;
        case 11: 
          localdfu.startTime = ((f.a.a.a.a)localObject1).NPN.zd();
          AppMethodBeat.o(122547);
          return 0;
        case 12: 
          localdfu.endTime = ((f.a.a.a.a)localObject1).NPN.zd();
          AppMethodBeat.o(122547);
          return 0;
        case 13: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new akx();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((akx)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdfu.Huh.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(122547);
          return 0;
        case 14: 
          localdfu.Hui = ((f.a.a.a.a)localObject1).NPN.zd();
          AppMethodBeat.o(122547);
          return 0;
        case 15: 
          localdfu.Huj = Double.longBitsToDouble(((f.a.a.a.a)localObject1).NPN.grA());
          AppMethodBeat.o(122547);
          return 0;
        case 16: 
          localdfu.Huk = Double.longBitsToDouble(((f.a.a.a.a)localObject1).NPN.grA());
          AppMethodBeat.o(122547);
          return 0;
        case 17: 
          localdfu.commentCount = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(122547);
          return 0;
        case 18: 
          localdfu.likeCount = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(122547);
          return 0;
        case 19: 
          localdfu.userName = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(122547);
          return 0;
        case 20: 
          localdfu.isAd = ((f.a.a.a.a)localObject1).NPN.grw();
          AppMethodBeat.o(122547);
          return 0;
        }
        localdfu.bVF = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(122547);
        return 0;
      }
      AppMethodBeat.o(122547);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dfu
 * JD-Core Version:    0.7.0.1
 */