package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bbb
  extends com.tencent.mm.bv.a
{
  public String Nickname;
  public String Username;
  public String gwO;
  public int gwP;
  public String gwQ;
  public String gwR;
  public String gwS;
  public int gwT;
  public String gwU;
  public int gwV;
  public int gwW;
  public String gwX;
  public String gwY;
  public String gwZ;
  public String wJq;
  public String wJr;
  public String wYu;
  public cfj xpk;
  public wc xpl;
  public abb xqj;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(73739);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.Username != null) {
        paramVarArgs.e(1, this.Username);
      }
      if (this.Nickname != null) {
        paramVarArgs.e(2, this.Nickname);
      }
      if (this.gwO != null) {
        paramVarArgs.e(3, this.gwO);
      }
      paramVarArgs.aO(4, this.gwP);
      if (this.gwQ != null) {
        paramVarArgs.e(5, this.gwQ);
      }
      if (this.gwR != null) {
        paramVarArgs.e(6, this.gwR);
      }
      if (this.gwS != null) {
        paramVarArgs.e(7, this.gwS);
      }
      paramVarArgs.aO(8, this.gwT);
      if (this.gwU != null) {
        paramVarArgs.e(9, this.gwU);
      }
      if (this.xqj != null)
      {
        paramVarArgs.iQ(10, this.xqj.computeSize());
        this.xqj.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(11, this.gwV);
      paramVarArgs.aO(12, this.gwW);
      if (this.gwX != null) {
        paramVarArgs.e(13, this.gwX);
      }
      if (this.xpk != null)
      {
        paramVarArgs.iQ(14, this.xpk.computeSize());
        this.xpk.writeFields(paramVarArgs);
      }
      if (this.gwY != null) {
        paramVarArgs.e(15, this.gwY);
      }
      if (this.gwZ != null) {
        paramVarArgs.e(16, this.gwZ);
      }
      if (this.xpl != null)
      {
        paramVarArgs.iQ(17, this.xpl.computeSize());
        this.xpl.writeFields(paramVarArgs);
      }
      if (this.wJq != null) {
        paramVarArgs.e(20, this.wJq);
      }
      if (this.wJr != null) {
        paramVarArgs.e(21, this.wJr);
      }
      if (this.wYu != null) {
        paramVarArgs.e(22, this.wYu);
      }
      AppMethodBeat.o(73739);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Username == null) {
        break label1610;
      }
    }
    label1610:
    for (int i = e.a.a.b.b.a.f(1, this.Username) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Nickname != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.Nickname);
      }
      i = paramInt;
      if (this.gwO != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.gwO);
      }
      i += e.a.a.b.b.a.bl(4, this.gwP);
      paramInt = i;
      if (this.gwQ != null) {
        paramInt = i + e.a.a.b.b.a.f(5, this.gwQ);
      }
      i = paramInt;
      if (this.gwR != null) {
        i = paramInt + e.a.a.b.b.a.f(6, this.gwR);
      }
      paramInt = i;
      if (this.gwS != null) {
        paramInt = i + e.a.a.b.b.a.f(7, this.gwS);
      }
      i = paramInt + e.a.a.b.b.a.bl(8, this.gwT);
      paramInt = i;
      if (this.gwU != null) {
        paramInt = i + e.a.a.b.b.a.f(9, this.gwU);
      }
      i = paramInt;
      if (this.xqj != null) {
        i = paramInt + e.a.a.a.iP(10, this.xqj.computeSize());
      }
      i = i + e.a.a.b.b.a.bl(11, this.gwV) + e.a.a.b.b.a.bl(12, this.gwW);
      paramInt = i;
      if (this.gwX != null) {
        paramInt = i + e.a.a.b.b.a.f(13, this.gwX);
      }
      i = paramInt;
      if (this.xpk != null) {
        i = paramInt + e.a.a.a.iP(14, this.xpk.computeSize());
      }
      paramInt = i;
      if (this.gwY != null) {
        paramInt = i + e.a.a.b.b.a.f(15, this.gwY);
      }
      i = paramInt;
      if (this.gwZ != null) {
        i = paramInt + e.a.a.b.b.a.f(16, this.gwZ);
      }
      paramInt = i;
      if (this.xpl != null) {
        paramInt = i + e.a.a.a.iP(17, this.xpl.computeSize());
      }
      i = paramInt;
      if (this.wJq != null) {
        i = paramInt + e.a.a.b.b.a.f(20, this.wJq);
      }
      paramInt = i;
      if (this.wJr != null) {
        paramInt = i + e.a.a.b.b.a.f(21, this.wJr);
      }
      i = paramInt;
      if (this.wYu != null) {
        i = paramInt + e.a.a.b.b.a.f(22, this.wYu);
      }
      AppMethodBeat.o(73739);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(73739);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        bbb localbbb = (bbb)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        case 18: 
        case 19: 
        default: 
          AppMethodBeat.o(73739);
          return -1;
        case 1: 
          localbbb.Username = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(73739);
          return 0;
        case 2: 
          localbbb.Nickname = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(73739);
          return 0;
        case 3: 
          localbbb.gwO = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(73739);
          return 0;
        case 4: 
          localbbb.gwP = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(73739);
          return 0;
        case 5: 
          localbbb.gwQ = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(73739);
          return 0;
        case 6: 
          localbbb.gwR = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(73739);
          return 0;
        case 7: 
          localbbb.gwS = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(73739);
          return 0;
        case 8: 
          localbbb.gwT = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(73739);
          return 0;
        case 9: 
          localbbb.gwU = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(73739);
          return 0;
        case 10: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new abb();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((abb)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localbbb.xqj = ((abb)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(73739);
          return 0;
        case 11: 
          localbbb.gwV = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(73739);
          return 0;
        case 12: 
          localbbb.gwW = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(73739);
          return 0;
        case 13: 
          localbbb.gwX = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(73739);
          return 0;
        case 14: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cfj();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cfj)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localbbb.xpk = ((cfj)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(73739);
          return 0;
        case 15: 
          localbbb.gwY = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(73739);
          return 0;
        case 16: 
          localbbb.gwZ = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(73739);
          return 0;
        case 17: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new wc();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((wc)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localbbb.xpl = ((wc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(73739);
          return 0;
        case 20: 
          localbbb.wJq = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(73739);
          return 0;
        case 21: 
          localbbb.wJr = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(73739);
          return 0;
        }
        localbbb.wYu = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(73739);
        return 0;
      }
      AppMethodBeat.o(73739);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bbb
 * JD-Core Version:    0.7.0.1
 */