package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class auc
  extends com.tencent.mm.bx.a
{
  public int ZEC;
  public bzb ZED;
  public btl ZEE;
  public auh ZEF;
  public bvz ZEG;
  public auh biz_info;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258016);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.ZEC);
      if (this.biz_info != null)
      {
        paramVarArgs.qD(2, this.biz_info.computeSize());
        this.biz_info.writeFields(paramVarArgs);
      }
      if (this.ZED != null)
      {
        paramVarArgs.qD(3, this.ZED.computeSize());
        this.ZED.writeFields(paramVarArgs);
      }
      if (this.ZEE != null)
      {
        paramVarArgs.qD(4, this.ZEE.computeSize());
        this.ZEE.writeFields(paramVarArgs);
      }
      if (this.ZEF != null)
      {
        paramVarArgs.qD(5, this.ZEF.computeSize());
        this.ZEF.writeFields(paramVarArgs);
      }
      if (this.ZEG != null)
      {
        paramVarArgs.qD(6, this.ZEG.computeSize());
        this.ZEG.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(258016);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.b.b.a.cJ(1, this.ZEC) + 0;
      paramInt = i;
      if (this.biz_info != null) {
        paramInt = i + i.a.a.a.qC(2, this.biz_info.computeSize());
      }
      i = paramInt;
      if (this.ZED != null) {
        i = paramInt + i.a.a.a.qC(3, this.ZED.computeSize());
      }
      paramInt = i;
      if (this.ZEE != null) {
        paramInt = i + i.a.a.a.qC(4, this.ZEE.computeSize());
      }
      i = paramInt;
      if (this.ZEF != null) {
        i = paramInt + i.a.a.a.qC(5, this.ZEF.computeSize());
      }
      paramInt = i;
      if (this.ZEG != null) {
        paramInt = i + i.a.a.a.qC(6, this.ZEG.computeSize());
      }
      AppMethodBeat.o(258016);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(258016);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
      auc localauc = (auc)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(258016);
        return -1;
      case 1: 
        localauc.ZEC = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(258016);
        return 0;
      case 2: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new auh();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((auh)localObject2).parseFrom((byte[])localObject1);
          }
          localauc.biz_info = ((auh)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(258016);
        return 0;
      case 3: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new bzb();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((bzb)localObject2).parseFrom((byte[])localObject1);
          }
          localauc.ZED = ((bzb)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(258016);
        return 0;
      case 4: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new btl();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((btl)localObject2).parseFrom((byte[])localObject1);
          }
          localauc.ZEE = ((btl)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(258016);
        return 0;
      case 5: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new auh();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((auh)localObject2).parseFrom((byte[])localObject1);
          }
          localauc.ZEF = ((auh)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(258016);
        return 0;
      }
      paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject1 = (byte[])paramVarArgs.get(paramInt);
        localObject2 = new bvz();
        if ((localObject1 != null) && (localObject1.length > 0)) {
          ((bvz)localObject2).parseFrom((byte[])localObject1);
        }
        localauc.ZEG = ((bvz)localObject2);
        paramInt += 1;
      }
      AppMethodBeat.o(258016);
      return 0;
    }
    AppMethodBeat.o(258016);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.auc
 * JD-Core Version:    0.7.0.1
 */