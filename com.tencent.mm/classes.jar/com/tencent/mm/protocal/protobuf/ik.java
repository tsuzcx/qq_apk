package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class ik
  extends com.tencent.mm.bx.a
{
  public gol YKe;
  public gol YKf;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(133147);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.YKe == null)
      {
        paramVarArgs = new b("Not all required fields were included: EncryptKey");
        AppMethodBeat.o(133147);
        throw paramVarArgs;
      }
      if (this.YKf == null)
      {
        paramVarArgs = new b("Not all required fields were included: Key");
        AppMethodBeat.o(133147);
        throw paramVarArgs;
      }
      if (this.YKe != null)
      {
        paramVarArgs.qD(1, this.YKe.computeSize());
        this.YKe.writeFields(paramVarArgs);
      }
      if (this.YKf != null)
      {
        paramVarArgs.qD(2, this.YKf.computeSize());
        this.YKf.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(133147);
      return 0;
    }
    if (paramInt == 1) {
      if (this.YKe == null) {
        break label514;
      }
    }
    label514:
    for (paramInt = i.a.a.a.qC(1, this.YKe.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.YKf != null) {
        i = paramInt + i.a.a.a.qC(2, this.YKf.computeSize());
      }
      AppMethodBeat.o(133147);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.YKe == null)
        {
          paramVarArgs = new b("Not all required fields were included: EncryptKey");
          AppMethodBeat.o(133147);
          throw paramVarArgs;
        }
        if (this.YKf == null)
        {
          paramVarArgs = new b("Not all required fields were included: Key");
          AppMethodBeat.o(133147);
          throw paramVarArgs;
        }
        AppMethodBeat.o(133147);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        ik localik = (ik)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        gol localgol;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(133147);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            localgol = new gol();
            if ((localObject != null) && (localObject.length > 0)) {
              localgol.dg((byte[])localObject);
            }
            localik.YKe = localgol;
            paramInt += 1;
          }
          AppMethodBeat.o(133147);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          localgol = new gol();
          if ((localObject != null) && (localObject.length > 0)) {
            localgol.dg((byte[])localObject);
          }
          localik.YKf = localgol;
          paramInt += 1;
        }
        AppMethodBeat.o(133147);
        return 0;
      }
      AppMethodBeat.o(133147);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ik
 * JD-Core Version:    0.7.0.1
 */