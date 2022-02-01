package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dlu
  extends com.tencent.mm.bx.a
{
  public String FBS;
  public cwq FsR;
  public bpn HAj;
  public LinkedList<dmo> HAk;
  public LinkedList<dmo> HAl;
  public bpn HAm;
  public csf HAn;
  public cwp HAo;
  public che Hor;
  
  public dlu()
  {
    AppMethodBeat.i(91707);
    this.HAk = new LinkedList();
    this.HAl = new LinkedList();
    AppMethodBeat.o(91707);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91708);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.HAj != null)
      {
        paramVarArgs.lC(1, this.HAj.computeSize());
        this.HAj.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.HAk);
      paramVarArgs.e(3, 8, this.HAl);
      if (this.HAm != null)
      {
        paramVarArgs.lC(4, this.HAm.computeSize());
        this.HAm.writeFields(paramVarArgs);
      }
      if (this.HAn != null)
      {
        paramVarArgs.lC(5, this.HAn.computeSize());
        this.HAn.writeFields(paramVarArgs);
      }
      if (this.FBS != null) {
        paramVarArgs.d(6, this.FBS);
      }
      if (this.Hor != null)
      {
        paramVarArgs.lC(7, this.Hor.computeSize());
        this.Hor.writeFields(paramVarArgs);
      }
      if (this.FsR != null)
      {
        paramVarArgs.lC(8, this.FsR.computeSize());
        this.FsR.writeFields(paramVarArgs);
      }
      if (this.HAo != null)
      {
        paramVarArgs.lC(9, this.HAo.computeSize());
        this.HAo.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(91708);
      return 0;
    }
    if (paramInt == 1) {
      if (this.HAj == null) {
        break label1426;
      }
    }
    label1426:
    for (paramInt = f.a.a.a.lB(1, this.HAj.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.a.c(2, 8, this.HAk) + f.a.a.a.c(3, 8, this.HAl);
      paramInt = i;
      if (this.HAm != null) {
        paramInt = i + f.a.a.a.lB(4, this.HAm.computeSize());
      }
      i = paramInt;
      if (this.HAn != null) {
        i = paramInt + f.a.a.a.lB(5, this.HAn.computeSize());
      }
      paramInt = i;
      if (this.FBS != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.FBS);
      }
      i = paramInt;
      if (this.Hor != null) {
        i = paramInt + f.a.a.a.lB(7, this.Hor.computeSize());
      }
      paramInt = i;
      if (this.FsR != null) {
        paramInt = i + f.a.a.a.lB(8, this.FsR.computeSize());
      }
      i = paramInt;
      if (this.HAo != null) {
        i = paramInt + f.a.a.a.lB(9, this.HAo.computeSize());
      }
      AppMethodBeat.o(91708);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.HAk.clear();
        this.HAl.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(91708);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dlu localdlu = (dlu)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91708);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bpn();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bpn)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdlu.HAj = ((bpn)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91708);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dmo();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dmo)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdlu.HAk.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91708);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dmo();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dmo)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdlu.HAl.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91708);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bpn();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bpn)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdlu.HAm = ((bpn)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91708);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new csf();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((csf)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdlu.HAn = ((csf)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91708);
          return 0;
        case 6: 
          localdlu.FBS = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91708);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new che();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((che)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdlu.Hor = ((che)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91708);
          return 0;
        case 8: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cwq();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cwq)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdlu.FsR = ((cwq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91708);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cwp();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cwp)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdlu.HAo = ((cwp)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91708);
        return 0;
      }
      AppMethodBeat.o(91708);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dlu
 * JD-Core Version:    0.7.0.1
 */