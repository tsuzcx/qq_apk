package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class esw
  extends com.tencent.mm.bx.a
{
  public int abwo;
  public LinkedList<ete> abwp;
  
  public esw()
  {
    AppMethodBeat.i(181504);
    this.abwp = new LinkedList();
    AppMethodBeat.o(181504);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(181505);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.abwo);
      paramVarArgs.e(2, 8, this.abwp);
      AppMethodBeat.o(181505);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = i.a.a.b.b.a.cJ(1, this.abwo);
      i = i.a.a.a.c(2, 8, this.abwp);
      AppMethodBeat.o(181505);
      return paramInt + 0 + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.abwp.clear();
      paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(181505);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (i.a.a.a.a)paramVarArgs[0];
      esw localesw = (esw)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(181505);
        return -1;
      case 1: 
        localesw.abwo = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(181505);
        return 0;
      }
      paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject = (byte[])paramVarArgs.get(paramInt);
        ete localete = new ete();
        if ((localObject != null) && (localObject.length > 0)) {
          localete.parseFrom((byte[])localObject);
        }
        localesw.abwp.add(localete);
        paramInt += 1;
      }
      AppMethodBeat.o(181505);
      return 0;
    }
    AppMethodBeat.o(181505);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.esw
 * JD-Core Version:    0.7.0.1
 */