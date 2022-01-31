package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ed
  extends buy
{
  public String session_id;
  public String url;
  public LinkedList<ur> wpZ;
  public int wqa;
  public int wqb;
  
  public ed()
  {
    AppMethodBeat.i(14683);
    this.wpZ = new LinkedList();
    AppMethodBeat.o(14683);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(14684);
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
      paramVarArgs.e(4, 8, this.wpZ);
      if (this.session_id != null) {
        paramVarArgs.e(5, this.session_id);
      }
      paramVarArgs.aO(6, this.wqa);
      paramVarArgs.aO(7, this.wqb);
      AppMethodBeat.o(14684);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label682;
      }
    }
    label682:
    for (paramInt = e.a.a.a.iP(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.url != null) {
        i = paramInt + e.a.a.b.b.a.f(2, this.url);
      }
      i += e.a.a.a.c(4, 8, this.wpZ);
      paramInt = i;
      if (this.session_id != null) {
        paramInt = i + e.a.a.b.b.a.f(5, this.session_id);
      }
      i = e.a.a.b.b.a.bl(6, this.wqa);
      int j = e.a.a.b.b.a.bl(7, this.wqb);
      AppMethodBeat.o(14684);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.wpZ.clear();
        paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = buy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = buy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(14684);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        ed localed = (ed)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        case 3: 
        default: 
          AppMethodBeat.o(14684);
          return -1;
        case 1: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new hq();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((hq)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, buy.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localed.BaseRequest = ((hq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(14684);
          return 0;
        case 2: 
          localed.url = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(14684);
          return 0;
        case 4: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ur();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ur)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, buy.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localed.wpZ.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(14684);
          return 0;
        case 5: 
          localed.session_id = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(14684);
          return 0;
        case 6: 
          localed.wqa = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(14684);
          return 0;
        }
        localed.wqb = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(14684);
        return 0;
      }
      AppMethodBeat.o(14684);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ed
 * JD-Core Version:    0.7.0.1
 */