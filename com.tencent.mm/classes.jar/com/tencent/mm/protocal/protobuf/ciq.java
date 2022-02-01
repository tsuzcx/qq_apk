package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ciq
  extends com.tencent.mm.cd.a
{
  public int Tpw;
  public com.tencent.mm.cd.b Tpx;
  public com.tencent.mm.cd.b Tpy;
  public com.tencent.mm.cd.b Tpz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(115844);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Tpx == null)
      {
        paramVarArgs = new g.a.a.b("Not all required fields were included: SPSBuf");
        AppMethodBeat.o(115844);
        throw paramVarArgs;
      }
      if (this.Tpy == null)
      {
        paramVarArgs = new g.a.a.b("Not all required fields were included: PPSBuf");
        AppMethodBeat.o(115844);
        throw paramVarArgs;
      }
      paramVarArgs.aY(1, this.Tpw);
      if (this.Tpx != null) {
        paramVarArgs.c(2, this.Tpx);
      }
      if (this.Tpy != null) {
        paramVarArgs.c(3, this.Tpy);
      }
      if (this.Tpz != null) {
        paramVarArgs.c(4, this.Tpz);
      }
      AppMethodBeat.o(115844);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bM(1, this.Tpw) + 0;
      paramInt = i;
      if (this.Tpx != null) {
        paramInt = i + g.a.a.b.b.a.b(2, this.Tpx);
      }
      i = paramInt;
      if (this.Tpy != null) {
        i = paramInt + g.a.a.b.b.a.b(3, this.Tpy);
      }
      paramInt = i;
      if (this.Tpz != null) {
        paramInt = i + g.a.a.b.b.a.b(4, this.Tpz);
      }
      AppMethodBeat.o(115844);
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
      if (this.Tpx == null)
      {
        paramVarArgs = new g.a.a.b("Not all required fields were included: SPSBuf");
        AppMethodBeat.o(115844);
        throw paramVarArgs;
      }
      if (this.Tpy == null)
      {
        paramVarArgs = new g.a.a.b("Not all required fields were included: PPSBuf");
        AppMethodBeat.o(115844);
        throw paramVarArgs;
      }
      AppMethodBeat.o(115844);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      ciq localciq = (ciq)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(115844);
        return -1;
      case 1: 
        localciq.Tpw = locala.abFh.AK();
        AppMethodBeat.o(115844);
        return 0;
      case 2: 
        localciq.Tpx = locala.abFh.iUw();
        AppMethodBeat.o(115844);
        return 0;
      case 3: 
        localciq.Tpy = locala.abFh.iUw();
        AppMethodBeat.o(115844);
        return 0;
      }
      localciq.Tpz = locala.abFh.iUw();
      AppMethodBeat.o(115844);
      return 0;
    }
    AppMethodBeat.o(115844);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ciq
 * JD-Core Version:    0.7.0.1
 */