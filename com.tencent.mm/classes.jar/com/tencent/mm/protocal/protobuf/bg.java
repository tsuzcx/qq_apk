package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bg
  extends com.tencent.mm.cd.a
{
  public erh RGf;
  public erh RGg;
  public eaa RGh;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91342);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.RGf != null)
      {
        paramVarArgs.oE(1, this.RGf.computeSize());
        this.RGf.writeFields(paramVarArgs);
      }
      if (this.RGg != null)
      {
        paramVarArgs.oE(2, this.RGg.computeSize());
        this.RGg.writeFields(paramVarArgs);
      }
      if (this.RGh != null)
      {
        paramVarArgs.oE(3, this.RGh.computeSize());
        this.RGh.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(91342);
      return 0;
    }
    if (paramInt == 1) {
      if (this.RGf == null) {
        break label552;
      }
    }
    label552:
    for (int i = g.a.a.a.oD(1, this.RGf.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.RGg != null) {
        paramInt = i + g.a.a.a.oD(2, this.RGg.computeSize());
      }
      i = paramInt;
      if (this.RGh != null) {
        i = paramInt + g.a.a.a.oD(3, this.RGh.computeSize());
      }
      AppMethodBeat.o(91342);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(91342);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        bg localbg = (bg)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91342);
          return -1;
        case 1: 
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
            localbg.RGf = ((erh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91342);
          return 0;
        case 2: 
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
            localbg.RGg = ((erh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91342);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new eaa();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((eaa)localObject2).parseFrom((byte[])localObject1);
          }
          localbg.RGh = ((eaa)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(91342);
        return 0;
      }
      AppMethodBeat.o(91342);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bg
 * JD-Core Version:    0.7.0.1
 */