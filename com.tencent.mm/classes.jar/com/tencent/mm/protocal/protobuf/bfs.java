package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;

public final class bfs
  extends com.tencent.mm.bw.a
{
  public String dqk;
  public String dwx;
  public String iKt;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152580);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.iKt == null)
      {
        paramVarArgs = new b("Not all required fields were included: tp_username");
        AppMethodBeat.o(152580);
        throw paramVarArgs;
      }
      if (this.iKt != null) {
        paramVarArgs.d(1, this.iKt);
      }
      if (this.dwx != null) {
        paramVarArgs.d(2, this.dwx);
      }
      if (this.dqk != null) {
        paramVarArgs.d(3, this.dqk);
      }
      AppMethodBeat.o(152580);
      return 0;
    }
    if (paramInt == 1) {
      if (this.iKt == null) {
        break label382;
      }
    }
    label382:
    for (int i = f.a.a.b.b.a.e(1, this.iKt) + 0;; i = 0)
    {
      paramInt = i;
      if (this.dwx != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.dwx);
      }
      i = paramInt;
      if (this.dqk != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.dqk);
      }
      AppMethodBeat.o(152580);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.iKt == null)
        {
          paramVarArgs = new b("Not all required fields were included: tp_username");
          AppMethodBeat.o(152580);
          throw paramVarArgs;
        }
        AppMethodBeat.o(152580);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        bfs localbfs = (bfs)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(152580);
          return -1;
        case 1: 
          localbfs.iKt = locala.OmT.readString();
          AppMethodBeat.o(152580);
          return 0;
        case 2: 
          localbfs.dwx = locala.OmT.readString();
          AppMethodBeat.o(152580);
          return 0;
        }
        localbfs.dqk = locala.OmT.readString();
        AppMethodBeat.o(152580);
        return 0;
      }
      AppMethodBeat.o(152580);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bfs
 * JD-Core Version:    0.7.0.1
 */