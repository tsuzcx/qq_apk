package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dmp
  extends com.tencent.mm.bw.a
{
  public String Gyt;
  public ali HTP;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124562);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Gyt != null) {
        paramVarArgs.d(1, this.Gyt);
      }
      if (this.HTP != null)
      {
        paramVarArgs.lJ(2, this.HTP.computeSize());
        this.HTP.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(124562);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Gyt == null) {
        break label370;
      }
    }
    label370:
    for (paramInt = f.a.a.b.b.a.e(1, this.Gyt) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.HTP != null) {
        i = paramInt + f.a.a.a.lI(2, this.HTP.computeSize());
      }
      AppMethodBeat.o(124562);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(124562);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dmp localdmp = (dmp)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(124562);
          return -1;
        case 1: 
          localdmp.Gyt = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(124562);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ali();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((ali)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdmp.HTP = ((ali)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(124562);
        return 0;
      }
      AppMethodBeat.o(124562);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dmp
 * JD-Core Version:    0.7.0.1
 */