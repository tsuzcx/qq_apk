package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class cvy
  extends com.tencent.mm.cd.a
{
  public String SWw;
  public cwc TEM;
  public int TEN;
  public cwj TEO;
  public String TEP;
  public int TEQ;
  public int TER;
  public String TES;
  public int commentCount;
  public int createTime;
  public String debugMessage;
  public int favCount;
  public int favFlag;
  public int forwardCount;
  public int friendLikeCount;
  public long id;
  public boolean lYN;
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
    AppMethodBeat.i(208001);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bm(1, this.id);
      paramVarArgs.aY(2, this.createTime);
      if (this.TEM != null)
      {
        paramVarArgs.oE(3, this.TEM.computeSize());
        this.TEM.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(4, this.forwardCount);
      paramVarArgs.aY(5, this.likeCount);
      paramVarArgs.aY(6, this.commentCount);
      paramVarArgs.aY(7, this.favCount);
      paramVarArgs.aY(8, this.friendLikeCount);
      paramVarArgs.aY(9, this.TEN);
      if (this.SWw != null) {
        paramVarArgs.f(10, this.SWw);
      }
      paramVarArgs.co(11, this.lYN);
      paramVarArgs.aY(12, this.readCount);
      if (this.sessionBuffer != null) {
        paramVarArgs.f(13, this.sessionBuffer);
      }
      paramVarArgs.aY(14, this.favFlag);
      paramVarArgs.aY(15, this.urlValidDuration);
      paramVarArgs.aY(16, this.privateFlag);
      if (this.debugMessage != null) {
        paramVarArgs.f(17, this.debugMessage);
      }
      paramVarArgs.aY(18, this.permissionFlag);
      if (this.TEO != null)
      {
        paramVarArgs.oE(19, this.TEO.computeSize());
        this.TEO.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(20, this.status);
      if (this.TEP != null) {
        paramVarArgs.f(21, this.TEP);
      }
      paramVarArgs.aY(22, this.TEQ);
      paramVarArgs.aY(23, this.likeFlag);
      paramVarArgs.aY(24, this.TER);
      if (this.TES != null) {
        paramVarArgs.f(25, this.TES);
      }
      AppMethodBeat.o(208001);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.p(1, this.id) + 0 + g.a.a.b.b.a.bM(2, this.createTime);
      paramInt = i;
      if (this.TEM != null) {
        paramInt = i + g.a.a.a.oD(3, this.TEM.computeSize());
      }
      i = paramInt + g.a.a.b.b.a.bM(4, this.forwardCount) + g.a.a.b.b.a.bM(5, this.likeCount) + g.a.a.b.b.a.bM(6, this.commentCount) + g.a.a.b.b.a.bM(7, this.favCount) + g.a.a.b.b.a.bM(8, this.friendLikeCount) + g.a.a.b.b.a.bM(9, this.TEN);
      paramInt = i;
      if (this.SWw != null) {
        paramInt = i + g.a.a.b.b.a.g(10, this.SWw);
      }
      i = paramInt + (g.a.a.b.b.a.gL(11) + 1) + g.a.a.b.b.a.bM(12, this.readCount);
      paramInt = i;
      if (this.sessionBuffer != null) {
        paramInt = i + g.a.a.b.b.a.g(13, this.sessionBuffer);
      }
      i = paramInt + g.a.a.b.b.a.bM(14, this.favFlag) + g.a.a.b.b.a.bM(15, this.urlValidDuration) + g.a.a.b.b.a.bM(16, this.privateFlag);
      paramInt = i;
      if (this.debugMessage != null) {
        paramInt = i + g.a.a.b.b.a.g(17, this.debugMessage);
      }
      i = paramInt + g.a.a.b.b.a.bM(18, this.permissionFlag);
      paramInt = i;
      if (this.TEO != null) {
        paramInt = i + g.a.a.a.oD(19, this.TEO.computeSize());
      }
      i = paramInt + g.a.a.b.b.a.bM(20, this.status);
      paramInt = i;
      if (this.TEP != null) {
        paramInt = i + g.a.a.b.b.a.g(21, this.TEP);
      }
      i = paramInt + g.a.a.b.b.a.bM(22, this.TEQ) + g.a.a.b.b.a.bM(23, this.likeFlag) + g.a.a.b.b.a.bM(24, this.TER);
      paramInt = i;
      if (this.TES != null) {
        paramInt = i + g.a.a.b.b.a.g(25, this.TES);
      }
      AppMethodBeat.o(208001);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(208001);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      cvy localcvy = (cvy)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(208001);
        return -1;
      case 1: 
        localcvy.id = ((g.a.a.a.a)localObject1).abFh.AN();
        AppMethodBeat.o(208001);
        return 0;
      case 2: 
        localcvy.createTime = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(208001);
        return 0;
      case 3: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new cwc();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((cwc)localObject2).parseFrom((byte[])localObject1);
          }
          localcvy.TEM = ((cwc)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(208001);
        return 0;
      case 4: 
        localcvy.forwardCount = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(208001);
        return 0;
      case 5: 
        localcvy.likeCount = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(208001);
        return 0;
      case 6: 
        localcvy.commentCount = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(208001);
        return 0;
      case 7: 
        localcvy.favCount = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(208001);
        return 0;
      case 8: 
        localcvy.friendLikeCount = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(208001);
        return 0;
      case 9: 
        localcvy.TEN = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(208001);
        return 0;
      case 10: 
        localcvy.SWw = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(208001);
        return 0;
      case 11: 
        localcvy.lYN = ((g.a.a.a.a)localObject1).abFh.AB();
        AppMethodBeat.o(208001);
        return 0;
      case 12: 
        localcvy.readCount = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(208001);
        return 0;
      case 13: 
        localcvy.sessionBuffer = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(208001);
        return 0;
      case 14: 
        localcvy.favFlag = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(208001);
        return 0;
      case 15: 
        localcvy.urlValidDuration = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(208001);
        return 0;
      case 16: 
        localcvy.privateFlag = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(208001);
        return 0;
      case 17: 
        localcvy.debugMessage = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(208001);
        return 0;
      case 18: 
        localcvy.permissionFlag = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(208001);
        return 0;
      case 19: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new cwj();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((cwj)localObject2).parseFrom((byte[])localObject1);
          }
          localcvy.TEO = ((cwj)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(208001);
        return 0;
      case 20: 
        localcvy.status = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(208001);
        return 0;
      case 21: 
        localcvy.TEP = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(208001);
        return 0;
      case 22: 
        localcvy.TEQ = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(208001);
        return 0;
      case 23: 
        localcvy.likeFlag = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(208001);
        return 0;
      case 24: 
        localcvy.TER = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(208001);
        return 0;
      }
      localcvy.TES = ((g.a.a.a.a)localObject1).abFh.readString();
      AppMethodBeat.o(208001);
      return 0;
    }
    AppMethodBeat.o(208001);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cvy
 * JD-Core Version:    0.7.0.1
 */