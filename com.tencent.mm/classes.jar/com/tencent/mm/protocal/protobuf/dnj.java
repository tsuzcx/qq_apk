package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class dnj
  extends com.tencent.mm.bw.a
{
  public dww GhB;
  public String text;
  public int textColor;
  public String ydG;
  public int ydz;
  public int yfg;
  public agg yfj;
  
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
      if (this.GhB == null)
      {
        paramVarArgs = new b("Not all required fields were included: matrix");
        AppMethodBeat.o(140931);
        throw paramVarArgs;
      }
      if (this.text != null) {
        paramVarArgs.d(1, this.text);
      }
      paramVarArgs.aS(2, this.textColor);
      paramVarArgs.aS(3, this.yfg);
      if (this.GhB != null)
      {
        paramVarArgs.lJ(4, this.GhB.computeSize());
        this.GhB.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(5, this.ydz);
      if (this.yfj != null)
      {
        paramVarArgs.lJ(6, this.yfj.computeSize());
        this.yfj.writeFields(paramVarArgs);
      }
      if (this.ydG != null) {
        paramVarArgs.d(7, this.ydG);
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
    for (paramInt = f.a.a.b.b.a.e(1, this.text) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.textColor) + f.a.a.b.b.a.bz(3, this.yfg);
      paramInt = i;
      if (this.GhB != null) {
        paramInt = i + f.a.a.a.lI(4, this.GhB.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bz(5, this.ydz);
      paramInt = i;
      if (this.yfj != null) {
        paramInt = i + f.a.a.a.lI(6, this.yfj.computeSize());
      }
      i = paramInt;
      if (this.ydG != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.ydG);
      }
      AppMethodBeat.o(140931);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.text == null)
        {
          paramVarArgs = new b("Not all required fields were included: text");
          AppMethodBeat.o(140931);
          throw paramVarArgs;
        }
        if (this.GhB == null)
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
        dnj localdnj = (dnj)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(140931);
          return -1;
        case 1: 
          localdnj.text = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(140931);
          return 0;
        case 2: 
          localdnj.textColor = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(140931);
          return 0;
        case 3: 
          localdnj.yfg = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(140931);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dww();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dww)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdnj.GhB = ((dww)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(140931);
          return 0;
        case 5: 
          localdnj.ydz = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(140931);
          return 0;
        case 6: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new agg();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((agg)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdnj.yfj = ((agg)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(140931);
          return 0;
        }
        localdnj.ydG = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(140931);
        return 0;
      }
      AppMethodBeat.o(140931);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dnj
 * JD-Core Version:    0.7.0.1
 */