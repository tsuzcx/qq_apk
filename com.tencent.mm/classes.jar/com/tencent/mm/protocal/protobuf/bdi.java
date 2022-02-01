package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;

public final class bdi
  extends com.tencent.mm.bw.a
{
  public int LNf;
  public b LNg;
  public b LNh;
  public String dQx;
  public int position;
  public long twp;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(209696);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.LNf);
      paramVarArgs.bb(2, this.twp);
      paramVarArgs.aM(3, this.position);
      if (this.dQx != null) {
        paramVarArgs.e(4, this.dQx);
      }
      if (this.LNg != null) {
        paramVarArgs.c(5, this.LNg);
      }
      if (this.LNh != null) {
        paramVarArgs.c(6, this.LNh);
      }
      AppMethodBeat.o(209696);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bu(1, this.LNf) + 0 + g.a.a.b.b.a.r(2, this.twp) + g.a.a.b.b.a.bu(3, this.position);
      paramInt = i;
      if (this.dQx != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.dQx);
      }
      i = paramInt;
      if (this.LNg != null) {
        i = paramInt + g.a.a.b.b.a.b(5, this.LNg);
      }
      paramInt = i;
      if (this.LNh != null) {
        paramInt = i + g.a.a.b.b.a.b(6, this.LNh);
      }
      AppMethodBeat.o(209696);
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
      AppMethodBeat.o(209696);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      bdi localbdi = (bdi)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(209696);
        return -1;
      case 1: 
        localbdi.LNf = locala.UbS.zi();
        AppMethodBeat.o(209696);
        return 0;
      case 2: 
        localbdi.twp = locala.UbS.zl();
        AppMethodBeat.o(209696);
        return 0;
      case 3: 
        localbdi.position = locala.UbS.zi();
        AppMethodBeat.o(209696);
        return 0;
      case 4: 
        localbdi.dQx = locala.UbS.readString();
        AppMethodBeat.o(209696);
        return 0;
      case 5: 
        localbdi.LNg = locala.UbS.hPo();
        AppMethodBeat.o(209696);
        return 0;
      }
      localbdi.LNh = locala.UbS.hPo();
      AppMethodBeat.o(209696);
      return 0;
    }
    AppMethodBeat.o(209696);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bdi
 * JD-Core Version:    0.7.0.1
 */