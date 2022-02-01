package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class brp
  extends dyy
{
  public boolean Tcd;
  public int Tce;
  public int Tcf;
  public up Tcg;
  public boolean Tch;
  public int tqa;
  public String tqb;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(114007);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(114007);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(2, this.tqa);
      if (this.tqb != null) {
        paramVarArgs.f(3, this.tqb);
      }
      paramVarArgs.co(4, this.Tcd);
      paramVarArgs.aY(5, this.Tce);
      paramVarArgs.aY(6, this.Tcf);
      if (this.Tcg != null)
      {
        paramVarArgs.oE(7, this.Tcg.computeSize());
        this.Tcg.writeFields(paramVarArgs);
      }
      paramVarArgs.co(8, this.Tch);
      AppMethodBeat.o(114007);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label746;
      }
    }
    label746:
    for (paramInt = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.tqa);
      paramInt = i;
      if (this.tqb != null) {
        paramInt = i + g.a.a.b.b.a.g(3, this.tqb);
      }
      i = paramInt + (g.a.a.b.b.a.gL(4) + 1) + g.a.a.b.b.a.bM(5, this.Tce) + g.a.a.b.b.a.bM(6, this.Tcf);
      paramInt = i;
      if (this.Tcg != null) {
        paramInt = i + g.a.a.a.oD(7, this.Tcg.computeSize());
      }
      i = g.a.a.b.b.a.gL(8);
      AppMethodBeat.o(114007);
      return paramInt + (i + 1);
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
          AppMethodBeat.o(114007);
          throw paramVarArgs;
        }
        AppMethodBeat.o(114007);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        brp localbrp = (brp)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(114007);
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
            localbrp.BaseResponse = ((jh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(114007);
          return 0;
        case 2: 
          localbrp.tqa = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(114007);
          return 0;
        case 3: 
          localbrp.tqb = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(114007);
          return 0;
        case 4: 
          localbrp.Tcd = ((g.a.a.a.a)localObject1).abFh.AB();
          AppMethodBeat.o(114007);
          return 0;
        case 5: 
          localbrp.Tce = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(114007);
          return 0;
        case 6: 
          localbrp.Tcf = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(114007);
          return 0;
        case 7: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new up();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((up)localObject2).parseFrom((byte[])localObject1);
            }
            localbrp.Tcg = ((up)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(114007);
          return 0;
        }
        localbrp.Tch = ((g.a.a.a.a)localObject1).abFh.AB();
        AppMethodBeat.o(114007);
        return 0;
      }
      AppMethodBeat.o(114007);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.brp
 * JD-Core Version:    0.7.0.1
 */