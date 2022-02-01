package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class blg
  extends com.tencent.mm.bx.a
{
  public int ZUn;
  public int ZUo;
  public int ZUp;
  public int ZUq;
  public int ZUr;
  public int ZUs;
  public int ZUt;
  public int platform;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259261);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.ZUn);
      paramVarArgs.bS(2, this.ZUo);
      paramVarArgs.bS(3, this.ZUp);
      paramVarArgs.bS(4, this.ZUq);
      paramVarArgs.bS(5, this.ZUr);
      paramVarArgs.bS(6, this.ZUs);
      paramVarArgs.bS(7, this.ZUt);
      paramVarArgs.bS(8, this.platform);
      AppMethodBeat.o(259261);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = i.a.a.b.b.a.cJ(1, this.ZUn);
      int i = i.a.a.b.b.a.cJ(2, this.ZUo);
      int j = i.a.a.b.b.a.cJ(3, this.ZUp);
      int k = i.a.a.b.b.a.cJ(4, this.ZUq);
      int m = i.a.a.b.b.a.cJ(5, this.ZUr);
      int n = i.a.a.b.b.a.cJ(6, this.ZUs);
      int i1 = i.a.a.b.b.a.cJ(7, this.ZUt);
      int i2 = i.a.a.b.b.a.cJ(8, this.platform);
      AppMethodBeat.o(259261);
      return paramInt + 0 + i + j + k + m + n + i1 + i2;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(259261);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      blg localblg = (blg)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(259261);
        return -1;
      case 1: 
        localblg.ZUn = locala.ajGk.aar();
        AppMethodBeat.o(259261);
        return 0;
      case 2: 
        localblg.ZUo = locala.ajGk.aar();
        AppMethodBeat.o(259261);
        return 0;
      case 3: 
        localblg.ZUp = locala.ajGk.aar();
        AppMethodBeat.o(259261);
        return 0;
      case 4: 
        localblg.ZUq = locala.ajGk.aar();
        AppMethodBeat.o(259261);
        return 0;
      case 5: 
        localblg.ZUr = locala.ajGk.aar();
        AppMethodBeat.o(259261);
        return 0;
      case 6: 
        localblg.ZUs = locala.ajGk.aar();
        AppMethodBeat.o(259261);
        return 0;
      case 7: 
        localblg.ZUt = locala.ajGk.aar();
        AppMethodBeat.o(259261);
        return 0;
      }
      localblg.platform = locala.ajGk.aar();
      AppMethodBeat.o(259261);
      return 0;
    }
    AppMethodBeat.o(259261);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.blg
 * JD-Core Version:    0.7.0.1
 */