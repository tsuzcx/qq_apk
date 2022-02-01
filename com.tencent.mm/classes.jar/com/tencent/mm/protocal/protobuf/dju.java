package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dju
  extends com.tencent.mm.bw.a
{
  public int KCl;
  public String lHA;
  public String lHB;
  public String yXJ;
  public String yXK;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91658);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.KCl);
      if (this.yXJ != null) {
        paramVarArgs.e(2, this.yXJ);
      }
      if (this.lHA != null) {
        paramVarArgs.e(3, this.lHA);
      }
      if (this.lHB != null) {
        paramVarArgs.e(4, this.lHB);
      }
      if (this.yXK != null) {
        paramVarArgs.e(5, this.yXK);
      }
      AppMethodBeat.o(91658);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bu(1, this.KCl) + 0;
      paramInt = i;
      if (this.yXJ != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.yXJ);
      }
      i = paramInt;
      if (this.lHA != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.lHA);
      }
      paramInt = i;
      if (this.lHB != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.lHB);
      }
      i = paramInt;
      if (this.yXK != null) {
        i = paramInt + g.a.a.b.b.a.f(5, this.yXK);
      }
      AppMethodBeat.o(91658);
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
      AppMethodBeat.o(91658);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      dju localdju = (dju)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(91658);
        return -1;
      case 1: 
        localdju.KCl = locala.UbS.zi();
        AppMethodBeat.o(91658);
        return 0;
      case 2: 
        localdju.yXJ = locala.UbS.readString();
        AppMethodBeat.o(91658);
        return 0;
      case 3: 
        localdju.lHA = locala.UbS.readString();
        AppMethodBeat.o(91658);
        return 0;
      case 4: 
        localdju.lHB = locala.UbS.readString();
        AppMethodBeat.o(91658);
        return 0;
      }
      localdju.yXK = locala.UbS.readString();
      AppMethodBeat.o(91658);
      return 0;
    }
    AppMethodBeat.o(91658);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dju
 * JD-Core Version:    0.7.0.1
 */