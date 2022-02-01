package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ak
  extends com.tencent.mm.bx.a
{
  public int YAV;
  public int YAW;
  public int YAX;
  public LinkedList<ai> YAY;
  public int YAZ;
  public LinkedList<ai> YBa;
  
  public ak()
  {
    AppMethodBeat.i(143963);
    this.YAY = new LinkedList();
    this.YBa = new LinkedList();
    AppMethodBeat.o(143963);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(143964);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.YAV);
      paramVarArgs.bS(2, this.YAX);
      paramVarArgs.e(3, 8, this.YAY);
      paramVarArgs.bS(4, this.YAW);
      paramVarArgs.bS(5, this.YAZ);
      paramVarArgs.e(6, 8, this.YBa);
      AppMethodBeat.o(143964);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = i.a.a.b.b.a.cJ(1, this.YAV);
      i = i.a.a.b.b.a.cJ(2, this.YAX);
      int j = i.a.a.a.c(3, 8, this.YAY);
      int k = i.a.a.b.b.a.cJ(4, this.YAW);
      int m = i.a.a.b.b.a.cJ(5, this.YAZ);
      int n = i.a.a.a.c(6, 8, this.YBa);
      AppMethodBeat.o(143964);
      return paramInt + 0 + i + j + k + m + n;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.YAY.clear();
      this.YBa.clear();
      paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(143964);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (i.a.a.a.a)paramVarArgs[0];
      ak localak = (ak)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      ai localai;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(143964);
        return -1;
      case 1: 
        localak.YAV = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(143964);
        return 0;
      case 2: 
        localak.YAX = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(143964);
        return 0;
      case 3: 
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          localai = new ai();
          if ((localObject != null) && (localObject.length > 0)) {
            localai.parseFrom((byte[])localObject);
          }
          localak.YAY.add(localai);
          paramInt += 1;
        }
        AppMethodBeat.o(143964);
        return 0;
      case 4: 
        localak.YAW = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(143964);
        return 0;
      case 5: 
        localak.YAZ = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(143964);
        return 0;
      }
      paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject = (byte[])paramVarArgs.get(paramInt);
        localai = new ai();
        if ((localObject != null) && (localObject.length > 0)) {
          localai.parseFrom((byte[])localObject);
        }
        localak.YBa.add(localai);
        paramInt += 1;
      }
      AppMethodBeat.o(143964);
      return 0;
    }
    AppMethodBeat.o(143964);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ak
 * JD-Core Version:    0.7.0.1
 */