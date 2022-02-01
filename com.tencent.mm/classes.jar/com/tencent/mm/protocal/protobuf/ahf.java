package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ahf
  extends com.tencent.mm.bx.a
{
  public String CUC;
  public String DjA;
  public String DjB;
  public int DjC;
  public String DjD;
  public int DjE;
  public long Djr;
  public long Djs;
  public long Djt;
  public String Dju;
  public long Djv;
  public String Djw;
  public String Djx;
  public String Djy;
  public String Djz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91460);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aG(1, this.Djr);
      paramVarArgs.aG(2, this.Djs);
      paramVarArgs.aG(3, this.Djt);
      if (this.Dju != null) {
        paramVarArgs.d(4, this.Dju);
      }
      paramVarArgs.aG(5, this.Djv);
      if (this.Djw != null) {
        paramVarArgs.d(6, this.Djw);
      }
      if (this.Djx != null) {
        paramVarArgs.d(7, this.Djx);
      }
      if (this.Djy != null) {
        paramVarArgs.d(8, this.Djy);
      }
      if (this.Djz != null) {
        paramVarArgs.d(9, this.Djz);
      }
      if (this.DjA != null) {
        paramVarArgs.d(10, this.DjA);
      }
      if (this.DjB != null) {
        paramVarArgs.d(11, this.DjB);
      }
      paramVarArgs.aR(12, this.DjC);
      if (this.DjD != null) {
        paramVarArgs.d(13, this.DjD);
      }
      paramVarArgs.aR(14, this.DjE);
      if (this.CUC != null) {
        paramVarArgs.d(15, this.CUC);
      }
      AppMethodBeat.o(91460);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.q(1, this.Djr) + 0 + f.a.a.b.b.a.q(2, this.Djs) + f.a.a.b.b.a.q(3, this.Djt);
      paramInt = i;
      if (this.Dju != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.Dju);
      }
      i = paramInt + f.a.a.b.b.a.q(5, this.Djv);
      paramInt = i;
      if (this.Djw != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.Djw);
      }
      i = paramInt;
      if (this.Djx != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.Djx);
      }
      paramInt = i;
      if (this.Djy != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.Djy);
      }
      i = paramInt;
      if (this.Djz != null) {
        i = paramInt + f.a.a.b.b.a.e(9, this.Djz);
      }
      paramInt = i;
      if (this.DjA != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.DjA);
      }
      i = paramInt;
      if (this.DjB != null) {
        i = paramInt + f.a.a.b.b.a.e(11, this.DjB);
      }
      i += f.a.a.b.b.a.bA(12, this.DjC);
      paramInt = i;
      if (this.DjD != null) {
        paramInt = i + f.a.a.b.b.a.e(13, this.DjD);
      }
      i = paramInt + f.a.a.b.b.a.bA(14, this.DjE);
      paramInt = i;
      if (this.CUC != null) {
        paramInt = i + f.a.a.b.b.a.e(15, this.CUC);
      }
      AppMethodBeat.o(91460);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      AppMethodBeat.o(91460);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      ahf localahf = (ahf)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(91460);
        return -1;
      case 1: 
        localahf.Djr = locala.KhF.xT();
        AppMethodBeat.o(91460);
        return 0;
      case 2: 
        localahf.Djs = locala.KhF.xT();
        AppMethodBeat.o(91460);
        return 0;
      case 3: 
        localahf.Djt = locala.KhF.xT();
        AppMethodBeat.o(91460);
        return 0;
      case 4: 
        localahf.Dju = locala.KhF.readString();
        AppMethodBeat.o(91460);
        return 0;
      case 5: 
        localahf.Djv = locala.KhF.xT();
        AppMethodBeat.o(91460);
        return 0;
      case 6: 
        localahf.Djw = locala.KhF.readString();
        AppMethodBeat.o(91460);
        return 0;
      case 7: 
        localahf.Djx = locala.KhF.readString();
        AppMethodBeat.o(91460);
        return 0;
      case 8: 
        localahf.Djy = locala.KhF.readString();
        AppMethodBeat.o(91460);
        return 0;
      case 9: 
        localahf.Djz = locala.KhF.readString();
        AppMethodBeat.o(91460);
        return 0;
      case 10: 
        localahf.DjA = locala.KhF.readString();
        AppMethodBeat.o(91460);
        return 0;
      case 11: 
        localahf.DjB = locala.KhF.readString();
        AppMethodBeat.o(91460);
        return 0;
      case 12: 
        localahf.DjC = locala.KhF.xS();
        AppMethodBeat.o(91460);
        return 0;
      case 13: 
        localahf.DjD = locala.KhF.readString();
        AppMethodBeat.o(91460);
        return 0;
      case 14: 
        localahf.DjE = locala.KhF.xS();
        AppMethodBeat.o(91460);
        return 0;
      }
      localahf.CUC = locala.KhF.readString();
      AppMethodBeat.o(91460);
      return 0;
    }
    AppMethodBeat.o(91460);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ahf
 * JD-Core Version:    0.7.0.1
 */