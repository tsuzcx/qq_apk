package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dhd
  extends com.tencent.mm.cd.a
{
  public duz Sro;
  public int targetHeight;
  public int targetWidth;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(255074);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Sro != null)
      {
        paramVarArgs.oE(1, this.Sro.computeSize());
        this.Sro.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(2, this.targetWidth);
      paramVarArgs.aY(3, this.targetHeight);
      AppMethodBeat.o(255074);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Sro == null) {
        break label380;
      }
    }
    label380:
    for (paramInt = g.a.a.a.oD(1, this.Sro.computeSize()) + 0;; paramInt = 0)
    {
      int i = g.a.a.b.b.a.bM(2, this.targetWidth);
      int j = g.a.a.b.b.a.bM(3, this.targetHeight);
      AppMethodBeat.o(255074);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(255074);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        dhd localdhd = (dhd)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(255074);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            duz localduz = new duz();
            if ((localObject != null) && (localObject.length > 0)) {
              localduz.parseFrom((byte[])localObject);
            }
            localdhd.Sro = localduz;
            paramInt += 1;
          }
          AppMethodBeat.o(255074);
          return 0;
        case 2: 
          localdhd.targetWidth = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(255074);
          return 0;
        }
        localdhd.targetHeight = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(255074);
        return 0;
      }
      AppMethodBeat.o(255074);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dhd
 * JD-Core Version:    0.7.0.1
 */