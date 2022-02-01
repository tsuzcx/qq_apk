package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class azo
  extends erp
{
  public b Ayh;
  public boolean LXS;
  public atz ZEc;
  public bma ZIR;
  public bgc ZJI;
  public b ZJJ;
  public String ZJK;
  public LinkedList<bfv> ZJL;
  public bfv ZJM;
  public String finderUsername;
  public long hKN;
  public long liveId;
  public String object_nonce_id;
  public int scene;
  
  public azo()
  {
    AppMethodBeat.i(259001);
    this.ZJL = new LinkedList();
    AppMethodBeat.o(259001);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259009);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.ZEc != null)
      {
        paramVarArgs.qD(2, this.ZEc.computeSize());
        this.ZEc.writeFields(paramVarArgs);
      }
      if (this.Ayh != null) {
        paramVarArgs.d(3, this.Ayh);
      }
      paramVarArgs.bv(4, this.liveId);
      if (this.finderUsername != null) {
        paramVarArgs.g(5, this.finderUsername);
      }
      paramVarArgs.bS(6, this.scene);
      paramVarArgs.bv(7, this.hKN);
      paramVarArgs.di(8, this.LXS);
      if (this.object_nonce_id != null) {
        paramVarArgs.g(9, this.object_nonce_id);
      }
      if (this.ZJI != null)
      {
        paramVarArgs.qD(10, this.ZJI.computeSize());
        this.ZJI.writeFields(paramVarArgs);
      }
      if (this.ZJJ != null) {
        paramVarArgs.d(11, this.ZJJ);
      }
      if (this.ZJK != null) {
        paramVarArgs.g(12, this.ZJK);
      }
      paramVarArgs.e(13, 8, this.ZJL);
      if (this.ZJM != null)
      {
        paramVarArgs.qD(14, this.ZJM.computeSize());
        this.ZJM.writeFields(paramVarArgs);
      }
      if (this.ZIR != null)
      {
        paramVarArgs.qD(15, this.ZIR.computeSize());
        this.ZIR.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(259009);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1422;
      }
    }
    label1422:
    for (int i = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.ZEc != null) {
        paramInt = i + i.a.a.a.qC(2, this.ZEc.computeSize());
      }
      i = paramInt;
      if (this.Ayh != null) {
        i = paramInt + i.a.a.b.b.a.c(3, this.Ayh);
      }
      i += i.a.a.b.b.a.q(4, this.liveId);
      paramInt = i;
      if (this.finderUsername != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.finderUsername);
      }
      i = paramInt + i.a.a.b.b.a.cJ(6, this.scene) + i.a.a.b.b.a.q(7, this.hKN) + (i.a.a.b.b.a.ko(8) + 1);
      paramInt = i;
      if (this.object_nonce_id != null) {
        paramInt = i + i.a.a.b.b.a.h(9, this.object_nonce_id);
      }
      i = paramInt;
      if (this.ZJI != null) {
        i = paramInt + i.a.a.a.qC(10, this.ZJI.computeSize());
      }
      paramInt = i;
      if (this.ZJJ != null) {
        paramInt = i + i.a.a.b.b.a.c(11, this.ZJJ);
      }
      i = paramInt;
      if (this.ZJK != null) {
        i = paramInt + i.a.a.b.b.a.h(12, this.ZJK);
      }
      i += i.a.a.a.c(13, 8, this.ZJL);
      paramInt = i;
      if (this.ZJM != null) {
        paramInt = i + i.a.a.a.qC(14, this.ZJM.computeSize());
      }
      i = paramInt;
      if (this.ZIR != null) {
        i = paramInt + i.a.a.a.qC(15, this.ZIR.computeSize());
      }
      AppMethodBeat.o(259009);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.ZJL.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(259009);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        azo localazo = (azo)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(259009);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new kc();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((kc)localObject2).parseFrom((byte[])localObject1);
            }
            localazo.BaseRequest = ((kc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(259009);
          return 0;
        case 2: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new atz();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((atz)localObject2).parseFrom((byte[])localObject1);
            }
            localazo.ZEc = ((atz)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(259009);
          return 0;
        case 3: 
          localazo.Ayh = ((i.a.a.a.a)localObject1).ajGk.kFX();
          AppMethodBeat.o(259009);
          return 0;
        case 4: 
          localazo.liveId = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(259009);
          return 0;
        case 5: 
          localazo.finderUsername = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(259009);
          return 0;
        case 6: 
          localazo.scene = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(259009);
          return 0;
        case 7: 
          localazo.hKN = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(259009);
          return 0;
        case 8: 
          localazo.LXS = ((i.a.a.a.a)localObject1).ajGk.aai();
          AppMethodBeat.o(259009);
          return 0;
        case 9: 
          localazo.object_nonce_id = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(259009);
          return 0;
        case 10: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bgc();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bgc)localObject2).parseFrom((byte[])localObject1);
            }
            localazo.ZJI = ((bgc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(259009);
          return 0;
        case 11: 
          localazo.ZJJ = ((i.a.a.a.a)localObject1).ajGk.kFX();
          AppMethodBeat.o(259009);
          return 0;
        case 12: 
          localazo.ZJK = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(259009);
          return 0;
        case 13: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bfv();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bfv)localObject2).parseFrom((byte[])localObject1);
            }
            localazo.ZJL.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(259009);
          return 0;
        case 14: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bfv();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bfv)localObject2).parseFrom((byte[])localObject1);
            }
            localazo.ZJM = ((bfv)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(259009);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new bma();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((bma)localObject2).parseFrom((byte[])localObject1);
          }
          localazo.ZIR = ((bma)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(259009);
        return 0;
      }
      AppMethodBeat.o(259009);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.azo
 * JD-Core Version:    0.7.0.1
 */