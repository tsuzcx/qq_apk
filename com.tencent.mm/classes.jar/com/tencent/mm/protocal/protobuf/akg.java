package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class akg
  extends com.tencent.mm.bx.a
{
  public int ZrA;
  public int Zru;
  public ake Zrv;
  public ake Zrw;
  public int Zrx;
  public int Zry;
  public int Zrz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(90966);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.Zru);
      if (this.Zrv != null)
      {
        paramVarArgs.qD(2, this.Zrv.computeSize());
        this.Zrv.writeFields(paramVarArgs);
      }
      if (this.Zrw != null)
      {
        paramVarArgs.qD(3, this.Zrw.computeSize());
        this.Zrw.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(4, this.Zrx);
      paramVarArgs.bS(5, this.Zry);
      paramVarArgs.bS(6, this.Zrz);
      paramVarArgs.bS(7, this.ZrA);
      AppMethodBeat.o(90966);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.b.b.a.cJ(1, this.Zru) + 0;
      paramInt = i;
      if (this.Zrv != null) {
        paramInt = i + i.a.a.a.qC(2, this.Zrv.computeSize());
      }
      i = paramInt;
      if (this.Zrw != null) {
        i = paramInt + i.a.a.a.qC(3, this.Zrw.computeSize());
      }
      paramInt = i.a.a.b.b.a.cJ(4, this.Zrx);
      int j = i.a.a.b.b.a.cJ(5, this.Zry);
      int k = i.a.a.b.b.a.cJ(6, this.Zrz);
      int m = i.a.a.b.b.a.cJ(7, this.ZrA);
      AppMethodBeat.o(90966);
      return i + paramInt + j + k + m;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(90966);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (i.a.a.a.a)paramVarArgs[0];
      akg localakg = (akg)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      ake localake;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(90966);
        return -1;
      case 1: 
        localakg.Zru = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(90966);
        return 0;
      case 2: 
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          localake = new ake();
          if ((localObject != null) && (localObject.length > 0)) {
            localake.parseFrom((byte[])localObject);
          }
          localakg.Zrv = localake;
          paramInt += 1;
        }
        AppMethodBeat.o(90966);
        return 0;
      case 3: 
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          localake = new ake();
          if ((localObject != null) && (localObject.length > 0)) {
            localake.parseFrom((byte[])localObject);
          }
          localakg.Zrw = localake;
          paramInt += 1;
        }
        AppMethodBeat.o(90966);
        return 0;
      case 4: 
        localakg.Zrx = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(90966);
        return 0;
      case 5: 
        localakg.Zry = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(90966);
        return 0;
      case 6: 
        localakg.Zrz = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(90966);
        return 0;
      }
      localakg.ZrA = ((i.a.a.a.a)localObject).ajGk.aar();
      AppMethodBeat.o(90966);
      return 0;
    }
    AppMethodBeat.o(90966);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.akg
 * JD-Core Version:    0.7.0.1
 */