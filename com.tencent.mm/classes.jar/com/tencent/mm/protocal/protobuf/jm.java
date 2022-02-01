package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class jm
  extends com.tencent.mm.bx.a
{
  public dvm YLF;
  public dvm YLG;
  public dvm YLH;
  public dvm YLI;
  public int YLJ;
  public int YLK;
  public int YLL;
  public int type;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(118406);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.type);
      if (this.YLF != null)
      {
        paramVarArgs.qD(2, this.YLF.computeSize());
        this.YLF.writeFields(paramVarArgs);
      }
      if (this.YLG != null)
      {
        paramVarArgs.qD(3, this.YLG.computeSize());
        this.YLG.writeFields(paramVarArgs);
      }
      if (this.YLH != null)
      {
        paramVarArgs.qD(4, this.YLH.computeSize());
        this.YLH.writeFields(paramVarArgs);
      }
      if (this.YLI != null)
      {
        paramVarArgs.qD(11, this.YLI.computeSize());
        this.YLI.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(100, this.YLJ);
      paramVarArgs.bS(101, this.YLK);
      paramVarArgs.bS(102, this.YLL);
      AppMethodBeat.o(118406);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.b.b.a.cJ(1, this.type) + 0;
      paramInt = i;
      if (this.YLF != null) {
        paramInt = i + i.a.a.a.qC(2, this.YLF.computeSize());
      }
      i = paramInt;
      if (this.YLG != null) {
        i = paramInt + i.a.a.a.qC(3, this.YLG.computeSize());
      }
      paramInt = i;
      if (this.YLH != null) {
        paramInt = i + i.a.a.a.qC(4, this.YLH.computeSize());
      }
      i = paramInt;
      if (this.YLI != null) {
        i = paramInt + i.a.a.a.qC(11, this.YLI.computeSize());
      }
      paramInt = i.a.a.b.b.a.cJ(100, this.YLJ);
      int j = i.a.a.b.b.a.cJ(101, this.YLK);
      int k = i.a.a.b.b.a.cJ(102, this.YLL);
      AppMethodBeat.o(118406);
      return i + paramInt + j + k;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(118406);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (i.a.a.a.a)paramVarArgs[0];
      jm localjm = (jm)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      dvm localdvm;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(118406);
        return -1;
      case 1: 
        localjm.type = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(118406);
        return 0;
      case 2: 
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          localdvm = new dvm();
          if ((localObject != null) && (localObject.length > 0)) {
            localdvm.parseFrom((byte[])localObject);
          }
          localjm.YLF = localdvm;
          paramInt += 1;
        }
        AppMethodBeat.o(118406);
        return 0;
      case 3: 
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          localdvm = new dvm();
          if ((localObject != null) && (localObject.length > 0)) {
            localdvm.parseFrom((byte[])localObject);
          }
          localjm.YLG = localdvm;
          paramInt += 1;
        }
        AppMethodBeat.o(118406);
        return 0;
      case 4: 
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          localdvm = new dvm();
          if ((localObject != null) && (localObject.length > 0)) {
            localdvm.parseFrom((byte[])localObject);
          }
          localjm.YLH = localdvm;
          paramInt += 1;
        }
        AppMethodBeat.o(118406);
        return 0;
      case 11: 
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          localdvm = new dvm();
          if ((localObject != null) && (localObject.length > 0)) {
            localdvm.parseFrom((byte[])localObject);
          }
          localjm.YLI = localdvm;
          paramInt += 1;
        }
        AppMethodBeat.o(118406);
        return 0;
      case 100: 
        localjm.YLJ = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(118406);
        return 0;
      case 101: 
        localjm.YLK = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(118406);
        return 0;
      }
      localjm.YLL = ((i.a.a.a.a)localObject).ajGk.aar();
      AppMethodBeat.o(118406);
      return 0;
    }
    AppMethodBeat.o(118406);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.jm
 * JD-Core Version:    0.7.0.1
 */