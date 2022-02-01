package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bjc
  extends com.tencent.mm.bx.a
{
  public int Avb;
  public int CBd;
  public int CWC;
  public int Czn;
  public int TpP;
  public bja ZQa;
  public int ZSL;
  public ebc ZSM;
  public bjd ZSN;
  public String description;
  public int endTime;
  public int extFlag;
  public String id;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(260095);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.id != null) {
        paramVarArgs.g(1, this.id);
      }
      paramVarArgs.bS(2, this.TpP);
      paramVarArgs.bS(3, this.endTime);
      paramVarArgs.bS(4, this.CWC);
      if (this.description != null) {
        paramVarArgs.g(5, this.description);
      }
      if (this.ZQa != null)
      {
        paramVarArgs.qD(6, this.ZQa.computeSize());
        this.ZQa.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(7, this.Czn);
      paramVarArgs.bS(8, this.Avb);
      paramVarArgs.bS(9, this.CBd);
      paramVarArgs.bS(10, this.extFlag);
      paramVarArgs.bS(11, this.ZSL);
      if (this.ZSM != null)
      {
        paramVarArgs.qD(12, this.ZSM.computeSize());
        this.ZSM.writeFields(paramVarArgs);
      }
      if (this.ZSN != null)
      {
        paramVarArgs.qD(13, this.ZSN.computeSize());
        this.ZSN.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(260095);
      return 0;
    }
    if (paramInt == 1) {
      if (this.id == null) {
        break label1024;
      }
    }
    label1024:
    for (paramInt = i.a.a.b.b.a.h(1, this.id) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.TpP) + i.a.a.b.b.a.cJ(3, this.endTime) + i.a.a.b.b.a.cJ(4, this.CWC);
      paramInt = i;
      if (this.description != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.description);
      }
      i = paramInt;
      if (this.ZQa != null) {
        i = paramInt + i.a.a.a.qC(6, this.ZQa.computeSize());
      }
      i = i + i.a.a.b.b.a.cJ(7, this.Czn) + i.a.a.b.b.a.cJ(8, this.Avb) + i.a.a.b.b.a.cJ(9, this.CBd) + i.a.a.b.b.a.cJ(10, this.extFlag) + i.a.a.b.b.a.cJ(11, this.ZSL);
      paramInt = i;
      if (this.ZSM != null) {
        paramInt = i + i.a.a.a.qC(12, this.ZSM.computeSize());
      }
      i = paramInt;
      if (this.ZSN != null) {
        i = paramInt + i.a.a.a.qC(13, this.ZSN.computeSize());
      }
      AppMethodBeat.o(260095);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(260095);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        bjc localbjc = (bjc)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(260095);
          return -1;
        case 1: 
          localbjc.id = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(260095);
          return 0;
        case 2: 
          localbjc.TpP = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(260095);
          return 0;
        case 3: 
          localbjc.endTime = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(260095);
          return 0;
        case 4: 
          localbjc.CWC = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(260095);
          return 0;
        case 5: 
          localbjc.description = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(260095);
          return 0;
        case 6: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bja();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bja)localObject2).parseFrom((byte[])localObject1);
            }
            localbjc.ZQa = ((bja)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(260095);
          return 0;
        case 7: 
          localbjc.Czn = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(260095);
          return 0;
        case 8: 
          localbjc.Avb = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(260095);
          return 0;
        case 9: 
          localbjc.CBd = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(260095);
          return 0;
        case 10: 
          localbjc.extFlag = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(260095);
          return 0;
        case 11: 
          localbjc.ZSL = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(260095);
          return 0;
        case 12: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new ebc();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((ebc)localObject2).parseFrom((byte[])localObject1);
            }
            localbjc.ZSM = ((ebc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(260095);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new bjd();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((bjd)localObject2).parseFrom((byte[])localObject1);
          }
          localbjc.ZSN = ((bjd)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(260095);
        return 0;
      }
      AppMethodBeat.o(260095);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bjc
 * JD-Core Version:    0.7.0.1
 */