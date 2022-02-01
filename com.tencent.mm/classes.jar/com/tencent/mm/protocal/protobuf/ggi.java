package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ggi
  extends com.tencent.mm.bx.a
{
  public int IMf;
  public int abAu;
  public String abvu;
  public com.tencent.mm.bx.b accH;
  public boolean accY;
  public boolean accZ;
  public boolean acda;
  public String hAP;
  public String nUB;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32545);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.abvu == null)
      {
        paramVarArgs = new i.a.a.b("Not all required fields were included: Talker");
        AppMethodBeat.o(32545);
        throw paramVarArgs;
      }
      if (this.hAP == null)
      {
        paramVarArgs = new i.a.a.b("Not all required fields were included: Title");
        AppMethodBeat.o(32545);
        throw paramVarArgs;
      }
      if (this.nUB == null)
      {
        paramVarArgs = new i.a.a.b("Not all required fields were included: Content");
        AppMethodBeat.o(32545);
        throw paramVarArgs;
      }
      paramVarArgs.bS(1, this.IMf);
      if (this.abvu != null) {
        paramVarArgs.g(2, this.abvu);
      }
      if (this.hAP != null) {
        paramVarArgs.g(3, this.hAP);
      }
      if (this.nUB != null) {
        paramVarArgs.g(4, this.nUB);
      }
      paramVarArgs.bS(5, this.abAu);
      if (this.accH != null) {
        paramVarArgs.d(6, this.accH);
      }
      paramVarArgs.di(7, this.accY);
      paramVarArgs.di(8, this.accZ);
      paramVarArgs.di(9, this.acda);
      AppMethodBeat.o(32545);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.cJ(1, this.IMf) + 0;
      paramInt = i;
      if (this.abvu != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.abvu);
      }
      i = paramInt;
      if (this.hAP != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.hAP);
      }
      paramInt = i;
      if (this.nUB != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.nUB);
      }
      i = paramInt + i.a.a.b.b.a.cJ(5, this.abAu);
      paramInt = i;
      if (this.accH != null) {
        paramInt = i + i.a.a.b.b.a.c(6, this.accH);
      }
      i = i.a.a.b.b.a.ko(7);
      int j = i.a.a.b.b.a.ko(8);
      int k = i.a.a.b.b.a.ko(9);
      AppMethodBeat.o(32545);
      return paramInt + (i + 1) + (j + 1) + (k + 1);
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      if (this.abvu == null)
      {
        paramVarArgs = new i.a.a.b("Not all required fields were included: Talker");
        AppMethodBeat.o(32545);
        throw paramVarArgs;
      }
      if (this.hAP == null)
      {
        paramVarArgs = new i.a.a.b("Not all required fields were included: Title");
        AppMethodBeat.o(32545);
        throw paramVarArgs;
      }
      if (this.nUB == null)
      {
        paramVarArgs = new i.a.a.b("Not all required fields were included: Content");
        AppMethodBeat.o(32545);
        throw paramVarArgs;
      }
      AppMethodBeat.o(32545);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      ggi localggi = (ggi)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(32545);
        return -1;
      case 1: 
        localggi.IMf = locala.ajGk.aar();
        AppMethodBeat.o(32545);
        return 0;
      case 2: 
        localggi.abvu = locala.ajGk.readString();
        AppMethodBeat.o(32545);
        return 0;
      case 3: 
        localggi.hAP = locala.ajGk.readString();
        AppMethodBeat.o(32545);
        return 0;
      case 4: 
        localggi.nUB = locala.ajGk.readString();
        AppMethodBeat.o(32545);
        return 0;
      case 5: 
        localggi.abAu = locala.ajGk.aar();
        AppMethodBeat.o(32545);
        return 0;
      case 6: 
        localggi.accH = locala.ajGk.kFX();
        AppMethodBeat.o(32545);
        return 0;
      case 7: 
        localggi.accY = locala.ajGk.aai();
        AppMethodBeat.o(32545);
        return 0;
      case 8: 
        localggi.accZ = locala.ajGk.aai();
        AppMethodBeat.o(32545);
        return 0;
      }
      localggi.acda = locala.ajGk.aai();
      AppMethodBeat.o(32545);
      return 0;
    }
    AppMethodBeat.o(32545);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ggi
 * JD-Core Version:    0.7.0.1
 */