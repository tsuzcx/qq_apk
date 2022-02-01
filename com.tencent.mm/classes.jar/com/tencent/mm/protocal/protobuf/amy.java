package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class amy
  extends dyy
{
  public long SwY;
  public String SwZ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(155406);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(155406);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.bm(2, this.SwY);
      if (this.SwZ != null) {
        paramVarArgs.f(3, this.SwZ);
      }
      AppMethodBeat.o(155406);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label440;
      }
    }
    label440:
    for (paramInt = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.p(2, this.SwY);
      paramInt = i;
      if (this.SwZ != null) {
        paramInt = i + g.a.a.b.b.a.g(3, this.SwZ);
      }
      AppMethodBeat.o(155406);
      return paramInt;
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
          AppMethodBeat.o(155406);
          throw paramVarArgs;
        }
        AppMethodBeat.o(155406);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        amy localamy = (amy)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(155406);
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
            localamy.BaseResponse = localjh;
            paramInt += 1;
          }
          AppMethodBeat.o(155406);
          return 0;
        case 2: 
          localamy.SwY = ((g.a.a.a.a)localObject).abFh.AN();
          AppMethodBeat.o(155406);
          return 0;
        }
        localamy.SwZ = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(155406);
        return 0;
      }
      AppMethodBeat.o(155406);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.amy
 * JD-Core Version:    0.7.0.1
 */