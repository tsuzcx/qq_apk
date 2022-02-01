package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class eij
  extends com.tencent.mm.bw.a
{
  public int Category;
  public int MOb;
  public LinkedList<String> MOd;
  public long NhD;
  public int NhE;
  public String iAc;
  
  public eij()
  {
    AppMethodBeat.i(152998);
    this.MOd = new LinkedList();
    AppMethodBeat.o(152998);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152999);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.iAc != null) {
        paramVarArgs.e(1, this.iAc);
      }
      paramVarArgs.bb(2, this.NhD);
      paramVarArgs.aM(3, this.MOb);
      paramVarArgs.aM(4, this.NhE);
      paramVarArgs.aM(5, this.Category);
      paramVarArgs.e(6, 1, this.MOd);
      AppMethodBeat.o(152999);
      return 0;
    }
    if (paramInt == 1) {
      if (this.iAc == null) {
        break label458;
      }
    }
    label458:
    for (paramInt = g.a.a.b.b.a.f(1, this.iAc) + 0;; paramInt = 0)
    {
      int i = g.a.a.b.b.a.r(2, this.NhD);
      int j = g.a.a.b.b.a.bu(3, this.MOb);
      int k = g.a.a.b.b.a.bu(4, this.NhE);
      int m = g.a.a.b.b.a.bu(5, this.Category);
      int n = g.a.a.a.c(6, 1, this.MOd);
      AppMethodBeat.o(152999);
      return paramInt + i + j + k + m + n;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.MOd.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(152999);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        eij localeij = (eij)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(152999);
          return -1;
        case 1: 
          localeij.iAc = locala.UbS.readString();
          AppMethodBeat.o(152999);
          return 0;
        case 2: 
          localeij.NhD = locala.UbS.zl();
          AppMethodBeat.o(152999);
          return 0;
        case 3: 
          localeij.MOb = locala.UbS.zi();
          AppMethodBeat.o(152999);
          return 0;
        case 4: 
          localeij.NhE = locala.UbS.zi();
          AppMethodBeat.o(152999);
          return 0;
        case 5: 
          localeij.Category = locala.UbS.zi();
          AppMethodBeat.o(152999);
          return 0;
        }
        localeij.MOd.add(locala.UbS.readString());
        AppMethodBeat.o(152999);
        return 0;
      }
      AppMethodBeat.o(152999);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eij
 * JD-Core Version:    0.7.0.1
 */