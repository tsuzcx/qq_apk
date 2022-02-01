package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class buq
  extends com.tencent.mm.bx.a
{
  public boolean DDK = false;
  public dcm DnE;
  public String DnF;
  public boolean DnH = false;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(122520);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.DnE != null)
      {
        paramVarArgs.kX(1, this.DnE.computeSize());
        this.DnE.writeFields(paramVarArgs);
      }
      paramVarArgs.bg(2, this.DnH);
      paramVarArgs.bg(3, this.DDK);
      if (this.DnF != null) {
        paramVarArgs.d(4, this.DnF);
      }
      AppMethodBeat.o(122520);
      return 0;
    }
    if (paramInt == 1) {
      if (this.DnE == null) {
        break label454;
      }
    }
    label454:
    for (paramInt = f.a.a.a.kW(1, this.DnE.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + (f.a.a.b.b.a.fY(2) + 1) + (f.a.a.b.b.a.fY(3) + 1);
      paramInt = i;
      if (this.DnF != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.DnF);
      }
      AppMethodBeat.o(122520);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(122520);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        buq localbuq = (buq)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(122520);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dcm();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((dcm)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbuq.DnE = ((dcm)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(122520);
          return 0;
        case 2: 
          localbuq.DnH = ((f.a.a.a.a)localObject1).KhF.fHu();
          AppMethodBeat.o(122520);
          return 0;
        case 3: 
          localbuq.DDK = ((f.a.a.a.a)localObject1).KhF.fHu();
          AppMethodBeat.o(122520);
          return 0;
        }
        localbuq.DnF = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(122520);
        return 0;
      }
      AppMethodBeat.o(122520);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.buq
 * JD-Core Version:    0.7.0.1
 */