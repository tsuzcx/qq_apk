package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bhx
  extends com.tencent.mm.bw.a
{
  public String CellTitle;
  public String EXj;
  public String EXk;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152609);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.CellTitle != null) {
        paramVarArgs.d(1, this.CellTitle);
      }
      if (this.EXj != null) {
        paramVarArgs.d(2, this.EXj);
      }
      if (this.EXk != null) {
        paramVarArgs.d(3, this.EXk);
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
      if (this.EXj != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.EXj);
      }
      i = paramInt;
      if (this.EXk != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.EXk);
      }
      AppMethodBeat.o(152609);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(152609);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        bhx localbhx = (bhx)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(152609);
          return -1;
        case 1: 
          localbhx.CellTitle = locala.LVo.readString();
          AppMethodBeat.o(152609);
          return 0;
        case 2: 
          localbhx.EXj = locala.LVo.readString();
          AppMethodBeat.o(152609);
          return 0;
        }
        localbhx.EXk = locala.LVo.readString();
        AppMethodBeat.o(152609);
        return 0;
      }
      AppMethodBeat.o(152609);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bhx
 * JD-Core Version:    0.7.0.1
 */