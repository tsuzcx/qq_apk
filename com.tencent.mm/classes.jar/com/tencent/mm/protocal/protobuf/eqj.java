package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class eqj
  extends dpc
{
  public int LjQ;
  public int MPQ;
  public esi MPV;
  public String NnO;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32497);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(32497);
        throw paramVarArgs;
      }
      if (this.MPV == null)
      {
        paramVarArgs = new b("Not all required fields were included: NextPiece");
        AppMethodBeat.o(32497);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ni(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.MPV != null)
      {
        paramVarArgs.ni(2, this.MPV.computeSize());
        this.MPV.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(3, this.LjQ);
      paramVarArgs.aM(4, this.MPQ);
      if (this.NnO != null) {
        paramVarArgs.e(5, this.NnO);
      }
      AppMethodBeat.o(32497);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label721;
      }
    }
    label721:
    for (paramInt = g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.MPV != null) {
        i = paramInt + g.a.a.a.nh(2, this.MPV.computeSize());
      }
      i = i + g.a.a.b.b.a.bu(3, this.LjQ) + g.a.a.b.b.a.bu(4, this.MPQ);
      paramInt = i;
      if (this.NnO != null) {
        paramInt = i + g.a.a.b.b.a.f(5, this.NnO);
      }
      AppMethodBeat.o(32497);
      return paramInt;
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
          AppMethodBeat.o(32497);
          throw paramVarArgs;
        }
        if (this.MPV == null)
        {
          paramVarArgs = new b("Not all required fields were included: NextPiece");
          AppMethodBeat.o(32497);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32497);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        eqj localeqj = (eqj)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32497);
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
            localeqj.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32497);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new esi();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((esi)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localeqj.MPV = ((esi)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32497);
          return 0;
        case 3: 
          localeqj.LjQ = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(32497);
          return 0;
        case 4: 
          localeqj.MPQ = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(32497);
          return 0;
        }
        localeqj.NnO = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(32497);
        return 0;
      }
      AppMethodBeat.o(32497);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eqj
 * JD-Core Version:    0.7.0.1
 */