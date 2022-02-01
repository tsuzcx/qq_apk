package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class edn
  extends com.tencent.mm.bw.a
{
  public int Gat;
  public String Gav;
  public String NdO;
  public String NdP;
  public String NdQ;
  public int height;
  public int width;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(168761);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.Gat);
      if (this.Gav != null) {
        paramVarArgs.e(2, this.Gav);
      }
      if (this.NdO != null) {
        paramVarArgs.e(3, this.NdO);
      }
      paramVarArgs.aM(4, this.height);
      paramVarArgs.aM(5, this.width);
      if (this.NdP != null) {
        paramVarArgs.e(6, this.NdP);
      }
      if (this.NdQ != null) {
        paramVarArgs.e(7, this.NdQ);
      }
      AppMethodBeat.o(168761);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bu(1, this.Gat) + 0;
      paramInt = i;
      if (this.Gav != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.Gav);
      }
      i = paramInt;
      if (this.NdO != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.NdO);
      }
      i = i + g.a.a.b.b.a.bu(4, this.height) + g.a.a.b.b.a.bu(5, this.width);
      paramInt = i;
      if (this.NdP != null) {
        paramInt = i + g.a.a.b.b.a.f(6, this.NdP);
      }
      i = paramInt;
      if (this.NdQ != null) {
        i = paramInt + g.a.a.b.b.a.f(7, this.NdQ);
      }
      AppMethodBeat.o(168761);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(168761);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      edn localedn = (edn)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(168761);
        return -1;
      case 1: 
        localedn.Gat = locala.UbS.zi();
        AppMethodBeat.o(168761);
        return 0;
      case 2: 
        localedn.Gav = locala.UbS.readString();
        AppMethodBeat.o(168761);
        return 0;
      case 3: 
        localedn.NdO = locala.UbS.readString();
        AppMethodBeat.o(168761);
        return 0;
      case 4: 
        localedn.height = locala.UbS.zi();
        AppMethodBeat.o(168761);
        return 0;
      case 5: 
        localedn.width = locala.UbS.zi();
        AppMethodBeat.o(168761);
        return 0;
      case 6: 
        localedn.NdP = locala.UbS.readString();
        AppMethodBeat.o(168761);
        return 0;
      }
      localedn.NdQ = locala.UbS.readString();
      AppMethodBeat.o(168761);
      return 0;
    }
    AppMethodBeat.o(168761);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.edn
 * JD-Core Version:    0.7.0.1
 */