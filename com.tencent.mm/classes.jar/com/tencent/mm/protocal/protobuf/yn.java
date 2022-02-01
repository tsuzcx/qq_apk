package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class yn
  extends esc
{
  public String OiN;
  public LinkedList<Integer> ZgH;
  public int ZgJ;
  public String ZgT;
  public String ZgZ;
  public String Zhc;
  public String Zhe;
  public String Zhf;
  public String Zhi;
  public String Zhj;
  public String Zhk;
  public String desc;
  public int hAV;
  public dus ign;
  public String wYI;
  
  public yn()
  {
    AppMethodBeat.i(72440);
    this.ZgH = new LinkedList();
    AppMethodBeat.o(72440);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72441);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(72441);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(2, this.hAV);
      if (this.wYI != null) {
        paramVarArgs.g(3, this.wYI);
      }
      if (this.ZgZ != null) {
        paramVarArgs.g(4, this.ZgZ);
      }
      paramVarArgs.e(5, 2, this.ZgH);
      if (this.desc != null) {
        paramVarArgs.g(6, this.desc);
      }
      if (this.Zhi != null) {
        paramVarArgs.g(7, this.Zhi);
      }
      if (this.OiN != null) {
        paramVarArgs.g(8, this.OiN);
      }
      if (this.Zhc != null) {
        paramVarArgs.g(9, this.Zhc);
      }
      if (this.Zhe != null) {
        paramVarArgs.g(10, this.Zhe);
      }
      if (this.Zhf != null) {
        paramVarArgs.g(11, this.Zhf);
      }
      paramVarArgs.bS(12, this.ZgJ);
      if (this.ZgT != null) {
        paramVarArgs.g(13, this.ZgT);
      }
      if (this.Zhj != null) {
        paramVarArgs.g(14, this.Zhj);
      }
      if (this.Zhk != null) {
        paramVarArgs.g(15, this.Zhk);
      }
      if (this.ign != null)
      {
        paramVarArgs.qD(16, this.ign.computeSize());
        this.ign.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(72441);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1297;
      }
    }
    label1297:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.hAV);
      paramInt = i;
      if (this.wYI != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.wYI);
      }
      i = paramInt;
      if (this.ZgZ != null) {
        i = paramInt + i.a.a.b.b.a.h(4, this.ZgZ);
      }
      i += i.a.a.a.c(5, 2, this.ZgH);
      paramInt = i;
      if (this.desc != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.desc);
      }
      i = paramInt;
      if (this.Zhi != null) {
        i = paramInt + i.a.a.b.b.a.h(7, this.Zhi);
      }
      paramInt = i;
      if (this.OiN != null) {
        paramInt = i + i.a.a.b.b.a.h(8, this.OiN);
      }
      i = paramInt;
      if (this.Zhc != null) {
        i = paramInt + i.a.a.b.b.a.h(9, this.Zhc);
      }
      paramInt = i;
      if (this.Zhe != null) {
        paramInt = i + i.a.a.b.b.a.h(10, this.Zhe);
      }
      i = paramInt;
      if (this.Zhf != null) {
        i = paramInt + i.a.a.b.b.a.h(11, this.Zhf);
      }
      i += i.a.a.b.b.a.cJ(12, this.ZgJ);
      paramInt = i;
      if (this.ZgT != null) {
        paramInt = i + i.a.a.b.b.a.h(13, this.ZgT);
      }
      i = paramInt;
      if (this.Zhj != null) {
        i = paramInt + i.a.a.b.b.a.h(14, this.Zhj);
      }
      paramInt = i;
      if (this.Zhk != null) {
        paramInt = i + i.a.a.b.b.a.h(15, this.Zhk);
      }
      i = paramInt;
      if (this.ign != null) {
        i = paramInt + i.a.a.a.qC(16, this.ign.computeSize());
      }
      AppMethodBeat.o(72441);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.ZgH.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(72441);
          throw paramVarArgs;
        }
        AppMethodBeat.o(72441);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        yn localyn = (yn)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72441);
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
            localyn.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(72441);
          return 0;
        case 2: 
          localyn.hAV = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(72441);
          return 0;
        case 3: 
          localyn.wYI = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(72441);
          return 0;
        case 4: 
          localyn.ZgZ = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(72441);
          return 0;
        case 5: 
          localyn.ZgH.add(Integer.valueOf(((i.a.a.a.a)localObject1).ajGk.aar()));
          AppMethodBeat.o(72441);
          return 0;
        case 6: 
          localyn.desc = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(72441);
          return 0;
        case 7: 
          localyn.Zhi = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(72441);
          return 0;
        case 8: 
          localyn.OiN = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(72441);
          return 0;
        case 9: 
          localyn.Zhc = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(72441);
          return 0;
        case 10: 
          localyn.Zhe = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(72441);
          return 0;
        case 11: 
          localyn.Zhf = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(72441);
          return 0;
        case 12: 
          localyn.ZgJ = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(72441);
          return 0;
        case 13: 
          localyn.ZgT = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(72441);
          return 0;
        case 14: 
          localyn.Zhj = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(72441);
          return 0;
        case 15: 
          localyn.Zhk = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(72441);
          return 0;
        }
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
          localyn.ign = ((dus)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(72441);
        return 0;
      }
      AppMethodBeat.o(72441);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.yn
 * JD-Core Version:    0.7.0.1
 */