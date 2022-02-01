package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class enf
  extends com.tencent.mm.bw.a
{
  public int BsF;
  public int BsG;
  public String LVq;
  public String MD5;
  public boolean Nlg;
  public boolean Nlh = false;
  public int Ret;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(104841);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.Ret);
      paramVarArgs.aM(2, this.BsG);
      paramVarArgs.aM(3, this.BsF);
      if (this.MD5 != null) {
        paramVarArgs.e(4, this.MD5);
      }
      paramVarArgs.cc(5, this.Nlg);
      if (this.LVq != null) {
        paramVarArgs.e(6, this.LVq);
      }
      paramVarArgs.cc(7, this.Nlh);
      AppMethodBeat.o(104841);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bu(1, this.Ret) + 0 + g.a.a.b.b.a.bu(2, this.BsG) + g.a.a.b.b.a.bu(3, this.BsF);
      paramInt = i;
      if (this.MD5 != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.MD5);
      }
      i = paramInt + (g.a.a.b.b.a.fS(5) + 1);
      paramInt = i;
      if (this.LVq != null) {
        paramInt = i + g.a.a.b.b.a.f(6, this.LVq);
      }
      i = g.a.a.b.b.a.fS(7);
      AppMethodBeat.o(104841);
      return paramInt + (i + 1);
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(104841);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      enf localenf = (enf)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(104841);
        return -1;
      case 1: 
        localenf.Ret = locala.UbS.zi();
        AppMethodBeat.o(104841);
        return 0;
      case 2: 
        localenf.BsG = locala.UbS.zi();
        AppMethodBeat.o(104841);
        return 0;
      case 3: 
        localenf.BsF = locala.UbS.zi();
        AppMethodBeat.o(104841);
        return 0;
      case 4: 
        localenf.MD5 = locala.UbS.readString();
        AppMethodBeat.o(104841);
        return 0;
      case 5: 
        localenf.Nlg = locala.UbS.yZ();
        AppMethodBeat.o(104841);
        return 0;
      case 6: 
        localenf.LVq = locala.UbS.readString();
        AppMethodBeat.o(104841);
        return 0;
      }
      localenf.Nlh = locala.UbS.yZ();
      AppMethodBeat.o(104841);
      return 0;
    }
    AppMethodBeat.o(104841);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.enf
 * JD-Core Version:    0.7.0.1
 */