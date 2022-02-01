package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class ecd
  extends esc
{
  public int KJh;
  public String VJU;
  public gel abhB;
  public gei abhC;
  public gec abhD;
  public gej abhE;
  public boolean abhF;
  public LinkedList<String> abhG;
  public geg abhH;
  public String errmsg;
  public int hGE;
  
  public ecd()
  {
    AppMethodBeat.i(91588);
    this.abhG = new LinkedList();
    AppMethodBeat.o(91588);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91589);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(91589);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(2, this.hGE);
      if (this.errmsg != null) {
        paramVarArgs.g(3, this.errmsg);
      }
      if (this.abhB != null)
      {
        paramVarArgs.qD(4, this.abhB.computeSize());
        this.abhB.writeFields(paramVarArgs);
      }
      if (this.abhC != null)
      {
        paramVarArgs.qD(5, this.abhC.computeSize());
        this.abhC.writeFields(paramVarArgs);
      }
      if (this.abhD != null)
      {
        paramVarArgs.qD(6, this.abhD.computeSize());
        this.abhD.writeFields(paramVarArgs);
      }
      if (this.abhE != null)
      {
        paramVarArgs.qD(7, this.abhE.computeSize());
        this.abhE.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(8, this.KJh);
      paramVarArgs.di(9, this.abhF);
      if (this.VJU != null) {
        paramVarArgs.g(10, this.VJU);
      }
      paramVarArgs.e(11, 1, this.abhG);
      if (this.abhH != null)
      {
        paramVarArgs.qD(12, this.abhH.computeSize());
        this.abhH.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(91589);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1314;
      }
    }
    label1314:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.hGE);
      paramInt = i;
      if (this.errmsg != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.errmsg);
      }
      i = paramInt;
      if (this.abhB != null) {
        i = paramInt + i.a.a.a.qC(4, this.abhB.computeSize());
      }
      paramInt = i;
      if (this.abhC != null) {
        paramInt = i + i.a.a.a.qC(5, this.abhC.computeSize());
      }
      i = paramInt;
      if (this.abhD != null) {
        i = paramInt + i.a.a.a.qC(6, this.abhD.computeSize());
      }
      paramInt = i;
      if (this.abhE != null) {
        paramInt = i + i.a.a.a.qC(7, this.abhE.computeSize());
      }
      i = paramInt + i.a.a.b.b.a.cJ(8, this.KJh) + (i.a.a.b.b.a.ko(9) + 1);
      paramInt = i;
      if (this.VJU != null) {
        paramInt = i + i.a.a.b.b.a.h(10, this.VJU);
      }
      i = paramInt + i.a.a.a.c(11, 1, this.abhG);
      paramInt = i;
      if (this.abhH != null) {
        paramInt = i + i.a.a.a.qC(12, this.abhH.computeSize());
      }
      AppMethodBeat.o(91589);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.abhG.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(91589);
          throw paramVarArgs;
        }
        AppMethodBeat.o(91589);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        ecd localecd = (ecd)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91589);
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
            localecd.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91589);
          return 0;
        case 2: 
          localecd.hGE = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(91589);
          return 0;
        case 3: 
          localecd.errmsg = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(91589);
          return 0;
        case 4: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new gel();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((gel)localObject2).parseFrom((byte[])localObject1);
            }
            localecd.abhB = ((gel)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91589);
          return 0;
        case 5: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new gei();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((gei)localObject2).parseFrom((byte[])localObject1);
            }
            localecd.abhC = ((gei)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91589);
          return 0;
        case 6: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new gec();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((gec)localObject2).parseFrom((byte[])localObject1);
            }
            localecd.abhD = ((gec)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91589);
          return 0;
        case 7: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new gej();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((gej)localObject2).parseFrom((byte[])localObject1);
            }
            localecd.abhE = ((gej)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91589);
          return 0;
        case 8: 
          localecd.KJh = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(91589);
          return 0;
        case 9: 
          localecd.abhF = ((i.a.a.a.a)localObject1).ajGk.aai();
          AppMethodBeat.o(91589);
          return 0;
        case 10: 
          localecd.VJU = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(91589);
          return 0;
        case 11: 
          localecd.abhG.add(((i.a.a.a.a)localObject1).ajGk.readString());
          AppMethodBeat.o(91589);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new geg();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((geg)localObject2).parseFrom((byte[])localObject1);
          }
          localecd.abhH = ((geg)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(91589);
        return 0;
      }
      AppMethodBeat.o(91589);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ecd
 * JD-Core Version:    0.7.0.1
 */