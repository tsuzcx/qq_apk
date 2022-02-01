package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.b;
import java.util.LinkedList;

public final class eaz
  extends com.tencent.mm.cd.a
{
  public b UfU;
  public b UfV;
  public b UfW;
  public b UfX;
  public eba UfY;
  public int oDH;
  public int oDI;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(188818);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.oDH);
      if (this.UfU != null) {
        paramVarArgs.c(2, this.UfU);
      }
      if (this.UfV != null) {
        paramVarArgs.c(3, this.UfV);
      }
      if (this.UfW != null) {
        paramVarArgs.c(4, this.UfW);
      }
      if (this.UfX != null) {
        paramVarArgs.c(5, this.UfX);
      }
      if (this.UfY != null)
      {
        paramVarArgs.oE(6, this.UfY.computeSize());
        this.UfY.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(7, this.oDI);
      AppMethodBeat.o(188818);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.bM(1, this.oDH) + 0;
      paramInt = i;
      if (this.UfU != null) {
        paramInt = i + g.a.a.b.b.a.b(2, this.UfU);
      }
      i = paramInt;
      if (this.UfV != null) {
        i = paramInt + g.a.a.b.b.a.b(3, this.UfV);
      }
      paramInt = i;
      if (this.UfW != null) {
        paramInt = i + g.a.a.b.b.a.b(4, this.UfW);
      }
      i = paramInt;
      if (this.UfX != null) {
        i = paramInt + g.a.a.b.b.a.b(5, this.UfX);
      }
      paramInt = i;
      if (this.UfY != null) {
        paramInt = i + g.a.a.a.oD(6, this.UfY.computeSize());
      }
      i = g.a.a.b.b.a.bM(7, this.oDI);
      AppMethodBeat.o(188818);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(188818);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (g.a.a.a.a)paramVarArgs[0];
      eaz localeaz = (eaz)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(188818);
        return -1;
      case 1: 
        localeaz.oDH = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(188818);
        return 0;
      case 2: 
        localeaz.UfU = ((g.a.a.a.a)localObject).abFh.iUw();
        AppMethodBeat.o(188818);
        return 0;
      case 3: 
        localeaz.UfV = ((g.a.a.a.a)localObject).abFh.iUw();
        AppMethodBeat.o(188818);
        return 0;
      case 4: 
        localeaz.UfW = ((g.a.a.a.a)localObject).abFh.iUw();
        AppMethodBeat.o(188818);
        return 0;
      case 5: 
        localeaz.UfX = ((g.a.a.a.a)localObject).abFh.iUw();
        AppMethodBeat.o(188818);
        return 0;
      case 6: 
        paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          eba localeba = new eba();
          if ((localObject != null) && (localObject.length > 0)) {
            localeba.parseFrom((byte[])localObject);
          }
          localeaz.UfY = localeba;
          paramInt += 1;
        }
        AppMethodBeat.o(188818);
        return 0;
      }
      localeaz.oDI = ((g.a.a.a.a)localObject).abFh.AK();
      AppMethodBeat.o(188818);
      return 0;
    }
    AppMethodBeat.o(188818);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eaz
 * JD-Core Version:    0.7.0.1
 */