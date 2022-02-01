package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class byc
  extends dyy
{
  public long Tdp;
  public boolean Tdq;
  public long Tdr;
  public LinkedList<ug> Tds;
  public LinkedList<uc> lpz;
  public String title;
  public String tqb;
  
  public byc()
  {
    AppMethodBeat.i(246437);
    this.Tds = new LinkedList();
    this.lpz = new LinkedList();
    AppMethodBeat.o(246437);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(246438);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(246438);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.bm(2, this.Tdp);
      if (this.tqb != null) {
        paramVarArgs.f(3, this.tqb);
      }
      paramVarArgs.co(4, this.Tdq);
      paramVarArgs.bm(5, this.Tdr);
      if (this.title != null) {
        paramVarArgs.f(6, this.title);
      }
      paramVarArgs.e(7, 8, this.Tds);
      paramVarArgs.e(8, 8, this.lpz);
      AppMethodBeat.o(246438);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label828;
      }
    }
    label828:
    for (paramInt = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.p(2, this.Tdp);
      paramInt = i;
      if (this.tqb != null) {
        paramInt = i + g.a.a.b.b.a.g(3, this.tqb);
      }
      i = paramInt + (g.a.a.b.b.a.gL(4) + 1) + g.a.a.b.b.a.p(5, this.Tdr);
      paramInt = i;
      if (this.title != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.title);
      }
      i = g.a.a.a.c(7, 8, this.Tds);
      int j = g.a.a.a.c(8, 8, this.lpz);
      AppMethodBeat.o(246438);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Tds.clear();
        this.lpz.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dyy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(246438);
          throw paramVarArgs;
        }
        AppMethodBeat.o(246438);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        byc localbyc = (byc)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(246438);
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
            localbyc.BaseResponse = ((jh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(246438);
          return 0;
        case 2: 
          localbyc.Tdp = ((g.a.a.a.a)localObject1).abFh.AN();
          AppMethodBeat.o(246438);
          return 0;
        case 3: 
          localbyc.tqb = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(246438);
          return 0;
        case 4: 
          localbyc.Tdq = ((g.a.a.a.a)localObject1).abFh.AB();
          AppMethodBeat.o(246438);
          return 0;
        case 5: 
          localbyc.Tdr = ((g.a.a.a.a)localObject1).abFh.AN();
          AppMethodBeat.o(246438);
          return 0;
        case 6: 
          localbyc.title = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(246438);
          return 0;
        case 7: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new ug();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((ug)localObject2).parseFrom((byte[])localObject1);
            }
            localbyc.Tds.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(246438);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new uc();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((uc)localObject2).parseFrom((byte[])localObject1);
          }
          localbyc.lpz.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(246438);
        return 0;
      }
      AppMethodBeat.o(246438);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.byc
 * JD-Core Version:    0.7.0.1
 */