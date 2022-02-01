package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bzj
  extends com.tencent.mm.bx.a
{
  public czu aaiA;
  public int aaiB = -1;
  public int aaiC = -1;
  public boolean aaiD = false;
  public int aaiE = -1;
  public int type = -1;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(122490);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.type);
      if (this.aaiA != null)
      {
        paramVarArgs.qD(2, this.aaiA.computeSize());
        this.aaiA.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(3, this.aaiB);
      paramVarArgs.bS(4, this.aaiC);
      paramVarArgs.di(5, this.aaiD);
      paramVarArgs.bS(6, this.aaiE);
      AppMethodBeat.o(122490);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.b.b.a.cJ(1, this.type) + 0;
      paramInt = i;
      if (this.aaiA != null) {
        paramInt = i + i.a.a.a.qC(2, this.aaiA.computeSize());
      }
      i = i.a.a.b.b.a.cJ(3, this.aaiB);
      int j = i.a.a.b.b.a.cJ(4, this.aaiC);
      int k = i.a.a.b.b.a.ko(5);
      int m = i.a.a.b.b.a.cJ(6, this.aaiE);
      AppMethodBeat.o(122490);
      return paramInt + i + j + (k + 1) + m;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(122490);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (i.a.a.a.a)paramVarArgs[0];
      bzj localbzj = (bzj)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(122490);
        return -1;
      case 1: 
        localbzj.type = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(122490);
        return 0;
      case 2: 
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          czu localczu = new czu();
          if ((localObject != null) && (localObject.length > 0)) {
            localczu.parseFrom((byte[])localObject);
          }
          localbzj.aaiA = localczu;
          paramInt += 1;
        }
        AppMethodBeat.o(122490);
        return 0;
      case 3: 
        localbzj.aaiB = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(122490);
        return 0;
      case 4: 
        localbzj.aaiC = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(122490);
        return 0;
      case 5: 
        localbzj.aaiD = ((i.a.a.a.a)localObject).ajGk.aai();
        AppMethodBeat.o(122490);
        return 0;
      }
      localbzj.aaiE = ((i.a.a.a.a)localObject).ajGk.aar();
      AppMethodBeat.o(122490);
      return 0;
    }
    AppMethodBeat.o(122490);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bzj
 * JD-Core Version:    0.7.0.1
 */