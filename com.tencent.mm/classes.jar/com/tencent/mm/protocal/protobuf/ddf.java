package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class ddf
  extends erp
{
  public String aaIK;
  public String aaIL;
  public String aaIM;
  public b aaIN;
  public int aaIO;
  public String aaIP;
  public int aaIQ;
  public String hhx;
  public String muA;
  public String scope;
  public String signature;
  public String url;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(82433);
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
      if (this.muA != null) {
        paramVarArgs.g(3, this.muA);
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
      if (this.scope != null) {
        paramVarArgs.g(11, this.scope);
      }
      if (this.aaIP != null) {
        paramVarArgs.g(12, this.aaIP);
      }
      paramVarArgs.bS(13, this.aaIQ);
      AppMethodBeat.o(82433);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label988;
      }
    }
    label988:
    for (int i = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.url != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.url);
      }
      i = paramInt;
      if (this.muA != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.muA);
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
      i += i.a.a.b.b.a.cJ(10, this.aaIO);
      paramInt = i;
      if (this.scope != null) {
        paramInt = i + i.a.a.b.b.a.h(11, this.scope);
      }
      i = paramInt;
      if (this.aaIP != null) {
        i = paramInt + i.a.a.b.b.a.h(12, this.aaIP);
      }
      paramInt = i.a.a.b.b.a.cJ(13, this.aaIQ);
      AppMethodBeat.o(82433);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(82433);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        ddf localddf = (ddf)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(82433);
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
            localddf.BaseRequest = localkc;
            paramInt += 1;
          }
          AppMethodBeat.o(82433);
          return 0;
        case 2: 
          localddf.url = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(82433);
          return 0;
        case 3: 
          localddf.muA = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(82433);
          return 0;
        case 4: 
          localddf.aaIK = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(82433);
          return 0;
        case 5: 
          localddf.hhx = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(82433);
          return 0;
        case 6: 
          localddf.aaIL = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(82433);
          return 0;
        case 7: 
          localddf.signature = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(82433);
          return 0;
        case 8: 
          localddf.aaIM = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(82433);
          return 0;
        case 9: 
          localddf.aaIN = ((i.a.a.a.a)localObject).ajGk.kFX();
          AppMethodBeat.o(82433);
          return 0;
        case 10: 
          localddf.aaIO = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(82433);
          return 0;
        case 11: 
          localddf.scope = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(82433);
          return 0;
        case 12: 
          localddf.aaIP = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(82433);
          return 0;
        }
        localddf.aaIQ = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(82433);
        return 0;
      }
      AppMethodBeat.o(82433);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ddf
 * JD-Core Version:    0.7.0.1
 */