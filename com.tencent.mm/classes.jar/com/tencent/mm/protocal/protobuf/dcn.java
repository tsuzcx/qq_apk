package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dcn
  extends com.tencent.mm.bx.a
{
  public String MRG;
  public int aaIs;
  public String aaIt;
  public LinkedList<dcz> aaIu;
  public LinkedList<ddd> aaIv;
  
  public dcn()
  {
    AppMethodBeat.i(259200);
    this.aaIu = new LinkedList();
    this.aaIv = new LinkedList();
    AppMethodBeat.o(259200);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259205);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.aaIs);
      if (this.MRG != null) {
        paramVarArgs.g(2, this.MRG);
      }
      if (this.aaIt != null) {
        paramVarArgs.g(3, this.aaIt);
      }
      paramVarArgs.e(4, 8, this.aaIu);
      paramVarArgs.e(5, 8, this.aaIv);
      AppMethodBeat.o(259205);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.b.b.a.cJ(1, this.aaIs) + 0;
      paramInt = i;
      if (this.MRG != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.MRG);
      }
      i = paramInt;
      if (this.aaIt != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.aaIt);
      }
      paramInt = i.a.a.a.c(4, 8, this.aaIu);
      int j = i.a.a.a.c(5, 8, this.aaIv);
      AppMethodBeat.o(259205);
      return i + paramInt + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.aaIu.clear();
      this.aaIv.clear();
      paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(259205);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
      dcn localdcn = (dcn)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(259205);
        return -1;
      case 1: 
        localdcn.aaIs = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(259205);
        return 0;
      case 2: 
        localdcn.MRG = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(259205);
        return 0;
      case 3: 
        localdcn.aaIt = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(259205);
        return 0;
      case 4: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new dcz();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((dcz)localObject2).parseFrom((byte[])localObject1);
          }
          localdcn.aaIu.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(259205);
        return 0;
      }
      paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject1 = (byte[])paramVarArgs.get(paramInt);
        localObject2 = new ddd();
        if ((localObject1 != null) && (localObject1.length > 0)) {
          ((ddd)localObject2).parseFrom((byte[])localObject1);
        }
        localdcn.aaIv.add(localObject2);
        paramInt += 1;
      }
      AppMethodBeat.o(259205);
      return 0;
    }
    AppMethodBeat.o(259205);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dcn
 * JD-Core Version:    0.7.0.1
 */