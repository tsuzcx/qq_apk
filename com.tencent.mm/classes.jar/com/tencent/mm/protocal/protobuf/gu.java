package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class gu
  extends com.tencent.mm.cd.a
{
  public String ProductID;
  public akf RLI;
  public String RLJ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(104745);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.ProductID == null)
      {
        paramVarArgs = new b("Not all required fields were included: ProductID");
        AppMethodBeat.o(104745);
        throw paramVarArgs;
      }
      if (this.RLI == null)
      {
        paramVarArgs = new b("Not all required fields were included: Price");
        AppMethodBeat.o(104745);
        throw paramVarArgs;
      }
      if (this.ProductID != null) {
        paramVarArgs.f(1, this.ProductID);
      }
      if (this.RLI != null)
      {
        paramVarArgs.oE(2, this.RLI.computeSize());
        this.RLI.writeFields(paramVarArgs);
      }
      if (this.RLJ != null) {
        paramVarArgs.f(3, this.RLJ);
      }
      AppMethodBeat.o(104745);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ProductID == null) {
        break label504;
      }
    }
    label504:
    for (int i = g.a.a.b.b.a.g(1, this.ProductID) + 0;; i = 0)
    {
      paramInt = i;
      if (this.RLI != null) {
        paramInt = i + g.a.a.a.oD(2, this.RLI.computeSize());
      }
      i = paramInt;
      if (this.RLJ != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.RLJ);
      }
      AppMethodBeat.o(104745);
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
          AppMethodBeat.o(104745);
          throw paramVarArgs;
        }
        if (this.RLI == null)
        {
          paramVarArgs = new b("Not all required fields were included: Price");
          AppMethodBeat.o(104745);
          throw paramVarArgs;
        }
        AppMethodBeat.o(104745);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        gu localgu = (gu)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(104745);
          return -1;
        case 1: 
          localgu.ProductID = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(104745);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            akf localakf = new akf();
            if ((localObject != null) && (localObject.length > 0)) {
              localakf.parseFrom((byte[])localObject);
            }
            localgu.RLI = localakf;
            paramInt += 1;
          }
          AppMethodBeat.o(104745);
          return 0;
        }
        localgu.RLJ = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(104745);
        return 0;
      }
      AppMethodBeat.o(104745);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.gu
 * JD-Core Version:    0.7.0.1
 */