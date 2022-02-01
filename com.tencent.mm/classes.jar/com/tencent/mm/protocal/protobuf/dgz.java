package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class dgz
  extends com.tencent.mm.bw.a
{
  public dqj Fgu;
  public int gPV;
  public int gPW;
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
      if (this.Fgu == null)
      {
        paramVarArgs = new b("Not all required fields were included: matrix");
        AppMethodBeat.o(140931);
        throw paramVarArgs;
      }
      if (this.text != null) {
        paramVarArgs.d(1, this.text);
      }
      paramVarArgs.aR(2, this.textColor);
      paramVarArgs.aR(3, this.gPV);
      if (this.Fgu != null)
      {
        paramVarArgs.ln(4, this.Fgu.computeSize());
        this.Fgu.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(5, this.gPW);
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
      int i = paramInt + f.a.a.b.b.a.bx(2, this.textColor) + f.a.a.b.b.a.bx(3, this.gPV);
      paramInt = i;
      if (this.Fgu != null) {
        paramInt = i + f.a.a.a.lm(4, this.Fgu.computeSize());
      }
      i = f.a.a.b.b.a.bx(5, this.gPW);
      AppMethodBeat.o(140931);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        if (this.text == null)
        {
          paramVarArgs = new b("Not all required fields were included: text");
          AppMethodBeat.o(140931);
          throw paramVarArgs;
        }
        if (this.Fgu == null)
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
        dgz localdgz = (dgz)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(140931);
          return -1;
        case 1: 
          localdgz.text = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(140931);
          return 0;
        case 2: 
          localdgz.textColor = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(140931);
          return 0;
        case 3: 
          localdgz.gPV = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(140931);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dqj();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((dqj)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdgz.Fgu = ((dqj)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(140931);
          return 0;
        }
        localdgz.gPW = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(140931);
        return 0;
      }
      AppMethodBeat.o(140931);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dgz
 * JD-Core Version:    0.7.0.1
 */