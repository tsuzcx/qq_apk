package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;

public final class bnn
  extends com.tencent.mm.cd.a
{
  public String CMB;
  public String CQz;
  public int ChC;
  public int SYG;
  public int SYH;
  public String SYm;
  public String ThumbUrl;
  public String fwr;
  public String lVG;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(42646);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.fwr == null)
      {
        paramVarArgs = new b("Not all required fields were included: Title");
        AppMethodBeat.o(42646);
        throw paramVarArgs;
      }
      if (this.CMB == null)
      {
        paramVarArgs = new b("Not all required fields were included: Desc");
        AppMethodBeat.o(42646);
        throw paramVarArgs;
      }
      if (this.ThumbUrl == null)
      {
        paramVarArgs = new b("Not all required fields were included: ThumbUrl");
        AppMethodBeat.o(42646);
        throw paramVarArgs;
      }
      if (this.fwr != null) {
        paramVarArgs.f(1, this.fwr);
      }
      if (this.CMB != null) {
        paramVarArgs.f(2, this.CMB);
      }
      if (this.ThumbUrl != null) {
        paramVarArgs.f(3, this.ThumbUrl);
      }
      if (this.SYm != null) {
        paramVarArgs.f(4, this.SYm);
      }
      paramVarArgs.aY(5, this.SYG);
      paramVarArgs.aY(6, this.SYH);
      if (this.lVG != null) {
        paramVarArgs.f(7, this.lVG);
      }
      paramVarArgs.aY(8, this.ChC);
      if (this.CQz != null) {
        paramVarArgs.f(9, this.CQz);
      }
      AppMethodBeat.o(42646);
      return 0;
    }
    if (paramInt == 1) {
      if (this.fwr == null) {
        break label798;
      }
    }
    label798:
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
      if (this.SYm != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.SYm);
      }
      i = paramInt + g.a.a.b.b.a.bM(5, this.SYG) + g.a.a.b.b.a.bM(6, this.SYH);
      paramInt = i;
      if (this.lVG != null) {
        paramInt = i + g.a.a.b.b.a.g(7, this.lVG);
      }
      i = paramInt + g.a.a.b.b.a.bM(8, this.ChC);
      paramInt = i;
      if (this.CQz != null) {
        paramInt = i + g.a.a.b.b.a.g(9, this.CQz);
      }
      AppMethodBeat.o(42646);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.fwr == null)
        {
          paramVarArgs = new b("Not all required fields were included: Title");
          AppMethodBeat.o(42646);
          throw paramVarArgs;
        }
        if (this.CMB == null)
        {
          paramVarArgs = new b("Not all required fields were included: Desc");
          AppMethodBeat.o(42646);
          throw paramVarArgs;
        }
        if (this.ThumbUrl == null)
        {
          paramVarArgs = new b("Not all required fields were included: ThumbUrl");
          AppMethodBeat.o(42646);
          throw paramVarArgs;
        }
        AppMethodBeat.o(42646);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        bnn localbnn = (bnn)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(42646);
          return -1;
        case 1: 
          localbnn.fwr = locala.abFh.readString();
          AppMethodBeat.o(42646);
          return 0;
        case 2: 
          localbnn.CMB = locala.abFh.readString();
          AppMethodBeat.o(42646);
          return 0;
        case 3: 
          localbnn.ThumbUrl = locala.abFh.readString();
          AppMethodBeat.o(42646);
          return 0;
        case 4: 
          localbnn.SYm = locala.abFh.readString();
          AppMethodBeat.o(42646);
          return 0;
        case 5: 
          localbnn.SYG = locala.abFh.AK();
          AppMethodBeat.o(42646);
          return 0;
        case 6: 
          localbnn.SYH = locala.abFh.AK();
          AppMethodBeat.o(42646);
          return 0;
        case 7: 
          localbnn.lVG = locala.abFh.readString();
          AppMethodBeat.o(42646);
          return 0;
        case 8: 
          localbnn.ChC = locala.abFh.AK();
          AppMethodBeat.o(42646);
          return 0;
        }
        localbnn.CQz = locala.abFh.readString();
        AppMethodBeat.o(42646);
        return 0;
      }
      AppMethodBeat.o(42646);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bnn
 * JD-Core Version:    0.7.0.1
 */