package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class fu
  extends buy
{
  public String cwc;
  public LinkedList<String> wse;
  public boolean wsf;
  public int wsg;
  
  public fu()
  {
    AppMethodBeat.i(102370);
    this.wse = new LinkedList();
    AppMethodBeat.o(102370);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(102371);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.iQ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.cwc != null) {
        paramVarArgs.e(2, this.cwc);
      }
      paramVarArgs.e(3, 1, this.wse);
      paramVarArgs.aS(4, this.wsf);
      paramVarArgs.aO(5, this.wsg);
      AppMethodBeat.o(102371);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label518;
      }
    }
    label518:
    for (paramInt = e.a.a.a.iP(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.cwc != null) {
        i = paramInt + e.a.a.b.b.a.f(2, this.cwc);
      }
      paramInt = e.a.a.a.c(3, 1, this.wse);
      int j = e.a.a.b.b.a.eW(4);
      int k = e.a.a.b.b.a.bl(5, this.wsg);
      AppMethodBeat.o(102371);
      return i + paramInt + (j + 1) + k;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.wse.clear();
        paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = buy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = buy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(102371);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        fu localfu = (fu)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(102371);
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
            localfu.BaseRequest = ((hq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(102371);
          return 0;
        case 2: 
          localfu.cwc = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(102371);
          return 0;
        case 3: 
          localfu.wse.add(((e.a.a.a.a)localObject1).CLY.readString());
          AppMethodBeat.o(102371);
          return 0;
        case 4: 
          localfu.wsf = ((e.a.a.a.a)localObject1).CLY.emu();
          AppMethodBeat.o(102371);
          return 0;
        }
        localfu.wsg = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(102371);
        return 0;
      }
      AppMethodBeat.o(102371);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fu
 * JD-Core Version:    0.7.0.1
 */