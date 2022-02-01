package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class eoh
  extends com.tencent.mm.bx.a
{
  public String Kru;
  public String Krv;
  public int aaxT;
  public int absA;
  public int absB;
  public int absC;
  public String absD;
  public String absE;
  public String absv;
  public LinkedList<fim> absw;
  public String absx;
  public eof absy;
  public String absz;
  public String description;
  public String nQE;
  public String nQG;
  public String nQH;
  public String title;
  public int wuj;
  
  public eoh()
  {
    AppMethodBeat.i(168759);
    this.absw = new LinkedList();
    AppMethodBeat.o(168759);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(168760);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.title != null) {
        paramVarArgs.g(1, this.title);
      }
      if (this.nQG != null) {
        paramVarArgs.g(2, this.nQG);
      }
      if (this.nQH != null) {
        paramVarArgs.g(3, this.nQH);
      }
      if (this.description != null) {
        paramVarArgs.g(4, this.description);
      }
      if (this.absv != null) {
        paramVarArgs.g(9, this.absv);
      }
      paramVarArgs.e(10, 8, this.absw);
      paramVarArgs.bS(11, this.wuj);
      if (this.Kru != null) {
        paramVarArgs.g(12, this.Kru);
      }
      if (this.Krv != null) {
        paramVarArgs.g(13, this.Krv);
      }
      if (this.absx != null) {
        paramVarArgs.g(14, this.absx);
      }
      if (this.nQE != null) {
        paramVarArgs.g(15, this.nQE);
      }
      if (this.absy != null)
      {
        paramVarArgs.qD(16, this.absy.computeSize());
        this.absy.writeFields(paramVarArgs);
      }
      if (this.absz != null) {
        paramVarArgs.g(17, this.absz);
      }
      paramVarArgs.bS(18, this.absA);
      paramVarArgs.bS(19, this.absB);
      paramVarArgs.bS(20, this.absC);
      if (this.absD != null) {
        paramVarArgs.g(21, this.absD);
      }
      if (this.absE != null) {
        paramVarArgs.g(22, this.absE);
      }
      paramVarArgs.bS(100, this.aaxT);
      AppMethodBeat.o(168760);
      return 0;
    }
    if (paramInt == 1) {
      if (this.title == null) {
        break label1442;
      }
    }
    label1442:
    for (int i = i.a.a.b.b.a.h(1, this.title) + 0;; i = 0)
    {
      paramInt = i;
      if (this.nQG != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.nQG);
      }
      i = paramInt;
      if (this.nQH != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.nQH);
      }
      paramInt = i;
      if (this.description != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.description);
      }
      i = paramInt;
      if (this.absv != null) {
        i = paramInt + i.a.a.b.b.a.h(9, this.absv);
      }
      i = i + i.a.a.a.c(10, 8, this.absw) + i.a.a.b.b.a.cJ(11, this.wuj);
      paramInt = i;
      if (this.Kru != null) {
        paramInt = i + i.a.a.b.b.a.h(12, this.Kru);
      }
      i = paramInt;
      if (this.Krv != null) {
        i = paramInt + i.a.a.b.b.a.h(13, this.Krv);
      }
      paramInt = i;
      if (this.absx != null) {
        paramInt = i + i.a.a.b.b.a.h(14, this.absx);
      }
      i = paramInt;
      if (this.nQE != null) {
        i = paramInt + i.a.a.b.b.a.h(15, this.nQE);
      }
      paramInt = i;
      if (this.absy != null) {
        paramInt = i + i.a.a.a.qC(16, this.absy.computeSize());
      }
      i = paramInt;
      if (this.absz != null) {
        i = paramInt + i.a.a.b.b.a.h(17, this.absz);
      }
      i = i + i.a.a.b.b.a.cJ(18, this.absA) + i.a.a.b.b.a.cJ(19, this.absB) + i.a.a.b.b.a.cJ(20, this.absC);
      paramInt = i;
      if (this.absD != null) {
        paramInt = i + i.a.a.b.b.a.h(21, this.absD);
      }
      i = paramInt;
      if (this.absE != null) {
        i = paramInt + i.a.a.b.b.a.h(22, this.absE);
      }
      paramInt = i.a.a.b.b.a.cJ(100, this.aaxT);
      AppMethodBeat.o(168760);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.absw.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(168760);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        eoh localeoh = (eoh)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(168760);
          return -1;
        case 1: 
          localeoh.title = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(168760);
          return 0;
        case 2: 
          localeoh.nQG = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(168760);
          return 0;
        case 3: 
          localeoh.nQH = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(168760);
          return 0;
        case 4: 
          localeoh.description = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(168760);
          return 0;
        case 9: 
          localeoh.absv = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(168760);
          return 0;
        case 10: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new fim();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((fim)localObject2).parseFrom((byte[])localObject1);
            }
            localeoh.absw.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(168760);
          return 0;
        case 11: 
          localeoh.wuj = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(168760);
          return 0;
        case 12: 
          localeoh.Kru = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(168760);
          return 0;
        case 13: 
          localeoh.Krv = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(168760);
          return 0;
        case 14: 
          localeoh.absx = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(168760);
          return 0;
        case 15: 
          localeoh.nQE = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(168760);
          return 0;
        case 16: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new eof();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((eof)localObject2).parseFrom((byte[])localObject1);
            }
            localeoh.absy = ((eof)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(168760);
          return 0;
        case 17: 
          localeoh.absz = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(168760);
          return 0;
        case 18: 
          localeoh.absA = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(168760);
          return 0;
        case 19: 
          localeoh.absB = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(168760);
          return 0;
        case 20: 
          localeoh.absC = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(168760);
          return 0;
        case 21: 
          localeoh.absD = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(168760);
          return 0;
        case 22: 
          localeoh.absE = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(168760);
          return 0;
        }
        localeoh.aaxT = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(168760);
        return 0;
      }
      AppMethodBeat.o(168760);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eoh
 * JD-Core Version:    0.7.0.1
 */