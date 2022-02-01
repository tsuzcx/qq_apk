package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class eel
  extends com.tencent.mm.bx.a
{
  public eet abjA;
  public LinkedList<eep> abjB;
  public LinkedList<eek> abjC;
  public LinkedList<eei> abjD;
  public eew abjE;
  public eef abjF;
  public eev abjG;
  public efa abjH;
  public eed abjI;
  public LinkedList<eey> abjJ;
  public eep abjK;
  public LinkedList<eeu> abjL;
  public ees abjM;
  public LinkedList<eez> abjN;
  public eee abjy;
  public eeo abjz;
  
  public eel()
  {
    AppMethodBeat.i(259957);
    this.abjB = new LinkedList();
    this.abjC = new LinkedList();
    this.abjD = new LinkedList();
    this.abjJ = new LinkedList();
    this.abjL = new LinkedList();
    this.abjN = new LinkedList();
    AppMethodBeat.o(259957);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259965);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.abjy != null)
      {
        paramVarArgs.qD(1, this.abjy.computeSize());
        this.abjy.writeFields(paramVarArgs);
      }
      if (this.abjz != null)
      {
        paramVarArgs.qD(2, this.abjz.computeSize());
        this.abjz.writeFields(paramVarArgs);
      }
      if (this.abjA != null)
      {
        paramVarArgs.qD(3, this.abjA.computeSize());
        this.abjA.writeFields(paramVarArgs);
      }
      paramVarArgs.e(4, 8, this.abjB);
      paramVarArgs.e(5, 8, this.abjC);
      paramVarArgs.e(6, 8, this.abjD);
      if (this.abjE != null)
      {
        paramVarArgs.qD(7, this.abjE.computeSize());
        this.abjE.writeFields(paramVarArgs);
      }
      if (this.abjF != null)
      {
        paramVarArgs.qD(8, this.abjF.computeSize());
        this.abjF.writeFields(paramVarArgs);
      }
      if (this.abjG != null)
      {
        paramVarArgs.qD(9, this.abjG.computeSize());
        this.abjG.writeFields(paramVarArgs);
      }
      if (this.abjH != null)
      {
        paramVarArgs.qD(10, this.abjH.computeSize());
        this.abjH.writeFields(paramVarArgs);
      }
      if (this.abjI != null)
      {
        paramVarArgs.qD(11, this.abjI.computeSize());
        this.abjI.writeFields(paramVarArgs);
      }
      paramVarArgs.e(12, 8, this.abjJ);
      if (this.abjK != null)
      {
        paramVarArgs.qD(13, this.abjK.computeSize());
        this.abjK.writeFields(paramVarArgs);
      }
      paramVarArgs.e(14, 8, this.abjL);
      if (this.abjM != null)
      {
        paramVarArgs.qD(15, this.abjM.computeSize());
        this.abjM.writeFields(paramVarArgs);
      }
      paramVarArgs.e(16, 8, this.abjN);
      AppMethodBeat.o(259965);
      return 0;
    }
    if (paramInt == 1) {
      if (this.abjy == null) {
        break label2194;
      }
    }
    label2194:
    for (int i = i.a.a.a.qC(1, this.abjy.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.abjz != null) {
        paramInt = i + i.a.a.a.qC(2, this.abjz.computeSize());
      }
      i = paramInt;
      if (this.abjA != null) {
        i = paramInt + i.a.a.a.qC(3, this.abjA.computeSize());
      }
      i = i + i.a.a.a.c(4, 8, this.abjB) + i.a.a.a.c(5, 8, this.abjC) + i.a.a.a.c(6, 8, this.abjD);
      paramInt = i;
      if (this.abjE != null) {
        paramInt = i + i.a.a.a.qC(7, this.abjE.computeSize());
      }
      i = paramInt;
      if (this.abjF != null) {
        i = paramInt + i.a.a.a.qC(8, this.abjF.computeSize());
      }
      paramInt = i;
      if (this.abjG != null) {
        paramInt = i + i.a.a.a.qC(9, this.abjG.computeSize());
      }
      i = paramInt;
      if (this.abjH != null) {
        i = paramInt + i.a.a.a.qC(10, this.abjH.computeSize());
      }
      paramInt = i;
      if (this.abjI != null) {
        paramInt = i + i.a.a.a.qC(11, this.abjI.computeSize());
      }
      i = paramInt + i.a.a.a.c(12, 8, this.abjJ);
      paramInt = i;
      if (this.abjK != null) {
        paramInt = i + i.a.a.a.qC(13, this.abjK.computeSize());
      }
      i = paramInt + i.a.a.a.c(14, 8, this.abjL);
      paramInt = i;
      if (this.abjM != null) {
        paramInt = i + i.a.a.a.qC(15, this.abjM.computeSize());
      }
      i = i.a.a.a.c(16, 8, this.abjN);
      AppMethodBeat.o(259965);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.abjB.clear();
        this.abjC.clear();
        this.abjD.clear();
        this.abjJ.clear();
        this.abjL.clear();
        this.abjN.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(259965);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        eel localeel = (eel)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(259965);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new eee();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((eee)localObject2).parseFrom((byte[])localObject1);
            }
            localeel.abjy = ((eee)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(259965);
          return 0;
        case 2: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new eeo();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((eeo)localObject2).parseFrom((byte[])localObject1);
            }
            localeel.abjz = ((eeo)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(259965);
          return 0;
        case 3: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new eet();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((eet)localObject2).parseFrom((byte[])localObject1);
            }
            localeel.abjA = ((eet)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(259965);
          return 0;
        case 4: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new eep();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((eep)localObject2).parseFrom((byte[])localObject1);
            }
            localeel.abjB.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(259965);
          return 0;
        case 5: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new eek();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((eek)localObject2).parseFrom((byte[])localObject1);
            }
            localeel.abjC.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(259965);
          return 0;
        case 6: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new eei();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((eei)localObject2).parseFrom((byte[])localObject1);
            }
            localeel.abjD.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(259965);
          return 0;
        case 7: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new eew();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((eew)localObject2).parseFrom((byte[])localObject1);
            }
            localeel.abjE = ((eew)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(259965);
          return 0;
        case 8: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new eef();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((eef)localObject2).parseFrom((byte[])localObject1);
            }
            localeel.abjF = ((eef)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(259965);
          return 0;
        case 9: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new eev();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((eev)localObject2).parseFrom((byte[])localObject1);
            }
            localeel.abjG = ((eev)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(259965);
          return 0;
        case 10: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new efa();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((efa)localObject2).parseFrom((byte[])localObject1);
            }
            localeel.abjH = ((efa)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(259965);
          return 0;
        case 11: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new eed();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((eed)localObject2).parseFrom((byte[])localObject1);
            }
            localeel.abjI = ((eed)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(259965);
          return 0;
        case 12: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new eey();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((eey)localObject2).parseFrom((byte[])localObject1);
            }
            localeel.abjJ.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(259965);
          return 0;
        case 13: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new eep();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((eep)localObject2).parseFrom((byte[])localObject1);
            }
            localeel.abjK = ((eep)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(259965);
          return 0;
        case 14: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new eeu();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((eeu)localObject2).parseFrom((byte[])localObject1);
            }
            localeel.abjL.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(259965);
          return 0;
        case 15: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new ees();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((ees)localObject2).parseFrom((byte[])localObject1);
            }
            localeel.abjM = ((ees)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(259965);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new eez();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((eez)localObject2).parseFrom((byte[])localObject1);
          }
          localeel.abjN.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(259965);
        return 0;
      }
      AppMethodBeat.o(259965);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eel
 * JD-Core Version:    0.7.0.1
 */