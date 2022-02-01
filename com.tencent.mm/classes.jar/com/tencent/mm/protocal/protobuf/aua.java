package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class aua
  extends erp
{
  public atz ZEc;
  public LinkedList<brr> ZEv;
  public int ZEw;
  public int ZEx;
  public String ZEy;
  public String finderUsername;
  public String mdG;
  public int scene;
  
  public aua()
  {
    AppMethodBeat.i(257991);
    this.ZEv = new LinkedList();
    AppMethodBeat.o(257991);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(257997);
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
      paramVarArgs.e(3, 8, this.ZEv);
      paramVarArgs.bS(4, this.scene);
      paramVarArgs.bS(5, this.ZEw);
      paramVarArgs.bS(6, this.ZEx);
      if (this.finderUsername != null) {
        paramVarArgs.g(7, this.finderUsername);
      }
      if (this.ZEy != null) {
        paramVarArgs.g(8, this.ZEy);
      }
      if (this.mdG != null) {
        paramVarArgs.g(9, this.mdG);
      }
      AppMethodBeat.o(257997);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label852;
      }
    }
    label852:
    for (paramInt = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.ZEc != null) {
        i = paramInt + i.a.a.a.qC(2, this.ZEc.computeSize());
      }
      i = i + i.a.a.a.c(3, 8, this.ZEv) + i.a.a.b.b.a.cJ(4, this.scene) + i.a.a.b.b.a.cJ(5, this.ZEw) + i.a.a.b.b.a.cJ(6, this.ZEx);
      paramInt = i;
      if (this.finderUsername != null) {
        paramInt = i + i.a.a.b.b.a.h(7, this.finderUsername);
      }
      i = paramInt;
      if (this.ZEy != null) {
        i = paramInt + i.a.a.b.b.a.h(8, this.ZEy);
      }
      paramInt = i;
      if (this.mdG != null) {
        paramInt = i + i.a.a.b.b.a.h(9, this.mdG);
      }
      AppMethodBeat.o(257997);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.ZEv.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(257997);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        aua localaua = (aua)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(257997);
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
            localaua.BaseRequest = ((kc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(257997);
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
            localaua.ZEc = ((atz)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(257997);
          return 0;
        case 3: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new brr();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((brr)localObject2).parseFrom((byte[])localObject1);
            }
            localaua.ZEv.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(257997);
          return 0;
        case 4: 
          localaua.scene = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(257997);
          return 0;
        case 5: 
          localaua.ZEw = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(257997);
          return 0;
        case 6: 
          localaua.ZEx = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(257997);
          return 0;
        case 7: 
          localaua.finderUsername = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(257997);
          return 0;
        case 8: 
          localaua.ZEy = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(257997);
          return 0;
        }
        localaua.mdG = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(257997);
        return 0;
      }
      AppMethodBeat.o(257997);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aua
 * JD-Core Version:    0.7.0.1
 */