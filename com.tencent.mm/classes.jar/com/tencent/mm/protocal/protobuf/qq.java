package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class qq
  extends com.tencent.mm.bx.a
{
  public LinkedList<pt> YSB;
  public String YSD;
  public long YVJ;
  public String YVK;
  public int bcb;
  
  public qq()
  {
    AppMethodBeat.i(257914);
    this.YSB = new LinkedList();
    AppMethodBeat.o(257914);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(257921);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bv(1, this.YVJ);
      paramVarArgs.e(2, 8, this.YSB);
      paramVarArgs.bS(3, this.bcb);
      if (this.YSD != null) {
        paramVarArgs.g(4, this.YSD);
      }
      if (this.YVK != null) {
        paramVarArgs.g(5, this.YVK);
      }
      AppMethodBeat.o(257921);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.b.b.a.q(1, this.YVJ) + 0 + i.a.a.a.c(2, 8, this.YSB) + i.a.a.b.b.a.cJ(3, this.bcb);
      paramInt = i;
      if (this.YSD != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.YSD);
      }
      i = paramInt;
      if (this.YVK != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.YVK);
      }
      AppMethodBeat.o(257921);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.YSB.clear();
      paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(257921);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (i.a.a.a.a)paramVarArgs[0];
      qq localqq = (qq)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(257921);
        return -1;
      case 1: 
        localqq.YVJ = ((i.a.a.a.a)localObject).ajGk.aaw();
        AppMethodBeat.o(257921);
        return 0;
      case 2: 
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          pt localpt = new pt();
          if ((localObject != null) && (localObject.length > 0)) {
            localpt.parseFrom((byte[])localObject);
          }
          localqq.YSB.add(localpt);
          paramInt += 1;
        }
        AppMethodBeat.o(257921);
        return 0;
      case 3: 
        localqq.bcb = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(257921);
        return 0;
      case 4: 
        localqq.YSD = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(257921);
        return 0;
      }
      localqq.YVK = ((i.a.a.a.a)localObject).ajGk.readString();
      AppMethodBeat.o(257921);
      return 0;
    }
    AppMethodBeat.o(257921);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.qq
 * JD-Core Version:    0.7.0.1
 */