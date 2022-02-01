package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class anx
  extends com.tencent.mm.bx.a
{
  public gol YOj;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152540);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.YOj == null)
      {
        paramVarArgs = new b("Not all required fields were included: RandomEncryKey");
        AppMethodBeat.o(152540);
        throw paramVarArgs;
      }
      if (this.YOj != null)
      {
        paramVarArgs.qD(1, this.YOj.computeSize());
        this.YOj.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(152540);
      return 0;
    }
    if (paramInt == 1) {
      if (this.YOj == null) {
        break label332;
      }
    }
    label332:
    for (paramInt = i.a.a.a.qC(1, this.YOj.computeSize()) + 0;; paramInt = 0)
    {
      AppMethodBeat.o(152540);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.YOj == null)
        {
          paramVarArgs = new b("Not all required fields were included: RandomEncryKey");
          AppMethodBeat.o(152540);
          throw paramVarArgs;
        }
        AppMethodBeat.o(152540);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        anx localanx = (anx)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(152540);
          return -1;
        }
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        int i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          gol localgol = new gol();
          if ((localObject != null) && (localObject.length > 0)) {
            localgol.dg((byte[])localObject);
          }
          localanx.YOj = localgol;
          paramInt += 1;
        }
        AppMethodBeat.o(152540);
        return 0;
      }
      AppMethodBeat.o(152540);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.anx
 * JD-Core Version:    0.7.0.1
 */