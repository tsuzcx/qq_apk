package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class ze
  extends dyy
{
  public int Slm;
  public int Sln;
  public int Slo;
  public int rWu;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(127629);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(127629);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(2, this.rWu);
      paramVarArgs.aY(3, this.Slm);
      paramVarArgs.aY(4, this.Sln);
      paramVarArgs.aY(5, this.Slo);
      AppMethodBeat.o(127629);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label520;
      }
    }
    label520:
    for (paramInt = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = g.a.a.b.b.a.bM(2, this.rWu);
      int j = g.a.a.b.b.a.bM(3, this.Slm);
      int k = g.a.a.b.b.a.bM(4, this.Sln);
      int m = g.a.a.b.b.a.bM(5, this.Slo);
      AppMethodBeat.o(127629);
      return paramInt + i + j + k + m;
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
          AppMethodBeat.o(127629);
          throw paramVarArgs;
        }
        AppMethodBeat.o(127629);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        ze localze = (ze)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(127629);
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
            localze.BaseResponse = localjh;
            paramInt += 1;
          }
          AppMethodBeat.o(127629);
          return 0;
        case 2: 
          localze.rWu = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(127629);
          return 0;
        case 3: 
          localze.Slm = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(127629);
          return 0;
        case 4: 
          localze.Sln = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(127629);
          return 0;
        }
        localze.Slo = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(127629);
        return 0;
      }
      AppMethodBeat.o(127629);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ze
 * JD-Core Version:    0.7.0.1
 */