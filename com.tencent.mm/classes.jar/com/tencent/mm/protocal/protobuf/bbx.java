package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public class bbx
  extends cld
{
  public int CBy;
  public String Dzw;
  public String Dzx;
  public LinkedList<String> Dzy;
  
  public bbx()
  {
    AppMethodBeat.i(147767);
    this.Dzy = new LinkedList();
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
        paramVarArgs.kX(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.Dzw != null) {
        paramVarArgs.d(2, this.Dzw);
      }
      paramVarArgs.aR(3, this.CBy);
      if (this.Dzx != null) {
        paramVarArgs.d(4, this.Dzx);
      }
      paramVarArgs.e(5, 1, this.Dzy);
      AppMethodBeat.o(147768);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label582;
      }
    }
    label582:
    for (paramInt = f.a.a.a.kW(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Dzw != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.Dzw);
      }
      i += f.a.a.b.b.a.bA(3, this.CBy);
      paramInt = i;
      if (this.Dzx != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.Dzx);
      }
      i = f.a.a.a.c(5, 1, this.Dzy);
      AppMethodBeat.o(147768);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Dzy.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cld.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cld.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
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
        bbx localbbx = (bbx)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(147768);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbbx.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(147768);
          return 0;
        case 2: 
          localbbx.Dzw = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(147768);
          return 0;
        case 3: 
          localbbx.CBy = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(147768);
          return 0;
        case 4: 
          localbbx.Dzx = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(147768);
          return 0;
        }
        localbbx.Dzy.add(((f.a.a.a.a)localObject1).KhF.readString());
        AppMethodBeat.o(147768);
        return 0;
      }
      AppMethodBeat.o(147768);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bbx
 * JD-Core Version:    0.7.0.1
 */