package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dsi
  extends com.tencent.mm.bx.a
{
  public String EGT;
  public String dnB;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117945);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.EGT != null) {
        paramVarArgs.d(1, this.EGT);
      }
      if (this.dnB != null) {
        paramVarArgs.d(2, this.dnB);
      }
      AppMethodBeat.o(117945);
      return 0;
    }
    if (paramInt == 1) {
      if (this.EGT == null) {
        break label274;
      }
    }
    label274:
    for (paramInt = f.a.a.b.b.a.e(1, this.EGT) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.dnB != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.dnB);
      }
      AppMethodBeat.o(117945);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(117945);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        dsi localdsi = (dsi)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(117945);
          return -1;
        case 1: 
          localdsi.EGT = locala.KhF.readString();
          AppMethodBeat.o(117945);
          return 0;
        }
        localdsi.dnB = locala.KhF.readString();
        AppMethodBeat.o(117945);
        return 0;
      }
      AppMethodBeat.o(117945);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dsi
 * JD-Core Version:    0.7.0.1
 */