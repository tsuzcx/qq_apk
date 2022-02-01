package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class cqs
  extends esc
{
  public String VAn;
  public String VAo;
  public boolean VxE;
  public String aaxb;
  public String aaxc;
  public String aaxd;
  public String aaxe;
  public String aaxf;
  public boolean aaxg;
  public String aaxh;
  public long aaxi;
  public boolean aaxj;
  public boolean aaxk;
  public boolean aaxl;
  public String aaxm;
  public String aaxn;
  public String aaxo;
  public String aaxp;
  public boolean aaxq;
  public LinkedList<String> aaxr;
  public dfd aaxs;
  public boolean aaxt;
  public boolean aaxu;
  public boolean aaxv;
  public LinkedList<emf> aaxw;
  public boolean aaxx;
  public fgr aaxy;
  public int hAV;
  public String wYI;
  
  public cqs()
  {
    AppMethodBeat.i(91509);
    this.aaxr = new LinkedList();
    this.aaxw = new LinkedList();
    AppMethodBeat.o(91509);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91510);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(91510);
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
      if (this.aaxb != null) {
        paramVarArgs.g(4, this.aaxb);
      }
      if (this.aaxc != null) {
        paramVarArgs.g(5, this.aaxc);
      }
      if (this.aaxd != null) {
        paramVarArgs.g(6, this.aaxd);
      }
      if (this.aaxe != null) {
        paramVarArgs.g(7, this.aaxe);
      }
      if (this.aaxf != null) {
        paramVarArgs.g(8, this.aaxf);
      }
      paramVarArgs.di(9, this.aaxg);
      if (this.aaxh != null) {
        paramVarArgs.g(10, this.aaxh);
      }
      paramVarArgs.bv(11, this.aaxi);
      paramVarArgs.di(12, this.aaxj);
      paramVarArgs.di(13, this.aaxk);
      paramVarArgs.di(14, this.aaxl);
      if (this.aaxm != null) {
        paramVarArgs.g(15, this.aaxm);
      }
      if (this.aaxn != null) {
        paramVarArgs.g(16, this.aaxn);
      }
      if (this.aaxo != null) {
        paramVarArgs.g(17, this.aaxo);
      }
      if (this.aaxp != null) {
        paramVarArgs.g(18, this.aaxp);
      }
      paramVarArgs.di(19, this.aaxq);
      paramVarArgs.e(20, 1, this.aaxr);
      paramVarArgs.di(21, this.VxE);
      if (this.aaxs != null)
      {
        paramVarArgs.qD(22, this.aaxs.computeSize());
        this.aaxs.writeFields(paramVarArgs);
      }
      paramVarArgs.di(23, this.aaxt);
      paramVarArgs.di(26, this.aaxu);
      paramVarArgs.di(27, this.aaxv);
      paramVarArgs.e(28, 8, this.aaxw);
      if (this.VAn != null) {
        paramVarArgs.g(29, this.VAn);
      }
      if (this.VAo != null) {
        paramVarArgs.g(30, this.VAo);
      }
      paramVarArgs.di(31, this.aaxx);
      if (this.aaxy != null)
      {
        paramVarArgs.qD(32, this.aaxy.computeSize());
        this.aaxy.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(91510);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label2102;
      }
    }
    label2102:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.hAV);
      paramInt = i;
      if (this.wYI != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.wYI);
      }
      i = paramInt;
      if (this.aaxb != null) {
        i = paramInt + i.a.a.b.b.a.h(4, this.aaxb);
      }
      paramInt = i;
      if (this.aaxc != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.aaxc);
      }
      i = paramInt;
      if (this.aaxd != null) {
        i = paramInt + i.a.a.b.b.a.h(6, this.aaxd);
      }
      paramInt = i;
      if (this.aaxe != null) {
        paramInt = i + i.a.a.b.b.a.h(7, this.aaxe);
      }
      i = paramInt;
      if (this.aaxf != null) {
        i = paramInt + i.a.a.b.b.a.h(8, this.aaxf);
      }
      i += i.a.a.b.b.a.ko(9) + 1;
      paramInt = i;
      if (this.aaxh != null) {
        paramInt = i + i.a.a.b.b.a.h(10, this.aaxh);
      }
      i = paramInt + i.a.a.b.b.a.q(11, this.aaxi) + (i.a.a.b.b.a.ko(12) + 1) + (i.a.a.b.b.a.ko(13) + 1) + (i.a.a.b.b.a.ko(14) + 1);
      paramInt = i;
      if (this.aaxm != null) {
        paramInt = i + i.a.a.b.b.a.h(15, this.aaxm);
      }
      i = paramInt;
      if (this.aaxn != null) {
        i = paramInt + i.a.a.b.b.a.h(16, this.aaxn);
      }
      paramInt = i;
      if (this.aaxo != null) {
        paramInt = i + i.a.a.b.b.a.h(17, this.aaxo);
      }
      i = paramInt;
      if (this.aaxp != null) {
        i = paramInt + i.a.a.b.b.a.h(18, this.aaxp);
      }
      i = i + (i.a.a.b.b.a.ko(19) + 1) + i.a.a.a.c(20, 1, this.aaxr) + (i.a.a.b.b.a.ko(21) + 1);
      paramInt = i;
      if (this.aaxs != null) {
        paramInt = i + i.a.a.a.qC(22, this.aaxs.computeSize());
      }
      i = paramInt + (i.a.a.b.b.a.ko(23) + 1) + (i.a.a.b.b.a.ko(26) + 1) + (i.a.a.b.b.a.ko(27) + 1) + i.a.a.a.c(28, 8, this.aaxw);
      paramInt = i;
      if (this.VAn != null) {
        paramInt = i + i.a.a.b.b.a.h(29, this.VAn);
      }
      i = paramInt;
      if (this.VAo != null) {
        i = paramInt + i.a.a.b.b.a.h(30, this.VAo);
      }
      i += i.a.a.b.b.a.ko(31) + 1;
      paramInt = i;
      if (this.aaxy != null) {
        paramInt = i + i.a.a.a.qC(32, this.aaxy.computeSize());
      }
      AppMethodBeat.o(91510);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.aaxr.clear();
        this.aaxw.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(91510);
          throw paramVarArgs;
        }
        AppMethodBeat.o(91510);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        cqs localcqs = (cqs)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        case 24: 
        case 25: 
        default: 
          AppMethodBeat.o(91510);
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
            localcqs.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91510);
          return 0;
        case 2: 
          localcqs.hAV = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(91510);
          return 0;
        case 3: 
          localcqs.wYI = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(91510);
          return 0;
        case 4: 
          localcqs.aaxb = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(91510);
          return 0;
        case 5: 
          localcqs.aaxc = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(91510);
          return 0;
        case 6: 
          localcqs.aaxd = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(91510);
          return 0;
        case 7: 
          localcqs.aaxe = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(91510);
          return 0;
        case 8: 
          localcqs.aaxf = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(91510);
          return 0;
        case 9: 
          localcqs.aaxg = ((i.a.a.a.a)localObject1).ajGk.aai();
          AppMethodBeat.o(91510);
          return 0;
        case 10: 
          localcqs.aaxh = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(91510);
          return 0;
        case 11: 
          localcqs.aaxi = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(91510);
          return 0;
        case 12: 
          localcqs.aaxj = ((i.a.a.a.a)localObject1).ajGk.aai();
          AppMethodBeat.o(91510);
          return 0;
        case 13: 
          localcqs.aaxk = ((i.a.a.a.a)localObject1).ajGk.aai();
          AppMethodBeat.o(91510);
          return 0;
        case 14: 
          localcqs.aaxl = ((i.a.a.a.a)localObject1).ajGk.aai();
          AppMethodBeat.o(91510);
          return 0;
        case 15: 
          localcqs.aaxm = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(91510);
          return 0;
        case 16: 
          localcqs.aaxn = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(91510);
          return 0;
        case 17: 
          localcqs.aaxo = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(91510);
          return 0;
        case 18: 
          localcqs.aaxp = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(91510);
          return 0;
        case 19: 
          localcqs.aaxq = ((i.a.a.a.a)localObject1).ajGk.aai();
          AppMethodBeat.o(91510);
          return 0;
        case 20: 
          localcqs.aaxr.add(((i.a.a.a.a)localObject1).ajGk.readString());
          AppMethodBeat.o(91510);
          return 0;
        case 21: 
          localcqs.VxE = ((i.a.a.a.a)localObject1).ajGk.aai();
          AppMethodBeat.o(91510);
          return 0;
        case 22: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dfd();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dfd)localObject2).parseFrom((byte[])localObject1);
            }
            localcqs.aaxs = ((dfd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91510);
          return 0;
        case 23: 
          localcqs.aaxt = ((i.a.a.a.a)localObject1).ajGk.aai();
          AppMethodBeat.o(91510);
          return 0;
        case 26: 
          localcqs.aaxu = ((i.a.a.a.a)localObject1).ajGk.aai();
          AppMethodBeat.o(91510);
          return 0;
        case 27: 
          localcqs.aaxv = ((i.a.a.a.a)localObject1).ajGk.aai();
          AppMethodBeat.o(91510);
          return 0;
        case 28: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new emf();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((emf)localObject2).parseFrom((byte[])localObject1);
            }
            localcqs.aaxw.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91510);
          return 0;
        case 29: 
          localcqs.VAn = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(91510);
          return 0;
        case 30: 
          localcqs.VAo = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(91510);
          return 0;
        case 31: 
          localcqs.aaxx = ((i.a.a.a.a)localObject1).ajGk.aai();
          AppMethodBeat.o(91510);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new fgr();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((fgr)localObject2).parseFrom((byte[])localObject1);
          }
          localcqs.aaxy = ((fgr)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(91510);
        return 0;
      }
      AppMethodBeat.o(91510);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cqs
 * JD-Core Version:    0.7.0.1
 */