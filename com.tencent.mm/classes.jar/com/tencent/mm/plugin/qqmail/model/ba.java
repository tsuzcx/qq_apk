package com.tencent.mm.plugin.qqmail.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ba
  extends com.tencent.mm.bx.a
{
  public LinkedList<String> NlC;
  public long NlD;
  public long uin;
  
  public ba()
  {
    AppMethodBeat.i(267019);
    this.NlC = new LinkedList();
    AppMethodBeat.o(267019);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(267020);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bv(1, this.uin);
      paramVarArgs.e(2, 1, this.NlC);
      paramVarArgs.bv(3, this.NlD);
      AppMethodBeat.o(267020);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = i.a.a.b.b.a.q(1, this.uin);
      int i = i.a.a.a.c(2, 1, this.NlC);
      int j = i.a.a.b.b.a.q(3, this.NlD);
      AppMethodBeat.o(267020);
      return paramInt + 0 + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.NlC.clear();
      paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(267020);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      ba localba = (ba)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(267020);
        return -1;
      case 1: 
        localba.uin = locala.ajGk.aaw();
        AppMethodBeat.o(267020);
        return 0;
      case 2: 
        localba.NlC.add(locala.ajGk.readString());
        AppMethodBeat.o(267020);
        return 0;
      }
      localba.NlD = locala.ajGk.aaw();
      AppMethodBeat.o(267020);
      return 0;
    }
    AppMethodBeat.o(267020);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.model.ba
 * JD-Core Version:    0.7.0.1
 */