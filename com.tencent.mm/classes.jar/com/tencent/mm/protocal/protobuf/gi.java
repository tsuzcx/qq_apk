package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class gi
  extends buy
{
  public String gwS;
  public String jJE;
  public String lGG;
  public String lGH;
  public String nGG;
  public int wkX;
  public int wsK;
  public SKBuiltinBuffer_t wsL;
  public String wsn;
  public String wsq;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(154769);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.wsL == null)
      {
        paramVarArgs = new b("Not all required fields were included: AxTicket");
        AppMethodBeat.o(154769);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.iQ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(2, this.wsK);
      if (this.wsL != null)
      {
        paramVarArgs.iQ(3, this.wsL.computeSize());
        this.wsL.writeFields(paramVarArgs);
      }
      if (this.nGG != null) {
        paramVarArgs.e(4, this.nGG);
      }
      if (this.wsn != null) {
        paramVarArgs.e(5, this.wsn);
      }
      if (this.gwS != null) {
        paramVarArgs.e(6, this.gwS);
      }
      if (this.jJE != null) {
        paramVarArgs.e(7, this.jJE);
      }
      if (this.wsq != null) {
        paramVarArgs.e(8, this.wsq);
      }
      if (this.lGH != null) {
        paramVarArgs.e(9, this.lGH);
      }
      if (this.lGG != null) {
        paramVarArgs.e(10, this.lGG);
      }
      paramVarArgs.aO(11, this.wkX);
      AppMethodBeat.o(154769);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1034;
      }
    }
    label1034:
    for (paramInt = e.a.a.a.iP(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + e.a.a.b.b.a.bl(2, this.wsK);
      paramInt = i;
      if (this.wsL != null) {
        paramInt = i + e.a.a.a.iP(3, this.wsL.computeSize());
      }
      i = paramInt;
      if (this.nGG != null) {
        i = paramInt + e.a.a.b.b.a.f(4, this.nGG);
      }
      paramInt = i;
      if (this.wsn != null) {
        paramInt = i + e.a.a.b.b.a.f(5, this.wsn);
      }
      i = paramInt;
      if (this.gwS != null) {
        i = paramInt + e.a.a.b.b.a.f(6, this.gwS);
      }
      paramInt = i;
      if (this.jJE != null) {
        paramInt = i + e.a.a.b.b.a.f(7, this.jJE);
      }
      i = paramInt;
      if (this.wsq != null) {
        i = paramInt + e.a.a.b.b.a.f(8, this.wsq);
      }
      paramInt = i;
      if (this.lGH != null) {
        paramInt = i + e.a.a.b.b.a.f(9, this.lGH);
      }
      i = paramInt;
      if (this.lGG != null) {
        i = paramInt + e.a.a.b.b.a.f(10, this.lGG);
      }
      paramInt = e.a.a.b.b.a.bl(11, this.wkX);
      AppMethodBeat.o(154769);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = buy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = buy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.wsL == null)
        {
          paramVarArgs = new b("Not all required fields were included: AxTicket");
          AppMethodBeat.o(154769);
          throw paramVarArgs;
        }
        AppMethodBeat.o(154769);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        gi localgi = (gi)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(154769);
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
            localgi.BaseRequest = ((hq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(154769);
          return 0;
        case 2: 
          localgi.wsK = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(154769);
          return 0;
        case 3: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, buy.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localgi.wsL = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(154769);
          return 0;
        case 4: 
          localgi.nGG = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(154769);
          return 0;
        case 5: 
          localgi.wsn = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(154769);
          return 0;
        case 6: 
          localgi.gwS = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(154769);
          return 0;
        case 7: 
          localgi.jJE = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(154769);
          return 0;
        case 8: 
          localgi.wsq = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(154769);
          return 0;
        case 9: 
          localgi.lGH = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(154769);
          return 0;
        case 10: 
          localgi.lGG = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(154769);
          return 0;
        }
        localgi.wkX = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(154769);
        return 0;
      }
      AppMethodBeat.o(154769);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.gi
 * JD-Core Version:    0.7.0.1
 */