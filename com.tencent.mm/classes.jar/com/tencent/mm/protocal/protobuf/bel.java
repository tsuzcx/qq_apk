package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bel
  extends com.tencent.mm.bx.a
{
  public String content;
  public boi location;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258722);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.location != null)
      {
        paramVarArgs.qD(1, this.location.computeSize());
        this.location.writeFields(paramVarArgs);
      }
      if (this.content != null) {
        paramVarArgs.g(2, this.content);
      }
      AppMethodBeat.o(258722);
      return 0;
    }
    if (paramInt == 1) {
      if (this.location == null) {
        break label344;
      }
    }
    label344:
    for (paramInt = i.a.a.a.qC(1, this.location.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.content != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.content);
      }
      AppMethodBeat.o(258722);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(258722);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        bel localbel = (bel)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(258722);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            boi localboi = new boi();
            if ((localObject != null) && (localObject.length > 0)) {
              localboi.parseFrom((byte[])localObject);
            }
            localbel.location = localboi;
            paramInt += 1;
          }
          AppMethodBeat.o(258722);
          return 0;
        }
        localbel.content = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(258722);
        return 0;
      }
      AppMethodBeat.o(258722);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bel
 * JD-Core Version:    0.7.0.1
 */