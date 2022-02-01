package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class bss
  extends erp
{
  public b Ayh;
  public bke CIc;
  public String YIZ;
  public atz ZEc;
  public bma ZIR;
  public bsr ZPb;
  public long hKN;
  public String kLn;
  public long liveId;
  public String object_nonce_id;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259901);
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
      if (this.CIc != null)
      {
        paramVarArgs.qD(4, this.CIc.computeSize());
        this.CIc.writeFields(paramVarArgs);
      }
      paramVarArgs.bv(5, this.liveId);
      if (this.kLn != null) {
        paramVarArgs.g(6, this.kLn);
      }
      paramVarArgs.bv(7, this.hKN);
      if (this.object_nonce_id != null) {
        paramVarArgs.g(8, this.object_nonce_id);
      }
      if (this.YIZ != null) {
        paramVarArgs.g(9, this.YIZ);
      }
      if (this.ZPb != null)
      {
        paramVarArgs.qD(10, this.ZPb.computeSize());
        this.ZPb.writeFields(paramVarArgs);
      }
      if (this.ZIR != null)
      {
        paramVarArgs.qD(11, this.ZIR.computeSize());
        this.ZIR.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(259901);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1152;
      }
    }
    label1152:
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
      paramInt = i;
      if (this.CIc != null) {
        paramInt = i + i.a.a.a.qC(4, this.CIc.computeSize());
      }
      i = paramInt + i.a.a.b.b.a.q(5, this.liveId);
      paramInt = i;
      if (this.kLn != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.kLn);
      }
      i = paramInt + i.a.a.b.b.a.q(7, this.hKN);
      paramInt = i;
      if (this.object_nonce_id != null) {
        paramInt = i + i.a.a.b.b.a.h(8, this.object_nonce_id);
      }
      i = paramInt;
      if (this.YIZ != null) {
        i = paramInt + i.a.a.b.b.a.h(9, this.YIZ);
      }
      paramInt = i;
      if (this.ZPb != null) {
        paramInt = i + i.a.a.a.qC(10, this.ZPb.computeSize());
      }
      i = paramInt;
      if (this.ZIR != null) {
        i = paramInt + i.a.a.a.qC(11, this.ZIR.computeSize());
      }
      AppMethodBeat.o(259901);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(259901);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        bss localbss = (bss)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(259901);
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
            localbss.BaseRequest = ((kc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(259901);
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
            localbss.ZEc = ((atz)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(259901);
          return 0;
        case 3: 
          localbss.Ayh = ((i.a.a.a.a)localObject1).ajGk.kFX();
          AppMethodBeat.o(259901);
          return 0;
        case 4: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bke();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bke)localObject2).parseFrom((byte[])localObject1);
            }
            localbss.CIc = ((bke)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(259901);
          return 0;
        case 5: 
          localbss.liveId = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(259901);
          return 0;
        case 6: 
          localbss.kLn = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(259901);
          return 0;
        case 7: 
          localbss.hKN = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(259901);
          return 0;
        case 8: 
          localbss.object_nonce_id = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(259901);
          return 0;
        case 9: 
          localbss.YIZ = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(259901);
          return 0;
        case 10: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bsr();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bsr)localObject2).parseFrom((byte[])localObject1);
            }
            localbss.ZPb = ((bsr)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(259901);
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
          localbss.ZIR = ((bma)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(259901);
        return 0;
      }
      AppMethodBeat.o(259901);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bss
 * JD-Core Version:    0.7.0.1
 */