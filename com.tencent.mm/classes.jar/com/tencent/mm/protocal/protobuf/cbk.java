package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cbk
  extends com.tencent.mm.bw.a
{
  public int FKD;
  public int FKG;
  public cxn GuF;
  public long GyM;
  public String GyN;
  public cxn Hed;
  public int Hhu;
  public String Hhv;
  public String Hhw;
  public String Hhx;
  public int Hhy;
  public int HnP;
  public int HoB;
  public int HoH;
  public com.tencent.mm.bw.b HoI;
  public int HoK;
  public cxn HoL;
  public cxn HoM;
  public int HoN;
  public int HoO;
  public int HoP;
  public int HoQ;
  public int HoR;
  public bnb HoS;
  public int HoT;
  public String HoU;
  public afg Hom;
  public int jfV;
  public String jfW;
  public String jfX;
  public String jfY;
  public int jfZ;
  public String jga;
  public int jgb;
  public int jgc;
  public String jgd;
  public String jge;
  public int nJb;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(43112);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.GuF == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: UserName");
        AppMethodBeat.o(43112);
        throw paramVarArgs;
      }
      if (this.Hed == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: NickName");
        AppMethodBeat.o(43112);
        throw paramVarArgs;
      }
      if (this.HoL == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: BindEmail");
        AppMethodBeat.o(43112);
        throw paramVarArgs;
      }
      if (this.HoM == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: BindMobile");
        AppMethodBeat.o(43112);
        throw paramVarArgs;
      }
      paramVarArgs.aS(1, this.HoK);
      if (this.GuF != null)
      {
        paramVarArgs.lJ(2, this.GuF.computeSize());
        this.GuF.writeFields(paramVarArgs);
      }
      if (this.Hed != null)
      {
        paramVarArgs.lJ(3, this.Hed.computeSize());
        this.Hed.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(4, this.FKD);
      if (this.HoL != null)
      {
        paramVarArgs.lJ(5, this.HoL.computeSize());
        this.HoL.writeFields(paramVarArgs);
      }
      if (this.HoM != null)
      {
        paramVarArgs.lJ(6, this.HoM.computeSize());
        this.HoM.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(7, this.nJb);
      paramVarArgs.aS(8, this.HoH);
      if (this.HoI != null) {
        paramVarArgs.c(9, this.HoI);
      }
      paramVarArgs.aS(10, this.jfV);
      if (this.jfW != null) {
        paramVarArgs.d(11, this.jfW);
      }
      if (this.jfX != null) {
        paramVarArgs.d(12, this.jfX);
      }
      if (this.jfY != null) {
        paramVarArgs.d(13, this.jfY);
      }
      paramVarArgs.aS(14, this.jfZ);
      if (this.Hom != null)
      {
        paramVarArgs.lJ(15, this.Hom.computeSize());
        this.Hom.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(16, this.FKG);
      paramVarArgs.aS(17, this.Hhu);
      if (this.Hhv != null) {
        paramVarArgs.d(18, this.Hhv);
      }
      paramVarArgs.aS(19, this.HoN);
      paramVarArgs.aS(20, this.HoO);
      paramVarArgs.aS(21, this.HnP);
      paramVarArgs.aS(22, this.HoP);
      paramVarArgs.aS(23, this.HoQ);
      if (this.Hhw != null) {
        paramVarArgs.d(24, this.Hhw);
      }
      paramVarArgs.aS(25, this.HoR);
      if (this.HoS != null)
      {
        paramVarArgs.lJ(26, this.HoS.computeSize());
        this.HoS.writeFields(paramVarArgs);
      }
      if (this.jga != null) {
        paramVarArgs.d(27, this.jga);
      }
      if (this.Hhx != null) {
        paramVarArgs.d(28, this.Hhx);
      }
      paramVarArgs.aS(29, this.Hhy);
      paramVarArgs.aS(30, this.HoT);
      paramVarArgs.aZ(31, this.GyM);
      if (this.GyN != null) {
        paramVarArgs.d(32, this.GyN);
      }
      paramVarArgs.aS(33, this.jgc);
      paramVarArgs.aS(34, this.jgb);
      if (this.jgd != null) {
        paramVarArgs.d(35, this.jgd);
      }
      paramVarArgs.aS(36, this.HoB);
      if (this.HoU != null) {
        paramVarArgs.d(37, this.HoU);
      }
      if (this.jge != null) {
        paramVarArgs.d(38, this.jge);
      }
      AppMethodBeat.o(43112);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bz(1, this.HoK) + 0;
      paramInt = i;
      if (this.GuF != null) {
        paramInt = i + f.a.a.a.lI(2, this.GuF.computeSize());
      }
      i = paramInt;
      if (this.Hed != null) {
        i = paramInt + f.a.a.a.lI(3, this.Hed.computeSize());
      }
      i += f.a.a.b.b.a.bz(4, this.FKD);
      paramInt = i;
      if (this.HoL != null) {
        paramInt = i + f.a.a.a.lI(5, this.HoL.computeSize());
      }
      i = paramInt;
      if (this.HoM != null) {
        i = paramInt + f.a.a.a.lI(6, this.HoM.computeSize());
      }
      i = i + f.a.a.b.b.a.bz(7, this.nJb) + f.a.a.b.b.a.bz(8, this.HoH);
      paramInt = i;
      if (this.HoI != null) {
        paramInt = i + f.a.a.b.b.a.b(9, this.HoI);
      }
      i = paramInt + f.a.a.b.b.a.bz(10, this.jfV);
      paramInt = i;
      if (this.jfW != null) {
        paramInt = i + f.a.a.b.b.a.e(11, this.jfW);
      }
      i = paramInt;
      if (this.jfX != null) {
        i = paramInt + f.a.a.b.b.a.e(12, this.jfX);
      }
      paramInt = i;
      if (this.jfY != null) {
        paramInt = i + f.a.a.b.b.a.e(13, this.jfY);
      }
      i = paramInt + f.a.a.b.b.a.bz(14, this.jfZ);
      paramInt = i;
      if (this.Hom != null) {
        paramInt = i + f.a.a.a.lI(15, this.Hom.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bz(16, this.FKG) + f.a.a.b.b.a.bz(17, this.Hhu);
      paramInt = i;
      if (this.Hhv != null) {
        paramInt = i + f.a.a.b.b.a.e(18, this.Hhv);
      }
      i = paramInt + f.a.a.b.b.a.bz(19, this.HoN) + f.a.a.b.b.a.bz(20, this.HoO) + f.a.a.b.b.a.bz(21, this.HnP) + f.a.a.b.b.a.bz(22, this.HoP) + f.a.a.b.b.a.bz(23, this.HoQ);
      paramInt = i;
      if (this.Hhw != null) {
        paramInt = i + f.a.a.b.b.a.e(24, this.Hhw);
      }
      i = paramInt + f.a.a.b.b.a.bz(25, this.HoR);
      paramInt = i;
      if (this.HoS != null) {
        paramInt = i + f.a.a.a.lI(26, this.HoS.computeSize());
      }
      i = paramInt;
      if (this.jga != null) {
        i = paramInt + f.a.a.b.b.a.e(27, this.jga);
      }
      paramInt = i;
      if (this.Hhx != null) {
        paramInt = i + f.a.a.b.b.a.e(28, this.Hhx);
      }
      i = paramInt + f.a.a.b.b.a.bz(29, this.Hhy) + f.a.a.b.b.a.bz(30, this.HoT) + f.a.a.b.b.a.p(31, this.GyM);
      paramInt = i;
      if (this.GyN != null) {
        paramInt = i + f.a.a.b.b.a.e(32, this.GyN);
      }
      i = paramInt + f.a.a.b.b.a.bz(33, this.jgc) + f.a.a.b.b.a.bz(34, this.jgb);
      paramInt = i;
      if (this.jgd != null) {
        paramInt = i + f.a.a.b.b.a.e(35, this.jgd);
      }
      i = paramInt + f.a.a.b.b.a.bz(36, this.HoB);
      paramInt = i;
      if (this.HoU != null) {
        paramInt = i + f.a.a.b.b.a.e(37, this.HoU);
      }
      i = paramInt;
      if (this.jge != null) {
        i = paramInt + f.a.a.b.b.a.e(38, this.jge);
      }
      AppMethodBeat.o(43112);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      if (this.GuF == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: UserName");
        AppMethodBeat.o(43112);
        throw paramVarArgs;
      }
      if (this.Hed == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: NickName");
        AppMethodBeat.o(43112);
        throw paramVarArgs;
      }
      if (this.HoL == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: BindEmail");
        AppMethodBeat.o(43112);
        throw paramVarArgs;
      }
      if (this.HoM == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: BindMobile");
        AppMethodBeat.o(43112);
        throw paramVarArgs;
      }
      AppMethodBeat.o(43112);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      cbk localcbk = (cbk)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(43112);
        return -1;
      case 1: 
        localcbk.HoK = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(43112);
        return 0;
      case 2: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cxn();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cxn)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localcbk.GuF = ((cxn)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(43112);
        return 0;
      case 3: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cxn();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cxn)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localcbk.Hed = ((cxn)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(43112);
        return 0;
      case 4: 
        localcbk.FKD = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(43112);
        return 0;
      case 5: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cxn();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cxn)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localcbk.HoL = ((cxn)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(43112);
        return 0;
      case 6: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cxn();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cxn)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localcbk.HoM = ((cxn)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(43112);
        return 0;
      case 7: 
        localcbk.nJb = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(43112);
        return 0;
      case 8: 
        localcbk.HoH = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(43112);
        return 0;
      case 9: 
        localcbk.HoI = ((f.a.a.a.a)localObject1).OmT.gCk();
        AppMethodBeat.o(43112);
        return 0;
      case 10: 
        localcbk.jfV = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(43112);
        return 0;
      case 11: 
        localcbk.jfW = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(43112);
        return 0;
      case 12: 
        localcbk.jfX = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(43112);
        return 0;
      case 13: 
        localcbk.jfY = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(43112);
        return 0;
      case 14: 
        localcbk.jfZ = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(43112);
        return 0;
      case 15: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new afg();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((afg)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localcbk.Hom = ((afg)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(43112);
        return 0;
      case 16: 
        localcbk.FKG = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(43112);
        return 0;
      case 17: 
        localcbk.Hhu = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(43112);
        return 0;
      case 18: 
        localcbk.Hhv = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(43112);
        return 0;
      case 19: 
        localcbk.HoN = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(43112);
        return 0;
      case 20: 
        localcbk.HoO = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(43112);
        return 0;
      case 21: 
        localcbk.HnP = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(43112);
        return 0;
      case 22: 
        localcbk.HoP = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(43112);
        return 0;
      case 23: 
        localcbk.HoQ = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(43112);
        return 0;
      case 24: 
        localcbk.Hhw = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(43112);
        return 0;
      case 25: 
        localcbk.HoR = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(43112);
        return 0;
      case 26: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bnb();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bnb)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localcbk.HoS = ((bnb)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(43112);
        return 0;
      case 27: 
        localcbk.jga = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(43112);
        return 0;
      case 28: 
        localcbk.Hhx = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(43112);
        return 0;
      case 29: 
        localcbk.Hhy = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(43112);
        return 0;
      case 30: 
        localcbk.HoT = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(43112);
        return 0;
      case 31: 
        localcbk.GyM = ((f.a.a.a.a)localObject1).OmT.zd();
        AppMethodBeat.o(43112);
        return 0;
      case 32: 
        localcbk.GyN = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(43112);
        return 0;
      case 33: 
        localcbk.jgc = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(43112);
        return 0;
      case 34: 
        localcbk.jgb = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(43112);
        return 0;
      case 35: 
        localcbk.jgd = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(43112);
        return 0;
      case 36: 
        localcbk.HoB = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(43112);
        return 0;
      case 37: 
        localcbk.HoU = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(43112);
        return 0;
      }
      localcbk.jge = ((f.a.a.a.a)localObject1).OmT.readString();
      AppMethodBeat.o(43112);
      return 0;
    }
    AppMethodBeat.o(43112);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cbk
 * JD-Core Version:    0.7.0.1
 */