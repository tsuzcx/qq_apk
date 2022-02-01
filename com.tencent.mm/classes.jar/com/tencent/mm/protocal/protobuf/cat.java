package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cat
  extends com.tencent.mm.bx.a
{
  public String DXh;
  public String DXi;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123635);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.DXh != null) {
        paramVarArgs.d(1, this.DXh);
      }
      if (this.DXi != null) {
        paramVarArgs.d(2, this.DXi);
      }
      AppMethodBeat.o(123635);
      return 0;
    }
    if (paramInt == 1) {
      if (this.DXh == null) {
        break label274;
      }
    }
    label274:
    for (paramInt = f.a.a.b.b.a.e(1, this.DXh) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.DXi != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.DXi);
      }
      AppMethodBeat.o(123635);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(123635);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        cat localcat = (cat)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(123635);
          return -1;
        case 1: 
          localcat.DXh = locala.KhF.readString();
          AppMethodBeat.o(123635);
          return 0;
        }
        localcat.DXi = locala.KhF.readString();
        AppMethodBeat.o(123635);
        return 0;
      }
      AppMethodBeat.o(123635);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cat
 * JD-Core Version:    0.7.0.1
 */