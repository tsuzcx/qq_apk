package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class axt
  extends cld
{
  public int CNq;
  public int Dwz;
  public int mAK;
  public LinkedList<bxo> mAL;
  public int mBH;
  
  public axt()
  {
    AppMethodBeat.i(152590);
    this.mAL = new LinkedList();
    AppMethodBeat.o(152590);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152591);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(152591);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.kX(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.mAK);
      paramVarArgs.e(3, 8, this.mAL);
      paramVarArgs.aR(4, this.CNq);
      paramVarArgs.aR(5, this.Dwz);
      paramVarArgs.aR(6, this.mBH);
      AppMethodBeat.o(152591);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label686;
      }
    }
    label686:
    for (paramInt = f.a.a.a.kW(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = f.a.a.b.b.a.bA(2, this.mAK);
      int j = f.a.a.a.c(3, 8, this.mAL);
      int k = f.a.a.b.b.a.bA(4, this.CNq);
      int m = f.a.a.b.b.a.bA(5, this.Dwz);
      int n = f.a.a.b.b.a.bA(6, this.mBH);
      AppMethodBeat.o(152591);
      return paramInt + i + j + k + m + n;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.mAL.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cld.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cld.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(152591);
          throw paramVarArgs;
        }
        AppMethodBeat.o(152591);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        axt localaxt = (axt)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(152591);
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
            localaxt.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152591);
          return 0;
        case 2: 
          localaxt.mAK = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(152591);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bxo();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bxo)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localaxt.mAL.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152591);
          return 0;
        case 4: 
          localaxt.CNq = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(152591);
          return 0;
        case 5: 
          localaxt.Dwz = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(152591);
          return 0;
        }
        localaxt.mBH = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(152591);
        return 0;
      }
      AppMethodBeat.o(152591);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.axt
 * JD-Core Version:    0.7.0.1
 */