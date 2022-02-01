package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class cnt
  extends cld
{
  public String CEV;
  public bqj CEW;
  public bfj CFB;
  public bfk CFC;
  public int Eic;
  public di Eid;
  
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
      if (this.CEW == null)
      {
        paramVarArgs = new b("Not all required fields were included: Contact");
        AppMethodBeat.o(32422);
        throw paramVarArgs;
      }
      if (this.CFB == null)
      {
        paramVarArgs = new b("Not all required fields were included: HardDevice");
        AppMethodBeat.o(32422);
        throw paramVarArgs;
      }
      if (this.CFC == null)
      {
        paramVarArgs = new b("Not all required fields were included: HardDeviceAttr");
        AppMethodBeat.o(32422);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.kX(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.CEW != null)
      {
        paramVarArgs.kX(2, this.CEW.computeSize());
        this.CEW.writeFields(paramVarArgs);
      }
      if (this.CFB != null)
      {
        paramVarArgs.kX(3, this.CFB.computeSize());
        this.CFB.writeFields(paramVarArgs);
      }
      if (this.CFC != null)
      {
        paramVarArgs.kX(4, this.CFC.computeSize());
        this.CFC.writeFields(paramVarArgs);
      }
      if (this.CEV != null) {
        paramVarArgs.d(5, this.CEV);
      }
      paramVarArgs.aR(6, this.Eic);
      if (this.Eid != null)
      {
        paramVarArgs.kX(7, this.Eid.computeSize());
        this.Eid.writeFields(paramVarArgs);
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
    for (int i = f.a.a.a.kW(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.CEW != null) {
        paramInt = i + f.a.a.a.kW(2, this.CEW.computeSize());
      }
      i = paramInt;
      if (this.CFB != null) {
        i = paramInt + f.a.a.a.kW(3, this.CFB.computeSize());
      }
      paramInt = i;
      if (this.CFC != null) {
        paramInt = i + f.a.a.a.kW(4, this.CFC.computeSize());
      }
      i = paramInt;
      if (this.CEV != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.CEV);
      }
      i += f.a.a.b.b.a.bA(6, this.Eic);
      paramInt = i;
      if (this.Eid != null) {
        paramInt = i + f.a.a.a.kW(7, this.Eid.computeSize());
      }
      AppMethodBeat.o(32422);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cld.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cld.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(32422);
          throw paramVarArgs;
        }
        if (this.CEW == null)
        {
          paramVarArgs = new b("Not all required fields were included: Contact");
          AppMethodBeat.o(32422);
          throw paramVarArgs;
        }
        if (this.CFB == null)
        {
          paramVarArgs = new b("Not all required fields were included: HardDevice");
          AppMethodBeat.o(32422);
          throw paramVarArgs;
        }
        if (this.CFC == null)
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
        cnt localcnt = (cnt)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32422);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcnt.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32422);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bqj();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bqj)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcnt.CEW = ((bqj)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32422);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bfj();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bfj)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcnt.CFB = ((bfj)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32422);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bfk();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bfk)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcnt.CFC = ((bfk)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32422);
          return 0;
        case 5: 
          localcnt.CEV = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(32422);
          return 0;
        case 6: 
          localcnt.Eic = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(32422);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new di();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((di)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localcnt.Eid = ((di)localObject1);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cnt
 * JD-Core Version:    0.7.0.1
 */