package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class aot
  extends com.tencent.mm.bw.a
{
  public int diw;
  public String objectNonceId;
  public long qXP;
  public String sessionBuffer;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(195123);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aO(1, this.qXP);
      if (this.objectNonceId != null) {
        paramVarArgs.d(2, this.objectNonceId);
      }
      paramVarArgs.aR(3, this.diw);
      if (this.sessionBuffer != null) {
        paramVarArgs.d(4, this.sessionBuffer);
      }
      AppMethodBeat.o(195123);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.p(1, this.qXP) + 0;
      paramInt = i;
      if (this.objectNonceId != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.objectNonceId);
      }
      i = paramInt + f.a.a.b.b.a.bx(3, this.diw);
      paramInt = i;
      if (this.sessionBuffer != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.sessionBuffer);
      }
      AppMethodBeat.o(195123);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      AppMethodBeat.o(195123);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      aot localaot = (aot)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(195123);
        return -1;
      case 1: 
        localaot.qXP = locala.LVo.xG();
        AppMethodBeat.o(195123);
        return 0;
      case 2: 
        localaot.objectNonceId = locala.LVo.readString();
        AppMethodBeat.o(195123);
        return 0;
      case 3: 
        localaot.diw = locala.LVo.xF();
        AppMethodBeat.o(195123);
        return 0;
      }
      localaot.sessionBuffer = locala.LVo.readString();
      AppMethodBeat.o(195123);
      return 0;
    }
    AppMethodBeat.o(195123);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aot
 * JD-Core Version:    0.7.0.1
 */