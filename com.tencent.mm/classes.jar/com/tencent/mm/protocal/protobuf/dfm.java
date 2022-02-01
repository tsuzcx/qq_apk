package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;

public final class dfm
  extends com.tencent.mm.bw.a
{
  public int HMA;
  public String HMB;
  public String HMC;
  public String HMD;
  public int HME;
  public int HMF;
  public int HMG;
  public int HMH;
  public int HMI;
  public String HMx;
  public String HMy;
  public String HMz;
  public int Scene;
  public String Title;
  public String Url;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117927);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.HMx == null)
      {
        paramVarArgs = new b("Not all required fields were included: PickedWord");
        AppMethodBeat.o(117927);
        throw paramVarArgs;
      }
      if (this.HMx != null) {
        paramVarArgs.d(1, this.HMx);
      }
      if (this.HMy != null) {
        paramVarArgs.d(2, this.HMy);
      }
      if (this.HMz != null) {
        paramVarArgs.d(3, this.HMz);
      }
      paramVarArgs.aS(4, this.Scene);
      paramVarArgs.aS(5, this.HMA);
      if (this.Url != null) {
        paramVarArgs.d(6, this.Url);
      }
      if (this.Title != null) {
        paramVarArgs.d(7, this.Title);
      }
      if (this.HMB != null) {
        paramVarArgs.d(8, this.HMB);
      }
      if (this.HMC != null) {
        paramVarArgs.d(9, this.HMC);
      }
      if (this.HMD != null) {
        paramVarArgs.d(10, this.HMD);
      }
      paramVarArgs.aS(11, this.HME);
      paramVarArgs.aS(12, this.HMF);
      paramVarArgs.aS(13, this.HMG);
      paramVarArgs.aS(14, this.HMH);
      paramVarArgs.aS(15, this.HMI);
      AppMethodBeat.o(117927);
      return 0;
    }
    if (paramInt == 1) {
      if (this.HMx == null) {
        break label1018;
      }
    }
    label1018:
    for (int i = f.a.a.b.b.a.e(1, this.HMx) + 0;; i = 0)
    {
      paramInt = i;
      if (this.HMy != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.HMy);
      }
      i = paramInt;
      if (this.HMz != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.HMz);
      }
      i = i + f.a.a.b.b.a.bz(4, this.Scene) + f.a.a.b.b.a.bz(5, this.HMA);
      paramInt = i;
      if (this.Url != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.Url);
      }
      i = paramInt;
      if (this.Title != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.Title);
      }
      paramInt = i;
      if (this.HMB != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.HMB);
      }
      i = paramInt;
      if (this.HMC != null) {
        i = paramInt + f.a.a.b.b.a.e(9, this.HMC);
      }
      paramInt = i;
      if (this.HMD != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.HMD);
      }
      i = f.a.a.b.b.a.bz(11, this.HME);
      int j = f.a.a.b.b.a.bz(12, this.HMF);
      int k = f.a.a.b.b.a.bz(13, this.HMG);
      int m = f.a.a.b.b.a.bz(14, this.HMH);
      int n = f.a.a.b.b.a.bz(15, this.HMI);
      AppMethodBeat.o(117927);
      return paramInt + i + j + k + m + n;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.HMx == null)
        {
          paramVarArgs = new b("Not all required fields were included: PickedWord");
          AppMethodBeat.o(117927);
          throw paramVarArgs;
        }
        AppMethodBeat.o(117927);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        dfm localdfm = (dfm)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(117927);
          return -1;
        case 1: 
          localdfm.HMx = locala.OmT.readString();
          AppMethodBeat.o(117927);
          return 0;
        case 2: 
          localdfm.HMy = locala.OmT.readString();
          AppMethodBeat.o(117927);
          return 0;
        case 3: 
          localdfm.HMz = locala.OmT.readString();
          AppMethodBeat.o(117927);
          return 0;
        case 4: 
          localdfm.Scene = locala.OmT.zc();
          AppMethodBeat.o(117927);
          return 0;
        case 5: 
          localdfm.HMA = locala.OmT.zc();
          AppMethodBeat.o(117927);
          return 0;
        case 6: 
          localdfm.Url = locala.OmT.readString();
          AppMethodBeat.o(117927);
          return 0;
        case 7: 
          localdfm.Title = locala.OmT.readString();
          AppMethodBeat.o(117927);
          return 0;
        case 8: 
          localdfm.HMB = locala.OmT.readString();
          AppMethodBeat.o(117927);
          return 0;
        case 9: 
          localdfm.HMC = locala.OmT.readString();
          AppMethodBeat.o(117927);
          return 0;
        case 10: 
          localdfm.HMD = locala.OmT.readString();
          AppMethodBeat.o(117927);
          return 0;
        case 11: 
          localdfm.HME = locala.OmT.zc();
          AppMethodBeat.o(117927);
          return 0;
        case 12: 
          localdfm.HMF = locala.OmT.zc();
          AppMethodBeat.o(117927);
          return 0;
        case 13: 
          localdfm.HMG = locala.OmT.zc();
          AppMethodBeat.o(117927);
          return 0;
        case 14: 
          localdfm.HMH = locala.OmT.zc();
          AppMethodBeat.o(117927);
          return 0;
        }
        localdfm.HMI = locala.OmT.zc();
        AppMethodBeat.o(117927);
        return 0;
      }
      AppMethodBeat.o(117927);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dfm
 * JD-Core Version:    0.7.0.1
 */