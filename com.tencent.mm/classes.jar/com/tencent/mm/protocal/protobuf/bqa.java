package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bqa
  extends com.tencent.mm.bx.a
{
  public int DOi;
  public String wcY;
  public int wcZ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(147773);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.wcY != null) {
        paramVarArgs.d(1, this.wcY);
      }
      paramVarArgs.aR(2, this.wcZ);
      paramVarArgs.aR(3, this.DOi);
      AppMethodBeat.o(147773);
      return 0;
    }
    if (paramInt == 1) {
      if (this.wcY == null) {
        break label306;
      }
    }
    label306:
    for (paramInt = f.a.a.b.b.a.e(1, this.wcY) + 0;; paramInt = 0)
    {
      int i = f.a.a.b.b.a.bA(2, this.wcZ);
      int j = f.a.a.b.b.a.bA(3, this.DOi);
      AppMethodBeat.o(147773);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(147773);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        bqa localbqa = (bqa)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(147773);
          return -1;
        case 1: 
          localbqa.wcY = locala.KhF.readString();
          AppMethodBeat.o(147773);
          return 0;
        case 2: 
          localbqa.wcZ = locala.KhF.xS();
          AppMethodBeat.o(147773);
          return 0;
        }
        localbqa.DOi = locala.KhF.xS();
        AppMethodBeat.o(147773);
        return 0;
      }
      AppMethodBeat.o(147773);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bqa
 * JD-Core Version:    0.7.0.1
 */