package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class epd
  extends com.tencent.mm.bx.a
{
  public fes ZEH;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259306);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.ZEH != null)
      {
        paramVarArgs.qD(1, this.ZEH.computeSize());
        this.ZEH.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(259306);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ZEH == null) {
        break label284;
      }
    }
    label284:
    for (paramInt = i.a.a.a.qC(1, this.ZEH.computeSize()) + 0;; paramInt = 0)
    {
      AppMethodBeat.o(259306);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(259306);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        epd localepd = (epd)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(259306);
          return -1;
        }
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        int i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          fes localfes = new fes();
          if ((localObject != null) && (localObject.length > 0)) {
            localfes.parseFrom((byte[])localObject);
          }
          localepd.ZEH = localfes;
          paramInt += 1;
        }
        AppMethodBeat.o(259306);
        return 0;
      }
      AppMethodBeat.o(259306);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.epd
 * JD-Core Version:    0.7.0.1
 */