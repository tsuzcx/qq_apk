package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class hx
  extends erp
{
  public int YDV;
  public LinkedList<String> YJD;
  public boolean YJE;
  public int YJF;
  public String appid;
  public int source;
  
  public hx()
  {
    AppMethodBeat.i(147758);
    this.YJD = new LinkedList();
    AppMethodBeat.o(147758);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(147759);
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
      paramVarArgs.e(3, 1, this.YJD);
      paramVarArgs.di(4, this.YJE);
      paramVarArgs.bS(5, this.YJF);
      paramVarArgs.bS(6, this.source);
      paramVarArgs.bS(7, this.YDV);
      AppMethodBeat.o(147759);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label592;
      }
    }
    label592:
    for (paramInt = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.appid != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.appid);
      }
      paramInt = i.a.a.a.c(3, 1, this.YJD);
      int j = i.a.a.b.b.a.ko(4);
      int k = i.a.a.b.b.a.cJ(5, this.YJF);
      int m = i.a.a.b.b.a.cJ(6, this.source);
      int n = i.a.a.b.b.a.cJ(7, this.YDV);
      AppMethodBeat.o(147759);
      return i + paramInt + (j + 1) + k + m + n;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.YJD.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(147759);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        hx localhx = (hx)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(147759);
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
            localhx.BaseRequest = localkc;
            paramInt += 1;
          }
          AppMethodBeat.o(147759);
          return 0;
        case 2: 
          localhx.appid = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(147759);
          return 0;
        case 3: 
          localhx.YJD.add(((i.a.a.a.a)localObject).ajGk.readString());
          AppMethodBeat.o(147759);
          return 0;
        case 4: 
          localhx.YJE = ((i.a.a.a.a)localObject).ajGk.aai();
          AppMethodBeat.o(147759);
          return 0;
        case 5: 
          localhx.YJF = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(147759);
          return 0;
        case 6: 
          localhx.source = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(147759);
          return 0;
        }
        localhx.YDV = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(147759);
        return 0;
      }
      AppMethodBeat.o(147759);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.hx
 * JD-Core Version:    0.7.0.1
 */