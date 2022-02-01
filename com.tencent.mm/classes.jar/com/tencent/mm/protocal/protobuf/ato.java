package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.b;
import java.util.LinkedList;

public final class ato
  extends dyl
{
  public String finderUsername;
  public b xHE;
  public aqe yjp;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(168970);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.finderUsername != null) {
        paramVarArgs.f(2, this.finderUsername);
      }
      if (this.xHE != null) {
        paramVarArgs.c(3, this.xHE);
      }
      if (this.yjp != null)
      {
        paramVarArgs.oE(4, this.yjp.computeSize());
        this.yjp.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(168970);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label542;
      }
    }
    label542:
    for (int i = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.finderUsername != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.finderUsername);
      }
      i = paramInt;
      if (this.xHE != null) {
        i = paramInt + g.a.a.b.b.a.b(3, this.xHE);
      }
      paramInt = i;
      if (this.yjp != null) {
        paramInt = i + g.a.a.a.oD(4, this.yjp.computeSize());
      }
      AppMethodBeat.o(168970);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(168970);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        ato localato = (ato)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(168970);
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
            localato.BaseRequest = ((jg)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(168970);
          return 0;
        case 2: 
          localato.finderUsername = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(168970);
          return 0;
        case 3: 
          localato.xHE = ((g.a.a.a.a)localObject1).abFh.iUw();
          AppMethodBeat.o(168970);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new aqe();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((aqe)localObject2).parseFrom((byte[])localObject1);
          }
          localato.yjp = ((aqe)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(168970);
        return 0;
      }
      AppMethodBeat.o(168970);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ato
 * JD-Core Version:    0.7.0.1
 */