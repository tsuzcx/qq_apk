package com.tencent.mm.plugin.qqmail.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.ckq;
import com.tencent.mm.protocal.protobuf.ip;
import f.a.a.b;
import java.util.LinkedList;

public final class e
  extends ckq
{
  public String gKn;
  public int uKQ;
  public int uKR;
  public int uKS;
  public SKBuiltinBuffer_t uKT;
  public String uKU;
  public String uKV;
  public int uKW;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(122658);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.uKT == null)
      {
        paramVarArgs = new b("Not all required fields were included: Data");
        AppMethodBeat.o(122658);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.kX(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.gKn != null) {
        paramVarArgs.d(2, this.gKn);
      }
      paramVarArgs.aR(3, this.uKQ);
      paramVarArgs.aR(4, this.uKR);
      paramVarArgs.aR(5, this.uKS);
      if (this.uKT != null)
      {
        paramVarArgs.kX(6, this.uKT.computeSize());
        this.uKT.writeFields(paramVarArgs);
      }
      if (this.uKU != null) {
        paramVarArgs.d(7, this.uKU);
      }
      if (this.uKV != null) {
        paramVarArgs.d(9, this.uKV);
      }
      paramVarArgs.aR(10, this.uKW);
      AppMethodBeat.o(122658);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label878;
      }
    }
    label878:
    for (paramInt = f.a.a.a.kW(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.gKn != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.gKn);
      }
      i = i + f.a.a.b.b.a.bA(3, this.uKQ) + f.a.a.b.b.a.bA(4, this.uKR) + f.a.a.b.b.a.bA(5, this.uKS);
      paramInt = i;
      if (this.uKT != null) {
        paramInt = i + f.a.a.a.kW(6, this.uKT.computeSize());
      }
      i = paramInt;
      if (this.uKU != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.uKU);
      }
      paramInt = i;
      if (this.uKV != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.uKV);
      }
      i = f.a.a.b.b.a.bA(10, this.uKW);
      AppMethodBeat.o(122658);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = ckq.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = ckq.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        if (this.uKT == null)
        {
          paramVarArgs = new b("Not all required fields were included: Data");
          AppMethodBeat.o(122658);
          throw paramVarArgs;
        }
        AppMethodBeat.o(122658);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        e locale = (e)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        case 8: 
        default: 
          AppMethodBeat.o(122658);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ip();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ip)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            locale.BaseRequest = ((ip)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(122658);
          return 0;
        case 2: 
          locale.gKn = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(122658);
          return 0;
        case 3: 
          locale.uKQ = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(122658);
          return 0;
        case 4: 
          locale.uKR = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(122658);
          return 0;
        case 5: 
          locale.uKS = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(122658);
          return 0;
        case 6: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            locale.uKT = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(122658);
          return 0;
        case 7: 
          locale.uKU = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(122658);
          return 0;
        case 9: 
          locale.uKV = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(122658);
          return 0;
        }
        locale.uKW = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(122658);
        return 0;
      }
      AppMethodBeat.o(122658);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.b.e
 * JD-Core Version:    0.7.0.1
 */