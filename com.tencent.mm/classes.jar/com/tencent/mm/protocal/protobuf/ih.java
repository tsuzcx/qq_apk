package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ih
  extends com.tencent.mm.bw.a
{
  public String KGX;
  public int KMt;
  public String KMu;
  public String KMv;
  public String UserName;
  public String keb;
  public String oUJ;
  public int wSO;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32127);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.KGX != null) {
        paramVarArgs.e(1, this.KGX);
      }
      if (this.oUJ != null) {
        paramVarArgs.e(2, this.oUJ);
      }
      if (this.UserName != null) {
        paramVarArgs.e(3, this.UserName);
      }
      paramVarArgs.aM(4, this.KMt);
      if (this.KMu != null) {
        paramVarArgs.e(5, this.KMu);
      }
      if (this.keb != null) {
        paramVarArgs.e(6, this.keb);
      }
      if (this.KMv != null) {
        paramVarArgs.e(7, this.KMv);
      }
      paramVarArgs.aM(8, this.wSO);
      AppMethodBeat.o(32127);
      return 0;
    }
    if (paramInt == 1) {
      if (this.KGX == null) {
        break label624;
      }
    }
    label624:
    for (int i = g.a.a.b.b.a.f(1, this.KGX) + 0;; i = 0)
    {
      paramInt = i;
      if (this.oUJ != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.oUJ);
      }
      i = paramInt;
      if (this.UserName != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.UserName);
      }
      i += g.a.a.b.b.a.bu(4, this.KMt);
      paramInt = i;
      if (this.KMu != null) {
        paramInt = i + g.a.a.b.b.a.f(5, this.KMu);
      }
      i = paramInt;
      if (this.keb != null) {
        i = paramInt + g.a.a.b.b.a.f(6, this.keb);
      }
      paramInt = i;
      if (this.KMv != null) {
        paramInt = i + g.a.a.b.b.a.f(7, this.KMv);
      }
      i = g.a.a.b.b.a.bu(8, this.wSO);
      AppMethodBeat.o(32127);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(32127);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        ih localih = (ih)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(32127);
          return -1;
        case 1: 
          localih.KGX = locala.UbS.readString();
          AppMethodBeat.o(32127);
          return 0;
        case 2: 
          localih.oUJ = locala.UbS.readString();
          AppMethodBeat.o(32127);
          return 0;
        case 3: 
          localih.UserName = locala.UbS.readString();
          AppMethodBeat.o(32127);
          return 0;
        case 4: 
          localih.KMt = locala.UbS.zi();
          AppMethodBeat.o(32127);
          return 0;
        case 5: 
          localih.KMu = locala.UbS.readString();
          AppMethodBeat.o(32127);
          return 0;
        case 6: 
          localih.keb = locala.UbS.readString();
          AppMethodBeat.o(32127);
          return 0;
        case 7: 
          localih.KMv = locala.UbS.readString();
          AppMethodBeat.o(32127);
          return 0;
        }
        localih.wSO = locala.UbS.zi();
        AppMethodBeat.o(32127);
        return 0;
      }
      AppMethodBeat.o(32127);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ih
 * JD-Core Version:    0.7.0.1
 */