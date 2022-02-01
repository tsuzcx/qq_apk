package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class btv
  extends com.tencent.mm.bx.a
{
  public int aabw;
  public btw aabx;
  public LinkedList<btw> aaby;
  
  public btv()
  {
    AppMethodBeat.i(259470);
    this.aaby = new LinkedList();
    AppMethodBeat.o(259470);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(169043);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.aabw);
      if (this.aabx != null)
      {
        paramVarArgs.qD(2, this.aabx.computeSize());
        this.aabx.writeFields(paramVarArgs);
      }
      paramVarArgs.e(3, 8, this.aaby);
      AppMethodBeat.o(169043);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.b.b.a.cJ(1, this.aabw) + 0;
      paramInt = i;
      if (this.aabx != null) {
        paramInt = i + i.a.a.a.qC(2, this.aabx.computeSize());
      }
      i = i.a.a.a.c(3, 8, this.aaby);
      AppMethodBeat.o(169043);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.aaby.clear();
      paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(169043);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (i.a.a.a.a)paramVarArgs[0];
      btv localbtv = (btv)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      btw localbtw;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(169043);
        return -1;
      case 1: 
        localbtv.aabw = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(169043);
        return 0;
      case 2: 
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          localbtw = new btw();
          if ((localObject != null) && (localObject.length > 0)) {
            localbtw.parseFrom((byte[])localObject);
          }
          localbtv.aabx = localbtw;
          paramInt += 1;
        }
        AppMethodBeat.o(169043);
        return 0;
      }
      paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject = (byte[])paramVarArgs.get(paramInt);
        localbtw = new btw();
        if ((localObject != null) && (localObject.length > 0)) {
          localbtw.parseFrom((byte[])localObject);
        }
        localbtv.aaby.add(localbtw);
        paramInt += 1;
      }
      AppMethodBeat.o(169043);
      return 0;
    }
    AppMethodBeat.o(169043);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.btv
 * JD-Core Version:    0.7.0.1
 */