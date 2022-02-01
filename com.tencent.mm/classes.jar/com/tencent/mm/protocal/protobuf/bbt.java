package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bbt
  extends com.tencent.mm.cd.a
{
  public String EyH;
  public String OIw;
  public int SNA;
  public int SNz;
  public int tpK;
  public String ufC;
  public String wording;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(229271);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.OIw != null) {
        paramVarArgs.f(1, this.OIw);
      }
      if (this.ufC != null) {
        paramVarArgs.f(2, this.ufC);
      }
      if (this.wording != null) {
        paramVarArgs.f(3, this.wording);
      }
      paramVarArgs.aY(4, this.tpK);
      if (this.EyH != null) {
        paramVarArgs.f(5, this.EyH);
      }
      paramVarArgs.aY(6, this.SNz);
      paramVarArgs.aY(7, this.SNA);
      AppMethodBeat.o(229271);
      return 0;
    }
    if (paramInt == 1) {
      if (this.OIw == null) {
        break label534;
      }
    }
    label534:
    for (int i = g.a.a.b.b.a.g(1, this.OIw) + 0;; i = 0)
    {
      paramInt = i;
      if (this.ufC != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.ufC);
      }
      i = paramInt;
      if (this.wording != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.wording);
      }
      i += g.a.a.b.b.a.bM(4, this.tpK);
      paramInt = i;
      if (this.EyH != null) {
        paramInt = i + g.a.a.b.b.a.g(5, this.EyH);
      }
      i = g.a.a.b.b.a.bM(6, this.SNz);
      int j = g.a.a.b.b.a.bM(7, this.SNA);
      AppMethodBeat.o(229271);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(229271);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        bbt localbbt = (bbt)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(229271);
          return -1;
        case 1: 
          localbbt.OIw = locala.abFh.readString();
          AppMethodBeat.o(229271);
          return 0;
        case 2: 
          localbbt.ufC = locala.abFh.readString();
          AppMethodBeat.o(229271);
          return 0;
        case 3: 
          localbbt.wording = locala.abFh.readString();
          AppMethodBeat.o(229271);
          return 0;
        case 4: 
          localbbt.tpK = locala.abFh.AK();
          AppMethodBeat.o(229271);
          return 0;
        case 5: 
          localbbt.EyH = locala.abFh.readString();
          AppMethodBeat.o(229271);
          return 0;
        case 6: 
          localbbt.SNz = locala.abFh.AK();
          AppMethodBeat.o(229271);
          return 0;
        }
        localbbt.SNA = locala.abFh.AK();
        AppMethodBeat.o(229271);
        return 0;
      }
      AppMethodBeat.o(229271);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bbt
 * JD-Core Version:    0.7.0.1
 */