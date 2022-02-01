package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class bia
  extends erp
{
  public String Bhk;
  public b YJa;
  public atz ZEc;
  public long ZPX;
  public String finderUsername;
  public long hKN;
  public b lastBuffer;
  public long liveId;
  public String mdD;
  public int scene;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(257533);
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
      if (this.finderUsername != null) {
        paramVarArgs.g(3, this.finderUsername);
      }
      paramVarArgs.bv(4, this.liveId);
      paramVarArgs.bv(5, this.hKN);
      paramVarArgs.bv(6, this.ZPX);
      if (this.Bhk != null) {
        paramVarArgs.g(7, this.Bhk);
      }
      if (this.lastBuffer != null) {
        paramVarArgs.d(8, this.lastBuffer);
      }
      if (this.mdD != null) {
        paramVarArgs.g(9, this.mdD);
      }
      if (this.YJa != null) {
        paramVarArgs.d(10, this.YJa);
      }
      paramVarArgs.bS(11, this.scene);
      AppMethodBeat.o(257533);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label902;
      }
    }
    label902:
    for (int i = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.ZEc != null) {
        paramInt = i + i.a.a.a.qC(2, this.ZEc.computeSize());
      }
      i = paramInt;
      if (this.finderUsername != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.finderUsername);
      }
      i = i + i.a.a.b.b.a.q(4, this.liveId) + i.a.a.b.b.a.q(5, this.hKN) + i.a.a.b.b.a.q(6, this.ZPX);
      paramInt = i;
      if (this.Bhk != null) {
        paramInt = i + i.a.a.b.b.a.h(7, this.Bhk);
      }
      i = paramInt;
      if (this.lastBuffer != null) {
        i = paramInt + i.a.a.b.b.a.c(8, this.lastBuffer);
      }
      paramInt = i;
      if (this.mdD != null) {
        paramInt = i + i.a.a.b.b.a.h(9, this.mdD);
      }
      i = paramInt;
      if (this.YJa != null) {
        i = paramInt + i.a.a.b.b.a.c(10, this.YJa);
      }
      paramInt = i.a.a.b.b.a.cJ(11, this.scene);
      AppMethodBeat.o(257533);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(257533);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        bia localbia = (bia)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(257533);
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
            localbia.BaseRequest = ((kc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(257533);
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
            localbia.ZEc = ((atz)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(257533);
          return 0;
        case 3: 
          localbia.finderUsername = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(257533);
          return 0;
        case 4: 
          localbia.liveId = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(257533);
          return 0;
        case 5: 
          localbia.hKN = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(257533);
          return 0;
        case 6: 
          localbia.ZPX = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(257533);
          return 0;
        case 7: 
          localbia.Bhk = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(257533);
          return 0;
        case 8: 
          localbia.lastBuffer = ((i.a.a.a.a)localObject1).ajGk.kFX();
          AppMethodBeat.o(257533);
          return 0;
        case 9: 
          localbia.mdD = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(257533);
          return 0;
        case 10: 
          localbia.YJa = ((i.a.a.a.a)localObject1).ajGk.kFX();
          AppMethodBeat.o(257533);
          return 0;
        }
        localbia.scene = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(257533);
        return 0;
      }
      AppMethodBeat.o(257533);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bia
 * JD-Core Version:    0.7.0.1
 */