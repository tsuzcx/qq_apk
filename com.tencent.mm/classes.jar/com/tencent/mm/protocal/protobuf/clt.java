package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class clt
  extends com.tencent.mm.bx.a
{
  public String HeV;
  public String HeW;
  public int type;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153294);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.type);
      if (this.HeV != null) {
        paramVarArgs.d(2, this.HeV);
      }
      if (this.HeW != null) {
        paramVarArgs.d(3, this.HeW);
      }
      AppMethodBeat.o(153294);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bz(1, this.type) + 0;
      paramInt = i;
      if (this.HeV != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.HeV);
      }
      i = paramInt;
      if (this.HeW != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.HeW);
      }
      AppMethodBeat.o(153294);
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
      AppMethodBeat.o(153294);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      clt localclt = (clt)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(153294);
        return -1;
      case 1: 
        localclt.type = locala.NPN.zc();
        AppMethodBeat.o(153294);
        return 0;
      case 2: 
        localclt.HeV = locala.NPN.readString();
        AppMethodBeat.o(153294);
        return 0;
      }
      localclt.HeW = locala.NPN.readString();
      AppMethodBeat.o(153294);
      return 0;
    }
    AppMethodBeat.o(153294);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.clt
 * JD-Core Version:    0.7.0.1
 */