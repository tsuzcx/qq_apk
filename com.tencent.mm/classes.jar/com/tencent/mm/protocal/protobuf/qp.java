package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class qp
  extends com.tencent.mm.bx.a
{
  public int YFu;
  public LinkedList<qo> YSB;
  public long YVJ;
  public String hAP;
  
  public qp()
  {
    AppMethodBeat.i(257939);
    this.YSB = new LinkedList();
    AppMethodBeat.o(257939);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(257943);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.YFu);
      if (this.hAP != null) {
        paramVarArgs.g(2, this.hAP);
      }
      paramVarArgs.e(3, 8, this.YSB);
      paramVarArgs.bv(4, this.YVJ);
      AppMethodBeat.o(257943);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.b.b.a.cJ(1, this.YFu) + 0;
      paramInt = i;
      if (this.hAP != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.hAP);
      }
      i = i.a.a.a.c(3, 8, this.YSB);
      int j = i.a.a.b.b.a.q(4, this.YVJ);
      AppMethodBeat.o(257943);
      return paramInt + i + j;
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
      AppMethodBeat.o(257943);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (i.a.a.a.a)paramVarArgs[0];
      qp localqp = (qp)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(257943);
        return -1;
      case 1: 
        localqp.YFu = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(257943);
        return 0;
      case 2: 
        localqp.hAP = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(257943);
        return 0;
      case 3: 
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          qo localqo = new qo();
          if ((localObject != null) && (localObject.length > 0)) {
            localqo.parseFrom((byte[])localObject);
          }
          localqp.YSB.add(localqo);
          paramInt += 1;
        }
        AppMethodBeat.o(257943);
        return 0;
      }
      localqp.YVJ = ((i.a.a.a.a)localObject).ajGk.aaw();
      AppMethodBeat.o(257943);
      return 0;
    }
    AppMethodBeat.o(257943);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.qp
 * JD-Core Version:    0.7.0.1
 */