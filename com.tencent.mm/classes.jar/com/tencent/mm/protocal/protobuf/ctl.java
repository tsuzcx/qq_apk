package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ctl
  extends com.tencent.mm.bx.a
{
  public String Ele;
  public String Elf;
  public String Elg;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32455);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Ele != null) {
        paramVarArgs.d(1, this.Ele);
      }
      if (this.Elf != null) {
        paramVarArgs.d(2, this.Elf);
      }
      if (this.Elg != null) {
        paramVarArgs.d(3, this.Elg);
      }
      AppMethodBeat.o(32455);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Ele == null) {
        break label343;
      }
    }
    label343:
    for (int i = f.a.a.b.b.a.e(1, this.Ele) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Elf != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.Elf);
      }
      i = paramInt;
      if (this.Elg != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.Elg);
      }
      AppMethodBeat.o(32455);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(32455);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        ctl localctl = (ctl)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(32455);
          return -1;
        case 1: 
          localctl.Ele = locala.KhF.readString();
          AppMethodBeat.o(32455);
          return 0;
        case 2: 
          localctl.Elf = locala.KhF.readString();
          AppMethodBeat.o(32455);
          return 0;
        }
        localctl.Elg = locala.KhF.readString();
        AppMethodBeat.o(32455);
        return 0;
      }
      AppMethodBeat.o(32455);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ctl
 * JD-Core Version:    0.7.0.1
 */