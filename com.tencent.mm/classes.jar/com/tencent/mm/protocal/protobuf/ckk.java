package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ckk
  extends com.tencent.mm.cd.a
{
  public String CQz;
  public String Sls;
  public String TrZ;
  public String Tsa;
  public String Tsb;
  public String Tsc;
  public int Tsd;
  public String Tse;
  public String Url;
  public String fwr;
  public int rWu;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32327);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.fwr != null) {
        paramVarArgs.f(1, this.fwr);
      }
      if (this.TrZ != null) {
        paramVarArgs.f(2, this.TrZ);
      }
      paramVarArgs.aY(3, this.rWu);
      if (this.Url != null) {
        paramVarArgs.f(4, this.Url);
      }
      if (this.Tsa != null) {
        paramVarArgs.f(5, this.Tsa);
      }
      if (this.Sls != null) {
        paramVarArgs.f(6, this.Sls);
      }
      if (this.Tsb != null) {
        paramVarArgs.f(7, this.Tsb);
      }
      if (this.CQz != null) {
        paramVarArgs.f(8, this.CQz);
      }
      if (this.Tsc != null) {
        paramVarArgs.f(9, this.Tsc);
      }
      paramVarArgs.aY(10, this.Tsd);
      if (this.Tse != null) {
        paramVarArgs.f(11, this.Tse);
      }
      AppMethodBeat.o(32327);
      return 0;
    }
    if (paramInt == 1) {
      if (this.fwr == null) {
        break label811;
      }
    }
    label811:
    for (paramInt = g.a.a.b.b.a.g(1, this.fwr) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.TrZ != null) {
        i = paramInt + g.a.a.b.b.a.g(2, this.TrZ);
      }
      i += g.a.a.b.b.a.bM(3, this.rWu);
      paramInt = i;
      if (this.Url != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.Url);
      }
      i = paramInt;
      if (this.Tsa != null) {
        i = paramInt + g.a.a.b.b.a.g(5, this.Tsa);
      }
      paramInt = i;
      if (this.Sls != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.Sls);
      }
      i = paramInt;
      if (this.Tsb != null) {
        i = paramInt + g.a.a.b.b.a.g(7, this.Tsb);
      }
      paramInt = i;
      if (this.CQz != null) {
        paramInt = i + g.a.a.b.b.a.g(8, this.CQz);
      }
      i = paramInt;
      if (this.Tsc != null) {
        i = paramInt + g.a.a.b.b.a.g(9, this.Tsc);
      }
      i += g.a.a.b.b.a.bM(10, this.Tsd);
      paramInt = i;
      if (this.Tse != null) {
        paramInt = i + g.a.a.b.b.a.g(11, this.Tse);
      }
      AppMethodBeat.o(32327);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(32327);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        ckk localckk = (ckk)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(32327);
          return -1;
        case 1: 
          localckk.fwr = locala.abFh.readString();
          AppMethodBeat.o(32327);
          return 0;
        case 2: 
          localckk.TrZ = locala.abFh.readString();
          AppMethodBeat.o(32327);
          return 0;
        case 3: 
          localckk.rWu = locala.abFh.AK();
          AppMethodBeat.o(32327);
          return 0;
        case 4: 
          localckk.Url = locala.abFh.readString();
          AppMethodBeat.o(32327);
          return 0;
        case 5: 
          localckk.Tsa = locala.abFh.readString();
          AppMethodBeat.o(32327);
          return 0;
        case 6: 
          localckk.Sls = locala.abFh.readString();
          AppMethodBeat.o(32327);
          return 0;
        case 7: 
          localckk.Tsb = locala.abFh.readString();
          AppMethodBeat.o(32327);
          return 0;
        case 8: 
          localckk.CQz = locala.abFh.readString();
          AppMethodBeat.o(32327);
          return 0;
        case 9: 
          localckk.Tsc = locala.abFh.readString();
          AppMethodBeat.o(32327);
          return 0;
        case 10: 
          localckk.Tsd = locala.abFh.AK();
          AppMethodBeat.o(32327);
          return 0;
        }
        localckk.Tse = locala.abFh.readString();
        AppMethodBeat.o(32327);
        return 0;
      }
      AppMethodBeat.o(32327);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ckk
 * JD-Core Version:    0.7.0.1
 */