package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dzz
  extends com.tencent.mm.bx.a
{
  public dzp contextObj;
  public long feedId;
  public String objectNonceId;
  public int scene;
  public String sessionBuffer;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(203888);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aG(1, this.feedId);
      if (this.objectNonceId != null) {
        paramVarArgs.d(2, this.objectNonceId);
      }
      paramVarArgs.aR(3, this.scene);
      if (this.contextObj != null)
      {
        paramVarArgs.kX(4, this.contextObj.computeSize());
        this.contextObj.writeFields(paramVarArgs);
      }
      if (this.sessionBuffer != null) {
        paramVarArgs.d(5, this.sessionBuffer);
      }
      AppMethodBeat.o(203888);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.q(1, this.feedId) + 0;
      paramInt = i;
      if (this.objectNonceId != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.objectNonceId);
      }
      i = paramInt + f.a.a.b.b.a.bA(3, this.scene);
      paramInt = i;
      if (this.contextObj != null) {
        paramInt = i + f.a.a.a.kW(4, this.contextObj.computeSize());
      }
      i = paramInt;
      if (this.sessionBuffer != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.sessionBuffer);
      }
      AppMethodBeat.o(203888);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      AppMethodBeat.o(203888);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      dzz localdzz = (dzz)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(203888);
        return -1;
      case 1: 
        localdzz.feedId = ((f.a.a.a.a)localObject1).KhF.xT();
        AppMethodBeat.o(203888);
        return 0;
      case 2: 
        localdzz.objectNonceId = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(203888);
        return 0;
      case 3: 
        localdzz.scene = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(203888);
        return 0;
      case 4: 
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dzp();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((dzp)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdzz.contextObj = ((dzp)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(203888);
        return 0;
      }
      localdzz.sessionBuffer = ((f.a.a.a.a)localObject1).KhF.readString();
      AppMethodBeat.o(203888);
      return 0;
    }
    AppMethodBeat.o(203888);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dzz
 * JD-Core Version:    0.7.0.1
 */