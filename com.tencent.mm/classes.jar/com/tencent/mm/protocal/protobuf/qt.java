package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class qt
  extends com.tencent.mm.bx.a
{
  public String CQD;
  public int CQE;
  public String CQF;
  public rc CQG;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(113956);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.CQD != null) {
        paramVarArgs.d(1, this.CQD);
      }
      paramVarArgs.aR(2, this.CQE);
      if (this.CQF != null) {
        paramVarArgs.d(3, this.CQF);
      }
      if (this.CQG != null)
      {
        paramVarArgs.kX(4, this.CQG.computeSize());
        this.CQG.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(113956);
      return 0;
    }
    if (paramInt == 1) {
      if (this.CQD == null) {
        break label474;
      }
    }
    label474:
    for (paramInt = f.a.a.b.b.a.e(1, this.CQD) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bA(2, this.CQE);
      paramInt = i;
      if (this.CQF != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.CQF);
      }
      i = paramInt;
      if (this.CQG != null) {
        i = paramInt + f.a.a.a.kW(4, this.CQG.computeSize());
      }
      AppMethodBeat.o(113956);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(113956);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        qt localqt = (qt)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(113956);
          return -1;
        case 1: 
          localqt.CQD = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(113956);
          return 0;
        case 2: 
          localqt.CQE = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(113956);
          return 0;
        case 3: 
          localqt.CQF = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(113956);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new rc();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((rc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localqt.CQG = ((rc)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(113956);
        return 0;
      }
      AppMethodBeat.o(113956);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.qt
 * JD-Core Version:    0.7.0.1
 */