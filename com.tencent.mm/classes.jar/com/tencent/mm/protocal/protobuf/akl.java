package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class akl
  extends com.tencent.mm.bx.a
{
  public int ZrC;
  public String ZrD;
  public String ZrE;
  public int ZrF;
  public int ZrG;
  public int ZrH;
  public fzo ZrI;
  public int ZrJ;
  public LinkedList<gbc> ZrK;
  public int ZrL;
  public int ZrM;
  
  public akl()
  {
    AppMethodBeat.i(115835);
    this.ZrK = new LinkedList();
    AppMethodBeat.o(115835);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(115836);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.ZrC);
      if (this.ZrD != null) {
        paramVarArgs.g(2, this.ZrD);
      }
      if (this.ZrE != null) {
        paramVarArgs.g(3, this.ZrE);
      }
      paramVarArgs.bS(4, this.ZrF);
      paramVarArgs.bS(5, this.ZrG);
      paramVarArgs.bS(6, this.ZrH);
      if (this.ZrI != null)
      {
        paramVarArgs.qD(7, this.ZrI.computeSize());
        this.ZrI.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(8, this.ZrJ);
      paramVarArgs.e(9, 8, this.ZrK);
      paramVarArgs.bS(10, this.ZrL);
      paramVarArgs.bS(11, this.ZrM);
      AppMethodBeat.o(115836);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.b.b.a.cJ(1, this.ZrC) + 0;
      paramInt = i;
      if (this.ZrD != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.ZrD);
      }
      i = paramInt;
      if (this.ZrE != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.ZrE);
      }
      i = i + i.a.a.b.b.a.cJ(4, this.ZrF) + i.a.a.b.b.a.cJ(5, this.ZrG) + i.a.a.b.b.a.cJ(6, this.ZrH);
      paramInt = i;
      if (this.ZrI != null) {
        paramInt = i + i.a.a.a.qC(7, this.ZrI.computeSize());
      }
      i = i.a.a.b.b.a.cJ(8, this.ZrJ);
      int j = i.a.a.a.c(9, 8, this.ZrK);
      int k = i.a.a.b.b.a.cJ(10, this.ZrL);
      int m = i.a.a.b.b.a.cJ(11, this.ZrM);
      AppMethodBeat.o(115836);
      return paramInt + i + j + k + m;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.ZrK.clear();
      paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(115836);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
      akl localakl = (akl)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(115836);
        return -1;
      case 1: 
        localakl.ZrC = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(115836);
        return 0;
      case 2: 
        localakl.ZrD = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(115836);
        return 0;
      case 3: 
        localakl.ZrE = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(115836);
        return 0;
      case 4: 
        localakl.ZrF = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(115836);
        return 0;
      case 5: 
        localakl.ZrG = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(115836);
        return 0;
      case 6: 
        localakl.ZrH = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(115836);
        return 0;
      case 7: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new fzo();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((fzo)localObject2).parseFrom((byte[])localObject1);
          }
          localakl.ZrI = ((fzo)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(115836);
        return 0;
      case 8: 
        localakl.ZrJ = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(115836);
        return 0;
      case 9: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new gbc();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((gbc)localObject2).parseFrom((byte[])localObject1);
          }
          localakl.ZrK.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(115836);
        return 0;
      case 10: 
        localakl.ZrL = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(115836);
        return 0;
      }
      localakl.ZrM = ((i.a.a.a.a)localObject1).ajGk.aar();
      AppMethodBeat.o(115836);
      return 0;
    }
    AppMethodBeat.o(115836);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.akl
 * JD-Core Version:    0.7.0.1
 */