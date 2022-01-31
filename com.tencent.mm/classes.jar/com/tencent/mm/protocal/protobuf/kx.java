package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class kx
  extends com.tencent.mm.bv.a
{
  public String content;
  public String kVV;
  public String kmm;
  public int wqK;
  public int wxI;
  public int wxJ;
  public int wyr;
  public String wys;
  public int wyt;
  public int wyu;
  public ut wyv;
  public int wyw;
  public int wyx;
  public int wyy = 0;
  public int wyz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(14712);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aO(1, this.wyr);
      paramVarArgs.aO(2, this.wqK);
      if (this.wys != null) {
        paramVarArgs.e(3, this.wys);
      }
      if (this.kVV != null) {
        paramVarArgs.e(4, this.kVV);
      }
      if (this.kmm != null) {
        paramVarArgs.e(5, this.kmm);
      }
      if (this.content != null) {
        paramVarArgs.e(6, this.content);
      }
      paramVarArgs.aO(7, this.wyt);
      paramVarArgs.aO(8, this.wyu);
      paramVarArgs.aO(9, this.wxI);
      paramVarArgs.aO(10, this.wxJ);
      if (this.wyv != null)
      {
        paramVarArgs.iQ(11, this.wyv.computeSize());
        this.wyv.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(12, this.wyw);
      paramVarArgs.aO(13, this.wyx);
      paramVarArgs.aO(14, this.wyy);
      paramVarArgs.aO(15, this.wyz);
      AppMethodBeat.o(14712);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = e.a.a.b.b.a.bl(1, this.wyr) + 0 + e.a.a.b.b.a.bl(2, this.wqK);
      paramInt = i;
      if (this.wys != null) {
        paramInt = i + e.a.a.b.b.a.f(3, this.wys);
      }
      i = paramInt;
      if (this.kVV != null) {
        i = paramInt + e.a.a.b.b.a.f(4, this.kVV);
      }
      paramInt = i;
      if (this.kmm != null) {
        paramInt = i + e.a.a.b.b.a.f(5, this.kmm);
      }
      i = paramInt;
      if (this.content != null) {
        i = paramInt + e.a.a.b.b.a.f(6, this.content);
      }
      i = i + e.a.a.b.b.a.bl(7, this.wyt) + e.a.a.b.b.a.bl(8, this.wyu) + e.a.a.b.b.a.bl(9, this.wxI) + e.a.a.b.b.a.bl(10, this.wxJ);
      paramInt = i;
      if (this.wyv != null) {
        paramInt = i + e.a.a.a.iP(11, this.wyv.computeSize());
      }
      i = e.a.a.b.b.a.bl(12, this.wyw);
      int j = e.a.a.b.b.a.bl(13, this.wyx);
      int k = e.a.a.b.b.a.bl(14, this.wyy);
      int m = e.a.a.b.b.a.bl(15, this.wyz);
      AppMethodBeat.o(14712);
      return paramInt + i + j + k + m;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.eqQ();
        }
      }
      AppMethodBeat.o(14712);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
      kx localkx = (kx)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(14712);
        return -1;
      case 1: 
        localkx.wyr = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(14712);
        return 0;
      case 2: 
        localkx.wqK = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(14712);
        return 0;
      case 3: 
        localkx.wys = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(14712);
        return 0;
      case 4: 
        localkx.kVV = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(14712);
        return 0;
      case 5: 
        localkx.kmm = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(14712);
        return 0;
      case 6: 
        localkx.content = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(14712);
        return 0;
      case 7: 
        localkx.wyt = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(14712);
        return 0;
      case 8: 
        localkx.wyu = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(14712);
        return 0;
      case 9: 
        localkx.wxI = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(14712);
        return 0;
      case 10: 
        localkx.wxJ = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(14712);
        return 0;
      case 11: 
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ut();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((ut)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localkx.wyv = ((ut)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(14712);
        return 0;
      case 12: 
        localkx.wyw = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(14712);
        return 0;
      case 13: 
        localkx.wyx = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(14712);
        return 0;
      case 14: 
        localkx.wyy = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(14712);
        return 0;
      }
      localkx.wyz = ((e.a.a.a.a)localObject1).CLY.sl();
      AppMethodBeat.o(14712);
      return 0;
    }
    AppMethodBeat.o(14712);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.kx
 * JD-Core Version:    0.7.0.1
 */