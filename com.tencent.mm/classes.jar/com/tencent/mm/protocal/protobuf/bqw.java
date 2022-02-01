package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class bqw
  extends dpc
{
  public int Brl;
  public long Brn;
  public int BsF;
  public int BsG;
  public int BsH;
  public SKBuiltinBuffer_t BsI;
  public dqi KHl;
  public dqi KHm;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152573);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(152573);
        throw paramVarArgs;
      }
      if (this.KHl == null)
      {
        paramVarArgs = new b("Not all required fields were included: FromUserName");
        AppMethodBeat.o(152573);
        throw paramVarArgs;
      }
      if (this.KHm == null)
      {
        paramVarArgs = new b("Not all required fields were included: ToUserName");
        AppMethodBeat.o(152573);
        throw paramVarArgs;
      }
      if (this.BsI == null)
      {
        paramVarArgs = new b("Not all required fields were included: Data");
        AppMethodBeat.o(152573);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ni(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(2, this.Brl);
      if (this.KHl != null)
      {
        paramVarArgs.ni(3, this.KHl.computeSize());
        this.KHl.writeFields(paramVarArgs);
      }
      if (this.KHm != null)
      {
        paramVarArgs.ni(4, this.KHm.computeSize());
        this.KHm.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(5, this.BsF);
      paramVarArgs.aM(6, this.BsG);
      paramVarArgs.aM(7, this.BsH);
      if (this.BsI != null)
      {
        paramVarArgs.ni(8, this.BsI.computeSize());
        this.BsI.writeFields(paramVarArgs);
      }
      paramVarArgs.bb(9, this.Brn);
      AppMethodBeat.o(152573);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1190;
      }
    }
    label1190:
    for (paramInt = g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bu(2, this.Brl);
      paramInt = i;
      if (this.KHl != null) {
        paramInt = i + g.a.a.a.nh(3, this.KHl.computeSize());
      }
      i = paramInt;
      if (this.KHm != null) {
        i = paramInt + g.a.a.a.nh(4, this.KHm.computeSize());
      }
      i = i + g.a.a.b.b.a.bu(5, this.BsF) + g.a.a.b.b.a.bu(6, this.BsG) + g.a.a.b.b.a.bu(7, this.BsH);
      paramInt = i;
      if (this.BsI != null) {
        paramInt = i + g.a.a.a.nh(8, this.BsI.computeSize());
      }
      i = g.a.a.b.b.a.r(9, this.Brn);
      AppMethodBeat.o(152573);
      return paramInt + i;
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
          AppMethodBeat.o(152573);
          throw paramVarArgs;
        }
        if (this.KHl == null)
        {
          paramVarArgs = new b("Not all required fields were included: FromUserName");
          AppMethodBeat.o(152573);
          throw paramVarArgs;
        }
        if (this.KHm == null)
        {
          paramVarArgs = new b("Not all required fields were included: ToUserName");
          AppMethodBeat.o(152573);
          throw paramVarArgs;
        }
        if (this.BsI == null)
        {
          paramVarArgs = new b("Not all required fields were included: Data");
          AppMethodBeat.o(152573);
          throw paramVarArgs;
        }
        AppMethodBeat.o(152573);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        bqw localbqw = (bqw)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(152573);
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
            localbqw.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152573);
          return 0;
        case 2: 
          localbqw.Brl = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(152573);
          return 0;
        case 3: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dqi();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dqi)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localbqw.KHl = ((dqi)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152573);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dqi();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dqi)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localbqw.KHm = ((dqi)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152573);
          return 0;
        case 5: 
          localbqw.BsF = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(152573);
          return 0;
        case 6: 
          localbqw.BsG = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(152573);
          return 0;
        case 7: 
          localbqw.BsH = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(152573);
          return 0;
        case 8: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localbqw.BsI = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152573);
          return 0;
        }
        localbqw.Brn = ((g.a.a.a.a)localObject1).UbS.zl();
        AppMethodBeat.o(152573);
        return 0;
      }
      AppMethodBeat.o(152573);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bqw
 * JD-Core Version:    0.7.0.1
 */