package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class egi
  extends com.tencent.mm.bw.a
{
  public dmu DTf;
  public String GLP;
  public long GeP;
  public String GeS;
  public int GeT;
  public int HFR;
  public int HFV;
  public LinkedList<duv> HIX;
  public buh HkU;
  public int Hvv;
  public LinkedList<aaj> Iiw;
  public int IjH;
  public String IjI;
  public int IjW;
  public String IjX;
  public String IjY;
  public int IjZ;
  public LinkedList<String> Ika;
  public LinkedList<cds> Ikb;
  public com.tencent.mm.bw.b Ikc;
  public com.tencent.mm.bw.b Ikd;
  public dgk Ike;
  public acs Ikf;
  public clp Ikg;
  public int Scene;
  public String qkN;
  
  public egi()
  {
    AppMethodBeat.i(117954);
    this.HIX = new LinkedList();
    this.Ika = new LinkedList();
    this.IjH = 2;
    this.Iiw = new LinkedList();
    this.Ikb = new LinkedList();
    AppMethodBeat.o(117954);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117955);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.GLP == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: Keyword");
        AppMethodBeat.o(117955);
        throw paramVarArgs;
      }
      paramVarArgs.aS(1, this.HFR);
      if (this.GLP != null) {
        paramVarArgs.d(2, this.GLP);
      }
      paramVarArgs.aS(3, this.GeT);
      paramVarArgs.aZ(4, this.GeP);
      paramVarArgs.aS(5, this.IjW);
      if (this.HkU != null)
      {
        paramVarArgs.lJ(6, this.HkU.computeSize());
        this.HkU.writeFields(paramVarArgs);
      }
      paramVarArgs.e(7, 8, this.HIX);
      paramVarArgs.aS(8, this.Scene);
      if (this.GeS != null) {
        paramVarArgs.d(9, this.GeS);
      }
      paramVarArgs.aS(10, this.HFV);
      if (this.IjX != null) {
        paramVarArgs.d(11, this.IjX);
      }
      if (this.IjY != null) {
        paramVarArgs.d(12, this.IjY);
      }
      paramVarArgs.aS(13, this.IjZ);
      paramVarArgs.e(14, 1, this.Ika);
      paramVarArgs.aS(15, this.IjH);
      if (this.DTf != null)
      {
        paramVarArgs.lJ(16, this.DTf.computeSize());
        this.DTf.writeFields(paramVarArgs);
      }
      paramVarArgs.e(17, 8, this.Iiw);
      paramVarArgs.e(18, 8, this.Ikb);
      if (this.qkN != null) {
        paramVarArgs.d(19, this.qkN);
      }
      if (this.Ikc != null) {
        paramVarArgs.c(20, this.Ikc);
      }
      if (this.IjI != null) {
        paramVarArgs.d(21, this.IjI);
      }
      if (this.Ikd != null) {
        paramVarArgs.c(22, this.Ikd);
      }
      if (this.Ike != null)
      {
        paramVarArgs.lJ(23, this.Ike.computeSize());
        this.Ike.writeFields(paramVarArgs);
      }
      if (this.Ikf != null)
      {
        paramVarArgs.lJ(24, this.Ikf.computeSize());
        this.Ikf.writeFields(paramVarArgs);
      }
      if (this.Ikg != null)
      {
        paramVarArgs.lJ(25, this.Ikg.computeSize());
        this.Ikg.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(26, this.Hvv);
      AppMethodBeat.o(117955);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bz(1, this.HFR) + 0;
      paramInt = i;
      if (this.GLP != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.GLP);
      }
      i = paramInt + f.a.a.b.b.a.bz(3, this.GeT) + f.a.a.b.b.a.p(4, this.GeP) + f.a.a.b.b.a.bz(5, this.IjW);
      paramInt = i;
      if (this.HkU != null) {
        paramInt = i + f.a.a.a.lI(6, this.HkU.computeSize());
      }
      i = paramInt + f.a.a.a.c(7, 8, this.HIX) + f.a.a.b.b.a.bz(8, this.Scene);
      paramInt = i;
      if (this.GeS != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.GeS);
      }
      i = paramInt + f.a.a.b.b.a.bz(10, this.HFV);
      paramInt = i;
      if (this.IjX != null) {
        paramInt = i + f.a.a.b.b.a.e(11, this.IjX);
      }
      i = paramInt;
      if (this.IjY != null) {
        i = paramInt + f.a.a.b.b.a.e(12, this.IjY);
      }
      i = i + f.a.a.b.b.a.bz(13, this.IjZ) + f.a.a.a.c(14, 1, this.Ika) + f.a.a.b.b.a.bz(15, this.IjH);
      paramInt = i;
      if (this.DTf != null) {
        paramInt = i + f.a.a.a.lI(16, this.DTf.computeSize());
      }
      i = paramInt + f.a.a.a.c(17, 8, this.Iiw) + f.a.a.a.c(18, 8, this.Ikb);
      paramInt = i;
      if (this.qkN != null) {
        paramInt = i + f.a.a.b.b.a.e(19, this.qkN);
      }
      i = paramInt;
      if (this.Ikc != null) {
        i = paramInt + f.a.a.b.b.a.b(20, this.Ikc);
      }
      paramInt = i;
      if (this.IjI != null) {
        paramInt = i + f.a.a.b.b.a.e(21, this.IjI);
      }
      i = paramInt;
      if (this.Ikd != null) {
        i = paramInt + f.a.a.b.b.a.b(22, this.Ikd);
      }
      paramInt = i;
      if (this.Ike != null) {
        paramInt = i + f.a.a.a.lI(23, this.Ike.computeSize());
      }
      i = paramInt;
      if (this.Ikf != null) {
        i = paramInt + f.a.a.a.lI(24, this.Ikf.computeSize());
      }
      paramInt = i;
      if (this.Ikg != null) {
        paramInt = i + f.a.a.a.lI(25, this.Ikg.computeSize());
      }
      i = f.a.a.b.b.a.bz(26, this.Hvv);
      AppMethodBeat.o(117955);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.HIX.clear();
      this.Ika.clear();
      this.Iiw.clear();
      this.Ikb.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      if (this.GLP == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: Keyword");
        AppMethodBeat.o(117955);
        throw paramVarArgs;
      }
      AppMethodBeat.o(117955);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      egi localegi = (egi)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(117955);
        return -1;
      case 1: 
        localegi.HFR = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(117955);
        return 0;
      case 2: 
        localegi.GLP = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(117955);
        return 0;
      case 3: 
        localegi.GeT = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(117955);
        return 0;
      case 4: 
        localegi.GeP = ((f.a.a.a.a)localObject1).OmT.zd();
        AppMethodBeat.o(117955);
        return 0;
      case 5: 
        localegi.IjW = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(117955);
        return 0;
      case 6: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new buh();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((buh)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localegi.HkU = ((buh)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(117955);
        return 0;
      case 7: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new duv();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((duv)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localegi.HIX.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(117955);
        return 0;
      case 8: 
        localegi.Scene = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(117955);
        return 0;
      case 9: 
        localegi.GeS = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(117955);
        return 0;
      case 10: 
        localegi.HFV = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(117955);
        return 0;
      case 11: 
        localegi.IjX = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(117955);
        return 0;
      case 12: 
        localegi.IjY = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(117955);
        return 0;
      case 13: 
        localegi.IjZ = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(117955);
        return 0;
      case 14: 
        localegi.Ika.add(((f.a.a.a.a)localObject1).OmT.readString());
        AppMethodBeat.o(117955);
        return 0;
      case 15: 
        localegi.IjH = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(117955);
        return 0;
      case 16: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dmu();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dmu)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localegi.DTf = ((dmu)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(117955);
        return 0;
      case 17: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new aaj();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((aaj)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localegi.Iiw.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(117955);
        return 0;
      case 18: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cds();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cds)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localegi.Ikb.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(117955);
        return 0;
      case 19: 
        localegi.qkN = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(117955);
        return 0;
      case 20: 
        localegi.Ikc = ((f.a.a.a.a)localObject1).OmT.gCk();
        AppMethodBeat.o(117955);
        return 0;
      case 21: 
        localegi.IjI = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(117955);
        return 0;
      case 22: 
        localegi.Ikd = ((f.a.a.a.a)localObject1).OmT.gCk();
        AppMethodBeat.o(117955);
        return 0;
      case 23: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dgk();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dgk)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localegi.Ike = ((dgk)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(117955);
        return 0;
      case 24: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new acs();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((acs)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localegi.Ikf = ((acs)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(117955);
        return 0;
      case 25: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new clp();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((clp)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localegi.Ikg = ((clp)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(117955);
        return 0;
      }
      localegi.Hvv = ((f.a.a.a.a)localObject1).OmT.zc();
      AppMethodBeat.o(117955);
      return 0;
    }
    AppMethodBeat.o(117955);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.egi
 * JD-Core Version:    0.7.0.1
 */