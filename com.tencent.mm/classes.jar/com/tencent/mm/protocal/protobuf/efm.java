package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class efm
  extends com.tencent.mm.bx.a
{
  public float ZaG;
  public float ZaH;
  public int Zyl;
  public String Zym;
  public String Zyn;
  public int Zyo;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152663);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.l(1, this.ZaG);
      paramVarArgs.l(2, this.ZaH);
      paramVarArgs.bS(3, this.Zyl);
      if (this.Zym != null) {
        paramVarArgs.g(4, this.Zym);
      }
      if (this.Zyn != null) {
        paramVarArgs.g(5, this.Zyn);
      }
      paramVarArgs.bS(6, this.Zyo);
      AppMethodBeat.o(152663);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.ko(1) + 4 + 0 + (i.a.a.b.b.a.ko(2) + 4) + i.a.a.b.b.a.cJ(3, this.Zyl);
      paramInt = i;
      if (this.Zym != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.Zym);
      }
      i = paramInt;
      if (this.Zyn != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.Zyn);
      }
      paramInt = i.a.a.b.b.a.cJ(6, this.Zyo);
      AppMethodBeat.o(152663);
      return i + paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(152663);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      efm localefm = (efm)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(152663);
        return -1;
      case 1: 
        localefm.ZaG = Float.intBitsToFloat(locala.ajGk.aax());
        AppMethodBeat.o(152663);
        return 0;
      case 2: 
        localefm.ZaH = Float.intBitsToFloat(locala.ajGk.aax());
        AppMethodBeat.o(152663);
        return 0;
      case 3: 
        localefm.Zyl = locala.ajGk.aar();
        AppMethodBeat.o(152663);
        return 0;
      case 4: 
        localefm.Zym = locala.ajGk.readString();
        AppMethodBeat.o(152663);
        return 0;
      case 5: 
        localefm.Zyn = locala.ajGk.readString();
        AppMethodBeat.o(152663);
        return 0;
      }
      localefm.Zyo = locala.ajGk.aar();
      AppMethodBeat.o(152663);
      return 0;
    }
    AppMethodBeat.o(152663);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.efm
 * JD-Core Version:    0.7.0.1
 */