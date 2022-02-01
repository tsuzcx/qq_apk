package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class eoe
  extends dyy
{
  public LinkedList<Integer> UlX;
  public int UqU;
  
  public eoe()
  {
    AppMethodBeat.i(118466);
    this.UlX = new LinkedList();
    AppMethodBeat.o(118466);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(118467);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new g.a.a.b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(118467);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(2, this.UqU);
      paramVarArgs.f(3, 2, this.UlX);
      AppMethodBeat.o(118467);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label455;
      }
    }
    label455:
    for (paramInt = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = g.a.a.b.b.a.bM(2, this.UqU);
      int j = g.a.a.a.d(3, 2, this.UlX);
      AppMethodBeat.o(118467);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.UlX.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dyy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new g.a.a.b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(118467);
          throw paramVarArgs;
        }
        AppMethodBeat.o(118467);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        eoe localeoe = (eoe)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(118467);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            jh localjh = new jh();
            if ((localObject != null) && (localObject.length > 0)) {
              localjh.parseFrom((byte[])localObject);
            }
            localeoe.BaseResponse = localjh;
            paramInt += 1;
          }
          AppMethodBeat.o(118467);
          return 0;
        case 2: 
          localeoe.UqU = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(118467);
          return 0;
        }
        localeoe.UlX = new g.a.a.a.a(((g.a.a.a.a)localObject).abFh.iUw().UH, unknownTagHandler).abFh.iUu();
        AppMethodBeat.o(118467);
        return 0;
      }
      AppMethodBeat.o(118467);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eoe
 * JD-Core Version:    0.7.0.1
 */