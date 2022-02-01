package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ctn
  extends dyl
{
  public String TBz;
  public String appid;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(82451);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.appid != null) {
        paramVarArgs.f(10, this.appid);
      }
      if (this.TBz != null) {
        paramVarArgs.f(20, this.TBz);
      }
      AppMethodBeat.o(82451);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label420;
      }
    }
    label420:
    for (int i = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.appid != null) {
        paramInt = i + g.a.a.b.b.a.g(10, this.appid);
      }
      i = paramInt;
      if (this.TBz != null) {
        i = paramInt + g.a.a.b.b.a.g(20, this.TBz);
      }
      AppMethodBeat.o(82451);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(82451);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        ctn localctn = (ctn)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(82451);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            jg localjg = new jg();
            if ((localObject != null) && (localObject.length > 0)) {
              localjg.parseFrom((byte[])localObject);
            }
            localctn.BaseRequest = localjg;
            paramInt += 1;
          }
          AppMethodBeat.o(82451);
          return 0;
        case 10: 
          localctn.appid = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(82451);
          return 0;
        }
        localctn.TBz = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(82451);
        return 0;
      }
      AppMethodBeat.o(82451);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ctn
 * JD-Core Version:    0.7.0.1
 */