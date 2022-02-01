package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class oz
  extends cpx
{
  public String DQC;
  public aid DQv;
  public int DQw;
  public String EeL;
  public String EeR;
  public String EeS;
  public String EeT;
  public int EeU;
  public boolean EeV;
  public boolean EeW;
  public String EeX;
  public int EeY;
  public String EeZ;
  public int Efa;
  public int Efb;
  public String Efc;
  public String Efd;
  public int channel;
  public String iAz;
  public String nickname;
  public int scene;
  public int wJT;
  public String wKR;
  public String wLo;
  public String wLp;
  public String wLr;
  public int wLt;
  public String wLu;
  public String wLv;
  public String znE;
  public String znF;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91374);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.EeR == null)
      {
        paramVarArgs = new b("Not all required fields were included: qrcode_id");
        AppMethodBeat.o(91374);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.ln(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.wLu != null) {
        paramVarArgs.d(2, this.wLu);
      }
      if (this.EeR != null) {
        paramVarArgs.d(3, this.EeR);
      }
      paramVarArgs.aR(4, this.scene);
      if (this.EeS != null) {
        paramVarArgs.d(5, this.EeS);
      }
      if (this.wLo != null) {
        paramVarArgs.d(6, this.wLo);
      }
      paramVarArgs.aR(7, this.DQw);
      paramVarArgs.aR(8, this.channel);
      if (this.wLv != null) {
        paramVarArgs.d(9, this.wLv);
      }
      if (this.wLp != null) {
        paramVarArgs.d(10, this.wLp);
      }
      if (this.EeT != null) {
        paramVarArgs.d(11, this.EeT);
      }
      paramVarArgs.aR(12, this.EeU);
      paramVarArgs.aR(13, this.wLt);
      if (this.iAz != null) {
        paramVarArgs.d(14, this.iAz);
      }
      if (this.DQv != null)
      {
        paramVarArgs.ln(15, this.DQv.computeSize());
        this.DQv.writeFields(paramVarArgs);
      }
      if (this.EeL != null) {
        paramVarArgs.d(16, this.EeL);
      }
      paramVarArgs.aR(17, this.wJT);
      paramVarArgs.bl(18, this.EeV);
      paramVarArgs.bl(19, this.EeW);
      if (this.znE != null) {
        paramVarArgs.d(20, this.znE);
      }
      if (this.znF != null) {
        paramVarArgs.d(21, this.znF);
      }
      if (this.EeX != null) {
        paramVarArgs.d(22, this.EeX);
      }
      if (this.wLr != null) {
        paramVarArgs.d(23, this.wLr);
      }
      if (this.nickname != null) {
        paramVarArgs.d(24, this.nickname);
      }
      if (this.wKR != null) {
        paramVarArgs.d(25, this.wKR);
      }
      paramVarArgs.aR(26, this.EeY);
      if (this.EeZ != null) {
        paramVarArgs.d(27, this.EeZ);
      }
      paramVarArgs.aR(28, this.Efa);
      paramVarArgs.aR(29, this.Efb);
      if (this.DQC != null) {
        paramVarArgs.d(30, this.DQC);
      }
      if (this.Efc != null) {
        paramVarArgs.d(31, this.Efc);
      }
      if (this.Efd != null) {
        paramVarArgs.d(32, this.Efd);
      }
      AppMethodBeat.o(91374);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label2178;
      }
    }
    label2178:
    for (int i = f.a.a.a.lm(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.wLu != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.wLu);
      }
      i = paramInt;
      if (this.EeR != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.EeR);
      }
      i += f.a.a.b.b.a.bx(4, this.scene);
      paramInt = i;
      if (this.EeS != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.EeS);
      }
      i = paramInt;
      if (this.wLo != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.wLo);
      }
      i = i + f.a.a.b.b.a.bx(7, this.DQw) + f.a.a.b.b.a.bx(8, this.channel);
      paramInt = i;
      if (this.wLv != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.wLv);
      }
      i = paramInt;
      if (this.wLp != null) {
        i = paramInt + f.a.a.b.b.a.e(10, this.wLp);
      }
      paramInt = i;
      if (this.EeT != null) {
        paramInt = i + f.a.a.b.b.a.e(11, this.EeT);
      }
      i = paramInt + f.a.a.b.b.a.bx(12, this.EeU) + f.a.a.b.b.a.bx(13, this.wLt);
      paramInt = i;
      if (this.iAz != null) {
        paramInt = i + f.a.a.b.b.a.e(14, this.iAz);
      }
      i = paramInt;
      if (this.DQv != null) {
        i = paramInt + f.a.a.a.lm(15, this.DQv.computeSize());
      }
      paramInt = i;
      if (this.EeL != null) {
        paramInt = i + f.a.a.b.b.a.e(16, this.EeL);
      }
      i = paramInt + f.a.a.b.b.a.bx(17, this.wJT) + (f.a.a.b.b.a.fK(18) + 1) + (f.a.a.b.b.a.fK(19) + 1);
      paramInt = i;
      if (this.znE != null) {
        paramInt = i + f.a.a.b.b.a.e(20, this.znE);
      }
      i = paramInt;
      if (this.znF != null) {
        i = paramInt + f.a.a.b.b.a.e(21, this.znF);
      }
      paramInt = i;
      if (this.EeX != null) {
        paramInt = i + f.a.a.b.b.a.e(22, this.EeX);
      }
      i = paramInt;
      if (this.wLr != null) {
        i = paramInt + f.a.a.b.b.a.e(23, this.wLr);
      }
      paramInt = i;
      if (this.nickname != null) {
        paramInt = i + f.a.a.b.b.a.e(24, this.nickname);
      }
      i = paramInt;
      if (this.wKR != null) {
        i = paramInt + f.a.a.b.b.a.e(25, this.wKR);
      }
      i += f.a.a.b.b.a.bx(26, this.EeY);
      paramInt = i;
      if (this.EeZ != null) {
        paramInt = i + f.a.a.b.b.a.e(27, this.EeZ);
      }
      i = paramInt + f.a.a.b.b.a.bx(28, this.Efa) + f.a.a.b.b.a.bx(29, this.Efb);
      paramInt = i;
      if (this.DQC != null) {
        paramInt = i + f.a.a.b.b.a.e(30, this.DQC);
      }
      i = paramInt;
      if (this.Efc != null) {
        i = paramInt + f.a.a.b.b.a.e(31, this.Efc);
      }
      paramInt = i;
      if (this.Efd != null) {
        paramInt = i + f.a.a.b.b.a.e(32, this.Efd);
      }
      AppMethodBeat.o(91374);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cpx.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cpx.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        if (this.EeR == null)
        {
          paramVarArgs = new b("Not all required fields were included: qrcode_id");
          AppMethodBeat.o(91374);
          throw paramVarArgs;
        }
        AppMethodBeat.o(91374);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        oz localoz = (oz)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91374);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new iv();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((iv)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localoz.BaseRequest = ((iv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91374);
          return 0;
        case 2: 
          localoz.wLu = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91374);
          return 0;
        case 3: 
          localoz.EeR = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91374);
          return 0;
        case 4: 
          localoz.scene = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(91374);
          return 0;
        case 5: 
          localoz.EeS = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91374);
          return 0;
        case 6: 
          localoz.wLo = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91374);
          return 0;
        case 7: 
          localoz.DQw = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(91374);
          return 0;
        case 8: 
          localoz.channel = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(91374);
          return 0;
        case 9: 
          localoz.wLv = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91374);
          return 0;
        case 10: 
          localoz.wLp = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91374);
          return 0;
        case 11: 
          localoz.EeT = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91374);
          return 0;
        case 12: 
          localoz.EeU = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(91374);
          return 0;
        case 13: 
          localoz.wLt = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(91374);
          return 0;
        case 14: 
          localoz.iAz = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91374);
          return 0;
        case 15: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new aid();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((aid)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localoz.DQv = ((aid)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91374);
          return 0;
        case 16: 
          localoz.EeL = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91374);
          return 0;
        case 17: 
          localoz.wJT = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(91374);
          return 0;
        case 18: 
          localoz.EeV = ((f.a.a.a.a)localObject1).LVo.fZX();
          AppMethodBeat.o(91374);
          return 0;
        case 19: 
          localoz.EeW = ((f.a.a.a.a)localObject1).LVo.fZX();
          AppMethodBeat.o(91374);
          return 0;
        case 20: 
          localoz.znE = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91374);
          return 0;
        case 21: 
          localoz.znF = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91374);
          return 0;
        case 22: 
          localoz.EeX = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91374);
          return 0;
        case 23: 
          localoz.wLr = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91374);
          return 0;
        case 24: 
          localoz.nickname = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91374);
          return 0;
        case 25: 
          localoz.wKR = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91374);
          return 0;
        case 26: 
          localoz.EeY = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(91374);
          return 0;
        case 27: 
          localoz.EeZ = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91374);
          return 0;
        case 28: 
          localoz.Efa = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(91374);
          return 0;
        case 29: 
          localoz.Efb = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(91374);
          return 0;
        case 30: 
          localoz.DQC = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91374);
          return 0;
        case 31: 
          localoz.Efc = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91374);
          return 0;
        }
        localoz.Efd = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(91374);
        return 0;
      }
      AppMethodBeat.o(91374);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.oz
 * JD-Core Version:    0.7.0.1
 */