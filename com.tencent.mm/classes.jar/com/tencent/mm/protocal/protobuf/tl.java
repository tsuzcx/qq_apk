package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class tl
  extends com.tencent.mm.bv.a
{
  public int jKx;
  public int lGw;
  public LinkedList<ayt> nrw;
  public String wAb;
  public String wAc;
  public String wAd;
  public String wAe;
  public String wAf;
  public int wLO;
  public int wur;
  
  public tl()
  {
    AppMethodBeat.i(72841);
    this.nrw = new LinkedList();
    AppMethodBeat.o(72841);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72842);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aO(1, this.lGw);
      if (this.wAd != null) {
        paramVarArgs.e(7, this.wAd);
      }
      paramVarArgs.aO(2, this.wur);
      paramVarArgs.aO(3, this.wLO);
      paramVarArgs.e(4, 8, this.nrw);
      if (this.wAb != null) {
        paramVarArgs.e(5, this.wAb);
      }
      if (this.wAc != null) {
        paramVarArgs.e(6, this.wAc);
      }
      if (this.wAe != null) {
        paramVarArgs.e(8, this.wAe);
      }
      if (this.wAf != null) {
        paramVarArgs.e(9, this.wAf);
      }
      paramVarArgs.aO(10, this.jKx);
      AppMethodBeat.o(72842);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = e.a.a.b.b.a.bl(1, this.lGw) + 0;
      paramInt = i;
      if (this.wAd != null) {
        paramInt = i + e.a.a.b.b.a.f(7, this.wAd);
      }
      i = paramInt + e.a.a.b.b.a.bl(2, this.wur) + e.a.a.b.b.a.bl(3, this.wLO) + e.a.a.a.c(4, 8, this.nrw);
      paramInt = i;
      if (this.wAb != null) {
        paramInt = i + e.a.a.b.b.a.f(5, this.wAb);
      }
      i = paramInt;
      if (this.wAc != null) {
        i = paramInt + e.a.a.b.b.a.f(6, this.wAc);
      }
      paramInt = i;
      if (this.wAe != null) {
        paramInt = i + e.a.a.b.b.a.f(8, this.wAe);
      }
      i = paramInt;
      if (this.wAf != null) {
        i = paramInt + e.a.a.b.b.a.f(9, this.wAf);
      }
      paramInt = e.a.a.b.b.a.bl(10, this.jKx);
      AppMethodBeat.o(72842);
      return i + paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.nrw.clear();
      paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.eqQ();
        }
      }
      AppMethodBeat.o(72842);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
      tl localtl = (tl)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(72842);
        return -1;
      case 1: 
        localtl.lGw = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(72842);
        return 0;
      case 7: 
        localtl.wAd = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(72842);
        return 0;
      case 2: 
        localtl.wur = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(72842);
        return 0;
      case 3: 
        localtl.wLO = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(72842);
        return 0;
      case 4: 
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ayt();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((ayt)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localtl.nrw.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(72842);
        return 0;
      case 5: 
        localtl.wAb = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(72842);
        return 0;
      case 6: 
        localtl.wAc = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(72842);
        return 0;
      case 8: 
        localtl.wAe = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(72842);
        return 0;
      case 9: 
        localtl.wAf = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(72842);
        return 0;
      }
      localtl.jKx = ((e.a.a.a.a)localObject1).CLY.sl();
      AppMethodBeat.o(72842);
      return 0;
    }
    AppMethodBeat.o(72842);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.tl
 * JD-Core Version:    0.7.0.1
 */