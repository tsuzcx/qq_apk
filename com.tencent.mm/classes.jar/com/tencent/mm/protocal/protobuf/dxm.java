package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dxm
  extends dyl
{
  public das UcW;
  public String UcX;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(63278);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.UcW != null)
      {
        paramVarArgs.oE(2, this.UcW.computeSize());
        this.UcW.writeFields(paramVarArgs);
      }
      if (this.UcX != null) {
        paramVarArgs.f(3, this.UcX);
      }
      AppMethodBeat.o(63278);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label482;
      }
    }
    label482:
    for (int i = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.UcW != null) {
        paramInt = i + g.a.a.a.oD(2, this.UcW.computeSize());
      }
      i = paramInt;
      if (this.UcX != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.UcX);
      }
      AppMethodBeat.o(63278);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(63278);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        dxm localdxm = (dxm)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(63278);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new jg();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((jg)localObject2).parseFrom((byte[])localObject1);
            }
            localdxm.BaseRequest = ((jg)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(63278);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new das();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((das)localObject2).parseFrom((byte[])localObject1);
            }
            localdxm.UcW = ((das)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(63278);
          return 0;
        }
        localdxm.UcX = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(63278);
        return 0;
      }
      AppMethodBeat.o(63278);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dxm
 * JD-Core Version:    0.7.0.1
 */