package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class nh
  extends com.tencent.mm.bx.a
{
  public uu YPa;
  public uu YPb;
  public uu YPc;
  public gol YPd;
  public gol YPe;
  public uu YPf;
  public int YPg;
  public ut YPh;
  public ut YPi;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(104359);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.YPa != null)
      {
        paramVarArgs.qD(1, this.YPa.computeSize());
        this.YPa.writeFields(paramVarArgs);
      }
      if (this.YPb != null)
      {
        paramVarArgs.qD(2, this.YPb.computeSize());
        this.YPb.writeFields(paramVarArgs);
      }
      if (this.YPc != null)
      {
        paramVarArgs.qD(4, this.YPc.computeSize());
        this.YPc.writeFields(paramVarArgs);
      }
      if (this.YPd != null)
      {
        paramVarArgs.qD(5, this.YPd.computeSize());
        this.YPd.writeFields(paramVarArgs);
      }
      if (this.YPe != null)
      {
        paramVarArgs.qD(6, this.YPe.computeSize());
        this.YPe.writeFields(paramVarArgs);
      }
      if (this.YPf != null)
      {
        paramVarArgs.qD(7, this.YPf.computeSize());
        this.YPf.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(8, this.YPg);
      if (this.YPh != null)
      {
        paramVarArgs.qD(9, this.YPh.computeSize());
        this.YPh.writeFields(paramVarArgs);
      }
      if (this.YPi != null)
      {
        paramVarArgs.qD(10, this.YPi.computeSize());
        this.YPi.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(104359);
      return 0;
    }
    if (paramInt == 1) {
      if (this.YPa == null) {
        break label1266;
      }
    }
    label1266:
    for (int i = i.a.a.a.qC(1, this.YPa.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.YPb != null) {
        paramInt = i + i.a.a.a.qC(2, this.YPb.computeSize());
      }
      i = paramInt;
      if (this.YPc != null) {
        i = paramInt + i.a.a.a.qC(4, this.YPc.computeSize());
      }
      paramInt = i;
      if (this.YPd != null) {
        paramInt = i + i.a.a.a.qC(5, this.YPd.computeSize());
      }
      i = paramInt;
      if (this.YPe != null) {
        i = paramInt + i.a.a.a.qC(6, this.YPe.computeSize());
      }
      paramInt = i;
      if (this.YPf != null) {
        paramInt = i + i.a.a.a.qC(7, this.YPf.computeSize());
      }
      i = paramInt + i.a.a.b.b.a.cJ(8, this.YPg);
      paramInt = i;
      if (this.YPh != null) {
        paramInt = i + i.a.a.a.qC(9, this.YPh.computeSize());
      }
      i = paramInt;
      if (this.YPi != null) {
        i = paramInt + i.a.a.a.qC(10, this.YPi.computeSize());
      }
      AppMethodBeat.o(104359);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(104359);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        nh localnh = (nh)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        case 3: 
        default: 
          AppMethodBeat.o(104359);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new uu();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((uu)localObject2).parseFrom((byte[])localObject1);
            }
            localnh.YPa = ((uu)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(104359);
          return 0;
        case 2: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new uu();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((uu)localObject2).parseFrom((byte[])localObject1);
            }
            localnh.YPb = ((uu)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(104359);
          return 0;
        case 4: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new uu();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((uu)localObject2).parseFrom((byte[])localObject1);
            }
            localnh.YPc = ((uu)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(104359);
          return 0;
        case 5: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new gol();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((gol)localObject2).dg((byte[])localObject1);
            }
            localnh.YPd = ((gol)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(104359);
          return 0;
        case 6: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new gol();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((gol)localObject2).dg((byte[])localObject1);
            }
            localnh.YPe = ((gol)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(104359);
          return 0;
        case 7: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new uu();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((uu)localObject2).parseFrom((byte[])localObject1);
            }
            localnh.YPf = ((uu)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(104359);
          return 0;
        case 8: 
          localnh.YPg = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(104359);
          return 0;
        case 9: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new ut();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((ut)localObject2).parseFrom((byte[])localObject1);
            }
            localnh.YPh = ((ut)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(104359);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new ut();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((ut)localObject2).parseFrom((byte[])localObject1);
          }
          localnh.YPi = ((ut)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(104359);
        return 0;
      }
      AppMethodBeat.o(104359);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.nh
 * JD-Core Version:    0.7.0.1
 */