package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class hl
  extends com.tencent.mm.bx.a
{
  public String data;
  public int dhR;
  public String username;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153261);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.username != null) {
        paramVarArgs.d(1, this.username);
      }
      if (this.data != null) {
        paramVarArgs.d(2, this.data);
      }
      paramVarArgs.aR(3, this.dhR);
      AppMethodBeat.o(153261);
      return 0;
    }
    if (paramInt == 1) {
      if (this.username == null) {
        break label318;
      }
    }
    label318:
    for (paramInt = f.a.a.b.b.a.e(1, this.username) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.data != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.data);
      }
      paramInt = f.a.a.b.b.a.bA(3, this.dhR);
      AppMethodBeat.o(153261);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(153261);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        hl localhl = (hl)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(153261);
          return -1;
        case 1: 
          localhl.username = locala.KhF.readString();
          AppMethodBeat.o(153261);
          return 0;
        case 2: 
          localhl.data = locala.KhF.readString();
          AppMethodBeat.o(153261);
          return 0;
        }
        localhl.dhR = locala.KhF.xS();
        AppMethodBeat.o(153261);
        return 0;
      }
      AppMethodBeat.o(153261);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.hl
 * JD-Core Version:    0.7.0.1
 */