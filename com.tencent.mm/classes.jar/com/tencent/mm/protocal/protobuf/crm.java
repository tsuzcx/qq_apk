package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class crm
  extends com.tencent.mm.cd.a
{
  public cxh SEm;
  public bnp TyA;
  public long Tyy;
  public long Tyz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(194249);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bm(1, this.Tyy);
      paramVarArgs.bm(2, this.Tyz);
      if (this.TyA != null)
      {
        paramVarArgs.oE(3, this.TyA.computeSize());
        this.TyA.writeFields(paramVarArgs);
      }
      if (this.SEm != null)
      {
        paramVarArgs.oE(4, this.SEm.computeSize());
        this.SEm.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(194249);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.p(1, this.Tyy) + 0 + g.a.a.b.b.a.p(2, this.Tyz);
      paramInt = i;
      if (this.TyA != null) {
        paramInt = i + g.a.a.a.oD(3, this.TyA.computeSize());
      }
      i = paramInt;
      if (this.SEm != null) {
        i = paramInt + g.a.a.a.oD(4, this.SEm.computeSize());
      }
      AppMethodBeat.o(194249);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(194249);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      crm localcrm = (crm)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(194249);
        return -1;
      case 1: 
        localcrm.Tyy = ((g.a.a.a.a)localObject1).abFh.AN();
        AppMethodBeat.o(194249);
        return 0;
      case 2: 
        localcrm.Tyz = ((g.a.a.a.a)localObject1).abFh.AN();
        AppMethodBeat.o(194249);
        return 0;
      case 3: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new bnp();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((bnp)localObject2).parseFrom((byte[])localObject1);
          }
          localcrm.TyA = ((bnp)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(194249);
        return 0;
      }
      paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject1 = (byte[])paramVarArgs.get(paramInt);
        localObject2 = new cxh();
        if ((localObject1 != null) && (localObject1.length > 0)) {
          ((cxh)localObject2).parseFrom((byte[])localObject1);
        }
        localcrm.SEm = ((cxh)localObject2);
        paramInt += 1;
      }
      AppMethodBeat.o(194249);
      return 0;
    }
    AppMethodBeat.o(194249);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.crm
 * JD-Core Version:    0.7.0.1
 */