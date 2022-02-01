package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.b;
import java.util.LinkedList;

public final class azq
  extends dyy
{
  public bdo SLo;
  public int continueFlag;
  public b lastBuffer;
  public long liveId;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(230349);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.SLo != null)
      {
        paramVarArgs.oE(2, this.SLo.computeSize());
        this.SLo.writeFields(paramVarArgs);
      }
      if (this.lastBuffer != null) {
        paramVarArgs.c(3, this.lastBuffer);
      }
      paramVarArgs.aY(4, this.continueFlag);
      paramVarArgs.bm(5, this.liveId);
      AppMethodBeat.o(230349);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label570;
      }
    }
    label570:
    for (int i = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.SLo != null) {
        paramInt = i + g.a.a.a.oD(2, this.SLo.computeSize());
      }
      i = paramInt;
      if (this.lastBuffer != null) {
        i = paramInt + g.a.a.b.b.a.b(3, this.lastBuffer);
      }
      paramInt = g.a.a.b.b.a.bM(4, this.continueFlag);
      int j = g.a.a.b.b.a.p(5, this.liveId);
      AppMethodBeat.o(230349);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(230349);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        azq localazq = (azq)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(230349);
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
            localazq.BaseResponse = ((jh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(230349);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bdo();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bdo)localObject2).parseFrom((byte[])localObject1);
            }
            localazq.SLo = ((bdo)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(230349);
          return 0;
        case 3: 
          localazq.lastBuffer = ((g.a.a.a.a)localObject1).abFh.iUw();
          AppMethodBeat.o(230349);
          return 0;
        case 4: 
          localazq.continueFlag = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(230349);
          return 0;
        }
        localazq.liveId = ((g.a.a.a.a)localObject1).abFh.AN();
        AppMethodBeat.o(230349);
        return 0;
      }
      AppMethodBeat.o(230349);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.azq
 * JD-Core Version:    0.7.0.1
 */