package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class eap
  extends com.tencent.mm.bx.a
{
  public dnd abfR;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258376);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.abfR != null)
      {
        paramVarArgs.qD(1, this.abfR.computeSize());
        this.abfR.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(258376);
      return 0;
    }
    if (paramInt == 1) {
      if (this.abfR == null) {
        break label284;
      }
    }
    label284:
    for (paramInt = i.a.a.a.qC(1, this.abfR.computeSize()) + 0;; paramInt = 0)
    {
      AppMethodBeat.o(258376);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(258376);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        eap localeap = (eap)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(258376);
          return -1;
        }
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        int i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          dnd localdnd = new dnd();
          if ((localObject != null) && (localObject.length > 0)) {
            localdnd.parseFrom((byte[])localObject);
          }
          localeap.abfR = localdnd;
          paramInt += 1;
        }
        AppMethodBeat.o(258376);
        return 0;
      }
      AppMethodBeat.o(258376);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eap
 * JD-Core Version:    0.7.0.1
 */