package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class fbr
  extends com.tencent.mm.cd.a
{
  public cvd UBO;
  public int UBP;
  public dhr Ufm;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91725);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Ufm != null)
      {
        paramVarArgs.oE(1, this.Ufm.computeSize());
        this.Ufm.writeFields(paramVarArgs);
      }
      if (this.UBO != null)
      {
        paramVarArgs.oE(2, this.UBO.computeSize());
        this.UBO.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(3, this.UBP);
      AppMethodBeat.o(91725);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Ufm == null) {
        break label466;
      }
    }
    label466:
    for (paramInt = g.a.a.a.oD(1, this.Ufm.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.UBO != null) {
        i = paramInt + g.a.a.a.oD(2, this.UBO.computeSize());
      }
      paramInt = g.a.a.b.b.a.bM(3, this.UBP);
      AppMethodBeat.o(91725);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(91725);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        fbr localfbr = (fbr)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91725);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dhr();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dhr)localObject2).parseFrom((byte[])localObject1);
            }
            localfbr.Ufm = ((dhr)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91725);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new cvd();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((cvd)localObject2).parseFrom((byte[])localObject1);
            }
            localfbr.UBO = ((cvd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91725);
          return 0;
        }
        localfbr.UBP = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(91725);
        return 0;
      }
      AppMethodBeat.o(91725);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fbr
 * JD-Core Version:    0.7.0.1
 */