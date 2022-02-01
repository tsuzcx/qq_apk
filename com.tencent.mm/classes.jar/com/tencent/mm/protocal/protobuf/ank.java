package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ank
  extends com.tencent.mm.bx.a
{
  public LinkedList<anm> DoA;
  public String DoB;
  public String DoC;
  public LinkedList<anl> DoD;
  public int DoE;
  public boolean DoF;
  public LinkedList<ane> Doz;
  public String Title;
  public int type;
  
  public ank()
  {
    AppMethodBeat.i(42642);
    this.Doz = new LinkedList();
    this.DoA = new LinkedList();
    this.DoD = new LinkedList();
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
      paramVarArgs.e(3, 8, this.Doz);
      paramVarArgs.e(4, 8, this.DoA);
      if (this.DoB != null) {
        paramVarArgs.d(5, this.DoB);
      }
      if (this.DoC != null) {
        paramVarArgs.d(6, this.DoC);
      }
      paramVarArgs.e(7, 8, this.DoD);
      paramVarArgs.aR(8, this.DoE);
      paramVarArgs.bg(9, this.DoF);
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
      int i = paramInt + f.a.a.b.b.a.bA(2, this.type) + f.a.a.a.c(3, 8, this.Doz) + f.a.a.a.c(4, 8, this.DoA);
      paramInt = i;
      if (this.DoB != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.DoB);
      }
      i = paramInt;
      if (this.DoC != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.DoC);
      }
      paramInt = f.a.a.a.c(7, 8, this.DoD);
      int j = f.a.a.b.b.a.bA(8, this.DoE);
      int k = f.a.a.b.b.a.fY(9);
      AppMethodBeat.o(42643);
      return i + paramInt + j + (k + 1);
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Doz.clear();
        this.DoA.clear();
        this.DoD.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(42643);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ank localank = (ank)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(42643);
          return -1;
        case 1: 
          localank.Title = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(42643);
          return 0;
        case 2: 
          localank.type = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(42643);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ane();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ane)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localank.Doz.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(42643);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new anm();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((anm)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localank.DoA.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(42643);
          return 0;
        case 5: 
          localank.DoB = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(42643);
          return 0;
        case 6: 
          localank.DoC = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(42643);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new anl();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((anl)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localank.DoD.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(42643);
          return 0;
        case 8: 
          localank.DoE = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(42643);
          return 0;
        }
        localank.DoF = ((f.a.a.a.a)localObject1).KhF.fHu();
        AppMethodBeat.o(42643);
        return 0;
      }
      AppMethodBeat.o(42643);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ank
 * JD-Core Version:    0.7.0.1
 */