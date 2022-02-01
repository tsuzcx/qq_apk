package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class byw
  extends dyy
{
  public ert ThT;
  public String ThU;
  public boolean ThV;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(176146);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(176146);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.ThT != null)
      {
        paramVarArgs.oE(2, this.ThT.computeSize());
        this.ThT.writeFields(paramVarArgs);
      }
      if (this.ThU != null) {
        paramVarArgs.f(3, this.ThU);
      }
      paramVarArgs.co(4, this.ThV);
      AppMethodBeat.o(176146);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label570;
      }
    }
    label570:
    for (int i = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.ThT != null) {
        paramInt = i + g.a.a.a.oD(2, this.ThT.computeSize());
      }
      i = paramInt;
      if (this.ThU != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.ThU);
      }
      paramInt = g.a.a.b.b.a.gL(4);
      AppMethodBeat.o(176146);
      return i + (paramInt + 1);
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
          AppMethodBeat.o(176146);
          throw paramVarArgs;
        }
        AppMethodBeat.o(176146);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        byw localbyw = (byw)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(176146);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new jh();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((jh)localObject2).parseFrom((byte[])localObject1);
            }
            localbyw.BaseResponse = ((jh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(176146);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new ert();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((ert)localObject2).parseFrom((byte[])localObject1);
            }
            localbyw.ThT = ((ert)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(176146);
          return 0;
        case 3: 
          localbyw.ThU = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(176146);
          return 0;
        }
        localbyw.ThV = ((g.a.a.a.a)localObject1).abFh.AB();
        AppMethodBeat.o(176146);
        return 0;
      }
      AppMethodBeat.o(176146);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.byw
 * JD-Core Version:    0.7.0.1
 */