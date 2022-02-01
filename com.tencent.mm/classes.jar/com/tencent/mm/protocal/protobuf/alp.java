package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;

public final class alp
  extends com.tencent.mm.bx.a
{
  public b Gls;
  public int cmdId;
  public String krz;
  public int retCode;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(168939);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.cmdId);
      paramVarArgs.aS(2, this.retCode);
      if (this.krz != null) {
        paramVarArgs.d(3, this.krz);
      }
      if (this.Gls != null) {
        paramVarArgs.c(4, this.Gls);
      }
      AppMethodBeat.o(168939);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bz(1, this.cmdId) + 0 + f.a.a.b.b.a.bz(2, this.retCode);
      paramInt = i;
      if (this.krz != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.krz);
      }
      i = paramInt;
      if (this.Gls != null) {
        i = paramInt + f.a.a.b.b.a.b(4, this.Gls);
      }
      AppMethodBeat.o(168939);
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
      AppMethodBeat.o(168939);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      alp localalp = (alp)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(168939);
        return -1;
      case 1: 
        localalp.cmdId = locala.NPN.zc();
        AppMethodBeat.o(168939);
        return 0;
      case 2: 
        localalp.retCode = locala.NPN.zc();
        AppMethodBeat.o(168939);
        return 0;
      case 3: 
        localalp.krz = locala.NPN.readString();
        AppMethodBeat.o(168939);
        return 0;
      }
      localalp.Gls = locala.NPN.gxI();
      AppMethodBeat.o(168939);
      return 0;
    }
    AppMethodBeat.o(168939);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.alp
 * JD-Core Version:    0.7.0.1
 */