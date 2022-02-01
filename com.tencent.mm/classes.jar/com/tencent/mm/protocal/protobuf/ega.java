package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ega
  extends com.tencent.mm.bw.a
{
  public int CreateTime;
  public int KHa;
  public String KSh;
  public String KSj;
  public String KSl;
  public String KSm;
  public String KSn;
  public String KSu;
  public int KSv;
  public int KSw;
  public int KSx;
  public long KWq;
  public String KWt;
  public int KWu;
  public String Title;
  public int iAb;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124558);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.KHa);
      if (this.Title != null) {
        paramVarArgs.e(2, this.Title);
      }
      if (this.KSh != null) {
        paramVarArgs.e(3, this.KSh);
      }
      if (this.KSj != null) {
        paramVarArgs.e(6, this.KSj);
      }
      if (this.KSl != null) {
        paramVarArgs.e(8, this.KSl);
      }
      if (this.KSm != null) {
        paramVarArgs.e(9, this.KSm);
      }
      if (this.KSn != null) {
        paramVarArgs.e(10, this.KSn);
      }
      paramVarArgs.aM(11, this.iAb);
      if (this.KSu != null) {
        paramVarArgs.e(15, this.KSu);
      }
      paramVarArgs.aM(16, this.KSv);
      paramVarArgs.aM(17, this.KSw);
      paramVarArgs.aM(18, this.KSx);
      paramVarArgs.aM(19, this.CreateTime);
      paramVarArgs.bb(20, this.KWq);
      if (this.KWt != null) {
        paramVarArgs.e(21, this.KWt);
      }
      paramVarArgs.aM(22, this.KWu);
      AppMethodBeat.o(124558);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bu(1, this.KHa) + 0;
      paramInt = i;
      if (this.Title != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.Title);
      }
      i = paramInt;
      if (this.KSh != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.KSh);
      }
      paramInt = i;
      if (this.KSj != null) {
        paramInt = i + g.a.a.b.b.a.f(6, this.KSj);
      }
      i = paramInt;
      if (this.KSl != null) {
        i = paramInt + g.a.a.b.b.a.f(8, this.KSl);
      }
      paramInt = i;
      if (this.KSm != null) {
        paramInt = i + g.a.a.b.b.a.f(9, this.KSm);
      }
      i = paramInt;
      if (this.KSn != null) {
        i = paramInt + g.a.a.b.b.a.f(10, this.KSn);
      }
      i += g.a.a.b.b.a.bu(11, this.iAb);
      paramInt = i;
      if (this.KSu != null) {
        paramInt = i + g.a.a.b.b.a.f(15, this.KSu);
      }
      i = paramInt + g.a.a.b.b.a.bu(16, this.KSv) + g.a.a.b.b.a.bu(17, this.KSw) + g.a.a.b.b.a.bu(18, this.KSx) + g.a.a.b.b.a.bu(19, this.CreateTime) + g.a.a.b.b.a.r(20, this.KWq);
      paramInt = i;
      if (this.KWt != null) {
        paramInt = i + g.a.a.b.b.a.f(21, this.KWt);
      }
      i = g.a.a.b.b.a.bu(22, this.KWu);
      AppMethodBeat.o(124558);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(124558);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      ega localega = (ega)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      case 4: 
      case 5: 
      case 7: 
      case 12: 
      case 13: 
      case 14: 
      default: 
        AppMethodBeat.o(124558);
        return -1;
      case 1: 
        localega.KHa = locala.UbS.zi();
        AppMethodBeat.o(124558);
        return 0;
      case 2: 
        localega.Title = locala.UbS.readString();
        AppMethodBeat.o(124558);
        return 0;
      case 3: 
        localega.KSh = locala.UbS.readString();
        AppMethodBeat.o(124558);
        return 0;
      case 6: 
        localega.KSj = locala.UbS.readString();
        AppMethodBeat.o(124558);
        return 0;
      case 8: 
        localega.KSl = locala.UbS.readString();
        AppMethodBeat.o(124558);
        return 0;
      case 9: 
        localega.KSm = locala.UbS.readString();
        AppMethodBeat.o(124558);
        return 0;
      case 10: 
        localega.KSn = locala.UbS.readString();
        AppMethodBeat.o(124558);
        return 0;
      case 11: 
        localega.iAb = locala.UbS.zi();
        AppMethodBeat.o(124558);
        return 0;
      case 15: 
        localega.KSu = locala.UbS.readString();
        AppMethodBeat.o(124558);
        return 0;
      case 16: 
        localega.KSv = locala.UbS.zi();
        AppMethodBeat.o(124558);
        return 0;
      case 17: 
        localega.KSw = locala.UbS.zi();
        AppMethodBeat.o(124558);
        return 0;
      case 18: 
        localega.KSx = locala.UbS.zi();
        AppMethodBeat.o(124558);
        return 0;
      case 19: 
        localega.CreateTime = locala.UbS.zi();
        AppMethodBeat.o(124558);
        return 0;
      case 20: 
        localega.KWq = locala.UbS.zl();
        AppMethodBeat.o(124558);
        return 0;
      case 21: 
        localega.KWt = locala.UbS.readString();
        AppMethodBeat.o(124558);
        return 0;
      }
      localega.KWu = locala.UbS.zi();
      AppMethodBeat.o(124558);
      return 0;
    }
    AppMethodBeat.o(124558);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ega
 * JD-Core Version:    0.7.0.1
 */