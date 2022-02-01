package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class euw
  extends erp
{
  public String abxH;
  public String abxI;
  public String abxv;
  public String abxw;
  public b abxx;
  public String appid;
  public String scope;
  public String state;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(82473);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.appid != null) {
        paramVarArgs.g(2, this.appid);
      }
      if (this.scope != null) {
        paramVarArgs.g(3, this.scope);
      }
      if (this.state != null) {
        paramVarArgs.g(4, this.state);
      }
      if (this.abxv != null) {
        paramVarArgs.g(5, this.abxv);
      }
      if (this.abxH != null) {
        paramVarArgs.g(6, this.abxH);
      }
      if (this.abxI != null) {
        paramVarArgs.g(7, this.abxI);
      }
      if (this.abxw != null) {
        paramVarArgs.g(13, this.abxw);
      }
      if (this.abxx != null) {
        paramVarArgs.d(14, this.abxx);
      }
      AppMethodBeat.o(82473);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label792;
      }
    }
    label792:
    for (int i = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.appid != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.appid);
      }
      i = paramInt;
      if (this.scope != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.scope);
      }
      paramInt = i;
      if (this.state != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.state);
      }
      i = paramInt;
      if (this.abxv != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.abxv);
      }
      paramInt = i;
      if (this.abxH != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.abxH);
      }
      i = paramInt;
      if (this.abxI != null) {
        i = paramInt + i.a.a.b.b.a.h(7, this.abxI);
      }
      paramInt = i;
      if (this.abxw != null) {
        paramInt = i + i.a.a.b.b.a.h(13, this.abxw);
      }
      i = paramInt;
      if (this.abxx != null) {
        i = paramInt + i.a.a.b.b.a.c(14, this.abxx);
      }
      AppMethodBeat.o(82473);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(82473);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        euw localeuw = (euw)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        case 8: 
        case 9: 
        case 10: 
        case 11: 
        case 12: 
        default: 
          AppMethodBeat.o(82473);
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
            localeuw.BaseRequest = localkc;
            paramInt += 1;
          }
          AppMethodBeat.o(82473);
          return 0;
        case 2: 
          localeuw.appid = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(82473);
          return 0;
        case 3: 
          localeuw.scope = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(82473);
          return 0;
        case 4: 
          localeuw.state = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(82473);
          return 0;
        case 5: 
          localeuw.abxv = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(82473);
          return 0;
        case 6: 
          localeuw.abxH = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(82473);
          return 0;
        case 7: 
          localeuw.abxI = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(82473);
          return 0;
        case 13: 
          localeuw.abxw = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(82473);
          return 0;
        }
        localeuw.abxx = ((i.a.a.a.a)localObject).ajGk.kFX();
        AppMethodBeat.o(82473);
        return 0;
      }
      AppMethodBeat.o(82473);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.euw
 * JD-Core Version:    0.7.0.1
 */