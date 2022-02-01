package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class aqt
  extends ckq
{
  public int BX;
  public String DaJ;
  public String data;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124508);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.DaJ == null)
      {
        paramVarArgs = new b("Not all required fields were included: corp_id");
        AppMethodBeat.o(124508);
        throw paramVarArgs;
      }
      if (this.data == null)
      {
        paramVarArgs = new b("Not all required fields were included: data");
        AppMethodBeat.o(124508);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.kX(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.DaJ != null) {
        paramVarArgs.d(2, this.DaJ);
      }
      paramVarArgs.aR(3, this.BX);
      if (this.data != null) {
        paramVarArgs.d(4, this.data);
      }
      AppMethodBeat.o(124508);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label574;
      }
    }
    label574:
    for (paramInt = f.a.a.a.kW(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.DaJ != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.DaJ);
      }
      i += f.a.a.b.b.a.bA(3, this.BX);
      paramInt = i;
      if (this.data != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.data);
      }
      AppMethodBeat.o(124508);
      return paramInt;
      Object localObject1;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        localObject1 = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = ckq.getNextFieldNumber((f.a.a.a.a)localObject1); paramInt > 0; paramInt = ckq.getNextFieldNumber((f.a.a.a.a)localObject1)) {
          if (!super.populateBuilderWithField((f.a.a.a.a)localObject1, this, paramInt)) {
            ((f.a.a.a.a)localObject1).fMq();
          }
        }
        if (this.DaJ == null)
        {
          paramVarArgs = new b("Not all required fields were included: corp_id");
          AppMethodBeat.o(124508);
          throw paramVarArgs;
        }
        if (paramVarArgs == null)
        {
          paramVarArgs = new b("Not all required fields were included: data");
          AppMethodBeat.o(124508);
          throw paramVarArgs;
        }
        AppMethodBeat.o(124508);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject2 = (f.a.a.a.a)paramVarArgs[0];
        localObject1 = (aqt)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(124508);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject2).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject3 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new ip();
            localObject3 = new f.a.a.a.a((byte[])localObject3, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((ip)localObject2).populateBuilderWithField((f.a.a.a.a)localObject3, (com.tencent.mm.bx.a)localObject2, ckq.getNextFieldNumber((f.a.a.a.a)localObject3))) {}
            ((aqt)localObject1).BaseRequest = ((ip)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(124508);
          return 0;
        case 2: 
          ((aqt)localObject1).DaJ = ((f.a.a.a.a)localObject2).KhF.readString();
          AppMethodBeat.o(124508);
          return 0;
        case 3: 
          ((aqt)localObject1).BX = ((f.a.a.a.a)localObject2).KhF.xS();
          AppMethodBeat.o(124508);
          return 0;
        }
        ((aqt)localObject1).data = ((f.a.a.a.a)localObject2).KhF.readString();
        AppMethodBeat.o(124508);
        return 0;
      }
      AppMethodBeat.o(124508);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aqt
 * JD-Core Version:    0.7.0.1
 */