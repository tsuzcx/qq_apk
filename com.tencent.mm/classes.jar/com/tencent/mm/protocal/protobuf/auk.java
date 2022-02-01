package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;

public final class auk
  extends com.tencent.mm.bw.a
{
  public long LFj;
  public String LFk;
  public b LFl;
  public String LFm;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(209477);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bb(1, this.LFj);
      if (this.LFk != null) {
        paramVarArgs.e(2, this.LFk);
      }
      if (this.LFl != null) {
        paramVarArgs.c(3, this.LFl);
      }
      if (this.LFm != null) {
        paramVarArgs.e(4, this.LFm);
      }
      AppMethodBeat.o(209477);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.r(1, this.LFj) + 0;
      paramInt = i;
      if (this.LFk != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.LFk);
      }
      i = paramInt;
      if (this.LFl != null) {
        i = paramInt + g.a.a.b.b.a.b(3, this.LFl);
      }
      paramInt = i;
      if (this.LFm != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.LFm);
      }
      AppMethodBeat.o(209477);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(209477);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      auk localauk = (auk)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(209477);
        return -1;
      case 1: 
        localauk.LFj = locala.UbS.zl();
        AppMethodBeat.o(209477);
        return 0;
      case 2: 
        localauk.LFk = locala.UbS.readString();
        AppMethodBeat.o(209477);
        return 0;
      case 3: 
        localauk.LFl = locala.UbS.hPo();
        AppMethodBeat.o(209477);
        return 0;
      }
      localauk.LFm = locala.UbS.readString();
      AppMethodBeat.o(209477);
      return 0;
    }
    AppMethodBeat.o(209477);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.auk
 * JD-Core Version:    0.7.0.1
 */