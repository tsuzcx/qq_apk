package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class cvi
  extends dyy
{
  public int TCX;
  public int TDa;
  public int TDj;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32346);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(32346);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(2, this.TCX);
      paramVarArgs.aY(3, this.TDa);
      paramVarArgs.aY(4, this.TDj);
      AppMethodBeat.o(32346);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label486;
      }
    }
    label486:
    for (paramInt = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = g.a.a.b.b.a.bM(2, this.TCX);
      int j = g.a.a.b.b.a.bM(3, this.TDa);
      int k = g.a.a.b.b.a.bM(4, this.TDj);
      AppMethodBeat.o(32346);
      return paramInt + i + j + k;
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
          AppMethodBeat.o(32346);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32346);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        cvi localcvi = (cvi)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32346);
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
            localcvi.BaseResponse = localjh;
            paramInt += 1;
          }
          AppMethodBeat.o(32346);
          return 0;
        case 2: 
          localcvi.TCX = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(32346);
          return 0;
        case 3: 
          localcvi.TDa = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(32346);
          return 0;
        }
        localcvi.TDj = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(32346);
        return 0;
      }
      AppMethodBeat.o(32346);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cvi
 * JD-Core Version:    0.7.0.1
 */