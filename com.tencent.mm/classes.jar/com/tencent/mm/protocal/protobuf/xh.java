package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class xh
  extends com.tencent.mm.bw.a
{
  public String LiA;
  public String LiB;
  public int LiC;
  public String LiD;
  public String LiE;
  public String LiF;
  public String Liq;
  public String Lir;
  public String Lis;
  public int Lit;
  public String Liu;
  public String Liv;
  public String Liw;
  public String Lix;
  public String Liy;
  public String Liz;
  public String UserName;
  public String oUJ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(43087);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.UserName != null) {
        paramVarArgs.e(1, this.UserName);
      }
      if (this.oUJ != null) {
        paramVarArgs.e(2, this.oUJ);
      }
      if (this.Liq != null) {
        paramVarArgs.e(3, this.Liq);
      }
      if (this.Lir != null) {
        paramVarArgs.e(4, this.Lir);
      }
      if (this.Lis != null) {
        paramVarArgs.e(5, this.Lis);
      }
      paramVarArgs.aM(6, this.Lit);
      if (this.Liu != null) {
        paramVarArgs.e(7, this.Liu);
      }
      if (this.Liv != null) {
        paramVarArgs.e(9, this.Liv);
      }
      if (this.Liw != null) {
        paramVarArgs.e(10, this.Liw);
      }
      if (this.Lix != null) {
        paramVarArgs.e(11, this.Lix);
      }
      if (this.Liy != null) {
        paramVarArgs.e(12, this.Liy);
      }
      if (this.Liz != null) {
        paramVarArgs.e(13, this.Liz);
      }
      if (this.LiA != null) {
        paramVarArgs.e(14, this.LiA);
      }
      if (this.LiB != null) {
        paramVarArgs.e(15, this.LiB);
      }
      paramVarArgs.aM(16, this.LiC);
      if (this.LiD != null) {
        paramVarArgs.e(17, this.LiD);
      }
      if (this.LiE != null) {
        paramVarArgs.e(18, this.LiE);
      }
      if (this.LiF != null) {
        paramVarArgs.e(19, this.LiF);
      }
      AppMethodBeat.o(43087);
      return 0;
    }
    if (paramInt == 1) {
      if (this.UserName == null) {
        break label1234;
      }
    }
    label1234:
    for (int i = g.a.a.b.b.a.f(1, this.UserName) + 0;; i = 0)
    {
      paramInt = i;
      if (this.oUJ != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.oUJ);
      }
      i = paramInt;
      if (this.Liq != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.Liq);
      }
      paramInt = i;
      if (this.Lir != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.Lir);
      }
      i = paramInt;
      if (this.Lis != null) {
        i = paramInt + g.a.a.b.b.a.f(5, this.Lis);
      }
      i += g.a.a.b.b.a.bu(6, this.Lit);
      paramInt = i;
      if (this.Liu != null) {
        paramInt = i + g.a.a.b.b.a.f(7, this.Liu);
      }
      i = paramInt;
      if (this.Liv != null) {
        i = paramInt + g.a.a.b.b.a.f(9, this.Liv);
      }
      paramInt = i;
      if (this.Liw != null) {
        paramInt = i + g.a.a.b.b.a.f(10, this.Liw);
      }
      i = paramInt;
      if (this.Lix != null) {
        i = paramInt + g.a.a.b.b.a.f(11, this.Lix);
      }
      paramInt = i;
      if (this.Liy != null) {
        paramInt = i + g.a.a.b.b.a.f(12, this.Liy);
      }
      i = paramInt;
      if (this.Liz != null) {
        i = paramInt + g.a.a.b.b.a.f(13, this.Liz);
      }
      paramInt = i;
      if (this.LiA != null) {
        paramInt = i + g.a.a.b.b.a.f(14, this.LiA);
      }
      i = paramInt;
      if (this.LiB != null) {
        i = paramInt + g.a.a.b.b.a.f(15, this.LiB);
      }
      i += g.a.a.b.b.a.bu(16, this.LiC);
      paramInt = i;
      if (this.LiD != null) {
        paramInt = i + g.a.a.b.b.a.f(17, this.LiD);
      }
      i = paramInt;
      if (this.LiE != null) {
        i = paramInt + g.a.a.b.b.a.f(18, this.LiE);
      }
      paramInt = i;
      if (this.LiF != null) {
        paramInt = i + g.a.a.b.b.a.f(19, this.LiF);
      }
      AppMethodBeat.o(43087);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(43087);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        xh localxh = (xh)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        case 8: 
        default: 
          AppMethodBeat.o(43087);
          return -1;
        case 1: 
          localxh.UserName = locala.UbS.readString();
          AppMethodBeat.o(43087);
          return 0;
        case 2: 
          localxh.oUJ = locala.UbS.readString();
          AppMethodBeat.o(43087);
          return 0;
        case 3: 
          localxh.Liq = locala.UbS.readString();
          AppMethodBeat.o(43087);
          return 0;
        case 4: 
          localxh.Lir = locala.UbS.readString();
          AppMethodBeat.o(43087);
          return 0;
        case 5: 
          localxh.Lis = locala.UbS.readString();
          AppMethodBeat.o(43087);
          return 0;
        case 6: 
          localxh.Lit = locala.UbS.zi();
          AppMethodBeat.o(43087);
          return 0;
        case 7: 
          localxh.Liu = locala.UbS.readString();
          AppMethodBeat.o(43087);
          return 0;
        case 9: 
          localxh.Liv = locala.UbS.readString();
          AppMethodBeat.o(43087);
          return 0;
        case 10: 
          localxh.Liw = locala.UbS.readString();
          AppMethodBeat.o(43087);
          return 0;
        case 11: 
          localxh.Lix = locala.UbS.readString();
          AppMethodBeat.o(43087);
          return 0;
        case 12: 
          localxh.Liy = locala.UbS.readString();
          AppMethodBeat.o(43087);
          return 0;
        case 13: 
          localxh.Liz = locala.UbS.readString();
          AppMethodBeat.o(43087);
          return 0;
        case 14: 
          localxh.LiA = locala.UbS.readString();
          AppMethodBeat.o(43087);
          return 0;
        case 15: 
          localxh.LiB = locala.UbS.readString();
          AppMethodBeat.o(43087);
          return 0;
        case 16: 
          localxh.LiC = locala.UbS.zi();
          AppMethodBeat.o(43087);
          return 0;
        case 17: 
          localxh.LiD = locala.UbS.readString();
          AppMethodBeat.o(43087);
          return 0;
        case 18: 
          localxh.LiE = locala.UbS.readString();
          AppMethodBeat.o(43087);
          return 0;
        }
        localxh.LiF = locala.UbS.readString();
        AppMethodBeat.o(43087);
        return 0;
      }
      AppMethodBeat.o(43087);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.xh
 * JD-Core Version:    0.7.0.1
 */