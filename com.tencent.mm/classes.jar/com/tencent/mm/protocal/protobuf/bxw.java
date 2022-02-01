package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bxw
  extends com.tencent.mm.bx.a
{
  public String action;
  public String className;
  public String dvm;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(122524);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.className != null) {
        paramVarArgs.d(1, this.className);
      }
      if (this.dvm != null) {
        paramVarArgs.d(2, this.dvm);
      }
      if (this.action != null) {
        paramVarArgs.d(3, this.action);
      }
      AppMethodBeat.o(122524);
      return 0;
    }
    if (paramInt == 1) {
      if (this.className == null) {
        break label334;
      }
    }
    label334:
    for (int i = f.a.a.b.b.a.e(1, this.className) + 0;; i = 0)
    {
      paramInt = i;
      if (this.dvm != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.dvm);
      }
      i = paramInt;
      if (this.action != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.action);
      }
      AppMethodBeat.o(122524);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(122524);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        bxw localbxw = (bxw)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(122524);
          return -1;
        case 1: 
          localbxw.className = locala.KhF.readString();
          AppMethodBeat.o(122524);
          return 0;
        case 2: 
          localbxw.dvm = locala.KhF.readString();
          AppMethodBeat.o(122524);
          return 0;
        }
        localbxw.action = locala.KhF.readString();
        AppMethodBeat.o(122524);
        return 0;
      }
      AppMethodBeat.o(122524);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bxw
 * JD-Core Version:    0.7.0.1
 */