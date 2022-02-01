package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class eqi
  extends com.tencent.mm.cd.a
{
  public LinkedList<cmp> TjT;
  public dbu UsO;
  public LinkedList<erh> UsP;
  
  public eqi()
  {
    AppMethodBeat.i(91709);
    this.TjT = new LinkedList();
    this.UsP = new LinkedList();
    AppMethodBeat.o(91709);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91710);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.UsO != null)
      {
        paramVarArgs.oE(1, this.UsO.computeSize());
        this.UsO.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.TjT);
      paramVarArgs.e(3, 8, this.UsP);
      AppMethodBeat.o(91710);
      return 0;
    }
    if (paramInt == 1) {
      if (this.UsO == null) {
        break label528;
      }
    }
    label528:
    for (paramInt = g.a.a.a.oD(1, this.UsO.computeSize()) + 0;; paramInt = 0)
    {
      int i = g.a.a.a.c(2, 8, this.TjT);
      int j = g.a.a.a.c(3, 8, this.UsP);
      AppMethodBeat.o(91710);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.TjT.clear();
        this.UsP.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(91710);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        eqi localeqi = (eqi)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91710);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dbu();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dbu)localObject2).parseFrom((byte[])localObject1);
            }
            localeqi.UsO = ((dbu)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91710);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new cmp();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((cmp)localObject2).parseFrom((byte[])localObject1);
            }
            localeqi.TjT.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91710);
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
          localeqi.UsP.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(91710);
        return 0;
      }
      AppMethodBeat.o(91710);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eqi
 * JD-Core Version:    0.7.0.1
 */