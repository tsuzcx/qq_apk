package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class iu
  extends com.tencent.mm.cd.a
{
  public LinkedList<dvo> ROG;
  public eis ROH;
  public String ROq;
  
  public iu()
  {
    AppMethodBeat.i(91357);
    this.ROG = new LinkedList();
    AppMethodBeat.o(91357);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91358);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.ROq != null) {
        paramVarArgs.f(1, this.ROq);
      }
      paramVarArgs.e(2, 8, this.ROG);
      if (this.ROH != null)
      {
        paramVarArgs.oE(3, this.ROH.computeSize());
        this.ROH.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(91358);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ROq == null) {
        break label466;
      }
    }
    label466:
    for (paramInt = g.a.a.b.b.a.g(1, this.ROq) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.a.c(2, 8, this.ROG);
      paramInt = i;
      if (this.ROH != null) {
        paramInt = i + g.a.a.a.oD(3, this.ROH.computeSize());
      }
      AppMethodBeat.o(91358);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.ROG.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(91358);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        iu localiu = (iu)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91358);
          return -1;
        case 1: 
          localiu.ROq = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(91358);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dvo();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dvo)localObject2).parseFrom((byte[])localObject1);
            }
            localiu.ROG.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91358);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new eis();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((eis)localObject2).parseFrom((byte[])localObject1);
          }
          localiu.ROH = ((eis)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(91358);
        return 0;
      }
      AppMethodBeat.o(91358);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.iu
 * JD-Core Version:    0.7.0.1
 */