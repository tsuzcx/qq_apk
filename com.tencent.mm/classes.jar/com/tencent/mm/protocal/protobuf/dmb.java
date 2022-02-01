package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dmb
  extends com.tencent.mm.bx.a
{
  public int Gad;
  public boolean aaSf;
  public boolean aaSg;
  public int aaSh;
  public String aaSi;
  public boolean aaSj;
  public boolean aaSk;
  public String aaSl;
  public boolean aaSm;
  public String appid;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(127172);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.di(1, this.aaSf);
      paramVarArgs.di(2, this.aaSg);
      paramVarArgs.bS(3, this.Gad);
      paramVarArgs.bS(4, this.aaSh);
      if (this.aaSi != null) {
        paramVarArgs.g(5, this.aaSi);
      }
      paramVarArgs.di(6, this.aaSj);
      if (this.appid != null) {
        paramVarArgs.g(7, this.appid);
      }
      paramVarArgs.di(8, this.aaSk);
      if (this.aaSl != null) {
        paramVarArgs.g(9, this.aaSl);
      }
      paramVarArgs.di(10, this.aaSm);
      AppMethodBeat.o(127172);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.ko(1) + 1 + 0 + (i.a.a.b.b.a.ko(2) + 1) + i.a.a.b.b.a.cJ(3, this.Gad) + i.a.a.b.b.a.cJ(4, this.aaSh);
      paramInt = i;
      if (this.aaSi != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.aaSi);
      }
      i = paramInt + (i.a.a.b.b.a.ko(6) + 1);
      paramInt = i;
      if (this.appid != null) {
        paramInt = i + i.a.a.b.b.a.h(7, this.appid);
      }
      i = paramInt + (i.a.a.b.b.a.ko(8) + 1);
      paramInt = i;
      if (this.aaSl != null) {
        paramInt = i + i.a.a.b.b.a.h(9, this.aaSl);
      }
      i = i.a.a.b.b.a.ko(10);
      AppMethodBeat.o(127172);
      return paramInt + (i + 1);
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(127172);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      dmb localdmb = (dmb)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(127172);
        return -1;
      case 1: 
        localdmb.aaSf = locala.ajGk.aai();
        AppMethodBeat.o(127172);
        return 0;
      case 2: 
        localdmb.aaSg = locala.ajGk.aai();
        AppMethodBeat.o(127172);
        return 0;
      case 3: 
        localdmb.Gad = locala.ajGk.aar();
        AppMethodBeat.o(127172);
        return 0;
      case 4: 
        localdmb.aaSh = locala.ajGk.aar();
        AppMethodBeat.o(127172);
        return 0;
      case 5: 
        localdmb.aaSi = locala.ajGk.readString();
        AppMethodBeat.o(127172);
        return 0;
      case 6: 
        localdmb.aaSj = locala.ajGk.aai();
        AppMethodBeat.o(127172);
        return 0;
      case 7: 
        localdmb.appid = locala.ajGk.readString();
        AppMethodBeat.o(127172);
        return 0;
      case 8: 
        localdmb.aaSk = locala.ajGk.aai();
        AppMethodBeat.o(127172);
        return 0;
      case 9: 
        localdmb.aaSl = locala.ajGk.readString();
        AppMethodBeat.o(127172);
        return 0;
      }
      localdmb.aaSm = locala.ajGk.aai();
      AppMethodBeat.o(127172);
      return 0;
    }
    AppMethodBeat.o(127172);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dmb
 * JD-Core Version:    0.7.0.1
 */