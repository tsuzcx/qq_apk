package com.tencent.mm.plugin.textstatus.proto;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class aq
  extends com.tencent.mm.cd.a
{
  public LinkedList<ap> MGI;
  
  public aq()
  {
    AppMethodBeat.i(237742);
    this.MGI = new LinkedList();
    AppMethodBeat.o(237742);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(237743);
    if (paramInt == 0)
    {
      ((g.a.a.c.a)paramVarArgs[0]).e(1, 8, this.MGI);
      AppMethodBeat.o(237743);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = g.a.a.a.c(1, 8, this.MGI);
      AppMethodBeat.o(237743);
      return paramInt + 0;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.MGI.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(237743);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (g.a.a.a.a)paramVarArgs[0];
      aq localaq = (aq)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(237743);
        return -1;
      }
      paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
      int i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject = (byte[])paramVarArgs.get(paramInt);
        ap localap = new ap();
        if ((localObject != null) && (localObject.length > 0)) {
          localap.parseFrom((byte[])localObject);
        }
        localaq.MGI.add(localap);
        paramInt += 1;
      }
      AppMethodBeat.o(237743);
      return 0;
    }
    AppMethodBeat.o(237743);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.proto.aq
 * JD-Core Version:    0.7.0.1
 */