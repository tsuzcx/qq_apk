package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cxy
  extends com.tencent.mm.bx.a
{
  public int CreateTime;
  public int ElZ;
  public int Ema;
  public int Eme;
  public String EpY;
  public String EpZ;
  public int Eqa;
  public int Eqb;
  public int Eqc;
  public long Id;
  public int IsNotRichText;
  public String ThumbUrl;
  public String gKr;
  public String sdP;
  public String sdQ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(118438);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aG(1, this.Id);
      if (this.sdQ != null) {
        paramVarArgs.d(2, this.sdQ);
      }
      if (this.sdP != null) {
        paramVarArgs.d(3, this.sdP);
      }
      if (this.EpY != null) {
        paramVarArgs.d(4, this.EpY);
      }
      if (this.EpZ != null) {
        paramVarArgs.d(5, this.EpZ);
      }
      paramVarArgs.aR(6, this.CreateTime);
      if (this.gKr != null) {
        paramVarArgs.d(7, this.gKr);
      }
      paramVarArgs.aR(8, this.Eqa);
      paramVarArgs.aR(9, this.Eme);
      paramVarArgs.aR(10, this.ElZ);
      paramVarArgs.aR(11, this.Ema);
      paramVarArgs.aR(12, this.IsNotRichText);
      if (this.ThumbUrl != null) {
        paramVarArgs.d(13, this.ThumbUrl);
      }
      paramVarArgs.aR(14, this.Eqb);
      paramVarArgs.aR(15, this.Eqc);
      AppMethodBeat.o(118438);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.q(1, this.Id) + 0;
      paramInt = i;
      if (this.sdQ != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.sdQ);
      }
      i = paramInt;
      if (this.sdP != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.sdP);
      }
      paramInt = i;
      if (this.EpY != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.EpY);
      }
      i = paramInt;
      if (this.EpZ != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.EpZ);
      }
      i += f.a.a.b.b.a.bA(6, this.CreateTime);
      paramInt = i;
      if (this.gKr != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.gKr);
      }
      i = paramInt + f.a.a.b.b.a.bA(8, this.Eqa) + f.a.a.b.b.a.bA(9, this.Eme) + f.a.a.b.b.a.bA(10, this.ElZ) + f.a.a.b.b.a.bA(11, this.Ema) + f.a.a.b.b.a.bA(12, this.IsNotRichText);
      paramInt = i;
      if (this.ThumbUrl != null) {
        paramInt = i + f.a.a.b.b.a.e(13, this.ThumbUrl);
      }
      i = f.a.a.b.b.a.bA(14, this.Eqb);
      int j = f.a.a.b.b.a.bA(15, this.Eqc);
      AppMethodBeat.o(118438);
      return paramInt + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      AppMethodBeat.o(118438);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      cxy localcxy = (cxy)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(118438);
        return -1;
      case 1: 
        localcxy.Id = locala.KhF.xT();
        AppMethodBeat.o(118438);
        return 0;
      case 2: 
        localcxy.sdQ = locala.KhF.readString();
        AppMethodBeat.o(118438);
        return 0;
      case 3: 
        localcxy.sdP = locala.KhF.readString();
        AppMethodBeat.o(118438);
        return 0;
      case 4: 
        localcxy.EpY = locala.KhF.readString();
        AppMethodBeat.o(118438);
        return 0;
      case 5: 
        localcxy.EpZ = locala.KhF.readString();
        AppMethodBeat.o(118438);
        return 0;
      case 6: 
        localcxy.CreateTime = locala.KhF.xS();
        AppMethodBeat.o(118438);
        return 0;
      case 7: 
        localcxy.gKr = locala.KhF.readString();
        AppMethodBeat.o(118438);
        return 0;
      case 8: 
        localcxy.Eqa = locala.KhF.xS();
        AppMethodBeat.o(118438);
        return 0;
      case 9: 
        localcxy.Eme = locala.KhF.xS();
        AppMethodBeat.o(118438);
        return 0;
      case 10: 
        localcxy.ElZ = locala.KhF.xS();
        AppMethodBeat.o(118438);
        return 0;
      case 11: 
        localcxy.Ema = locala.KhF.xS();
        AppMethodBeat.o(118438);
        return 0;
      case 12: 
        localcxy.IsNotRichText = locala.KhF.xS();
        AppMethodBeat.o(118438);
        return 0;
      case 13: 
        localcxy.ThumbUrl = locala.KhF.readString();
        AppMethodBeat.o(118438);
        return 0;
      case 14: 
        localcxy.Eqb = locala.KhF.xS();
        AppMethodBeat.o(118438);
        return 0;
      }
      localcxy.Eqc = locala.KhF.xS();
      AppMethodBeat.o(118438);
      return 0;
    }
    AppMethodBeat.o(118438);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cxy
 * JD-Core Version:    0.7.0.1
 */