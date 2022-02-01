package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class ddr
  extends com.tencent.mm.bw.a
{
  public int FNJ;
  public String GNI;
  public String GXa;
  public String GnN;
  public String GnO;
  public int HLg;
  public SKBuiltinBuffer_t HLh;
  public int HLi;
  public dia HhA;
  public aco HhB;
  public String Hht;
  public int Hhu;
  public String Hhv;
  public String Hhw;
  public String Hhx;
  public int Hhy;
  public int Hhz;
  public int jfV;
  public String jfW;
  public String jfX;
  public String jfY;
  public String jge;
  public String jgf;
  public String nIJ;
  public String nJO;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32440);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.HLh == null)
      {
        paramVarArgs = new b("Not all required fields were included: ImgBuffer");
        AppMethodBeat.o(32440);
        throw paramVarArgs;
      }
      if (this.nIJ != null) {
        paramVarArgs.d(1, this.nIJ);
      }
      if (this.nJO != null) {
        paramVarArgs.d(2, this.nJO);
      }
      if (this.jfW != null) {
        paramVarArgs.d(3, this.jfW);
      }
      if (this.jfX != null) {
        paramVarArgs.d(4, this.jfX);
      }
      if (this.jfY != null) {
        paramVarArgs.d(5, this.jfY);
      }
      if (this.Hht != null) {
        paramVarArgs.d(6, this.Hht);
      }
      paramVarArgs.aS(7, this.jfV);
      paramVarArgs.aS(8, this.FNJ);
      paramVarArgs.aS(9, this.HLg);
      if (this.HLh != null)
      {
        paramVarArgs.lJ(10, this.HLh.computeSize());
        this.HLh.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(11, this.HLi);
      if (this.Hhw != null) {
        paramVarArgs.d(12, this.Hhw);
      }
      if (this.Hhx != null) {
        paramVarArgs.d(13, this.Hhx);
      }
      paramVarArgs.aS(14, this.Hhy);
      paramVarArgs.aS(15, this.Hhu);
      if (this.Hhv != null) {
        paramVarArgs.d(16, this.Hhv);
      }
      if (this.GXa != null) {
        paramVarArgs.d(17, this.GXa);
      }
      paramVarArgs.aS(21, this.Hhz);
      if (this.HhA != null)
      {
        paramVarArgs.lJ(22, this.HhA.computeSize());
        this.HhA.writeFields(paramVarArgs);
      }
      if (this.jge != null) {
        paramVarArgs.d(23, this.jge);
      }
      if (this.GnN != null) {
        paramVarArgs.d(24, this.GnN);
      }
      if (this.GnO != null) {
        paramVarArgs.d(25, this.GnO);
      }
      if (this.jgf != null) {
        paramVarArgs.d(26, this.jgf);
      }
      if (this.HhB != null)
      {
        paramVarArgs.lJ(27, this.HhB.computeSize());
        this.HhB.writeFields(paramVarArgs);
      }
      if (this.GNI != null) {
        paramVarArgs.d(28, this.GNI);
      }
      AppMethodBeat.o(32440);
      return 0;
    }
    if (paramInt == 1) {
      if (this.nIJ == null) {
        break label1953;
      }
    }
    label1953:
    for (int i = f.a.a.b.b.a.e(1, this.nIJ) + 0;; i = 0)
    {
      paramInt = i;
      if (this.nJO != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.nJO);
      }
      i = paramInt;
      if (this.jfW != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.jfW);
      }
      paramInt = i;
      if (this.jfX != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.jfX);
      }
      i = paramInt;
      if (this.jfY != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.jfY);
      }
      paramInt = i;
      if (this.Hht != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.Hht);
      }
      i = paramInt + f.a.a.b.b.a.bz(7, this.jfV) + f.a.a.b.b.a.bz(8, this.FNJ) + f.a.a.b.b.a.bz(9, this.HLg);
      paramInt = i;
      if (this.HLh != null) {
        paramInt = i + f.a.a.a.lI(10, this.HLh.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bz(11, this.HLi);
      paramInt = i;
      if (this.Hhw != null) {
        paramInt = i + f.a.a.b.b.a.e(12, this.Hhw);
      }
      i = paramInt;
      if (this.Hhx != null) {
        i = paramInt + f.a.a.b.b.a.e(13, this.Hhx);
      }
      i = i + f.a.a.b.b.a.bz(14, this.Hhy) + f.a.a.b.b.a.bz(15, this.Hhu);
      paramInt = i;
      if (this.Hhv != null) {
        paramInt = i + f.a.a.b.b.a.e(16, this.Hhv);
      }
      i = paramInt;
      if (this.GXa != null) {
        i = paramInt + f.a.a.b.b.a.e(17, this.GXa);
      }
      i += f.a.a.b.b.a.bz(21, this.Hhz);
      paramInt = i;
      if (this.HhA != null) {
        paramInt = i + f.a.a.a.lI(22, this.HhA.computeSize());
      }
      i = paramInt;
      if (this.jge != null) {
        i = paramInt + f.a.a.b.b.a.e(23, this.jge);
      }
      paramInt = i;
      if (this.GnN != null) {
        paramInt = i + f.a.a.b.b.a.e(24, this.GnN);
      }
      i = paramInt;
      if (this.GnO != null) {
        i = paramInt + f.a.a.b.b.a.e(25, this.GnO);
      }
      paramInt = i;
      if (this.jgf != null) {
        paramInt = i + f.a.a.b.b.a.e(26, this.jgf);
      }
      i = paramInt;
      if (this.HhB != null) {
        i = paramInt + f.a.a.a.lI(27, this.HhB.computeSize());
      }
      paramInt = i;
      if (this.GNI != null) {
        paramInt = i + f.a.a.b.b.a.e(28, this.GNI);
      }
      AppMethodBeat.o(32440);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.HLh == null)
        {
          paramVarArgs = new b("Not all required fields were included: ImgBuffer");
          AppMethodBeat.o(32440);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32440);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ddr localddr = (ddr)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        case 18: 
        case 19: 
        case 20: 
        default: 
          AppMethodBeat.o(32440);
          return -1;
        case 1: 
          localddr.nIJ = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(32440);
          return 0;
        case 2: 
          localddr.nJO = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(32440);
          return 0;
        case 3: 
          localddr.jfW = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(32440);
          return 0;
        case 4: 
          localddr.jfX = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(32440);
          return 0;
        case 5: 
          localddr.jfY = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(32440);
          return 0;
        case 6: 
          localddr.Hht = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(32440);
          return 0;
        case 7: 
          localddr.jfV = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(32440);
          return 0;
        case 8: 
          localddr.FNJ = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(32440);
          return 0;
        case 9: 
          localddr.HLg = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(32440);
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
            localddr.HLh = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32440);
          return 0;
        case 11: 
          localddr.HLi = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(32440);
          return 0;
        case 12: 
          localddr.Hhw = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(32440);
          return 0;
        case 13: 
          localddr.Hhx = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(32440);
          return 0;
        case 14: 
          localddr.Hhy = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(32440);
          return 0;
        case 15: 
          localddr.Hhu = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(32440);
          return 0;
        case 16: 
          localddr.Hhv = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(32440);
          return 0;
        case 17: 
          localddr.GXa = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(32440);
          return 0;
        case 21: 
          localddr.Hhz = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(32440);
          return 0;
        case 22: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dia();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dia)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localddr.HhA = ((dia)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32440);
          return 0;
        case 23: 
          localddr.jge = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(32440);
          return 0;
        case 24: 
          localddr.GnN = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(32440);
          return 0;
        case 25: 
          localddr.GnO = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(32440);
          return 0;
        case 26: 
          localddr.jgf = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(32440);
          return 0;
        case 27: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new aco();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((aco)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localddr.HhB = ((aco)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32440);
          return 0;
        }
        localddr.GNI = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(32440);
        return 0;
      }
      AppMethodBeat.o(32440);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ddr
 * JD-Core Version:    0.7.0.1
 */