package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class vs
  extends com.tencent.mm.bw.a
{
  public String FMg;
  public String GnA;
  public int GnB;
  public String GnC;
  public int Gns;
  public String Gnt;
  public int Gnu;
  public String Gnv;
  public int Gnw;
  public String Gnx;
  public String Gny;
  public String Gnz;
  public int pqO;
  public String pqP;
  public String pqV;
  public String pqW;
  public String prI;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125715);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.Gns);
      if (this.prI != null) {
        paramVarArgs.d(2, this.prI);
      }
      if (this.Gnt != null) {
        paramVarArgs.d(3, this.Gnt);
      }
      if (this.pqV != null) {
        paramVarArgs.d(4, this.pqV);
      }
      paramVarArgs.aS(5, this.Gnu);
      if (this.Gnv != null) {
        paramVarArgs.d(6, this.Gnv);
      }
      paramVarArgs.aS(7, this.Gnw);
      if (this.pqW != null) {
        paramVarArgs.d(8, this.pqW);
      }
      if (this.FMg != null) {
        paramVarArgs.d(9, this.FMg);
      }
      paramVarArgs.aS(10, this.pqO);
      if (this.pqP != null) {
        paramVarArgs.d(11, this.pqP);
      }
      if (this.Gnx != null) {
        paramVarArgs.d(12, this.Gnx);
      }
      if (this.Gny != null) {
        paramVarArgs.d(13, this.Gny);
      }
      if (this.Gnz != null) {
        paramVarArgs.d(14, this.Gnz);
      }
      if (this.GnA != null) {
        paramVarArgs.d(15, this.GnA);
      }
      paramVarArgs.aS(16, this.GnB);
      if (this.GnC != null) {
        paramVarArgs.d(17, this.GnC);
      }
      AppMethodBeat.o(125715);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bz(1, this.Gns) + 0;
      paramInt = i;
      if (this.prI != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.prI);
      }
      i = paramInt;
      if (this.Gnt != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.Gnt);
      }
      paramInt = i;
      if (this.pqV != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.pqV);
      }
      i = paramInt + f.a.a.b.b.a.bz(5, this.Gnu);
      paramInt = i;
      if (this.Gnv != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.Gnv);
      }
      i = paramInt + f.a.a.b.b.a.bz(7, this.Gnw);
      paramInt = i;
      if (this.pqW != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.pqW);
      }
      i = paramInt;
      if (this.FMg != null) {
        i = paramInt + f.a.a.b.b.a.e(9, this.FMg);
      }
      i += f.a.a.b.b.a.bz(10, this.pqO);
      paramInt = i;
      if (this.pqP != null) {
        paramInt = i + f.a.a.b.b.a.e(11, this.pqP);
      }
      i = paramInt;
      if (this.Gnx != null) {
        i = paramInt + f.a.a.b.b.a.e(12, this.Gnx);
      }
      paramInt = i;
      if (this.Gny != null) {
        paramInt = i + f.a.a.b.b.a.e(13, this.Gny);
      }
      i = paramInt;
      if (this.Gnz != null) {
        i = paramInt + f.a.a.b.b.a.e(14, this.Gnz);
      }
      paramInt = i;
      if (this.GnA != null) {
        paramInt = i + f.a.a.b.b.a.e(15, this.GnA);
      }
      i = paramInt + f.a.a.b.b.a.bz(16, this.GnB);
      paramInt = i;
      if (this.GnC != null) {
        paramInt = i + f.a.a.b.b.a.e(17, this.GnC);
      }
      AppMethodBeat.o(125715);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(125715);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      vs localvs = (vs)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(125715);
        return -1;
      case 1: 
        localvs.Gns = locala.OmT.zc();
        AppMethodBeat.o(125715);
        return 0;
      case 2: 
        localvs.prI = locala.OmT.readString();
        AppMethodBeat.o(125715);
        return 0;
      case 3: 
        localvs.Gnt = locala.OmT.readString();
        AppMethodBeat.o(125715);
        return 0;
      case 4: 
        localvs.pqV = locala.OmT.readString();
        AppMethodBeat.o(125715);
        return 0;
      case 5: 
        localvs.Gnu = locala.OmT.zc();
        AppMethodBeat.o(125715);
        return 0;
      case 6: 
        localvs.Gnv = locala.OmT.readString();
        AppMethodBeat.o(125715);
        return 0;
      case 7: 
        localvs.Gnw = locala.OmT.zc();
        AppMethodBeat.o(125715);
        return 0;
      case 8: 
        localvs.pqW = locala.OmT.readString();
        AppMethodBeat.o(125715);
        return 0;
      case 9: 
        localvs.FMg = locala.OmT.readString();
        AppMethodBeat.o(125715);
        return 0;
      case 10: 
        localvs.pqO = locala.OmT.zc();
        AppMethodBeat.o(125715);
        return 0;
      case 11: 
        localvs.pqP = locala.OmT.readString();
        AppMethodBeat.o(125715);
        return 0;
      case 12: 
        localvs.Gnx = locala.OmT.readString();
        AppMethodBeat.o(125715);
        return 0;
      case 13: 
        localvs.Gny = locala.OmT.readString();
        AppMethodBeat.o(125715);
        return 0;
      case 14: 
        localvs.Gnz = locala.OmT.readString();
        AppMethodBeat.o(125715);
        return 0;
      case 15: 
        localvs.GnA = locala.OmT.readString();
        AppMethodBeat.o(125715);
        return 0;
      case 16: 
        localvs.GnB = locala.OmT.zc();
        AppMethodBeat.o(125715);
        return 0;
      }
      localvs.GnC = locala.OmT.readString();
      AppMethodBeat.o(125715);
      return 0;
    }
    AppMethodBeat.o(125715);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.vs
 * JD-Core Version:    0.7.0.1
 */