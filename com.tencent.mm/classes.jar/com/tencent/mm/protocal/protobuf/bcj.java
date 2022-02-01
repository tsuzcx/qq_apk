package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bcj
  extends dyy
{
  public String SNM;
  public LinkedList<bnu> SNN;
  public boolean has_next;
  
  public bcj()
  {
    AppMethodBeat.i(231086);
    this.SNN = new LinkedList();
    AppMethodBeat.o(231086);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(231091);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.SNN);
      paramVarArgs.co(3, this.has_next);
      if (this.SNM != null) {
        paramVarArgs.f(4, this.SNM);
      }
      AppMethodBeat.o(231091);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label506;
      }
    }
    label506:
    for (paramInt = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.a.c(2, 8, this.SNN) + (g.a.a.b.b.a.gL(3) + 1);
      paramInt = i;
      if (this.SNM != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.SNM);
      }
      AppMethodBeat.o(231091);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.SNN.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dyy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(231091);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        bcj localbcj = (bcj)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(231091);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new jh();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((jh)localObject2).parseFrom((byte[])localObject1);
            }
            localbcj.BaseResponse = ((jh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(231091);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bnu();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bnu)localObject2).parseFrom((byte[])localObject1);
            }
            localbcj.SNN.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(231091);
          return 0;
        case 3: 
          localbcj.has_next = ((g.a.a.a.a)localObject1).abFh.AB();
          AppMethodBeat.o(231091);
          return 0;
        }
        localbcj.SNM = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(231091);
        return 0;
      }
      AppMethodBeat.o(231091);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bcj
 * JD-Core Version:    0.7.0.1
 */