package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class axe
  extends erp
{
  public long Acx;
  public atz ZEc;
  public int ZFJ;
  public String finderUsername;
  public long hKN;
  public int hYl;
  public String objectNonceId;
  public String sessionBuffer;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259924);
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
      paramVarArgs.bv(3, this.hKN);
      paramVarArgs.bS(4, this.hYl);
      if (this.objectNonceId != null) {
        paramVarArgs.g(5, this.objectNonceId);
      }
      paramVarArgs.bv(6, this.Acx);
      if (this.finderUsername != null) {
        paramVarArgs.g(7, this.finderUsername);
      }
      if (this.sessionBuffer != null) {
        paramVarArgs.g(8, this.sessionBuffer);
      }
      paramVarArgs.bS(9, this.ZFJ);
      AppMethodBeat.o(259924);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label778;
      }
    }
    label778:
    for (paramInt = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.ZEc != null) {
        i = paramInt + i.a.a.a.qC(2, this.ZEc.computeSize());
      }
      i = i + i.a.a.b.b.a.q(3, this.hKN) + i.a.a.b.b.a.cJ(4, this.hYl);
      paramInt = i;
      if (this.objectNonceId != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.objectNonceId);
      }
      i = paramInt + i.a.a.b.b.a.q(6, this.Acx);
      paramInt = i;
      if (this.finderUsername != null) {
        paramInt = i + i.a.a.b.b.a.h(7, this.finderUsername);
      }
      i = paramInt;
      if (this.sessionBuffer != null) {
        i = paramInt + i.a.a.b.b.a.h(8, this.sessionBuffer);
      }
      paramInt = i.a.a.b.b.a.cJ(9, this.ZFJ);
      AppMethodBeat.o(259924);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(259924);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        axe localaxe = (axe)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(259924);
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
            localaxe.BaseRequest = ((kc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(259924);
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
            localaxe.ZEc = ((atz)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(259924);
          return 0;
        case 3: 
          localaxe.hKN = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(259924);
          return 0;
        case 4: 
          localaxe.hYl = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(259924);
          return 0;
        case 5: 
          localaxe.objectNonceId = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(259924);
          return 0;
        case 6: 
          localaxe.Acx = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(259924);
          return 0;
        case 7: 
          localaxe.finderUsername = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(259924);
          return 0;
        case 8: 
          localaxe.sessionBuffer = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(259924);
          return 0;
        }
        localaxe.ZFJ = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(259924);
        return 0;
      }
      AppMethodBeat.o(259924);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.axe
 * JD-Core Version:    0.7.0.1
 */