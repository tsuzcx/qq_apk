package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public class bwy
  extends dpc
{
  public int KLv;
  public String McH;
  public String McI;
  public LinkedList<String> McJ;
  
  public bwy()
  {
    AppMethodBeat.i(147767);
    this.McJ = new LinkedList();
    AppMethodBeat.o(147767);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(147768);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(147768);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ni(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.McH != null) {
        paramVarArgs.e(2, this.McH);
      }
      paramVarArgs.aM(3, this.KLv);
      if (this.McI != null) {
        paramVarArgs.e(4, this.McI);
      }
      paramVarArgs.e(5, 1, this.McJ);
      AppMethodBeat.o(147768);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label582;
      }
    }
    label582:
    for (paramInt = g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.McH != null) {
        i = paramInt + g.a.a.b.b.a.f(2, this.McH);
      }
      i += g.a.a.b.b.a.bu(3, this.KLv);
      paramInt = i;
      if (this.McI != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.McI);
      }
      i = g.a.a.a.c(5, 1, this.McJ);
      AppMethodBeat.o(147768);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.McJ.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dpc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dpc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
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
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        bwy localbwy = (bwy)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(147768);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localbwy.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(147768);
          return 0;
        case 2: 
          localbwy.McH = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(147768);
          return 0;
        case 3: 
          localbwy.KLv = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(147768);
          return 0;
        case 4: 
          localbwy.McI = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(147768);
          return 0;
        }
        localbwy.McJ.add(((g.a.a.a.a)localObject1).UbS.readString());
        AppMethodBeat.o(147768);
        return 0;
      }
      AppMethodBeat.o(147768);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bwy
 * JD-Core Version:    0.7.0.1
 */