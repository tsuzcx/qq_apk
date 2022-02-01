package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;

public final class dfk
  extends com.tencent.mm.bx.a
{
  public int ZrV;
  public int aaLf;
  public b aaLg;
  public int aaLh;
  public int aaLi;
  public int vgN;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(143982);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.aaLf);
      if (this.aaLg != null) {
        paramVarArgs.d(2, this.aaLg);
      }
      paramVarArgs.bS(3, this.aaLh);
      paramVarArgs.bS(4, this.ZrV);
      paramVarArgs.bS(5, this.vgN);
      paramVarArgs.bS(6, this.aaLi);
      AppMethodBeat.o(143982);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.cJ(1, this.aaLf) + 0;
      paramInt = i;
      if (this.aaLg != null) {
        paramInt = i + i.a.a.b.b.a.c(2, this.aaLg);
      }
      i = i.a.a.b.b.a.cJ(3, this.aaLh);
      int j = i.a.a.b.b.a.cJ(4, this.ZrV);
      int k = i.a.a.b.b.a.cJ(5, this.vgN);
      int m = i.a.a.b.b.a.cJ(6, this.aaLi);
      AppMethodBeat.o(143982);
      return paramInt + i + j + k + m;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(143982);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      dfk localdfk = (dfk)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(143982);
        return -1;
      case 1: 
        localdfk.aaLf = locala.ajGk.aar();
        AppMethodBeat.o(143982);
        return 0;
      case 2: 
        localdfk.aaLg = locala.ajGk.kFX();
        AppMethodBeat.o(143982);
        return 0;
      case 3: 
        localdfk.aaLh = locala.ajGk.aar();
        AppMethodBeat.o(143982);
        return 0;
      case 4: 
        localdfk.ZrV = locala.ajGk.aar();
        AppMethodBeat.o(143982);
        return 0;
      case 5: 
        localdfk.vgN = locala.ajGk.aar();
        AppMethodBeat.o(143982);
        return 0;
      }
      localdfk.aaLi = locala.ajGk.aar();
      AppMethodBeat.o(143982);
      return 0;
    }
    AppMethodBeat.o(143982);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dfk
 * JD-Core Version:    0.7.0.1
 */