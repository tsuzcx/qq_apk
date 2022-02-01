package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class azv
  extends cwj
{
  public String GQa;
  public vy GQb;
  public int nIA;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(101815);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(101815);
        throw paramVarArgs;
      }
      if (this.GQb == null)
      {
        paramVarArgs = new b("Not all required fields were included: NewChatroomData");
        AppMethodBeat.o(101815);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lJ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.GQa != null) {
        paramVarArgs.d(2, this.GQa);
      }
      paramVarArgs.aS(3, this.nIA);
      if (this.GQb != null)
      {
        paramVarArgs.lJ(4, this.GQb.computeSize());
        this.GQb.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(101815);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label666;
      }
    }
    label666:
    for (paramInt = f.a.a.a.lI(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.GQa != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.GQa);
      }
      i += f.a.a.b.b.a.bz(3, this.nIA);
      paramInt = i;
      if (this.GQb != null) {
        paramInt = i + f.a.a.a.lI(4, this.GQb.computeSize());
      }
      AppMethodBeat.o(101815);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cwj.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cwj.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(101815);
          throw paramVarArgs;
        }
        if (this.GQb == null)
        {
          paramVarArgs = new b("Not all required fields were included: NewChatroomData");
          AppMethodBeat.o(101815);
          throw paramVarArgs;
        }
        AppMethodBeat.o(101815);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        azv localazv = (azv)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(101815);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localazv.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(101815);
          return 0;
        case 2: 
          localazv.GQa = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(101815);
          return 0;
        case 3: 
          localazv.nIA = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(101815);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new vy();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((vy)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localazv.GQb = ((vy)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(101815);
        return 0;
      }
      AppMethodBeat.o(101815);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.azv
 * JD-Core Version:    0.7.0.1
 */