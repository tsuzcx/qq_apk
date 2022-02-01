package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class op
  extends com.tencent.mm.bw.a
{
  public String KSj;
  public String KUA;
  public int KUx;
  public int KUy;
  public long KUz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124433);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.KUx);
      paramVarArgs.aM(2, this.KUy);
      paramVarArgs.bb(3, this.KUz);
      if (this.KUA != null) {
        paramVarArgs.e(4, this.KUA);
      }
      if (this.KSj != null) {
        paramVarArgs.e(5, this.KSj);
      }
      AppMethodBeat.o(124433);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bu(1, this.KUx) + 0 + g.a.a.b.b.a.bu(2, this.KUy) + g.a.a.b.b.a.r(3, this.KUz);
      paramInt = i;
      if (this.KUA != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.KUA);
      }
      i = paramInt;
      if (this.KSj != null) {
        i = paramInt + g.a.a.b.b.a.f(5, this.KSj);
      }
      AppMethodBeat.o(124433);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(124433);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      op localop = (op)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(124433);
        return -1;
      case 1: 
        localop.KUx = locala.UbS.zi();
        AppMethodBeat.o(124433);
        return 0;
      case 2: 
        localop.KUy = locala.UbS.zi();
        AppMethodBeat.o(124433);
        return 0;
      case 3: 
        localop.KUz = locala.UbS.zl();
        AppMethodBeat.o(124433);
        return 0;
      case 4: 
        localop.KUA = locala.UbS.readString();
        AppMethodBeat.o(124433);
        return 0;
      }
      localop.KSj = locala.UbS.readString();
      AppMethodBeat.o(124433);
      return 0;
    }
    AppMethodBeat.o(124433);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.op
 * JD-Core Version:    0.7.0.1
 */