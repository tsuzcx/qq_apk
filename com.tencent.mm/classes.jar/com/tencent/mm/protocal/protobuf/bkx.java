package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bkx
  extends com.tencent.mm.bw.a
{
  public String LTF;
  public we LTL;
  public String LTM;
  public boolean LTN;
  public int LTO;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(114024);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.LTL != null)
      {
        paramVarArgs.ni(1, this.LTL.computeSize());
        this.LTL.writeFields(paramVarArgs);
      }
      if (this.LTF != null) {
        paramVarArgs.e(2, this.LTF);
      }
      if (this.LTM != null) {
        paramVarArgs.e(3, this.LTM);
      }
      paramVarArgs.cc(4, this.LTN);
      paramVarArgs.aM(5, this.LTO);
      AppMethodBeat.o(114024);
      return 0;
    }
    if (paramInt == 1) {
      if (this.LTL == null) {
        break label518;
      }
    }
    label518:
    for (int i = g.a.a.a.nh(1, this.LTL.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.LTF != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.LTF);
      }
      i = paramInt;
      if (this.LTM != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.LTM);
      }
      paramInt = g.a.a.b.b.a.fS(4);
      int j = g.a.a.b.b.a.bu(5, this.LTO);
      AppMethodBeat.o(114024);
      return i + (paramInt + 1) + j;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(114024);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        bkx localbkx = (bkx)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(114024);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new we();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((we)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localbkx.LTL = ((we)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(114024);
          return 0;
        case 2: 
          localbkx.LTF = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(114024);
          return 0;
        case 3: 
          localbkx.LTM = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(114024);
          return 0;
        case 4: 
          localbkx.LTN = ((g.a.a.a.a)localObject1).UbS.yZ();
          AppMethodBeat.o(114024);
          return 0;
        }
        localbkx.LTO = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(114024);
        return 0;
      }
      AppMethodBeat.o(114024);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bkx
 * JD-Core Version:    0.7.0.1
 */