package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ezd
  extends com.tencent.mm.bw.a
{
  public String MRZ;
  public int MWA;
  public boolean NvF;
  public boolean NvG;
  public boolean NvH;
  public com.tencent.mm.bw.b Nvo;
  public String Title;
  public String iAc;
  public int xNF;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32545);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.MRZ == null)
      {
        paramVarArgs = new g.a.a.b("Not all required fields were included: Talker");
        AppMethodBeat.o(32545);
        throw paramVarArgs;
      }
      if (this.Title == null)
      {
        paramVarArgs = new g.a.a.b("Not all required fields were included: Title");
        AppMethodBeat.o(32545);
        throw paramVarArgs;
      }
      if (this.iAc == null)
      {
        paramVarArgs = new g.a.a.b("Not all required fields were included: Content");
        AppMethodBeat.o(32545);
        throw paramVarArgs;
      }
      paramVarArgs.aM(1, this.xNF);
      if (this.MRZ != null) {
        paramVarArgs.e(2, this.MRZ);
      }
      if (this.Title != null) {
        paramVarArgs.e(3, this.Title);
      }
      if (this.iAc != null) {
        paramVarArgs.e(4, this.iAc);
      }
      paramVarArgs.aM(5, this.MWA);
      if (this.Nvo != null) {
        paramVarArgs.c(6, this.Nvo);
      }
      paramVarArgs.cc(7, this.NvF);
      paramVarArgs.cc(8, this.NvG);
      paramVarArgs.cc(9, this.NvH);
      AppMethodBeat.o(32545);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bu(1, this.xNF) + 0;
      paramInt = i;
      if (this.MRZ != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.MRZ);
      }
      i = paramInt;
      if (this.Title != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.Title);
      }
      paramInt = i;
      if (this.iAc != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.iAc);
      }
      i = paramInt + g.a.a.b.b.a.bu(5, this.MWA);
      paramInt = i;
      if (this.Nvo != null) {
        paramInt = i + g.a.a.b.b.a.b(6, this.Nvo);
      }
      i = g.a.a.b.b.a.fS(7);
      int j = g.a.a.b.b.a.fS(8);
      int k = g.a.a.b.b.a.fS(9);
      AppMethodBeat.o(32545);
      return paramInt + (i + 1) + (j + 1) + (k + 1);
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      if (this.MRZ == null)
      {
        paramVarArgs = new g.a.a.b("Not all required fields were included: Talker");
        AppMethodBeat.o(32545);
        throw paramVarArgs;
      }
      if (this.Title == null)
      {
        paramVarArgs = new g.a.a.b("Not all required fields were included: Title");
        AppMethodBeat.o(32545);
        throw paramVarArgs;
      }
      if (this.iAc == null)
      {
        paramVarArgs = new g.a.a.b("Not all required fields were included: Content");
        AppMethodBeat.o(32545);
        throw paramVarArgs;
      }
      AppMethodBeat.o(32545);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      ezd localezd = (ezd)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(32545);
        return -1;
      case 1: 
        localezd.xNF = locala.UbS.zi();
        AppMethodBeat.o(32545);
        return 0;
      case 2: 
        localezd.MRZ = locala.UbS.readString();
        AppMethodBeat.o(32545);
        return 0;
      case 3: 
        localezd.Title = locala.UbS.readString();
        AppMethodBeat.o(32545);
        return 0;
      case 4: 
        localezd.iAc = locala.UbS.readString();
        AppMethodBeat.o(32545);
        return 0;
      case 5: 
        localezd.MWA = locala.UbS.zi();
        AppMethodBeat.o(32545);
        return 0;
      case 6: 
        localezd.Nvo = locala.UbS.hPo();
        AppMethodBeat.o(32545);
        return 0;
      case 7: 
        localezd.NvF = locala.UbS.yZ();
        AppMethodBeat.o(32545);
        return 0;
      case 8: 
        localezd.NvG = locala.UbS.yZ();
        AppMethodBeat.o(32545);
        return 0;
      }
      localezd.NvH = locala.UbS.yZ();
      AppMethodBeat.o(32545);
      return 0;
    }
    AppMethodBeat.o(32545);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ezd
 * JD-Core Version:    0.7.0.1
 */