package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ctc
  extends com.tencent.mm.bw.a
{
  public ctd GWv;
  public String HEe;
  public String content;
  public String hCn;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(168758);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.content != null) {
        paramVarArgs.d(1, this.content);
      }
      if (this.hCn != null) {
        paramVarArgs.d(2, this.hCn);
      }
      if (this.HEe != null) {
        paramVarArgs.d(3, this.HEe);
      }
      if (this.GWv != null)
      {
        paramVarArgs.lJ(4, this.GWv.computeSize());
        this.GWv.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(168758);
      return 0;
    }
    if (paramInt == 1) {
      if (this.content == null) {
        break label490;
      }
    }
    label490:
    for (int i = f.a.a.b.b.a.e(1, this.content) + 0;; i = 0)
    {
      paramInt = i;
      if (this.hCn != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.hCn);
      }
      i = paramInt;
      if (this.HEe != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.HEe);
      }
      paramInt = i;
      if (this.GWv != null) {
        paramInt = i + f.a.a.a.lI(4, this.GWv.computeSize());
      }
      AppMethodBeat.o(168758);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(168758);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ctc localctc = (ctc)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(168758);
          return -1;
        case 1: 
          localctc.content = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(168758);
          return 0;
        case 2: 
          localctc.hCn = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(168758);
          return 0;
        case 3: 
          localctc.HEe = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(168758);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ctd();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((ctd)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localctc.GWv = ((ctd)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(168758);
        return 0;
      }
      AppMethodBeat.o(168758);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ctc
 * JD-Core Version:    0.7.0.1
 */