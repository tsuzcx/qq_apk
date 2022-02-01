package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ok
  extends com.tencent.mm.bx.a
{
  public LinkedList<String> FJN;
  public int FJO;
  public String FJT;
  public String FJU;
  public LinkedList<oj> FJV;
  public int FuX;
  public String jdf;
  public String nDo;
  public String nEt;
  public String uhr;
  
  public ok()
  {
    AppMethodBeat.i(207238);
    this.FJV = new LinkedList();
    this.FJN = new LinkedList();
    AppMethodBeat.o(207238);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(207239);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.FuX);
      if (this.nDo != null) {
        paramVarArgs.d(2, this.nDo);
      }
      if (this.nEt != null) {
        paramVarArgs.d(3, this.nEt);
      }
      if (this.uhr != null) {
        paramVarArgs.d(4, this.uhr);
      }
      if (this.jdf != null) {
        paramVarArgs.d(5, this.jdf);
      }
      if (this.FJT != null) {
        paramVarArgs.d(6, this.FJT);
      }
      if (this.FJU != null) {
        paramVarArgs.d(7, this.FJU);
      }
      paramVarArgs.e(8, 8, this.FJV);
      paramVarArgs.e(9, 1, this.FJN);
      paramVarArgs.aS(10, this.FJO);
      AppMethodBeat.o(207239);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bz(1, this.FuX) + 0;
      paramInt = i;
      if (this.nDo != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.nDo);
      }
      i = paramInt;
      if (this.nEt != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.nEt);
      }
      paramInt = i;
      if (this.uhr != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.uhr);
      }
      i = paramInt;
      if (this.jdf != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.jdf);
      }
      paramInt = i;
      if (this.FJT != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.FJT);
      }
      i = paramInt;
      if (this.FJU != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.FJU);
      }
      paramInt = f.a.a.a.c(8, 8, this.FJV);
      int j = f.a.a.a.c(9, 1, this.FJN);
      int k = f.a.a.b.b.a.bz(10, this.FJO);
      AppMethodBeat.o(207239);
      return i + paramInt + j + k;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.FJV.clear();
      this.FJN.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(207239);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      ok localok = (ok)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(207239);
        return -1;
      case 1: 
        localok.FuX = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(207239);
        return 0;
      case 2: 
        localok.nDo = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(207239);
        return 0;
      case 3: 
        localok.nEt = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(207239);
        return 0;
      case 4: 
        localok.uhr = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(207239);
        return 0;
      case 5: 
        localok.jdf = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(207239);
        return 0;
      case 6: 
        localok.FJT = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(207239);
        return 0;
      case 7: 
        localok.FJU = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(207239);
        return 0;
      case 8: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new oj();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((oj)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localok.FJV.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(207239);
        return 0;
      case 9: 
        localok.FJN.add(((f.a.a.a.a)localObject1).NPN.readString());
        AppMethodBeat.o(207239);
        return 0;
      }
      localok.FJO = ((f.a.a.a.a)localObject1).NPN.zc();
      AppMethodBeat.o(207239);
      return 0;
    }
    AppMethodBeat.o(207239);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ok
 * JD-Core Version:    0.7.0.1
 */