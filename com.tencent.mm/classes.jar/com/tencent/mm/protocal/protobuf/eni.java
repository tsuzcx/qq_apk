package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class eni
  extends dyl
{
  public String SessionId;
  public eng Uqe;
  public eng Uqf;
  public int Uqg;
  public int Uqh;
  public String lps;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(118439);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Uqe == null)
      {
        paramVarArgs = new b("Not all required fields were included: CommentDetail");
        AppMethodBeat.o(118439);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.lps != null) {
        paramVarArgs.f(2, this.lps);
      }
      if (this.Uqe != null)
      {
        paramVarArgs.oE(3, this.Uqe.computeSize());
        this.Uqe.writeFields(paramVarArgs);
      }
      if (this.Uqf != null)
      {
        paramVarArgs.oE(6, this.Uqf.computeSize());
        this.Uqf.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(4, this.Uqg);
      paramVarArgs.aY(5, this.Uqh);
      if (this.SessionId != null) {
        paramVarArgs.f(7, this.SessionId);
      }
      AppMethodBeat.o(118439);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label812;
      }
    }
    label812:
    for (int i = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.lps != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.lps);
      }
      i = paramInt;
      if (this.Uqe != null) {
        i = paramInt + g.a.a.a.oD(3, this.Uqe.computeSize());
      }
      paramInt = i;
      if (this.Uqf != null) {
        paramInt = i + g.a.a.a.oD(6, this.Uqf.computeSize());
      }
      i = paramInt + g.a.a.b.b.a.bM(4, this.Uqg) + g.a.a.b.b.a.bM(5, this.Uqh);
      paramInt = i;
      if (this.SessionId != null) {
        paramInt = i + g.a.a.b.b.a.g(7, this.SessionId);
      }
      AppMethodBeat.o(118439);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.Uqe == null)
        {
          paramVarArgs = new b("Not all required fields were included: CommentDetail");
          AppMethodBeat.o(118439);
          throw paramVarArgs;
        }
        AppMethodBeat.o(118439);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        eni localeni = (eni)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(118439);
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
            localeni.BaseRequest = ((jg)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(118439);
          return 0;
        case 2: 
          localeni.lps = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(118439);
          return 0;
        case 3: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new eng();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((eng)localObject2).parseFrom((byte[])localObject1);
            }
            localeni.Uqe = ((eng)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(118439);
          return 0;
        case 6: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new eng();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((eng)localObject2).parseFrom((byte[])localObject1);
            }
            localeni.Uqf = ((eng)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(118439);
          return 0;
        case 4: 
          localeni.Uqg = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(118439);
          return 0;
        case 5: 
          localeni.Uqh = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(118439);
          return 0;
        }
        localeni.SessionId = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(118439);
        return 0;
      }
      AppMethodBeat.o(118439);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eni
 * JD-Core Version:    0.7.0.1
 */