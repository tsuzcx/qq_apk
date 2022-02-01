package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class dwr
  extends cvp
{
  public int GeI;
  public long GeJ;
  public int HJc;
  public int HJl;
  public dyg HJm;
  public int HJn;
  public int HJo;
  public int HJp;
  public int HJq;
  public SKBuiltinBuffer_t HJr;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(115859);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(115859);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lC(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.GeI);
      paramVarArgs.aY(3, this.GeJ);
      paramVarArgs.aS(4, this.HJl);
      if (this.HJm != null)
      {
        paramVarArgs.lC(5, this.HJm.computeSize());
        this.HJm.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(6, this.HJc);
      paramVarArgs.aS(7, this.HJn);
      paramVarArgs.aS(8, this.HJo);
      paramVarArgs.aS(9, this.HJp);
      paramVarArgs.aS(10, this.HJq);
      if (this.HJr != null)
      {
        paramVarArgs.lC(11, this.HJr.computeSize());
        this.HJr.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(115859);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1018;
      }
    }
    label1018:
    for (paramInt = f.a.a.a.lB(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.GeI) + f.a.a.b.b.a.p(3, this.GeJ) + f.a.a.b.b.a.bz(4, this.HJl);
      paramInt = i;
      if (this.HJm != null) {
        paramInt = i + f.a.a.a.lB(5, this.HJm.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bz(6, this.HJc) + f.a.a.b.b.a.bz(7, this.HJn) + f.a.a.b.b.a.bz(8, this.HJo) + f.a.a.b.b.a.bz(9, this.HJp) + f.a.a.b.b.a.bz(10, this.HJq);
      paramInt = i;
      if (this.HJr != null) {
        paramInt = i + f.a.a.a.lB(11, this.HJr.computeSize());
      }
      AppMethodBeat.o(115859);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(115859);
          throw paramVarArgs;
        }
        AppMethodBeat.o(115859);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dwr localdwr = (dwr)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(115859);
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
            localdwr.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115859);
          return 0;
        case 2: 
          localdwr.GeI = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(115859);
          return 0;
        case 3: 
          localdwr.GeJ = ((f.a.a.a.a)localObject1).NPN.zd();
          AppMethodBeat.o(115859);
          return 0;
        case 4: 
          localdwr.HJl = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(115859);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dyg();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dyg)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdwr.HJm = ((dyg)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115859);
          return 0;
        case 6: 
          localdwr.HJc = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(115859);
          return 0;
        case 7: 
          localdwr.HJn = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(115859);
          return 0;
        case 8: 
          localdwr.HJo = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(115859);
          return 0;
        case 9: 
          localdwr.HJp = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(115859);
          return 0;
        case 10: 
          localdwr.HJq = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(115859);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new SKBuiltinBuffer_t();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdwr.HJr = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(115859);
        return 0;
      }
      AppMethodBeat.o(115859);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dwr
 * JD-Core Version:    0.7.0.1
 */