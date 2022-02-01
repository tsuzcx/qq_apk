package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class yx
  extends ckq
{
  public LinkedList<bpm> Cxd;
  public cmf DaZ;
  public SKBuiltinBuffer_t Dba;
  public int Scene;
  public int fpb;
  
  public yx()
  {
    AppMethodBeat.i(101797);
    this.Cxd = new LinkedList();
    AppMethodBeat.o(101797);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(101798);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.DaZ == null)
      {
        paramVarArgs = new b("Not all required fields were included: Topic");
        AppMethodBeat.o(101798);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.kX(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.DaZ != null)
      {
        paramVarArgs.kX(2, this.DaZ.computeSize());
        this.DaZ.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(3, this.fpb);
      paramVarArgs.e(4, 8, this.Cxd);
      paramVarArgs.aR(5, this.Scene);
      if (this.Dba != null)
      {
        paramVarArgs.kX(6, this.Dba.computeSize());
        this.Dba.writeFields(paramVarArgs);
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
    for (paramInt = f.a.a.a.kW(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.DaZ != null) {
        i = paramInt + f.a.a.a.kW(2, this.DaZ.computeSize());
      }
      i = i + f.a.a.b.b.a.bA(3, this.fpb) + f.a.a.a.c(4, 8, this.Cxd) + f.a.a.b.b.a.bA(5, this.Scene);
      paramInt = i;
      if (this.Dba != null) {
        paramInt = i + f.a.a.a.kW(6, this.Dba.computeSize());
      }
      AppMethodBeat.o(101798);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Cxd.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = ckq.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = ckq.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        if (this.DaZ == null)
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
        yx localyx = (yx)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(101798);
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
            localyx.BaseRequest = ((ip)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(101798);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cmf();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cmf)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localyx.DaZ = ((cmf)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(101798);
          return 0;
        case 3: 
          localyx.fpb = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(101798);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bpm();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bpm)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localyx.Cxd.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(101798);
          return 0;
        case 5: 
          localyx.Scene = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(101798);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new SKBuiltinBuffer_t();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localyx.Dba = ((SKBuiltinBuffer_t)localObject1);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.yx
 * JD-Core Version:    0.7.0.1
 */