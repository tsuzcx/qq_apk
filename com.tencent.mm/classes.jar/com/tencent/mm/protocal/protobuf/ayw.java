package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class ayw
  extends cqk
{
  public SKBuiltinBuffer_t EQj;
  public int EQo;
  public LinkedList<crm> EQp;
  public int EQq;
  public LinkedList<boy> EQr;
  public String EQs;
  public int EQt;
  public int EQu;
  public boz EQv;
  public String EQw;
  public int EfS;
  public String EfU;
  public String iJV;
  
  public ayw()
  {
    AppMethodBeat.i(32251);
    this.EQp = new LinkedList();
    this.EQr = new LinkedList();
    AppMethodBeat.o(32251);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32252);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(32252);
        throw paramVarArgs;
      }
      if (this.EQj == null)
      {
        paramVarArgs = new b("Not all required fields were included: Buff");
        AppMethodBeat.o(32252);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ln(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.EQj != null)
      {
        paramVarArgs.ln(2, this.EQj.computeSize());
        this.EQj.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(3, this.EQo);
      paramVarArgs.e(4, 8, this.EQp);
      paramVarArgs.aR(5, this.EQq);
      paramVarArgs.e(6, 8, this.EQr);
      paramVarArgs.aR(7, this.EfS);
      if (this.EQs != null) {
        paramVarArgs.d(8, this.EQs);
      }
      if (this.EfU != null) {
        paramVarArgs.d(9, this.EfU);
      }
      paramVarArgs.aR(10, this.EQt);
      if (this.iJV != null) {
        paramVarArgs.d(11, this.iJV);
      }
      paramVarArgs.aR(12, this.EQu);
      if (this.EQv != null)
      {
        paramVarArgs.ln(13, this.EQv.computeSize());
        this.EQv.writeFields(paramVarArgs);
      }
      if (this.EQw != null) {
        paramVarArgs.d(14, this.EQw);
      }
      AppMethodBeat.o(32252);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1490;
      }
    }
    label1490:
    for (paramInt = f.a.a.a.lm(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.EQj != null) {
        i = paramInt + f.a.a.a.lm(2, this.EQj.computeSize());
      }
      i = i + f.a.a.b.b.a.bx(3, this.EQo) + f.a.a.a.c(4, 8, this.EQp) + f.a.a.b.b.a.bx(5, this.EQq) + f.a.a.a.c(6, 8, this.EQr) + f.a.a.b.b.a.bx(7, this.EfS);
      paramInt = i;
      if (this.EQs != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.EQs);
      }
      i = paramInt;
      if (this.EfU != null) {
        i = paramInt + f.a.a.b.b.a.e(9, this.EfU);
      }
      i += f.a.a.b.b.a.bx(10, this.EQt);
      paramInt = i;
      if (this.iJV != null) {
        paramInt = i + f.a.a.b.b.a.e(11, this.iJV);
      }
      i = paramInt + f.a.a.b.b.a.bx(12, this.EQu);
      paramInt = i;
      if (this.EQv != null) {
        paramInt = i + f.a.a.a.lm(13, this.EQv.computeSize());
      }
      i = paramInt;
      if (this.EQw != null) {
        i = paramInt + f.a.a.b.b.a.e(14, this.EQw);
      }
      AppMethodBeat.o(32252);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.EQp.clear();
        this.EQr.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cqk.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cqk.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(32252);
          throw paramVarArgs;
        }
        if (this.EQj == null)
        {
          paramVarArgs = new b("Not all required fields were included: Buff");
          AppMethodBeat.o(32252);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32252);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ayw localayw = (ayw)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32252);
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
            localayw.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32252);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localayw.EQj = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32252);
          return 0;
        case 3: 
          localayw.EQo = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(32252);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new crm();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((crm)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localayw.EQp.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32252);
          return 0;
        case 5: 
          localayw.EQq = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(32252);
          return 0;
        case 6: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new boy();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((boy)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localayw.EQr.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32252);
          return 0;
        case 7: 
          localayw.EfS = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(32252);
          return 0;
        case 8: 
          localayw.EQs = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(32252);
          return 0;
        case 9: 
          localayw.EfU = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(32252);
          return 0;
        case 10: 
          localayw.EQt = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(32252);
          return 0;
        case 11: 
          localayw.iJV = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(32252);
          return 0;
        case 12: 
          localayw.EQu = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(32252);
          return 0;
        case 13: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new boz();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((boz)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localayw.EQv = ((boz)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32252);
          return 0;
        }
        localayw.EQw = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(32252);
        return 0;
      }
      AppMethodBeat.o(32252);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ayw
 * JD-Core Version:    0.7.0.1
 */