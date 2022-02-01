package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class bbb
  extends cvp
{
  public LinkedList<el> Fys;
  public int Gyb;
  public int Gyc;
  public LinkedList<Integer> Gyd;
  public LinkedList<ahp> Gye;
  public int Gyg;
  
  public bbb()
  {
    AppMethodBeat.i(122505);
    this.Gyd = new LinkedList();
    this.Gye = new LinkedList();
    this.Fys = new LinkedList();
    AppMethodBeat.o(122505);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(122506);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(122506);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lC(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.Gyb);
      paramVarArgs.aS(3, this.Gyc);
      paramVarArgs.e(4, 2, this.Gyd);
      paramVarArgs.e(5, 8, this.Gye);
      paramVarArgs.aS(6, this.Gyg);
      paramVarArgs.e(7, 8, this.Fys);
      AppMethodBeat.o(122506);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label845;
      }
    }
    label845:
    for (paramInt = f.a.a.a.lB(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = f.a.a.b.b.a.bz(2, this.Gyb);
      int j = f.a.a.b.b.a.bz(3, this.Gyc);
      int k = f.a.a.a.c(4, 2, this.Gyd);
      int m = f.a.a.a.c(5, 8, this.Gye);
      int n = f.a.a.b.b.a.bz(6, this.Gyg);
      int i1 = f.a.a.a.c(7, 8, this.Fys);
      AppMethodBeat.o(122506);
      return paramInt + i + j + k + m + n + i1;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Gyd.clear();
        this.Gye.clear();
        this.Fys.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cvp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(122506);
          throw paramVarArgs;
        }
        AppMethodBeat.o(122506);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bbb localbbb = (bbb)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(122506);
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
            localbbb.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(122506);
          return 0;
        case 2: 
          localbbb.Gyb = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(122506);
          return 0;
        case 3: 
          localbbb.Gyc = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(122506);
          return 0;
        case 4: 
          localbbb.Gyd.add(Integer.valueOf(((f.a.a.a.a)localObject1).NPN.zc()));
          AppMethodBeat.o(122506);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ahp();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ahp)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbbb.Gye.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(122506);
          return 0;
        case 6: 
          localbbb.Gyg = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(122506);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new el();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((el)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbbb.Fys.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(122506);
        return 0;
      }
      AppMethodBeat.o(122506);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bbb
 * JD-Core Version:    0.7.0.1
 */