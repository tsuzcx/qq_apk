package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dvi
  extends com.tencent.mm.bx.a
{
  public int EJr;
  public int EJs;
  public int EJt;
  public int EJu;
  public int EJv;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(50122);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.EJr);
      paramVarArgs.aR(2, this.EJs);
      paramVarArgs.aR(3, this.EJt);
      paramVarArgs.aR(4, this.EJu);
      paramVarArgs.aR(5, this.EJv);
      AppMethodBeat.o(50122);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.bA(1, this.EJr);
      int i = f.a.a.b.b.a.bA(2, this.EJs);
      int j = f.a.a.b.b.a.bA(3, this.EJt);
      int k = f.a.a.b.b.a.bA(4, this.EJu);
      int m = f.a.a.b.b.a.bA(5, this.EJv);
      AppMethodBeat.o(50122);
      return paramInt + 0 + i + j + k + m;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      AppMethodBeat.o(50122);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      dvi localdvi = (dvi)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(50122);
        return -1;
      case 1: 
        localdvi.EJr = locala.KhF.xS();
        AppMethodBeat.o(50122);
        return 0;
      case 2: 
        localdvi.EJs = locala.KhF.xS();
        AppMethodBeat.o(50122);
        return 0;
      case 3: 
        localdvi.EJt = locala.KhF.xS();
        AppMethodBeat.o(50122);
        return 0;
      case 4: 
        localdvi.EJu = locala.KhF.xS();
        AppMethodBeat.o(50122);
        return 0;
      }
      localdvi.EJv = locala.KhF.xS();
      AppMethodBeat.o(50122);
      return 0;
    }
    AppMethodBeat.o(50122);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dvi
 * JD-Core Version:    0.7.0.1
 */