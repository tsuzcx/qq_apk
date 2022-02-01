package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cly
  extends com.tencent.mm.bw.a
{
  public boolean Mrm;
  public boolean Mrn;
  public int Mro;
  public String Mrp;
  public boolean Mrq;
  public boolean Mrr;
  public String Mrs;
  public String dNI;
  public int vUh;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(127172);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.cc(1, this.Mrm);
      paramVarArgs.cc(2, this.Mrn);
      paramVarArgs.aM(3, this.vUh);
      paramVarArgs.aM(4, this.Mro);
      if (this.Mrp != null) {
        paramVarArgs.e(5, this.Mrp);
      }
      paramVarArgs.cc(6, this.Mrq);
      if (this.dNI != null) {
        paramVarArgs.e(7, this.dNI);
      }
      paramVarArgs.cc(8, this.Mrr);
      if (this.Mrs != null) {
        paramVarArgs.e(9, this.Mrs);
      }
      AppMethodBeat.o(127172);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.fS(1) + 1 + 0 + (g.a.a.b.b.a.fS(2) + 1) + g.a.a.b.b.a.bu(3, this.vUh) + g.a.a.b.b.a.bu(4, this.Mro);
      paramInt = i;
      if (this.Mrp != null) {
        paramInt = i + g.a.a.b.b.a.f(5, this.Mrp);
      }
      i = paramInt + (g.a.a.b.b.a.fS(6) + 1);
      paramInt = i;
      if (this.dNI != null) {
        paramInt = i + g.a.a.b.b.a.f(7, this.dNI);
      }
      i = paramInt + (g.a.a.b.b.a.fS(8) + 1);
      paramInt = i;
      if (this.Mrs != null) {
        paramInt = i + g.a.a.b.b.a.f(9, this.Mrs);
      }
      AppMethodBeat.o(127172);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(127172);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      cly localcly = (cly)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(127172);
        return -1;
      case 1: 
        localcly.Mrm = locala.UbS.yZ();
        AppMethodBeat.o(127172);
        return 0;
      case 2: 
        localcly.Mrn = locala.UbS.yZ();
        AppMethodBeat.o(127172);
        return 0;
      case 3: 
        localcly.vUh = locala.UbS.zi();
        AppMethodBeat.o(127172);
        return 0;
      case 4: 
        localcly.Mro = locala.UbS.zi();
        AppMethodBeat.o(127172);
        return 0;
      case 5: 
        localcly.Mrp = locala.UbS.readString();
        AppMethodBeat.o(127172);
        return 0;
      case 6: 
        localcly.Mrq = locala.UbS.yZ();
        AppMethodBeat.o(127172);
        return 0;
      case 7: 
        localcly.dNI = locala.UbS.readString();
        AppMethodBeat.o(127172);
        return 0;
      case 8: 
        localcly.Mrr = locala.UbS.yZ();
        AppMethodBeat.o(127172);
        return 0;
      }
      localcly.Mrs = locala.UbS.readString();
      AppMethodBeat.o(127172);
      return 0;
    }
    AppMethodBeat.o(127172);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cly
 * JD-Core Version:    0.7.0.1
 */