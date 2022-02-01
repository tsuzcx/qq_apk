package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class eon
  extends com.tencent.mm.bw.a
{
  public String CYp;
  public int CYq;
  public String scope;
  public int state;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(74674);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.scope != null) {
        paramVarArgs.e(1, this.scope);
      }
      if (this.CYp != null) {
        paramVarArgs.e(2, this.CYp);
      }
      paramVarArgs.aM(3, this.state);
      paramVarArgs.aM(4, this.CYq);
      AppMethodBeat.o(74674);
      return 0;
    }
    if (paramInt == 1) {
      if (this.scope == null) {
        break label366;
      }
    }
    label366:
    for (paramInt = g.a.a.b.b.a.f(1, this.scope) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.CYp != null) {
        i = paramInt + g.a.a.b.b.a.f(2, this.CYp);
      }
      paramInt = g.a.a.b.b.a.bu(3, this.state);
      int j = g.a.a.b.b.a.bu(4, this.CYq);
      AppMethodBeat.o(74674);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(74674);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        eon localeon = (eon)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(74674);
          return -1;
        case 1: 
          localeon.scope = locala.UbS.readString();
          AppMethodBeat.o(74674);
          return 0;
        case 2: 
          localeon.CYp = locala.UbS.readString();
          AppMethodBeat.o(74674);
          return 0;
        case 3: 
          localeon.state = locala.UbS.zi();
          AppMethodBeat.o(74674);
          return 0;
        }
        localeon.CYq = locala.UbS.zi();
        AppMethodBeat.o(74674);
        return 0;
      }
      AppMethodBeat.o(74674);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eon
 * JD-Core Version:    0.7.0.1
 */