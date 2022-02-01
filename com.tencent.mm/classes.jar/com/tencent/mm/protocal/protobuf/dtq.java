package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dtq
  extends com.tencent.mm.cd.a
{
  public fmn TZP;
  public fmm TZQ;
  public fmm TZR;
  public int version;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(250416);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.version);
      if (this.TZP != null)
      {
        paramVarArgs.oE(2, this.TZP.computeSize());
        this.TZP.writeFields(paramVarArgs);
      }
      if (this.TZQ != null)
      {
        paramVarArgs.oE(3, this.TZQ.computeSize());
        this.TZQ.writeFields(paramVarArgs);
      }
      if (this.TZR != null)
      {
        paramVarArgs.oE(4, this.TZR.computeSize());
        this.TZR.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(250416);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.bM(1, this.version) + 0;
      paramInt = i;
      if (this.TZP != null) {
        paramInt = i + g.a.a.a.oD(2, this.TZP.computeSize());
      }
      i = paramInt;
      if (this.TZQ != null) {
        i = paramInt + g.a.a.a.oD(3, this.TZQ.computeSize());
      }
      paramInt = i;
      if (this.TZR != null) {
        paramInt = i + g.a.a.a.oD(4, this.TZR.computeSize());
      }
      AppMethodBeat.o(250416);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(250416);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      dtq localdtq = (dtq)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(250416);
        return -1;
      case 1: 
        localdtq.version = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(250416);
        return 0;
      case 2: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new fmn();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((fmn)localObject2).parseFrom((byte[])localObject1);
          }
          localdtq.TZP = ((fmn)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(250416);
        return 0;
      case 3: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new fmm();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((fmm)localObject2).parseFrom((byte[])localObject1);
          }
          localdtq.TZQ = ((fmm)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(250416);
        return 0;
      }
      paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject1 = (byte[])paramVarArgs.get(paramInt);
        localObject2 = new fmm();
        if ((localObject1 != null) && (localObject1.length > 0)) {
          ((fmm)localObject2).parseFrom((byte[])localObject1);
        }
        localdtq.TZR = ((fmm)localObject2);
        paramInt += 1;
      }
      AppMethodBeat.o(250416);
      return 0;
    }
    AppMethodBeat.o(250416);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dtq
 * JD-Core Version:    0.7.0.1
 */