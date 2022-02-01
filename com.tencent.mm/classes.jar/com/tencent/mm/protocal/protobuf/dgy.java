package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class dgy
  extends com.tencent.mm.bx.a
{
  public String UserName;
  public int YFH;
  public int YFu;
  public String ZhO;
  public String ZhP;
  public String aaMl;
  public int aaMm;
  public String aaMn;
  public String aaMo;
  public String aaMp;
  public int aaMq;
  public int aaMr;
  public ffs aaMs;
  public ahl aaMt;
  public int aaMu;
  public String aant;
  public String aayW;
  public int pSf;
  public String pSg;
  public String pSh;
  public String pSi;
  public String pSk;
  public String pSo;
  public String pSp;
  public String vhX;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(89925);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.UserName != null) {
        paramVarArgs.g(1, this.UserName);
      }
      if (this.vhX != null) {
        paramVarArgs.g(2, this.vhX);
      }
      if (this.pSg != null) {
        paramVarArgs.g(3, this.pSg);
      }
      if (this.pSh != null) {
        paramVarArgs.g(4, this.pSh);
      }
      if (this.pSi != null) {
        paramVarArgs.g(5, this.pSi);
      }
      if (this.aaMl != null) {
        paramVarArgs.g(6, this.aaMl);
      }
      paramVarArgs.bS(7, this.pSf);
      paramVarArgs.bS(8, this.YFH);
      paramVarArgs.bS(9, this.aaMm);
      if (this.aaMn != null) {
        paramVarArgs.g(10, this.aaMn);
      }
      if (this.aayW != null) {
        paramVarArgs.g(11, this.aayW);
      }
      if (this.pSk != null) {
        paramVarArgs.g(12, this.pSk);
      }
      if (this.aaMo != null) {
        paramVarArgs.g(13, this.aaMo);
      }
      if (this.aaMp != null) {
        paramVarArgs.g(14, this.aaMp);
      }
      paramVarArgs.bS(15, this.aaMq);
      paramVarArgs.bS(19, this.aaMr);
      if (this.aaMs != null)
      {
        paramVarArgs.qD(20, this.aaMs.computeSize());
        this.aaMs.writeFields(paramVarArgs);
      }
      if (this.pSo != null) {
        paramVarArgs.g(21, this.pSo);
      }
      if (this.ZhO != null) {
        paramVarArgs.g(22, this.ZhO);
      }
      if (this.ZhP != null) {
        paramVarArgs.g(23, this.ZhP);
      }
      if (this.pSp != null) {
        paramVarArgs.g(24, this.pSp);
      }
      if (this.aaMt != null)
      {
        paramVarArgs.qD(25, this.aaMt.computeSize());
        this.aaMt.writeFields(paramVarArgs);
      }
      if (this.aant != null) {
        paramVarArgs.g(26, this.aant);
      }
      paramVarArgs.bS(27, this.YFu);
      paramVarArgs.bS(28, this.aaMu);
      AppMethodBeat.o(89925);
      return 0;
    }
    if (paramInt == 1) {
      if (this.UserName == null) {
        break label1734;
      }
    }
    label1734:
    for (int i = i.a.a.b.b.a.h(1, this.UserName) + 0;; i = 0)
    {
      paramInt = i;
      if (this.vhX != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.vhX);
      }
      i = paramInt;
      if (this.pSg != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.pSg);
      }
      paramInt = i;
      if (this.pSh != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.pSh);
      }
      i = paramInt;
      if (this.pSi != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.pSi);
      }
      paramInt = i;
      if (this.aaMl != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.aaMl);
      }
      i = paramInt + i.a.a.b.b.a.cJ(7, this.pSf) + i.a.a.b.b.a.cJ(8, this.YFH) + i.a.a.b.b.a.cJ(9, this.aaMm);
      paramInt = i;
      if (this.aaMn != null) {
        paramInt = i + i.a.a.b.b.a.h(10, this.aaMn);
      }
      i = paramInt;
      if (this.aayW != null) {
        i = paramInt + i.a.a.b.b.a.h(11, this.aayW);
      }
      paramInt = i;
      if (this.pSk != null) {
        paramInt = i + i.a.a.b.b.a.h(12, this.pSk);
      }
      i = paramInt;
      if (this.aaMo != null) {
        i = paramInt + i.a.a.b.b.a.h(13, this.aaMo);
      }
      paramInt = i;
      if (this.aaMp != null) {
        paramInt = i + i.a.a.b.b.a.h(14, this.aaMp);
      }
      i = paramInt + i.a.a.b.b.a.cJ(15, this.aaMq) + i.a.a.b.b.a.cJ(19, this.aaMr);
      paramInt = i;
      if (this.aaMs != null) {
        paramInt = i + i.a.a.a.qC(20, this.aaMs.computeSize());
      }
      i = paramInt;
      if (this.pSo != null) {
        i = paramInt + i.a.a.b.b.a.h(21, this.pSo);
      }
      paramInt = i;
      if (this.ZhO != null) {
        paramInt = i + i.a.a.b.b.a.h(22, this.ZhO);
      }
      i = paramInt;
      if (this.ZhP != null) {
        i = paramInt + i.a.a.b.b.a.h(23, this.ZhP);
      }
      paramInt = i;
      if (this.pSp != null) {
        paramInt = i + i.a.a.b.b.a.h(24, this.pSp);
      }
      i = paramInt;
      if (this.aaMt != null) {
        i = paramInt + i.a.a.a.qC(25, this.aaMt.computeSize());
      }
      paramInt = i;
      if (this.aant != null) {
        paramInt = i + i.a.a.b.b.a.h(26, this.aant);
      }
      i = i.a.a.b.b.a.cJ(27, this.YFu);
      int j = i.a.a.b.b.a.cJ(28, this.aaMu);
      AppMethodBeat.o(89925);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(89925);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        dgy localdgy = (dgy)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        case 16: 
        case 17: 
        case 18: 
        default: 
          AppMethodBeat.o(89925);
          return -1;
        case 1: 
          localdgy.UserName = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(89925);
          return 0;
        case 2: 
          localdgy.vhX = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(89925);
          return 0;
        case 3: 
          localdgy.pSg = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(89925);
          return 0;
        case 4: 
          localdgy.pSh = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(89925);
          return 0;
        case 5: 
          localdgy.pSi = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(89925);
          return 0;
        case 6: 
          localdgy.aaMl = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(89925);
          return 0;
        case 7: 
          localdgy.pSf = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(89925);
          return 0;
        case 8: 
          localdgy.YFH = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(89925);
          return 0;
        case 9: 
          localdgy.aaMm = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(89925);
          return 0;
        case 10: 
          localdgy.aaMn = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(89925);
          return 0;
        case 11: 
          localdgy.aayW = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(89925);
          return 0;
        case 12: 
          localdgy.pSk = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(89925);
          return 0;
        case 13: 
          localdgy.aaMo = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(89925);
          return 0;
        case 14: 
          localdgy.aaMp = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(89925);
          return 0;
        case 15: 
          localdgy.aaMq = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(89925);
          return 0;
        case 19: 
          localdgy.aaMr = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(89925);
          return 0;
        case 20: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new ffs();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((ffs)localObject2).parseFrom((byte[])localObject1);
            }
            localdgy.aaMs = ((ffs)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(89925);
          return 0;
        case 21: 
          localdgy.pSo = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(89925);
          return 0;
        case 22: 
          localdgy.ZhO = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(89925);
          return 0;
        case 23: 
          localdgy.ZhP = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(89925);
          return 0;
        case 24: 
          localdgy.pSp = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(89925);
          return 0;
        case 25: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new ahl();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((ahl)localObject2).parseFrom((byte[])localObject1);
            }
            localdgy.aaMt = ((ahl)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(89925);
          return 0;
        case 26: 
          localdgy.aant = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(89925);
          return 0;
        case 27: 
          localdgy.YFu = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(89925);
          return 0;
        }
        localdgy.aaMu = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(89925);
        return 0;
      }
      AppMethodBeat.o(89925);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dgy
 * JD-Core Version:    0.7.0.1
 */