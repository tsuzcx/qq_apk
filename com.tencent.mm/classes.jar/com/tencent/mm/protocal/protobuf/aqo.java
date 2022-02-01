package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class aqo
  extends com.tencent.mm.bw.a
{
  public LinkedList<aqq> EJA;
  public String EJB;
  public String EJC;
  public LinkedList<aqp> EJD;
  public int EJE;
  public boolean EJF;
  public LinkedList<aqi> EJz;
  public String Title;
  public int type;
  
  public aqo()
  {
    AppMethodBeat.i(42642);
    this.EJz = new LinkedList();
    this.EJA = new LinkedList();
    this.EJD = new LinkedList();
    AppMethodBeat.o(42642);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(42643);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Title != null) {
        paramVarArgs.d(1, this.Title);
      }
      paramVarArgs.aR(2, this.type);
      paramVarArgs.e(3, 8, this.EJz);
      paramVarArgs.e(4, 8, this.EJA);
      if (this.EJB != null) {
        paramVarArgs.d(5, this.EJB);
      }
      if (this.EJC != null) {
        paramVarArgs.d(6, this.EJC);
      }
      paramVarArgs.e(7, 8, this.EJD);
      paramVarArgs.aR(8, this.EJE);
      paramVarArgs.bl(9, this.EJF);
      AppMethodBeat.o(42643);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Title == null) {
        break label894;
      }
    }
    label894:
    for (paramInt = f.a.a.b.b.a.e(1, this.Title) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bx(2, this.type) + f.a.a.a.c(3, 8, this.EJz) + f.a.a.a.c(4, 8, this.EJA);
      paramInt = i;
      if (this.EJB != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.EJB);
      }
      i = paramInt;
      if (this.EJC != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.EJC);
      }
      paramInt = f.a.a.a.c(7, 8, this.EJD);
      int j = f.a.a.b.b.a.bx(8, this.EJE);
      int k = f.a.a.b.b.a.fK(9);
      AppMethodBeat.o(42643);
      return i + paramInt + j + (k + 1);
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.EJz.clear();
        this.EJA.clear();
        this.EJD.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(42643);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        aqo localaqo = (aqo)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(42643);
          return -1;
        case 1: 
          localaqo.Title = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(42643);
          return 0;
        case 2: 
          localaqo.type = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(42643);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new aqi();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((aqi)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localaqo.EJz.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(42643);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new aqq();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((aqq)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localaqo.EJA.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(42643);
          return 0;
        case 5: 
          localaqo.EJB = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(42643);
          return 0;
        case 6: 
          localaqo.EJC = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(42643);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new aqp();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((aqp)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localaqo.EJD.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(42643);
          return 0;
        case 8: 
          localaqo.EJE = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(42643);
          return 0;
        }
        localaqo.EJF = ((f.a.a.a.a)localObject1).LVo.fZX();
        AppMethodBeat.o(42643);
        return 0;
      }
      AppMethodBeat.o(42643);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aqo
 * JD-Core Version:    0.7.0.1
 */