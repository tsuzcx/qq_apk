package com.tencent.mm.plugin.qqmail.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.cvc;
import com.tencent.mm.protocal.protobuf.jc;
import f.a.a.b;
import java.util.LinkedList;

public final class ah
  extends cvc
{
  public String hCW;
  public int xcK;
  public int xcL;
  public int xcM;
  public SKBuiltinBuffer_t xcN;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(122799);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.xcN == null)
      {
        paramVarArgs = new b("Not all required fields were included: Data");
        AppMethodBeat.o(122799);
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
      AppMethodBeat.o(122799);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label702;
      }
    }
    label702:
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
      AppMethodBeat.o(122799);
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
          AppMethodBeat.o(122799);
          throw paramVarArgs;
        }
        AppMethodBeat.o(122799);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ah localah = (ah)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(122799);
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
            localah.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(122799);
          return 0;
        case 2: 
          localah.hCW = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(122799);
          return 0;
        case 3: 
          localah.xcK = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(122799);
          return 0;
        case 4: 
          localah.xcL = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(122799);
          return 0;
        case 5: 
          localah.xcM = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(122799);
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
          for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localah.xcN = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(122799);
        return 0;
      }
      AppMethodBeat.o(122799);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.d.ah
 * JD-Core Version:    0.7.0.1
 */