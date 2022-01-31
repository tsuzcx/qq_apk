package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class pt
  extends buy
{
  public int cCy;
  public int okH;
  public int qiP;
  public String qkg;
  public String qkh;
  public String wIb;
  public String wIc;
  public String wpp;
  public String wpq;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(56749);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.iQ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.wpp != null) {
        paramVarArgs.e(2, this.wpp);
      }
      if (this.wpq != null) {
        paramVarArgs.e(3, this.wpq);
      }
      paramVarArgs.aO(4, this.okH);
      if (this.qkh != null) {
        paramVarArgs.e(5, this.qkh);
      }
      if (this.qkg != null) {
        paramVarArgs.e(6, this.qkg);
      }
      paramVarArgs.aO(7, this.cCy);
      paramVarArgs.aO(8, this.qiP);
      if (this.wIb != null) {
        paramVarArgs.e(9, this.wIb);
      }
      if (this.wIc != null) {
        paramVarArgs.e(10, this.wIc);
      }
      AppMethodBeat.o(56749);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label810;
      }
    }
    label810:
    for (int i = e.a.a.a.iP(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.wpp != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.wpp);
      }
      i = paramInt;
      if (this.wpq != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.wpq);
      }
      i += e.a.a.b.b.a.bl(4, this.okH);
      paramInt = i;
      if (this.qkh != null) {
        paramInt = i + e.a.a.b.b.a.f(5, this.qkh);
      }
      i = paramInt;
      if (this.qkg != null) {
        i = paramInt + e.a.a.b.b.a.f(6, this.qkg);
      }
      i = i + e.a.a.b.b.a.bl(7, this.cCy) + e.a.a.b.b.a.bl(8, this.qiP);
      paramInt = i;
      if (this.wIb != null) {
        paramInt = i + e.a.a.b.b.a.f(9, this.wIb);
      }
      i = paramInt;
      if (this.wIc != null) {
        i = paramInt + e.a.a.b.b.a.f(10, this.wIc);
      }
      AppMethodBeat.o(56749);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = buy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = buy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(56749);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        pt localpt = (pt)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(56749);
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
            localpt.BaseRequest = ((hq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(56749);
          return 0;
        case 2: 
          localpt.wpp = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56749);
          return 0;
        case 3: 
          localpt.wpq = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56749);
          return 0;
        case 4: 
          localpt.okH = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(56749);
          return 0;
        case 5: 
          localpt.qkh = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56749);
          return 0;
        case 6: 
          localpt.qkg = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56749);
          return 0;
        case 7: 
          localpt.cCy = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(56749);
          return 0;
        case 8: 
          localpt.qiP = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(56749);
          return 0;
        case 9: 
          localpt.wIb = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56749);
          return 0;
        }
        localpt.wIc = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(56749);
        return 0;
      }
      AppMethodBeat.o(56749);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.pt
 * JD-Core Version:    0.7.0.1
 */