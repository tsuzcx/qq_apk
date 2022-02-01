package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class ern
  extends dyy
{
  public String CSe;
  public int RIs;
  public int RTQ;
  public long RXN;
  public String RXT;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(206716);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(206716);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.bm(2, this.RXN);
      paramVarArgs.aY(3, this.RIs);
      paramVarArgs.aY(4, this.RTQ);
      if (this.RXT != null) {
        paramVarArgs.f(5, this.RXT);
      }
      if (this.CSe != null) {
        paramVarArgs.f(6, this.CSe);
      }
      AppMethodBeat.o(206716);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label588;
      }
    }
    label588:
    for (paramInt = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.p(2, this.RXN) + g.a.a.b.b.a.bM(3, this.RIs) + g.a.a.b.b.a.bM(4, this.RTQ);
      paramInt = i;
      if (this.RXT != null) {
        paramInt = i + g.a.a.b.b.a.g(5, this.RXT);
      }
      i = paramInt;
      if (this.CSe != null) {
        i = paramInt + g.a.a.b.b.a.g(6, this.CSe);
      }
      AppMethodBeat.o(206716);
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
          AppMethodBeat.o(206716);
          throw paramVarArgs;
        }
        AppMethodBeat.o(206716);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        ern localern = (ern)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(206716);
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
            localern.BaseResponse = localjh;
            paramInt += 1;
          }
          AppMethodBeat.o(206716);
          return 0;
        case 2: 
          localern.RXN = ((g.a.a.a.a)localObject).abFh.AN();
          AppMethodBeat.o(206716);
          return 0;
        case 3: 
          localern.RIs = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(206716);
          return 0;
        case 4: 
          localern.RTQ = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(206716);
          return 0;
        case 5: 
          localern.RXT = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(206716);
          return 0;
        }
        localern.CSe = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(206716);
        return 0;
      }
      AppMethodBeat.o(206716);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ern
 * JD-Core Version:    0.7.0.1
 */