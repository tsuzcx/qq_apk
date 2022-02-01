package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class ayl
  extends esc
{
  public btc ZDZ;
  public LinkedList<FinderCommentInfo> ZJl;
  public int ZJm;
  public int ZJn;
  public LinkedList<FinderCommentInfo> ZJo;
  public LinkedList<FinderObject> ZJp;
  public String ZJq;
  public LinkedList<FinderCommentInfo> ZJr;
  public int commentCount;
  public FinderObject feedObject;
  public b lastBuffer;
  public int secondaryShowFlag;
  public int upContinueFlag;
  
  public ayl()
  {
    AppMethodBeat.i(168974);
    this.ZJl = new LinkedList();
    this.ZJo = new LinkedList();
    this.ZJp = new LinkedList();
    this.ZJr = new LinkedList();
    AppMethodBeat.o(168974);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(168975);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.ZJl);
      if (this.feedObject != null)
      {
        paramVarArgs.qD(3, this.feedObject.computeSize());
        this.feedObject.writeFields(paramVarArgs);
      }
      if (this.lastBuffer != null) {
        paramVarArgs.d(4, this.lastBuffer);
      }
      paramVarArgs.bS(5, this.commentCount);
      paramVarArgs.bS(6, this.upContinueFlag);
      paramVarArgs.bS(7, this.ZJm);
      paramVarArgs.bS(8, this.ZJn);
      paramVarArgs.bS(9, this.secondaryShowFlag);
      paramVarArgs.e(10, 8, this.ZJo);
      paramVarArgs.e(11, 8, this.ZJp);
      if (this.ZDZ != null)
      {
        paramVarArgs.qD(12, this.ZDZ.computeSize());
        this.ZDZ.writeFields(paramVarArgs);
      }
      if (this.ZJq != null) {
        paramVarArgs.g(13, this.ZJq);
      }
      paramVarArgs.e(20, 8, this.ZJr);
      AppMethodBeat.o(168975);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1388;
      }
    }
    label1388:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.a.c(2, 8, this.ZJl);
      paramInt = i;
      if (this.feedObject != null) {
        paramInt = i + i.a.a.a.qC(3, this.feedObject.computeSize());
      }
      i = paramInt;
      if (this.lastBuffer != null) {
        i = paramInt + i.a.a.b.b.a.c(4, this.lastBuffer);
      }
      i = i + i.a.a.b.b.a.cJ(5, this.commentCount) + i.a.a.b.b.a.cJ(6, this.upContinueFlag) + i.a.a.b.b.a.cJ(7, this.ZJm) + i.a.a.b.b.a.cJ(8, this.ZJn) + i.a.a.b.b.a.cJ(9, this.secondaryShowFlag) + i.a.a.a.c(10, 8, this.ZJo) + i.a.a.a.c(11, 8, this.ZJp);
      paramInt = i;
      if (this.ZDZ != null) {
        paramInt = i + i.a.a.a.qC(12, this.ZDZ.computeSize());
      }
      i = paramInt;
      if (this.ZJq != null) {
        i = paramInt + i.a.a.b.b.a.h(13, this.ZJq);
      }
      paramInt = i.a.a.a.c(20, 8, this.ZJr);
      AppMethodBeat.o(168975);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.ZJl.clear();
        this.ZJo.clear();
        this.ZJp.clear();
        this.ZJr.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(168975);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        ayl localayl = (ayl)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        case 14: 
        case 15: 
        case 16: 
        case 17: 
        case 18: 
        case 19: 
        default: 
          AppMethodBeat.o(168975);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new kd();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((kd)localObject2).parseFrom((byte[])localObject1);
            }
            localayl.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(168975);
          return 0;
        case 2: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new FinderCommentInfo();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((FinderCommentInfo)localObject2).parseFrom((byte[])localObject1);
            }
            localayl.ZJl.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(168975);
          return 0;
        case 3: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new FinderObject();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((FinderObject)localObject2).parseFrom((byte[])localObject1);
            }
            localayl.feedObject = ((FinderObject)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(168975);
          return 0;
        case 4: 
          localayl.lastBuffer = ((i.a.a.a.a)localObject1).ajGk.kFX();
          AppMethodBeat.o(168975);
          return 0;
        case 5: 
          localayl.commentCount = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(168975);
          return 0;
        case 6: 
          localayl.upContinueFlag = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(168975);
          return 0;
        case 7: 
          localayl.ZJm = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(168975);
          return 0;
        case 8: 
          localayl.ZJn = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(168975);
          return 0;
        case 9: 
          localayl.secondaryShowFlag = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(168975);
          return 0;
        case 10: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new FinderCommentInfo();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((FinderCommentInfo)localObject2).parseFrom((byte[])localObject1);
            }
            localayl.ZJo.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(168975);
          return 0;
        case 11: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new FinderObject();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((FinderObject)localObject2).parseFrom((byte[])localObject1);
            }
            localayl.ZJp.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(168975);
          return 0;
        case 12: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new btc();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((btc)localObject2).parseFrom((byte[])localObject1);
            }
            localayl.ZDZ = ((btc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(168975);
          return 0;
        case 13: 
          localayl.ZJq = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(168975);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new FinderCommentInfo();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((FinderCommentInfo)localObject2).parseFrom((byte[])localObject1);
          }
          localayl.ZJr.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(168975);
        return 0;
      }
      AppMethodBeat.o(168975);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ayl
 * JD-Core Version:    0.7.0.1
 */