package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class dzx
  extends com.tencent.mm.bw.a
{
  public ead Idl;
  public ead Idm;
  public ctw IeZ;
  public int IfA;
  public int IfB;
  public int IfC;
  public bsf IfD;
  public SKBuiltinBuffer_t IfE;
  public int IfF;
  public String IfG;
  public int IfH;
  public LinkedList<dzy> IfI;
  public bfc IfJ;
  public afe Ifa;
  public int Ifg;
  public dyk Ifh;
  public dyk Ifi;
  public int Ifj;
  public int Ifk;
  public int Ifl;
  public int Ifm;
  public SKBuiltinBuffer_t Ifn;
  public int Ifo;
  public dyk Ifp;
  public int Ifq;
  public int Ifr;
  public int Ifs;
  public int Ift;
  public int Ifu;
  public int Ifv;
  public SKBuiltinBuffer_t Ifw;
  public SKBuiltinBuffer_t Ifx;
  public int Ify;
  public SKBuiltinBuffer_t Ifz;
  public int uXB;
  
  public dzx()
  {
    AppMethodBeat.i(115899);
    this.IfI = new LinkedList();
    AppMethodBeat.o(115899);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(115900);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Idl == null)
      {
        paramVarArgs = new b("Not all required fields were included: PeerId");
        AppMethodBeat.o(115900);
        throw paramVarArgs;
      }
      if (this.Idm == null)
      {
        paramVarArgs = new b("Not all required fields were included: CapInfo");
        AppMethodBeat.o(115900);
        throw paramVarArgs;
      }
      if (this.Idl != null)
      {
        paramVarArgs.lJ(1, this.Idl.computeSize());
        this.Idl.writeFields(paramVarArgs);
      }
      if (this.Idm != null)
      {
        paramVarArgs.lJ(2, this.Idm.computeSize());
        this.Idm.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(3, this.Ifg);
      if (this.Ifh != null)
      {
        paramVarArgs.lJ(4, this.Ifh.computeSize());
        this.Ifh.writeFields(paramVarArgs);
      }
      if (this.Ifi != null)
      {
        paramVarArgs.lJ(5, this.Ifi.computeSize());
        this.Ifi.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(6, this.Ifj);
      paramVarArgs.aS(7, this.Ifk);
      paramVarArgs.aS(8, this.Ifl);
      paramVarArgs.aS(9, this.Ifm);
      if (this.Ifn != null)
      {
        paramVarArgs.lJ(10, this.Ifn.computeSize());
        this.Ifn.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(11, this.Ifo);
      if (this.Ifp != null)
      {
        paramVarArgs.lJ(12, this.Ifp.computeSize());
        this.Ifp.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(13, this.Ifq);
      paramVarArgs.aS(14, this.Ifr);
      paramVarArgs.aS(15, this.Ifs);
      paramVarArgs.aS(16, this.Ift);
      paramVarArgs.aS(17, this.Ifu);
      paramVarArgs.aS(18, this.uXB);
      paramVarArgs.aS(19, this.Ifv);
      if (this.Ifw != null)
      {
        paramVarArgs.lJ(20, this.Ifw.computeSize());
        this.Ifw.writeFields(paramVarArgs);
      }
      if (this.Ifx != null)
      {
        paramVarArgs.lJ(21, this.Ifx.computeSize());
        this.Ifx.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(22, this.Ify);
      if (this.Ifz != null)
      {
        paramVarArgs.lJ(23, this.Ifz.computeSize());
        this.Ifz.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(24, this.IfA);
      paramVarArgs.aS(25, this.IfB);
      paramVarArgs.aS(26, this.IfC);
      if (this.IfD != null)
      {
        paramVarArgs.lJ(27, this.IfD.computeSize());
        this.IfD.writeFields(paramVarArgs);
      }
      if (this.IfE != null)
      {
        paramVarArgs.lJ(28, this.IfE.computeSize());
        this.IfE.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(29, this.IfF);
      if (this.IfG != null) {
        paramVarArgs.d(30, this.IfG);
      }
      paramVarArgs.aS(31, this.IfH);
      paramVarArgs.e(32, 8, this.IfI);
      if (this.IeZ != null)
      {
        paramVarArgs.lJ(33, this.IeZ.computeSize());
        this.IeZ.writeFields(paramVarArgs);
      }
      if (this.Ifa != null)
      {
        paramVarArgs.lJ(34, this.Ifa.computeSize());
        this.Ifa.writeFields(paramVarArgs);
      }
      if (this.IfJ != null)
      {
        paramVarArgs.lJ(35, this.IfJ.computeSize());
        this.IfJ.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(115900);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Idl == null) {
        break label3482;
      }
    }
    label3482:
    for (paramInt = f.a.a.a.lI(1, this.Idl.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Idm != null) {
        i = paramInt + f.a.a.a.lI(2, this.Idm.computeSize());
      }
      i += f.a.a.b.b.a.bz(3, this.Ifg);
      paramInt = i;
      if (this.Ifh != null) {
        paramInt = i + f.a.a.a.lI(4, this.Ifh.computeSize());
      }
      i = paramInt;
      if (this.Ifi != null) {
        i = paramInt + f.a.a.a.lI(5, this.Ifi.computeSize());
      }
      i = i + f.a.a.b.b.a.bz(6, this.Ifj) + f.a.a.b.b.a.bz(7, this.Ifk) + f.a.a.b.b.a.bz(8, this.Ifl) + f.a.a.b.b.a.bz(9, this.Ifm);
      paramInt = i;
      if (this.Ifn != null) {
        paramInt = i + f.a.a.a.lI(10, this.Ifn.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bz(11, this.Ifo);
      paramInt = i;
      if (this.Ifp != null) {
        paramInt = i + f.a.a.a.lI(12, this.Ifp.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bz(13, this.Ifq) + f.a.a.b.b.a.bz(14, this.Ifr) + f.a.a.b.b.a.bz(15, this.Ifs) + f.a.a.b.b.a.bz(16, this.Ift) + f.a.a.b.b.a.bz(17, this.Ifu) + f.a.a.b.b.a.bz(18, this.uXB) + f.a.a.b.b.a.bz(19, this.Ifv);
      paramInt = i;
      if (this.Ifw != null) {
        paramInt = i + f.a.a.a.lI(20, this.Ifw.computeSize());
      }
      i = paramInt;
      if (this.Ifx != null) {
        i = paramInt + f.a.a.a.lI(21, this.Ifx.computeSize());
      }
      i += f.a.a.b.b.a.bz(22, this.Ify);
      paramInt = i;
      if (this.Ifz != null) {
        paramInt = i + f.a.a.a.lI(23, this.Ifz.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bz(24, this.IfA) + f.a.a.b.b.a.bz(25, this.IfB) + f.a.a.b.b.a.bz(26, this.IfC);
      paramInt = i;
      if (this.IfD != null) {
        paramInt = i + f.a.a.a.lI(27, this.IfD.computeSize());
      }
      i = paramInt;
      if (this.IfE != null) {
        i = paramInt + f.a.a.a.lI(28, this.IfE.computeSize());
      }
      i += f.a.a.b.b.a.bz(29, this.IfF);
      paramInt = i;
      if (this.IfG != null) {
        paramInt = i + f.a.a.b.b.a.e(30, this.IfG);
      }
      i = paramInt + f.a.a.b.b.a.bz(31, this.IfH) + f.a.a.a.c(32, 8, this.IfI);
      paramInt = i;
      if (this.IeZ != null) {
        paramInt = i + f.a.a.a.lI(33, this.IeZ.computeSize());
      }
      i = paramInt;
      if (this.Ifa != null) {
        i = paramInt + f.a.a.a.lI(34, this.Ifa.computeSize());
      }
      paramInt = i;
      if (this.IfJ != null) {
        paramInt = i + f.a.a.a.lI(35, this.IfJ.computeSize());
      }
      AppMethodBeat.o(115900);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.IfI.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.Idl == null)
        {
          paramVarArgs = new b("Not all required fields were included: PeerId");
          AppMethodBeat.o(115900);
          throw paramVarArgs;
        }
        if (this.Idm == null)
        {
          paramVarArgs = new b("Not all required fields were included: CapInfo");
          AppMethodBeat.o(115900);
          throw paramVarArgs;
        }
        AppMethodBeat.o(115900);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dzx localdzx = (dzx)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(115900);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ead();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ead)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdzx.Idl = ((ead)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115900);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ead();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ead)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdzx.Idm = ((ead)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115900);
          return 0;
        case 3: 
          localdzx.Ifg = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(115900);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dyk();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dyk)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdzx.Ifh = ((dyk)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115900);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dyk();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dyk)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdzx.Ifi = ((dyk)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115900);
          return 0;
        case 6: 
          localdzx.Ifj = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(115900);
          return 0;
        case 7: 
          localdzx.Ifk = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(115900);
          return 0;
        case 8: 
          localdzx.Ifl = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(115900);
          return 0;
        case 9: 
          localdzx.Ifm = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(115900);
          return 0;
        case 10: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdzx.Ifn = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115900);
          return 0;
        case 11: 
          localdzx.Ifo = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(115900);
          return 0;
        case 12: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dyk();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dyk)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdzx.Ifp = ((dyk)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115900);
          return 0;
        case 13: 
          localdzx.Ifq = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(115900);
          return 0;
        case 14: 
          localdzx.Ifr = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(115900);
          return 0;
        case 15: 
          localdzx.Ifs = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(115900);
          return 0;
        case 16: 
          localdzx.Ift = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(115900);
          return 0;
        case 17: 
          localdzx.Ifu = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(115900);
          return 0;
        case 18: 
          localdzx.uXB = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(115900);
          return 0;
        case 19: 
          localdzx.Ifv = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(115900);
          return 0;
        case 20: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdzx.Ifw = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115900);
          return 0;
        case 21: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdzx.Ifx = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115900);
          return 0;
        case 22: 
          localdzx.Ify = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(115900);
          return 0;
        case 23: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdzx.Ifz = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115900);
          return 0;
        case 24: 
          localdzx.IfA = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(115900);
          return 0;
        case 25: 
          localdzx.IfB = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(115900);
          return 0;
        case 26: 
          localdzx.IfC = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(115900);
          return 0;
        case 27: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bsf();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bsf)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdzx.IfD = ((bsf)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115900);
          return 0;
        case 28: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdzx.IfE = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115900);
          return 0;
        case 29: 
          localdzx.IfF = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(115900);
          return 0;
        case 30: 
          localdzx.IfG = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(115900);
          return 0;
        case 31: 
          localdzx.IfH = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(115900);
          return 0;
        case 32: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dzy();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dzy)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdzx.IfI.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115900);
          return 0;
        case 33: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ctw();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ctw)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdzx.IeZ = ((ctw)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115900);
          return 0;
        case 34: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new afe();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((afe)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdzx.Ifa = ((afe)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115900);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bfc();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bfc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdzx.IfJ = ((bfc)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(115900);
        return 0;
      }
      AppMethodBeat.o(115900);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dzx
 * JD-Core Version:    0.7.0.1
 */