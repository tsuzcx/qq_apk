package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class duz
  extends com.tencent.mm.bx.a
{
  public double EJf;
  public long EJg;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153324);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, this.EJf);
      paramVarArgs.aG(2, this.EJg);
      AppMethodBeat.o(153324);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.fY(1);
      int i = f.a.a.b.b.a.q(2, this.EJg);
      AppMethodBeat.o(153324);
      return paramInt + 8 + 0 + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      AppMethodBeat.o(153324);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      duz localduz = (duz)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(153324);
        return -1;
      case 1: 
        localduz.EJf = Double.longBitsToDouble(locala.KhF.fHy());
        AppMethodBeat.o(153324);
        return 0;
      }
      localduz.EJg = locala.KhF.xT();
      AppMethodBeat.o(153324);
      return 0;
    }
    AppMethodBeat.o(153324);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.duz
 * JD-Core Version:    0.7.0.1
 */