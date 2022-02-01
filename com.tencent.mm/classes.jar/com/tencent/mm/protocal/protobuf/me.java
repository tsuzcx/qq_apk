package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class me
  extends com.tencent.mm.cd.a
{
  public te RRI;
  public te RRJ;
  public te RRK;
  public eae RRL;
  public eae RRM;
  public te RRN;
  public int RRO;
  public td RRP;
  public td RRQ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(104359);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.RRI != null)
      {
        paramVarArgs.oE(1, this.RRI.computeSize());
        this.RRI.writeFields(paramVarArgs);
      }
      if (this.RRJ != null)
      {
        paramVarArgs.oE(2, this.RRJ.computeSize());
        this.RRJ.writeFields(paramVarArgs);
      }
      if (this.RRK != null)
      {
        paramVarArgs.oE(4, this.RRK.computeSize());
        this.RRK.writeFields(paramVarArgs);
      }
      if (this.RRL != null)
      {
        paramVarArgs.oE(5, this.RRL.computeSize());
        this.RRL.writeFields(paramVarArgs);
      }
      if (this.RRM != null)
      {
        paramVarArgs.oE(6, this.RRM.computeSize());
        this.RRM.writeFields(paramVarArgs);
      }
      if (this.RRN != null)
      {
        paramVarArgs.oE(7, this.RRN.computeSize());
        this.RRN.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(8, this.RRO);
      if (this.RRP != null)
      {
        paramVarArgs.oE(9, this.RRP.computeSize());
        this.RRP.writeFields(paramVarArgs);
      }
      if (this.RRQ != null)
      {
        paramVarArgs.oE(10, this.RRQ.computeSize());
        this.RRQ.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(104359);
      return 0;
    }
    if (paramInt == 1) {
      if (this.RRI == null) {
        break label1270;
      }
    }
    label1270:
    for (int i = g.a.a.a.oD(1, this.RRI.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.RRJ != null) {
        paramInt = i + g.a.a.a.oD(2, this.RRJ.computeSize());
      }
      i = paramInt;
      if (this.RRK != null) {
        i = paramInt + g.a.a.a.oD(4, this.RRK.computeSize());
      }
      paramInt = i;
      if (this.RRL != null) {
        paramInt = i + g.a.a.a.oD(5, this.RRL.computeSize());
      }
      i = paramInt;
      if (this.RRM != null) {
        i = paramInt + g.a.a.a.oD(6, this.RRM.computeSize());
      }
      paramInt = i;
      if (this.RRN != null) {
        paramInt = i + g.a.a.a.oD(7, this.RRN.computeSize());
      }
      i = paramInt + g.a.a.b.b.a.bM(8, this.RRO);
      paramInt = i;
      if (this.RRP != null) {
        paramInt = i + g.a.a.a.oD(9, this.RRP.computeSize());
      }
      i = paramInt;
      if (this.RRQ != null) {
        i = paramInt + g.a.a.a.oD(10, this.RRQ.computeSize());
      }
      AppMethodBeat.o(104359);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(104359);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        me localme = (me)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        case 3: 
        default: 
          AppMethodBeat.o(104359);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new te();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((te)localObject2).parseFrom((byte[])localObject1);
            }
            localme.RRI = ((te)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(104359);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new te();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((te)localObject2).parseFrom((byte[])localObject1);
            }
            localme.RRJ = ((te)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(104359);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new te();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((te)localObject2).parseFrom((byte[])localObject1);
            }
            localme.RRK = ((te)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(104359);
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
            localme.RRL = ((eae)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(104359);
          return 0;
        case 6: 
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
            localme.RRM = ((eae)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(104359);
          return 0;
        case 7: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new te();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((te)localObject2).parseFrom((byte[])localObject1);
            }
            localme.RRN = ((te)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(104359);
          return 0;
        case 8: 
          localme.RRO = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(104359);
          return 0;
        case 9: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new td();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((td)localObject2).parseFrom((byte[])localObject1);
            }
            localme.RRP = ((td)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(104359);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new td();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((td)localObject2).parseFrom((byte[])localObject1);
          }
          localme.RRQ = ((td)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(104359);
        return 0;
      }
      AppMethodBeat.o(104359);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.me
 * JD-Core Version:    0.7.0.1
 */