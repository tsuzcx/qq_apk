package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class mr
  extends dyy
{
  public int ROx;
  public String RSF;
  public long RSk;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(207085);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(207085);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.RSF != null) {
        paramVarArgs.f(2, this.RSF);
      }
      paramVarArgs.bm(11, this.RSk);
      paramVarArgs.aY(15, this.ROx);
      AppMethodBeat.o(207085);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label504;
      }
    }
    label504:
    for (paramInt = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.RSF != null) {
        i = paramInt + g.a.a.b.b.a.g(2, this.RSF);
      }
      paramInt = g.a.a.b.b.a.p(11, this.RSk);
      int j = g.a.a.b.b.a.bM(15, this.ROx);
      AppMethodBeat.o(207085);
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
          AppMethodBeat.o(207085);
          throw paramVarArgs;
        }
        AppMethodBeat.o(207085);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        mr localmr = (mr)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(207085);
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
            localmr.BaseResponse = localjh;
            paramInt += 1;
          }
          AppMethodBeat.o(207085);
          return 0;
        case 2: 
          localmr.RSF = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(207085);
          return 0;
        case 11: 
          localmr.RSk = ((g.a.a.a.a)localObject).abFh.AN();
          AppMethodBeat.o(207085);
          return 0;
        }
        localmr.ROx = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(207085);
        return 0;
      }
      AppMethodBeat.o(207085);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.mr
 * JD-Core Version:    0.7.0.1
 */