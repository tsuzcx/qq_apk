package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class nn
  extends com.tencent.mm.cd.a
{
  public nq RUs;
  public String RUt;
  public String RUu;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124421);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.RUs != null)
      {
        paramVarArgs.oE(1, this.RUs.computeSize());
        this.RUs.writeFields(paramVarArgs);
      }
      if (this.RUt != null) {
        paramVarArgs.f(2, this.RUt);
      }
      if (this.RUu != null) {
        paramVarArgs.f(3, this.RUu);
      }
      AppMethodBeat.o(124421);
      return 0;
    }
    if (paramInt == 1) {
      if (this.RUs == null) {
        break label408;
      }
    }
    label408:
    for (int i = g.a.a.a.oD(1, this.RUs.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.RUt != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.RUt);
      }
      i = paramInt;
      if (this.RUu != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.RUu);
      }
      AppMethodBeat.o(124421);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(124421);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        nn localnn = (nn)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(124421);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            nq localnq = new nq();
            if ((localObject != null) && (localObject.length > 0)) {
              localnq.parseFrom((byte[])localObject);
            }
            localnn.RUs = localnq;
            paramInt += 1;
          }
          AppMethodBeat.o(124421);
          return 0;
        case 2: 
          localnn.RUt = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(124421);
          return 0;
        }
        localnn.RUu = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(124421);
        return 0;
      }
      AppMethodBeat.o(124421);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.nn
 * JD-Core Version:    0.7.0.1
 */