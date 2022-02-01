package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bnl
  extends com.tencent.mm.cd.a
{
  public String SYA;
  public LinkedList<bnm> SYB;
  public int SYC;
  public boolean SYD;
  public LinkedList<bnf> SYx;
  public LinkedList<bnn> SYy;
  public String SYz;
  public String fwr;
  public int type;
  
  public bnl()
  {
    AppMethodBeat.i(42642);
    this.SYx = new LinkedList();
    this.SYy = new LinkedList();
    this.SYB = new LinkedList();
    AppMethodBeat.o(42642);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(42643);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.fwr != null) {
        paramVarArgs.f(1, this.fwr);
      }
      paramVarArgs.aY(2, this.type);
      paramVarArgs.e(3, 8, this.SYx);
      paramVarArgs.e(4, 8, this.SYy);
      if (this.SYz != null) {
        paramVarArgs.f(5, this.SYz);
      }
      if (this.SYA != null) {
        paramVarArgs.f(6, this.SYA);
      }
      paramVarArgs.e(7, 8, this.SYB);
      paramVarArgs.aY(8, this.SYC);
      paramVarArgs.co(9, this.SYD);
      AppMethodBeat.o(42643);
      return 0;
    }
    if (paramInt == 1) {
      if (this.fwr == null) {
        break label828;
      }
    }
    label828:
    for (paramInt = g.a.a.b.b.a.g(1, this.fwr) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.type) + g.a.a.a.c(3, 8, this.SYx) + g.a.a.a.c(4, 8, this.SYy);
      paramInt = i;
      if (this.SYz != null) {
        paramInt = i + g.a.a.b.b.a.g(5, this.SYz);
      }
      i = paramInt;
      if (this.SYA != null) {
        i = paramInt + g.a.a.b.b.a.g(6, this.SYA);
      }
      paramInt = g.a.a.a.c(7, 8, this.SYB);
      int j = g.a.a.b.b.a.bM(8, this.SYC);
      int k = g.a.a.b.b.a.gL(9);
      AppMethodBeat.o(42643);
      return i + paramInt + j + (k + 1);
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.SYx.clear();
        this.SYy.clear();
        this.SYB.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(42643);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        bnl localbnl = (bnl)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(42643);
          return -1;
        case 1: 
          localbnl.fwr = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(42643);
          return 0;
        case 2: 
          localbnl.type = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(42643);
          return 0;
        case 3: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bnf();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bnf)localObject2).parseFrom((byte[])localObject1);
            }
            localbnl.SYx.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(42643);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bnn();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bnn)localObject2).parseFrom((byte[])localObject1);
            }
            localbnl.SYy.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(42643);
          return 0;
        case 5: 
          localbnl.SYz = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(42643);
          return 0;
        case 6: 
          localbnl.SYA = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(42643);
          return 0;
        case 7: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bnm();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bnm)localObject2).parseFrom((byte[])localObject1);
            }
            localbnl.SYB.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(42643);
          return 0;
        case 8: 
          localbnl.SYC = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(42643);
          return 0;
        }
        localbnl.SYD = ((g.a.a.a.a)localObject1).abFh.AB();
        AppMethodBeat.o(42643);
        return 0;
      }
      AppMethodBeat.o(42643);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bnl
 * JD-Core Version:    0.7.0.1
 */