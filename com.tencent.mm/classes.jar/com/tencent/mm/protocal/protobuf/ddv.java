package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class ddv
  extends erp
{
  public String aaIK;
  public String aaIL;
  public String aaIM;
  public b aaIN;
  public int aaIO;
  public String aaIP;
  public int aaIQ;
  public LinkedList<dek> aaIU;
  public String appid;
  public String hhx;
  public String signature;
  public String url;
  
  public ddv()
  {
    AppMethodBeat.i(82444);
    this.aaIU = new LinkedList();
    AppMethodBeat.o(82444);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(82445);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.url != null) {
        paramVarArgs.g(2, this.url);
      }
      if (this.appid != null) {
        paramVarArgs.g(3, this.appid);
      }
      if (this.aaIK != null) {
        paramVarArgs.g(4, this.aaIK);
      }
      if (this.hhx != null) {
        paramVarArgs.g(5, this.hhx);
      }
      if (this.aaIL != null) {
        paramVarArgs.g(6, this.aaIL);
      }
      if (this.signature != null) {
        paramVarArgs.g(7, this.signature);
      }
      if (this.aaIM != null) {
        paramVarArgs.g(8, this.aaIM);
      }
      if (this.aaIN != null) {
        paramVarArgs.d(9, this.aaIN);
      }
      paramVarArgs.bS(10, this.aaIO);
      paramVarArgs.e(11, 8, this.aaIU);
      if (this.aaIP != null) {
        paramVarArgs.g(12, this.aaIP);
      }
      paramVarArgs.bS(13, this.aaIQ);
      AppMethodBeat.o(82445);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1046;
      }
    }
    label1046:
    for (int i = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.url != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.url);
      }
      i = paramInt;
      if (this.appid != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.appid);
      }
      paramInt = i;
      if (this.aaIK != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.aaIK);
      }
      i = paramInt;
      if (this.hhx != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.hhx);
      }
      paramInt = i;
      if (this.aaIL != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.aaIL);
      }
      i = paramInt;
      if (this.signature != null) {
        i = paramInt + i.a.a.b.b.a.h(7, this.signature);
      }
      paramInt = i;
      if (this.aaIM != null) {
        paramInt = i + i.a.a.b.b.a.h(8, this.aaIM);
      }
      i = paramInt;
      if (this.aaIN != null) {
        i = paramInt + i.a.a.b.b.a.c(9, this.aaIN);
      }
      i = i + i.a.a.b.b.a.cJ(10, this.aaIO) + i.a.a.a.c(11, 8, this.aaIU);
      paramInt = i;
      if (this.aaIP != null) {
        paramInt = i + i.a.a.b.b.a.h(12, this.aaIP);
      }
      i = i.a.a.b.b.a.cJ(13, this.aaIQ);
      AppMethodBeat.o(82445);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.aaIU.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(82445);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        ddv localddv = (ddv)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(82445);
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
            localddv.BaseRequest = ((kc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(82445);
          return 0;
        case 2: 
          localddv.url = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(82445);
          return 0;
        case 3: 
          localddv.appid = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(82445);
          return 0;
        case 4: 
          localddv.aaIK = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(82445);
          return 0;
        case 5: 
          localddv.hhx = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(82445);
          return 0;
        case 6: 
          localddv.aaIL = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(82445);
          return 0;
        case 7: 
          localddv.signature = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(82445);
          return 0;
        case 8: 
          localddv.aaIM = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(82445);
          return 0;
        case 9: 
          localddv.aaIN = ((i.a.a.a.a)localObject1).ajGk.kFX();
          AppMethodBeat.o(82445);
          return 0;
        case 10: 
          localddv.aaIO = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(82445);
          return 0;
        case 11: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dek();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dek)localObject2).parseFrom((byte[])localObject1);
            }
            localddv.aaIU.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(82445);
          return 0;
        case 12: 
          localddv.aaIP = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(82445);
          return 0;
        }
        localddv.aaIQ = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(82445);
        return 0;
      }
      AppMethodBeat.o(82445);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ddv
 * JD-Core Version:    0.7.0.1
 */