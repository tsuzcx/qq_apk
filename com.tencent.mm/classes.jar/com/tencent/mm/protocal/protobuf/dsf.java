package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class dsf
  extends cvc
{
  public String Gcl;
  public String hCW;
  public int xcK;
  public int xcL;
  public int xcM;
  public SKBuiltinBuffer_t xcN;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(90777);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.xcN == null)
      {
        paramVarArgs = new b("Not all required fields were included: Data");
        AppMethodBeat.o(90777);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.lC(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.hCW != null) {
        paramVarArgs.d(2, this.hCW);
      }
      paramVarArgs.aS(3, this.xcK);
      paramVarArgs.aS(4, this.xcL);
      paramVarArgs.aS(5, this.xcM);
      if (this.xcN != null)
      {
        paramVarArgs.lC(6, this.xcN.computeSize());
        this.xcN.writeFields(paramVarArgs);
      }
      if (this.Gcl != null) {
        paramVarArgs.d(7, this.Gcl);
      }
      AppMethodBeat.o(90777);
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
      int i = paramInt;
      if (this.hCW != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.hCW);
      }
      i = i + f.a.a.b.b.a.bz(3, this.xcK) + f.a.a.b.b.a.bz(4, this.xcL) + f.a.a.b.b.a.bz(5, this.xcM);
      paramInt = i;
      if (this.xcN != null) {
        paramInt = i + f.a.a.a.lB(6, this.xcN.computeSize());
      }
      i = paramInt;
      if (this.Gcl != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.Gcl);
      }
      AppMethodBeat.o(90777);
      return i;
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
          AppMethodBeat.o(90777);
          throw paramVarArgs;
        }
        AppMethodBeat.o(90777);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dsf localdsf = (dsf)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(90777);
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
            localdsf.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(90777);
          return 0;
        case 2: 
          localdsf.hCW = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(90777);
          return 0;
        case 3: 
          localdsf.xcK = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(90777);
          return 0;
        case 4: 
          localdsf.xcL = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(90777);
          return 0;
        case 5: 
          localdsf.xcM = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(90777);
          return 0;
        case 6: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdsf.xcN = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(90777);
          return 0;
        }
        localdsf.Gcl = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(90777);
        return 0;
      }
      AppMethodBeat.o(90777);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dsf
 * JD-Core Version:    0.7.0.1
 */