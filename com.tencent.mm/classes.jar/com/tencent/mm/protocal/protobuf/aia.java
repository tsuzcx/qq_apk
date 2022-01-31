package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class aia
  extends buy
{
  public String cHn;
  public String cHo;
  public int cHp;
  public String knu;
  public String wZY;
  public String wlF;
  public String wlG;
  public int wlH;
  public cgd wlJ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(89077);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.cHn == null)
      {
        paramVarArgs = new b("Not all required fields were included: card_id");
        AppMethodBeat.o(89077);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.iQ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.cHn != null) {
        paramVarArgs.e(2, this.cHn);
      }
      paramVarArgs.aO(3, this.cHp);
      if (this.knu != null) {
        paramVarArgs.e(4, this.knu);
      }
      if (this.cHo != null) {
        paramVarArgs.e(5, this.cHo);
      }
      if (this.wlF != null) {
        paramVarArgs.e(6, this.wlF);
      }
      if (this.wlG != null) {
        paramVarArgs.e(7, this.wlG);
      }
      paramVarArgs.aO(8, this.wlH);
      if (this.wZY != null) {
        paramVarArgs.e(9, this.wZY);
      }
      if (this.wlJ != null)
      {
        paramVarArgs.iQ(10, this.wlJ.computeSize());
        this.wlJ.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(89077);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label970;
      }
    }
    label970:
    for (paramInt = e.a.a.a.iP(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.cHn != null) {
        i = paramInt + e.a.a.b.b.a.f(2, this.cHn);
      }
      i += e.a.a.b.b.a.bl(3, this.cHp);
      paramInt = i;
      if (this.knu != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.knu);
      }
      i = paramInt;
      if (this.cHo != null) {
        i = paramInt + e.a.a.b.b.a.f(5, this.cHo);
      }
      paramInt = i;
      if (this.wlF != null) {
        paramInt = i + e.a.a.b.b.a.f(6, this.wlF);
      }
      i = paramInt;
      if (this.wlG != null) {
        i = paramInt + e.a.a.b.b.a.f(7, this.wlG);
      }
      i += e.a.a.b.b.a.bl(8, this.wlH);
      paramInt = i;
      if (this.wZY != null) {
        paramInt = i + e.a.a.b.b.a.f(9, this.wZY);
      }
      i = paramInt;
      if (this.wlJ != null) {
        i = paramInt + e.a.a.a.iP(10, this.wlJ.computeSize());
      }
      AppMethodBeat.o(89077);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = buy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = buy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.cHn == null)
        {
          paramVarArgs = new b("Not all required fields were included: card_id");
          AppMethodBeat.o(89077);
          throw paramVarArgs;
        }
        AppMethodBeat.o(89077);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        aia localaia = (aia)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(89077);
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
            localaia.BaseRequest = ((hq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(89077);
          return 0;
        case 2: 
          localaia.cHn = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(89077);
          return 0;
        case 3: 
          localaia.cHp = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(89077);
          return 0;
        case 4: 
          localaia.knu = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(89077);
          return 0;
        case 5: 
          localaia.cHo = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(89077);
          return 0;
        case 6: 
          localaia.wlF = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(89077);
          return 0;
        case 7: 
          localaia.wlG = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(89077);
          return 0;
        case 8: 
          localaia.wlH = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(89077);
          return 0;
        case 9: 
          localaia.wZY = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(89077);
          return 0;
        }
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cgd();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cgd)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, buy.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localaia.wlJ = ((cgd)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(89077);
        return 0;
      }
      AppMethodBeat.o(89077);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aia
 * JD-Core Version:    0.7.0.1
 */