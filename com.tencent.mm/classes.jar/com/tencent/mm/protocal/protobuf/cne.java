package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cne
  extends com.tencent.mm.bw.a
{
  public boolean GUi;
  public int HqE;
  public LinkedList<cdr> Hzm;
  public String Hzn;
  public String dyI;
  public String oGf;
  
  public cne()
  {
    AppMethodBeat.i(176148);
    this.Hzm = new LinkedList();
    AppMethodBeat.o(176148);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(176149);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 8, this.Hzm);
      if (this.dyI != null) {
        paramVarArgs.d(2, this.dyI);
      }
      if (this.Hzn != null) {
        paramVarArgs.d(3, this.Hzn);
      }
      if (this.oGf != null) {
        paramVarArgs.d(4, this.oGf);
      }
      paramVarArgs.bC(5, this.GUi);
      paramVarArgs.aS(6, this.HqE);
      AppMethodBeat.o(176149);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.a.c(1, 8, this.Hzm) + 0;
      paramInt = i;
      if (this.dyI != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.dyI);
      }
      i = paramInt;
      if (this.Hzn != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.Hzn);
      }
      paramInt = i;
      if (this.oGf != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.oGf);
      }
      i = f.a.a.b.b.a.amF(5);
      int j = f.a.a.b.b.a.bz(6, this.HqE);
      AppMethodBeat.o(176149);
      return paramInt + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.Hzm.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(176149);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      cne localcne = (cne)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(176149);
        return -1;
      case 1: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cdr();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((cdr)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localcne.Hzm.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(176149);
        return 0;
      case 2: 
        localcne.dyI = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(176149);
        return 0;
      case 3: 
        localcne.Hzn = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(176149);
        return 0;
      case 4: 
        localcne.oGf = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(176149);
        return 0;
      case 5: 
        localcne.GUi = ((f.a.a.a.a)localObject1).OmT.gvY();
        AppMethodBeat.o(176149);
        return 0;
      }
      localcne.HqE = ((f.a.a.a.a)localObject1).OmT.zc();
      AppMethodBeat.o(176149);
      return 0;
    }
    AppMethodBeat.o(176149);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cne
 * JD-Core Version:    0.7.0.1
 */