package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class fbl
  extends com.tencent.mm.cd.a
{
  public adv UBo;
  public boolean UBp = true;
  public faz UBq;
  public String UBr;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117943);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.UBo != null)
      {
        paramVarArgs.oE(1, this.UBo.computeSize());
        this.UBo.writeFields(paramVarArgs);
      }
      paramVarArgs.co(2, this.UBp);
      if (this.UBq != null)
      {
        paramVarArgs.oE(3, this.UBq.computeSize());
        this.UBq.writeFields(paramVarArgs);
      }
      if (this.UBr != null) {
        paramVarArgs.f(4, this.UBr);
      }
      AppMethodBeat.o(117943);
      return 0;
    }
    if (paramInt == 1) {
      if (this.UBo == null) {
        break label522;
      }
    }
    label522:
    for (paramInt = g.a.a.a.oD(1, this.UBo.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + (g.a.a.b.b.a.gL(2) + 1);
      paramInt = i;
      if (this.UBq != null) {
        paramInt = i + g.a.a.a.oD(3, this.UBq.computeSize());
      }
      i = paramInt;
      if (this.UBr != null) {
        i = paramInt + g.a.a.b.b.a.g(4, this.UBr);
      }
      AppMethodBeat.o(117943);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(117943);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        fbl localfbl = (fbl)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(117943);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new adv();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((adv)localObject2).parseFrom((byte[])localObject1);
            }
            localfbl.UBo = ((adv)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(117943);
          return 0;
        case 2: 
          localfbl.UBp = ((g.a.a.a.a)localObject1).abFh.AB();
          AppMethodBeat.o(117943);
          return 0;
        case 3: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new faz();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((faz)localObject2).parseFrom((byte[])localObject1);
            }
            localfbl.UBq = ((faz)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(117943);
          return 0;
        }
        localfbl.UBr = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(117943);
        return 0;
      }
      AppMethodBeat.o(117943);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fbl
 * JD-Core Version:    0.7.0.1
 */