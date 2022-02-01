package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class zs
  extends cpx
{
  public LinkedList<bud> DPz;
  public crm EtW;
  public SKBuiltinBuffer_t EtX;
  public int Scene;
  public int fsB;
  
  public zs()
  {
    AppMethodBeat.i(101797);
    this.DPz = new LinkedList();
    AppMethodBeat.o(101797);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(101798);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.EtW == null)
      {
        paramVarArgs = new b("Not all required fields were included: Topic");
        AppMethodBeat.o(101798);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.ln(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.EtW != null)
      {
        paramVarArgs.ln(2, this.EtW.computeSize());
        this.EtW.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(3, this.fsB);
      paramVarArgs.e(4, 8, this.DPz);
      paramVarArgs.aR(5, this.Scene);
      if (this.EtX != null)
      {
        paramVarArgs.ln(6, this.EtX.computeSize());
        this.EtX.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(101798);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label894;
      }
    }
    label894:
    for (paramInt = f.a.a.a.lm(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.EtW != null) {
        i = paramInt + f.a.a.a.lm(2, this.EtW.computeSize());
      }
      i = i + f.a.a.b.b.a.bx(3, this.fsB) + f.a.a.a.c(4, 8, this.DPz) + f.a.a.b.b.a.bx(5, this.Scene);
      paramInt = i;
      if (this.EtX != null) {
        paramInt = i + f.a.a.a.lm(6, this.EtX.computeSize());
      }
      AppMethodBeat.o(101798);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.DPz.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cpx.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cpx.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        if (this.EtW == null)
        {
          paramVarArgs = new b("Not all required fields were included: Topic");
          AppMethodBeat.o(101798);
          throw paramVarArgs;
        }
        AppMethodBeat.o(101798);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        zs localzs = (zs)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(101798);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new iv();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((iv)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localzs.BaseRequest = ((iv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(101798);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new crm();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((crm)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localzs.EtW = ((crm)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(101798);
          return 0;
        case 3: 
          localzs.fsB = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(101798);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bud();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bud)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localzs.DPz.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(101798);
          return 0;
        case 5: 
          localzs.Scene = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(101798);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new SKBuiltinBuffer_t();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localzs.EtX = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(101798);
        return 0;
      }
      AppMethodBeat.o(101798);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.zs
 * JD-Core Version:    0.7.0.1
 */