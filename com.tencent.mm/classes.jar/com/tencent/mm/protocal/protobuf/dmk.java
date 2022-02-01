package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dmk
  extends com.tencent.mm.bx.a
{
  public int AcJ;
  public int aaSt;
  public int aaSu;
  public int aaSv;
  public int aaSw;
  public boolean aaSx;
  public long hKN;
  public int scene;
  public String sessionBuffer;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(184214);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bv(1, this.hKN);
      paramVarArgs.bS(2, this.scene);
      paramVarArgs.bS(3, this.AcJ);
      paramVarArgs.bS(4, this.aaSt);
      if (this.sessionBuffer != null) {
        paramVarArgs.g(5, this.sessionBuffer);
      }
      paramVarArgs.bS(6, this.aaSu);
      paramVarArgs.bS(7, this.aaSv);
      paramVarArgs.bS(8, this.aaSw);
      paramVarArgs.di(9, this.aaSx);
      AppMethodBeat.o(184214);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.q(1, this.hKN) + 0 + i.a.a.b.b.a.cJ(2, this.scene) + i.a.a.b.b.a.cJ(3, this.AcJ) + i.a.a.b.b.a.cJ(4, this.aaSt);
      paramInt = i;
      if (this.sessionBuffer != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.sessionBuffer);
      }
      i = i.a.a.b.b.a.cJ(6, this.aaSu);
      int j = i.a.a.b.b.a.cJ(7, this.aaSv);
      int k = i.a.a.b.b.a.cJ(8, this.aaSw);
      int m = i.a.a.b.b.a.ko(9);
      AppMethodBeat.o(184214);
      return paramInt + i + j + k + (m + 1);
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(184214);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      dmk localdmk = (dmk)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(184214);
        return -1;
      case 1: 
        localdmk.hKN = locala.ajGk.aaw();
        AppMethodBeat.o(184214);
        return 0;
      case 2: 
        localdmk.scene = locala.ajGk.aar();
        AppMethodBeat.o(184214);
        return 0;
      case 3: 
        localdmk.AcJ = locala.ajGk.aar();
        AppMethodBeat.o(184214);
        return 0;
      case 4: 
        localdmk.aaSt = locala.ajGk.aar();
        AppMethodBeat.o(184214);
        return 0;
      case 5: 
        localdmk.sessionBuffer = locala.ajGk.readString();
        AppMethodBeat.o(184214);
        return 0;
      case 6: 
        localdmk.aaSu = locala.ajGk.aar();
        AppMethodBeat.o(184214);
        return 0;
      case 7: 
        localdmk.aaSv = locala.ajGk.aar();
        AppMethodBeat.o(184214);
        return 0;
      case 8: 
        localdmk.aaSw = locala.ajGk.aar();
        AppMethodBeat.o(184214);
        return 0;
      }
      localdmk.aaSx = locala.ajGk.aai();
      AppMethodBeat.o(184214);
      return 0;
    }
    AppMethodBeat.o(184214);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dmk
 * JD-Core Version:    0.7.0.1
 */