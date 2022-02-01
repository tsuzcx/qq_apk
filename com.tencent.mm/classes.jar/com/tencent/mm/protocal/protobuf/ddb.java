package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ddb
  extends com.tencent.mm.bx.a
{
  public int CreateTime;
  public String YQI;
  public String YQK;
  public String YQM;
  public String YQN;
  public String YQO;
  public fxo aaID;
  public fze aaIE;
  public edo aaIF;
  public String hAP;
  public int nUA;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259078);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.hAP != null) {
        paramVarArgs.g(1, this.hAP);
      }
      if (this.YQI != null) {
        paramVarArgs.g(2, this.YQI);
      }
      if (this.YQK != null) {
        paramVarArgs.g(3, this.YQK);
      }
      if (this.YQM != null) {
        paramVarArgs.g(4, this.YQM);
      }
      if (this.YQN != null) {
        paramVarArgs.g(5, this.YQN);
      }
      if (this.YQO != null) {
        paramVarArgs.g(6, this.YQO);
      }
      paramVarArgs.bS(7, this.nUA);
      paramVarArgs.bS(8, this.CreateTime);
      if (this.aaID != null)
      {
        paramVarArgs.qD(9, this.aaID.computeSize());
        this.aaID.writeFields(paramVarArgs);
      }
      if (this.aaIE != null)
      {
        paramVarArgs.qD(10, this.aaIE.computeSize());
        this.aaIE.writeFields(paramVarArgs);
      }
      if (this.aaIF != null)
      {
        paramVarArgs.qD(11, this.aaIF.computeSize());
        this.aaIF.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(259078);
      return 0;
    }
    if (paramInt == 1) {
      if (this.hAP == null) {
        break label1008;
      }
    }
    label1008:
    for (int i = i.a.a.b.b.a.h(1, this.hAP) + 0;; i = 0)
    {
      paramInt = i;
      if (this.YQI != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.YQI);
      }
      i = paramInt;
      if (this.YQK != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.YQK);
      }
      paramInt = i;
      if (this.YQM != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.YQM);
      }
      i = paramInt;
      if (this.YQN != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.YQN);
      }
      paramInt = i;
      if (this.YQO != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.YQO);
      }
      i = paramInt + i.a.a.b.b.a.cJ(7, this.nUA) + i.a.a.b.b.a.cJ(8, this.CreateTime);
      paramInt = i;
      if (this.aaID != null) {
        paramInt = i + i.a.a.a.qC(9, this.aaID.computeSize());
      }
      i = paramInt;
      if (this.aaIE != null) {
        i = paramInt + i.a.a.a.qC(10, this.aaIE.computeSize());
      }
      paramInt = i;
      if (this.aaIF != null) {
        paramInt = i + i.a.a.a.qC(11, this.aaIF.computeSize());
      }
      AppMethodBeat.o(259078);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(259078);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        ddb localddb = (ddb)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(259078);
          return -1;
        case 1: 
          localddb.hAP = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(259078);
          return 0;
        case 2: 
          localddb.YQI = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(259078);
          return 0;
        case 3: 
          localddb.YQK = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(259078);
          return 0;
        case 4: 
          localddb.YQM = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(259078);
          return 0;
        case 5: 
          localddb.YQN = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(259078);
          return 0;
        case 6: 
          localddb.YQO = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(259078);
          return 0;
        case 7: 
          localddb.nUA = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(259078);
          return 0;
        case 8: 
          localddb.CreateTime = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(259078);
          return 0;
        case 9: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new fxo();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((fxo)localObject2).parseFrom((byte[])localObject1);
            }
            localddb.aaID = ((fxo)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(259078);
          return 0;
        case 10: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new fze();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((fze)localObject2).parseFrom((byte[])localObject1);
            }
            localddb.aaIE = ((fze)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(259078);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new edo();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((edo)localObject2).parseFrom((byte[])localObject1);
          }
          localddb.aaIF = ((edo)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(259078);
        return 0;
      }
      AppMethodBeat.o(259078);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ddb
 * JD-Core Version:    0.7.0.1
 */