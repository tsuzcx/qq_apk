package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class acy
  extends com.tencent.mm.bw.a
{
  public String KBt;
  public long Lnv;
  public int Lof;
  public boolean Log;
  public int Loh;
  public boolean Lol;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(186800);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bb(1, this.Lnv);
      if (this.KBt != null) {
        paramVarArgs.e(2, this.KBt);
      }
      paramVarArgs.aM(3, this.Lof);
      paramVarArgs.cc(4, this.Lol);
      paramVarArgs.cc(5, this.Log);
      paramVarArgs.aM(6, this.Loh);
      AppMethodBeat.o(186800);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.r(1, this.Lnv) + 0;
      paramInt = i;
      if (this.KBt != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.KBt);
      }
      i = g.a.a.b.b.a.bu(3, this.Lof);
      int j = g.a.a.b.b.a.fS(4);
      int k = g.a.a.b.b.a.fS(5);
      int m = g.a.a.b.b.a.bu(6, this.Loh);
      AppMethodBeat.o(186800);
      return paramInt + i + (j + 1) + (k + 1) + m;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(186800);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      acy localacy = (acy)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(186800);
        return -1;
      case 1: 
        localacy.Lnv = locala.UbS.zl();
        AppMethodBeat.o(186800);
        return 0;
      case 2: 
        localacy.KBt = locala.UbS.readString();
        AppMethodBeat.o(186800);
        return 0;
      case 3: 
        localacy.Lof = locala.UbS.zi();
        AppMethodBeat.o(186800);
        return 0;
      case 4: 
        localacy.Lol = locala.UbS.yZ();
        AppMethodBeat.o(186800);
        return 0;
      case 5: 
        localacy.Log = locala.UbS.yZ();
        AppMethodBeat.o(186800);
        return 0;
      }
      localacy.Loh = locala.UbS.zi();
      AppMethodBeat.o(186800);
      return 0;
    }
    AppMethodBeat.o(186800);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.acy
 * JD-Core Version:    0.7.0.1
 */