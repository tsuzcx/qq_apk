package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cab
  extends erp
{
  public String CAf;
  public int aaiZ;
  public String city;
  public String ihx;
  public int msgType;
  public String province;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258635);
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
      if (this.province != null) {
        paramVarArgs.g(4, this.province);
      }
      if (this.city != null) {
        paramVarArgs.g(5, this.city);
      }
      paramVarArgs.bS(6, this.msgType);
      paramVarArgs.bS(7, this.aaiZ);
      AppMethodBeat.o(258635);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label620;
      }
    }
    label620:
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
      if (this.province != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.province);
      }
      i = paramInt;
      if (this.city != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.city);
      }
      paramInt = i.a.a.b.b.a.cJ(6, this.msgType);
      int j = i.a.a.b.b.a.cJ(7, this.aaiZ);
      AppMethodBeat.o(258635);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(258635);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        cab localcab = (cab)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(258635);
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
            localcab.BaseRequest = localkc;
            paramInt += 1;
          }
          AppMethodBeat.o(258635);
          return 0;
        case 2: 
          localcab.ihx = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(258635);
          return 0;
        case 3: 
          localcab.CAf = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(258635);
          return 0;
        case 4: 
          localcab.province = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(258635);
          return 0;
        case 5: 
          localcab.city = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(258635);
          return 0;
        case 6: 
          localcab.msgType = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(258635);
          return 0;
        }
        localcab.aaiZ = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(258635);
        return 0;
      }
      AppMethodBeat.o(258635);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cab
 * JD-Core Version:    0.7.0.1
 */