package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class sl
  extends buy
{
  public int Scene;
  public String Title;
  public String fKj;
  public String fKw;
  public String wKO;
  public String wKP;
  public String wKQ;
  public String wKR;
  public String wKS;
  public String wKT;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(105144);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.iQ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.fKj != null) {
        paramVarArgs.e(2, this.fKj);
      }
      if (this.Title != null) {
        paramVarArgs.e(3, this.Title);
      }
      if (this.wKO != null) {
        paramVarArgs.e(4, this.wKO);
      }
      if (this.wKP != null) {
        paramVarArgs.e(5, this.wKP);
      }
      if (this.wKQ != null) {
        paramVarArgs.e(6, this.wKQ);
      }
      if (this.wKR != null) {
        paramVarArgs.e(7, this.wKR);
      }
      if (this.wKS != null) {
        paramVarArgs.e(8, this.wKS);
      }
      if (this.fKw != null) {
        paramVarArgs.e(9, this.fKw);
      }
      paramVarArgs.aO(10, this.Scene);
      if (this.wKT != null) {
        paramVarArgs.e(11, this.wKT);
      }
      AppMethodBeat.o(105144);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label906;
      }
    }
    label906:
    for (int i = e.a.a.a.iP(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.fKj != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.fKj);
      }
      i = paramInt;
      if (this.Title != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.Title);
      }
      paramInt = i;
      if (this.wKO != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.wKO);
      }
      i = paramInt;
      if (this.wKP != null) {
        i = paramInt + e.a.a.b.b.a.f(5, this.wKP);
      }
      paramInt = i;
      if (this.wKQ != null) {
        paramInt = i + e.a.a.b.b.a.f(6, this.wKQ);
      }
      i = paramInt;
      if (this.wKR != null) {
        i = paramInt + e.a.a.b.b.a.f(7, this.wKR);
      }
      paramInt = i;
      if (this.wKS != null) {
        paramInt = i + e.a.a.b.b.a.f(8, this.wKS);
      }
      i = paramInt;
      if (this.fKw != null) {
        i = paramInt + e.a.a.b.b.a.f(9, this.fKw);
      }
      i += e.a.a.b.b.a.bl(10, this.Scene);
      paramInt = i;
      if (this.wKT != null) {
        paramInt = i + e.a.a.b.b.a.f(11, this.wKT);
      }
      AppMethodBeat.o(105144);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = buy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = buy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(105144);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        sl localsl = (sl)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(105144);
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
            localsl.BaseRequest = ((hq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(105144);
          return 0;
        case 2: 
          localsl.fKj = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(105144);
          return 0;
        case 3: 
          localsl.Title = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(105144);
          return 0;
        case 4: 
          localsl.wKO = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(105144);
          return 0;
        case 5: 
          localsl.wKP = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(105144);
          return 0;
        case 6: 
          localsl.wKQ = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(105144);
          return 0;
        case 7: 
          localsl.wKR = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(105144);
          return 0;
        case 8: 
          localsl.wKS = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(105144);
          return 0;
        case 9: 
          localsl.fKw = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(105144);
          return 0;
        case 10: 
          localsl.Scene = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(105144);
          return 0;
        }
        localsl.wKT = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(105144);
        return 0;
      }
      AppMethodBeat.o(105144);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.sl
 * JD-Core Version:    0.7.0.1
 */