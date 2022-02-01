package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class tp
  extends dyl
{
  public String RLK;
  public String Sdo;
  public bd Sdp;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91392);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.Sdo != null) {
        paramVarArgs.f(2, this.Sdo);
      }
      if (this.RLK != null) {
        paramVarArgs.f(3, this.RLK);
      }
      if (this.Sdp != null)
      {
        paramVarArgs.oE(4, this.Sdp.computeSize());
        this.Sdp.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(91392);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label542;
      }
    }
    label542:
    for (int i = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Sdo != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.Sdo);
      }
      i = paramInt;
      if (this.RLK != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.RLK);
      }
      paramInt = i;
      if (this.Sdp != null) {
        paramInt = i + g.a.a.a.oD(4, this.Sdp.computeSize());
      }
      AppMethodBeat.o(91392);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(91392);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        tp localtp = (tp)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91392);
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
            localtp.BaseRequest = ((jg)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91392);
          return 0;
        case 2: 
          localtp.Sdo = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(91392);
          return 0;
        case 3: 
          localtp.RLK = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(91392);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new bd();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((bd)localObject2).parseFrom((byte[])localObject1);
          }
          localtp.Sdp = ((bd)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(91392);
        return 0;
      }
      AppMethodBeat.o(91392);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.tp
 * JD-Core Version:    0.7.0.1
 */