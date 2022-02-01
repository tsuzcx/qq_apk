package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class asm
  extends com.tencent.mm.bx.a
{
  public long ZCi;
  public long ZCj;
  public long ZCk;
  public String ZCl;
  public long ZCm;
  public String ZCn;
  public String ZCo;
  public String ZCp;
  public String ZCq;
  public String ZCr;
  public String ZCs;
  public int ZCt;
  public String ZCu;
  public String ZgS;
  public int Zxg;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91460);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bv(1, this.ZCi);
      paramVarArgs.bv(2, this.ZCj);
      paramVarArgs.bv(3, this.ZCk);
      if (this.ZCl != null) {
        paramVarArgs.g(4, this.ZCl);
      }
      paramVarArgs.bv(5, this.ZCm);
      if (this.ZCn != null) {
        paramVarArgs.g(6, this.ZCn);
      }
      if (this.ZCo != null) {
        paramVarArgs.g(7, this.ZCo);
      }
      if (this.ZCp != null) {
        paramVarArgs.g(8, this.ZCp);
      }
      if (this.ZCq != null) {
        paramVarArgs.g(9, this.ZCq);
      }
      if (this.ZCr != null) {
        paramVarArgs.g(10, this.ZCr);
      }
      if (this.ZCs != null) {
        paramVarArgs.g(11, this.ZCs);
      }
      paramVarArgs.bS(12, this.ZCt);
      if (this.ZCu != null) {
        paramVarArgs.g(13, this.ZCu);
      }
      paramVarArgs.bS(14, this.Zxg);
      if (this.ZgS != null) {
        paramVarArgs.g(15, this.ZgS);
      }
      AppMethodBeat.o(91460);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.q(1, this.ZCi) + 0 + i.a.a.b.b.a.q(2, this.ZCj) + i.a.a.b.b.a.q(3, this.ZCk);
      paramInt = i;
      if (this.ZCl != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.ZCl);
      }
      i = paramInt + i.a.a.b.b.a.q(5, this.ZCm);
      paramInt = i;
      if (this.ZCn != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.ZCn);
      }
      i = paramInt;
      if (this.ZCo != null) {
        i = paramInt + i.a.a.b.b.a.h(7, this.ZCo);
      }
      paramInt = i;
      if (this.ZCp != null) {
        paramInt = i + i.a.a.b.b.a.h(8, this.ZCp);
      }
      i = paramInt;
      if (this.ZCq != null) {
        i = paramInt + i.a.a.b.b.a.h(9, this.ZCq);
      }
      paramInt = i;
      if (this.ZCr != null) {
        paramInt = i + i.a.a.b.b.a.h(10, this.ZCr);
      }
      i = paramInt;
      if (this.ZCs != null) {
        i = paramInt + i.a.a.b.b.a.h(11, this.ZCs);
      }
      i += i.a.a.b.b.a.cJ(12, this.ZCt);
      paramInt = i;
      if (this.ZCu != null) {
        paramInt = i + i.a.a.b.b.a.h(13, this.ZCu);
      }
      i = paramInt + i.a.a.b.b.a.cJ(14, this.Zxg);
      paramInt = i;
      if (this.ZgS != null) {
        paramInt = i + i.a.a.b.b.a.h(15, this.ZgS);
      }
      AppMethodBeat.o(91460);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(91460);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      asm localasm = (asm)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(91460);
        return -1;
      case 1: 
        localasm.ZCi = locala.ajGk.aaw();
        AppMethodBeat.o(91460);
        return 0;
      case 2: 
        localasm.ZCj = locala.ajGk.aaw();
        AppMethodBeat.o(91460);
        return 0;
      case 3: 
        localasm.ZCk = locala.ajGk.aaw();
        AppMethodBeat.o(91460);
        return 0;
      case 4: 
        localasm.ZCl = locala.ajGk.readString();
        AppMethodBeat.o(91460);
        return 0;
      case 5: 
        localasm.ZCm = locala.ajGk.aaw();
        AppMethodBeat.o(91460);
        return 0;
      case 6: 
        localasm.ZCn = locala.ajGk.readString();
        AppMethodBeat.o(91460);
        return 0;
      case 7: 
        localasm.ZCo = locala.ajGk.readString();
        AppMethodBeat.o(91460);
        return 0;
      case 8: 
        localasm.ZCp = locala.ajGk.readString();
        AppMethodBeat.o(91460);
        return 0;
      case 9: 
        localasm.ZCq = locala.ajGk.readString();
        AppMethodBeat.o(91460);
        return 0;
      case 10: 
        localasm.ZCr = locala.ajGk.readString();
        AppMethodBeat.o(91460);
        return 0;
      case 11: 
        localasm.ZCs = locala.ajGk.readString();
        AppMethodBeat.o(91460);
        return 0;
      case 12: 
        localasm.ZCt = locala.ajGk.aar();
        AppMethodBeat.o(91460);
        return 0;
      case 13: 
        localasm.ZCu = locala.ajGk.readString();
        AppMethodBeat.o(91460);
        return 0;
      case 14: 
        localasm.Zxg = locala.ajGk.aar();
        AppMethodBeat.o(91460);
        return 0;
      }
      localasm.ZgS = locala.ajGk.readString();
      AppMethodBeat.o(91460);
      return 0;
    }
    AppMethodBeat.o(91460);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.asm
 * JD-Core Version:    0.7.0.1
 */