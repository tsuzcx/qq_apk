package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;

public final class bwk
  extends com.tencent.mm.bw.a
{
  public String Ajr;
  public int Ajt;
  public int Ajv;
  public String GGA;
  public float GgZ;
  public float Gha;
  public String Hjq;
  public int Hjr;
  public int Hjs;
  public b Hjt;
  public String Hju;
  public float bYG;
  public String country;
  public String jGd;
  public String jfX;
  public int score;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125739);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.y(1, this.GgZ);
      paramVarArgs.y(2, this.Gha);
      if (this.jfX != null) {
        paramVarArgs.d(3, this.jfX);
      }
      if (this.jGd != null) {
        paramVarArgs.d(4, this.jGd);
      }
      if (this.Ajr != null) {
        paramVarArgs.d(5, this.Ajr);
      }
      if (this.GGA != null) {
        paramVarArgs.d(6, this.GGA);
      }
      paramVarArgs.aS(7, this.Ajt);
      if (this.Hjq != null) {
        paramVarArgs.d(8, this.Hjq);
      }
      paramVarArgs.aS(9, this.Hjr);
      paramVarArgs.aS(10, this.Hjs);
      paramVarArgs.aS(11, this.Ajv);
      paramVarArgs.y(12, this.bYG);
      if (this.Hjt != null) {
        paramVarArgs.c(13, this.Hjt);
      }
      paramVarArgs.aS(14, this.score);
      if (this.Hju != null) {
        paramVarArgs.d(15, this.Hju);
      }
      if (this.country != null) {
        paramVarArgs.d(16, this.country);
      }
      AppMethodBeat.o(125739);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.amE(1) + 0 + f.a.a.b.b.a.amE(2);
      paramInt = i;
      if (this.jfX != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.jfX);
      }
      i = paramInt;
      if (this.jGd != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.jGd);
      }
      paramInt = i;
      if (this.Ajr != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.Ajr);
      }
      i = paramInt;
      if (this.GGA != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.GGA);
      }
      i += f.a.a.b.b.a.bz(7, this.Ajt);
      paramInt = i;
      if (this.Hjq != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.Hjq);
      }
      i = paramInt + f.a.a.b.b.a.bz(9, this.Hjr) + f.a.a.b.b.a.bz(10, this.Hjs) + f.a.a.b.b.a.bz(11, this.Ajv) + f.a.a.b.b.a.amE(12);
      paramInt = i;
      if (this.Hjt != null) {
        paramInt = i + f.a.a.b.b.a.b(13, this.Hjt);
      }
      i = paramInt + f.a.a.b.b.a.bz(14, this.score);
      paramInt = i;
      if (this.Hju != null) {
        paramInt = i + f.a.a.b.b.a.e(15, this.Hju);
      }
      i = paramInt;
      if (this.country != null) {
        i = paramInt + f.a.a.b.b.a.e(16, this.country);
      }
      AppMethodBeat.o(125739);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(125739);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      bwk localbwk = (bwk)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(125739);
        return -1;
      case 1: 
        localbwk.GgZ = Float.intBitsToFloat(locala.OmT.gwb());
        AppMethodBeat.o(125739);
        return 0;
      case 2: 
        localbwk.Gha = Float.intBitsToFloat(locala.OmT.gwb());
        AppMethodBeat.o(125739);
        return 0;
      case 3: 
        localbwk.jfX = locala.OmT.readString();
        AppMethodBeat.o(125739);
        return 0;
      case 4: 
        localbwk.jGd = locala.OmT.readString();
        AppMethodBeat.o(125739);
        return 0;
      case 5: 
        localbwk.Ajr = locala.OmT.readString();
        AppMethodBeat.o(125739);
        return 0;
      case 6: 
        localbwk.GGA = locala.OmT.readString();
        AppMethodBeat.o(125739);
        return 0;
      case 7: 
        localbwk.Ajt = locala.OmT.zc();
        AppMethodBeat.o(125739);
        return 0;
      case 8: 
        localbwk.Hjq = locala.OmT.readString();
        AppMethodBeat.o(125739);
        return 0;
      case 9: 
        localbwk.Hjr = locala.OmT.zc();
        AppMethodBeat.o(125739);
        return 0;
      case 10: 
        localbwk.Hjs = locala.OmT.zc();
        AppMethodBeat.o(125739);
        return 0;
      case 11: 
        localbwk.Ajv = locala.OmT.zc();
        AppMethodBeat.o(125739);
        return 0;
      case 12: 
        localbwk.bYG = Float.intBitsToFloat(locala.OmT.gwb());
        AppMethodBeat.o(125739);
        return 0;
      case 13: 
        localbwk.Hjt = locala.OmT.gCk();
        AppMethodBeat.o(125739);
        return 0;
      case 14: 
        localbwk.score = locala.OmT.zc();
        AppMethodBeat.o(125739);
        return 0;
      case 15: 
        localbwk.Hju = locala.OmT.readString();
        AppMethodBeat.o(125739);
        return 0;
      }
      localbwk.country = locala.OmT.readString();
      AppMethodBeat.o(125739);
      return 0;
    }
    AppMethodBeat.o(125739);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bwk
 * JD-Core Version:    0.7.0.1
 */