package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class aym
  extends erp
{
  public String YIZ;
  public atz ZEc;
  public LinkedList<String> ZJs;
  public int ZJt;
  public LinkedList<avo> ZJu;
  public LinkedList<avm> ZJv;
  public LinkedList<avj> ZJw;
  public LinkedList<avk> ZJx;
  public int ZJy;
  public LinkedList<avr> ZJz;
  
  public aym()
  {
    AppMethodBeat.i(259356);
    this.ZJs = new LinkedList();
    this.ZJu = new LinkedList();
    this.ZJv = new LinkedList();
    this.ZJw = new LinkedList();
    this.ZJx = new LinkedList();
    this.ZJz = new LinkedList();
    AppMethodBeat.o(259356);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259362);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.ZEc != null)
      {
        paramVarArgs.qD(2, this.ZEc.computeSize());
        this.ZEc.writeFields(paramVarArgs);
      }
      paramVarArgs.e(3, 1, this.ZJs);
      paramVarArgs.bS(4, this.ZJt);
      if (this.YIZ != null) {
        paramVarArgs.g(5, this.YIZ);
      }
      paramVarArgs.e(6, 8, this.ZJu);
      paramVarArgs.e(7, 8, this.ZJv);
      paramVarArgs.e(8, 8, this.ZJw);
      paramVarArgs.e(9, 8, this.ZJx);
      paramVarArgs.bS(10, this.ZJy);
      paramVarArgs.e(11, 8, this.ZJz);
      AppMethodBeat.o(259362);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1228;
      }
    }
    label1228:
    for (paramInt = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.ZEc != null) {
        i = paramInt + i.a.a.a.qC(2, this.ZEc.computeSize());
      }
      i = i + i.a.a.a.c(3, 1, this.ZJs) + i.a.a.b.b.a.cJ(4, this.ZJt);
      paramInt = i;
      if (this.YIZ != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.YIZ);
      }
      i = i.a.a.a.c(6, 8, this.ZJu);
      int j = i.a.a.a.c(7, 8, this.ZJv);
      int k = i.a.a.a.c(8, 8, this.ZJw);
      int m = i.a.a.a.c(9, 8, this.ZJx);
      int n = i.a.a.b.b.a.cJ(10, this.ZJy);
      int i1 = i.a.a.a.c(11, 8, this.ZJz);
      AppMethodBeat.o(259362);
      return paramInt + i + j + k + m + n + i1;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.ZJs.clear();
        this.ZJu.clear();
        this.ZJv.clear();
        this.ZJw.clear();
        this.ZJx.clear();
        this.ZJz.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(259362);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        aym localaym = (aym)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(259362);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new kc();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((kc)localObject2).parseFrom((byte[])localObject1);
            }
            localaym.BaseRequest = ((kc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(259362);
          return 0;
        case 2: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new atz();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((atz)localObject2).parseFrom((byte[])localObject1);
            }
            localaym.ZEc = ((atz)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(259362);
          return 0;
        case 3: 
          localaym.ZJs.add(((i.a.a.a.a)localObject1).ajGk.readString());
          AppMethodBeat.o(259362);
          return 0;
        case 4: 
          localaym.ZJt = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(259362);
          return 0;
        case 5: 
          localaym.YIZ = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(259362);
          return 0;
        case 6: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new avo();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((avo)localObject2).parseFrom((byte[])localObject1);
            }
            localaym.ZJu.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(259362);
          return 0;
        case 7: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new avm();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((avm)localObject2).parseFrom((byte[])localObject1);
            }
            localaym.ZJv.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(259362);
          return 0;
        case 8: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new avj();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((avj)localObject2).parseFrom((byte[])localObject1);
            }
            localaym.ZJw.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(259362);
          return 0;
        case 9: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new avk();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((avk)localObject2).parseFrom((byte[])localObject1);
            }
            localaym.ZJx.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(259362);
          return 0;
        case 10: 
          localaym.ZJy = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(259362);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new avr();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((avr)localObject2).parseFrom((byte[])localObject1);
          }
          localaym.ZJz.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(259362);
        return 0;
      }
      AppMethodBeat.o(259362);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aym
 * JD-Core Version:    0.7.0.1
 */