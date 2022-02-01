package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public class bfp
  extends cqk
{
  public int DTW;
  public String EUS;
  public String EUT;
  public LinkedList<String> EUU;
  
  public bfp()
  {
    AppMethodBeat.i(147767);
    this.EUU = new LinkedList();
    AppMethodBeat.o(147767);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(147768);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(147768);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ln(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.EUS != null) {
        paramVarArgs.d(2, this.EUS);
      }
      paramVarArgs.aR(3, this.DTW);
      if (this.EUT != null) {
        paramVarArgs.d(4, this.EUT);
      }
      paramVarArgs.e(5, 1, this.EUU);
      AppMethodBeat.o(147768);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label582;
      }
    }
    label582:
    for (paramInt = f.a.a.a.lm(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.EUS != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.EUS);
      }
      i += f.a.a.b.b.a.bx(3, this.DTW);
      paramInt = i;
      if (this.EUT != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.EUT);
      }
      i = f.a.a.a.c(5, 1, this.EUU);
      AppMethodBeat.o(147768);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.EUU.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cqk.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cqk.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(147768);
          throw paramVarArgs;
        }
        AppMethodBeat.o(147768);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bfp localbfp = (bfp)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(147768);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbfp.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(147768);
          return 0;
        case 2: 
          localbfp.EUS = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(147768);
          return 0;
        case 3: 
          localbfp.DTW = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(147768);
          return 0;
        case 4: 
          localbfp.EUT = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(147768);
          return 0;
        }
        localbfp.EUU.add(((f.a.a.a.a)localObject1).LVo.readString());
        AppMethodBeat.o(147768);
        return 0;
      }
      AppMethodBeat.o(147768);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bfp
 * JD-Core Version:    0.7.0.1
 */