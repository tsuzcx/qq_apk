package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class sg
  extends com.tencent.mm.bx.a
{
  public String OiL;
  public LinkedList<asm> YXg;
  public LinkedList<asl> YXh;
  public String YXi;
  public String YXj;
  
  public sg()
  {
    AppMethodBeat.i(91368);
    this.YXg = new LinkedList();
    this.YXh = new LinkedList();
    AppMethodBeat.o(91368);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91369);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 8, this.YXg);
      paramVarArgs.e(2, 8, this.YXh);
      if (this.YXi != null) {
        paramVarArgs.g(3, this.YXi);
      }
      if (this.OiL != null) {
        paramVarArgs.g(4, this.OiL);
      }
      if (this.YXj != null) {
        paramVarArgs.g(5, this.YXj);
      }
      AppMethodBeat.o(91369);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.a.c(1, 8, this.YXg) + 0 + i.a.a.a.c(2, 8, this.YXh);
      paramInt = i;
      if (this.YXi != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.YXi);
      }
      i = paramInt;
      if (this.OiL != null) {
        i = paramInt + i.a.a.b.b.a.h(4, this.OiL);
      }
      paramInt = i;
      if (this.YXj != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.YXj);
      }
      AppMethodBeat.o(91369);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.YXg.clear();
      this.YXh.clear();
      paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(91369);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
      sg localsg = (sg)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(91369);
        return -1;
      case 1: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new asm();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((asm)localObject2).parseFrom((byte[])localObject1);
          }
          localsg.YXg.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(91369);
        return 0;
      case 2: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new asl();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((asl)localObject2).parseFrom((byte[])localObject1);
          }
          localsg.YXh.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(91369);
        return 0;
      case 3: 
        localsg.YXi = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(91369);
        return 0;
      case 4: 
        localsg.OiL = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(91369);
        return 0;
      }
      localsg.YXj = ((i.a.a.a.a)localObject1).ajGk.readString();
      AppMethodBeat.o(91369);
      return 0;
    }
    AppMethodBeat.o(91369);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.sg
 * JD-Core Version:    0.7.0.1
 */