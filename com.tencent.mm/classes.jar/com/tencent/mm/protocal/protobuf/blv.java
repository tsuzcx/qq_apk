package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class blv
  extends dyy
{
  public int SWT;
  public String SWU;
  public String SWV;
  public int SWW;
  public String SWX;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91467);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(91467);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(2, this.SWT);
      if (this.SWU != null) {
        paramVarArgs.f(3, this.SWU);
      }
      if (this.SWV != null) {
        paramVarArgs.f(4, this.SWV);
      }
      paramVarArgs.aY(5, this.SWW);
      if (this.SWX != null) {
        paramVarArgs.f(6, this.SWX);
      }
      AppMethodBeat.o(91467);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label608;
      }
    }
    label608:
    for (paramInt = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.SWT);
      paramInt = i;
      if (this.SWU != null) {
        paramInt = i + g.a.a.b.b.a.g(3, this.SWU);
      }
      i = paramInt;
      if (this.SWV != null) {
        i = paramInt + g.a.a.b.b.a.g(4, this.SWV);
      }
      i += g.a.a.b.b.a.bM(5, this.SWW);
      paramInt = i;
      if (this.SWX != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.SWX);
      }
      AppMethodBeat.o(91467);
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
          AppMethodBeat.o(91467);
          throw paramVarArgs;
        }
        AppMethodBeat.o(91467);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        blv localblv = (blv)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91467);
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
            localblv.BaseResponse = localjh;
            paramInt += 1;
          }
          AppMethodBeat.o(91467);
          return 0;
        case 2: 
          localblv.SWT = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(91467);
          return 0;
        case 3: 
          localblv.SWU = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(91467);
          return 0;
        case 4: 
          localblv.SWV = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(91467);
          return 0;
        case 5: 
          localblv.SWW = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(91467);
          return 0;
        }
        localblv.SWX = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(91467);
        return 0;
      }
      AppMethodBeat.o(91467);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.blv
 * JD-Core Version:    0.7.0.1
 */