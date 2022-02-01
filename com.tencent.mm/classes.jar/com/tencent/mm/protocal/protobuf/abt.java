package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class abt
  extends com.tencent.mm.bw.a
{
  public dnl FLn;
  public String FUn;
  public LinkedList<dnl> Gjz;
  public LinkedList<dnl> GtL;
  public String GtM;
  public int state;
  
  public abt()
  {
    AppMethodBeat.i(91427);
    this.Gjz = new LinkedList();
    this.GtL = new LinkedList();
    AppMethodBeat.o(91427);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91428);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.state);
      if (this.FLn != null)
      {
        paramVarArgs.lJ(2, this.FLn.computeSize());
        this.FLn.writeFields(paramVarArgs);
      }
      paramVarArgs.e(3, 8, this.Gjz);
      paramVarArgs.e(4, 8, this.GtL);
      if (this.GtM != null) {
        paramVarArgs.d(5, this.GtM);
      }
      if (this.FUn != null) {
        paramVarArgs.d(6, this.FUn);
      }
      AppMethodBeat.o(91428);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bz(1, this.state) + 0;
      paramInt = i;
      if (this.FLn != null) {
        paramInt = i + f.a.a.a.lI(2, this.FLn.computeSize());
      }
      i = paramInt + f.a.a.a.c(3, 8, this.Gjz) + f.a.a.a.c(4, 8, this.GtL);
      paramInt = i;
      if (this.GtM != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.GtM);
      }
      i = paramInt;
      if (this.FUn != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.FUn);
      }
      AppMethodBeat.o(91428);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.Gjz.clear();
      this.GtL.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(91428);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      abt localabt = (abt)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(91428);
        return -1;
      case 1: 
        localabt.state = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(91428);
        return 0;
      case 2: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dnl();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dnl)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localabt.FLn = ((dnl)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91428);
        return 0;
      case 3: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dnl();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dnl)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localabt.Gjz.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91428);
        return 0;
      case 4: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dnl();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dnl)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localabt.GtL.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91428);
        return 0;
      case 5: 
        localabt.GtM = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(91428);
        return 0;
      }
      localabt.FUn = ((f.a.a.a.a)localObject1).OmT.readString();
      AppMethodBeat.o(91428);
      return 0;
    }
    AppMethodBeat.o(91428);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.abt
 * JD-Core Version:    0.7.0.1
 */