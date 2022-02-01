package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class cal
  extends dyy
{
  public String IKh;
  public int Sjq;
  public String TiP;
  public int block;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(116455);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(116455);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.IKh != null) {
        paramVarArgs.f(2, this.IKh);
      }
      paramVarArgs.aY(3, this.block);
      if (this.TiP != null) {
        paramVarArgs.f(4, this.TiP);
      }
      paramVarArgs.aY(5, this.Sjq);
      AppMethodBeat.o(116455);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label544;
      }
    }
    label544:
    for (paramInt = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.IKh != null) {
        i = paramInt + g.a.a.b.b.a.g(2, this.IKh);
      }
      i += g.a.a.b.b.a.bM(3, this.block);
      paramInt = i;
      if (this.TiP != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.TiP);
      }
      i = g.a.a.b.b.a.bM(5, this.Sjq);
      AppMethodBeat.o(116455);
      return paramInt + i;
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
          AppMethodBeat.o(116455);
          throw paramVarArgs;
        }
        AppMethodBeat.o(116455);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        cal localcal = (cal)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(116455);
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
            localcal.BaseResponse = localjh;
            paramInt += 1;
          }
          AppMethodBeat.o(116455);
          return 0;
        case 2: 
          localcal.IKh = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(116455);
          return 0;
        case 3: 
          localcal.block = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(116455);
          return 0;
        case 4: 
          localcal.TiP = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(116455);
          return 0;
        }
        localcal.Sjq = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(116455);
        return 0;
      }
      AppMethodBeat.o(116455);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cal
 * JD-Core Version:    0.7.0.1
 */