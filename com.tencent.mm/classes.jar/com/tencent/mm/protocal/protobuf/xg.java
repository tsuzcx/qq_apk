package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class xg
  extends com.tencent.mm.cd.a
{
  public String RGZ;
  public int Sjm;
  public String Sjn;
  public int Sjo;
  public String Sjp;
  public int Sjq;
  public String Sjr;
  public String Sjs;
  public String Sjt;
  public String Sju;
  public int Sjv;
  public String Sjw;
  public String ufB;
  public String ufC;
  public int ufu;
  public String ufv;
  public String ugo;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125715);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.Sjm);
      if (this.ugo != null) {
        paramVarArgs.f(2, this.ugo);
      }
      if (this.Sjn != null) {
        paramVarArgs.f(3, this.Sjn);
      }
      if (this.ufB != null) {
        paramVarArgs.f(4, this.ufB);
      }
      paramVarArgs.aY(5, this.Sjo);
      if (this.Sjp != null) {
        paramVarArgs.f(6, this.Sjp);
      }
      paramVarArgs.aY(7, this.Sjq);
      if (this.ufC != null) {
        paramVarArgs.f(8, this.ufC);
      }
      if (this.RGZ != null) {
        paramVarArgs.f(9, this.RGZ);
      }
      paramVarArgs.aY(10, this.ufu);
      if (this.ufv != null) {
        paramVarArgs.f(11, this.ufv);
      }
      if (this.Sjr != null) {
        paramVarArgs.f(12, this.Sjr);
      }
      if (this.Sjs != null) {
        paramVarArgs.f(13, this.Sjs);
      }
      if (this.Sjt != null) {
        paramVarArgs.f(14, this.Sjt);
      }
      if (this.Sju != null) {
        paramVarArgs.f(15, this.Sju);
      }
      paramVarArgs.aY(16, this.Sjv);
      if (this.Sjw != null) {
        paramVarArgs.f(17, this.Sjw);
      }
      AppMethodBeat.o(125715);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bM(1, this.Sjm) + 0;
      paramInt = i;
      if (this.ugo != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.ugo);
      }
      i = paramInt;
      if (this.Sjn != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.Sjn);
      }
      paramInt = i;
      if (this.ufB != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.ufB);
      }
      i = paramInt + g.a.a.b.b.a.bM(5, this.Sjo);
      paramInt = i;
      if (this.Sjp != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.Sjp);
      }
      i = paramInt + g.a.a.b.b.a.bM(7, this.Sjq);
      paramInt = i;
      if (this.ufC != null) {
        paramInt = i + g.a.a.b.b.a.g(8, this.ufC);
      }
      i = paramInt;
      if (this.RGZ != null) {
        i = paramInt + g.a.a.b.b.a.g(9, this.RGZ);
      }
      i += g.a.a.b.b.a.bM(10, this.ufu);
      paramInt = i;
      if (this.ufv != null) {
        paramInt = i + g.a.a.b.b.a.g(11, this.ufv);
      }
      i = paramInt;
      if (this.Sjr != null) {
        i = paramInt + g.a.a.b.b.a.g(12, this.Sjr);
      }
      paramInt = i;
      if (this.Sjs != null) {
        paramInt = i + g.a.a.b.b.a.g(13, this.Sjs);
      }
      i = paramInt;
      if (this.Sjt != null) {
        i = paramInt + g.a.a.b.b.a.g(14, this.Sjt);
      }
      paramInt = i;
      if (this.Sju != null) {
        paramInt = i + g.a.a.b.b.a.g(15, this.Sju);
      }
      i = paramInt + g.a.a.b.b.a.bM(16, this.Sjv);
      paramInt = i;
      if (this.Sjw != null) {
        paramInt = i + g.a.a.b.b.a.g(17, this.Sjw);
      }
      AppMethodBeat.o(125715);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(125715);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      xg localxg = (xg)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(125715);
        return -1;
      case 1: 
        localxg.Sjm = locala.abFh.AK();
        AppMethodBeat.o(125715);
        return 0;
      case 2: 
        localxg.ugo = locala.abFh.readString();
        AppMethodBeat.o(125715);
        return 0;
      case 3: 
        localxg.Sjn = locala.abFh.readString();
        AppMethodBeat.o(125715);
        return 0;
      case 4: 
        localxg.ufB = locala.abFh.readString();
        AppMethodBeat.o(125715);
        return 0;
      case 5: 
        localxg.Sjo = locala.abFh.AK();
        AppMethodBeat.o(125715);
        return 0;
      case 6: 
        localxg.Sjp = locala.abFh.readString();
        AppMethodBeat.o(125715);
        return 0;
      case 7: 
        localxg.Sjq = locala.abFh.AK();
        AppMethodBeat.o(125715);
        return 0;
      case 8: 
        localxg.ufC = locala.abFh.readString();
        AppMethodBeat.o(125715);
        return 0;
      case 9: 
        localxg.RGZ = locala.abFh.readString();
        AppMethodBeat.o(125715);
        return 0;
      case 10: 
        localxg.ufu = locala.abFh.AK();
        AppMethodBeat.o(125715);
        return 0;
      case 11: 
        localxg.ufv = locala.abFh.readString();
        AppMethodBeat.o(125715);
        return 0;
      case 12: 
        localxg.Sjr = locala.abFh.readString();
        AppMethodBeat.o(125715);
        return 0;
      case 13: 
        localxg.Sjs = locala.abFh.readString();
        AppMethodBeat.o(125715);
        return 0;
      case 14: 
        localxg.Sjt = locala.abFh.readString();
        AppMethodBeat.o(125715);
        return 0;
      case 15: 
        localxg.Sju = locala.abFh.readString();
        AppMethodBeat.o(125715);
        return 0;
      case 16: 
        localxg.Sjv = locala.abFh.AK();
        AppMethodBeat.o(125715);
        return 0;
      }
      localxg.Sjw = locala.abFh.readString();
      AppMethodBeat.o(125715);
      return 0;
    }
    AppMethodBeat.o(125715);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.xg
 * JD-Core Version:    0.7.0.1
 */