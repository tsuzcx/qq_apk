package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class mi
  extends dpc
{
  public int KEf;
  public dyh KLj;
  public String KLk;
  public int KLo;
  public int KPZ;
  public String KQa;
  public cta KQe;
  public String KQg;
  public int KQh;
  public String KQi;
  public ccb KQj;
  public qy KQk;
  public ctb KQl;
  public String KQm;
  public int KQn;
  public dql KQo;
  public String KQp;
  public String KQq;
  public String KQr;
  public String KQs;
  public int KQt;
  public String Username;
  public String dHx;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(134244);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(134244);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ni(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.dHx != null) {
        paramVarArgs.e(2, this.dHx);
      }
      if (this.KQg != null) {
        paramVarArgs.e(3, this.KQg);
      }
      paramVarArgs.aM(4, this.KQh);
      if (this.KQi != null) {
        paramVarArgs.e(5, this.KQi);
      }
      if (this.Username != null) {
        paramVarArgs.e(6, this.Username);
      }
      if (this.KQj != null)
      {
        paramVarArgs.ni(7, this.KQj.computeSize());
        this.KQj.writeFields(paramVarArgs);
      }
      if (this.KQk != null)
      {
        paramVarArgs.ni(8, this.KQk.computeSize());
        this.KQk.writeFields(paramVarArgs);
      }
      if (this.KQl != null)
      {
        paramVarArgs.ni(9, this.KQl.computeSize());
        this.KQl.writeFields(paramVarArgs);
      }
      if (this.KLk != null) {
        paramVarArgs.e(10, this.KLk);
      }
      paramVarArgs.aM(11, this.KEf);
      if (this.KQm != null) {
        paramVarArgs.e(12, this.KQm);
      }
      paramVarArgs.aM(13, this.KQn);
      if (this.KQo != null)
      {
        paramVarArgs.ni(14, this.KQo.computeSize());
        this.KQo.writeFields(paramVarArgs);
      }
      if (this.KQp != null) {
        paramVarArgs.e(15, this.KQp);
      }
      if (this.KQq != null) {
        paramVarArgs.e(16, this.KQq);
      }
      if (this.KLj != null)
      {
        paramVarArgs.ni(17, this.KLj.computeSize());
        this.KLj.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(18, this.KLo);
      if (this.KQr != null) {
        paramVarArgs.e(19, this.KQr);
      }
      if (this.KQs != null) {
        paramVarArgs.e(20, this.KQs);
      }
      paramVarArgs.aM(21, this.KPZ);
      if (this.KQa != null) {
        paramVarArgs.e(22, this.KQa);
      }
      paramVarArgs.aM(23, this.KQt);
      if (this.KQe != null)
      {
        paramVarArgs.ni(24, this.KQe.computeSize());
        this.KQe.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(134244);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label2246;
      }
    }
    label2246:
    for (int i = g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.dHx != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.dHx);
      }
      i = paramInt;
      if (this.KQg != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.KQg);
      }
      i += g.a.a.b.b.a.bu(4, this.KQh);
      paramInt = i;
      if (this.KQi != null) {
        paramInt = i + g.a.a.b.b.a.f(5, this.KQi);
      }
      i = paramInt;
      if (this.Username != null) {
        i = paramInt + g.a.a.b.b.a.f(6, this.Username);
      }
      paramInt = i;
      if (this.KQj != null) {
        paramInt = i + g.a.a.a.nh(7, this.KQj.computeSize());
      }
      i = paramInt;
      if (this.KQk != null) {
        i = paramInt + g.a.a.a.nh(8, this.KQk.computeSize());
      }
      paramInt = i;
      if (this.KQl != null) {
        paramInt = i + g.a.a.a.nh(9, this.KQl.computeSize());
      }
      i = paramInt;
      if (this.KLk != null) {
        i = paramInt + g.a.a.b.b.a.f(10, this.KLk);
      }
      i += g.a.a.b.b.a.bu(11, this.KEf);
      paramInt = i;
      if (this.KQm != null) {
        paramInt = i + g.a.a.b.b.a.f(12, this.KQm);
      }
      i = paramInt + g.a.a.b.b.a.bu(13, this.KQn);
      paramInt = i;
      if (this.KQo != null) {
        paramInt = i + g.a.a.a.nh(14, this.KQo.computeSize());
      }
      i = paramInt;
      if (this.KQp != null) {
        i = paramInt + g.a.a.b.b.a.f(15, this.KQp);
      }
      paramInt = i;
      if (this.KQq != null) {
        paramInt = i + g.a.a.b.b.a.f(16, this.KQq);
      }
      i = paramInt;
      if (this.KLj != null) {
        i = paramInt + g.a.a.a.nh(17, this.KLj.computeSize());
      }
      i += g.a.a.b.b.a.bu(18, this.KLo);
      paramInt = i;
      if (this.KQr != null) {
        paramInt = i + g.a.a.b.b.a.f(19, this.KQr);
      }
      i = paramInt;
      if (this.KQs != null) {
        i = paramInt + g.a.a.b.b.a.f(20, this.KQs);
      }
      i += g.a.a.b.b.a.bu(21, this.KPZ);
      paramInt = i;
      if (this.KQa != null) {
        paramInt = i + g.a.a.b.b.a.f(22, this.KQa);
      }
      i = paramInt + g.a.a.b.b.a.bu(23, this.KQt);
      paramInt = i;
      if (this.KQe != null) {
        paramInt = i + g.a.a.a.nh(24, this.KQe.computeSize());
      }
      AppMethodBeat.o(134244);
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
          AppMethodBeat.o(134244);
          throw paramVarArgs;
        }
        AppMethodBeat.o(134244);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        mi localmi = (mi)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(134244);
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
            localmi.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(134244);
          return 0;
        case 2: 
          localmi.dHx = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(134244);
          return 0;
        case 3: 
          localmi.KQg = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(134244);
          return 0;
        case 4: 
          localmi.KQh = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(134244);
          return 0;
        case 5: 
          localmi.KQi = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(134244);
          return 0;
        case 6: 
          localmi.Username = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(134244);
          return 0;
        case 7: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ccb();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ccb)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localmi.KQj = ((ccb)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(134244);
          return 0;
        case 8: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new qy();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((qy)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localmi.KQk = ((qy)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(134244);
          return 0;
        case 9: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ctb();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ctb)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localmi.KQl = ((ctb)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(134244);
          return 0;
        case 10: 
          localmi.KLk = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(134244);
          return 0;
        case 11: 
          localmi.KEf = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(134244);
          return 0;
        case 12: 
          localmi.KQm = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(134244);
          return 0;
        case 13: 
          localmi.KQn = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(134244);
          return 0;
        case 14: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dql();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dql)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localmi.KQo = ((dql)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(134244);
          return 0;
        case 15: 
          localmi.KQp = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(134244);
          return 0;
        case 16: 
          localmi.KQq = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(134244);
          return 0;
        case 17: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dyh();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dyh)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localmi.KLj = ((dyh)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(134244);
          return 0;
        case 18: 
          localmi.KLo = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(134244);
          return 0;
        case 19: 
          localmi.KQr = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(134244);
          return 0;
        case 20: 
          localmi.KQs = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(134244);
          return 0;
        case 21: 
          localmi.KPZ = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(134244);
          return 0;
        case 22: 
          localmi.KQa = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(134244);
          return 0;
        case 23: 
          localmi.KQt = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(134244);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cta();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cta)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localmi.KQe = ((cta)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(134244);
        return 0;
      }
      AppMethodBeat.o(134244);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.mi
 * JD-Core Version:    0.7.0.1
 */