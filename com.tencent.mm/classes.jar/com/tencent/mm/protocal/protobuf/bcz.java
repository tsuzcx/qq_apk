package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class bcz
  extends cvc
{
  public int FAt;
  public btm GbC;
  public String Gsr;
  public SKBuiltinBuffer_t GzA;
  public int GzB;
  public int GzC;
  public LinkedList<ckk> GzD;
  public int GzE;
  public int Scene;
  
  public bcz()
  {
    AppMethodBeat.i(32249);
    this.GzD = new LinkedList();
    AppMethodBeat.o(32249);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32250);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.GbC == null)
      {
        paramVarArgs = new b("Not all required fields were included: Loc");
        AppMethodBeat.o(32250);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.lC(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.FAt);
      paramVarArgs.aS(3, this.Scene);
      if (this.GzA != null)
      {
        paramVarArgs.lC(4, this.GzA.computeSize());
        this.GzA.writeFields(paramVarArgs);
      }
      if (this.GbC != null)
      {
        paramVarArgs.lC(5, this.GbC.computeSize());
        this.GbC.writeFields(paramVarArgs);
      }
      if (this.Gsr != null) {
        paramVarArgs.d(6, this.Gsr);
      }
      paramVarArgs.aS(7, this.GzB);
      paramVarArgs.aS(8, this.GzC);
      paramVarArgs.e(11, 8, this.GzD);
      paramVarArgs.aS(12, this.GzE);
      AppMethodBeat.o(32250);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1126;
      }
    }
    label1126:
    for (paramInt = f.a.a.a.lB(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.FAt) + f.a.a.b.b.a.bz(3, this.Scene);
      paramInt = i;
      if (this.GzA != null) {
        paramInt = i + f.a.a.a.lB(4, this.GzA.computeSize());
      }
      i = paramInt;
      if (this.GbC != null) {
        i = paramInt + f.a.a.a.lB(5, this.GbC.computeSize());
      }
      paramInt = i;
      if (this.Gsr != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.Gsr);
      }
      i = f.a.a.b.b.a.bz(7, this.GzB);
      int j = f.a.a.b.b.a.bz(8, this.GzC);
      int k = f.a.a.a.c(11, 8, this.GzD);
      int m = f.a.a.b.b.a.bz(12, this.GzE);
      AppMethodBeat.o(32250);
      return paramInt + i + j + k + m;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.GzD.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cvc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.GbC == null)
        {
          paramVarArgs = new b("Not all required fields were included: Loc");
          AppMethodBeat.o(32250);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32250);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bcz localbcz = (bcz)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        case 9: 
        case 10: 
        default: 
          AppMethodBeat.o(32250);
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
            localbcz.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32250);
          return 0;
        case 2: 
          localbcz.FAt = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(32250);
          return 0;
        case 3: 
          localbcz.Scene = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(32250);
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
            localbcz.GzA = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32250);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new btm();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((btm)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbcz.GbC = ((btm)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32250);
          return 0;
        case 6: 
          localbcz.Gsr = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(32250);
          return 0;
        case 7: 
          localbcz.GzB = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(32250);
          return 0;
        case 8: 
          localbcz.GzC = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(32250);
          return 0;
        case 11: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ckk();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ckk)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbcz.GzD.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32250);
          return 0;
        }
        localbcz.GzE = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(32250);
        return 0;
      }
      AppMethodBeat.o(32250);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bcz
 * JD-Core Version:    0.7.0.1
 */