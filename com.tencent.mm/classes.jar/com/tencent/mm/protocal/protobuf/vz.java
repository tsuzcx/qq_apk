package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class vz
  extends com.tencent.mm.bw.a
{
  public String GnM;
  public String GnN;
  public String GnO;
  public int GnP;
  public String GnQ;
  public String GnR;
  public String GnS;
  public String nIJ;
  public String nJO;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(43087);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.nIJ != null) {
        paramVarArgs.d(1, this.nIJ);
      }
      if (this.nJO != null) {
        paramVarArgs.d(2, this.nJO);
      }
      if (this.GnM != null) {
        paramVarArgs.d(3, this.GnM);
      }
      if (this.GnN != null) {
        paramVarArgs.d(4, this.GnN);
      }
      if (this.GnO != null) {
        paramVarArgs.d(5, this.GnO);
      }
      paramVarArgs.aS(6, this.GnP);
      if (this.GnQ != null) {
        paramVarArgs.d(7, this.GnQ);
      }
      if (this.GnR != null) {
        paramVarArgs.d(10, this.GnR);
      }
      if (this.GnS != null) {
        paramVarArgs.d(11, this.GnS);
      }
      AppMethodBeat.o(43087);
      return 0;
    }
    if (paramInt == 1) {
      if (this.nIJ == null) {
        break label694;
      }
    }
    label694:
    for (int i = f.a.a.b.b.a.e(1, this.nIJ) + 0;; i = 0)
    {
      paramInt = i;
      if (this.nJO != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.nJO);
      }
      i = paramInt;
      if (this.GnM != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.GnM);
      }
      paramInt = i;
      if (this.GnN != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.GnN);
      }
      i = paramInt;
      if (this.GnO != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.GnO);
      }
      i += f.a.a.b.b.a.bz(6, this.GnP);
      paramInt = i;
      if (this.GnQ != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.GnQ);
      }
      i = paramInt;
      if (this.GnR != null) {
        i = paramInt + f.a.a.b.b.a.e(10, this.GnR);
      }
      paramInt = i;
      if (this.GnS != null) {
        paramInt = i + f.a.a.b.b.a.e(11, this.GnS);
      }
      AppMethodBeat.o(43087);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(43087);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        vz localvz = (vz)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        case 8: 
        case 9: 
        default: 
          AppMethodBeat.o(43087);
          return -1;
        case 1: 
          localvz.nIJ = locala.OmT.readString();
          AppMethodBeat.o(43087);
          return 0;
        case 2: 
          localvz.nJO = locala.OmT.readString();
          AppMethodBeat.o(43087);
          return 0;
        case 3: 
          localvz.GnM = locala.OmT.readString();
          AppMethodBeat.o(43087);
          return 0;
        case 4: 
          localvz.GnN = locala.OmT.readString();
          AppMethodBeat.o(43087);
          return 0;
        case 5: 
          localvz.GnO = locala.OmT.readString();
          AppMethodBeat.o(43087);
          return 0;
        case 6: 
          localvz.GnP = locala.OmT.zc();
          AppMethodBeat.o(43087);
          return 0;
        case 7: 
          localvz.GnQ = locala.OmT.readString();
          AppMethodBeat.o(43087);
          return 0;
        case 10: 
          localvz.GnR = locala.OmT.readString();
          AppMethodBeat.o(43087);
          return 0;
        }
        localvz.GnS = locala.OmT.readString();
        AppMethodBeat.o(43087);
        return 0;
      }
      AppMethodBeat.o(43087);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.vz
 * JD-Core Version:    0.7.0.1
 */