package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class su
  extends com.tencent.mm.bw.a
{
  public String Gif;
  public String Gig;
  public String Gih;
  public int Gii;
  public ti Gij;
  public int Gik;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(113950);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Gif != null) {
        paramVarArgs.d(1, this.Gif);
      }
      if (this.Gig != null) {
        paramVarArgs.d(2, this.Gig);
      }
      if (this.Gih != null) {
        paramVarArgs.d(3, this.Gih);
      }
      paramVarArgs.aS(4, this.Gii);
      if (this.Gij != null)
      {
        paramVarArgs.lJ(5, this.Gij.computeSize());
        this.Gij.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(6, this.Gik);
      AppMethodBeat.o(113950);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Gif == null) {
        break label582;
      }
    }
    label582:
    for (int i = f.a.a.b.b.a.e(1, this.Gif) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Gig != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.Gig);
      }
      i = paramInt;
      if (this.Gih != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.Gih);
      }
      i += f.a.a.b.b.a.bz(4, this.Gii);
      paramInt = i;
      if (this.Gij != null) {
        paramInt = i + f.a.a.a.lI(5, this.Gij.computeSize());
      }
      i = f.a.a.b.b.a.bz(6, this.Gik);
      AppMethodBeat.o(113950);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(113950);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        su localsu = (su)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(113950);
          return -1;
        case 1: 
          localsu.Gif = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(113950);
          return 0;
        case 2: 
          localsu.Gig = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(113950);
          return 0;
        case 3: 
          localsu.Gih = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(113950);
          return 0;
        case 4: 
          localsu.Gii = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(113950);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ti();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((ti)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localsu.Gij = ((ti)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(113950);
          return 0;
        }
        localsu.Gik = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(113950);
        return 0;
      }
      AppMethodBeat.o(113950);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.su
 * JD-Core Version:    0.7.0.1
 */