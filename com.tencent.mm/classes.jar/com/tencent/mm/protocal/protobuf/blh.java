package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class blh
  extends com.tencent.mm.bx.a
{
  public int ZUu;
  public int ZUv;
  public LinkedList<bob> ZUw;
  public float ZUx;
  public float ZUy;
  public b ZUz;
  public int height;
  public long mMJ;
  public int mMK;
  public int mML;
  public int mMM;
  public int mMN;
  public int mMO;
  public int mMP;
  public int mMQ;
  public int mMR;
  public int mMS;
  public int mMT;
  public int mMU;
  public int mMV;
  public int mMW;
  public int mMZ;
  public int mNa;
  public int mNb;
  public int mNc;
  public int mNd;
  public String mNe;
  public int mNf;
  public float mNg;
  public float mNh;
  public int width;
  
  public blh()
  {
    AppMethodBeat.i(259254);
    this.ZUw = new LinkedList();
    AppMethodBeat.o(259254);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259262);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bv(1, this.mMJ);
      paramVarArgs.bS(2, this.width);
      paramVarArgs.bS(3, this.height);
      paramVarArgs.bS(4, this.mMK);
      paramVarArgs.bS(5, this.mML);
      paramVarArgs.bS(6, this.mMM);
      paramVarArgs.bS(7, this.mMN);
      paramVarArgs.bS(8, this.mMO);
      paramVarArgs.bS(9, this.mMP);
      paramVarArgs.bS(10, this.mMQ);
      paramVarArgs.bS(11, this.mMR);
      paramVarArgs.bS(12, this.mMS);
      paramVarArgs.bS(13, this.mMT);
      paramVarArgs.bS(14, this.mMU);
      paramVarArgs.bS(15, this.mMV);
      paramVarArgs.bS(16, this.mMW);
      paramVarArgs.bS(17, this.ZUu);
      paramVarArgs.bS(18, this.ZUv);
      paramVarArgs.e(19, 8, this.ZUw);
      paramVarArgs.bS(20, this.mMZ);
      paramVarArgs.bS(21, this.mNa);
      paramVarArgs.bS(22, this.mNb);
      paramVarArgs.bS(23, this.mNc);
      paramVarArgs.bS(24, this.mNd);
      if (this.mNe != null) {
        paramVarArgs.g(25, this.mNe);
      }
      paramVarArgs.bS(26, this.mNf);
      paramVarArgs.l(27, this.mNg);
      paramVarArgs.l(28, this.mNh);
      paramVarArgs.l(29, this.ZUx);
      paramVarArgs.l(30, this.ZUy);
      if (this.ZUz != null) {
        paramVarArgs.d(31, this.ZUz);
      }
      AppMethodBeat.o(259262);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.b.b.a.q(1, this.mMJ) + 0 + i.a.a.b.b.a.cJ(2, this.width) + i.a.a.b.b.a.cJ(3, this.height) + i.a.a.b.b.a.cJ(4, this.mMK) + i.a.a.b.b.a.cJ(5, this.mML) + i.a.a.b.b.a.cJ(6, this.mMM) + i.a.a.b.b.a.cJ(7, this.mMN) + i.a.a.b.b.a.cJ(8, this.mMO) + i.a.a.b.b.a.cJ(9, this.mMP) + i.a.a.b.b.a.cJ(10, this.mMQ) + i.a.a.b.b.a.cJ(11, this.mMR) + i.a.a.b.b.a.cJ(12, this.mMS) + i.a.a.b.b.a.cJ(13, this.mMT) + i.a.a.b.b.a.cJ(14, this.mMU) + i.a.a.b.b.a.cJ(15, this.mMV) + i.a.a.b.b.a.cJ(16, this.mMW) + i.a.a.b.b.a.cJ(17, this.ZUu) + i.a.a.b.b.a.cJ(18, this.ZUv) + i.a.a.a.c(19, 8, this.ZUw) + i.a.a.b.b.a.cJ(20, this.mMZ) + i.a.a.b.b.a.cJ(21, this.mNa) + i.a.a.b.b.a.cJ(22, this.mNb) + i.a.a.b.b.a.cJ(23, this.mNc) + i.a.a.b.b.a.cJ(24, this.mNd);
      paramInt = i;
      if (this.mNe != null) {
        paramInt = i + i.a.a.b.b.a.h(25, this.mNe);
      }
      i = paramInt + i.a.a.b.b.a.cJ(26, this.mNf) + (i.a.a.b.b.a.ko(27) + 4) + (i.a.a.b.b.a.ko(28) + 4) + (i.a.a.b.b.a.ko(29) + 4) + (i.a.a.b.b.a.ko(30) + 4);
      paramInt = i;
      if (this.ZUz != null) {
        paramInt = i + i.a.a.b.b.a.c(31, this.ZUz);
      }
      AppMethodBeat.o(259262);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.ZUw.clear();
      paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(259262);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (i.a.a.a.a)paramVarArgs[0];
      blh localblh = (blh)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(259262);
        return -1;
      case 1: 
        localblh.mMJ = ((i.a.a.a.a)localObject).ajGk.aaw();
        AppMethodBeat.o(259262);
        return 0;
      case 2: 
        localblh.width = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(259262);
        return 0;
      case 3: 
        localblh.height = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(259262);
        return 0;
      case 4: 
        localblh.mMK = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(259262);
        return 0;
      case 5: 
        localblh.mML = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(259262);
        return 0;
      case 6: 
        localblh.mMM = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(259262);
        return 0;
      case 7: 
        localblh.mMN = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(259262);
        return 0;
      case 8: 
        localblh.mMO = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(259262);
        return 0;
      case 9: 
        localblh.mMP = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(259262);
        return 0;
      case 10: 
        localblh.mMQ = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(259262);
        return 0;
      case 11: 
        localblh.mMR = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(259262);
        return 0;
      case 12: 
        localblh.mMS = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(259262);
        return 0;
      case 13: 
        localblh.mMT = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(259262);
        return 0;
      case 14: 
        localblh.mMU = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(259262);
        return 0;
      case 15: 
        localblh.mMV = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(259262);
        return 0;
      case 16: 
        localblh.mMW = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(259262);
        return 0;
      case 17: 
        localblh.ZUu = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(259262);
        return 0;
      case 18: 
        localblh.ZUv = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(259262);
        return 0;
      case 19: 
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          bob localbob = new bob();
          if ((localObject != null) && (localObject.length > 0)) {
            localbob.parseFrom((byte[])localObject);
          }
          localblh.ZUw.add(localbob);
          paramInt += 1;
        }
        AppMethodBeat.o(259262);
        return 0;
      case 20: 
        localblh.mMZ = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(259262);
        return 0;
      case 21: 
        localblh.mNa = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(259262);
        return 0;
      case 22: 
        localblh.mNb = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(259262);
        return 0;
      case 23: 
        localblh.mNc = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(259262);
        return 0;
      case 24: 
        localblh.mNd = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(259262);
        return 0;
      case 25: 
        localblh.mNe = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(259262);
        return 0;
      case 26: 
        localblh.mNf = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(259262);
        return 0;
      case 27: 
        localblh.mNg = Float.intBitsToFloat(((i.a.a.a.a)localObject).ajGk.aax());
        AppMethodBeat.o(259262);
        return 0;
      case 28: 
        localblh.mNh = Float.intBitsToFloat(((i.a.a.a.a)localObject).ajGk.aax());
        AppMethodBeat.o(259262);
        return 0;
      case 29: 
        localblh.ZUx = Float.intBitsToFloat(((i.a.a.a.a)localObject).ajGk.aax());
        AppMethodBeat.o(259262);
        return 0;
      case 30: 
        localblh.ZUy = Float.intBitsToFloat(((i.a.a.a.a)localObject).ajGk.aax());
        AppMethodBeat.o(259262);
        return 0;
      }
      localblh.ZUz = ((i.a.a.a.a)localObject).ajGk.kFX();
      AppMethodBeat.o(259262);
      return 0;
    }
    AppMethodBeat.o(259262);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.blh
 * JD-Core Version:    0.7.0.1
 */