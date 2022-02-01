package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class bcx
  extends cqk
{
  public boolean Bov;
  public String Bri;
  public String Brj;
  public String ESR;
  public String ESS;
  public String EST;
  public String ESU;
  public String ESV;
  public boolean ESW;
  public String ESX;
  public long ESY;
  public boolean ESZ;
  public boolean ETa;
  public boolean ETb;
  public String ETc;
  public String ETd;
  public String ETe;
  public String ETf;
  public boolean ETg;
  public LinkedList<String> ETh;
  public bno ETi;
  public boolean ETj;
  public boolean ETk;
  public boolean ETl;
  public LinkedList<cmb> ETm;
  public boolean ETn;
  public int dae;
  public String oxf;
  
  public bcx()
  {
    AppMethodBeat.i(91509);
    this.ETh = new LinkedList();
    this.ETm = new LinkedList();
    AppMethodBeat.o(91509);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91510);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(91510);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ln(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.dae);
      if (this.oxf != null) {
        paramVarArgs.d(3, this.oxf);
      }
      if (this.ESR != null) {
        paramVarArgs.d(4, this.ESR);
      }
      if (this.ESS != null) {
        paramVarArgs.d(5, this.ESS);
      }
      if (this.EST != null) {
        paramVarArgs.d(6, this.EST);
      }
      if (this.ESU != null) {
        paramVarArgs.d(7, this.ESU);
      }
      if (this.ESV != null) {
        paramVarArgs.d(8, this.ESV);
      }
      paramVarArgs.bl(9, this.ESW);
      if (this.ESX != null) {
        paramVarArgs.d(10, this.ESX);
      }
      paramVarArgs.aO(11, this.ESY);
      paramVarArgs.bl(12, this.ESZ);
      paramVarArgs.bl(13, this.ETa);
      paramVarArgs.bl(14, this.ETb);
      if (this.ETc != null) {
        paramVarArgs.d(15, this.ETc);
      }
      if (this.ETd != null) {
        paramVarArgs.d(16, this.ETd);
      }
      if (this.ETe != null) {
        paramVarArgs.d(17, this.ETe);
      }
      if (this.ETf != null) {
        paramVarArgs.d(18, this.ETf);
      }
      paramVarArgs.bl(19, this.ETg);
      paramVarArgs.e(20, 1, this.ETh);
      paramVarArgs.bl(21, this.Bov);
      if (this.ETi != null)
      {
        paramVarArgs.ln(22, this.ETi.computeSize());
        this.ETi.writeFields(paramVarArgs);
      }
      paramVarArgs.bl(23, this.ETj);
      paramVarArgs.bl(26, this.ETk);
      paramVarArgs.bl(27, this.ETl);
      paramVarArgs.e(28, 8, this.ETm);
      if (this.Bri != null) {
        paramVarArgs.d(29, this.Bri);
      }
      if (this.Brj != null) {
        paramVarArgs.d(30, this.Brj);
      }
      paramVarArgs.bl(31, this.ETn);
      AppMethodBeat.o(91510);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label2038;
      }
    }
    label2038:
    for (paramInt = f.a.a.a.lm(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bx(2, this.dae);
      paramInt = i;
      if (this.oxf != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.oxf);
      }
      i = paramInt;
      if (this.ESR != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.ESR);
      }
      paramInt = i;
      if (this.ESS != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.ESS);
      }
      i = paramInt;
      if (this.EST != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.EST);
      }
      paramInt = i;
      if (this.ESU != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.ESU);
      }
      i = paramInt;
      if (this.ESV != null) {
        i = paramInt + f.a.a.b.b.a.e(8, this.ESV);
      }
      i += f.a.a.b.b.a.fK(9) + 1;
      paramInt = i;
      if (this.ESX != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.ESX);
      }
      i = paramInt + f.a.a.b.b.a.p(11, this.ESY) + (f.a.a.b.b.a.fK(12) + 1) + (f.a.a.b.b.a.fK(13) + 1) + (f.a.a.b.b.a.fK(14) + 1);
      paramInt = i;
      if (this.ETc != null) {
        paramInt = i + f.a.a.b.b.a.e(15, this.ETc);
      }
      i = paramInt;
      if (this.ETd != null) {
        i = paramInt + f.a.a.b.b.a.e(16, this.ETd);
      }
      paramInt = i;
      if (this.ETe != null) {
        paramInt = i + f.a.a.b.b.a.e(17, this.ETe);
      }
      i = paramInt;
      if (this.ETf != null) {
        i = paramInt + f.a.a.b.b.a.e(18, this.ETf);
      }
      i = i + (f.a.a.b.b.a.fK(19) + 1) + f.a.a.a.c(20, 1, this.ETh) + (f.a.a.b.b.a.fK(21) + 1);
      paramInt = i;
      if (this.ETi != null) {
        paramInt = i + f.a.a.a.lm(22, this.ETi.computeSize());
      }
      i = paramInt + (f.a.a.b.b.a.fK(23) + 1) + (f.a.a.b.b.a.fK(26) + 1) + (f.a.a.b.b.a.fK(27) + 1) + f.a.a.a.c(28, 8, this.ETm);
      paramInt = i;
      if (this.Bri != null) {
        paramInt = i + f.a.a.b.b.a.e(29, this.Bri);
      }
      i = paramInt;
      if (this.Brj != null) {
        i = paramInt + f.a.a.b.b.a.e(30, this.Brj);
      }
      paramInt = f.a.a.b.b.a.fK(31);
      AppMethodBeat.o(91510);
      return i + (paramInt + 1);
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.ETh.clear();
        this.ETm.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cqk.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cqk.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
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
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bcx localbcx = (bcx)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        case 24: 
        case 25: 
        default: 
          AppMethodBeat.o(91510);
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
            localbcx.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91510);
          return 0;
        case 2: 
          localbcx.dae = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(91510);
          return 0;
        case 3: 
          localbcx.oxf = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91510);
          return 0;
        case 4: 
          localbcx.ESR = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91510);
          return 0;
        case 5: 
          localbcx.ESS = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91510);
          return 0;
        case 6: 
          localbcx.EST = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91510);
          return 0;
        case 7: 
          localbcx.ESU = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91510);
          return 0;
        case 8: 
          localbcx.ESV = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91510);
          return 0;
        case 9: 
          localbcx.ESW = ((f.a.a.a.a)localObject1).LVo.fZX();
          AppMethodBeat.o(91510);
          return 0;
        case 10: 
          localbcx.ESX = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91510);
          return 0;
        case 11: 
          localbcx.ESY = ((f.a.a.a.a)localObject1).LVo.xG();
          AppMethodBeat.o(91510);
          return 0;
        case 12: 
          localbcx.ESZ = ((f.a.a.a.a)localObject1).LVo.fZX();
          AppMethodBeat.o(91510);
          return 0;
        case 13: 
          localbcx.ETa = ((f.a.a.a.a)localObject1).LVo.fZX();
          AppMethodBeat.o(91510);
          return 0;
        case 14: 
          localbcx.ETb = ((f.a.a.a.a)localObject1).LVo.fZX();
          AppMethodBeat.o(91510);
          return 0;
        case 15: 
          localbcx.ETc = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91510);
          return 0;
        case 16: 
          localbcx.ETd = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91510);
          return 0;
        case 17: 
          localbcx.ETe = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91510);
          return 0;
        case 18: 
          localbcx.ETf = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91510);
          return 0;
        case 19: 
          localbcx.ETg = ((f.a.a.a.a)localObject1).LVo.fZX();
          AppMethodBeat.o(91510);
          return 0;
        case 20: 
          localbcx.ETh.add(((f.a.a.a.a)localObject1).LVo.readString());
          AppMethodBeat.o(91510);
          return 0;
        case 21: 
          localbcx.Bov = ((f.a.a.a.a)localObject1).LVo.fZX();
          AppMethodBeat.o(91510);
          return 0;
        case 22: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bno();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bno)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbcx.ETi = ((bno)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91510);
          return 0;
        case 23: 
          localbcx.ETj = ((f.a.a.a.a)localObject1).LVo.fZX();
          AppMethodBeat.o(91510);
          return 0;
        case 26: 
          localbcx.ETk = ((f.a.a.a.a)localObject1).LVo.fZX();
          AppMethodBeat.o(91510);
          return 0;
        case 27: 
          localbcx.ETl = ((f.a.a.a.a)localObject1).LVo.fZX();
          AppMethodBeat.o(91510);
          return 0;
        case 28: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cmb();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cmb)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbcx.ETm.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91510);
          return 0;
        case 29: 
          localbcx.Bri = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91510);
          return 0;
        case 30: 
          localbcx.Brj = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91510);
          return 0;
        }
        localbcx.ETn = ((f.a.a.a.a)localObject1).LVo.fZX();
        AppMethodBeat.o(91510);
        return 0;
      }
      AppMethodBeat.o(91510);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bcx
 * JD-Core Version:    0.7.0.1
 */