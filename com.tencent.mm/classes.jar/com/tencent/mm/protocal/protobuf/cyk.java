package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class cyk
  extends cvp
{
  public String FCR;
  public bzp FCS;
  public bnj FDx;
  public bnk FDy;
  public dl HpA;
  public int Hpz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32422);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(32422);
        throw paramVarArgs;
      }
      if (this.FCS == null)
      {
        paramVarArgs = new b("Not all required fields were included: Contact");
        AppMethodBeat.o(32422);
        throw paramVarArgs;
      }
      if (this.FDx == null)
      {
        paramVarArgs = new b("Not all required fields were included: HardDevice");
        AppMethodBeat.o(32422);
        throw paramVarArgs;
      }
      if (this.FDy == null)
      {
        paramVarArgs = new b("Not all required fields were included: HardDeviceAttr");
        AppMethodBeat.o(32422);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lC(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.FCS != null)
      {
        paramVarArgs.lC(2, this.FCS.computeSize());
        this.FCS.writeFields(paramVarArgs);
      }
      if (this.FDx != null)
      {
        paramVarArgs.lC(3, this.FDx.computeSize());
        this.FDx.writeFields(paramVarArgs);
      }
      if (this.FDy != null)
      {
        paramVarArgs.lC(4, this.FDy.computeSize());
        this.FDy.writeFields(paramVarArgs);
      }
      if (this.FCR != null) {
        paramVarArgs.d(5, this.FCR);
      }
      paramVarArgs.aS(6, this.Hpz);
      if (this.HpA != null)
      {
        paramVarArgs.lC(7, this.HpA.computeSize());
        this.HpA.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(32422);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1247;
      }
    }
    label1247:
    for (int i = f.a.a.a.lB(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.FCS != null) {
        paramInt = i + f.a.a.a.lB(2, this.FCS.computeSize());
      }
      i = paramInt;
      if (this.FDx != null) {
        i = paramInt + f.a.a.a.lB(3, this.FDx.computeSize());
      }
      paramInt = i;
      if (this.FDy != null) {
        paramInt = i + f.a.a.a.lB(4, this.FDy.computeSize());
      }
      i = paramInt;
      if (this.FCR != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.FCR);
      }
      i += f.a.a.b.b.a.bz(6, this.Hpz);
      paramInt = i;
      if (this.HpA != null) {
        paramInt = i + f.a.a.a.lB(7, this.HpA.computeSize());
      }
      AppMethodBeat.o(32422);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(32422);
          throw paramVarArgs;
        }
        if (this.FCS == null)
        {
          paramVarArgs = new b("Not all required fields were included: Contact");
          AppMethodBeat.o(32422);
          throw paramVarArgs;
        }
        if (this.FDx == null)
        {
          paramVarArgs = new b("Not all required fields were included: HardDevice");
          AppMethodBeat.o(32422);
          throw paramVarArgs;
        }
        if (this.FDy == null)
        {
          paramVarArgs = new b("Not all required fields were included: HardDeviceAttr");
          AppMethodBeat.o(32422);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32422);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cyk localcyk = (cyk)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32422);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcyk.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32422);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bzp();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bzp)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcyk.FCS = ((bzp)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32422);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bnj();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bnj)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcyk.FDx = ((bnj)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32422);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bnk();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bnk)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcyk.FDy = ((bnk)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32422);
          return 0;
        case 5: 
          localcyk.FCR = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(32422);
          return 0;
        case 6: 
          localcyk.Hpz = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(32422);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dl();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dl)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localcyk.HpA = ((dl)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(32422);
        return 0;
      }
      AppMethodBeat.o(32422);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cyk
 * JD-Core Version:    0.7.0.1
 */