package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class fbf
  extends com.tencent.mm.bw.a
{
  public String Nxw;
  public boolean Nxx;
  public int Nxy;
  public int Nxz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(110856);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Nxw != null) {
        paramVarArgs.e(1, this.Nxw);
      }
      paramVarArgs.cc(2, this.Nxx);
      paramVarArgs.aM(3, this.Nxy);
      paramVarArgs.aM(4, this.Nxz);
      AppMethodBeat.o(110856);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Nxw == null) {
        break label350;
      }
    }
    label350:
    for (paramInt = g.a.a.b.b.a.f(1, this.Nxw) + 0;; paramInt = 0)
    {
      int i = g.a.a.b.b.a.fS(2);
      int j = g.a.a.b.b.a.bu(3, this.Nxy);
      int k = g.a.a.b.b.a.bu(4, this.Nxz);
      AppMethodBeat.o(110856);
      return paramInt + (i + 1) + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(110856);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        fbf localfbf = (fbf)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(110856);
          return -1;
        case 1: 
          localfbf.Nxw = locala.UbS.readString();
          AppMethodBeat.o(110856);
          return 0;
        case 2: 
          localfbf.Nxx = locala.UbS.yZ();
          AppMethodBeat.o(110856);
          return 0;
        case 3: 
          localfbf.Nxy = locala.UbS.zi();
          AppMethodBeat.o(110856);
          return 0;
        }
        localfbf.Nxz = locala.UbS.zi();
        AppMethodBeat.o(110856);
        return 0;
      }
      AppMethodBeat.o(110856);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fbf
 * JD-Core Version:    0.7.0.1
 */