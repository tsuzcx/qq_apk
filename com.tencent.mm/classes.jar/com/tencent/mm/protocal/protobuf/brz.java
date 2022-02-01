package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class brz
  extends com.tencent.mm.bx.a
{
  public boolean GMQ;
  public csn GMR;
  public String dxD;
  public String kzK;
  public String kzL;
  public String title;
  public int uxt;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91528);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.uxt);
      paramVarArgs.bt(2, this.GMQ);
      if (this.dxD != null) {
        paramVarArgs.d(3, this.dxD);
      }
      if (this.kzK != null) {
        paramVarArgs.d(4, this.kzK);
      }
      if (this.kzL != null) {
        paramVarArgs.d(5, this.kzL);
      }
      if (this.GMR != null)
      {
        paramVarArgs.lC(6, this.GMR.computeSize());
        this.GMR.writeFields(paramVarArgs);
      }
      if (this.title != null) {
        paramVarArgs.d(7, this.title);
      }
      AppMethodBeat.o(91528);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bz(1, this.uxt) + 0 + f.a.a.b.b.a.alV(2);
      paramInt = i;
      if (this.dxD != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.dxD);
      }
      i = paramInt;
      if (this.kzK != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.kzK);
      }
      paramInt = i;
      if (this.kzL != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.kzL);
      }
      i = paramInt;
      if (this.GMR != null) {
        i = paramInt + f.a.a.a.lB(6, this.GMR.computeSize());
      }
      paramInt = i;
      if (this.title != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.title);
      }
      AppMethodBeat.o(91528);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(91528);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      brz localbrz = (brz)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(91528);
        return -1;
      case 1: 
        localbrz.uxt = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(91528);
        return 0;
      case 2: 
        localbrz.GMQ = ((f.a.a.a.a)localObject1).NPN.grw();
        AppMethodBeat.o(91528);
        return 0;
      case 3: 
        localbrz.dxD = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(91528);
        return 0;
      case 4: 
        localbrz.kzK = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(91528);
        return 0;
      case 5: 
        localbrz.kzL = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(91528);
        return 0;
      case 6: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new csn();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((csn)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbrz.GMR = ((csn)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91528);
        return 0;
      }
      localbrz.title = ((f.a.a.a.a)localObject1).NPN.readString();
      AppMethodBeat.o(91528);
      return 0;
    }
    AppMethodBeat.o(91528);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.brz
 * JD-Core Version:    0.7.0.1
 */