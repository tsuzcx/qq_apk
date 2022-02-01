package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dle
  extends com.tencent.mm.bx.a
{
  public String DKv;
  public String Dbx;
  public String JfH;
  public String JfI;
  public int JfJ;
  public String ZTp;
  public String aaRb;
  public int aaRc;
  public long aaRd;
  public int aaRe;
  public String aaRf;
  public int aaRg;
  public int aaRh;
  public String content;
  public String kLn;
  public int msgType;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259199);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.msgType);
      if (this.aaRb != null) {
        paramVarArgs.g(2, this.aaRb);
      }
      if (this.content != null) {
        paramVarArgs.g(3, this.content);
      }
      paramVarArgs.bS(4, this.aaRc);
      paramVarArgs.bv(5, this.aaRd);
      if (this.kLn != null) {
        paramVarArgs.g(6, this.kLn);
      }
      if (this.ZTp != null) {
        paramVarArgs.g(7, this.ZTp);
      }
      paramVarArgs.bS(8, this.JfJ);
      paramVarArgs.bS(9, this.aaRe);
      if (this.aaRf != null) {
        paramVarArgs.g(10, this.aaRf);
      }
      if (this.JfH != null) {
        paramVarArgs.g(11, this.JfH);
      }
      paramVarArgs.bS(12, this.aaRg);
      if (this.JfI != null) {
        paramVarArgs.g(13, this.JfI);
      }
      if (this.DKv != null) {
        paramVarArgs.g(14, this.DKv);
      }
      if (this.Dbx != null) {
        paramVarArgs.g(15, this.Dbx);
      }
      paramVarArgs.bS(16, this.aaRh);
      AppMethodBeat.o(259199);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.cJ(1, this.msgType) + 0;
      paramInt = i;
      if (this.aaRb != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.aaRb);
      }
      i = paramInt;
      if (this.content != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.content);
      }
      i = i + i.a.a.b.b.a.cJ(4, this.aaRc) + i.a.a.b.b.a.q(5, this.aaRd);
      paramInt = i;
      if (this.kLn != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.kLn);
      }
      i = paramInt;
      if (this.ZTp != null) {
        i = paramInt + i.a.a.b.b.a.h(7, this.ZTp);
      }
      i = i + i.a.a.b.b.a.cJ(8, this.JfJ) + i.a.a.b.b.a.cJ(9, this.aaRe);
      paramInt = i;
      if (this.aaRf != null) {
        paramInt = i + i.a.a.b.b.a.h(10, this.aaRf);
      }
      i = paramInt;
      if (this.JfH != null) {
        i = paramInt + i.a.a.b.b.a.h(11, this.JfH);
      }
      i += i.a.a.b.b.a.cJ(12, this.aaRg);
      paramInt = i;
      if (this.JfI != null) {
        paramInt = i + i.a.a.b.b.a.h(13, this.JfI);
      }
      i = paramInt;
      if (this.DKv != null) {
        i = paramInt + i.a.a.b.b.a.h(14, this.DKv);
      }
      paramInt = i;
      if (this.Dbx != null) {
        paramInt = i + i.a.a.b.b.a.h(15, this.Dbx);
      }
      i = i.a.a.b.b.a.cJ(16, this.aaRh);
      AppMethodBeat.o(259199);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(259199);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      dle localdle = (dle)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(259199);
        return -1;
      case 1: 
        localdle.msgType = locala.ajGk.aar();
        AppMethodBeat.o(259199);
        return 0;
      case 2: 
        localdle.aaRb = locala.ajGk.readString();
        AppMethodBeat.o(259199);
        return 0;
      case 3: 
        localdle.content = locala.ajGk.readString();
        AppMethodBeat.o(259199);
        return 0;
      case 4: 
        localdle.aaRc = locala.ajGk.aar();
        AppMethodBeat.o(259199);
        return 0;
      case 5: 
        localdle.aaRd = locala.ajGk.aaw();
        AppMethodBeat.o(259199);
        return 0;
      case 6: 
        localdle.kLn = locala.ajGk.readString();
        AppMethodBeat.o(259199);
        return 0;
      case 7: 
        localdle.ZTp = locala.ajGk.readString();
        AppMethodBeat.o(259199);
        return 0;
      case 8: 
        localdle.JfJ = locala.ajGk.aar();
        AppMethodBeat.o(259199);
        return 0;
      case 9: 
        localdle.aaRe = locala.ajGk.aar();
        AppMethodBeat.o(259199);
        return 0;
      case 10: 
        localdle.aaRf = locala.ajGk.readString();
        AppMethodBeat.o(259199);
        return 0;
      case 11: 
        localdle.JfH = locala.ajGk.readString();
        AppMethodBeat.o(259199);
        return 0;
      case 12: 
        localdle.aaRg = locala.ajGk.aar();
        AppMethodBeat.o(259199);
        return 0;
      case 13: 
        localdle.JfI = locala.ajGk.readString();
        AppMethodBeat.o(259199);
        return 0;
      case 14: 
        localdle.DKv = locala.ajGk.readString();
        AppMethodBeat.o(259199);
        return 0;
      case 15: 
        localdle.Dbx = locala.ajGk.readString();
        AppMethodBeat.o(259199);
        return 0;
      }
      localdle.aaRh = locala.ajGk.aar();
      AppMethodBeat.o(259199);
      return 0;
    }
    AppMethodBeat.o(259199);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dle
 * JD-Core Version:    0.7.0.1
 */