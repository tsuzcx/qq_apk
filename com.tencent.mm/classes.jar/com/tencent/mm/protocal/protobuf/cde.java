package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class cde
  extends dyy
{
  public String Tlb;
  public String Tle;
  public int tpK;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(260331);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(260331);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(2, this.tpK);
      if (this.Tlb != null) {
        paramVarArgs.f(3, this.Tlb);
      }
      if (this.Tle != null) {
        paramVarArgs.f(4, this.Tle);
      }
      AppMethodBeat.o(260331);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label500;
      }
    }
    label500:
    for (paramInt = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.tpK);
      paramInt = i;
      if (this.Tlb != null) {
        paramInt = i + g.a.a.b.b.a.g(3, this.Tlb);
      }
      i = paramInt;
      if (this.Tle != null) {
        i = paramInt + g.a.a.b.b.a.g(4, this.Tle);
      }
      AppMethodBeat.o(260331);
      return i;
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
          AppMethodBeat.o(260331);
          throw paramVarArgs;
        }
        AppMethodBeat.o(260331);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        cde localcde = (cde)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(260331);
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
            localcde.BaseResponse = localjh;
            paramInt += 1;
          }
          AppMethodBeat.o(260331);
          return 0;
        case 2: 
          localcde.tpK = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(260331);
          return 0;
        case 3: 
          localcde.Tlb = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(260331);
          return 0;
        }
        localcde.Tle = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(260331);
        return 0;
      }
      AppMethodBeat.o(260331);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cde
 * JD-Core Version:    0.7.0.1
 */