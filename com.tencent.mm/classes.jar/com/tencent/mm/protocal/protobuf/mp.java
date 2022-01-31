package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class mp
  extends buy
{
  public int cCy;
  public String kbP;
  public String nickname;
  public int qiP;
  public String qjK;
  public String qkh;
  public String qki;
  public String qkk;
  public int qkm;
  public String qkn;
  public String qko;
  public int scene;
  public String son;
  public String wAV;
  public String wBb;
  public String wBc;
  public String wBd;
  public int wBe;
  public boolean wBf;
  public boolean wBg;
  public String wBh;
  public int wBi;
  public String wBj;
  public int wBk;
  public int wBl;
  public adg wps;
  public String wpt;
  public int wpu;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(56724);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.wBb == null)
      {
        paramVarArgs = new b("Not all required fields were included: qrcode_id");
        AppMethodBeat.o(56724);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.iQ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.qkn != null) {
        paramVarArgs.e(2, this.qkn);
      }
      if (this.wBb != null) {
        paramVarArgs.e(3, this.wBb);
      }
      paramVarArgs.aO(4, this.scene);
      if (this.wBc != null) {
        paramVarArgs.e(5, this.wBc);
      }
      if (this.qkh != null) {
        paramVarArgs.e(6, this.qkh);
      }
      paramVarArgs.aO(7, this.wpu);
      paramVarArgs.aO(8, this.cCy);
      if (this.qko != null) {
        paramVarArgs.e(9, this.qko);
      }
      if (this.qki != null) {
        paramVarArgs.e(10, this.qki);
      }
      if (this.wBd != null) {
        paramVarArgs.e(11, this.wBd);
      }
      paramVarArgs.aO(12, this.wBe);
      paramVarArgs.aO(13, this.qkm);
      if (this.wpt != null) {
        paramVarArgs.e(14, this.wpt);
      }
      if (this.wps != null)
      {
        paramVarArgs.iQ(15, this.wps.computeSize());
        this.wps.writeFields(paramVarArgs);
      }
      if (this.wAV != null) {
        paramVarArgs.e(16, this.wAV);
      }
      paramVarArgs.aO(17, this.qiP);
      paramVarArgs.aS(18, this.wBf);
      paramVarArgs.aS(19, this.wBg);
      if (this.son != null) {
        paramVarArgs.e(20, this.son);
      }
      if (this.kbP != null) {
        paramVarArgs.e(21, this.kbP);
      }
      if (this.wBh != null) {
        paramVarArgs.e(22, this.wBh);
      }
      if (this.qkk != null) {
        paramVarArgs.e(23, this.qkk);
      }
      if (this.nickname != null) {
        paramVarArgs.e(24, this.nickname);
      }
      if (this.qjK != null) {
        paramVarArgs.e(25, this.qjK);
      }
      paramVarArgs.aO(26, this.wBi);
      if (this.wBj != null) {
        paramVarArgs.e(27, this.wBj);
      }
      paramVarArgs.aO(28, this.wBk);
      paramVarArgs.aO(29, this.wBl);
      AppMethodBeat.o(56724);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1994;
      }
    }
    label1994:
    for (int i = e.a.a.a.iP(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.qkn != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.qkn);
      }
      i = paramInt;
      if (this.wBb != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.wBb);
      }
      i += e.a.a.b.b.a.bl(4, this.scene);
      paramInt = i;
      if (this.wBc != null) {
        paramInt = i + e.a.a.b.b.a.f(5, this.wBc);
      }
      i = paramInt;
      if (this.qkh != null) {
        i = paramInt + e.a.a.b.b.a.f(6, this.qkh);
      }
      i = i + e.a.a.b.b.a.bl(7, this.wpu) + e.a.a.b.b.a.bl(8, this.cCy);
      paramInt = i;
      if (this.qko != null) {
        paramInt = i + e.a.a.b.b.a.f(9, this.qko);
      }
      i = paramInt;
      if (this.qki != null) {
        i = paramInt + e.a.a.b.b.a.f(10, this.qki);
      }
      paramInt = i;
      if (this.wBd != null) {
        paramInt = i + e.a.a.b.b.a.f(11, this.wBd);
      }
      i = paramInt + e.a.a.b.b.a.bl(12, this.wBe) + e.a.a.b.b.a.bl(13, this.qkm);
      paramInt = i;
      if (this.wpt != null) {
        paramInt = i + e.a.a.b.b.a.f(14, this.wpt);
      }
      i = paramInt;
      if (this.wps != null) {
        i = paramInt + e.a.a.a.iP(15, this.wps.computeSize());
      }
      paramInt = i;
      if (this.wAV != null) {
        paramInt = i + e.a.a.b.b.a.f(16, this.wAV);
      }
      i = paramInt + e.a.a.b.b.a.bl(17, this.qiP) + (e.a.a.b.b.a.eW(18) + 1) + (e.a.a.b.b.a.eW(19) + 1);
      paramInt = i;
      if (this.son != null) {
        paramInt = i + e.a.a.b.b.a.f(20, this.son);
      }
      i = paramInt;
      if (this.kbP != null) {
        i = paramInt + e.a.a.b.b.a.f(21, this.kbP);
      }
      paramInt = i;
      if (this.wBh != null) {
        paramInt = i + e.a.a.b.b.a.f(22, this.wBh);
      }
      i = paramInt;
      if (this.qkk != null) {
        i = paramInt + e.a.a.b.b.a.f(23, this.qkk);
      }
      paramInt = i;
      if (this.nickname != null) {
        paramInt = i + e.a.a.b.b.a.f(24, this.nickname);
      }
      i = paramInt;
      if (this.qjK != null) {
        i = paramInt + e.a.a.b.b.a.f(25, this.qjK);
      }
      i += e.a.a.b.b.a.bl(26, this.wBi);
      paramInt = i;
      if (this.wBj != null) {
        paramInt = i + e.a.a.b.b.a.f(27, this.wBj);
      }
      i = e.a.a.b.b.a.bl(28, this.wBk);
      int j = e.a.a.b.b.a.bl(29, this.wBl);
      AppMethodBeat.o(56724);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = buy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = buy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.wBb == null)
        {
          paramVarArgs = new b("Not all required fields were included: qrcode_id");
          AppMethodBeat.o(56724);
          throw paramVarArgs;
        }
        AppMethodBeat.o(56724);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        mp localmp = (mp)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(56724);
          return -1;
        case 1: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new hq();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((hq)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, buy.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localmp.BaseRequest = ((hq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(56724);
          return 0;
        case 2: 
          localmp.qkn = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56724);
          return 0;
        case 3: 
          localmp.wBb = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56724);
          return 0;
        case 4: 
          localmp.scene = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(56724);
          return 0;
        case 5: 
          localmp.wBc = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56724);
          return 0;
        case 6: 
          localmp.qkh = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56724);
          return 0;
        case 7: 
          localmp.wpu = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(56724);
          return 0;
        case 8: 
          localmp.cCy = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(56724);
          return 0;
        case 9: 
          localmp.qko = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56724);
          return 0;
        case 10: 
          localmp.qki = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56724);
          return 0;
        case 11: 
          localmp.wBd = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56724);
          return 0;
        case 12: 
          localmp.wBe = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(56724);
          return 0;
        case 13: 
          localmp.qkm = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(56724);
          return 0;
        case 14: 
          localmp.wpt = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56724);
          return 0;
        case 15: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new adg();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((adg)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, buy.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localmp.wps = ((adg)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(56724);
          return 0;
        case 16: 
          localmp.wAV = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56724);
          return 0;
        case 17: 
          localmp.qiP = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(56724);
          return 0;
        case 18: 
          localmp.wBf = ((e.a.a.a.a)localObject1).CLY.emu();
          AppMethodBeat.o(56724);
          return 0;
        case 19: 
          localmp.wBg = ((e.a.a.a.a)localObject1).CLY.emu();
          AppMethodBeat.o(56724);
          return 0;
        case 20: 
          localmp.son = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56724);
          return 0;
        case 21: 
          localmp.kbP = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56724);
          return 0;
        case 22: 
          localmp.wBh = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56724);
          return 0;
        case 23: 
          localmp.qkk = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56724);
          return 0;
        case 24: 
          localmp.nickname = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56724);
          return 0;
        case 25: 
          localmp.qjK = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56724);
          return 0;
        case 26: 
          localmp.wBi = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(56724);
          return 0;
        case 27: 
          localmp.wBj = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56724);
          return 0;
        case 28: 
          localmp.wBk = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(56724);
          return 0;
        }
        localmp.wBl = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(56724);
        return 0;
      }
      AppMethodBeat.o(56724);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.mp
 * JD-Core Version:    0.7.0.1
 */