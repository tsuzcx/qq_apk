package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bv.b;
import java.util.LinkedList;

public final class azs
  extends com.tencent.mm.bv.a
{
  public String Title;
  public int jKs;
  public String pdW;
  public float pdX;
  public int pdY;
  public LinkedList<Integer> pdZ;
  public int pea;
  public LinkedList<bwc> peb;
  public float pec;
  public String ped;
  public SKBuiltinBuffer_t pee;
  public String xpm;
  public SKBuiltinBuffer_t xpn;
  public int xpo;
  public int xpp;
  
  public azs()
  {
    AppMethodBeat.i(70484);
    this.pdZ = new LinkedList();
    this.peb = new LinkedList();
    AppMethodBeat.o(70484);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(70485);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.pdW != null) {
        paramVarArgs.e(1, this.pdW);
      }
      if (this.Title != null) {
        paramVarArgs.e(2, this.Title);
      }
      paramVarArgs.q(3, this.pdX);
      paramVarArgs.aO(4, this.pdY);
      paramVarArgs.f(5, 2, this.pdZ);
      paramVarArgs.aO(6, this.pea);
      paramVarArgs.e(7, 8, this.peb);
      paramVarArgs.q(8, this.pec);
      if (this.ped != null) {
        paramVarArgs.e(9, this.ped);
      }
      paramVarArgs.aO(10, this.jKs);
      if (this.pee != null)
      {
        paramVarArgs.iQ(11, this.pee.computeSize());
        this.pee.writeFields(paramVarArgs);
      }
      if (this.xpm != null) {
        paramVarArgs.e(12, this.xpm);
      }
      if (this.xpn != null)
      {
        paramVarArgs.iQ(13, this.xpn.computeSize());
        this.xpn.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(14, this.xpo);
      paramVarArgs.aO(15, this.xpp);
      AppMethodBeat.o(70485);
      return 0;
    }
    if (paramInt == 1) {
      if (this.pdW == null) {
        break label1239;
      }
    }
    label1239:
    for (paramInt = e.a.a.b.b.a.f(1, this.pdW) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Title != null) {
        i = paramInt + e.a.a.b.b.a.f(2, this.Title);
      }
      i = i + (e.a.a.b.b.a.eW(3) + 4) + e.a.a.b.b.a.bl(4, this.pdY) + e.a.a.a.d(5, 2, this.pdZ) + e.a.a.b.b.a.bl(6, this.pea) + e.a.a.a.c(7, 8, this.peb) + (e.a.a.b.b.a.eW(8) + 4);
      paramInt = i;
      if (this.ped != null) {
        paramInt = i + e.a.a.b.b.a.f(9, this.ped);
      }
      i = paramInt + e.a.a.b.b.a.bl(10, this.jKs);
      paramInt = i;
      if (this.pee != null) {
        paramInt = i + e.a.a.a.iP(11, this.pee.computeSize());
      }
      i = paramInt;
      if (this.xpm != null) {
        i = paramInt + e.a.a.b.b.a.f(12, this.xpm);
      }
      paramInt = i;
      if (this.xpn != null) {
        paramInt = i + e.a.a.a.iP(13, this.xpn.computeSize());
      }
      i = e.a.a.b.b.a.bl(14, this.xpo);
      int j = e.a.a.b.b.a.bl(15, this.xpp);
      AppMethodBeat.o(70485);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.pdZ.clear();
        this.peb.clear();
        paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(70485);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        azs localazs = (azs)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(70485);
          return -1;
        case 1: 
          localazs.pdW = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(70485);
          return 0;
        case 2: 
          localazs.Title = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(70485);
          return 0;
        case 3: 
          localazs.pdX = Float.intBitsToFloat(((e.a.a.a.a)localObject1).CLY.emx());
          AppMethodBeat.o(70485);
          return 0;
        case 4: 
          localazs.pdY = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(70485);
          return 0;
        case 5: 
          localazs.pdZ = new e.a.a.a.a(((e.a.a.a.a)localObject1).CLY.eqS().pW, unknownTagHandler).CLY.eqR();
          AppMethodBeat.o(70485);
          return 0;
        case 6: 
          localazs.pea = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(70485);
          return 0;
        case 7: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bwc();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bwc)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localazs.peb.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(70485);
          return 0;
        case 8: 
          localazs.pec = Float.intBitsToFloat(((e.a.a.a.a)localObject1).CLY.emx());
          AppMethodBeat.o(70485);
          return 0;
        case 9: 
          localazs.ped = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(70485);
          return 0;
        case 10: 
          localazs.jKs = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(70485);
          return 0;
        case 11: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localazs.pee = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(70485);
          return 0;
        case 12: 
          localazs.xpm = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(70485);
          return 0;
        case 13: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localazs.xpn = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(70485);
          return 0;
        case 14: 
          localazs.xpo = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(70485);
          return 0;
        }
        localazs.xpp = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(70485);
        return 0;
      }
      AppMethodBeat.o(70485);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.azs
 * JD-Core Version:    0.7.0.1
 */