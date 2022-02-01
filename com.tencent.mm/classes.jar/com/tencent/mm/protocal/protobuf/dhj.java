package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class dhj
  extends ckq
{
  public int Duq;
  public String ExB;
  public String mAQ;
  public int uKQ;
  public int uKR;
  public SKBuiltinBuffer_t uKT;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152717);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.uKT == null)
      {
        paramVarArgs = new b("Not all required fields were included: Data");
        AppMethodBeat.o(152717);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.kX(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.uKQ);
      paramVarArgs.aR(3, this.uKR);
      paramVarArgs.aR(4, this.Duq);
      if (this.uKT != null)
      {
        paramVarArgs.kX(5, this.uKT.computeSize());
        this.uKT.writeFields(paramVarArgs);
      }
      if (this.ExB != null) {
        paramVarArgs.d(6, this.ExB);
      }
      if (this.mAQ != null) {
        paramVarArgs.d(7, this.mAQ);
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
    for (paramInt = f.a.a.a.kW(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bA(2, this.uKQ) + f.a.a.b.b.a.bA(3, this.uKR) + f.a.a.b.b.a.bA(4, this.Duq);
      paramInt = i;
      if (this.uKT != null) {
        paramInt = i + f.a.a.a.kW(5, this.uKT.computeSize());
      }
      i = paramInt;
      if (this.ExB != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.ExB);
      }
      paramInt = i;
      if (this.mAQ != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.mAQ);
      }
      AppMethodBeat.o(152717);
      return paramInt;
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
          AppMethodBeat.o(152717);
          throw paramVarArgs;
        }
        AppMethodBeat.o(152717);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dhj localdhj = (dhj)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(152717);
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
            localdhj.BaseRequest = ((ip)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152717);
          return 0;
        case 2: 
          localdhj.uKQ = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(152717);
          return 0;
        case 3: 
          localdhj.uKR = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(152717);
          return 0;
        case 4: 
          localdhj.Duq = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(152717);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdhj.uKT = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152717);
          return 0;
        case 6: 
          localdhj.ExB = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(152717);
          return 0;
        }
        localdhj.mAQ = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(152717);
        return 0;
      }
      AppMethodBeat.o(152717);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dhj
 * JD-Core Version:    0.7.0.1
 */