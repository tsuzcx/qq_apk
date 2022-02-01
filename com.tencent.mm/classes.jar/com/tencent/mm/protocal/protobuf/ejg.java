package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ejg
  extends com.tencent.mm.bw.a
{
  public double KUt;
  public double KUu;
  public String MCE;
  public String Name;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(56262);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, this.KUu);
      paramVarArgs.e(2, this.KUt);
      if (this.Name != null) {
        paramVarArgs.e(3, this.Name);
      }
      if (this.MCE != null) {
        paramVarArgs.e(4, this.MCE);
      }
      AppMethodBeat.o(56262);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.fS(1) + 8 + 0 + (g.a.a.b.b.a.fS(2) + 8);
      paramInt = i;
      if (this.Name != null) {
        paramInt = i + g.a.a.b.b.a.f(3, this.Name);
      }
      i = paramInt;
      if (this.MCE != null) {
        i = paramInt + g.a.a.b.b.a.f(4, this.MCE);
      }
      AppMethodBeat.o(56262);
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
      AppMethodBeat.o(56262);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      ejg localejg = (ejg)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(56262);
        return -1;
      case 1: 
        localejg.KUu = Double.longBitsToDouble(locala.UbS.zn());
        AppMethodBeat.o(56262);
        return 0;
      case 2: 
        localejg.KUt = Double.longBitsToDouble(locala.UbS.zn());
        AppMethodBeat.o(56262);
        return 0;
      case 3: 
        localejg.Name = locala.UbS.readString();
        AppMethodBeat.o(56262);
        return 0;
      }
      localejg.MCE = locala.UbS.readString();
      AppMethodBeat.o(56262);
      return 0;
    }
    AppMethodBeat.o(56262);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ejg
 * JD-Core Version:    0.7.0.1
 */