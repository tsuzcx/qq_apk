package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class eeu
  extends com.tencent.mm.bw.a
{
  public LinkedList<Integer> IiZ;
  public boolean Ija;
  
  public eeu()
  {
    AppMethodBeat.i(32543);
    this.IiZ = new LinkedList();
    AppMethodBeat.o(32543);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32544);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 2, this.IiZ);
      paramVarArgs.bC(2, this.Ija);
      AppMethodBeat.o(32544);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.a.c(1, 2, this.IiZ);
      int i = f.a.a.b.b.a.amF(2);
      AppMethodBeat.o(32544);
      return paramInt + 0 + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.IiZ.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(32544);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      eeu localeeu = (eeu)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(32544);
        return -1;
      case 1: 
        localeeu.IiZ.add(Integer.valueOf(locala.OmT.zc()));
        AppMethodBeat.o(32544);
        return 0;
      }
      localeeu.Ija = locala.OmT.gvY();
      AppMethodBeat.o(32544);
      return 0;
    }
    AppMethodBeat.o(32544);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eeu
 * JD-Core Version:    0.7.0.1
 */