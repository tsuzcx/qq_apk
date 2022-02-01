package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class amd
  extends com.tencent.mm.bx.a
{
  public LinkedList<aly> Ztc;
  public String script;
  public int zAa;
  public int zAb;
  public int zAc;
  public int zAd;
  public String zAe;
  public String zAf;
  public String zAg;
  public String zzS;
  public int zzV;
  public int zzW;
  public int zzX;
  public int zzZ;
  
  public amd()
  {
    AppMethodBeat.i(257706);
    this.Ztc = new LinkedList();
    AppMethodBeat.o(257706);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(257712);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.zzS != null) {
        paramVarArgs.g(1, this.zzS);
      }
      paramVarArgs.bS(2, this.zzV);
      paramVarArgs.bS(3, this.zzW);
      paramVarArgs.bS(4, this.zzX);
      paramVarArgs.e(5, 8, this.Ztc);
      paramVarArgs.bS(6, this.zzZ);
      paramVarArgs.bS(7, this.zAc);
      if (this.script != null) {
        paramVarArgs.g(8, this.script);
      }
      if (this.zAf != null) {
        paramVarArgs.g(9, this.zAf);
      }
      paramVarArgs.bS(10, this.zAb);
      paramVarArgs.bS(11, this.zAa);
      if (this.zAg != null) {
        paramVarArgs.g(12, this.zAg);
      }
      paramVarArgs.bS(13, this.zAd);
      if (this.zAe != null) {
        paramVarArgs.g(14, this.zAe);
      }
      AppMethodBeat.o(257712);
      return 0;
    }
    if (paramInt == 1) {
      if (this.zzS == null) {
        break label932;
      }
    }
    label932:
    for (paramInt = i.a.a.b.b.a.h(1, this.zzS) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.zzV) + i.a.a.b.b.a.cJ(3, this.zzW) + i.a.a.b.b.a.cJ(4, this.zzX) + i.a.a.a.c(5, 8, this.Ztc) + i.a.a.b.b.a.cJ(6, this.zzZ) + i.a.a.b.b.a.cJ(7, this.zAc);
      paramInt = i;
      if (this.script != null) {
        paramInt = i + i.a.a.b.b.a.h(8, this.script);
      }
      i = paramInt;
      if (this.zAf != null) {
        i = paramInt + i.a.a.b.b.a.h(9, this.zAf);
      }
      i = i + i.a.a.b.b.a.cJ(10, this.zAb) + i.a.a.b.b.a.cJ(11, this.zAa);
      paramInt = i;
      if (this.zAg != null) {
        paramInt = i + i.a.a.b.b.a.h(12, this.zAg);
      }
      i = paramInt + i.a.a.b.b.a.cJ(13, this.zAd);
      paramInt = i;
      if (this.zAe != null) {
        paramInt = i + i.a.a.b.b.a.h(14, this.zAe);
      }
      AppMethodBeat.o(257712);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Ztc.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(257712);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        amd localamd = (amd)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(257712);
          return -1;
        case 1: 
          localamd.zzS = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(257712);
          return 0;
        case 2: 
          localamd.zzV = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(257712);
          return 0;
        case 3: 
          localamd.zzW = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(257712);
          return 0;
        case 4: 
          localamd.zzX = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(257712);
          return 0;
        case 5: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            aly localaly = new aly();
            if ((localObject != null) && (localObject.length > 0)) {
              localaly.parseFrom((byte[])localObject);
            }
            localamd.Ztc.add(localaly);
            paramInt += 1;
          }
          AppMethodBeat.o(257712);
          return 0;
        case 6: 
          localamd.zzZ = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(257712);
          return 0;
        case 7: 
          localamd.zAc = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(257712);
          return 0;
        case 8: 
          localamd.script = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(257712);
          return 0;
        case 9: 
          localamd.zAf = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(257712);
          return 0;
        case 10: 
          localamd.zAb = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(257712);
          return 0;
        case 11: 
          localamd.zAa = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(257712);
          return 0;
        case 12: 
          localamd.zAg = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(257712);
          return 0;
        case 13: 
          localamd.zAd = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(257712);
          return 0;
        }
        localamd.zAe = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(257712);
        return 0;
      }
      AppMethodBeat.o(257712);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.amd
 * JD-Core Version:    0.7.0.1
 */