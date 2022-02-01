package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class env
  extends dpc
{
  public int Brl;
  public long Brn;
  public int BsF;
  public int BsG;
  public int BsH;
  public int CreateTime;
  public dqi KHl;
  public dqi KHm;
  public String KHq;
  public String KMl;
  public String LbJ;
  public int LbO;
  public dqi NlB;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152720);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(152720);
        throw paramVarArgs;
      }
      if (this.NlB == null)
      {
        paramVarArgs = new b("Not all required fields were included: ClientImgId");
        AppMethodBeat.o(152720);
        throw paramVarArgs;
      }
      if (this.KHl == null)
      {
        paramVarArgs = new b("Not all required fields were included: FromUserName");
        AppMethodBeat.o(152720);
        throw paramVarArgs;
      }
      if (this.KHm == null)
      {
        paramVarArgs = new b("Not all required fields were included: ToUserName");
        AppMethodBeat.o(152720);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ni(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(2, this.Brl);
      if (this.NlB != null)
      {
        paramVarArgs.ni(3, this.NlB.computeSize());
        this.NlB.writeFields(paramVarArgs);
      }
      if (this.KHl != null)
      {
        paramVarArgs.ni(4, this.KHl.computeSize());
        this.KHl.writeFields(paramVarArgs);
      }
      if (this.KHm != null)
      {
        paramVarArgs.ni(5, this.KHm.computeSize());
        this.KHm.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(6, this.BsF);
      paramVarArgs.aM(7, this.BsG);
      paramVarArgs.aM(8, this.BsH);
      paramVarArgs.aM(9, this.CreateTime);
      paramVarArgs.bb(10, this.Brn);
      if (this.LbJ != null) {
        paramVarArgs.e(11, this.LbJ);
      }
      if (this.KMl != null) {
        paramVarArgs.e(12, this.KMl);
      }
      if (this.KHq != null) {
        paramVarArgs.e(13, this.KHq);
      }
      paramVarArgs.aM(14, this.LbO);
      AppMethodBeat.o(152720);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1462;
      }
    }
    label1462:
    for (paramInt = g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bu(2, this.Brl);
      paramInt = i;
      if (this.NlB != null) {
        paramInt = i + g.a.a.a.nh(3, this.NlB.computeSize());
      }
      i = paramInt;
      if (this.KHl != null) {
        i = paramInt + g.a.a.a.nh(4, this.KHl.computeSize());
      }
      paramInt = i;
      if (this.KHm != null) {
        paramInt = i + g.a.a.a.nh(5, this.KHm.computeSize());
      }
      i = paramInt + g.a.a.b.b.a.bu(6, this.BsF) + g.a.a.b.b.a.bu(7, this.BsG) + g.a.a.b.b.a.bu(8, this.BsH) + g.a.a.b.b.a.bu(9, this.CreateTime) + g.a.a.b.b.a.r(10, this.Brn);
      paramInt = i;
      if (this.LbJ != null) {
        paramInt = i + g.a.a.b.b.a.f(11, this.LbJ);
      }
      i = paramInt;
      if (this.KMl != null) {
        i = paramInt + g.a.a.b.b.a.f(12, this.KMl);
      }
      paramInt = i;
      if (this.KHq != null) {
        paramInt = i + g.a.a.b.b.a.f(13, this.KHq);
      }
      i = g.a.a.b.b.a.bu(14, this.LbO);
      AppMethodBeat.o(152720);
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
          AppMethodBeat.o(152720);
          throw paramVarArgs;
        }
        if (this.NlB == null)
        {
          paramVarArgs = new b("Not all required fields were included: ClientImgId");
          AppMethodBeat.o(152720);
          throw paramVarArgs;
        }
        if (this.KHl == null)
        {
          paramVarArgs = new b("Not all required fields were included: FromUserName");
          AppMethodBeat.o(152720);
          throw paramVarArgs;
        }
        if (this.KHm == null)
        {
          paramVarArgs = new b("Not all required fields were included: ToUserName");
          AppMethodBeat.o(152720);
          throw paramVarArgs;
        }
        AppMethodBeat.o(152720);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        env localenv = (env)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(152720);
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
            localenv.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152720);
          return 0;
        case 2: 
          localenv.Brl = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(152720);
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
            localenv.NlB = ((dqi)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152720);
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
            localenv.KHl = ((dqi)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152720);
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
            localenv.KHm = ((dqi)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152720);
          return 0;
        case 6: 
          localenv.BsF = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(152720);
          return 0;
        case 7: 
          localenv.BsG = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(152720);
          return 0;
        case 8: 
          localenv.BsH = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(152720);
          return 0;
        case 9: 
          localenv.CreateTime = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(152720);
          return 0;
        case 10: 
          localenv.Brn = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(152720);
          return 0;
        case 11: 
          localenv.LbJ = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(152720);
          return 0;
        case 12: 
          localenv.KMl = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(152720);
          return 0;
        case 13: 
          localenv.KHq = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(152720);
          return 0;
        }
        localenv.LbO = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(152720);
        return 0;
      }
      AppMethodBeat.o(152720);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.env
 * JD-Core Version:    0.7.0.1
 */