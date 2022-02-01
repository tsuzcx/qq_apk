package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class bnh
  extends dyy
{
  public String CqW;
  public LinkedList<String> SYp;
  public LinkedList<String> SYq;
  public LinkedList<String> SYr;
  public LinkedList<bni> SYs;
  public String fwr;
  
  public bnh()
  {
    AppMethodBeat.i(42635);
    this.SYp = new LinkedList();
    this.SYq = new LinkedList();
    this.SYr = new LinkedList();
    this.SYs = new LinkedList();
    AppMethodBeat.o(42635);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(42636);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(42636);
        throw paramVarArgs;
      }
      if (this.fwr == null)
      {
        paramVarArgs = new b("Not all required fields were included: Title");
        AppMethodBeat.o(42636);
        throw paramVarArgs;
      }
      if (this.CqW == null)
      {
        paramVarArgs = new b("Not all required fields were included: JsonData");
        AppMethodBeat.o(42636);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.fwr != null) {
        paramVarArgs.f(2, this.fwr);
      }
      paramVarArgs.e(3, 1, this.SYp);
      if (this.CqW != null) {
        paramVarArgs.f(4, this.CqW);
      }
      paramVarArgs.e(5, 1, this.SYq);
      paramVarArgs.e(6, 1, this.SYr);
      paramVarArgs.e(7, 8, this.SYs);
      AppMethodBeat.o(42636);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label850;
      }
    }
    label850:
    for (paramInt = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.fwr != null) {
        i = paramInt + g.a.a.b.b.a.g(2, this.fwr);
      }
      i += g.a.a.a.c(3, 1, this.SYp);
      paramInt = i;
      if (this.CqW != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.CqW);
      }
      i = g.a.a.a.c(5, 1, this.SYq);
      int j = g.a.a.a.c(6, 1, this.SYr);
      int k = g.a.a.a.c(7, 8, this.SYs);
      AppMethodBeat.o(42636);
      return paramInt + i + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.SYp.clear();
        this.SYq.clear();
        this.SYr.clear();
        this.SYs.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dyy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(42636);
          throw paramVarArgs;
        }
        if (this.fwr == null)
        {
          paramVarArgs = new b("Not all required fields were included: Title");
          AppMethodBeat.o(42636);
          throw paramVarArgs;
        }
        if (this.CqW == null)
        {
          paramVarArgs = new b("Not all required fields were included: JsonData");
          AppMethodBeat.o(42636);
          throw paramVarArgs;
        }
        AppMethodBeat.o(42636);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        bnh localbnh = (bnh)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(42636);
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
            localbnh.BaseResponse = ((jh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(42636);
          return 0;
        case 2: 
          localbnh.fwr = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(42636);
          return 0;
        case 3: 
          localbnh.SYp.add(((g.a.a.a.a)localObject1).abFh.readString());
          AppMethodBeat.o(42636);
          return 0;
        case 4: 
          localbnh.CqW = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(42636);
          return 0;
        case 5: 
          localbnh.SYq.add(((g.a.a.a.a)localObject1).abFh.readString());
          AppMethodBeat.o(42636);
          return 0;
        case 6: 
          localbnh.SYr.add(((g.a.a.a.a)localObject1).abFh.readString());
          AppMethodBeat.o(42636);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new bni();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((bni)localObject2).parseFrom((byte[])localObject1);
          }
          localbnh.SYs.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(42636);
        return 0;
      }
      AppMethodBeat.o(42636);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bnh
 * JD-Core Version:    0.7.0.1
 */