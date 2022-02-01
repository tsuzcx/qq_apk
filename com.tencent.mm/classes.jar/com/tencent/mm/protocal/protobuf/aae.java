package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class aae
  extends com.tencent.mm.bw.a
{
  public String FQf;
  public aaa GrA;
  public String Grz;
  public String dyb;
  public long timestamp;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117861);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aZ(1, this.timestamp);
      if (this.Grz != null) {
        paramVarArgs.d(2, this.Grz);
      }
      if (this.FQf != null) {
        paramVarArgs.d(3, this.FQf);
      }
      if (this.dyb != null) {
        paramVarArgs.d(4, this.dyb);
      }
      if (this.GrA != null)
      {
        paramVarArgs.lJ(5, this.GrA.computeSize());
        this.GrA.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(117861);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.p(1, this.timestamp) + 0;
      paramInt = i;
      if (this.Grz != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.Grz);
      }
      i = paramInt;
      if (this.FQf != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.FQf);
      }
      paramInt = i;
      if (this.dyb != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.dyb);
      }
      i = paramInt;
      if (this.GrA != null) {
        i = paramInt + f.a.a.a.lI(5, this.GrA.computeSize());
      }
      AppMethodBeat.o(117861);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(117861);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      aae localaae = (aae)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(117861);
        return -1;
      case 1: 
        localaae.timestamp = ((f.a.a.a.a)localObject1).OmT.zd();
        AppMethodBeat.o(117861);
        return 0;
      case 2: 
        localaae.Grz = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(117861);
        return 0;
      case 3: 
        localaae.FQf = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(117861);
        return 0;
      case 4: 
        localaae.dyb = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(117861);
        return 0;
      }
      paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        Object localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new aaa();
        localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (boolean bool = true; bool; bool = ((aaa)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
        localaae.GrA = ((aaa)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(117861);
      return 0;
    }
    AppMethodBeat.o(117861);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aae
 * JD-Core Version:    0.7.0.1
 */