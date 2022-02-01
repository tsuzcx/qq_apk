package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class cew
  extends dyy
{
  public boolean Gbs;
  public LinkedList<blw> RIz;
  public LinkedList<emy> RJm;
  public fqo Srw;
  public int Sry;
  public String Tmm;
  public LinkedList<fqq> Tmn;
  public LinkedList<fqp> Tmo;
  public LinkedList<String> Tmp;
  public String Tmq;
  public String Tmr;
  public LinkedList<rz> Tms;
  public boolean Tmt;
  public LinkedList<emg> Tmu;
  public fqn Tmv;
  public String source;
  public String vhW;
  public String vhX;
  public boolean vih;
  public int voP;
  
  public cew()
  {
    AppMethodBeat.i(32279);
    this.Tmn = new LinkedList();
    this.Tmo = new LinkedList();
    this.Tmp = new LinkedList();
    this.RJm = new LinkedList();
    this.RIz = new LinkedList();
    this.Tms = new LinkedList();
    this.Tmu = new LinkedList();
    AppMethodBeat.o(32279);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32280);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(32280);
        throw paramVarArgs;
      }
      if (this.Tmm == null)
      {
        paramVarArgs = new b("Not all required fields were included: coverurl");
        AppMethodBeat.o(32280);
        throw paramVarArgs;
      }
      if (this.vhX == null)
      {
        paramVarArgs = new b("Not all required fields were included: motto");
        AppMethodBeat.o(32280);
        throw paramVarArgs;
      }
      if (this.Srw == null)
      {
        paramVarArgs = new b("Not all required fields were included: rankdesc");
        AppMethodBeat.o(32280);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.Tmm != null) {
        paramVarArgs.f(2, this.Tmm);
      }
      if (this.vhX != null) {
        paramVarArgs.f(3, this.vhX);
      }
      if (this.Srw != null)
      {
        paramVarArgs.oE(4, this.Srw.computeSize());
        this.Srw.writeFields(paramVarArgs);
      }
      paramVarArgs.e(5, 8, this.Tmn);
      paramVarArgs.e(6, 8, this.Tmo);
      if (this.source != null) {
        paramVarArgs.f(7, this.source);
      }
      paramVarArgs.e(8, 1, this.Tmp);
      if (this.Tmq != null) {
        paramVarArgs.f(9, this.Tmq);
      }
      if (this.Tmr != null) {
        paramVarArgs.f(10, this.Tmr);
      }
      paramVarArgs.e(14, 8, this.RJm);
      paramVarArgs.e(15, 8, this.RIz);
      paramVarArgs.co(16, this.vih);
      paramVarArgs.e(17, 8, this.Tms);
      paramVarArgs.co(18, this.Tmt);
      paramVarArgs.aY(19, this.voP);
      if (this.vhW != null) {
        paramVarArgs.f(20, this.vhW);
      }
      paramVarArgs.e(21, 8, this.Tmu);
      paramVarArgs.aY(22, this.Sry);
      if (this.Tmv != null)
      {
        paramVarArgs.oE(23, this.Tmv.computeSize());
        this.Tmv.writeFields(paramVarArgs);
      }
      paramVarArgs.co(24, this.Gbs);
      AppMethodBeat.o(32280);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label2143;
      }
    }
    label2143:
    for (int i = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Tmm != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.Tmm);
      }
      i = paramInt;
      if (this.vhX != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.vhX);
      }
      paramInt = i;
      if (this.Srw != null) {
        paramInt = i + g.a.a.a.oD(4, this.Srw.computeSize());
      }
      i = paramInt + g.a.a.a.c(5, 8, this.Tmn) + g.a.a.a.c(6, 8, this.Tmo);
      paramInt = i;
      if (this.source != null) {
        paramInt = i + g.a.a.b.b.a.g(7, this.source);
      }
      i = paramInt + g.a.a.a.c(8, 1, this.Tmp);
      paramInt = i;
      if (this.Tmq != null) {
        paramInt = i + g.a.a.b.b.a.g(9, this.Tmq);
      }
      i = paramInt;
      if (this.Tmr != null) {
        i = paramInt + g.a.a.b.b.a.g(10, this.Tmr);
      }
      i = i + g.a.a.a.c(14, 8, this.RJm) + g.a.a.a.c(15, 8, this.RIz) + (g.a.a.b.b.a.gL(16) + 1) + g.a.a.a.c(17, 8, this.Tms) + (g.a.a.b.b.a.gL(18) + 1) + g.a.a.b.b.a.bM(19, this.voP);
      paramInt = i;
      if (this.vhW != null) {
        paramInt = i + g.a.a.b.b.a.g(20, this.vhW);
      }
      i = paramInt + g.a.a.a.c(21, 8, this.Tmu) + g.a.a.b.b.a.bM(22, this.Sry);
      paramInt = i;
      if (this.Tmv != null) {
        paramInt = i + g.a.a.a.oD(23, this.Tmv.computeSize());
      }
      i = g.a.a.b.b.a.gL(24);
      AppMethodBeat.o(32280);
      return paramInt + (i + 1);
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Tmn.clear();
        this.Tmo.clear();
        this.Tmp.clear();
        this.RJm.clear();
        this.RIz.clear();
        this.Tms.clear();
        this.Tmu.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dyy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(32280);
          throw paramVarArgs;
        }
        if (this.Tmm == null)
        {
          paramVarArgs = new b("Not all required fields were included: coverurl");
          AppMethodBeat.o(32280);
          throw paramVarArgs;
        }
        if (this.vhX == null)
        {
          paramVarArgs = new b("Not all required fields were included: motto");
          AppMethodBeat.o(32280);
          throw paramVarArgs;
        }
        if (this.Srw == null)
        {
          paramVarArgs = new b("Not all required fields were included: rankdesc");
          AppMethodBeat.o(32280);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32280);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        cew localcew = (cew)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        case 11: 
        case 12: 
        case 13: 
        default: 
          AppMethodBeat.o(32280);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new jh();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((jh)localObject2).parseFrom((byte[])localObject1);
            }
            localcew.BaseResponse = ((jh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(32280);
          return 0;
        case 2: 
          localcew.Tmm = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(32280);
          return 0;
        case 3: 
          localcew.vhX = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(32280);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new fqo();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((fqo)localObject2).parseFrom((byte[])localObject1);
            }
            localcew.Srw = ((fqo)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(32280);
          return 0;
        case 5: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new fqq();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((fqq)localObject2).parseFrom((byte[])localObject1);
            }
            localcew.Tmn.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(32280);
          return 0;
        case 6: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new fqp();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((fqp)localObject2).parseFrom((byte[])localObject1);
            }
            localcew.Tmo.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(32280);
          return 0;
        case 7: 
          localcew.source = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(32280);
          return 0;
        case 8: 
          localcew.Tmp.add(((g.a.a.a.a)localObject1).abFh.readString());
          AppMethodBeat.o(32280);
          return 0;
        case 9: 
          localcew.Tmq = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(32280);
          return 0;
        case 10: 
          localcew.Tmr = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(32280);
          return 0;
        case 14: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new emy();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((emy)localObject2).parseFrom((byte[])localObject1);
            }
            localcew.RJm.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(32280);
          return 0;
        case 15: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new blw();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((blw)localObject2).parseFrom((byte[])localObject1);
            }
            localcew.RIz.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(32280);
          return 0;
        case 16: 
          localcew.vih = ((g.a.a.a.a)localObject1).abFh.AB();
          AppMethodBeat.o(32280);
          return 0;
        case 17: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new rz();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((rz)localObject2).parseFrom((byte[])localObject1);
            }
            localcew.Tms.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(32280);
          return 0;
        case 18: 
          localcew.Tmt = ((g.a.a.a.a)localObject1).abFh.AB();
          AppMethodBeat.o(32280);
          return 0;
        case 19: 
          localcew.voP = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(32280);
          return 0;
        case 20: 
          localcew.vhW = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(32280);
          return 0;
        case 21: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new emg();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((emg)localObject2).parseFrom((byte[])localObject1);
            }
            localcew.Tmu.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(32280);
          return 0;
        case 22: 
          localcew.Sry = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(32280);
          return 0;
        case 23: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new fqn();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((fqn)localObject2).parseFrom((byte[])localObject1);
            }
            localcew.Tmv = ((fqn)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(32280);
          return 0;
        }
        localcew.Gbs = ((g.a.a.a.a)localObject1).abFh.AB();
        AppMethodBeat.o(32280);
        return 0;
      }
      AppMethodBeat.o(32280);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cew
 * JD-Core Version:    0.7.0.1
 */