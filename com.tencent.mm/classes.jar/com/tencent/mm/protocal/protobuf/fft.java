package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class fft
  extends com.tencent.mm.cd.a
{
  public float RHI;
  public String Spt;
  public String UGe;
  public String UGf;
  public String UGg;
  public int UGh;
  public float UGi;
  public String UGj;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(147791);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.UGe != null) {
        paramVarArgs.f(1, this.UGe);
      }
      if (this.Spt != null) {
        paramVarArgs.f(2, this.Spt);
      }
      if (this.UGf != null) {
        paramVarArgs.f(3, this.UGf);
      }
      if (this.UGg != null) {
        paramVarArgs.f(4, this.UGg);
      }
      paramVarArgs.aY(5, this.UGh);
      paramVarArgs.i(6, this.RHI);
      paramVarArgs.i(7, this.UGi);
      if (this.UGj != null) {
        paramVarArgs.f(8, this.UGj);
      }
      AppMethodBeat.o(147791);
      return 0;
    }
    if (paramInt == 1) {
      if (this.UGe == null) {
        break label592;
      }
    }
    label592:
    for (int i = g.a.a.b.b.a.g(1, this.UGe) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Spt != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.Spt);
      }
      i = paramInt;
      if (this.UGf != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.UGf);
      }
      paramInt = i;
      if (this.UGg != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.UGg);
      }
      i = paramInt + g.a.a.b.b.a.bM(5, this.UGh) + (g.a.a.b.b.a.gL(6) + 4) + (g.a.a.b.b.a.gL(7) + 4);
      paramInt = i;
      if (this.UGj != null) {
        paramInt = i + g.a.a.b.b.a.g(8, this.UGj);
      }
      AppMethodBeat.o(147791);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(147791);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        fft localfft = (fft)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(147791);
          return -1;
        case 1: 
          localfft.UGe = locala.abFh.readString();
          AppMethodBeat.o(147791);
          return 0;
        case 2: 
          localfft.Spt = locala.abFh.readString();
          AppMethodBeat.o(147791);
          return 0;
        case 3: 
          localfft.UGf = locala.abFh.readString();
          AppMethodBeat.o(147791);
          return 0;
        case 4: 
          localfft.UGg = locala.abFh.readString();
          AppMethodBeat.o(147791);
          return 0;
        case 5: 
          localfft.UGh = locala.abFh.AK();
          AppMethodBeat.o(147791);
          return 0;
        case 6: 
          localfft.RHI = Float.intBitsToFloat(locala.abFh.AO());
          AppMethodBeat.o(147791);
          return 0;
        case 7: 
          localfft.UGi = Float.intBitsToFloat(locala.abFh.AO());
          AppMethodBeat.o(147791);
          return 0;
        }
        localfft.UGj = locala.abFh.readString();
        AppMethodBeat.o(147791);
        return 0;
      }
      AppMethodBeat.o(147791);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fft
 * JD-Core Version:    0.7.0.1
 */