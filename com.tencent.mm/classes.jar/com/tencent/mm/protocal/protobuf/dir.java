package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dir
  extends com.tencent.mm.bx.a
{
  public String Ezc;
  public String mAQ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32489);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.mAQ != null) {
        paramVarArgs.d(1, this.mAQ);
      }
      if (this.Ezc != null) {
        paramVarArgs.d(2, this.Ezc);
      }
      AppMethodBeat.o(32489);
      return 0;
    }
    if (paramInt == 1) {
      if (this.mAQ == null) {
        break label282;
      }
    }
    label282:
    for (paramInt = f.a.a.b.b.a.e(1, this.mAQ) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Ezc != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.Ezc);
      }
      AppMethodBeat.o(32489);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(32489);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        dir localdir = (dir)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(32489);
          return -1;
        case 1: 
          localdir.mAQ = locala.KhF.readString();
          AppMethodBeat.o(32489);
          return 0;
        }
        localdir.Ezc = locala.KhF.readString();
        AppMethodBeat.o(32489);
        return 0;
      }
      AppMethodBeat.o(32489);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dir
 * JD-Core Version:    0.7.0.1
 */