package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bgd
  extends com.tencent.mm.bx.a
{
  public String dvm;
  public String jOx = "";
  public String value;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(122514);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.value != null) {
        paramVarArgs.d(1, this.value);
      }
      if (this.dvm != null) {
        paramVarArgs.d(2, this.dvm);
      }
      if (this.jOx != null) {
        paramVarArgs.d(3, this.jOx);
      }
      AppMethodBeat.o(122514);
      return 0;
    }
    if (paramInt == 1) {
      if (this.value == null) {
        break label334;
      }
    }
    label334:
    for (int i = f.a.a.b.b.a.e(1, this.value) + 0;; i = 0)
    {
      paramInt = i;
      if (this.dvm != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.dvm);
      }
      i = paramInt;
      if (this.jOx != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.jOx);
      }
      AppMethodBeat.o(122514);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(122514);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        bgd localbgd = (bgd)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(122514);
          return -1;
        case 1: 
          localbgd.value = locala.KhF.readString();
          AppMethodBeat.o(122514);
          return 0;
        case 2: 
          localbgd.dvm = locala.KhF.readString();
          AppMethodBeat.o(122514);
          return 0;
        }
        localbgd.jOx = locala.KhF.readString();
        AppMethodBeat.o(122514);
        return 0;
      }
      AppMethodBeat.o(122514);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bgd
 * JD-Core Version:    0.7.0.1
 */