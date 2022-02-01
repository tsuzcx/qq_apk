package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dvg
  extends com.tencent.mm.bx.a
{
  public boolean EJo;
  public int EJp;
  public double EJq;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(50121);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bg(1, this.EJo);
      paramVarArgs.aR(2, this.EJp);
      paramVarArgs.e(3, this.EJq);
      AppMethodBeat.o(50121);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.fY(1);
      int i = f.a.a.b.b.a.bA(2, this.EJp);
      int j = f.a.a.b.b.a.fY(3);
      AppMethodBeat.o(50121);
      return paramInt + 1 + 0 + i + (j + 8);
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      AppMethodBeat.o(50121);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      dvg localdvg = (dvg)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(50121);
        return -1;
      case 1: 
        localdvg.EJo = locala.KhF.fHu();
        AppMethodBeat.o(50121);
        return 0;
      case 2: 
        localdvg.EJp = locala.KhF.xS();
        AppMethodBeat.o(50121);
        return 0;
      }
      localdvg.EJq = Double.longBitsToDouble(locala.KhF.fHy());
      AppMethodBeat.o(50121);
      return 0;
    }
    AppMethodBeat.o(50121);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dvg
 * JD-Core Version:    0.7.0.1
 */