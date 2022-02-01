package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class brl
  extends com.tencent.mm.bx.a
{
  public LinkedList<brk> ZZF;
  public bri ZZG;
  public brj ZZH;
  public brj ZZI;
  public efp ZZJ;
  public LinkedList<bre> msn;
  
  public brl()
  {
    AppMethodBeat.i(257362);
    this.ZZF = new LinkedList();
    this.msn = new LinkedList();
    AppMethodBeat.o(257362);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(257366);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 8, this.ZZF);
      if (this.ZZG != null)
      {
        paramVarArgs.qD(2, this.ZZG.computeSize());
        this.ZZG.writeFields(paramVarArgs);
      }
      if (this.ZZH != null)
      {
        paramVarArgs.qD(3, this.ZZH.computeSize());
        this.ZZH.writeFields(paramVarArgs);
      }
      if (this.ZZI != null)
      {
        paramVarArgs.qD(4, this.ZZI.computeSize());
        this.ZZI.writeFields(paramVarArgs);
      }
      if (this.ZZJ != null)
      {
        paramVarArgs.qD(5, this.ZZJ.computeSize());
        this.ZZJ.writeFields(paramVarArgs);
      }
      paramVarArgs.e(6, 8, this.msn);
      AppMethodBeat.o(257366);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.a.c(1, 8, this.ZZF) + 0;
      paramInt = i;
      if (this.ZZG != null) {
        paramInt = i + i.a.a.a.qC(2, this.ZZG.computeSize());
      }
      i = paramInt;
      if (this.ZZH != null) {
        i = paramInt + i.a.a.a.qC(3, this.ZZH.computeSize());
      }
      paramInt = i;
      if (this.ZZI != null) {
        paramInt = i + i.a.a.a.qC(4, this.ZZI.computeSize());
      }
      i = paramInt;
      if (this.ZZJ != null) {
        i = paramInt + i.a.a.a.qC(5, this.ZZJ.computeSize());
      }
      paramInt = i.a.a.a.c(6, 8, this.msn);
      AppMethodBeat.o(257366);
      return i + paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.ZZF.clear();
      this.msn.clear();
      paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(257366);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
      brl localbrl = (brl)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(257366);
        return -1;
      case 1: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new brk();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((brk)localObject2).parseFrom((byte[])localObject1);
          }
          localbrl.ZZF.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(257366);
        return 0;
      case 2: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new bri();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((bri)localObject2).parseFrom((byte[])localObject1);
          }
          localbrl.ZZG = ((bri)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(257366);
        return 0;
      case 3: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new brj();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((brj)localObject2).parseFrom((byte[])localObject1);
          }
          localbrl.ZZH = ((brj)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(257366);
        return 0;
      case 4: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new brj();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((brj)localObject2).parseFrom((byte[])localObject1);
          }
          localbrl.ZZI = ((brj)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(257366);
        return 0;
      case 5: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new efp();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((efp)localObject2).parseFrom((byte[])localObject1);
          }
          localbrl.ZZJ = ((efp)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(257366);
        return 0;
      }
      paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject1 = (byte[])paramVarArgs.get(paramInt);
        localObject2 = new bre();
        if ((localObject1 != null) && (localObject1.length > 0)) {
          ((bre)localObject2).parseFrom((byte[])localObject1);
        }
        localbrl.msn.add(localObject2);
        paramInt += 1;
      }
      AppMethodBeat.o(257366);
      return 0;
    }
    AppMethodBeat.o(257366);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.brl
 * JD-Core Version:    0.7.0.1
 */