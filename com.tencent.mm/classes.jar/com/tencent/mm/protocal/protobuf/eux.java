package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class eux
  extends dpc
{
  public int KZh;
  public SKBuiltinBuffer_t Lev;
  public int LsZ;
  public long Lta;
  public etn NsY;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(115926);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(115926);
        throw paramVarArgs;
      }
      if (this.Lev == null)
      {
        paramVarArgs = new b("Not all required fields were included: KeyBuf");
        AppMethodBeat.o(115926);
        throw paramVarArgs;
      }
      if (this.NsY == null)
      {
        paramVarArgs = new b("Not all required fields were included: CmdList");
        AppMethodBeat.o(115926);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ni(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(3, this.LsZ);
      if (this.Lev != null)
      {
        paramVarArgs.ni(4, this.Lev.computeSize());
        this.Lev.writeFields(paramVarArgs);
      }
      if (this.NsY != null)
      {
        paramVarArgs.ni(5, this.NsY.computeSize());
        this.NsY.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(7, this.KZh);
      paramVarArgs.bb(8, this.Lta);
      AppMethodBeat.o(115926);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label910;
      }
    }
    label910:
    for (paramInt = g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bu(3, this.LsZ);
      paramInt = i;
      if (this.Lev != null) {
        paramInt = i + g.a.a.a.nh(4, this.Lev.computeSize());
      }
      i = paramInt;
      if (this.NsY != null) {
        i = paramInt + g.a.a.a.nh(5, this.NsY.computeSize());
      }
      paramInt = g.a.a.b.b.a.bu(7, this.KZh);
      int j = g.a.a.b.b.a.r(8, this.Lta);
      AppMethodBeat.o(115926);
      return i + paramInt + j;
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
          AppMethodBeat.o(115926);
          throw paramVarArgs;
        }
        if (this.Lev == null)
        {
          paramVarArgs = new b("Not all required fields were included: KeyBuf");
          AppMethodBeat.o(115926);
          throw paramVarArgs;
        }
        if (this.NsY == null)
        {
          paramVarArgs = new b("Not all required fields were included: CmdList");
          AppMethodBeat.o(115926);
          throw paramVarArgs;
        }
        AppMethodBeat.o(115926);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        eux localeux = (eux)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        case 2: 
        case 6: 
        default: 
          AppMethodBeat.o(115926);
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
            localeux.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115926);
          return 0;
        case 3: 
          localeux.LsZ = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(115926);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localeux.Lev = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115926);
          return 0;
        case 5: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new etn();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((etn)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localeux.NsY = ((etn)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115926);
          return 0;
        case 7: 
          localeux.KZh = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(115926);
          return 0;
        }
        localeux.Lta = ((g.a.a.a.a)localObject1).UbS.zl();
        AppMethodBeat.o(115926);
        return 0;
      }
      AppMethodBeat.o(115926);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eux
 * JD-Core Version:    0.7.0.1
 */