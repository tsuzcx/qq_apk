package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cfk
  extends com.tencent.mm.bw.a
{
  public String Hsg;
  public String Hsh;
  public int Hsi;
  public String Hsj;
  public String Hsk;
  public String Hsl;
  public int Hsm;
  public int Hsn;
  public int Hso;
  public long Hsp;
  public String buG;
  public String dBe;
  public String oIt;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152632);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.buG != null) {
        paramVarArgs.d(1, this.buG);
      }
      if (this.Hsg != null) {
        paramVarArgs.d(2, this.Hsg);
      }
      if (this.Hsh != null) {
        paramVarArgs.d(3, this.Hsh);
      }
      paramVarArgs.aS(4, this.Hsi);
      if (this.dBe != null) {
        paramVarArgs.d(5, this.dBe);
      }
      if (this.Hsj != null) {
        paramVarArgs.d(6, this.Hsj);
      }
      if (this.Hsk != null) {
        paramVarArgs.d(7, this.Hsk);
      }
      if (this.oIt != null) {
        paramVarArgs.d(8, this.oIt);
      }
      if (this.Hsl != null) {
        paramVarArgs.d(9, this.Hsl);
      }
      paramVarArgs.aS(10, this.Hsm);
      paramVarArgs.aS(11, this.Hsn);
      paramVarArgs.aS(12, this.Hso);
      paramVarArgs.aZ(13, this.Hsp);
      AppMethodBeat.o(152632);
      return 0;
    }
    if (paramInt == 1) {
      if (this.buG == null) {
        break label878;
      }
    }
    label878:
    for (int i = f.a.a.b.b.a.e(1, this.buG) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Hsg != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.Hsg);
      }
      i = paramInt;
      if (this.Hsh != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.Hsh);
      }
      i += f.a.a.b.b.a.bz(4, this.Hsi);
      paramInt = i;
      if (this.dBe != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.dBe);
      }
      i = paramInt;
      if (this.Hsj != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.Hsj);
      }
      paramInt = i;
      if (this.Hsk != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.Hsk);
      }
      i = paramInt;
      if (this.oIt != null) {
        i = paramInt + f.a.a.b.b.a.e(8, this.oIt);
      }
      paramInt = i;
      if (this.Hsl != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.Hsl);
      }
      i = f.a.a.b.b.a.bz(10, this.Hsm);
      int j = f.a.a.b.b.a.bz(11, this.Hsn);
      int k = f.a.a.b.b.a.bz(12, this.Hso);
      int m = f.a.a.b.b.a.p(13, this.Hsp);
      AppMethodBeat.o(152632);
      return paramInt + i + j + k + m;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(152632);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        cfk localcfk = (cfk)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(152632);
          return -1;
        case 1: 
          localcfk.buG = locala.OmT.readString();
          AppMethodBeat.o(152632);
          return 0;
        case 2: 
          localcfk.Hsg = locala.OmT.readString();
          AppMethodBeat.o(152632);
          return 0;
        case 3: 
          localcfk.Hsh = locala.OmT.readString();
          AppMethodBeat.o(152632);
          return 0;
        case 4: 
          localcfk.Hsi = locala.OmT.zc();
          AppMethodBeat.o(152632);
          return 0;
        case 5: 
          localcfk.dBe = locala.OmT.readString();
          AppMethodBeat.o(152632);
          return 0;
        case 6: 
          localcfk.Hsj = locala.OmT.readString();
          AppMethodBeat.o(152632);
          return 0;
        case 7: 
          localcfk.Hsk = locala.OmT.readString();
          AppMethodBeat.o(152632);
          return 0;
        case 8: 
          localcfk.oIt = locala.OmT.readString();
          AppMethodBeat.o(152632);
          return 0;
        case 9: 
          localcfk.Hsl = locala.OmT.readString();
          AppMethodBeat.o(152632);
          return 0;
        case 10: 
          localcfk.Hsm = locala.OmT.zc();
          AppMethodBeat.o(152632);
          return 0;
        case 11: 
          localcfk.Hsn = locala.OmT.zc();
          AppMethodBeat.o(152632);
          return 0;
        case 12: 
          localcfk.Hso = locala.OmT.zc();
          AppMethodBeat.o(152632);
          return 0;
        }
        localcfk.Hsp = locala.OmT.zd();
        AppMethodBeat.o(152632);
        return 0;
      }
      AppMethodBeat.o(152632);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cfk
 * JD-Core Version:    0.7.0.1
 */