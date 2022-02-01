package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bzm
  extends com.tencent.mm.bx.a
{
  public String DWp;
  public String DWq;
  public String title;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91595);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.title != null) {
        paramVarArgs.d(1, this.title);
      }
      if (this.DWp != null) {
        paramVarArgs.d(2, this.DWp);
      }
      if (this.DWq != null) {
        paramVarArgs.d(3, this.DWq);
      }
      AppMethodBeat.o(91595);
      return 0;
    }
    if (paramInt == 1) {
      if (this.title == null) {
        break label334;
      }
    }
    label334:
    for (int i = f.a.a.b.b.a.e(1, this.title) + 0;; i = 0)
    {
      paramInt = i;
      if (this.DWp != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.DWp);
      }
      i = paramInt;
      if (this.DWq != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.DWq);
      }
      AppMethodBeat.o(91595);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(91595);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        bzm localbzm = (bzm)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(91595);
          return -1;
        case 1: 
          localbzm.title = locala.KhF.readString();
          AppMethodBeat.o(91595);
          return 0;
        case 2: 
          localbzm.DWp = locala.KhF.readString();
          AppMethodBeat.o(91595);
          return 0;
        }
        localbzm.DWq = locala.KhF.readString();
        AppMethodBeat.o(91595);
        return 0;
      }
      AppMethodBeat.o(91595);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bzm
 * JD-Core Version:    0.7.0.1
 */