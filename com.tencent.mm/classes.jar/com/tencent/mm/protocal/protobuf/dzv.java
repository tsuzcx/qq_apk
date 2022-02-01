package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dzv
  extends com.tencent.mm.bw.a
{
  public int CHZ;
  public int EOS;
  public LinkedList<anw> MZr;
  public long MZs;
  public double MZt;
  public double MZu;
  public int commentCount;
  public boolean ddZ;
  public long endTime;
  public String feedId;
  public int height;
  public boolean isAd;
  public int likeCount;
  public int mEY;
  public String nickName;
  public long startTime;
  public int udM;
  public String userName;
  public int virtualKeyHeight;
  public int vp;
  public int y;
  
  public dzv()
  {
    AppMethodBeat.i(122546);
    this.y = -1;
    this.height = -1;
    this.mEY = -1;
    this.virtualKeyHeight = 0;
    this.CHZ = -1;
    this.udM = -1;
    this.vp = 0;
    this.EOS = 0;
    this.ddZ = false;
    this.startTime = -1L;
    this.endTime = -1L;
    this.MZr = new LinkedList();
    this.MZs = 0L;
    this.MZt = 0.0D;
    this.MZu = 0.0D;
    this.isAd = false;
    AppMethodBeat.o(122546);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(122547);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.feedId != null) {
        paramVarArgs.e(1, this.feedId);
      }
      paramVarArgs.aM(2, this.y);
      paramVarArgs.aM(3, this.height);
      paramVarArgs.aM(4, this.mEY);
      paramVarArgs.aM(5, this.virtualKeyHeight);
      paramVarArgs.aM(6, this.CHZ);
      paramVarArgs.aM(7, this.udM);
      paramVarArgs.aM(8, this.vp);
      paramVarArgs.aM(9, this.EOS);
      paramVarArgs.cc(10, this.ddZ);
      paramVarArgs.bb(11, this.startTime);
      paramVarArgs.bb(12, this.endTime);
      paramVarArgs.e(13, 8, this.MZr);
      paramVarArgs.bb(14, this.MZs);
      paramVarArgs.e(15, this.MZt);
      paramVarArgs.e(16, this.MZu);
      paramVarArgs.aM(17, this.commentCount);
      paramVarArgs.aM(18, this.likeCount);
      if (this.userName != null) {
        paramVarArgs.e(19, this.userName);
      }
      paramVarArgs.cc(20, this.isAd);
      if (this.nickName != null) {
        paramVarArgs.e(21, this.nickName);
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
    for (paramInt = g.a.a.b.b.a.f(1, this.feedId) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bu(2, this.y) + g.a.a.b.b.a.bu(3, this.height) + g.a.a.b.b.a.bu(4, this.mEY) + g.a.a.b.b.a.bu(5, this.virtualKeyHeight) + g.a.a.b.b.a.bu(6, this.CHZ) + g.a.a.b.b.a.bu(7, this.udM) + g.a.a.b.b.a.bu(8, this.vp) + g.a.a.b.b.a.bu(9, this.EOS) + (g.a.a.b.b.a.fS(10) + 1) + g.a.a.b.b.a.r(11, this.startTime) + g.a.a.b.b.a.r(12, this.endTime) + g.a.a.a.c(13, 8, this.MZr) + g.a.a.b.b.a.r(14, this.MZs) + (g.a.a.b.b.a.fS(15) + 8) + (g.a.a.b.b.a.fS(16) + 8) + g.a.a.b.b.a.bu(17, this.commentCount) + g.a.a.b.b.a.bu(18, this.likeCount);
      paramInt = i;
      if (this.userName != null) {
        paramInt = i + g.a.a.b.b.a.f(19, this.userName);
      }
      i = paramInt + (g.a.a.b.b.a.fS(20) + 1);
      paramInt = i;
      if (this.nickName != null) {
        paramInt = i + g.a.a.b.b.a.f(21, this.nickName);
      }
      AppMethodBeat.o(122547);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.MZr.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(122547);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        dzv localdzv = (dzv)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(122547);
          return -1;
        case 1: 
          localdzv.feedId = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(122547);
          return 0;
        case 2: 
          localdzv.y = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(122547);
          return 0;
        case 3: 
          localdzv.height = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(122547);
          return 0;
        case 4: 
          localdzv.mEY = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(122547);
          return 0;
        case 5: 
          localdzv.virtualKeyHeight = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(122547);
          return 0;
        case 6: 
          localdzv.CHZ = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(122547);
          return 0;
        case 7: 
          localdzv.udM = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(122547);
          return 0;
        case 8: 
          localdzv.vp = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(122547);
          return 0;
        case 9: 
          localdzv.EOS = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(122547);
          return 0;
        case 10: 
          localdzv.ddZ = ((g.a.a.a.a)localObject1).UbS.yZ();
          AppMethodBeat.o(122547);
          return 0;
        case 11: 
          localdzv.startTime = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(122547);
          return 0;
        case 12: 
          localdzv.endTime = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(122547);
          return 0;
        case 13: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new anw();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((anw)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localdzv.MZr.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(122547);
          return 0;
        case 14: 
          localdzv.MZs = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(122547);
          return 0;
        case 15: 
          localdzv.MZt = Double.longBitsToDouble(((g.a.a.a.a)localObject1).UbS.zn());
          AppMethodBeat.o(122547);
          return 0;
        case 16: 
          localdzv.MZu = Double.longBitsToDouble(((g.a.a.a.a)localObject1).UbS.zn());
          AppMethodBeat.o(122547);
          return 0;
        case 17: 
          localdzv.commentCount = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(122547);
          return 0;
        case 18: 
          localdzv.likeCount = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(122547);
          return 0;
        case 19: 
          localdzv.userName = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(122547);
          return 0;
        case 20: 
          localdzv.isAd = ((g.a.a.a.a)localObject1).UbS.yZ();
          AppMethodBeat.o(122547);
          return 0;
        }
        localdzv.nickName = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(122547);
        return 0;
      }
      AppMethodBeat.o(122547);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dzv
 * JD-Core Version:    0.7.0.1
 */