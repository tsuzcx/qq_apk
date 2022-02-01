package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class oc
  extends cvp
{
  public String FIL;
  public long FJl;
  public int FJm;
  public int FJn;
  public long FJo;
  public int FJp;
  public LinkedList<oa> FJq;
  public int FJr;
  public LinkedList<crq> FJs;
  public int dDp;
  public int nuC;
  
  public oc()
  {
    AppMethodBeat.i(124440);
    this.FJq = new LinkedList();
    this.FJs = new LinkedList();
    AppMethodBeat.o(124440);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124441);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(124441);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lC(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(2, this.FJl);
      paramVarArgs.aS(3, this.FJm);
      paramVarArgs.aS(4, this.FJn);
      paramVarArgs.aY(5, this.FJo);
      paramVarArgs.aS(6, this.FJp);
      paramVarArgs.e(7, 8, this.FJq);
      paramVarArgs.aS(8, this.FJr);
      if (this.FIL != null) {
        paramVarArgs.d(9, this.FIL);
      }
      paramVarArgs.aS(10, this.nuC);
      paramVarArgs.aS(11, this.dDp);
      paramVarArgs.e(12, 8, this.FJs);
      AppMethodBeat.o(124441);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1058;
      }
    }
    label1058:
    for (paramInt = f.a.a.a.lB(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.p(2, this.FJl) + f.a.a.b.b.a.bz(3, this.FJm) + f.a.a.b.b.a.bz(4, this.FJn) + f.a.a.b.b.a.p(5, this.FJo) + f.a.a.b.b.a.bz(6, this.FJp) + f.a.a.a.c(7, 8, this.FJq) + f.a.a.b.b.a.bz(8, this.FJr);
      paramInt = i;
      if (this.FIL != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.FIL);
      }
      i = f.a.a.b.b.a.bz(10, this.nuC);
      int j = f.a.a.b.b.a.bz(11, this.dDp);
      int k = f.a.a.a.c(12, 8, this.FJs);
      AppMethodBeat.o(124441);
      return paramInt + i + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.FJq.clear();
        this.FJs.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cvp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(124441);
          throw paramVarArgs;
        }
        AppMethodBeat.o(124441);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        oc localoc = (oc)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(124441);
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
            localoc.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(124441);
          return 0;
        case 2: 
          localoc.FJl = ((f.a.a.a.a)localObject1).NPN.zd();
          AppMethodBeat.o(124441);
          return 0;
        case 3: 
          localoc.FJm = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(124441);
          return 0;
        case 4: 
          localoc.FJn = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(124441);
          return 0;
        case 5: 
          localoc.FJo = ((f.a.a.a.a)localObject1).NPN.zd();
          AppMethodBeat.o(124441);
          return 0;
        case 6: 
          localoc.FJp = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(124441);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new oa();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((oa)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localoc.FJq.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(124441);
          return 0;
        case 8: 
          localoc.FJr = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(124441);
          return 0;
        case 9: 
          localoc.FIL = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(124441);
          return 0;
        case 10: 
          localoc.nuC = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(124441);
          return 0;
        case 11: 
          localoc.dDp = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(124441);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new crq();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((crq)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localoc.FJs.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(124441);
        return 0;
      }
      AppMethodBeat.o(124441);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.oc
 * JD-Core Version:    0.7.0.1
 */