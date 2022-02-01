package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class avy
  extends dyy
{
  public bkr SIo;
  public int SIp;
  public dmp SIq;
  public bkq bgmInfo;
  public int continueFlag;
  public com.tencent.mm.cd.b lastBuffer;
  public LinkedList<FinderObject> object;
  public bhh preloadInfo;
  public dwb xEJ;
  public long xEc;
  
  public avy()
  {
    AppMethodBeat.i(168991);
    this.object = new LinkedList();
    AppMethodBeat.o(168991);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(168992);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new g.a.a.b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(168992);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.object);
      if (this.lastBuffer != null) {
        paramVarArgs.c(3, this.lastBuffer);
      }
      paramVarArgs.aY(4, this.continueFlag);
      paramVarArgs.bm(5, this.xEc);
      if (this.SIo != null)
      {
        paramVarArgs.oE(6, this.SIo.computeSize());
        this.SIo.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(7, this.SIp);
      if (this.xEJ != null)
      {
        paramVarArgs.oE(8, this.xEJ.computeSize());
        this.xEJ.writeFields(paramVarArgs);
      }
      if (this.SIq != null)
      {
        paramVarArgs.oE(9, this.SIq.computeSize());
        this.SIq.writeFields(paramVarArgs);
      }
      if (this.preloadInfo != null)
      {
        paramVarArgs.oE(10, this.preloadInfo.computeSize());
        this.preloadInfo.writeFields(paramVarArgs);
      }
      if (this.bgmInfo != null)
      {
        paramVarArgs.oE(11, this.bgmInfo.computeSize());
        this.bgmInfo.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(168992);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1316;
      }
    }
    label1316:
    for (paramInt = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.a.c(2, 8, this.object);
      paramInt = i;
      if (this.lastBuffer != null) {
        paramInt = i + g.a.a.b.b.a.b(3, this.lastBuffer);
      }
      i = paramInt + g.a.a.b.b.a.bM(4, this.continueFlag) + g.a.a.b.b.a.p(5, this.xEc);
      paramInt = i;
      if (this.SIo != null) {
        paramInt = i + g.a.a.a.oD(6, this.SIo.computeSize());
      }
      i = paramInt + g.a.a.b.b.a.bM(7, this.SIp);
      paramInt = i;
      if (this.xEJ != null) {
        paramInt = i + g.a.a.a.oD(8, this.xEJ.computeSize());
      }
      i = paramInt;
      if (this.SIq != null) {
        i = paramInt + g.a.a.a.oD(9, this.SIq.computeSize());
      }
      paramInt = i;
      if (this.preloadInfo != null) {
        paramInt = i + g.a.a.a.oD(10, this.preloadInfo.computeSize());
      }
      i = paramInt;
      if (this.bgmInfo != null) {
        i = paramInt + g.a.a.a.oD(11, this.bgmInfo.computeSize());
      }
      AppMethodBeat.o(168992);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.object.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dyy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new g.a.a.b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(168992);
          throw paramVarArgs;
        }
        AppMethodBeat.o(168992);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        avy localavy = (avy)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(168992);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new jh();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((jh)localObject2).parseFrom((byte[])localObject1);
            }
            localavy.BaseResponse = ((jh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(168992);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new FinderObject();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((FinderObject)localObject2).parseFrom((byte[])localObject1);
            }
            localavy.object.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(168992);
          return 0;
        case 3: 
          localavy.lastBuffer = ((g.a.a.a.a)localObject1).abFh.iUw();
          AppMethodBeat.o(168992);
          return 0;
        case 4: 
          localavy.continueFlag = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(168992);
          return 0;
        case 5: 
          localavy.xEc = ((g.a.a.a.a)localObject1).abFh.AN();
          AppMethodBeat.o(168992);
          return 0;
        case 6: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bkr();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bkr)localObject2).parseFrom((byte[])localObject1);
            }
            localavy.SIo = ((bkr)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(168992);
          return 0;
        case 7: 
          localavy.SIp = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(168992);
          return 0;
        case 8: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dwb();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dwb)localObject2).parseFrom((byte[])localObject1);
            }
            localavy.xEJ = ((dwb)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(168992);
          return 0;
        case 9: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dmp();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dmp)localObject2).parseFrom((byte[])localObject1);
            }
            localavy.SIq = ((dmp)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(168992);
          return 0;
        case 10: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bhh();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bhh)localObject2).parseFrom((byte[])localObject1);
            }
            localavy.preloadInfo = ((bhh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(168992);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new bkq();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((bkq)localObject2).parseFrom((byte[])localObject1);
          }
          localavy.bgmInfo = ((bkq)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(168992);
        return 0;
      }
      AppMethodBeat.o(168992);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.avy
 * JD-Core Version:    0.7.0.1
 */