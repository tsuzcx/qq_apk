package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dva
  extends com.tencent.mm.bx.a
{
  public int EJh;
  public String doh;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153325);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.EJh);
      if (this.doh != null) {
        paramVarArgs.d(2, this.doh);
      }
      AppMethodBeat.o(153325);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bA(1, this.EJh) + 0;
      paramInt = i;
      if (this.doh != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.doh);
      }
      AppMethodBeat.o(153325);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      AppMethodBeat.o(153325);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      dva localdva = (dva)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(153325);
        return -1;
      case 1: 
        localdva.EJh = locala.KhF.xS();
        AppMethodBeat.o(153325);
        return 0;
      }
      localdva.doh = locala.KhF.readString();
      AppMethodBeat.o(153325);
      return 0;
    }
    AppMethodBeat.o(153325);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dva
 * JD-Core Version:    0.7.0.1
 */