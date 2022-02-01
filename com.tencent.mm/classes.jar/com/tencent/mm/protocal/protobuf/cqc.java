package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class cqc
  extends esc
{
  public aso aawA;
  public glf aawB;
  public gmg aawC;
  public gmi aawD;
  public String aawE;
  public String aawF;
  public LinkedList<gmi> aawG;
  public epg aawH;
  public int aawI;
  public eys aawx;
  public gld aawy;
  public glx aawz;
  
  public cqc()
  {
    AppMethodBeat.i(259137);
    this.aawG = new LinkedList();
    AppMethodBeat.o(259137);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153276);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(153276);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.aawx != null)
      {
        paramVarArgs.qD(2, this.aawx.computeSize());
        this.aawx.writeFields(paramVarArgs);
      }
      if (this.aawy != null)
      {
        paramVarArgs.qD(3, this.aawy.computeSize());
        this.aawy.writeFields(paramVarArgs);
      }
      if (this.aawz != null)
      {
        paramVarArgs.qD(4, this.aawz.computeSize());
        this.aawz.writeFields(paramVarArgs);
      }
      if (this.aawA != null)
      {
        paramVarArgs.qD(5, this.aawA.computeSize());
        this.aawA.writeFields(paramVarArgs);
      }
      if (this.aawB != null)
      {
        paramVarArgs.qD(6, this.aawB.computeSize());
        this.aawB.writeFields(paramVarArgs);
      }
      if (this.aawC != null)
      {
        paramVarArgs.qD(7, this.aawC.computeSize());
        this.aawC.writeFields(paramVarArgs);
      }
      if (this.aawD != null)
      {
        paramVarArgs.qD(8, this.aawD.computeSize());
        this.aawD.writeFields(paramVarArgs);
      }
      if (this.aawE != null) {
        paramVarArgs.g(10, this.aawE);
      }
      if (this.aawF != null) {
        paramVarArgs.g(11, this.aawF);
      }
      paramVarArgs.e(12, 8, this.aawG);
      if (this.aawH != null)
      {
        paramVarArgs.qD(13, this.aawH.computeSize());
        this.aawH.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(14, this.aawI);
      AppMethodBeat.o(153276);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1694;
      }
    }
    label1694:
    for (int i = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.aawx != null) {
        paramInt = i + i.a.a.a.qC(2, this.aawx.computeSize());
      }
      i = paramInt;
      if (this.aawy != null) {
        i = paramInt + i.a.a.a.qC(3, this.aawy.computeSize());
      }
      paramInt = i;
      if (this.aawz != null) {
        paramInt = i + i.a.a.a.qC(4, this.aawz.computeSize());
      }
      i = paramInt;
      if (this.aawA != null) {
        i = paramInt + i.a.a.a.qC(5, this.aawA.computeSize());
      }
      paramInt = i;
      if (this.aawB != null) {
        paramInt = i + i.a.a.a.qC(6, this.aawB.computeSize());
      }
      i = paramInt;
      if (this.aawC != null) {
        i = paramInt + i.a.a.a.qC(7, this.aawC.computeSize());
      }
      paramInt = i;
      if (this.aawD != null) {
        paramInt = i + i.a.a.a.qC(8, this.aawD.computeSize());
      }
      i = paramInt;
      if (this.aawE != null) {
        i = paramInt + i.a.a.b.b.a.h(10, this.aawE);
      }
      paramInt = i;
      if (this.aawF != null) {
        paramInt = i + i.a.a.b.b.a.h(11, this.aawF);
      }
      i = paramInt + i.a.a.a.c(12, 8, this.aawG);
      paramInt = i;
      if (this.aawH != null) {
        paramInt = i + i.a.a.a.qC(13, this.aawH.computeSize());
      }
      i = i.a.a.b.b.a.cJ(14, this.aawI);
      AppMethodBeat.o(153276);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.aawG.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(153276);
          throw paramVarArgs;
        }
        AppMethodBeat.o(153276);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        cqc localcqc = (cqc)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        case 9: 
        default: 
          AppMethodBeat.o(153276);
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
            localcqc.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(153276);
          return 0;
        case 2: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new eys();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((eys)localObject2).parseFrom((byte[])localObject1);
            }
            localcqc.aawx = ((eys)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(153276);
          return 0;
        case 3: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new gld();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((gld)localObject2).parseFrom((byte[])localObject1);
            }
            localcqc.aawy = ((gld)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(153276);
          return 0;
        case 4: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new glx();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((glx)localObject2).parseFrom((byte[])localObject1);
            }
            localcqc.aawz = ((glx)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(153276);
          return 0;
        case 5: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new aso();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((aso)localObject2).parseFrom((byte[])localObject1);
            }
            localcqc.aawA = ((aso)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(153276);
          return 0;
        case 6: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new glf();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((glf)localObject2).parseFrom((byte[])localObject1);
            }
            localcqc.aawB = ((glf)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(153276);
          return 0;
        case 7: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new gmg();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((gmg)localObject2).parseFrom((byte[])localObject1);
            }
            localcqc.aawC = ((gmg)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(153276);
          return 0;
        case 8: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new gmi();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((gmi)localObject2).parseFrom((byte[])localObject1);
            }
            localcqc.aawD = ((gmi)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(153276);
          return 0;
        case 10: 
          localcqc.aawE = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(153276);
          return 0;
        case 11: 
          localcqc.aawF = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(153276);
          return 0;
        case 12: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new gmi();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((gmi)localObject2).parseFrom((byte[])localObject1);
            }
            localcqc.aawG.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(153276);
          return 0;
        case 13: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new epg();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((epg)localObject2).parseFrom((byte[])localObject1);
            }
            localcqc.aawH = ((epg)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(153276);
          return 0;
        }
        localcqc.aawI = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(153276);
        return 0;
      }
      AppMethodBeat.o(153276);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cqc
 * JD-Core Version:    0.7.0.1
 */