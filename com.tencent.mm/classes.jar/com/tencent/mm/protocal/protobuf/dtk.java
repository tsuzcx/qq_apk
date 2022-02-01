package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dtk
  extends com.tencent.mm.cd.a
{
  public aew TZF;
  public boolean TZG;
  public boolean TZH;
  public boolean TZI;
  public boolean TZJ;
  public boolean TZK;
  public boolean TZL;
  public boolean TZM;
  public boolean TZN;
  public boolean TZO;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91659);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.TZF != null)
      {
        paramVarArgs.oE(1, this.TZF.computeSize());
        this.TZF.writeFields(paramVarArgs);
      }
      paramVarArgs.co(2, this.TZG);
      paramVarArgs.co(3, this.TZH);
      paramVarArgs.co(4, this.TZI);
      paramVarArgs.co(5, this.TZJ);
      paramVarArgs.co(6, this.TZK);
      paramVarArgs.co(7, this.TZL);
      paramVarArgs.co(8, this.TZM);
      paramVarArgs.co(9, this.TZN);
      paramVarArgs.co(10, this.TZO);
      AppMethodBeat.o(91659);
      return 0;
    }
    if (paramInt == 1) {
      if (this.TZF == null) {
        break label692;
      }
    }
    label692:
    for (paramInt = g.a.a.a.oD(1, this.TZF.computeSize()) + 0;; paramInt = 0)
    {
      int i = g.a.a.b.b.a.gL(2);
      int j = g.a.a.b.b.a.gL(3);
      int k = g.a.a.b.b.a.gL(4);
      int m = g.a.a.b.b.a.gL(5);
      int n = g.a.a.b.b.a.gL(6);
      int i1 = g.a.a.b.b.a.gL(7);
      int i2 = g.a.a.b.b.a.gL(8);
      int i3 = g.a.a.b.b.a.gL(9);
      int i4 = g.a.a.b.b.a.gL(10);
      AppMethodBeat.o(91659);
      return paramInt + (i + 1) + (j + 1) + (k + 1) + (m + 1) + (n + 1) + (i1 + 1) + (i2 + 1) + (i3 + 1) + (i4 + 1);
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(91659);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        dtk localdtk = (dtk)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91659);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            aew localaew = new aew();
            if ((localObject != null) && (localObject.length > 0)) {
              localaew.parseFrom((byte[])localObject);
            }
            localdtk.TZF = localaew;
            paramInt += 1;
          }
          AppMethodBeat.o(91659);
          return 0;
        case 2: 
          localdtk.TZG = ((g.a.a.a.a)localObject).abFh.AB();
          AppMethodBeat.o(91659);
          return 0;
        case 3: 
          localdtk.TZH = ((g.a.a.a.a)localObject).abFh.AB();
          AppMethodBeat.o(91659);
          return 0;
        case 4: 
          localdtk.TZI = ((g.a.a.a.a)localObject).abFh.AB();
          AppMethodBeat.o(91659);
          return 0;
        case 5: 
          localdtk.TZJ = ((g.a.a.a.a)localObject).abFh.AB();
          AppMethodBeat.o(91659);
          return 0;
        case 6: 
          localdtk.TZK = ((g.a.a.a.a)localObject).abFh.AB();
          AppMethodBeat.o(91659);
          return 0;
        case 7: 
          localdtk.TZL = ((g.a.a.a.a)localObject).abFh.AB();
          AppMethodBeat.o(91659);
          return 0;
        case 8: 
          localdtk.TZM = ((g.a.a.a.a)localObject).abFh.AB();
          AppMethodBeat.o(91659);
          return 0;
        case 9: 
          localdtk.TZN = ((g.a.a.a.a)localObject).abFh.AB();
          AppMethodBeat.o(91659);
          return 0;
        }
        localdtk.TZO = ((g.a.a.a.a)localObject).abFh.AB();
        AppMethodBeat.o(91659);
        return 0;
      }
      AppMethodBeat.o(91659);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dtk
 * JD-Core Version:    0.7.0.1
 */