package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class euu
  extends erp
{
  public int ZqK;
  public int abaP;
  public LinkedList<String> abaQ;
  public int abxA;
  public b abxB;
  public boolean abxC;
  public String abxv;
  public String abxw;
  public b abxx;
  public b abxy;
  public String abxz;
  public String appid;
  public String state;
  
  public euu()
  {
    AppMethodBeat.i(82470);
    this.abaQ = new LinkedList();
    AppMethodBeat.o(82470);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(82471);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(3, this.abaP);
      paramVarArgs.e(4, 1, this.abaQ);
      if (this.appid != null) {
        paramVarArgs.g(5, this.appid);
      }
      if (this.state != null) {
        paramVarArgs.g(6, this.state);
      }
      if (this.abxv != null) {
        paramVarArgs.g(7, this.abxv);
      }
      paramVarArgs.bS(8, this.ZqK);
      if (this.abxw != null) {
        paramVarArgs.g(14, this.abxw);
      }
      if (this.abxx != null) {
        paramVarArgs.d(15, this.abxx);
      }
      if (this.abxy != null) {
        paramVarArgs.d(16, this.abxy);
      }
      if (this.abxz != null) {
        paramVarArgs.g(17, this.abxz);
      }
      paramVarArgs.bS(18, this.abxA);
      if (this.abxB != null) {
        paramVarArgs.d(19, this.abxB);
      }
      paramVarArgs.di(20, this.abxC);
      AppMethodBeat.o(82471);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1040;
      }
    }
    label1040:
    for (paramInt = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(3, this.abaP) + i.a.a.a.c(4, 1, this.abaQ);
      paramInt = i;
      if (this.appid != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.appid);
      }
      i = paramInt;
      if (this.state != null) {
        i = paramInt + i.a.a.b.b.a.h(6, this.state);
      }
      paramInt = i;
      if (this.abxv != null) {
        paramInt = i + i.a.a.b.b.a.h(7, this.abxv);
      }
      i = paramInt + i.a.a.b.b.a.cJ(8, this.ZqK);
      paramInt = i;
      if (this.abxw != null) {
        paramInt = i + i.a.a.b.b.a.h(14, this.abxw);
      }
      i = paramInt;
      if (this.abxx != null) {
        i = paramInt + i.a.a.b.b.a.c(15, this.abxx);
      }
      paramInt = i;
      if (this.abxy != null) {
        paramInt = i + i.a.a.b.b.a.c(16, this.abxy);
      }
      i = paramInt;
      if (this.abxz != null) {
        i = paramInt + i.a.a.b.b.a.h(17, this.abxz);
      }
      i += i.a.a.b.b.a.cJ(18, this.abxA);
      paramInt = i;
      if (this.abxB != null) {
        paramInt = i + i.a.a.b.b.a.c(19, this.abxB);
      }
      i = i.a.a.b.b.a.ko(20);
      AppMethodBeat.o(82471);
      return paramInt + (i + 1);
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.abaQ.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(82471);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        euu localeuu = (euu)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        case 2: 
        case 9: 
        case 10: 
        case 11: 
        case 12: 
        case 13: 
        default: 
          AppMethodBeat.o(82471);
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
            localeuu.BaseRequest = localkc;
            paramInt += 1;
          }
          AppMethodBeat.o(82471);
          return 0;
        case 3: 
          localeuu.abaP = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(82471);
          return 0;
        case 4: 
          localeuu.abaQ.add(((i.a.a.a.a)localObject).ajGk.readString());
          AppMethodBeat.o(82471);
          return 0;
        case 5: 
          localeuu.appid = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(82471);
          return 0;
        case 6: 
          localeuu.state = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(82471);
          return 0;
        case 7: 
          localeuu.abxv = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(82471);
          return 0;
        case 8: 
          localeuu.ZqK = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(82471);
          return 0;
        case 14: 
          localeuu.abxw = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(82471);
          return 0;
        case 15: 
          localeuu.abxx = ((i.a.a.a.a)localObject).ajGk.kFX();
          AppMethodBeat.o(82471);
          return 0;
        case 16: 
          localeuu.abxy = ((i.a.a.a.a)localObject).ajGk.kFX();
          AppMethodBeat.o(82471);
          return 0;
        case 17: 
          localeuu.abxz = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(82471);
          return 0;
        case 18: 
          localeuu.abxA = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(82471);
          return 0;
        case 19: 
          localeuu.abxB = ((i.a.a.a.a)localObject).ajGk.kFX();
          AppMethodBeat.o(82471);
          return 0;
        }
        localeuu.abxC = ((i.a.a.a.a)localObject).ajGk.aai();
        AppMethodBeat.o(82471);
        return 0;
      }
      AppMethodBeat.o(82471);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.euu
 * JD-Core Version:    0.7.0.1
 */