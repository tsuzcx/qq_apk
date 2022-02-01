package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;

public final class drb
  extends com.tencent.mm.bw.a
{
  public int HYd;
  public int HYe;
  public String HYf;
  public b HYg;
  public int HYh;
  public int HYi;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(82481);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.HYd);
      paramVarArgs.aS(2, this.HYe);
      if (this.HYf != null) {
        paramVarArgs.d(3, this.HYf);
      }
      if (this.HYg != null) {
        paramVarArgs.c(4, this.HYg);
      }
      paramVarArgs.aS(5, this.HYh);
      paramVarArgs.aS(6, this.HYi);
      AppMethodBeat.o(82481);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bz(1, this.HYd) + 0 + f.a.a.b.b.a.bz(2, this.HYe);
      paramInt = i;
      if (this.HYf != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.HYf);
      }
      i = paramInt;
      if (this.HYg != null) {
        i = paramInt + f.a.a.b.b.a.b(4, this.HYg);
      }
      paramInt = f.a.a.b.b.a.bz(5, this.HYh);
      int j = f.a.a.b.b.a.bz(6, this.HYi);
      AppMethodBeat.o(82481);
      return i + paramInt + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(82481);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      drb localdrb = (drb)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(82481);
        return -1;
      case 1: 
        localdrb.HYd = locala.OmT.zc();
        AppMethodBeat.o(82481);
        return 0;
      case 2: 
        localdrb.HYe = locala.OmT.zc();
        AppMethodBeat.o(82481);
        return 0;
      case 3: 
        localdrb.HYf = locala.OmT.readString();
        AppMethodBeat.o(82481);
        return 0;
      case 4: 
        localdrb.HYg = locala.OmT.gCk();
        AppMethodBeat.o(82481);
        return 0;
      case 5: 
        localdrb.HYh = locala.OmT.zc();
        AppMethodBeat.o(82481);
        return 0;
      }
      localdrb.HYi = locala.OmT.zc();
      AppMethodBeat.o(82481);
      return 0;
    }
    AppMethodBeat.o(82481);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.drb
 * JD-Core Version:    0.7.0.1
 */