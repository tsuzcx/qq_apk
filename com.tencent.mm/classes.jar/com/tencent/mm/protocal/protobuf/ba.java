package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ba
  extends com.tencent.mm.bx.a
{
  public dy FsA;
  public ep FsB;
  public eo FsC;
  public eo FsD;
  public String Fsv;
  public String Fsw;
  public String Fsx;
  public ay Fsy;
  public String Fsz;
  public int Scene;
  public String Url;
  public int nEf;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125689);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.nEf);
      if (this.Url != null) {
        paramVarArgs.d(2, this.Url);
      }
      paramVarArgs.aS(3, this.Scene);
      if (this.Fsv != null) {
        paramVarArgs.d(4, this.Fsv);
      }
      if (this.Fsw != null) {
        paramVarArgs.d(5, this.Fsw);
      }
      if (this.Fsx != null) {
        paramVarArgs.d(6, this.Fsx);
      }
      if (this.Fsy != null)
      {
        paramVarArgs.lC(7, this.Fsy.computeSize());
        this.Fsy.writeFields(paramVarArgs);
      }
      if (this.Fsz != null) {
        paramVarArgs.d(8, this.Fsz);
      }
      if (this.FsA != null)
      {
        paramVarArgs.lC(9, this.FsA.computeSize());
        this.FsA.writeFields(paramVarArgs);
      }
      if (this.FsB != null)
      {
        paramVarArgs.lC(10, this.FsB.computeSize());
        this.FsB.writeFields(paramVarArgs);
      }
      if (this.FsC != null)
      {
        paramVarArgs.lC(11, this.FsC.computeSize());
        this.FsC.writeFields(paramVarArgs);
      }
      if (this.FsD != null)
      {
        paramVarArgs.lC(12, this.FsD.computeSize());
        this.FsD.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(125689);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bz(1, this.nEf) + 0;
      paramInt = i;
      if (this.Url != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.Url);
      }
      i = paramInt + f.a.a.b.b.a.bz(3, this.Scene);
      paramInt = i;
      if (this.Fsv != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.Fsv);
      }
      i = paramInt;
      if (this.Fsw != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.Fsw);
      }
      paramInt = i;
      if (this.Fsx != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.Fsx);
      }
      i = paramInt;
      if (this.Fsy != null) {
        i = paramInt + f.a.a.a.lB(7, this.Fsy.computeSize());
      }
      paramInt = i;
      if (this.Fsz != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.Fsz);
      }
      i = paramInt;
      if (this.FsA != null) {
        i = paramInt + f.a.a.a.lB(9, this.FsA.computeSize());
      }
      paramInt = i;
      if (this.FsB != null) {
        paramInt = i + f.a.a.a.lB(10, this.FsB.computeSize());
      }
      i = paramInt;
      if (this.FsC != null) {
        i = paramInt + f.a.a.a.lB(11, this.FsC.computeSize());
      }
      paramInt = i;
      if (this.FsD != null) {
        paramInt = i + f.a.a.a.lB(12, this.FsD.computeSize());
      }
      AppMethodBeat.o(125689);
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
      AppMethodBeat.o(125689);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      ba localba = (ba)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(125689);
        return -1;
      case 1: 
        localba.nEf = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(125689);
        return 0;
      case 2: 
        localba.Url = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(125689);
        return 0;
      case 3: 
        localba.Scene = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(125689);
        return 0;
      case 4: 
        localba.Fsv = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(125689);
        return 0;
      case 5: 
        localba.Fsw = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(125689);
        return 0;
      case 6: 
        localba.Fsx = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(125689);
        return 0;
      case 7: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ay();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((ay)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localba.Fsy = ((ay)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(125689);
        return 0;
      case 8: 
        localba.Fsz = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(125689);
        return 0;
      case 9: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dy();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dy)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localba.FsA = ((dy)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(125689);
        return 0;
      case 10: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ep();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((ep)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localba.FsB = ((ep)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(125689);
        return 0;
      case 11: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new eo();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((eo)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localba.FsC = ((eo)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(125689);
        return 0;
      }
      paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new eo();
        localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((eo)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
        localba.FsD = ((eo)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(125689);
      return 0;
    }
    AppMethodBeat.o(125689);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ba
 * JD-Core Version:    0.7.0.1
 */