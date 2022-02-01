package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bmx
  extends com.tencent.mm.bw.a
{
  public String CellTitle;
  public String Hah;
  public String Hai;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152609);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.CellTitle != null) {
        paramVarArgs.d(1, this.CellTitle);
      }
      if (this.Hah != null) {
        paramVarArgs.d(2, this.Hah);
      }
      if (this.Hai != null) {
        paramVarArgs.d(3, this.Hai);
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
      if (this.Hah != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.Hah);
      }
      i = paramInt;
      if (this.Hai != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.Hai);
      }
      AppMethodBeat.o(152609);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(152609);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        bmx localbmx = (bmx)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(152609);
          return -1;
        case 1: 
          localbmx.CellTitle = locala.OmT.readString();
          AppMethodBeat.o(152609);
          return 0;
        case 2: 
          localbmx.Hah = locala.OmT.readString();
          AppMethodBeat.o(152609);
          return 0;
        }
        localbmx.Hai = locala.OmT.readString();
        AppMethodBeat.o(152609);
        return 0;
      }
      AppMethodBeat.o(152609);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bmx
 * JD-Core Version:    0.7.0.1
 */