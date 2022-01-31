package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class axk
  extends buy
{
  public String cqf;
  public String cwc;
  public int scene;
  public String signature;
  public String url;
  public LinkedList<String> xmI;
  public String xmJ;
  public String xmq;
  public String xmr;
  
  public axk()
  {
    AppMethodBeat.i(10203);
    this.xmI = new LinkedList();
    AppMethodBeat.o(10203);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(10204);
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
      if (this.cwc != null) {
        paramVarArgs.e(3, this.cwc);
      }
      paramVarArgs.e(4, 1, this.xmI);
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
      paramVarArgs.aO(9, this.scene);
      if (this.xmJ != null) {
        paramVarArgs.e(10, this.xmJ);
      }
      AppMethodBeat.o(10204);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label858;
      }
    }
    label858:
    for (int i = e.a.a.a.iP(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.url != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.url);
      }
      i = paramInt;
      if (this.cwc != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.cwc);
      }
      i += e.a.a.a.c(4, 1, this.xmI);
      paramInt = i;
      if (this.cqf != null) {
        paramInt = i + e.a.a.b.b.a.f(5, this.cqf);
      }
      i = paramInt;
      if (this.xmq != null) {
        i = paramInt + e.a.a.b.b.a.f(6, this.xmq);
      }
      paramInt = i;
      if (this.signature != null) {
        paramInt = i + e.a.a.b.b.a.f(7, this.signature);
      }
      i = paramInt;
      if (this.xmr != null) {
        i = paramInt + e.a.a.b.b.a.f(8, this.xmr);
      }
      i += e.a.a.b.b.a.bl(9, this.scene);
      paramInt = i;
      if (this.xmJ != null) {
        paramInt = i + e.a.a.b.b.a.f(10, this.xmJ);
      }
      AppMethodBeat.o(10204);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.xmI.clear();
        paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = buy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = buy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(10204);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        axk localaxk = (axk)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(10204);
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
            localaxk.BaseRequest = ((hq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(10204);
          return 0;
        case 2: 
          localaxk.url = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(10204);
          return 0;
        case 3: 
          localaxk.cwc = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(10204);
          return 0;
        case 4: 
          localaxk.xmI.add(((e.a.a.a.a)localObject1).CLY.readString());
          AppMethodBeat.o(10204);
          return 0;
        case 5: 
          localaxk.cqf = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(10204);
          return 0;
        case 6: 
          localaxk.xmq = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(10204);
          return 0;
        case 7: 
          localaxk.signature = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(10204);
          return 0;
        case 8: 
          localaxk.xmr = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(10204);
          return 0;
        case 9: 
          localaxk.scene = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(10204);
          return 0;
        }
        localaxk.xmJ = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(10204);
        return 0;
      }
      AppMethodBeat.o(10204);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.axk
 * JD-Core Version:    0.7.0.1
 */