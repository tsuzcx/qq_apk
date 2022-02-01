package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class ejv
  extends esc
{
  public long Zjf;
  public long Zjg;
  public dag Zqc;
  public esq aaFC;
  public String aaWY;
  public fnr aaqT;
  public uj aatd;
  public drd aboq;
  public String abor;
  public LinkedList<ebo> hfF;
  public dus ign;
  public String wuA;
  public int wuz;
  
  public ejv()
  {
    AppMethodBeat.i(72560);
    this.hfF = new LinkedList();
    AppMethodBeat.o(72560);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72561);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(72561);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(2, this.wuz);
      if (this.wuA != null) {
        paramVarArgs.g(3, this.wuA);
      }
      if (this.Zqc != null)
      {
        paramVarArgs.qD(4, this.Zqc.computeSize());
        this.Zqc.writeFields(paramVarArgs);
      }
      paramVarArgs.e(5, 8, this.hfF);
      paramVarArgs.bv(6, this.Zjf);
      paramVarArgs.bv(7, this.Zjg);
      if (this.aaFC != null)
      {
        paramVarArgs.qD(8, this.aaFC.computeSize());
        this.aaFC.writeFields(paramVarArgs);
      }
      if (this.aatd != null)
      {
        paramVarArgs.qD(9, this.aatd.computeSize());
        this.aatd.writeFields(paramVarArgs);
      }
      if (this.aaqT != null)
      {
        paramVarArgs.qD(10, this.aaqT.computeSize());
        this.aaqT.writeFields(paramVarArgs);
      }
      if (this.aboq != null)
      {
        paramVarArgs.qD(11, this.aboq.computeSize());
        this.aboq.writeFields(paramVarArgs);
      }
      if (this.ign != null)
      {
        paramVarArgs.qD(12, this.ign.computeSize());
        this.ign.writeFields(paramVarArgs);
      }
      if (this.abor != null) {
        paramVarArgs.g(13, this.abor);
      }
      if (this.aaWY != null) {
        paramVarArgs.g(14, this.aaWY);
      }
      AppMethodBeat.o(72561);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1570;
      }
    }
    label1570:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.wuz);
      paramInt = i;
      if (this.wuA != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.wuA);
      }
      i = paramInt;
      if (this.Zqc != null) {
        i = paramInt + i.a.a.a.qC(4, this.Zqc.computeSize());
      }
      i = i + i.a.a.a.c(5, 8, this.hfF) + i.a.a.b.b.a.q(6, this.Zjf) + i.a.a.b.b.a.q(7, this.Zjg);
      paramInt = i;
      if (this.aaFC != null) {
        paramInt = i + i.a.a.a.qC(8, this.aaFC.computeSize());
      }
      i = paramInt;
      if (this.aatd != null) {
        i = paramInt + i.a.a.a.qC(9, this.aatd.computeSize());
      }
      paramInt = i;
      if (this.aaqT != null) {
        paramInt = i + i.a.a.a.qC(10, this.aaqT.computeSize());
      }
      i = paramInt;
      if (this.aboq != null) {
        i = paramInt + i.a.a.a.qC(11, this.aboq.computeSize());
      }
      paramInt = i;
      if (this.ign != null) {
        paramInt = i + i.a.a.a.qC(12, this.ign.computeSize());
      }
      i = paramInt;
      if (this.abor != null) {
        i = paramInt + i.a.a.b.b.a.h(13, this.abor);
      }
      paramInt = i;
      if (this.aaWY != null) {
        paramInt = i + i.a.a.b.b.a.h(14, this.aaWY);
      }
      AppMethodBeat.o(72561);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.hfF.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(72561);
          throw paramVarArgs;
        }
        AppMethodBeat.o(72561);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        ejv localejv = (ejv)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72561);
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
            localejv.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(72561);
          return 0;
        case 2: 
          localejv.wuz = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(72561);
          return 0;
        case 3: 
          localejv.wuA = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(72561);
          return 0;
        case 4: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dag();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dag)localObject2).parseFrom((byte[])localObject1);
            }
            localejv.Zqc = ((dag)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(72561);
          return 0;
        case 5: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new ebo();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((ebo)localObject2).parseFrom((byte[])localObject1);
            }
            localejv.hfF.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(72561);
          return 0;
        case 6: 
          localejv.Zjf = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(72561);
          return 0;
        case 7: 
          localejv.Zjg = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(72561);
          return 0;
        case 8: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new esq();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((esq)localObject2).parseFrom((byte[])localObject1);
            }
            localejv.aaFC = ((esq)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(72561);
          return 0;
        case 9: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new uj();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((uj)localObject2).parseFrom((byte[])localObject1);
            }
            localejv.aatd = ((uj)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(72561);
          return 0;
        case 10: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new fnr();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((fnr)localObject2).parseFrom((byte[])localObject1);
            }
            localejv.aaqT = ((fnr)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(72561);
          return 0;
        case 11: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new drd();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((drd)localObject2).parseFrom((byte[])localObject1);
            }
            localejv.aboq = ((drd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(72561);
          return 0;
        case 12: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dus();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dus)localObject2).parseFrom((byte[])localObject1);
            }
            localejv.ign = ((dus)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(72561);
          return 0;
        case 13: 
          localejv.abor = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(72561);
          return 0;
        }
        localejv.aaWY = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(72561);
        return 0;
      }
      AppMethodBeat.o(72561);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ejv
 * JD-Core Version:    0.7.0.1
 */