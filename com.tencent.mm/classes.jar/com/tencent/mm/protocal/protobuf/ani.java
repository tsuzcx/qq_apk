package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ani
  extends com.tencent.mm.cd.a
{
  public int SxA;
  public dcf Sxy;
  public int Sxz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(252065);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Sxy != null)
      {
        paramVarArgs.oE(1, this.Sxy.computeSize());
        this.Sxy.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(2, this.Sxz);
      paramVarArgs.aY(3, this.SxA);
      AppMethodBeat.o(252065);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Sxy == null) {
        break label380;
      }
    }
    label380:
    for (paramInt = g.a.a.a.oD(1, this.Sxy.computeSize()) + 0;; paramInt = 0)
    {
      int i = g.a.a.b.b.a.bM(2, this.Sxz);
      int j = g.a.a.b.b.a.bM(3, this.SxA);
      AppMethodBeat.o(252065);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(252065);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        ani localani = (ani)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(252065);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            dcf localdcf = new dcf();
            if ((localObject != null) && (localObject.length > 0)) {
              localdcf.parseFrom((byte[])localObject);
            }
            localani.Sxy = localdcf;
            paramInt += 1;
          }
          AppMethodBeat.o(252065);
          return 0;
        case 2: 
          localani.Sxz = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(252065);
          return 0;
        }
        localani.SxA = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(252065);
        return 0;
      }
      AppMethodBeat.o(252065);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ani
 * JD-Core Version:    0.7.0.1
 */