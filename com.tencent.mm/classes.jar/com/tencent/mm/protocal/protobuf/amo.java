package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class amo
  extends com.tencent.mm.bx.a
{
  public dcm DnE;
  public String DnF = "";
  public String DnG = "";
  public boolean DnH = false;
  public boolean DnI = false;
  public long timestamp = 0L;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(122493);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.DnE != null)
      {
        paramVarArgs.kX(1, this.DnE.computeSize());
        this.DnE.writeFields(paramVarArgs);
      }
      if (this.DnG != null) {
        paramVarArgs.d(2, this.DnG);
      }
      paramVarArgs.bg(3, this.DnH);
      if (this.DnF != null) {
        paramVarArgs.d(4, this.DnF);
      }
      paramVarArgs.bg(5, this.DnI);
      paramVarArgs.aG(6, this.timestamp);
      AppMethodBeat.o(122493);
      return 0;
    }
    if (paramInt == 1) {
      if (this.DnE == null) {
        break label562;
      }
    }
    label562:
    for (paramInt = f.a.a.a.kW(1, this.DnE.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.DnG != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.DnG);
      }
      i += f.a.a.b.b.a.fY(3) + 1;
      paramInt = i;
      if (this.DnF != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.DnF);
      }
      i = f.a.a.b.b.a.fY(5);
      int j = f.a.a.b.b.a.q(6, this.timestamp);
      AppMethodBeat.o(122493);
      return paramInt + (i + 1) + j;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(122493);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        amo localamo = (amo)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(122493);
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
            localamo.DnE = ((dcm)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(122493);
          return 0;
        case 2: 
          localamo.DnG = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(122493);
          return 0;
        case 3: 
          localamo.DnH = ((f.a.a.a.a)localObject1).KhF.fHu();
          AppMethodBeat.o(122493);
          return 0;
        case 4: 
          localamo.DnF = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(122493);
          return 0;
        case 5: 
          localamo.DnI = ((f.a.a.a.a)localObject1).KhF.fHu();
          AppMethodBeat.o(122493);
          return 0;
        }
        localamo.timestamp = ((f.a.a.a.a)localObject1).KhF.xT();
        AppMethodBeat.o(122493);
        return 0;
      }
      AppMethodBeat.o(122493);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.amo
 * JD-Core Version:    0.7.0.1
 */