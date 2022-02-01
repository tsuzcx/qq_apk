package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dah
  extends com.tencent.mm.bw.a
{
  public long FJA;
  public double FJB;
  public double FJC;
  public int FJy;
  public LinkedList<aih> FJz;
  public String bLs;
  public boolean cBT;
  public int commentCount;
  public long endTime;
  public String feedId;
  public int height;
  public boolean isAd;
  public int kWC;
  public int likeCount;
  public int rKm;
  public long startTime;
  public int tp;
  public String userName;
  public int xJx;
  public int y;
  public int yWr;
  
  public dah()
  {
    AppMethodBeat.i(122546);
    this.y = -1;
    this.height = -1;
    this.kWC = -1;
    this.FJy = 0;
    this.xJx = -1;
    this.rKm = -1;
    this.tp = 0;
    this.yWr = 0;
    this.cBT = false;
    this.startTime = -1L;
    this.endTime = -1L;
    this.FJz = new LinkedList();
    this.FJA = 0L;
    this.FJB = 0.0D;
    this.FJC = 0.0D;
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
      paramVarArgs.aR(2, this.y);
      paramVarArgs.aR(3, this.height);
      paramVarArgs.aR(4, this.kWC);
      paramVarArgs.aR(5, this.FJy);
      paramVarArgs.aR(6, this.xJx);
      paramVarArgs.aR(7, this.rKm);
      paramVarArgs.aR(8, this.tp);
      paramVarArgs.aR(9, this.yWr);
      paramVarArgs.bl(10, this.cBT);
      paramVarArgs.aO(11, this.startTime);
      paramVarArgs.aO(12, this.endTime);
      paramVarArgs.e(13, 8, this.FJz);
      paramVarArgs.aO(14, this.FJA);
      paramVarArgs.e(15, this.FJB);
      paramVarArgs.e(16, this.FJC);
      paramVarArgs.aR(17, this.commentCount);
      paramVarArgs.aR(18, this.likeCount);
      if (this.userName != null) {
        paramVarArgs.d(19, this.userName);
      }
      paramVarArgs.bl(20, this.isAd);
      if (this.bLs != null) {
        paramVarArgs.d(21, this.bLs);
      }
      AppMethodBeat.o(122547);
      return 0;
    }
    if (paramInt == 1) {
      if (this.feedId == null) {
        break label1224;
      }
    }
    label1224:
    for (paramInt = f.a.a.b.b.a.e(1, this.feedId) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bx(2, this.y) + f.a.a.b.b.a.bx(3, this.height) + f.a.a.b.b.a.bx(4, this.kWC) + f.a.a.b.b.a.bx(5, this.FJy) + f.a.a.b.b.a.bx(6, this.xJx) + f.a.a.b.b.a.bx(7, this.rKm) + f.a.a.b.b.a.bx(8, this.tp) + f.a.a.b.b.a.bx(9, this.yWr) + (f.a.a.b.b.a.fK(10) + 1) + f.a.a.b.b.a.p(11, this.startTime) + f.a.a.b.b.a.p(12, this.endTime) + f.a.a.a.c(13, 8, this.FJz) + f.a.a.b.b.a.p(14, this.FJA) + (f.a.a.b.b.a.fK(15) + 8) + (f.a.a.b.b.a.fK(16) + 8) + f.a.a.b.b.a.bx(17, this.commentCount) + f.a.a.b.b.a.bx(18, this.likeCount);
      paramInt = i;
      if (this.userName != null) {
        paramInt = i + f.a.a.b.b.a.e(19, this.userName);
      }
      i = paramInt + (f.a.a.b.b.a.fK(20) + 1);
      paramInt = i;
      if (this.bLs != null) {
        paramInt = i + f.a.a.b.b.a.e(21, this.bLs);
      }
      AppMethodBeat.o(122547);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.FJz.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(122547);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dah localdah = (dah)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(122547);
          return -1;
        case 1: 
          localdah.feedId = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(122547);
          return 0;
        case 2: 
          localdah.y = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(122547);
          return 0;
        case 3: 
          localdah.height = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(122547);
          return 0;
        case 4: 
          localdah.kWC = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(122547);
          return 0;
        case 5: 
          localdah.FJy = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(122547);
          return 0;
        case 6: 
          localdah.xJx = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(122547);
          return 0;
        case 7: 
          localdah.rKm = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(122547);
          return 0;
        case 8: 
          localdah.tp = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(122547);
          return 0;
        case 9: 
          localdah.yWr = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(122547);
          return 0;
        case 10: 
          localdah.cBT = ((f.a.a.a.a)localObject1).LVo.fZX();
          AppMethodBeat.o(122547);
          return 0;
        case 11: 
          localdah.startTime = ((f.a.a.a.a)localObject1).LVo.xG();
          AppMethodBeat.o(122547);
          return 0;
        case 12: 
          localdah.endTime = ((f.a.a.a.a)localObject1).LVo.xG();
          AppMethodBeat.o(122547);
          return 0;
        case 13: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new aih();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((aih)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdah.FJz.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(122547);
          return 0;
        case 14: 
          localdah.FJA = ((f.a.a.a.a)localObject1).LVo.xG();
          AppMethodBeat.o(122547);
          return 0;
        case 15: 
          localdah.FJB = Double.longBitsToDouble(((f.a.a.a.a)localObject1).LVo.gab());
          AppMethodBeat.o(122547);
          return 0;
        case 16: 
          localdah.FJC = Double.longBitsToDouble(((f.a.a.a.a)localObject1).LVo.gab());
          AppMethodBeat.o(122547);
          return 0;
        case 17: 
          localdah.commentCount = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(122547);
          return 0;
        case 18: 
          localdah.likeCount = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(122547);
          return 0;
        case 19: 
          localdah.userName = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(122547);
          return 0;
        case 20: 
          localdah.isAd = ((f.a.a.a.a)localObject1).LVo.fZX();
          AppMethodBeat.o(122547);
          return 0;
        }
        localdah.bLs = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(122547);
        return 0;
      }
      AppMethodBeat.o(122547);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dah
 * JD-Core Version:    0.7.0.1
 */