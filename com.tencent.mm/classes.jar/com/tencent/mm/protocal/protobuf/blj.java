package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class blj
  extends cvc
{
  public SKBuiltinBuffer_t Fzc;
  public String GFB;
  public SKBuiltinBuffer_t GtX;
  public int Scene;
  public String nDo;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32315);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Fzc == null)
      {
        paramVarArgs = new b("Not all required fields were included: A2Key");
        AppMethodBeat.o(32315);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.lC(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.Fzc != null)
      {
        paramVarArgs.lC(2, this.Fzc.computeSize());
        this.Fzc.writeFields(paramVarArgs);
      }
      if (this.nDo != null) {
        paramVarArgs.d(3, this.nDo);
      }
      paramVarArgs.aS(4, this.Scene);
      if (this.GFB != null) {
        paramVarArgs.d(5, this.GFB);
      }
      if (this.GtX != null)
      {
        paramVarArgs.lC(6, this.GtX.computeSize());
        this.GtX.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(32315);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label846;
      }
    }
    label846:
    for (int i = f.a.a.a.lB(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Fzc != null) {
        paramInt = i + f.a.a.a.lB(2, this.Fzc.computeSize());
      }
      i = paramInt;
      if (this.nDo != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.nDo);
      }
      i += f.a.a.b.b.a.bz(4, this.Scene);
      paramInt = i;
      if (this.GFB != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.GFB);
      }
      i = paramInt;
      if (this.GtX != null) {
        i = paramInt + f.a.a.a.lB(6, this.GtX.computeSize());
      }
      AppMethodBeat.o(32315);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.Fzc == null)
        {
          paramVarArgs = new b("Not all required fields were included: A2Key");
          AppMethodBeat.o(32315);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32315);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        blj localblj = (blj)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32315);
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
            localblj.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32315);
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
            localblj.Fzc = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32315);
          return 0;
        case 3: 
          localblj.nDo = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(32315);
          return 0;
        case 4: 
          localblj.Scene = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(32315);
          return 0;
        case 5: 
          localblj.GFB = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(32315);
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
          localblj.GtX = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(32315);
        return 0;
      }
      AppMethodBeat.o(32315);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.blj
 * JD-Core Version:    0.7.0.1
 */