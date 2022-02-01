package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class dhe
  extends com.tencent.mm.cd.a
{
  public String CMP;
  public String GtP;
  public double RVy;
  public double RVz;
  public String Srf;
  public String Srg;
  public String TOk;
  public String TOl;
  public String TOm;
  public String TOn;
  public String mVA;
  public String mVz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(56257);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.CMP != null) {
        paramVarArgs.f(1, this.CMP);
      }
      if (this.TOk != null) {
        paramVarArgs.f(2, this.TOk);
      }
      paramVarArgs.e(3, this.RVy);
      paramVarArgs.e(4, this.RVz);
      if (this.TOl != null) {
        paramVarArgs.f(5, this.TOl);
      }
      if (this.GtP != null) {
        paramVarArgs.f(6, this.GtP);
      }
      if (this.TOm != null) {
        paramVarArgs.f(7, this.TOm);
      }
      if (this.mVz != null) {
        paramVarArgs.f(8, this.mVz);
      }
      if (this.mVA != null) {
        paramVarArgs.f(9, this.mVA);
      }
      if (this.Srf != null) {
        paramVarArgs.f(10, this.Srf);
      }
      if (this.Srg != null) {
        paramVarArgs.f(11, this.Srg);
      }
      if (this.TOn != null) {
        paramVarArgs.f(12, this.TOn);
      }
      AppMethodBeat.o(56257);
      return 0;
    }
    if (paramInt == 1) {
      if (this.CMP == null) {
        break label860;
      }
    }
    label860:
    for (paramInt = g.a.a.b.b.a.g(1, this.CMP) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.TOk != null) {
        i = paramInt + g.a.a.b.b.a.g(2, this.TOk);
      }
      i = i + (g.a.a.b.b.a.gL(3) + 8) + (g.a.a.b.b.a.gL(4) + 8);
      paramInt = i;
      if (this.TOl != null) {
        paramInt = i + g.a.a.b.b.a.g(5, this.TOl);
      }
      i = paramInt;
      if (this.GtP != null) {
        i = paramInt + g.a.a.b.b.a.g(6, this.GtP);
      }
      paramInt = i;
      if (this.TOm != null) {
        paramInt = i + g.a.a.b.b.a.g(7, this.TOm);
      }
      i = paramInt;
      if (this.mVz != null) {
        i = paramInt + g.a.a.b.b.a.g(8, this.mVz);
      }
      paramInt = i;
      if (this.mVA != null) {
        paramInt = i + g.a.a.b.b.a.g(9, this.mVA);
      }
      i = paramInt;
      if (this.Srf != null) {
        i = paramInt + g.a.a.b.b.a.g(10, this.Srf);
      }
      paramInt = i;
      if (this.Srg != null) {
        paramInt = i + g.a.a.b.b.a.g(11, this.Srg);
      }
      i = paramInt;
      if (this.TOn != null) {
        i = paramInt + g.a.a.b.b.a.g(12, this.TOn);
      }
      AppMethodBeat.o(56257);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(56257);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        dhe localdhe = (dhe)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(56257);
          return -1;
        case 1: 
          localdhe.CMP = locala.abFh.readString();
          AppMethodBeat.o(56257);
          return 0;
        case 2: 
          localdhe.TOk = locala.abFh.readString();
          AppMethodBeat.o(56257);
          return 0;
        case 3: 
          localdhe.RVy = Double.longBitsToDouble(locala.abFh.AP());
          AppMethodBeat.o(56257);
          return 0;
        case 4: 
          localdhe.RVz = Double.longBitsToDouble(locala.abFh.AP());
          AppMethodBeat.o(56257);
          return 0;
        case 5: 
          localdhe.TOl = locala.abFh.readString();
          AppMethodBeat.o(56257);
          return 0;
        case 6: 
          localdhe.GtP = locala.abFh.readString();
          AppMethodBeat.o(56257);
          return 0;
        case 7: 
          localdhe.TOm = locala.abFh.readString();
          AppMethodBeat.o(56257);
          return 0;
        case 8: 
          localdhe.mVz = locala.abFh.readString();
          AppMethodBeat.o(56257);
          return 0;
        case 9: 
          localdhe.mVA = locala.abFh.readString();
          AppMethodBeat.o(56257);
          return 0;
        case 10: 
          localdhe.Srf = locala.abFh.readString();
          AppMethodBeat.o(56257);
          return 0;
        case 11: 
          localdhe.Srg = locala.abFh.readString();
          AppMethodBeat.o(56257);
          return 0;
        }
        localdhe.TOn = locala.abFh.readString();
        AppMethodBeat.o(56257);
        return 0;
      }
      AppMethodBeat.o(56257);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dhe
 * JD-Core Version:    0.7.0.1
 */