package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class ban
  extends cvp
{
  public int GxC;
  public String GxD;
  public int GxE;
  public int nDi;
  public LinkedList<agm> nDj;
  
  public ban()
  {
    AppMethodBeat.i(104792);
    this.nDj = new LinkedList();
    AppMethodBeat.o(104792);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(104793);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(104793);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lC(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.nDi);
      paramVarArgs.e(3, 8, this.nDj);
      paramVarArgs.aS(4, this.GxC);
      if (this.GxD != null) {
        paramVarArgs.d(5, this.GxD);
      }
      paramVarArgs.aS(6, this.GxE);
      AppMethodBeat.o(104793);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label690;
      }
    }
    label690:
    for (paramInt = f.a.a.a.lB(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.nDi) + f.a.a.a.c(3, 8, this.nDj) + f.a.a.b.b.a.bz(4, this.GxC);
      paramInt = i;
      if (this.GxD != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.GxD);
      }
      i = f.a.a.b.b.a.bz(6, this.GxE);
      AppMethodBeat.o(104793);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.nDj.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cvp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(104793);
          throw paramVarArgs;
        }
        AppMethodBeat.o(104793);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ban localban = (ban)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(104793);
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
            localban.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(104793);
          return 0;
        case 2: 
          localban.nDi = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(104793);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new agm();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((agm)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localban.nDj.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(104793);
          return 0;
        case 4: 
          localban.GxC = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(104793);
          return 0;
        case 5: 
          localban.GxD = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(104793);
          return 0;
        }
        localban.GxE = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(104793);
        return 0;
      }
      AppMethodBeat.o(104793);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ban
 * JD-Core Version:    0.7.0.1
 */