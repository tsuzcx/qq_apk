package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class afz
  extends cvc
{
  public int FAt;
  public SKBuiltinBuffer_t FDQ;
  public String FDt;
  public String FEb;
  public String FzI;
  public String GdV;
  public String GdW;
  public int GdX;
  public String qei;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(155402);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.FDQ == null)
      {
        paramVarArgs = new b("Not all required fields were included: RandomEncryKey");
        AppMethodBeat.o(155402);
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
      paramVarArgs.aS(3, this.FAt);
      if (this.FDt != null) {
        paramVarArgs.d(4, this.FDt);
      }
      if (this.qei != null) {
        paramVarArgs.d(5, this.qei);
      }
      if (this.FEb != null) {
        paramVarArgs.d(6, this.FEb);
      }
      if (this.GdV != null) {
        paramVarArgs.d(7, this.GdV);
      }
      if (this.FzI != null) {
        paramVarArgs.d(8, this.FzI);
      }
      if (this.GdW != null) {
        paramVarArgs.d(9, this.GdW);
      }
      paramVarArgs.aS(10, this.GdX);
      AppMethodBeat.o(155402);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label970;
      }
    }
    label970:
    for (paramInt = f.a.a.a.lB(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.FDQ != null) {
        i = paramInt + f.a.a.a.lB(2, this.FDQ.computeSize());
      }
      i += f.a.a.b.b.a.bz(3, this.FAt);
      paramInt = i;
      if (this.FDt != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.FDt);
      }
      i = paramInt;
      if (this.qei != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.qei);
      }
      paramInt = i;
      if (this.FEb != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.FEb);
      }
      i = paramInt;
      if (this.GdV != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.GdV);
      }
      paramInt = i;
      if (this.FzI != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.FzI);
      }
      i = paramInt;
      if (this.GdW != null) {
        i = paramInt + f.a.a.b.b.a.e(9, this.GdW);
      }
      paramInt = f.a.a.b.b.a.bz(10, this.GdX);
      AppMethodBeat.o(155402);
      return i + paramInt;
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
          AppMethodBeat.o(155402);
          throw paramVarArgs;
        }
        AppMethodBeat.o(155402);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        afz localafz = (afz)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(155402);
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
            localafz.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(155402);
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
            localafz.FDQ = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(155402);
          return 0;
        case 3: 
          localafz.FAt = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(155402);
          return 0;
        case 4: 
          localafz.FDt = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(155402);
          return 0;
        case 5: 
          localafz.qei = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(155402);
          return 0;
        case 6: 
          localafz.FEb = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(155402);
          return 0;
        case 7: 
          localafz.GdV = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(155402);
          return 0;
        case 8: 
          localafz.FzI = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(155402);
          return 0;
        case 9: 
          localafz.GdW = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(155402);
          return 0;
        }
        localafz.GdX = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(155402);
        return 0;
      }
      AppMethodBeat.o(155402);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.afz
 * JD-Core Version:    0.7.0.1
 */