package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class biw
  extends cvc
{
  public SKBuiltinBuffer_t FDQ;
  public String FzI;
  public String GDt;
  public String GDu;
  public String GDv;
  public String GDw;
  public String GDx;
  public int GDy;
  public String nEt;
  public String qei;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(155417);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.FDQ == null)
      {
        paramVarArgs = new b("Not all required fields were included: RandomEncryKey");
        AppMethodBeat.o(155417);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.lC(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.FDQ != null)
      {
        paramVarArgs.lC(2, this.FDQ.computeSize());
        this.FDQ.writeFields(paramVarArgs);
      }
      if (this.GDt != null) {
        paramVarArgs.d(3, this.GDt);
      }
      if (this.GDu != null) {
        paramVarArgs.d(4, this.GDu);
      }
      if (this.nEt != null) {
        paramVarArgs.d(5, this.nEt);
      }
      if (this.GDv != null) {
        paramVarArgs.d(6, this.GDv);
      }
      if (this.GDw != null) {
        paramVarArgs.d(7, this.GDw);
      }
      if (this.GDx != null) {
        paramVarArgs.d(8, this.GDx);
      }
      paramVarArgs.aS(9, this.GDy);
      if (this.qei != null) {
        paramVarArgs.d(10, this.qei);
      }
      if (this.FzI != null) {
        paramVarArgs.d(11, this.FzI);
      }
      AppMethodBeat.o(155417);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1050;
      }
    }
    label1050:
    for (int i = f.a.a.a.lB(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.FDQ != null) {
        paramInt = i + f.a.a.a.lB(2, this.FDQ.computeSize());
      }
      i = paramInt;
      if (this.GDt != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.GDt);
      }
      paramInt = i;
      if (this.GDu != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.GDu);
      }
      i = paramInt;
      if (this.nEt != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.nEt);
      }
      paramInt = i;
      if (this.GDv != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.GDv);
      }
      i = paramInt;
      if (this.GDw != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.GDw);
      }
      paramInt = i;
      if (this.GDx != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.GDx);
      }
      i = paramInt + f.a.a.b.b.a.bz(9, this.GDy);
      paramInt = i;
      if (this.qei != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.qei);
      }
      i = paramInt;
      if (this.FzI != null) {
        i = paramInt + f.a.a.b.b.a.e(11, this.FzI);
      }
      AppMethodBeat.o(155417);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.FDQ == null)
        {
          paramVarArgs = new b("Not all required fields were included: RandomEncryKey");
          AppMethodBeat.o(155417);
          throw paramVarArgs;
        }
        AppMethodBeat.o(155417);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        biw localbiw = (biw)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(155417);
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
            localbiw.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(155417);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbiw.FDQ = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(155417);
          return 0;
        case 3: 
          localbiw.GDt = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(155417);
          return 0;
        case 4: 
          localbiw.GDu = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(155417);
          return 0;
        case 5: 
          localbiw.nEt = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(155417);
          return 0;
        case 6: 
          localbiw.GDv = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(155417);
          return 0;
        case 7: 
          localbiw.GDw = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(155417);
          return 0;
        case 8: 
          localbiw.GDx = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(155417);
          return 0;
        case 9: 
          localbiw.GDy = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(155417);
          return 0;
        case 10: 
          localbiw.qei = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(155417);
          return 0;
        }
        localbiw.FzI = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(155417);
        return 0;
      }
      AppMethodBeat.o(155417);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.biw
 * JD-Core Version:    0.7.0.1
 */