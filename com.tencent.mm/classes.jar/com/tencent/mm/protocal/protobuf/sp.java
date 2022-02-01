package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class sp
  extends com.tencent.mm.bx.a
{
  public int ozA;
  public String text;
  public String url;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(113947);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.ozA);
      if (this.text != null) {
        paramVarArgs.d(2, this.text);
      }
      if (this.url != null) {
        paramVarArgs.d(3, this.url);
      }
      AppMethodBeat.o(113947);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bz(1, this.ozA) + 0;
      paramInt = i;
      if (this.text != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.text);
      }
      i = paramInt;
      if (this.url != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.url);
      }
      AppMethodBeat.o(113947);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(113947);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      sp localsp = (sp)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(113947);
        return -1;
      case 1: 
        localsp.ozA = locala.NPN.zc();
        AppMethodBeat.o(113947);
        return 0;
      case 2: 
        localsp.text = locala.NPN.readString();
        AppMethodBeat.o(113947);
        return 0;
      }
      localsp.url = locala.NPN.readString();
      AppMethodBeat.o(113947);
      return 0;
    }
    AppMethodBeat.o(113947);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.sp
 * JD-Core Version:    0.7.0.1
 */