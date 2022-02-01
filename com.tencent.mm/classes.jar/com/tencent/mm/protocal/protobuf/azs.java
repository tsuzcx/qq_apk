package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.b;
import java.util.LinkedList;

public final class azs
  extends dyy
{
  public ban SLp;
  public int SLq;
  public int continueFlag;
  public b lastBuffer;
  public long liveId;
  public bal xHW;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(229892);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.xHW != null)
      {
        paramVarArgs.oE(2, this.xHW.computeSize());
        this.xHW.writeFields(paramVarArgs);
      }
      if (this.lastBuffer != null) {
        paramVarArgs.c(3, this.lastBuffer);
      }
      paramVarArgs.aY(4, this.continueFlag);
      if (this.SLp != null)
      {
        paramVarArgs.oE(5, this.SLp.computeSize());
        this.SLp.writeFields(paramVarArgs);
      }
      paramVarArgs.bm(6, this.liveId);
      paramVarArgs.aY(7, this.SLq);
      AppMethodBeat.o(229892);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label752;
      }
    }
    label752:
    for (int i = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.xHW != null) {
        paramInt = i + g.a.a.a.oD(2, this.xHW.computeSize());
      }
      i = paramInt;
      if (this.lastBuffer != null) {
        i = paramInt + g.a.a.b.b.a.b(3, this.lastBuffer);
      }
      i += g.a.a.b.b.a.bM(4, this.continueFlag);
      paramInt = i;
      if (this.SLp != null) {
        paramInt = i + g.a.a.a.oD(5, this.SLp.computeSize());
      }
      i = g.a.a.b.b.a.p(6, this.liveId);
      int j = g.a.a.b.b.a.bM(7, this.SLq);
      AppMethodBeat.o(229892);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(229892);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        azs localazs = (azs)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(229892);
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
            localazs.BaseResponse = ((jh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(229892);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bal();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bal)localObject2).parseFrom((byte[])localObject1);
            }
            localazs.xHW = ((bal)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(229892);
          return 0;
        case 3: 
          localazs.lastBuffer = ((g.a.a.a.a)localObject1).abFh.iUw();
          AppMethodBeat.o(229892);
          return 0;
        case 4: 
          localazs.continueFlag = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(229892);
          return 0;
        case 5: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new ban();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((ban)localObject2).parseFrom((byte[])localObject1);
            }
            localazs.SLp = ((ban)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(229892);
          return 0;
        case 6: 
          localazs.liveId = ((g.a.a.a.a)localObject1).abFh.AN();
          AppMethodBeat.o(229892);
          return 0;
        }
        localazs.SLq = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(229892);
        return 0;
      }
      AppMethodBeat.o(229892);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.azs
 * JD-Core Version:    0.7.0.1
 */