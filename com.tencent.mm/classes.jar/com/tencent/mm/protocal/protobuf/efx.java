package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class efx
  extends dyy
{
  public int RLc;
  public int Uja;
  public String jUi;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32435);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(32435);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.jUi != null) {
        paramVarArgs.f(2, this.jUi);
      }
      paramVarArgs.aY(3, this.RLc);
      paramVarArgs.aY(4, this.Uja);
      AppMethodBeat.o(32435);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label498;
      }
    }
    label498:
    for (paramInt = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.jUi != null) {
        i = paramInt + g.a.a.b.b.a.g(2, this.jUi);
      }
      paramInt = g.a.a.b.b.a.bM(3, this.RLc);
      int j = g.a.a.b.b.a.bM(4, this.Uja);
      AppMethodBeat.o(32435);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(32435);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32435);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        efx localefx = (efx)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32435);
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
            localefx.BaseResponse = localjh;
            paramInt += 1;
          }
          AppMethodBeat.o(32435);
          return 0;
        case 2: 
          localefx.jUi = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(32435);
          return 0;
        case 3: 
          localefx.RLc = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(32435);
          return 0;
        }
        localefx.Uja = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(32435);
        return 0;
      }
      AppMethodBeat.o(32435);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.efx
 * JD-Core Version:    0.7.0.1
 */