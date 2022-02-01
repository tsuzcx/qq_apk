package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class pa
  extends cqk
{
  public String DQs;
  public String DQt;
  public String DQu;
  public String EeQ;
  public String Efe;
  public cys Eff;
  public String Efg;
  public String Efh;
  public int Efi;
  public int Efj;
  public int Efk;
  public dhy Efl;
  public String Efm;
  public int Efn;
  public int Efo;
  public int Efp;
  public com.tencent.mm.bw.b Efq;
  public int Efr;
  public int Efs;
  public int Eft;
  public ot Efu;
  public dp Efv;
  public do Efw;
  public vs Efx;
  public String djr;
  public int nWx;
  public String nWy;
  public int wLb = 0;
  public String wLc;
  public String wLd;
  public String wLe;
  public String wLf;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91375);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(91375);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ln(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.nWx);
      if (this.nWy != null) {
        paramVarArgs.d(3, this.nWy);
      }
      if (this.djr != null) {
        paramVarArgs.d(4, this.djr);
      }
      if (this.Efe != null) {
        paramVarArgs.d(5, this.Efe);
      }
      if (this.Eff != null)
      {
        paramVarArgs.ln(6, this.Eff.computeSize());
        this.Eff.writeFields(paramVarArgs);
      }
      if (this.DQs != null) {
        paramVarArgs.d(7, this.DQs);
      }
      if (this.DQu != null) {
        paramVarArgs.d(8, this.DQu);
      }
      if (this.Efg != null) {
        paramVarArgs.d(9, this.Efg);
      }
      if (this.Efh != null) {
        paramVarArgs.d(10, this.Efh);
      }
      paramVarArgs.aR(11, this.Efi);
      if (this.DQt != null) {
        paramVarArgs.d(12, this.DQt);
      }
      if (this.EeQ != null) {
        paramVarArgs.d(13, this.EeQ);
      }
      paramVarArgs.aR(14, this.Efj);
      paramVarArgs.aR(15, this.Efk);
      if (this.Efl != null)
      {
        paramVarArgs.ln(16, this.Efl.computeSize());
        this.Efl.writeFields(paramVarArgs);
      }
      if (this.Efm != null) {
        paramVarArgs.d(17, this.Efm);
      }
      paramVarArgs.aR(18, this.Efn);
      paramVarArgs.aR(19, this.Efo);
      paramVarArgs.aR(20, this.Efp);
      if (this.Efq != null) {
        paramVarArgs.c(21, this.Efq);
      }
      paramVarArgs.aR(22, this.Efr);
      paramVarArgs.aR(23, this.wLb);
      if (this.wLc != null) {
        paramVarArgs.d(24, this.wLc);
      }
      if (this.wLd != null) {
        paramVarArgs.d(25, this.wLd);
      }
      paramVarArgs.aR(26, this.Efs);
      if (this.wLe != null) {
        paramVarArgs.d(27, this.wLe);
      }
      if (this.wLf != null) {
        paramVarArgs.d(28, this.wLf);
      }
      paramVarArgs.aR(29, this.Eft);
      if (this.Efu != null)
      {
        paramVarArgs.ln(30, this.Efu.computeSize());
        this.Efu.writeFields(paramVarArgs);
      }
      if (this.Efv != null)
      {
        paramVarArgs.ln(31, this.Efv.computeSize());
        this.Efv.writeFields(paramVarArgs);
      }
      if (this.Efw != null)
      {
        paramVarArgs.ln(32, this.Efw.computeSize());
        this.Efw.writeFields(paramVarArgs);
      }
      if (this.Efx != null)
      {
        paramVarArgs.ln(33, this.Efx.computeSize());
        this.Efx.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(91375);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label2714;
      }
    }
    label2714:
    for (paramInt = f.a.a.a.lm(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bx(2, this.nWx);
      paramInt = i;
      if (this.nWy != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.nWy);
      }
      i = paramInt;
      if (this.djr != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.djr);
      }
      paramInt = i;
      if (this.Efe != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.Efe);
      }
      i = paramInt;
      if (this.Eff != null) {
        i = paramInt + f.a.a.a.lm(6, this.Eff.computeSize());
      }
      paramInt = i;
      if (this.DQs != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.DQs);
      }
      i = paramInt;
      if (this.DQu != null) {
        i = paramInt + f.a.a.b.b.a.e(8, this.DQu);
      }
      paramInt = i;
      if (this.Efg != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.Efg);
      }
      i = paramInt;
      if (this.Efh != null) {
        i = paramInt + f.a.a.b.b.a.e(10, this.Efh);
      }
      i += f.a.a.b.b.a.bx(11, this.Efi);
      paramInt = i;
      if (this.DQt != null) {
        paramInt = i + f.a.a.b.b.a.e(12, this.DQt);
      }
      i = paramInt;
      if (this.EeQ != null) {
        i = paramInt + f.a.a.b.b.a.e(13, this.EeQ);
      }
      i = i + f.a.a.b.b.a.bx(14, this.Efj) + f.a.a.b.b.a.bx(15, this.Efk);
      paramInt = i;
      if (this.Efl != null) {
        paramInt = i + f.a.a.a.lm(16, this.Efl.computeSize());
      }
      i = paramInt;
      if (this.Efm != null) {
        i = paramInt + f.a.a.b.b.a.e(17, this.Efm);
      }
      i = i + f.a.a.b.b.a.bx(18, this.Efn) + f.a.a.b.b.a.bx(19, this.Efo) + f.a.a.b.b.a.bx(20, this.Efp);
      paramInt = i;
      if (this.Efq != null) {
        paramInt = i + f.a.a.b.b.a.b(21, this.Efq);
      }
      i = paramInt + f.a.a.b.b.a.bx(22, this.Efr) + f.a.a.b.b.a.bx(23, this.wLb);
      paramInt = i;
      if (this.wLc != null) {
        paramInt = i + f.a.a.b.b.a.e(24, this.wLc);
      }
      i = paramInt;
      if (this.wLd != null) {
        i = paramInt + f.a.a.b.b.a.e(25, this.wLd);
      }
      i += f.a.a.b.b.a.bx(26, this.Efs);
      paramInt = i;
      if (this.wLe != null) {
        paramInt = i + f.a.a.b.b.a.e(27, this.wLe);
      }
      i = paramInt;
      if (this.wLf != null) {
        i = paramInt + f.a.a.b.b.a.e(28, this.wLf);
      }
      i += f.a.a.b.b.a.bx(29, this.Eft);
      paramInt = i;
      if (this.Efu != null) {
        paramInt = i + f.a.a.a.lm(30, this.Efu.computeSize());
      }
      i = paramInt;
      if (this.Efv != null) {
        i = paramInt + f.a.a.a.lm(31, this.Efv.computeSize());
      }
      paramInt = i;
      if (this.Efw != null) {
        paramInt = i + f.a.a.a.lm(32, this.Efw.computeSize());
      }
      i = paramInt;
      if (this.Efx != null) {
        i = paramInt + f.a.a.a.lm(33, this.Efx.computeSize());
      }
      AppMethodBeat.o(91375);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cqk.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cqk.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new f.a.a.b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(91375);
          throw paramVarArgs;
        }
        AppMethodBeat.o(91375);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        pa localpa = (pa)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91375);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localpa.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91375);
          return 0;
        case 2: 
          localpa.nWx = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(91375);
          return 0;
        case 3: 
          localpa.nWy = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91375);
          return 0;
        case 4: 
          localpa.djr = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91375);
          return 0;
        case 5: 
          localpa.Efe = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91375);
          return 0;
        case 6: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cys();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cys)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localpa.Eff = ((cys)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91375);
          return 0;
        case 7: 
          localpa.DQs = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91375);
          return 0;
        case 8: 
          localpa.DQu = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91375);
          return 0;
        case 9: 
          localpa.Efg = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91375);
          return 0;
        case 10: 
          localpa.Efh = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91375);
          return 0;
        case 11: 
          localpa.Efi = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(91375);
          return 0;
        case 12: 
          localpa.DQt = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91375);
          return 0;
        case 13: 
          localpa.EeQ = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91375);
          return 0;
        case 14: 
          localpa.Efj = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(91375);
          return 0;
        case 15: 
          localpa.Efk = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(91375);
          return 0;
        case 16: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dhy();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dhy)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localpa.Efl = ((dhy)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91375);
          return 0;
        case 17: 
          localpa.Efm = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91375);
          return 0;
        case 18: 
          localpa.Efn = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(91375);
          return 0;
        case 19: 
          localpa.Efo = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(91375);
          return 0;
        case 20: 
          localpa.Efp = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(91375);
          return 0;
        case 21: 
          localpa.Efq = ((f.a.a.a.a)localObject1).LVo.gfk();
          AppMethodBeat.o(91375);
          return 0;
        case 22: 
          localpa.Efr = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(91375);
          return 0;
        case 23: 
          localpa.wLb = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(91375);
          return 0;
        case 24: 
          localpa.wLc = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91375);
          return 0;
        case 25: 
          localpa.wLd = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91375);
          return 0;
        case 26: 
          localpa.Efs = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(91375);
          return 0;
        case 27: 
          localpa.wLe = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91375);
          return 0;
        case 28: 
          localpa.wLf = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91375);
          return 0;
        case 29: 
          localpa.Eft = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(91375);
          return 0;
        case 30: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ot();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ot)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localpa.Efu = ((ot)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91375);
          return 0;
        case 31: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dp();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dp)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localpa.Efv = ((dp)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91375);
          return 0;
        case 32: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new do();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((do)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localpa.Efw = ((do)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91375);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new vs();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((vs)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localpa.Efx = ((vs)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91375);
        return 0;
      }
      AppMethodBeat.o(91375);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.pa
 * JD-Core Version:    0.7.0.1
 */