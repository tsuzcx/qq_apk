package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bgj
  extends com.tencent.mm.bw.a
{
  public LinkedList<bgd> LQd;
  public LinkedList<bgl> LQe;
  public String LQf;
  public String LQg;
  public LinkedList<bgk> LQh;
  public int LQi;
  public boolean LQj;
  public String Title;
  public int type;
  
  public bgj()
  {
    AppMethodBeat.i(42642);
    this.LQd = new LinkedList();
    this.LQe = new LinkedList();
    this.LQh = new LinkedList();
    AppMethodBeat.o(42642);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(42643);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Title != null) {
        paramVarArgs.e(1, this.Title);
      }
      paramVarArgs.aM(2, this.type);
      paramVarArgs.e(3, 8, this.LQd);
      paramVarArgs.e(4, 8, this.LQe);
      if (this.LQf != null) {
        paramVarArgs.e(5, this.LQf);
      }
      if (this.LQg != null) {
        paramVarArgs.e(6, this.LQg);
      }
      paramVarArgs.e(7, 8, this.LQh);
      paramVarArgs.aM(8, this.LQi);
      paramVarArgs.cc(9, this.LQj);
      AppMethodBeat.o(42643);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Title == null) {
        break label894;
      }
    }
    label894:
    for (paramInt = g.a.a.b.b.a.f(1, this.Title) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bu(2, this.type) + g.a.a.a.c(3, 8, this.LQd) + g.a.a.a.c(4, 8, this.LQe);
      paramInt = i;
      if (this.LQf != null) {
        paramInt = i + g.a.a.b.b.a.f(5, this.LQf);
      }
      i = paramInt;
      if (this.LQg != null) {
        i = paramInt + g.a.a.b.b.a.f(6, this.LQg);
      }
      paramInt = g.a.a.a.c(7, 8, this.LQh);
      int j = g.a.a.b.b.a.bu(8, this.LQi);
      int k = g.a.a.b.b.a.fS(9);
      AppMethodBeat.o(42643);
      return i + paramInt + j + (k + 1);
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.LQd.clear();
        this.LQe.clear();
        this.LQh.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(42643);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        bgj localbgj = (bgj)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(42643);
          return -1;
        case 1: 
          localbgj.Title = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(42643);
          return 0;
        case 2: 
          localbgj.type = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(42643);
          return 0;
        case 3: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bgd();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bgd)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localbgj.LQd.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(42643);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bgl();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bgl)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localbgj.LQe.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(42643);
          return 0;
        case 5: 
          localbgj.LQf = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(42643);
          return 0;
        case 6: 
          localbgj.LQg = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(42643);
          return 0;
        case 7: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bgk();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bgk)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localbgj.LQh.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(42643);
          return 0;
        case 8: 
          localbgj.LQi = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(42643);
          return 0;
        }
        localbgj.LQj = ((g.a.a.a.a)localObject1).UbS.yZ();
        AppMethodBeat.o(42643);
        return 0;
      }
      AppMethodBeat.o(42643);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bgj
 * JD-Core Version:    0.7.0.1
 */