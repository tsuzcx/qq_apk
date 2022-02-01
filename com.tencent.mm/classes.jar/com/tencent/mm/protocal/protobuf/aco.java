package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class aco
  extends com.tencent.mm.cd.a
{
  public dal Soh;
  public boolean Soi;
  public String wmL;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(205558);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Soh != null)
      {
        paramVarArgs.oE(1, this.Soh.computeSize());
        this.Soh.writeFields(paramVarArgs);
      }
      if (this.wmL != null) {
        paramVarArgs.f(2, this.wmL);
      }
      paramVarArgs.co(3, this.Soi);
      AppMethodBeat.o(205558);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Soh == null) {
        break label392;
      }
    }
    label392:
    for (paramInt = g.a.a.a.oD(1, this.Soh.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.wmL != null) {
        i = paramInt + g.a.a.b.b.a.g(2, this.wmL);
      }
      paramInt = g.a.a.b.b.a.gL(3);
      AppMethodBeat.o(205558);
      return i + (paramInt + 1);
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(205558);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        aco localaco = (aco)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(205558);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            dal localdal = new dal();
            if ((localObject != null) && (localObject.length > 0)) {
              localdal.parseFrom((byte[])localObject);
            }
            localaco.Soh = localdal;
            paramInt += 1;
          }
          AppMethodBeat.o(205558);
          return 0;
        case 2: 
          localaco.wmL = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(205558);
          return 0;
        }
        localaco.Soi = ((g.a.a.a.a)localObject).abFh.AB();
        AppMethodBeat.o(205558);
        return 0;
      }
      AppMethodBeat.o(205558);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aco
 * JD-Core Version:    0.7.0.1
 */