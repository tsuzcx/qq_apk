package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dix
  extends com.tencent.mm.bx.a
{
  public int CreateTime;
  public int HtG;
  public int HtH;
  public int HtL;
  public String HxL;
  public String HxM;
  public int HxN;
  public int HxO;
  public int HxP;
  public long Id;
  public int IsNotRichText;
  public String ThumbUrl;
  public String hDa;
  public String uki;
  public String ukj;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(118438);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.Id);
      if (this.ukj != null) {
        paramVarArgs.d(2, this.ukj);
      }
      if (this.uki != null) {
        paramVarArgs.d(3, this.uki);
      }
      if (this.HxL != null) {
        paramVarArgs.d(4, this.HxL);
      }
      if (this.HxM != null) {
        paramVarArgs.d(5, this.HxM);
      }
      paramVarArgs.aS(6, this.CreateTime);
      if (this.hDa != null) {
        paramVarArgs.d(7, this.hDa);
      }
      paramVarArgs.aS(8, this.HxN);
      paramVarArgs.aS(9, this.HtL);
      paramVarArgs.aS(10, this.HtG);
      paramVarArgs.aS(11, this.HtH);
      paramVarArgs.aS(12, this.IsNotRichText);
      if (this.ThumbUrl != null) {
        paramVarArgs.d(13, this.ThumbUrl);
      }
      paramVarArgs.aS(14, this.HxO);
      paramVarArgs.aS(15, this.HxP);
      AppMethodBeat.o(118438);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.p(1, this.Id) + 0;
      paramInt = i;
      if (this.ukj != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.ukj);
      }
      i = paramInt;
      if (this.uki != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.uki);
      }
      paramInt = i;
      if (this.HxL != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.HxL);
      }
      i = paramInt;
      if (this.HxM != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.HxM);
      }
      i += f.a.a.b.b.a.bz(6, this.CreateTime);
      paramInt = i;
      if (this.hDa != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.hDa);
      }
      i = paramInt + f.a.a.b.b.a.bz(8, this.HxN) + f.a.a.b.b.a.bz(9, this.HtL) + f.a.a.b.b.a.bz(10, this.HtG) + f.a.a.b.b.a.bz(11, this.HtH) + f.a.a.b.b.a.bz(12, this.IsNotRichText);
      paramInt = i;
      if (this.ThumbUrl != null) {
        paramInt = i + f.a.a.b.b.a.e(13, this.ThumbUrl);
      }
      i = f.a.a.b.b.a.bz(14, this.HxO);
      int j = f.a.a.b.b.a.bz(15, this.HxP);
      AppMethodBeat.o(118438);
      return paramInt + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(118438);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      dix localdix = (dix)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(118438);
        return -1;
      case 1: 
        localdix.Id = locala.NPN.zd();
        AppMethodBeat.o(118438);
        return 0;
      case 2: 
        localdix.ukj = locala.NPN.readString();
        AppMethodBeat.o(118438);
        return 0;
      case 3: 
        localdix.uki = locala.NPN.readString();
        AppMethodBeat.o(118438);
        return 0;
      case 4: 
        localdix.HxL = locala.NPN.readString();
        AppMethodBeat.o(118438);
        return 0;
      case 5: 
        localdix.HxM = locala.NPN.readString();
        AppMethodBeat.o(118438);
        return 0;
      case 6: 
        localdix.CreateTime = locala.NPN.zc();
        AppMethodBeat.o(118438);
        return 0;
      case 7: 
        localdix.hDa = locala.NPN.readString();
        AppMethodBeat.o(118438);
        return 0;
      case 8: 
        localdix.HxN = locala.NPN.zc();
        AppMethodBeat.o(118438);
        return 0;
      case 9: 
        localdix.HtL = locala.NPN.zc();
        AppMethodBeat.o(118438);
        return 0;
      case 10: 
        localdix.HtG = locala.NPN.zc();
        AppMethodBeat.o(118438);
        return 0;
      case 11: 
        localdix.HtH = locala.NPN.zc();
        AppMethodBeat.o(118438);
        return 0;
      case 12: 
        localdix.IsNotRichText = locala.NPN.zc();
        AppMethodBeat.o(118438);
        return 0;
      case 13: 
        localdix.ThumbUrl = locala.NPN.readString();
        AppMethodBeat.o(118438);
        return 0;
      case 14: 
        localdix.HxO = locala.NPN.zc();
        AppMethodBeat.o(118438);
        return 0;
      }
      localdix.HxP = locala.NPN.zc();
      AppMethodBeat.o(118438);
      return 0;
    }
    AppMethodBeat.o(118438);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dix
 * JD-Core Version:    0.7.0.1
 */