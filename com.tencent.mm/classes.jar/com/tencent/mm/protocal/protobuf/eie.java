package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class eie
  extends com.tencent.mm.bx.a
{
  public eig HSJ;
  public eif HSK;
  public eih HSL;
  public eij HSM;
  public eii HSN;
  public eil HSO;
  public eid HSP;
  public eik HSQ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153340);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.HSJ != null)
      {
        paramVarArgs.lC(1, this.HSJ.computeSize());
        this.HSJ.writeFields(paramVarArgs);
      }
      if (this.HSK != null)
      {
        paramVarArgs.lC(2, this.HSK.computeSize());
        this.HSK.writeFields(paramVarArgs);
      }
      if (this.HSL != null)
      {
        paramVarArgs.lC(3, this.HSL.computeSize());
        this.HSL.writeFields(paramVarArgs);
      }
      if (this.HSM != null)
      {
        paramVarArgs.lC(4, this.HSM.computeSize());
        this.HSM.writeFields(paramVarArgs);
      }
      if (this.HSN != null)
      {
        paramVarArgs.lC(5, this.HSN.computeSize());
        this.HSN.writeFields(paramVarArgs);
      }
      if (this.HSO != null)
      {
        paramVarArgs.lC(6, this.HSO.computeSize());
        this.HSO.writeFields(paramVarArgs);
      }
      if (this.HSP != null)
      {
        paramVarArgs.lC(7, this.HSP.computeSize());
        this.HSP.writeFields(paramVarArgs);
      }
      if (this.HSQ != null)
      {
        paramVarArgs.lC(8, this.HSQ.computeSize());
        this.HSQ.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(153340);
      return 0;
    }
    if (paramInt == 1) {
      if (this.HSJ == null) {
        break label1394;
      }
    }
    label1394:
    for (int i = f.a.a.a.lB(1, this.HSJ.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.HSK != null) {
        paramInt = i + f.a.a.a.lB(2, this.HSK.computeSize());
      }
      i = paramInt;
      if (this.HSL != null) {
        i = paramInt + f.a.a.a.lB(3, this.HSL.computeSize());
      }
      paramInt = i;
      if (this.HSM != null) {
        paramInt = i + f.a.a.a.lB(4, this.HSM.computeSize());
      }
      i = paramInt;
      if (this.HSN != null) {
        i = paramInt + f.a.a.a.lB(5, this.HSN.computeSize());
      }
      paramInt = i;
      if (this.HSO != null) {
        paramInt = i + f.a.a.a.lB(6, this.HSO.computeSize());
      }
      i = paramInt;
      if (this.HSP != null) {
        i = paramInt + f.a.a.a.lB(7, this.HSP.computeSize());
      }
      paramInt = i;
      if (this.HSQ != null) {
        paramInt = i + f.a.a.a.lB(8, this.HSQ.computeSize());
      }
      AppMethodBeat.o(153340);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(153340);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        eie localeie = (eie)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(153340);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new eig();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((eig)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localeie.HSJ = ((eig)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(153340);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new eif();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((eif)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localeie.HSK = ((eif)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(153340);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new eih();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((eih)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localeie.HSL = ((eih)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(153340);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new eij();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((eij)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localeie.HSM = ((eij)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(153340);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new eii();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((eii)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localeie.HSN = ((eii)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(153340);
          return 0;
        case 6: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new eil();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((eil)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localeie.HSO = ((eil)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(153340);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new eid();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((eid)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localeie.HSP = ((eid)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(153340);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new eik();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((eik)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localeie.HSQ = ((eik)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(153340);
        return 0;
      }
      AppMethodBeat.o(153340);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eie
 * JD-Core Version:    0.7.0.1
 */