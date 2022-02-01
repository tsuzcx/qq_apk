package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;

public final class ejp
  extends com.tencent.mm.bw.a
{
  public String FNF;
  public int FYj;
  public b HJr;
  public String IconUrl;
  public String ImA;
  public String Imw;
  public float Imx;
  public float Imy;
  public int Imz;
  public String ikm;
  public String nIJ;
  public String nJO;
  public String uuA;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117960);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Imw != null) {
        paramVarArgs.d(1, this.Imw);
      }
      if (this.nJO != null) {
        paramVarArgs.d(2, this.nJO);
      }
      if (this.IconUrl != null) {
        paramVarArgs.d(3, this.IconUrl);
      }
      if (this.nIJ != null) {
        paramVarArgs.d(4, this.nIJ);
      }
      paramVarArgs.aS(5, this.FYj);
      if (this.FNF != null) {
        paramVarArgs.d(6, this.FNF);
      }
      if (this.uuA != null) {
        paramVarArgs.d(7, this.uuA);
      }
      paramVarArgs.y(8, this.Imx);
      paramVarArgs.y(9, this.Imy);
      paramVarArgs.aS(10, this.Imz);
      if (this.ikm != null) {
        paramVarArgs.d(11, this.ikm);
      }
      if (this.ImA != null) {
        paramVarArgs.d(12, this.ImA);
      }
      if (this.HJr != null) {
        paramVarArgs.c(13, this.HJr);
      }
      AppMethodBeat.o(117960);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Imw == null) {
        break label880;
      }
    }
    label880:
    for (int i = f.a.a.b.b.a.e(1, this.Imw) + 0;; i = 0)
    {
      paramInt = i;
      if (this.nJO != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.nJO);
      }
      i = paramInt;
      if (this.IconUrl != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.IconUrl);
      }
      paramInt = i;
      if (this.nIJ != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.nIJ);
      }
      i = paramInt + f.a.a.b.b.a.bz(5, this.FYj);
      paramInt = i;
      if (this.FNF != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.FNF);
      }
      i = paramInt;
      if (this.uuA != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.uuA);
      }
      i = i + f.a.a.b.b.a.amE(8) + f.a.a.b.b.a.amE(9) + f.a.a.b.b.a.bz(10, this.Imz);
      paramInt = i;
      if (this.ikm != null) {
        paramInt = i + f.a.a.b.b.a.e(11, this.ikm);
      }
      i = paramInt;
      if (this.ImA != null) {
        i = paramInt + f.a.a.b.b.a.e(12, this.ImA);
      }
      paramInt = i;
      if (this.HJr != null) {
        paramInt = i + f.a.a.b.b.a.b(13, this.HJr);
      }
      AppMethodBeat.o(117960);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(117960);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        ejp localejp = (ejp)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(117960);
          return -1;
        case 1: 
          localejp.Imw = locala.OmT.readString();
          AppMethodBeat.o(117960);
          return 0;
        case 2: 
          localejp.nJO = locala.OmT.readString();
          AppMethodBeat.o(117960);
          return 0;
        case 3: 
          localejp.IconUrl = locala.OmT.readString();
          AppMethodBeat.o(117960);
          return 0;
        case 4: 
          localejp.nIJ = locala.OmT.readString();
          AppMethodBeat.o(117960);
          return 0;
        case 5: 
          localejp.FYj = locala.OmT.zc();
          AppMethodBeat.o(117960);
          return 0;
        case 6: 
          localejp.FNF = locala.OmT.readString();
          AppMethodBeat.o(117960);
          return 0;
        case 7: 
          localejp.uuA = locala.OmT.readString();
          AppMethodBeat.o(117960);
          return 0;
        case 8: 
          localejp.Imx = Float.intBitsToFloat(locala.OmT.gwb());
          AppMethodBeat.o(117960);
          return 0;
        case 9: 
          localejp.Imy = Float.intBitsToFloat(locala.OmT.gwb());
          AppMethodBeat.o(117960);
          return 0;
        case 10: 
          localejp.Imz = locala.OmT.zc();
          AppMethodBeat.o(117960);
          return 0;
        case 11: 
          localejp.ikm = locala.OmT.readString();
          AppMethodBeat.o(117960);
          return 0;
        case 12: 
          localejp.ImA = locala.OmT.readString();
          AppMethodBeat.o(117960);
          return 0;
        }
        localejp.HJr = locala.OmT.gCk();
        AppMethodBeat.o(117960);
        return 0;
      }
      AppMethodBeat.o(117960);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ejp
 * JD-Core Version:    0.7.0.1
 */