package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class rf
  extends com.tencent.mm.bx.a
{
  public int YWd;
  public LinkedList<rg> YWe;
  public int type;
  public int uin;
  public int update_time;
  public int version;
  
  public rf()
  {
    AppMethodBeat.i(124455);
    this.YWe = new LinkedList();
    AppMethodBeat.o(124455);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124456);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.uin);
      paramVarArgs.bS(2, this.YWd);
      paramVarArgs.bS(3, this.update_time);
      paramVarArgs.e(4, 8, this.YWe);
      paramVarArgs.bS(5, this.version);
      paramVarArgs.bS(6, this.type);
      AppMethodBeat.o(124456);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = i.a.a.b.b.a.cJ(1, this.uin);
      i = i.a.a.b.b.a.cJ(2, this.YWd);
      int j = i.a.a.b.b.a.cJ(3, this.update_time);
      int k = i.a.a.a.c(4, 8, this.YWe);
      int m = i.a.a.b.b.a.cJ(5, this.version);
      int n = i.a.a.b.b.a.cJ(6, this.type);
      AppMethodBeat.o(124456);
      return paramInt + 0 + i + j + k + m + n;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.YWe.clear();
      paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(124456);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (i.a.a.a.a)paramVarArgs[0];
      rf localrf = (rf)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(124456);
        return -1;
      case 1: 
        localrf.uin = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(124456);
        return 0;
      case 2: 
        localrf.YWd = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(124456);
        return 0;
      case 3: 
        localrf.update_time = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(124456);
        return 0;
      case 4: 
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          rg localrg = new rg();
          if ((localObject != null) && (localObject.length > 0)) {
            localrg.parseFrom((byte[])localObject);
          }
          localrf.YWe.add(localrg);
          paramInt += 1;
        }
        AppMethodBeat.o(124456);
        return 0;
      case 5: 
        localrf.version = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(124456);
        return 0;
      }
      localrf.type = ((i.a.a.a.a)localObject).ajGk.aar();
      AppMethodBeat.o(124456);
      return 0;
    }
    AppMethodBeat.o(124456);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.rf
 * JD-Core Version:    0.7.0.1
 */