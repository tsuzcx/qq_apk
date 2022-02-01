package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class dbn
  extends com.tencent.mm.bx.a
{
  public dks DKf;
  public int gpn;
  public int gpo;
  public String text;
  public int textColor;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(140931);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.text == null)
      {
        paramVarArgs = new b("Not all required fields were included: text");
        AppMethodBeat.o(140931);
        throw paramVarArgs;
      }
      if (this.DKf == null)
      {
        paramVarArgs = new b("Not all required fields were included: matrix");
        AppMethodBeat.o(140931);
        throw paramVarArgs;
      }
      if (this.text != null) {
        paramVarArgs.d(1, this.text);
      }
      paramVarArgs.aR(2, this.textColor);
      paramVarArgs.aR(3, this.gpn);
      if (this.DKf != null)
      {
        paramVarArgs.kX(4, this.DKf.computeSize());
        this.DKf.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(5, this.gpo);
      AppMethodBeat.o(140931);
      return 0;
    }
    if (paramInt == 1) {
      if (this.text == null) {
        break label598;
      }
    }
    label598:
    for (paramInt = f.a.a.b.b.a.e(1, this.text) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bA(2, this.textColor) + f.a.a.b.b.a.bA(3, this.gpn);
      paramInt = i;
      if (this.DKf != null) {
        paramInt = i + f.a.a.a.kW(4, this.DKf.computeSize());
      }
      i = f.a.a.b.b.a.bA(5, this.gpo);
      AppMethodBeat.o(140931);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        if (this.text == null)
        {
          paramVarArgs = new b("Not all required fields were included: text");
          AppMethodBeat.o(140931);
          throw paramVarArgs;
        }
        if (this.DKf == null)
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
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dbn localdbn = (dbn)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(140931);
          return -1;
        case 1: 
          localdbn.text = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(140931);
          return 0;
        case 2: 
          localdbn.textColor = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(140931);
          return 0;
        case 3: 
          localdbn.gpn = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(140931);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dks();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((dks)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdbn.DKf = ((dks)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(140931);
          return 0;
        }
        localdbn.gpo = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(140931);
        return 0;
      }
      AppMethodBeat.o(140931);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dbn
 * JD-Core Version:    0.7.0.1
 */