package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ao
  extends bvk
{
  public String color;
  public String content;
  public String kml;
  public LinkedList<ap> kne;
  public LinkedList<aq> knf;
  public String kng;
  public int knh;
  public String kni;
  public String knj;
  public String knk;
  public String knl;
  public String wlP;
  public String wlQ;
  public String wlR;
  public String wlS;
  public String wlT;
  public String wlU;
  public String wlV;
  public String wlW;
  public String wlX;
  public String wlY;
  public String wlZ;
  public String wma;
  public boolean wmb;
  public int wmc;
  public int wmd;
  public int wme;
  public String wmf;
  public String wmg;
  public int wmh;
  public String wmi;
  public String wmj;
  public String wmk;
  public String wml;
  public String wmm;
  public String wmn;
  public String wmo;
  public String wmp;
  
  public ao()
  {
    AppMethodBeat.i(88999);
    this.wmb = false;
    this.kne = new LinkedList();
    this.knf = new LinkedList();
    AppMethodBeat.o(88999);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(89000);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.iQ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.wlP != null) {
        paramVarArgs.e(2, this.wlP);
      }
      if (this.wlQ != null) {
        paramVarArgs.e(3, this.wlQ);
      }
      if (this.wlR != null) {
        paramVarArgs.e(4, this.wlR);
      }
      if (this.content != null) {
        paramVarArgs.e(5, this.content);
      }
      if (this.wlS != null) {
        paramVarArgs.e(6, this.wlS);
      }
      if (this.wlT != null) {
        paramVarArgs.e(7, this.wlT);
      }
      if (this.wlU != null) {
        paramVarArgs.e(8, this.wlU);
      }
      if (this.wlV != null) {
        paramVarArgs.e(9, this.wlV);
      }
      if (this.wlW != null) {
        paramVarArgs.e(10, this.wlW);
      }
      if (this.wlX != null) {
        paramVarArgs.e(11, this.wlX);
      }
      if (this.wlY != null) {
        paramVarArgs.e(12, this.wlY);
      }
      if (this.wlZ != null) {
        paramVarArgs.e(13, this.wlZ);
      }
      if (this.knk != null) {
        paramVarArgs.e(14, this.knk);
      }
      if (this.knl != null) {
        paramVarArgs.e(15, this.knl);
      }
      if (this.wma != null) {
        paramVarArgs.e(16, this.wma);
      }
      paramVarArgs.aS(17, this.wmb);
      paramVarArgs.aO(18, this.wmc);
      paramVarArgs.aO(19, this.wmd);
      paramVarArgs.aO(20, this.wme);
      if (this.color != null) {
        paramVarArgs.e(21, this.color);
      }
      if (this.wmf != null) {
        paramVarArgs.e(22, this.wmf);
      }
      if (this.wmg != null) {
        paramVarArgs.e(23, this.wmg);
      }
      paramVarArgs.aO(24, this.wmh);
      if (this.wmi != null) {
        paramVarArgs.e(25, this.wmi);
      }
      if (this.wmj != null) {
        paramVarArgs.e(26, this.wmj);
      }
      if (this.wmk != null) {
        paramVarArgs.e(27, this.wmk);
      }
      if (this.wml != null) {
        paramVarArgs.e(28, this.wml);
      }
      if (this.wmm != null) {
        paramVarArgs.e(29, this.wmm);
      }
      if (this.wmn != null) {
        paramVarArgs.e(30, this.wmn);
      }
      if (this.wmo != null) {
        paramVarArgs.e(31, this.wmo);
      }
      if (this.kml != null) {
        paramVarArgs.e(32, this.kml);
      }
      if (this.wmp != null) {
        paramVarArgs.e(33, this.wmp);
      }
      paramVarArgs.e(34, 8, this.kne);
      paramVarArgs.e(35, 8, this.knf);
      if (this.kng != null) {
        paramVarArgs.e(36, this.kng);
      }
      paramVarArgs.aO(37, this.knh);
      if (this.kni != null) {
        paramVarArgs.e(38, this.kni);
      }
      if (this.knj != null) {
        paramVarArgs.e(39, this.knj);
      }
      AppMethodBeat.o(89000);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label2714;
      }
    }
    label2714:
    for (int i = e.a.a.a.iP(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.wlP != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.wlP);
      }
      i = paramInt;
      if (this.wlQ != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.wlQ);
      }
      paramInt = i;
      if (this.wlR != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.wlR);
      }
      i = paramInt;
      if (this.content != null) {
        i = paramInt + e.a.a.b.b.a.f(5, this.content);
      }
      paramInt = i;
      if (this.wlS != null) {
        paramInt = i + e.a.a.b.b.a.f(6, this.wlS);
      }
      i = paramInt;
      if (this.wlT != null) {
        i = paramInt + e.a.a.b.b.a.f(7, this.wlT);
      }
      paramInt = i;
      if (this.wlU != null) {
        paramInt = i + e.a.a.b.b.a.f(8, this.wlU);
      }
      i = paramInt;
      if (this.wlV != null) {
        i = paramInt + e.a.a.b.b.a.f(9, this.wlV);
      }
      paramInt = i;
      if (this.wlW != null) {
        paramInt = i + e.a.a.b.b.a.f(10, this.wlW);
      }
      i = paramInt;
      if (this.wlX != null) {
        i = paramInt + e.a.a.b.b.a.f(11, this.wlX);
      }
      paramInt = i;
      if (this.wlY != null) {
        paramInt = i + e.a.a.b.b.a.f(12, this.wlY);
      }
      i = paramInt;
      if (this.wlZ != null) {
        i = paramInt + e.a.a.b.b.a.f(13, this.wlZ);
      }
      paramInt = i;
      if (this.knk != null) {
        paramInt = i + e.a.a.b.b.a.f(14, this.knk);
      }
      i = paramInt;
      if (this.knl != null) {
        i = paramInt + e.a.a.b.b.a.f(15, this.knl);
      }
      paramInt = i;
      if (this.wma != null) {
        paramInt = i + e.a.a.b.b.a.f(16, this.wma);
      }
      i = paramInt + (e.a.a.b.b.a.eW(17) + 1) + e.a.a.b.b.a.bl(18, this.wmc) + e.a.a.b.b.a.bl(19, this.wmd) + e.a.a.b.b.a.bl(20, this.wme);
      paramInt = i;
      if (this.color != null) {
        paramInt = i + e.a.a.b.b.a.f(21, this.color);
      }
      i = paramInt;
      if (this.wmf != null) {
        i = paramInt + e.a.a.b.b.a.f(22, this.wmf);
      }
      paramInt = i;
      if (this.wmg != null) {
        paramInt = i + e.a.a.b.b.a.f(23, this.wmg);
      }
      i = paramInt + e.a.a.b.b.a.bl(24, this.wmh);
      paramInt = i;
      if (this.wmi != null) {
        paramInt = i + e.a.a.b.b.a.f(25, this.wmi);
      }
      i = paramInt;
      if (this.wmj != null) {
        i = paramInt + e.a.a.b.b.a.f(26, this.wmj);
      }
      paramInt = i;
      if (this.wmk != null) {
        paramInt = i + e.a.a.b.b.a.f(27, this.wmk);
      }
      i = paramInt;
      if (this.wml != null) {
        i = paramInt + e.a.a.b.b.a.f(28, this.wml);
      }
      paramInt = i;
      if (this.wmm != null) {
        paramInt = i + e.a.a.b.b.a.f(29, this.wmm);
      }
      i = paramInt;
      if (this.wmn != null) {
        i = paramInt + e.a.a.b.b.a.f(30, this.wmn);
      }
      paramInt = i;
      if (this.wmo != null) {
        paramInt = i + e.a.a.b.b.a.f(31, this.wmo);
      }
      i = paramInt;
      if (this.kml != null) {
        i = paramInt + e.a.a.b.b.a.f(32, this.kml);
      }
      paramInt = i;
      if (this.wmp != null) {
        paramInt = i + e.a.a.b.b.a.f(33, this.wmp);
      }
      i = paramInt + e.a.a.a.c(34, 8, this.kne) + e.a.a.a.c(35, 8, this.knf);
      paramInt = i;
      if (this.kng != null) {
        paramInt = i + e.a.a.b.b.a.f(36, this.kng);
      }
      i = paramInt + e.a.a.b.b.a.bl(37, this.knh);
      paramInt = i;
      if (this.kni != null) {
        paramInt = i + e.a.a.b.b.a.f(38, this.kni);
      }
      i = paramInt;
      if (this.knj != null) {
        i = paramInt + e.a.a.b.b.a.f(39, this.knj);
      }
      AppMethodBeat.o(89000);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.kne.clear();
        this.knf.clear();
        paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = bvk.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = bvk.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(89000);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        ao localao = (ao)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(89000);
          return -1;
        case 1: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localao.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(89000);
          return 0;
        case 2: 
          localao.wlP = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(89000);
          return 0;
        case 3: 
          localao.wlQ = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(89000);
          return 0;
        case 4: 
          localao.wlR = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(89000);
          return 0;
        case 5: 
          localao.content = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(89000);
          return 0;
        case 6: 
          localao.wlS = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(89000);
          return 0;
        case 7: 
          localao.wlT = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(89000);
          return 0;
        case 8: 
          localao.wlU = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(89000);
          return 0;
        case 9: 
          localao.wlV = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(89000);
          return 0;
        case 10: 
          localao.wlW = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(89000);
          return 0;
        case 11: 
          localao.wlX = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(89000);
          return 0;
        case 12: 
          localao.wlY = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(89000);
          return 0;
        case 13: 
          localao.wlZ = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(89000);
          return 0;
        case 14: 
          localao.knk = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(89000);
          return 0;
        case 15: 
          localao.knl = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(89000);
          return 0;
        case 16: 
          localao.wma = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(89000);
          return 0;
        case 17: 
          localao.wmb = ((e.a.a.a.a)localObject1).CLY.emu();
          AppMethodBeat.o(89000);
          return 0;
        case 18: 
          localao.wmc = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(89000);
          return 0;
        case 19: 
          localao.wmd = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(89000);
          return 0;
        case 20: 
          localao.wme = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(89000);
          return 0;
        case 21: 
          localao.color = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(89000);
          return 0;
        case 22: 
          localao.wmf = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(89000);
          return 0;
        case 23: 
          localao.wmg = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(89000);
          return 0;
        case 24: 
          localao.wmh = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(89000);
          return 0;
        case 25: 
          localao.wmi = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(89000);
          return 0;
        case 26: 
          localao.wmj = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(89000);
          return 0;
        case 27: 
          localao.wmk = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(89000);
          return 0;
        case 28: 
          localao.wml = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(89000);
          return 0;
        case 29: 
          localao.wmm = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(89000);
          return 0;
        case 30: 
          localao.wmn = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(89000);
          return 0;
        case 31: 
          localao.wmo = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(89000);
          return 0;
        case 32: 
          localao.kml = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(89000);
          return 0;
        case 33: 
          localao.wmp = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(89000);
          return 0;
        case 34: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ap();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ap)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localao.kne.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(89000);
          return 0;
        case 35: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new aq();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((aq)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localao.knf.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(89000);
          return 0;
        case 36: 
          localao.kng = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(89000);
          return 0;
        case 37: 
          localao.knh = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(89000);
          return 0;
        case 38: 
          localao.kni = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(89000);
          return 0;
        }
        localao.knj = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(89000);
        return 0;
      }
      AppMethodBeat.o(89000);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ao
 * JD-Core Version:    0.7.0.1
 */