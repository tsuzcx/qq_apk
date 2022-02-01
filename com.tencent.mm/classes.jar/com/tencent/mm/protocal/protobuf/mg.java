package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class mg
  extends com.tencent.mm.bx.a
{
  public long YNA;
  public LinkedList<me> YNB;
  public boolean YNC;
  public long YNz;
  public long uin;
  
  public mg()
  {
    AppMethodBeat.i(110888);
    this.YNB = new LinkedList();
    this.YNC = false;
    AppMethodBeat.o(110888);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(110889);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bv(1, this.YNz);
      paramVarArgs.bv(2, this.uin);
      paramVarArgs.bv(3, this.YNA);
      paramVarArgs.e(4, 8, this.YNB);
      paramVarArgs.di(5, this.YNC);
      AppMethodBeat.o(110889);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = i.a.a.b.b.a.q(1, this.YNz);
      i = i.a.a.b.b.a.q(2, this.uin);
      int j = i.a.a.b.b.a.q(3, this.YNA);
      int k = i.a.a.a.c(4, 8, this.YNB);
      int m = i.a.a.b.b.a.ko(5);
      AppMethodBeat.o(110889);
      return paramInt + 0 + i + j + k + (m + 1);
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.YNB.clear();
      paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(110889);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (i.a.a.a.a)paramVarArgs[0];
      mg localmg = (mg)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(110889);
        return -1;
      case 1: 
        localmg.YNz = ((i.a.a.a.a)localObject).ajGk.aaw();
        AppMethodBeat.o(110889);
        return 0;
      case 2: 
        localmg.uin = ((i.a.a.a.a)localObject).ajGk.aaw();
        AppMethodBeat.o(110889);
        return 0;
      case 3: 
        localmg.YNA = ((i.a.a.a.a)localObject).ajGk.aaw();
        AppMethodBeat.o(110889);
        return 0;
      case 4: 
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          me localme = new me();
          if ((localObject != null) && (localObject.length > 0)) {
            localme.parseFrom((byte[])localObject);
          }
          localmg.YNB.add(localme);
          paramInt += 1;
        }
        AppMethodBeat.o(110889);
        return 0;
      }
      localmg.YNC = ((i.a.a.a.a)localObject).ajGk.aai();
      AppMethodBeat.o(110889);
      return 0;
    }
    AppMethodBeat.o(110889);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.mg
 * JD-Core Version:    0.7.0.1
 */