package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;

public final class ggx
  extends com.tencent.mm.bx.a
{
  public String acdi;
  public String acdj;
  public String acdk;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32562);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.acdi == null)
      {
        paramVarArgs = new b("Not all required fields were included: Plugin");
        AppMethodBeat.o(32562);
        throw paramVarArgs;
      }
      if (this.acdj == null)
      {
        paramVarArgs = new b("Not all required fields were included: ActivityPath");
        AppMethodBeat.o(32562);
        throw paramVarArgs;
      }
      if (this.acdi != null) {
        paramVarArgs.g(1, this.acdi);
      }
      if (this.acdj != null) {
        paramVarArgs.g(2, this.acdj);
      }
      if (this.acdk != null) {
        paramVarArgs.g(3, this.acdk);
      }
      AppMethodBeat.o(32562);
      return 0;
    }
    if (paramInt == 1) {
      if (this.acdi == null) {
        break label439;
      }
    }
    label439:
    for (int i = i.a.a.b.b.a.h(1, this.acdi) + 0;; i = 0)
    {
      paramInt = i;
      if (this.acdj != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.acdj);
      }
      i = paramInt;
      if (this.acdk != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.acdk);
      }
      AppMethodBeat.o(32562);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.acdi == null)
        {
          paramVarArgs = new b("Not all required fields were included: Plugin");
          AppMethodBeat.o(32562);
          throw paramVarArgs;
        }
        if (this.acdj == null)
        {
          paramVarArgs = new b("Not all required fields were included: ActivityPath");
          AppMethodBeat.o(32562);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32562);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        ggx localggx = (ggx)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(32562);
          return -1;
        case 1: 
          localggx.acdi = locala.ajGk.readString();
          AppMethodBeat.o(32562);
          return 0;
        case 2: 
          localggx.acdj = locala.ajGk.readString();
          AppMethodBeat.o(32562);
          return 0;
        }
        localggx.acdk = locala.ajGk.readString();
        AppMethodBeat.o(32562);
        return 0;
      }
      AppMethodBeat.o(32562);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ggx
 * JD-Core Version:    0.7.0.1
 */