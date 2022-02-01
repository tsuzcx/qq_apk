package com.tencent.mm.protocal.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.arf;
import com.tencent.mm.protocal.protobuf.arp;
import java.util.LinkedList;

public final class c
  extends com.tencent.mm.bx.a
{
  public String NAa;
  public arp YzK;
  public String desc;
  public LinkedList<arf> nUC;
  public String title;
  public long ygh;
  
  public c()
  {
    AppMethodBeat.i(94808);
    this.nUC = new LinkedList();
    AppMethodBeat.o(94808);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(94809);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.title != null) {
        paramVarArgs.g(1, this.title);
      }
      if (this.desc != null) {
        paramVarArgs.g(2, this.desc);
      }
      paramVarArgs.e(3, 8, this.nUC);
      if (this.NAa != null) {
        paramVarArgs.g(4, this.NAa);
      }
      if (this.YzK != null)
      {
        paramVarArgs.qD(5, this.YzK.computeSize());
        this.YzK.writeFields(paramVarArgs);
      }
      paramVarArgs.bv(6, this.ygh);
      AppMethodBeat.o(94809);
      return 0;
    }
    if (paramInt == 1) {
      if (this.title == null) {
        break label630;
      }
    }
    label630:
    for (paramInt = i.a.a.b.b.a.h(1, this.title) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.desc != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.desc);
      }
      i += i.a.a.a.c(3, 8, this.nUC);
      paramInt = i;
      if (this.NAa != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.NAa);
      }
      i = paramInt;
      if (this.YzK != null) {
        i = paramInt + i.a.a.a.qC(5, this.YzK.computeSize());
      }
      paramInt = i.a.a.b.b.a.q(6, this.ygh);
      AppMethodBeat.o(94809);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.nUC.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(94809);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        c localc = (c)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(94809);
          return -1;
        case 1: 
          localc.title = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(94809);
          return 0;
        case 2: 
          localc.desc = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(94809);
          return 0;
        case 3: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new arf();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((arf)localObject2).parseFrom((byte[])localObject1);
            }
            localc.nUC.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(94809);
          return 0;
        case 4: 
          localc.NAa = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(94809);
          return 0;
        case 5: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new arp();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((arp)localObject2).parseFrom((byte[])localObject1);
            }
            localc.YzK = ((arp)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(94809);
          return 0;
        }
        localc.ygh = ((i.a.a.a.a)localObject1).ajGk.aaw();
        AppMethodBeat.o(94809);
        return 0;
      }
      AppMethodBeat.o(94809);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.b.a.c
 * JD-Core Version:    0.7.0.1
 */