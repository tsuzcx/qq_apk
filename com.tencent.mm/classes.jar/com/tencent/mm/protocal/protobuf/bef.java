package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bef
  extends com.tencent.mm.bx.a
{
  public String CellTitle;
  public String DBN;
  public String DBO;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152609);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.CellTitle != null) {
        paramVarArgs.d(1, this.CellTitle);
      }
      if (this.DBN != null) {
        paramVarArgs.d(2, this.DBN);
      }
      if (this.DBO != null) {
        paramVarArgs.d(3, this.DBO);
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
      if (this.DBN != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.DBN);
      }
      i = paramInt;
      if (this.DBO != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.DBO);
      }
      AppMethodBeat.o(152609);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(152609);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        bef localbef = (bef)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(152609);
          return -1;
        case 1: 
          localbef.CellTitle = locala.KhF.readString();
          AppMethodBeat.o(152609);
          return 0;
        case 2: 
          localbef.DBN = locala.KhF.readString();
          AppMethodBeat.o(152609);
          return 0;
        }
        localbef.DBO = locala.KhF.readString();
        AppMethodBeat.o(152609);
        return 0;
      }
      AppMethodBeat.o(152609);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bef
 * JD-Core Version:    0.7.0.1
 */