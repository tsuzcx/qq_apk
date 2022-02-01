package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cpb
  extends dyy
{
  public String Tky;
  public epm TwM;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(212037);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.Tky != null) {
        paramVarArgs.f(2, this.Tky);
      }
      if (this.TwM != null)
      {
        paramVarArgs.oE(3, this.TwM.computeSize());
        this.TwM.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(212037);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label482;
      }
    }
    label482:
    for (int i = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Tky != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.Tky);
      }
      i = paramInt;
      if (this.TwM != null) {
        i = paramInt + g.a.a.a.oD(3, this.TwM.computeSize());
      }
      AppMethodBeat.o(212037);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(212037);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        cpb localcpb = (cpb)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(212037);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new jh();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((jh)localObject2).parseFrom((byte[])localObject1);
            }
            localcpb.BaseResponse = ((jh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(212037);
          return 0;
        case 2: 
          localcpb.Tky = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(212037);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new epm();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((epm)localObject2).parseFrom((byte[])localObject1);
          }
          localcpb.TwM = ((epm)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(212037);
        return 0;
      }
      AppMethodBeat.o(212037);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cpb
 * JD-Core Version:    0.7.0.1
 */