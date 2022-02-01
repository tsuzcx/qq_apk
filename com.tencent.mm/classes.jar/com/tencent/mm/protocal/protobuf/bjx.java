package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public class bjx
  extends cvp
{
  public int Fzq;
  public String GEp;
  public String GEq;
  public LinkedList<String> GEr;
  
  public bjx()
  {
    AppMethodBeat.i(147767);
    this.GEr = new LinkedList();
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
        paramVarArgs.lC(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.GEp != null) {
        paramVarArgs.d(2, this.GEp);
      }
      paramVarArgs.aS(3, this.Fzq);
      if (this.GEq != null) {
        paramVarArgs.d(4, this.GEq);
      }
      paramVarArgs.e(5, 1, this.GEr);
      AppMethodBeat.o(147768);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label582;
      }
    }
    label582:
    for (paramInt = f.a.a.a.lB(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.GEp != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.GEp);
      }
      i += f.a.a.b.b.a.bz(3, this.Fzq);
      paramInt = i;
      if (this.GEq != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.GEq);
      }
      i = f.a.a.a.c(5, 1, this.GEr);
      AppMethodBeat.o(147768);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.GEr.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cvp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
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
        bjx localbjx = (bjx)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(147768);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbjx.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(147768);
          return 0;
        case 2: 
          localbjx.GEp = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(147768);
          return 0;
        case 3: 
          localbjx.Fzq = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(147768);
          return 0;
        case 4: 
          localbjx.GEq = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(147768);
          return 0;
        }
        localbjx.GEr.add(((f.a.a.a.a)localObject1).NPN.readString());
        AppMethodBeat.o(147768);
        return 0;
      }
      AppMethodBeat.o(147768);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bjx
 * JD-Core Version:    0.7.0.1
 */