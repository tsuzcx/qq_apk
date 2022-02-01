package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bqf
  extends com.tencent.mm.bw.a
{
  public int EcB;
  public String Ffi;
  public int Ffj;
  public String content;
  public String fzc;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(190889);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Ffi != null) {
        paramVarArgs.d(1, this.Ffi);
      }
      if (this.fzc != null) {
        paramVarArgs.d(2, this.fzc);
      }
      paramVarArgs.aR(3, this.EcB);
      if (this.content != null) {
        paramVarArgs.d(4, this.content);
      }
      paramVarArgs.aR(5, this.Ffj);
      AppMethodBeat.o(190889);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Ffi == null) {
        break label422;
      }
    }
    label422:
    for (paramInt = f.a.a.b.b.a.e(1, this.Ffi) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.fzc != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.fzc);
      }
      i += f.a.a.b.b.a.bx(3, this.EcB);
      paramInt = i;
      if (this.content != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.content);
      }
      i = f.a.a.b.b.a.bx(5, this.Ffj);
      AppMethodBeat.o(190889);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(190889);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        bqf localbqf = (bqf)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(190889);
          return -1;
        case 1: 
          localbqf.Ffi = locala.LVo.readString();
          AppMethodBeat.o(190889);
          return 0;
        case 2: 
          localbqf.fzc = locala.LVo.readString();
          AppMethodBeat.o(190889);
          return 0;
        case 3: 
          localbqf.EcB = locala.LVo.xF();
          AppMethodBeat.o(190889);
          return 0;
        case 4: 
          localbqf.content = locala.LVo.readString();
          AppMethodBeat.o(190889);
          return 0;
        }
        localbqf.Ffj = locala.LVo.xF();
        AppMethodBeat.o(190889);
        return 0;
      }
      AppMethodBeat.o(190889);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bqf
 * JD-Core Version:    0.7.0.1
 */