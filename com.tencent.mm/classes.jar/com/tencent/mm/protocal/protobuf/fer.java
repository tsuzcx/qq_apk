package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class fer
  extends com.tencent.mm.bx.a
{
  public int abEc;
  public fgi abEd;
  public elb abEe;
  public ajd abEf;
  public ego abEg;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125802);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.abEc);
      if (this.abEd != null)
      {
        paramVarArgs.qD(2, this.abEd.computeSize());
        this.abEd.writeFields(paramVarArgs);
      }
      if (this.abEe != null)
      {
        paramVarArgs.qD(3, this.abEe.computeSize());
        this.abEe.writeFields(paramVarArgs);
      }
      if (this.abEf != null)
      {
        paramVarArgs.qD(4, this.abEf.computeSize());
        this.abEf.writeFields(paramVarArgs);
      }
      if (this.abEg != null)
      {
        paramVarArgs.qD(5, this.abEg.computeSize());
        this.abEg.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(125802);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.b.b.a.cJ(1, this.abEc) + 0;
      paramInt = i;
      if (this.abEd != null) {
        paramInt = i + i.a.a.a.qC(2, this.abEd.computeSize());
      }
      i = paramInt;
      if (this.abEe != null) {
        i = paramInt + i.a.a.a.qC(3, this.abEe.computeSize());
      }
      paramInt = i;
      if (this.abEf != null) {
        paramInt = i + i.a.a.a.qC(4, this.abEf.computeSize());
      }
      i = paramInt;
      if (this.abEg != null) {
        i = paramInt + i.a.a.a.qC(5, this.abEg.computeSize());
      }
      AppMethodBeat.o(125802);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(125802);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
      fer localfer = (fer)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(125802);
        return -1;
      case 1: 
        localfer.abEc = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(125802);
        return 0;
      case 2: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new fgi();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((fgi)localObject2).parseFrom((byte[])localObject1);
          }
          localfer.abEd = ((fgi)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(125802);
        return 0;
      case 3: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new elb();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((elb)localObject2).parseFrom((byte[])localObject1);
          }
          localfer.abEe = ((elb)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(125802);
        return 0;
      case 4: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new ajd();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((ajd)localObject2).parseFrom((byte[])localObject1);
          }
          localfer.abEf = ((ajd)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(125802);
        return 0;
      }
      paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject1 = (byte[])paramVarArgs.get(paramInt);
        localObject2 = new ego();
        if ((localObject1 != null) && (localObject1.length > 0)) {
          ((ego)localObject2).parseFrom((byte[])localObject1);
        }
        localfer.abEg = ((ego)localObject2);
        paramInt += 1;
      }
      AppMethodBeat.o(125802);
      return 0;
    }
    AppMethodBeat.o(125802);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fer
 * JD-Core Version:    0.7.0.1
 */