package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cuv
  extends com.tencent.mm.bx.a
{
  public LinkedList<ahi> EmA;
  public long EmB;
  public double EmC;
  public double EmD;
  public int Emz;
  public String bNK;
  public boolean cEL;
  public int commentCount;
  public long endTime;
  public String feedId;
  public int height;
  public boolean isAd;
  public int kvo;
  public int likeCount;
  public int qPe;
  public int sq;
  public long startTime;
  public String userName;
  public int wxW;
  public int xJB;
  public int y;
  
  public cuv()
  {
    AppMethodBeat.i(122546);
    this.y = -1;
    this.height = -1;
    this.kvo = -1;
    this.Emz = 0;
    this.wxW = -1;
    this.qPe = -1;
    this.sq = 0;
    this.xJB = 0;
    this.cEL = false;
    this.startTime = -1L;
    this.endTime = -1L;
    this.EmA = new LinkedList();
    this.EmB = 0L;
    this.EmC = 0.0D;
    this.EmD = 0.0D;
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
      paramVarArgs.aR(4, this.kvo);
      paramVarArgs.aR(5, this.Emz);
      paramVarArgs.aR(6, this.wxW);
      paramVarArgs.aR(7, this.qPe);
      paramVarArgs.aR(8, this.sq);
      paramVarArgs.aR(9, this.xJB);
      paramVarArgs.bg(10, this.cEL);
      paramVarArgs.aG(11, this.startTime);
      paramVarArgs.aG(12, this.endTime);
      paramVarArgs.e(13, 8, this.EmA);
      paramVarArgs.aG(14, this.EmB);
      paramVarArgs.e(15, this.EmC);
      paramVarArgs.e(16, this.EmD);
      paramVarArgs.aR(17, this.commentCount);
      paramVarArgs.aR(18, this.likeCount);
      if (this.userName != null) {
        paramVarArgs.d(19, this.userName);
      }
      paramVarArgs.bg(20, this.isAd);
      if (this.bNK != null) {
        paramVarArgs.d(21, this.bNK);
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
      int i = paramInt + f.a.a.b.b.a.bA(2, this.y) + f.a.a.b.b.a.bA(3, this.height) + f.a.a.b.b.a.bA(4, this.kvo) + f.a.a.b.b.a.bA(5, this.Emz) + f.a.a.b.b.a.bA(6, this.wxW) + f.a.a.b.b.a.bA(7, this.qPe) + f.a.a.b.b.a.bA(8, this.sq) + f.a.a.b.b.a.bA(9, this.xJB) + (f.a.a.b.b.a.fY(10) + 1) + f.a.a.b.b.a.q(11, this.startTime) + f.a.a.b.b.a.q(12, this.endTime) + f.a.a.a.c(13, 8, this.EmA) + f.a.a.b.b.a.q(14, this.EmB) + (f.a.a.b.b.a.fY(15) + 8) + (f.a.a.b.b.a.fY(16) + 8) + f.a.a.b.b.a.bA(17, this.commentCount) + f.a.a.b.b.a.bA(18, this.likeCount);
      paramInt = i;
      if (this.userName != null) {
        paramInt = i + f.a.a.b.b.a.e(19, this.userName);
      }
      i = paramInt + (f.a.a.b.b.a.fY(20) + 1);
      paramInt = i;
      if (this.bNK != null) {
        paramInt = i + f.a.a.b.b.a.e(21, this.bNK);
      }
      AppMethodBeat.o(122547);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.EmA.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(122547);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cuv localcuv = (cuv)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(122547);
          return -1;
        case 1: 
          localcuv.feedId = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(122547);
          return 0;
        case 2: 
          localcuv.y = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(122547);
          return 0;
        case 3: 
          localcuv.height = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(122547);
          return 0;
        case 4: 
          localcuv.kvo = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(122547);
          return 0;
        case 5: 
          localcuv.Emz = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(122547);
          return 0;
        case 6: 
          localcuv.wxW = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(122547);
          return 0;
        case 7: 
          localcuv.qPe = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(122547);
          return 0;
        case 8: 
          localcuv.sq = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(122547);
          return 0;
        case 9: 
          localcuv.xJB = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(122547);
          return 0;
        case 10: 
          localcuv.cEL = ((f.a.a.a.a)localObject1).KhF.fHu();
          AppMethodBeat.o(122547);
          return 0;
        case 11: 
          localcuv.startTime = ((f.a.a.a.a)localObject1).KhF.xT();
          AppMethodBeat.o(122547);
          return 0;
        case 12: 
          localcuv.endTime = ((f.a.a.a.a)localObject1).KhF.xT();
          AppMethodBeat.o(122547);
          return 0;
        case 13: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ahi();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((ahi)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcuv.EmA.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(122547);
          return 0;
        case 14: 
          localcuv.EmB = ((f.a.a.a.a)localObject1).KhF.xT();
          AppMethodBeat.o(122547);
          return 0;
        case 15: 
          localcuv.EmC = Double.longBitsToDouble(((f.a.a.a.a)localObject1).KhF.fHy());
          AppMethodBeat.o(122547);
          return 0;
        case 16: 
          localcuv.EmD = Double.longBitsToDouble(((f.a.a.a.a)localObject1).KhF.fHy());
          AppMethodBeat.o(122547);
          return 0;
        case 17: 
          localcuv.commentCount = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(122547);
          return 0;
        case 18: 
          localcuv.likeCount = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(122547);
          return 0;
        case 19: 
          localcuv.userName = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(122547);
          return 0;
        case 20: 
          localcuv.isAd = ((f.a.a.a.a)localObject1).KhF.fHu();
          AppMethodBeat.o(122547);
          return 0;
        }
        localcuv.bNK = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(122547);
        return 0;
      }
      AppMethodBeat.o(122547);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cuv
 * JD-Core Version:    0.7.0.1
 */