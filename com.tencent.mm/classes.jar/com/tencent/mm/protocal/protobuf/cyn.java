package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cyn
  extends com.tencent.mm.bx.a
{
  public int DJF;
  public long DNs;
  public int DNw;
  public int EqE;
  public cyl EqF;
  public String EqG;
  public boolean EqH;
  public String gKn;
  public int gll;
  public String md5;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(118455);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.gKn != null) {
        paramVarArgs.d(1, this.gKn);
      }
      paramVarArgs.aR(2, this.gll);
      paramVarArgs.aG(3, this.DNs);
      paramVarArgs.aR(4, this.DNw);
      if (this.md5 != null) {
        paramVarArgs.d(5, this.md5);
      }
      paramVarArgs.aR(6, this.DJF);
      paramVarArgs.aR(7, this.EqE);
      if (this.EqF != null)
      {
        paramVarArgs.kX(8, this.EqF.computeSize());
        this.EqF.writeFields(paramVarArgs);
      }
      if (this.EqG != null) {
        paramVarArgs.d(9, this.EqG);
      }
      paramVarArgs.bg(10, this.EqH);
      AppMethodBeat.o(118455);
      return 0;
    }
    if (paramInt == 1) {
      if (this.gKn == null) {
        break label758;
      }
    }
    label758:
    for (paramInt = f.a.a.b.b.a.e(1, this.gKn) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bA(2, this.gll) + f.a.a.b.b.a.q(3, this.DNs) + f.a.a.b.b.a.bA(4, this.DNw);
      paramInt = i;
      if (this.md5 != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.md5);
      }
      i = paramInt + f.a.a.b.b.a.bA(6, this.DJF) + f.a.a.b.b.a.bA(7, this.EqE);
      paramInt = i;
      if (this.EqF != null) {
        paramInt = i + f.a.a.a.kW(8, this.EqF.computeSize());
      }
      i = paramInt;
      if (this.EqG != null) {
        i = paramInt + f.a.a.b.b.a.e(9, this.EqG);
      }
      paramInt = f.a.a.b.b.a.fY(10);
      AppMethodBeat.o(118455);
      return i + (paramInt + 1);
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(118455);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cyn localcyn = (cyn)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(118455);
          return -1;
        case 1: 
          localcyn.gKn = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(118455);
          return 0;
        case 2: 
          localcyn.gll = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(118455);
          return 0;
        case 3: 
          localcyn.DNs = ((f.a.a.a.a)localObject1).KhF.xT();
          AppMethodBeat.o(118455);
          return 0;
        case 4: 
          localcyn.DNw = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(118455);
          return 0;
        case 5: 
          localcyn.md5 = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(118455);
          return 0;
        case 6: 
          localcyn.DJF = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(118455);
          return 0;
        case 7: 
          localcyn.EqE = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(118455);
          return 0;
        case 8: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cyl();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((cyl)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcyn.EqF = ((cyl)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(118455);
          return 0;
        case 9: 
          localcyn.EqG = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(118455);
          return 0;
        }
        localcyn.EqH = ((f.a.a.a.a)localObject1).KhF.fHu();
        AppMethodBeat.o(118455);
        return 0;
      }
      AppMethodBeat.o(118455);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cyn
 * JD-Core Version:    0.7.0.1
 */