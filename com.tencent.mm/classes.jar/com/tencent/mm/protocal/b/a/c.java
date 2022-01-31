package com.tencent.mm.protocal.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.aca;
import com.tencent.mm.protocal.protobuf.ack;
import java.util.LinkedList;

public final class c
  extends com.tencent.mm.bv.a
{
  public String desc;
  public LinkedList<aca> fjy;
  public long lsP;
  public String title;
  public String wjU;
  public ack wjV;
  
  public c()
  {
    AppMethodBeat.i(111120);
    this.fjy = new LinkedList();
    AppMethodBeat.o(111120);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(111121);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.title != null) {
        paramVarArgs.e(1, this.title);
      }
      if (this.desc != null) {
        paramVarArgs.e(2, this.desc);
      }
      paramVarArgs.e(3, 8, this.fjy);
      if (this.wjU != null) {
        paramVarArgs.e(4, this.wjU);
      }
      if (this.wjV != null)
      {
        paramVarArgs.iQ(5, this.wjV.computeSize());
        this.wjV.writeFields(paramVarArgs);
      }
      paramVarArgs.am(6, this.lsP);
      AppMethodBeat.o(111121);
      return 0;
    }
    if (paramInt == 1) {
      if (this.title == null) {
        break label678;
      }
    }
    label678:
    for (paramInt = e.a.a.b.b.a.f(1, this.title) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.desc != null) {
        i = paramInt + e.a.a.b.b.a.f(2, this.desc);
      }
      i += e.a.a.a.c(3, 8, this.fjy);
      paramInt = i;
      if (this.wjU != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.wjU);
      }
      i = paramInt;
      if (this.wjV != null) {
        i = paramInt + e.a.a.a.iP(5, this.wjV.computeSize());
      }
      paramInt = e.a.a.b.b.a.p(6, this.lsP);
      AppMethodBeat.o(111121);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.fjy.clear();
        paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(111121);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        c localc = (c)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(111121);
          return -1;
        case 1: 
          localc.title = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(111121);
          return 0;
        case 2: 
          localc.desc = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(111121);
          return 0;
        case 3: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new aca();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((aca)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localc.fjy.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(111121);
          return 0;
        case 4: 
          localc.wjU = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(111121);
          return 0;
        case 5: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ack();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ack)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localc.wjV = ((ack)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(111121);
          return 0;
        }
        localc.lsP = ((e.a.a.a.a)localObject1).CLY.sm();
        AppMethodBeat.o(111121);
        return 0;
      }
      AppMethodBeat.o(111121);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.b.a.c
 * JD-Core Version:    0.7.0.1
 */