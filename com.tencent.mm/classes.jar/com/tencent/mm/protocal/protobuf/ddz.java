package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ddz
  extends com.tencent.mm.bx.a
{
  public LinkedList<String> Hsp;
  public LinkedList<String> Hsq;
  public LinkedList<Integer> Hsr;
  public LinkedList<Integer> Hss;
  
  public ddz()
  {
    AppMethodBeat.i(114079);
    this.Hsp = new LinkedList();
    this.Hsq = new LinkedList();
    this.Hsr = new LinkedList();
    this.Hss = new LinkedList();
    AppMethodBeat.o(114079);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(114080);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 1, this.Hsp);
      paramVarArgs.e(2, 1, this.Hsq);
      paramVarArgs.e(3, 2, this.Hsr);
      paramVarArgs.e(4, 2, this.Hss);
      AppMethodBeat.o(114080);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.a.c(1, 1, this.Hsp);
      int i = f.a.a.a.c(2, 1, this.Hsq);
      int j = f.a.a.a.c(3, 2, this.Hsr);
      int k = f.a.a.a.c(4, 2, this.Hss);
      AppMethodBeat.o(114080);
      return paramInt + 0 + i + j + k;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.Hsp.clear();
      this.Hsq.clear();
      this.Hsr.clear();
      this.Hss.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(114080);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      ddz localddz = (ddz)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(114080);
        return -1;
      case 1: 
        localddz.Hsp.add(locala.NPN.readString());
        AppMethodBeat.o(114080);
        return 0;
      case 2: 
        localddz.Hsq.add(locala.NPN.readString());
        AppMethodBeat.o(114080);
        return 0;
      case 3: 
        localddz.Hsr.add(Integer.valueOf(locala.NPN.zc()));
        AppMethodBeat.o(114080);
        return 0;
      }
      localddz.Hss.add(Integer.valueOf(locala.NPN.zc()));
      AppMethodBeat.o(114080);
      return 0;
    }
    AppMethodBeat.o(114080);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ddz
 * JD-Core Version:    0.7.0.1
 */