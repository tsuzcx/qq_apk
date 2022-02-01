package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bmf
  extends com.tencent.mm.bx.a
{
  public String CellTitle;
  public String GGF;
  public String GGG;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152609);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.CellTitle != null) {
        paramVarArgs.d(1, this.CellTitle);
      }
      if (this.GGF != null) {
        paramVarArgs.d(2, this.GGF);
      }
      if (this.GGG != null) {
        paramVarArgs.d(3, this.GGG);
      }
      AppMethodBeat.o(152609);
      return 0;
    }
    if (paramInt == 1) {
      if (this.CellTitle == null) {
        break label334;
      }
    }
    label334:
    for (int i = f.a.a.b.b.a.e(1, this.CellTitle) + 0;; i = 0)
    {
      paramInt = i;
      if (this.GGF != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.GGF);
      }
      i = paramInt;
      if (this.GGG != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.GGG);
      }
      AppMethodBeat.o(152609);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(152609);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        bmf localbmf = (bmf)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(152609);
          return -1;
        case 1: 
          localbmf.CellTitle = locala.NPN.readString();
          AppMethodBeat.o(152609);
          return 0;
        case 2: 
          localbmf.GGF = locala.NPN.readString();
          AppMethodBeat.o(152609);
          return 0;
        }
        localbmf.GGG = locala.NPN.readString();
        AppMethodBeat.o(152609);
        return 0;
      }
      AppMethodBeat.o(152609);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bmf
 * JD-Core Version:    0.7.0.1
 */