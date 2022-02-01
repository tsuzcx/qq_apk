package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ezh
  extends com.tencent.mm.bw.a
{
  public String MVg;
  public int NcY;
  public com.tencent.mm.bw.b NvI;
  public com.tencent.mm.bw.b NvJ;
  public String NvK;
  public String NvL;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32550);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.MVg == null)
      {
        paramVarArgs = new g.a.a.b("Not all required fields were included: Msg");
        AppMethodBeat.o(32550);
        throw paramVarArgs;
      }
      paramVarArgs.aM(1, this.NcY);
      if (this.MVg != null) {
        paramVarArgs.e(2, this.MVg);
      }
      if (this.NvI != null) {
        paramVarArgs.c(3, this.NvI);
      }
      if (this.NvJ != null) {
        paramVarArgs.c(4, this.NvJ);
      }
      if (this.NvK != null) {
        paramVarArgs.e(5, this.NvK);
      }
      if (this.NvL != null) {
        paramVarArgs.e(6, this.NvL);
      }
      AppMethodBeat.o(32550);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bu(1, this.NcY) + 0;
      paramInt = i;
      if (this.MVg != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.MVg);
      }
      i = paramInt;
      if (this.NvI != null) {
        i = paramInt + g.a.a.b.b.a.b(3, this.NvI);
      }
      paramInt = i;
      if (this.NvJ != null) {
        paramInt = i + g.a.a.b.b.a.b(4, this.NvJ);
      }
      i = paramInt;
      if (this.NvK != null) {
        i = paramInt + g.a.a.b.b.a.f(5, this.NvK);
      }
      paramInt = i;
      if (this.NvL != null) {
        paramInt = i + g.a.a.b.b.a.f(6, this.NvL);
      }
      AppMethodBeat.o(32550);
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
      if (this.MVg == null)
      {
        paramVarArgs = new g.a.a.b("Not all required fields were included: Msg");
        AppMethodBeat.o(32550);
        throw paramVarArgs;
      }
      AppMethodBeat.o(32550);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      ezh localezh = (ezh)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(32550);
        return -1;
      case 1: 
        localezh.NcY = locala.UbS.zi();
        AppMethodBeat.o(32550);
        return 0;
      case 2: 
        localezh.MVg = locala.UbS.readString();
        AppMethodBeat.o(32550);
        return 0;
      case 3: 
        localezh.NvI = locala.UbS.hPo();
        AppMethodBeat.o(32550);
        return 0;
      case 4: 
        localezh.NvJ = locala.UbS.hPo();
        AppMethodBeat.o(32550);
        return 0;
      case 5: 
        localezh.NvK = locala.UbS.readString();
        AppMethodBeat.o(32550);
        return 0;
      }
      localezh.NvL = locala.UbS.readString();
      AppMethodBeat.o(32550);
      return 0;
    }
    AppMethodBeat.o(32550);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ezh
 * JD-Core Version:    0.7.0.1
 */