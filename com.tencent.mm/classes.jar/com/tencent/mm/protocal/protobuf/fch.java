package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.b;
import java.util.LinkedList;

public final class fch
  extends com.tencent.mm.cd.a
{
  public b SpH;
  public fcn UCk;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(196086);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.UCk != null)
      {
        paramVarArgs.oE(1, this.UCk.computeSize());
        this.UCk.writeFields(paramVarArgs);
      }
      if (this.SpH != null) {
        paramVarArgs.c(2, this.SpH);
      }
      AppMethodBeat.o(196086);
      return 0;
    }
    if (paramInt == 1) {
      if (this.UCk == null) {
        break label348;
      }
    }
    label348:
    for (paramInt = g.a.a.a.oD(1, this.UCk.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.SpH != null) {
        i = paramInt + g.a.a.b.b.a.b(2, this.SpH);
      }
      AppMethodBeat.o(196086);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(196086);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        fch localfch = (fch)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(196086);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            fcn localfcn = new fcn();
            if ((localObject != null) && (localObject.length > 0)) {
              localfcn.parseFrom((byte[])localObject);
            }
            localfch.UCk = localfcn;
            paramInt += 1;
          }
          AppMethodBeat.o(196086);
          return 0;
        }
        localfch.SpH = ((g.a.a.a.a)localObject).abFh.iUw();
        AppMethodBeat.o(196086);
        return 0;
      }
      AppMethodBeat.o(196086);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fch
 * JD-Core Version:    0.7.0.1
 */