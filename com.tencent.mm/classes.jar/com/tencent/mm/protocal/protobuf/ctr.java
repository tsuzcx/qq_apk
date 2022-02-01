package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ctr
  extends dyl
{
  public ctm TBA;
  public String appid;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(82455);
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
      if (this.TBA != null)
      {
        paramVarArgs.oE(20, this.TBA.computeSize());
        this.TBA.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(82455);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label494;
      }
    }
    label494:
    for (int i = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.appid != null) {
        paramInt = i + g.a.a.b.b.a.g(10, this.appid);
      }
      i = paramInt;
      if (this.TBA != null) {
        i = paramInt + g.a.a.a.oD(20, this.TBA.computeSize());
      }
      AppMethodBeat.o(82455);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(82455);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        ctr localctr = (ctr)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(82455);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new jg();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((jg)localObject2).parseFrom((byte[])localObject1);
            }
            localctr.BaseRequest = ((jg)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(82455);
          return 0;
        case 10: 
          localctr.appid = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(82455);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new ctm();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((ctm)localObject2).parseFrom((byte[])localObject1);
          }
          localctr.TBA = ((ctm)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(82455);
        return 0;
      }
      AppMethodBeat.o(82455);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ctr
 * JD-Core Version:    0.7.0.1
 */