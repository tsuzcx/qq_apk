package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class aav
  extends com.tencent.mm.bw.a
{
  public int Gsj;
  public int Gsk;
  public int Gsl;
  public int Gsm;
  public int pdP;
  public int pdQ;
  public int pdR;
  public int pdS;
  public int pdT;
  public int pdU;
  public int pdV;
  public int pdW;
  public int pdX;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(90959);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.pdP);
      paramVarArgs.aS(2, this.Gsj);
      paramVarArgs.aS(3, this.pdQ);
      paramVarArgs.aS(4, this.pdR);
      paramVarArgs.aS(5, this.pdS);
      paramVarArgs.aS(6, this.Gsk);
      paramVarArgs.aS(7, this.pdT);
      paramVarArgs.aS(8, this.pdU);
      paramVarArgs.aS(9, this.Gsl);
      paramVarArgs.aS(10, this.Gsm);
      paramVarArgs.aS(11, this.pdV);
      paramVarArgs.aS(12, this.pdW);
      paramVarArgs.aS(13, this.pdX);
      AppMethodBeat.o(90959);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.bz(1, this.pdP);
      int i = f.a.a.b.b.a.bz(2, this.Gsj);
      int j = f.a.a.b.b.a.bz(3, this.pdQ);
      int k = f.a.a.b.b.a.bz(4, this.pdR);
      int m = f.a.a.b.b.a.bz(5, this.pdS);
      int n = f.a.a.b.b.a.bz(6, this.Gsk);
      int i1 = f.a.a.b.b.a.bz(7, this.pdT);
      int i2 = f.a.a.b.b.a.bz(8, this.pdU);
      int i3 = f.a.a.b.b.a.bz(9, this.Gsl);
      int i4 = f.a.a.b.b.a.bz(10, this.Gsm);
      int i5 = f.a.a.b.b.a.bz(11, this.pdV);
      int i6 = f.a.a.b.b.a.bz(12, this.pdW);
      int i7 = f.a.a.b.b.a.bz(13, this.pdX);
      AppMethodBeat.o(90959);
      return paramInt + 0 + i + j + k + m + n + i1 + i2 + i3 + i4 + i5 + i6 + i7;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(90959);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      aav localaav = (aav)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(90959);
        return -1;
      case 1: 
        localaav.pdP = locala.OmT.zc();
        AppMethodBeat.o(90959);
        return 0;
      case 2: 
        localaav.Gsj = locala.OmT.zc();
        AppMethodBeat.o(90959);
        return 0;
      case 3: 
        localaav.pdQ = locala.OmT.zc();
        AppMethodBeat.o(90959);
        return 0;
      case 4: 
        localaav.pdR = locala.OmT.zc();
        AppMethodBeat.o(90959);
        return 0;
      case 5: 
        localaav.pdS = locala.OmT.zc();
        AppMethodBeat.o(90959);
        return 0;
      case 6: 
        localaav.Gsk = locala.OmT.zc();
        AppMethodBeat.o(90959);
        return 0;
      case 7: 
        localaav.pdT = locala.OmT.zc();
        AppMethodBeat.o(90959);
        return 0;
      case 8: 
        localaav.pdU = locala.OmT.zc();
        AppMethodBeat.o(90959);
        return 0;
      case 9: 
        localaav.Gsl = locala.OmT.zc();
        AppMethodBeat.o(90959);
        return 0;
      case 10: 
        localaav.Gsm = locala.OmT.zc();
        AppMethodBeat.o(90959);
        return 0;
      case 11: 
        localaav.pdV = locala.OmT.zc();
        AppMethodBeat.o(90959);
        return 0;
      case 12: 
        localaav.pdW = locala.OmT.zc();
        AppMethodBeat.o(90959);
        return 0;
      }
      localaav.pdX = locala.OmT.zc();
      AppMethodBeat.o(90959);
      return 0;
    }
    AppMethodBeat.o(90959);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aav
 * JD-Core Version:    0.7.0.1
 */