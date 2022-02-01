package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class xb
  extends com.tencent.mm.bx.a
{
  public String CYV;
  public String teH;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32168);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.CYV != null) {
        paramVarArgs.d(1, this.CYV);
      }
      if (this.teH != null) {
        paramVarArgs.d(2, this.teH);
      }
      AppMethodBeat.o(32168);
      return 0;
    }
    if (paramInt == 1) {
      if (this.CYV == null) {
        break label282;
      }
    }
    label282:
    for (paramInt = f.a.a.b.b.a.e(1, this.CYV) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.teH != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.teH);
      }
      AppMethodBeat.o(32168);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(32168);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        xb localxb = (xb)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(32168);
          return -1;
        case 1: 
          localxb.CYV = locala.KhF.readString();
          AppMethodBeat.o(32168);
          return 0;
        }
        localxb.teH = locala.KhF.readString();
        AppMethodBeat.o(32168);
        return 0;
      }
      AppMethodBeat.o(32168);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.xb
 * JD-Core Version:    0.7.0.1
 */