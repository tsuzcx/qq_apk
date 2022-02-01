package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class bbz
  extends erp
{
  public b Ayh;
  public String Edn;
  public atz ZEc;
  public long ZEj;
  public bma ZIR;
  public b ZJJ;
  public String ZJK;
  public bfu ZKH;
  public String ZMI;
  public int ZMJ;
  public String ZMK;
  public bcb ZML;
  public bfv ZMM;
  public String finderUsername;
  public long hKN;
  public int iaK;
  public long liveId;
  public String object_nonce_id;
  public int scene;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259575);
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
      paramVarArgs.bv(3, this.liveId);
      if (this.Ayh != null) {
        paramVarArgs.d(4, this.Ayh);
      }
      paramVarArgs.bv(5, this.hKN);
      if (this.finderUsername != null) {
        paramVarArgs.g(6, this.finderUsername);
      }
      paramVarArgs.bS(7, this.scene);
      if (this.ZMI != null) {
        paramVarArgs.g(8, this.ZMI);
      }
      if (this.object_nonce_id != null) {
        paramVarArgs.g(9, this.object_nonce_id);
      }
      if (this.ZJK != null) {
        paramVarArgs.g(10, this.ZJK);
      }
      paramVarArgs.bS(11, this.ZMJ);
      if (this.ZMK != null) {
        paramVarArgs.g(12, this.ZMK);
      }
      paramVarArgs.bS(13, this.iaK);
      paramVarArgs.bv(14, this.ZEj);
      if (this.ZML != null)
      {
        paramVarArgs.qD(15, this.ZML.computeSize());
        this.ZML.writeFields(paramVarArgs);
      }
      if (this.ZJJ != null) {
        paramVarArgs.d(16, this.ZJJ);
      }
      if (this.Edn != null) {
        paramVarArgs.g(17, this.Edn);
      }
      if (this.ZKH != null)
      {
        paramVarArgs.qD(18, this.ZKH.computeSize());
        this.ZKH.writeFields(paramVarArgs);
      }
      if (this.ZMM != null)
      {
        paramVarArgs.qD(19, this.ZMM.computeSize());
        this.ZMM.writeFields(paramVarArgs);
      }
      if (this.ZIR != null)
      {
        paramVarArgs.qD(20, this.ZIR.computeSize());
        this.ZIR.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(259575);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1718;
      }
    }
    label1718:
    for (paramInt = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.ZEc != null) {
        i = paramInt + i.a.a.a.qC(2, this.ZEc.computeSize());
      }
      i += i.a.a.b.b.a.q(3, this.liveId);
      paramInt = i;
      if (this.Ayh != null) {
        paramInt = i + i.a.a.b.b.a.c(4, this.Ayh);
      }
      i = paramInt + i.a.a.b.b.a.q(5, this.hKN);
      paramInt = i;
      if (this.finderUsername != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.finderUsername);
      }
      i = paramInt + i.a.a.b.b.a.cJ(7, this.scene);
      paramInt = i;
      if (this.ZMI != null) {
        paramInt = i + i.a.a.b.b.a.h(8, this.ZMI);
      }
      i = paramInt;
      if (this.object_nonce_id != null) {
        i = paramInt + i.a.a.b.b.a.h(9, this.object_nonce_id);
      }
      paramInt = i;
      if (this.ZJK != null) {
        paramInt = i + i.a.a.b.b.a.h(10, this.ZJK);
      }
      i = paramInt + i.a.a.b.b.a.cJ(11, this.ZMJ);
      paramInt = i;
      if (this.ZMK != null) {
        paramInt = i + i.a.a.b.b.a.h(12, this.ZMK);
      }
      i = paramInt + i.a.a.b.b.a.cJ(13, this.iaK) + i.a.a.b.b.a.q(14, this.ZEj);
      paramInt = i;
      if (this.ZML != null) {
        paramInt = i + i.a.a.a.qC(15, this.ZML.computeSize());
      }
      i = paramInt;
      if (this.ZJJ != null) {
        i = paramInt + i.a.a.b.b.a.c(16, this.ZJJ);
      }
      paramInt = i;
      if (this.Edn != null) {
        paramInt = i + i.a.a.b.b.a.h(17, this.Edn);
      }
      i = paramInt;
      if (this.ZKH != null) {
        i = paramInt + i.a.a.a.qC(18, this.ZKH.computeSize());
      }
      paramInt = i;
      if (this.ZMM != null) {
        paramInt = i + i.a.a.a.qC(19, this.ZMM.computeSize());
      }
      i = paramInt;
      if (this.ZIR != null) {
        i = paramInt + i.a.a.a.qC(20, this.ZIR.computeSize());
      }
      AppMethodBeat.o(259575);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(259575);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        bbz localbbz = (bbz)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(259575);
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
            localbbz.BaseRequest = ((kc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(259575);
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
            localbbz.ZEc = ((atz)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(259575);
          return 0;
        case 3: 
          localbbz.liveId = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(259575);
          return 0;
        case 4: 
          localbbz.Ayh = ((i.a.a.a.a)localObject1).ajGk.kFX();
          AppMethodBeat.o(259575);
          return 0;
        case 5: 
          localbbz.hKN = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(259575);
          return 0;
        case 6: 
          localbbz.finderUsername = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(259575);
          return 0;
        case 7: 
          localbbz.scene = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(259575);
          return 0;
        case 8: 
          localbbz.ZMI = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(259575);
          return 0;
        case 9: 
          localbbz.object_nonce_id = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(259575);
          return 0;
        case 10: 
          localbbz.ZJK = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(259575);
          return 0;
        case 11: 
          localbbz.ZMJ = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(259575);
          return 0;
        case 12: 
          localbbz.ZMK = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(259575);
          return 0;
        case 13: 
          localbbz.iaK = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(259575);
          return 0;
        case 14: 
          localbbz.ZEj = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(259575);
          return 0;
        case 15: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bcb();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bcb)localObject2).parseFrom((byte[])localObject1);
            }
            localbbz.ZML = ((bcb)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(259575);
          return 0;
        case 16: 
          localbbz.ZJJ = ((i.a.a.a.a)localObject1).ajGk.kFX();
          AppMethodBeat.o(259575);
          return 0;
        case 17: 
          localbbz.Edn = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(259575);
          return 0;
        case 18: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bfu();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bfu)localObject2).parseFrom((byte[])localObject1);
            }
            localbbz.ZKH = ((bfu)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(259575);
          return 0;
        case 19: 
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
            localbbz.ZMM = ((bfv)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(259575);
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
          localbbz.ZIR = ((bma)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(259575);
        return 0;
      }
      AppMethodBeat.o(259575);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bbz
 * JD-Core Version:    0.7.0.1
 */