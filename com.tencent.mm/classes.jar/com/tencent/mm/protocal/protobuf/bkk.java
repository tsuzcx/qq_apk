package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bkk
  extends dyl
{
  public String Nzy;
  public aqe SFL;
  public String finderUsername;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(199348);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.SFL != null)
      {
        paramVarArgs.oE(2, this.SFL.computeSize());
        this.SFL.writeFields(paramVarArgs);
      }
      if (this.finderUsername != null) {
        paramVarArgs.f(3, this.finderUsername);
      }
      if (this.Nzy != null) {
        paramVarArgs.f(4, this.Nzy);
      }
      AppMethodBeat.o(199348);
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
      if (this.SFL != null) {
        paramInt = i + g.a.a.a.oD(2, this.SFL.computeSize());
      }
      i = paramInt;
      if (this.finderUsername != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.finderUsername);
      }
      paramInt = i;
      if (this.Nzy != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.Nzy);
      }
      AppMethodBeat.o(199348);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(199348);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        bkk localbkk = (bkk)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(199348);
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
            localbkk.BaseRequest = ((jg)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(199348);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new aqe();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((aqe)localObject2).parseFrom((byte[])localObject1);
            }
            localbkk.SFL = ((aqe)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(199348);
          return 0;
        case 3: 
          localbkk.finderUsername = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(199348);
          return 0;
        }
        localbkk.Nzy = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(199348);
        return 0;
      }
      AppMethodBeat.o(199348);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bkk
 * JD-Core Version:    0.7.0.1
 */