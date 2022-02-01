package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class dcq
  extends com.tencent.mm.cd.a
{
  public int CPw;
  public String RMK;
  public int SfH;
  public eae SfI;
  public abv TKA;
  public int TKB;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(133186);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.TKA == null)
      {
        paramVarArgs = new b("Not all required fields were included: Oplog");
        AppMethodBeat.o(133186);
        throw paramVarArgs;
      }
      if (this.SfI == null)
      {
        paramVarArgs = new b("Not all required fields were included: KeyBuf");
        AppMethodBeat.o(133186);
        throw paramVarArgs;
      }
      if (this.TKA != null)
      {
        paramVarArgs.oE(1, this.TKA.computeSize());
        this.TKA.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(2, this.SfH);
      if (this.SfI != null)
      {
        paramVarArgs.oE(3, this.SfI.computeSize());
        this.SfI.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(4, this.CPw);
      if (this.RMK != null) {
        paramVarArgs.f(5, this.RMK);
      }
      paramVarArgs.aY(6, this.TKB);
      AppMethodBeat.o(133186);
      return 0;
    }
    if (paramInt == 1) {
      if (this.TKA == null) {
        break label710;
      }
    }
    label710:
    for (paramInt = g.a.a.a.oD(1, this.TKA.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.SfH);
      paramInt = i;
      if (this.SfI != null) {
        paramInt = i + g.a.a.a.oD(3, this.SfI.computeSize());
      }
      i = paramInt + g.a.a.b.b.a.bM(4, this.CPw);
      paramInt = i;
      if (this.RMK != null) {
        paramInt = i + g.a.a.b.b.a.g(5, this.RMK);
      }
      i = g.a.a.b.b.a.bM(6, this.TKB);
      AppMethodBeat.o(133186);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.TKA == null)
        {
          paramVarArgs = new b("Not all required fields were included: Oplog");
          AppMethodBeat.o(133186);
          throw paramVarArgs;
        }
        if (this.SfI == null)
        {
          paramVarArgs = new b("Not all required fields were included: KeyBuf");
          AppMethodBeat.o(133186);
          throw paramVarArgs;
        }
        AppMethodBeat.o(133186);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        dcq localdcq = (dcq)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(133186);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new abv();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((abv)localObject2).parseFrom((byte[])localObject1);
            }
            localdcq.TKA = ((abv)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(133186);
          return 0;
        case 2: 
          localdcq.SfH = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(133186);
          return 0;
        case 3: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new eae();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((eae)localObject2).dd((byte[])localObject1);
            }
            localdcq.SfI = ((eae)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(133186);
          return 0;
        case 4: 
          localdcq.CPw = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(133186);
          return 0;
        case 5: 
          localdcq.RMK = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(133186);
          return 0;
        }
        localdcq.TKB = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(133186);
        return 0;
      }
      AppMethodBeat.o(133186);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dcq
 * JD-Core Version:    0.7.0.1
 */