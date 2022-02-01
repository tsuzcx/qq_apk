package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class deh
  extends esc
{
  public String IKJ;
  public String YDL;
  public eq aaAr;
  public fvl aaAs;
  public String aaJB;
  public String aaJC;
  public String aaJD;
  public eul aaJO;
  public ahp aaJP;
  public boolean aaJQ;
  public fur aaJR;
  public ddh aaJx;
  public com.tencent.mm.bx.b vgA;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123619);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new i.a.a.b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(123619);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.aaJx != null)
      {
        paramVarArgs.qD(2, this.aaJx.computeSize());
        this.aaJx.writeFields(paramVarArgs);
      }
      if (this.vgA != null) {
        paramVarArgs.d(3, this.vgA);
      }
      if (this.aaJO != null)
      {
        paramVarArgs.qD(4, this.aaJO.computeSize());
        this.aaJO.writeFields(paramVarArgs);
      }
      if (this.IKJ != null) {
        paramVarArgs.g(5, this.IKJ);
      }
      if (this.YDL != null) {
        paramVarArgs.g(6, this.YDL);
      }
      if (this.aaJP != null)
      {
        paramVarArgs.qD(7, this.aaJP.computeSize());
        this.aaJP.writeFields(paramVarArgs);
      }
      paramVarArgs.di(8, this.aaJQ);
      if (this.aaJB != null) {
        paramVarArgs.g(9, this.aaJB);
      }
      if (this.aaJC != null) {
        paramVarArgs.g(10, this.aaJC);
      }
      if (this.aaJD != null) {
        paramVarArgs.g(11, this.aaJD);
      }
      if (this.aaJR != null)
      {
        paramVarArgs.qD(12, this.aaJR.computeSize());
        this.aaJR.writeFields(paramVarArgs);
      }
      if (this.aaAr != null)
      {
        paramVarArgs.qD(13, this.aaAr.computeSize());
        this.aaAr.writeFields(paramVarArgs);
      }
      if (this.aaAs != null)
      {
        paramVarArgs.qD(15, this.aaAs.computeSize());
        this.aaAs.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(123619);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1548;
      }
    }
    label1548:
    for (int i = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.aaJx != null) {
        paramInt = i + i.a.a.a.qC(2, this.aaJx.computeSize());
      }
      i = paramInt;
      if (this.vgA != null) {
        i = paramInt + i.a.a.b.b.a.c(3, this.vgA);
      }
      paramInt = i;
      if (this.aaJO != null) {
        paramInt = i + i.a.a.a.qC(4, this.aaJO.computeSize());
      }
      i = paramInt;
      if (this.IKJ != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.IKJ);
      }
      paramInt = i;
      if (this.YDL != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.YDL);
      }
      i = paramInt;
      if (this.aaJP != null) {
        i = paramInt + i.a.a.a.qC(7, this.aaJP.computeSize());
      }
      i += i.a.a.b.b.a.ko(8) + 1;
      paramInt = i;
      if (this.aaJB != null) {
        paramInt = i + i.a.a.b.b.a.h(9, this.aaJB);
      }
      i = paramInt;
      if (this.aaJC != null) {
        i = paramInt + i.a.a.b.b.a.h(10, this.aaJC);
      }
      paramInt = i;
      if (this.aaJD != null) {
        paramInt = i + i.a.a.b.b.a.h(11, this.aaJD);
      }
      i = paramInt;
      if (this.aaJR != null) {
        i = paramInt + i.a.a.a.qC(12, this.aaJR.computeSize());
      }
      paramInt = i;
      if (this.aaAr != null) {
        paramInt = i + i.a.a.a.qC(13, this.aaAr.computeSize());
      }
      i = paramInt;
      if (this.aaAs != null) {
        i = paramInt + i.a.a.a.qC(15, this.aaAs.computeSize());
      }
      AppMethodBeat.o(123619);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new i.a.a.b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(123619);
          throw paramVarArgs;
        }
        AppMethodBeat.o(123619);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        deh localdeh = (deh)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        case 14: 
        default: 
          AppMethodBeat.o(123619);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new kd();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((kd)localObject2).parseFrom((byte[])localObject1);
            }
            localdeh.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(123619);
          return 0;
        case 2: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new ddh();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((ddh)localObject2).parseFrom((byte[])localObject1);
            }
            localdeh.aaJx = ((ddh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(123619);
          return 0;
        case 3: 
          localdeh.vgA = ((i.a.a.a.a)localObject1).ajGk.kFX();
          AppMethodBeat.o(123619);
          return 0;
        case 4: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new eul();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((eul)localObject2).parseFrom((byte[])localObject1);
            }
            localdeh.aaJO = ((eul)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(123619);
          return 0;
        case 5: 
          localdeh.IKJ = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(123619);
          return 0;
        case 6: 
          localdeh.YDL = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(123619);
          return 0;
        case 7: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new ahp();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((ahp)localObject2).parseFrom((byte[])localObject1);
            }
            localdeh.aaJP = ((ahp)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(123619);
          return 0;
        case 8: 
          localdeh.aaJQ = ((i.a.a.a.a)localObject1).ajGk.aai();
          AppMethodBeat.o(123619);
          return 0;
        case 9: 
          localdeh.aaJB = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(123619);
          return 0;
        case 10: 
          localdeh.aaJC = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(123619);
          return 0;
        case 11: 
          localdeh.aaJD = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(123619);
          return 0;
        case 12: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new fur();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((fur)localObject2).parseFrom((byte[])localObject1);
            }
            localdeh.aaJR = ((fur)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(123619);
          return 0;
        case 13: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new eq();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((eq)localObject2).parseFrom((byte[])localObject1);
            }
            localdeh.aaAr = ((eq)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(123619);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new fvl();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((fvl)localObject2).parseFrom((byte[])localObject1);
          }
          localdeh.aaAs = ((fvl)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(123619);
        return 0;
      }
      AppMethodBeat.o(123619);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.deh
 * JD-Core Version:    0.7.0.1
 */