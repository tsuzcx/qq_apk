package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class bev
  extends cvp
{
  public int FuX;
  public int GAR;
  public LinkedList<cdz> GAS;
  public String GAT;
  public int GAU;
  
  public bev()
  {
    AppMethodBeat.i(32254);
    this.GAS = new LinkedList();
    AppMethodBeat.o(32254);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32255);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(32255);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lC(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.GAR);
      paramVarArgs.e(3, 8, this.GAS);
      if (this.GAT != null) {
        paramVarArgs.d(4, this.GAT);
      }
      paramVarArgs.aS(5, this.FuX);
      paramVarArgs.aS(6, this.GAU);
      AppMethodBeat.o(32255);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label706;
      }
    }
    label706:
    for (paramInt = f.a.a.a.lB(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.GAR) + f.a.a.a.c(3, 8, this.GAS);
      paramInt = i;
      if (this.GAT != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.GAT);
      }
      i = f.a.a.b.b.a.bz(5, this.FuX);
      int j = f.a.a.b.b.a.bz(6, this.GAU);
      AppMethodBeat.o(32255);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.GAS.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cvp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(32255);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32255);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bev localbev = (bev)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32255);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbev.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32255);
          return 0;
        case 2: 
          localbev.GAR = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(32255);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cdz();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cdz)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbev.GAS.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32255);
          return 0;
        case 4: 
          localbev.GAT = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(32255);
          return 0;
        case 5: 
          localbev.FuX = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(32255);
          return 0;
        }
        localbev.GAU = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(32255);
        return 0;
      }
      AppMethodBeat.o(32255);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bev
 * JD-Core Version:    0.7.0.1
 */