package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class djj
  extends cvp
{
  public int FqM;
  public String HtU;
  public int Hvp;
  public long HxY;
  public int Hyk;
  public LinkedList<djh> Hyl;
  
  public djj()
  {
    AppMethodBeat.i(118450);
    this.Hyl = new LinkedList();
    AppMethodBeat.o(118450);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(118451);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(118451);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lC(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.HtU != null) {
        paramVarArgs.d(2, this.HtU);
      }
      paramVarArgs.aS(3, this.Hyk);
      paramVarArgs.e(4, 8, this.Hyl);
      paramVarArgs.aS(5, this.Hvp);
      paramVarArgs.aY(6, this.HxY);
      paramVarArgs.aS(7, this.FqM);
      AppMethodBeat.o(118451);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label746;
      }
    }
    label746:
    for (paramInt = f.a.a.a.lB(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.HtU != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.HtU);
      }
      paramInt = f.a.a.b.b.a.bz(3, this.Hyk);
      int j = f.a.a.a.c(4, 8, this.Hyl);
      int k = f.a.a.b.b.a.bz(5, this.Hvp);
      int m = f.a.a.b.b.a.p(6, this.HxY);
      int n = f.a.a.b.b.a.bz(7, this.FqM);
      AppMethodBeat.o(118451);
      return i + paramInt + j + k + m + n;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Hyl.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cvp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(118451);
          throw paramVarArgs;
        }
        AppMethodBeat.o(118451);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        djj localdjj = (djj)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(118451);
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
            localdjj.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(118451);
          return 0;
        case 2: 
          localdjj.HtU = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(118451);
          return 0;
        case 3: 
          localdjj.Hyk = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(118451);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new djh();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((djh)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdjj.Hyl.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(118451);
          return 0;
        case 5: 
          localdjj.Hvp = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(118451);
          return 0;
        case 6: 
          localdjj.HxY = ((f.a.a.a.a)localObject1).NPN.zd();
          AppMethodBeat.o(118451);
          return 0;
        }
        localdjj.FqM = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(118451);
        return 0;
      }
      AppMethodBeat.o(118451);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.djj
 * JD-Core Version:    0.7.0.1
 */