package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class bsq
  extends com.tencent.mm.bv.a
{
  public String fjW;
  public String kXr;
  public int xGe;
  public float xGi;
  public float xGj;
  public String xGk;
  public LinkedList<String> xGl;
  public String xGm;
  public LinkedList<String> xGn;
  public LinkedList<bsr> xGo;
  
  public bsq()
  {
    AppMethodBeat.i(108899);
    this.xGl = new LinkedList();
    this.xGn = new LinkedList();
    this.xGo = new LinkedList();
    AppMethodBeat.o(108899);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(108900);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.xGk == null)
      {
        paramVarArgs = new b("Not all required fields were included: music_url");
        AppMethodBeat.o(108900);
        throw paramVarArgs;
      }
      paramVarArgs.aO(1, this.xGe);
      paramVarArgs.q(2, this.xGi);
      paramVarArgs.q(3, this.xGj);
      if (this.xGk != null) {
        paramVarArgs.e(4, this.xGk);
      }
      paramVarArgs.e(5, 1, this.xGl);
      if (this.xGm != null) {
        paramVarArgs.e(6, this.xGm);
      }
      paramVarArgs.e(7, 1, this.xGn);
      paramVarArgs.e(8, 8, this.xGo);
      if (this.kXr != null) {
        paramVarArgs.e(9, this.kXr);
      }
      if (this.fjW != null) {
        paramVarArgs.e(10, this.fjW);
      }
      AppMethodBeat.o(108900);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = e.a.a.b.b.a.bl(1, this.xGe) + 0 + (e.a.a.b.b.a.eW(2) + 4) + (e.a.a.b.b.a.eW(3) + 4);
      paramInt = i;
      if (this.xGk != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.xGk);
      }
      i = paramInt + e.a.a.a.c(5, 1, this.xGl);
      paramInt = i;
      if (this.xGm != null) {
        paramInt = i + e.a.a.b.b.a.f(6, this.xGm);
      }
      i = paramInt + e.a.a.a.c(7, 1, this.xGn) + e.a.a.a.c(8, 8, this.xGo);
      paramInt = i;
      if (this.kXr != null) {
        paramInt = i + e.a.a.b.b.a.f(9, this.kXr);
      }
      i = paramInt;
      if (this.fjW != null) {
        i = paramInt + e.a.a.b.b.a.f(10, this.fjW);
      }
      AppMethodBeat.o(108900);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.xGl.clear();
      this.xGn.clear();
      this.xGo.clear();
      paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.eqQ();
        }
      }
      if (this.xGk == null)
      {
        paramVarArgs = new b("Not all required fields were included: music_url");
        AppMethodBeat.o(108900);
        throw paramVarArgs;
      }
      AppMethodBeat.o(108900);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
      bsq localbsq = (bsq)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(108900);
        return -1;
      case 1: 
        localbsq.xGe = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(108900);
        return 0;
      case 2: 
        localbsq.xGi = Float.intBitsToFloat(((e.a.a.a.a)localObject1).CLY.emx());
        AppMethodBeat.o(108900);
        return 0;
      case 3: 
        localbsq.xGj = Float.intBitsToFloat(((e.a.a.a.a)localObject1).CLY.emx());
        AppMethodBeat.o(108900);
        return 0;
      case 4: 
        localbsq.xGk = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(108900);
        return 0;
      case 5: 
        localbsq.xGl.add(((e.a.a.a.a)localObject1).CLY.readString());
        AppMethodBeat.o(108900);
        return 0;
      case 6: 
        localbsq.xGm = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(108900);
        return 0;
      case 7: 
        localbsq.xGn.add(((e.a.a.a.a)localObject1).CLY.readString());
        AppMethodBeat.o(108900);
        return 0;
      case 8: 
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bsr();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((bsr)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localbsq.xGo.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(108900);
        return 0;
      case 9: 
        localbsq.kXr = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(108900);
        return 0;
      }
      localbsq.fjW = ((e.a.a.a.a)localObject1).CLY.readString();
      AppMethodBeat.o(108900);
      return 0;
    }
    AppMethodBeat.o(108900);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bsq
 * JD-Core Version:    0.7.0.1
 */