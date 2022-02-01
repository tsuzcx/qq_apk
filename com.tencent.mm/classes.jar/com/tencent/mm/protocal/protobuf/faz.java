package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class faz
  extends com.tencent.mm.cd.a
{
  public int UAQ;
  public vi UAR;
  public vi UAS;
  public int UAT;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117940);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.UAQ);
      if (this.UAR != null)
      {
        paramVarArgs.oE(4, this.UAR.computeSize());
        this.UAR.writeFields(paramVarArgs);
      }
      if (this.UAS != null)
      {
        paramVarArgs.oE(5, this.UAS.computeSize());
        this.UAS.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(6, this.UAT);
      AppMethodBeat.o(117940);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.bM(1, this.UAQ) + 0;
      paramInt = i;
      if (this.UAR != null) {
        paramInt = i + g.a.a.a.oD(4, this.UAR.computeSize());
      }
      i = paramInt;
      if (this.UAS != null) {
        i = paramInt + g.a.a.a.oD(5, this.UAS.computeSize());
      }
      paramInt = g.a.a.b.b.a.bM(6, this.UAT);
      AppMethodBeat.o(117940);
      return i + paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(117940);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (g.a.a.a.a)paramVarArgs[0];
      faz localfaz = (faz)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      vi localvi;
      switch (paramInt)
      {
      case 2: 
      case 3: 
      default: 
        AppMethodBeat.o(117940);
        return -1;
      case 1: 
        localfaz.UAQ = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(117940);
        return 0;
      case 4: 
        paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          localvi = new vi();
          if ((localObject != null) && (localObject.length > 0)) {
            localvi.parseFrom((byte[])localObject);
          }
          localfaz.UAR = localvi;
          paramInt += 1;
        }
        AppMethodBeat.o(117940);
        return 0;
      case 5: 
        paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          localvi = new vi();
          if ((localObject != null) && (localObject.length > 0)) {
            localvi.parseFrom((byte[])localObject);
          }
          localfaz.UAS = localvi;
          paramInt += 1;
        }
        AppMethodBeat.o(117940);
        return 0;
      }
      localfaz.UAT = ((g.a.a.a.a)localObject).abFh.AK();
      AppMethodBeat.o(117940);
      return 0;
    }
    AppMethodBeat.o(117940);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.faz
 * JD-Core Version:    0.7.0.1
 */