package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class vw
  extends com.tencent.mm.bx.a
{
  public LinkedList<vu> ZcA;
  public LinkedList<vt> ZcB;
  public String ZcC;
  public String ZcD;
  public wg ZcE;
  public vu ZcF;
  public int ZcG;
  public int ZcH;
  public int ZcI;
  public long ZcJ;
  public int Zcl;
  public String Zcm;
  public wg Zcn;
  public String Zco;
  public String Zcw;
  public String Zcx;
  public String Zcy;
  public String Zcz;
  
  public vw()
  {
    AppMethodBeat.i(113954);
    this.ZcA = new LinkedList();
    this.ZcB = new LinkedList();
    AppMethodBeat.o(113954);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(113955);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.Zcw != null) {
        paramVarArgs.g(1, this.Zcw);
      }
      if (this.Zcx != null) {
        paramVarArgs.g(2, this.Zcx);
      }
      if (this.Zcy != null) {
        paramVarArgs.g(3, this.Zcy);
      }
      if (this.Zcz != null) {
        paramVarArgs.g(4, this.Zcz);
      }
      paramVarArgs.e(5, 8, this.ZcA);
      paramVarArgs.bS(6, this.Zcl);
      if (this.Zcm != null) {
        paramVarArgs.g(7, this.Zcm);
      }
      if (this.Zcn != null)
      {
        paramVarArgs.qD(8, this.Zcn.computeSize());
        this.Zcn.writeFields(paramVarArgs);
      }
      if (this.Zco != null) {
        paramVarArgs.g(9, this.Zco);
      }
      paramVarArgs.e(10, 8, this.ZcB);
      if (this.ZcC != null) {
        paramVarArgs.g(11, this.ZcC);
      }
      if (this.ZcD != null) {
        paramVarArgs.g(12, this.ZcD);
      }
      if (this.ZcE != null)
      {
        paramVarArgs.qD(13, this.ZcE.computeSize());
        this.ZcE.writeFields(paramVarArgs);
      }
      if (this.ZcF != null)
      {
        paramVarArgs.qD(14, this.ZcF.computeSize());
        this.ZcF.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(15, this.ZcG);
      paramVarArgs.bS(16, this.ZcH);
      paramVarArgs.bS(17, this.ZcI);
      paramVarArgs.bv(18, this.ZcJ);
      AppMethodBeat.o(113955);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Zcw == null) {
        break label1516;
      }
    }
    label1516:
    for (int i = i.a.a.b.b.a.h(1, this.Zcw) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Zcx != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.Zcx);
      }
      i = paramInt;
      if (this.Zcy != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.Zcy);
      }
      paramInt = i;
      if (this.Zcz != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.Zcz);
      }
      i = paramInt + i.a.a.a.c(5, 8, this.ZcA) + i.a.a.b.b.a.cJ(6, this.Zcl);
      paramInt = i;
      if (this.Zcm != null) {
        paramInt = i + i.a.a.b.b.a.h(7, this.Zcm);
      }
      i = paramInt;
      if (this.Zcn != null) {
        i = paramInt + i.a.a.a.qC(8, this.Zcn.computeSize());
      }
      paramInt = i;
      if (this.Zco != null) {
        paramInt = i + i.a.a.b.b.a.h(9, this.Zco);
      }
      i = paramInt + i.a.a.a.c(10, 8, this.ZcB);
      paramInt = i;
      if (this.ZcC != null) {
        paramInt = i + i.a.a.b.b.a.h(11, this.ZcC);
      }
      i = paramInt;
      if (this.ZcD != null) {
        i = paramInt + i.a.a.b.b.a.h(12, this.ZcD);
      }
      paramInt = i;
      if (this.ZcE != null) {
        paramInt = i + i.a.a.a.qC(13, this.ZcE.computeSize());
      }
      i = paramInt;
      if (this.ZcF != null) {
        i = paramInt + i.a.a.a.qC(14, this.ZcF.computeSize());
      }
      paramInt = i.a.a.b.b.a.cJ(15, this.ZcG);
      int j = i.a.a.b.b.a.cJ(16, this.ZcH);
      int k = i.a.a.b.b.a.cJ(17, this.ZcI);
      int m = i.a.a.b.b.a.q(18, this.ZcJ);
      AppMethodBeat.o(113955);
      return i + paramInt + j + k + m;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.ZcA.clear();
        this.ZcB.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(113955);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        vw localvw = (vw)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(113955);
          return -1;
        case 1: 
          localvw.Zcw = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(113955);
          return 0;
        case 2: 
          localvw.Zcx = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(113955);
          return 0;
        case 3: 
          localvw.Zcy = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(113955);
          return 0;
        case 4: 
          localvw.Zcz = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(113955);
          return 0;
        case 5: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new vu();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((vu)localObject2).parseFrom((byte[])localObject1);
            }
            localvw.ZcA.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(113955);
          return 0;
        case 6: 
          localvw.Zcl = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(113955);
          return 0;
        case 7: 
          localvw.Zcm = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(113955);
          return 0;
        case 8: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new wg();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((wg)localObject2).parseFrom((byte[])localObject1);
            }
            localvw.Zcn = ((wg)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(113955);
          return 0;
        case 9: 
          localvw.Zco = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(113955);
          return 0;
        case 10: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new vt();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((vt)localObject2).parseFrom((byte[])localObject1);
            }
            localvw.ZcB.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(113955);
          return 0;
        case 11: 
          localvw.ZcC = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(113955);
          return 0;
        case 12: 
          localvw.ZcD = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(113955);
          return 0;
        case 13: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new wg();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((wg)localObject2).parseFrom((byte[])localObject1);
            }
            localvw.ZcE = ((wg)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(113955);
          return 0;
        case 14: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new vu();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((vu)localObject2).parseFrom((byte[])localObject1);
            }
            localvw.ZcF = ((vu)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(113955);
          return 0;
        case 15: 
          localvw.ZcG = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(113955);
          return 0;
        case 16: 
          localvw.ZcH = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(113955);
          return 0;
        case 17: 
          localvw.ZcI = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(113955);
          return 0;
        }
        localvw.ZcJ = ((i.a.a.a.a)localObject1).ajGk.aaw();
        AppMethodBeat.o(113955);
        return 0;
      }
      AppMethodBeat.o(113955);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.vw
 * JD-Core Version:    0.7.0.1
 */