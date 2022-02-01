package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dfd
  extends cvc
{
  public cte FvG;
  public SKBuiltinBuffer_t Htx;
  public SKBuiltinBuffer_t Hty;
  public int Htz;
  public long Id;
  public int Scene;
  public int tRT;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125766);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lC(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(2, this.Id);
      paramVarArgs.aS(3, this.Scene);
      if (this.Htx != null)
      {
        paramVarArgs.lC(4, this.Htx.computeSize());
        this.Htx.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(5, this.tRT);
      if (this.Hty != null)
      {
        paramVarArgs.lC(6, this.Hty.computeSize());
        this.Hty.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(7, this.Htz);
      if (this.FvG != null)
      {
        paramVarArgs.lC(8, this.FvG.computeSize());
        this.FvG.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(125766);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label954;
      }
    }
    label954:
    for (paramInt = f.a.a.a.lB(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.p(2, this.Id) + f.a.a.b.b.a.bz(3, this.Scene);
      paramInt = i;
      if (this.Htx != null) {
        paramInt = i + f.a.a.a.lB(4, this.Htx.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bz(5, this.tRT);
      paramInt = i;
      if (this.Hty != null) {
        paramInt = i + f.a.a.a.lB(6, this.Hty.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bz(7, this.Htz);
      paramInt = i;
      if (this.FvG != null) {
        paramInt = i + f.a.a.a.lB(8, this.FvG.computeSize());
      }
      AppMethodBeat.o(125766);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(125766);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dfd localdfd = (dfd)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(125766);
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
            localdfd.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125766);
          return 0;
        case 2: 
          localdfd.Id = ((f.a.a.a.a)localObject1).NPN.zd();
          AppMethodBeat.o(125766);
          return 0;
        case 3: 
          localdfd.Scene = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(125766);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdfd.Htx = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125766);
          return 0;
        case 5: 
          localdfd.tRT = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(125766);
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
            localdfd.Hty = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125766);
          return 0;
        case 7: 
          localdfd.Htz = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(125766);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cte();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cte)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdfd.FvG = ((cte)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(125766);
        return 0;
      }
      AppMethodBeat.o(125766);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dfd
 * JD-Core Version:    0.7.0.1
 */