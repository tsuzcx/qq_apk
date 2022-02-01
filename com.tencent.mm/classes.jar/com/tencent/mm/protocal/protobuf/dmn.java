package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dmn
  extends com.tencent.mm.bw.a
{
  public int FNv;
  public String Gcs;
  public String HTN;
  public String jfY;
  public String nIJ;
  public String nJO;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124559);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.nIJ != null) {
        paramVarArgs.d(1, this.nIJ);
      }
      if (this.nJO != null) {
        paramVarArgs.d(2, this.nJO);
      }
      paramVarArgs.aS(3, this.FNv);
      if (this.HTN != null) {
        paramVarArgs.d(4, this.HTN);
      }
      if (this.jfY != null) {
        paramVarArgs.d(5, this.jfY);
      }
      if (this.Gcs != null) {
        paramVarArgs.d(6, this.Gcs);
      }
      AppMethodBeat.o(124559);
      return 0;
    }
    if (paramInt == 1) {
      if (this.nIJ == null) {
        break label502;
      }
    }
    label502:
    for (paramInt = f.a.a.b.b.a.e(1, this.nIJ) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.nJO != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.nJO);
      }
      i += f.a.a.b.b.a.bz(3, this.FNv);
      paramInt = i;
      if (this.HTN != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.HTN);
      }
      i = paramInt;
      if (this.jfY != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.jfY);
      }
      paramInt = i;
      if (this.Gcs != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.Gcs);
      }
      AppMethodBeat.o(124559);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(124559);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        dmn localdmn = (dmn)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(124559);
          return -1;
        case 1: 
          localdmn.nIJ = locala.OmT.readString();
          AppMethodBeat.o(124559);
          return 0;
        case 2: 
          localdmn.nJO = locala.OmT.readString();
          AppMethodBeat.o(124559);
          return 0;
        case 3: 
          localdmn.FNv = locala.OmT.zc();
          AppMethodBeat.o(124559);
          return 0;
        case 4: 
          localdmn.HTN = locala.OmT.readString();
          AppMethodBeat.o(124559);
          return 0;
        case 5: 
          localdmn.jfY = locala.OmT.readString();
          AppMethodBeat.o(124559);
          return 0;
        }
        localdmn.Gcs = locala.OmT.readString();
        AppMethodBeat.o(124559);
        return 0;
      }
      AppMethodBeat.o(124559);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dmn
 * JD-Core Version:    0.7.0.1
 */