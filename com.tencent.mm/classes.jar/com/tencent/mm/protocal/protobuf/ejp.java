package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class ejp
  extends dyl
{
  public ejj UkW;
  public eaf UkX;
  public String lps;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125780);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.UkW == null)
      {
        paramVarArgs = new b("Not all required fields were included: Action");
        AppMethodBeat.o(125780);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.UkW != null)
      {
        paramVarArgs.oE(2, this.UkW.computeSize());
        this.UkW.writeFields(paramVarArgs);
      }
      if (this.lps != null) {
        paramVarArgs.f(3, this.lps);
      }
      if (this.UkX != null)
      {
        paramVarArgs.oE(4, this.UkX.computeSize());
        this.UkX.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(125780);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label660;
      }
    }
    label660:
    for (int i = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.UkW != null) {
        paramInt = i + g.a.a.a.oD(2, this.UkW.computeSize());
      }
      i = paramInt;
      if (this.lps != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.lps);
      }
      paramInt = i;
      if (this.UkX != null) {
        paramInt = i + g.a.a.a.oD(4, this.UkX.computeSize());
      }
      AppMethodBeat.o(125780);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.UkW == null)
        {
          paramVarArgs = new b("Not all required fields were included: Action");
          AppMethodBeat.o(125780);
          throw paramVarArgs;
        }
        AppMethodBeat.o(125780);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        ejp localejp = (ejp)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(125780);
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
            localejp.BaseRequest = ((jg)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(125780);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new ejj();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((ejj)localObject2).parseFrom((byte[])localObject1);
            }
            localejp.UkW = ((ejj)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(125780);
          return 0;
        case 3: 
          localejp.lps = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(125780);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new eaf();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((eaf)localObject2).de((byte[])localObject1);
          }
          localejp.UkX = ((eaf)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(125780);
        return 0;
      }
      AppMethodBeat.o(125780);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ejp
 * JD-Core Version:    0.7.0.1
 */