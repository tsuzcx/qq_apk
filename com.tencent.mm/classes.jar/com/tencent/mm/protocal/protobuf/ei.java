package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class ei
  extends com.tencent.mm.bx.a
{
  public ej YGw;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259032);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.YGw != null)
      {
        paramVarArgs.qD(1, this.YGw.computeSize());
        this.YGw.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(259032);
      return 0;
    }
    if (paramInt == 1) {
      if (this.YGw == null) {
        break label284;
      }
    }
    label284:
    for (paramInt = i.a.a.a.qC(1, this.YGw.computeSize()) + 0;; paramInt = 0)
    {
      AppMethodBeat.o(259032);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(259032);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        ei localei = (ei)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(259032);
          return -1;
        }
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        int i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          ej localej = new ej();
          if ((localObject != null) && (localObject.length > 0)) {
            localej.parseFrom((byte[])localObject);
          }
          localei.YGw = localej;
          paramInt += 1;
        }
        AppMethodBeat.o(259032);
        return 0;
      }
      AppMethodBeat.o(259032);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ei
 * JD-Core Version:    0.7.0.1
 */