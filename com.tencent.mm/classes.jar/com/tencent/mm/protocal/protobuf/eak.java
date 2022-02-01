package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class eak
  extends ckq
{
  public String EEF;
  public long LwA;
  public b LyM;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(202507);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.kX(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aG(2, this.LwA);
      if (this.EEF != null) {
        paramVarArgs.d(3, this.EEF);
      }
      if (this.LyM != null) {
        paramVarArgs.c(4, this.LyM);
      }
      AppMethodBeat.o(202507);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label474;
      }
    }
    label474:
    for (paramInt = f.a.a.a.kW(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.q(2, this.LwA);
      paramInt = i;
      if (this.EEF != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.EEF);
      }
      i = paramInt;
      if (this.LyM != null) {
        i = paramInt + f.a.a.b.b.a.b(4, this.LyM);
      }
      AppMethodBeat.o(202507);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = ckq.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = ckq.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(202507);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        eak localeak = (eak)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(202507);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ip();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((ip)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localeak.BaseRequest = ((ip)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(202507);
          return 0;
        case 2: 
          localeak.LwA = ((f.a.a.a.a)localObject1).KhF.xT();
          AppMethodBeat.o(202507);
          return 0;
        case 3: 
          localeak.EEF = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(202507);
          return 0;
        }
        localeak.LyM = ((f.a.a.a.a)localObject1).KhF.fMu();
        AppMethodBeat.o(202507);
        return 0;
      }
      AppMethodBeat.o(202507);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eak
 * JD-Core Version:    0.7.0.1
 */