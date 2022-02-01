package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ub
  extends com.tencent.mm.cd.a
{
  public String SdV;
  public String SdW;
  public String SdX;
  public int SdY;
  public up SdZ;
  public int Sea;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(113950);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.SdV != null) {
        paramVarArgs.f(1, this.SdV);
      }
      if (this.SdW != null) {
        paramVarArgs.f(2, this.SdW);
      }
      if (this.SdX != null) {
        paramVarArgs.f(3, this.SdX);
      }
      paramVarArgs.aY(4, this.SdY);
      if (this.SdZ != null)
      {
        paramVarArgs.oE(5, this.SdZ.computeSize());
        this.SdZ.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(6, this.Sea);
      AppMethodBeat.o(113950);
      return 0;
    }
    if (paramInt == 1) {
      if (this.SdV == null) {
        break label560;
      }
    }
    label560:
    for (int i = g.a.a.b.b.a.g(1, this.SdV) + 0;; i = 0)
    {
      paramInt = i;
      if (this.SdW != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.SdW);
      }
      i = paramInt;
      if (this.SdX != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.SdX);
      }
      i += g.a.a.b.b.a.bM(4, this.SdY);
      paramInt = i;
      if (this.SdZ != null) {
        paramInt = i + g.a.a.a.oD(5, this.SdZ.computeSize());
      }
      i = g.a.a.b.b.a.bM(6, this.Sea);
      AppMethodBeat.o(113950);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(113950);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        ub localub = (ub)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(113950);
          return -1;
        case 1: 
          localub.SdV = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(113950);
          return 0;
        case 2: 
          localub.SdW = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(113950);
          return 0;
        case 3: 
          localub.SdX = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(113950);
          return 0;
        case 4: 
          localub.SdY = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(113950);
          return 0;
        case 5: 
          paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            up localup = new up();
            if ((localObject != null) && (localObject.length > 0)) {
              localup.parseFrom((byte[])localObject);
            }
            localub.SdZ = localup;
            paramInt += 1;
          }
          AppMethodBeat.o(113950);
          return 0;
        }
        localub.Sea = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(113950);
        return 0;
      }
      AppMethodBeat.o(113950);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ub
 * JD-Core Version:    0.7.0.1
 */