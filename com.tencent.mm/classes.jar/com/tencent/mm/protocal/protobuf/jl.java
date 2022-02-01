package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class jl
  extends com.tencent.mm.bx.a
{
  public int FAu;
  public int FCk;
  public LinkedList<String> FCl;
  public int ReqType;
  
  public jl()
  {
    AppMethodBeat.i(104755);
    this.FCl = new LinkedList();
    AppMethodBeat.o(104755);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(104756);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.FCk);
      paramVarArgs.aS(2, this.ReqType);
      paramVarArgs.e(3, 1, this.FCl);
      paramVarArgs.aS(4, this.FAu);
      AppMethodBeat.o(104756);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.bz(1, this.FCk);
      int i = f.a.a.b.b.a.bz(2, this.ReqType);
      int j = f.a.a.a.c(3, 1, this.FCl);
      int k = f.a.a.b.b.a.bz(4, this.FAu);
      AppMethodBeat.o(104756);
      return paramInt + 0 + i + j + k;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.FCl.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(104756);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      jl localjl = (jl)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(104756);
        return -1;
      case 1: 
        localjl.FCk = locala.NPN.zc();
        AppMethodBeat.o(104756);
        return 0;
      case 2: 
        localjl.ReqType = locala.NPN.zc();
        AppMethodBeat.o(104756);
        return 0;
      case 3: 
        localjl.FCl.add(locala.NPN.readString());
        AppMethodBeat.o(104756);
        return 0;
      }
      localjl.FAu = locala.NPN.zc();
      AppMethodBeat.o(104756);
      return 0;
    }
    AppMethodBeat.o(104756);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.jl
 * JD-Core Version:    0.7.0.1
 */