package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;

public final class ecj
  extends com.tencent.mm.bw.a
{
  public long Asv;
  public b NcA;
  public String id;
  public int type;
  public String wVT;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(209817);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.id != null) {
        paramVarArgs.e(1, this.id);
      }
      if (this.wVT != null) {
        paramVarArgs.e(2, this.wVT);
      }
      paramVarArgs.bb(3, this.Asv);
      paramVarArgs.aM(4, this.type);
      if (this.NcA != null) {
        paramVarArgs.c(5, this.NcA);
      }
      AppMethodBeat.o(209817);
      return 0;
    }
    if (paramInt == 1) {
      if (this.id == null) {
        break label422;
      }
    }
    label422:
    for (paramInt = g.a.a.b.b.a.f(1, this.id) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.wVT != null) {
        i = paramInt + g.a.a.b.b.a.f(2, this.wVT);
      }
      i = i + g.a.a.b.b.a.r(3, this.Asv) + g.a.a.b.b.a.bu(4, this.type);
      paramInt = i;
      if (this.NcA != null) {
        paramInt = i + g.a.a.b.b.a.b(5, this.NcA);
      }
      AppMethodBeat.o(209817);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(209817);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        ecj localecj = (ecj)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(209817);
          return -1;
        case 1: 
          localecj.id = locala.UbS.readString();
          AppMethodBeat.o(209817);
          return 0;
        case 2: 
          localecj.wVT = locala.UbS.readString();
          AppMethodBeat.o(209817);
          return 0;
        case 3: 
          localecj.Asv = locala.UbS.zl();
          AppMethodBeat.o(209817);
          return 0;
        case 4: 
          localecj.type = locala.UbS.zi();
          AppMethodBeat.o(209817);
          return 0;
        }
        localecj.NcA = locala.UbS.hPo();
        AppMethodBeat.o(209817);
        return 0;
      }
      AppMethodBeat.o(209817);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ecj
 * JD-Core Version:    0.7.0.1
 */