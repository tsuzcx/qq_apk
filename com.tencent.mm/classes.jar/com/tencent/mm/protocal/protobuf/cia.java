package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cia
  extends com.tencent.mm.bx.a
{
  public int Eds;
  public String gGH;
  public String gGI;
  public String gGJ;
  public String gGK;
  public String gGL;
  public String gGM;
  public String gGN;
  public String gGO;
  public String gGP;
  public String gGQ;
  public String gGR;
  public String gGS;
  public boolean gGT;
  public int gGU;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(169219);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.gGH != null) {
        paramVarArgs.d(1, this.gGH);
      }
      if (this.gGI != null) {
        paramVarArgs.d(2, this.gGI);
      }
      if (this.gGJ != null) {
        paramVarArgs.d(3, this.gGJ);
      }
      if (this.gGK != null) {
        paramVarArgs.d(4, this.gGK);
      }
      if (this.gGL != null) {
        paramVarArgs.d(5, this.gGL);
      }
      if (this.gGM != null) {
        paramVarArgs.d(6, this.gGM);
      }
      if (this.gGN != null) {
        paramVarArgs.d(7, this.gGN);
      }
      if (this.gGO != null) {
        paramVarArgs.d(8, this.gGO);
      }
      if (this.gGP != null) {
        paramVarArgs.d(9, this.gGP);
      }
      if (this.gGQ != null) {
        paramVarArgs.d(10, this.gGQ);
      }
      paramVarArgs.aR(11, this.Eds);
      if (this.gGR != null) {
        paramVarArgs.d(12, this.gGR);
      }
      if (this.gGS != null) {
        paramVarArgs.d(13, this.gGS);
      }
      paramVarArgs.bg(14, this.gGT);
      paramVarArgs.aR(15, this.gGU);
      AppMethodBeat.o(169219);
      return 0;
    }
    if (paramInt == 1) {
      if (this.gGH == null) {
        break label1026;
      }
    }
    label1026:
    for (int i = f.a.a.b.b.a.e(1, this.gGH) + 0;; i = 0)
    {
      paramInt = i;
      if (this.gGI != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.gGI);
      }
      i = paramInt;
      if (this.gGJ != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.gGJ);
      }
      paramInt = i;
      if (this.gGK != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.gGK);
      }
      i = paramInt;
      if (this.gGL != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.gGL);
      }
      paramInt = i;
      if (this.gGM != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.gGM);
      }
      i = paramInt;
      if (this.gGN != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.gGN);
      }
      paramInt = i;
      if (this.gGO != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.gGO);
      }
      i = paramInt;
      if (this.gGP != null) {
        i = paramInt + f.a.a.b.b.a.e(9, this.gGP);
      }
      paramInt = i;
      if (this.gGQ != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.gGQ);
      }
      i = paramInt + f.a.a.b.b.a.bA(11, this.Eds);
      paramInt = i;
      if (this.gGR != null) {
        paramInt = i + f.a.a.b.b.a.e(12, this.gGR);
      }
      i = paramInt;
      if (this.gGS != null) {
        i = paramInt + f.a.a.b.b.a.e(13, this.gGS);
      }
      paramInt = f.a.a.b.b.a.fY(14);
      int j = f.a.a.b.b.a.bA(15, this.gGU);
      AppMethodBeat.o(169219);
      return i + (paramInt + 1) + j;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(169219);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        cia localcia = (cia)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(169219);
          return -1;
        case 1: 
          localcia.gGH = locala.KhF.readString();
          AppMethodBeat.o(169219);
          return 0;
        case 2: 
          localcia.gGI = locala.KhF.readString();
          AppMethodBeat.o(169219);
          return 0;
        case 3: 
          localcia.gGJ = locala.KhF.readString();
          AppMethodBeat.o(169219);
          return 0;
        case 4: 
          localcia.gGK = locala.KhF.readString();
          AppMethodBeat.o(169219);
          return 0;
        case 5: 
          localcia.gGL = locala.KhF.readString();
          AppMethodBeat.o(169219);
          return 0;
        case 6: 
          localcia.gGM = locala.KhF.readString();
          AppMethodBeat.o(169219);
          return 0;
        case 7: 
          localcia.gGN = locala.KhF.readString();
          AppMethodBeat.o(169219);
          return 0;
        case 8: 
          localcia.gGO = locala.KhF.readString();
          AppMethodBeat.o(169219);
          return 0;
        case 9: 
          localcia.gGP = locala.KhF.readString();
          AppMethodBeat.o(169219);
          return 0;
        case 10: 
          localcia.gGQ = locala.KhF.readString();
          AppMethodBeat.o(169219);
          return 0;
        case 11: 
          localcia.Eds = locala.KhF.xS();
          AppMethodBeat.o(169219);
          return 0;
        case 12: 
          localcia.gGR = locala.KhF.readString();
          AppMethodBeat.o(169219);
          return 0;
        case 13: 
          localcia.gGS = locala.KhF.readString();
          AppMethodBeat.o(169219);
          return 0;
        case 14: 
          localcia.gGT = locala.KhF.fHu();
          AppMethodBeat.o(169219);
          return 0;
        }
        localcia.gGU = locala.KhF.xS();
        AppMethodBeat.o(169219);
        return 0;
      }
      AppMethodBeat.o(169219);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cia
 * JD-Core Version:    0.7.0.1
 */