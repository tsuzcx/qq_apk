package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class bcj
  extends cqk
{
  public cvn ESs;
  public eaq ESt;
  public ebi ESu;
  public aig ESv;
  public eas ESw;
  public ebr ESx;
  public ebt ESy;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153276);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(153276);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ln(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.ESs != null)
      {
        paramVarArgs.ln(2, this.ESs.computeSize());
        this.ESs.writeFields(paramVarArgs);
      }
      if (this.ESt != null)
      {
        paramVarArgs.ln(3, this.ESt.computeSize());
        this.ESt.writeFields(paramVarArgs);
      }
      if (this.ESu != null)
      {
        paramVarArgs.ln(4, this.ESu.computeSize());
        this.ESu.writeFields(paramVarArgs);
      }
      if (this.ESv != null)
      {
        paramVarArgs.ln(5, this.ESv.computeSize());
        this.ESv.writeFields(paramVarArgs);
      }
      if (this.ESw != null)
      {
        paramVarArgs.ln(6, this.ESw.computeSize());
        this.ESw.writeFields(paramVarArgs);
      }
      if (this.ESx != null)
      {
        paramVarArgs.ln(7, this.ESx.computeSize());
        this.ESx.writeFields(paramVarArgs);
      }
      if (this.ESy != null)
      {
        paramVarArgs.ln(8, this.ESy.computeSize());
        this.ESy.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(153276);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1442;
      }
    }
    label1442:
    for (int i = f.a.a.a.lm(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.ESs != null) {
        paramInt = i + f.a.a.a.lm(2, this.ESs.computeSize());
      }
      i = paramInt;
      if (this.ESt != null) {
        i = paramInt + f.a.a.a.lm(3, this.ESt.computeSize());
      }
      paramInt = i;
      if (this.ESu != null) {
        paramInt = i + f.a.a.a.lm(4, this.ESu.computeSize());
      }
      i = paramInt;
      if (this.ESv != null) {
        i = paramInt + f.a.a.a.lm(5, this.ESv.computeSize());
      }
      paramInt = i;
      if (this.ESw != null) {
        paramInt = i + f.a.a.a.lm(6, this.ESw.computeSize());
      }
      i = paramInt;
      if (this.ESx != null) {
        i = paramInt + f.a.a.a.lm(7, this.ESx.computeSize());
      }
      paramInt = i;
      if (this.ESy != null) {
        paramInt = i + f.a.a.a.lm(8, this.ESy.computeSize());
      }
      AppMethodBeat.o(153276);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cqk.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cqk.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(153276);
          throw paramVarArgs;
        }
        AppMethodBeat.o(153276);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bcj localbcj = (bcj)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(153276);
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
            localbcj.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(153276);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cvn();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cvn)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbcj.ESs = ((cvn)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(153276);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new eaq();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((eaq)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbcj.ESt = ((eaq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(153276);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ebi();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ebi)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbcj.ESu = ((ebi)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(153276);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new aig();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((aig)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbcj.ESv = ((aig)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(153276);
          return 0;
        case 6: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new eas();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((eas)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbcj.ESw = ((eas)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(153276);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ebr();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ebr)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbcj.ESx = ((ebr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(153276);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ebt();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((ebt)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbcj.ESy = ((ebt)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(153276);
        return 0;
      }
      AppMethodBeat.o(153276);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bcj
 * JD-Core Version:    0.7.0.1
 */