package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class ai
  extends buy
{
  public String cHn;
  public String cHo;
  public int cHp;
  public String knu;
  public String wlF;
  public String wlG;
  public int wlH;
  public int wlI;
  public cgd wlJ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(88993);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.cHn == null)
      {
        paramVarArgs = new b("Not all required fields were included: card_id");
        AppMethodBeat.o(88993);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.iQ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.knu != null) {
        paramVarArgs.e(2, this.knu);
      }
      paramVarArgs.aO(3, this.cHp);
      if (this.cHn != null) {
        paramVarArgs.e(4, this.cHn);
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
      paramVarArgs.aO(9, this.wlI);
      if (this.wlJ != null)
      {
        paramVarArgs.iQ(10, this.wlJ.computeSize());
        this.wlJ.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(88993);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label954;
      }
    }
    label954:
    for (paramInt = e.a.a.a.iP(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.knu != null) {
        i = paramInt + e.a.a.b.b.a.f(2, this.knu);
      }
      i += e.a.a.b.b.a.bl(3, this.cHp);
      paramInt = i;
      if (this.cHn != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.cHn);
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
      i = i + e.a.a.b.b.a.bl(8, this.wlH) + e.a.a.b.b.a.bl(9, this.wlI);
      paramInt = i;
      if (this.wlJ != null) {
        paramInt = i + e.a.a.a.iP(10, this.wlJ.computeSize());
      }
      AppMethodBeat.o(88993);
      return paramInt;
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
          AppMethodBeat.o(88993);
          throw paramVarArgs;
        }
        AppMethodBeat.o(88993);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        ai localai = (ai)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(88993);
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
            localai.BaseRequest = ((hq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(88993);
          return 0;
        case 2: 
          localai.knu = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(88993);
          return 0;
        case 3: 
          localai.cHp = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(88993);
          return 0;
        case 4: 
          localai.cHn = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(88993);
          return 0;
        case 5: 
          localai.cHo = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(88993);
          return 0;
        case 6: 
          localai.wlF = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(88993);
          return 0;
        case 7: 
          localai.wlG = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(88993);
          return 0;
        case 8: 
          localai.wlH = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(88993);
          return 0;
        case 9: 
          localai.wlI = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(88993);
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
          localai.wlJ = ((cgd)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(88993);
        return 0;
      }
      AppMethodBeat.o(88993);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ai
 * JD-Core Version:    0.7.0.1
 */