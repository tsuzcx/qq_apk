package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class art
  extends dop
{
  public aov LAI;
  public String LAt;
  public LinkedList<String> LDj;
  public int LDk;
  public LinkedList<aps> LDl;
  public LinkedList<apq> LDm;
  public LinkedList<apo> LDn;
  
  public art()
  {
    AppMethodBeat.i(209398);
    this.LDj = new LinkedList();
    this.LDl = new LinkedList();
    this.LDm = new LinkedList();
    this.LDn = new LinkedList();
    AppMethodBeat.o(209398);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(209399);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ni(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.LAI != null)
      {
        paramVarArgs.ni(2, this.LAI.computeSize());
        this.LAI.writeFields(paramVarArgs);
      }
      paramVarArgs.e(3, 1, this.LDj);
      paramVarArgs.aM(4, this.LDk);
      if (this.LAt != null) {
        paramVarArgs.e(5, this.LAt);
      }
      paramVarArgs.e(6, 8, this.LDl);
      paramVarArgs.e(7, 8, this.LDm);
      paramVarArgs.e(8, 8, this.LDn);
      AppMethodBeat.o(209399);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1054;
      }
    }
    label1054:
    for (paramInt = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.LAI != null) {
        i = paramInt + g.a.a.a.nh(2, this.LAI.computeSize());
      }
      i = i + g.a.a.a.c(3, 1, this.LDj) + g.a.a.b.b.a.bu(4, this.LDk);
      paramInt = i;
      if (this.LAt != null) {
        paramInt = i + g.a.a.b.b.a.f(5, this.LAt);
      }
      i = g.a.a.a.c(6, 8, this.LDl);
      int j = g.a.a.a.c(7, 8, this.LDm);
      int k = g.a.a.a.c(8, 8, this.LDn);
      AppMethodBeat.o(209399);
      return paramInt + i + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.LDj.clear();
        this.LDl.clear();
        this.LDm.clear();
        this.LDn.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(209399);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        art localart = (art)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(209399);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jr();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((jr)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localart.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(209399);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new aov();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((aov)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localart.LAI = ((aov)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(209399);
          return 0;
        case 3: 
          localart.LDj.add(((g.a.a.a.a)localObject1).UbS.readString());
          AppMethodBeat.o(209399);
          return 0;
        case 4: 
          localart.LDk = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(209399);
          return 0;
        case 5: 
          localart.LAt = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(209399);
          return 0;
        case 6: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new aps();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((aps)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localart.LDl.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(209399);
          return 0;
        case 7: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new apq();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((apq)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localart.LDm.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(209399);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new apo();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((apo)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localart.LDn.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(209399);
        return 0;
      }
      AppMethodBeat.o(209399);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.art
 * JD-Core Version:    0.7.0.1
 */