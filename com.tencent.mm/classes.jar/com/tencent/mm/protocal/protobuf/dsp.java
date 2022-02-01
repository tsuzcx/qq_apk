package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class dsp
  extends cvc
{
  public int GyK;
  public String HFr;
  public String nDo;
  public int xcK;
  public int xcL;
  public SKBuiltinBuffer_t xcN;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152717);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.xcN == null)
      {
        paramVarArgs = new b("Not all required fields were included: Data");
        AppMethodBeat.o(152717);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.lC(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.xcK);
      paramVarArgs.aS(3, this.xcL);
      paramVarArgs.aS(4, this.GyK);
      if (this.xcN != null)
      {
        paramVarArgs.lC(5, this.xcN.computeSize());
        this.xcN.writeFields(paramVarArgs);
      }
      if (this.HFr != null) {
        paramVarArgs.d(6, this.HFr);
      }
      if (this.nDo != null) {
        paramVarArgs.d(7, this.nDo);
      }
      AppMethodBeat.o(152717);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label766;
      }
    }
    label766:
    for (paramInt = f.a.a.a.lB(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.xcK) + f.a.a.b.b.a.bz(3, this.xcL) + f.a.a.b.b.a.bz(4, this.GyK);
      paramInt = i;
      if (this.xcN != null) {
        paramInt = i + f.a.a.a.lB(5, this.xcN.computeSize());
      }
      i = paramInt;
      if (this.HFr != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.HFr);
      }
      paramInt = i;
      if (this.nDo != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.nDo);
      }
      AppMethodBeat.o(152717);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.xcN == null)
        {
          paramVarArgs = new b("Not all required fields were included: Data");
          AppMethodBeat.o(152717);
          throw paramVarArgs;
        }
        AppMethodBeat.o(152717);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dsp localdsp = (dsp)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(152717);
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
            localdsp.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152717);
          return 0;
        case 2: 
          localdsp.xcK = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(152717);
          return 0;
        case 3: 
          localdsp.xcL = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(152717);
          return 0;
        case 4: 
          localdsp.GyK = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(152717);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdsp.xcN = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152717);
          return 0;
        case 6: 
          localdsp.HFr = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(152717);
          return 0;
        }
        localdsp.nDo = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(152717);
        return 0;
      }
      AppMethodBeat.o(152717);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dsp
 * JD-Core Version:    0.7.0.1
 */