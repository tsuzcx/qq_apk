package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class cvw
  extends cld
{
  public String Enx;
  public int OpCode;
  public int mAK;
  public LinkedList<cvu> mAL;
  public int wFN;
  
  public cvw()
  {
    AppMethodBeat.i(125819);
    this.mAL = new LinkedList();
    AppMethodBeat.o(125819);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125820);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(125820);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.kX(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.OpCode);
      if (this.Enx != null) {
        paramVarArgs.d(3, this.Enx);
      }
      paramVarArgs.aR(4, this.mAK);
      paramVarArgs.e(5, 8, this.mAL);
      paramVarArgs.aR(6, this.wFN);
      AppMethodBeat.o(125820);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label698;
      }
    }
    label698:
    for (paramInt = f.a.a.a.kW(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bA(2, this.OpCode);
      paramInt = i;
      if (this.Enx != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.Enx);
      }
      i = f.a.a.b.b.a.bA(4, this.mAK);
      int j = f.a.a.a.c(5, 8, this.mAL);
      int k = f.a.a.b.b.a.bA(6, this.wFN);
      AppMethodBeat.o(125820);
      return paramInt + i + j + k;
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
          AppMethodBeat.o(125820);
          throw paramVarArgs;
        }
        AppMethodBeat.o(125820);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cvw localcvw = (cvw)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(125820);
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
            localcvw.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125820);
          return 0;
        case 2: 
          localcvw.OpCode = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(125820);
          return 0;
        case 3: 
          localcvw.Enx = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(125820);
          return 0;
        case 4: 
          localcvw.mAK = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(125820);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cvu();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cvu)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcvw.mAL.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125820);
          return 0;
        }
        localcvw.wFN = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(125820);
        return 0;
      }
      AppMethodBeat.o(125820);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cvw
 * JD-Core Version:    0.7.0.1
 */