package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class eng
  extends com.tencent.mm.cd.a
{
  public String CRQ;
  public String CRR;
  public int CreateTime;
  public long Id;
  public int IsNotRichText;
  public String ThumbUrl;
  public int Ulm;
  public int Uln;
  public int Ulr;
  public String UpX;
  public String UpY;
  public int UpZ;
  public int Uqa;
  public int Uqb;
  public String lpy;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(118438);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bm(1, this.Id);
      if (this.CRR != null) {
        paramVarArgs.f(2, this.CRR);
      }
      if (this.CRQ != null) {
        paramVarArgs.f(3, this.CRQ);
      }
      if (this.UpX != null) {
        paramVarArgs.f(4, this.UpX);
      }
      if (this.UpY != null) {
        paramVarArgs.f(5, this.UpY);
      }
      paramVarArgs.aY(6, this.CreateTime);
      if (this.lpy != null) {
        paramVarArgs.f(7, this.lpy);
      }
      paramVarArgs.aY(8, this.UpZ);
      paramVarArgs.aY(9, this.Ulr);
      paramVarArgs.aY(10, this.Ulm);
      paramVarArgs.aY(11, this.Uln);
      paramVarArgs.aY(12, this.IsNotRichText);
      if (this.ThumbUrl != null) {
        paramVarArgs.f(13, this.ThumbUrl);
      }
      paramVarArgs.aY(14, this.Uqa);
      paramVarArgs.aY(15, this.Uqb);
      AppMethodBeat.o(118438);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.p(1, this.Id) + 0;
      paramInt = i;
      if (this.CRR != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.CRR);
      }
      i = paramInt;
      if (this.CRQ != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.CRQ);
      }
      paramInt = i;
      if (this.UpX != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.UpX);
      }
      i = paramInt;
      if (this.UpY != null) {
        i = paramInt + g.a.a.b.b.a.g(5, this.UpY);
      }
      i += g.a.a.b.b.a.bM(6, this.CreateTime);
      paramInt = i;
      if (this.lpy != null) {
        paramInt = i + g.a.a.b.b.a.g(7, this.lpy);
      }
      i = paramInt + g.a.a.b.b.a.bM(8, this.UpZ) + g.a.a.b.b.a.bM(9, this.Ulr) + g.a.a.b.b.a.bM(10, this.Ulm) + g.a.a.b.b.a.bM(11, this.Uln) + g.a.a.b.b.a.bM(12, this.IsNotRichText);
      paramInt = i;
      if (this.ThumbUrl != null) {
        paramInt = i + g.a.a.b.b.a.g(13, this.ThumbUrl);
      }
      i = g.a.a.b.b.a.bM(14, this.Uqa);
      int j = g.a.a.b.b.a.bM(15, this.Uqb);
      AppMethodBeat.o(118438);
      return paramInt + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(118438);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      eng localeng = (eng)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(118438);
        return -1;
      case 1: 
        localeng.Id = locala.abFh.AN();
        AppMethodBeat.o(118438);
        return 0;
      case 2: 
        localeng.CRR = locala.abFh.readString();
        AppMethodBeat.o(118438);
        return 0;
      case 3: 
        localeng.CRQ = locala.abFh.readString();
        AppMethodBeat.o(118438);
        return 0;
      case 4: 
        localeng.UpX = locala.abFh.readString();
        AppMethodBeat.o(118438);
        return 0;
      case 5: 
        localeng.UpY = locala.abFh.readString();
        AppMethodBeat.o(118438);
        return 0;
      case 6: 
        localeng.CreateTime = locala.abFh.AK();
        AppMethodBeat.o(118438);
        return 0;
      case 7: 
        localeng.lpy = locala.abFh.readString();
        AppMethodBeat.o(118438);
        return 0;
      case 8: 
        localeng.UpZ = locala.abFh.AK();
        AppMethodBeat.o(118438);
        return 0;
      case 9: 
        localeng.Ulr = locala.abFh.AK();
        AppMethodBeat.o(118438);
        return 0;
      case 10: 
        localeng.Ulm = locala.abFh.AK();
        AppMethodBeat.o(118438);
        return 0;
      case 11: 
        localeng.Uln = locala.abFh.AK();
        AppMethodBeat.o(118438);
        return 0;
      case 12: 
        localeng.IsNotRichText = locala.abFh.AK();
        AppMethodBeat.o(118438);
        return 0;
      case 13: 
        localeng.ThumbUrl = locala.abFh.readString();
        AppMethodBeat.o(118438);
        return 0;
      case 14: 
        localeng.Uqa = locala.abFh.AK();
        AppMethodBeat.o(118438);
        return 0;
      }
      localeng.Uqb = locala.abFh.AK();
      AppMethodBeat.o(118438);
      return 0;
    }
    AppMethodBeat.o(118438);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eng
 * JD-Core Version:    0.7.0.1
 */