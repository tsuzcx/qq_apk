package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bus
  extends com.tencent.mm.bw.a
{
  public PersonalDesigner GQO;
  public String GwI;
  public bur HhP;
  public buu HhQ;
  public String Name;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(104818);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.GwI != null) {
        paramVarArgs.d(1, this.GwI);
      }
      if (this.HhP != null)
      {
        paramVarArgs.lJ(2, this.HhP.computeSize());
        this.HhP.writeFields(paramVarArgs);
      }
      if (this.Name != null) {
        paramVarArgs.d(3, this.Name);
      }
      if (this.GQO != null)
      {
        paramVarArgs.lJ(4, this.GQO.computeSize());
        this.GQO.writeFields(paramVarArgs);
      }
      if (this.HhQ != null)
      {
        paramVarArgs.lJ(5, this.HhQ.computeSize());
        this.HhQ.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(104818);
      return 0;
    }
    if (paramInt == 1) {
      if (this.GwI == null) {
        break label738;
      }
    }
    label738:
    for (int i = f.a.a.b.b.a.e(1, this.GwI) + 0;; i = 0)
    {
      paramInt = i;
      if (this.HhP != null) {
        paramInt = i + f.a.a.a.lI(2, this.HhP.computeSize());
      }
      i = paramInt;
      if (this.Name != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.Name);
      }
      paramInt = i;
      if (this.GQO != null) {
        paramInt = i + f.a.a.a.lI(4, this.GQO.computeSize());
      }
      i = paramInt;
      if (this.HhQ != null) {
        i = paramInt + f.a.a.a.lI(5, this.HhQ.computeSize());
      }
      AppMethodBeat.o(104818);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(104818);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bus localbus = (bus)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(104818);
          return -1;
        case 1: 
          localbus.GwI = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(104818);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bur();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bur)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbus.HhP = ((bur)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(104818);
          return 0;
        case 3: 
          localbus.Name = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(104818);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new PersonalDesigner();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((PersonalDesigner)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbus.GQO = ((PersonalDesigner)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(104818);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new buu();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((buu)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbus.HhQ = ((buu)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(104818);
        return 0;
      }
      AppMethodBeat.o(104818);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bus
 * JD-Core Version:    0.7.0.1
 */