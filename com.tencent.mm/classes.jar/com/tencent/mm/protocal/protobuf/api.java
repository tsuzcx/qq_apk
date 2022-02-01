package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class api
  extends cld
{
  public LinkedList<String> DqR;
  public String DqS;
  public String odt;
  public String title;
  
  public api()
  {
    AppMethodBeat.i(181502);
    this.DqR = new LinkedList();
    AppMethodBeat.o(181502);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(181503);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.kX(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.odt != null) {
        paramVarArgs.d(2, this.odt);
      }
      paramVarArgs.e(3, 1, this.DqR);
      if (this.DqS != null) {
        paramVarArgs.d(4, this.DqS);
      }
      if (this.title != null) {
        paramVarArgs.d(5, this.title);
      }
      AppMethodBeat.o(181503);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label550;
      }
    }
    label550:
    for (paramInt = f.a.a.a.kW(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.odt != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.odt);
      }
      i += f.a.a.a.c(3, 1, this.DqR);
      paramInt = i;
      if (this.DqS != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.DqS);
      }
      i = paramInt;
      if (this.title != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.title);
      }
      AppMethodBeat.o(181503);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.DqR.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cld.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cld.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(181503);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        api localapi = (api)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(181503);
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
            localapi.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(181503);
          return 0;
        case 2: 
          localapi.odt = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(181503);
          return 0;
        case 3: 
          localapi.DqR.add(((f.a.a.a.a)localObject1).KhF.readString());
          AppMethodBeat.o(181503);
          return 0;
        case 4: 
          localapi.DqS = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(181503);
          return 0;
        }
        localapi.title = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(181503);
        return 0;
      }
      AppMethodBeat.o(181503);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.api
 * JD-Core Version:    0.7.0.1
 */