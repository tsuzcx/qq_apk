package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class btf
  extends dyy
{
  public long Tdp;
  public boolean Tdq;
  public long Tdr;
  public LinkedList<ug> Tds;
  public aeb Tdt;
  public String title;
  public String tqb;
  
  public btf()
  {
    AppMethodBeat.i(252521);
    this.Tds = new LinkedList();
    AppMethodBeat.o(252521);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(252530);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(252530);
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
      if (this.Tdt != null)
      {
        paramVarArgs.oE(8, this.Tdt.computeSize());
        this.Tdt.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(252530);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label840;
      }
    }
    label840:
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
      i = paramInt + g.a.a.a.c(7, 8, this.Tds);
      paramInt = i;
      if (this.Tdt != null) {
        paramInt = i + g.a.a.a.oD(8, this.Tdt.computeSize());
      }
      AppMethodBeat.o(252530);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Tds.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dyy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(252530);
          throw paramVarArgs;
        }
        AppMethodBeat.o(252530);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        btf localbtf = (btf)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(252530);
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
            localbtf.BaseResponse = ((jh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(252530);
          return 0;
        case 2: 
          localbtf.Tdp = ((g.a.a.a.a)localObject1).abFh.AN();
          AppMethodBeat.o(252530);
          return 0;
        case 3: 
          localbtf.tqb = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(252530);
          return 0;
        case 4: 
          localbtf.Tdq = ((g.a.a.a.a)localObject1).abFh.AB();
          AppMethodBeat.o(252530);
          return 0;
        case 5: 
          localbtf.Tdr = ((g.a.a.a.a)localObject1).abFh.AN();
          AppMethodBeat.o(252530);
          return 0;
        case 6: 
          localbtf.title = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(252530);
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
            localbtf.Tds.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(252530);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new aeb();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((aeb)localObject2).parseFrom((byte[])localObject1);
          }
          localbtf.Tdt = ((aeb)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(252530);
        return 0;
      }
      AppMethodBeat.o(252530);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.btf
 * JD-Core Version:    0.7.0.1
 */