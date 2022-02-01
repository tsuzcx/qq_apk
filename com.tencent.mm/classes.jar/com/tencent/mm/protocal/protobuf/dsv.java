package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class dsv
  extends cvc
{
  public cwt HFA;
  public cwt HFB;
  public int HFC;
  public int HFD;
  public int HFE;
  public int HFF;
  public int tSp;
  public int xcK;
  public int xcL;
  public int xcM;
  public SKBuiltinBuffer_t xcN;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(148659);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.HFA == null)
      {
        paramVarArgs = new b("Not all required fields were included: ClientMediaId");
        AppMethodBeat.o(148659);
        throw paramVarArgs;
      }
      if (this.HFB == null)
      {
        paramVarArgs = new b("Not all required fields were included: DataMD5");
        AppMethodBeat.o(148659);
        throw paramVarArgs;
      }
      if (this.xcN == null)
      {
        paramVarArgs = new b("Not all required fields were included: Data");
        AppMethodBeat.o(148659);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.lC(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.HFA != null)
      {
        paramVarArgs.lC(2, this.HFA.computeSize());
        this.HFA.writeFields(paramVarArgs);
      }
      if (this.HFB != null)
      {
        paramVarArgs.lC(3, this.HFB.computeSize());
        this.HFB.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(4, this.xcK);
      paramVarArgs.aS(5, this.xcL);
      paramVarArgs.aS(6, this.xcM);
      if (this.xcN != null)
      {
        paramVarArgs.lC(7, this.xcN.computeSize());
        this.xcN.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(8, this.tSp);
      paramVarArgs.aS(9, this.HFC);
      paramVarArgs.aS(10, this.HFD);
      paramVarArgs.aS(11, this.HFE);
      paramVarArgs.aS(12, this.HFF);
      AppMethodBeat.o(148659);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1286;
      }
    }
    label1286:
    for (int i = f.a.a.a.lB(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.HFA != null) {
        paramInt = i + f.a.a.a.lB(2, this.HFA.computeSize());
      }
      i = paramInt;
      if (this.HFB != null) {
        i = paramInt + f.a.a.a.lB(3, this.HFB.computeSize());
      }
      i = i + f.a.a.b.b.a.bz(4, this.xcK) + f.a.a.b.b.a.bz(5, this.xcL) + f.a.a.b.b.a.bz(6, this.xcM);
      paramInt = i;
      if (this.xcN != null) {
        paramInt = i + f.a.a.a.lB(7, this.xcN.computeSize());
      }
      i = f.a.a.b.b.a.bz(8, this.tSp);
      int j = f.a.a.b.b.a.bz(9, this.HFC);
      int k = f.a.a.b.b.a.bz(10, this.HFD);
      int m = f.a.a.b.b.a.bz(11, this.HFE);
      int n = f.a.a.b.b.a.bz(12, this.HFF);
      AppMethodBeat.o(148659);
      return paramInt + i + j + k + m + n;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.HFA == null)
        {
          paramVarArgs = new b("Not all required fields were included: ClientMediaId");
          AppMethodBeat.o(148659);
          throw paramVarArgs;
        }
        if (this.HFB == null)
        {
          paramVarArgs = new b("Not all required fields were included: DataMD5");
          AppMethodBeat.o(148659);
          throw paramVarArgs;
        }
        if (this.xcN == null)
        {
          paramVarArgs = new b("Not all required fields were included: Data");
          AppMethodBeat.o(148659);
          throw paramVarArgs;
        }
        AppMethodBeat.o(148659);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dsv localdsv = (dsv)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(148659);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((jc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdsv.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(148659);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cwt();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cwt)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdsv.HFA = ((cwt)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(148659);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cwt();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cwt)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdsv.HFB = ((cwt)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(148659);
          return 0;
        case 4: 
          localdsv.xcK = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(148659);
          return 0;
        case 5: 
          localdsv.xcL = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(148659);
          return 0;
        case 6: 
          localdsv.xcM = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(148659);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdsv.xcN = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(148659);
          return 0;
        case 8: 
          localdsv.tSp = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(148659);
          return 0;
        case 9: 
          localdsv.HFC = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(148659);
          return 0;
        case 10: 
          localdsv.HFD = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(148659);
          return 0;
        case 11: 
          localdsv.HFE = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(148659);
          return 0;
        }
        localdsv.HFF = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(148659);
        return 0;
      }
      AppMethodBeat.o(148659);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dsv
 * JD-Core Version:    0.7.0.1
 */