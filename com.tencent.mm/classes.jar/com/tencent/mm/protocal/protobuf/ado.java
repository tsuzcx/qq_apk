package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ado
  extends com.tencent.mm.cd.a
{
  public epw SpQ;
  public erh SpR;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91425);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.SpQ != null)
      {
        paramVarArgs.oE(1, this.SpQ.computeSize());
        this.SpQ.writeFields(paramVarArgs);
      }
      if (this.SpR != null)
      {
        paramVarArgs.oE(2, this.SpR.computeSize());
        this.SpR.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(91425);
      return 0;
    }
    if (paramInt == 1) {
      if (this.SpQ == null) {
        break label422;
      }
    }
    label422:
    for (paramInt = g.a.a.a.oD(1, this.SpQ.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.SpR != null) {
        i = paramInt + g.a.a.a.oD(2, this.SpR.computeSize());
      }
      AppMethodBeat.o(91425);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(91425);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        ado localado = (ado)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91425);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new epw();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((epw)localObject2).parseFrom((byte[])localObject1);
            }
            localado.SpQ = ((epw)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91425);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new erh();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((erh)localObject2).parseFrom((byte[])localObject1);
          }
          localado.SpR = ((erh)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(91425);
        return 0;
      }
      AppMethodBeat.o(91425);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ado
 * JD-Core Version:    0.7.0.1
 */