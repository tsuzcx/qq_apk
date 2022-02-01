package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class cua
  extends ckq
{
  public cmf ElK;
  public cuj ElL;
  public cmf ElM;
  public int Scene;
  public String gKn;
  public int rNz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125762);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.ElL == null)
      {
        paramVarArgs = new b("Not all required fields were included: Action");
        AppMethodBeat.o(125762);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.kX(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.ElL != null)
      {
        paramVarArgs.kX(2, this.ElL.computeSize());
        this.ElL.writeFields(paramVarArgs);
      }
      if (this.gKn != null) {
        paramVarArgs.d(3, this.gKn);
      }
      if (this.ElK != null)
      {
        paramVarArgs.kX(4, this.ElK.computeSize());
        this.ElK.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(5, this.rNz);
      if (this.ElM != null)
      {
        paramVarArgs.kX(6, this.ElM.computeSize());
        this.ElM.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(7, this.Scene);
      AppMethodBeat.o(125762);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label974;
      }
    }
    label974:
    for (int i = f.a.a.a.kW(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.ElL != null) {
        paramInt = i + f.a.a.a.kW(2, this.ElL.computeSize());
      }
      i = paramInt;
      if (this.gKn != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.gKn);
      }
      paramInt = i;
      if (this.ElK != null) {
        paramInt = i + f.a.a.a.kW(4, this.ElK.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bA(5, this.rNz);
      paramInt = i;
      if (this.ElM != null) {
        paramInt = i + f.a.a.a.kW(6, this.ElM.computeSize());
      }
      i = f.a.a.b.b.a.bA(7, this.Scene);
      AppMethodBeat.o(125762);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = ckq.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = ckq.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        if (this.ElL == null)
        {
          paramVarArgs = new b("Not all required fields were included: Action");
          AppMethodBeat.o(125762);
          throw paramVarArgs;
        }
        AppMethodBeat.o(125762);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cua localcua = (cua)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(125762);
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
            localcua.BaseRequest = ((ip)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125762);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cuj();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cuj)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcua.ElL = ((cuj)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125762);
          return 0;
        case 3: 
          localcua.gKn = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(125762);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cmf();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cmf)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcua.ElK = ((cmf)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125762);
          return 0;
        case 5: 
          localcua.rNz = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(125762);
          return 0;
        case 6: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cmf();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cmf)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcua.ElM = ((cmf)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125762);
          return 0;
        }
        localcua.Scene = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(125762);
        return 0;
      }
      AppMethodBeat.o(125762);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cua
 * JD-Core Version:    0.7.0.1
 */