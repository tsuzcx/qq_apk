package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class ecj
  extends com.tencent.mm.cd.a
{
  public String SjI;
  public String SjJ;
  public eaf SrH;
  public eaf TtX;
  public int TxF;
  public String TxG;
  public String TxH;
  public String TxI;
  public int TxJ;
  public aez TxM;
  public String mVA;
  public String mVB;
  public int mVC;
  public String mVD;
  public String mVH;
  public int mVy;
  public String mVz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(6431);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.SrH == null)
      {
        paramVarArgs = new b("Not all required fields were included: UserName");
        AppMethodBeat.o(6431);
        throw paramVarArgs;
      }
      if (this.TtX == null)
      {
        paramVarArgs = new b("Not all required fields were included: NickName");
        AppMethodBeat.o(6431);
        throw paramVarArgs;
      }
      if (this.SrH != null)
      {
        paramVarArgs.oE(1, this.SrH.computeSize());
        this.SrH.writeFields(paramVarArgs);
      }
      if (this.TtX != null)
      {
        paramVarArgs.oE(2, this.TtX.computeSize());
        this.TtX.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(3, this.mVy);
      if (this.mVz != null) {
        paramVarArgs.f(4, this.mVz);
      }
      if (this.mVA != null) {
        paramVarArgs.f(5, this.mVA);
      }
      if (this.mVB != null) {
        paramVarArgs.f(6, this.mVB);
      }
      paramVarArgs.aY(7, this.mVC);
      paramVarArgs.aY(8, this.TxF);
      if (this.TxG != null) {
        paramVarArgs.f(9, this.TxG);
      }
      if (this.TxH != null) {
        paramVarArgs.f(10, this.TxH);
      }
      if (this.mVD != null) {
        paramVarArgs.f(11, this.mVD);
      }
      if (this.TxI != null) {
        paramVarArgs.f(12, this.TxI);
      }
      paramVarArgs.aY(13, this.TxJ);
      if (this.mVH != null) {
        paramVarArgs.f(14, this.mVH);
      }
      if (this.TxM != null)
      {
        paramVarArgs.oE(15, this.TxM.computeSize());
        this.TxM.writeFields(paramVarArgs);
      }
      if (this.SjI != null) {
        paramVarArgs.f(16, this.SjI);
      }
      if (this.SjJ != null) {
        paramVarArgs.f(17, this.SjJ);
      }
      AppMethodBeat.o(6431);
      return 0;
    }
    if (paramInt == 1) {
      if (this.SrH == null) {
        break label1475;
      }
    }
    label1475:
    for (paramInt = g.a.a.a.oD(1, this.SrH.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.TtX != null) {
        i = paramInt + g.a.a.a.oD(2, this.TtX.computeSize());
      }
      i += g.a.a.b.b.a.bM(3, this.mVy);
      paramInt = i;
      if (this.mVz != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.mVz);
      }
      i = paramInt;
      if (this.mVA != null) {
        i = paramInt + g.a.a.b.b.a.g(5, this.mVA);
      }
      paramInt = i;
      if (this.mVB != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.mVB);
      }
      i = paramInt + g.a.a.b.b.a.bM(7, this.mVC) + g.a.a.b.b.a.bM(8, this.TxF);
      paramInt = i;
      if (this.TxG != null) {
        paramInt = i + g.a.a.b.b.a.g(9, this.TxG);
      }
      i = paramInt;
      if (this.TxH != null) {
        i = paramInt + g.a.a.b.b.a.g(10, this.TxH);
      }
      paramInt = i;
      if (this.mVD != null) {
        paramInt = i + g.a.a.b.b.a.g(11, this.mVD);
      }
      i = paramInt;
      if (this.TxI != null) {
        i = paramInt + g.a.a.b.b.a.g(12, this.TxI);
      }
      i += g.a.a.b.b.a.bM(13, this.TxJ);
      paramInt = i;
      if (this.mVH != null) {
        paramInt = i + g.a.a.b.b.a.g(14, this.mVH);
      }
      i = paramInt;
      if (this.TxM != null) {
        i = paramInt + g.a.a.a.oD(15, this.TxM.computeSize());
      }
      paramInt = i;
      if (this.SjI != null) {
        paramInt = i + g.a.a.b.b.a.g(16, this.SjI);
      }
      i = paramInt;
      if (this.SjJ != null) {
        i = paramInt + g.a.a.b.b.a.g(17, this.SjJ);
      }
      AppMethodBeat.o(6431);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.SrH == null)
        {
          paramVarArgs = new b("Not all required fields were included: UserName");
          AppMethodBeat.o(6431);
          throw paramVarArgs;
        }
        if (this.TtX == null)
        {
          paramVarArgs = new b("Not all required fields were included: NickName");
          AppMethodBeat.o(6431);
          throw paramVarArgs;
        }
        AppMethodBeat.o(6431);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        ecj localecj = (ecj)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(6431);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new eaf();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((eaf)localObject2).de((byte[])localObject1);
            }
            localecj.SrH = ((eaf)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(6431);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new eaf();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((eaf)localObject2).de((byte[])localObject1);
            }
            localecj.TtX = ((eaf)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(6431);
          return 0;
        case 3: 
          localecj.mVy = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(6431);
          return 0;
        case 4: 
          localecj.mVz = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(6431);
          return 0;
        case 5: 
          localecj.mVA = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(6431);
          return 0;
        case 6: 
          localecj.mVB = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(6431);
          return 0;
        case 7: 
          localecj.mVC = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(6431);
          return 0;
        case 8: 
          localecj.TxF = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(6431);
          return 0;
        case 9: 
          localecj.TxG = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(6431);
          return 0;
        case 10: 
          localecj.TxH = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(6431);
          return 0;
        case 11: 
          localecj.mVD = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(6431);
          return 0;
        case 12: 
          localecj.TxI = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(6431);
          return 0;
        case 13: 
          localecj.TxJ = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(6431);
          return 0;
        case 14: 
          localecj.mVH = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(6431);
          return 0;
        case 15: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new aez();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((aez)localObject2).parseFrom((byte[])localObject1);
            }
            localecj.TxM = ((aez)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(6431);
          return 0;
        case 16: 
          localecj.SjI = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(6431);
          return 0;
        }
        localecj.SjJ = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(6431);
        return 0;
      }
      AppMethodBeat.o(6431);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ecj
 * JD-Core Version:    0.7.0.1
 */