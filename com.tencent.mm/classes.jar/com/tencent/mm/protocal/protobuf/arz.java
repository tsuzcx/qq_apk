package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class arz
  extends com.tencent.mm.bw.a
{
  public arw GIz;
  public String dBe;
  public String desc;
  public String iconUrl;
  public int sXu;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(164048);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.dBe != null) {
        paramVarArgs.d(1, this.dBe);
      }
      paramVarArgs.aS(2, this.sXu);
      if (this.iconUrl != null) {
        paramVarArgs.d(3, this.iconUrl);
      }
      if (this.desc != null) {
        paramVarArgs.d(4, this.desc);
      }
      if (this.GIz != null)
      {
        paramVarArgs.lJ(5, this.GIz.computeSize());
        this.GIz.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(164048);
      return 0;
    }
    if (paramInt == 1) {
      if (this.dBe == null) {
        break label534;
      }
    }
    label534:
    for (paramInt = f.a.a.b.b.a.e(1, this.dBe) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.sXu);
      paramInt = i;
      if (this.iconUrl != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.iconUrl);
      }
      i = paramInt;
      if (this.desc != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.desc);
      }
      paramInt = i;
      if (this.GIz != null) {
        paramInt = i + f.a.a.a.lI(5, this.GIz.computeSize());
      }
      AppMethodBeat.o(164048);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(164048);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        arz localarz = (arz)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(164048);
          return -1;
        case 1: 
          localarz.dBe = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(164048);
          return 0;
        case 2: 
          localarz.sXu = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(164048);
          return 0;
        case 3: 
          localarz.iconUrl = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(164048);
          return 0;
        case 4: 
          localarz.desc = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(164048);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new arw();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((arw)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localarz.GIz = ((arw)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(164048);
        return 0;
      }
      AppMethodBeat.o(164048);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.arz
 * JD-Core Version:    0.7.0.1
 */