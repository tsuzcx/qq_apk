package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class aoe
  extends cqk
{
  public int EHg;
  public int EHh;
  public int EHi;
  public ajf EHj;
  public int EHk;
  public LinkedList<FinderObject> EHl;
  public aoq EHm;
  public aiw EHn;
  public String EHo;
  public aoc EHp;
  public com.tencent.mm.bw.b lastBuffer;
  public LinkedList<FinderObject> object;
  public anu qYj;
  public String rmp;
  public String rmq;
  public int rmr;
  public anb rmt;
  
  public aoe()
  {
    AppMethodBeat.i(169057);
    this.object = new LinkedList();
    this.EHl = new LinkedList();
    AppMethodBeat.o(169057);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(169058);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(169058);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ln(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.object);
      if (this.lastBuffer != null) {
        paramVarArgs.c(3, this.lastBuffer);
      }
      if (this.rmp != null) {
        paramVarArgs.d(4, this.rmp);
      }
      if (this.rmq != null) {
        paramVarArgs.d(5, this.rmq);
      }
      paramVarArgs.aR(6, this.rmr);
      paramVarArgs.aR(7, this.EHg);
      paramVarArgs.aR(8, this.EHh);
      paramVarArgs.aR(9, this.EHi);
      if (this.rmt != null)
      {
        paramVarArgs.ln(10, this.rmt.computeSize());
        this.rmt.writeFields(paramVarArgs);
      }
      if (this.EHj != null)
      {
        paramVarArgs.ln(11, this.EHj.computeSize());
        this.EHj.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(12, this.EHk);
      paramVarArgs.e(13, 8, this.EHl);
      if (this.EHm != null)
      {
        paramVarArgs.ln(14, this.EHm.computeSize());
        this.EHm.writeFields(paramVarArgs);
      }
      if (this.EHn != null)
      {
        paramVarArgs.ln(15, this.EHn.computeSize());
        this.EHn.writeFields(paramVarArgs);
      }
      if (this.EHo != null) {
        paramVarArgs.d(16, this.EHo);
      }
      if (this.qYj != null)
      {
        paramVarArgs.ln(17, this.qYj.computeSize());
        this.qYj.writeFields(paramVarArgs);
      }
      if (this.EHp != null)
      {
        paramVarArgs.ln(18, this.EHp.computeSize());
        this.EHp.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(169058);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label2042;
      }
    }
    label2042:
    for (paramInt = f.a.a.a.lm(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.a.c(2, 8, this.object);
      paramInt = i;
      if (this.lastBuffer != null) {
        paramInt = i + f.a.a.b.b.a.b(3, this.lastBuffer);
      }
      i = paramInt;
      if (this.rmp != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.rmp);
      }
      paramInt = i;
      if (this.rmq != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.rmq);
      }
      i = paramInt + f.a.a.b.b.a.bx(6, this.rmr) + f.a.a.b.b.a.bx(7, this.EHg) + f.a.a.b.b.a.bx(8, this.EHh) + f.a.a.b.b.a.bx(9, this.EHi);
      paramInt = i;
      if (this.rmt != null) {
        paramInt = i + f.a.a.a.lm(10, this.rmt.computeSize());
      }
      i = paramInt;
      if (this.EHj != null) {
        i = paramInt + f.a.a.a.lm(11, this.EHj.computeSize());
      }
      i = i + f.a.a.b.b.a.bx(12, this.EHk) + f.a.a.a.c(13, 8, this.EHl);
      paramInt = i;
      if (this.EHm != null) {
        paramInt = i + f.a.a.a.lm(14, this.EHm.computeSize());
      }
      i = paramInt;
      if (this.EHn != null) {
        i = paramInt + f.a.a.a.lm(15, this.EHn.computeSize());
      }
      paramInt = i;
      if (this.EHo != null) {
        paramInt = i + f.a.a.b.b.a.e(16, this.EHo);
      }
      i = paramInt;
      if (this.qYj != null) {
        i = paramInt + f.a.a.a.lm(17, this.qYj.computeSize());
      }
      paramInt = i;
      if (this.EHp != null) {
        paramInt = i + f.a.a.a.lm(18, this.EHp.computeSize());
      }
      AppMethodBeat.o(169058);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.object.clear();
        this.EHl.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cqk.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cqk.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new f.a.a.b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(169058);
          throw paramVarArgs;
        }
        AppMethodBeat.o(169058);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        aoe localaoe = (aoe)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(169058);
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
            localaoe.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169058);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new FinderObject();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((FinderObject)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localaoe.object.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169058);
          return 0;
        case 3: 
          localaoe.lastBuffer = ((f.a.a.a.a)localObject1).LVo.gfk();
          AppMethodBeat.o(169058);
          return 0;
        case 4: 
          localaoe.rmp = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(169058);
          return 0;
        case 5: 
          localaoe.rmq = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(169058);
          return 0;
        case 6: 
          localaoe.rmr = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(169058);
          return 0;
        case 7: 
          localaoe.EHg = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(169058);
          return 0;
        case 8: 
          localaoe.EHh = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(169058);
          return 0;
        case 9: 
          localaoe.EHi = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(169058);
          return 0;
        case 10: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new anb();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((anb)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localaoe.rmt = ((anb)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169058);
          return 0;
        case 11: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ajf();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ajf)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localaoe.EHj = ((ajf)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169058);
          return 0;
        case 12: 
          localaoe.EHk = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(169058);
          return 0;
        case 13: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new FinderObject();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((FinderObject)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localaoe.EHl.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169058);
          return 0;
        case 14: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new aoq();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((aoq)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localaoe.EHm = ((aoq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169058);
          return 0;
        case 15: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new aiw();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((aiw)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localaoe.EHn = ((aiw)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169058);
          return 0;
        case 16: 
          localaoe.EHo = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(169058);
          return 0;
        case 17: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new anu();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((anu)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localaoe.qYj = ((anu)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169058);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new aoc();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((aoc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localaoe.EHp = ((aoc)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(169058);
        return 0;
      }
      AppMethodBeat.o(169058);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aoe
 * JD-Core Version:    0.7.0.1
 */