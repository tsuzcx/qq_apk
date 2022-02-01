package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class eww
  extends dyl
{
  public int Uxx;
  public aku Uxy;
  public String username;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153311);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.username != null) {
        paramVarArgs.f(2, this.username);
      }
      paramVarArgs.aY(3, this.Uxx);
      if (this.Uxy != null)
      {
        paramVarArgs.oE(4, this.Uxy.computeSize());
        this.Uxy.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(153311);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label526;
      }
    }
    label526:
    for (paramInt = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.username != null) {
        i = paramInt + g.a.a.b.b.a.g(2, this.username);
      }
      i += g.a.a.b.b.a.bM(3, this.Uxx);
      paramInt = i;
      if (this.Uxy != null) {
        paramInt = i + g.a.a.a.oD(4, this.Uxy.computeSize());
      }
      AppMethodBeat.o(153311);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(153311);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        eww localeww = (eww)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(153311);
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
            localeww.BaseRequest = ((jg)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(153311);
          return 0;
        case 2: 
          localeww.username = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(153311);
          return 0;
        case 3: 
          localeww.Uxx = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(153311);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new aku();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((aku)localObject2).parseFrom((byte[])localObject1);
          }
          localeww.Uxy = ((aku)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(153311);
        return 0;
      }
      AppMethodBeat.o(153311);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eww
 * JD-Core Version:    0.7.0.1
 */