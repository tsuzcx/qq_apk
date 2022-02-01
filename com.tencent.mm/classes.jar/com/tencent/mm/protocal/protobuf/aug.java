package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class aug
  extends com.tencent.mm.bw.a
{
  public long duw;
  public String objectNonceId;
  public arn rQw;
  public int scene;
  public String sessionBuffer;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(189423);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aZ(1, this.duw);
      if (this.objectNonceId != null) {
        paramVarArgs.d(2, this.objectNonceId);
      }
      paramVarArgs.aS(3, this.scene);
      if (this.rQw != null)
      {
        paramVarArgs.lJ(4, this.rQw.computeSize());
        this.rQw.writeFields(paramVarArgs);
      }
      if (this.sessionBuffer != null) {
        paramVarArgs.d(5, this.sessionBuffer);
      }
      AppMethodBeat.o(189423);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.p(1, this.duw) + 0;
      paramInt = i;
      if (this.objectNonceId != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.objectNonceId);
      }
      i = paramInt + f.a.a.b.b.a.bz(3, this.scene);
      paramInt = i;
      if (this.rQw != null) {
        paramInt = i + f.a.a.a.lI(4, this.rQw.computeSize());
      }
      i = paramInt;
      if (this.sessionBuffer != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.sessionBuffer);
      }
      AppMethodBeat.o(189423);
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
      AppMethodBeat.o(189423);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      aug localaug = (aug)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(189423);
        return -1;
      case 1: 
        localaug.duw = ((f.a.a.a.a)localObject1).OmT.zd();
        AppMethodBeat.o(189423);
        return 0;
      case 2: 
        localaug.objectNonceId = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(189423);
        return 0;
      case 3: 
        localaug.scene = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(189423);
        return 0;
      case 4: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new arn();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((arn)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localaug.rQw = ((arn)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(189423);
        return 0;
      }
      localaug.sessionBuffer = ((f.a.a.a.a)localObject1).OmT.readString();
      AppMethodBeat.o(189423);
      return 0;
    }
    AppMethodBeat.o(189423);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aug
 * JD-Core Version:    0.7.0.1
 */