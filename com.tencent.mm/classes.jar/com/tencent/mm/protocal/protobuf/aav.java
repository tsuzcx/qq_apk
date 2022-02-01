package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class aav
  extends com.tencent.mm.bx.a
{
  public int Gaq;
  public int Gar;
  public String Gas;
  public String dmK;
  public String dmL;
  public int version;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32169);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.version);
      paramVarArgs.aS(2, this.Gaq);
      paramVarArgs.aS(3, this.Gar);
      if (this.dmL != null) {
        paramVarArgs.d(4, this.dmL);
      }
      if (this.Gas != null) {
        paramVarArgs.d(5, this.Gas);
      }
      if (this.dmK != null) {
        paramVarArgs.d(6, this.dmK);
      }
      AppMethodBeat.o(32169);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bz(1, this.version) + 0 + f.a.a.b.b.a.bz(2, this.Gaq) + f.a.a.b.b.a.bz(3, this.Gar);
      paramInt = i;
      if (this.dmL != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.dmL);
      }
      i = paramInt;
      if (this.Gas != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.Gas);
      }
      paramInt = i;
      if (this.dmK != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.dmK);
      }
      AppMethodBeat.o(32169);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(32169);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      aav localaav = (aav)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(32169);
        return -1;
      case 1: 
        localaav.version = locala.NPN.zc();
        AppMethodBeat.o(32169);
        return 0;
      case 2: 
        localaav.Gaq = locala.NPN.zc();
        AppMethodBeat.o(32169);
        return 0;
      case 3: 
        localaav.Gar = locala.NPN.zc();
        AppMethodBeat.o(32169);
        return 0;
      case 4: 
        localaav.dmL = locala.NPN.readString();
        AppMethodBeat.o(32169);
        return 0;
      case 5: 
        localaav.Gas = locala.NPN.readString();
        AppMethodBeat.o(32169);
        return 0;
      }
      localaav.dmK = locala.NPN.readString();
      AppMethodBeat.o(32169);
      return 0;
    }
    AppMethodBeat.o(32169);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aav
 * JD-Core Version:    0.7.0.1
 */