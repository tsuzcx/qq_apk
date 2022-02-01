package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class fen
  extends com.tencent.mm.cd.a
{
  public LinkedList<eqo> UEt;
  
  public fen()
  {
    AppMethodBeat.i(32502);
    this.UEt = new LinkedList();
    AppMethodBeat.o(32502);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32503);
    if (paramInt == 0)
    {
      ((g.a.a.c.a)paramVarArgs[0]).e(1, 8, this.UEt);
      AppMethodBeat.o(32503);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = g.a.a.a.c(1, 8, this.UEt);
      AppMethodBeat.o(32503);
      return paramInt + 0;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.UEt.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(32503);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (g.a.a.a.a)paramVarArgs[0];
      fen localfen = (fen)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(32503);
        return -1;
      }
      paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
      int i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject = (byte[])paramVarArgs.get(paramInt);
        eqo localeqo = new eqo();
        if ((localObject != null) && (localObject.length > 0)) {
          localeqo.parseFrom((byte[])localObject);
        }
        localfen.UEt.add(localeqo);
        paramInt += 1;
      }
      AppMethodBeat.o(32503);
      return 0;
    }
    AppMethodBeat.o(32503);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fen
 * JD-Core Version:    0.7.0.1
 */