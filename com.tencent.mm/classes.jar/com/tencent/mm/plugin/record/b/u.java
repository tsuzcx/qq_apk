package com.tencent.mm.plugin.record.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;

public final class u
  extends com.tencent.mm.bx.a
{
  public int dBt;
  public String gXN;
  public int id;
  public int status;
  public String vaR;
  public b vaS;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(27828);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.id);
      paramVarArgs.aR(2, this.status);
      if (this.vaR != null) {
        paramVarArgs.d(3, this.vaR);
      }
      if (this.gXN != null) {
        paramVarArgs.d(4, this.gXN);
      }
      if (this.vaS != null) {
        paramVarArgs.c(5, this.vaS);
      }
      paramVarArgs.aR(6, this.dBt);
      AppMethodBeat.o(27828);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bA(1, this.id) + 0 + f.a.a.b.b.a.bA(2, this.status);
      paramInt = i;
      if (this.vaR != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.vaR);
      }
      i = paramInt;
      if (this.gXN != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.gXN);
      }
      paramInt = i;
      if (this.vaS != null) {
        paramInt = i + f.a.a.b.b.a.b(5, this.vaS);
      }
      i = f.a.a.b.b.a.bA(6, this.dBt);
      AppMethodBeat.o(27828);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      AppMethodBeat.o(27828);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      u localu = (u)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(27828);
        return -1;
      case 1: 
        localu.id = locala.KhF.xS();
        AppMethodBeat.o(27828);
        return 0;
      case 2: 
        localu.status = locala.KhF.xS();
        AppMethodBeat.o(27828);
        return 0;
      case 3: 
        localu.vaR = locala.KhF.readString();
        AppMethodBeat.o(27828);
        return 0;
      case 4: 
        localu.gXN = locala.KhF.readString();
        AppMethodBeat.o(27828);
        return 0;
      case 5: 
        localu.vaS = locala.KhF.fMu();
        AppMethodBeat.o(27828);
        return 0;
      }
      localu.dBt = locala.KhF.xS();
      AppMethodBeat.o(27828);
      return 0;
    }
    AppMethodBeat.o(27828);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.record.b.u
 * JD-Core Version:    0.7.0.1
 */