package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bdx
  extends dpc
{
  public int bNu;
  public boolean completed;
  public int iKP;
  public String twt;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(169069);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.ni(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(2, this.iKP);
      paramVarArgs.aM(3, this.bNu);
      if (this.twt != null) {
        paramVarArgs.e(4, this.twt);
      }
      paramVarArgs.cc(5, this.completed);
      AppMethodBeat.o(169069);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label498;
      }
    }
    label498:
    for (paramInt = g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bu(2, this.iKP) + g.a.a.b.b.a.bu(3, this.bNu);
      paramInt = i;
      if (this.twt != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.twt);
      }
      i = g.a.a.b.b.a.fS(5);
      AppMethodBeat.o(169069);
      return paramInt + (i + 1);
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dpc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dpc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(169069);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        bdx localbdx = (bdx)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(169069);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localbdx.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169069);
          return 0;
        case 2: 
          localbdx.iKP = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(169069);
          return 0;
        case 3: 
          localbdx.bNu = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(169069);
          return 0;
        case 4: 
          localbdx.twt = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(169069);
          return 0;
        }
        localbdx.completed = ((g.a.a.a.a)localObject1).UbS.yZ();
        AppMethodBeat.o(169069);
        return 0;
      }
      AppMethodBeat.o(169069);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bdx
 * JD-Core Version:    0.7.0.1
 */