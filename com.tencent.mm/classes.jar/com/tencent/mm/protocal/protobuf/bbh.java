package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class bbh
  extends cqk
{
  public String DLQ;
  public SKBuiltinBuffer_t EQj;
  public String EQs;
  public int EQt;
  public int ERR;
  public LinkedList<ccb> ERS;
  public String Ebg;
  public int Edp;
  public String EfU;
  public int OpCode;
  public String Url;
  
  public bbh()
  {
    AppMethodBeat.i(56250);
    this.ERS = new LinkedList();
    AppMethodBeat.o(56250);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(56251);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(56251);
        throw paramVarArgs;
      }
      if (this.EQj == null)
      {
        paramVarArgs = new b("Not all required fields were included: Buff");
        AppMethodBeat.o(56251);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ln(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.ERR);
      paramVarArgs.e(3, 8, this.ERS);
      paramVarArgs.aR(4, this.OpCode);
      paramVarArgs.aR(5, this.Edp);
      if (this.EQj != null)
      {
        paramVarArgs.ln(6, this.EQj.computeSize());
        this.EQj.writeFields(paramVarArgs);
      }
      if (this.Url != null) {
        paramVarArgs.d(7, this.Url);
      }
      if (this.EQs != null) {
        paramVarArgs.d(8, this.EQs);
      }
      if (this.Ebg != null) {
        paramVarArgs.d(9, this.Ebg);
      }
      if (this.DLQ != null) {
        paramVarArgs.d(10, this.DLQ);
      }
      paramVarArgs.aR(11, this.EQt);
      if (this.EfU != null) {
        paramVarArgs.d(12, this.EfU);
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
    for (paramInt = f.a.a.a.lm(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bx(2, this.ERR) + f.a.a.a.c(3, 8, this.ERS) + f.a.a.b.b.a.bx(4, this.OpCode) + f.a.a.b.b.a.bx(5, this.Edp);
      paramInt = i;
      if (this.EQj != null) {
        paramInt = i + f.a.a.a.lm(6, this.EQj.computeSize());
      }
      i = paramInt;
      if (this.Url != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.Url);
      }
      paramInt = i;
      if (this.EQs != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.EQs);
      }
      i = paramInt;
      if (this.Ebg != null) {
        i = paramInt + f.a.a.b.b.a.e(9, this.Ebg);
      }
      paramInt = i;
      if (this.DLQ != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.DLQ);
      }
      i = paramInt + f.a.a.b.b.a.bx(11, this.EQt);
      paramInt = i;
      if (this.EfU != null) {
        paramInt = i + f.a.a.b.b.a.e(12, this.EfU);
      }
      AppMethodBeat.o(56251);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.ERS.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cqk.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cqk.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(56251);
          throw paramVarArgs;
        }
        if (this.EQj == null)
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
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bbh localbbh = (bbh)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(56251);
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
            localbbh.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(56251);
          return 0;
        case 2: 
          localbbh.ERR = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(56251);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ccb();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ccb)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbbh.ERS.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(56251);
          return 0;
        case 4: 
          localbbh.OpCode = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(56251);
          return 0;
        case 5: 
          localbbh.Edp = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(56251);
          return 0;
        case 6: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbbh.EQj = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(56251);
          return 0;
        case 7: 
          localbbh.Url = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(56251);
          return 0;
        case 8: 
          localbbh.EQs = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(56251);
          return 0;
        case 9: 
          localbbh.Ebg = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(56251);
          return 0;
        case 10: 
          localbbh.DLQ = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(56251);
          return 0;
        case 11: 
          localbbh.EQt = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(56251);
          return 0;
        }
        localbbh.EfU = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(56251);
        return 0;
      }
      AppMethodBeat.o(56251);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bbh
 * JD-Core Version:    0.7.0.1
 */