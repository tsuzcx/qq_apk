package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dat
  extends com.tencent.mm.cd.a
{
  public String TIm;
  public bds TIn;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(229097);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.TIm != null) {
        paramVarArgs.f(1, this.TIm);
      }
      if (this.TIn != null)
      {
        paramVarArgs.oE(2, this.TIn.computeSize());
        this.TIn.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(229097);
      return 0;
    }
    if (paramInt == 1) {
      if (this.TIm == null) {
        break label348;
      }
    }
    label348:
    for (paramInt = g.a.a.b.b.a.g(1, this.TIm) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.TIn != null) {
        i = paramInt + g.a.a.a.oD(2, this.TIn.computeSize());
      }
      AppMethodBeat.o(229097);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(229097);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        dat localdat = (dat)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(229097);
          return -1;
        case 1: 
          localdat.TIm = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(229097);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          bds localbds = new bds();
          if ((localObject != null) && (localObject.length > 0)) {
            localbds.parseFrom((byte[])localObject);
          }
          localdat.TIn = localbds;
          paramInt += 1;
        }
        AppMethodBeat.o(229097);
        return 0;
      }
      AppMethodBeat.o(229097);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dat
 * JD-Core Version:    0.7.0.1
 */