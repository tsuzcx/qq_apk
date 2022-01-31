package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class bjy
  extends com.tencent.mm.bv.a
{
  public String pqD;
  public int state;
  public LinkedList<bjx> xyo;
  public int xyp;
  public int xyq;
  public bvg xyr;
  public int xyt;
  public LinkedList<bjw> xyu;
  public boolean xyv;
  public LinkedList<bvg> xyw;
  
  public bjy()
  {
    AppMethodBeat.i(90704);
    this.xyo = new LinkedList();
    this.xyu = new LinkedList();
    this.xyw = new LinkedList();
    AppMethodBeat.o(90704);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(90705);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.pqD == null)
      {
        paramVarArgs = new b("Not all required fields were included: pid");
        AppMethodBeat.o(90705);
        throw paramVarArgs;
      }
      if (this.pqD != null) {
        paramVarArgs.e(1, this.pqD);
      }
      paramVarArgs.aO(2, this.state);
      paramVarArgs.e(3, 8, this.xyo);
      paramVarArgs.aO(4, this.xyp);
      paramVarArgs.aO(5, this.xyq);
      if (this.xyr != null)
      {
        paramVarArgs.iQ(6, this.xyr.computeSize());
        this.xyr.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(7, this.xyt);
      paramVarArgs.e(8, 8, this.xyu);
      paramVarArgs.aS(9, this.xyv);
      paramVarArgs.e(10, 8, this.xyw);
      AppMethodBeat.o(90705);
      return 0;
    }
    if (paramInt == 1) {
      if (this.pqD == null) {
        break label1066;
      }
    }
    label1066:
    for (paramInt = e.a.a.b.b.a.f(1, this.pqD) + 0;; paramInt = 0)
    {
      int i = paramInt + e.a.a.b.b.a.bl(2, this.state) + e.a.a.a.c(3, 8, this.xyo) + e.a.a.b.b.a.bl(4, this.xyp) + e.a.a.b.b.a.bl(5, this.xyq);
      paramInt = i;
      if (this.xyr != null) {
        paramInt = i + e.a.a.a.iP(6, this.xyr.computeSize());
      }
      i = e.a.a.b.b.a.bl(7, this.xyt);
      int j = e.a.a.a.c(8, 8, this.xyu);
      int k = e.a.a.b.b.a.eW(9);
      int m = e.a.a.a.c(10, 8, this.xyw);
      AppMethodBeat.o(90705);
      return paramInt + i + j + (k + 1) + m;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.xyo.clear();
        this.xyu.clear();
        this.xyw.clear();
        paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.pqD == null)
        {
          paramVarArgs = new b("Not all required fields were included: pid");
          AppMethodBeat.o(90705);
          throw paramVarArgs;
        }
        AppMethodBeat.o(90705);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        bjy localbjy = (bjy)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(90705);
          return -1;
        case 1: 
          localbjy.pqD = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(90705);
          return 0;
        case 2: 
          localbjy.state = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(90705);
          return 0;
        case 3: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bjx();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bjx)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localbjy.xyo.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(90705);
          return 0;
        case 4: 
          localbjy.xyp = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(90705);
          return 0;
        case 5: 
          localbjy.xyq = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(90705);
          return 0;
        case 6: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bvg();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bvg)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localbjy.xyr = ((bvg)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(90705);
          return 0;
        case 7: 
          localbjy.xyt = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(90705);
          return 0;
        case 8: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bjw();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bjw)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localbjy.xyu.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(90705);
          return 0;
        case 9: 
          localbjy.xyv = ((e.a.a.a.a)localObject1).CLY.emu();
          AppMethodBeat.o(90705);
          return 0;
        }
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bvg();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bvg)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localbjy.xyw.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(90705);
        return 0;
      }
      AppMethodBeat.o(90705);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bjy
 * JD-Core Version:    0.7.0.1
 */