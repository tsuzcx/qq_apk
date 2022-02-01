package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class cyg
  extends com.tencent.mm.bw.a
{
  public String Cga;
  public ain Cgj;
  public erc Lce;
  public String text;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(200107);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Cga == null)
      {
        paramVarArgs = new b("Not all required fields were included: pagPath");
        AppMethodBeat.o(200107);
        throw paramVarArgs;
      }
      if (this.Lce == null)
      {
        paramVarArgs = new b("Not all required fields were included: matrix");
        AppMethodBeat.o(200107);
        throw paramVarArgs;
      }
      if (this.Cga != null) {
        paramVarArgs.e(1, this.Cga);
      }
      if (this.text != null) {
        paramVarArgs.e(2, this.text);
      }
      if (this.Lce != null)
      {
        paramVarArgs.ni(3, this.Lce.computeSize());
        this.Lce.writeFields(paramVarArgs);
      }
      if (this.Cgj != null)
      {
        paramVarArgs.ni(4, this.Cgj.computeSize());
        this.Cgj.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(200107);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Cga == null) {
        break label682;
      }
    }
    label682:
    for (int i = g.a.a.b.b.a.f(1, this.Cga) + 0;; i = 0)
    {
      paramInt = i;
      if (this.text != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.text);
      }
      i = paramInt;
      if (this.Lce != null) {
        i = paramInt + g.a.a.a.nh(3, this.Lce.computeSize());
      }
      paramInt = i;
      if (this.Cgj != null) {
        paramInt = i + g.a.a.a.nh(4, this.Cgj.computeSize());
      }
      AppMethodBeat.o(200107);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.Cga == null)
        {
          paramVarArgs = new b("Not all required fields were included: pagPath");
          AppMethodBeat.o(200107);
          throw paramVarArgs;
        }
        if (this.Lce == null)
        {
          paramVarArgs = new b("Not all required fields were included: matrix");
          AppMethodBeat.o(200107);
          throw paramVarArgs;
        }
        AppMethodBeat.o(200107);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        cyg localcyg = (cyg)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(200107);
          return -1;
        case 1: 
          localcyg.Cga = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(200107);
          return 0;
        case 2: 
          localcyg.text = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(200107);
          return 0;
        case 3: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new erc();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((erc)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localcyg.Lce = ((erc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(200107);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ain();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((ain)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localcyg.Cgj = ((ain)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(200107);
        return 0;
      }
      AppMethodBeat.o(200107);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cyg
 * JD-Core Version:    0.7.0.1
 */