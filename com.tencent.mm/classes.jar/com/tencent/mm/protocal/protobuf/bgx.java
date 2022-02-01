package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bgx
  extends com.tencent.mm.bx.a
{
  public bgh Ddj;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258028);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.Ddj != null)
      {
        paramVarArgs.qD(1, this.Ddj.computeSize());
        this.Ddj.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(258028);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Ddj == null) {
        break label284;
      }
    }
    label284:
    for (paramInt = i.a.a.a.qC(1, this.Ddj.computeSize()) + 0;; paramInt = 0)
    {
      AppMethodBeat.o(258028);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(258028);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        bgx localbgx = (bgx)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(258028);
          return -1;
        }
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        int i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          bgh localbgh = new bgh();
          if ((localObject != null) && (localObject.length > 0)) {
            localbgh.parseFrom((byte[])localObject);
          }
          localbgx.Ddj = localbgh;
          paramInt += 1;
        }
        AppMethodBeat.o(258028);
        return 0;
      }
      AppMethodBeat.o(258028);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bgx
 * JD-Core Version:    0.7.0.1
 */