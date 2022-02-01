package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dam
  extends com.tencent.mm.bw.a
{
  public String HLy;
  public String Hwr;
  public String Hws;
  public dlq MFQ;
  public String desc;
  public String iwv;
  public String name;
  public String title;
  public int uSc;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72542);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.name != null) {
        paramVarArgs.e(1, this.name);
      }
      if (this.title != null) {
        paramVarArgs.e(2, this.title);
      }
      if (this.desc != null) {
        paramVarArgs.e(3, this.desc);
      }
      if (this.iwv != null) {
        paramVarArgs.e(4, this.iwv);
      }
      paramVarArgs.aM(5, this.uSc);
      if (this.HLy != null) {
        paramVarArgs.e(6, this.HLy);
      }
      if (this.Hwr != null) {
        paramVarArgs.e(7, this.Hwr);
      }
      if (this.Hws != null) {
        paramVarArgs.e(8, this.Hws);
      }
      if (this.MFQ != null)
      {
        paramVarArgs.ni(9, this.MFQ.computeSize());
        this.MFQ.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(72542);
      return 0;
    }
    if (paramInt == 1) {
      if (this.name == null) {
        break label782;
      }
    }
    label782:
    for (int i = g.a.a.b.b.a.f(1, this.name) + 0;; i = 0)
    {
      paramInt = i;
      if (this.title != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.title);
      }
      i = paramInt;
      if (this.desc != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.desc);
      }
      paramInt = i;
      if (this.iwv != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.iwv);
      }
      i = paramInt + g.a.a.b.b.a.bu(5, this.uSc);
      paramInt = i;
      if (this.HLy != null) {
        paramInt = i + g.a.a.b.b.a.f(6, this.HLy);
      }
      i = paramInt;
      if (this.Hwr != null) {
        i = paramInt + g.a.a.b.b.a.f(7, this.Hwr);
      }
      paramInt = i;
      if (this.Hws != null) {
        paramInt = i + g.a.a.b.b.a.f(8, this.Hws);
      }
      i = paramInt;
      if (this.MFQ != null) {
        i = paramInt + g.a.a.a.nh(9, this.MFQ.computeSize());
      }
      AppMethodBeat.o(72542);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(72542);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        dam localdam = (dam)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72542);
          return -1;
        case 1: 
          localdam.name = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(72542);
          return 0;
        case 2: 
          localdam.title = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(72542);
          return 0;
        case 3: 
          localdam.desc = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(72542);
          return 0;
        case 4: 
          localdam.iwv = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(72542);
          return 0;
        case 5: 
          localdam.uSc = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(72542);
          return 0;
        case 6: 
          localdam.HLy = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(72542);
          return 0;
        case 7: 
          localdam.Hwr = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(72542);
          return 0;
        case 8: 
          localdam.Hws = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(72542);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dlq();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((dlq)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localdam.MFQ = ((dlq)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(72542);
        return 0;
      }
      AppMethodBeat.o(72542);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dam
 * JD-Core Version:    0.7.0.1
 */