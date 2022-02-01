package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class aoq
  extends cwj
{
  public String GFW;
  public int GFX;
  public String GFY;
  public aqi GFZ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(189351);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.lJ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.GFW != null) {
        paramVarArgs.d(2, this.GFW);
      }
      paramVarArgs.aS(3, this.GFX);
      if (this.GFY != null) {
        paramVarArgs.d(4, this.GFY);
      }
      if (this.GFZ != null)
      {
        paramVarArgs.lJ(5, this.GFZ.computeSize());
        this.GFZ.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(189351);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label630;
      }
    }
    label630:
    for (paramInt = f.a.a.a.lI(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.GFW != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.GFW);
      }
      i += f.a.a.b.b.a.bz(3, this.GFX);
      paramInt = i;
      if (this.GFY != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.GFY);
      }
      i = paramInt;
      if (this.GFZ != null) {
        i = paramInt + f.a.a.a.lI(5, this.GFZ.computeSize());
      }
      AppMethodBeat.o(189351);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cwj.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cwj.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(189351);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        aoq localaoq = (aoq)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(189351);
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
            localaoq.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(189351);
          return 0;
        case 2: 
          localaoq.GFW = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(189351);
          return 0;
        case 3: 
          localaoq.GFX = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(189351);
          return 0;
        case 4: 
          localaoq.GFY = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(189351);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new aqi();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((aqi)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localaoq.GFZ = ((aqi)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(189351);
        return 0;
      }
      AppMethodBeat.o(189351);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aoq
 * JD-Core Version:    0.7.0.1
 */