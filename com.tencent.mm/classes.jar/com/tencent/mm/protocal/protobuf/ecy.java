package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class ecy
  extends com.tencent.mm.cd.a
{
  public aiq RLT;
  public eae RLU;
  public eae RLV;
  public int RMj;
  public eae RMm;
  public eae RMn;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(133194);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.RLV == null)
      {
        paramVarArgs = new b("Not all required fields were included: AutoAuthKey");
        AppMethodBeat.o(133194);
        throw paramVarArgs;
      }
      if (this.RLT == null)
      {
        paramVarArgs = new b("Not all required fields were included: SvrPubECDHKey");
        AppMethodBeat.o(133194);
        throw paramVarArgs;
      }
      if (this.RLU == null)
      {
        paramVarArgs = new b("Not all required fields were included: SessionKey");
        AppMethodBeat.o(133194);
        throw paramVarArgs;
      }
      if (this.RLV != null)
      {
        paramVarArgs.oE(1, this.RLV.computeSize());
        this.RLV.writeFields(paramVarArgs);
      }
      if (this.RLT != null)
      {
        paramVarArgs.oE(2, this.RLT.computeSize());
        this.RLT.writeFields(paramVarArgs);
      }
      if (this.RLU != null)
      {
        paramVarArgs.oE(3, this.RLU.computeSize());
        this.RLU.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(4, this.RMj);
      if (this.RMm != null)
      {
        paramVarArgs.oE(5, this.RMm.computeSize());
        this.RMm.writeFields(paramVarArgs);
      }
      if (this.RMn != null)
      {
        paramVarArgs.oE(6, this.RMn.computeSize());
        this.RMn.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(133194);
      return 0;
    }
    if (paramInt == 1) {
      if (this.RLV == null) {
        break label1008;
      }
    }
    label1008:
    for (int i = g.a.a.a.oD(1, this.RLV.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.RLT != null) {
        paramInt = i + g.a.a.a.oD(2, this.RLT.computeSize());
      }
      i = paramInt;
      if (this.RLU != null) {
        i = paramInt + g.a.a.a.oD(3, this.RLU.computeSize());
      }
      i += g.a.a.b.b.a.bM(4, this.RMj);
      paramInt = i;
      if (this.RMm != null) {
        paramInt = i + g.a.a.a.oD(5, this.RMm.computeSize());
      }
      i = paramInt;
      if (this.RMn != null) {
        i = paramInt + g.a.a.a.oD(6, this.RMn.computeSize());
      }
      AppMethodBeat.o(133194);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.RLV == null)
        {
          paramVarArgs = new b("Not all required fields were included: AutoAuthKey");
          AppMethodBeat.o(133194);
          throw paramVarArgs;
        }
        if (this.RLT == null)
        {
          paramVarArgs = new b("Not all required fields were included: SvrPubECDHKey");
          AppMethodBeat.o(133194);
          throw paramVarArgs;
        }
        if (this.RLU == null)
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
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        ecy localecy = (ecy)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(133194);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new eae();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((eae)localObject2).dd((byte[])localObject1);
            }
            localecy.RLV = ((eae)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(133194);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new aiq();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((aiq)localObject2).parseFrom((byte[])localObject1);
            }
            localecy.RLT = ((aiq)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(133194);
          return 0;
        case 3: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new eae();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((eae)localObject2).dd((byte[])localObject1);
            }
            localecy.RLU = ((eae)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(133194);
          return 0;
        case 4: 
          localecy.RMj = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(133194);
          return 0;
        case 5: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new eae();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((eae)localObject2).dd((byte[])localObject1);
            }
            localecy.RMm = ((eae)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(133194);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new eae();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((eae)localObject2).dd((byte[])localObject1);
          }
          localecy.RMn = ((eae)localObject2);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ecy
 * JD-Core Version:    0.7.0.1
 */