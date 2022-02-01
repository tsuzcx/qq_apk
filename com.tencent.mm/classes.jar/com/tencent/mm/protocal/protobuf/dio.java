package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dio
  extends com.tencent.mm.bx.a
{
  public LinkedList<dip> DRp;
  public boolean jEE;
  public int jEF;
  public int jEG;
  public String jEH;
  public String jEI;
  public String jEJ;
  public String jEK;
  
  public dio()
  {
    AppMethodBeat.i(123670);
    this.DRp = new LinkedList();
    AppMethodBeat.o(123670);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123671);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 8, this.DRp);
      paramVarArgs.bg(2, this.jEE);
      paramVarArgs.aR(3, this.jEF);
      paramVarArgs.aR(4, this.jEG);
      if (this.jEH != null) {
        paramVarArgs.d(5, this.jEH);
      }
      if (this.jEI != null) {
        paramVarArgs.d(6, this.jEI);
      }
      if (this.jEJ != null) {
        paramVarArgs.d(7, this.jEJ);
      }
      if (this.jEK != null) {
        paramVarArgs.d(8, this.jEK);
      }
      AppMethodBeat.o(123671);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.a.c(1, 8, this.DRp) + 0 + (f.a.a.b.b.a.fY(2) + 1) + f.a.a.b.b.a.bA(3, this.jEF) + f.a.a.b.b.a.bA(4, this.jEG);
      paramInt = i;
      if (this.jEH != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.jEH);
      }
      i = paramInt;
      if (this.jEI != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.jEI);
      }
      paramInt = i;
      if (this.jEJ != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.jEJ);
      }
      i = paramInt;
      if (this.jEK != null) {
        i = paramInt + f.a.a.b.b.a.e(8, this.jEK);
      }
      AppMethodBeat.o(123671);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.DRp.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      AppMethodBeat.o(123671);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      dio localdio = (dio)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(123671);
        return -1;
      case 1: 
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dip();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((dip)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdio.DRp.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(123671);
        return 0;
      case 2: 
        localdio.jEE = ((f.a.a.a.a)localObject1).KhF.fHu();
        AppMethodBeat.o(123671);
        return 0;
      case 3: 
        localdio.jEF = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(123671);
        return 0;
      case 4: 
        localdio.jEG = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(123671);
        return 0;
      case 5: 
        localdio.jEH = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(123671);
        return 0;
      case 6: 
        localdio.jEI = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(123671);
        return 0;
      case 7: 
        localdio.jEJ = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(123671);
        return 0;
      }
      localdio.jEK = ((f.a.a.a.a)localObject1).KhF.readString();
      AppMethodBeat.o(123671);
      return 0;
    }
    AppMethodBeat.o(123671);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dio
 * JD-Core Version:    0.7.0.1
 */