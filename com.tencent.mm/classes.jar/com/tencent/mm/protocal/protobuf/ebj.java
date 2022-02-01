package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.b;

public final class ebj
  extends com.tencent.mm.cd.a
{
  public String CNM;
  public String RRW;
  public int TxF;
  public String Ugk;
  public String Ugl;
  public b Ugm;
  public b Ugn;
  public b Ugo;
  public String Username;
  public String mVA;
  public String mVB;
  public String mVH;
  public int mVM;
  public int mVy;
  public String mVz;
  public String rWI;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(212109);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Username != null) {
        paramVarArgs.f(1, this.Username);
      }
      if (this.rWI != null) {
        paramVarArgs.f(2, this.rWI);
      }
      if (this.Ugk != null) {
        paramVarArgs.f(3, this.Ugk);
      }
      if (this.Ugl != null) {
        paramVarArgs.f(4, this.Ugl);
      }
      if (this.mVH != null) {
        paramVarArgs.f(5, this.mVH);
      }
      if (this.mVz != null) {
        paramVarArgs.f(6, this.mVz);
      }
      if (this.mVA != null) {
        paramVarArgs.f(7, this.mVA);
      }
      if (this.mVB != null) {
        paramVarArgs.f(8, this.mVB);
      }
      paramVarArgs.aY(9, this.mVy);
      paramVarArgs.aY(10, this.TxF);
      if (this.Ugm != null) {
        paramVarArgs.c(11, this.Ugm);
      }
      if (this.RRW != null) {
        paramVarArgs.f(12, this.RRW);
      }
      if (this.Ugn != null) {
        paramVarArgs.c(13, this.Ugn);
      }
      if (this.Ugo != null) {
        paramVarArgs.c(14, this.Ugo);
      }
      paramVarArgs.aY(15, this.mVM);
      if (this.CNM != null) {
        paramVarArgs.f(16, this.CNM);
      }
      AppMethodBeat.o(212109);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Username == null) {
        break label1086;
      }
    }
    label1086:
    for (int i = g.a.a.b.b.a.g(1, this.Username) + 0;; i = 0)
    {
      paramInt = i;
      if (this.rWI != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.rWI);
      }
      i = paramInt;
      if (this.Ugk != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.Ugk);
      }
      paramInt = i;
      if (this.Ugl != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.Ugl);
      }
      i = paramInt;
      if (this.mVH != null) {
        i = paramInt + g.a.a.b.b.a.g(5, this.mVH);
      }
      paramInt = i;
      if (this.mVz != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.mVz);
      }
      i = paramInt;
      if (this.mVA != null) {
        i = paramInt + g.a.a.b.b.a.g(7, this.mVA);
      }
      paramInt = i;
      if (this.mVB != null) {
        paramInt = i + g.a.a.b.b.a.g(8, this.mVB);
      }
      i = paramInt + g.a.a.b.b.a.bM(9, this.mVy) + g.a.a.b.b.a.bM(10, this.TxF);
      paramInt = i;
      if (this.Ugm != null) {
        paramInt = i + g.a.a.b.b.a.b(11, this.Ugm);
      }
      i = paramInt;
      if (this.RRW != null) {
        i = paramInt + g.a.a.b.b.a.g(12, this.RRW);
      }
      paramInt = i;
      if (this.Ugn != null) {
        paramInt = i + g.a.a.b.b.a.b(13, this.Ugn);
      }
      i = paramInt;
      if (this.Ugo != null) {
        i = paramInt + g.a.a.b.b.a.b(14, this.Ugo);
      }
      i += g.a.a.b.b.a.bM(15, this.mVM);
      paramInt = i;
      if (this.CNM != null) {
        paramInt = i + g.a.a.b.b.a.g(16, this.CNM);
      }
      AppMethodBeat.o(212109);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(212109);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        ebj localebj = (ebj)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(212109);
          return -1;
        case 1: 
          localebj.Username = locala.abFh.readString();
          AppMethodBeat.o(212109);
          return 0;
        case 2: 
          localebj.rWI = locala.abFh.readString();
          AppMethodBeat.o(212109);
          return 0;
        case 3: 
          localebj.Ugk = locala.abFh.readString();
          AppMethodBeat.o(212109);
          return 0;
        case 4: 
          localebj.Ugl = locala.abFh.readString();
          AppMethodBeat.o(212109);
          return 0;
        case 5: 
          localebj.mVH = locala.abFh.readString();
          AppMethodBeat.o(212109);
          return 0;
        case 6: 
          localebj.mVz = locala.abFh.readString();
          AppMethodBeat.o(212109);
          return 0;
        case 7: 
          localebj.mVA = locala.abFh.readString();
          AppMethodBeat.o(212109);
          return 0;
        case 8: 
          localebj.mVB = locala.abFh.readString();
          AppMethodBeat.o(212109);
          return 0;
        case 9: 
          localebj.mVy = locala.abFh.AK();
          AppMethodBeat.o(212109);
          return 0;
        case 10: 
          localebj.TxF = locala.abFh.AK();
          AppMethodBeat.o(212109);
          return 0;
        case 11: 
          localebj.Ugm = locala.abFh.iUw();
          AppMethodBeat.o(212109);
          return 0;
        case 12: 
          localebj.RRW = locala.abFh.readString();
          AppMethodBeat.o(212109);
          return 0;
        case 13: 
          localebj.Ugn = locala.abFh.iUw();
          AppMethodBeat.o(212109);
          return 0;
        case 14: 
          localebj.Ugo = locala.abFh.iUw();
          AppMethodBeat.o(212109);
          return 0;
        case 15: 
          localebj.mVM = locala.abFh.AK();
          AppMethodBeat.o(212109);
          return 0;
        }
        localebj.CNM = locala.abFh.readString();
        AppMethodBeat.o(212109);
        return 0;
      }
      AppMethodBeat.o(212109);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ebj
 * JD-Core Version:    0.7.0.1
 */