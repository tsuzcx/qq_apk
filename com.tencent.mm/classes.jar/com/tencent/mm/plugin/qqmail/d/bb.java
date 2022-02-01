package com.tencent.mm.plugin.qqmail.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bb
  extends com.tencent.mm.bx.a
{
  public long uin;
  public LinkedList<String> xdA;
  public long xdB;
  
  public bb()
  {
    AppMethodBeat.i(215245);
    this.xdA = new LinkedList();
    AppMethodBeat.o(215245);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(215246);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.uin);
      paramVarArgs.e(2, 1, this.xdA);
      paramVarArgs.aY(3, this.xdB);
      AppMethodBeat.o(215246);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.p(1, this.uin);
      int i = f.a.a.a.c(2, 1, this.xdA);
      int j = f.a.a.b.b.a.p(3, this.xdB);
      AppMethodBeat.o(215246);
      return paramInt + 0 + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.xdA.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(215246);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      bb localbb = (bb)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(215246);
        return -1;
      case 1: 
        localbb.uin = locala.NPN.zd();
        AppMethodBeat.o(215246);
        return 0;
      case 2: 
        localbb.xdA.add(locala.NPN.readString());
        AppMethodBeat.o(215246);
        return 0;
      }
      localbb.xdB = locala.NPN.zd();
      AppMethodBeat.o(215246);
      return 0;
    }
    AppMethodBeat.o(215246);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.d.bb
 * JD-Core Version:    0.7.0.1
 */