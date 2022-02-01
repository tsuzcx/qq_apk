package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class ehd
  extends com.tencent.mm.bw.a
{
  public int CeB;
  public String CeI;
  public int Cgg;
  public ain Cgj;
  public erc Lce;
  public String text;
  public int textColor;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(140931);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.text == null)
      {
        paramVarArgs = new b("Not all required fields were included: text");
        AppMethodBeat.o(140931);
        throw paramVarArgs;
      }
      if (this.Lce == null)
      {
        paramVarArgs = new b("Not all required fields were included: matrix");
        AppMethodBeat.o(140931);
        throw paramVarArgs;
      }
      if (this.text != null) {
        paramVarArgs.e(1, this.text);
      }
      paramVarArgs.aM(2, this.textColor);
      paramVarArgs.aM(3, this.Cgg);
      if (this.Lce != null)
      {
        paramVarArgs.ni(4, this.Lce.computeSize());
        this.Lce.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(5, this.CeB);
      if (this.Cgj != null)
      {
        paramVarArgs.ni(6, this.Cgj.computeSize());
        this.Cgj.writeFields(paramVarArgs);
      }
      if (this.CeI != null) {
        paramVarArgs.e(7, this.CeI);
      }
      AppMethodBeat.o(140931);
      return 0;
    }
    if (paramInt == 1) {
      if (this.text == null) {
        break label814;
      }
    }
    label814:
    for (paramInt = g.a.a.b.b.a.f(1, this.text) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bu(2, this.textColor) + g.a.a.b.b.a.bu(3, this.Cgg);
      paramInt = i;
      if (this.Lce != null) {
        paramInt = i + g.a.a.a.nh(4, this.Lce.computeSize());
      }
      i = paramInt + g.a.a.b.b.a.bu(5, this.CeB);
      paramInt = i;
      if (this.Cgj != null) {
        paramInt = i + g.a.a.a.nh(6, this.Cgj.computeSize());
      }
      i = paramInt;
      if (this.CeI != null) {
        i = paramInt + g.a.a.b.b.a.f(7, this.CeI);
      }
      AppMethodBeat.o(140931);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.text == null)
        {
          paramVarArgs = new b("Not all required fields were included: text");
          AppMethodBeat.o(140931);
          throw paramVarArgs;
        }
        if (this.Lce == null)
        {
          paramVarArgs = new b("Not all required fields were included: matrix");
          AppMethodBeat.o(140931);
          throw paramVarArgs;
        }
        AppMethodBeat.o(140931);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        ehd localehd = (ehd)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(140931);
          return -1;
        case 1: 
          localehd.text = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(140931);
          return 0;
        case 2: 
          localehd.textColor = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(140931);
          return 0;
        case 3: 
          localehd.Cgg = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(140931);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new erc();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((erc)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localehd.Lce = ((erc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(140931);
          return 0;
        case 5: 
          localehd.CeB = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(140931);
          return 0;
        case 6: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ain();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ain)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localehd.Cgj = ((ain)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(140931);
          return 0;
        }
        localehd.CeI = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(140931);
        return 0;
      }
      AppMethodBeat.o(140931);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ehd
 * JD-Core Version:    0.7.0.1
 */