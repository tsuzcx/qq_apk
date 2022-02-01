package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class dmj
  extends dpc
{
  public int MPQ;
  public int MPT;
  public int MPU;
  public esi MPV;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32413);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(32413);
        throw paramVarArgs;
      }
      if (this.MPV == null)
      {
        paramVarArgs = new b("Not all required fields were included: NextPiece");
        AppMethodBeat.o(32413);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ni(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(2, this.MPT);
      paramVarArgs.aM(3, this.MPU);
      if (this.MPV != null)
      {
        paramVarArgs.ni(4, this.MPV.computeSize());
        this.MPV.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(5, this.MPQ);
      AppMethodBeat.o(32413);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label705;
      }
    }
    label705:
    for (paramInt = g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bu(2, this.MPT) + g.a.a.b.b.a.bu(3, this.MPU);
      paramInt = i;
      if (this.MPV != null) {
        paramInt = i + g.a.a.a.nh(4, this.MPV.computeSize());
      }
      i = g.a.a.b.b.a.bu(5, this.MPQ);
      AppMethodBeat.o(32413);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dpc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dpc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(32413);
          throw paramVarArgs;
        }
        if (this.MPV == null)
        {
          paramVarArgs = new b("Not all required fields were included: NextPiece");
          AppMethodBeat.o(32413);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32413);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        dmj localdmj = (dmj)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32413);
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
            localdmj.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32413);
          return 0;
        case 2: 
          localdmj.MPT = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(32413);
          return 0;
        case 3: 
          localdmj.MPU = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(32413);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new esi();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((esi)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localdmj.MPV = ((esi)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32413);
          return 0;
        }
        localdmj.MPQ = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(32413);
        return 0;
      }
      AppMethodBeat.o(32413);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dmj
 * JD-Core Version:    0.7.0.1
 */