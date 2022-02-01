package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cip
  extends com.tencent.mm.bx.a
{
  public int YWM;
  public erm aard;
  public djr aare;
  public int aarf;
  public boolean aarg;
  public boolean aarh;
  public int aari;
  public String xlz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(175244);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.aard != null)
      {
        paramVarArgs.qD(1, this.aard.computeSize());
        this.aard.writeFields(paramVarArgs);
      }
      if (this.aare != null)
      {
        paramVarArgs.qD(2, this.aare.computeSize());
        this.aare.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(3, this.aarf);
      paramVarArgs.bS(4, this.YWM);
      paramVarArgs.di(5, this.aarg);
      paramVarArgs.di(6, this.aarh);
      paramVarArgs.bS(7, this.aari);
      if (this.xlz != null) {
        paramVarArgs.g(8, this.xlz);
      }
      AppMethodBeat.o(175244);
      return 0;
    }
    if (paramInt == 1) {
      if (this.aard == null) {
        break label690;
      }
    }
    label690:
    for (paramInt = i.a.a.a.qC(1, this.aard.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.aare != null) {
        i = paramInt + i.a.a.a.qC(2, this.aare.computeSize());
      }
      i = i + i.a.a.b.b.a.cJ(3, this.aarf) + i.a.a.b.b.a.cJ(4, this.YWM) + (i.a.a.b.b.a.ko(5) + 1) + (i.a.a.b.b.a.ko(6) + 1) + i.a.a.b.b.a.cJ(7, this.aari);
      paramInt = i;
      if (this.xlz != null) {
        paramInt = i + i.a.a.b.b.a.h(8, this.xlz);
      }
      AppMethodBeat.o(175244);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(175244);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        cip localcip = (cip)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(175244);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new erm();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((erm)localObject2).parseFrom((byte[])localObject1);
            }
            localcip.aard = ((erm)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(175244);
          return 0;
        case 2: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new djr();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((djr)localObject2).parseFrom((byte[])localObject1);
            }
            localcip.aare = ((djr)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(175244);
          return 0;
        case 3: 
          localcip.aarf = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(175244);
          return 0;
        case 4: 
          localcip.YWM = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(175244);
          return 0;
        case 5: 
          localcip.aarg = ((i.a.a.a.a)localObject1).ajGk.aai();
          AppMethodBeat.o(175244);
          return 0;
        case 6: 
          localcip.aarh = ((i.a.a.a.a)localObject1).ajGk.aai();
          AppMethodBeat.o(175244);
          return 0;
        case 7: 
          localcip.aari = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(175244);
          return 0;
        }
        localcip.xlz = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(175244);
        return 0;
      }
      AppMethodBeat.o(175244);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cip
 * JD-Core Version:    0.7.0.1
 */