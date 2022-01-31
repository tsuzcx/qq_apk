package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cju
  extends com.tencent.mm.bv.a
{
  public float size;
  public String text;
  public bvz wna;
  public String wug;
  public long xTK;
  public String xTL;
  public int xTM;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(48969);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.am(1, this.xTK);
      if (this.xTL != null) {
        paramVarArgs.e(2, this.xTL);
      }
      if (this.text != null) {
        paramVarArgs.e(3, this.text);
      }
      paramVarArgs.q(4, this.size);
      if (this.wna != null)
      {
        paramVarArgs.iQ(5, this.wna.computeSize());
        this.wna.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(6, this.xTM);
      if (this.wug != null) {
        paramVarArgs.e(7, this.wug);
      }
      AppMethodBeat.o(48969);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = e.a.a.b.b.a.p(1, this.xTK) + 0;
      paramInt = i;
      if (this.xTL != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.xTL);
      }
      i = paramInt;
      if (this.text != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.text);
      }
      i += e.a.a.b.b.a.eW(4) + 4;
      paramInt = i;
      if (this.wna != null) {
        paramInt = i + e.a.a.a.iP(5, this.wna.computeSize());
      }
      i = paramInt + e.a.a.b.b.a.bl(6, this.xTM);
      paramInt = i;
      if (this.wug != null) {
        paramInt = i + e.a.a.b.b.a.f(7, this.wug);
      }
      AppMethodBeat.o(48969);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.eqQ();
        }
      }
      AppMethodBeat.o(48969);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
      cju localcju = (cju)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(48969);
        return -1;
      case 1: 
        localcju.xTK = ((e.a.a.a.a)localObject1).CLY.sm();
        AppMethodBeat.o(48969);
        return 0;
      case 2: 
        localcju.xTL = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(48969);
        return 0;
      case 3: 
        localcju.text = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(48969);
        return 0;
      case 4: 
        localcju.size = Float.intBitsToFloat(((e.a.a.a.a)localObject1).CLY.emx());
        AppMethodBeat.o(48969);
        return 0;
      case 5: 
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bvz();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((bvz)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localcju.wna = ((bvz)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(48969);
        return 0;
      case 6: 
        localcju.xTM = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(48969);
        return 0;
      }
      localcju.wug = ((e.a.a.a.a)localObject1).CLY.readString();
      AppMethodBeat.o(48969);
      return 0;
    }
    AppMethodBeat.o(48969);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cju
 * JD-Core Version:    0.7.0.1
 */