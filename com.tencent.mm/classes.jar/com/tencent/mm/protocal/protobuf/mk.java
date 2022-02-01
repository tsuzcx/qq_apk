package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class mk
  extends dpc
{
  public int KEf;
  public int KEi;
  public SKBuiltinBuffer_t KHp;
  public SKBuiltinBuffer_t KLb;
  public SKBuiltinBuffer_t KLh;
  public SKBuiltinBuffer_t KQA;
  public int KQC;
  public String KQD;
  public String KQE;
  public dql KQo;
  public String KQw;
  public dqi KQz;
  public int oTW;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(155397);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(155397);
        throw paramVarArgs;
      }
      if (this.KHp == null)
      {
        paramVarArgs = new b("Not all required fields were included: ImgBuf");
        AppMethodBeat.o(155397);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ni(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.KQw != null) {
        paramVarArgs.e(2, this.KQw);
      }
      if (this.KHp != null)
      {
        paramVarArgs.ni(3, this.KHp.computeSize());
        this.KHp.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(4, this.KEi);
      paramVarArgs.aM(5, this.KQC);
      if (this.KQD != null) {
        paramVarArgs.e(6, this.KQD);
      }
      paramVarArgs.aM(7, this.oTW);
      if (this.KQE != null) {
        paramVarArgs.e(8, this.KQE);
      }
      if (this.KQz != null)
      {
        paramVarArgs.ni(9, this.KQz.computeSize());
        this.KQz.writeFields(paramVarArgs);
      }
      if (this.KLh != null)
      {
        paramVarArgs.ni(10, this.KLh.computeSize());
        this.KLh.writeFields(paramVarArgs);
      }
      if (this.KQA != null)
      {
        paramVarArgs.ni(11, this.KQA.computeSize());
        this.KQA.writeFields(paramVarArgs);
      }
      if (this.KQo != null)
      {
        paramVarArgs.ni(12, this.KQo.computeSize());
        this.KQo.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(13, this.KEf);
      if (this.KLb != null)
      {
        paramVarArgs.ni(14, this.KLb.computeSize());
        this.KLb.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(155397);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1702;
      }
    }
    label1702:
    for (int i = g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.KQw != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.KQw);
      }
      i = paramInt;
      if (this.KHp != null) {
        i = paramInt + g.a.a.a.nh(3, this.KHp.computeSize());
      }
      i = i + g.a.a.b.b.a.bu(4, this.KEi) + g.a.a.b.b.a.bu(5, this.KQC);
      paramInt = i;
      if (this.KQD != null) {
        paramInt = i + g.a.a.b.b.a.f(6, this.KQD);
      }
      i = paramInt + g.a.a.b.b.a.bu(7, this.oTW);
      paramInt = i;
      if (this.KQE != null) {
        paramInt = i + g.a.a.b.b.a.f(8, this.KQE);
      }
      i = paramInt;
      if (this.KQz != null) {
        i = paramInt + g.a.a.a.nh(9, this.KQz.computeSize());
      }
      paramInt = i;
      if (this.KLh != null) {
        paramInt = i + g.a.a.a.nh(10, this.KLh.computeSize());
      }
      i = paramInt;
      if (this.KQA != null) {
        i = paramInt + g.a.a.a.nh(11, this.KQA.computeSize());
      }
      paramInt = i;
      if (this.KQo != null) {
        paramInt = i + g.a.a.a.nh(12, this.KQo.computeSize());
      }
      i = paramInt + g.a.a.b.b.a.bu(13, this.KEf);
      paramInt = i;
      if (this.KLb != null) {
        paramInt = i + g.a.a.a.nh(14, this.KLb.computeSize());
      }
      AppMethodBeat.o(155397);
      return paramInt;
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
          AppMethodBeat.o(155397);
          throw paramVarArgs;
        }
        if (this.KHp == null)
        {
          paramVarArgs = new b("Not all required fields were included: ImgBuf");
          AppMethodBeat.o(155397);
          throw paramVarArgs;
        }
        AppMethodBeat.o(155397);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        mk localmk = (mk)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(155397);
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
            localmk.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(155397);
          return 0;
        case 2: 
          localmk.KQw = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(155397);
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
            localmk.KHp = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(155397);
          return 0;
        case 4: 
          localmk.KEi = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(155397);
          return 0;
        case 5: 
          localmk.KQC = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(155397);
          return 0;
        case 6: 
          localmk.KQD = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(155397);
          return 0;
        case 7: 
          localmk.oTW = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(155397);
          return 0;
        case 8: 
          localmk.KQE = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(155397);
          return 0;
        case 9: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dqi();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dqi)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localmk.KQz = ((dqi)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(155397);
          return 0;
        case 10: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localmk.KLh = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(155397);
          return 0;
        case 11: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localmk.KQA = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(155397);
          return 0;
        case 12: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dql();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dql)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localmk.KQo = ((dql)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(155397);
          return 0;
        case 13: 
          localmk.KEf = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(155397);
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
          localmk.KLb = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(155397);
        return 0;
      }
      AppMethodBeat.o(155397);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.mk
 * JD-Core Version:    0.7.0.1
 */