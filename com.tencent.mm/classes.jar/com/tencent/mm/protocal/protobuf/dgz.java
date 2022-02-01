package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class dgz
  extends com.tencent.mm.bx.a
{
  public String MpI;
  public float MpJ;
  public int MpK;
  public LinkedList<Integer> MpL;
  public int MpM;
  public LinkedList<etl> MpN;
  public float MpO;
  public String MpP;
  public gol MpQ;
  public String aaMv;
  public gol aaMw;
  public int aaMx;
  public int aaMy;
  public String hAP;
  public int vhJ;
  
  public dgz()
  {
    AppMethodBeat.i(116338);
    this.MpL = new LinkedList();
    this.MpN = new LinkedList();
    AppMethodBeat.o(116338);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(116339);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.MpI != null) {
        paramVarArgs.g(1, this.MpI);
      }
      if (this.hAP != null) {
        paramVarArgs.g(2, this.hAP);
      }
      paramVarArgs.l(3, this.MpJ);
      paramVarArgs.bS(4, this.MpK);
      paramVarArgs.f(5, 2, this.MpL);
      paramVarArgs.bS(6, this.MpM);
      paramVarArgs.e(7, 8, this.MpN);
      paramVarArgs.l(8, this.MpO);
      if (this.MpP != null) {
        paramVarArgs.g(9, this.MpP);
      }
      paramVarArgs.bS(10, this.vhJ);
      if (this.MpQ != null)
      {
        paramVarArgs.qD(11, this.MpQ.computeSize());
        this.MpQ.writeFields(paramVarArgs);
      }
      if (this.aaMv != null) {
        paramVarArgs.g(12, this.aaMv);
      }
      if (this.aaMw != null)
      {
        paramVarArgs.qD(13, this.aaMw.computeSize());
        this.aaMw.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(14, this.aaMx);
      paramVarArgs.bS(15, this.aaMy);
      AppMethodBeat.o(116339);
      return 0;
    }
    if (paramInt == 1) {
      if (this.MpI == null) {
        break label1169;
      }
    }
    label1169:
    for (paramInt = i.a.a.b.b.a.h(1, this.MpI) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.hAP != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.hAP);
      }
      i = i + (i.a.a.b.b.a.ko(3) + 4) + i.a.a.b.b.a.cJ(4, this.MpK) + i.a.a.a.d(5, 2, this.MpL) + i.a.a.b.b.a.cJ(6, this.MpM) + i.a.a.a.c(7, 8, this.MpN) + (i.a.a.b.b.a.ko(8) + 4);
      paramInt = i;
      if (this.MpP != null) {
        paramInt = i + i.a.a.b.b.a.h(9, this.MpP);
      }
      i = paramInt + i.a.a.b.b.a.cJ(10, this.vhJ);
      paramInt = i;
      if (this.MpQ != null) {
        paramInt = i + i.a.a.a.qC(11, this.MpQ.computeSize());
      }
      i = paramInt;
      if (this.aaMv != null) {
        i = paramInt + i.a.a.b.b.a.h(12, this.aaMv);
      }
      paramInt = i;
      if (this.aaMw != null) {
        paramInt = i + i.a.a.a.qC(13, this.aaMw.computeSize());
      }
      i = i.a.a.b.b.a.cJ(14, this.aaMx);
      int j = i.a.a.b.b.a.cJ(15, this.aaMy);
      AppMethodBeat.o(116339);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.MpL.clear();
        this.MpN.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(116339);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        dgz localdgz = (dgz)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(116339);
          return -1;
        case 1: 
          localdgz.MpI = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(116339);
          return 0;
        case 2: 
          localdgz.hAP = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(116339);
          return 0;
        case 3: 
          localdgz.MpJ = Float.intBitsToFloat(((i.a.a.a.a)localObject1).ajGk.aax());
          AppMethodBeat.o(116339);
          return 0;
        case 4: 
          localdgz.MpK = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(116339);
          return 0;
        case 5: 
          localdgz.MpL = new i.a.a.a.a(((i.a.a.a.a)localObject1).ajGk.kFX().Op, unknownTagHandler).ajGk.kFV();
          AppMethodBeat.o(116339);
          return 0;
        case 6: 
          localdgz.MpM = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(116339);
          return 0;
        case 7: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new etl();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((etl)localObject2).dh((byte[])localObject1);
            }
            localdgz.MpN.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(116339);
          return 0;
        case 8: 
          localdgz.MpO = Float.intBitsToFloat(((i.a.a.a.a)localObject1).ajGk.aax());
          AppMethodBeat.o(116339);
          return 0;
        case 9: 
          localdgz.MpP = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(116339);
          return 0;
        case 10: 
          localdgz.vhJ = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(116339);
          return 0;
        case 11: 
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
            localdgz.MpQ = ((gol)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(116339);
          return 0;
        case 12: 
          localdgz.aaMv = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(116339);
          return 0;
        case 13: 
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
            localdgz.aaMw = ((gol)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(116339);
          return 0;
        case 14: 
          localdgz.aaMx = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(116339);
          return 0;
        }
        localdgz.aaMy = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(116339);
        return 0;
      }
      AppMethodBeat.o(116339);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dgz
 * JD-Core Version:    0.7.0.1
 */