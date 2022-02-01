package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class fdr
  extends dyl
{
  public long Svv;
  public LinkedList<fdq> UDD;
  public long Urf;
  
  public fdr()
  {
    AppMethodBeat.i(125506);
    this.UDD = new LinkedList();
    AppMethodBeat.o(125506);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125507);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.bm(2, this.Urf);
      paramVarArgs.bm(3, this.Svv);
      paramVarArgs.e(4, 8, this.UDD);
      AppMethodBeat.o(125507);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label498;
      }
    }
    label498:
    for (paramInt = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = g.a.a.b.b.a.p(2, this.Urf);
      int j = g.a.a.b.b.a.p(3, this.Svv);
      int k = g.a.a.a.c(4, 8, this.UDD);
      AppMethodBeat.o(125507);
      return paramInt + i + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.UDD.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(125507);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        fdr localfdr = (fdr)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(125507);
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
            localfdr.BaseRequest = ((jg)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(125507);
          return 0;
        case 2: 
          localfdr.Urf = ((g.a.a.a.a)localObject1).abFh.AN();
          AppMethodBeat.o(125507);
          return 0;
        case 3: 
          localfdr.Svv = ((g.a.a.a.a)localObject1).abFh.AN();
          AppMethodBeat.o(125507);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new fdq();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((fdq)localObject2).parseFrom((byte[])localObject1);
          }
          localfdr.UDD.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(125507);
        return 0;
      }
      AppMethodBeat.o(125507);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fdr
 * JD-Core Version:    0.7.0.1
 */