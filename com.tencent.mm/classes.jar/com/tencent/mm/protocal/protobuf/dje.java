package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class dje
  extends cvp
{
  public int FMr;
  public int FqM;
  public int HxF;
  public LinkedList<djs> HxX;
  public long HxY;
  
  public dje()
  {
    AppMethodBeat.i(118445);
    this.HxX = new LinkedList();
    AppMethodBeat.o(118445);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(118446);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(118446);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lC(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.HxF);
      paramVarArgs.e(3, 8, this.HxX);
      paramVarArgs.aY(4, this.HxY);
      paramVarArgs.aS(5, this.FMr);
      paramVarArgs.aS(6, this.FqM);
      AppMethodBeat.o(118446);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label686;
      }
    }
    label686:
    for (paramInt = f.a.a.a.lB(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = f.a.a.b.b.a.bz(2, this.HxF);
      int j = f.a.a.a.c(3, 8, this.HxX);
      int k = f.a.a.b.b.a.p(4, this.HxY);
      int m = f.a.a.b.b.a.bz(5, this.FMr);
      int n = f.a.a.b.b.a.bz(6, this.FqM);
      AppMethodBeat.o(118446);
      return paramInt + i + j + k + m + n;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.HxX.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cvp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(118446);
          throw paramVarArgs;
        }
        AppMethodBeat.o(118446);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dje localdje = (dje)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(118446);
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
            localdje.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(118446);
          return 0;
        case 2: 
          localdje.HxF = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(118446);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new djs();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((djs)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdje.HxX.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(118446);
          return 0;
        case 4: 
          localdje.HxY = ((f.a.a.a.a)localObject1).NPN.zd();
          AppMethodBeat.o(118446);
          return 0;
        case 5: 
          localdje.FMr = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(118446);
          return 0;
        }
        localdje.FqM = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(118446);
        return 0;
      }
      AppMethodBeat.o(118446);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dje
 * JD-Core Version:    0.7.0.1
 */