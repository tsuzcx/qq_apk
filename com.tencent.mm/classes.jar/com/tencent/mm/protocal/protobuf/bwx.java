package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bwx
  extends com.tencent.mm.bw.a
{
  public String GNI;
  public String GnN;
  public String GnO;
  public dia HhA;
  public aco HhB;
  public ais HjL;
  public String Nickname;
  public String Username;
  public String jfU;
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
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(155440);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Username != null) {
        paramVarArgs.d(1, this.Username);
      }
      if (this.Nickname != null) {
        paramVarArgs.d(2, this.Nickname);
      }
      if (this.jfU != null) {
        paramVarArgs.d(3, this.jfU);
      }
      paramVarArgs.aS(4, this.jfV);
      if (this.jfW != null) {
        paramVarArgs.d(5, this.jfW);
      }
      if (this.jfX != null) {
        paramVarArgs.d(6, this.jfX);
      }
      if (this.jfY != null) {
        paramVarArgs.d(7, this.jfY);
      }
      paramVarArgs.aS(8, this.jfZ);
      if (this.jga != null) {
        paramVarArgs.d(9, this.jga);
      }
      if (this.HjL != null)
      {
        paramVarArgs.lJ(10, this.HjL.computeSize());
        this.HjL.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(11, this.jgb);
      paramVarArgs.aS(12, this.jgc);
      if (this.jgd != null) {
        paramVarArgs.d(13, this.jgd);
      }
      if (this.HhA != null)
      {
        paramVarArgs.lJ(14, this.HhA.computeSize());
        this.HhA.writeFields(paramVarArgs);
      }
      if (this.jge != null) {
        paramVarArgs.d(15, this.jge);
      }
      if (this.jgf != null) {
        paramVarArgs.d(16, this.jgf);
      }
      if (this.HhB != null)
      {
        paramVarArgs.lJ(17, this.HhB.computeSize());
        this.HhB.writeFields(paramVarArgs);
      }
      if (this.GnN != null) {
        paramVarArgs.d(20, this.GnN);
      }
      if (this.GnO != null) {
        paramVarArgs.d(21, this.GnO);
      }
      if (this.GNI != null) {
        paramVarArgs.d(22, this.GNI);
      }
      AppMethodBeat.o(155440);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Username == null) {
        break label1610;
      }
    }
    label1610:
    for (int i = f.a.a.b.b.a.e(1, this.Username) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Nickname != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.Nickname);
      }
      i = paramInt;
      if (this.jfU != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.jfU);
      }
      i += f.a.a.b.b.a.bz(4, this.jfV);
      paramInt = i;
      if (this.jfW != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.jfW);
      }
      i = paramInt;
      if (this.jfX != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.jfX);
      }
      paramInt = i;
      if (this.jfY != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.jfY);
      }
      i = paramInt + f.a.a.b.b.a.bz(8, this.jfZ);
      paramInt = i;
      if (this.jga != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.jga);
      }
      i = paramInt;
      if (this.HjL != null) {
        i = paramInt + f.a.a.a.lI(10, this.HjL.computeSize());
      }
      i = i + f.a.a.b.b.a.bz(11, this.jgb) + f.a.a.b.b.a.bz(12, this.jgc);
      paramInt = i;
      if (this.jgd != null) {
        paramInt = i + f.a.a.b.b.a.e(13, this.jgd);
      }
      i = paramInt;
      if (this.HhA != null) {
        i = paramInt + f.a.a.a.lI(14, this.HhA.computeSize());
      }
      paramInt = i;
      if (this.jge != null) {
        paramInt = i + f.a.a.b.b.a.e(15, this.jge);
      }
      i = paramInt;
      if (this.jgf != null) {
        i = paramInt + f.a.a.b.b.a.e(16, this.jgf);
      }
      paramInt = i;
      if (this.HhB != null) {
        paramInt = i + f.a.a.a.lI(17, this.HhB.computeSize());
      }
      i = paramInt;
      if (this.GnN != null) {
        i = paramInt + f.a.a.b.b.a.e(20, this.GnN);
      }
      paramInt = i;
      if (this.GnO != null) {
        paramInt = i + f.a.a.b.b.a.e(21, this.GnO);
      }
      i = paramInt;
      if (this.GNI != null) {
        i = paramInt + f.a.a.b.b.a.e(22, this.GNI);
      }
      AppMethodBeat.o(155440);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(155440);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bwx localbwx = (bwx)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        case 18: 
        case 19: 
        default: 
          AppMethodBeat.o(155440);
          return -1;
        case 1: 
          localbwx.Username = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(155440);
          return 0;
        case 2: 
          localbwx.Nickname = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(155440);
          return 0;
        case 3: 
          localbwx.jfU = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(155440);
          return 0;
        case 4: 
          localbwx.jfV = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(155440);
          return 0;
        case 5: 
          localbwx.jfW = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(155440);
          return 0;
        case 6: 
          localbwx.jfX = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(155440);
          return 0;
        case 7: 
          localbwx.jfY = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(155440);
          return 0;
        case 8: 
          localbwx.jfZ = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(155440);
          return 0;
        case 9: 
          localbwx.jga = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(155440);
          return 0;
        case 10: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ais();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ais)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbwx.HjL = ((ais)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(155440);
          return 0;
        case 11: 
          localbwx.jgb = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(155440);
          return 0;
        case 12: 
          localbwx.jgc = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(155440);
          return 0;
        case 13: 
          localbwx.jgd = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(155440);
          return 0;
        case 14: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dia();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dia)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbwx.HhA = ((dia)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(155440);
          return 0;
        case 15: 
          localbwx.jge = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(155440);
          return 0;
        case 16: 
          localbwx.jgf = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(155440);
          return 0;
        case 17: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new aco();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((aco)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbwx.HhB = ((aco)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(155440);
          return 0;
        case 20: 
          localbwx.GnN = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(155440);
          return 0;
        case 21: 
          localbwx.GnO = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(155440);
          return 0;
        }
        localbwx.GNI = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(155440);
        return 0;
      }
      AppMethodBeat.o(155440);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bwx
 * JD-Core Version:    0.7.0.1
 */