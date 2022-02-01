package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class ph
  extends dpc
{
  public int KTf;
  public mq KWe;
  public np KWf;
  public ov KWg;
  public nr KWh;
  public ov KWi;
  public py KWj;
  public LinkedList<bfu> KWk;
  public int KWl;
  public dey KWm;
  public String KWn;
  public qg KWo;
  public qj KWp;
  
  public ph()
  {
    AppMethodBeat.i(124444);
    this.KWk = new LinkedList();
    AppMethodBeat.o(124444);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124445);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(124445);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ni(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.KWe != null)
      {
        paramVarArgs.ni(2, this.KWe.computeSize());
        this.KWe.writeFields(paramVarArgs);
      }
      if (this.KWf != null)
      {
        paramVarArgs.ni(3, this.KWf.computeSize());
        this.KWf.writeFields(paramVarArgs);
      }
      if (this.KWg != null)
      {
        paramVarArgs.ni(4, this.KWg.computeSize());
        this.KWg.writeFields(paramVarArgs);
      }
      if (this.KWh != null)
      {
        paramVarArgs.ni(5, this.KWh.computeSize());
        this.KWh.writeFields(paramVarArgs);
      }
      if (this.KWi != null)
      {
        paramVarArgs.ni(6, this.KWi.computeSize());
        this.KWi.writeFields(paramVarArgs);
      }
      if (this.KWj != null)
      {
        paramVarArgs.ni(7, this.KWj.computeSize());
        this.KWj.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(8, this.KTf);
      paramVarArgs.e(9, 8, this.KWk);
      paramVarArgs.aM(10, this.KWl);
      if (this.KWm != null)
      {
        paramVarArgs.ni(11, this.KWm.computeSize());
        this.KWm.writeFields(paramVarArgs);
      }
      if (this.KWn != null) {
        paramVarArgs.e(12, this.KWn);
      }
      if (this.KWo != null)
      {
        paramVarArgs.ni(13, this.KWo.computeSize());
        this.KWo.writeFields(paramVarArgs);
      }
      if (this.KWp != null)
      {
        paramVarArgs.ni(14, this.KWp.computeSize());
        this.KWp.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(124445);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label2046;
      }
    }
    label2046:
    for (int i = g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.KWe != null) {
        paramInt = i + g.a.a.a.nh(2, this.KWe.computeSize());
      }
      i = paramInt;
      if (this.KWf != null) {
        i = paramInt + g.a.a.a.nh(3, this.KWf.computeSize());
      }
      paramInt = i;
      if (this.KWg != null) {
        paramInt = i + g.a.a.a.nh(4, this.KWg.computeSize());
      }
      i = paramInt;
      if (this.KWh != null) {
        i = paramInt + g.a.a.a.nh(5, this.KWh.computeSize());
      }
      paramInt = i;
      if (this.KWi != null) {
        paramInt = i + g.a.a.a.nh(6, this.KWi.computeSize());
      }
      i = paramInt;
      if (this.KWj != null) {
        i = paramInt + g.a.a.a.nh(7, this.KWj.computeSize());
      }
      i = i + g.a.a.b.b.a.bu(8, this.KTf) + g.a.a.a.c(9, 8, this.KWk) + g.a.a.b.b.a.bu(10, this.KWl);
      paramInt = i;
      if (this.KWm != null) {
        paramInt = i + g.a.a.a.nh(11, this.KWm.computeSize());
      }
      i = paramInt;
      if (this.KWn != null) {
        i = paramInt + g.a.a.b.b.a.f(12, this.KWn);
      }
      paramInt = i;
      if (this.KWo != null) {
        paramInt = i + g.a.a.a.nh(13, this.KWo.computeSize());
      }
      i = paramInt;
      if (this.KWp != null) {
        i = paramInt + g.a.a.a.nh(14, this.KWp.computeSize());
      }
      AppMethodBeat.o(124445);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.KWk.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dpc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dpc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(124445);
          throw paramVarArgs;
        }
        AppMethodBeat.o(124445);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        ph localph = (ph)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(124445);
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
            localph.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(124445);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new mq();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((mq)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localph.KWe = ((mq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(124445);
          return 0;
        case 3: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new np();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((np)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localph.KWf = ((np)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(124445);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ov();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ov)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localph.KWg = ((ov)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(124445);
          return 0;
        case 5: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new nr();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((nr)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localph.KWh = ((nr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(124445);
          return 0;
        case 6: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ov();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ov)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localph.KWi = ((ov)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(124445);
          return 0;
        case 7: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new py();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((py)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localph.KWj = ((py)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(124445);
          return 0;
        case 8: 
          localph.KTf = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(124445);
          return 0;
        case 9: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bfu();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bfu)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localph.KWk.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(124445);
          return 0;
        case 10: 
          localph.KWl = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(124445);
          return 0;
        case 11: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dey();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dey)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localph.KWm = ((dey)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(124445);
          return 0;
        case 12: 
          localph.KWn = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(124445);
          return 0;
        case 13: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new qg();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((qg)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localph.KWo = ((qg)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(124445);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new qj();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((qj)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localph.KWp = ((qj)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(124445);
        return 0;
      }
      AppMethodBeat.o(124445);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ph
 * JD-Core Version:    0.7.0.1
 */