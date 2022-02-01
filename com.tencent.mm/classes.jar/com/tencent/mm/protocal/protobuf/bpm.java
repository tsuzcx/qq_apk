package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bpm
  extends com.tencent.mm.bx.a
{
  public FinderObject ABJ;
  public bqs FKR;
  public bsg ZIs;
  public bpn ZXV;
  public int dataType;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(257995);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.dataType);
      if (this.ZXV != null)
      {
        paramVarArgs.qD(2, this.ZXV.computeSize());
        this.ZXV.writeFields(paramVarArgs);
      }
      if (this.FKR != null)
      {
        paramVarArgs.qD(3, this.FKR.computeSize());
        this.FKR.writeFields(paramVarArgs);
      }
      if (this.ABJ != null)
      {
        paramVarArgs.qD(4, this.ABJ.computeSize());
        this.ABJ.writeFields(paramVarArgs);
      }
      if (this.ZIs != null)
      {
        paramVarArgs.qD(5, this.ZIs.computeSize());
        this.ZIs.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(257995);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.b.b.a.cJ(1, this.dataType) + 0;
      paramInt = i;
      if (this.ZXV != null) {
        paramInt = i + i.a.a.a.qC(2, this.ZXV.computeSize());
      }
      i = paramInt;
      if (this.FKR != null) {
        i = paramInt + i.a.a.a.qC(3, this.FKR.computeSize());
      }
      paramInt = i;
      if (this.ABJ != null) {
        paramInt = i + i.a.a.a.qC(4, this.ABJ.computeSize());
      }
      i = paramInt;
      if (this.ZIs != null) {
        i = paramInt + i.a.a.a.qC(5, this.ZIs.computeSize());
      }
      AppMethodBeat.o(257995);
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
      AppMethodBeat.o(257995);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
      bpm localbpm = (bpm)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(257995);
        return -1;
      case 1: 
        localbpm.dataType = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(257995);
        return 0;
      case 2: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new bpn();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((bpn)localObject2).parseFrom((byte[])localObject1);
          }
          localbpm.ZXV = ((bpn)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(257995);
        return 0;
      case 3: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new bqs();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((bqs)localObject2).parseFrom((byte[])localObject1);
          }
          localbpm.FKR = ((bqs)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(257995);
        return 0;
      case 4: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new FinderObject();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((FinderObject)localObject2).parseFrom((byte[])localObject1);
          }
          localbpm.ABJ = ((FinderObject)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(257995);
        return 0;
      }
      paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject1 = (byte[])paramVarArgs.get(paramInt);
        localObject2 = new bsg();
        if ((localObject1 != null) && (localObject1.length > 0)) {
          ((bsg)localObject2).parseFrom((byte[])localObject1);
        }
        localbpm.ZIs = ((bsg)localObject2);
        paramInt += 1;
      }
      AppMethodBeat.o(257995);
      return 0;
    }
    AppMethodBeat.o(257995);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bpm
 * JD-Core Version:    0.7.0.1
 */