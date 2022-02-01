package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bez
  extends com.tencent.mm.bx.a
{
  public dij ZPi;
  public String ZPj;
  public String description;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258670);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.description != null) {
        paramVarArgs.g(1, this.description);
      }
      if (this.ZPi != null)
      {
        paramVarArgs.qD(2, this.ZPi.computeSize());
        this.ZPi.writeFields(paramVarArgs);
      }
      if (this.ZPj != null) {
        paramVarArgs.g(3, this.ZPj);
      }
      AppMethodBeat.o(258670);
      return 0;
    }
    if (paramInt == 1) {
      if (this.description == null) {
        break label404;
      }
    }
    label404:
    for (int i = i.a.a.b.b.a.h(1, this.description) + 0;; i = 0)
    {
      paramInt = i;
      if (this.ZPi != null) {
        paramInt = i + i.a.a.a.qC(2, this.ZPi.computeSize());
      }
      i = paramInt;
      if (this.ZPj != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.ZPj);
      }
      AppMethodBeat.o(258670);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(258670);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        bez localbez = (bez)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(258670);
          return -1;
        case 1: 
          localbez.description = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(258670);
          return 0;
        case 2: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            dij localdij = new dij();
            if ((localObject != null) && (localObject.length > 0)) {
              localdij.parseFrom((byte[])localObject);
            }
            localbez.ZPi = localdij;
            paramInt += 1;
          }
          AppMethodBeat.o(258670);
          return 0;
        }
        localbez.ZPj = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(258670);
        return 0;
      }
      AppMethodBeat.o(258670);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bez
 * JD-Core Version:    0.7.0.1
 */