package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bze
  extends com.tencent.mm.bx.a
{
  public boolean CwI;
  public String CwJ;
  public LinkedList<Integer> GUg;
  
  public bze()
  {
    AppMethodBeat.i(91541);
    this.GUg = new LinkedList();
    AppMethodBeat.o(91541);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91542);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bt(1, this.CwI);
      if (this.CwJ != null) {
        paramVarArgs.d(2, this.CwJ);
      }
      paramVarArgs.e(3, 2, this.GUg);
      AppMethodBeat.o(91542);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.alV(1) + 0;
      paramInt = i;
      if (this.CwJ != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.CwJ);
      }
      i = f.a.a.a.c(3, 2, this.GUg);
      AppMethodBeat.o(91542);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.GUg.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(91542);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      bze localbze = (bze)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(91542);
        return -1;
      case 1: 
        localbze.CwI = locala.NPN.grw();
        AppMethodBeat.o(91542);
        return 0;
      case 2: 
        localbze.CwJ = locala.NPN.readString();
        AppMethodBeat.o(91542);
        return 0;
      }
      localbze.GUg.add(Integer.valueOf(locala.NPN.zc()));
      AppMethodBeat.o(91542);
      return 0;
    }
    AppMethodBeat.o(91542);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bze
 * JD-Core Version:    0.7.0.1
 */