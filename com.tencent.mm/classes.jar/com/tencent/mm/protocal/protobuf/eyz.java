package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class eyz
  extends com.tencent.mm.bw.a
{
  public long KMc;
  public long KMm;
  public String MRZ;
  public String Nickname;
  public boolean NvA;
  public com.tencent.mm.bw.b NvB;
  public String iAc;
  public int xKb;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32539);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Nickname == null)
      {
        paramVarArgs = new g.a.a.b("Not all required fields were included: Nickname");
        AppMethodBeat.o(32539);
        throw paramVarArgs;
      }
      if (this.iAc == null)
      {
        paramVarArgs = new g.a.a.b("Not all required fields were included: Content");
        AppMethodBeat.o(32539);
        throw paramVarArgs;
      }
      if (this.MRZ == null)
      {
        paramVarArgs = new g.a.a.b("Not all required fields were included: Talker");
        AppMethodBeat.o(32539);
        throw paramVarArgs;
      }
      paramVarArgs.bb(1, this.KMm);
      if (this.Nickname != null) {
        paramVarArgs.e(2, this.Nickname);
      }
      if (this.iAc != null) {
        paramVarArgs.e(3, this.iAc);
      }
      paramVarArgs.aM(4, this.xKb);
      if (this.MRZ != null) {
        paramVarArgs.e(5, this.MRZ);
      }
      paramVarArgs.bb(6, this.KMc);
      paramVarArgs.cc(7, this.NvA);
      if (this.NvB != null) {
        paramVarArgs.c(8, this.NvB);
      }
      AppMethodBeat.o(32539);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.r(1, this.KMm) + 0;
      paramInt = i;
      if (this.Nickname != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.Nickname);
      }
      i = paramInt;
      if (this.iAc != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.iAc);
      }
      i += g.a.a.b.b.a.bu(4, this.xKb);
      paramInt = i;
      if (this.MRZ != null) {
        paramInt = i + g.a.a.b.b.a.f(5, this.MRZ);
      }
      i = paramInt + g.a.a.b.b.a.r(6, this.KMc) + (g.a.a.b.b.a.fS(7) + 1);
      paramInt = i;
      if (this.NvB != null) {
        paramInt = i + g.a.a.b.b.a.b(8, this.NvB);
      }
      AppMethodBeat.o(32539);
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
      if (this.Nickname == null)
      {
        paramVarArgs = new g.a.a.b("Not all required fields were included: Nickname");
        AppMethodBeat.o(32539);
        throw paramVarArgs;
      }
      if (this.iAc == null)
      {
        paramVarArgs = new g.a.a.b("Not all required fields were included: Content");
        AppMethodBeat.o(32539);
        throw paramVarArgs;
      }
      if (this.MRZ == null)
      {
        paramVarArgs = new g.a.a.b("Not all required fields were included: Talker");
        AppMethodBeat.o(32539);
        throw paramVarArgs;
      }
      AppMethodBeat.o(32539);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      eyz localeyz = (eyz)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(32539);
        return -1;
      case 1: 
        localeyz.KMm = locala.UbS.zl();
        AppMethodBeat.o(32539);
        return 0;
      case 2: 
        localeyz.Nickname = locala.UbS.readString();
        AppMethodBeat.o(32539);
        return 0;
      case 3: 
        localeyz.iAc = locala.UbS.readString();
        AppMethodBeat.o(32539);
        return 0;
      case 4: 
        localeyz.xKb = locala.UbS.zi();
        AppMethodBeat.o(32539);
        return 0;
      case 5: 
        localeyz.MRZ = locala.UbS.readString();
        AppMethodBeat.o(32539);
        return 0;
      case 6: 
        localeyz.KMc = locala.UbS.zl();
        AppMethodBeat.o(32539);
        return 0;
      case 7: 
        localeyz.NvA = locala.UbS.yZ();
        AppMethodBeat.o(32539);
        return 0;
      }
      localeyz.NvB = locala.UbS.hPo();
      AppMethodBeat.o(32539);
      return 0;
    }
    AppMethodBeat.o(32539);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eyz
 * JD-Core Version:    0.7.0.1
 */