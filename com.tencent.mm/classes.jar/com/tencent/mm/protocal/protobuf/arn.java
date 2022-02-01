package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class arn
  extends dyy
{
  public String SED;
  public int SEE;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(229787);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.SED != null) {
        paramVarArgs.f(2, this.SED);
      }
      paramVarArgs.aY(3, this.SEE);
      AppMethodBeat.o(229787);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label392;
      }
    }
    label392:
    for (paramInt = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.SED != null) {
        i = paramInt + g.a.a.b.b.a.g(2, this.SED);
      }
      paramInt = g.a.a.b.b.a.bM(3, this.SEE);
      AppMethodBeat.o(229787);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(229787);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        arn localarn = (arn)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(229787);
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
            localarn.BaseResponse = localjh;
            paramInt += 1;
          }
          AppMethodBeat.o(229787);
          return 0;
        case 2: 
          localarn.SED = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(229787);
          return 0;
        }
        localarn.SEE = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(229787);
        return 0;
      }
      AppMethodBeat.o(229787);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.arn
 * JD-Core Version:    0.7.0.1
 */