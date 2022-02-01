package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class po
  extends com.tencent.mm.cd.a
{
  public dza RXU;
  public String RXV;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117836);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.RXU != null)
      {
        paramVarArgs.oE(1, this.RXU.computeSize());
        this.RXU.writeFields(paramVarArgs);
      }
      if (this.RXV != null) {
        paramVarArgs.f(2, this.RXV);
      }
      AppMethodBeat.o(117836);
      return 0;
    }
    if (paramInt == 1) {
      if (this.RXU == null) {
        break label348;
      }
    }
    label348:
    for (paramInt = g.a.a.a.oD(1, this.RXU.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.RXV != null) {
        i = paramInt + g.a.a.b.b.a.g(2, this.RXV);
      }
      AppMethodBeat.o(117836);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(117836);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        po localpo = (po)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(117836);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            dza localdza = new dza();
            if ((localObject != null) && (localObject.length > 0)) {
              localdza.parseFrom((byte[])localObject);
            }
            localpo.RXU = localdza;
            paramInt += 1;
          }
          AppMethodBeat.o(117836);
          return 0;
        }
        localpo.RXV = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(117836);
        return 0;
      }
      AppMethodBeat.o(117836);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.po
 * JD-Core Version:    0.7.0.1
 */