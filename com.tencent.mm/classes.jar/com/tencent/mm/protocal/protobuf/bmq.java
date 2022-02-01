package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bmq
  extends com.tencent.mm.cd.a
{
  public long feedId;
  public String objectNonceId;
  public int scene;
  public String sessionBuffer;
  public bid xbu;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(198404);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bm(1, this.feedId);
      if (this.objectNonceId != null) {
        paramVarArgs.f(2, this.objectNonceId);
      }
      paramVarArgs.aY(3, this.scene);
      if (this.xbu != null)
      {
        paramVarArgs.oE(4, this.xbu.computeSize());
        this.xbu.writeFields(paramVarArgs);
      }
      if (this.sessionBuffer != null) {
        paramVarArgs.f(5, this.sessionBuffer);
      }
      AppMethodBeat.o(198404);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.p(1, this.feedId) + 0;
      paramInt = i;
      if (this.objectNonceId != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.objectNonceId);
      }
      i = paramInt + g.a.a.b.b.a.bM(3, this.scene);
      paramInt = i;
      if (this.xbu != null) {
        paramInt = i + g.a.a.a.oD(4, this.xbu.computeSize());
      }
      i = paramInt;
      if (this.sessionBuffer != null) {
        i = paramInt + g.a.a.b.b.a.g(5, this.sessionBuffer);
      }
      AppMethodBeat.o(198404);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(198404);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (g.a.a.a.a)paramVarArgs[0];
      bmq localbmq = (bmq)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(198404);
        return -1;
      case 1: 
        localbmq.feedId = ((g.a.a.a.a)localObject).abFh.AN();
        AppMethodBeat.o(198404);
        return 0;
      case 2: 
        localbmq.objectNonceId = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(198404);
        return 0;
      case 3: 
        localbmq.scene = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(198404);
        return 0;
      case 4: 
        paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          bid localbid = new bid();
          if ((localObject != null) && (localObject.length > 0)) {
            localbid.parseFrom((byte[])localObject);
          }
          localbmq.xbu = localbid;
          paramInt += 1;
        }
        AppMethodBeat.o(198404);
        return 0;
      }
      localbmq.sessionBuffer = ((g.a.a.a.a)localObject).abFh.readString();
      AppMethodBeat.o(198404);
      return 0;
    }
    AppMethodBeat.o(198404);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bmq
 * JD-Core Version:    0.7.0.1
 */