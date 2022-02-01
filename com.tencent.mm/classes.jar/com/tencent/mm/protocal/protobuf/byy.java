package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class byy
  extends com.tencent.mm.bx.a
{
  public String Afa;
  public long AgE;
  public long AgF;
  public long AgG;
  public int AgH;
  public int AgI;
  public long AgJ;
  public String Ags;
  public String Aox;
  public String DVI;
  public String DVJ;
  public String DVK;
  public int DVL;
  public String doh;
  public String dub;
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
      if (this.doh != null) {
        paramVarArgs.d(2, this.doh);
      }
      if (this.dub != null) {
        paramVarArgs.d(3, this.dub);
      }
      if (this.Aox != null) {
        paramVarArgs.d(4, this.Aox);
      }
      if (this.Ags != null) {
        paramVarArgs.d(5, this.Ags);
      }
      if (this.DVI != null) {
        paramVarArgs.d(6, this.DVI);
      }
      if (this.type != null) {
        paramVarArgs.d(7, this.type);
      }
      if (this.title != null) {
        paramVarArgs.d(8, this.title);
      }
      paramVarArgs.aG(9, this.AgE);
      paramVarArgs.aG(10, this.AgF);
      if (this.Afa != null) {
        paramVarArgs.d(11, this.Afa);
      }
      paramVarArgs.aG(12, this.AgG);
      paramVarArgs.aR(13, this.AgH);
      paramVarArgs.aR(14, this.AgI);
      if (this.DVJ != null) {
        paramVarArgs.d(15, this.DVJ);
      }
      if (this.DVK != null) {
        paramVarArgs.d(16, this.DVK);
      }
      paramVarArgs.aG(17, this.AgJ);
      paramVarArgs.aR(18, this.DVL);
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
      if (this.doh != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.doh);
      }
      i = paramInt;
      if (this.dub != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.dub);
      }
      paramInt = i;
      if (this.Aox != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.Aox);
      }
      i = paramInt;
      if (this.Ags != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.Ags);
      }
      paramInt = i;
      if (this.DVI != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.DVI);
      }
      i = paramInt;
      if (this.type != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.type);
      }
      paramInt = i;
      if (this.title != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.title);
      }
      i = paramInt + f.a.a.b.b.a.q(9, this.AgE) + f.a.a.b.b.a.q(10, this.AgF);
      paramInt = i;
      if (this.Afa != null) {
        paramInt = i + f.a.a.b.b.a.e(11, this.Afa);
      }
      i = paramInt + f.a.a.b.b.a.q(12, this.AgG) + f.a.a.b.b.a.bA(13, this.AgH) + f.a.a.b.b.a.bA(14, this.AgI);
      paramInt = i;
      if (this.DVJ != null) {
        paramInt = i + f.a.a.b.b.a.e(15, this.DVJ);
      }
      i = paramInt;
      if (this.DVK != null) {
        i = paramInt + f.a.a.b.b.a.e(16, this.DVK);
      }
      paramInt = f.a.a.b.b.a.q(17, this.AgJ);
      int j = f.a.a.b.b.a.bA(18, this.DVL);
      AppMethodBeat.o(91578);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(91578);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        byy localbyy = (byy)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(91578);
          return -1;
        case 1: 
          localbyy.url = locala.KhF.readString();
          AppMethodBeat.o(91578);
          return 0;
        case 2: 
          localbyy.doh = locala.KhF.readString();
          AppMethodBeat.o(91578);
          return 0;
        case 3: 
          localbyy.dub = locala.KhF.readString();
          AppMethodBeat.o(91578);
          return 0;
        case 4: 
          localbyy.Aox = locala.KhF.readString();
          AppMethodBeat.o(91578);
          return 0;
        case 5: 
          localbyy.Ags = locala.KhF.readString();
          AppMethodBeat.o(91578);
          return 0;
        case 6: 
          localbyy.DVI = locala.KhF.readString();
          AppMethodBeat.o(91578);
          return 0;
        case 7: 
          localbyy.type = locala.KhF.readString();
          AppMethodBeat.o(91578);
          return 0;
        case 8: 
          localbyy.title = locala.KhF.readString();
          AppMethodBeat.o(91578);
          return 0;
        case 9: 
          localbyy.AgE = locala.KhF.xT();
          AppMethodBeat.o(91578);
          return 0;
        case 10: 
          localbyy.AgF = locala.KhF.xT();
          AppMethodBeat.o(91578);
          return 0;
        case 11: 
          localbyy.Afa = locala.KhF.readString();
          AppMethodBeat.o(91578);
          return 0;
        case 12: 
          localbyy.AgG = locala.KhF.xT();
          AppMethodBeat.o(91578);
          return 0;
        case 13: 
          localbyy.AgH = locala.KhF.xS();
          AppMethodBeat.o(91578);
          return 0;
        case 14: 
          localbyy.AgI = locala.KhF.xS();
          AppMethodBeat.o(91578);
          return 0;
        case 15: 
          localbyy.DVJ = locala.KhF.readString();
          AppMethodBeat.o(91578);
          return 0;
        case 16: 
          localbyy.DVK = locala.KhF.readString();
          AppMethodBeat.o(91578);
          return 0;
        case 17: 
          localbyy.AgJ = locala.KhF.xT();
          AppMethodBeat.o(91578);
          return 0;
        }
        localbyy.DVL = locala.KhF.xS();
        AppMethodBeat.o(91578);
        return 0;
      }
      AppMethodBeat.o(91578);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.byy
 * JD-Core Version:    0.7.0.1
 */