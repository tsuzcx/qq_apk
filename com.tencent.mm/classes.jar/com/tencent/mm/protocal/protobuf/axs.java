package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class axs
  extends buy
{
  public String fKw;
  public LinkedList<String> xmO;
  public int xmQ;
  public dam xmR;
  public String xmT;
  
  public axs()
  {
    AppMethodBeat.i(96255);
    this.xmO = new LinkedList();
    AppMethodBeat.o(96255);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(96256);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.iQ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.fKw != null) {
        paramVarArgs.e(2, this.fKw);
      }
      paramVarArgs.e(3, 1, this.xmO);
      paramVarArgs.aO(4, this.xmQ);
      if (this.xmR != null)
      {
        paramVarArgs.iQ(5, this.xmR.computeSize());
        this.xmR.writeFields(paramVarArgs);
      }
      if (this.xmT != null) {
        paramVarArgs.e(6, this.xmT);
      }
      AppMethodBeat.o(96256);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label686;
      }
    }
    label686:
    for (paramInt = e.a.a.a.iP(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.fKw != null) {
        i = paramInt + e.a.a.b.b.a.f(2, this.fKw);
      }
      i = i + e.a.a.a.c(3, 1, this.xmO) + e.a.a.b.b.a.bl(4, this.xmQ);
      paramInt = i;
      if (this.xmR != null) {
        paramInt = i + e.a.a.a.iP(5, this.xmR.computeSize());
      }
      i = paramInt;
      if (this.xmT != null) {
        i = paramInt + e.a.a.b.b.a.f(6, this.xmT);
      }
      AppMethodBeat.o(96256);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.xmO.clear();
        paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = buy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = buy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(96256);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        axs localaxs = (axs)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(96256);
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
            localaxs.BaseRequest = ((hq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(96256);
          return 0;
        case 2: 
          localaxs.fKw = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(96256);
          return 0;
        case 3: 
          localaxs.xmO.add(((e.a.a.a.a)localObject1).CLY.readString());
          AppMethodBeat.o(96256);
          return 0;
        case 4: 
          localaxs.xmQ = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(96256);
          return 0;
        case 5: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dam();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dam)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, buy.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localaxs.xmR = ((dam)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(96256);
          return 0;
        }
        localaxs.xmT = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(96256);
        return 0;
      }
      AppMethodBeat.o(96256);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.axs
 * JD-Core Version:    0.7.0.1
 */