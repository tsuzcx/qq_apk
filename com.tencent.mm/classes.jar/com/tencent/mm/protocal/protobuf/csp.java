package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class csp
  extends erp
{
  public int aaun;
  public String aayH;
  public String aayI;
  public int aayJ;
  public int aayK;
  public String aid;
  public String mdG;
  public int wuj;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258379);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(2, this.wuj);
      if (this.aayH != null) {
        paramVarArgs.g(3, this.aayH);
      }
      if (this.aid != null) {
        paramVarArgs.g(4, this.aid);
      }
      if (this.aayI != null) {
        paramVarArgs.g(5, this.aayI);
      }
      if (this.mdG != null) {
        paramVarArgs.g(6, this.mdG);
      }
      paramVarArgs.bS(7, this.aayJ);
      paramVarArgs.bS(8, this.aaun);
      paramVarArgs.bS(9, this.aayK);
      AppMethodBeat.o(258379);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label712;
      }
    }
    label712:
    for (paramInt = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.wuj);
      paramInt = i;
      if (this.aayH != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.aayH);
      }
      i = paramInt;
      if (this.aid != null) {
        i = paramInt + i.a.a.b.b.a.h(4, this.aid);
      }
      paramInt = i;
      if (this.aayI != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.aayI);
      }
      i = paramInt;
      if (this.mdG != null) {
        i = paramInt + i.a.a.b.b.a.h(6, this.mdG);
      }
      paramInt = i.a.a.b.b.a.cJ(7, this.aayJ);
      int j = i.a.a.b.b.a.cJ(8, this.aaun);
      int k = i.a.a.b.b.a.cJ(9, this.aayK);
      AppMethodBeat.o(258379);
      return i + paramInt + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(258379);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        csp localcsp = (csp)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(258379);
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
            localcsp.BaseRequest = localkc;
            paramInt += 1;
          }
          AppMethodBeat.o(258379);
          return 0;
        case 2: 
          localcsp.wuj = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(258379);
          return 0;
        case 3: 
          localcsp.aayH = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(258379);
          return 0;
        case 4: 
          localcsp.aid = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(258379);
          return 0;
        case 5: 
          localcsp.aayI = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(258379);
          return 0;
        case 6: 
          localcsp.mdG = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(258379);
          return 0;
        case 7: 
          localcsp.aayJ = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(258379);
          return 0;
        case 8: 
          localcsp.aaun = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(258379);
          return 0;
        }
        localcsp.aayK = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(258379);
        return 0;
      }
      AppMethodBeat.o(258379);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.csp
 * JD-Core Version:    0.7.0.1
 */