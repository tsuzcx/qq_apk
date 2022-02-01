package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class euh
  extends com.tencent.mm.bw.a
{
  public int GWw;
  public int GWx;
  public String dQC;
  public int oXT;
  public String userName;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(115904);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.oXT);
      paramVarArgs.aM(2, this.GWx);
      paramVarArgs.aM(3, this.GWw);
      if (this.userName != null) {
        paramVarArgs.e(4, this.userName);
      }
      if (this.dQC != null) {
        paramVarArgs.e(5, this.dQC);
      }
      AppMethodBeat.o(115904);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bu(1, this.oXT) + 0 + g.a.a.b.b.a.bu(2, this.GWx) + g.a.a.b.b.a.bu(3, this.GWw);
      paramInt = i;
      if (this.userName != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.userName);
      }
      i = paramInt;
      if (this.dQC != null) {
        i = paramInt + g.a.a.b.b.a.f(5, this.dQC);
      }
      AppMethodBeat.o(115904);
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
      AppMethodBeat.o(115904);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      euh localeuh = (euh)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(115904);
        return -1;
      case 1: 
        localeuh.oXT = locala.UbS.zi();
        AppMethodBeat.o(115904);
        return 0;
      case 2: 
        localeuh.GWx = locala.UbS.zi();
        AppMethodBeat.o(115904);
        return 0;
      case 3: 
        localeuh.GWw = locala.UbS.zi();
        AppMethodBeat.o(115904);
        return 0;
      case 4: 
        localeuh.userName = locala.UbS.readString();
        AppMethodBeat.o(115904);
        return 0;
      }
      localeuh.dQC = locala.UbS.readString();
      AppMethodBeat.o(115904);
      return 0;
    }
    AppMethodBeat.o(115904);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.euh
 * JD-Core Version:    0.7.0.1
 */