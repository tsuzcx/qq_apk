package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class ept
  extends dpc
{
  public String Bri;
  public SKBuiltinBuffer_t KHp;
  public SKBuiltinBuffer_t KLb;
  public String KLg;
  public SKBuiltinBuffer_t KLh;
  public SKBuiltinBuffer_t KQA;
  public dqi KQz;
  public dqi Mdj;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(43134);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(43134);
        throw paramVarArgs;
      }
      if (this.Mdj == null)
      {
        paramVarArgs = new b("Not all required fields were included: ImgSid");
        AppMethodBeat.o(43134);
        throw paramVarArgs;
      }
      if (this.KHp == null)
      {
        paramVarArgs = new b("Not all required fields were included: ImgBuf");
        AppMethodBeat.o(43134);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ni(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.Mdj != null)
      {
        paramVarArgs.ni(2, this.Mdj.computeSize());
        this.Mdj.writeFields(paramVarArgs);
      }
      if (this.KHp != null)
      {
        paramVarArgs.ni(3, this.KHp.computeSize());
        this.KHp.writeFields(paramVarArgs);
      }
      if (this.Bri != null) {
        paramVarArgs.e(4, this.Bri);
      }
      if (this.KQz != null)
      {
        paramVarArgs.ni(5, this.KQz.computeSize());
        this.KQz.writeFields(paramVarArgs);
      }
      if (this.KLh != null)
      {
        paramVarArgs.ni(6, this.KLh.computeSize());
        this.KLh.writeFields(paramVarArgs);
      }
      if (this.KQA != null)
      {
        paramVarArgs.ni(7, this.KQA.computeSize());
        this.KQA.writeFields(paramVarArgs);
      }
      if (this.KLg != null) {
        paramVarArgs.e(8, this.KLg);
      }
      if (this.KLb != null)
      {
        paramVarArgs.ni(9, this.KLb.computeSize());
        this.KLb.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(43134);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1506;
      }
    }
    label1506:
    for (int i = g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Mdj != null) {
        paramInt = i + g.a.a.a.nh(2, this.Mdj.computeSize());
      }
      i = paramInt;
      if (this.KHp != null) {
        i = paramInt + g.a.a.a.nh(3, this.KHp.computeSize());
      }
      paramInt = i;
      if (this.Bri != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.Bri);
      }
      i = paramInt;
      if (this.KQz != null) {
        i = paramInt + g.a.a.a.nh(5, this.KQz.computeSize());
      }
      paramInt = i;
      if (this.KLh != null) {
        paramInt = i + g.a.a.a.nh(6, this.KLh.computeSize());
      }
      i = paramInt;
      if (this.KQA != null) {
        i = paramInt + g.a.a.a.nh(7, this.KQA.computeSize());
      }
      paramInt = i;
      if (this.KLg != null) {
        paramInt = i + g.a.a.b.b.a.f(8, this.KLg);
      }
      i = paramInt;
      if (this.KLb != null) {
        i = paramInt + g.a.a.a.nh(9, this.KLb.computeSize());
      }
      AppMethodBeat.o(43134);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dpc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dpc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(43134);
          throw paramVarArgs;
        }
        if (this.Mdj == null)
        {
          paramVarArgs = new b("Not all required fields were included: ImgSid");
          AppMethodBeat.o(43134);
          throw paramVarArgs;
        }
        if (this.KHp == null)
        {
          paramVarArgs = new b("Not all required fields were included: ImgBuf");
          AppMethodBeat.o(43134);
          throw paramVarArgs;
        }
        AppMethodBeat.o(43134);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        ept localept = (ept)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(43134);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localept.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(43134);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dqi();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dqi)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localept.Mdj = ((dqi)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(43134);
          return 0;
        case 3: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localept.KHp = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(43134);
          return 0;
        case 4: 
          localept.Bri = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(43134);
          return 0;
        case 5: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dqi();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dqi)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localept.KQz = ((dqi)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(43134);
          return 0;
        case 6: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localept.KLh = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(43134);
          return 0;
        case 7: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localept.KQA = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(43134);
          return 0;
        case 8: 
          localept.KLg = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(43134);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new SKBuiltinBuffer_t();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localept.KLb = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(43134);
        return 0;
      }
      AppMethodBeat.o(43134);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ept
 * JD-Core Version:    0.7.0.1
 */