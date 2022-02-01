package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class axb
  extends cqk
{
  public LinkedList<eh> DSZ;
  public int EOV;
  public int EOW;
  public LinkedList<Integer> EOX;
  public LinkedList<afe> EOY;
  public int EOZ;
  
  public axb()
  {
    AppMethodBeat.i(122505);
    this.EOX = new LinkedList();
    this.EOY = new LinkedList();
    this.DSZ = new LinkedList();
    AppMethodBeat.o(122505);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(122506);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(122506);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ln(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.EOV);
      paramVarArgs.aR(3, this.EOW);
      paramVarArgs.e(4, 2, this.EOX);
      paramVarArgs.e(5, 8, this.EOY);
      paramVarArgs.aR(6, this.EOZ);
      paramVarArgs.e(7, 8, this.DSZ);
      AppMethodBeat.o(122506);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label845;
      }
    }
    label845:
    for (paramInt = f.a.a.a.lm(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = f.a.a.b.b.a.bx(2, this.EOV);
      int j = f.a.a.b.b.a.bx(3, this.EOW);
      int k = f.a.a.a.c(4, 2, this.EOX);
      int m = f.a.a.a.c(5, 8, this.EOY);
      int n = f.a.a.b.b.a.bx(6, this.EOZ);
      int i1 = f.a.a.a.c(7, 8, this.DSZ);
      AppMethodBeat.o(122506);
      return paramInt + i + j + k + m + n + i1;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.EOX.clear();
        this.EOY.clear();
        this.DSZ.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cqk.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cqk.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(122506);
          throw paramVarArgs;
        }
        AppMethodBeat.o(122506);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        axb localaxb = (axb)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(122506);
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
            localaxb.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(122506);
          return 0;
        case 2: 
          localaxb.EOV = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(122506);
          return 0;
        case 3: 
          localaxb.EOW = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(122506);
          return 0;
        case 4: 
          localaxb.EOX.add(Integer.valueOf(((f.a.a.a.a)localObject1).LVo.xF()));
          AppMethodBeat.o(122506);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new afe();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((afe)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localaxb.EOY.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(122506);
          return 0;
        case 6: 
          localaxb.EOZ = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(122506);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new eh();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((eh)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localaxb.DSZ.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(122506);
        return 0;
      }
      AppMethodBeat.o(122506);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.axb
 * JD-Core Version:    0.7.0.1
 */