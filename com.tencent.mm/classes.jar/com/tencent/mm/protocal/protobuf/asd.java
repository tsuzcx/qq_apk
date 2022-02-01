package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class asd
  extends cld
{
  public String Dss;
  public tq Dst;
  public int mAH;
  
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
      if (this.Dst == null)
      {
        paramVarArgs = new b("Not all required fields were included: NewChatroomData");
        AppMethodBeat.o(101815);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.kX(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.Dss != null) {
        paramVarArgs.d(2, this.Dss);
      }
      paramVarArgs.aR(3, this.mAH);
      if (this.Dst != null)
      {
        paramVarArgs.kX(4, this.Dst.computeSize());
        this.Dst.writeFields(paramVarArgs);
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
    for (paramInt = f.a.a.a.kW(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Dss != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.Dss);
      }
      i += f.a.a.b.b.a.bA(3, this.mAH);
      paramInt = i;
      if (this.Dst != null) {
        paramInt = i + f.a.a.a.kW(4, this.Dst.computeSize());
      }
      AppMethodBeat.o(101815);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cld.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cld.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(101815);
          throw paramVarArgs;
        }
        if (this.Dst == null)
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
        asd localasd = (asd)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(101815);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localasd.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(101815);
          return 0;
        case 2: 
          localasd.Dss = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(101815);
          return 0;
        case 3: 
          localasd.mAH = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(101815);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new tq();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((tq)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localasd.Dst = ((tq)localObject1);
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
 * Qualified Name:     com.tencent.mm.protocal.protobuf.asd
 * JD-Core Version:    0.7.0.1
 */