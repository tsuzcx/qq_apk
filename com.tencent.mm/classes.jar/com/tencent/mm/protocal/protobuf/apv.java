package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class apv
  extends dyy
{
  public FinderContact SDj;
  public String SDk;
  public dhc entranceInfo;
  public String qbv;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(202666);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.SDj != null)
      {
        paramVarArgs.oE(2, this.SDj.computeSize());
        this.SDj.writeFields(paramVarArgs);
      }
      if (this.qbv != null) {
        paramVarArgs.f(3, this.qbv);
      }
      if (this.SDk != null) {
        paramVarArgs.f(4, this.SDk);
      }
      if (this.entranceInfo != null)
      {
        paramVarArgs.oE(5, this.entranceInfo.computeSize());
        this.entranceInfo.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(202666);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label672;
      }
    }
    label672:
    for (int i = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.SDj != null) {
        paramInt = i + g.a.a.a.oD(2, this.SDj.computeSize());
      }
      i = paramInt;
      if (this.qbv != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.qbv);
      }
      paramInt = i;
      if (this.SDk != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.SDk);
      }
      i = paramInt;
      if (this.entranceInfo != null) {
        i = paramInt + g.a.a.a.oD(5, this.entranceInfo.computeSize());
      }
      AppMethodBeat.o(202666);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(202666);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        apv localapv = (apv)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(202666);
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
            localapv.BaseResponse = ((jh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(202666);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new FinderContact();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((FinderContact)localObject2).parseFrom((byte[])localObject1);
            }
            localapv.SDj = ((FinderContact)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(202666);
          return 0;
        case 3: 
          localapv.qbv = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(202666);
          return 0;
        case 4: 
          localapv.SDk = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(202666);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new dhc();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((dhc)localObject2).parseFrom((byte[])localObject1);
          }
          localapv.entranceInfo = ((dhc)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(202666);
        return 0;
      }
      AppMethodBeat.o(202666);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.apv
 * JD-Core Version:    0.7.0.1
 */