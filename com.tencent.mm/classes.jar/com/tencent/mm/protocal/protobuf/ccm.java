package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ccm
  extends com.tencent.mm.cd.a
{
  public int CPw;
  public String RYJ;
  public String SessionId;
  public int Tkv;
  public String Tkx;
  public String Tky;
  public String lpy;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(211760);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.CPw);
      if (this.SessionId != null) {
        paramVarArgs.f(2, this.SessionId);
      }
      if (this.Tkx != null) {
        paramVarArgs.f(3, this.Tkx);
      }
      if (this.Tky != null) {
        paramVarArgs.f(4, this.Tky);
      }
      paramVarArgs.aY(5, this.Tkv);
      if (this.RYJ != null) {
        paramVarArgs.f(6, this.RYJ);
      }
      if (this.lpy != null) {
        paramVarArgs.f(7, this.lpy);
      }
      AppMethodBeat.o(211760);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bM(1, this.CPw) + 0;
      paramInt = i;
      if (this.SessionId != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.SessionId);
      }
      i = paramInt;
      if (this.Tkx != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.Tkx);
      }
      paramInt = i;
      if (this.Tky != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.Tky);
      }
      i = paramInt + g.a.a.b.b.a.bM(5, this.Tkv);
      paramInt = i;
      if (this.RYJ != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.RYJ);
      }
      i = paramInt;
      if (this.lpy != null) {
        i = paramInt + g.a.a.b.b.a.g(7, this.lpy);
      }
      AppMethodBeat.o(211760);
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
      AppMethodBeat.o(211760);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      ccm localccm = (ccm)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(211760);
        return -1;
      case 1: 
        localccm.CPw = locala.abFh.AK();
        AppMethodBeat.o(211760);
        return 0;
      case 2: 
        localccm.SessionId = locala.abFh.readString();
        AppMethodBeat.o(211760);
        return 0;
      case 3: 
        localccm.Tkx = locala.abFh.readString();
        AppMethodBeat.o(211760);
        return 0;
      case 4: 
        localccm.Tky = locala.abFh.readString();
        AppMethodBeat.o(211760);
        return 0;
      case 5: 
        localccm.Tkv = locala.abFh.AK();
        AppMethodBeat.o(211760);
        return 0;
      case 6: 
        localccm.RYJ = locala.abFh.readString();
        AppMethodBeat.o(211760);
        return 0;
      }
      localccm.lpy = locala.abFh.readString();
      AppMethodBeat.o(211760);
      return 0;
    }
    AppMethodBeat.o(211760);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ccm
 * JD-Core Version:    0.7.0.1
 */