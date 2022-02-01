package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bbv
  extends com.tencent.mm.cd.a
{
  public int SKS;
  public LinkedList<chj> lpz;
  public aza yYy;
  
  public bbv()
  {
    AppMethodBeat.i(229872);
    this.lpz = new LinkedList();
    AppMethodBeat.o(229872);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(229878);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.yYy != null)
      {
        paramVarArgs.oE(1, this.yYy.computeSize());
        this.yYy.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.lpz);
      paramVarArgs.aY(3, this.SKS);
      AppMethodBeat.o(229878);
      return 0;
    }
    if (paramInt == 1) {
      if (this.yYy == null) {
        break label454;
      }
    }
    label454:
    for (paramInt = g.a.a.a.oD(1, this.yYy.computeSize()) + 0;; paramInt = 0)
    {
      int i = g.a.a.a.c(2, 8, this.lpz);
      int j = g.a.a.b.b.a.bM(3, this.SKS);
      AppMethodBeat.o(229878);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.lpz.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(229878);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        bbv localbbv = (bbv)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(229878);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new aza();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((aza)localObject2).parseFrom((byte[])localObject1);
            }
            localbbv.yYy = ((aza)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(229878);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new chj();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((chj)localObject2).parseFrom((byte[])localObject1);
            }
            localbbv.lpz.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(229878);
          return 0;
        }
        localbbv.SKS = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(229878);
        return 0;
      }
      AppMethodBeat.o(229878);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bbv
 * JD-Core Version:    0.7.0.1
 */