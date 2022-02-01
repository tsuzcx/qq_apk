package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class gjc
  extends com.tencent.mm.bx.a
{
  public efc acfs;
  public efc acft;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(110919);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.acfs != null)
      {
        paramVarArgs.qD(1, this.acfs.computeSize());
        this.acfs.writeFields(paramVarArgs);
      }
      if (this.acft != null)
      {
        paramVarArgs.qD(2, this.acft.computeSize());
        this.acft.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(110919);
      return 0;
    }
    if (paramInt == 1) {
      if (this.acfs == null) {
        break label418;
      }
    }
    label418:
    for (paramInt = i.a.a.a.qC(1, this.acfs.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.acft != null) {
        i = paramInt + i.a.a.a.qC(2, this.acft.computeSize());
      }
      AppMethodBeat.o(110919);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(110919);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        gjc localgjc = (gjc)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        efc localefc;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(110919);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            localefc = new efc();
            if ((localObject != null) && (localObject.length > 0)) {
              localefc.parseFrom((byte[])localObject);
            }
            localgjc.acfs = localefc;
            paramInt += 1;
          }
          AppMethodBeat.o(110919);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          localefc = new efc();
          if ((localObject != null) && (localObject.length > 0)) {
            localefc.parseFrom((byte[])localObject);
          }
          localgjc.acft = localefc;
          paramInt += 1;
        }
        AppMethodBeat.o(110919);
        return 0;
      }
      AppMethodBeat.o(110919);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.gjc
 * JD-Core Version:    0.7.0.1
 */