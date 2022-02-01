package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ckr
  extends com.tencent.mm.bx.a
{
  public String Hef;
  public String Heg;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123635);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Hef != null) {
        paramVarArgs.d(1, this.Hef);
      }
      if (this.Heg != null) {
        paramVarArgs.d(2, this.Heg);
      }
      AppMethodBeat.o(123635);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Hef == null) {
        break label274;
      }
    }
    label274:
    for (paramInt = f.a.a.b.b.a.e(1, this.Hef) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Heg != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.Heg);
      }
      AppMethodBeat.o(123635);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(123635);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        ckr localckr = (ckr)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(123635);
          return -1;
        case 1: 
          localckr.Hef = locala.NPN.readString();
          AppMethodBeat.o(123635);
          return 0;
        }
        localckr.Heg = locala.NPN.readString();
        AppMethodBeat.o(123635);
        return 0;
      }
      AppMethodBeat.o(123635);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ckr
 * JD-Core Version:    0.7.0.1
 */