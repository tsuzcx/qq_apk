package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ebk
  extends com.tencent.mm.cd.a
{
  public String CMB;
  public String GtP;
  public int Height;
  public String ThumbUrl;
  public String Ugp;
  public String Ugq;
  public int Ugr;
  public int Width;
  public String fwr;
  public int lpx;
  public String sSY;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(211228);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.fwr != null) {
        paramVarArgs.f(1, this.fwr);
      }
      if (this.CMB != null) {
        paramVarArgs.f(2, this.CMB);
      }
      if (this.ThumbUrl != null) {
        paramVarArgs.f(3, this.ThumbUrl);
      }
      if (this.GtP != null) {
        paramVarArgs.f(4, this.GtP);
      }
      paramVarArgs.aY(5, this.lpx);
      if (this.Ugp != null) {
        paramVarArgs.f(6, this.Ugp);
      }
      if (this.Ugq != null) {
        paramVarArgs.f(7, this.Ugq);
      }
      if (this.sSY != null) {
        paramVarArgs.f(8, this.sSY);
      }
      paramVarArgs.aY(9, this.Ugr);
      paramVarArgs.aY(10, this.Width);
      paramVarArgs.aY(11, this.Height);
      AppMethodBeat.o(211228);
      return 0;
    }
    if (paramInt == 1) {
      if (this.fwr == null) {
        break label766;
      }
    }
    label766:
    for (int i = g.a.a.b.b.a.g(1, this.fwr) + 0;; i = 0)
    {
      paramInt = i;
      if (this.CMB != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.CMB);
      }
      i = paramInt;
      if (this.ThumbUrl != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.ThumbUrl);
      }
      paramInt = i;
      if (this.GtP != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.GtP);
      }
      i = paramInt + g.a.a.b.b.a.bM(5, this.lpx);
      paramInt = i;
      if (this.Ugp != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.Ugp);
      }
      i = paramInt;
      if (this.Ugq != null) {
        i = paramInt + g.a.a.b.b.a.g(7, this.Ugq);
      }
      paramInt = i;
      if (this.sSY != null) {
        paramInt = i + g.a.a.b.b.a.g(8, this.sSY);
      }
      i = g.a.a.b.b.a.bM(9, this.Ugr);
      int j = g.a.a.b.b.a.bM(10, this.Width);
      int k = g.a.a.b.b.a.bM(11, this.Height);
      AppMethodBeat.o(211228);
      return paramInt + i + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(211228);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        ebk localebk = (ebk)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(211228);
          return -1;
        case 1: 
          localebk.fwr = locala.abFh.readString();
          AppMethodBeat.o(211228);
          return 0;
        case 2: 
          localebk.CMB = locala.abFh.readString();
          AppMethodBeat.o(211228);
          return 0;
        case 3: 
          localebk.ThumbUrl = locala.abFh.readString();
          AppMethodBeat.o(211228);
          return 0;
        case 4: 
          localebk.GtP = locala.abFh.readString();
          AppMethodBeat.o(211228);
          return 0;
        case 5: 
          localebk.lpx = locala.abFh.AK();
          AppMethodBeat.o(211228);
          return 0;
        case 6: 
          localebk.Ugp = locala.abFh.readString();
          AppMethodBeat.o(211228);
          return 0;
        case 7: 
          localebk.Ugq = locala.abFh.readString();
          AppMethodBeat.o(211228);
          return 0;
        case 8: 
          localebk.sSY = locala.abFh.readString();
          AppMethodBeat.o(211228);
          return 0;
        case 9: 
          localebk.Ugr = locala.abFh.AK();
          AppMethodBeat.o(211228);
          return 0;
        case 10: 
          localebk.Width = locala.abFh.AK();
          AppMethodBeat.o(211228);
          return 0;
        }
        localebk.Height = locala.abFh.AK();
        AppMethodBeat.o(211228);
        return 0;
      }
      AppMethodBeat.o(211228);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ebk
 * JD-Core Version:    0.7.0.1
 */