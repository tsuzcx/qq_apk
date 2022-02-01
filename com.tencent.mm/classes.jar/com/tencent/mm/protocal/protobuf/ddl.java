package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class ddl
  extends esc
{
  public LinkedList<hv> aaJc;
  public LinkedList<ehd> aaJd;
  public String appid;
  
  public ddl()
  {
    AppMethodBeat.i(258844);
    this.aaJc = new LinkedList();
    this.aaJd = new LinkedList();
    AppMethodBeat.o(258844);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258847);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(258847);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.appid != null) {
        paramVarArgs.g(2, this.appid);
      }
      paramVarArgs.e(3, 8, this.aaJc);
      paramVarArgs.e(4, 8, this.aaJd);
      AppMethodBeat.o(258847);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label632;
      }
    }
    label632:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.appid != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.appid);
      }
      paramInt = i.a.a.a.c(3, 8, this.aaJc);
      int j = i.a.a.a.c(4, 8, this.aaJd);
      AppMethodBeat.o(258847);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.aaJc.clear();
        this.aaJd.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(258847);
          throw paramVarArgs;
        }
        AppMethodBeat.o(258847);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        ddl localddl = (ddl)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(258847);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new kd();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((kd)localObject2).parseFrom((byte[])localObject1);
            }
            localddl.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(258847);
          return 0;
        case 2: 
          localddl.appid = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(258847);
          return 0;
        case 3: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new hv();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((hv)localObject2).parseFrom((byte[])localObject1);
            }
            localddl.aaJc.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(258847);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new ehd();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((ehd)localObject2).parseFrom((byte[])localObject1);
          }
          localddl.aaJd.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(258847);
        return 0;
      }
      AppMethodBeat.o(258847);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ddl
 * JD-Core Version:    0.7.0.1
 */