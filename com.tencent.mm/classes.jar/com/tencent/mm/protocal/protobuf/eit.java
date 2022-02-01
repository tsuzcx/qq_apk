package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;

public final class eit
  extends com.tencent.mm.cd.a
{
  public int CPw;
  public String UkA;
  public String UkB;
  public int UkC;
  public String UkD;
  public String UkE;
  public String UkF;
  public int UkG;
  public int UkH;
  public int UkI;
  public int UkJ;
  public int UkK;
  public String Ukz;
  public String Url;
  public String fwr;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117927);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Ukz == null)
      {
        paramVarArgs = new b("Not all required fields were included: PickedWord");
        AppMethodBeat.o(117927);
        throw paramVarArgs;
      }
      if (this.Ukz != null) {
        paramVarArgs.f(1, this.Ukz);
      }
      if (this.UkA != null) {
        paramVarArgs.f(2, this.UkA);
      }
      if (this.UkB != null) {
        paramVarArgs.f(3, this.UkB);
      }
      paramVarArgs.aY(4, this.CPw);
      paramVarArgs.aY(5, this.UkC);
      if (this.Url != null) {
        paramVarArgs.f(6, this.Url);
      }
      if (this.fwr != null) {
        paramVarArgs.f(7, this.fwr);
      }
      if (this.UkD != null) {
        paramVarArgs.f(8, this.UkD);
      }
      if (this.UkE != null) {
        paramVarArgs.f(9, this.UkE);
      }
      if (this.UkF != null) {
        paramVarArgs.f(10, this.UkF);
      }
      paramVarArgs.aY(11, this.UkG);
      paramVarArgs.aY(12, this.UkH);
      paramVarArgs.aY(13, this.UkI);
      paramVarArgs.aY(14, this.UkJ);
      paramVarArgs.aY(15, this.UkK);
      AppMethodBeat.o(117927);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Ukz == null) {
        break label1018;
      }
    }
    label1018:
    for (int i = g.a.a.b.b.a.g(1, this.Ukz) + 0;; i = 0)
    {
      paramInt = i;
      if (this.UkA != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.UkA);
      }
      i = paramInt;
      if (this.UkB != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.UkB);
      }
      i = i + g.a.a.b.b.a.bM(4, this.CPw) + g.a.a.b.b.a.bM(5, this.UkC);
      paramInt = i;
      if (this.Url != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.Url);
      }
      i = paramInt;
      if (this.fwr != null) {
        i = paramInt + g.a.a.b.b.a.g(7, this.fwr);
      }
      paramInt = i;
      if (this.UkD != null) {
        paramInt = i + g.a.a.b.b.a.g(8, this.UkD);
      }
      i = paramInt;
      if (this.UkE != null) {
        i = paramInt + g.a.a.b.b.a.g(9, this.UkE);
      }
      paramInt = i;
      if (this.UkF != null) {
        paramInt = i + g.a.a.b.b.a.g(10, this.UkF);
      }
      i = g.a.a.b.b.a.bM(11, this.UkG);
      int j = g.a.a.b.b.a.bM(12, this.UkH);
      int k = g.a.a.b.b.a.bM(13, this.UkI);
      int m = g.a.a.b.b.a.bM(14, this.UkJ);
      int n = g.a.a.b.b.a.bM(15, this.UkK);
      AppMethodBeat.o(117927);
      return paramInt + i + j + k + m + n;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.Ukz == null)
        {
          paramVarArgs = new b("Not all required fields were included: PickedWord");
          AppMethodBeat.o(117927);
          throw paramVarArgs;
        }
        AppMethodBeat.o(117927);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        eit localeit = (eit)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(117927);
          return -1;
        case 1: 
          localeit.Ukz = locala.abFh.readString();
          AppMethodBeat.o(117927);
          return 0;
        case 2: 
          localeit.UkA = locala.abFh.readString();
          AppMethodBeat.o(117927);
          return 0;
        case 3: 
          localeit.UkB = locala.abFh.readString();
          AppMethodBeat.o(117927);
          return 0;
        case 4: 
          localeit.CPw = locala.abFh.AK();
          AppMethodBeat.o(117927);
          return 0;
        case 5: 
          localeit.UkC = locala.abFh.AK();
          AppMethodBeat.o(117927);
          return 0;
        case 6: 
          localeit.Url = locala.abFh.readString();
          AppMethodBeat.o(117927);
          return 0;
        case 7: 
          localeit.fwr = locala.abFh.readString();
          AppMethodBeat.o(117927);
          return 0;
        case 8: 
          localeit.UkD = locala.abFh.readString();
          AppMethodBeat.o(117927);
          return 0;
        case 9: 
          localeit.UkE = locala.abFh.readString();
          AppMethodBeat.o(117927);
          return 0;
        case 10: 
          localeit.UkF = locala.abFh.readString();
          AppMethodBeat.o(117927);
          return 0;
        case 11: 
          localeit.UkG = locala.abFh.AK();
          AppMethodBeat.o(117927);
          return 0;
        case 12: 
          localeit.UkH = locala.abFh.AK();
          AppMethodBeat.o(117927);
          return 0;
        case 13: 
          localeit.UkI = locala.abFh.AK();
          AppMethodBeat.o(117927);
          return 0;
        case 14: 
          localeit.UkJ = locala.abFh.AK();
          AppMethodBeat.o(117927);
          return 0;
        }
        localeit.UkK = locala.abFh.AK();
        AppMethodBeat.o(117927);
        return 0;
      }
      AppMethodBeat.o(117927);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eit
 * JD-Core Version:    0.7.0.1
 */