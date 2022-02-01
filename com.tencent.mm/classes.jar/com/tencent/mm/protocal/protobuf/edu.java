package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class edu
  extends com.tencent.mm.bw.a
{
  public int Mpa;
  public long MsZ;
  public int Mtd;
  public int Nee;
  public eds Nef;
  public String Neg;
  public boolean Neh;
  public LinkedList<String> Nei;
  public int ibG;
  public String izX;
  public String md5;
  
  public edu()
  {
    AppMethodBeat.i(201797);
    this.Nei = new LinkedList();
    AppMethodBeat.o(201797);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(118455);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.izX != null) {
        paramVarArgs.e(1, this.izX);
      }
      paramVarArgs.aM(2, this.ibG);
      paramVarArgs.bb(3, this.MsZ);
      paramVarArgs.aM(4, this.Mtd);
      if (this.md5 != null) {
        paramVarArgs.e(5, this.md5);
      }
      paramVarArgs.aM(6, this.Mpa);
      paramVarArgs.aM(7, this.Nee);
      if (this.Nef != null)
      {
        paramVarArgs.ni(8, this.Nef.computeSize());
        this.Nef.writeFields(paramVarArgs);
      }
      if (this.Neg != null) {
        paramVarArgs.e(9, this.Neg);
      }
      paramVarArgs.cc(10, this.Neh);
      paramVarArgs.e(11, 1, this.Nei);
      AppMethodBeat.o(118455);
      return 0;
    }
    if (paramInt == 1) {
      if (this.izX == null) {
        break label818;
      }
    }
    label818:
    for (paramInt = g.a.a.b.b.a.f(1, this.izX) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bu(2, this.ibG) + g.a.a.b.b.a.r(3, this.MsZ) + g.a.a.b.b.a.bu(4, this.Mtd);
      paramInt = i;
      if (this.md5 != null) {
        paramInt = i + g.a.a.b.b.a.f(5, this.md5);
      }
      i = paramInt + g.a.a.b.b.a.bu(6, this.Mpa) + g.a.a.b.b.a.bu(7, this.Nee);
      paramInt = i;
      if (this.Nef != null) {
        paramInt = i + g.a.a.a.nh(8, this.Nef.computeSize());
      }
      i = paramInt;
      if (this.Neg != null) {
        i = paramInt + g.a.a.b.b.a.f(9, this.Neg);
      }
      paramInt = g.a.a.b.b.a.fS(10);
      int j = g.a.a.a.c(11, 1, this.Nei);
      AppMethodBeat.o(118455);
      return i + (paramInt + 1) + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Nei.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(118455);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        edu localedu = (edu)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(118455);
          return -1;
        case 1: 
          localedu.izX = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(118455);
          return 0;
        case 2: 
          localedu.ibG = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(118455);
          return 0;
        case 3: 
          localedu.MsZ = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(118455);
          return 0;
        case 4: 
          localedu.Mtd = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(118455);
          return 0;
        case 5: 
          localedu.md5 = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(118455);
          return 0;
        case 6: 
          localedu.Mpa = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(118455);
          return 0;
        case 7: 
          localedu.Nee = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(118455);
          return 0;
        case 8: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new eds();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((eds)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localedu.Nef = ((eds)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(118455);
          return 0;
        case 9: 
          localedu.Neg = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(118455);
          return 0;
        case 10: 
          localedu.Neh = ((g.a.a.a.a)localObject1).UbS.yZ();
          AppMethodBeat.o(118455);
          return 0;
        }
        localedu.Nei.add(((g.a.a.a.a)localObject1).UbS.readString());
        AppMethodBeat.o(118455);
        return 0;
      }
      AppMethodBeat.o(118455);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.edu
 * JD-Core Version:    0.7.0.1
 */