package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class akh
  extends com.tencent.mm.cd.a
{
  public String CNj;
  public String ProductID;
  public String SuH;
  public String Suv;
  public int Svi;
  public int TOG;
  public String Tev;
  public String Tew;
  public String Tex;
  public int Tey;
  public String Ufx;
  public String VHB;
  public String VHC;
  public String VHD;
  public String VHH;
  public String VHO;
  public String VHP;
  public String VHQ;
  public String VHR;
  public int Vdr;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(104781);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.ProductID != null) {
        paramVarArgs.f(1, this.ProductID);
      }
      if (this.CNj != null) {
        paramVarArgs.f(2, this.CNj);
      }
      if (this.Suv != null) {
        paramVarArgs.f(3, this.Suv);
      }
      if (this.Tev != null) {
        paramVarArgs.f(4, this.Tev);
      }
      if (this.Tew != null) {
        paramVarArgs.f(5, this.Tew);
      }
      if (this.Tex != null) {
        paramVarArgs.f(6, this.Tex);
      }
      paramVarArgs.aY(7, this.Tey);
      paramVarArgs.aY(8, this.TOG);
      if (this.Ufx != null) {
        paramVarArgs.f(9, this.Ufx);
      }
      paramVarArgs.aY(10, this.Vdr);
      if (this.VHB != null) {
        paramVarArgs.f(11, this.VHB);
      }
      paramVarArgs.aY(12, this.Svi);
      if (this.VHD != null) {
        paramVarArgs.f(13, this.VHD);
      }
      if (this.VHC != null) {
        paramVarArgs.f(14, this.VHC);
      }
      if (this.SuH != null) {
        paramVarArgs.f(15, this.SuH);
      }
      if (this.VHO != null) {
        paramVarArgs.f(16, this.VHO);
      }
      if (this.VHH != null) {
        paramVarArgs.f(17, this.VHH);
      }
      if (this.VHP != null) {
        paramVarArgs.f(18, this.VHP);
      }
      if (this.VHQ != null) {
        paramVarArgs.f(19, this.VHQ);
      }
      if (this.VHR != null) {
        paramVarArgs.f(20, this.VHR);
      }
      AppMethodBeat.o(104781);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ProductID == null) {
        break label1318;
      }
    }
    label1318:
    for (int i = g.a.a.b.b.a.g(1, this.ProductID) + 0;; i = 0)
    {
      paramInt = i;
      if (this.CNj != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.CNj);
      }
      i = paramInt;
      if (this.Suv != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.Suv);
      }
      paramInt = i;
      if (this.Tev != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.Tev);
      }
      i = paramInt;
      if (this.Tew != null) {
        i = paramInt + g.a.a.b.b.a.g(5, this.Tew);
      }
      paramInt = i;
      if (this.Tex != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.Tex);
      }
      i = paramInt + g.a.a.b.b.a.bM(7, this.Tey) + g.a.a.b.b.a.bM(8, this.TOG);
      paramInt = i;
      if (this.Ufx != null) {
        paramInt = i + g.a.a.b.b.a.g(9, this.Ufx);
      }
      i = paramInt + g.a.a.b.b.a.bM(10, this.Vdr);
      paramInt = i;
      if (this.VHB != null) {
        paramInt = i + g.a.a.b.b.a.g(11, this.VHB);
      }
      i = paramInt + g.a.a.b.b.a.bM(12, this.Svi);
      paramInt = i;
      if (this.VHD != null) {
        paramInt = i + g.a.a.b.b.a.g(13, this.VHD);
      }
      i = paramInt;
      if (this.VHC != null) {
        i = paramInt + g.a.a.b.b.a.g(14, this.VHC);
      }
      paramInt = i;
      if (this.SuH != null) {
        paramInt = i + g.a.a.b.b.a.g(15, this.SuH);
      }
      i = paramInt;
      if (this.VHO != null) {
        i = paramInt + g.a.a.b.b.a.g(16, this.VHO);
      }
      paramInt = i;
      if (this.VHH != null) {
        paramInt = i + g.a.a.b.b.a.g(17, this.VHH);
      }
      i = paramInt;
      if (this.VHP != null) {
        i = paramInt + g.a.a.b.b.a.g(18, this.VHP);
      }
      paramInt = i;
      if (this.VHQ != null) {
        paramInt = i + g.a.a.b.b.a.g(19, this.VHQ);
      }
      i = paramInt;
      if (this.VHR != null) {
        i = paramInt + g.a.a.b.b.a.g(20, this.VHR);
      }
      AppMethodBeat.o(104781);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(104781);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        akh localakh = (akh)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(104781);
          return -1;
        case 1: 
          localakh.ProductID = locala.abFh.readString();
          AppMethodBeat.o(104781);
          return 0;
        case 2: 
          localakh.CNj = locala.abFh.readString();
          AppMethodBeat.o(104781);
          return 0;
        case 3: 
          localakh.Suv = locala.abFh.readString();
          AppMethodBeat.o(104781);
          return 0;
        case 4: 
          localakh.Tev = locala.abFh.readString();
          AppMethodBeat.o(104781);
          return 0;
        case 5: 
          localakh.Tew = locala.abFh.readString();
          AppMethodBeat.o(104781);
          return 0;
        case 6: 
          localakh.Tex = locala.abFh.readString();
          AppMethodBeat.o(104781);
          return 0;
        case 7: 
          localakh.Tey = locala.abFh.AK();
          AppMethodBeat.o(104781);
          return 0;
        case 8: 
          localakh.TOG = locala.abFh.AK();
          AppMethodBeat.o(104781);
          return 0;
        case 9: 
          localakh.Ufx = locala.abFh.readString();
          AppMethodBeat.o(104781);
          return 0;
        case 10: 
          localakh.Vdr = locala.abFh.AK();
          AppMethodBeat.o(104781);
          return 0;
        case 11: 
          localakh.VHB = locala.abFh.readString();
          AppMethodBeat.o(104781);
          return 0;
        case 12: 
          localakh.Svi = locala.abFh.AK();
          AppMethodBeat.o(104781);
          return 0;
        case 13: 
          localakh.VHD = locala.abFh.readString();
          AppMethodBeat.o(104781);
          return 0;
        case 14: 
          localakh.VHC = locala.abFh.readString();
          AppMethodBeat.o(104781);
          return 0;
        case 15: 
          localakh.SuH = locala.abFh.readString();
          AppMethodBeat.o(104781);
          return 0;
        case 16: 
          localakh.VHO = locala.abFh.readString();
          AppMethodBeat.o(104781);
          return 0;
        case 17: 
          localakh.VHH = locala.abFh.readString();
          AppMethodBeat.o(104781);
          return 0;
        case 18: 
          localakh.VHP = locala.abFh.readString();
          AppMethodBeat.o(104781);
          return 0;
        case 19: 
          localakh.VHQ = locala.abFh.readString();
          AppMethodBeat.o(104781);
          return 0;
        }
        localakh.VHR = locala.abFh.readString();
        AppMethodBeat.o(104781);
        return 0;
      }
      AppMethodBeat.o(104781);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.akh
 * JD-Core Version:    0.7.0.1
 */