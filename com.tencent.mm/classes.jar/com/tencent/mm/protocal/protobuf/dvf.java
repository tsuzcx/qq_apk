package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dvf
  extends com.tencent.mm.bx.a
{
  public boolean EJl;
  public boolean EJm;
  public int EJn;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(50120);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bg(1, this.EJl);
      paramVarArgs.bg(2, this.EJm);
      paramVarArgs.aR(3, this.EJn);
      AppMethodBeat.o(50120);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.fY(1);
      int i = f.a.a.b.b.a.fY(2);
      int j = f.a.a.b.b.a.bA(3, this.EJn);
      AppMethodBeat.o(50120);
      return paramInt + 1 + 0 + (i + 1) + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      AppMethodBeat.o(50120);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      dvf localdvf = (dvf)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(50120);
        return -1;
      case 1: 
        localdvf.EJl = locala.KhF.fHu();
        AppMethodBeat.o(50120);
        return 0;
      case 2: 
        localdvf.EJm = locala.KhF.fHu();
        AppMethodBeat.o(50120);
        return 0;
      }
      localdvf.EJn = locala.KhF.xS();
      AppMethodBeat.o(50120);
      return 0;
    }
    AppMethodBeat.o(50120);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dvf
 * JD-Core Version:    0.7.0.1
 */