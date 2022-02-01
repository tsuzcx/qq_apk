package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class fel
  extends com.tencent.mm.bw.a
{
  public int KRN;
  public String MOt;
  public int Mzg;
  public String NzF;
  public int NzG;
  public boolean NzH = false;
  public boolean NzI = false;
  public String session_id;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117961);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.KRN);
      paramVarArgs.aM(2, this.Mzg);
      if (this.session_id != null) {
        paramVarArgs.e(3, this.session_id);
      }
      if (this.NzF != null) {
        paramVarArgs.e(4, this.NzF);
      }
      if (this.MOt != null) {
        paramVarArgs.e(5, this.MOt);
      }
      paramVarArgs.aM(6, this.NzG);
      paramVarArgs.cc(7, this.NzH);
      paramVarArgs.cc(8, this.NzI);
      AppMethodBeat.o(117961);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bu(1, this.KRN) + 0 + g.a.a.b.b.a.bu(2, this.Mzg);
      paramInt = i;
      if (this.session_id != null) {
        paramInt = i + g.a.a.b.b.a.f(3, this.session_id);
      }
      i = paramInt;
      if (this.NzF != null) {
        i = paramInt + g.a.a.b.b.a.f(4, this.NzF);
      }
      paramInt = i;
      if (this.MOt != null) {
        paramInt = i + g.a.a.b.b.a.f(5, this.MOt);
      }
      i = g.a.a.b.b.a.bu(6, this.NzG);
      int j = g.a.a.b.b.a.fS(7);
      int k = g.a.a.b.b.a.fS(8);
      AppMethodBeat.o(117961);
      return paramInt + i + (j + 1) + (k + 1);
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(117961);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      fel localfel = (fel)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(117961);
        return -1;
      case 1: 
        localfel.KRN = locala.UbS.zi();
        AppMethodBeat.o(117961);
        return 0;
      case 2: 
        localfel.Mzg = locala.UbS.zi();
        AppMethodBeat.o(117961);
        return 0;
      case 3: 
        localfel.session_id = locala.UbS.readString();
        AppMethodBeat.o(117961);
        return 0;
      case 4: 
        localfel.NzF = locala.UbS.readString();
        AppMethodBeat.o(117961);
        return 0;
      case 5: 
        localfel.MOt = locala.UbS.readString();
        AppMethodBeat.o(117961);
        return 0;
      case 6: 
        localfel.NzG = locala.UbS.zi();
        AppMethodBeat.o(117961);
        return 0;
      case 7: 
        localfel.NzH = locala.UbS.yZ();
        AppMethodBeat.o(117961);
        return 0;
      }
      localfel.NzI = locala.UbS.yZ();
      AppMethodBeat.o(117961);
      return 0;
    }
    AppMethodBeat.o(117961);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fel
 * JD-Core Version:    0.7.0.1
 */