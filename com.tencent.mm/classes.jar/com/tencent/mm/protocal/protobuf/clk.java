package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class clk
  extends cqk
{
  public LinkedList<cli> DPz;
  public String Ewu;
  public int OpCode;
  public int fsB;
  
  public clk()
  {
    AppMethodBeat.i(127297);
    this.DPz = new LinkedList();
    AppMethodBeat.o(127297);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(127298);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(127298);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ln(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.Ewu != null) {
        paramVarArgs.d(2, this.Ewu);
      }
      paramVarArgs.aR(3, this.OpCode);
      paramVarArgs.aR(4, this.fsB);
      paramVarArgs.e(5, 8, this.DPz);
      AppMethodBeat.o(127298);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label650;
      }
    }
    label650:
    for (paramInt = f.a.a.a.lm(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Ewu != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.Ewu);
      }
      paramInt = f.a.a.b.b.a.bx(3, this.OpCode);
      int j = f.a.a.b.b.a.bx(4, this.fsB);
      int k = f.a.a.a.c(5, 8, this.DPz);
      AppMethodBeat.o(127298);
      return i + paramInt + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.DPz.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cqk.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cqk.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(127298);
          throw paramVarArgs;
        }
        AppMethodBeat.o(127298);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        clk localclk = (clk)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(127298);
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
            localclk.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(127298);
          return 0;
        case 2: 
          localclk.Ewu = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(127298);
          return 0;
        case 3: 
          localclk.OpCode = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(127298);
          return 0;
        case 4: 
          localclk.fsB = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(127298);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cli();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cli)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localclk.DPz.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(127298);
        return 0;
      }
      AppMethodBeat.o(127298);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.clk
 * JD-Core Version:    0.7.0.1
 */