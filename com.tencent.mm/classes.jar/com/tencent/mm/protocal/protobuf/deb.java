package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class deb
  extends esc
{
  public String IKJ;
  public String YDL;
  public eq aaAr;
  public fvl aaAs;
  public String aaJB;
  public String aaJC;
  public String aaJD;
  public com.tencent.mm.bx.b aaJE;
  public String aaJF;
  public ddh aaJx;
  public LinkedList<eul> aans;
  
  public deb()
  {
    AppMethodBeat.i(123609);
    this.aans = new LinkedList();
    AppMethodBeat.o(123609);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123610);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new i.a.a.b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(123610);
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
      paramVarArgs.e(3, 8, this.aans);
      if (this.IKJ != null) {
        paramVarArgs.g(4, this.IKJ);
      }
      if (this.YDL != null) {
        paramVarArgs.g(5, this.YDL);
      }
      if (this.aaJB != null) {
        paramVarArgs.g(6, this.aaJB);
      }
      if (this.aaJC != null) {
        paramVarArgs.g(7, this.aaJC);
      }
      if (this.aaJD != null) {
        paramVarArgs.g(8, this.aaJD);
      }
      if (this.aaAr != null)
      {
        paramVarArgs.qD(9, this.aaAr.computeSize());
        this.aaAr.writeFields(paramVarArgs);
      }
      if (this.aaJE != null) {
        paramVarArgs.d(10, this.aaJE);
      }
      if (this.aaJF != null) {
        paramVarArgs.g(11, this.aaJF);
      }
      if (this.aaAs != null)
      {
        paramVarArgs.qD(12, this.aaAs.computeSize());
        this.aaAs.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(123610);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1284;
      }
    }
    label1284:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.aaJx != null) {
        i = paramInt + i.a.a.a.qC(2, this.aaJx.computeSize());
      }
      i += i.a.a.a.c(3, 8, this.aans);
      paramInt = i;
      if (this.IKJ != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.IKJ);
      }
      i = paramInt;
      if (this.YDL != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.YDL);
      }
      paramInt = i;
      if (this.aaJB != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.aaJB);
      }
      i = paramInt;
      if (this.aaJC != null) {
        i = paramInt + i.a.a.b.b.a.h(7, this.aaJC);
      }
      paramInt = i;
      if (this.aaJD != null) {
        paramInt = i + i.a.a.b.b.a.h(8, this.aaJD);
      }
      i = paramInt;
      if (this.aaAr != null) {
        i = paramInt + i.a.a.a.qC(9, this.aaAr.computeSize());
      }
      paramInt = i;
      if (this.aaJE != null) {
        paramInt = i + i.a.a.b.b.a.c(10, this.aaJE);
      }
      i = paramInt;
      if (this.aaJF != null) {
        i = paramInt + i.a.a.b.b.a.h(11, this.aaJF);
      }
      paramInt = i;
      if (this.aaAs != null) {
        paramInt = i + i.a.a.a.qC(12, this.aaAs.computeSize());
      }
      AppMethodBeat.o(123610);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.aans.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new i.a.a.b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(123610);
          throw paramVarArgs;
        }
        AppMethodBeat.o(123610);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        deb localdeb = (deb)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(123610);
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
            localdeb.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(123610);
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
            localdeb.aaJx = ((ddh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(123610);
          return 0;
        case 3: 
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
            localdeb.aans.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(123610);
          return 0;
        case 4: 
          localdeb.IKJ = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(123610);
          return 0;
        case 5: 
          localdeb.YDL = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(123610);
          return 0;
        case 6: 
          localdeb.aaJB = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(123610);
          return 0;
        case 7: 
          localdeb.aaJC = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(123610);
          return 0;
        case 8: 
          localdeb.aaJD = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(123610);
          return 0;
        case 9: 
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
            localdeb.aaAr = ((eq)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(123610);
          return 0;
        case 10: 
          localdeb.aaJE = ((i.a.a.a.a)localObject1).ajGk.kFX();
          AppMethodBeat.o(123610);
          return 0;
        case 11: 
          localdeb.aaJF = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(123610);
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
          localdeb.aaAs = ((fvl)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(123610);
        return 0;
      }
      AppMethodBeat.o(123610);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.deb
 * JD-Core Version:    0.7.0.1
 */