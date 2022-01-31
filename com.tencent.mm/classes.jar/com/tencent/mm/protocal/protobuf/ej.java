package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ej
  extends buy
{
  public int scene;
  public String session_id;
  public String url;
  public int wqa;
  public int wqb;
  public int wqc;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(14691);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.iQ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.url != null) {
        paramVarArgs.e(2, this.url);
      }
      paramVarArgs.aO(3, this.scene);
      paramVarArgs.aO(4, this.wqc);
      paramVarArgs.aO(5, this.wqb);
      paramVarArgs.aO(6, this.wqa);
      if (this.session_id != null) {
        paramVarArgs.e(7, this.session_id);
      }
      AppMethodBeat.o(14691);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label619;
      }
    }
    label619:
    for (paramInt = e.a.a.a.iP(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.url != null) {
        i = paramInt + e.a.a.b.b.a.f(2, this.url);
      }
      i = i + e.a.a.b.b.a.bl(3, this.scene) + e.a.a.b.b.a.bl(4, this.wqc) + e.a.a.b.b.a.bl(5, this.wqb) + e.a.a.b.b.a.bl(6, this.wqa);
      paramInt = i;
      if (this.session_id != null) {
        paramInt = i + e.a.a.b.b.a.f(7, this.session_id);
      }
      AppMethodBeat.o(14691);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = buy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = buy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(14691);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        ej localej = (ej)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(14691);
          return -1;
        case 1: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new hq();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((hq)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, buy.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localej.BaseRequest = ((hq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(14691);
          return 0;
        case 2: 
          localej.url = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(14691);
          return 0;
        case 3: 
          localej.scene = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(14691);
          return 0;
        case 4: 
          localej.wqc = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(14691);
          return 0;
        case 5: 
          localej.wqb = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(14691);
          return 0;
        case 6: 
          localej.wqa = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(14691);
          return 0;
        }
        localej.session_id = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(14691);
        return 0;
      }
      AppMethodBeat.o(14691);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ej
 * JD-Core Version:    0.7.0.1
 */