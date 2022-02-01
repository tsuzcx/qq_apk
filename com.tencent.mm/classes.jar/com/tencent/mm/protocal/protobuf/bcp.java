package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class bcp
  extends erp
{
  public String Tro;
  public atz YIY;
  public String YIZ;
  public b YJa;
  public bma ZIR;
  public int ZNC;
  public long count;
  public int hYl;
  public long mMJ;
  public long object_id;
  public String object_nonce_id;
  public int scene;
  public long seq;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259273);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.YIY != null)
      {
        paramVarArgs.qD(2, this.YIY.computeSize());
        this.YIY.writeFields(paramVarArgs);
      }
      paramVarArgs.bv(3, this.mMJ);
      paramVarArgs.bv(4, this.count);
      if (this.YJa != null) {
        paramVarArgs.d(5, this.YJa);
      }
      paramVarArgs.bv(6, this.object_id);
      paramVarArgs.bv(7, this.seq);
      paramVarArgs.bS(8, this.ZNC);
      if (this.Tro != null) {
        paramVarArgs.g(9, this.Tro);
      }
      paramVarArgs.bS(10, this.scene);
      paramVarArgs.bS(11, this.hYl);
      if (this.object_nonce_id != null) {
        paramVarArgs.g(12, this.object_nonce_id);
      }
      if (this.YIZ != null) {
        paramVarArgs.g(13, this.YIZ);
      }
      if (this.ZIR != null)
      {
        paramVarArgs.qD(14, this.ZIR.computeSize());
        this.ZIR.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(259273);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1108;
      }
    }
    label1108:
    for (paramInt = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.YIY != null) {
        i = paramInt + i.a.a.a.qC(2, this.YIY.computeSize());
      }
      i = i + i.a.a.b.b.a.q(3, this.mMJ) + i.a.a.b.b.a.q(4, this.count);
      paramInt = i;
      if (this.YJa != null) {
        paramInt = i + i.a.a.b.b.a.c(5, this.YJa);
      }
      i = paramInt + i.a.a.b.b.a.q(6, this.object_id) + i.a.a.b.b.a.q(7, this.seq) + i.a.a.b.b.a.cJ(8, this.ZNC);
      paramInt = i;
      if (this.Tro != null) {
        paramInt = i + i.a.a.b.b.a.h(9, this.Tro);
      }
      i = paramInt + i.a.a.b.b.a.cJ(10, this.scene) + i.a.a.b.b.a.cJ(11, this.hYl);
      paramInt = i;
      if (this.object_nonce_id != null) {
        paramInt = i + i.a.a.b.b.a.h(12, this.object_nonce_id);
      }
      i = paramInt;
      if (this.YIZ != null) {
        i = paramInt + i.a.a.b.b.a.h(13, this.YIZ);
      }
      paramInt = i;
      if (this.ZIR != null) {
        paramInt = i + i.a.a.a.qC(14, this.ZIR.computeSize());
      }
      AppMethodBeat.o(259273);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(259273);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        bcp localbcp = (bcp)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(259273);
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
            localbcp.BaseRequest = ((kc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(259273);
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
            localbcp.YIY = ((atz)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(259273);
          return 0;
        case 3: 
          localbcp.mMJ = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(259273);
          return 0;
        case 4: 
          localbcp.count = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(259273);
          return 0;
        case 5: 
          localbcp.YJa = ((i.a.a.a.a)localObject1).ajGk.kFX();
          AppMethodBeat.o(259273);
          return 0;
        case 6: 
          localbcp.object_id = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(259273);
          return 0;
        case 7: 
          localbcp.seq = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(259273);
          return 0;
        case 8: 
          localbcp.ZNC = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(259273);
          return 0;
        case 9: 
          localbcp.Tro = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(259273);
          return 0;
        case 10: 
          localbcp.scene = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(259273);
          return 0;
        case 11: 
          localbcp.hYl = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(259273);
          return 0;
        case 12: 
          localbcp.object_nonce_id = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(259273);
          return 0;
        case 13: 
          localbcp.YIZ = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(259273);
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
          localbcp.ZIR = ((bma)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(259273);
        return 0;
      }
      AppMethodBeat.o(259273);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bcp
 * JD-Core Version:    0.7.0.1
 */