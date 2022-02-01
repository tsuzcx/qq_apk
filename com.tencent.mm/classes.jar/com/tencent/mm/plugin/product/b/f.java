package com.tencent.mm.plugin.product.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class f
  extends com.tencent.mm.bx.a
{
  public String MRA;
  public j MRz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91272);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.MRz != null)
      {
        paramVarArgs.qD(1, this.MRz.computeSize());
        this.MRz.writeFields(paramVarArgs);
      }
      if (this.MRA != null) {
        paramVarArgs.g(2, this.MRA);
      }
      AppMethodBeat.o(91272);
      return 0;
    }
    if (paramInt == 1) {
      if (this.MRz == null) {
        break label344;
      }
    }
    label344:
    for (paramInt = i.a.a.a.qC(1, this.MRz.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.MRA != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.MRA);
      }
      AppMethodBeat.o(91272);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(91272);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        f localf = (f)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91272);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            j localj = new j();
            if ((localObject != null) && (localObject.length > 0)) {
              localj.parseFrom((byte[])localObject);
            }
            localf.MRz = localj;
            paramInt += 1;
          }
          AppMethodBeat.o(91272);
          return 0;
        }
        localf.MRA = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(91272);
        return 0;
      }
      AppMethodBeat.o(91272);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.product.b.f
 * JD-Core Version:    0.7.0.1
 */