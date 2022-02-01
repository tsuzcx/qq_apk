package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class cta
  extends cqk
{
  public String DXv;
  public bva DXw;
  public bjb DYb;
  public bjc DYc;
  public int FFa;
  public dk FFb;
  
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
      if (this.DXw == null)
      {
        paramVarArgs = new b("Not all required fields were included: Contact");
        AppMethodBeat.o(32422);
        throw paramVarArgs;
      }
      if (this.DYb == null)
      {
        paramVarArgs = new b("Not all required fields were included: HardDevice");
        AppMethodBeat.o(32422);
        throw paramVarArgs;
      }
      if (this.DYc == null)
      {
        paramVarArgs = new b("Not all required fields were included: HardDeviceAttr");
        AppMethodBeat.o(32422);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ln(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.DXw != null)
      {
        paramVarArgs.ln(2, this.DXw.computeSize());
        this.DXw.writeFields(paramVarArgs);
      }
      if (this.DYb != null)
      {
        paramVarArgs.ln(3, this.DYb.computeSize());
        this.DYb.writeFields(paramVarArgs);
      }
      if (this.DYc != null)
      {
        paramVarArgs.ln(4, this.DYc.computeSize());
        this.DYc.writeFields(paramVarArgs);
      }
      if (this.DXv != null) {
        paramVarArgs.d(5, this.DXv);
      }
      paramVarArgs.aR(6, this.FFa);
      if (this.FFb != null)
      {
        paramVarArgs.ln(7, this.FFb.computeSize());
        this.FFb.writeFields(paramVarArgs);
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
    for (int i = f.a.a.a.lm(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.DXw != null) {
        paramInt = i + f.a.a.a.lm(2, this.DXw.computeSize());
      }
      i = paramInt;
      if (this.DYb != null) {
        i = paramInt + f.a.a.a.lm(3, this.DYb.computeSize());
      }
      paramInt = i;
      if (this.DYc != null) {
        paramInt = i + f.a.a.a.lm(4, this.DYc.computeSize());
      }
      i = paramInt;
      if (this.DXv != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.DXv);
      }
      i += f.a.a.b.b.a.bx(6, this.FFa);
      paramInt = i;
      if (this.FFb != null) {
        paramInt = i + f.a.a.a.lm(7, this.FFb.computeSize());
      }
      AppMethodBeat.o(32422);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cqk.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cqk.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(32422);
          throw paramVarArgs;
        }
        if (this.DXw == null)
        {
          paramVarArgs = new b("Not all required fields were included: Contact");
          AppMethodBeat.o(32422);
          throw paramVarArgs;
        }
        if (this.DYb == null)
        {
          paramVarArgs = new b("Not all required fields were included: HardDevice");
          AppMethodBeat.o(32422);
          throw paramVarArgs;
        }
        if (this.DYc == null)
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
        cta localcta = (cta)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32422);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcta.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32422);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bva();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bva)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcta.DXw = ((bva)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32422);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bjb();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bjb)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcta.DYb = ((bjb)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32422);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bjc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bjc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcta.DYc = ((bjc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32422);
          return 0;
        case 5: 
          localcta.DXv = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(32422);
          return 0;
        case 6: 
          localcta.FFa = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(32422);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dk();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dk)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localcta.FFb = ((dk)localObject1);
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
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cta
 * JD-Core Version:    0.7.0.1
 */