package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class eun
  extends com.tencent.mm.bx.a
{
  public euo YJf;
  public String scope;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(257643);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.scope != null) {
        paramVarArgs.g(1, this.scope);
      }
      if (this.YJf != null)
      {
        paramVarArgs.qD(2, this.YJf.computeSize());
        this.YJf.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(257643);
      return 0;
    }
    if (paramInt == 1) {
      if (this.scope == null) {
        break label344;
      }
    }
    label344:
    for (paramInt = i.a.a.b.b.a.h(1, this.scope) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.YJf != null) {
        i = paramInt + i.a.a.a.qC(2, this.YJf.computeSize());
      }
      AppMethodBeat.o(257643);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(257643);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        eun localeun = (eun)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(257643);
          return -1;
        case 1: 
          localeun.scope = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(257643);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          euo localeuo = new euo();
          if ((localObject != null) && (localObject.length > 0)) {
            localeuo.parseFrom((byte[])localObject);
          }
          localeun.YJf = localeuo;
          paramInt += 1;
        }
        AppMethodBeat.o(257643);
        return 0;
      }
      AppMethodBeat.o(257643);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eun
 * JD-Core Version:    0.7.0.1
 */