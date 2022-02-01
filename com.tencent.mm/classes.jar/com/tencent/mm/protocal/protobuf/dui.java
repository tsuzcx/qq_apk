package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dui
  extends com.tencent.mm.bx.a
{
  public int aaLf;
  public int aban;
  public int abao;
  public int abap;
  public int abaq;
  public int abar;
  public int abas;
  public int vhJ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(143985);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.aaLf);
      paramVarArgs.bS(2, this.aban);
      paramVarArgs.bS(3, this.abao);
      paramVarArgs.bS(4, this.abap);
      paramVarArgs.bS(5, this.abaq);
      paramVarArgs.bS(6, this.abar);
      paramVarArgs.bS(7, this.abas);
      paramVarArgs.bS(8, this.vhJ);
      AppMethodBeat.o(143985);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = i.a.a.b.b.a.cJ(1, this.aaLf);
      int i = i.a.a.b.b.a.cJ(2, this.aban);
      int j = i.a.a.b.b.a.cJ(3, this.abao);
      int k = i.a.a.b.b.a.cJ(4, this.abap);
      int m = i.a.a.b.b.a.cJ(5, this.abaq);
      int n = i.a.a.b.b.a.cJ(6, this.abar);
      int i1 = i.a.a.b.b.a.cJ(7, this.abas);
      int i2 = i.a.a.b.b.a.cJ(8, this.vhJ);
      AppMethodBeat.o(143985);
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
      AppMethodBeat.o(143985);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      dui localdui = (dui)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(143985);
        return -1;
      case 1: 
        localdui.aaLf = locala.ajGk.aar();
        AppMethodBeat.o(143985);
        return 0;
      case 2: 
        localdui.aban = locala.ajGk.aar();
        AppMethodBeat.o(143985);
        return 0;
      case 3: 
        localdui.abao = locala.ajGk.aar();
        AppMethodBeat.o(143985);
        return 0;
      case 4: 
        localdui.abap = locala.ajGk.aar();
        AppMethodBeat.o(143985);
        return 0;
      case 5: 
        localdui.abaq = locala.ajGk.aar();
        AppMethodBeat.o(143985);
        return 0;
      case 6: 
        localdui.abar = locala.ajGk.aar();
        AppMethodBeat.o(143985);
        return 0;
      case 7: 
        localdui.abas = locala.ajGk.aar();
        AppMethodBeat.o(143985);
        return 0;
      }
      localdui.vhJ = locala.ajGk.aar();
      AppMethodBeat.o(143985);
      return 0;
    }
    AppMethodBeat.o(143985);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dui
 * JD-Core Version:    0.7.0.1
 */