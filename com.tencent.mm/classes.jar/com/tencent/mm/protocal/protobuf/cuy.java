package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cuy
  extends dyl
{
  public int Olc;
  public String RIU;
  public int type;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91535);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(2, this.type);
      paramVarArgs.aY(3, this.Olc);
      if (this.RIU != null) {
        paramVarArgs.f(4, this.RIU);
      }
      AppMethodBeat.o(91535);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label436;
      }
    }
    label436:
    for (paramInt = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.type) + g.a.a.b.b.a.bM(3, this.Olc);
      paramInt = i;
      if (this.RIU != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.RIU);
      }
      AppMethodBeat.o(91535);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(91535);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        cuy localcuy = (cuy)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91535);
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
            localcuy.BaseRequest = localjg;
            paramInt += 1;
          }
          AppMethodBeat.o(91535);
          return 0;
        case 2: 
          localcuy.type = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(91535);
          return 0;
        case 3: 
          localcuy.Olc = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(91535);
          return 0;
        }
        localcuy.RIU = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(91535);
        return 0;
      }
      AppMethodBeat.o(91535);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cuy
 * JD-Core Version:    0.7.0.1
 */