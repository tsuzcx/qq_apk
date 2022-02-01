package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class aaz
  extends com.tencent.mm.bw.a
{
  public String FIf;
  public int GsR;
  public LinkedList<aay> GsS;
  public long Gsg;
  
  public aaz()
  {
    AppMethodBeat.i(211621);
    this.GsS = new LinkedList();
    AppMethodBeat.o(211621);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(211622);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aZ(1, this.Gsg);
      if (this.FIf != null) {
        paramVarArgs.d(2, this.FIf);
      }
      paramVarArgs.aS(3, this.GsR);
      paramVarArgs.e(4, 8, this.GsS);
      AppMethodBeat.o(211622);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.p(1, this.Gsg) + 0;
      paramInt = i;
      if (this.FIf != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.FIf);
      }
      i = f.a.a.b.b.a.bz(3, this.GsR);
      int j = f.a.a.a.c(4, 8, this.GsS);
      AppMethodBeat.o(211622);
      return paramInt + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.GsS.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(211622);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      aaz localaaz = (aaz)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(211622);
        return -1;
      case 1: 
        localaaz.Gsg = ((f.a.a.a.a)localObject1).OmT.zd();
        AppMethodBeat.o(211622);
        return 0;
      case 2: 
        localaaz.FIf = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(211622);
        return 0;
      case 3: 
        localaaz.GsR = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(211622);
        return 0;
      }
      paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        Object localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new aay();
        localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (boolean bool = true; bool; bool = ((aay)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
        localaaz.GsS.add(localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(211622);
      return 0;
    }
    AppMethodBeat.o(211622);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aaz
 * JD-Core Version:    0.7.0.1
 */