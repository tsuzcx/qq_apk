package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ctb
  extends com.tencent.mm.bx.a
{
  public LinkedList<String> EkJ;
  public LinkedList<String> EkK;
  public LinkedList<Integer> EkL;
  public LinkedList<Integer> EkM;
  
  public ctb()
  {
    AppMethodBeat.i(114079);
    this.EkJ = new LinkedList();
    this.EkK = new LinkedList();
    this.EkL = new LinkedList();
    this.EkM = new LinkedList();
    AppMethodBeat.o(114079);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(114080);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 1, this.EkJ);
      paramVarArgs.e(2, 1, this.EkK);
      paramVarArgs.e(3, 2, this.EkL);
      paramVarArgs.e(4, 2, this.EkM);
      AppMethodBeat.o(114080);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.a.c(1, 1, this.EkJ);
      int i = f.a.a.a.c(2, 1, this.EkK);
      int j = f.a.a.a.c(3, 2, this.EkL);
      int k = f.a.a.a.c(4, 2, this.EkM);
      AppMethodBeat.o(114080);
      return paramInt + 0 + i + j + k;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.EkJ.clear();
      this.EkK.clear();
      this.EkL.clear();
      this.EkM.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      AppMethodBeat.o(114080);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      ctb localctb = (ctb)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(114080);
        return -1;
      case 1: 
        localctb.EkJ.add(locala.KhF.readString());
        AppMethodBeat.o(114080);
        return 0;
      case 2: 
        localctb.EkK.add(locala.KhF.readString());
        AppMethodBeat.o(114080);
        return 0;
      case 3: 
        localctb.EkL.add(Integer.valueOf(locala.KhF.xS()));
        AppMethodBeat.o(114080);
        return 0;
      }
      localctb.EkM.add(Integer.valueOf(locala.KhF.xS()));
      AppMethodBeat.o(114080);
      return 0;
    }
    AppMethodBeat.o(114080);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ctb
 * JD-Core Version:    0.7.0.1
 */