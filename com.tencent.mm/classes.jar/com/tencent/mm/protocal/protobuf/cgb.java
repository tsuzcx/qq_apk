package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cgb
  extends com.tencent.mm.bw.a
{
  public String Fui;
  public String Fuj;
  public LinkedList<dhg> Fuk;
  
  public cgb()
  {
    AppMethodBeat.i(72550);
    this.Fuk = new LinkedList();
    AppMethodBeat.o(72550);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72551);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Fui != null) {
        paramVarArgs.d(1, this.Fui);
      }
      if (this.Fuj != null) {
        paramVarArgs.d(2, this.Fuj);
      }
      paramVarArgs.e(3, 8, this.Fuk);
      AppMethodBeat.o(72551);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Fui == null) {
        break label418;
      }
    }
    label418:
    for (paramInt = f.a.a.b.b.a.e(1, this.Fui) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Fuj != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.Fuj);
      }
      paramInt = f.a.a.a.c(3, 8, this.Fuk);
      AppMethodBeat.o(72551);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Fuk.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(72551);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cgb localcgb = (cgb)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72551);
          return -1;
        case 1: 
          localcgb.Fui = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(72551);
          return 0;
        case 2: 
          localcgb.Fuj = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(72551);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dhg();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((dhg)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localcgb.Fuk.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(72551);
        return 0;
      }
      AppMethodBeat.o(72551);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cgb
 * JD-Core Version:    0.7.0.1
 */