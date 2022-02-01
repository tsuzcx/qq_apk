package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.b;
import java.util.LinkedList;

public final class ejc
  extends com.tencent.mm.cd.a
{
  public int Cqs;
  public eaf UkV;
  public eaf UkX;
  public int UkY;
  public int UkZ;
  public LinkedList<Integer> Ula;
  
  public ejc()
  {
    AppMethodBeat.i(260029);
    this.Ula = new LinkedList();
    AppMethodBeat.o(260029);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125764);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.UkV != null)
      {
        paramVarArgs.oE(1, this.UkV.computeSize());
        this.UkV.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(2, this.Cqs);
      if (this.UkX != null)
      {
        paramVarArgs.oE(3, this.UkX.computeSize());
        this.UkX.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(4, this.UkY);
      paramVarArgs.aY(5, this.UkZ);
      paramVarArgs.f(6, 2, this.Ula);
      AppMethodBeat.o(125764);
      return 0;
    }
    if (paramInt == 1) {
      if (this.UkV == null) {
        break label633;
      }
    }
    label633:
    for (paramInt = g.a.a.a.oD(1, this.UkV.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.Cqs);
      paramInt = i;
      if (this.UkX != null) {
        paramInt = i + g.a.a.a.oD(3, this.UkX.computeSize());
      }
      i = g.a.a.b.b.a.bM(4, this.UkY);
      int j = g.a.a.b.b.a.bM(5, this.UkZ);
      int k = g.a.a.a.d(6, 2, this.Ula);
      AppMethodBeat.o(125764);
      return paramInt + i + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Ula.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(125764);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        ejc localejc = (ejc)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        eaf localeaf;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(125764);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            localeaf = new eaf();
            if ((localObject != null) && (localObject.length > 0)) {
              localeaf.de((byte[])localObject);
            }
            localejc.UkV = localeaf;
            paramInt += 1;
          }
          AppMethodBeat.o(125764);
          return 0;
        case 2: 
          localejc.Cqs = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(125764);
          return 0;
        case 3: 
          paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            localeaf = new eaf();
            if ((localObject != null) && (localObject.length > 0)) {
              localeaf.de((byte[])localObject);
            }
            localejc.UkX = localeaf;
            paramInt += 1;
          }
          AppMethodBeat.o(125764);
          return 0;
        case 4: 
          localejc.UkY = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(125764);
          return 0;
        case 5: 
          localejc.UkZ = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(125764);
          return 0;
        }
        localejc.Ula = new g.a.a.a.a(((g.a.a.a.a)localObject).abFh.iUw().UH, unknownTagHandler).abFh.iUu();
        AppMethodBeat.o(125764);
        return 0;
      }
      AppMethodBeat.o(125764);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ejc
 * JD-Core Version:    0.7.0.1
 */