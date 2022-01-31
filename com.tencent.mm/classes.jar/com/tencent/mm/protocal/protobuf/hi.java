package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class hi
  extends com.tencent.mm.bv.a
{
  public String nLq;
  public String poq;
  public String qfY;
  public int qfZ;
  public int qga;
  public String qgb;
  public String qgc;
  public String qgd;
  public long qgg;
  public LinkedList<zz> wua;
  public String wub;
  public String wuc;
  
  public hi()
  {
    AppMethodBeat.i(48776);
    this.wua = new LinkedList();
    AppMethodBeat.o(48776);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(48777);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.poq != null) {
        paramVarArgs.e(1, this.poq);
      }
      if (this.nLq != null) {
        paramVarArgs.e(2, this.nLq);
      }
      if (this.qfY != null) {
        paramVarArgs.e(3, this.qfY);
      }
      paramVarArgs.aO(4, this.qfZ);
      paramVarArgs.aO(5, this.qga);
      paramVarArgs.e(6, 8, this.wua);
      if (this.qgb != null) {
        paramVarArgs.e(7, this.qgb);
      }
      if (this.qgc != null) {
        paramVarArgs.e(8, this.qgc);
      }
      if (this.qgd != null) {
        paramVarArgs.e(9, this.qgd);
      }
      if (this.wub != null) {
        paramVarArgs.e(10, this.wub);
      }
      if (this.wuc != null) {
        paramVarArgs.e(11, this.wuc);
      }
      paramVarArgs.am(12, this.qgg);
      AppMethodBeat.o(48777);
      return 0;
    }
    if (paramInt == 1) {
      if (this.poq == null) {
        break label918;
      }
    }
    label918:
    for (int i = e.a.a.b.b.a.f(1, this.poq) + 0;; i = 0)
    {
      paramInt = i;
      if (this.nLq != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.nLq);
      }
      i = paramInt;
      if (this.qfY != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.qfY);
      }
      i = i + e.a.a.b.b.a.bl(4, this.qfZ) + e.a.a.b.b.a.bl(5, this.qga) + e.a.a.a.c(6, 8, this.wua);
      paramInt = i;
      if (this.qgb != null) {
        paramInt = i + e.a.a.b.b.a.f(7, this.qgb);
      }
      i = paramInt;
      if (this.qgc != null) {
        i = paramInt + e.a.a.b.b.a.f(8, this.qgc);
      }
      paramInt = i;
      if (this.qgd != null) {
        paramInt = i + e.a.a.b.b.a.f(9, this.qgd);
      }
      i = paramInt;
      if (this.wub != null) {
        i = paramInt + e.a.a.b.b.a.f(10, this.wub);
      }
      paramInt = i;
      if (this.wuc != null) {
        paramInt = i + e.a.a.b.b.a.f(11, this.wuc);
      }
      i = e.a.a.b.b.a.p(12, this.qgg);
      AppMethodBeat.o(48777);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.wua.clear();
        paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(48777);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        hi localhi = (hi)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(48777);
          return -1;
        case 1: 
          localhi.poq = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(48777);
          return 0;
        case 2: 
          localhi.nLq = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(48777);
          return 0;
        case 3: 
          localhi.qfY = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(48777);
          return 0;
        case 4: 
          localhi.qfZ = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(48777);
          return 0;
        case 5: 
          localhi.qga = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(48777);
          return 0;
        case 6: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new zz();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((zz)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localhi.wua.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(48777);
          return 0;
        case 7: 
          localhi.qgb = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(48777);
          return 0;
        case 8: 
          localhi.qgc = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(48777);
          return 0;
        case 9: 
          localhi.qgd = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(48777);
          return 0;
        case 10: 
          localhi.wub = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(48777);
          return 0;
        case 11: 
          localhi.wuc = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(48777);
          return 0;
        }
        localhi.qgg = ((e.a.a.a.a)localObject1).CLY.sm();
        AppMethodBeat.o(48777);
        return 0;
      }
      AppMethodBeat.o(48777);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.hi
 * JD-Core Version:    0.7.0.1
 */