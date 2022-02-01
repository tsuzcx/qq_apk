package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class ass
  extends cqk
{
  public int DLE;
  public int DLI;
  public String DLJ;
  public cyw DLK;
  public int DLS;
  public hn str;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32220);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(32220);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ln(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.DLI);
      paramVarArgs.aR(3, this.DLS);
      if (this.DLJ != null) {
        paramVarArgs.d(4, this.DLJ);
      }
      if (this.DLK != null)
      {
        paramVarArgs.ln(5, this.DLK.computeSize());
        this.DLK.writeFields(paramVarArgs);
      }
      if (this.str != null)
      {
        paramVarArgs.ln(6, this.str.computeSize());
        this.str.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(7, this.DLE);
      AppMethodBeat.o(32220);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label875;
      }
    }
    label875:
    for (paramInt = f.a.a.a.lm(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bx(2, this.DLI) + f.a.a.b.b.a.bx(3, this.DLS);
      paramInt = i;
      if (this.DLJ != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.DLJ);
      }
      i = paramInt;
      if (this.DLK != null) {
        i = paramInt + f.a.a.a.lm(5, this.DLK.computeSize());
      }
      paramInt = i;
      if (this.str != null) {
        paramInt = i + f.a.a.a.lm(6, this.str.computeSize());
      }
      i = f.a.a.b.b.a.bx(7, this.DLE);
      AppMethodBeat.o(32220);
      return paramInt + i;
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
          AppMethodBeat.o(32220);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32220);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ass localass = (ass)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32220);
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
            localass.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32220);
          return 0;
        case 2: 
          localass.DLI = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(32220);
          return 0;
        case 3: 
          localass.DLS = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(32220);
          return 0;
        case 4: 
          localass.DLJ = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(32220);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cyw();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cyw)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localass.DLK = ((cyw)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32220);
          return 0;
        case 6: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new hn();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((hn)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localass.str = ((hn)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32220);
          return 0;
        }
        localass.DLE = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(32220);
        return 0;
      }
      AppMethodBeat.o(32220);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ass
 * JD-Core Version:    0.7.0.1
 */