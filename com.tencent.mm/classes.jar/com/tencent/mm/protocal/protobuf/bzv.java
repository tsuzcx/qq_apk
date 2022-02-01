package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bzv
  extends com.tencent.mm.bx.a
{
  public String KrU;
  public String KtF;
  public String KtG;
  public long Kth;
  public String Kti;
  public int state;
  public String userName;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(257563);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bv(1, this.Kth);
      if (this.Kti != null) {
        paramVarArgs.g(2, this.Kti);
      }
      if (this.KrU != null) {
        paramVarArgs.g(3, this.KrU);
      }
      paramVarArgs.bS(4, this.state);
      if (this.KtF != null) {
        paramVarArgs.g(5, this.KtF);
      }
      if (this.userName != null) {
        paramVarArgs.g(6, this.userName);
      }
      if (this.KtG != null) {
        paramVarArgs.g(7, this.KtG);
      }
      AppMethodBeat.o(257563);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.q(1, this.Kth) + 0;
      paramInt = i;
      if (this.Kti != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.Kti);
      }
      i = paramInt;
      if (this.KrU != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.KrU);
      }
      i += i.a.a.b.b.a.cJ(4, this.state);
      paramInt = i;
      if (this.KtF != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.KtF);
      }
      i = paramInt;
      if (this.userName != null) {
        i = paramInt + i.a.a.b.b.a.h(6, this.userName);
      }
      paramInt = i;
      if (this.KtG != null) {
        paramInt = i + i.a.a.b.b.a.h(7, this.KtG);
      }
      AppMethodBeat.o(257563);
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
      AppMethodBeat.o(257563);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      bzv localbzv = (bzv)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(257563);
        return -1;
      case 1: 
        localbzv.Kth = locala.ajGk.aaw();
        AppMethodBeat.o(257563);
        return 0;
      case 2: 
        localbzv.Kti = locala.ajGk.readString();
        AppMethodBeat.o(257563);
        return 0;
      case 3: 
        localbzv.KrU = locala.ajGk.readString();
        AppMethodBeat.o(257563);
        return 0;
      case 4: 
        localbzv.state = locala.ajGk.aar();
        AppMethodBeat.o(257563);
        return 0;
      case 5: 
        localbzv.KtF = locala.ajGk.readString();
        AppMethodBeat.o(257563);
        return 0;
      case 6: 
        localbzv.userName = locala.ajGk.readString();
        AppMethodBeat.o(257563);
        return 0;
      }
      localbzv.KtG = locala.ajGk.readString();
      AppMethodBeat.o(257563);
      return 0;
    }
    AppMethodBeat.o(257563);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bzv
 * JD-Core Version:    0.7.0.1
 */