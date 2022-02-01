package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class wg
  extends com.tencent.mm.cd.a
{
  public wf SiH;
  public wf SiI;
  public wf SiJ;
  public wf SiK;
  public wf SiL;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(113984);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.SiH != null)
      {
        paramVarArgs.oE(1, this.SiH.computeSize());
        this.SiH.writeFields(paramVarArgs);
      }
      if (this.SiI != null)
      {
        paramVarArgs.oE(2, this.SiI.computeSize());
        this.SiI.writeFields(paramVarArgs);
      }
      if (this.SiJ != null)
      {
        paramVarArgs.oE(3, this.SiJ.computeSize());
        this.SiJ.writeFields(paramVarArgs);
      }
      if (this.SiK != null)
      {
        paramVarArgs.oE(4, this.SiK.computeSize());
        this.SiK.writeFields(paramVarArgs);
      }
      if (this.SiL != null)
      {
        paramVarArgs.oE(5, this.SiL.computeSize());
        this.SiL.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(113984);
      return 0;
    }
    if (paramInt == 1) {
      if (this.SiH == null) {
        break label816;
      }
    }
    label816:
    for (int i = g.a.a.a.oD(1, this.SiH.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.SiI != null) {
        paramInt = i + g.a.a.a.oD(2, this.SiI.computeSize());
      }
      i = paramInt;
      if (this.SiJ != null) {
        i = paramInt + g.a.a.a.oD(3, this.SiJ.computeSize());
      }
      paramInt = i;
      if (this.SiK != null) {
        paramInt = i + g.a.a.a.oD(4, this.SiK.computeSize());
      }
      i = paramInt;
      if (this.SiL != null) {
        i = paramInt + g.a.a.a.oD(5, this.SiL.computeSize());
      }
      AppMethodBeat.o(113984);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(113984);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        wg localwg = (wg)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        wf localwf;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(113984);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            localwf = new wf();
            if ((localObject != null) && (localObject.length > 0)) {
              localwf.parseFrom((byte[])localObject);
            }
            localwg.SiH = localwf;
            paramInt += 1;
          }
          AppMethodBeat.o(113984);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            localwf = new wf();
            if ((localObject != null) && (localObject.length > 0)) {
              localwf.parseFrom((byte[])localObject);
            }
            localwg.SiI = localwf;
            paramInt += 1;
          }
          AppMethodBeat.o(113984);
          return 0;
        case 3: 
          paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            localwf = new wf();
            if ((localObject != null) && (localObject.length > 0)) {
              localwf.parseFrom((byte[])localObject);
            }
            localwg.SiJ = localwf;
            paramInt += 1;
          }
          AppMethodBeat.o(113984);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            localwf = new wf();
            if ((localObject != null) && (localObject.length > 0)) {
              localwf.parseFrom((byte[])localObject);
            }
            localwg.SiK = localwf;
            paramInt += 1;
          }
          AppMethodBeat.o(113984);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          localwf = new wf();
          if ((localObject != null) && (localObject.length > 0)) {
            localwf.parseFrom((byte[])localObject);
          }
          localwg.SiL = localwf;
          paramInt += 1;
        }
        AppMethodBeat.o(113984);
        return 0;
      }
      AppMethodBeat.o(113984);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.wg
 * JD-Core Version:    0.7.0.1
 */