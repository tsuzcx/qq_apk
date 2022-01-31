package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cxf
  extends com.tencent.mm.bv.a
{
  public String Nickname;
  public int nqW;
  public String ntu;
  public long wsC;
  public long wsz;
  public String xlH;
  public boolean yeN;
  public com.tencent.mm.bv.b yeO;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(28740);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.Nickname == null)
      {
        paramVarArgs = new e.a.a.b("Not all required fields were included: Nickname");
        AppMethodBeat.o(28740);
        throw paramVarArgs;
      }
      if (this.ntu == null)
      {
        paramVarArgs = new e.a.a.b("Not all required fields were included: Content");
        AppMethodBeat.o(28740);
        throw paramVarArgs;
      }
      if (this.xlH == null)
      {
        paramVarArgs = new e.a.a.b("Not all required fields were included: Talker");
        AppMethodBeat.o(28740);
        throw paramVarArgs;
      }
      paramVarArgs.am(1, this.wsz);
      if (this.Nickname != null) {
        paramVarArgs.e(2, this.Nickname);
      }
      if (this.ntu != null) {
        paramVarArgs.e(3, this.ntu);
      }
      paramVarArgs.aO(4, this.nqW);
      if (this.xlH != null) {
        paramVarArgs.e(5, this.xlH);
      }
      paramVarArgs.am(6, this.wsC);
      paramVarArgs.aS(7, this.yeN);
      if (this.yeO != null) {
        paramVarArgs.c(8, this.yeO);
      }
      AppMethodBeat.o(28740);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = e.a.a.b.b.a.p(1, this.wsz) + 0;
      paramInt = i;
      if (this.Nickname != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.Nickname);
      }
      i = paramInt;
      if (this.ntu != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.ntu);
      }
      i += e.a.a.b.b.a.bl(4, this.nqW);
      paramInt = i;
      if (this.xlH != null) {
        paramInt = i + e.a.a.b.b.a.f(5, this.xlH);
      }
      i = paramInt + e.a.a.b.b.a.p(6, this.wsC) + (e.a.a.b.b.a.eW(7) + 1);
      paramInt = i;
      if (this.yeO != null) {
        paramInt = i + e.a.a.b.b.a.b(8, this.yeO);
      }
      AppMethodBeat.o(28740);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.eqQ();
        }
      }
      if (this.Nickname == null)
      {
        paramVarArgs = new e.a.a.b("Not all required fields were included: Nickname");
        AppMethodBeat.o(28740);
        throw paramVarArgs;
      }
      if (this.ntu == null)
      {
        paramVarArgs = new e.a.a.b("Not all required fields were included: Content");
        AppMethodBeat.o(28740);
        throw paramVarArgs;
      }
      if (this.xlH == null)
      {
        paramVarArgs = new e.a.a.b("Not all required fields were included: Talker");
        AppMethodBeat.o(28740);
        throw paramVarArgs;
      }
      AppMethodBeat.o(28740);
      return 0;
    }
    if (paramInt == 3)
    {
      e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
      cxf localcxf = (cxf)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(28740);
        return -1;
      case 1: 
        localcxf.wsz = locala.CLY.sm();
        AppMethodBeat.o(28740);
        return 0;
      case 2: 
        localcxf.Nickname = locala.CLY.readString();
        AppMethodBeat.o(28740);
        return 0;
      case 3: 
        localcxf.ntu = locala.CLY.readString();
        AppMethodBeat.o(28740);
        return 0;
      case 4: 
        localcxf.nqW = locala.CLY.sl();
        AppMethodBeat.o(28740);
        return 0;
      case 5: 
        localcxf.xlH = locala.CLY.readString();
        AppMethodBeat.o(28740);
        return 0;
      case 6: 
        localcxf.wsC = locala.CLY.sm();
        AppMethodBeat.o(28740);
        return 0;
      case 7: 
        localcxf.yeN = locala.CLY.emu();
        AppMethodBeat.o(28740);
        return 0;
      }
      localcxf.yeO = locala.CLY.eqS();
      AppMethodBeat.o(28740);
      return 0;
    }
    AppMethodBeat.o(28740);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cxf
 * JD-Core Version:    0.7.0.1
 */