package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class nf
  extends com.tencent.mm.cd.a
{
  public int RTV;
  public int RTW;
  public int RTX;
  public String RTY;
  public String RTZ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124410);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.RTV);
      paramVarArgs.aY(2, this.RTW);
      paramVarArgs.aY(3, this.RTX);
      if (this.RTY != null) {
        paramVarArgs.f(4, this.RTY);
      }
      if (this.RTZ != null) {
        paramVarArgs.f(5, this.RTZ);
      }
      AppMethodBeat.o(124410);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bM(1, this.RTV) + 0 + g.a.a.b.b.a.bM(2, this.RTW) + g.a.a.b.b.a.bM(3, this.RTX);
      paramInt = i;
      if (this.RTY != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.RTY);
      }
      i = paramInt;
      if (this.RTZ != null) {
        i = paramInt + g.a.a.b.b.a.g(5, this.RTZ);
      }
      AppMethodBeat.o(124410);
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
      AppMethodBeat.o(124410);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      nf localnf = (nf)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(124410);
        return -1;
      case 1: 
        localnf.RTV = locala.abFh.AK();
        AppMethodBeat.o(124410);
        return 0;
      case 2: 
        localnf.RTW = locala.abFh.AK();
        AppMethodBeat.o(124410);
        return 0;
      case 3: 
        localnf.RTX = locala.abFh.AK();
        AppMethodBeat.o(124410);
        return 0;
      case 4: 
        localnf.RTY = locala.abFh.readString();
        AppMethodBeat.o(124410);
        return 0;
      }
      localnf.RTZ = locala.abFh.readString();
      AppMethodBeat.o(124410);
      return 0;
    }
    AppMethodBeat.o(124410);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.nf
 * JD-Core Version:    0.7.0.1
 */