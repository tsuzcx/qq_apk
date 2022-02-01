package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bmy
  extends com.tencent.mm.bx.a
{
  public String DKs;
  public String url;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(177341);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.url != null) {
        paramVarArgs.d(1, this.url);
      }
      if (this.DKs != null) {
        paramVarArgs.d(2, this.DKs);
      }
      AppMethodBeat.o(177341);
      return 0;
    }
    if (paramInt == 1) {
      if (this.url == null) {
        break label274;
      }
    }
    label274:
    for (paramInt = f.a.a.b.b.a.e(1, this.url) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.DKs != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.DKs);
      }
      AppMethodBeat.o(177341);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(177341);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        bmy localbmy = (bmy)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(177341);
          return -1;
        case 1: 
          localbmy.url = locala.KhF.readString();
          AppMethodBeat.o(177341);
          return 0;
        }
        localbmy.DKs = locala.KhF.readString();
        AppMethodBeat.o(177341);
        return 0;
      }
      AppMethodBeat.o(177341);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bmy
 * JD-Core Version:    0.7.0.1
 */