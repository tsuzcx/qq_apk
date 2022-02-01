package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.b;
import java.util.LinkedList;

public final class axm
  extends com.tencent.mm.cd.a
{
  public b SKb;
  public ayr SKc;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(230928);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.SKb != null) {
        paramVarArgs.c(1, this.SKb);
      }
      if (this.SKc != null)
      {
        paramVarArgs.oE(106, this.SKc.computeSize());
        this.SKc.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(230928);
      return 0;
    }
    if (paramInt == 1) {
      if (this.SKb == null) {
        break label356;
      }
    }
    label356:
    for (paramInt = g.a.a.b.b.a.b(1, this.SKb) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.SKc != null) {
        i = paramInt + g.a.a.a.oD(106, this.SKc.computeSize());
      }
      AppMethodBeat.o(230928);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(230928);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        axm localaxm = (axm)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(230928);
          return -1;
        case 1: 
          localaxm.SKb = ((g.a.a.a.a)localObject).abFh.iUw();
          AppMethodBeat.o(230928);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          ayr localayr = new ayr();
          if ((localObject != null) && (localObject.length > 0)) {
            localayr.parseFrom((byte[])localObject);
          }
          localaxm.SKc = localayr;
          paramInt += 1;
        }
        AppMethodBeat.o(230928);
        return 0;
      }
      AppMethodBeat.o(230928);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.axm
 * JD-Core Version:    0.7.0.1
 */