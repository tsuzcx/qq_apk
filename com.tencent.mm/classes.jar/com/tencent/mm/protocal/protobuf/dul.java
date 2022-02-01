package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dul
  extends com.tencent.mm.bx.a
{
  public LinkedList<vq> ZpP;
  public int ZpQ;
  public int ZpR;
  public long lastUpdateTime;
  public int version;
  
  public dul()
  {
    AppMethodBeat.i(32357);
    this.ZpP = new LinkedList();
    AppMethodBeat.o(32357);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32358);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 8, this.ZpP);
      paramVarArgs.bS(2, this.version);
      paramVarArgs.bS(3, this.ZpQ);
      paramVarArgs.bS(4, this.ZpR);
      paramVarArgs.bv(5, this.lastUpdateTime);
      AppMethodBeat.o(32358);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = i.a.a.a.c(1, 8, this.ZpP);
      i = i.a.a.b.b.a.cJ(2, this.version);
      int j = i.a.a.b.b.a.cJ(3, this.ZpQ);
      int k = i.a.a.b.b.a.cJ(4, this.ZpR);
      int m = i.a.a.b.b.a.q(5, this.lastUpdateTime);
      AppMethodBeat.o(32358);
      return paramInt + 0 + i + j + k + m;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.ZpP.clear();
      paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(32358);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (i.a.a.a.a)paramVarArgs[0];
      dul localdul = (dul)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(32358);
        return -1;
      case 1: 
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          vq localvq = new vq();
          if ((localObject != null) && (localObject.length > 0)) {
            localvq.parseFrom((byte[])localObject);
          }
          localdul.ZpP.add(localvq);
          paramInt += 1;
        }
        AppMethodBeat.o(32358);
        return 0;
      case 2: 
        localdul.version = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(32358);
        return 0;
      case 3: 
        localdul.ZpQ = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(32358);
        return 0;
      case 4: 
        localdul.ZpR = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(32358);
        return 0;
      }
      localdul.lastUpdateTime = ((i.a.a.a.a)localObject).ajGk.aaw();
      AppMethodBeat.o(32358);
      return 0;
    }
    AppMethodBeat.o(32358);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dul
 * JD-Core Version:    0.7.0.1
 */