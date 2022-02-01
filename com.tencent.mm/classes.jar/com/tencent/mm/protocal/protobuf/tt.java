package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class tt
  extends com.tencent.mm.bx.a
{
  public String FSl;
  public String code;
  public String duW;
  public String oxM;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(113977);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.oxM != null) {
        paramVarArgs.d(1, this.oxM);
      }
      if (this.code != null) {
        paramVarArgs.d(2, this.code);
      }
      if (this.FSl != null) {
        paramVarArgs.d(3, this.FSl);
      }
      if (this.duW != null) {
        paramVarArgs.d(4, this.duW);
      }
      AppMethodBeat.o(113977);
      return 0;
    }
    if (paramInt == 1) {
      if (this.oxM == null) {
        break label394;
      }
    }
    label394:
    for (int i = f.a.a.b.b.a.e(1, this.oxM) + 0;; i = 0)
    {
      paramInt = i;
      if (this.code != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.code);
      }
      i = paramInt;
      if (this.FSl != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.FSl);
      }
      paramInt = i;
      if (this.duW != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.duW);
      }
      AppMethodBeat.o(113977);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(113977);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        tt localtt = (tt)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(113977);
          return -1;
        case 1: 
          localtt.oxM = locala.NPN.readString();
          AppMethodBeat.o(113977);
          return 0;
        case 2: 
          localtt.code = locala.NPN.readString();
          AppMethodBeat.o(113977);
          return 0;
        case 3: 
          localtt.FSl = locala.NPN.readString();
          AppMethodBeat.o(113977);
          return 0;
        }
        localtt.duW = locala.NPN.readString();
        AppMethodBeat.o(113977);
        return 0;
      }
      AppMethodBeat.o(113977);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.tt
 * JD-Core Version:    0.7.0.1
 */