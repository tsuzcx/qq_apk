package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bzy
  extends erp
{
  public String CAf;
  public String KuX;
  public String aaiY;
  public int aaiZ;
  public String city;
  public String ihx;
  public int msgType;
  public String province;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(257399);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.ihx != null) {
        paramVarArgs.g(2, this.ihx);
      }
      if (this.CAf != null) {
        paramVarArgs.g(3, this.CAf);
      }
      if (this.aaiY != null) {
        paramVarArgs.g(4, this.aaiY);
      }
      if (this.province != null) {
        paramVarArgs.g(5, this.province);
      }
      if (this.city != null) {
        paramVarArgs.g(6, this.city);
      }
      if (this.KuX != null) {
        paramVarArgs.g(7, this.KuX);
      }
      paramVarArgs.bS(8, this.msgType);
      paramVarArgs.bS(9, this.aaiZ);
      AppMethodBeat.o(257399);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label744;
      }
    }
    label744:
    for (int i = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.ihx != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.ihx);
      }
      i = paramInt;
      if (this.CAf != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.CAf);
      }
      paramInt = i;
      if (this.aaiY != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.aaiY);
      }
      i = paramInt;
      if (this.province != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.province);
      }
      paramInt = i;
      if (this.city != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.city);
      }
      i = paramInt;
      if (this.KuX != null) {
        i = paramInt + i.a.a.b.b.a.h(7, this.KuX);
      }
      paramInt = i.a.a.b.b.a.cJ(8, this.msgType);
      int j = i.a.a.b.b.a.cJ(9, this.aaiZ);
      AppMethodBeat.o(257399);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(257399);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        bzy localbzy = (bzy)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(257399);
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
            localbzy.BaseRequest = localkc;
            paramInt += 1;
          }
          AppMethodBeat.o(257399);
          return 0;
        case 2: 
          localbzy.ihx = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(257399);
          return 0;
        case 3: 
          localbzy.CAf = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(257399);
          return 0;
        case 4: 
          localbzy.aaiY = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(257399);
          return 0;
        case 5: 
          localbzy.province = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(257399);
          return 0;
        case 6: 
          localbzy.city = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(257399);
          return 0;
        case 7: 
          localbzy.KuX = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(257399);
          return 0;
        case 8: 
          localbzy.msgType = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(257399);
          return 0;
        }
        localbzy.aaiZ = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(257399);
        return 0;
      }
      AppMethodBeat.o(257399);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bzy
 * JD-Core Version:    0.7.0.1
 */