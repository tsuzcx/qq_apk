package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class caj
  extends com.tencent.mm.bw.a
{
  public int DeleteFlag;
  public int ExtFlag;
  public String FNF;
  public SKBuiltinBuffer_t FNK;
  public String GNt;
  public vy GQb;
  public String GXa;
  public String GnN;
  public String GnO;
  public cxn GtY;
  public cxn GtZ;
  public int Gti;
  public int Gtj;
  public int Gto;
  public int Gtp;
  public LinkedList<cwz> Gtq;
  public int Gts;
  public int Gtt;
  public cxn GuF;
  public int GuG;
  public String GuH;
  public cxn Hed;
  public dia HhA;
  public aco HhB;
  public int Hhu;
  public String Hhv;
  public String Hhw;
  public String Hhx;
  public int Hhy;
  public int HnJ;
  public cxn HnN;
  public int HnO;
  public int HnP;
  public String HnQ;
  public String HnR;
  public String HnS;
  public String HnT;
  public String HnU;
  public String HnV;
  public String HnW;
  public String HnX;
  public dh HnY;
  public int HnZ;
  public cxn Hnt;
  public cxn Hnu;
  public cxn Hnv;
  public int Hoa;
  public int Hob;
  public String Hoc;
  public cld Hod;
  public int Hoe;
  public int Hof;
  public String Hog;
  public long eRA;
  public String eRt;
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
  public String jgf;
  public int ucK;
  public String uvT;
  
  public caj()
  {
    AppMethodBeat.i(43106);
    this.Gtq = new LinkedList();
    AppMethodBeat.o(43106);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(43107);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.GuF == null)
      {
        paramVarArgs = new b("Not all required fields were included: UserName");
        AppMethodBeat.o(43107);
        throw paramVarArgs;
      }
      if (this.Hed == null)
      {
        paramVarArgs = new b("Not all required fields were included: NickName");
        AppMethodBeat.o(43107);
        throw paramVarArgs;
      }
      if (this.GtY == null)
      {
        paramVarArgs = new b("Not all required fields were included: PYInitial");
        AppMethodBeat.o(43107);
        throw paramVarArgs;
      }
      if (this.GtZ == null)
      {
        paramVarArgs = new b("Not all required fields were included: QuanPin");
        AppMethodBeat.o(43107);
        throw paramVarArgs;
      }
      if (this.FNK == null)
      {
        paramVarArgs = new b("Not all required fields were included: ImgBuf");
        AppMethodBeat.o(43107);
        throw paramVarArgs;
      }
      if (this.GuF != null)
      {
        paramVarArgs.lJ(1, this.GuF.computeSize());
        this.GuF.writeFields(paramVarArgs);
      }
      if (this.Hed != null)
      {
        paramVarArgs.lJ(2, this.Hed.computeSize());
        this.Hed.writeFields(paramVarArgs);
      }
      if (this.GtY != null)
      {
        paramVarArgs.lJ(3, this.GtY.computeSize());
        this.GtY.writeFields(paramVarArgs);
      }
      if (this.GtZ != null)
      {
        paramVarArgs.lJ(4, this.GtZ.computeSize());
        this.GtZ.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(5, this.jfV);
      if (this.FNK != null)
      {
        paramVarArgs.lJ(6, this.FNK.computeSize());
        this.FNK.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(7, this.Gti);
      paramVarArgs.aS(8, this.Gtj);
      paramVarArgs.aS(9, this.HnJ);
      if (this.Hnt != null)
      {
        paramVarArgs.lJ(10, this.Hnt.computeSize());
        this.Hnt.writeFields(paramVarArgs);
      }
      if (this.Hnu != null)
      {
        paramVarArgs.lJ(11, this.Hnu.computeSize());
        this.Hnu.writeFields(paramVarArgs);
      }
      if (this.Hnv != null)
      {
        paramVarArgs.lJ(12, this.Hnv.computeSize());
        this.Hnv.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(13, this.Gto);
      paramVarArgs.aS(14, this.Gtp);
      paramVarArgs.e(15, 8, this.Gtq);
      if (this.HnN != null)
      {
        paramVarArgs.lJ(16, this.HnN.computeSize());
        this.HnN.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(17, this.Gts);
      paramVarArgs.aS(18, this.Gtt);
      if (this.jfW != null) {
        paramVarArgs.d(19, this.jfW);
      }
      if (this.jfX != null) {
        paramVarArgs.d(20, this.jfX);
      }
      if (this.jfY != null) {
        paramVarArgs.d(21, this.jfY);
      }
      paramVarArgs.aS(22, this.jfZ);
      paramVarArgs.aS(23, this.HnO);
      paramVarArgs.aS(24, this.Hhu);
      if (this.Hhv != null) {
        paramVarArgs.d(25, this.Hhv);
      }
      paramVarArgs.aS(26, this.HnP);
      paramVarArgs.aS(27, this.ucK);
      if (this.Hhw != null) {
        paramVarArgs.d(28, this.Hhw);
      }
      if (this.GXa != null) {
        paramVarArgs.d(29, this.GXa);
      }
      if (this.jga != null) {
        paramVarArgs.d(30, this.jga);
      }
      if (this.HnQ != null) {
        paramVarArgs.d(31, this.HnQ);
      }
      if (this.Hhx != null) {
        paramVarArgs.d(32, this.Hhx);
      }
      paramVarArgs.aS(33, this.Hhy);
      paramVarArgs.aS(34, this.jgc);
      paramVarArgs.aS(35, this.jgb);
      if (this.jgd != null) {
        paramVarArgs.d(36, this.jgd);
      }
      if (this.HhA != null)
      {
        paramVarArgs.lJ(37, this.HhA.computeSize());
        this.HhA.writeFields(paramVarArgs);
      }
      if (this.jge != null) {
        paramVarArgs.d(38, this.jge);
      }
      if (this.GnN != null) {
        paramVarArgs.d(39, this.GnN);
      }
      if (this.GnO != null) {
        paramVarArgs.d(40, this.GnO);
      }
      if (this.jgf != null) {
        paramVarArgs.d(41, this.jgf);
      }
      if (this.HhB != null)
      {
        paramVarArgs.lJ(42, this.HhB.computeSize());
        this.HhB.writeFields(paramVarArgs);
      }
      if (this.HnR != null) {
        paramVarArgs.d(43, this.HnR);
      }
      if (this.HnS != null) {
        paramVarArgs.d(44, this.HnS);
      }
      if (this.HnT != null) {
        paramVarArgs.d(45, this.HnT);
      }
      if (this.HnU != null) {
        paramVarArgs.d(46, this.HnU);
      }
      if (this.HnV != null) {
        paramVarArgs.d(47, this.HnV);
      }
      if (this.HnW != null) {
        paramVarArgs.d(48, this.HnW);
      }
      if (this.HnX != null) {
        paramVarArgs.d(49, this.HnX);
      }
      if (this.HnY != null)
      {
        paramVarArgs.lJ(50, this.HnY.computeSize());
        this.HnY.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(53, this.HnZ);
      if (this.uvT != null) {
        paramVarArgs.d(54, this.uvT);
      }
      paramVarArgs.aS(55, this.Hoa);
      paramVarArgs.aS(56, this.Hob);
      if (this.GQb != null)
      {
        paramVarArgs.lJ(57, this.GQb.computeSize());
        this.GQb.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(58, this.DeleteFlag);
      if (this.FNF != null) {
        paramVarArgs.d(59, this.FNF);
      }
      if (this.Hoc != null) {
        paramVarArgs.d(60, this.Hoc);
      }
      if (this.GuH != null) {
        paramVarArgs.d(61, this.GuH);
      }
      if (this.Hod != null)
      {
        paramVarArgs.lJ(62, this.Hod.computeSize());
        this.Hod.writeFields(paramVarArgs);
      }
      if (this.eRt != null) {
        paramVarArgs.d(63, this.eRt);
      }
      paramVarArgs.aS(64, this.Hoe);
      paramVarArgs.aS(65, this.GuG);
      paramVarArgs.aS(66, this.Hof);
      paramVarArgs.aS(67, this.ExtFlag);
      if (this.Hog != null) {
        paramVarArgs.d(68, this.Hog);
      }
      paramVarArgs.aZ(70, this.eRA);
      if (this.GNt != null) {
        paramVarArgs.d(71, this.GNt);
      }
      AppMethodBeat.o(43107);
      return 0;
    }
    if (paramInt == 1) {
      if (this.GuF == null) {
        break label5582;
      }
    }
    label5582:
    for (int i = f.a.a.a.lI(1, this.GuF.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Hed != null) {
        paramInt = i + f.a.a.a.lI(2, this.Hed.computeSize());
      }
      i = paramInt;
      if (this.GtY != null) {
        i = paramInt + f.a.a.a.lI(3, this.GtY.computeSize());
      }
      paramInt = i;
      if (this.GtZ != null) {
        paramInt = i + f.a.a.a.lI(4, this.GtZ.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bz(5, this.jfV);
      paramInt = i;
      if (this.FNK != null) {
        paramInt = i + f.a.a.a.lI(6, this.FNK.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bz(7, this.Gti) + f.a.a.b.b.a.bz(8, this.Gtj) + f.a.a.b.b.a.bz(9, this.HnJ);
      paramInt = i;
      if (this.Hnt != null) {
        paramInt = i + f.a.a.a.lI(10, this.Hnt.computeSize());
      }
      i = paramInt;
      if (this.Hnu != null) {
        i = paramInt + f.a.a.a.lI(11, this.Hnu.computeSize());
      }
      paramInt = i;
      if (this.Hnv != null) {
        paramInt = i + f.a.a.a.lI(12, this.Hnv.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bz(13, this.Gto) + f.a.a.b.b.a.bz(14, this.Gtp) + f.a.a.a.c(15, 8, this.Gtq);
      paramInt = i;
      if (this.HnN != null) {
        paramInt = i + f.a.a.a.lI(16, this.HnN.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bz(17, this.Gts) + f.a.a.b.b.a.bz(18, this.Gtt);
      paramInt = i;
      if (this.jfW != null) {
        paramInt = i + f.a.a.b.b.a.e(19, this.jfW);
      }
      i = paramInt;
      if (this.jfX != null) {
        i = paramInt + f.a.a.b.b.a.e(20, this.jfX);
      }
      paramInt = i;
      if (this.jfY != null) {
        paramInt = i + f.a.a.b.b.a.e(21, this.jfY);
      }
      i = paramInt + f.a.a.b.b.a.bz(22, this.jfZ) + f.a.a.b.b.a.bz(23, this.HnO) + f.a.a.b.b.a.bz(24, this.Hhu);
      paramInt = i;
      if (this.Hhv != null) {
        paramInt = i + f.a.a.b.b.a.e(25, this.Hhv);
      }
      i = paramInt + f.a.a.b.b.a.bz(26, this.HnP) + f.a.a.b.b.a.bz(27, this.ucK);
      paramInt = i;
      if (this.Hhw != null) {
        paramInt = i + f.a.a.b.b.a.e(28, this.Hhw);
      }
      i = paramInt;
      if (this.GXa != null) {
        i = paramInt + f.a.a.b.b.a.e(29, this.GXa);
      }
      paramInt = i;
      if (this.jga != null) {
        paramInt = i + f.a.a.b.b.a.e(30, this.jga);
      }
      i = paramInt;
      if (this.HnQ != null) {
        i = paramInt + f.a.a.b.b.a.e(31, this.HnQ);
      }
      paramInt = i;
      if (this.Hhx != null) {
        paramInt = i + f.a.a.b.b.a.e(32, this.Hhx);
      }
      i = paramInt + f.a.a.b.b.a.bz(33, this.Hhy) + f.a.a.b.b.a.bz(34, this.jgc) + f.a.a.b.b.a.bz(35, this.jgb);
      paramInt = i;
      if (this.jgd != null) {
        paramInt = i + f.a.a.b.b.a.e(36, this.jgd);
      }
      i = paramInt;
      if (this.HhA != null) {
        i = paramInt + f.a.a.a.lI(37, this.HhA.computeSize());
      }
      paramInt = i;
      if (this.jge != null) {
        paramInt = i + f.a.a.b.b.a.e(38, this.jge);
      }
      i = paramInt;
      if (this.GnN != null) {
        i = paramInt + f.a.a.b.b.a.e(39, this.GnN);
      }
      paramInt = i;
      if (this.GnO != null) {
        paramInt = i + f.a.a.b.b.a.e(40, this.GnO);
      }
      i = paramInt;
      if (this.jgf != null) {
        i = paramInt + f.a.a.b.b.a.e(41, this.jgf);
      }
      paramInt = i;
      if (this.HhB != null) {
        paramInt = i + f.a.a.a.lI(42, this.HhB.computeSize());
      }
      i = paramInt;
      if (this.HnR != null) {
        i = paramInt + f.a.a.b.b.a.e(43, this.HnR);
      }
      paramInt = i;
      if (this.HnS != null) {
        paramInt = i + f.a.a.b.b.a.e(44, this.HnS);
      }
      i = paramInt;
      if (this.HnT != null) {
        i = paramInt + f.a.a.b.b.a.e(45, this.HnT);
      }
      paramInt = i;
      if (this.HnU != null) {
        paramInt = i + f.a.a.b.b.a.e(46, this.HnU);
      }
      i = paramInt;
      if (this.HnV != null) {
        i = paramInt + f.a.a.b.b.a.e(47, this.HnV);
      }
      paramInt = i;
      if (this.HnW != null) {
        paramInt = i + f.a.a.b.b.a.e(48, this.HnW);
      }
      i = paramInt;
      if (this.HnX != null) {
        i = paramInt + f.a.a.b.b.a.e(49, this.HnX);
      }
      paramInt = i;
      if (this.HnY != null) {
        paramInt = i + f.a.a.a.lI(50, this.HnY.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bz(53, this.HnZ);
      paramInt = i;
      if (this.uvT != null) {
        paramInt = i + f.a.a.b.b.a.e(54, this.uvT);
      }
      i = paramInt + f.a.a.b.b.a.bz(55, this.Hoa) + f.a.a.b.b.a.bz(56, this.Hob);
      paramInt = i;
      if (this.GQb != null) {
        paramInt = i + f.a.a.a.lI(57, this.GQb.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bz(58, this.DeleteFlag);
      paramInt = i;
      if (this.FNF != null) {
        paramInt = i + f.a.a.b.b.a.e(59, this.FNF);
      }
      i = paramInt;
      if (this.Hoc != null) {
        i = paramInt + f.a.a.b.b.a.e(60, this.Hoc);
      }
      paramInt = i;
      if (this.GuH != null) {
        paramInt = i + f.a.a.b.b.a.e(61, this.GuH);
      }
      i = paramInt;
      if (this.Hod != null) {
        i = paramInt + f.a.a.a.lI(62, this.Hod.computeSize());
      }
      paramInt = i;
      if (this.eRt != null) {
        paramInt = i + f.a.a.b.b.a.e(63, this.eRt);
      }
      i = paramInt + f.a.a.b.b.a.bz(64, this.Hoe) + f.a.a.b.b.a.bz(65, this.GuG) + f.a.a.b.b.a.bz(66, this.Hof) + f.a.a.b.b.a.bz(67, this.ExtFlag);
      paramInt = i;
      if (this.Hog != null) {
        paramInt = i + f.a.a.b.b.a.e(68, this.Hog);
      }
      i = paramInt + f.a.a.b.b.a.p(70, this.eRA);
      paramInt = i;
      if (this.GNt != null) {
        paramInt = i + f.a.a.b.b.a.e(71, this.GNt);
      }
      AppMethodBeat.o(43107);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Gtq.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.GuF == null)
        {
          paramVarArgs = new b("Not all required fields were included: UserName");
          AppMethodBeat.o(43107);
          throw paramVarArgs;
        }
        if (this.Hed == null)
        {
          paramVarArgs = new b("Not all required fields were included: NickName");
          AppMethodBeat.o(43107);
          throw paramVarArgs;
        }
        if (this.GtY == null)
        {
          paramVarArgs = new b("Not all required fields were included: PYInitial");
          AppMethodBeat.o(43107);
          throw paramVarArgs;
        }
        if (this.GtZ == null)
        {
          paramVarArgs = new b("Not all required fields were included: QuanPin");
          AppMethodBeat.o(43107);
          throw paramVarArgs;
        }
        if (this.FNK == null)
        {
          paramVarArgs = new b("Not all required fields were included: ImgBuf");
          AppMethodBeat.o(43107);
          throw paramVarArgs;
        }
        AppMethodBeat.o(43107);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        caj localcaj = (caj)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        case 51: 
        case 52: 
        case 69: 
        default: 
          AppMethodBeat.o(43107);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cxn();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cxn)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcaj.GuF = ((cxn)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(43107);
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
            localcaj.Hed = ((cxn)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(43107);
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
            localcaj.GtY = ((cxn)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(43107);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cxn();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cxn)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcaj.GtZ = ((cxn)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(43107);
          return 0;
        case 5: 
          localcaj.jfV = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(43107);
          return 0;
        case 6: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcaj.FNK = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(43107);
          return 0;
        case 7: 
          localcaj.Gti = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(43107);
          return 0;
        case 8: 
          localcaj.Gtj = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(43107);
          return 0;
        case 9: 
          localcaj.HnJ = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(43107);
          return 0;
        case 10: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cxn();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cxn)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcaj.Hnt = ((cxn)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(43107);
          return 0;
        case 11: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cxn();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cxn)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcaj.Hnu = ((cxn)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(43107);
          return 0;
        case 12: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cxn();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cxn)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcaj.Hnv = ((cxn)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(43107);
          return 0;
        case 13: 
          localcaj.Gto = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(43107);
          return 0;
        case 14: 
          localcaj.Gtp = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(43107);
          return 0;
        case 15: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cwz();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cwz)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcaj.Gtq.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(43107);
          return 0;
        case 16: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cxn();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cxn)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcaj.HnN = ((cxn)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(43107);
          return 0;
        case 17: 
          localcaj.Gts = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(43107);
          return 0;
        case 18: 
          localcaj.Gtt = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(43107);
          return 0;
        case 19: 
          localcaj.jfW = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(43107);
          return 0;
        case 20: 
          localcaj.jfX = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(43107);
          return 0;
        case 21: 
          localcaj.jfY = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(43107);
          return 0;
        case 22: 
          localcaj.jfZ = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(43107);
          return 0;
        case 23: 
          localcaj.HnO = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(43107);
          return 0;
        case 24: 
          localcaj.Hhu = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(43107);
          return 0;
        case 25: 
          localcaj.Hhv = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(43107);
          return 0;
        case 26: 
          localcaj.HnP = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(43107);
          return 0;
        case 27: 
          localcaj.ucK = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(43107);
          return 0;
        case 28: 
          localcaj.Hhw = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(43107);
          return 0;
        case 29: 
          localcaj.GXa = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(43107);
          return 0;
        case 30: 
          localcaj.jga = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(43107);
          return 0;
        case 31: 
          localcaj.HnQ = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(43107);
          return 0;
        case 32: 
          localcaj.Hhx = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(43107);
          return 0;
        case 33: 
          localcaj.Hhy = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(43107);
          return 0;
        case 34: 
          localcaj.jgc = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(43107);
          return 0;
        case 35: 
          localcaj.jgb = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(43107);
          return 0;
        case 36: 
          localcaj.jgd = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(43107);
          return 0;
        case 37: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dia();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dia)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcaj.HhA = ((dia)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(43107);
          return 0;
        case 38: 
          localcaj.jge = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(43107);
          return 0;
        case 39: 
          localcaj.GnN = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(43107);
          return 0;
        case 40: 
          localcaj.GnO = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(43107);
          return 0;
        case 41: 
          localcaj.jgf = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(43107);
          return 0;
        case 42: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new aco();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((aco)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcaj.HhB = ((aco)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(43107);
          return 0;
        case 43: 
          localcaj.HnR = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(43107);
          return 0;
        case 44: 
          localcaj.HnS = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(43107);
          return 0;
        case 45: 
          localcaj.HnT = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(43107);
          return 0;
        case 46: 
          localcaj.HnU = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(43107);
          return 0;
        case 47: 
          localcaj.HnV = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(43107);
          return 0;
        case 48: 
          localcaj.HnW = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(43107);
          return 0;
        case 49: 
          localcaj.HnX = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(43107);
          return 0;
        case 50: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dh();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dh)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcaj.HnY = ((dh)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(43107);
          return 0;
        case 53: 
          localcaj.HnZ = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(43107);
          return 0;
        case 54: 
          localcaj.uvT = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(43107);
          return 0;
        case 55: 
          localcaj.Hoa = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(43107);
          return 0;
        case 56: 
          localcaj.Hob = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(43107);
          return 0;
        case 57: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new vy();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((vy)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcaj.GQb = ((vy)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(43107);
          return 0;
        case 58: 
          localcaj.DeleteFlag = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(43107);
          return 0;
        case 59: 
          localcaj.FNF = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(43107);
          return 0;
        case 60: 
          localcaj.Hoc = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(43107);
          return 0;
        case 61: 
          localcaj.GuH = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(43107);
          return 0;
        case 62: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cld();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cld)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcaj.Hod = ((cld)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(43107);
          return 0;
        case 63: 
          localcaj.eRt = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(43107);
          return 0;
        case 64: 
          localcaj.Hoe = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(43107);
          return 0;
        case 65: 
          localcaj.GuG = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(43107);
          return 0;
        case 66: 
          localcaj.Hof = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(43107);
          return 0;
        case 67: 
          localcaj.ExtFlag = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(43107);
          return 0;
        case 68: 
          localcaj.Hog = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(43107);
          return 0;
        case 70: 
          localcaj.eRA = ((f.a.a.a.a)localObject1).OmT.zd();
          AppMethodBeat.o(43107);
          return 0;
        }
        localcaj.GNt = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(43107);
        return 0;
      }
      AppMethodBeat.o(43107);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.caj
 * JD-Core Version:    0.7.0.1
 */