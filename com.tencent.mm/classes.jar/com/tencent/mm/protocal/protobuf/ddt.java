package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class ddt
  extends erp
{
  public String aaIK;
  public String aaIL;
  public String aaIM;
  public b aaIN;
  public String aaIP;
  public int aaIQ;
  public String appid;
  public String hhx;
  public String signature;
  public String url;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(82442);
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
      if (this.aaIP != null) {
        paramVarArgs.g(10, this.aaIP);
      }
      paramVarArgs.bS(12, this.aaIQ);
      AppMethodBeat.o(82442);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label884;
      }
    }
    label884:
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
      paramInt = i;
      if (this.aaIP != null) {
        paramInt = i + i.a.a.b.b.a.h(10, this.aaIP);
      }
      i = i.a.a.b.b.a.cJ(12, this.aaIQ);
      AppMethodBeat.o(82442);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(82442);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        ddt localddt = (ddt)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        case 11: 
        default: 
          AppMethodBeat.o(82442);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            kc localkc = new kc();
            if ((localObject != null) && (localObject.length > 0)) {
              localkc.parseFrom((byte[])localObject);
            }
            localddt.BaseRequest = localkc;
            paramInt += 1;
          }
          AppMethodBeat.o(82442);
          return 0;
        case 2: 
          localddt.url = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(82442);
          return 0;
        case 3: 
          localddt.appid = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(82442);
          return 0;
        case 4: 
          localddt.aaIK = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(82442);
          return 0;
        case 5: 
          localddt.hhx = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(82442);
          return 0;
        case 6: 
          localddt.aaIL = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(82442);
          return 0;
        case 7: 
          localddt.signature = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(82442);
          return 0;
        case 8: 
          localddt.aaIM = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(82442);
          return 0;
        case 9: 
          localddt.aaIN = ((i.a.a.a.a)localObject).ajGk.kFX();
          AppMethodBeat.o(82442);
          return 0;
        case 10: 
          localddt.aaIP = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(82442);
          return 0;
        }
        localddt.aaIQ = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(82442);
        return 0;
      }
      AppMethodBeat.o(82442);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ddt
 * JD-Core Version:    0.7.0.1
 */