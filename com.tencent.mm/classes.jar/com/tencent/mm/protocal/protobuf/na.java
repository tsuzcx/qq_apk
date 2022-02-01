package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class na
  extends com.tencent.mm.bw.a
{
  public String Ean;
  public int Ecj;
  public int Eck;
  public long Ecl;
  public String Ecm;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124433);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.Ecj);
      paramVarArgs.aR(2, this.Eck);
      paramVarArgs.aO(3, this.Ecl);
      if (this.Ecm != null) {
        paramVarArgs.d(4, this.Ecm);
      }
      if (this.Ean != null) {
        paramVarArgs.d(5, this.Ean);
      }
      AppMethodBeat.o(124433);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bx(1, this.Ecj) + 0 + f.a.a.b.b.a.bx(2, this.Eck) + f.a.a.b.b.a.p(3, this.Ecl);
      paramInt = i;
      if (this.Ecm != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.Ecm);
      }
      i = paramInt;
      if (this.Ean != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.Ean);
      }
      AppMethodBeat.o(124433);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      AppMethodBeat.o(124433);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      na localna = (na)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(124433);
        return -1;
      case 1: 
        localna.Ecj = locala.LVo.xF();
        AppMethodBeat.o(124433);
        return 0;
      case 2: 
        localna.Eck = locala.LVo.xF();
        AppMethodBeat.o(124433);
        return 0;
      case 3: 
        localna.Ecl = locala.LVo.xG();
        AppMethodBeat.o(124433);
        return 0;
      case 4: 
        localna.Ecm = locala.LVo.readString();
        AppMethodBeat.o(124433);
        return 0;
      }
      localna.Ean = locala.LVo.readString();
      AppMethodBeat.o(124433);
      return 0;
    }
    AppMethodBeat.o(124433);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.na
 * JD-Core Version:    0.7.0.1
 */