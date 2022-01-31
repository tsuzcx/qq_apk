package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cbs
  extends buy
{
  public int cHp;
  public LinkedList<cbu> fjy;
  public String wZY;
  public cgd wlJ;
  public String xFL;
  public int xMu;
  public ccj xMv;
  
  public cbs()
  {
    AppMethodBeat.i(89137);
    this.fjy = new LinkedList();
    AppMethodBeat.o(89137);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(89138);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.iQ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(2, this.xMu);
      paramVarArgs.e(3, 8, this.fjy);
      if (this.xFL != null) {
        paramVarArgs.e(4, this.xFL);
      }
      if (this.wZY != null) {
        paramVarArgs.e(5, this.wZY);
      }
      if (this.xMv != null)
      {
        paramVarArgs.iQ(6, this.xMv.computeSize());
        this.xMv.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(7, this.cHp);
      if (this.wlJ != null)
      {
        paramVarArgs.iQ(8, this.wlJ.computeSize());
        this.wlJ.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(89138);
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
      int i = paramInt + e.a.a.b.b.a.bl(2, this.xMu) + e.a.a.a.c(3, 8, this.fjy);
      paramInt = i;
      if (this.xFL != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.xFL);
      }
      i = paramInt;
      if (this.wZY != null) {
        i = paramInt + e.a.a.b.b.a.f(5, this.wZY);
      }
      paramInt = i;
      if (this.xMv != null) {
        paramInt = i + e.a.a.a.iP(6, this.xMv.computeSize());
      }
      i = paramInt + e.a.a.b.b.a.bl(7, this.cHp);
      paramInt = i;
      if (this.wlJ != null) {
        paramInt = i + e.a.a.a.iP(8, this.wlJ.computeSize());
      }
      AppMethodBeat.o(89138);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.fjy.clear();
        paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = buy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = buy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(89138);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        cbs localcbs = (cbs)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(89138);
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
            localcbs.BaseRequest = ((hq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(89138);
          return 0;
        case 2: 
          localcbs.xMu = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(89138);
          return 0;
        case 3: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cbu();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cbu)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, buy.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localcbs.fjy.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(89138);
          return 0;
        case 4: 
          localcbs.xFL = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(89138);
          return 0;
        case 5: 
          localcbs.wZY = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(89138);
          return 0;
        case 6: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ccj();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ccj)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, buy.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localcbs.xMv = ((ccj)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(89138);
          return 0;
        case 7: 
          localcbs.cHp = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(89138);
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
          localcbs.wlJ = ((cgd)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(89138);
        return 0;
      }
      AppMethodBeat.o(89138);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cbs
 * JD-Core Version:    0.7.0.1
 */