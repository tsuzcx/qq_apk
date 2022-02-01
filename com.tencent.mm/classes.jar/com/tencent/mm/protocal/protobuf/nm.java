package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class nm
  extends com.tencent.mm.bx.a
{
  public LinkedList<eaw> FHK;
  public LinkedList<String> FHM;
  public String FHN;
  public String FHO;
  
  public nm()
  {
    AppMethodBeat.i(207224);
    this.FHK = new LinkedList();
    this.FHM = new LinkedList();
    AppMethodBeat.o(207224);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(207225);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(15, 8, this.FHK);
      paramVarArgs.e(17, 1, this.FHM);
      if (this.FHN != null) {
        paramVarArgs.d(18, this.FHN);
      }
      if (this.FHO != null) {
        paramVarArgs.d(19, this.FHO);
      }
      AppMethodBeat.o(207225);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.a.c(15, 8, this.FHK) + 0 + f.a.a.a.c(17, 1, this.FHM);
      paramInt = i;
      if (this.FHN != null) {
        paramInt = i + f.a.a.b.b.a.e(18, this.FHN);
      }
      i = paramInt;
      if (this.FHO != null) {
        i = paramInt + f.a.a.b.b.a.e(19, this.FHO);
      }
      AppMethodBeat.o(207225);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.FHK.clear();
      this.FHM.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(207225);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      nm localnm = (nm)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      case 16: 
      default: 
        AppMethodBeat.o(207225);
        return -1;
      case 15: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new eaw();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((eaw)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localnm.FHK.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(207225);
        return 0;
      case 17: 
        localnm.FHM.add(((f.a.a.a.a)localObject1).NPN.readString());
        AppMethodBeat.o(207225);
        return 0;
      case 18: 
        localnm.FHN = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(207225);
        return 0;
      }
      localnm.FHO = ((f.a.a.a.a)localObject1).NPN.readString();
      AppMethodBeat.o(207225);
      return 0;
    }
    AppMethodBeat.o(207225);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.nm
 * JD-Core Version:    0.7.0.1
 */