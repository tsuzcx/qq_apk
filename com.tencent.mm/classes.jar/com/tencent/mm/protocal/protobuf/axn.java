package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class axn
  extends cqk
{
  public long ELn;
  public String EPo;
  public pp EPp;
  public cu EPq;
  public int EPr;
  public int OpCode;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(114788);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(114788);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ln(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.OpCode);
      paramVarArgs.aO(3, this.ELn);
      if (this.EPq != null)
      {
        paramVarArgs.ln(4, this.EPq.computeSize());
        this.EPq.writeFields(paramVarArgs);
      }
      if (this.EPo != null) {
        paramVarArgs.d(5, this.EPo);
      }
      paramVarArgs.aR(6, this.EPr);
      if (this.EPp != null)
      {
        paramVarArgs.ln(7, this.EPp.computeSize());
        this.EPp.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(114788);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label862;
      }
    }
    label862:
    for (paramInt = f.a.a.a.lm(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bx(2, this.OpCode) + f.a.a.b.b.a.p(3, this.ELn);
      paramInt = i;
      if (this.EPq != null) {
        paramInt = i + f.a.a.a.lm(4, this.EPq.computeSize());
      }
      i = paramInt;
      if (this.EPo != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.EPo);
      }
      i += f.a.a.b.b.a.bx(6, this.EPr);
      paramInt = i;
      if (this.EPp != null) {
        paramInt = i + f.a.a.a.lm(7, this.EPp.computeSize());
      }
      AppMethodBeat.o(114788);
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
          AppMethodBeat.o(114788);
          throw paramVarArgs;
        }
        AppMethodBeat.o(114788);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        axn localaxn = (axn)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(114788);
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
            localaxn.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(114788);
          return 0;
        case 2: 
          localaxn.OpCode = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(114788);
          return 0;
        case 3: 
          localaxn.ELn = ((f.a.a.a.a)localObject1).LVo.xG();
          AppMethodBeat.o(114788);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cu();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cu)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localaxn.EPq = ((cu)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(114788);
          return 0;
        case 5: 
          localaxn.EPo = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(114788);
          return 0;
        case 6: 
          localaxn.EPr = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(114788);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new pp();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((pp)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localaxn.EPp = ((pp)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(114788);
        return 0;
      }
      AppMethodBeat.o(114788);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.axn
 * JD-Core Version:    0.7.0.1
 */