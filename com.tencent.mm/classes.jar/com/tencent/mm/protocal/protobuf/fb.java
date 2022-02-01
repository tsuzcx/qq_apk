package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class fb
  extends cqk
{
  public LinkedList<fp> DRV;
  public int DRW;
  public String DRX;
  public int DRY;
  public int DRZ;
  public int DSa;
  public en DSb;
  public dqd DSc;
  public String DSd;
  public btb DSe;
  public ey DSf;
  public LinkedList<String> DSg;
  public dq DSh;
  public LinkedList<bro> DSi;
  public String DSj;
  public String hhd;
  public String url;
  
  public fb()
  {
    AppMethodBeat.i(103195);
    this.DRV = new LinkedList();
    this.DSg = new LinkedList();
    this.DSi = new LinkedList();
    AppMethodBeat.o(103195);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(103196);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(103196);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ln(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.DRV);
      paramVarArgs.aR(3, this.DRW);
      if (this.DRX != null) {
        paramVarArgs.d(4, this.DRX);
      }
      paramVarArgs.aR(5, this.DRY);
      paramVarArgs.aR(6, this.DRZ);
      paramVarArgs.aR(7, this.DSa);
      if (this.DSb != null)
      {
        paramVarArgs.ln(8, this.DSb.computeSize());
        this.DSb.writeFields(paramVarArgs);
      }
      if (this.url != null) {
        paramVarArgs.d(9, this.url);
      }
      if (this.hhd != null) {
        paramVarArgs.d(10, this.hhd);
      }
      if (this.DSc != null)
      {
        paramVarArgs.ln(11, this.DSc.computeSize());
        this.DSc.writeFields(paramVarArgs);
      }
      if (this.DSd != null) {
        paramVarArgs.d(12, this.DSd);
      }
      if (this.DSe != null)
      {
        paramVarArgs.ln(13, this.DSe.computeSize());
        this.DSe.writeFields(paramVarArgs);
      }
      if (this.DSf != null)
      {
        paramVarArgs.ln(14, this.DSf.computeSize());
        this.DSf.writeFields(paramVarArgs);
      }
      paramVarArgs.e(15, 1, this.DSg);
      if (this.DSh != null)
      {
        paramVarArgs.ln(16, this.DSh.computeSize());
        this.DSh.writeFields(paramVarArgs);
      }
      paramVarArgs.e(17, 8, this.DSi);
      if (this.DSj != null) {
        paramVarArgs.d(18, this.DSj);
      }
      AppMethodBeat.o(103196);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1962;
      }
    }
    label1962:
    for (paramInt = f.a.a.a.lm(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.a.c(2, 8, this.DRV) + f.a.a.b.b.a.bx(3, this.DRW);
      paramInt = i;
      if (this.DRX != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.DRX);
      }
      i = paramInt + f.a.a.b.b.a.bx(5, this.DRY) + f.a.a.b.b.a.bx(6, this.DRZ) + f.a.a.b.b.a.bx(7, this.DSa);
      paramInt = i;
      if (this.DSb != null) {
        paramInt = i + f.a.a.a.lm(8, this.DSb.computeSize());
      }
      i = paramInt;
      if (this.url != null) {
        i = paramInt + f.a.a.b.b.a.e(9, this.url);
      }
      paramInt = i;
      if (this.hhd != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.hhd);
      }
      i = paramInt;
      if (this.DSc != null) {
        i = paramInt + f.a.a.a.lm(11, this.DSc.computeSize());
      }
      paramInt = i;
      if (this.DSd != null) {
        paramInt = i + f.a.a.b.b.a.e(12, this.DSd);
      }
      i = paramInt;
      if (this.DSe != null) {
        i = paramInt + f.a.a.a.lm(13, this.DSe.computeSize());
      }
      paramInt = i;
      if (this.DSf != null) {
        paramInt = i + f.a.a.a.lm(14, this.DSf.computeSize());
      }
      i = paramInt + f.a.a.a.c(15, 1, this.DSg);
      paramInt = i;
      if (this.DSh != null) {
        paramInt = i + f.a.a.a.lm(16, this.DSh.computeSize());
      }
      i = paramInt + f.a.a.a.c(17, 8, this.DSi);
      paramInt = i;
      if (this.DSj != null) {
        paramInt = i + f.a.a.b.b.a.e(18, this.DSj);
      }
      AppMethodBeat.o(103196);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.DRV.clear();
        this.DSg.clear();
        this.DSi.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cqk.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cqk.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(103196);
          throw paramVarArgs;
        }
        AppMethodBeat.o(103196);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        fb localfb = (fb)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(103196);
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
            localfb.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(103196);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new fp();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((fp)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localfb.DRV.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(103196);
          return 0;
        case 3: 
          localfb.DRW = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(103196);
          return 0;
        case 4: 
          localfb.DRX = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(103196);
          return 0;
        case 5: 
          localfb.DRY = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(103196);
          return 0;
        case 6: 
          localfb.DRZ = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(103196);
          return 0;
        case 7: 
          localfb.DSa = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(103196);
          return 0;
        case 8: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new en();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((en)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localfb.DSb = ((en)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(103196);
          return 0;
        case 9: 
          localfb.url = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(103196);
          return 0;
        case 10: 
          localfb.hhd = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(103196);
          return 0;
        case 11: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dqd();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dqd)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localfb.DSc = ((dqd)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(103196);
          return 0;
        case 12: 
          localfb.DSd = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(103196);
          return 0;
        case 13: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new btb();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((btb)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localfb.DSe = ((btb)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(103196);
          return 0;
        case 14: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ey();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ey)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localfb.DSf = ((ey)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(103196);
          return 0;
        case 15: 
          localfb.DSg.add(((f.a.a.a.a)localObject1).LVo.readString());
          AppMethodBeat.o(103196);
          return 0;
        case 16: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dq();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dq)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localfb.DSh = ((dq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(103196);
          return 0;
        case 17: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bro();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bro)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localfb.DSi.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(103196);
          return 0;
        }
        localfb.DSj = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(103196);
        return 0;
      }
      AppMethodBeat.o(103196);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fb
 * JD-Core Version:    0.7.0.1
 */