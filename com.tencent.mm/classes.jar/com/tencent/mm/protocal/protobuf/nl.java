package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class nl
  extends com.tencent.mm.bx.a
{
  public int YPp;
  public GoodsObject YPq;
  public float YPr;
  public String hMy;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258944);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.YPp);
      if (this.YPq != null)
      {
        paramVarArgs.qD(2, this.YPq.computeSize());
        this.YPq.writeFields(paramVarArgs);
      }
      paramVarArgs.l(3, this.YPr);
      if (this.hMy != null) {
        paramVarArgs.g(4, this.hMy);
      }
      AppMethodBeat.o(258944);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.b.b.a.cJ(1, this.YPp) + 0;
      paramInt = i;
      if (this.YPq != null) {
        paramInt = i + i.a.a.a.qC(2, this.YPq.computeSize());
      }
      i = paramInt + (i.a.a.b.b.a.ko(3) + 4);
      paramInt = i;
      if (this.hMy != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.hMy);
      }
      AppMethodBeat.o(258944);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(258944);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (i.a.a.a.a)paramVarArgs[0];
      nl localnl = (nl)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(258944);
        return -1;
      case 1: 
        localnl.YPp = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(258944);
        return 0;
      case 2: 
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          GoodsObject localGoodsObject = new GoodsObject();
          if ((localObject != null) && (localObject.length > 0)) {
            localGoodsObject.parseFrom((byte[])localObject);
          }
          localnl.YPq = localGoodsObject;
          paramInt += 1;
        }
        AppMethodBeat.o(258944);
        return 0;
      case 3: 
        localnl.YPr = Float.intBitsToFloat(((i.a.a.a.a)localObject).ajGk.aax());
        AppMethodBeat.o(258944);
        return 0;
      }
      localnl.hMy = ((i.a.a.a.a)localObject).ajGk.readString();
      AppMethodBeat.o(258944);
      return 0;
    }
    AppMethodBeat.o(258944);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.nl
 * JD-Core Version:    0.7.0.1
 */