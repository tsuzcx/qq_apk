package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cjn
  extends com.tencent.mm.bw.a
{
  public String Dps;
  public String DqK;
  public long DqW;
  public long DqX;
  public long DqY;
  public int DqZ;
  public int Dra;
  public long Drb;
  public String DyN;
  public String Hwd;
  public String Hwe;
  public String Hwf;
  public int Hwg;
  public String dEM;
  public String dyI;
  public String title;
  public String type;
  public String url;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91578);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.url != null) {
        paramVarArgs.d(1, this.url);
      }
      if (this.dyI != null) {
        paramVarArgs.d(2, this.dyI);
      }
      if (this.dEM != null) {
        paramVarArgs.d(3, this.dEM);
      }
      if (this.DyN != null) {
        paramVarArgs.d(4, this.DyN);
      }
      if (this.DqK != null) {
        paramVarArgs.d(5, this.DqK);
      }
      if (this.Hwd != null) {
        paramVarArgs.d(6, this.Hwd);
      }
      if (this.type != null) {
        paramVarArgs.d(7, this.type);
      }
      if (this.title != null) {
        paramVarArgs.d(8, this.title);
      }
      paramVarArgs.aZ(9, this.DqW);
      paramVarArgs.aZ(10, this.DqX);
      if (this.Dps != null) {
        paramVarArgs.d(11, this.Dps);
      }
      paramVarArgs.aZ(12, this.DqY);
      paramVarArgs.aS(13, this.DqZ);
      paramVarArgs.aS(14, this.Dra);
      if (this.Hwe != null) {
        paramVarArgs.d(15, this.Hwe);
      }
      if (this.Hwf != null) {
        paramVarArgs.d(16, this.Hwf);
      }
      paramVarArgs.aZ(17, this.Drb);
      paramVarArgs.aS(18, this.Hwg);
      AppMethodBeat.o(91578);
      return 0;
    }
    if (paramInt == 1) {
      if (this.url == null) {
        break label1146;
      }
    }
    label1146:
    for (int i = f.a.a.b.b.a.e(1, this.url) + 0;; i = 0)
    {
      paramInt = i;
      if (this.dyI != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.dyI);
      }
      i = paramInt;
      if (this.dEM != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.dEM);
      }
      paramInt = i;
      if (this.DyN != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.DyN);
      }
      i = paramInt;
      if (this.DqK != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.DqK);
      }
      paramInt = i;
      if (this.Hwd != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.Hwd);
      }
      i = paramInt;
      if (this.type != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.type);
      }
      paramInt = i;
      if (this.title != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.title);
      }
      i = paramInt + f.a.a.b.b.a.p(9, this.DqW) + f.a.a.b.b.a.p(10, this.DqX);
      paramInt = i;
      if (this.Dps != null) {
        paramInt = i + f.a.a.b.b.a.e(11, this.Dps);
      }
      i = paramInt + f.a.a.b.b.a.p(12, this.DqY) + f.a.a.b.b.a.bz(13, this.DqZ) + f.a.a.b.b.a.bz(14, this.Dra);
      paramInt = i;
      if (this.Hwe != null) {
        paramInt = i + f.a.a.b.b.a.e(15, this.Hwe);
      }
      i = paramInt;
      if (this.Hwf != null) {
        i = paramInt + f.a.a.b.b.a.e(16, this.Hwf);
      }
      paramInt = f.a.a.b.b.a.p(17, this.Drb);
      int j = f.a.a.b.b.a.bz(18, this.Hwg);
      AppMethodBeat.o(91578);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(91578);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        cjn localcjn = (cjn)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(91578);
          return -1;
        case 1: 
          localcjn.url = locala.OmT.readString();
          AppMethodBeat.o(91578);
          return 0;
        case 2: 
          localcjn.dyI = locala.OmT.readString();
          AppMethodBeat.o(91578);
          return 0;
        case 3: 
          localcjn.dEM = locala.OmT.readString();
          AppMethodBeat.o(91578);
          return 0;
        case 4: 
          localcjn.DyN = locala.OmT.readString();
          AppMethodBeat.o(91578);
          return 0;
        case 5: 
          localcjn.DqK = locala.OmT.readString();
          AppMethodBeat.o(91578);
          return 0;
        case 6: 
          localcjn.Hwd = locala.OmT.readString();
          AppMethodBeat.o(91578);
          return 0;
        case 7: 
          localcjn.type = locala.OmT.readString();
          AppMethodBeat.o(91578);
          return 0;
        case 8: 
          localcjn.title = locala.OmT.readString();
          AppMethodBeat.o(91578);
          return 0;
        case 9: 
          localcjn.DqW = locala.OmT.zd();
          AppMethodBeat.o(91578);
          return 0;
        case 10: 
          localcjn.DqX = locala.OmT.zd();
          AppMethodBeat.o(91578);
          return 0;
        case 11: 
          localcjn.Dps = locala.OmT.readString();
          AppMethodBeat.o(91578);
          return 0;
        case 12: 
          localcjn.DqY = locala.OmT.zd();
          AppMethodBeat.o(91578);
          return 0;
        case 13: 
          localcjn.DqZ = locala.OmT.zc();
          AppMethodBeat.o(91578);
          return 0;
        case 14: 
          localcjn.Dra = locala.OmT.zc();
          AppMethodBeat.o(91578);
          return 0;
        case 15: 
          localcjn.Hwe = locala.OmT.readString();
          AppMethodBeat.o(91578);
          return 0;
        case 16: 
          localcjn.Hwf = locala.OmT.readString();
          AppMethodBeat.o(91578);
          return 0;
        case 17: 
          localcjn.Drb = locala.OmT.zd();
          AppMethodBeat.o(91578);
          return 0;
        }
        localcjn.Hwg = locala.OmT.zc();
        AppMethodBeat.o(91578);
        return 0;
      }
      AppMethodBeat.o(91578);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cjn
 * JD-Core Version:    0.7.0.1
 */