package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dvk
  extends com.tencent.mm.bx.a
{
  public long Bee;
  public dvj ZYO;
  public dvg ZYP;
  public dvi ZYQ;
  public dvh ZYR;
  public int adType;
  public String mdG;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258787);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.adType);
      if (this.ZYO != null)
      {
        paramVarArgs.qD(2, this.ZYO.computeSize());
        this.ZYO.writeFields(paramVarArgs);
      }
      if (this.ZYP != null)
      {
        paramVarArgs.qD(3, this.ZYP.computeSize());
        this.ZYP.writeFields(paramVarArgs);
      }
      if (this.ZYQ != null)
      {
        paramVarArgs.qD(4, this.ZYQ.computeSize());
        this.ZYQ.writeFields(paramVarArgs);
      }
      if (this.ZYR != null)
      {
        paramVarArgs.qD(5, this.ZYR.computeSize());
        this.ZYR.writeFields(paramVarArgs);
      }
      if (this.mdG != null) {
        paramVarArgs.g(20, this.mdG);
      }
      paramVarArgs.bv(21, this.Bee);
      AppMethodBeat.o(258787);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.b.b.a.cJ(1, this.adType) + 0;
      paramInt = i;
      if (this.ZYO != null) {
        paramInt = i + i.a.a.a.qC(2, this.ZYO.computeSize());
      }
      i = paramInt;
      if (this.ZYP != null) {
        i = paramInt + i.a.a.a.qC(3, this.ZYP.computeSize());
      }
      paramInt = i;
      if (this.ZYQ != null) {
        paramInt = i + i.a.a.a.qC(4, this.ZYQ.computeSize());
      }
      i = paramInt;
      if (this.ZYR != null) {
        i = paramInt + i.a.a.a.qC(5, this.ZYR.computeSize());
      }
      paramInt = i;
      if (this.mdG != null) {
        paramInt = i + i.a.a.b.b.a.h(20, this.mdG);
      }
      i = i.a.a.b.b.a.q(21, this.Bee);
      AppMethodBeat.o(258787);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(258787);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
      dvk localdvk = (dvk)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(258787);
        return -1;
      case 1: 
        localdvk.adType = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(258787);
        return 0;
      case 2: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new dvj();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((dvj)localObject2).parseFrom((byte[])localObject1);
          }
          localdvk.ZYO = ((dvj)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(258787);
        return 0;
      case 3: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new dvg();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((dvg)localObject2).parseFrom((byte[])localObject1);
          }
          localdvk.ZYP = ((dvg)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(258787);
        return 0;
      case 4: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new dvi();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((dvi)localObject2).parseFrom((byte[])localObject1);
          }
          localdvk.ZYQ = ((dvi)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(258787);
        return 0;
      case 5: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new dvh();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((dvh)localObject2).parseFrom((byte[])localObject1);
          }
          localdvk.ZYR = ((dvh)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(258787);
        return 0;
      case 20: 
        localdvk.mdG = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(258787);
        return 0;
      }
      localdvk.Bee = ((i.a.a.a.a)localObject1).ajGk.aaw();
      AppMethodBeat.o(258787);
      return 0;
    }
    AppMethodBeat.o(258787);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dvk
 * JD-Core Version:    0.7.0.1
 */