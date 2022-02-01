package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class ewn
  extends com.tencent.mm.bx.a
{
  public gol YJA;
  public gol YJB;
  public all YJh;
  public gol YJi;
  public gol YJj;
  public int YJx;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(133194);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.YJj == null)
      {
        paramVarArgs = new b("Not all required fields were included: AutoAuthKey");
        AppMethodBeat.o(133194);
        throw paramVarArgs;
      }
      if (this.YJh == null)
      {
        paramVarArgs = new b("Not all required fields were included: SvrPubECDHKey");
        AppMethodBeat.o(133194);
        throw paramVarArgs;
      }
      if (this.YJi == null)
      {
        paramVarArgs = new b("Not all required fields were included: SessionKey");
        AppMethodBeat.o(133194);
        throw paramVarArgs;
      }
      if (this.YJj != null)
      {
        paramVarArgs.qD(1, this.YJj.computeSize());
        this.YJj.writeFields(paramVarArgs);
      }
      if (this.YJh != null)
      {
        paramVarArgs.qD(2, this.YJh.computeSize());
        this.YJh.writeFields(paramVarArgs);
      }
      if (this.YJi != null)
      {
        paramVarArgs.qD(3, this.YJi.computeSize());
        this.YJi.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(4, this.YJx);
      if (this.YJA != null)
      {
        paramVarArgs.qD(5, this.YJA.computeSize());
        this.YJA.writeFields(paramVarArgs);
      }
      if (this.YJB != null)
      {
        paramVarArgs.qD(6, this.YJB.computeSize());
        this.YJB.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(133194);
      return 0;
    }
    if (paramInt == 1) {
      if (this.YJj == null) {
        break label1004;
      }
    }
    label1004:
    for (int i = i.a.a.a.qC(1, this.YJj.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.YJh != null) {
        paramInt = i + i.a.a.a.qC(2, this.YJh.computeSize());
      }
      i = paramInt;
      if (this.YJi != null) {
        i = paramInt + i.a.a.a.qC(3, this.YJi.computeSize());
      }
      i += i.a.a.b.b.a.cJ(4, this.YJx);
      paramInt = i;
      if (this.YJA != null) {
        paramInt = i + i.a.a.a.qC(5, this.YJA.computeSize());
      }
      i = paramInt;
      if (this.YJB != null) {
        i = paramInt + i.a.a.a.qC(6, this.YJB.computeSize());
      }
      AppMethodBeat.o(133194);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.YJj == null)
        {
          paramVarArgs = new b("Not all required fields were included: AutoAuthKey");
          AppMethodBeat.o(133194);
          throw paramVarArgs;
        }
        if (this.YJh == null)
        {
          paramVarArgs = new b("Not all required fields were included: SvrPubECDHKey");
          AppMethodBeat.o(133194);
          throw paramVarArgs;
        }
        if (this.YJi == null)
        {
          paramVarArgs = new b("Not all required fields were included: SessionKey");
          AppMethodBeat.o(133194);
          throw paramVarArgs;
        }
        AppMethodBeat.o(133194);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        ewn localewn = (ewn)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(133194);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new gol();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((gol)localObject2).dg((byte[])localObject1);
            }
            localewn.YJj = ((gol)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(133194);
          return 0;
        case 2: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new all();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((all)localObject2).parseFrom((byte[])localObject1);
            }
            localewn.YJh = ((all)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(133194);
          return 0;
        case 3: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new gol();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((gol)localObject2).dg((byte[])localObject1);
            }
            localewn.YJi = ((gol)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(133194);
          return 0;
        case 4: 
          localewn.YJx = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(133194);
          return 0;
        case 5: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new gol();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((gol)localObject2).dg((byte[])localObject1);
            }
            localewn.YJA = ((gol)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(133194);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new gol();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((gol)localObject2).dg((byte[])localObject1);
          }
          localewn.YJB = ((gol)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(133194);
        return 0;
      }
      AppMethodBeat.o(133194);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ewn
 * JD-Core Version:    0.7.0.1
 */