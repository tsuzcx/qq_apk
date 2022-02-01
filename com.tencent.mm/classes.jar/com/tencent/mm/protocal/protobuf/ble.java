package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ble
  extends dyy
{
  public int Apz;
  public int Atf;
  public String OAl;
  public FinderContact SDj;
  public LinkedList<axc> SID;
  public int SIE;
  public long SIF;
  public String SVZ;
  public String SWa;
  public String SWb;
  public int SWc;
  public int SWd;
  public afc SWe;
  public int SWf;
  public int SWg;
  public bln SWh;
  public int SWi;
  public dnb SWj;
  public int SWk;
  public String SWl;
  public String SWm;
  public av SWn;
  public int SWo;
  public String SWp;
  public egt SWq;
  public blc SWr;
  public dt SWs;
  public int actionType;
  public int foreign_user_flag;
  public int logout_lock;
  public String logout_url;
  public bfm verifyInfo;
  public bln wxaShopInfo;
  public int zqt;
  
  public ble()
  {
    AppMethodBeat.i(199968);
    this.SID = new LinkedList();
    AppMethodBeat.o(199968);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(169074);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(2, this.actionType);
      if (this.verifyInfo != null)
      {
        paramVarArgs.oE(3, this.verifyInfo.computeSize());
        this.verifyInfo.writeFields(paramVarArgs);
      }
      if (this.SDj != null)
      {
        paramVarArgs.oE(4, this.SDj.computeSize());
        this.SDj.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(5, this.zqt);
      if (this.SVZ != null) {
        paramVarArgs.f(6, this.SVZ);
      }
      if (this.SWa != null) {
        paramVarArgs.f(7, this.SWa);
      }
      if (this.SWb != null) {
        paramVarArgs.f(8, this.SWb);
      }
      paramVarArgs.aY(9, this.SWc);
      paramVarArgs.aY(10, this.Atf);
      paramVarArgs.aY(11, this.SWd);
      paramVarArgs.aY(12, this.Apz);
      if (this.SWe != null)
      {
        paramVarArgs.oE(13, this.SWe.computeSize());
        this.SWe.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(14, this.SWf);
      paramVarArgs.aY(15, this.SWg);
      if (this.OAl != null) {
        paramVarArgs.f(16, this.OAl);
      }
      if (this.SWh != null)
      {
        paramVarArgs.oE(17, this.SWh.computeSize());
        this.SWh.writeFields(paramVarArgs);
      }
      if (this.wxaShopInfo != null)
      {
        paramVarArgs.oE(18, this.wxaShopInfo.computeSize());
        this.wxaShopInfo.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(19, this.SWi);
      if (this.SWj != null)
      {
        paramVarArgs.oE(21, this.SWj.computeSize());
        this.SWj.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(22, this.SWk);
      if (this.SWl != null) {
        paramVarArgs.f(23, this.SWl);
      }
      paramVarArgs.aY(24, this.foreign_user_flag);
      if (this.SWm != null) {
        paramVarArgs.f(25, this.SWm);
      }
      if (this.SWn != null)
      {
        paramVarArgs.oE(26, this.SWn.computeSize());
        this.SWn.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(27, this.logout_lock);
      if (this.logout_url != null) {
        paramVarArgs.f(28, this.logout_url);
      }
      paramVarArgs.e(29, 8, this.SID);
      paramVarArgs.aY(30, this.SIE);
      paramVarArgs.bm(31, this.SIF);
      paramVarArgs.aY(32, this.SWo);
      if (this.SWp != null) {
        paramVarArgs.f(33, this.SWp);
      }
      if (this.SWq != null)
      {
        paramVarArgs.oE(35, this.SWq.computeSize());
        this.SWq.writeFields(paramVarArgs);
      }
      if (this.SWr != null)
      {
        paramVarArgs.oE(36, this.SWr.computeSize());
        this.SWr.writeFields(paramVarArgs);
      }
      if (this.SWs != null)
      {
        paramVarArgs.oE(37, this.SWs.computeSize());
        this.SWs.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(169074);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label2922;
      }
    }
    label2922:
    for (paramInt = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.actionType);
      paramInt = i;
      if (this.verifyInfo != null) {
        paramInt = i + g.a.a.a.oD(3, this.verifyInfo.computeSize());
      }
      i = paramInt;
      if (this.SDj != null) {
        i = paramInt + g.a.a.a.oD(4, this.SDj.computeSize());
      }
      i += g.a.a.b.b.a.bM(5, this.zqt);
      paramInt = i;
      if (this.SVZ != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.SVZ);
      }
      i = paramInt;
      if (this.SWa != null) {
        i = paramInt + g.a.a.b.b.a.g(7, this.SWa);
      }
      paramInt = i;
      if (this.SWb != null) {
        paramInt = i + g.a.a.b.b.a.g(8, this.SWb);
      }
      i = paramInt + g.a.a.b.b.a.bM(9, this.SWc) + g.a.a.b.b.a.bM(10, this.Atf) + g.a.a.b.b.a.bM(11, this.SWd) + g.a.a.b.b.a.bM(12, this.Apz);
      paramInt = i;
      if (this.SWe != null) {
        paramInt = i + g.a.a.a.oD(13, this.SWe.computeSize());
      }
      i = paramInt + g.a.a.b.b.a.bM(14, this.SWf) + g.a.a.b.b.a.bM(15, this.SWg);
      paramInt = i;
      if (this.OAl != null) {
        paramInt = i + g.a.a.b.b.a.g(16, this.OAl);
      }
      i = paramInt;
      if (this.SWh != null) {
        i = paramInt + g.a.a.a.oD(17, this.SWh.computeSize());
      }
      paramInt = i;
      if (this.wxaShopInfo != null) {
        paramInt = i + g.a.a.a.oD(18, this.wxaShopInfo.computeSize());
      }
      i = paramInt + g.a.a.b.b.a.bM(19, this.SWi);
      paramInt = i;
      if (this.SWj != null) {
        paramInt = i + g.a.a.a.oD(21, this.SWj.computeSize());
      }
      i = paramInt + g.a.a.b.b.a.bM(22, this.SWk);
      paramInt = i;
      if (this.SWl != null) {
        paramInt = i + g.a.a.b.b.a.g(23, this.SWl);
      }
      i = paramInt + g.a.a.b.b.a.bM(24, this.foreign_user_flag);
      paramInt = i;
      if (this.SWm != null) {
        paramInt = i + g.a.a.b.b.a.g(25, this.SWm);
      }
      i = paramInt;
      if (this.SWn != null) {
        i = paramInt + g.a.a.a.oD(26, this.SWn.computeSize());
      }
      i += g.a.a.b.b.a.bM(27, this.logout_lock);
      paramInt = i;
      if (this.logout_url != null) {
        paramInt = i + g.a.a.b.b.a.g(28, this.logout_url);
      }
      i = paramInt + g.a.a.a.c(29, 8, this.SID) + g.a.a.b.b.a.bM(30, this.SIE) + g.a.a.b.b.a.p(31, this.SIF) + g.a.a.b.b.a.bM(32, this.SWo);
      paramInt = i;
      if (this.SWp != null) {
        paramInt = i + g.a.a.b.b.a.g(33, this.SWp);
      }
      i = paramInt;
      if (this.SWq != null) {
        i = paramInt + g.a.a.a.oD(35, this.SWq.computeSize());
      }
      paramInt = i;
      if (this.SWr != null) {
        paramInt = i + g.a.a.a.oD(36, this.SWr.computeSize());
      }
      i = paramInt;
      if (this.SWs != null) {
        i = paramInt + g.a.a.a.oD(37, this.SWs.computeSize());
      }
      AppMethodBeat.o(169074);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.SID.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dyy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(169074);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        ble localble = (ble)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        case 20: 
        case 34: 
        default: 
          AppMethodBeat.o(169074);
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
            localble.BaseResponse = ((jh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(169074);
          return 0;
        case 2: 
          localble.actionType = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(169074);
          return 0;
        case 3: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bfm();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bfm)localObject2).parseFrom((byte[])localObject1);
            }
            localble.verifyInfo = ((bfm)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(169074);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new FinderContact();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((FinderContact)localObject2).parseFrom((byte[])localObject1);
            }
            localble.SDj = ((FinderContact)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(169074);
          return 0;
        case 5: 
          localble.zqt = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(169074);
          return 0;
        case 6: 
          localble.SVZ = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(169074);
          return 0;
        case 7: 
          localble.SWa = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(169074);
          return 0;
        case 8: 
          localble.SWb = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(169074);
          return 0;
        case 9: 
          localble.SWc = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(169074);
          return 0;
        case 10: 
          localble.Atf = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(169074);
          return 0;
        case 11: 
          localble.SWd = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(169074);
          return 0;
        case 12: 
          localble.Apz = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(169074);
          return 0;
        case 13: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new afc();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((afc)localObject2).parseFrom((byte[])localObject1);
            }
            localble.SWe = ((afc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(169074);
          return 0;
        case 14: 
          localble.SWf = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(169074);
          return 0;
        case 15: 
          localble.SWg = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(169074);
          return 0;
        case 16: 
          localble.OAl = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(169074);
          return 0;
        case 17: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bln();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bln)localObject2).parseFrom((byte[])localObject1);
            }
            localble.SWh = ((bln)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(169074);
          return 0;
        case 18: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bln();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bln)localObject2).parseFrom((byte[])localObject1);
            }
            localble.wxaShopInfo = ((bln)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(169074);
          return 0;
        case 19: 
          localble.SWi = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(169074);
          return 0;
        case 21: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dnb();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dnb)localObject2).parseFrom((byte[])localObject1);
            }
            localble.SWj = ((dnb)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(169074);
          return 0;
        case 22: 
          localble.SWk = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(169074);
          return 0;
        case 23: 
          localble.SWl = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(169074);
          return 0;
        case 24: 
          localble.foreign_user_flag = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(169074);
          return 0;
        case 25: 
          localble.SWm = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(169074);
          return 0;
        case 26: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new av();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((av)localObject2).parseFrom((byte[])localObject1);
            }
            localble.SWn = ((av)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(169074);
          return 0;
        case 27: 
          localble.logout_lock = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(169074);
          return 0;
        case 28: 
          localble.logout_url = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(169074);
          return 0;
        case 29: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new axc();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((axc)localObject2).parseFrom((byte[])localObject1);
            }
            localble.SID.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(169074);
          return 0;
        case 30: 
          localble.SIE = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(169074);
          return 0;
        case 31: 
          localble.SIF = ((g.a.a.a.a)localObject1).abFh.AN();
          AppMethodBeat.o(169074);
          return 0;
        case 32: 
          localble.SWo = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(169074);
          return 0;
        case 33: 
          localble.SWp = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(169074);
          return 0;
        case 35: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new egt();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((egt)localObject2).parseFrom((byte[])localObject1);
            }
            localble.SWq = ((egt)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(169074);
          return 0;
        case 36: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new blc();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((blc)localObject2).parseFrom((byte[])localObject1);
            }
            localble.SWr = ((blc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(169074);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new dt();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((dt)localObject2).parseFrom((byte[])localObject1);
          }
          localble.SWs = ((dt)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(169074);
        return 0;
      }
      AppMethodBeat.o(169074);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ble
 * JD-Core Version:    0.7.0.1
 */