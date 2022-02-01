package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cup
  extends erp
{
  public int YDV;
  public boolean aaAd;
  public LinkedList<String> aaAe;
  public String appid;
  public int source;
  
  public cup()
  {
    AppMethodBeat.i(147765);
    this.aaAe = new LinkedList();
    AppMethodBeat.o(147765);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(147766);
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
      paramVarArgs.di(3, this.aaAd);
      paramVarArgs.e(4, 1, this.aaAe);
      paramVarArgs.bS(5, this.source);
      paramVarArgs.bS(6, this.YDV);
      AppMethodBeat.o(147766);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label544;
      }
    }
    label544:
    for (paramInt = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.appid != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.appid);
      }
      paramInt = i.a.a.b.b.a.ko(3);
      int j = i.a.a.a.c(4, 1, this.aaAe);
      int k = i.a.a.b.b.a.cJ(5, this.source);
      int m = i.a.a.b.b.a.cJ(6, this.YDV);
      AppMethodBeat.o(147766);
      return i + (paramInt + 1) + j + k + m;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.aaAe.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(147766);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        cup localcup = (cup)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(147766);
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
            localcup.BaseRequest = localkc;
            paramInt += 1;
          }
          AppMethodBeat.o(147766);
          return 0;
        case 2: 
          localcup.appid = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(147766);
          return 0;
        case 3: 
          localcup.aaAd = ((i.a.a.a.a)localObject).ajGk.aai();
          AppMethodBeat.o(147766);
          return 0;
        case 4: 
          localcup.aaAe.add(((i.a.a.a.a)localObject).ajGk.readString());
          AppMethodBeat.o(147766);
          return 0;
        case 5: 
          localcup.source = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(147766);
          return 0;
        }
        localcup.YDV = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(147766);
        return 0;
      }
      AppMethodBeat.o(147766);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cup
 * JD-Core Version:    0.7.0.1
 */