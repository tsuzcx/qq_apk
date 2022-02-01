package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cng
  extends com.tencent.mm.bw.a
{
  public String LOd;
  public cnl MtG;
  public int MtH;
  public cns MtI;
  public String MtJ;
  public int MtK;
  public int MtL;
  public String MtM;
  public int commentCount;
  public String debugMessage;
  public int favCount;
  public int favFlag;
  public int forwardCount;
  public int friendLikeCount;
  public int iXu;
  public long id;
  public boolean jiQ;
  public int likeCount;
  public int likeFlag;
  public int permissionFlag;
  public int privateFlag;
  public int readCount;
  public String sessionBuffer;
  public int status;
  public int urlValidDuration;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(209732);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bb(1, this.id);
      paramVarArgs.aM(2, this.iXu);
      if (this.MtG != null)
      {
        paramVarArgs.ni(3, this.MtG.computeSize());
        this.MtG.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(4, this.forwardCount);
      paramVarArgs.aM(5, this.likeCount);
      paramVarArgs.aM(6, this.commentCount);
      paramVarArgs.aM(7, this.favCount);
      paramVarArgs.aM(8, this.friendLikeCount);
      paramVarArgs.aM(9, this.MtH);
      if (this.LOd != null) {
        paramVarArgs.e(10, this.LOd);
      }
      paramVarArgs.cc(11, this.jiQ);
      paramVarArgs.aM(12, this.readCount);
      if (this.sessionBuffer != null) {
        paramVarArgs.e(13, this.sessionBuffer);
      }
      paramVarArgs.aM(14, this.favFlag);
      paramVarArgs.aM(15, this.urlValidDuration);
      paramVarArgs.aM(16, this.privateFlag);
      if (this.debugMessage != null) {
        paramVarArgs.e(17, this.debugMessage);
      }
      paramVarArgs.aM(18, this.permissionFlag);
      if (this.MtI != null)
      {
        paramVarArgs.ni(19, this.MtI.computeSize());
        this.MtI.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(20, this.status);
      if (this.MtJ != null) {
        paramVarArgs.e(21, this.MtJ);
      }
      paramVarArgs.aM(22, this.MtK);
      paramVarArgs.aM(23, this.likeFlag);
      paramVarArgs.aM(24, this.MtL);
      if (this.MtM != null) {
        paramVarArgs.e(25, this.MtM);
      }
      AppMethodBeat.o(209732);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.r(1, this.id) + 0 + g.a.a.b.b.a.bu(2, this.iXu);
      paramInt = i;
      if (this.MtG != null) {
        paramInt = i + g.a.a.a.nh(3, this.MtG.computeSize());
      }
      i = paramInt + g.a.a.b.b.a.bu(4, this.forwardCount) + g.a.a.b.b.a.bu(5, this.likeCount) + g.a.a.b.b.a.bu(6, this.commentCount) + g.a.a.b.b.a.bu(7, this.favCount) + g.a.a.b.b.a.bu(8, this.friendLikeCount) + g.a.a.b.b.a.bu(9, this.MtH);
      paramInt = i;
      if (this.LOd != null) {
        paramInt = i + g.a.a.b.b.a.f(10, this.LOd);
      }
      i = paramInt + (g.a.a.b.b.a.fS(11) + 1) + g.a.a.b.b.a.bu(12, this.readCount);
      paramInt = i;
      if (this.sessionBuffer != null) {
        paramInt = i + g.a.a.b.b.a.f(13, this.sessionBuffer);
      }
      i = paramInt + g.a.a.b.b.a.bu(14, this.favFlag) + g.a.a.b.b.a.bu(15, this.urlValidDuration) + g.a.a.b.b.a.bu(16, this.privateFlag);
      paramInt = i;
      if (this.debugMessage != null) {
        paramInt = i + g.a.a.b.b.a.f(17, this.debugMessage);
      }
      i = paramInt + g.a.a.b.b.a.bu(18, this.permissionFlag);
      paramInt = i;
      if (this.MtI != null) {
        paramInt = i + g.a.a.a.nh(19, this.MtI.computeSize());
      }
      i = paramInt + g.a.a.b.b.a.bu(20, this.status);
      paramInt = i;
      if (this.MtJ != null) {
        paramInt = i + g.a.a.b.b.a.f(21, this.MtJ);
      }
      i = paramInt + g.a.a.b.b.a.bu(22, this.MtK) + g.a.a.b.b.a.bu(23, this.likeFlag) + g.a.a.b.b.a.bu(24, this.MtL);
      paramInt = i;
      if (this.MtM != null) {
        paramInt = i + g.a.a.b.b.a.f(25, this.MtM);
      }
      AppMethodBeat.o(209732);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(209732);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      cng localcng = (cng)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(209732);
        return -1;
      case 1: 
        localcng.id = ((g.a.a.a.a)localObject1).UbS.zl();
        AppMethodBeat.o(209732);
        return 0;
      case 2: 
        localcng.iXu = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(209732);
        return 0;
      case 3: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cnl();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cnl)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localcng.MtG = ((cnl)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(209732);
        return 0;
      case 4: 
        localcng.forwardCount = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(209732);
        return 0;
      case 5: 
        localcng.likeCount = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(209732);
        return 0;
      case 6: 
        localcng.commentCount = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(209732);
        return 0;
      case 7: 
        localcng.favCount = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(209732);
        return 0;
      case 8: 
        localcng.friendLikeCount = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(209732);
        return 0;
      case 9: 
        localcng.MtH = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(209732);
        return 0;
      case 10: 
        localcng.LOd = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(209732);
        return 0;
      case 11: 
        localcng.jiQ = ((g.a.a.a.a)localObject1).UbS.yZ();
        AppMethodBeat.o(209732);
        return 0;
      case 12: 
        localcng.readCount = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(209732);
        return 0;
      case 13: 
        localcng.sessionBuffer = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(209732);
        return 0;
      case 14: 
        localcng.favFlag = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(209732);
        return 0;
      case 15: 
        localcng.urlValidDuration = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(209732);
        return 0;
      case 16: 
        localcng.privateFlag = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(209732);
        return 0;
      case 17: 
        localcng.debugMessage = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(209732);
        return 0;
      case 18: 
        localcng.permissionFlag = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(209732);
        return 0;
      case 19: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cns();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cns)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localcng.MtI = ((cns)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(209732);
        return 0;
      case 20: 
        localcng.status = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(209732);
        return 0;
      case 21: 
        localcng.MtJ = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(209732);
        return 0;
      case 22: 
        localcng.MtK = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(209732);
        return 0;
      case 23: 
        localcng.likeFlag = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(209732);
        return 0;
      case 24: 
        localcng.MtL = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(209732);
        return 0;
      }
      localcng.MtM = ((g.a.a.a.a)localObject1).UbS.readString();
      AppMethodBeat.o(209732);
      return 0;
    }
    AppMethodBeat.o(209732);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cng
 * JD-Core Version:    0.7.0.1
 */