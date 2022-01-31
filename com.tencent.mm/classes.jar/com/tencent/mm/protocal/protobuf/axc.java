package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bv.b;
import java.util.LinkedList;

public final class axc
  extends buy
{
  public String cqf;
  public String npZ;
  public String scope;
  public String signature;
  public String url;
  public String xmo;
  public String xmq;
  public String xmr;
  public b xms;
  public int xmt;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(10198);
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
      if (this.npZ != null) {
        paramVarArgs.e(3, this.npZ);
      }
      if (this.xmo != null) {
        paramVarArgs.e(4, this.xmo);
      }
      if (this.cqf != null) {
        paramVarArgs.e(5, this.cqf);
      }
      if (this.xmq != null) {
        paramVarArgs.e(6, this.xmq);
      }
      if (this.signature != null) {
        paramVarArgs.e(7, this.signature);
      }
      if (this.xmr != null) {
        paramVarArgs.e(8, this.xmr);
      }
      if (this.xms != null) {
        paramVarArgs.c(9, this.xms);
      }
      paramVarArgs.aO(10, this.xmt);
      if (this.scope != null) {
        paramVarArgs.e(11, this.scope);
      }
      AppMethodBeat.o(10198);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label923;
      }
    }
    label923:
    for (int i = e.a.a.a.iP(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.url != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.url);
      }
      i = paramInt;
      if (this.npZ != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.npZ);
      }
      paramInt = i;
      if (this.xmo != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.xmo);
      }
      i = paramInt;
      if (this.cqf != null) {
        i = paramInt + e.a.a.b.b.a.f(5, this.cqf);
      }
      paramInt = i;
      if (this.xmq != null) {
        paramInt = i + e.a.a.b.b.a.f(6, this.xmq);
      }
      i = paramInt;
      if (this.signature != null) {
        i = paramInt + e.a.a.b.b.a.f(7, this.signature);
      }
      paramInt = i;
      if (this.xmr != null) {
        paramInt = i + e.a.a.b.b.a.f(8, this.xmr);
      }
      i = paramInt;
      if (this.xms != null) {
        i = paramInt + e.a.a.b.b.a.b(9, this.xms);
      }
      i += e.a.a.b.b.a.bl(10, this.xmt);
      paramInt = i;
      if (this.scope != null) {
        paramInt = i + e.a.a.b.b.a.f(11, this.scope);
      }
      AppMethodBeat.o(10198);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = buy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = buy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(10198);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        axc localaxc = (axc)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(10198);
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
            localaxc.BaseRequest = ((hq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(10198);
          return 0;
        case 2: 
          localaxc.url = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(10198);
          return 0;
        case 3: 
          localaxc.npZ = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(10198);
          return 0;
        case 4: 
          localaxc.xmo = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(10198);
          return 0;
        case 5: 
          localaxc.cqf = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(10198);
          return 0;
        case 6: 
          localaxc.xmq = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(10198);
          return 0;
        case 7: 
          localaxc.signature = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(10198);
          return 0;
        case 8: 
          localaxc.xmr = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(10198);
          return 0;
        case 9: 
          localaxc.xms = ((e.a.a.a.a)localObject1).CLY.eqS();
          AppMethodBeat.o(10198);
          return 0;
        case 10: 
          localaxc.xmt = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(10198);
          return 0;
        }
        localaxc.scope = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(10198);
        return 0;
      }
      AppMethodBeat.o(10198);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.axc
 * JD-Core Version:    0.7.0.1
 */