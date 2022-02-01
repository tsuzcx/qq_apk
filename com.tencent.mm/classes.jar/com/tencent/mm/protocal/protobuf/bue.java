package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class bue
  extends com.tencent.mm.bw.a
{
  public int FNJ;
  public String GNI;
  public String GXa;
  public String GnN;
  public String GnO;
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
  public String jga;
  public String jge;
  public String jgf;
  public String nIJ;
  public String nJO;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(89925);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
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
      paramVarArgs.aS(9, this.Hhu);
      if (this.Hhv != null) {
        paramVarArgs.d(10, this.Hhv);
      }
      if (this.GXa != null) {
        paramVarArgs.d(11, this.GXa);
      }
      if (this.jga != null) {
        paramVarArgs.d(12, this.jga);
      }
      if (this.Hhw != null) {
        paramVarArgs.d(13, this.Hhw);
      }
      if (this.Hhx != null) {
        paramVarArgs.d(14, this.Hhx);
      }
      paramVarArgs.aS(15, this.Hhy);
      paramVarArgs.aS(19, this.Hhz);
      if (this.HhA != null)
      {
        paramVarArgs.lJ(20, this.HhA.computeSize());
        this.HhA.writeFields(paramVarArgs);
      }
      if (this.jge != null) {
        paramVarArgs.d(21, this.jge);
      }
      if (this.GnN != null) {
        paramVarArgs.d(22, this.GnN);
      }
      if (this.GnO != null) {
        paramVarArgs.d(23, this.GnO);
      }
      if (this.jgf != null) {
        paramVarArgs.d(24, this.jgf);
      }
      if (this.HhB != null)
      {
        paramVarArgs.lJ(25, this.HhB.computeSize());
        this.HhB.writeFields(paramVarArgs);
      }
      if (this.GNI != null) {
        paramVarArgs.d(26, this.GNI);
      }
      AppMethodBeat.o(89925);
      return 0;
    }
    if (paramInt == 1) {
      if (this.nIJ == null) {
        break label1686;
      }
    }
    label1686:
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
      i = paramInt + f.a.a.b.b.a.bz(7, this.jfV) + f.a.a.b.b.a.bz(8, this.FNJ) + f.a.a.b.b.a.bz(9, this.Hhu);
      paramInt = i;
      if (this.Hhv != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.Hhv);
      }
      i = paramInt;
      if (this.GXa != null) {
        i = paramInt + f.a.a.b.b.a.e(11, this.GXa);
      }
      paramInt = i;
      if (this.jga != null) {
        paramInt = i + f.a.a.b.b.a.e(12, this.jga);
      }
      i = paramInt;
      if (this.Hhw != null) {
        i = paramInt + f.a.a.b.b.a.e(13, this.Hhw);
      }
      paramInt = i;
      if (this.Hhx != null) {
        paramInt = i + f.a.a.b.b.a.e(14, this.Hhx);
      }
      i = paramInt + f.a.a.b.b.a.bz(15, this.Hhy) + f.a.a.b.b.a.bz(19, this.Hhz);
      paramInt = i;
      if (this.HhA != null) {
        paramInt = i + f.a.a.a.lI(20, this.HhA.computeSize());
      }
      i = paramInt;
      if (this.jge != null) {
        i = paramInt + f.a.a.b.b.a.e(21, this.jge);
      }
      paramInt = i;
      if (this.GnN != null) {
        paramInt = i + f.a.a.b.b.a.e(22, this.GnN);
      }
      i = paramInt;
      if (this.GnO != null) {
        i = paramInt + f.a.a.b.b.a.e(23, this.GnO);
      }
      paramInt = i;
      if (this.jgf != null) {
        paramInt = i + f.a.a.b.b.a.e(24, this.jgf);
      }
      i = paramInt;
      if (this.HhB != null) {
        i = paramInt + f.a.a.a.lI(25, this.HhB.computeSize());
      }
      paramInt = i;
      if (this.GNI != null) {
        paramInt = i + f.a.a.b.b.a.e(26, this.GNI);
      }
      AppMethodBeat.o(89925);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(89925);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bue localbue = (bue)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        case 16: 
        case 17: 
        case 18: 
        default: 
          AppMethodBeat.o(89925);
          return -1;
        case 1: 
          localbue.nIJ = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(89925);
          return 0;
        case 2: 
          localbue.nJO = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(89925);
          return 0;
        case 3: 
          localbue.jfW = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(89925);
          return 0;
        case 4: 
          localbue.jfX = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(89925);
          return 0;
        case 5: 
          localbue.jfY = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(89925);
          return 0;
        case 6: 
          localbue.Hht = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(89925);
          return 0;
        case 7: 
          localbue.jfV = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(89925);
          return 0;
        case 8: 
          localbue.FNJ = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(89925);
          return 0;
        case 9: 
          localbue.Hhu = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(89925);
          return 0;
        case 10: 
          localbue.Hhv = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(89925);
          return 0;
        case 11: 
          localbue.GXa = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(89925);
          return 0;
        case 12: 
          localbue.jga = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(89925);
          return 0;
        case 13: 
          localbue.Hhw = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(89925);
          return 0;
        case 14: 
          localbue.Hhx = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(89925);
          return 0;
        case 15: 
          localbue.Hhy = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(89925);
          return 0;
        case 19: 
          localbue.Hhz = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(89925);
          return 0;
        case 20: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dia();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dia)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbue.HhA = ((dia)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(89925);
          return 0;
        case 21: 
          localbue.jge = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(89925);
          return 0;
        case 22: 
          localbue.GnN = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(89925);
          return 0;
        case 23: 
          localbue.GnO = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(89925);
          return 0;
        case 24: 
          localbue.jgf = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(89925);
          return 0;
        case 25: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new aco();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((aco)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbue.HhB = ((aco)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(89925);
          return 0;
        }
        localbue.GNI = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(89925);
        return 0;
      }
      AppMethodBeat.o(89925);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bue
 * JD-Core Version:    0.7.0.1
 */