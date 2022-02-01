package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class fmt
  extends com.tencent.mm.bx.a
{
  public fmx aaXa;
  public String title;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72585);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.title != null) {
        paramVarArgs.g(1, this.title);
      }
      if (this.aaXa != null)
      {
        paramVarArgs.qD(2, this.aaXa.computeSize());
        this.aaXa.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(72585);
      return 0;
    }
    if (paramInt == 1) {
      if (this.title == null) {
        break label344;
      }
    }
    label344:
    for (paramInt = i.a.a.b.b.a.h(1, this.title) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.aaXa != null) {
        i = paramInt + i.a.a.a.qC(2, this.aaXa.computeSize());
      }
      AppMethodBeat.o(72585);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(72585);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        fmt localfmt = (fmt)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72585);
          return -1;
        case 1: 
          localfmt.title = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(72585);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          fmx localfmx = new fmx();
          if ((localObject != null) && (localObject.length > 0)) {
            localfmx.parseFrom((byte[])localObject);
          }
          localfmt.aaXa = localfmx;
          paramInt += 1;
        }
        AppMethodBeat.o(72585);
        return 0;
      }
      AppMethodBeat.o(72585);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fmt
 * JD-Core Version:    0.7.0.1
 */