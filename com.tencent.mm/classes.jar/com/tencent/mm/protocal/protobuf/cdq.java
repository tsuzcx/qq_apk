package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class cdq
  extends com.tencent.mm.bx.a
{
  public boolean TpE;
  public awr YGg;
  public b aanT;
  public LinkedList<bp> aanV;
  public bp aanW;
  public br aanX;
  public boolean aanY;
  public boolean aanZ;
  public bo aaoa;
  
  public cdq()
  {
    AppMethodBeat.i(257535);
    this.aanV = new LinkedList();
    AppMethodBeat.o(257535);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(257541);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.YGg != null)
      {
        paramVarArgs.qD(1, this.YGg.computeSize());
        this.YGg.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.aanV);
      if (this.aanW != null)
      {
        paramVarArgs.qD(3, this.aanW.computeSize());
        this.aanW.writeFields(paramVarArgs);
      }
      if (this.aanX != null)
      {
        paramVarArgs.qD(4, this.aanX.computeSize());
        this.aanX.writeFields(paramVarArgs);
      }
      paramVarArgs.di(5, this.aanY);
      paramVarArgs.di(6, this.aanZ);
      paramVarArgs.di(7, this.TpE);
      if (this.aanT != null) {
        paramVarArgs.d(8, this.aanT);
      }
      if (this.aaoa != null)
      {
        paramVarArgs.qD(9, this.aaoa.computeSize());
        this.aaoa.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(257541);
      return 0;
    }
    if (paramInt == 1) {
      if (this.YGg == null) {
        break label992;
      }
    }
    label992:
    for (paramInt = i.a.a.a.qC(1, this.YGg.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.a.c(2, 8, this.aanV);
      paramInt = i;
      if (this.aanW != null) {
        paramInt = i + i.a.a.a.qC(3, this.aanW.computeSize());
      }
      i = paramInt;
      if (this.aanX != null) {
        i = paramInt + i.a.a.a.qC(4, this.aanX.computeSize());
      }
      i = i + (i.a.a.b.b.a.ko(5) + 1) + (i.a.a.b.b.a.ko(6) + 1) + (i.a.a.b.b.a.ko(7) + 1);
      paramInt = i;
      if (this.aanT != null) {
        paramInt = i + i.a.a.b.b.a.c(8, this.aanT);
      }
      i = paramInt;
      if (this.aaoa != null) {
        i = paramInt + i.a.a.a.qC(9, this.aaoa.computeSize());
      }
      AppMethodBeat.o(257541);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.aanV.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(257541);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        cdq localcdq = (cdq)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(257541);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new awr();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((awr)localObject2).parseFrom((byte[])localObject1);
            }
            localcdq.YGg = ((awr)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(257541);
          return 0;
        case 2: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bp();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bp)localObject2).parseFrom((byte[])localObject1);
            }
            localcdq.aanV.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(257541);
          return 0;
        case 3: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bp();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bp)localObject2).parseFrom((byte[])localObject1);
            }
            localcdq.aanW = ((bp)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(257541);
          return 0;
        case 4: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new br();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((br)localObject2).parseFrom((byte[])localObject1);
            }
            localcdq.aanX = ((br)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(257541);
          return 0;
        case 5: 
          localcdq.aanY = ((i.a.a.a.a)localObject1).ajGk.aai();
          AppMethodBeat.o(257541);
          return 0;
        case 6: 
          localcdq.aanZ = ((i.a.a.a.a)localObject1).ajGk.aai();
          AppMethodBeat.o(257541);
          return 0;
        case 7: 
          localcdq.TpE = ((i.a.a.a.a)localObject1).ajGk.aai();
          AppMethodBeat.o(257541);
          return 0;
        case 8: 
          localcdq.aanT = ((i.a.a.a.a)localObject1).ajGk.kFX();
          AppMethodBeat.o(257541);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new bo();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((bo)localObject2).parseFrom((byte[])localObject1);
          }
          localcdq.aaoa = ((bo)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(257541);
        return 0;
      }
      AppMethodBeat.o(257541);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cdq
 * JD-Core Version:    0.7.0.1
 */