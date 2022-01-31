package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ckw
  extends com.tencent.mm.bv.a
{
  public String cnv;
  public boolean efg;
  public String hng;
  public int offset;
  public int scene;
  public LinkedList<up> uIO;
  public String xUK;
  public String xUL;
  public String xUM;
  public String xUN;
  public long xUO;
  public ckx xUP;
  public ccp xUQ;
  public boolean xUR;
  public LinkedList<ckx> xUS;
  public int xUT;
  public int xUU;
  public String xUV;
  public int xUW;
  public boolean xUX;
  public String xUt;
  
  public ckw()
  {
    AppMethodBeat.i(55708);
    this.uIO = new LinkedList();
    this.xUS = new LinkedList();
    AppMethodBeat.o(55708);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(55709);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.xUK != null) {
        paramVarArgs.e(1, this.xUK);
      }
      if (this.xUL != null) {
        paramVarArgs.e(2, this.xUL);
      }
      if (this.xUM != null) {
        paramVarArgs.e(3, this.xUM);
      }
      if (this.xUN != null) {
        paramVarArgs.e(4, this.xUN);
      }
      paramVarArgs.am(5, this.xUO);
      paramVarArgs.aO(6, this.scene);
      if (this.hng != null) {
        paramVarArgs.e(7, this.hng);
      }
      if (this.cnv != null) {
        paramVarArgs.e(8, this.cnv);
      }
      if (this.xUP != null)
      {
        paramVarArgs.iQ(9, this.xUP.computeSize());
        this.xUP.writeFields(paramVarArgs);
      }
      if (this.xUQ != null)
      {
        paramVarArgs.iQ(10, this.xUQ.computeSize());
        this.xUQ.writeFields(paramVarArgs);
      }
      paramVarArgs.e(11, 8, this.uIO);
      if (this.xUt != null) {
        paramVarArgs.e(12, this.xUt);
      }
      paramVarArgs.aO(13, this.offset);
      paramVarArgs.aS(14, this.xUR);
      paramVarArgs.e(15, 8, this.xUS);
      paramVarArgs.aO(16, this.xUT);
      paramVarArgs.aO(17, this.xUU);
      paramVarArgs.aS(18, this.efg);
      if (this.xUV != null) {
        paramVarArgs.e(19, this.xUV);
      }
      paramVarArgs.aO(20, this.xUW);
      paramVarArgs.aS(21, this.xUX);
      AppMethodBeat.o(55709);
      return 0;
    }
    if (paramInt == 1) {
      if (this.xUK == null) {
        break label1638;
      }
    }
    label1638:
    for (int i = e.a.a.b.b.a.f(1, this.xUK) + 0;; i = 0)
    {
      paramInt = i;
      if (this.xUL != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.xUL);
      }
      i = paramInt;
      if (this.xUM != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.xUM);
      }
      paramInt = i;
      if (this.xUN != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.xUN);
      }
      i = paramInt + e.a.a.b.b.a.p(5, this.xUO) + e.a.a.b.b.a.bl(6, this.scene);
      paramInt = i;
      if (this.hng != null) {
        paramInt = i + e.a.a.b.b.a.f(7, this.hng);
      }
      i = paramInt;
      if (this.cnv != null) {
        i = paramInt + e.a.a.b.b.a.f(8, this.cnv);
      }
      paramInt = i;
      if (this.xUP != null) {
        paramInt = i + e.a.a.a.iP(9, this.xUP.computeSize());
      }
      i = paramInt;
      if (this.xUQ != null) {
        i = paramInt + e.a.a.a.iP(10, this.xUQ.computeSize());
      }
      i += e.a.a.a.c(11, 8, this.uIO);
      paramInt = i;
      if (this.xUt != null) {
        paramInt = i + e.a.a.b.b.a.f(12, this.xUt);
      }
      i = paramInt + e.a.a.b.b.a.bl(13, this.offset) + (e.a.a.b.b.a.eW(14) + 1) + e.a.a.a.c(15, 8, this.xUS) + e.a.a.b.b.a.bl(16, this.xUT) + e.a.a.b.b.a.bl(17, this.xUU) + (e.a.a.b.b.a.eW(18) + 1);
      paramInt = i;
      if (this.xUV != null) {
        paramInt = i + e.a.a.b.b.a.f(19, this.xUV);
      }
      i = e.a.a.b.b.a.bl(20, this.xUW);
      int j = e.a.a.b.b.a.eW(21);
      AppMethodBeat.o(55709);
      return paramInt + i + (j + 1);
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.uIO.clear();
        this.xUS.clear();
        paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(55709);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        ckw localckw = (ckw)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(55709);
          return -1;
        case 1: 
          localckw.xUK = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(55709);
          return 0;
        case 2: 
          localckw.xUL = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(55709);
          return 0;
        case 3: 
          localckw.xUM = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(55709);
          return 0;
        case 4: 
          localckw.xUN = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(55709);
          return 0;
        case 5: 
          localckw.xUO = ((e.a.a.a.a)localObject1).CLY.sm();
          AppMethodBeat.o(55709);
          return 0;
        case 6: 
          localckw.scene = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(55709);
          return 0;
        case 7: 
          localckw.hng = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(55709);
          return 0;
        case 8: 
          localckw.cnv = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(55709);
          return 0;
        case 9: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ckx();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ckx)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localckw.xUP = ((ckx)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(55709);
          return 0;
        case 10: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ccp();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ccp)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localckw.xUQ = ((ccp)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(55709);
          return 0;
        case 11: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new up();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((up)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localckw.uIO.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(55709);
          return 0;
        case 12: 
          localckw.xUt = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(55709);
          return 0;
        case 13: 
          localckw.offset = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(55709);
          return 0;
        case 14: 
          localckw.xUR = ((e.a.a.a.a)localObject1).CLY.emu();
          AppMethodBeat.o(55709);
          return 0;
        case 15: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ckx();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ckx)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localckw.xUS.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(55709);
          return 0;
        case 16: 
          localckw.xUT = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(55709);
          return 0;
        case 17: 
          localckw.xUU = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(55709);
          return 0;
        case 18: 
          localckw.efg = ((e.a.a.a.a)localObject1).CLY.emu();
          AppMethodBeat.o(55709);
          return 0;
        case 19: 
          localckw.xUV = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(55709);
          return 0;
        case 20: 
          localckw.xUW = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(55709);
          return 0;
        }
        localckw.xUX = ((e.a.a.a.a)localObject1).CLY.emu();
        AppMethodBeat.o(55709);
        return 0;
      }
      AppMethodBeat.o(55709);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ckw
 * JD-Core Version:    0.7.0.1
 */