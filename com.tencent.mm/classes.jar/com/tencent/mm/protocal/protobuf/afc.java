package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class afc
  extends com.tencent.mm.cd.a
{
  public String SrA;
  public String SrB;
  public int Srz;
  public boolean enable;
  public String ozt;
  public String title;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(201105);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.co(1, this.enable);
      paramVarArgs.aY(2, this.Srz);
      if (this.ozt != null) {
        paramVarArgs.f(3, this.ozt);
      }
      if (this.SrA != null) {
        paramVarArgs.f(4, this.SrA);
      }
      if (this.SrB != null) {
        paramVarArgs.f(5, this.SrB);
      }
      if (this.title != null) {
        paramVarArgs.f(6, this.title);
      }
      AppMethodBeat.o(201105);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.gL(1) + 1 + 0 + g.a.a.b.b.a.bM(2, this.Srz);
      paramInt = i;
      if (this.ozt != null) {
        paramInt = i + g.a.a.b.b.a.g(3, this.ozt);
      }
      i = paramInt;
      if (this.SrA != null) {
        i = paramInt + g.a.a.b.b.a.g(4, this.SrA);
      }
      paramInt = i;
      if (this.SrB != null) {
        paramInt = i + g.a.a.b.b.a.g(5, this.SrB);
      }
      i = paramInt;
      if (this.title != null) {
        i = paramInt + g.a.a.b.b.a.g(6, this.title);
      }
      AppMethodBeat.o(201105);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(201105);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      afc localafc = (afc)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(201105);
        return -1;
      case 1: 
        localafc.enable = locala.abFh.AB();
        AppMethodBeat.o(201105);
        return 0;
      case 2: 
        localafc.Srz = locala.abFh.AK();
        AppMethodBeat.o(201105);
        return 0;
      case 3: 
        localafc.ozt = locala.abFh.readString();
        AppMethodBeat.o(201105);
        return 0;
      case 4: 
        localafc.SrA = locala.abFh.readString();
        AppMethodBeat.o(201105);
        return 0;
      case 5: 
        localafc.SrB = locala.abFh.readString();
        AppMethodBeat.o(201105);
        return 0;
      }
      localafc.title = locala.abFh.readString();
      AppMethodBeat.o(201105);
      return 0;
    }
    AppMethodBeat.o(201105);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.afc
 * JD-Core Version:    0.7.0.1
 */