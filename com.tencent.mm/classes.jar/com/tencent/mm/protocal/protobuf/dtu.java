package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dtu
  extends com.tencent.mm.bx.a
{
  public LinkedList<dtv> GXq;
  public boolean kzP;
  public int kzQ;
  public int kzR;
  public String kzS;
  public String kzT;
  public String kzU;
  public String kzV;
  
  public dtu()
  {
    AppMethodBeat.i(123670);
    this.GXq = new LinkedList();
    AppMethodBeat.o(123670);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123671);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 8, this.GXq);
      paramVarArgs.bt(2, this.kzP);
      paramVarArgs.aS(3, this.kzQ);
      paramVarArgs.aS(4, this.kzR);
      if (this.kzS != null) {
        paramVarArgs.d(5, this.kzS);
      }
      if (this.kzT != null) {
        paramVarArgs.d(6, this.kzT);
      }
      if (this.kzU != null) {
        paramVarArgs.d(7, this.kzU);
      }
      if (this.kzV != null) {
        paramVarArgs.d(8, this.kzV);
      }
      AppMethodBeat.o(123671);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.a.c(1, 8, this.GXq) + 0 + f.a.a.b.b.a.alV(2) + f.a.a.b.b.a.bz(3, this.kzQ) + f.a.a.b.b.a.bz(4, this.kzR);
      paramInt = i;
      if (this.kzS != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.kzS);
      }
      i = paramInt;
      if (this.kzT != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.kzT);
      }
      paramInt = i;
      if (this.kzU != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.kzU);
      }
      i = paramInt;
      if (this.kzV != null) {
        i = paramInt + f.a.a.b.b.a.e(8, this.kzV);
      }
      AppMethodBeat.o(123671);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.GXq.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(123671);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      dtu localdtu = (dtu)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(123671);
        return -1;
      case 1: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dtv();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((dtv)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdtu.GXq.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(123671);
        return 0;
      case 2: 
        localdtu.kzP = ((f.a.a.a.a)localObject1).NPN.grw();
        AppMethodBeat.o(123671);
        return 0;
      case 3: 
        localdtu.kzQ = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(123671);
        return 0;
      case 4: 
        localdtu.kzR = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(123671);
        return 0;
      case 5: 
        localdtu.kzS = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(123671);
        return 0;
      case 6: 
        localdtu.kzT = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(123671);
        return 0;
      case 7: 
        localdtu.kzU = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(123671);
        return 0;
      }
      localdtu.kzV = ((f.a.a.a.a)localObject1).NPN.readString();
      AppMethodBeat.o(123671);
      return 0;
    }
    AppMethodBeat.o(123671);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dtu
 * JD-Core Version:    0.7.0.1
 */