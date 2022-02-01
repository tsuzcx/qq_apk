package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class dpc
  extends dyy
{
  public String DZX;
  public String TWd;
  public int Tsk;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32375);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(32375);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.TWd != null) {
        paramVarArgs.f(2, this.TWd);
      }
      if (this.DZX != null) {
        paramVarArgs.f(3, this.DZX);
      }
      paramVarArgs.aY(4, this.Tsk);
      AppMethodBeat.o(32375);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label514;
      }
    }
    label514:
    for (int i = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.TWd != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.TWd);
      }
      i = paramInt;
      if (this.DZX != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.DZX);
      }
      paramInt = g.a.a.b.b.a.bM(4, this.Tsk);
      AppMethodBeat.o(32375);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(32375);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32375);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        dpc localdpc = (dpc)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32375);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            jh localjh = new jh();
            if ((localObject != null) && (localObject.length > 0)) {
              localjh.parseFrom((byte[])localObject);
            }
            localdpc.BaseResponse = localjh;
            paramInt += 1;
          }
          AppMethodBeat.o(32375);
          return 0;
        case 2: 
          localdpc.TWd = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(32375);
          return 0;
        case 3: 
          localdpc.DZX = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(32375);
          return 0;
        }
        localdpc.Tsk = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(32375);
        return 0;
      }
      AppMethodBeat.o(32375);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dpc
 * JD-Core Version:    0.7.0.1
 */