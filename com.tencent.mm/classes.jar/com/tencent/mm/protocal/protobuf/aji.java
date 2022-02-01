package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class aji
  extends cld
{
  public ebq KPE;
  public dzw LxB;
  public int LxC;
  public ebk LxD;
  public int continueFlag;
  public com.tencent.mm.bx.b lastBuffer;
  public LinkedList<FinderObject> object;
  public long qxB;
  
  public aji()
  {
    AppMethodBeat.i(168991);
    this.object = new LinkedList();
    AppMethodBeat.o(168991);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(168992);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(168992);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.kX(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.object);
      if (this.lastBuffer != null) {
        paramVarArgs.c(3, this.lastBuffer);
      }
      paramVarArgs.aR(4, this.continueFlag);
      paramVarArgs.aG(5, this.qxB);
      if (this.LxB != null)
      {
        paramVarArgs.kX(6, this.LxB.computeSize());
        this.LxB.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(7, this.LxC);
      if (this.KPE != null)
      {
        paramVarArgs.kX(8, this.KPE.computeSize());
        this.KPE.writeFields(paramVarArgs);
      }
      if (this.LxD != null)
      {
        paramVarArgs.kX(9, this.LxD.computeSize());
        this.LxD.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(168992);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1158;
      }
    }
    label1158:
    for (paramInt = f.a.a.a.kW(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.a.c(2, 8, this.object);
      paramInt = i;
      if (this.lastBuffer != null) {
        paramInt = i + f.a.a.b.b.a.b(3, this.lastBuffer);
      }
      i = paramInt + f.a.a.b.b.a.bA(4, this.continueFlag) + f.a.a.b.b.a.q(5, this.qxB);
      paramInt = i;
      if (this.LxB != null) {
        paramInt = i + f.a.a.a.kW(6, this.LxB.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bA(7, this.LxC);
      paramInt = i;
      if (this.KPE != null) {
        paramInt = i + f.a.a.a.kW(8, this.KPE.computeSize());
      }
      i = paramInt;
      if (this.LxD != null) {
        i = paramInt + f.a.a.a.kW(9, this.LxD.computeSize());
      }
      AppMethodBeat.o(168992);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.object.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cld.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cld.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new f.a.a.b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(168992);
          throw paramVarArgs;
        }
        AppMethodBeat.o(168992);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        aji localaji = (aji)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(168992);
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
            localaji.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(168992);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new FinderObject();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((FinderObject)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localaji.object.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(168992);
          return 0;
        case 3: 
          localaji.lastBuffer = ((f.a.a.a.a)localObject1).KhF.fMu();
          AppMethodBeat.o(168992);
          return 0;
        case 4: 
          localaji.continueFlag = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(168992);
          return 0;
        case 5: 
          localaji.qxB = ((f.a.a.a.a)localObject1).KhF.xT();
          AppMethodBeat.o(168992);
          return 0;
        case 6: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dzw();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dzw)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localaji.LxB = ((dzw)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(168992);
          return 0;
        case 7: 
          localaji.LxC = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(168992);
          return 0;
        case 8: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ebq();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ebq)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localaji.KPE = ((ebq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(168992);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ebk();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((ebk)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localaji.LxD = ((ebk)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(168992);
        return 0;
      }
      AppMethodBeat.o(168992);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aji
 * JD-Core Version:    0.7.0.1
 */