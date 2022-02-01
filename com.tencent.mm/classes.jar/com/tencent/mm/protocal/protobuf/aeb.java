package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class aeb
  extends com.tencent.mm.cd.a
{
  public String SqI;
  public LinkedList<uc> lpz;
  
  public aeb()
  {
    AppMethodBeat.i(246880);
    this.lpz = new LinkedList();
    AppMethodBeat.o(246880);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(246882);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.SqI != null) {
        paramVarArgs.f(1, this.SqI);
      }
      paramVarArgs.e(2, 8, this.lpz);
      AppMethodBeat.o(246882);
      return 0;
    }
    if (paramInt == 1) {
      if (this.SqI == null) {
        break label336;
      }
    }
    label336:
    for (paramInt = g.a.a.b.b.a.g(1, this.SqI) + 0;; paramInt = 0)
    {
      int i = g.a.a.a.c(2, 8, this.lpz);
      AppMethodBeat.o(246882);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.lpz.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(246882);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        aeb localaeb = (aeb)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(246882);
          return -1;
        case 1: 
          localaeb.SqI = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(246882);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          uc localuc = new uc();
          if ((localObject != null) && (localObject.length > 0)) {
            localuc.parseFrom((byte[])localObject);
          }
          localaeb.lpz.add(localuc);
          paramInt += 1;
        }
        AppMethodBeat.o(246882);
        return 0;
      }
      AppMethodBeat.o(246882);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aeb
 * JD-Core Version:    0.7.0.1
 */