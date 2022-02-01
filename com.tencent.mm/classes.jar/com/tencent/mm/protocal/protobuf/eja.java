package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class eja
  extends dyl
{
  public int CPw;
  public int Cqs;
  public eaf UkV;
  public ejj UkW;
  public eaf UkX;
  public String lps;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125762);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.UkW == null)
      {
        paramVarArgs = new b("Not all required fields were included: Action");
        AppMethodBeat.o(125762);
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
      if (this.UkV != null)
      {
        paramVarArgs.oE(4, this.UkV.computeSize());
        this.UkV.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(5, this.Cqs);
      if (this.UkX != null)
      {
        paramVarArgs.oE(6, this.UkX.computeSize());
        this.UkX.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(7, this.CPw);
      AppMethodBeat.o(125762);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label886;
      }
    }
    label886:
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
      if (this.UkV != null) {
        paramInt = i + g.a.a.a.oD(4, this.UkV.computeSize());
      }
      i = paramInt + g.a.a.b.b.a.bM(5, this.Cqs);
      paramInt = i;
      if (this.UkX != null) {
        paramInt = i + g.a.a.a.oD(6, this.UkX.computeSize());
      }
      i = g.a.a.b.b.a.bM(7, this.CPw);
      AppMethodBeat.o(125762);
      return paramInt + i;
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
          AppMethodBeat.o(125762);
          throw paramVarArgs;
        }
        AppMethodBeat.o(125762);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        eja localeja = (eja)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(125762);
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
            localeja.BaseRequest = ((jg)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(125762);
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
            localeja.UkW = ((ejj)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(125762);
          return 0;
        case 3: 
          localeja.lps = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(125762);
          return 0;
        case 4: 
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
            localeja.UkV = ((eaf)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(125762);
          return 0;
        case 5: 
          localeja.Cqs = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(125762);
          return 0;
        case 6: 
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
            localeja.UkX = ((eaf)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(125762);
          return 0;
        }
        localeja.CPw = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(125762);
        return 0;
      }
      AppMethodBeat.o(125762);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eja
 * JD-Core Version:    0.7.0.1
 */