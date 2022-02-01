package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dzt
  extends dyl
{
  public String RIi;
  public dzq TcA;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(181508);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.RIi != null) {
        paramVarArgs.f(2, this.RIi);
      }
      if (this.TcA != null)
      {
        paramVarArgs.oE(3, this.TcA.computeSize());
        this.TcA.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(181508);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label482;
      }
    }
    label482:
    for (int i = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.RIi != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.RIi);
      }
      i = paramInt;
      if (this.TcA != null) {
        i = paramInt + g.a.a.a.oD(3, this.TcA.computeSize());
      }
      AppMethodBeat.o(181508);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(181508);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        dzt localdzt = (dzt)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(181508);
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
            localdzt.BaseRequest = ((jg)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(181508);
          return 0;
        case 2: 
          localdzt.RIi = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(181508);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new dzq();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((dzq)localObject2).parseFrom((byte[])localObject1);
          }
          localdzt.TcA = ((dzq)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(181508);
        return 0;
      }
      AppMethodBeat.o(181508);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dzt
 * JD-Core Version:    0.7.0.1
 */