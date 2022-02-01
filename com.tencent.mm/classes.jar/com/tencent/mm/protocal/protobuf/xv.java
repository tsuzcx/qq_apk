package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class xv
  extends esc
{
  public String OhN;
  public String VBL;
  public boolean ZgE;
  public String ZgF;
  public int ZgG;
  public LinkedList<Integer> ZgH;
  public String ZgI;
  public int ZgJ;
  public int ZgK;
  public eme Zgn;
  public String desc;
  public int hAV;
  public dus ign;
  public String vFa;
  public String wYI;
  public String wul;
  
  public xv()
  {
    AppMethodBeat.i(72433);
    this.ZgH = new LinkedList();
    AppMethodBeat.o(72433);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72434);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(72434);
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
      paramVarArgs.di(4, this.ZgE);
      if (this.OhN != null) {
        paramVarArgs.g(5, this.OhN);
      }
      if (this.ZgF != null) {
        paramVarArgs.g(6, this.ZgF);
      }
      if (this.vFa != null) {
        paramVarArgs.g(7, this.vFa);
      }
      paramVarArgs.bS(8, this.ZgG);
      if (this.desc != null) {
        paramVarArgs.g(9, this.desc);
      }
      if (this.VBL != null) {
        paramVarArgs.g(10, this.VBL);
      }
      paramVarArgs.e(11, 2, this.ZgH);
      if (this.ZgI != null) {
        paramVarArgs.g(12, this.ZgI);
      }
      if (this.wul != null) {
        paramVarArgs.g(13, this.wul);
      }
      paramVarArgs.bS(14, this.ZgJ);
      paramVarArgs.bS(15, this.ZgK);
      if (this.Zgn != null)
      {
        paramVarArgs.qD(16, this.Zgn.computeSize());
        this.Zgn.writeFields(paramVarArgs);
      }
      if (this.ign != null)
      {
        paramVarArgs.qD(17, this.ign.computeSize());
        this.ign.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(72434);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1379;
      }
    }
    label1379:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.hAV);
      paramInt = i;
      if (this.wYI != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.wYI);
      }
      i = paramInt + (i.a.a.b.b.a.ko(4) + 1);
      paramInt = i;
      if (this.OhN != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.OhN);
      }
      i = paramInt;
      if (this.ZgF != null) {
        i = paramInt + i.a.a.b.b.a.h(6, this.ZgF);
      }
      paramInt = i;
      if (this.vFa != null) {
        paramInt = i + i.a.a.b.b.a.h(7, this.vFa);
      }
      i = paramInt + i.a.a.b.b.a.cJ(8, this.ZgG);
      paramInt = i;
      if (this.desc != null) {
        paramInt = i + i.a.a.b.b.a.h(9, this.desc);
      }
      i = paramInt;
      if (this.VBL != null) {
        i = paramInt + i.a.a.b.b.a.h(10, this.VBL);
      }
      i += i.a.a.a.c(11, 2, this.ZgH);
      paramInt = i;
      if (this.ZgI != null) {
        paramInt = i + i.a.a.b.b.a.h(12, this.ZgI);
      }
      i = paramInt;
      if (this.wul != null) {
        i = paramInt + i.a.a.b.b.a.h(13, this.wul);
      }
      i = i + i.a.a.b.b.a.cJ(14, this.ZgJ) + i.a.a.b.b.a.cJ(15, this.ZgK);
      paramInt = i;
      if (this.Zgn != null) {
        paramInt = i + i.a.a.a.qC(16, this.Zgn.computeSize());
      }
      i = paramInt;
      if (this.ign != null) {
        i = paramInt + i.a.a.a.qC(17, this.ign.computeSize());
      }
      AppMethodBeat.o(72434);
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
          AppMethodBeat.o(72434);
          throw paramVarArgs;
        }
        AppMethodBeat.o(72434);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        xv localxv = (xv)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72434);
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
            localxv.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(72434);
          return 0;
        case 2: 
          localxv.hAV = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(72434);
          return 0;
        case 3: 
          localxv.wYI = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(72434);
          return 0;
        case 4: 
          localxv.ZgE = ((i.a.a.a.a)localObject1).ajGk.aai();
          AppMethodBeat.o(72434);
          return 0;
        case 5: 
          localxv.OhN = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(72434);
          return 0;
        case 6: 
          localxv.ZgF = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(72434);
          return 0;
        case 7: 
          localxv.vFa = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(72434);
          return 0;
        case 8: 
          localxv.ZgG = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(72434);
          return 0;
        case 9: 
          localxv.desc = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(72434);
          return 0;
        case 10: 
          localxv.VBL = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(72434);
          return 0;
        case 11: 
          localxv.ZgH.add(Integer.valueOf(((i.a.a.a.a)localObject1).ajGk.aar()));
          AppMethodBeat.o(72434);
          return 0;
        case 12: 
          localxv.ZgI = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(72434);
          return 0;
        case 13: 
          localxv.wul = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(72434);
          return 0;
        case 14: 
          localxv.ZgJ = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(72434);
          return 0;
        case 15: 
          localxv.ZgK = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(72434);
          return 0;
        case 16: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new eme();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((eme)localObject2).parseFrom((byte[])localObject1);
            }
            localxv.Zgn = ((eme)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(72434);
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
          localxv.ign = ((dus)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(72434);
        return 0;
      }
      AppMethodBeat.o(72434);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.xv
 * JD-Core Version:    0.7.0.1
 */