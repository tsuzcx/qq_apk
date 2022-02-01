package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dcn
  extends com.tencent.mm.bw.a
{
  public float AAH;
  public String MHF;
  public String MHH;
  public String MHI;
  public String MHJ;
  public String MHK;
  public String MHL;
  public String MHM;
  public String MHN;
  public String MHO;
  public float MHP;
  public int MHQ;
  public String MHR;
  public LinkedList<String> MHS;
  public String MHT;
  
  public dcn()
  {
    AppMethodBeat.i(209790);
    this.MHS = new LinkedList();
    AppMethodBeat.o(209790);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(209791);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.MHH != null) {
        paramVarArgs.e(1, this.MHH);
      }
      paramVarArgs.E(2, this.AAH);
      if (this.MHI != null) {
        paramVarArgs.e(3, this.MHI);
      }
      if (this.MHJ != null) {
        paramVarArgs.e(4, this.MHJ);
      }
      if (this.MHF != null) {
        paramVarArgs.e(5, this.MHF);
      }
      if (this.MHK != null) {
        paramVarArgs.e(6, this.MHK);
      }
      if (this.MHL != null) {
        paramVarArgs.e(7, this.MHL);
      }
      if (this.MHM != null) {
        paramVarArgs.e(8, this.MHM);
      }
      if (this.MHN != null) {
        paramVarArgs.e(9, this.MHN);
      }
      if (this.MHO != null) {
        paramVarArgs.e(10, this.MHO);
      }
      paramVarArgs.E(11, this.MHP);
      paramVarArgs.aM(12, this.MHQ);
      if (this.MHR != null) {
        paramVarArgs.e(13, this.MHR);
      }
      paramVarArgs.e(14, 1, this.MHS);
      if (this.MHT != null) {
        paramVarArgs.e(101, this.MHT);
      }
      AppMethodBeat.o(209791);
      return 0;
    }
    if (paramInt == 1) {
      if (this.MHH == null) {
        break label1080;
      }
    }
    label1080:
    for (paramInt = g.a.a.b.b.a.f(1, this.MHH) + 0;; paramInt = 0)
    {
      int i = paramInt + (g.a.a.b.b.a.fS(2) + 4);
      paramInt = i;
      if (this.MHI != null) {
        paramInt = i + g.a.a.b.b.a.f(3, this.MHI);
      }
      i = paramInt;
      if (this.MHJ != null) {
        i = paramInt + g.a.a.b.b.a.f(4, this.MHJ);
      }
      paramInt = i;
      if (this.MHF != null) {
        paramInt = i + g.a.a.b.b.a.f(5, this.MHF);
      }
      i = paramInt;
      if (this.MHK != null) {
        i = paramInt + g.a.a.b.b.a.f(6, this.MHK);
      }
      paramInt = i;
      if (this.MHL != null) {
        paramInt = i + g.a.a.b.b.a.f(7, this.MHL);
      }
      i = paramInt;
      if (this.MHM != null) {
        i = paramInt + g.a.a.b.b.a.f(8, this.MHM);
      }
      paramInt = i;
      if (this.MHN != null) {
        paramInt = i + g.a.a.b.b.a.f(9, this.MHN);
      }
      i = paramInt;
      if (this.MHO != null) {
        i = paramInt + g.a.a.b.b.a.f(10, this.MHO);
      }
      i = i + (g.a.a.b.b.a.fS(11) + 4) + g.a.a.b.b.a.bu(12, this.MHQ);
      paramInt = i;
      if (this.MHR != null) {
        paramInt = i + g.a.a.b.b.a.f(13, this.MHR);
      }
      i = paramInt + g.a.a.a.c(14, 1, this.MHS);
      paramInt = i;
      if (this.MHT != null) {
        paramInt = i + g.a.a.b.b.a.f(101, this.MHT);
      }
      AppMethodBeat.o(209791);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.MHS.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(209791);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        dcn localdcn = (dcn)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(209791);
          return -1;
        case 1: 
          localdcn.MHH = locala.UbS.readString();
          AppMethodBeat.o(209791);
          return 0;
        case 2: 
          localdcn.AAH = Float.intBitsToFloat(locala.UbS.zm());
          AppMethodBeat.o(209791);
          return 0;
        case 3: 
          localdcn.MHI = locala.UbS.readString();
          AppMethodBeat.o(209791);
          return 0;
        case 4: 
          localdcn.MHJ = locala.UbS.readString();
          AppMethodBeat.o(209791);
          return 0;
        case 5: 
          localdcn.MHF = locala.UbS.readString();
          AppMethodBeat.o(209791);
          return 0;
        case 6: 
          localdcn.MHK = locala.UbS.readString();
          AppMethodBeat.o(209791);
          return 0;
        case 7: 
          localdcn.MHL = locala.UbS.readString();
          AppMethodBeat.o(209791);
          return 0;
        case 8: 
          localdcn.MHM = locala.UbS.readString();
          AppMethodBeat.o(209791);
          return 0;
        case 9: 
          localdcn.MHN = locala.UbS.readString();
          AppMethodBeat.o(209791);
          return 0;
        case 10: 
          localdcn.MHO = locala.UbS.readString();
          AppMethodBeat.o(209791);
          return 0;
        case 11: 
          localdcn.MHP = Float.intBitsToFloat(locala.UbS.zm());
          AppMethodBeat.o(209791);
          return 0;
        case 12: 
          localdcn.MHQ = locala.UbS.zi();
          AppMethodBeat.o(209791);
          return 0;
        case 13: 
          localdcn.MHR = locala.UbS.readString();
          AppMethodBeat.o(209791);
          return 0;
        case 14: 
          localdcn.MHS.add(locala.UbS.readString());
          AppMethodBeat.o(209791);
          return 0;
        }
        localdcn.MHT = locala.UbS.readString();
        AppMethodBeat.o(209791);
        return 0;
      }
      AppMethodBeat.o(209791);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dcn
 * JD-Core Version:    0.7.0.1
 */