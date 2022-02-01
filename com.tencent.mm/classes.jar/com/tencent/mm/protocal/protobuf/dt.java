package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class dt
  extends com.tencent.mm.cd.a
{
  public du RJj;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(204086);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.RJj != null)
      {
        paramVarArgs.oE(1, this.RJj.computeSize());
        this.RJj.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(204086);
      return 0;
    }
    if (paramInt == 1) {
      if (this.RJj == null) {
        break label288;
      }
    }
    label288:
    for (paramInt = g.a.a.a.oD(1, this.RJj.computeSize()) + 0;; paramInt = 0)
    {
      AppMethodBeat.o(204086);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(204086);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        dt localdt = (dt)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(204086);
          return -1;
        }
        paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
        int i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          du localdu = new du();
          if ((localObject != null) && (localObject.length > 0)) {
            localdu.parseFrom((byte[])localObject);
          }
          localdt.RJj = localdu;
          paramInt += 1;
        }
        AppMethodBeat.o(204086);
        return 0;
      }
      AppMethodBeat.o(204086);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dt
 * JD-Core Version:    0.7.0.1
 */