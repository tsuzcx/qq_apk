package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ghk
  extends erp
{
  public String acat;
  public String acdt;
  public int acdu;
  public int acdv;
  public String acdw;
  public int acdx;
  public String acdy;
  public String acdz;
  public String appid;
  public String hNw;
  public String vTt;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(82489);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.hNw != null) {
        paramVarArgs.g(2, this.hNw);
      }
      if (this.acdt != null) {
        paramVarArgs.g(3, this.acdt);
      }
      paramVarArgs.bS(4, this.acdu);
      paramVarArgs.bS(5, this.acdv);
      if (this.acat != null) {
        paramVarArgs.g(6, this.acat);
      }
      if (this.vTt != null) {
        paramVarArgs.g(7, this.vTt);
      }
      if (this.appid != null) {
        paramVarArgs.g(8, this.appid);
      }
      if (this.acdw != null) {
        paramVarArgs.g(9, this.acdw);
      }
      paramVarArgs.bS(10, this.acdx);
      if (this.acdy != null) {
        paramVarArgs.g(11, this.acdy);
      }
      if (this.acdz != null) {
        paramVarArgs.g(12, this.acdz);
      }
      AppMethodBeat.o(82489);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label908;
      }
    }
    label908:
    for (int i = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.hNw != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.hNw);
      }
      i = paramInt;
      if (this.acdt != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.acdt);
      }
      i = i + i.a.a.b.b.a.cJ(4, this.acdu) + i.a.a.b.b.a.cJ(5, this.acdv);
      paramInt = i;
      if (this.acat != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.acat);
      }
      i = paramInt;
      if (this.vTt != null) {
        i = paramInt + i.a.a.b.b.a.h(7, this.vTt);
      }
      paramInt = i;
      if (this.appid != null) {
        paramInt = i + i.a.a.b.b.a.h(8, this.appid);
      }
      i = paramInt;
      if (this.acdw != null) {
        i = paramInt + i.a.a.b.b.a.h(9, this.acdw);
      }
      i += i.a.a.b.b.a.cJ(10, this.acdx);
      paramInt = i;
      if (this.acdy != null) {
        paramInt = i + i.a.a.b.b.a.h(11, this.acdy);
      }
      i = paramInt;
      if (this.acdz != null) {
        i = paramInt + i.a.a.b.b.a.h(12, this.acdz);
      }
      AppMethodBeat.o(82489);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(82489);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        ghk localghk = (ghk)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(82489);
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
            localghk.BaseRequest = localkc;
            paramInt += 1;
          }
          AppMethodBeat.o(82489);
          return 0;
        case 2: 
          localghk.hNw = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(82489);
          return 0;
        case 3: 
          localghk.acdt = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(82489);
          return 0;
        case 4: 
          localghk.acdu = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(82489);
          return 0;
        case 5: 
          localghk.acdv = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(82489);
          return 0;
        case 6: 
          localghk.acat = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(82489);
          return 0;
        case 7: 
          localghk.vTt = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(82489);
          return 0;
        case 8: 
          localghk.appid = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(82489);
          return 0;
        case 9: 
          localghk.acdw = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(82489);
          return 0;
        case 10: 
          localghk.acdx = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(82489);
          return 0;
        case 11: 
          localghk.acdy = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(82489);
          return 0;
        }
        localghk.acdz = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(82489);
        return 0;
      }
      AppMethodBeat.o(82489);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ghk
 * JD-Core Version:    0.7.0.1
 */