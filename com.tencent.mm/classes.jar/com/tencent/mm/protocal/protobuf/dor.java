package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class dor
  extends com.tencent.mm.bx.a
{
  public String Dyh;
  public dnp EEK;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(147814);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.EEK == null)
      {
        paramVarArgs = new b("Not all required fields were included: base_request");
        AppMethodBeat.o(147814);
        throw paramVarArgs;
      }
      if (this.EEK != null)
      {
        paramVarArgs.kX(1, this.EEK.computeSize());
        this.EEK.writeFields(paramVarArgs);
      }
      if (this.Dyh != null) {
        paramVarArgs.d(2, this.Dyh);
      }
      AppMethodBeat.o(147814);
      return 0;
    }
    if (paramInt == 1) {
      if (this.EEK == null) {
        break label418;
      }
    }
    label418:
    for (paramInt = f.a.a.a.kW(1, this.EEK.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Dyh != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.Dyh);
      }
      AppMethodBeat.o(147814);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        if (this.EEK == null)
        {
          paramVarArgs = new b("Not all required fields were included: base_request");
          AppMethodBeat.o(147814);
          throw paramVarArgs;
        }
        AppMethodBeat.o(147814);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dor localdor = (dor)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(147814);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dnp();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((dnp)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdor.EEK = ((dnp)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(147814);
          return 0;
        }
        localdor.Dyh = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(147814);
        return 0;
      }
      AppMethodBeat.o(147814);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dor
 * JD-Core Version:    0.7.0.1
 */