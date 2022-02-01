package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class brx
  extends dpc
{
  public String KCL;
  public String KTg;
  public int KWa;
  public String KZj;
  public SKBuiltinBuffer_t LXm;
  public String LXv;
  public int LXw;
  public int LZb;
  public LinkedList<cxt> LZc;
  public int OpCode;
  public String Url;
  
  public brx()
  {
    AppMethodBeat.i(56250);
    this.LZc = new LinkedList();
    AppMethodBeat.o(56250);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(56251);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(56251);
        throw paramVarArgs;
      }
      if (this.LXm == null)
      {
        paramVarArgs = new b("Not all required fields were included: Buff");
        AppMethodBeat.o(56251);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ni(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(2, this.LZb);
      paramVarArgs.e(3, 8, this.LZc);
      paramVarArgs.aM(4, this.OpCode);
      paramVarArgs.aM(5, this.KWa);
      if (this.LXm != null)
      {
        paramVarArgs.ni(6, this.LXm.computeSize());
        this.LXm.writeFields(paramVarArgs);
      }
      if (this.Url != null) {
        paramVarArgs.e(7, this.Url);
      }
      if (this.LXv != null) {
        paramVarArgs.e(8, this.LXv);
      }
      if (this.KTg != null) {
        paramVarArgs.e(9, this.KTg);
      }
      if (this.KCL != null) {
        paramVarArgs.e(10, this.KCL);
      }
      paramVarArgs.aM(11, this.LXw);
      if (this.KZj != null) {
        paramVarArgs.e(12, this.KZj);
      }
      AppMethodBeat.o(56251);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1186;
      }
    }
    label1186:
    for (paramInt = g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bu(2, this.LZb) + g.a.a.a.c(3, 8, this.LZc) + g.a.a.b.b.a.bu(4, this.OpCode) + g.a.a.b.b.a.bu(5, this.KWa);
      paramInt = i;
      if (this.LXm != null) {
        paramInt = i + g.a.a.a.nh(6, this.LXm.computeSize());
      }
      i = paramInt;
      if (this.Url != null) {
        i = paramInt + g.a.a.b.b.a.f(7, this.Url);
      }
      paramInt = i;
      if (this.LXv != null) {
        paramInt = i + g.a.a.b.b.a.f(8, this.LXv);
      }
      i = paramInt;
      if (this.KTg != null) {
        i = paramInt + g.a.a.b.b.a.f(9, this.KTg);
      }
      paramInt = i;
      if (this.KCL != null) {
        paramInt = i + g.a.a.b.b.a.f(10, this.KCL);
      }
      i = paramInt + g.a.a.b.b.a.bu(11, this.LXw);
      paramInt = i;
      if (this.KZj != null) {
        paramInt = i + g.a.a.b.b.a.f(12, this.KZj);
      }
      AppMethodBeat.o(56251);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.LZc.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dpc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dpc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(56251);
          throw paramVarArgs;
        }
        if (this.LXm == null)
        {
          paramVarArgs = new b("Not all required fields were included: Buff");
          AppMethodBeat.o(56251);
          throw paramVarArgs;
        }
        AppMethodBeat.o(56251);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        brx localbrx = (brx)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(56251);
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
            localbrx.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(56251);
          return 0;
        case 2: 
          localbrx.LZb = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(56251);
          return 0;
        case 3: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cxt();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cxt)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localbrx.LZc.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(56251);
          return 0;
        case 4: 
          localbrx.OpCode = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(56251);
          return 0;
        case 5: 
          localbrx.KWa = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(56251);
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
            localbrx.LXm = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(56251);
          return 0;
        case 7: 
          localbrx.Url = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(56251);
          return 0;
        case 8: 
          localbrx.LXv = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(56251);
          return 0;
        case 9: 
          localbrx.KTg = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(56251);
          return 0;
        case 10: 
          localbrx.KCL = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(56251);
          return 0;
        case 11: 
          localbrx.LXw = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(56251);
          return 0;
        }
        localbrx.KZj = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(56251);
        return 0;
      }
      AppMethodBeat.o(56251);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.brx
 * JD-Core Version:    0.7.0.1
 */