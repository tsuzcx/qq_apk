package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dnp
  extends com.tencent.mm.bx.a
{
  public int BrG;
  public LinkedList<aag> DBj;
  public String DBr;
  public String Glg;
  public LinkedList<dnz> HBB;
  public int HBC;
  public String HBD;
  public LinkedList<String> HBE;
  public asy HBF;
  public int cSc;
  public String dCW;
  public String dld;
  public String dwW;
  public String keN;
  public int offset;
  public String qXu;
  public int scene;
  public String sessionId;
  public String srd;
  public int uFB;
  public String url;
  
  public dnp()
  {
    AppMethodBeat.i(152996);
    this.DBj = new LinkedList();
    this.HBB = new LinkedList();
    this.HBE = new LinkedList();
    AppMethodBeat.o(152996);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152997);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.keN != null) {
        paramVarArgs.d(1, this.keN);
      }
      if (this.sessionId != null) {
        paramVarArgs.d(2, this.sessionId);
      }
      if (this.dCW != null) {
        paramVarArgs.d(3, this.dCW);
      }
      paramVarArgs.aS(4, this.offset);
      if (this.dld != null) {
        paramVarArgs.d(5, this.dld);
      }
      paramVarArgs.aS(6, this.scene);
      if (this.url != null) {
        paramVarArgs.d(7, this.url);
      }
      if (this.dwW != null) {
        paramVarArgs.d(8, this.dwW);
      }
      paramVarArgs.e(9, 8, this.DBj);
      if (this.qXu != null) {
        paramVarArgs.d(10, this.qXu);
      }
      paramVarArgs.e(11, 8, this.HBB);
      paramVarArgs.aS(12, this.BrG);
      paramVarArgs.aS(13, this.cSc);
      if (this.DBr != null) {
        paramVarArgs.d(14, this.DBr);
      }
      paramVarArgs.aS(15, this.HBC);
      if (this.Glg != null) {
        paramVarArgs.d(16, this.Glg);
      }
      if (this.srd != null) {
        paramVarArgs.d(17, this.srd);
      }
      if (this.HBD != null) {
        paramVarArgs.d(18, this.HBD);
      }
      paramVarArgs.e(19, 1, this.HBE);
      paramVarArgs.aS(20, this.uFB);
      if (this.HBF != null)
      {
        paramVarArgs.lC(21, this.HBF.computeSize());
        this.HBF.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(152997);
      return 0;
    }
    if (paramInt == 1) {
      if (this.keN == null) {
        break label1598;
      }
    }
    label1598:
    for (int i = f.a.a.b.b.a.e(1, this.keN) + 0;; i = 0)
    {
      paramInt = i;
      if (this.sessionId != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.sessionId);
      }
      i = paramInt;
      if (this.dCW != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.dCW);
      }
      i += f.a.a.b.b.a.bz(4, this.offset);
      paramInt = i;
      if (this.dld != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.dld);
      }
      i = paramInt + f.a.a.b.b.a.bz(6, this.scene);
      paramInt = i;
      if (this.url != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.url);
      }
      i = paramInt;
      if (this.dwW != null) {
        i = paramInt + f.a.a.b.b.a.e(8, this.dwW);
      }
      i += f.a.a.a.c(9, 8, this.DBj);
      paramInt = i;
      if (this.qXu != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.qXu);
      }
      i = paramInt + f.a.a.a.c(11, 8, this.HBB) + f.a.a.b.b.a.bz(12, this.BrG) + f.a.a.b.b.a.bz(13, this.cSc);
      paramInt = i;
      if (this.DBr != null) {
        paramInt = i + f.a.a.b.b.a.e(14, this.DBr);
      }
      i = paramInt + f.a.a.b.b.a.bz(15, this.HBC);
      paramInt = i;
      if (this.Glg != null) {
        paramInt = i + f.a.a.b.b.a.e(16, this.Glg);
      }
      i = paramInt;
      if (this.srd != null) {
        i = paramInt + f.a.a.b.b.a.e(17, this.srd);
      }
      paramInt = i;
      if (this.HBD != null) {
        paramInt = i + f.a.a.b.b.a.e(18, this.HBD);
      }
      i = paramInt + f.a.a.a.c(19, 1, this.HBE) + f.a.a.b.b.a.bz(20, this.uFB);
      paramInt = i;
      if (this.HBF != null) {
        paramInt = i + f.a.a.a.lB(21, this.HBF.computeSize());
      }
      AppMethodBeat.o(152997);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.DBj.clear();
        this.HBB.clear();
        this.HBE.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(152997);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dnp localdnp = (dnp)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(152997);
          return -1;
        case 1: 
          localdnp.keN = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(152997);
          return 0;
        case 2: 
          localdnp.sessionId = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(152997);
          return 0;
        case 3: 
          localdnp.dCW = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(152997);
          return 0;
        case 4: 
          localdnp.offset = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(152997);
          return 0;
        case 5: 
          localdnp.dld = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(152997);
          return 0;
        case 6: 
          localdnp.scene = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(152997);
          return 0;
        case 7: 
          localdnp.url = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(152997);
          return 0;
        case 8: 
          localdnp.dwW = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(152997);
          return 0;
        case 9: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new aag();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((aag)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdnp.DBj.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152997);
          return 0;
        case 10: 
          localdnp.qXu = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(152997);
          return 0;
        case 11: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dnz();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dnz)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdnp.HBB.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152997);
          return 0;
        case 12: 
          localdnp.BrG = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(152997);
          return 0;
        case 13: 
          localdnp.cSc = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(152997);
          return 0;
        case 14: 
          localdnp.DBr = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(152997);
          return 0;
        case 15: 
          localdnp.HBC = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(152997);
          return 0;
        case 16: 
          localdnp.Glg = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(152997);
          return 0;
        case 17: 
          localdnp.srd = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(152997);
          return 0;
        case 18: 
          localdnp.HBD = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(152997);
          return 0;
        case 19: 
          localdnp.HBE.add(((f.a.a.a.a)localObject1).NPN.readString());
          AppMethodBeat.o(152997);
          return 0;
        case 20: 
          localdnp.uFB = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(152997);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new asy();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((asy)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdnp.HBF = ((asy)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(152997);
        return 0;
      }
      AppMethodBeat.o(152997);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dnp
 * JD-Core Version:    0.7.0.1
 */