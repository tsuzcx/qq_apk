package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bwe
  extends com.tencent.mm.bx.a
{
  public LinkedList<bwa> ZLJ;
  public LinkedList<bwc> aadF;
  public LinkedList<Long> aaeh;
  public LinkedList<bmz> aaei;
  
  public bwe()
  {
    AppMethodBeat.i(258742);
    this.aadF = new LinkedList();
    this.ZLJ = new LinkedList();
    this.aaeh = new LinkedList();
    this.aaei = new LinkedList();
    AppMethodBeat.o(258742);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258743);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 8, this.aadF);
      paramVarArgs.e(2, 8, this.ZLJ);
      paramVarArgs.e(3, 3, this.aaeh);
      paramVarArgs.e(4, 8, this.aaei);
      AppMethodBeat.o(258743);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = i.a.a.a.c(1, 8, this.aadF);
      i = i.a.a.a.c(2, 8, this.ZLJ);
      int j = i.a.a.a.c(3, 3, this.aaeh);
      int k = i.a.a.a.c(4, 8, this.aaei);
      AppMethodBeat.o(258743);
      return paramInt + 0 + i + j + k;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.aadF.clear();
      this.ZLJ.clear();
      this.aaeh.clear();
      this.aaei.clear();
      paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(258743);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
      bwe localbwe = (bwe)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(258743);
        return -1;
      case 1: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new bwc();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((bwc)localObject2).parseFrom((byte[])localObject1);
          }
          localbwe.aadF.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(258743);
        return 0;
      case 2: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new bwa();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((bwa)localObject2).parseFrom((byte[])localObject1);
          }
          localbwe.ZLJ.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(258743);
        return 0;
      case 3: 
        localbwe.aaeh.add(Long.valueOf(((i.a.a.a.a)localObject1).ajGk.aaw()));
        AppMethodBeat.o(258743);
        return 0;
      }
      paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject1 = (byte[])paramVarArgs.get(paramInt);
        localObject2 = new bmz();
        if ((localObject1 != null) && (localObject1.length > 0)) {
          ((bmz)localObject2).parseFrom((byte[])localObject1);
        }
        localbwe.aaei.add(localObject2);
        paramInt += 1;
      }
      AppMethodBeat.o(258743);
      return 0;
    }
    AppMethodBeat.o(258743);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bwe
 * JD-Core Version:    0.7.0.1
 */