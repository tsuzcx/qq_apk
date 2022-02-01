package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bvm
  extends com.tencent.mm.bw.a
{
  public int GaV;
  public String Hio;
  public int Hip;
  public String content;
  public String fUv;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(215584);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Hio != null) {
        paramVarArgs.d(1, this.Hio);
      }
      if (this.fUv != null) {
        paramVarArgs.d(2, this.fUv);
      }
      paramVarArgs.aS(3, this.GaV);
      if (this.content != null) {
        paramVarArgs.d(4, this.content);
      }
      paramVarArgs.aS(5, this.Hip);
      AppMethodBeat.o(215584);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Hio == null) {
        break label422;
      }
    }
    label422:
    for (paramInt = f.a.a.b.b.a.e(1, this.Hio) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.fUv != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.fUv);
      }
      i += f.a.a.b.b.a.bz(3, this.GaV);
      paramInt = i;
      if (this.content != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.content);
      }
      i = f.a.a.b.b.a.bz(5, this.Hip);
      AppMethodBeat.o(215584);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(215584);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        bvm localbvm = (bvm)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(215584);
          return -1;
        case 1: 
          localbvm.Hio = locala.OmT.readString();
          AppMethodBeat.o(215584);
          return 0;
        case 2: 
          localbvm.fUv = locala.OmT.readString();
          AppMethodBeat.o(215584);
          return 0;
        case 3: 
          localbvm.GaV = locala.OmT.zc();
          AppMethodBeat.o(215584);
          return 0;
        case 4: 
          localbvm.content = locala.OmT.readString();
          AppMethodBeat.o(215584);
          return 0;
        }
        localbvm.Hip = locala.OmT.zc();
        AppMethodBeat.o(215584);
        return 0;
      }
      AppMethodBeat.o(215584);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bvm
 * JD-Core Version:    0.7.0.1
 */