package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import java.util.LinkedList;

public final class bp
  extends cpx
{
  public String DOA;
  public long DOB;
  public cb DOC;
  public int DOD;
  public int DOE;
  public String DOF;
  public int DOG;
  public b DOH;
  public b DOI;
  public long DOJ;
  public String DOK;
  public int DOL;
  public int DOM;
  public int DON;
  public String DOw;
  public String DOx;
  public int DOz;
  public String bssid;
  public int dbL;
  public String imei;
  public int scene;
  public String ssid;
  public String xJJ;
  public String zmu;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125693);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ln(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.xJJ != null) {
        paramVarArgs.d(2, this.xJJ);
      }
      paramVarArgs.aR(3, this.DOz);
      if (this.DOA != null) {
        paramVarArgs.d(4, this.DOA);
      }
      paramVarArgs.aR(5, this.scene);
      if (this.ssid != null) {
        paramVarArgs.d(6, this.ssid);
      }
      if (this.bssid != null) {
        paramVarArgs.d(7, this.bssid);
      }
      paramVarArgs.aO(8, this.DOB);
      if (this.DOC != null)
      {
        paramVarArgs.ln(9, this.DOC.computeSize());
        this.DOC.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(10, this.DOD);
      paramVarArgs.aR(11, this.DOE);
      paramVarArgs.aR(12, this.dbL);
      if (this.DOF != null) {
        paramVarArgs.d(13, this.DOF);
      }
      paramVarArgs.aR(14, this.DOG);
      if (this.DOH != null) {
        paramVarArgs.c(15, this.DOH);
      }
      if (this.DOI != null) {
        paramVarArgs.c(16, this.DOI);
      }
      paramVarArgs.aO(17, this.DOJ);
      if (this.DOw != null) {
        paramVarArgs.d(18, this.DOw);
      }
      if (this.zmu != null) {
        paramVarArgs.d(19, this.zmu);
      }
      if (this.DOK != null) {
        paramVarArgs.d(20, this.DOK);
      }
      paramVarArgs.aR(21, this.DOL);
      paramVarArgs.aR(22, this.DOM);
      paramVarArgs.aR(23, this.DON);
      if (this.imei != null) {
        paramVarArgs.d(24, this.imei);
      }
      if (this.DOx != null) {
        paramVarArgs.d(25, this.DOx);
      }
      AppMethodBeat.o(125693);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1702;
      }
    }
    label1702:
    for (paramInt = f.a.a.a.lm(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.xJJ != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.xJJ);
      }
      i += f.a.a.b.b.a.bx(3, this.DOz);
      paramInt = i;
      if (this.DOA != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.DOA);
      }
      i = paramInt + f.a.a.b.b.a.bx(5, this.scene);
      paramInt = i;
      if (this.ssid != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.ssid);
      }
      i = paramInt;
      if (this.bssid != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.bssid);
      }
      i += f.a.a.b.b.a.p(8, this.DOB);
      paramInt = i;
      if (this.DOC != null) {
        paramInt = i + f.a.a.a.lm(9, this.DOC.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bx(10, this.DOD) + f.a.a.b.b.a.bx(11, this.DOE) + f.a.a.b.b.a.bx(12, this.dbL);
      paramInt = i;
      if (this.DOF != null) {
        paramInt = i + f.a.a.b.b.a.e(13, this.DOF);
      }
      i = paramInt + f.a.a.b.b.a.bx(14, this.DOG);
      paramInt = i;
      if (this.DOH != null) {
        paramInt = i + f.a.a.b.b.a.b(15, this.DOH);
      }
      i = paramInt;
      if (this.DOI != null) {
        i = paramInt + f.a.a.b.b.a.b(16, this.DOI);
      }
      i += f.a.a.b.b.a.p(17, this.DOJ);
      paramInt = i;
      if (this.DOw != null) {
        paramInt = i + f.a.a.b.b.a.e(18, this.DOw);
      }
      i = paramInt;
      if (this.zmu != null) {
        i = paramInt + f.a.a.b.b.a.e(19, this.zmu);
      }
      paramInt = i;
      if (this.DOK != null) {
        paramInt = i + f.a.a.b.b.a.e(20, this.DOK);
      }
      i = paramInt + f.a.a.b.b.a.bx(21, this.DOL) + f.a.a.b.b.a.bx(22, this.DOM) + f.a.a.b.b.a.bx(23, this.DON);
      paramInt = i;
      if (this.imei != null) {
        paramInt = i + f.a.a.b.b.a.e(24, this.imei);
      }
      i = paramInt;
      if (this.DOx != null) {
        i = paramInt + f.a.a.b.b.a.e(25, this.DOx);
      }
      AppMethodBeat.o(125693);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cpx.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cpx.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(125693);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bp localbp = (bp)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(125693);
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
            localbp.BaseRequest = ((iv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125693);
          return 0;
        case 2: 
          localbp.xJJ = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(125693);
          return 0;
        case 3: 
          localbp.DOz = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(125693);
          return 0;
        case 4: 
          localbp.DOA = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(125693);
          return 0;
        case 5: 
          localbp.scene = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(125693);
          return 0;
        case 6: 
          localbp.ssid = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(125693);
          return 0;
        case 7: 
          localbp.bssid = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(125693);
          return 0;
        case 8: 
          localbp.DOB = ((f.a.a.a.a)localObject1).LVo.xG();
          AppMethodBeat.o(125693);
          return 0;
        case 9: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cb();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cb)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbp.DOC = ((cb)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125693);
          return 0;
        case 10: 
          localbp.DOD = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(125693);
          return 0;
        case 11: 
          localbp.DOE = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(125693);
          return 0;
        case 12: 
          localbp.dbL = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(125693);
          return 0;
        case 13: 
          localbp.DOF = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(125693);
          return 0;
        case 14: 
          localbp.DOG = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(125693);
          return 0;
        case 15: 
          localbp.DOH = ((f.a.a.a.a)localObject1).LVo.gfk();
          AppMethodBeat.o(125693);
          return 0;
        case 16: 
          localbp.DOI = ((f.a.a.a.a)localObject1).LVo.gfk();
          AppMethodBeat.o(125693);
          return 0;
        case 17: 
          localbp.DOJ = ((f.a.a.a.a)localObject1).LVo.xG();
          AppMethodBeat.o(125693);
          return 0;
        case 18: 
          localbp.DOw = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(125693);
          return 0;
        case 19: 
          localbp.zmu = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(125693);
          return 0;
        case 20: 
          localbp.DOK = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(125693);
          return 0;
        case 21: 
          localbp.DOL = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(125693);
          return 0;
        case 22: 
          localbp.DOM = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(125693);
          return 0;
        case 23: 
          localbp.DON = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(125693);
          return 0;
        case 24: 
          localbp.imei = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(125693);
          return 0;
        }
        localbp.DOx = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(125693);
        return 0;
      }
      AppMethodBeat.o(125693);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bp
 * JD-Core Version:    0.7.0.1
 */