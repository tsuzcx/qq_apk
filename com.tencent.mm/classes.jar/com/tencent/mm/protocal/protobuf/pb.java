package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import java.util.LinkedList;

public final class pb
  extends dop
{
  public int KND;
  public b KRc;
  public String KRf;
  public int KVV;
  public int source;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(118407);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ni(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.KRc != null) {
        paramVarArgs.c(2, this.KRc);
      }
      paramVarArgs.aM(3, this.source);
      paramVarArgs.aM(4, this.KVV);
      if (this.KRf != null) {
        paramVarArgs.e(5, this.KRf);
      }
      paramVarArgs.aM(6, this.KND);
      AppMethodBeat.o(118407);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label562;
      }
    }
    label562:
    for (paramInt = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.KRc != null) {
        i = paramInt + g.a.a.b.b.a.b(2, this.KRc);
      }
      i = i + g.a.a.b.b.a.bu(3, this.source) + g.a.a.b.b.a.bu(4, this.KVV);
      paramInt = i;
      if (this.KRf != null) {
        paramInt = i + g.a.a.b.b.a.f(5, this.KRf);
      }
      i = g.a.a.b.b.a.bu(6, this.KND);
      AppMethodBeat.o(118407);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(118407);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        pb localpb = (pb)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(118407);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jr();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((jr)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localpb.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(118407);
          return 0;
        case 2: 
          localpb.KRc = ((g.a.a.a.a)localObject1).UbS.hPo();
          AppMethodBeat.o(118407);
          return 0;
        case 3: 
          localpb.source = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(118407);
          return 0;
        case 4: 
          localpb.KVV = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(118407);
          return 0;
        case 5: 
          localpb.KRf = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(118407);
          return 0;
        }
        localpb.KND = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(118407);
        return 0;
      }
      AppMethodBeat.o(118407);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.pb
 * JD-Core Version:    0.7.0.1
 */