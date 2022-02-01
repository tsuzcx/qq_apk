package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class apw
  extends com.tencent.mm.bw.a
{
  public anm contextObj;
  public long dig;
  public String objectNonceId;
  public int scene;
  public String sessionBuffer;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(195124);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aO(1, this.dig);
      if (this.objectNonceId != null) {
        paramVarArgs.d(2, this.objectNonceId);
      }
      paramVarArgs.aR(3, this.scene);
      if (this.contextObj != null)
      {
        paramVarArgs.ln(4, this.contextObj.computeSize());
        this.contextObj.writeFields(paramVarArgs);
      }
      if (this.sessionBuffer != null) {
        paramVarArgs.d(5, this.sessionBuffer);
      }
      AppMethodBeat.o(195124);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.p(1, this.dig) + 0;
      paramInt = i;
      if (this.objectNonceId != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.objectNonceId);
      }
      i = paramInt + f.a.a.b.b.a.bx(3, this.scene);
      paramInt = i;
      if (this.contextObj != null) {
        paramInt = i + f.a.a.a.lm(4, this.contextObj.computeSize());
      }
      i = paramInt;
      if (this.sessionBuffer != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.sessionBuffer);
      }
      AppMethodBeat.o(195124);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      AppMethodBeat.o(195124);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      apw localapw = (apw)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(195124);
        return -1;
      case 1: 
        localapw.dig = ((f.a.a.a.a)localObject1).LVo.xG();
        AppMethodBeat.o(195124);
        return 0;
      case 2: 
        localapw.objectNonceId = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(195124);
        return 0;
      case 3: 
        localapw.scene = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(195124);
        return 0;
      case 4: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new anm();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((anm)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localapw.contextObj = ((anm)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(195124);
        return 0;
      }
      localapw.sessionBuffer = ((f.a.a.a.a)localObject1).LVo.readString();
      AppMethodBeat.o(195124);
      return 0;
    }
    AppMethodBeat.o(195124);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.apw
 * JD-Core Version:    0.7.0.1
 */