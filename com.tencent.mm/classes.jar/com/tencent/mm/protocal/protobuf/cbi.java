package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cbi
  extends com.tencent.mm.bx.a
{
  public LinkedList<cbk> aakA;
  public String aakB;
  public String aakC;
  public LinkedList<cbj> aakD;
  public int aakE;
  public boolean aakF;
  public LinkedList<cbc> aakz;
  public String hAP;
  public int type;
  
  public cbi()
  {
    AppMethodBeat.i(42642);
    this.aakz = new LinkedList();
    this.aakA = new LinkedList();
    this.aakD = new LinkedList();
    AppMethodBeat.o(42642);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(42643);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.hAP != null) {
        paramVarArgs.g(1, this.hAP);
      }
      paramVarArgs.bS(2, this.type);
      paramVarArgs.e(3, 8, this.aakz);
      paramVarArgs.e(4, 8, this.aakA);
      if (this.aakB != null) {
        paramVarArgs.g(5, this.aakB);
      }
      if (this.aakC != null) {
        paramVarArgs.g(6, this.aakC);
      }
      paramVarArgs.e(7, 8, this.aakD);
      paramVarArgs.bS(8, this.aakE);
      paramVarArgs.di(9, this.aakF);
      AppMethodBeat.o(42643);
      return 0;
    }
    if (paramInt == 1) {
      if (this.hAP == null) {
        break label824;
      }
    }
    label824:
    for (paramInt = i.a.a.b.b.a.h(1, this.hAP) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.type) + i.a.a.a.c(3, 8, this.aakz) + i.a.a.a.c(4, 8, this.aakA);
      paramInt = i;
      if (this.aakB != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.aakB);
      }
      i = paramInt;
      if (this.aakC != null) {
        i = paramInt + i.a.a.b.b.a.h(6, this.aakC);
      }
      paramInt = i.a.a.a.c(7, 8, this.aakD);
      int j = i.a.a.b.b.a.cJ(8, this.aakE);
      int k = i.a.a.b.b.a.ko(9);
      AppMethodBeat.o(42643);
      return i + paramInt + j + (k + 1);
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.aakz.clear();
        this.aakA.clear();
        this.aakD.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(42643);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        cbi localcbi = (cbi)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(42643);
          return -1;
        case 1: 
          localcbi.hAP = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(42643);
          return 0;
        case 2: 
          localcbi.type = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(42643);
          return 0;
        case 3: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new cbc();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((cbc)localObject2).parseFrom((byte[])localObject1);
            }
            localcbi.aakz.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(42643);
          return 0;
        case 4: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new cbk();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((cbk)localObject2).parseFrom((byte[])localObject1);
            }
            localcbi.aakA.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(42643);
          return 0;
        case 5: 
          localcbi.aakB = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(42643);
          return 0;
        case 6: 
          localcbi.aakC = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(42643);
          return 0;
        case 7: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new cbj();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((cbj)localObject2).parseFrom((byte[])localObject1);
            }
            localcbi.aakD.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(42643);
          return 0;
        case 8: 
          localcbi.aakE = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(42643);
          return 0;
        }
        localcbi.aakF = ((i.a.a.a.a)localObject1).ajGk.aai();
        AppMethodBeat.o(42643);
        return 0;
      }
      AppMethodBeat.o(42643);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cbi
 * JD-Core Version:    0.7.0.1
 */