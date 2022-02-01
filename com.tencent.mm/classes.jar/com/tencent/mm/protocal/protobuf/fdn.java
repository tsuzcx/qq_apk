package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;

public final class fdn
  extends com.tencent.mm.bw.a
{
  public boolean NyX;
  public String Nzf;
  public b Nzg;
  public int Nzh;
  public int Nzi;
  public int Nzj;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(50123);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.cc(1, this.NyX);
      if (this.Nzf != null) {
        paramVarArgs.e(2, this.Nzf);
      }
      if (this.Nzg != null) {
        paramVarArgs.c(3, this.Nzg);
      }
      paramVarArgs.aM(4, this.Nzh);
      paramVarArgs.aM(5, this.Nzi);
      paramVarArgs.aM(6, this.Nzj);
      AppMethodBeat.o(50123);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.fS(1) + 1 + 0;
      paramInt = i;
      if (this.Nzf != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.Nzf);
      }
      i = paramInt;
      if (this.Nzg != null) {
        i = paramInt + g.a.a.b.b.a.b(3, this.Nzg);
      }
      paramInt = g.a.a.b.b.a.bu(4, this.Nzh);
      int j = g.a.a.b.b.a.bu(5, this.Nzi);
      int k = g.a.a.b.b.a.bu(6, this.Nzj);
      AppMethodBeat.o(50123);
      return i + paramInt + j + k;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(50123);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      fdn localfdn = (fdn)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(50123);
        return -1;
      case 1: 
        localfdn.NyX = locala.UbS.yZ();
        AppMethodBeat.o(50123);
        return 0;
      case 2: 
        localfdn.Nzf = locala.UbS.readString();
        AppMethodBeat.o(50123);
        return 0;
      case 3: 
        localfdn.Nzg = locala.UbS.hPo();
        AppMethodBeat.o(50123);
        return 0;
      case 4: 
        localfdn.Nzh = locala.UbS.zi();
        AppMethodBeat.o(50123);
        return 0;
      case 5: 
        localfdn.Nzi = locala.UbS.zi();
        AppMethodBeat.o(50123);
        return 0;
      }
      localfdn.Nzj = locala.UbS.zi();
      AppMethodBeat.o(50123);
      return 0;
    }
    AppMethodBeat.o(50123);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fdn
 * JD-Core Version:    0.7.0.1
 */