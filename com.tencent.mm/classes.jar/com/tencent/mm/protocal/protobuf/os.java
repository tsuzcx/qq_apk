package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class os
  extends ckq
{
  public String CMA;
  public String CMB;
  public String CMj;
  public String CMp;
  public String CMq;
  public String CMr;
  public int CMs;
  public boolean CMt;
  public boolean CMu;
  public String CMv;
  public int CMw;
  public String CMx;
  public int CMy;
  public int CMz;
  public ahe CxZ;
  public int Cya;
  public String Cyg;
  public int channel;
  public String iaw;
  public String nickname;
  public int scene;
  public String vAM;
  public String vBj;
  public String vBk;
  public String vBm;
  public int vBo;
  public String vBp;
  public String vBq;
  public int vzO;
  public String yaF;
  public String yaG;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91374);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.CMp == null)
      {
        paramVarArgs = new b("Not all required fields were included: qrcode_id");
        AppMethodBeat.o(91374);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.kX(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.vBp != null) {
        paramVarArgs.d(2, this.vBp);
      }
      if (this.CMp != null) {
        paramVarArgs.d(3, this.CMp);
      }
      paramVarArgs.aR(4, this.scene);
      if (this.CMq != null) {
        paramVarArgs.d(5, this.CMq);
      }
      if (this.vBj != null) {
        paramVarArgs.d(6, this.vBj);
      }
      paramVarArgs.aR(7, this.Cya);
      paramVarArgs.aR(8, this.channel);
      if (this.vBq != null) {
        paramVarArgs.d(9, this.vBq);
      }
      if (this.vBk != null) {
        paramVarArgs.d(10, this.vBk);
      }
      if (this.CMr != null) {
        paramVarArgs.d(11, this.CMr);
      }
      paramVarArgs.aR(12, this.CMs);
      paramVarArgs.aR(13, this.vBo);
      if (this.iaw != null) {
        paramVarArgs.d(14, this.iaw);
      }
      if (this.CxZ != null)
      {
        paramVarArgs.kX(15, this.CxZ.computeSize());
        this.CxZ.writeFields(paramVarArgs);
      }
      if (this.CMj != null) {
        paramVarArgs.d(16, this.CMj);
      }
      paramVarArgs.aR(17, this.vzO);
      paramVarArgs.bg(18, this.CMt);
      paramVarArgs.bg(19, this.CMu);
      if (this.yaF != null) {
        paramVarArgs.d(20, this.yaF);
      }
      if (this.yaG != null) {
        paramVarArgs.d(21, this.yaG);
      }
      if (this.CMv != null) {
        paramVarArgs.d(22, this.CMv);
      }
      if (this.vBm != null) {
        paramVarArgs.d(23, this.vBm);
      }
      if (this.nickname != null) {
        paramVarArgs.d(24, this.nickname);
      }
      if (this.vAM != null) {
        paramVarArgs.d(25, this.vAM);
      }
      paramVarArgs.aR(26, this.CMw);
      if (this.CMx != null) {
        paramVarArgs.d(27, this.CMx);
      }
      paramVarArgs.aR(28, this.CMy);
      paramVarArgs.aR(29, this.CMz);
      if (this.Cyg != null) {
        paramVarArgs.d(30, this.Cyg);
      }
      if (this.CMA != null) {
        paramVarArgs.d(31, this.CMA);
      }
      if (this.CMB != null) {
        paramVarArgs.d(32, this.CMB);
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
    for (int i = f.a.a.a.kW(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.vBp != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.vBp);
      }
      i = paramInt;
      if (this.CMp != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.CMp);
      }
      i += f.a.a.b.b.a.bA(4, this.scene);
      paramInt = i;
      if (this.CMq != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.CMq);
      }
      i = paramInt;
      if (this.vBj != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.vBj);
      }
      i = i + f.a.a.b.b.a.bA(7, this.Cya) + f.a.a.b.b.a.bA(8, this.channel);
      paramInt = i;
      if (this.vBq != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.vBq);
      }
      i = paramInt;
      if (this.vBk != null) {
        i = paramInt + f.a.a.b.b.a.e(10, this.vBk);
      }
      paramInt = i;
      if (this.CMr != null) {
        paramInt = i + f.a.a.b.b.a.e(11, this.CMr);
      }
      i = paramInt + f.a.a.b.b.a.bA(12, this.CMs) + f.a.a.b.b.a.bA(13, this.vBo);
      paramInt = i;
      if (this.iaw != null) {
        paramInt = i + f.a.a.b.b.a.e(14, this.iaw);
      }
      i = paramInt;
      if (this.CxZ != null) {
        i = paramInt + f.a.a.a.kW(15, this.CxZ.computeSize());
      }
      paramInt = i;
      if (this.CMj != null) {
        paramInt = i + f.a.a.b.b.a.e(16, this.CMj);
      }
      i = paramInt + f.a.a.b.b.a.bA(17, this.vzO) + (f.a.a.b.b.a.fY(18) + 1) + (f.a.a.b.b.a.fY(19) + 1);
      paramInt = i;
      if (this.yaF != null) {
        paramInt = i + f.a.a.b.b.a.e(20, this.yaF);
      }
      i = paramInt;
      if (this.yaG != null) {
        i = paramInt + f.a.a.b.b.a.e(21, this.yaG);
      }
      paramInt = i;
      if (this.CMv != null) {
        paramInt = i + f.a.a.b.b.a.e(22, this.CMv);
      }
      i = paramInt;
      if (this.vBm != null) {
        i = paramInt + f.a.a.b.b.a.e(23, this.vBm);
      }
      paramInt = i;
      if (this.nickname != null) {
        paramInt = i + f.a.a.b.b.a.e(24, this.nickname);
      }
      i = paramInt;
      if (this.vAM != null) {
        i = paramInt + f.a.a.b.b.a.e(25, this.vAM);
      }
      i += f.a.a.b.b.a.bA(26, this.CMw);
      paramInt = i;
      if (this.CMx != null) {
        paramInt = i + f.a.a.b.b.a.e(27, this.CMx);
      }
      i = paramInt + f.a.a.b.b.a.bA(28, this.CMy) + f.a.a.b.b.a.bA(29, this.CMz);
      paramInt = i;
      if (this.Cyg != null) {
        paramInt = i + f.a.a.b.b.a.e(30, this.Cyg);
      }
      i = paramInt;
      if (this.CMA != null) {
        i = paramInt + f.a.a.b.b.a.e(31, this.CMA);
      }
      paramInt = i;
      if (this.CMB != null) {
        paramInt = i + f.a.a.b.b.a.e(32, this.CMB);
      }
      AppMethodBeat.o(91374);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = ckq.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = ckq.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        if (this.CMp == null)
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
        os localos = (os)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91374);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ip();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ip)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localos.BaseRequest = ((ip)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91374);
          return 0;
        case 2: 
          localos.vBp = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91374);
          return 0;
        case 3: 
          localos.CMp = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91374);
          return 0;
        case 4: 
          localos.scene = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(91374);
          return 0;
        case 5: 
          localos.CMq = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91374);
          return 0;
        case 6: 
          localos.vBj = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91374);
          return 0;
        case 7: 
          localos.Cya = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(91374);
          return 0;
        case 8: 
          localos.channel = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(91374);
          return 0;
        case 9: 
          localos.vBq = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91374);
          return 0;
        case 10: 
          localos.vBk = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91374);
          return 0;
        case 11: 
          localos.CMr = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91374);
          return 0;
        case 12: 
          localos.CMs = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(91374);
          return 0;
        case 13: 
          localos.vBo = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(91374);
          return 0;
        case 14: 
          localos.iaw = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91374);
          return 0;
        case 15: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ahe();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ahe)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localos.CxZ = ((ahe)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91374);
          return 0;
        case 16: 
          localos.CMj = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91374);
          return 0;
        case 17: 
          localos.vzO = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(91374);
          return 0;
        case 18: 
          localos.CMt = ((f.a.a.a.a)localObject1).KhF.fHu();
          AppMethodBeat.o(91374);
          return 0;
        case 19: 
          localos.CMu = ((f.a.a.a.a)localObject1).KhF.fHu();
          AppMethodBeat.o(91374);
          return 0;
        case 20: 
          localos.yaF = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91374);
          return 0;
        case 21: 
          localos.yaG = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91374);
          return 0;
        case 22: 
          localos.CMv = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91374);
          return 0;
        case 23: 
          localos.vBm = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91374);
          return 0;
        case 24: 
          localos.nickname = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91374);
          return 0;
        case 25: 
          localos.vAM = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91374);
          return 0;
        case 26: 
          localos.CMw = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(91374);
          return 0;
        case 27: 
          localos.CMx = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91374);
          return 0;
        case 28: 
          localos.CMy = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(91374);
          return 0;
        case 29: 
          localos.CMz = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(91374);
          return 0;
        case 30: 
          localos.Cyg = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91374);
          return 0;
        case 31: 
          localos.CMA = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91374);
          return 0;
        }
        localos.CMB = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(91374);
        return 0;
      }
      AppMethodBeat.o(91374);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.os
 * JD-Core Version:    0.7.0.1
 */