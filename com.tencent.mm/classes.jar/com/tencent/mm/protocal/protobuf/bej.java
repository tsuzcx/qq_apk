package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class bej
  extends cvc
{
  public cwt Fvi;
  public cwt Fvj;
  public int GAB;
  public int xbr;
  public long xbt;
  public int xcK;
  public int xcL;
  public int xcM;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152572);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Fvi == null)
      {
        paramVarArgs = new b("Not all required fields were included: FromUserName");
        AppMethodBeat.o(152572);
        throw paramVarArgs;
      }
      if (this.Fvj == null)
      {
        paramVarArgs = new b("Not all required fields were included: ToUserName");
        AppMethodBeat.o(152572);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.lC(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.xbr);
      if (this.Fvi != null)
      {
        paramVarArgs.lC(3, this.Fvi.computeSize());
        this.Fvi.writeFields(paramVarArgs);
      }
      if (this.Fvj != null)
      {
        paramVarArgs.lC(4, this.Fvj.computeSize());
        this.Fvj.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(5, this.xcK);
      paramVarArgs.aS(6, this.xcL);
      paramVarArgs.aS(7, this.xcM);
      paramVarArgs.aS(8, this.GAB);
      paramVarArgs.aY(9, this.xbt);
      AppMethodBeat.o(152572);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label994;
      }
    }
    label994:
    for (paramInt = f.a.a.a.lB(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.xbr);
      paramInt = i;
      if (this.Fvi != null) {
        paramInt = i + f.a.a.a.lB(3, this.Fvi.computeSize());
      }
      i = paramInt;
      if (this.Fvj != null) {
        i = paramInt + f.a.a.a.lB(4, this.Fvj.computeSize());
      }
      paramInt = f.a.a.b.b.a.bz(5, this.xcK);
      int j = f.a.a.b.b.a.bz(6, this.xcL);
      int k = f.a.a.b.b.a.bz(7, this.xcM);
      int m = f.a.a.b.b.a.bz(8, this.GAB);
      int n = f.a.a.b.b.a.p(9, this.xbt);
      AppMethodBeat.o(152572);
      return i + paramInt + j + k + m + n;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.Fvi == null)
        {
          paramVarArgs = new b("Not all required fields were included: FromUserName");
          AppMethodBeat.o(152572);
          throw paramVarArgs;
        }
        if (this.Fvj == null)
        {
          paramVarArgs = new b("Not all required fields were included: ToUserName");
          AppMethodBeat.o(152572);
          throw paramVarArgs;
        }
        AppMethodBeat.o(152572);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bej localbej = (bej)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(152572);
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
            localbej.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152572);
          return 0;
        case 2: 
          localbej.xbr = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(152572);
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
            localbej.Fvi = ((cwt)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152572);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cwt();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cwt)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbej.Fvj = ((cwt)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152572);
          return 0;
        case 5: 
          localbej.xcK = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(152572);
          return 0;
        case 6: 
          localbej.xcL = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(152572);
          return 0;
        case 7: 
          localbej.xcM = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(152572);
          return 0;
        case 8: 
          localbej.GAB = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(152572);
          return 0;
        }
        localbej.xbt = ((f.a.a.a.a)localObject1).NPN.zd();
        AppMethodBeat.o(152572);
        return 0;
      }
      AppMethodBeat.o(152572);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bej
 * JD-Core Version:    0.7.0.1
 */