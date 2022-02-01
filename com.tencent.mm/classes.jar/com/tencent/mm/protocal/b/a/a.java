package com.tencent.mm.protocal.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;

public final class a
  extends com.tencent.mm.bw.a
{
  public String KBo;
  public String KBp;
  public int actionType;
  public int id;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123716);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.KBo == null)
      {
        paramVarArgs = new b("Not all required fields were included: btnStr");
        AppMethodBeat.o(123716);
        throw paramVarArgs;
      }
      paramVarArgs.aM(1, this.id);
      paramVarArgs.aM(2, this.actionType);
      if (this.KBo != null) {
        paramVarArgs.e(3, this.KBo);
      }
      if (this.KBp != null) {
        paramVarArgs.e(4, this.KBp);
      }
      AppMethodBeat.o(123716);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bu(1, this.id) + 0 + g.a.a.b.b.a.bu(2, this.actionType);
      paramInt = i;
      if (this.KBo != null) {
        paramInt = i + g.a.a.b.b.a.f(3, this.KBo);
      }
      i = paramInt;
      if (this.KBp != null) {
        i = paramInt + g.a.a.b.b.a.f(4, this.KBp);
      }
      AppMethodBeat.o(123716);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      if (this.KBo == null)
      {
        paramVarArgs = new b("Not all required fields were included: btnStr");
        AppMethodBeat.o(123716);
        throw paramVarArgs;
      }
      AppMethodBeat.o(123716);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      a locala1 = (a)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(123716);
        return -1;
      case 1: 
        locala1.id = locala.UbS.zi();
        AppMethodBeat.o(123716);
        return 0;
      case 2: 
        locala1.actionType = locala.UbS.zi();
        AppMethodBeat.o(123716);
        return 0;
      case 3: 
        locala1.KBo = locala.UbS.readString();
        AppMethodBeat.o(123716);
        return 0;
      }
      locala1.KBp = locala.UbS.readString();
      AppMethodBeat.o(123716);
      return 0;
    }
    AppMethodBeat.o(123716);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.b.a.a
 * JD-Core Version:    0.7.0.1
 */