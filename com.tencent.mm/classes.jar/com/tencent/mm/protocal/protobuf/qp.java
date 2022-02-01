package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class qp
  extends com.tencent.mm.bx.a
{
  public String CPL;
  public String CPM;
  public String CPN;
  public int CPO;
  public rc CPP;
  public int CPQ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(113950);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.CPL != null) {
        paramVarArgs.d(1, this.CPL);
      }
      if (this.CPM != null) {
        paramVarArgs.d(2, this.CPM);
      }
      if (this.CPN != null) {
        paramVarArgs.d(3, this.CPN);
      }
      paramVarArgs.aR(4, this.CPO);
      if (this.CPP != null)
      {
        paramVarArgs.kX(5, this.CPP.computeSize());
        this.CPP.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(6, this.CPQ);
      AppMethodBeat.o(113950);
      return 0;
    }
    if (paramInt == 1) {
      if (this.CPL == null) {
        break label582;
      }
    }
    label582:
    for (int i = f.a.a.b.b.a.e(1, this.CPL) + 0;; i = 0)
    {
      paramInt = i;
      if (this.CPM != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.CPM);
      }
      i = paramInt;
      if (this.CPN != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.CPN);
      }
      i += f.a.a.b.b.a.bA(4, this.CPO);
      paramInt = i;
      if (this.CPP != null) {
        paramInt = i + f.a.a.a.kW(5, this.CPP.computeSize());
      }
      i = f.a.a.b.b.a.bA(6, this.CPQ);
      AppMethodBeat.o(113950);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(113950);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        qp localqp = (qp)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(113950);
          return -1;
        case 1: 
          localqp.CPL = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(113950);
          return 0;
        case 2: 
          localqp.CPM = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(113950);
          return 0;
        case 3: 
          localqp.CPN = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(113950);
          return 0;
        case 4: 
          localqp.CPO = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(113950);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new rc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((rc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localqp.CPP = ((rc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(113950);
          return 0;
        }
        localqp.CPQ = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(113950);
        return 0;
      }
      AppMethodBeat.o(113950);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.qp
 * JD-Core Version:    0.7.0.1
 */