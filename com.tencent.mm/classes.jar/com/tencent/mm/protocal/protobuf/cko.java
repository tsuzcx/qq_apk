package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cko
  extends com.tencent.mm.bv.a
{
  public int bWu;
  public String cCW;
  public String cnv;
  public String cpW;
  public String hng;
  public int nHx;
  public int offset;
  public String ohe;
  public int scene;
  public int tft;
  public LinkedList<up> uIO;
  public String uIX;
  public String url;
  public String xUt;
  public LinkedList<ckv> xUu;
  public int xUv;
  public String xUw;
  public String xUx;
  public String xUy;
  public LinkedList<String> xUz;
  
  public cko()
  {
    AppMethodBeat.i(55702);
    this.uIO = new LinkedList();
    this.xUu = new LinkedList();
    this.xUz = new LinkedList();
    AppMethodBeat.o(55702);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(55703);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.hng != null) {
        paramVarArgs.e(1, this.hng);
      }
      if (this.cpW != null) {
        paramVarArgs.e(2, this.cpW);
      }
      if (this.cCW != null) {
        paramVarArgs.e(3, this.cCW);
      }
      paramVarArgs.aO(4, this.offset);
      if (this.cnv != null) {
        paramVarArgs.e(5, this.cnv);
      }
      paramVarArgs.aO(6, this.scene);
      if (this.url != null) {
        paramVarArgs.e(7, this.url);
      }
      if (this.ohe != null) {
        paramVarArgs.e(8, this.ohe);
      }
      paramVarArgs.e(9, 8, this.uIO);
      if (this.xUt != null) {
        paramVarArgs.e(10, this.xUt);
      }
      paramVarArgs.e(11, 8, this.xUu);
      paramVarArgs.aO(12, this.tft);
      paramVarArgs.aO(13, this.bWu);
      if (this.uIX != null) {
        paramVarArgs.e(14, this.uIX);
      }
      paramVarArgs.aO(15, this.xUv);
      if (this.xUw != null) {
        paramVarArgs.e(16, this.xUw);
      }
      if (this.xUx != null) {
        paramVarArgs.e(17, this.xUx);
      }
      if (this.xUy != null) {
        paramVarArgs.e(18, this.xUy);
      }
      paramVarArgs.e(19, 1, this.xUz);
      paramVarArgs.aO(20, this.nHx);
      AppMethodBeat.o(55703);
      return 0;
    }
    if (paramInt == 1) {
      if (this.hng == null) {
        break label1446;
      }
    }
    label1446:
    for (int i = e.a.a.b.b.a.f(1, this.hng) + 0;; i = 0)
    {
      paramInt = i;
      if (this.cpW != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.cpW);
      }
      i = paramInt;
      if (this.cCW != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.cCW);
      }
      i += e.a.a.b.b.a.bl(4, this.offset);
      paramInt = i;
      if (this.cnv != null) {
        paramInt = i + e.a.a.b.b.a.f(5, this.cnv);
      }
      i = paramInt + e.a.a.b.b.a.bl(6, this.scene);
      paramInt = i;
      if (this.url != null) {
        paramInt = i + e.a.a.b.b.a.f(7, this.url);
      }
      i = paramInt;
      if (this.ohe != null) {
        i = paramInt + e.a.a.b.b.a.f(8, this.ohe);
      }
      i += e.a.a.a.c(9, 8, this.uIO);
      paramInt = i;
      if (this.xUt != null) {
        paramInt = i + e.a.a.b.b.a.f(10, this.xUt);
      }
      i = paramInt + e.a.a.a.c(11, 8, this.xUu) + e.a.a.b.b.a.bl(12, this.tft) + e.a.a.b.b.a.bl(13, this.bWu);
      paramInt = i;
      if (this.uIX != null) {
        paramInt = i + e.a.a.b.b.a.f(14, this.uIX);
      }
      i = paramInt + e.a.a.b.b.a.bl(15, this.xUv);
      paramInt = i;
      if (this.xUw != null) {
        paramInt = i + e.a.a.b.b.a.f(16, this.xUw);
      }
      i = paramInt;
      if (this.xUx != null) {
        i = paramInt + e.a.a.b.b.a.f(17, this.xUx);
      }
      paramInt = i;
      if (this.xUy != null) {
        paramInt = i + e.a.a.b.b.a.f(18, this.xUy);
      }
      i = e.a.a.a.c(19, 1, this.xUz);
      int j = e.a.a.b.b.a.bl(20, this.nHx);
      AppMethodBeat.o(55703);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.uIO.clear();
        this.xUu.clear();
        this.xUz.clear();
        paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(55703);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        cko localcko = (cko)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(55703);
          return -1;
        case 1: 
          localcko.hng = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(55703);
          return 0;
        case 2: 
          localcko.cpW = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(55703);
          return 0;
        case 3: 
          localcko.cCW = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(55703);
          return 0;
        case 4: 
          localcko.offset = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(55703);
          return 0;
        case 5: 
          localcko.cnv = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(55703);
          return 0;
        case 6: 
          localcko.scene = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(55703);
          return 0;
        case 7: 
          localcko.url = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(55703);
          return 0;
        case 8: 
          localcko.ohe = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(55703);
          return 0;
        case 9: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new up();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((up)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localcko.uIO.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(55703);
          return 0;
        case 10: 
          localcko.xUt = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(55703);
          return 0;
        case 11: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ckv();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ckv)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localcko.xUu.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(55703);
          return 0;
        case 12: 
          localcko.tft = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(55703);
          return 0;
        case 13: 
          localcko.bWu = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(55703);
          return 0;
        case 14: 
          localcko.uIX = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(55703);
          return 0;
        case 15: 
          localcko.xUv = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(55703);
          return 0;
        case 16: 
          localcko.xUw = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(55703);
          return 0;
        case 17: 
          localcko.xUx = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(55703);
          return 0;
        case 18: 
          localcko.xUy = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(55703);
          return 0;
        case 19: 
          localcko.xUz.add(((e.a.a.a.a)localObject1).CLY.readString());
          AppMethodBeat.o(55703);
          return 0;
        }
        localcko.nHx = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(55703);
        return 0;
      }
      AppMethodBeat.o(55703);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cko
 * JD-Core Version:    0.7.0.1
 */