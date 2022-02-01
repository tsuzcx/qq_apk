package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dhz
  extends com.tencent.mm.cd.a
{
  public dhy TPf;
  public String key;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(253352);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.key != null) {
        paramVarArgs.f(1, this.key);
      }
      if (this.TPf != null)
      {
        paramVarArgs.oE(2, this.TPf.computeSize());
        this.TPf.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(253352);
      return 0;
    }
    if (paramInt == 1) {
      if (this.key == null) {
        break label348;
      }
    }
    label348:
    for (paramInt = g.a.a.b.b.a.g(1, this.key) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.TPf != null) {
        i = paramInt + g.a.a.a.oD(2, this.TPf.computeSize());
      }
      AppMethodBeat.o(253352);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(253352);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        dhz localdhz = (dhz)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(253352);
          return -1;
        case 1: 
          localdhz.key = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(253352);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          dhy localdhy = new dhy();
          if ((localObject != null) && (localObject.length > 0)) {
            localdhy.parseFrom((byte[])localObject);
          }
          localdhz.TPf = localdhy;
          paramInt += 1;
        }
        AppMethodBeat.o(253352);
        return 0;
      }
      AppMethodBeat.o(253352);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dhz
 * JD-Core Version:    0.7.0.1
 */