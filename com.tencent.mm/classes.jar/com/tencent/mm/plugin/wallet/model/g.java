package com.tencent.mm.plugin.wallet.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class g
  extends com.tencent.mm.bx.a
{
  public k Vlf;
  public String Vlh;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91291);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.Vlf != null)
      {
        paramVarArgs.qD(1, this.Vlf.computeSize());
        this.Vlf.writeFields(paramVarArgs);
      }
      if (this.Vlh != null) {
        paramVarArgs.g(2, this.Vlh);
      }
      AppMethodBeat.o(91291);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Vlf == null) {
        break label344;
      }
    }
    label344:
    for (paramInt = i.a.a.a.qC(1, this.Vlf.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Vlh != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.Vlh);
      }
      AppMethodBeat.o(91291);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(91291);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        g localg = (g)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91291);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            k localk = new k();
            if ((localObject != null) && (localObject.length > 0)) {
              localk.parseFrom((byte[])localObject);
            }
            localg.Vlf = localk;
            paramInt += 1;
          }
          AppMethodBeat.o(91291);
          return 0;
        }
        localg.Vlh = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(91291);
        return 0;
      }
      AppMethodBeat.o(91291);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.model.g
 * JD-Core Version:    0.7.0.1
 */