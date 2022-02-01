package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class aip
  extends ckq
{
  public String DkK;
  public aht Dkw;
  public String finderUsername;
  public int opType;
  public long refObjectId;
  public String refObjectNonceId;
  public String sessionBuffer;
  public int tjk;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(168964);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.kX(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.DkK != null) {
        paramVarArgs.d(2, this.DkK);
      }
      paramVarArgs.aR(3, this.opType);
      paramVarArgs.aG(4, this.refObjectId);
      if (this.finderUsername != null) {
        paramVarArgs.d(5, this.finderUsername);
      }
      if (this.refObjectNonceId != null) {
        paramVarArgs.d(6, this.refObjectNonceId);
      }
      if (this.Dkw != null)
      {
        paramVarArgs.kX(7, this.Dkw.computeSize());
        this.Dkw.writeFields(paramVarArgs);
      }
      if (this.sessionBuffer != null) {
        paramVarArgs.d(8, this.sessionBuffer);
      }
      paramVarArgs.aR(9, this.tjk);
      AppMethodBeat.o(168964);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label842;
      }
    }
    label842:
    for (paramInt = f.a.a.a.kW(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.DkK != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.DkK);
      }
      i = i + f.a.a.b.b.a.bA(3, this.opType) + f.a.a.b.b.a.q(4, this.refObjectId);
      paramInt = i;
      if (this.finderUsername != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.finderUsername);
      }
      i = paramInt;
      if (this.refObjectNonceId != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.refObjectNonceId);
      }
      paramInt = i;
      if (this.Dkw != null) {
        paramInt = i + f.a.a.a.kW(7, this.Dkw.computeSize());
      }
      i = paramInt;
      if (this.sessionBuffer != null) {
        i = paramInt + f.a.a.b.b.a.e(8, this.sessionBuffer);
      }
      paramInt = f.a.a.b.b.a.bA(9, this.tjk);
      AppMethodBeat.o(168964);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = ckq.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = ckq.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(168964);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        aip localaip = (aip)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(168964);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ip();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ip)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localaip.BaseRequest = ((ip)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(168964);
          return 0;
        case 2: 
          localaip.DkK = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(168964);
          return 0;
        case 3: 
          localaip.opType = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(168964);
          return 0;
        case 4: 
          localaip.refObjectId = ((f.a.a.a.a)localObject1).KhF.xT();
          AppMethodBeat.o(168964);
          return 0;
        case 5: 
          localaip.finderUsername = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(168964);
          return 0;
        case 6: 
          localaip.refObjectNonceId = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(168964);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new aht();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((aht)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localaip.Dkw = ((aht)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(168964);
          return 0;
        case 8: 
          localaip.sessionBuffer = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(168964);
          return 0;
        }
        localaip.tjk = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(168964);
        return 0;
      }
      AppMethodBeat.o(168964);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aip
 * JD-Core Version:    0.7.0.1
 */