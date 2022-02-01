package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class dyy
  extends cvc
{
  public int FRq;
  public SKBuiltinBuffer_t FRr;
  public int GeI;
  public long GeJ;
  public long HJh;
  public dxp HMs;
  public String Hgt;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(115925);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.FRr == null)
      {
        paramVarArgs = new b("Not all required fields were included: KeyBuf");
        AppMethodBeat.o(115925);
        throw paramVarArgs;
      }
      if (this.HMs == null)
      {
        paramVarArgs = new b("Not all required fields were included: OpLog");
        AppMethodBeat.o(115925);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.lC(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.Hgt != null) {
        paramVarArgs.d(2, this.Hgt);
      }
      paramVarArgs.aS(3, this.GeI);
      if (this.FRr != null)
      {
        paramVarArgs.lC(4, this.FRr.computeSize());
        this.FRr.writeFields(paramVarArgs);
      }
      if (this.HMs != null)
      {
        paramVarArgs.lC(5, this.HMs.computeSize());
        this.HMs.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(6, this.GeJ);
      paramVarArgs.aS(7, this.FRq);
      paramVarArgs.aY(8, this.HJh);
      AppMethodBeat.o(115925);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label962;
      }
    }
    label962:
    for (paramInt = f.a.a.a.lB(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Hgt != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.Hgt);
      }
      i += f.a.a.b.b.a.bz(3, this.GeI);
      paramInt = i;
      if (this.FRr != null) {
        paramInt = i + f.a.a.a.lB(4, this.FRr.computeSize());
      }
      i = paramInt;
      if (this.HMs != null) {
        i = paramInt + f.a.a.a.lB(5, this.HMs.computeSize());
      }
      paramInt = f.a.a.b.b.a.p(6, this.GeJ);
      int j = f.a.a.b.b.a.bz(7, this.FRq);
      int k = f.a.a.b.b.a.p(8, this.HJh);
      AppMethodBeat.o(115925);
      return i + paramInt + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.FRr == null)
        {
          paramVarArgs = new b("Not all required fields were included: KeyBuf");
          AppMethodBeat.o(115925);
          throw paramVarArgs;
        }
        if (this.HMs == null)
        {
          paramVarArgs = new b("Not all required fields were included: OpLog");
          AppMethodBeat.o(115925);
          throw paramVarArgs;
        }
        AppMethodBeat.o(115925);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dyy localdyy = (dyy)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(115925);
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
            localdyy.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115925);
          return 0;
        case 2: 
          localdyy.Hgt = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(115925);
          return 0;
        case 3: 
          localdyy.GeI = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(115925);
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
            localdyy.FRr = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115925);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dxp();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dxp)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdyy.HMs = ((dxp)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115925);
          return 0;
        case 6: 
          localdyy.GeJ = ((f.a.a.a.a)localObject1).NPN.zd();
          AppMethodBeat.o(115925);
          return 0;
        case 7: 
          localdyy.FRq = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(115925);
          return 0;
        }
        localdyy.HJh = ((f.a.a.a.a)localObject1).NPN.zd();
        AppMethodBeat.o(115925);
        return 0;
      }
      AppMethodBeat.o(115925);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dyy
 * JD-Core Version:    0.7.0.1
 */