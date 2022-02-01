package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class mi
  extends ckq
{
  public String CIQ;
  public String dcm;
  public int offset;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124422);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.CIQ == null)
      {
        paramVarArgs = new b("Not all required fields were included: brand_user_name");
        AppMethodBeat.o(124422);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.kX(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.CIQ != null) {
        paramVarArgs.d(2, this.CIQ);
      }
      if (this.dcm != null) {
        paramVarArgs.d(3, this.dcm);
      }
      paramVarArgs.aR(4, this.offset);
      AppMethodBeat.o(124422);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label522;
      }
    }
    label522:
    for (int i = f.a.a.a.kW(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.CIQ != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.CIQ);
      }
      i = paramInt;
      if (this.dcm != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.dcm);
      }
      paramInt = f.a.a.b.b.a.bA(4, this.offset);
      AppMethodBeat.o(124422);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = ckq.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = ckq.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        if (this.CIQ == null)
        {
          paramVarArgs = new b("Not all required fields were included: brand_user_name");
          AppMethodBeat.o(124422);
          throw paramVarArgs;
        }
        AppMethodBeat.o(124422);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        mi localmi = (mi)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(124422);
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
            localmi.BaseRequest = ((ip)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(124422);
          return 0;
        case 2: 
          localmi.CIQ = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(124422);
          return 0;
        case 3: 
          localmi.dcm = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(124422);
          return 0;
        }
        localmi.offset = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(124422);
        return 0;
      }
      AppMethodBeat.o(124422);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.mi
 * JD-Core Version:    0.7.0.1
 */