package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class awh
  extends com.tencent.mm.cd.a
{
  public aow SIK;
  public FinderObject xcx;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(201658);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.xcx != null)
      {
        paramVarArgs.oE(1, this.xcx.computeSize());
        this.xcx.writeFields(paramVarArgs);
      }
      if (this.SIK != null)
      {
        paramVarArgs.oE(2, this.SIK.computeSize());
        this.SIK.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(201658);
      return 0;
    }
    if (paramInt == 1) {
      if (this.xcx == null) {
        break label422;
      }
    }
    label422:
    for (paramInt = g.a.a.a.oD(1, this.xcx.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.SIK != null) {
        i = paramInt + g.a.a.a.oD(2, this.SIK.computeSize());
      }
      AppMethodBeat.o(201658);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(201658);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        awh localawh = (awh)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(201658);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new FinderObject();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((FinderObject)localObject2).parseFrom((byte[])localObject1);
            }
            localawh.xcx = ((FinderObject)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(201658);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new aow();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((aow)localObject2).parseFrom((byte[])localObject1);
          }
          localawh.SIK = ((aow)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(201658);
        return 0;
      }
      AppMethodBeat.o(201658);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.awh
 * JD-Core Version:    0.7.0.1
 */