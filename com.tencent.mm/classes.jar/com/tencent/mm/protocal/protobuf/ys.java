package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class ys
  extends cld
{
  public LinkedList<qn> DaU;
  public int DaV;
  public int DaW;
  public int version;
  public String zWO;
  
  public ys()
  {
    AppMethodBeat.i(32177);
    this.DaU = new LinkedList();
    AppMethodBeat.o(32177);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32178);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(32178);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.kX(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.DaU);
      paramVarArgs.aR(3, this.version);
      paramVarArgs.aR(4, this.DaV);
      paramVarArgs.aR(5, this.DaW);
      if (this.zWO != null) {
        paramVarArgs.d(6, this.zWO);
      }
      AppMethodBeat.o(32178);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label702;
      }
    }
    label702:
    for (paramInt = f.a.a.a.kW(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.a.c(2, 8, this.DaU) + f.a.a.b.b.a.bA(3, this.version) + f.a.a.b.b.a.bA(4, this.DaV) + f.a.a.b.b.a.bA(5, this.DaW);
      paramInt = i;
      if (this.zWO != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.zWO);
      }
      AppMethodBeat.o(32178);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.DaU.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cld.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cld.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(32178);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32178);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ys localys = (ys)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32178);
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
            localys.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32178);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new qn();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((qn)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localys.DaU.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32178);
          return 0;
        case 3: 
          localys.version = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(32178);
          return 0;
        case 4: 
          localys.DaV = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(32178);
          return 0;
        case 5: 
          localys.DaW = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(32178);
          return 0;
        }
        localys.zWO = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(32178);
        return 0;
      }
      AppMethodBeat.o(32178);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ys
 * JD-Core Version:    0.7.0.1
 */