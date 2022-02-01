package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class bug
  extends dyl
{
  public int CPw;
  public eae RJA;
  public int Tei;
  public int lpw;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(104799);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.RJA == null)
      {
        paramVarArgs = new b("Not all required fields were included: ReqBuf");
        AppMethodBeat.o(104799);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.RJA != null)
      {
        paramVarArgs.oE(2, this.RJA.computeSize());
        this.RJA.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(3, this.lpw);
      paramVarArgs.aY(4, this.CPw);
      paramVarArgs.aY(5, this.Tei);
      AppMethodBeat.o(104799);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label606;
      }
    }
    label606:
    for (paramInt = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.RJA != null) {
        i = paramInt + g.a.a.a.oD(2, this.RJA.computeSize());
      }
      paramInt = g.a.a.b.b.a.bM(3, this.lpw);
      int j = g.a.a.b.b.a.bM(4, this.CPw);
      int k = g.a.a.b.b.a.bM(5, this.Tei);
      AppMethodBeat.o(104799);
      return i + paramInt + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.RJA == null)
        {
          paramVarArgs = new b("Not all required fields were included: ReqBuf");
          AppMethodBeat.o(104799);
          throw paramVarArgs;
        }
        AppMethodBeat.o(104799);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        bug localbug = (bug)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(104799);
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
            localbug.BaseRequest = ((jg)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(104799);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new eae();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((eae)localObject2).dd((byte[])localObject1);
            }
            localbug.RJA = ((eae)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(104799);
          return 0;
        case 3: 
          localbug.lpw = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(104799);
          return 0;
        case 4: 
          localbug.CPw = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(104799);
          return 0;
        }
        localbug.Tei = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(104799);
        return 0;
      }
      AppMethodBeat.o(104799);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bug
 * JD-Core Version:    0.7.0.1
 */