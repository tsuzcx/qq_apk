package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class bue
  extends com.tencent.mm.cd.a
{
  public String ProductID;
  public eae RJA;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(104796);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.ProductID == null)
      {
        paramVarArgs = new b("Not all required fields were included: ProductID");
        AppMethodBeat.o(104796);
        throw paramVarArgs;
      }
      if (this.RJA == null)
      {
        paramVarArgs = new b("Not all required fields were included: ReqBuf");
        AppMethodBeat.o(104796);
        throw paramVarArgs;
      }
      if (this.ProductID != null) {
        paramVarArgs.f(1, this.ProductID);
      }
      if (this.RJA != null)
      {
        paramVarArgs.oE(2, this.RJA.computeSize());
        this.RJA.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(104796);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ProductID == null) {
        break label444;
      }
    }
    label444:
    for (paramInt = g.a.a.b.b.a.g(1, this.ProductID) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.RJA != null) {
        i = paramInt + g.a.a.a.oD(2, this.RJA.computeSize());
      }
      AppMethodBeat.o(104796);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.ProductID == null)
        {
          paramVarArgs = new b("Not all required fields were included: ProductID");
          AppMethodBeat.o(104796);
          throw paramVarArgs;
        }
        if (this.RJA == null)
        {
          paramVarArgs = new b("Not all required fields were included: ReqBuf");
          AppMethodBeat.o(104796);
          throw paramVarArgs;
        }
        AppMethodBeat.o(104796);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        bue localbue = (bue)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(104796);
          return -1;
        case 1: 
          localbue.ProductID = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(104796);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          eae localeae = new eae();
          if ((localObject != null) && (localObject.length > 0)) {
            localeae.dd((byte[])localObject);
          }
          localbue.RJA = localeae;
          paramInt += 1;
        }
        AppMethodBeat.o(104796);
        return 0;
      }
      AppMethodBeat.o(104796);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bue
 * JD-Core Version:    0.7.0.1
 */