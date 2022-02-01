package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ccd
  extends com.tencent.mm.bx.a
{
  public ccf aalA;
  public LinkedList<ccg> aalB;
  public int aalw;
  public int aalx;
  public long aaly;
  public cce aalz;
  
  public ccd()
  {
    AppMethodBeat.i(258048);
    this.aalB = new LinkedList();
    AppMethodBeat.o(258048);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258053);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.aalw);
      paramVarArgs.bS(2, this.aalx);
      paramVarArgs.bv(3, this.aaly);
      if (this.aalz != null)
      {
        paramVarArgs.qD(4, this.aalz.computeSize());
        this.aalz.writeFields(paramVarArgs);
      }
      if (this.aalA != null)
      {
        paramVarArgs.qD(5, this.aalA.computeSize());
        this.aalA.writeFields(paramVarArgs);
      }
      paramVarArgs.e(6, 8, this.aalB);
      AppMethodBeat.o(258053);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.b.b.a.cJ(1, this.aalw) + 0 + i.a.a.b.b.a.cJ(2, this.aalx) + i.a.a.b.b.a.q(3, this.aaly);
      paramInt = i;
      if (this.aalz != null) {
        paramInt = i + i.a.a.a.qC(4, this.aalz.computeSize());
      }
      i = paramInt;
      if (this.aalA != null) {
        i = paramInt + i.a.a.a.qC(5, this.aalA.computeSize());
      }
      paramInt = i.a.a.a.c(6, 8, this.aalB);
      AppMethodBeat.o(258053);
      return i + paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.aalB.clear();
      paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(258053);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
      ccd localccd = (ccd)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(258053);
        return -1;
      case 1: 
        localccd.aalw = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(258053);
        return 0;
      case 2: 
        localccd.aalx = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(258053);
        return 0;
      case 3: 
        localccd.aaly = ((i.a.a.a.a)localObject1).ajGk.aaw();
        AppMethodBeat.o(258053);
        return 0;
      case 4: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new cce();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((cce)localObject2).parseFrom((byte[])localObject1);
          }
          localccd.aalz = ((cce)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(258053);
        return 0;
      case 5: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new ccf();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((ccf)localObject2).parseFrom((byte[])localObject1);
          }
          localccd.aalA = ((ccf)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(258053);
        return 0;
      }
      paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject1 = (byte[])paramVarArgs.get(paramInt);
        localObject2 = new ccg();
        if ((localObject1 != null) && (localObject1.length > 0)) {
          ((ccg)localObject2).parseFrom((byte[])localObject1);
        }
        localccd.aalB.add(localObject2);
        paramInt += 1;
      }
      AppMethodBeat.o(258053);
      return 0;
    }
    AppMethodBeat.o(258053);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ccd
 * JD-Core Version:    0.7.0.1
 */