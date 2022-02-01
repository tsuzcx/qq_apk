package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import java.util.LinkedList;

public final class avy
  extends dpc
{
  public awk LGt;
  public int LGu;
  public int continueFlag;
  public b lastBuffer;
  public long liveId;
  public awi tWe;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(209518);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.ni(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.tWe != null)
      {
        paramVarArgs.ni(2, this.tWe.computeSize());
        this.tWe.writeFields(paramVarArgs);
      }
      if (this.lastBuffer != null) {
        paramVarArgs.c(3, this.lastBuffer);
      }
      paramVarArgs.aM(4, this.continueFlag);
      if (this.LGt != null)
      {
        paramVarArgs.ni(5, this.LGt.computeSize());
        this.LGt.writeFields(paramVarArgs);
      }
      paramVarArgs.bb(6, this.liveId);
      paramVarArgs.aM(7, this.LGu);
      AppMethodBeat.o(209518);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label818;
      }
    }
    label818:
    for (int i = g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.tWe != null) {
        paramInt = i + g.a.a.a.nh(2, this.tWe.computeSize());
      }
      i = paramInt;
      if (this.lastBuffer != null) {
        i = paramInt + g.a.a.b.b.a.b(3, this.lastBuffer);
      }
      i += g.a.a.b.b.a.bu(4, this.continueFlag);
      paramInt = i;
      if (this.LGt != null) {
        paramInt = i + g.a.a.a.nh(5, this.LGt.computeSize());
      }
      i = g.a.a.b.b.a.r(6, this.liveId);
      int j = g.a.a.b.b.a.bu(7, this.LGu);
      AppMethodBeat.o(209518);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dpc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dpc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(209518);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        avy localavy = (avy)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(209518);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localavy.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(209518);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new awi();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((awi)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localavy.tWe = ((awi)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(209518);
          return 0;
        case 3: 
          localavy.lastBuffer = ((g.a.a.a.a)localObject1).UbS.hPo();
          AppMethodBeat.o(209518);
          return 0;
        case 4: 
          localavy.continueFlag = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(209518);
          return 0;
        case 5: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new awk();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((awk)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localavy.LGt = ((awk)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(209518);
          return 0;
        case 6: 
          localavy.liveId = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(209518);
          return 0;
        }
        localavy.LGu = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(209518);
        return 0;
      }
      AppMethodBeat.o(209518);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.avy
 * JD-Core Version:    0.7.0.1
 */