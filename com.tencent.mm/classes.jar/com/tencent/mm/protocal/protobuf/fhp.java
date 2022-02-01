package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class fhp
  extends com.tencent.mm.bx.a
{
  public int AJo;
  public ni abIh;
  public fvu abIi;
  public dzj abIj;
  public long abIk;
  public int abIl;
  public long abIm;
  public long abIn;
  public b abIo;
  public long abIp;
  public String abIq;
  public long abIr;
  public long abIs;
  public String finderUsername;
  public long hKN;
  public long mMJ;
  public int mediaType;
  public String objectNonceId;
  public String sessionBuffer;
  public int uin;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(169091);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bv(1, this.hKN);
      if (this.abIh != null)
      {
        paramVarArgs.qD(2, this.abIh.computeSize());
        this.abIh.writeFields(paramVarArgs);
      }
      if (this.abIi != null)
      {
        paramVarArgs.qD(3, this.abIi.computeSize());
        this.abIi.writeFields(paramVarArgs);
      }
      if (this.abIj != null)
      {
        paramVarArgs.qD(4, this.abIj.computeSize());
        this.abIj.writeFields(paramVarArgs);
      }
      if (this.objectNonceId != null) {
        paramVarArgs.g(5, this.objectNonceId);
      }
      if (this.finderUsername != null) {
        paramVarArgs.g(6, this.finderUsername);
      }
      paramVarArgs.bv(7, this.abIk);
      paramVarArgs.bS(8, this.abIl);
      if (this.sessionBuffer != null) {
        paramVarArgs.g(9, this.sessionBuffer);
      }
      paramVarArgs.bv(10, this.abIm);
      paramVarArgs.bS(11, this.AJo);
      paramVarArgs.bv(12, this.abIn);
      if (this.abIo != null) {
        paramVarArgs.d(13, this.abIo);
      }
      paramVarArgs.bS(14, this.mediaType);
      paramVarArgs.bv(15, this.abIp);
      if (this.abIq != null) {
        paramVarArgs.g(16, this.abIq);
      }
      paramVarArgs.bv(17, this.abIr);
      paramVarArgs.bS(18, this.uin);
      paramVarArgs.bv(19, this.abIs);
      paramVarArgs.bv(20, this.mMJ);
      AppMethodBeat.o(169091);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.b.b.a.q(1, this.hKN) + 0;
      paramInt = i;
      if (this.abIh != null) {
        paramInt = i + i.a.a.a.qC(2, this.abIh.computeSize());
      }
      i = paramInt;
      if (this.abIi != null) {
        i = paramInt + i.a.a.a.qC(3, this.abIi.computeSize());
      }
      paramInt = i;
      if (this.abIj != null) {
        paramInt = i + i.a.a.a.qC(4, this.abIj.computeSize());
      }
      i = paramInt;
      if (this.objectNonceId != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.objectNonceId);
      }
      paramInt = i;
      if (this.finderUsername != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.finderUsername);
      }
      i = paramInt + i.a.a.b.b.a.q(7, this.abIk) + i.a.a.b.b.a.cJ(8, this.abIl);
      paramInt = i;
      if (this.sessionBuffer != null) {
        paramInt = i + i.a.a.b.b.a.h(9, this.sessionBuffer);
      }
      i = paramInt + i.a.a.b.b.a.q(10, this.abIm) + i.a.a.b.b.a.cJ(11, this.AJo) + i.a.a.b.b.a.q(12, this.abIn);
      paramInt = i;
      if (this.abIo != null) {
        paramInt = i + i.a.a.b.b.a.c(13, this.abIo);
      }
      i = paramInt + i.a.a.b.b.a.cJ(14, this.mediaType) + i.a.a.b.b.a.q(15, this.abIp);
      paramInt = i;
      if (this.abIq != null) {
        paramInt = i + i.a.a.b.b.a.h(16, this.abIq);
      }
      i = i.a.a.b.b.a.q(17, this.abIr);
      int j = i.a.a.b.b.a.cJ(18, this.uin);
      int k = i.a.a.b.b.a.q(19, this.abIs);
      int m = i.a.a.b.b.a.q(20, this.mMJ);
      AppMethodBeat.o(169091);
      return paramInt + i + j + k + m;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(169091);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
      fhp localfhp = (fhp)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(169091);
        return -1;
      case 1: 
        localfhp.hKN = ((i.a.a.a.a)localObject1).ajGk.aaw();
        AppMethodBeat.o(169091);
        return 0;
      case 2: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new ni();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((ni)localObject2).parseFrom((byte[])localObject1);
          }
          localfhp.abIh = ((ni)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(169091);
        return 0;
      case 3: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new fvu();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((fvu)localObject2).parseFrom((byte[])localObject1);
          }
          localfhp.abIi = ((fvu)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(169091);
        return 0;
      case 4: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new dzj();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((dzj)localObject2).parseFrom((byte[])localObject1);
          }
          localfhp.abIj = ((dzj)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(169091);
        return 0;
      case 5: 
        localfhp.objectNonceId = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(169091);
        return 0;
      case 6: 
        localfhp.finderUsername = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(169091);
        return 0;
      case 7: 
        localfhp.abIk = ((i.a.a.a.a)localObject1).ajGk.aaw();
        AppMethodBeat.o(169091);
        return 0;
      case 8: 
        localfhp.abIl = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(169091);
        return 0;
      case 9: 
        localfhp.sessionBuffer = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(169091);
        return 0;
      case 10: 
        localfhp.abIm = ((i.a.a.a.a)localObject1).ajGk.aaw();
        AppMethodBeat.o(169091);
        return 0;
      case 11: 
        localfhp.AJo = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(169091);
        return 0;
      case 12: 
        localfhp.abIn = ((i.a.a.a.a)localObject1).ajGk.aaw();
        AppMethodBeat.o(169091);
        return 0;
      case 13: 
        localfhp.abIo = ((i.a.a.a.a)localObject1).ajGk.kFX();
        AppMethodBeat.o(169091);
        return 0;
      case 14: 
        localfhp.mediaType = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(169091);
        return 0;
      case 15: 
        localfhp.abIp = ((i.a.a.a.a)localObject1).ajGk.aaw();
        AppMethodBeat.o(169091);
        return 0;
      case 16: 
        localfhp.abIq = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(169091);
        return 0;
      case 17: 
        localfhp.abIr = ((i.a.a.a.a)localObject1).ajGk.aaw();
        AppMethodBeat.o(169091);
        return 0;
      case 18: 
        localfhp.uin = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(169091);
        return 0;
      case 19: 
        localfhp.abIs = ((i.a.a.a.a)localObject1).ajGk.aaw();
        AppMethodBeat.o(169091);
        return 0;
      }
      localfhp.mMJ = ((i.a.a.a.a)localObject1).ajGk.aaw();
      AppMethodBeat.o(169091);
      return 0;
    }
    AppMethodBeat.o(169091);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fhp
 * JD-Core Version:    0.7.0.1
 */