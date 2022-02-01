package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class chz
  extends com.tencent.mm.bw.a
{
  public PersonalDesigner LVe;
  public String Lso;
  public chy Mnr;
  public cib Mns;
  public String Name;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(104818);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Lso != null) {
        paramVarArgs.e(1, this.Lso);
      }
      if (this.Mnr != null)
      {
        paramVarArgs.ni(2, this.Mnr.computeSize());
        this.Mnr.writeFields(paramVarArgs);
      }
      if (this.Name != null) {
        paramVarArgs.e(3, this.Name);
      }
      if (this.LVe != null)
      {
        paramVarArgs.ni(4, this.LVe.computeSize());
        this.LVe.writeFields(paramVarArgs);
      }
      if (this.Mns != null)
      {
        paramVarArgs.ni(5, this.Mns.computeSize());
        this.Mns.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(104818);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Lso == null) {
        break label738;
      }
    }
    label738:
    for (int i = g.a.a.b.b.a.f(1, this.Lso) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Mnr != null) {
        paramInt = i + g.a.a.a.nh(2, this.Mnr.computeSize());
      }
      i = paramInt;
      if (this.Name != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.Name);
      }
      paramInt = i;
      if (this.LVe != null) {
        paramInt = i + g.a.a.a.nh(4, this.LVe.computeSize());
      }
      i = paramInt;
      if (this.Mns != null) {
        i = paramInt + g.a.a.a.nh(5, this.Mns.computeSize());
      }
      AppMethodBeat.o(104818);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(104818);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        chz localchz = (chz)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(104818);
          return -1;
        case 1: 
          localchz.Lso = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(104818);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new chy();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((chy)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localchz.Mnr = ((chy)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(104818);
          return 0;
        case 3: 
          localchz.Name = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(104818);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new PersonalDesigner();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((PersonalDesigner)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localchz.LVe = ((PersonalDesigner)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(104818);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cib();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cib)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localchz.Mns = ((cib)localObject1);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.chz
 * JD-Core Version:    0.7.0.1
 */