package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class nl
  extends cqk
{
  public int Ebf;
  public int EdA;
  public chl EdB;
  public lp Edt;
  public mg Edu;
  public nd Edv;
  public mi Edw;
  public nd Edx;
  public nu Edy;
  public LinkedList<aqb> Edz;
  
  public nl()
  {
    AppMethodBeat.i(124444);
    this.Edz = new LinkedList();
    AppMethodBeat.o(124444);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124445);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(124445);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ln(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.Edt != null)
      {
        paramVarArgs.ln(2, this.Edt.computeSize());
        this.Edt.writeFields(paramVarArgs);
      }
      if (this.Edu != null)
      {
        paramVarArgs.ln(3, this.Edu.computeSize());
        this.Edu.writeFields(paramVarArgs);
      }
      if (this.Edv != null)
      {
        paramVarArgs.ln(4, this.Edv.computeSize());
        this.Edv.writeFields(paramVarArgs);
      }
      if (this.Edw != null)
      {
        paramVarArgs.ln(5, this.Edw.computeSize());
        this.Edw.writeFields(paramVarArgs);
      }
      if (this.Edx != null)
      {
        paramVarArgs.ln(6, this.Edx.computeSize());
        this.Edx.writeFields(paramVarArgs);
      }
      if (this.Edy != null)
      {
        paramVarArgs.ln(7, this.Edy.computeSize());
        this.Edy.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(8, this.Ebf);
      paramVarArgs.e(9, 8, this.Edz);
      paramVarArgs.aR(10, this.EdA);
      if (this.EdB != null)
      {
        paramVarArgs.ln(11, this.EdB.computeSize());
        this.EdB.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(124445);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1674;
      }
    }
    label1674:
    for (int i = f.a.a.a.lm(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Edt != null) {
        paramInt = i + f.a.a.a.lm(2, this.Edt.computeSize());
      }
      i = paramInt;
      if (this.Edu != null) {
        i = paramInt + f.a.a.a.lm(3, this.Edu.computeSize());
      }
      paramInt = i;
      if (this.Edv != null) {
        paramInt = i + f.a.a.a.lm(4, this.Edv.computeSize());
      }
      i = paramInt;
      if (this.Edw != null) {
        i = paramInt + f.a.a.a.lm(5, this.Edw.computeSize());
      }
      paramInt = i;
      if (this.Edx != null) {
        paramInt = i + f.a.a.a.lm(6, this.Edx.computeSize());
      }
      i = paramInt;
      if (this.Edy != null) {
        i = paramInt + f.a.a.a.lm(7, this.Edy.computeSize());
      }
      i = i + f.a.a.b.b.a.bx(8, this.Ebf) + f.a.a.a.c(9, 8, this.Edz) + f.a.a.b.b.a.bx(10, this.EdA);
      paramInt = i;
      if (this.EdB != null) {
        paramInt = i + f.a.a.a.lm(11, this.EdB.computeSize());
      }
      AppMethodBeat.o(124445);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Edz.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cqk.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cqk.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
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
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        nl localnl = (nl)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(124445);
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
            localnl.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(124445);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new lp();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((lp)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localnl.Edt = ((lp)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(124445);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new mg();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((mg)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localnl.Edu = ((mg)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(124445);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new nd();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((nd)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localnl.Edv = ((nd)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(124445);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new mi();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((mi)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localnl.Edw = ((mi)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(124445);
          return 0;
        case 6: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new nd();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((nd)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localnl.Edx = ((nd)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(124445);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new nu();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((nu)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localnl.Edy = ((nu)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(124445);
          return 0;
        case 8: 
          localnl.Ebf = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(124445);
          return 0;
        case 9: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new aqb();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((aqb)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localnl.Edz.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(124445);
          return 0;
        case 10: 
          localnl.EdA = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(124445);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new chl();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((chl)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localnl.EdB = ((chl)localObject1);
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
 * Qualified Name:     com.tencent.mm.protocal.protobuf.nl
 * JD-Core Version:    0.7.0.1
 */