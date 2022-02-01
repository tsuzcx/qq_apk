package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class giu
  extends com.tencent.mm.bx.a
{
  public gir acfi;
  public String oOI;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(110859);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.oOI == null)
      {
        paramVarArgs = new b("Not all required fields were included: AppId");
        AppMethodBeat.o(110859);
        throw paramVarArgs;
      }
      if (this.acfi == null)
      {
        paramVarArgs = new b("Not all required fields were included: PkgConfig");
        AppMethodBeat.o(110859);
        throw paramVarArgs;
      }
      if (this.oOI != null) {
        paramVarArgs.g(1, this.oOI);
      }
      if (this.acfi != null)
      {
        paramVarArgs.qD(2, this.acfi.computeSize());
        this.acfi.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(110859);
      return 0;
    }
    if (paramInt == 1) {
      if (this.oOI == null) {
        break label440;
      }
    }
    label440:
    for (paramInt = i.a.a.b.b.a.h(1, this.oOI) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.acfi != null) {
        i = paramInt + i.a.a.a.qC(2, this.acfi.computeSize());
      }
      AppMethodBeat.o(110859);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.oOI == null)
        {
          paramVarArgs = new b("Not all required fields were included: AppId");
          AppMethodBeat.o(110859);
          throw paramVarArgs;
        }
        if (this.acfi == null)
        {
          paramVarArgs = new b("Not all required fields were included: PkgConfig");
          AppMethodBeat.o(110859);
          throw paramVarArgs;
        }
        AppMethodBeat.o(110859);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        giu localgiu = (giu)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(110859);
          return -1;
        case 1: 
          localgiu.oOI = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(110859);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          gir localgir = new gir();
          if ((localObject != null) && (localObject.length > 0)) {
            localgir.parseFrom((byte[])localObject);
          }
          localgiu.acfi = localgir;
          paramInt += 1;
        }
        AppMethodBeat.o(110859);
        return 0;
      }
      AppMethodBeat.o(110859);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.giu
 * JD-Core Version:    0.7.0.1
 */