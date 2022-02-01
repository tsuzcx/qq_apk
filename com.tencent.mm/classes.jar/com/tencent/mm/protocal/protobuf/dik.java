package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;

public final class dik
  extends com.tencent.mm.cd.a
{
  public int CPw;
  public int HlG;
  public int RLs;
  public String TPK;
  public int TPL;
  public String TPM;
  public String TPN;
  public String TPO;
  public String TPP;
  public String TPQ;
  public int TPR;
  public String TPS;
  public String mVB;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(218736);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.TPK == null)
      {
        paramVarArgs = new b("Not all required fields were included: FileMD5");
        AppMethodBeat.o(218736);
        throw paramVarArgs;
      }
      paramVarArgs.aY(1, this.CPw);
      paramVarArgs.aY(2, this.RLs);
      paramVarArgs.aY(3, this.HlG);
      if (this.TPK != null) {
        paramVarArgs.f(4, this.TPK);
      }
      paramVarArgs.aY(5, this.TPL);
      if (this.TPM != null) {
        paramVarArgs.f(6, this.TPM);
      }
      if (this.TPN != null) {
        paramVarArgs.f(7, this.TPN);
      }
      if (this.TPO != null) {
        paramVarArgs.f(8, this.TPO);
      }
      if (this.TPP != null) {
        paramVarArgs.f(10, this.TPP);
      }
      if (this.TPQ != null) {
        paramVarArgs.f(11, this.TPQ);
      }
      paramVarArgs.aY(12, this.TPR);
      if (this.mVB != null) {
        paramVarArgs.f(13, this.mVB);
      }
      if (this.TPS != null) {
        paramVarArgs.f(14, this.TPS);
      }
      AppMethodBeat.o(218736);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bM(1, this.CPw) + 0 + g.a.a.b.b.a.bM(2, this.RLs) + g.a.a.b.b.a.bM(3, this.HlG);
      paramInt = i;
      if (this.TPK != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.TPK);
      }
      i = paramInt + g.a.a.b.b.a.bM(5, this.TPL);
      paramInt = i;
      if (this.TPM != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.TPM);
      }
      i = paramInt;
      if (this.TPN != null) {
        i = paramInt + g.a.a.b.b.a.g(7, this.TPN);
      }
      paramInt = i;
      if (this.TPO != null) {
        paramInt = i + g.a.a.b.b.a.g(8, this.TPO);
      }
      i = paramInt;
      if (this.TPP != null) {
        i = paramInt + g.a.a.b.b.a.g(10, this.TPP);
      }
      paramInt = i;
      if (this.TPQ != null) {
        paramInt = i + g.a.a.b.b.a.g(11, this.TPQ);
      }
      i = paramInt + g.a.a.b.b.a.bM(12, this.TPR);
      paramInt = i;
      if (this.mVB != null) {
        paramInt = i + g.a.a.b.b.a.g(13, this.mVB);
      }
      i = paramInt;
      if (this.TPS != null) {
        i = paramInt + g.a.a.b.b.a.g(14, this.TPS);
      }
      AppMethodBeat.o(218736);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      if (this.TPK == null)
      {
        paramVarArgs = new b("Not all required fields were included: FileMD5");
        AppMethodBeat.o(218736);
        throw paramVarArgs;
      }
      AppMethodBeat.o(218736);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      dik localdik = (dik)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      case 9: 
      default: 
        AppMethodBeat.o(218736);
        return -1;
      case 1: 
        localdik.CPw = locala.abFh.AK();
        AppMethodBeat.o(218736);
        return 0;
      case 2: 
        localdik.RLs = locala.abFh.AK();
        AppMethodBeat.o(218736);
        return 0;
      case 3: 
        localdik.HlG = locala.abFh.AK();
        AppMethodBeat.o(218736);
        return 0;
      case 4: 
        localdik.TPK = locala.abFh.readString();
        AppMethodBeat.o(218736);
        return 0;
      case 5: 
        localdik.TPL = locala.abFh.AK();
        AppMethodBeat.o(218736);
        return 0;
      case 6: 
        localdik.TPM = locala.abFh.readString();
        AppMethodBeat.o(218736);
        return 0;
      case 7: 
        localdik.TPN = locala.abFh.readString();
        AppMethodBeat.o(218736);
        return 0;
      case 8: 
        localdik.TPO = locala.abFh.readString();
        AppMethodBeat.o(218736);
        return 0;
      case 10: 
        localdik.TPP = locala.abFh.readString();
        AppMethodBeat.o(218736);
        return 0;
      case 11: 
        localdik.TPQ = locala.abFh.readString();
        AppMethodBeat.o(218736);
        return 0;
      case 12: 
        localdik.TPR = locala.abFh.AK();
        AppMethodBeat.o(218736);
        return 0;
      case 13: 
        localdik.mVB = locala.abFh.readString();
        AppMethodBeat.o(218736);
        return 0;
      }
      localdik.TPS = locala.abFh.readString();
      AppMethodBeat.o(218736);
      return 0;
    }
    AppMethodBeat.o(218736);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dik
 * JD-Core Version:    0.7.0.1
 */