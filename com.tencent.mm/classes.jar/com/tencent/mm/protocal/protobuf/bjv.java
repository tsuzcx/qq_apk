package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.b;
import java.util.LinkedList;

public class bjv
  extends dyl
{
  public aqo SCW;
  public LinkedList<emr> SFB;
  public bka SJg;
  public String SJn;
  public LinkedList<cve> SPe;
  public int SUA;
  public String SUC;
  public ayv SUD;
  public int SUE;
  public long SUF;
  public LinkedList<bjx> SUG;
  public int SUv;
  public long SUw;
  public String SUx;
  public long SUy;
  public LinkedList<bku> SUz;
  public int fEH;
  public String finderUsername;
  public b lastBuffer;
  public float latitude;
  public float longitude;
  public int pullType;
  public String sessionId;
  public b tabTipsByPassInfo;
  public b xGO;
  public aqe yjp;
  
  public bjv()
  {
    AppMethodBeat.i(184211);
    this.SPe = new LinkedList();
    this.SFB = new LinkedList();
    this.SUz = new LinkedList();
    this.SUG = new LinkedList();
    AppMethodBeat.o(184211);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(169056);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.lastBuffer != null) {
        paramVarArgs.c(3, this.lastBuffer);
      }
      if (this.finderUsername != null) {
        paramVarArgs.f(4, this.finderUsername);
      }
      paramVarArgs.aY(5, this.pullType);
      if (this.yjp != null)
      {
        paramVarArgs.oE(6, this.yjp.computeSize());
        this.yjp.writeFields(paramVarArgs);
      }
      paramVarArgs.i(7, this.longitude);
      paramVarArgs.i(8, this.latitude);
      if (this.sessionId != null) {
        paramVarArgs.f(9, this.sessionId);
      }
      if (this.SCW != null)
      {
        paramVarArgs.oE(10, this.SCW.computeSize());
        this.SCW.writeFields(paramVarArgs);
      }
      paramVarArgs.e(11, 8, this.SPe);
      paramVarArgs.aY(12, this.SUv);
      paramVarArgs.aY(13, this.fEH);
      paramVarArgs.bm(14, this.SUw);
      if (this.SUx != null) {
        paramVarArgs.f(15, this.SUx);
      }
      paramVarArgs.e(16, 8, this.SFB);
      paramVarArgs.bm(17, this.SUy);
      paramVarArgs.e(18, 8, this.SUz);
      if (this.xGO != null) {
        paramVarArgs.c(19, this.xGO);
      }
      paramVarArgs.aY(20, this.SUA);
      if (this.SUC != null) {
        paramVarArgs.f(21, this.SUC);
      }
      if (this.tabTipsByPassInfo != null) {
        paramVarArgs.c(22, this.tabTipsByPassInfo);
      }
      if (this.SUD != null)
      {
        paramVarArgs.oE(23, this.SUD.computeSize());
        this.SUD.writeFields(paramVarArgs);
      }
      if (this.SJn != null) {
        paramVarArgs.f(24, this.SJn);
      }
      paramVarArgs.aY(25, this.SUE);
      if (this.SJg != null)
      {
        paramVarArgs.oE(26, this.SJg.computeSize());
        this.SJg.writeFields(paramVarArgs);
      }
      paramVarArgs.bm(27, this.SUF);
      paramVarArgs.e(28, 8, this.SUG);
      AppMethodBeat.o(169056);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label2250;
      }
    }
    label2250:
    for (int i = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.lastBuffer != null) {
        paramInt = i + g.a.a.b.b.a.b(3, this.lastBuffer);
      }
      i = paramInt;
      if (this.finderUsername != null) {
        i = paramInt + g.a.a.b.b.a.g(4, this.finderUsername);
      }
      i += g.a.a.b.b.a.bM(5, this.pullType);
      paramInt = i;
      if (this.yjp != null) {
        paramInt = i + g.a.a.a.oD(6, this.yjp.computeSize());
      }
      i = paramInt + (g.a.a.b.b.a.gL(7) + 4) + (g.a.a.b.b.a.gL(8) + 4);
      paramInt = i;
      if (this.sessionId != null) {
        paramInt = i + g.a.a.b.b.a.g(9, this.sessionId);
      }
      i = paramInt;
      if (this.SCW != null) {
        i = paramInt + g.a.a.a.oD(10, this.SCW.computeSize());
      }
      i = i + g.a.a.a.c(11, 8, this.SPe) + g.a.a.b.b.a.bM(12, this.SUv) + g.a.a.b.b.a.bM(13, this.fEH) + g.a.a.b.b.a.p(14, this.SUw);
      paramInt = i;
      if (this.SUx != null) {
        paramInt = i + g.a.a.b.b.a.g(15, this.SUx);
      }
      i = paramInt + g.a.a.a.c(16, 8, this.SFB) + g.a.a.b.b.a.p(17, this.SUy) + g.a.a.a.c(18, 8, this.SUz);
      paramInt = i;
      if (this.xGO != null) {
        paramInt = i + g.a.a.b.b.a.b(19, this.xGO);
      }
      i = paramInt + g.a.a.b.b.a.bM(20, this.SUA);
      paramInt = i;
      if (this.SUC != null) {
        paramInt = i + g.a.a.b.b.a.g(21, this.SUC);
      }
      i = paramInt;
      if (this.tabTipsByPassInfo != null) {
        i = paramInt + g.a.a.b.b.a.b(22, this.tabTipsByPassInfo);
      }
      paramInt = i;
      if (this.SUD != null) {
        paramInt = i + g.a.a.a.oD(23, this.SUD.computeSize());
      }
      i = paramInt;
      if (this.SJn != null) {
        i = paramInt + g.a.a.b.b.a.g(24, this.SJn);
      }
      i += g.a.a.b.b.a.bM(25, this.SUE);
      paramInt = i;
      if (this.SJg != null) {
        paramInt = i + g.a.a.a.oD(26, this.SJg.computeSize());
      }
      i = g.a.a.b.b.a.p(27, this.SUF);
      int j = g.a.a.a.c(28, 8, this.SUG);
      AppMethodBeat.o(169056);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.SPe.clear();
        this.SFB.clear();
        this.SUz.clear();
        this.SUG.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(169056);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        bjv localbjv = (bjv)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        case 2: 
        default: 
          AppMethodBeat.o(169056);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new jg();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((jg)localObject2).parseFrom((byte[])localObject1);
            }
            localbjv.BaseRequest = ((jg)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(169056);
          return 0;
        case 3: 
          localbjv.lastBuffer = ((g.a.a.a.a)localObject1).abFh.iUw();
          AppMethodBeat.o(169056);
          return 0;
        case 4: 
          localbjv.finderUsername = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(169056);
          return 0;
        case 5: 
          localbjv.pullType = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(169056);
          return 0;
        case 6: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new aqe();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((aqe)localObject2).parseFrom((byte[])localObject1);
            }
            localbjv.yjp = ((aqe)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(169056);
          return 0;
        case 7: 
          localbjv.longitude = Float.intBitsToFloat(((g.a.a.a.a)localObject1).abFh.AO());
          AppMethodBeat.o(169056);
          return 0;
        case 8: 
          localbjv.latitude = Float.intBitsToFloat(((g.a.a.a.a)localObject1).abFh.AO());
          AppMethodBeat.o(169056);
          return 0;
        case 9: 
          localbjv.sessionId = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(169056);
          return 0;
        case 10: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new aqo();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((aqo)localObject2).parseFrom((byte[])localObject1);
            }
            localbjv.SCW = ((aqo)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(169056);
          return 0;
        case 11: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new cve();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((cve)localObject2).parseFrom((byte[])localObject1);
            }
            localbjv.SPe.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(169056);
          return 0;
        case 12: 
          localbjv.SUv = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(169056);
          return 0;
        case 13: 
          localbjv.fEH = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(169056);
          return 0;
        case 14: 
          localbjv.SUw = ((g.a.a.a.a)localObject1).abFh.AN();
          AppMethodBeat.o(169056);
          return 0;
        case 15: 
          localbjv.SUx = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(169056);
          return 0;
        case 16: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new emr();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((emr)localObject2).parseFrom((byte[])localObject1);
            }
            localbjv.SFB.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(169056);
          return 0;
        case 17: 
          localbjv.SUy = ((g.a.a.a.a)localObject1).abFh.AN();
          AppMethodBeat.o(169056);
          return 0;
        case 18: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bku();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bku)localObject2).parseFrom((byte[])localObject1);
            }
            localbjv.SUz.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(169056);
          return 0;
        case 19: 
          localbjv.xGO = ((g.a.a.a.a)localObject1).abFh.iUw();
          AppMethodBeat.o(169056);
          return 0;
        case 20: 
          localbjv.SUA = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(169056);
          return 0;
        case 21: 
          localbjv.SUC = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(169056);
          return 0;
        case 22: 
          localbjv.tabTipsByPassInfo = ((g.a.a.a.a)localObject1).abFh.iUw();
          AppMethodBeat.o(169056);
          return 0;
        case 23: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new ayv();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((ayv)localObject2).parseFrom((byte[])localObject1);
            }
            localbjv.SUD = ((ayv)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(169056);
          return 0;
        case 24: 
          localbjv.SJn = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(169056);
          return 0;
        case 25: 
          localbjv.SUE = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(169056);
          return 0;
        case 26: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bka();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bka)localObject2).parseFrom((byte[])localObject1);
            }
            localbjv.SJg = ((bka)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(169056);
          return 0;
        case 27: 
          localbjv.SUF = ((g.a.a.a.a)localObject1).abFh.AN();
          AppMethodBeat.o(169056);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new bjx();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((bjx)localObject2).parseFrom((byte[])localObject1);
          }
          localbjv.SUG.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(169056);
        return 0;
      }
      AppMethodBeat.o(169056);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bjv
 * JD-Core Version:    0.7.0.1
 */