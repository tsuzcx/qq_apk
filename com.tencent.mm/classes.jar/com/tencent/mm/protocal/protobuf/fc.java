package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class fc
  extends erp
{
  public String YGP;
  public int YGQ;
  public String YzM;
  public String appid;
  public String hMM;
  public String signature;
  public String wDg;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258463);
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
      if (this.YzM != null) {
        paramVarArgs.g(3, this.YzM);
      }
      if (this.wDg != null) {
        paramVarArgs.g(4, this.wDg);
      }
      if (this.signature != null) {
        paramVarArgs.g(5, this.signature);
      }
      if (this.hMM != null) {
        paramVarArgs.g(6, this.hMM);
      }
      if (this.YGP != null) {
        paramVarArgs.g(7, this.YGP);
      }
      paramVarArgs.bS(8, this.YGQ);
      AppMethodBeat.o(258463);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label696;
      }
    }
    label696:
    for (int i = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.appid != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.appid);
      }
      i = paramInt;
      if (this.YzM != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.YzM);
      }
      paramInt = i;
      if (this.wDg != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.wDg);
      }
      i = paramInt;
      if (this.signature != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.signature);
      }
      paramInt = i;
      if (this.hMM != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.hMM);
      }
      i = paramInt;
      if (this.YGP != null) {
        i = paramInt + i.a.a.b.b.a.h(7, this.YGP);
      }
      paramInt = i.a.a.b.b.a.cJ(8, this.YGQ);
      AppMethodBeat.o(258463);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(258463);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        fc localfc = (fc)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(258463);
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
            localfc.BaseRequest = localkc;
            paramInt += 1;
          }
          AppMethodBeat.o(258463);
          return 0;
        case 2: 
          localfc.appid = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(258463);
          return 0;
        case 3: 
          localfc.YzM = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(258463);
          return 0;
        case 4: 
          localfc.wDg = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(258463);
          return 0;
        case 5: 
          localfc.signature = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(258463);
          return 0;
        case 6: 
          localfc.hMM = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(258463);
          return 0;
        case 7: 
          localfc.YGP = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(258463);
          return 0;
        }
        localfc.YGQ = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(258463);
        return 0;
      }
      AppMethodBeat.o(258463);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fc
 * JD-Core Version:    0.7.0.1
 */