package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dlx
  extends com.tencent.mm.bx.a
{
  public int HAr;
  public String HAs;
  public String HAt;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117933);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.HAr);
      if (this.HAs != null) {
        paramVarArgs.d(2, this.HAs);
      }
      if (this.HAt != null) {
        paramVarArgs.d(3, this.HAt);
      }
      AppMethodBeat.o(117933);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bz(1, this.HAr) + 0;
      paramInt = i;
      if (this.HAs != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.HAs);
      }
      i = paramInt;
      if (this.HAt != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.HAt);
      }
      AppMethodBeat.o(117933);
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
      AppMethodBeat.o(117933);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      dlx localdlx = (dlx)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(117933);
        return -1;
      case 1: 
        localdlx.HAr = locala.NPN.zc();
        AppMethodBeat.o(117933);
        return 0;
      case 2: 
        localdlx.HAs = locala.NPN.readString();
        AppMethodBeat.o(117933);
        return 0;
      }
      localdlx.HAt = locala.NPN.readString();
      AppMethodBeat.o(117933);
      return 0;
    }
    AppMethodBeat.o(117933);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dlx
 * JD-Core Version:    0.7.0.1
 */