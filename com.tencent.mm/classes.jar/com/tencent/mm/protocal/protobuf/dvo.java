package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dvo
  extends com.tencent.mm.bx.a
{
  public LinkedList<dvp> FUp;
  public int HBl;
  public String HfN;
  public String duW;
  public String dxD;
  public int version;
  
  public dvo()
  {
    AppMethodBeat.i(176154);
    this.FUp = new LinkedList();
    AppMethodBeat.o(176154);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(176155);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 8, this.FUp);
      if (this.dxD != null) {
        paramVarArgs.d(2, this.dxD);
      }
      paramVarArgs.aS(3, this.HBl);
      if (this.HfN != null) {
        paramVarArgs.d(4, this.HfN);
      }
      if (this.duW != null) {
        paramVarArgs.d(5, this.duW);
      }
      paramVarArgs.aS(6, this.version);
      AppMethodBeat.o(176155);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.a.c(1, 8, this.FUp) + 0;
      paramInt = i;
      if (this.dxD != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.dxD);
      }
      i = paramInt + f.a.a.b.b.a.bz(3, this.HBl);
      paramInt = i;
      if (this.HfN != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.HfN);
      }
      i = paramInt;
      if (this.duW != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.duW);
      }
      paramInt = f.a.a.b.b.a.bz(6, this.version);
      AppMethodBeat.o(176155);
      return i + paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.FUp.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(176155);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      dvo localdvo = (dvo)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(176155);
        return -1;
      case 1: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dvp();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((dvp)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdvo.FUp.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(176155);
        return 0;
      case 2: 
        localdvo.dxD = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(176155);
        return 0;
      case 3: 
        localdvo.HBl = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(176155);
        return 0;
      case 4: 
        localdvo.HfN = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(176155);
        return 0;
      case 5: 
        localdvo.duW = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(176155);
        return 0;
      }
      localdvo.version = ((f.a.a.a.a)localObject1).NPN.zc();
      AppMethodBeat.o(176155);
      return 0;
    }
    AppMethodBeat.o(176155);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dvo
 * JD-Core Version:    0.7.0.1
 */