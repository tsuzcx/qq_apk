package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class alu
  extends com.tencent.mm.cd.a
{
  public int SvY;
  public String SvZ;
  public String Swa;
  public String Swb;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32199);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.SvY);
      if (this.SvZ != null) {
        paramVarArgs.f(2, this.SvZ);
      }
      if (this.Swa != null) {
        paramVarArgs.f(3, this.Swa);
      }
      if (this.Swb != null) {
        paramVarArgs.f(4, this.Swb);
      }
      AppMethodBeat.o(32199);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bM(1, this.SvY) + 0;
      paramInt = i;
      if (this.SvZ != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.SvZ);
      }
      i = paramInt;
      if (this.Swa != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.Swa);
      }
      paramInt = i;
      if (this.Swb != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.Swb);
      }
      AppMethodBeat.o(32199);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(32199);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      alu localalu = (alu)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(32199);
        return -1;
      case 1: 
        localalu.SvY = locala.abFh.AK();
        AppMethodBeat.o(32199);
        return 0;
      case 2: 
        localalu.SvZ = locala.abFh.readString();
        AppMethodBeat.o(32199);
        return 0;
      case 3: 
        localalu.Swa = locala.abFh.readString();
        AppMethodBeat.o(32199);
        return 0;
      }
      localalu.Swb = locala.abFh.readString();
      AppMethodBeat.o(32199);
      return 0;
    }
    AppMethodBeat.o(32199);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.alu
 * JD-Core Version:    0.7.0.1
 */