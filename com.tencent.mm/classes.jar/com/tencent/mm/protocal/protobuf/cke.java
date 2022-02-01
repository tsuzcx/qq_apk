package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cke
  extends com.tencent.mm.bx.a
{
  public dmo FsP;
  public dmo FsQ;
  public LinkedList<tj> Gpt;
  public bpn HdN;
  public cce HdO;
  
  public cke()
  {
    AppMethodBeat.i(91613);
    this.Gpt = new LinkedList();
    AppMethodBeat.o(91613);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91614);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.HdN != null)
      {
        paramVarArgs.lC(1, this.HdN.computeSize());
        this.HdN.writeFields(paramVarArgs);
      }
      if (this.FsP != null)
      {
        paramVarArgs.lC(2, this.FsP.computeSize());
        this.FsP.writeFields(paramVarArgs);
      }
      if (this.FsQ != null)
      {
        paramVarArgs.lC(3, this.FsQ.computeSize());
        this.FsQ.writeFields(paramVarArgs);
      }
      paramVarArgs.e(4, 8, this.Gpt);
      if (this.HdO != null)
      {
        paramVarArgs.lC(5, this.HdO.computeSize());
        this.HdO.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(91614);
      return 0;
    }
    if (paramInt == 1) {
      if (this.HdN == null) {
        break label914;
      }
    }
    label914:
    for (int i = f.a.a.a.lB(1, this.HdN.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.FsP != null) {
        paramInt = i + f.a.a.a.lB(2, this.FsP.computeSize());
      }
      i = paramInt;
      if (this.FsQ != null) {
        i = paramInt + f.a.a.a.lB(3, this.FsQ.computeSize());
      }
      i += f.a.a.a.c(4, 8, this.Gpt);
      paramInt = i;
      if (this.HdO != null) {
        paramInt = i + f.a.a.a.lB(5, this.HdO.computeSize());
      }
      AppMethodBeat.o(91614);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Gpt.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(91614);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cke localcke = (cke)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91614);
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
            localcke.HdN = ((bpn)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91614);
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
            localcke.FsP = ((dmo)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91614);
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
            localcke.FsQ = ((dmo)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91614);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new tj();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((tj)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcke.Gpt.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91614);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cce();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cce)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localcke.HdO = ((cce)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91614);
        return 0;
      }
      AppMethodBeat.o(91614);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cke
 * JD-Core Version:    0.7.0.1
 */